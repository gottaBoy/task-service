/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.CloneSessionManager
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.wfdesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.CloneSessionManager;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcRole;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSWFProcessService
extends PSWFProcessServiceBase {
    private static final Log log = LogFactory.getLog(PSWFProcessService.class);

    protected boolean onFillEntityKeyValue(PSWFProcess pSWFProcess, boolean bl) throws Exception {
        if (StringHelper.compare((String)pSWFProcess.getWFProcessType(), (String)"START", (boolean)true) == 0) {
            pSWFProcess.setPSWFProcessId(pSWFProcess.getPSWFVersionId());
            return true;
        }
        return super.onFillEntityKeyValue((IEntity)pSWFProcess, bl);
    }

    @Override
    protected void onFillParentInfo_PSWFVersion(PSWFProcess pSWFProcess, PSWFVersion pSWFVersion) throws Exception {
        super.onFillParentInfo_PSWFVersion(pSWFProcess, pSWFVersion);
        pSWFProcess.setPSWFId(pSWFVersion.getPSWFId());
        pSWFProcess.setPSWFName(pSWFVersion.getPSWFName());
        pSWFProcess.setPSSystemId(pSWFVersion.getPSSystemId());
    }

    @Override
    protected void onBeforeCreateTemp(PSWFProcess pSWFProcess) throws Exception {
        super.onBeforeCreateTemp(pSWFProcess);
        if (StringHelper.isNullOrEmpty((String)pSWFProcess.getCodeName())) {
            pSWFProcess.setCodeName(this.calcPSWFProcessCodeName(pSWFProcess));
        }
    }

    protected String calcPSWFProcessCodeName(PSWFProcess pSWFProcess) throws Exception {
        String string = pSWFProcess.getWFProcessType();
        string = string.toLowerCase();
        string = string.substring(0, 1).toUpperCase() + string.substring(1);
        PSWFVersion pSWFVersion = new PSWFVersion();
        pSWFVersion.setPSWFVersionId(pSWFProcess.getPSWFVersionId());
        ArrayList<PSWFProcess> arrayList = this.selectTempByPSWFVersion(pSWFVersion);
        HashMap<String, PSWFProcess> hashMap = new HashMap<String, PSWFProcess>();
        for (PSWFProcess object2 : arrayList) {
            hashMap.put(object2.getCodeName().toLowerCase(), object2);
        }
        int n = 1;
        String string2 = "";
        String string3;
        while (hashMap.containsKey((string3 = StringHelper.format((String)"%1$s%2$03d", (Object)string, (Object)n)).toLowerCase())) {
            ++n;
        }
        return string3;
    }

    @Override
    public String getModelV2Tag(PSWFProcess pSWFProcess) {
        if (!StringHelper.isNullOrEmpty((String)pSWFProcess.getCodeName())) {
            return pSWFProcess.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSWFProcess.getPSWFProcessName())) {
            return pSWFProcess.getPSWFProcessName();
        }
        return super.getModelV2Tag(pSWFProcess);
    }

    @Override
    protected void getRelatedDataTempMajor_PSWFProcRole(PSWFProcess pSWFProcess) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSWFVERSION", (boolean)true) == 0) {
            return;
        }
        super.getRelatedDataTempMajor_PSWFProcRole(pSWFProcess);
    }

    @Override
    protected ArrayList<PSWFProcRole> updateRelatedDataTempMajor_removePSWFProcRole(PSWFProcess pSWFProcess, PSWFProcess pSWFProcess2) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSWFVERSION", (boolean)true) == 0) {
            return null;
        }
        return super.updateRelatedDataTempMajor_removePSWFProcRole(pSWFProcess, pSWFProcess2);
    }

    @Override
    protected void updateRelatedDataTempMajor_updatePSWFProcRole(PSWFProcess pSWFProcess, PSWFProcess pSWFProcess2, ArrayList<PSWFProcRole> arrayList) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSWFVERSION", (boolean)true) == 0) {
            return;
        }
        super.updateRelatedDataTempMajor_updatePSWFProcRole(pSWFProcess, pSWFProcess2, arrayList);
    }
}

