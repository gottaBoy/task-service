/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Control;

import SA.SRFDA.PS.Core.App.Control.IPSAppEditorTempl;
import SA.SRFDA.PS.Core.App.Control.PSAppEditorTemplImpl;
import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Data.PSAppEditorTempl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppEditorTemplGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppEditorTempl, IPSAppEditorTempl> {
    private static final Log log = LogFactory.getLog(PSAppEditorTemplGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        this.bEnableEmptyMap = true;
        return super.OnInit();
    }

    @Override
    protected PSAppEditorTempl GetObject(String strPSAppEditorTemplId) {
        return null;
    }

    @Override
    protected IPSAppEditorTempl OnCreateModelHelper(PSAppEditorTempl vt) throws Exception {
        PSAppEditorTemplImpl iPSAppEditorTempl = new PSAppEditorTemplImpl();
        iPSAppEditorTempl.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppEditorTempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppEditorTempl obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSAppEditorTempl vt) {
        return vt.getPSAPPEDITORTEMPLID();
    }

    @Override
    protected IPSAppEditorTempl registerModel(PSAppEditorTempl vt) throws Exception {
        IPSAppEditorTempl iPSAppEditorTempl = (IPSAppEditorTempl)this.InternalGetModelHelper(vt.getPSAPPEDITORTEMPLID());
        if (iPSAppEditorTempl != null) {
            return iPSAppEditorTempl;
        }
        this.setModel(vt.getPSAPPEDITORTEMPLID(), vt, null);
        return (IPSAppEditorTempl)this.FindModelHelper(vt.getPSAPPEDITORTEMPLID());
    }

    @Override
    protected Vector<PSAppEditorTempl> getAllModels() throws Exception {
        Vector<PSAppEditorTempl> list = new Vector<PSAppEditorTempl>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppEditorTempls(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5e94\u7528\u5168\u90e8\u5e94\u7528\u529f\u80fd\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppEditorTempl psAppEditorTempl : list) {
            this.setModel(psAppEditorTempl.getPSAPPEDITORTEMPLID(), psAppEditorTempl, null);
        }
        return list;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSApplicationException.create(this.getPSApplication(), 40002, objObjectId);
    }
}

