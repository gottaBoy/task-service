/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysBDTable;
import net.ibizsys.modelapi.domain.PSSysBDTableDER;
import net.ibizsys.modelapi.dto.PSSysBDTableDERDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBDTableDERService
extends IPSModelService<PSSysBDTableDER, PSSysBDTableDERDTO> {
    public List<PSSysBDTableDER> listByPSSysBDTable(PSSysBDTable var1) throws Exception;

    public PSSysBDTableDER get(PSSysBDTable var1, String var2, boolean var3) throws Exception;

    public List<PSSysBDTableDERDTO> listDTOByPSSysBDTable(String var1) throws Exception;
}

