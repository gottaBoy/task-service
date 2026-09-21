/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysBICubeDimension;
import net.ibizsys.modelapi.domain.PSSysBICubeLevel;
import net.ibizsys.modelapi.dto.PSSysBICubeLevelDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBICubeLevelService
extends IPSModelService<PSSysBICubeLevel, PSSysBICubeLevelDTO> {
    public List<PSSysBICubeLevel> listByPSSysBICubeDimension(PSSysBICubeDimension var1) throws Exception;

    public PSSysBICubeLevel get(PSSysBICubeDimension var1, String var2, boolean var3) throws Exception;

    public List<PSSysBICubeLevelDTO> listDTOByPSSysBICubeDimension(String var1) throws Exception;
}

