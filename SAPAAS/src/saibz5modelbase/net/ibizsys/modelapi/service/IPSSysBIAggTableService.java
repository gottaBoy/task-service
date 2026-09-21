/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysBIAggTable;
import net.ibizsys.modelapi.domain.PSSysBIScheme;
import net.ibizsys.modelapi.dto.PSSysBIAggTableDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBIAggTableService
extends IPSModelService<PSSysBIAggTable, PSSysBIAggTableDTO> {
    public List<PSSysBIAggTable> listByPSSysBIScheme(PSSysBIScheme var1) throws Exception;

    public PSSysBIAggTable get(PSSysBIScheme var1, String var2, boolean var3) throws Exception;

    public List<PSSysBIAggTableDTO> listDTOByPSSysBIScheme(String var1) throws Exception;
}

