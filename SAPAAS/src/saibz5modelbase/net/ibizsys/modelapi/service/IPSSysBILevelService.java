/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysBIHierarchy;
import net.ibizsys.modelapi.domain.PSSysBILevel;
import net.ibizsys.modelapi.dto.PSSysBILevelDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBILevelService
extends IPSModelService<PSSysBILevel, PSSysBILevelDTO> {
    public List<PSSysBILevel> listByPSSysBIHierarchy(PSSysBIHierarchy var1) throws Exception;

    public PSSysBILevel get(PSSysBIHierarchy var1, String var2, boolean var3) throws Exception;

    public List<PSSysBILevelDTO> listDTOByPSSysBIHierarchy(String var1) throws Exception;
}

