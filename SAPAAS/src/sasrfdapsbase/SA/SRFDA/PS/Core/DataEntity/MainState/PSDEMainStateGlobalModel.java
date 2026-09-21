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

import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.MainState.PSDEMainStateImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEMainState;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEMainStateGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEMainState, IPSDEMainState> {
    private static final Log log = LogFactory.getLog(PSDEMainStateGlobalModel.class);

    @Override
    protected PSDEMainState GetObject(String strPSDEMainStateId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u4e3b\u72b6\u6001[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEMainStateId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEMainState OnCreateModelHelper(PSDEMainState vt) throws Exception {
        PSDEMainStateImpl iPSDEMainState = new PSDEMainStateImpl();
        iPSDEMainState.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEMainState;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEMainState obj) {
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
    protected Vector<PSDEMainState> getAllModels() throws Exception {
        Vector<PSDEMainState> psDEMainState = new Vector<PSDEMainState>();
        CallResult callResult = this.iPSModelHelper.getPSDEMainStates(this.getPSDataEntity().getId(), psDEMainState);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u4e3b\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEMainState;
    }

    @Override
    protected IPSDEMainState registerModel(PSDEMainState vt) throws Exception {
        IPSDEMainState iPSDEMainState = (IPSDEMainState)this.InternalGetModelHelper(vt.getPSDEMAINSTATEID());
        if (iPSDEMainState != null) {
            return iPSDEMainState;
        }
        this.setModel(vt.getPSDEMAINSTATEID(), vt, null);
        return (IPSDEMainState)this.FindModelHelper(vt.getPSDEMAINSTATEID());
    }

    @Override
    protected String getObjectId(PSDEMainState vt) {
        return vt.getPSDEMAINSTATEID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEMainState vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

