/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSAppUtilPage;
import SA.SRFDA.PS.Core.App.PSAppUtilPageImpl;
import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Data.PSAppUtilPage;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppUtilPageGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppUtilPage, IPSAppUtilPage> {
    private static final Log log = LogFactory.getLog(PSAppUtilPageGlobalModel.class);

    @Override
    protected PSAppUtilPage GetObject(String strPSAppUtilPageId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSAppUtilPage psAppUtilPage = new PSAppUtilPage();
        CallResult callResult = this.iPSModelHelper.getPSAppUtilPage(strPSAppUtilPageId, psAppUtilPage);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u529f\u80fd\u9875\u9762[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppUtilPageId, (Object)callResult.getErrorInfo()));
            return null;
        }
        if (StringHelper.Compare((String)this.getPSApplication().getId(), (String)psAppUtilPage.getPSSYSAPPID(), (boolean)false) != 0) {
            return null;
        }
        return psAppUtilPage;
    }

    @Override
    protected IPSAppUtilPage OnCreateModelHelper(PSAppUtilPage vt, String strId) throws Exception {
        if (StringHelper.Compare((String)strId, (String)vt.getPSAPPUTILPAGEID(), (boolean)false) == 0) {
            PSAppUtilPageImpl iPSAppUtilPage = new PSAppUtilPageImpl();
            iPSAppUtilPage.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
            return iPSAppUtilPage;
        }
        return (IPSAppUtilPage)this.FindModelHelper(vt.getPSAPPUTILPAGEID());
    }

    @Override
    protected Boolean TestObjectRenew(PSAppUtilPage obj) {
        return false;
    }

    @Override
    protected IPSAppUtilPage registerModel(PSAppUtilPage vt) throws Exception {
        IPSAppUtilPage iPSAppUtilPage = (IPSAppUtilPage)this.InternalGetModelHelper(vt.getPSAPPUTILPAGEID());
        if (iPSAppUtilPage != null) {
            return iPSAppUtilPage;
        }
        this.setModel(vt.getPSAPPUTILPAGEID(), vt, null);
        iPSAppUtilPage = (IPSAppUtilPage)this.FindModelHelper(vt.getPSAPPUTILPAGEID());
        return iPSAppUtilPage;
    }

    @Override
    protected Vector<PSAppUtilPage> getAllModels() throws Exception {
        Vector<PSAppUtilPage> list = new Vector<PSAppUtilPage>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppUtilPages(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u529f\u80fd\u9875\u9762\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppUtilPage psAppUtilPage : list) {
            this.setModel(psAppUtilPage.getPSAPPUTILPAGEID(), psAppUtilPage, null);
            if (psAppUtilPage.getPSAPPUTILPAGEID().indexOf("S") != 0) continue;
            this.setModel(KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)psAppUtilPage.getPSAPPUTILPAGENAME()), psAppUtilPage, null);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSAppUtilPage vt) {
        return vt.getPSAPPUTILPAGEID();
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
        return PSApplicationException.create(this.getPSApplication(), 40005, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSAppUtilPage vt) {
        String strUniqueId;
        String strUtilType = vt.getUTILTYPE();
        if (StringHelper.IsNullOrEmpty((String)strUtilType)) {
            strUtilType = vt.getPSAPPUTILPAGENAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)strUtilType) && strUtilType.indexOf("USER") != 0 && StringHelper.Compare((String)(strUniqueId = KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)strUtilType)), (String)vt.getPSAPPUTILPAGEID(), (boolean)false) != 0) {
            return new String[]{strUniqueId.toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

