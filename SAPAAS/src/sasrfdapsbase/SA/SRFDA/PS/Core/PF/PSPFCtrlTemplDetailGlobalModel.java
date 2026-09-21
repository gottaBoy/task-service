/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTemplDetail;
import SA.SRFDA.PS.Core.PF.PSPFCtrlTemplDetailImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSPFCtrlTemplDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCtrlTemplDetailGlobalModel
extends PSGlobalModelBase<String, PSPFCtrlTemplDetail, IPSPFCtrlTemplDetail> {
    private static final Log log = LogFactory.getLog(PSPFCtrlTemplDetailGlobalModel.class);
    protected IPSPFCtrlTempl iPSPFCtrlTempl = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFCtrlTempl iPSPFCtrlTempl) {
        this.iPSPFCtrlTempl = iPSPFCtrlTempl;
        return super.Init(iDAGlobalHelper);
    }

    protected IPSPFCtrlTempl getPSPFCtrlTempl() {
        return this.iPSPFCtrlTempl;
    }

    @Override
    protected PSPFCtrlTemplDetail GetObject(String strPSPFCtrlTemplDetailId) {
        return null;
    }

    @Override
    protected IPSPFCtrlTemplDetail OnCreateModelHelper(PSPFCtrlTemplDetail vt) throws Exception {
        PSPFCtrlTemplDetailImpl iPSPFCtrlTemplDetail = new PSPFCtrlTemplDetailImpl();
        iPSPFCtrlTemplDetail.init(this.iDAGlobalHelper, this.getPSPFCtrlTempl(), vt);
        return iPSPFCtrlTemplDetail;
    }

    @Override
    protected Boolean TestObjectRenew(PSPFCtrlTemplDetail obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        Vector<PSPFCtrlTemplDetail> psPFCtrlTemplDetailList = new Vector<PSPFCtrlTemplDetail>();
        CallResult callResult = this.iPSModelHelper.getPSPFCtrlTemplDetails(this.getPSPFCtrlTempl().getId(), psPFCtrlTemplDetailList);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u90e8\u4ef6\u7ec4\u6210\u4ee3\u7801\u6a21\u7248\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        for (PSPFCtrlTemplDetail psPFCtrlTemplDetail : psPFCtrlTemplDetailList) {
            this.setModel(psPFCtrlTemplDetail.getPSPFCTDETAILNAME(), psPFCtrlTemplDetail, null);
        }
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSPFCtrlTempl().getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSPFCtrlTemplDetail vt) {
        return vt.getPSPFCTDETAILID();
    }

    @Override
    protected String getModelInfo() {
        return StringHelper.Format((String)"%1$s-%2$s", (Object)super.getModelInfo(), (Object)this.iPSPFCtrlTempl.getName());
    }
}

