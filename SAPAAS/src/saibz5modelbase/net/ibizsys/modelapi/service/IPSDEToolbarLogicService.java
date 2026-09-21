/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEToolbar;
import net.ibizsys.modelapi.domain.PSDEToolbarLogic;
import net.ibizsys.modelapi.dto.PSDEToolbarLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEToolbarLogicService
extends IPSModelService<PSDEToolbarLogic, PSDEToolbarLogicDTO> {
    public List<PSDEToolbarLogic> listByPSDEToolbar(PSDEToolbar var1) throws Exception;

    public PSDEToolbarLogic get(PSDEToolbar var1, String var2, boolean var3) throws Exception;

    public List<PSDEToolbarLogicDTO> listDTOByPSDEToolbar(String var1) throws Exception;
}

