/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysBDColumn;
import net.ibizsys.modelapi.domain.PSSysBDTable;
import net.ibizsys.modelapi.dto.PSSysBDColumnDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBDColumnService
extends IPSModelService<PSSysBDColumn, PSSysBDColumnDTO> {
    public List<PSSysBDColumn> listByPSSysBDTable(PSSysBDTable var1) throws Exception;

    public PSSysBDColumn get(PSSysBDTable var1, String var2, boolean var3) throws Exception;

    public List<PSSysBDColumnDTO> listDTOByPSSysBDTable(String var1) throws Exception;
}

