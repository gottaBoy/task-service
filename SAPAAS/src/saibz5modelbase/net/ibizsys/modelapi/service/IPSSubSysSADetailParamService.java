/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSubSysSADetail;
import net.ibizsys.modelapi.domain.PSSubSysSADetailParam;
import net.ibizsys.modelapi.dto.PSSubSysSADetailParamDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSubSysSADetailParamService
extends IPSModelService<PSSubSysSADetailParam, PSSubSysSADetailParamDTO> {
    public List<PSSubSysSADetailParam> listByPSSubSysSADetail(PSSubSysSADetail var1) throws Exception;

    public PSSubSysSADetailParam get(PSSubSysSADetail var1, String var2, boolean var3) throws Exception;

    public List<PSSubSysSADetailParamDTO> listDTOByPSSubSysSADetail(String var1) throws Exception;
}

