/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.entity.PSPFStyle;
import net.ibizsys.model.pf.IPSPFRuntime;
import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.model.pf.IPSPFStyleRuntime;
import net.ibizsys.model.pf.PSPFGlobalModelBase;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFStyleGlobalModel
extends PSPFGlobalModelBase<String, PSPFStyle, IPSPFStyle> {
    private static final Log log = LogFactory.getLog(PSPFStyleGlobalModel.class);

    @Override
    protected void onInit() throws Exception {
        this.bEnableEmptyMap = true;
        super.onInit();
    }

    @Override
    protected PSPFStyle getObject(String strPSPFStyleId) {
        PSPFStyle PSPFStyle2 = new PSPFStyle();
        CallResult callResult = this.getPSModelQueryHelper().getPSPFStyle(strPSPFStyleId, PSPFStyle2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e94\u7528\u6837\u5f0f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSPFStyleId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSPFStyle2;
    }

    @Override
    protected IPSPFStyle onCreateModelHelper(PSPFStyle vt) throws Exception {
        IPSPFStyle iPSPFStyle = ((IPSPFRuntime)this.getPSPF()).createPSPFStyle();
        ((IPSPFStyleRuntime)iPSPFStyle).init(this.getPSModelStorageContext(), this.getPSPF(), vt);
        return iPSPFStyle;
    }

    @Override
    protected Boolean testObjectRenew(PSPFStyle obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSPFStyle vt) {
        return vt.getPSPFSTYLEID();
    }

    @Override
    public IPSPFStyle findModelHelper(String objObjectId, boolean bTryMode) throws Exception {
        IPSPFStyle iPSPFStyle = (IPSPFStyle)super.findModelHelper(objObjectId, bTryMode);
        if (iPSPFStyle != null && !StringHelper.isNullOrEmpty((String)iPSPFStyle.getPSDevCenterId())) {
            PSPFStyle psPFStyle = new PSPFStyle();
            CallResult callResult = this.getPSModelQueryHelper().getPSPFStyle(objObjectId, psPFStyle);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e94\u7528\u6837\u5f0f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
            }
            if (iPSPFStyle.getVersion() != psPFStyle.getVERSION()) {
                this.resetModel(objObjectId);
                return (IPSPFStyle)super.findModelHelper(objObjectId, bTryMode);
            }
        }
        return iPSPFStyle;
    }
}

