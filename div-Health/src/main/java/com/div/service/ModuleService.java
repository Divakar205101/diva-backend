package com.div.service;

import java.util.List;

import com.div.domain.BaseVO;
import com.div.domain.ModuleVO;

public interface ModuleService {
    public List<ModuleVO> getAll();
    public void savemodule(ModuleVO moduleDO);
}
