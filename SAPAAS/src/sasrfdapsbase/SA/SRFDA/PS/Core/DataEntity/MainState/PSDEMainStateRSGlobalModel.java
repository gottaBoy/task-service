/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.MainState;

import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateRS;
import SA.SRFDA.PS.Core.DataEntity.MainState.PSDEMainStateRSImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEMainStateRS;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEMainStateRSGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEMainStateRS, IPSDEMainStateRS> {
    private static final Log log = LogFactory.getLog(PSDEMainStateRSGlobalModel.class);

    @Override
    protected PSDEMainStateRS GetObject(String strPSDEMainStateRSId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u4e3b\u72b6\u6001\u5173\u7cfb[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEMainStateRSId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEMainStateRS OnCreateModelHelper(PSDEMainStateRS vt) throws Exception {
        PSDEMainStateRSImpl iPSDEMainStateRS = new PSDEMainStateRSImpl();
        iPSDEMainStateRS.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEMainStateRS;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEMainStateRS obj) {
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
    protected Vector<PSDEMainStateRS> getAllModels() throws Exception {
        Vector<PSDEMainStateRS> psDEMainStateRS = new Vector<PSDEMainStateRS>();
        CallResult callResult = this.iPSModelHelper.getPSDEMainStateRSs(this.getPSDataEntity().getId(), psDEMainStateRS);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u4e3b\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEMainStateRS;
    }

    @Override
    protected IPSDEMainStateRS registerModel(PSDEMainStateRS vt) throws Exception {
        IPSDEMainStateRS iPSDEMainStateRS = (IPSDEMainStateRS)this.InternalGetModelHelper(vt.getPSDEMAINSTATERSID());
        if (iPSDEMainStateRS != null) {
            return iPSDEMainStateRS;
        }
        this.setModel(vt.getPSDEMAINSTATERSID(), vt, null);
        return (IPSDEMainStateRS)this.FindModelHelper(vt.getPSDEMAINSTATERSID());
    }

    @Override
    protected String getObjectId(PSDEMainStateRS vt) {
        return vt.getPSDEMAINSTATERSID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEMainStateRS vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

