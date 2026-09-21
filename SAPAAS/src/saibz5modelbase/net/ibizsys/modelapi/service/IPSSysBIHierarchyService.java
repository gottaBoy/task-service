/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysBIDimension;
import net.ibizsys.modelapi.domain.PSSysBIHierarchy;
import net.ibizsys.modelapi.dto.PSSysBIHierarchyDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBIHierarchyService
extends IPSModelService<PSSysBIHierarchy, PSSysBIHierarchyDTO> {
    public List<PSSysBIHierarchy> listByPSSysBIDimension(PSSysBIDimension var1) throws Exception;

    public PSSysBIHierarchy get(PSSysBIDimension var1, String var2, boolean var3) throws Exception;

    public List<PSSysBIHierarchyDTO> listDTOByPSSysBIDimension(String var1) throws Exception;
}

