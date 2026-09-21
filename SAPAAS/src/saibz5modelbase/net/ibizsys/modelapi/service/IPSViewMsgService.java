/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.domain.PSViewMsg;
import net.ibizsys.modelapi.dto.PSViewMsgDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSViewMsgService
extends IPSModelService<PSViewMsg, PSViewMsgDTO> {
    public List<PSViewMsg> listByPSModule(PSModule var1) throws Exception;

    public PSViewMsg get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSViewMsgDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSViewMsg> listByPSSystem(PSSystem var1) throws Exception;

    public PSViewMsg get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSViewMsgDTO> listDTOByPSSystem(String var1) throws Exception;
}

