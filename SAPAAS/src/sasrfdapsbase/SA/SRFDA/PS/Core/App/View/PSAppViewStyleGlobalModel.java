/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Core.App.View.IPSAppViewStyle;
import SA.SRFDA.PS.Core.App.View.PSAppViewStyleImpl;
import SA.SRFDA.PS.Data.PSAppViewStyle;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppViewStyleGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppViewStyle, IPSAppViewStyle> {
    private static final Log log = LogFactory.getLog(PSAppViewStyleGlobalModel.class);

    @Override
    protected PSAppViewStyle GetObject(String strPSAppViewStyleId) {
        PSAppViewStyle psAppViewStyle = new PSAppViewStyle();
        CallResult callResult = this.iPSModelHelper.getPSAppViewStyle(strPSAppViewStyleId, psAppViewStyle);
        if (callResult.isError()) {
            String strInfo = StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u89c6\u56fe\u6837\u5f0f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppViewStyleId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSSystemUtil().log(1, this.getPSApplication(), strInfo);
            return null;
        }
        return psAppViewStyle;
    }

    @Override
    protected IPSAppViewStyle OnCreateModelHelper(PSAppViewStyle vt) throws Exception {
        PSAppViewStyleImpl iPSAppViewStyle = new PSAppViewStyleImpl();
        iPSAppViewStyle.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppViewStyle;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppViewStyle obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSAppViewStyle vt) {
        return vt.getPSAPPVIEWSTYLEID();
    }
}

