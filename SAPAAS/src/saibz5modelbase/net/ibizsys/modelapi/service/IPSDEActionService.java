/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEAction;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEActionDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEActionService
extends IPSModelService<PSDEAction, PSDEActionDTO> {
    public List<PSDEAction> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEAction get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEActionDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

