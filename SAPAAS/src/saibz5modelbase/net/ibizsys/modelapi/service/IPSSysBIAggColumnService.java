/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysBIAggColumn;
import net.ibizsys.modelapi.domain.PSSysBIAggTable;
import net.ibizsys.modelapi.dto.PSSysBIAggColumnDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBIAggColumnService
extends IPSModelService<PSSysBIAggColumn, PSSysBIAggColumnDTO> {
    public List<PSSysBIAggColumn> listByPSSysBIAggTable(PSSysBIAggTable var1) throws Exception;

    public PSSysBIAggColumn get(PSSysBIAggTable var1, String var2, boolean var3) throws Exception;

    public List<PSSysBIAggColumnDTO> listDTOByPSSysBIAggTable(String var1) throws Exception;
}

