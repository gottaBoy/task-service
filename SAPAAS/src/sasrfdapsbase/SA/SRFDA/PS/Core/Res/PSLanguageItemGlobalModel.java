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
import SA.SRFDA.PS.Core.Res.IPSLanguageItem;
import SA.SRFDA.PS.Core.Res.PSLanguageItemImpl;
import SA.SRFDA.PS.Data.PSLanguageItem;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSLanguageItemGlobalModel
extends PSSystemGlobalModelBase<String, PSLanguageItem, IPSLanguageItem> {
    private static final Log log = LogFactory.getLog(PSLanguageItemGlobalModel.class);

    @Override
    protected PSLanguageItem GetObject(String strPSLanguageItemId) {
        return null;
    }

    @Override
    protected IPSLanguageItem OnCreateModelHelper(PSLanguageItem vt) throws Exception {
        PSLanguageItemImpl iPSLanguageItem = null;
        iPSLanguageItem = new PSLanguageItemImpl();
        iPSLanguageItem.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSLanguageItem;
    }

    @Override
    protected Boolean TestObjectRenew(PSLanguageItem obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSLanguageItem registerModel(PSLanguageItem vt) throws Exception {
        IPSLanguageItem iIPSLanguageItem = (IPSLanguageItem)this.InternalGetModelHelper(vt.getPSLANGUAGEITEMID());
        if (iIPSLanguageItem != null) {
            return iIPSLanguageItem;
        }
        this.setModel(vt.getPSLANGUAGEITEMID(), vt, null);
        IPSLanguageItem iPSLanguageItem = (IPSLanguageItem)this.FindModelHelper(vt.getPSLANGUAGEITEMID());
        this.setModel(vt.getPSLANGUAGEITEMNAME(), vt, iPSLanguageItem);
        return iPSLanguageItem;
    }

    @Override
    protected Vector<PSLanguageItem> getAllModels() throws Exception {
        Vector<PSLanguageItem> list = new Vector<PSLanguageItem>();
        CallResult callResult = this.iPSModelHelper.getAllPSLanguageItems(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u8bed\u8a00\u8d44\u6e90\u9879\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSLanguageItem vt) {
        return vt.getPSLANGUAGEITEMID();
    }

    @Override
    protected void onPreloadModels() {
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }
}

