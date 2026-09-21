/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyle;
import SA.SRFDA.PS.Core.Res.PSSysEditorStyleImpl;
import SA.SRFDA.PS.Data.PSSysEditorStyle;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysEditorStyleGlobalModel
extends PSSystemGlobalModelBase<String, PSSysEditorStyle, IPSSysEditorStyle> {
    private static final Log log = LogFactory.getLog(PSSysEditorStyleGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        this.bEnableEmptyMap = true;
        return super.OnInit();
    }

    @Override
    protected PSSysEditorStyle GetObject(String strPSSysEditorStyleId) {
        return null;
    }

    @Override
    protected IPSSysEditorStyle OnCreateModelHelper(PSSysEditorStyle vt) throws Exception {
        PSSysEditorStyleImpl iPSSysEditorStyle = new PSSysEditorStyleImpl();
        iPSSysEditorStyle.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysEditorStyle;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysEditorStyle obj) {
        return false;
    }

    @Override
    protected IPSSysEditorStyle registerModel(PSSysEditorStyle vt) throws Exception {
        IPSSysEditorStyle iPSSysEditorStyle = (IPSSysEditorStyle)this.InternalGetModelHelper(vt.getPSSYSEDITORSTYLEID());
        if (iPSSysEditorStyle != null) {
            return iPSSysEditorStyle;
        }
        this.setModel(vt.getPSSYSEDITORSTYLEID(), vt, null);
        iPSSysEditorStyle = (IPSSysEditorStyle)this.FindModelHelper(vt.getPSSYSEDITORSTYLEID());
        return iPSSysEditorStyle;
    }

    @Override
    protected Vector<PSSysEditorStyle> getAllModels() throws Exception {
        Vector<PSSysEditorStyle> list = new Vector<PSSysEditorStyle>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysEditorStyles(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u7cfb\u7edf\u5168\u90e8\u7f16\u8f91\u5668\u6837\u5f0f\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysEditorStyle vt) {
        return vt.getPSSYSEDITORSTYLEID();
    }
}

