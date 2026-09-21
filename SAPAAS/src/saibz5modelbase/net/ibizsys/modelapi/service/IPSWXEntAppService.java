/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSWXAccount;
import net.ibizsys.modelapi.domain.PSWXEntApp;
import net.ibizsys.modelapi.dto.PSWXEntAppDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSWXEntAppService
extends IPSModelService<PSWXEntApp, PSWXEntAppDTO> {
    public List<PSWXEntApp> listByPSWXAccount(PSWXAccount var1) throws Exception;

    public PSWXEntApp get(PSWXAccount var1, String var2, boolean var3) throws Exception;

    public List<PSWXEntAppDTO> listDTOByPSWXAccount(String var1) throws Exception;
}

