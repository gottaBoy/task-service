/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSCtrlLogicGroup;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSCtrlLogicGroupDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSCtrlLogicGroupService
extends IPSModelService<PSCtrlLogicGroup, PSCtrlLogicGroupDTO> {
    public List<PSCtrlLogicGroup> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSCtrlLogicGroup get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSCtrlLogicGroupDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSCtrlLogicGroup> listByPSModule(PSModule var1) throws Exception;

    public PSCtrlLogicGroup get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSCtrlLogicGroupDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSCtrlLogicGroup> listByPSSystem(PSSystem var1) throws Exception;

    public PSCtrlLogicGroup get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSCtrlLogicGroupDTO> listDTOByPSSystem(String var1) throws Exception;
}

