package com.div.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO implements Serializable {
   private Integer id;
   private String pdname;
   private Integer pdCost;
}
