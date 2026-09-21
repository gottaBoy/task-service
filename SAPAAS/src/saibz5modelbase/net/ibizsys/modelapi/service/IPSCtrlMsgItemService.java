/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSCtrlMsg;
import net.ibizsys.modelapi.domain.PSCtrlMsgItem;
import net.ibizsys.modelapi.dto.PSCtrlMsgItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSCtrlMsgItemService
extends IPSModelService<PSCtrlMsgItem, PSCtrlMsgItemDTO> {
    public List<PSCtrlMsgItem> listByPSCtrlMsg(PSCtrlMsg var1) throws Exception;

    public PSCtrlMsgItem get(PSCtrlMsg var1, String var2, boolean var3) throws Exception;

    public List<PSCtrlMsgItemDTO> listDTOByPSCtrlMsg(String var1) throws Exception;
}

