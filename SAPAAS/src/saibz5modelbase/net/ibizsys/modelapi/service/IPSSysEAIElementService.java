/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysEAIElement;
import net.ibizsys.modelapi.domain.PSSysEAIScheme;
import net.ibizsys.modelapi.dto.PSSysEAIElementDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysEAIElementService
extends IPSModelService<PSSysEAIElement, PSSysEAIElementDTO> {
    public List<PSSysEAIElement> listByPSSysEAIScheme(PSSysEAIScheme var1) throws Exception;

    public PSSysEAIElement get(PSSysEAIScheme var1, String var2, boolean var3) throws Exception;

    public List<PSSysEAIElementDTO> listDTOByPSSysEAIScheme(String var1) throws Exception;
}

