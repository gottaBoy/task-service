/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysDashboard;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysDashboardDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysDashboardService
extends IPSModelService<PSSysDashboard, PSSysDashboardDTO> {
    public List<PSSysDashboard> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSSysDashboard get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSSysDashboardDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSSysDashboard> listByPSModule(PSModule var1) throws Exception;

    public PSSysDashboard get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysDashboardDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysDashboard> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysDashboard get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysDashboardDTO> listDTOByPSSystem(String var1) throws Exception;
}

