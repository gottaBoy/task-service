/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.domain.PSWXAccount;
import net.ibizsys.modelapi.dto.PSWXAccountDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSWXAccountService
extends IPSModelService<PSWXAccount, PSWXAccountDTO> {
    public List<PSWXAccount> listByPSModule(PSModule var1) throws Exception;

    public PSWXAccount get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSWXAccountDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSWXAccount> listByPSSystem(PSSystem var1) throws Exception;

    public PSWXAccount get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSWXAccountDTO> listDTOByPSSystem(String var1) throws Exception;
}

