/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDELogic;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSDELogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDELogicService
extends IPSModelService<PSDELogic, PSDELogicDTO> {
    public List<PSDELogic> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDELogic get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDELogicDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSDELogic> listByPSModule(PSModule var1) throws Exception;

    public PSDELogic get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSDELogicDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSDELogic> listByPSSystem(PSSystem var1) throws Exception;

    public PSDELogic get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSDELogicDTO> listDTOByPSSystem(String var1) throws Exception;
}

