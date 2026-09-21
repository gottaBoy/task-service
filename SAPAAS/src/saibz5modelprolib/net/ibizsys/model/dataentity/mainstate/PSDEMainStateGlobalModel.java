/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.mainstate.IPSDEMainState
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.mainstate;

import java.util.Vector;
import net.ibizsys.model.dataentity.PSDataEntityGlobalModelBase;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainState;
import net.ibizsys.model.dataentity.mainstate.PSDEMainStateImpl;
import net.ibizsys.model.entity.PSDEMainState;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEMainStateGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEMainState, IPSDEMainState> {
    private static final Log log = LogFactory.getLog(PSDEMainStateGlobalModel.class);

    @Override
    protected PSDEMainState getObject(String strPSDEMainStateId) {
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u4e3b\u72b6\u6001[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEMainStateId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEMainState onCreateModelHelper(PSDEMainState vt) throws Exception {
        PSDEMainStateImpl iPSDEMainState = new PSDEMainStateImpl();
        iPSDEMainState.init(this.getPSModelStorageContext(), this.getPSDataEntity(), vt);
        return iPSDEMainState;
    }

    @Override
    protected Boolean testObjectRenew(PSDEMainState obj) {
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
        CallResult callResult = this.getPSModelQueryHelper().getPSDEMainStates(this.getPSDataEntity().getId(), psDEMainState);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u4e3b\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEMainState;
    }

    @Override
    protected IPSDEMainState registerModel(PSDEMainState vt) throws Exception {
        IPSDEMainState iPSDEMainState = (IPSDEMainState)this.internalGetModelHelper(vt.getPSDEMAINSTATEID());
        if (iPSDEMainState != null) {
            return iPSDEMainState;
        }
        this.setModel(vt.getPSDEMAINSTATEID(), vt, null);
        return (IPSDEMainState)this.findModelHelper(vt.getPSDEMAINSTATEID());
    }

    @Override
    protected String getObjectId(PSDEMainState vt) {
        return vt.getPSDEMAINSTATEID();
    }
}

