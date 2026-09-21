/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysBICube;
import net.ibizsys.modelapi.domain.PSSysBIScheme;
import net.ibizsys.modelapi.dto.PSSysBICubeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysBICubeService
extends IPSModelService<PSSysBICube, PSSysBICubeDTO> {
    public List<PSSysBICube> listByPSSysBIScheme(PSSysBIScheme var1) throws Exception;

    public PSSysBICube get(PSSysBIScheme var1, String var2, boolean var3) throws Exception;

    public List<PSSysBICubeDTO> listDTOByPSSysBIScheme(String var1) throws Exception;
}

