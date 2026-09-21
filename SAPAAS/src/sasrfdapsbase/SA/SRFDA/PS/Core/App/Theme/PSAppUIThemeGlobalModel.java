/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Theme;

import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Core.App.Theme.IPSAppUITheme;
import SA.SRFDA.PS.Core.App.Theme.PSAppUIThemeImpl;
import SA.SRFDA.PS.Data.PSAppUITheme;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppUIThemeGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppUITheme, IPSAppUITheme> {
    private static final Log log = LogFactory.getLog(PSAppUIThemeGlobalModel.class);

    @Override
    protected PSAppUITheme GetObject(String strPSAppUIThemeId) {
        PSAppUITheme psAppUITheme = new PSAppUITheme();
        CallResult callResult = this.iPSModelHelper.getPSAppUITheme(strPSAppUIThemeId, psAppUITheme);
        if (callResult.isError()) {
            String strInfo = StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u754c\u9762\u4e3b\u9898[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppUIThemeId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, this.getPSApplication(), strInfo);
            return null;
        }
        return psAppUITheme;
    }

    @Override
    protected IPSAppUITheme OnCreateModelHelper(PSAppUITheme vt) throws Exception {
        PSAppUIThemeImpl iPSAppUITheme = new PSAppUIThemeImpl();
        iPSAppUITheme.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppUITheme;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppUITheme obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSAppUITheme vt) {
        return vt.getPSAPPUITHEMEID();
    }

    @Override
    protected IPSAppUITheme registerModel(PSAppUITheme vt) throws Exception {
        IPSAppUITheme iPSAppUITheme = (IPSAppUITheme)this.InternalGetModelHelper(vt.getPSAPPUITHEMEID());
        if (iPSAppUITheme != null) {
            return iPSAppUITheme;
        }
        this.setModel(vt.getPSAPPUITHEMEID(), vt, null);
        return (IPSAppUITheme)this.FindModelHelper(vt.getPSAPPUITHEMEID());
    }

    @Override
    protected Vector<PSAppUITheme> getAllModels() throws Exception {
        Vector<PSAppUITheme> list = new Vector<PSAppUITheme>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppUIThemes(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u754c\u9762\u4e3b\u9898\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppUITheme psAppUITheme : list) {
            this.setModel(psAppUITheme.getPSAPPUITHEMEID(), psAppUITheme, null);
        }
        return list;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSApplicationException.create(this.getPSApplication(), 40014, objObjectId);
    }
}

