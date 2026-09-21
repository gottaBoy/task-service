/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSubSysSADERS;
import net.ibizsys.modelapi.domain.PSSubSysServiceAPI;
import net.ibizsys.modelapi.dto.PSSubSysSADERSDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSubSysSADERSService
extends IPSModelService<PSSubSysSADERS, PSSubSysSADERSDTO> {
    public List<PSSubSysSADERS> listByPSSubSysServiceAPI(PSSubSysServiceAPI var1) throws Exception;

    public PSSubSysSADERS get(PSSubSysServiceAPI var1, String var2, boolean var3) throws Exception;

    public List<PSSubSysSADERSDTO> listDTOByPSSubSysServiceAPI(String var1) throws Exception;
}

