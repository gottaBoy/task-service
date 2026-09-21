/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysUCMap;
import net.ibizsys.modelapi.domain.PSSysUCMapNode;
import net.ibizsys.modelapi.dto.PSSysUCMapNodeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysUCMapNodeService
extends IPSModelService<PSSysUCMapNode, PSSysUCMapNodeDTO> {
    public List<PSSysUCMapNode> listByPSSysUCMap(PSSysUCMap var1) throws Exception;

    public PSSysUCMapNode get(PSSysUCMap var1, String var2, boolean var3) throws Exception;

    public List<PSSysUCMapNodeDTO> listDTOByPSSysUCMap(String var1) throws Exception;
}

