/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGrpDetail;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGrpDetailServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSCtrlLogicGrpDetailService
extends PSCtrlLogicGrpDetailServiceBase {
    private static final Log log = LogFactory.getLog(PSCtrlLogicGrpDetailService.class);

    @Override
    public void getDraft(PSCtrlLogicGrpDetail pSCtrlLogicGrpDetail) throws Exception {
        super.getDraft(pSCtrlLogicGrpDetail);
        if (StringHelper.isNullOrEmpty((String)pSCtrlLogicGrpDetail.getPSDEId()) && pSCtrlLogicGrpDetail.getPSCtrlLogicGroup() != null) {
            pSCtrlLogicGrpDetail.setPSDEId(pSCtrlLogicGrpDetail.getPSCtrlLogicGroup().getPSDEId());
            pSCtrlLogicGrpDetail.setPSDEName(pSCtrlLogicGrpDetail.getPSCtrlLogicGroup().getPSDEName());
        }
    }

    @Override
    public void getDraftTemp(PSCtrlLogicGrpDetail pSCtrlLogicGrpDetail) throws Exception {
        super.getDraftTemp(pSCtrlLogicGrpDetail);
        if (StringHelper.isNullOrEmpty((String)pSCtrlLogicGrpDetail.getPSDEId()) && pSCtrlLogicGrpDetail.getPSCtrlLogicGroup() != null) {
            pSCtrlLogicGrpDetail.setPSDEId(pSCtrlLogicGrpDetail.getPSCtrlLogicGroup().getPSDEId());
            pSCtrlLogicGrpDetail.setPSDEName(pSCtrlLogicGrpDetail.getPSCtrlLogicGroup().getPSDEName());
        }
    }

    @Override
    protected Map<String, Object> getGetDraftDefaultValueScope(PSCtrlLogicGrpDetail pSCtrlLogicGrpDetail, boolean bl) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if (!StringHelper.isNullOrEmpty((String)pSCtrlLogicGrpDetail.getPSCtrlLogicGroupId())) {
            hashMap.put("PSCTRLLOGICGROUPID", pSCtrlLogicGrpDetail.getPSCtrlLogicGroupId());
        }
        return hashMap;
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSCtrlLogicGrpDetail pSCtrlLogicGrpDetail, boolean bl) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        if (StringHelper.isNullOrEmpty((String)pSCtrlLogicGrpDetail.getPSCtrlLogicGrpDetailName())) {
            hashMap.put("PSCTRLLOGICGRPDETAILNAME", "logic");
        }
        return hashMap;
    }
}

