/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF.UIAction;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIActionGroup;
import SA.SRFDA.PS.Core.WF.UIAction.PSWFUIActionGroupImpl;
import SA.SRFDA.PS.Data.PSDEUIActionGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFUIActionGroupGlobalModel
extends PSGlobalModelBase<String, PSDEUIActionGroup, IPSWFUIActionGroup> {
    private static final Log log = LogFactory.getLog(PSWFUIActionGroupGlobalModel.class);
    protected IPSWFVersion iPSWFVersion = null;
    protected IPSWorkflow iPSWorkflow = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWFVersion iPSWFVersion) {
        this.iPSWFVersion = iPSWFVersion;
        this.iPSWorkflow = this.iPSWFVersion.getPSWorkflow();
        return super.Init(iDAGlobalHelper);
    }

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWorkflow iPSWorkflow) {
        this.iPSWorkflow = iPSWorkflow;
        return super.Init(iDAGlobalHelper);
    }

    @Override
    protected PSDEUIActionGroup GetObject(String strPSDEUIActionGroupId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u6d41\u7a0b\u754c\u9762\u884c\u4e3a\u7ec4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEUIActionGroupId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSWFUIActionGroup OnCreateModelHelper(PSDEUIActionGroup vt) throws Exception {
        PSWFUIActionGroupImpl iPSWFUIActionGroup = new PSWFUIActionGroupImpl();
        iPSWFUIActionGroup.init(this.iDAGlobalHelper, this.iPSWorkflow, this.iPSWFVersion, vt);
        return iPSWFUIActionGroup;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEUIActionGroup obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected Vector<PSDEUIActionGroup> getAllModels() throws Exception {
        Vector<PSDEUIActionGroup> psDEUIActionGroupList = new Vector<PSDEUIActionGroup>();
        CallResult callResult = null;
        callResult = this.iPSWFVersion != null ? this.iPSModelHelper.getPSWFUIActionGroups(this.iPSWFVersion.getId(), psDEUIActionGroupList) : this.iPSModelHelper.getPSWFUIActionGroups2(this.iPSWorkflow.getId(), psDEUIActionGroupList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6d41\u7a0b\u754c\u9762\u884c\u4e3a\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDEUIActionGroup> deuaGroupMap = new HashMap<String, PSDEUIActionGroup>();
        for (PSDEUIActionGroup psDEUIActionGroup : psDEUIActionGroupList) {
            this.setModel(psDEUIActionGroup.getPSDEUAGROUPID(), psDEUIActionGroup, null);
            deuaGroupMap.put(psDEUIActionGroup.getPSDEUAGROUPID(), psDEUIActionGroup);
        }
        for (PSDEUIActionGroup psDEUIActionGroup : psDEUIActionGroupList) {
            if (StringHelper.IsNullOrEmpty((String)psDEUIActionGroup.getUAGTAG()) || StringHelper.IsNullOrEmpty((String)psDEUIActionGroup.getPSWFPROCESSID())) continue;
            String strKey = "";
            if (StringHelper.Compare((String)psDEUIActionGroup.getUAGTAG(), (String)"IAACTION", (boolean)false) == 0) {
                if (StringHelper.IsNullOrEmpty((String)psDEUIActionGroup.getUAGTAG2())) {
                    strKey = psDEUIActionGroup.getPSWFPROCESSID();
                } else if (StringHelper.Compare((String)psDEUIActionGroup.getUAGTAG2(), (String)"MOB", (boolean)false) == 0) {
                    strKey = KeyValueHelper.genUniqueId((String)"MOB", (String)psDEUIActionGroup.getPSWFPROCESSID());
                }
            } else if (StringHelper.Compare((String)psDEUIActionGroup.getUAGTAG(), (String)"PDACTION", (boolean)false) == 0) {
                if (StringHelper.IsNullOrEmpty((String)psDEUIActionGroup.getUAGTAG2())) {
                    strKey = KeyValueHelper.genUniqueId((String)psDEUIActionGroup.getPSWFPROCESSID(), (String)psDEUIActionGroup.getUAGTAG3());
                } else if (StringHelper.Compare((String)psDEUIActionGroup.getUAGTAG2(), (String)"MOB", (boolean)false) == 0) {
                    strKey = KeyValueHelper.genUniqueId((String)"MOB", (String)psDEUIActionGroup.getPSWFPROCESSID(), (String)psDEUIActionGroup.getUAGTAG3());
                }
            }
            if (StringHelper.IsNullOrEmpty((String)strKey) || StringHelper.Compare((String)strKey, (String)psDEUIActionGroup.getPSDEUAGROUPID(), (boolean)false) == 0 || deuaGroupMap.containsKey(strKey)) continue;
            this.setModel(strKey, psDEUIActionGroup, null);
            deuaGroupMap.put(strKey, psDEUIActionGroup);
        }
        return psDEUIActionGroupList;
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.iPSWFVersion != null) {
            return this.iPSWFVersion.getPSSysModelInstId();
        }
        return this.iPSWorkflow.getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSDEUIActionGroup vt) {
        return vt.getPSDEUAGROUPID();
    }

    @Override
    protected IPSWFUIActionGroup registerModel(PSDEUIActionGroup vt) throws Exception {
        IPSWFUIActionGroup iPSWFUIActionGroup = (IPSWFUIActionGroup)this.InternalGetModelHelper(vt.getPSDEUAGROUPID());
        if (iPSWFUIActionGroup != null) {
            return iPSWFUIActionGroup;
        }
        this.setModel(vt.getPSDEUAGROUPID(), vt, null);
        return (IPSWFUIActionGroup)this.FindModelHelper(vt.getPSDEUAGROUPID());
    }
}

