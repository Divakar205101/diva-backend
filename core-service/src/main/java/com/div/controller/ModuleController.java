package com.div.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.div.domain.FeaturesVO;
import com.div.domain.ModuleVO;
import com.div.mo.ModuleMO;
import com.div.service.FeaturesService;
import com.div.service.ModuleService;

@RestController
@RequestMapping(value = "/core")
public class ModuleController {

	private static final String SAVEMODULE="/savemodule";
	private static final String GET_ALL="/getallModules";
	
	@Autowired private ModuleService moduleService;
	@Autowired private FeaturesService featuresService;
	
	
    @PostMapping(value=SAVEMODULE)
	public ResponseEntity<ModuleVO> savemodule(@RequestBody ModuleMO moduleMO){
    	ModuleVO moduleDO = moduleMO.getModuleDO();
		 moduleService.savemodule(moduleDO);		 
		 saveorupdatefeatures(moduleMO,moduleDO);
		return new ResponseEntity<>(moduleDO, HttpStatus.CREATED);
	}
    
    public void saveorupdatefeatures(ModuleMO moduleMO,ModuleVO moduleDO) {
    	List<FeaturesVO> featuresDOs = moduleDO.getFeaturesDOs();
    	featuresDOs.forEach(x->{
    		x.setMasterDO(moduleDO);
    		featuresService.saveFeatures(x);
    	});
	}
    
    @GetMapping(value=GET_ALL)
    public ResponseEntity<List<ModuleVO>> getAll() {
		return new ResponseEntity<>(moduleService.getAll(),HttpStatus.OK);
	}
}
