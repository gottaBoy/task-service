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

import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.PSSFGlobalModelBase;
import SA.SRFDA.PS.Core.SF.PSSFObjectImpl;
import SA.SRFDA.PS.Core.SF.PSSFStyle2Impl;
import SA.SRFDA.PS.Core.SF.PSSFStyleImpl;
import SA.SRFDA.PS.Data.PSSFStyle;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFStyleGlobalModel
extends PSSFGlobalModelBase<String, PSSFStyle, IPSSFStyle> {
    private static final Log log = LogFactory.getLog(PSSFStyleGlobalModel.class);

    @Override
    protected PSSFStyle GetObject(String strPSSFStyleId) {
        PSSFStyle PSSFStyle2 = new PSSFStyle();
        CallResult callResult = this.iPSModelHelper.getPSSFStyle(strPSSFStyleId, PSSFStyle2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u670d\u52a1\u6846\u67b6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSFStyleId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSSFStyle2;
    }

    @Override
    protected IPSSFStyle OnCreateModelHelper(PSSFStyle vt) throws Exception {
        PSSFObjectImpl iPSSFStyle = null;
        iPSSFStyle = StringHelper.Compare((String)vt.getSTYLEENGINE(), (String)"V2", (boolean)true) == 0 ? new PSSFStyle2Impl() : new PSSFStyleImpl();
        iPSSFStyle.init(this.iDAGlobalHelper, this.getPSSF(), vt);
        return iPSSFStyle;
    }

    @Override
    protected Boolean TestObjectRenew(PSSFStyle obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSSFStyle vt) {
        return vt.getPSSFSTYLEID();
    }

    @Override
    public IPSSFStyle FindModelHelper(String objObjectId, boolean bTryMode) throws Exception {
        IPSSFStyle iPSSFStyle = (IPSSFStyle)super.FindModelHelper(objObjectId, bTryMode);
        if (iPSSFStyle != null) {
            PSSFStyle psPFStyle = null;
            psPFStyle = new PSSFStyle();
            CallResult callResult = this.iPSModelHelper.getPSSFStyleRefreshVersion(objObjectId, psPFStyle);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u540e\u53f0\u670d\u52a1\u6846\u67b6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
            }
            if (psPFStyle.isVERSIONNull()) {
                psPFStyle.setVERSION(1);
            }
            if (iPSSFStyle.getVersion() != psPFStyle.getVERSION()) {
                this.ResetModel(objObjectId);
                return (IPSSFStyle)super.FindModelHelper(objObjectId, bTryMode);
            }
        }
        return iPSSFStyle;
    }
}

