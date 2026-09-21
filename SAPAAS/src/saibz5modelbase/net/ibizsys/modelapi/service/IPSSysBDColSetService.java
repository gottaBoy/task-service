/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysBDColSet;
import net.ibizsys.modelapi.domain.PSSysBDTable;
import net.ibizsys.modelapi.dto.PSSysBDColSetDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBDColSetService
extends IPSModelService<PSSysBDColSet, PSSysBDColSetDTO> {
    public List<PSSysBDColSet> listByPSSysBDTable(PSSysBDTable var1) throws Exception;

    public PSSysBDColSet get(PSSysBDTable var1, String var2, boolean var3) throws Exception;

    public List<PSSysBDColSetDTO> listDTOByPSSysBDTable(String var1) throws Exception;
}

