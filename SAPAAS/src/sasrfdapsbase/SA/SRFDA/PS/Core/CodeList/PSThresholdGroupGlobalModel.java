/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.CodeList;

import SA.SRFDA.PS.Core.CodeList.IPSThresholdGroup;
import SA.SRFDA.PS.Core.CodeList.PSThresholdGroupImpl;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.PSSystemException;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSThresholdGroup;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSThresholdGroupGlobalModel
extends PSSystemGlobalModelBase<String, PSThresholdGroup, IPSThresholdGroup> {
    private static final Log log = LogFactory.getLog(PSThresholdGroupGlobalModel.class);
    protected IPSModelHelper iPSModelHelper = null;

    @Override
    protected CallResult OnInit() {
        this.bEnableEmptyMap = true;
        CallResult callResult = super.OnInit();
        if (callResult.isError()) {
            return callResult;
        }
        try {
            this.iPSModelHelper = PSObjectFactory.getPSModelHelper(this.iDAGlobalHelper, this.getPSSystem().getPSSysModelInstId());
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u9608\u503c\u7ec4\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    @Override
    protected PSThresholdGroup GetObject(String strPSThresholdGroupId) {
        PSThresholdGroup psCodeList = new PSThresholdGroup();
        CallResult callResult = this.iPSModelHelper.getPSThresholdGroup(strPSThresholdGroupId, psCodeList);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u9608\u503c\u7ec4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSThresholdGroupId, (Object)callResult.getErrorInfo()));
            return null;
        }
        if (StringHelper.Compare((String)this.getPSSystem().getId(), (String)psCodeList.getPSSYSTEMID(), (boolean)false) != 0) {
            return null;
        }
        return psCodeList;
    }

    @Override
    protected IPSThresholdGroup OnCreateModelHelper(PSThresholdGroup vt) throws Exception {
        PSThresholdGroupImpl iPSThresholdGroup = null;
        iPSThresholdGroup = new PSThresholdGroupImpl();
        iPSThresholdGroup.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSThresholdGroup;
    }

    @Override
    protected Boolean TestObjectRenew(PSThresholdGroup obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSThresholdGroup registerModel(PSThresholdGroup vt) throws Exception {
        IPSThresholdGroup iIPSThresholdGroup = (IPSThresholdGroup)this.InternalGetModelHelper(vt.getPSTHRESHOLDGROUPID());
        if (iIPSThresholdGroup != null) {
            return iIPSThresholdGroup;
        }
        this.setModel(vt.getPSTHRESHOLDGROUPID(), vt, null);
        return (IPSThresholdGroup)this.FindModelHelper(vt.getPSTHRESHOLDGROUPID());
    }

    @Override
    protected Vector<PSThresholdGroup> getAllModels() throws Exception {
        Vector<PSThresholdGroup> list = new Vector<PSThresholdGroup>();
        CallResult callResult = this.iPSModelHelper.getAllPSThresholdGroups(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u9608\u503c\u7ec4\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSThresholdGroup> codeListMap = new HashMap<String, PSThresholdGroup>();
        for (PSThresholdGroup psCodeList : list) {
            this.setModel(psCodeList.getPSTHRESHOLDGROUPID(), psCodeList, null);
            codeListMap.put(psCodeList.getPSTHRESHOLDGROUPID(), psCodeList);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSThresholdGroup vt) {
        return vt.getPSTHRESHOLDGROUPID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSSystemException.create(this.getPSSystem(), 10007, objObjectId);
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModels();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSThresholdGroup vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

