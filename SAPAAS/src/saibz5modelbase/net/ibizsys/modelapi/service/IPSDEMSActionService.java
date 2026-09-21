/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEMSAction;
import net.ibizsys.modelapi.domain.PSDEMainState;
import net.ibizsys.modelapi.dto.PSDEMSActionDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEMSActionService
extends IPSModelService<PSDEMSAction, PSDEMSActionDTO> {
    public List<PSDEMSAction> listByPSDEMainState(PSDEMainState var1) throws Exception;

    public PSDEMSAction get(PSDEMainState var1, String var2, boolean var3) throws Exception;

    public List<PSDEMSActionDTO> listDTOByPSDEMainState(String var1) throws Exception;
}

