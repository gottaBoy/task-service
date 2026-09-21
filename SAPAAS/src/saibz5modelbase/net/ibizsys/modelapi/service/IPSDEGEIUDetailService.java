/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEGEIUDetail;
import net.ibizsys.modelapi.domain.PSDEGEIUpdate;
import net.ibizsys.modelapi.dto.PSDEGEIUDetailDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEGEIUDetailService
extends IPSModelService<PSDEGEIUDetail, PSDEGEIUDetailDTO> {
    public List<PSDEGEIUDetail> listByPSDEGEIUpdate(PSDEGEIUpdate var1) throws Exception;

    public PSDEGEIUDetail get(PSDEGEIUpdate var1, String var2, boolean var3) throws Exception;

    public List<PSDEGEIUDetailDTO> listDTOByPSDEGEIUpdate(String var1) throws Exception;
}

