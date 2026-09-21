/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysEAIElement;
import net.ibizsys.modelapi.domain.PSSysEAIElementAttr;
import net.ibizsys.modelapi.dto.PSSysEAIElementAttrDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysEAIElementAttrService
extends IPSModelService<PSSysEAIElementAttr, PSSysEAIElementAttrDTO> {
    public List<PSSysEAIElementAttr> listByPSSysEAIElement(PSSysEAIElement var1) throws Exception;

    public PSSysEAIElementAttr get(PSSysEAIElement var1, String var2, boolean var3) throws Exception;

    public List<PSSysEAIElementAttrDTO> listDTOByPSSysEAIElement(String var1) throws Exception;
}

