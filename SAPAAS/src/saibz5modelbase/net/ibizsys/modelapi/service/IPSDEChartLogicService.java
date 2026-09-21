/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEChart;
import net.ibizsys.modelapi.domain.PSDEChartLogic;
import net.ibizsys.modelapi.dto.PSDEChartLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEChartLogicService
extends IPSModelService<PSDEChartLogic, PSDEChartLogicDTO> {
    public List<PSDEChartLogic> listByPSDEChart(PSDEChart var1) throws Exception;

    public PSDEChartLogic get(PSDEChart var1, String var2, boolean var3) throws Exception;

    public List<PSDEChartLogicDTO> listDTOByPSDEChart(String var1) throws Exception;
}

