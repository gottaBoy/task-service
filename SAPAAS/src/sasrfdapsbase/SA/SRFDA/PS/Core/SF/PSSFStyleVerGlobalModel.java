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

import SA.SRFDA.PS.Core.SF.IPSSFStyleVer;
import SA.SRFDA.PS.Core.SF.PSSFStyleGlobalModelBase;
import SA.SRFDA.PS.Core.SF.PSSFStyleVerImpl;
import SA.SRFDA.PS.Data.PSSFStyleVer;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFStyleVerGlobalModel
extends PSSFStyleGlobalModelBase<String, PSSFStyleVer, IPSSFStyleVer> {
    private static final Log log = LogFactory.getLog(PSSFStyleVerGlobalModel.class);

    @Override
    protected PSSFStyleVer GetObject(String strPSSFStyleVerId) {
        PSSFStyleVer PSSFStyleVer2 = new PSSFStyleVer();
        CallResult callResult = this.iPSModelHelper.getPSSFStyleVer(strPSSFStyleVerId, PSSFStyleVer2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u670d\u52a1\u6846\u67b6\u6269\u5c55[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSFStyleVerId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSSFStyleVer2;
    }

    @Override
    protected IPSSFStyleVer OnCreateModelHelper(PSSFStyleVer vt) throws Exception {
        PSSFStyleVerImpl iPSSFStyleVer = new PSSFStyleVerImpl();
        iPSSFStyleVer.init(this.iDAGlobalHelper, this.getPSSFStyle(), vt);
        return iPSSFStyleVer;
    }

    @Override
    protected Boolean TestObjectRenew(PSSFStyleVer obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSSFStyleVer vt) {
        return vt.getPSSFSTYLEVERID();
    }

    @Override
    public IPSSFStyleVer FindModelHelper(String objObjectId, boolean bTryMode) throws Exception {
        IPSSFStyleVer iPSSFStyleVer = (IPSSFStyleVer)super.FindModelHelper(objObjectId, bTryMode);
        if (iPSSFStyleVer != null) {
            PSSFStyleVer psSFStyleVer = new PSSFStyleVer();
            CallResult callResult = this.iPSModelHelper.getPSSFStyleVer(objObjectId, psSFStyleVer);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u670d\u52a1\u6846\u67b6\u6269\u5c55[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
            }
            if (iPSSFStyleVer.getVersion() != psSFStyleVer.getMAJOR()) {
                this.ResetModel(objObjectId);
                return (IPSSFStyleVer)super.FindModelHelper(objObjectId, bTryMode);
            }
        }
        return iPSSFStyleVer;
    }
}

