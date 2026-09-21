/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysBIScheme;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysBISchemeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBISchemeService
extends IPSModelService<PSSysBIScheme, PSSysBISchemeDTO> {
    public List<PSSysBIScheme> listByPSModule(PSModule var1) throws Exception;

    public PSSysBIScheme get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysBISchemeDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysBIScheme> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysBIScheme get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysBISchemeDTO> listDTOByPSSystem(String var1) throws Exception;
}

