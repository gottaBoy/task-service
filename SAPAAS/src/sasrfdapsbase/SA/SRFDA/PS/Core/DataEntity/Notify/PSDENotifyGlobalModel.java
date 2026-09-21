/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Notify;

import SA.SRFDA.PS.Core.DataEntity.Notify.IPSDENotify;
import SA.SRFDA.PS.Core.DataEntity.Notify.PSDENotifyImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSDENotify;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDENotifyGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDENotify, IPSDENotify> {
    private static final Log log = LogFactory.getLog(PSDENotifyGlobalModel.class);

    @Override
    protected PSDENotify GetObject(String strPSDENotifyId) {
        if (this.isPrepareModels()) {
            return null;
        }
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u901a\u77e5[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDENotifyId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDENotify OnCreateModelHelper(PSDENotify vt) throws Exception {
        PSDENotifyImpl iPSDENotify = new PSDENotifyImpl();
        iPSDENotify.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDENotify;
    }

    @Override
    protected Boolean TestObjectRenew(PSDENotify obj) {
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
    protected Vector<PSDENotify> getAllModels() throws Exception {
        Vector<PSDENotify> psDENotify = new Vector<PSDENotify>();
        CallResult callResult = this.iPSModelHelper.getPSDENotifies(this.getPSDataEntity().getId(), psDENotify);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u901a\u77e5\u5bfc\u5165\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDENotify;
    }

    @Override
    protected IPSDENotify registerModel(PSDENotify vt) throws Exception {
        IPSDENotify iPSDENotify = (IPSDENotify)this.InternalGetModelHelper(vt.getPSDENOTIFYID());
        if (iPSDENotify != null) {
            return iPSDENotify;
        }
        this.setModel(vt.getPSDENOTIFYID(), vt, null);
        iPSDENotify = (IPSDENotify)this.FindModelHelper(vt.getPSDENOTIFYID());
        return iPSDENotify;
    }

    @Override
    protected String getObjectId(PSDENotify vt) {
        return vt.getPSDENOTIFYID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20030, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDENotify vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

