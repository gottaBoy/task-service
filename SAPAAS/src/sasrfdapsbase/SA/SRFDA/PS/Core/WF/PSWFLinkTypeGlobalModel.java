/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.WF.IPSWFLinkType;
import SA.SRFDA.PS.Core.WF.PSWFLinkTypeImpl;
import SA.SRFDA.PS.Data.PSWFLinkType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFLinkTypeGlobalModel
extends PSGlobalModelBase<String, PSWFLinkType, IPSWFLinkType> {
    private static final Log log = LogFactory.getLog(PSWFLinkTypeGlobalModel.class);

    @Override
    protected PSWFLinkType GetObject(String strPSWFLinkTypeId) {
        PSWFLinkType PSWFLinkType2 = new PSWFLinkType();
        CallResult callResult = this.iPSModelHelper.getPSWFLinkType(strPSWFLinkTypeId, PSWFLinkType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u6d41\u7a0b\u8fde\u63a5\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWFLinkTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSWFLinkType2;
    }

    @Override
    protected IPSWFLinkType OnCreateModelHelper(PSWFLinkType vt) throws Exception {
        PSWFLinkTypeImpl iPSWFLinkType = new PSWFLinkTypeImpl();
        iPSWFLinkType.init(this.iDAGlobalHelper, vt);
        return iPSWFLinkType;
    }

    @Override
    protected Boolean TestObjectRenew(PSWFLinkType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSWFLinkType vt) {
        return vt.getPSWFLINKTYPEID();
    }
}

