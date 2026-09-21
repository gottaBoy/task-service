/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEMap;
import net.ibizsys.modelapi.domain.PSDEMapDS;
import net.ibizsys.modelapi.dto.PSDEMapDSDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEMapDSService
extends IPSModelService<PSDEMapDS, PSDEMapDSDTO> {
    public List<PSDEMapDS> listByPSDEMap(PSDEMap var1) throws Exception;

    public PSDEMapDS get(PSDEMap var1, String var2, boolean var3) throws Exception;

    public List<PSDEMapDSDTO> listDTOByPSDEMap(String var1) throws Exception;
}

