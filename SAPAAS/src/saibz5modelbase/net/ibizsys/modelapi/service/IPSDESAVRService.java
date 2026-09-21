/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDESAVR;
import net.ibizsys.modelapi.domain.PSDEServiceAPI;
import net.ibizsys.modelapi.dto.PSDESAVRDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDESAVRService
extends IPSModelService<PSDESAVR, PSDESAVRDTO> {
    public List<PSDESAVR> listByPSDEServiceAPI(PSDEServiceAPI var1) throws Exception;

    public PSDESAVR get(PSDEServiceAPI var1, String var2, boolean var3) throws Exception;

    public List<PSDESAVRDTO> listDTOByPSDEServiceAPI(String var1) throws Exception;
}

