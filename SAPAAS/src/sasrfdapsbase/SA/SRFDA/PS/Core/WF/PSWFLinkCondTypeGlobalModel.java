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
import SA.SRFDA.PS.Core.WF.IPSWFLinkCondType;
import SA.SRFDA.PS.Core.WF.PSWFLinkCondTypeImpl;
import SA.SRFDA.PS.Data.PSWFLinkCondType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFLinkCondTypeGlobalModel
extends PSGlobalModelBase<String, PSWFLinkCondType, IPSWFLinkCondType> {
    private static final Log log = LogFactory.getLog(PSWFLinkCondTypeGlobalModel.class);

    @Override
    protected PSWFLinkCondType GetObject(String strPSWFLinkCondTypeId) {
        PSWFLinkCondType PSWFLinkCondType2 = new PSWFLinkCondType();
        CallResult callResult = this.iPSModelHelper.getPSWFLinkCondType(strPSWFLinkCondTypeId, PSWFLinkCondType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u6d41\u7a0b\u5904\u7406\u8fde\u63a5\u6761\u4ef6\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWFLinkCondTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSWFLinkCondType2;
    }

    @Override
    protected IPSWFLinkCondType OnCreateModelHelper(PSWFLinkCondType vt) throws Exception {
        PSWFLinkCondTypeImpl iPSWFLinkCondType = new PSWFLinkCondTypeImpl();
        iPSWFLinkCondType.init(this.iDAGlobalHelper, vt);
        return iPSWFLinkCondType;
    }

    @Override
    protected Boolean TestObjectRenew(PSWFLinkCondType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSWFLinkCondType vt) {
        return vt.getPSWFLINKCONDTYPEID();
    }
}

