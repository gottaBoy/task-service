/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysBDScheme;
import net.ibizsys.modelapi.domain.PSSysModelGroup;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysBDSchemeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBDSchemeService
extends IPSModelService<PSSysBDScheme, PSSysBDSchemeDTO> {
    public List<PSSysBDScheme> listByPSModule(PSModule var1) throws Exception;

    public PSSysBDScheme get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysBDSchemeDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysBDScheme> listByPSSysModelGroup(PSSysModelGroup var1) throws Exception;

    public PSSysBDScheme get(PSSysModelGroup var1, String var2, boolean var3) throws Exception;

    public List<PSSysBDSchemeDTO> listDTOByPSSysModelGroup(String var1) throws Exception;

    public List<PSSysBDScheme> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysBDScheme get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysBDSchemeDTO> listDTOByPSSystem(String var1) throws Exception;
}

