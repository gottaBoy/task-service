/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDESARS;
import net.ibizsys.modelapi.domain.PSSysServiceAPI;
import net.ibizsys.modelapi.dto.PSDESARSDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDESARSService
extends IPSModelService<PSDESARS, PSDESARSDTO> {
    public List<PSDESARS> listByPSSysServiceAPI(PSSysServiceAPI var1) throws Exception;

    public PSDESARS get(PSSysServiceAPI var1, String var2, boolean var3) throws Exception;

    public List<PSDESARSDTO> listDTOByPSSysServiceAPI(String var1) throws Exception;
}

