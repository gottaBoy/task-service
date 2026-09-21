/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.dr.IPSDEDRItem
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.dr;

import java.util.Vector;
import net.ibizsys.model.dataentity.PSDataEntityGlobalModelBase;
import net.ibizsys.model.dataentity.dr.IPSDEDRItem;
import net.ibizsys.model.dataentity.dr.IPSDEDRItemRuntime;
import net.ibizsys.model.dataentity.dr.IPSDRItemType;
import net.ibizsys.model.entity.PSDEDRItem;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDRItemGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEDRItem, IPSDEDRItem> {
    private static final Log log = LogFactory.getLog(PSDEDRItemGlobalModel.class);

    @Override
    protected PSDEDRItem getObject(String strPSDEDRItemId) {
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u5b9e\u4f53\u5173\u7cfb\u5206\u7ec4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDRItemId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEDRItem onCreateModelHelper(PSDEDRItem vt) throws Exception {
        IPSDRItemType iPSDRItemType = this.getPSModelStorageContext().getPSDRItemType(vt.getDRITEMTYPE());
        IPSDEDRItem iPSDEDRItem = iPSDRItemType.createPSDEDRItem(vt);
        ((IPSDEDRItemRuntime)iPSDEDRItem).init(this.getPSModelStorageContext(), this.getPSDataEntity(), vt);
        return iPSDEDRItem;
    }

    @Override
    protected Boolean testObjectRenew(PSDEDRItem obj) {
        return false;
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
    protected Vector<PSDEDRItem> getAllModels() throws Exception {
        Vector<PSDEDRItem> psDEDRItem = new Vector<PSDEDRItem>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEDRItems(this.getPSDataEntity().getId(), psDEDRItem);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u5b9e\u4f53\u5173\u7cfb\u5206\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDRItem;
    }

    @Override
    protected IPSDEDRItem registerModel(PSDEDRItem vt) throws Exception {
        IPSDEDRItem iPSDEDRItem = (IPSDEDRItem)this.internalGetModelHelper(vt.getPSDEDRITEMID());
        if (iPSDEDRItem != null) {
            return iPSDEDRItem;
        }
        this.setModel(vt.getPSDEDRITEMID(), vt, null);
        return (IPSDEDRItem)this.findModelHelper(vt.getPSDEDRITEMID());
    }

    @Override
    protected String getObjectId(PSDEDRItem vt) {
        return vt.getPSDEDRITEMID();
    }
}

