/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEMainState;
import net.ibizsys.modelapi.domain.PSDEMainStateRS;
import net.ibizsys.modelapi.dto.PSDEMainStateRSDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEMainStateRSService
extends IPSModelService<PSDEMainStateRS, PSDEMainStateRSDTO> {
    public List<PSDEMainStateRS> listByPSDEMainState(PSDEMainState var1) throws Exception;

    public PSDEMainStateRS get(PSDEMainState var1, String var2, boolean var3) throws Exception;

    public List<PSDEMainStateRSDTO> listDTOByPSDEMainState(String var1) throws Exception;
}

