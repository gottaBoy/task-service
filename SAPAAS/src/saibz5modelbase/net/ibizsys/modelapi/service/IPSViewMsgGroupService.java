/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.domain.PSViewMsgGroup;
import net.ibizsys.modelapi.dto.PSViewMsgGroupDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSViewMsgGroupService
extends IPSModelService<PSViewMsgGroup, PSViewMsgGroupDTO> {
    public List<PSViewMsgGroup> listByPSModule(PSModule var1) throws Exception;

    public PSViewMsgGroup get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSViewMsgGroupDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSViewMsgGroup> listByPSSystem(PSSystem var1) throws Exception;

    public PSViewMsgGroup get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSViewMsgGroupDTO> listDTOByPSSystem(String var1) throws Exception;
}

