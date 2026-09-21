/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WS.Ctrl;

import SA.SRFDA.WS.Ctrl.BaseWSGlobalModel;
import SA.SRFDA.WS.Ctrl.Data.WSPageType;
import SA.SRFDA.WS.Ctrl.IWSModelHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WSPageTypeGlobalModel
extends BaseWSGlobalModel<String, WSPageType, IWSModelHelper> {
    private static final Log log = LogFactory.getLog(WSPageTypeGlobalModel.class);

    @Override
    protected WSPageType GetObject(String objObjectId) {
        WSPageType wsPageType = new WSPageType();
        CallResult callRsult = this.iWSModelHelper.GetWSPageType(objObjectId, wsPageType);
        if (callRsult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6[%3$s]\u6570\u636e\u5bf9\u8c61[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callRsult.getErrorInfo(), (Object)((Object)((Object)wsPageType)).getClass().getName()));
            return null;
        }
        return wsPageType;
    }
}

