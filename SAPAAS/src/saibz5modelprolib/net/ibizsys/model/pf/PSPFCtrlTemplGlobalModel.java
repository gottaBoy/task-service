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
import net.ibizsys.model.entity.PSPFCtrlTempl;
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pf.PSPFCtrlTemplImpl;
import net.ibizsys.model.pf.PSPFStyleGlobalModelBase;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCtrlTemplGlobalModel
extends PSPFStyleGlobalModelBase<String, PSPFCtrlTempl, IPSPFCtrlTempl> {
    private static final Log log = LogFactory.getLog(PSPFCtrlTemplGlobalModel.class);

    @Override
    protected void onInit() throws Exception {
        this.bEnableEmptyMap = true;
        super.onInit();
    }

    @Override
    protected PSPFCtrlTempl getObject(String strPSPFCtrlTemplId) {
        return null;
    }

    @Override
    protected IPSPFCtrlTempl onCreateModelHelper(PSPFCtrlTempl vt) throws Exception {
        PSPFCtrlTemplImpl iPSPFCtrlTempl = new PSPFCtrlTemplImpl();
        iPSPFCtrlTempl.init(this.getPSModelStorageContext(), this.getPSPF(), this.getPSPFStyle(), vt);
        return iPSPFCtrlTempl;
    }

    @Override
    protected Boolean testObjectRenew(PSPFCtrlTempl obj) {
        return false;
    }

    @Override
    protected IPSPFCtrlTempl registerModel(PSPFCtrlTempl vt) throws Exception {
        IPSPFCtrlTempl iPSPFCtrlTempl = (IPSPFCtrlTempl)this.internalGetModelHelper(vt.getPSPFCTRLTEMPLID());
        if (iPSPFCtrlTempl != null) {
            return iPSPFCtrlTempl;
        }
        this.setModel(vt.getPSPFCTRLTEMPLID(), vt, null);
        return (IPSPFCtrlTempl)this.findModelHelper(vt.getPSPFCTRLTEMPLID());
    }

    @Override
    protected Vector<PSPFCtrlTempl> getAllModels() throws Exception {
        Vector<PSPFCtrlTempl> list = new Vector<PSPFCtrlTempl>();
        CallResult callResult = this.getPSModelQueryHelper().getPSPFCtrlTemplsByPFStyle(this.getPSPFStyle().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5e94\u7528\u524d\u7aef\u6837\u5f0f\u90e8\u4ef6\u6a21\u7248\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected String getObjectId(PSPFCtrlTempl vt) {
        return vt.getPSPFCTRLTEMPLID();
    }
}

