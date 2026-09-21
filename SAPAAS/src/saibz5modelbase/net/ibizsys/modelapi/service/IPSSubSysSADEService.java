/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSubSysSADE;
import net.ibizsys.modelapi.domain.PSSubSysServiceAPI;
import net.ibizsys.modelapi.dto.PSSubSysSADEDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSubSysSADEService
extends IPSModelService<PSSubSysSADE, PSSubSysSADEDTO> {
    public List<PSSubSysSADE> listByPSSubSysServiceAPI(PSSubSysServiceAPI var1) throws Exception;

    public PSSubSysSADE get(PSSubSysServiceAPI var1, String var2, boolean var3) throws Exception;

    public List<PSSubSysSADEDTO> listDTOByPSSubSysServiceAPI(String var1) throws Exception;
}

