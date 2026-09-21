/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.res.IPSLanguageItem
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import java.util.Vector;
import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.entity.PSLanguageItem;
import net.ibizsys.model.res.IPSLanguageItem;
import net.ibizsys.model.res.PSLanguageItemImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSLanguageItemGlobalModel
extends PSSystemGlobalModelBase<String, PSLanguageItem, IPSLanguageItem> {
    private static final Log log = LogFactory.getLog(PSLanguageItemGlobalModel.class);

    @Override
    protected PSLanguageItem getObject(String strPSLanguageItemId) {
        return null;
    }

    @Override
    protected IPSLanguageItem onCreateModelHelper(PSLanguageItem vt) throws Exception {
        PSLanguageItemImpl iPSLanguageItem = null;
        iPSLanguageItem = new PSLanguageItemImpl();
        iPSLanguageItem.init(this.getPSModelStorageContext(), this.getPSSystem(), vt);
        return iPSLanguageItem;
    }

    @Override
    protected Boolean testObjectRenew(PSLanguageItem obj) {
        return false;
    }

    @Override
    protected IPSLanguageItem registerModel(PSLanguageItem vt) throws Exception {
        IPSLanguageItem iIPSLanguageItem = (IPSLanguageItem)this.internalGetModelHelper(vt.getPSLANGUAGEITEMID());
        if (iIPSLanguageItem != null) {
            return iIPSLanguageItem;
        }
        this.setModel(vt.getPSLANGUAGEITEMID(), vt, null);
        IPSLanguageItem iPSLanguageItem = (IPSLanguageItem)this.findModelHelper(vt.getPSLANGUAGEITEMID());
        this.setModel(vt.getPSLANGUAGEITEMNAME(), vt, iPSLanguageItem);
        return iPSLanguageItem;
    }

    @Override
    protected Vector<PSLanguageItem> getAllModels() throws Exception {
        Vector<PSLanguageItem> list = new Vector<PSLanguageItem>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSLanguageItems(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u8bed\u8a00\u8d44\u6e90\u9879\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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

