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

import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.PSPFGlobalModelBase;
import SA.SRFDA.PS.Core.PF.PSPFStyle2Impl;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Data.PSPFStyle;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFStyleGlobalModel
extends PSPFGlobalModelBase<String, PSPFStyle, IPSPFStyle> {
    private static final Log log = LogFactory.getLog(PSPFStyleGlobalModel.class);
    protected IPSModelHelper iPSModelHelper = null;

    @Override
    protected CallResult OnInit() {
        this.bEnableEmptyMap = true;
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.iPSModelHelper = PSObjectFactory.getPSModelHelper(this.iDAGlobalHelper, null);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u4e91\u5e73\u53f0\u5e94\u7528\u6837\u5f0f\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    @Override
    protected PSPFStyle GetObject(String strPSPFStyleId) {
        PSPFStyle psPFStyle = new PSPFStyle();
        CallResult callResult = this.iPSModelHelper.getPSPFStyle(strPSPFStyleId, psPFStyle);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e94\u7528\u6837\u5f0f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSPFStyleId, (Object)callResult.getErrorInfo()));
            return null;
        }
        if (StringHelper.Compare((String)psPFStyle.getPSPFID(), (String)this.getPSPF().getId(), (boolean)false) != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e94\u7528\u6837\u5f0f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c\u524d\u7aef\u6280\u672f\u4f53\u7cfb[%2$s]\u4e0e\u5f53\u524d\u6280\u672f\u4f53\u7cfb[%3$s]\u4e0d\u4e00\u81f4", (Object)strPSPFStyleId, (Object)psPFStyle.getPSPFID(), (Object)this.getPSPF().getId()));
            return null;
        }
        return psPFStyle;
    }

    @Override
    protected IPSPFStyle OnCreateModelHelper(PSPFStyle vt) throws Exception {
        if (StringHelper.Compare((String)vt.getSTYLEENGINE(), (String)"V2", (boolean)true) == 0) {
            PSPFStyle2Impl iPSPFStyle = new PSPFStyle2Impl();
            iPSPFStyle.init(this.iDAGlobalHelper, this.getPSPF(), vt);
            return iPSPFStyle;
        }
        IPSPFStyle iPSPFStyle = this.getPSPF().createPSPFStyle();
        iPSPFStyle.init(this.iDAGlobalHelper, this.getPSPF(), vt);
        return iPSPFStyle;
    }

    @Override
    protected Boolean TestObjectRenew(PSPFStyle obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSPFStyle vt) {
        return vt.getPSPFSTYLEID();
    }

    @Override
    public IPSPFStyle FindModelHelper(String objObjectId, boolean bTryMode) throws Exception {
        IPSPFStyle iPSPFStyle = (IPSPFStyle)super.FindModelHelper(objObjectId, bTryMode);
        if (iPSPFStyle != null) {
            PSPFStyle psPFStyle = null;
            psPFStyle = new PSPFStyle();
            CallResult callResult = this.iPSModelHelper.getPSPFStyleRefreshVersion(objObjectId, psPFStyle);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e94\u7528\u6837\u5f0f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
            }
            if (psPFStyle.isVERSIONNull()) {
                psPFStyle.setVERSION(1);
            }
            if (iPSPFStyle.getVersion() != psPFStyle.getVERSION()) {
                this.ResetModel(objObjectId);
                return (IPSPFStyle)super.FindModelHelper(objObjectId, bTryMode);
            }
        }
        return iPSPFStyle;
    }
}

