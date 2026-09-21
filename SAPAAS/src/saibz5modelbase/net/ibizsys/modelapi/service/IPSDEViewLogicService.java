/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEViewBase;
import net.ibizsys.modelapi.domain.PSDEViewLogic;
import net.ibizsys.modelapi.dto.PSDEViewLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEViewLogicService
extends IPSModelService<PSDEViewLogic, PSDEViewLogicDTO> {
    public List<PSDEViewLogic> listByPSDEViewBase(PSDEViewBase var1) throws Exception;

    public PSDEViewLogic get(PSDEViewBase var1, String var2, boolean var3) throws Exception;

    public List<PSDEViewLogicDTO> listDTOByPSDEViewBase(String var1) throws Exception;
}

