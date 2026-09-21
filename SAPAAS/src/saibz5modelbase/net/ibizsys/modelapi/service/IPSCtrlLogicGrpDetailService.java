/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSCtrlLogicGroup;
import net.ibizsys.modelapi.domain.PSCtrlLogicGrpDetail;
import net.ibizsys.modelapi.dto.PSCtrlLogicGrpDetailDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSCtrlLogicGrpDetailService
extends IPSModelService<PSCtrlLogicGrpDetail, PSCtrlLogicGrpDetailDTO> {
    public List<PSCtrlLogicGrpDetail> listByPSCtrlLogicGroup(PSCtrlLogicGroup var1) throws Exception;

    public PSCtrlLogicGrpDetail get(PSCtrlLogicGroup var1, String var2, boolean var3) throws Exception;

    public List<PSCtrlLogicGrpDetailDTO> listDTOByPSCtrlLogicGroup(String var1) throws Exception;
}

