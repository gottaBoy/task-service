/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDBCfg;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEDBCfgDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDBCfgService
extends IPSModelService<PSDEDBCfg, PSDEDBCfgDTO> {
    public List<PSDEDBCfg> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEDBCfg get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEDBCfgDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

