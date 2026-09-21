/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSubSysServiceAPI;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSubSysServiceAPIDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSubSysServiceAPIService
extends IPSModelService<PSSubSysServiceAPI, PSSubSysServiceAPIDTO> {
    public List<PSSubSysServiceAPI> listByPSModule(PSModule var1) throws Exception;

    public PSSubSysServiceAPI get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSubSysServiceAPIDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSubSysServiceAPI> listByPSSystem(PSSystem var1) throws Exception;

    public PSSubSysServiceAPI get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSubSysServiceAPIDTO> listDTOByPSSystem(String var1) throws Exception;
}

