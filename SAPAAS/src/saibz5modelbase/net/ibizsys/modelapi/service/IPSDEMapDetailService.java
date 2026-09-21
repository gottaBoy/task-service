/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEMap;
import net.ibizsys.modelapi.domain.PSDEMapDetail;
import net.ibizsys.modelapi.dto.PSDEMapDetailDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEMapDetailService
extends IPSModelService<PSDEMapDetail, PSDEMapDetailDTO> {
    public List<PSDEMapDetail> listByPSDEMap(PSDEMap var1) throws Exception;

    public PSDEMapDetail get(PSDEMap var1, String var2, boolean var3) throws Exception;

    public List<PSDEMapDetailDTO> listDTOByPSDEMap(String var1) throws Exception;
}

