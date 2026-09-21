/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysDBScheme;
import net.ibizsys.modelapi.domain.PSSysModelGroup;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysDBSchemeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysDBSchemeService
extends IPSModelService<PSSysDBScheme, PSSysDBSchemeDTO> {
    public List<PSSysDBScheme> listByPSModule(PSModule var1) throws Exception;

    public PSSysDBScheme get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysDBSchemeDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysDBScheme> listByPSSysModelGroup(PSSysModelGroup var1) throws Exception;

    public PSSysDBScheme get(PSSysModelGroup var1, String var2, boolean var3) throws Exception;

    public List<PSSysDBSchemeDTO> listDTOByPSSysModelGroup(String var1) throws Exception;

    public List<PSSysDBScheme> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysDBScheme get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysDBSchemeDTO> listDTOByPSSystem(String var1) throws Exception;
}

