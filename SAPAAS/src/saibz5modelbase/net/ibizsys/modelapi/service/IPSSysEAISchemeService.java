/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysEAIScheme;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysEAISchemeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysEAISchemeService
extends IPSModelService<PSSysEAIScheme, PSSysEAISchemeDTO> {
    public List<PSSysEAIScheme> listByPSModule(PSModule var1) throws Exception;

    public PSSysEAIScheme get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysEAISchemeDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysEAIScheme> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysEAIScheme get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysEAISchemeDTO> listDTOByPSSystem(String var1) throws Exception;
}

