/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEList;
import net.ibizsys.modelapi.domain.PSDEListLogic;
import net.ibizsys.modelapi.dto.PSDEListLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEListLogicService
extends IPSModelService<PSDEListLogic, PSDEListLogicDTO> {
    public List<PSDEListLogic> listByPSDEList(PSDEList var1) throws Exception;

    public PSDEListLogic get(PSDEList var1, String var2, boolean var3) throws Exception;

    public List<PSDEListLogicDTO> listDTOByPSDEList(String var1) throws Exception;
}

