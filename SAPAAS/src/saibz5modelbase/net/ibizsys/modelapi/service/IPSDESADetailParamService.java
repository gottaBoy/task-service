/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDESADetail;
import net.ibizsys.modelapi.domain.PSDESADetailParam;
import net.ibizsys.modelapi.dto.PSDESADetailParamDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDESADetailParamService
extends IPSModelService<PSDESADetailParam, PSDESADetailParamDTO> {
    public List<PSDESADetailParam> listByPSDESADetail(PSDESADetail var1) throws Exception;

    public PSDESADetailParam get(PSDESADetail var1, String var2, boolean var3) throws Exception;

    public List<PSDESADetailParamDTO> listDTOByPSDESADetail(String var1) throws Exception;
}

