/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEMap;
import net.ibizsys.modelapi.domain.PSDEMapDQ;
import net.ibizsys.modelapi.dto.PSDEMapDQDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEMapDQService
extends IPSModelService<PSDEMapDQ, PSDEMapDQDTO> {
    public List<PSDEMapDQ> listByPSDEMap(PSDEMap var1) throws Exception;

    public PSDEMapDQ get(PSDEMap var1, String var2, boolean var3) throws Exception;

    public List<PSDEMapDQDTO> listDTOByPSDEMap(String var1) throws Exception;
}

