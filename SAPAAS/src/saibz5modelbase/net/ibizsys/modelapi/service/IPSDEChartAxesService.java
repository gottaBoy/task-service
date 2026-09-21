/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEChart;
import net.ibizsys.modelapi.domain.PSDEChartAxes;
import net.ibizsys.modelapi.dto.PSDEChartAxesDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEChartAxesService
extends IPSModelService<PSDEChartAxes, PSDEChartAxesDTO> {
    public List<PSDEChartAxes> listByPSDEChart(PSDEChart var1) throws Exception;

    public PSDEChartAxes get(PSDEChart var1, String var2, boolean var3) throws Exception;

    public List<PSDEChartAxesDTO> listDTOByPSDEChart(String var1) throws Exception;
}

