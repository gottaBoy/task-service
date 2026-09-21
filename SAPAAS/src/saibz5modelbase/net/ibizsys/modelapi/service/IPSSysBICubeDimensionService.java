/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysBICube;
import net.ibizsys.modelapi.domain.PSSysBICubeDimension;
import net.ibizsys.modelapi.dto.PSSysBICubeDimensionDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBICubeDimensionService
extends IPSModelService<PSSysBICubeDimension, PSSysBICubeDimensionDTO> {
    public List<PSSysBICubeDimension> listByPSSysBICube(PSSysBICube var1) throws Exception;

    public PSSysBICubeDimension get(PSSysBICube var1, String var2, boolean var3) throws Exception;

    public List<PSSysBICubeDimensionDTO> listDTOByPSSysBICube(String var1) throws Exception;
}

