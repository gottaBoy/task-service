/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEChart;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEChartDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEChartService
extends IPSModelService<PSDEChart, PSDEChartDTO> {
    public List<PSDEChart> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEChart get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEChartDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

