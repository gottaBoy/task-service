/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysDashboard;
import net.ibizsys.modelapi.domain.PSSysDashboardLogic;
import net.ibizsys.modelapi.dto.PSSysDashboardLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysDashboardLogicService
extends IPSModelService<PSSysDashboardLogic, PSSysDashboardLogicDTO> {
    public List<PSSysDashboardLogic> listByPSSysDashboard(PSSysDashboard var1) throws Exception;

    public PSSysDashboardLogic get(PSSysDashboard var1, String var2, boolean var3) throws Exception;

    public List<PSSysDashboardLogicDTO> listDTOByPSSysDashboard(String var1) throws Exception;
}

