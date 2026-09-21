/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DR;

import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRItem;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDRItemType;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEDRItem;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDRItemGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEDRItem, IPSDEDRItem> {
    private static final Log log = LogFactory.getLog(PSDEDRItemGlobalModel.class);

    @Override
    protected PSDEDRItem GetObject(String strPSDEDRItemId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u754c\u9762[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDRItemId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEDRItem OnCreateModelHelper(PSDEDRItem vt) throws Exception {
        IPSDRItemType iPSDRItemType = this.iPSModelStorage.getPSDRItemType(vt.getDRITEMTYPE());
        IPSDEDRItem iPSDEDRItem = iPSDRItemType.createPSDEDRItem(vt);
        iPSDEDRItem.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEDRItem;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEDRItem obj) {
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
        CallResult callResult = this.iPSModelHelper.getPSDEDRItems(this.getPSDataEntity().getId(), psDEDRItem);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5b9e\u4f53\u5173\u7cfb\u5206\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDRItem;
    }

    @Override
    protected IPSDEDRItem registerModel(PSDEDRItem vt) throws Exception {
        IPSDEDRItem iPSDEDRItem = (IPSDEDRItem)this.InternalGetModelHelper(vt.getPSDEDRITEMID());
        if (iPSDEDRItem != null) {
            return iPSDEDRItem;
        }
        this.setModel(vt.getPSDEDRITEMID(), vt, null);
        return (IPSDEDRItem)this.FindModelHelper(vt.getPSDEDRITEMID());
    }

    @Override
    protected String getObjectId(PSDEDRItem vt) {
        return vt.getPSDEDRITEMID();
    }

    @Override
    protected String getModelInfo() {
        return StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5173\u7cfb\u754c\u9762", (Object)this.getPSDataEntity().getName());
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEDRItem vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

