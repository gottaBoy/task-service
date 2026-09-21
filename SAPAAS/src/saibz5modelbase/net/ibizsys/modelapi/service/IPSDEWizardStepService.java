/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEWizard;
import net.ibizsys.modelapi.domain.PSDEWizardStep;
import net.ibizsys.modelapi.dto.PSDEWizardStepDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEWizardStepService
extends IPSModelService<PSDEWizardStep, PSDEWizardStepDTO> {
    public List<PSDEWizardStep> listByPSDEWizard(PSDEWizard var1) throws Exception;

    public PSDEWizardStep get(PSDEWizard var1, String var2, boolean var3) throws Exception;

    public List<PSDEWizardStepDTO> listDTOByPSDEWizard(String var1) throws Exception;
}

