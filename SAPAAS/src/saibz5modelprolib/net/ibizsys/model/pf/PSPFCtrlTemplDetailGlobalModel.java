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

import java.util.Vector;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.entity.PSPFCtrlTemplDetail;
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pf.IPSPFCtrlTemplDetail;
import net.ibizsys.model.pf.PSPFCtrlTemplDetailImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCtrlTemplDetailGlobalModel
extends PSGlobalModelBase<String, PSPFCtrlTemplDetail, IPSPFCtrlTemplDetail> {
    private static final Log log = LogFactory.getLog(PSPFCtrlTemplDetailGlobalModel.class);
    protected IPSPFCtrlTempl iPSPFCtrlTempl = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSPFCtrlTempl iPSPFCtrlTempl) throws Exception {
        this.iPSPFCtrlTempl = iPSPFCtrlTempl;
        super.init(iPSModelStorageContext);
    }

    protected IPSPFCtrlTempl getPSPFCtrlTempl() {
        return this.iPSPFCtrlTempl;
    }

    @Override
    protected PSPFCtrlTemplDetail getObject(String strPSPFCtrlTemplDetailId) {
        return null;
    }

    @Override
    protected IPSPFCtrlTemplDetail onCreateModelHelper(PSPFCtrlTemplDetail vt) throws Exception {
        PSPFCtrlTemplDetailImpl iPSPFCtrlTemplDetail = new PSPFCtrlTemplDetailImpl();
        iPSPFCtrlTemplDetail.init(this.getPSModelStorageContext(), this.getPSPFCtrlTempl(), vt);
        return iPSPFCtrlTemplDetail;
    }

    @Override
    protected Boolean testObjectRenew(PSPFCtrlTemplDetail obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        Vector<PSPFCtrlTemplDetail> psPFCtrlTemplDetailList = new Vector<PSPFCtrlTemplDetail>();
        CallResult callResult = this.getPSModelQueryHelper().getPSPFCtrlTemplDetails(this.getPSPFCtrlTempl().getId(), psPFCtrlTemplDetailList);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u67e5\u8be2\u90e8\u4ef6\u7ec4\u6210\u4ee3\u7801\u6a21\u7248\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        for (PSPFCtrlTemplDetail psPFCtrlTemplDetail : psPFCtrlTemplDetailList) {
            this.setModel(psPFCtrlTemplDetail.getPSPFCTDETAILNAME(), psPFCtrlTemplDetail, null);
        }
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)((Object)this.getPSPFCtrlTempl())).getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSPFCtrlTemplDetail vt) {
        return vt.getPSPFCTDETAILID();
    }
}

