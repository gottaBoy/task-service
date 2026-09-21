/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysServiceAPI;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysServiceAPIDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysServiceAPIService
extends IPSModelService<PSSysServiceAPI, PSSysServiceAPIDTO> {
    public List<PSSysServiceAPI> listByPSModule(PSModule var1) throws Exception;

    public PSSysServiceAPI get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysServiceAPIDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysServiceAPI> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysServiceAPI get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysServiceAPIDTO> listDTOByPSSystem(String var1) throws Exception;
}

