/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEGrid;
import net.ibizsys.modelapi.domain.PSDEGridLogic;
import net.ibizsys.modelapi.dto.PSDEGridLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEGridLogicService
extends IPSModelService<PSDEGridLogic, PSDEGridLogicDTO> {
    public List<PSDEGridLogic> listByPSDEGrid(PSDEGrid var1) throws Exception;

    public PSDEGridLogic get(PSDEGrid var1, String var2, boolean var3) throws Exception;

    public List<PSDEGridLogicDTO> listDTOByPSDEGrid(String var1) throws Exception;
}

