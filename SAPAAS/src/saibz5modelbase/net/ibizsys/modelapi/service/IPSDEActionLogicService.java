/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEAction;
import net.ibizsys.modelapi.domain.PSDEActionLogic;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEActionLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEActionLogicService
extends IPSModelService<PSDEActionLogic, PSDEActionLogicDTO> {
    public List<PSDEActionLogic> listByPSDEAction(PSDEAction var1) throws Exception;

    public PSDEActionLogic get(PSDEAction var1, String var2, boolean var3) throws Exception;

    public List<PSDEActionLogicDTO> listDTOByPSDEAction(String var1) throws Exception;

    public List<PSDEActionLogic> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEActionLogic get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEActionLogicDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

