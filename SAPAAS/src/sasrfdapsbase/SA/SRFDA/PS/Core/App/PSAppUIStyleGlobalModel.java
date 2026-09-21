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

import SA.SRFDA.PS.Core.App.IPSAppUIStyle;
import SA.SRFDA.PS.Core.App.PSAppUIStyleImpl;
import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Data.PSAppUIStyle;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppUIStyleGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppUIStyle, IPSAppUIStyle> {
    private static final Log log = LogFactory.getLog(PSAppUIStyleGlobalModel.class);

    @Override
    protected PSAppUIStyle GetObject(String strPSAppUIStyleId) {
        PSAppUIStyle psAppUIStyle = new PSAppUIStyle();
        CallResult callResult = this.iPSModelHelper.getPSAppUIStyle(strPSAppUIStyleId, psAppUIStyle);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u754c\u9762\u6a21\u5f0f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppUIStyleId, (Object)callResult.getErrorInfo()));
            return null;
        }
        if (StringHelper.Compare((String)this.getPSApplication().getId(), (String)psAppUIStyle.getPSSYSAPPID(), (boolean)false) != 0) {
            return null;
        }
        return psAppUIStyle;
    }

    @Override
    protected IPSAppUIStyle OnCreateModelHelper(PSAppUIStyle vt) throws Exception {
        PSAppUIStyleImpl iPSAppUIStyle = new PSAppUIStyleImpl();
        iPSAppUIStyle.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppUIStyle;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppUIStyle obj) {
        return false;
    }

    @Override
    protected IPSAppUIStyle registerModel(PSAppUIStyle vt) throws Exception {
        IPSAppUIStyle iPSAppUIStyle = (IPSAppUIStyle)this.InternalGetModelHelper(vt.getPSAPPUISTYLEID());
        if (iPSAppUIStyle != null) {
            return iPSAppUIStyle;
        }
        this.setModel(vt.getPSAPPUISTYLEID(), vt, null);
        return (IPSAppUIStyle)this.FindModelHelper(vt.getPSAPPUISTYLEID());
    }

    @Override
    protected Vector<PSAppUIStyle> getAllModels() throws Exception {
        Vector<PSAppUIStyle> list = new Vector<PSAppUIStyle>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppUIStyles(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u754c\u9762\u6a21\u5f0f\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppUIStyle psAppUIStyle : list) {
            this.setModel(psAppUIStyle.getPSAPPUISTYLEID(), psAppUIStyle, null);
            this.setModel(psAppUIStyle.getUISTYLE(), psAppUIStyle, null);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSAppUIStyle vt) {
        return vt.getPSAPPUISTYLEID();
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
        return PSApplicationException.create(this.getPSApplication(), 40013, objObjectId);
    }
}

