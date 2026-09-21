/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEGroup;
import net.ibizsys.modelapi.domain.PSDEGroupDetail;
import net.ibizsys.modelapi.dto.PSDEGroupDetailDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEGroupDetailService
extends IPSModelService<PSDEGroupDetail, PSDEGroupDetailDTO> {
    public List<PSDEGroupDetail> listByPSDEGroup(PSDEGroup var1) throws Exception;

    public PSDEGroupDetail get(PSDEGroup var1, String var2, boolean var3) throws Exception;

    public List<PSDEGroupDetailDTO> listDTOByPSDEGroup(String var1) throws Exception;
}

