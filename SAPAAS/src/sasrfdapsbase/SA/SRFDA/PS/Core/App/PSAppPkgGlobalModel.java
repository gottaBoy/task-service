/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSAppPkg;
import SA.SRFDA.PS.Core.App.PSAppPkgImpl;
import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Data.PSAppPkg;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppPkgGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppPkg, IPSAppPkg> {
    private static final Log log = LogFactory.getLog(PSAppPkgGlobalModel.class);

    @Override
    protected PSAppPkg GetObject(String strPSAppPkgId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSAppPkg psAppPkg = new PSAppPkg();
        CallResult callResult = this.iPSModelHelper.getPSAppPkg(strPSAppPkgId, psAppPkg);
        if (callResult.isError()) {
            String strInfo = StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u7ec4\u4ef6\u5305[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppPkgId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, this.getPSApplication(), strInfo);
            return null;
        }
        if (StringHelper.Compare((String)this.getPSApplication().getId(), (String)psAppPkg.getPSSYSAPPID(), (boolean)false) != 0) {
            return null;
        }
        return psAppPkg;
    }

    @Override
    protected IPSAppPkg OnCreateModelHelper(PSAppPkg vt) throws Exception {
        PSAppPkgImpl iPSAppPkg = new PSAppPkgImpl();
        iPSAppPkg.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppPkg;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppPkg obj) {
        return false;
    }

    @Override
    protected IPSAppPkg registerModel(PSAppPkg vt) throws Exception {
        IPSAppPkg iPSAppPkg = (IPSAppPkg)this.InternalGetModelHelper(vt.getPSAPPPKGID());
        if (iPSAppPkg != null) {
            return iPSAppPkg;
        }
        this.setModel(vt.getPSAPPPKGID(), vt, null);
        return (IPSAppPkg)this.FindModelHelper(vt.getPSAPPPKGID());
    }

    @Override
    protected Vector<PSAppPkg> getAllModels() throws Exception {
        Vector<PSAppPkg> list = new Vector<PSAppPkg>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppPkgs(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u7ec4\u4ef6\u5305\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppPkg psAppPkg : list) {
            this.setModel(psAppPkg.getPSAPPPKGID(), psAppPkg, null);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSAppPkg vt) {
        return vt.getPSAPPPKGID();
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
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSApplicationException.create(this.getPSApplication(), 40007, objObjectId);
    }
}

