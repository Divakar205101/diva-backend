package com.diva.mto;

import com.diva.domain.UserVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMO {
   private UserVO userVO = new UserVO();
}