package com.div.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.div.domain.MemberBanksVO;
import com.div.domain.MemberVO;
import com.div.domain.ModuleVO;
import com.div.domain.OutboxEventVO;
import com.div.mo.MemberMO;
import com.div.mto.MemberMTO;
import com.div.repo.MemberBanksRepository;
import com.div.repo.MemberCommRepository;
import com.div.repo.OutboxEventRepository;
import com.div.service.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/core")
public class MemberController {

	private static final String SAVEUSER = "/saveUser";
	private static final String ACTION = "action";
	private static final String CREATE = "create";
	private static final String EDIT = "edit";
	private static final String GET_ALL = "/getmembers";
	private static final String EDIT_MEMBER = "/editmember";

	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private MemberService userService;
	@Autowired
	private MemberBanksRepository memberBanksRepository;
	@Autowired
	private MemberCommRepository memberCommRepository;
	private OutboxEventRepository outboxEventRepository;

	@PostMapping(value = SAVEUSER)
	public ResponseEntity<MemberMTO> createUser(@RequestParam(ACTION) String action, @RequestBody MemberMTO memberMTO) {
		try {
			MemberVO memberVO_DB = new MemberVO();
			MemberMO memberMO = mapper.convertValue(memberMTO, MemberMO.class);
			MemberVO memberVO = memberMO.getMemberVO();
			if (action.equals(CREATE)) {
				memberCommRepository.save(memberVO.getMemberCommVO());
				memberMO.getMemberVO().setMemberCommVO(memberMO.getMemberVO().getMemberCommVO());
				MemberVO memberVO_UI = memberMO.getMemberVO();
				userService.createUser(memberVO_UI);
			} else if (action.equals(EDIT)) {
				memberVO_DB = userService.getUserById(memberVO.getId());
			}
			saveorupdatebankVOs(memberVO, memberVO_DB);
			System.out.println("Member saved");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(memberMTO, HttpStatus.CREATED);
	}

	@GetMapping(value = EDIT_MEMBER)
	public ResponseEntity<MemberVO> edit(@RequestParam(ACTION) String action,
			@RequestParam("memberId") Integer memberId) {
		MemberVO userById = userService.getUserById(memberId);
		if (userById != null) {
			return ResponseEntity.ok(userById);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping(value = GET_ALL)
	public ResponseEntity<List<MemberVO>> getAll() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}

	public void saveorupdatebankVOs(MemberVO memberVO_UI, MemberVO MemberVO_DB) {
		List<MemberBanksVO> memberBanksVOs_UI = memberVO_UI.getMemberBanksVOs();
		List<MemberBanksVO> memberBanksVOs_DB = MemberVO_DB.getMemberBanksVOs();

		memberBanksVOs_DB.stream().filter(x -> !memberBanksVOs_UI.contains(x)).forEach(y -> {
			memberBanksRepository.deleteById(y.getId());
		});

		for (MemberBanksVO memberBanksVO : memberBanksVOs_UI) {
			memberBanksVO.setMemberVO(memberVO_UI);
			memberBanksRepository.save(memberBanksVO);
		}
	}

	public void saveoutboxevent(ModuleVO moduleVO) {
		OutboxEventVO outboxEventVO = new OutboxEventVO();
		outboxEventVO.setAggregateType("Order");
		outboxEventVO.setAggregateId(moduleVO.getId());
		outboxEventVO.setEventType("OrderCreated");
		outboxEventVO.setPayload(serializeOrder(moduleVO));
		outboxEventVO.setCreatedAt(new Date());
		outboxEventRepository.save(outboxEventVO);
	}

	private String serializeOrder(Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
