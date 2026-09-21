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
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.App.WF.PSAppWFVerImpl;
import SA.SRFDA.PS.Data.PSAppWFVer;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppWFVerGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppWFVer, IPSAppWFVer> {
    private static final Log log = LogFactory.getLog(PSAppWFVerGlobalModel.class);

    @Override
    protected PSAppWFVer GetObject(String strPSAppWFVerId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSAppWFVer psAppWFVer = new PSAppWFVer();
        CallResult callResult = this.iPSModelHelper.getPSAppWFVer(strPSAppWFVerId, psAppWFVer);
        if (callResult.isError()) {
            String strInfo = StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u5de5\u4f5c\u6d41\u7248\u672c[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppWFVerId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, this.getPSApplication(), strInfo);
            return null;
        }
        if (StringHelper.Compare((String)this.getPSApplication().getId(), (String)psAppWFVer.getPSSYSAPPID(), (boolean)false) != 0) {
            return null;
        }
        return psAppWFVer;
    }

    @Override
    protected IPSAppWFVer OnCreateModelHelper(PSAppWFVer vt) throws Exception {
        PSAppWFVerImpl iPSAppWFVer = new PSAppWFVerImpl();
        iPSAppWFVer.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppWFVer;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppWFVer obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSAppWFVer vt) {
        return vt.getPSAPPWFVERID();
    }

    @Override
    protected IPSAppWFVer registerModel(PSAppWFVer vt) throws Exception {
        IPSAppWFVer iPSAppWFVer = (IPSAppWFVer)this.InternalGetModelHelper(vt.getPSAPPWFVERID());
        if (iPSAppWFVer != null) {
            return iPSAppWFVer;
        }
        this.setModel(vt.getPSAPPWFVERID(), vt, null);
        return (IPSAppWFVer)this.FindModelHelper(vt.getPSAPPWFVERID());
    }

    @Override
    protected Vector<PSAppWFVer> getAllModels() throws Exception {
        Vector<PSAppWFVer> list = new Vector<PSAppWFVer>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppWFVers(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u529f\u80fd\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppWFVer psAppWFVer : list) {
            this.setModel(psAppWFVer.getPSAPPWFVERID(), psAppWFVer, null);
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
            this.getPSSystemUtil().getPSSysConsole().error(this.getPSApplication().getFullModelName(), StringHelper.Format((String)"\u52a0\u8f7d\u5e94\u7528\u529f\u80fd\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
        }
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSApplicationException.create(this.getPSApplication(), 40017, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSAppWFVer vt) {
        return new String[]{vt.getPSWFVERSIONID().toUpperCase()};
    }
}

