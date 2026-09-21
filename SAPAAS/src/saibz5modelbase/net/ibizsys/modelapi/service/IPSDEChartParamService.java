/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEChart;
import net.ibizsys.modelapi.domain.PSDEChartParam;
import net.ibizsys.modelapi.dto.PSDEChartParamDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEChartParamService
extends IPSModelService<PSDEChartParam, PSDEChartParamDTO> {
    public List<PSDEChartParam> listByPSDEChart(PSDEChart var1) throws Exception;

    public PSDEChartParam get(PSDEChart var1, String var2, boolean var3) throws Exception;

    public List<PSDEChartParamDTO> listDTOByPSDEChart(String var1) throws Exception;
}

