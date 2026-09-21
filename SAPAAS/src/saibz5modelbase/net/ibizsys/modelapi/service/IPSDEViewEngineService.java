/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEViewBase;
import net.ibizsys.modelapi.domain.PSDEViewEngine;
import net.ibizsys.modelapi.dto.PSDEViewEngineDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEViewEngineService
extends IPSModelService<PSDEViewEngine, PSDEViewEngineDTO> {
    public List<PSDEViewEngine> listByPSDEViewBase(PSDEViewBase var1) throws Exception;

    public PSDEViewEngine get(PSDEViewBase var1, String var2, boolean var3) throws Exception;

    public List<PSDEViewEngineDTO> listDTOByPSDEViewBase(String var1) throws Exception;
}

