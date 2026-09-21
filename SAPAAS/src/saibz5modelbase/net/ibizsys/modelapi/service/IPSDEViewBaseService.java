/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEViewBase;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEViewBaseDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEViewBaseService
extends IPSModelService<PSDEViewBase, PSDEViewBaseDTO> {
    public List<PSDEViewBase> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEViewBase get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEViewBaseDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

