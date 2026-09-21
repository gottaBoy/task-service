/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysBIDimension;
import net.ibizsys.modelapi.domain.PSSysBIScheme;
import net.ibizsys.modelapi.dto.PSSysBIDimensionDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBIDimensionService
extends IPSModelService<PSSysBIDimension, PSSysBIDimensionDTO> {
    public List<PSSysBIDimension> listByPSSysBIScheme(PSSysBIScheme var1) throws Exception;

    public PSSysBIDimension get(PSSysBIScheme var1, String var2, boolean var3) throws Exception;

    public List<PSSysBIDimensionDTO> listDTOByPSSysBIScheme(String var1) throws Exception;
}

