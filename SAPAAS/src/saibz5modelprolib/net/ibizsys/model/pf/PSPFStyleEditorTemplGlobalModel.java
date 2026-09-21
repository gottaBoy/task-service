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
import net.ibizsys.model.entity.PSPFEditorTempl;
import net.ibizsys.model.pf.IPSPFEditorTempl;
import net.ibizsys.model.pf.PSPFEditorTemplImpl;
import net.ibizsys.model.pf.PSPFStyleGlobalModelBase;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFStyleEditorTemplGlobalModel
extends PSPFStyleGlobalModelBase<String, PSPFEditorTempl, IPSPFEditorTempl> {
    private static final Log log = LogFactory.getLog(PSPFStyleEditorTemplGlobalModel.class);

    @Override
    protected void onInit() throws Exception {
        this.bEnableEmptyMap = true;
        super.onInit();
    }

    @Override
    protected PSPFEditorTempl getObject(String strPSPFEditorTemplId) {
        return null;
    }

    @Override
    protected IPSPFEditorTempl onCreateModelHelper(PSPFEditorTempl vt) throws Exception {
        PSPFEditorTemplImpl iPSPFEditorTempl = new PSPFEditorTemplImpl();
        iPSPFEditorTempl.init(this.getPSModelStorageContext(), this.getPSPF(), this.getPSPFStyle(), vt);
        return iPSPFEditorTempl;
    }

    @Override
    protected Boolean testObjectRenew(PSPFEditorTempl obj) {
        return false;
    }

    @Override
    protected IPSPFEditorTempl registerModel(PSPFEditorTempl vt) throws Exception {
        IPSPFEditorTempl iPSPFEditorTempl = (IPSPFEditorTempl)this.internalGetModelHelper(vt.getPSPFEDITORTEMPLID());
        if (iPSPFEditorTempl != null) {
            return iPSPFEditorTempl;
        }
        this.setModel(vt.getPSPFEDITORTEMPLID(), vt, null);
        return (IPSPFEditorTempl)this.findModelHelper(vt.getPSPFEDITORTEMPLID());
    }

    @Override
    protected Vector<PSPFEditorTempl> getAllModels() throws Exception {
        Vector<PSPFEditorTempl> list = new Vector<PSPFEditorTempl>();
        CallResult callResult = this.getPSModelQueryHelper().getPSPFEditorTemplsByPFStyle(this.getPSPFStyle().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5e94\u7528\u524d\u7aef\u6837\u5f0f\u7f16\u8f91\u5668\u6a21\u7248\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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
    protected String getObjectId(PSPFEditorTempl vt) {
        return vt.getPSPFEDITORTEMPLID();
    }
}

