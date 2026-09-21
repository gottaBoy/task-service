/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpPrj;
import SA.SRFDA.PS.Core.Help.IPSHelpPrjType;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSHelpModule;
import SA.SRFDA.PS.Data.PSHelpPrj;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpPrjGlobalModel
extends PSSystemGlobalModelBase<String, PSHelpPrj, IPSHelpPrj> {
    private static final Log log = LogFactory.getLog(PSHelpPrjGlobalModel.class);

    @Override
    protected PSHelpPrj GetObject(String strPSHelpPrjId) {
        return null;
    }

    @Override
    protected IPSHelpPrj OnCreateModelHelper(PSHelpPrj vt) throws Exception {
        String strPrjType = vt.getPRJTYPE();
        if (StringHelper.IsNullOrEmpty((String)strPrjType)) {
            strPrjType = "COMMON";
        }
        IPSHelpPrjType iPSHelpPrjType = this.iPSModelStorage.getPSHelpPrjType(strPrjType);
        IPSHelpPrj iPSHelpPrj = iPSHelpPrjType.createPSHelpPrj(vt);
        iPSHelpPrj.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSHelpPrj;
    }

    @Override
    protected Boolean TestObjectRenew(PSHelpPrj obj) {
        return false;
    }

    @Override
    protected IPSHelpPrj registerModel(PSHelpPrj vt) throws Exception {
        IPSHelpPrj iPSHelpPrj = (IPSHelpPrj)this.InternalGetModelHelper(vt.getPSHELPPRJID());
        if (iPSHelpPrj != null) {
            return iPSHelpPrj;
        }
        this.setModel(vt.getPSHELPPRJID(), vt, null);
        iPSHelpPrj = (IPSHelpPrj)this.FindModelHelper(vt.getPSHELPPRJID());
        return iPSHelpPrj;
    }

    @Override
    protected void onPreloadModels() {
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected Vector<PSHelpPrj> getAllModels() throws Exception {
        Vector<PSHelpPrj> list = new Vector<PSHelpPrj>();
        CallResult callResult = this.iPSModelHelper.getAllPSHelpPrjs(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5e2e\u52a9\u9879\u76ee\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<PSHelpModule> list2 = new Vector<PSHelpModule>();
        callResult = this.iPSModelHelper.getAllPSHelpModules(this.iPSSystem.getId(), list2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5e2e\u52a9\u7ae0\u8282\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSHelpPrj> psHelpPrjMap = new HashMap<String, PSHelpPrj>();
        for (PSHelpPrj psHelpPrj : list) {
            psHelpPrjMap.put(psHelpPrj.getPSHELPPRJID(), psHelpPrj);
        }
        HashMap<String, PSHelpModule> psHelpModuleMap = new HashMap<String, PSHelpModule>();
        for (PSHelpModule psHelpModule : list2) {
            psHelpModuleMap.put(psHelpModule.getPSHELPMODULEID(), psHelpModule);
        }
        for (PSHelpModule psHelpModule : list2) {
            if (StringHelper.IsNullOrEmpty((String)psHelpModule.getPPSHELPMODULEID())) {
                PSHelpPrj psHelpPrj = (PSHelpPrj)((Object)psHelpPrjMap.get(psHelpModule.getPSHELPPRJID()));
                if (psHelpPrj == null) continue;
                psHelpPrj.getRootPSHelpModules(true).add(psHelpModule);
                continue;
            }
            PSHelpModule parentPSHelpModule = (PSHelpModule)((Object)psHelpModuleMap.get(psHelpModule.getPPSHELPMODULEID()));
            if (parentPSHelpModule == null) continue;
            parentPSHelpModule.getChildPSHelpModules(true).add(psHelpModule);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSHelpPrj vt) {
        return vt.getPSHELPPRJID();
    }
}

