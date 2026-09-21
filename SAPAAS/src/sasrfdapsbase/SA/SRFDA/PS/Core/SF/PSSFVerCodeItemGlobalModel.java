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
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.SF.IPSSFVerCode;
import SA.SRFDA.PS.Core.SF.IPSSFVerCodeItem;
import SA.SRFDA.PS.Core.SF.PSSFVerCodeItemImpl;
import SA.SRFDA.PS.Data.PSSFVerCodeItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFVerCodeItemGlobalModel
extends PSGlobalModelBase<String, PSSFVerCodeItem, IPSSFVerCodeItem> {
    private static final Log log = LogFactory.getLog(PSSFVerCodeItemGlobalModel.class);
    protected IPSSFVerCode iPSSFVerCode = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFVerCode iPSSFVerCode) {
        this.iPSSFVerCode = iPSSFVerCode;
        return super.Init(iDAGlobalHelper);
    }

    @Override
    protected PSSFVerCodeItem GetObject(String strPSSFVerCodeItemId) {
        return null;
    }

    @Override
    protected IPSSFVerCodeItem OnCreateModelHelper(PSSFVerCodeItem vt) throws Exception {
        PSSFVerCodeItemImpl iPSSFVerCodeItem = new PSSFVerCodeItemImpl();
        iPSSFVerCodeItem.init(this.iDAGlobalHelper, this.iPSSFVerCode, vt);
        return iPSSFVerCodeItem;
    }

    @Override
    protected Boolean TestObjectRenew(PSSFVerCodeItem obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSFVerCode.getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSSFVerCodeItem vt) {
        return vt.getPSSFVERCODEITEMID();
    }

    @Override
    protected IPSSFVerCodeItem registerModel(PSSFVerCodeItem vt) throws Exception {
        IPSSFVerCodeItem iPSSFVerCodeItem = (IPSSFVerCodeItem)this.InternalGetModelHelper(vt.getPSSFVERCODEITEMID());
        if (iPSSFVerCodeItem != null) {
            return iPSSFVerCodeItem;
        }
        this.setModel(vt.getPSSFVERCODEITEMID(), vt, null);
        return (IPSSFVerCodeItem)this.FindModelHelper(vt.getPSSFVERCODEITEMID());
    }

    @Override
    protected Vector<PSSFVerCodeItem> getAllModels() throws Exception {
        Vector<PSSFVerCodeItem> list = new Vector<PSSFVerCodeItem>();
        CallResult callResult = this.iPSModelHelper.getPSSFVerCodeItems(this.iPSSFVerCode.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u540e\u53f0\u670d\u52a1\u6846\u67b6\u6837\u5f0f\u7248\u672c\u4ee3\u7801\u9879\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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
}

