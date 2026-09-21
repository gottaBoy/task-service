/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataSync;

import SA.SRFDA.PS.Core.DataEntity.DataSync.IPSDEDataSync;
import SA.SRFDA.PS.Core.DataEntity.DataSync.PSDEDataSyncImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEDataSync;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataSyncGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEDataSync, IPSDEDataSync> {
    private static final Log log = LogFactory.getLog(PSDEDataSyncGlobalModel.class);

    @Override
    protected PSDEDataSync GetObject(String strPSDEDataSyncId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDataSyncId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEDataSync OnCreateModelHelper(PSDEDataSync vt) throws Exception {
        PSDEDataSyncImpl iPSDEDataSync = new PSDEDataSyncImpl();
        iPSDEDataSync.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEDataSync;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEDataSync obj) {
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
    protected Vector<PSDEDataSync> getAllModels() throws Exception {
        Vector<PSDEDataSync> psDEDataSync = new Vector<PSDEDataSync>();
        CallResult callResult = this.iPSModelHelper.getPSDEDataSyncs(this.getPSDataEntity().getId(), psDEDataSync);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataSync;
    }

    @Override
    protected IPSDEDataSync registerModel(PSDEDataSync vt) throws Exception {
        IPSDEDataSync iPSDEDataSync = (IPSDEDataSync)this.InternalGetModelHelper(vt.getPSDEDATASYNCID());
        if (iPSDEDataSync != null) {
            return iPSDEDataSync;
        }
        this.setModel(vt.getPSDEDATASYNCID(), vt, null);
        return (IPSDEDataSync)this.FindModelHelper(vt.getPSDEDATASYNCID());
    }

    @Override
    protected String getObjectId(PSDEDataSync vt) {
        return vt.getPSDEDATASYNCID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20006, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEDataSync vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

