/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSCtrlMsg;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSCtrlMsgDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSCtrlMsgService
extends IPSModelService<PSCtrlMsg, PSCtrlMsgDTO> {
    public List<PSCtrlMsg> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSCtrlMsg get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSCtrlMsgDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSCtrlMsg> listByPSModule(PSModule var1) throws Exception;

    public PSCtrlMsg get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSCtrlMsgDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSCtrlMsg> listByPSSystem(PSSystem var1) throws Exception;

    public PSCtrlMsg get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSCtrlMsgDTO> listDTOByPSSystem(String var1) throws Exception;
}

