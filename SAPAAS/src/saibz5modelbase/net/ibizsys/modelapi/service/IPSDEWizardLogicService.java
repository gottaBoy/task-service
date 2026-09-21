/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEWizard;
import net.ibizsys.modelapi.domain.PSDEWizardLogic;
import net.ibizsys.modelapi.dto.PSDEWizardLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEWizardLogicService
extends IPSModelService<PSDEWizardLogic, PSDEWizardLogicDTO> {
    public List<PSDEWizardLogic> listByPSDEWizard(PSDEWizard var1) throws Exception;

    public PSDEWizardLogic get(PSDEWizard var1, String var2, boolean var3) throws Exception;

    public List<PSDEWizardLogicDTO> listDTOByPSDEWizard(String var1) throws Exception;
}

