/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSubSysSADE;
import net.ibizsys.modelapi.domain.PSSubSysSADetail;
import net.ibizsys.modelapi.domain.PSSubSysServiceAPI;
import net.ibizsys.modelapi.dto.PSSubSysSADetailDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSubSysSADetailService
extends IPSModelService<PSSubSysSADetail, PSSubSysSADetailDTO> {
    public List<PSSubSysSADetail> listByPSSubSysSADE(PSSubSysSADE var1) throws Exception;

    public PSSubSysSADetail get(PSSubSysSADE var1, String var2, boolean var3) throws Exception;

    public List<PSSubSysSADetailDTO> listDTOByPSSubSysSADE(String var1) throws Exception;

    public List<PSSubSysSADetail> listByPSSubSysServiceAPI(PSSubSysServiceAPI var1) throws Exception;

    public PSSubSysSADetail get(PSSubSysServiceAPI var1, String var2, boolean var3) throws Exception;

    public List<PSSubSysSADetailDTO> listDTOByPSSubSysServiceAPI(String var1) throws Exception;
}

