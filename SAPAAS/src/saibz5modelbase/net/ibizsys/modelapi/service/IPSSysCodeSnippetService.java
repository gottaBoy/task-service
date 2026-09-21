/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysCodeSnippet;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysCodeSnippetDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysCodeSnippetService
extends IPSModelService<PSSysCodeSnippet, PSSysCodeSnippetDTO> {
    public List<PSSysCodeSnippet> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysCodeSnippet get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysCodeSnippetDTO> listDTOByPSSystem(String var1) throws Exception;
}

