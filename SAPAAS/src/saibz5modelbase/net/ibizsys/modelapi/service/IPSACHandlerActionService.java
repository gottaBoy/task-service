/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSACHandler;
import net.ibizsys.modelapi.domain.PSACHandlerAction;
import net.ibizsys.modelapi.dto.PSACHandlerActionDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSACHandlerActionService
extends IPSModelService<PSACHandlerAction, PSACHandlerActionDTO> {
    public List<PSACHandlerAction> listByPSACHandler(PSACHandler var1) throws Exception;

    public PSACHandlerAction get(PSACHandler var1, String var2, boolean var3) throws Exception;

    public List<PSACHandlerActionDTO> listDTOByPSACHandler(String var1) throws Exception;
}

