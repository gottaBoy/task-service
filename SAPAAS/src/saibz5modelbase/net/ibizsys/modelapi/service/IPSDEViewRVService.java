/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEViewBase;
import net.ibizsys.modelapi.domain.PSDEViewRV;
import net.ibizsys.modelapi.dto.PSDEViewRVDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEViewRVService
extends IPSModelService<PSDEViewRV, PSDEViewRVDTO> {
    public List<PSDEViewRV> listByPSDEViewBase(PSDEViewBase var1) throws Exception;

    public PSDEViewRV get(PSDEViewBase var1, String var2, boolean var3) throws Exception;

    public List<PSDEViewRVDTO> listDTOByPSDEViewBase(String var1) throws Exception;
}

