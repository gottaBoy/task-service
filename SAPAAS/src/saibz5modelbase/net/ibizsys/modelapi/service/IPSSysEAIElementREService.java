/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysEAIElement;
import net.ibizsys.modelapi.domain.PSSysEAIElementRE;
import net.ibizsys.modelapi.dto.PSSysEAIElementREDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysEAIElementREService
extends IPSModelService<PSSysEAIElementRE, PSSysEAIElementREDTO> {
    public List<PSSysEAIElementRE> listByPSSysEAIElement(PSSysEAIElement var1) throws Exception;

    public PSSysEAIElementRE get(PSSysEAIElement var1, String var2, boolean var3) throws Exception;

    public List<PSSysEAIElementREDTO> listDTOByPSSysEAIElement(String var1) throws Exception;
}

