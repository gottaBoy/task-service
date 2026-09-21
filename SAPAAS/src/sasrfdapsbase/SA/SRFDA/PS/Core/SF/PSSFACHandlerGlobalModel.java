/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSFACHandler;
import SA.SRFDA.PS.Core.SF.PSSFACHandlerImpl;
import SA.SRFDA.PS.Core.SF.PSSFGlobalModelBase;
import SA.SRFDA.PS.Data.PSSFACHandler;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFACHandlerGlobalModel
extends PSSFGlobalModelBase<String, PSSFACHandler, IPSSFACHandler> {
    private static final Log log = LogFactory.getLog(PSSFACHandlerGlobalModel.class);

    @Override
    protected PSSFACHandler GetObject(String strPSSFACHandlerId) {
        PSSFACHandler PSSFACHandler2 = new PSSFACHandler();
        CallResult callResult = this.iPSModelHelper.getPSSFACHandler(strPSSFACHandlerId, PSSFACHandler2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u670d\u52a1\u6846\u67b6\u90e8\u4ef6\u5904\u7406\u5bf9\u8c61[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSFACHandlerId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSSFACHandler2;
    }

    @Override
    protected IPSSFACHandler OnCreateModelHelper(PSSFACHandler vt) throws Exception {
        PSSFACHandlerImpl iPSSFACHandler = new PSSFACHandlerImpl();
        iPSSFACHandler.init(this.iDAGlobalHelper, this.getPSSF(), vt);
        return iPSSFACHandler;
    }

    @Override
    protected Boolean TestObjectRenew(PSSFACHandler obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSSFACHandler vt) {
        return vt.getPSSFACHANDLERID();
    }
}

