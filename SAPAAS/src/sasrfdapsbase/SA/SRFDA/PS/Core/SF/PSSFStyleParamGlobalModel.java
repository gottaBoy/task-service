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

import SA.SRFDA.PS.Core.SF.IPSSFStyleParam;
import SA.SRFDA.PS.Core.SF.PSSFGlobalModelBase;
import SA.SRFDA.PS.Core.SF.PSSFStyleParamImpl;
import SA.SRFDA.PS.Data.PSSFStyleParam;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFStyleParamGlobalModel
extends PSSFGlobalModelBase<String, PSSFStyleParam, IPSSFStyleParam> {
    private static final Log log = LogFactory.getLog(PSSFStyleParamGlobalModel.class);

    @Override
    protected PSSFStyleParam GetObject(String strPSSFStyleParamId) {
        PSSFStyleParam PSSFStyleParam2 = new PSSFStyleParam();
        CallResult callResult = this.iPSModelHelper.getPSSFStyleParam(strPSSFStyleParamId, PSSFStyleParam2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u670d\u52a1\u6846\u67b6\u6837\u5f0f\u53c2\u6570[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSFStyleParamId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSSFStyleParam2;
    }

    @Override
    protected IPSSFStyleParam OnCreateModelHelper(PSSFStyleParam vt) throws Exception {
        PSSFStyleParamImpl iPSSFStyleParam = new PSSFStyleParamImpl();
        iPSSFStyleParam.init(this.iDAGlobalHelper, this.getPSSF(), vt);
        return iPSSFStyleParam;
    }

    @Override
    protected Boolean TestObjectRenew(PSSFStyleParam obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSSFStyleParam vt) {
        return vt.getPSSFSTYLEPARAMID();
    }
}

