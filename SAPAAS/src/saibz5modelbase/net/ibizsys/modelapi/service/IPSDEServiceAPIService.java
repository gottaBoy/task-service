/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEServiceAPI;
import net.ibizsys.modelapi.domain.PSSysServiceAPI;
import net.ibizsys.modelapi.dto.PSDEServiceAPIDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEServiceAPIService
extends IPSModelService<PSDEServiceAPI, PSDEServiceAPIDTO> {
    public List<PSDEServiceAPI> listByPSSysServiceAPI(PSSysServiceAPI var1) throws Exception;

    public PSDEServiceAPI get(PSSysServiceAPI var1, String var2, boolean var3) throws Exception;

    public List<PSDEServiceAPIDTO> listDTOByPSSysServiceAPI(String var1) throws Exception;
}

