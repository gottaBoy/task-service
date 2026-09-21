/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEFGroup;
import net.ibizsys.modelapi.domain.PSDEFGroupDetail;
import net.ibizsys.modelapi.dto.PSDEFGroupDetailDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEFGroupDetailService
extends IPSModelService<PSDEFGroupDetail, PSDEFGroupDetailDTO> {
    public List<PSDEFGroupDetail> listByPSDEFGroup(PSDEFGroup var1) throws Exception;

    public PSDEFGroupDetail get(PSDEFGroup var1, String var2, boolean var3) throws Exception;

    public List<PSDEFGroupDetailDTO> listDTOByPSDEFGroup(String var1) throws Exception;
}

