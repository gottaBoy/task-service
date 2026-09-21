/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysBDTable;
import net.ibizsys.modelapi.domain.PSSysBDTableDE;
import net.ibizsys.modelapi.dto.PSSysBDTableDEDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBDTableDEService
extends IPSModelService<PSSysBDTableDE, PSSysBDTableDEDTO> {
    public List<PSSysBDTableDE> listByPSSysBDTable(PSSysBDTable var1) throws Exception;

    public PSSysBDTableDE get(PSSysBDTable var1, String var2, boolean var3) throws Exception;

    public List<PSSysBDTableDEDTO> listDTOByPSSysBDTable(String var1) throws Exception;
}

