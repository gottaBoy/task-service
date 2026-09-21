/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Requirement;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqModule;
import SA.SRFDA.PS.Core.Requirement.PSSysReqModuleImpl;
import SA.SRFDA.PS.Data.PSSysReqModule;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysReqModuleGlobalModel
extends PSSystemGlobalModelBase<String, PSSysReqModule, IPSSysReqModule> {
    private static final Log log = LogFactory.getLog(PSSysReqModuleGlobalModel.class);
    private IPSSysReqModule iPSSysReqModule = null;
    private ArrayList<IPSSysReqModule> allPSSysReqModuleList = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysReqModule iPSSysReqModule) {
        this.iPSSysReqModule = iPSSysReqModule;
        return super.Init(iDAGlobalHelper, this.getPSSysReqModule().getPSSystem());
    }

    public IPSSysReqModule getPSSysReqModule() {
        return this.iPSSysReqModule;
    }

    @Override
    protected PSSysReqModule GetObject(String strPSSysReqModuleId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSSysReqModule psSysReqModule = new PSSysReqModule();
        CallResult callResult = this.iPSModelHelper.getPSSysReqModule(strPSSysReqModuleId, psSysReqModule);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u9700\u6c42\u6a21\u5757[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysReqModuleId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysReqModule;
    }

    @Override
    protected IPSSysReqModule OnCreateModelHelper(PSSysReqModule vt) throws Exception {
        PSSysReqModuleImpl iPSSysReqModule = new PSSysReqModuleImpl();
        iPSSysReqModule.init(this.iDAGlobalHelper, this.getPSSystem(), this.getPSSysReqModule(), vt);
        return iPSSysReqModule;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysReqModule obj) {
        return false;
    }

    @Override
    protected IPSSysReqModule registerModel(PSSysReqModule vt) throws Exception {
        IPSSysReqModule iPSSysReqModule = (IPSSysReqModule)this.InternalGetModelHelper(vt.getPSSYSREQMODULEID());
        if (iPSSysReqModule != null) {
            return iPSSysReqModule;
        }
        this.setModel(vt.getPSSYSREQMODULEID(), vt, null);
        iPSSysReqModule = (IPSSysReqModule)this.FindModelHelper(vt.getPSSYSREQMODULEID());
        return iPSSysReqModule;
    }

    @Override
    protected void onPreloadModels() {
        try {
            Iterator iterator = this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    protected void fillAllPSSysReqModules(IPSSysReqModule iPSSysReqModule, ArrayList<IPSSysReqModule> psSysReqModuleList) throws Exception {
        psSysReqModuleList.add(iPSSysReqModule);
        Iterator<IPSSysReqModule> psSysReqModules = iPSSysReqModule.getPSSysReqModules();
        if (psSysReqModules != null) {
            while (psSysReqModules.hasNext()) {
                IPSSysReqModule iPSSysReqModule2 = psSysReqModules.next();
                this.fillAllPSSysReqModules(iPSSysReqModule2, psSysReqModuleList);
            }
        }
    }

    @Override
    protected Vector<PSSysReqModule> getAllModels() throws Exception {
        Vector<PSSysReqModule> list = new Vector<PSSysReqModule>();
        if (this.getPSSysReqModule() == null) {
            CallResult callResult = this.iPSModelHelper.getAllPSSysReqModules(this.getPSSystem().getId(), list);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u9700\u6c42\u6a21\u5757\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
            }
        } else {
            CallResult callResult = this.iPSModelHelper.getPSSysReqModules(this.getPSSysReqModule().getId(), list);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u9700\u6c42\u6a21\u5757\u5168\u90e8\u5b50\u6a21\u5757\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
            }
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysReqModule vt) {
        return vt.getPSSYSREQMODULEID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysReqModule vt) {
        if (!net.ibizsys.paas.util.StringHelper.isNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }

    public Iterator<IPSSysReqModule> getAllPSSysReqModules() throws Exception {
        Iterator psSysReqModules;
        if (this.getPSSysReqModule() != null) {
            return null;
        }
        if (this.allPSSysReqModuleList == null && (psSysReqModules = this.getAllModelHelpers()) != null) {
            ArrayList<IPSSysReqModule> psSysReqModuleList = new ArrayList<IPSSysReqModule>();
            while (psSysReqModules.hasNext()) {
                IPSSysReqModule iPSSysReqModule = (IPSSysReqModule)psSysReqModules.next();
                this.fillAllPSSysReqModules(iPSSysReqModule, psSysReqModuleList);
            }
            this.allPSSysReqModuleList = psSysReqModuleList;
        }
        if (this.allPSSysReqModuleList == null || this.allPSSysReqModuleList.size() == 0) {
            return null;
        }
        return this.allPSSysReqModuleList.iterator();
    }
}

