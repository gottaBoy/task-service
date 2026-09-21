/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.wfdesign.service;

import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.WFProcRoleTypeCodeListModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcRole;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcRoleServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSWFProcRoleService
extends PSWFProcRoleServiceBase {
    private static final Log log = LogFactory.getLog(PSWFProcRoleService.class);

    @Override
    protected void onFillParentInfo_PSWFProcess(PSWFProcRole pSWFProcRole, PSWFProcess pSWFProcess) throws Exception {
        super.onFillParentInfo_PSWFProcess(pSWFProcRole, pSWFProcess);
        pSWFProcRole.setPSWFVersionId(pSWFProcess.getPSWFVersionId());
        pSWFProcRole.setPSWFVersionName(pSWFProcess.getPSWFVersionName());
    }

    @Override
    protected void onBeforeCreateTemp(PSWFProcRole pSWFProcRole) throws Exception {
        super.onBeforeCreateTemp(pSWFProcRole);
        if (StringHelper.isNullOrEmpty((String)pSWFProcRole.getPSWFProcRoleName())) {
            pSWFProcRole.setPSWFProcRoleName(this.calcWFProcRoleName(pSWFProcRole));
        }
    }

    @Override
    protected void onBeforeUpdateTemp(PSWFProcRole pSWFProcRole) throws Exception {
        super.onBeforeUpdateTemp(pSWFProcRole);
        if (StringHelper.isNullOrEmpty((String)pSWFProcRole.getPSWFProcRoleName())) {
            pSWFProcRole.setPSWFProcRoleName(this.calcWFProcRoleName(pSWFProcRole));
        }
    }

    protected String calcWFProcRoleName(PSWFProcRole pSWFProcRole) throws Exception {
        if (StringHelper.compare((String)pSWFProcRole.getRoleType(), (String)"WFROLE", (boolean)true) == 0) {
            return pSWFProcRole.getPSWFRoleName();
        }
        WFProcRoleTypeCodeListModel wFProcRoleTypeCodeListModel = (WFProcRoleTypeCodeListModel)CodeListGlobal.getCodeList((String)WFProcRoleTypeCodeListModel.class.getCanonicalName());
        return "[" + wFProcRoleTypeCodeListModel.getCodeListText(pSWFProcRole.getRoleType(), false) + "]";
    }
}

