/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDELogic;
import net.ibizsys.modelapi.domain.PSDELogicNode;
import net.ibizsys.modelapi.dto.PSDELogicNodeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDELogicNodeService
extends IPSModelService<PSDELogicNode, PSDELogicNodeDTO> {
    public List<PSDELogicNode> listByPSDELogic(PSDELogic var1) throws Exception;

    public PSDELogicNode get(PSDELogic var1, String var2, boolean var3) throws Exception;

    public List<PSDELogicNodeDTO> listDTOByPSDELogic(String var1) throws Exception;
}

