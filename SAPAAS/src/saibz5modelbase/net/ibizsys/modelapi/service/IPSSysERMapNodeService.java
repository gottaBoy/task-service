/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysERMap;
import net.ibizsys.modelapi.domain.PSSysERMapNode;
import net.ibizsys.modelapi.dto.PSSysERMapNodeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysERMapNodeService
extends IPSModelService<PSSysERMapNode, PSSysERMapNodeDTO> {
    public List<PSSysERMapNode> listByPSSysERMap(PSSysERMap var1) throws Exception;

    public PSSysERMapNode get(PSSysERMap var1, String var2, boolean var3) throws Exception;

    public List<PSSysERMapNodeDTO> listDTOByPSSysERMap(String var1) throws Exception;
}

