/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.AC;

import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.AC.PSDEACModeImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEACMode;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEACModeGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEACMode, IPSDEACMode> {
    private static final Log log = LogFactory.getLog(PSDEACModeGlobalModel.class);

    @Override
    protected PSDEACMode GetObject(String strPSDEACModeId) {
        if (this.isPrepareModels()) {
            return null;
        }
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEACModeId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEACMode OnCreateModelHelper(PSDEACMode vt, String objObjectId) throws Exception {
        PSDEACModeImpl iPSDEACMode = new PSDEACModeImpl();
        iPSDEACMode.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEACMode;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEACMode obj) {
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
    protected IPSDEACMode registerModel(PSDEACMode vt) throws Exception {
        IPSDEACMode iPSDEACMode = (IPSDEACMode)this.InternalGetModelHelper(vt.getPSDEACMODEID());
        if (iPSDEACMode != null) {
            return iPSDEACMode;
        }
        this.setModel(vt.getPSDEACMODEID(), vt, null);
        iPSDEACMode = (IPSDEACMode)this.FindModelHelper(vt.getPSDEACMODEID());
        return iPSDEACMode;
    }

    @Override
    protected Vector<PSDEACMode> getAllModels() throws Exception {
        Vector<PSDEACMode> psDEACModeList = new Vector<PSDEACMode>();
        CallResult callResult = this.iPSModelHelper.getPSDEACModes(this.getPSDataEntity().getId(), psDEACModeList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u81ea\u586b\u6a21\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEACModeList;
    }

    @Override
    protected String getObjectId(PSDEACMode vt) {
        return vt.getPSDEACMODEID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEACMode vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20004, objObjectId);
    }
}

