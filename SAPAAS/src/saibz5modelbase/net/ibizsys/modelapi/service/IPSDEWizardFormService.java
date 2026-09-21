/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEWizard;
import net.ibizsys.modelapi.domain.PSDEWizardForm;
import net.ibizsys.modelapi.dto.PSDEWizardFormDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEWizardFormService
extends IPSModelService<PSDEWizardForm, PSDEWizardFormDTO> {
    public List<PSDEWizardForm> listByPSDEWizard(PSDEWizard var1) throws Exception;

    public PSDEWizardForm get(PSDEWizard var1, String var2, boolean var3) throws Exception;

    public List<PSDEWizardFormDTO> listDTOByPSDEWizard(String var1) throws Exception;
}

