/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysModelGroup;
import net.ibizsys.modelapi.domain.PSSysSearchScheme;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysSearchSchemeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysSearchSchemeService
extends IPSModelService<PSSysSearchScheme, PSSysSearchSchemeDTO> {
    public List<PSSysSearchScheme> listByPSModule(PSModule var1) throws Exception;

    public PSSysSearchScheme get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysSearchSchemeDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysSearchScheme> listByPSSysModelGroup(PSSysModelGroup var1) throws Exception;

    public PSSysSearchScheme get(PSSysModelGroup var1, String var2, boolean var3) throws Exception;

    public List<PSSysSearchSchemeDTO> listDTOByPSSysModelGroup(String var1) throws Exception;

    public List<PSSysSearchScheme> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysSearchScheme get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysSearchSchemeDTO> listDTOByPSSystem(String var1) throws Exception;
}

