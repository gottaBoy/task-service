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

import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.PF.PSPFEditorTemplImpl;
import SA.SRFDA.PS.Core.PF.PSPFStyleGlobalModelBase;
import SA.SRFDA.PS.Data.PSPFEditorTempl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFStyleEditorTemplGlobalModel
extends PSPFStyleGlobalModelBase<String, PSPFEditorTempl, IPSPFEditorTempl> {
    private static final Log log = LogFactory.getLog(PSPFStyleEditorTemplGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        this.bEnableEmptyMap = true;
        return super.OnInit();
    }

    @Override
    protected PSPFEditorTempl GetObject(String strPSPFEditorTemplId) {
        return null;
    }

    @Override
    protected IPSPFEditorTempl OnCreateModelHelper(PSPFEditorTempl vt) throws Exception {
        PSPFEditorTemplImpl iPSPFEditorTempl = new PSPFEditorTemplImpl();
        iPSPFEditorTempl.init(this.iDAGlobalHelper, this.getPSPF(), this.getPSPFStyle(), vt);
        return iPSPFEditorTempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSPFEditorTempl obj) {
        return false;
    }

    @Override
    protected IPSPFEditorTempl registerModel(PSPFEditorTempl vt) throws Exception {
        IPSPFEditorTempl iPSPFEditorTempl = (IPSPFEditorTempl)this.InternalGetModelHelper(vt.getPSPFEDITORTEMPLID());
        if (iPSPFEditorTempl != null) {
            return iPSPFEditorTempl;
        }
        this.setModel(vt.getPSPFEDITORTEMPLID(), vt, null);
        return (IPSPFEditorTempl)this.FindModelHelper(vt.getPSPFEDITORTEMPLID());
    }

    @Override
    protected Vector<PSPFEditorTempl> getAllModels() throws Exception {
        Vector<PSPFEditorTempl> list = new Vector<PSPFEditorTempl>();
        CallResult callResult = this.iPSModelHelper.getPSPFEditorTemplsByPFStyle(this.getPSPFStyle().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u524d\u7aef\u6837\u5f0f\u7f16\u8f91\u5668\u6a21\u7248\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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

