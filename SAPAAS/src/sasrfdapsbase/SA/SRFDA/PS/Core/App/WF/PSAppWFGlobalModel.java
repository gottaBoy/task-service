/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.WF;

import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.PSAppWFImpl;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Data.PSAppWF;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppWFGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppWF, IPSAppWF> {
    private static final Log log = LogFactory.getLog(PSAppWFGlobalModel.class);

    @Override
    protected PSAppWF GetObject(String strPSAppWFId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSAppWF psAppWF = new PSAppWF();
        CallResult callResult = this.iPSModelHelper.getPSAppWF(strPSAppWFId, psAppWF);
        if (callResult.isError()) {
            String strInfo = StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u5de5\u4f5c\u6d41[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppWFId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, this.getPSApplication(), strInfo);
            return null;
        }
        if (StringHelper.Compare((String)this.getPSApplication().getId(), (String)psAppWF.getPSSYSAPPID(), (boolean)false) != 0) {
            return null;
        }
        return psAppWF;
    }

    @Override
    protected IPSAppWF OnCreateModelHelper(PSAppWF vt) throws Exception {
        PSAppWFImpl iPSAppWF = new PSAppWFImpl();
        iPSAppWF.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppWF;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppWF obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSAppWF vt) {
        return vt.getPSAPPWFID();
    }

    @Override
    protected IPSAppWF registerModel(PSAppWF vt) throws Exception {
        IPSAppWF iPSAppWF = (IPSAppWF)this.InternalGetModelHelper(vt.getPSAPPWFID());
        if (iPSAppWF != null) {
            return iPSAppWF;
        }
        this.setModel(vt.getPSAPPWFID(), vt, null);
        return (IPSAppWF)this.FindModelHelper(vt.getPSAPPWFID());
    }

    @Override
    protected Vector<PSAppWF> getAllModels() throws Exception {
        Vector<PSAppWF> list = new Vector<PSAppWF>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppWFs(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u5de5\u4f5c\u6d41\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppWF psAppWF : list) {
            this.setModel(psAppWF.getPSAPPWFID(), psAppWF, null);
        }
        return list;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            this.getPSSystemUtil().getPSSysConsole().error(this.getPSApplication().getFullModelName(), StringHelper.Format((String)"\u52a0\u8f7d\u5e94\u7528\u5de5\u4f5c\u6d41\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
        }
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSApplicationException.create(this.getPSApplication(), 40016, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSAppWF vt) {
        return new String[]{vt.getPSWORKFLOWID().toUpperCase()};
    }

    @Override
    public IPSAppWF FindModelHelper(String objObjectId, boolean bTryMode) throws Exception {
        IPSAppWF iPSAppWF = (IPSAppWF)super.FindModelHelper(objObjectId, true);
        if (iPSAppWF != null) {
            return iPSAppWF;
        }
        IPSWorkflow iPSWorkflow = this.getPSApplication().getPSSystem().getPSWorkflow(objObjectId, true);
        if (iPSWorkflow != null) {
            PSAppWF psAppWF = new PSAppWF();
            psAppWF.setPSAPPWFID(iPSWorkflow.getId());
            psAppWF.setPSAPPWFNAME(iPSWorkflow.getName());
            psAppWF.setPSSYSAPPID(this.getPSApplication().getId());
            psAppWF.setPSSYSAPPNAME(this.getPSApplication().getName());
            psAppWF.setPSWORKFLOWID(iPSWorkflow.getId());
            psAppWF.setPSWORKFLOWNAME(iPSWorkflow.getName());
            psAppWF.setVALIDFLAG(true);
            iPSAppWF = this.OnCreateModelHelper(psAppWF);
            this.setModel(objObjectId, psAppWF, iPSAppWF);
            this.internalAddAllModelHelper(iPSAppWF);
            return iPSAppWF;
        }
        if (bTryMode) {
            return null;
        }
        return (IPSAppWF)super.FindModelHelper(objObjectId, bTryMode);
    }
}

