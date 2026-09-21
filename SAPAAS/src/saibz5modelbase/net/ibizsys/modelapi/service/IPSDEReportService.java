/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEReport;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEReportDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEReportService
extends IPSModelService<PSDEReport, PSDEReportDTO> {
    public List<PSDEReport> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEReport get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEReportDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

