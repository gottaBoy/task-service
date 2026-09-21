/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFPluginType;
import SA.SRFDA.PS.Core.PF.PSPFPluginTypeImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSPFPluginType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFPluginTypeGlobalModel
extends PSGlobalModelBase<String, PSPFPluginType, IPSPFPluginType> {
    private static final Log log = LogFactory.getLog(PSPFPluginTypeGlobalModel.class);

    @Override
    protected PSPFPluginType GetObject(String strPSPFPluginTypeId) {
        PSPFPluginType PSPFPluginType2 = new PSPFPluginType();
        CallResult callResult = this.iPSModelHelper.getPSPFPluginType(strPSPFPluginTypeId, PSPFPluginType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e94\u7528\u6846\u67b6\u63d2\u4ef6\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSPFPluginTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSPFPluginType2;
    }

    @Override
    protected IPSPFPluginType OnCreateModelHelper(PSPFPluginType vt) throws Exception {
        PSPFPluginTypeImpl iPSPFPluginType = new PSPFPluginTypeImpl();
        iPSPFPluginType.init(this.iDAGlobalHelper, vt);
        return iPSPFPluginType;
    }

    @Override
    protected Boolean TestObjectRenew(PSPFPluginType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSPFPluginType vt) {
        return vt.getPSPFPLUGINTYPEID();
    }
}

