/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEWizard;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEWizardDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEWizardService
extends IPSModelService<PSDEWizard, PSDEWizardDTO> {
    public List<PSDEWizard> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEWizard get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEWizardDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

