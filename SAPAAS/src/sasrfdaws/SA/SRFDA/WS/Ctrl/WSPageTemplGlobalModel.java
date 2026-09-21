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
import SA.SRFDA.WS.Ctrl.Data.WSPageTempl;
import SA.SRFDA.WS.Ctrl.IWSModelHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WSPageTemplGlobalModel
extends BaseWSGlobalModel<String, WSPageTempl, IWSModelHelper> {
    private static final Log log = LogFactory.getLog(WSPageTemplGlobalModel.class);

    @Override
    protected WSPageTempl GetObject(String objObjectId) {
        WSPageTempl wsPageTempl = new WSPageTempl();
        CallResult callRsult = this.iWSModelHelper.GetWSPageTempl(objObjectId, wsPageTempl);
        if (callRsult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6[%3$s]\u6570\u636e\u5bf9\u8c61[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callRsult.getErrorInfo(), (Object)((Object)((Object)wsPageTempl)).getClass().getName()));
            return null;
        }
        return wsPageTempl;
    }
}

