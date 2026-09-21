/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSViewMsgGroup;
import net.ibizsys.modelapi.domain.PSViewMsgGrpDetail;
import net.ibizsys.modelapi.dto.PSViewMsgGrpDetailDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSViewMsgGrpDetailService
extends IPSModelService<PSViewMsgGrpDetail, PSViewMsgGrpDetailDTO> {
    public List<PSViewMsgGrpDetail> listByPSViewMsgGroup(PSViewMsgGroup var1) throws Exception;

    public PSViewMsgGrpDetail get(PSViewMsgGroup var1, String var2, boolean var3) throws Exception;

    public List<PSViewMsgGrpDetailDTO> listDTOByPSViewMsgGroup(String var1) throws Exception;
}

