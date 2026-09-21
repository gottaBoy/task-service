/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Requirement;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqItem;
import SA.SRFDA.PS.Core.Requirement.PSSysReqItemImpl;
import SA.SRFDA.PS.Data.PSSysReqItem;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysReqItemGlobalModel
extends PSSystemGlobalModelBase<String, PSSysReqItem, IPSSysReqItem> {
    private static final Log log = LogFactory.getLog(PSSysReqItemGlobalModel.class);

    @Override
    protected PSSysReqItem GetObject(String strPSSysReqItemId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSSysReqItem psSysReqItem = new PSSysReqItem();
        CallResult callResult = this.iPSModelHelper.getPSSysReqItem(strPSSysReqItemId, psSysReqItem);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u9700\u6c42\u9879[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysReqItemId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysReqItem;
    }

    @Override
    protected IPSSysReqItem OnCreateModelHelper(PSSysReqItem vt) throws Exception {
        PSSysReqItemImpl iPSSysReqItem = new PSSysReqItemImpl();
        iPSSysReqItem.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysReqItem;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysReqItem obj) {
        return false;
    }

    @Override
    protected IPSSysReqItem registerModel(PSSysReqItem vt) throws Exception {
        IPSSysReqItem iPSSysReqItem = (IPSSysReqItem)this.InternalGetModelHelper(vt.getPSSYSREQITEMID());
        if (iPSSysReqItem != null) {
            return iPSSysReqItem;
        }
        this.setModel(vt.getPSSYSREQITEMID(), vt, null);
        iPSSysReqItem = (IPSSysReqItem)this.FindModelHelper(vt.getPSSYSREQITEMID());
        return iPSSysReqItem;
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

    @Override
    protected Vector<PSSysReqItem> getAllModels() throws Exception {
        Vector<PSSysReqItem> list = new Vector<PSSysReqItem>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysReqItems(this.getPSSystem().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u9700\u6c42\u6a21\u5757\u5168\u90e8\u5185\u5bb9\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysReqItem vt) {
        return vt.getPSSYSREQITEMID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysReqItem vt) {
        if (StringHelper.IsNullOrEmpty((String)vt.getPSSYSREQMODULEID()) && !net.ibizsys.paas.util.StringHelper.isNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

