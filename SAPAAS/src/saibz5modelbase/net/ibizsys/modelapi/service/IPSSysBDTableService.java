/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysBDScheme;
import net.ibizsys.modelapi.domain.PSSysBDTable;
import net.ibizsys.modelapi.dto.PSSysBDTableDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBDTableService
extends IPSModelService<PSSysBDTable, PSSysBDTableDTO> {
    public List<PSSysBDTable> listByPSSysBDScheme(PSSysBDScheme var1) throws Exception;

    public PSSysBDTable get(PSSysBDScheme var1, String var2, boolean var3) throws Exception;

    public List<PSSysBDTableDTO> listDTOByPSSysBDScheme(String var1) throws Exception;
}

