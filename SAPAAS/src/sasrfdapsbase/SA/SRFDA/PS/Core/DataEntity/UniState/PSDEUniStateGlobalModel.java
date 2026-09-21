/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.UniState;

import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.UniState.IPSDEUniState;
import SA.SRFDA.PS.Core.DataEntity.UniState.PSDEUniStateImpl;
import SA.SRFDA.PS.Data.PSSysUniState;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUniStateGlobalModel
extends PSDataEntityGlobalModelBase<String, PSSysUniState, IPSDEUniState> {
    private static final Log log = LogFactory.getLog(PSDEUniStateGlobalModel.class);
    private IPSDEUniState defaultPSDEUniState = null;

    @Override
    protected PSSysUniState GetObject(String strPSDEUniStateId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u7edf\u4e00\u72b6\u6001\u914d\u7f6e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEUniStateId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEUniState OnCreateModelHelper(PSSysUniState vt) throws Exception {
        PSDEUniStateImpl iPSDEUniState = new PSDEUniStateImpl();
        iPSDEUniState.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEUniState;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysUniState obj) {
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
    protected Vector<PSSysUniState> getAllModels() throws Exception {
        Vector<PSSysUniState> psWFDEList = new Vector<PSSysUniState>();
        CallResult callResult = this.iPSModelHelper.getPSDEUniStates(this.getPSDataEntity().getId(), psWFDEList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u7edf\u4e00\u72b6\u6001\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psWFDEList;
    }

    @Override
    protected IPSDEUniState registerModel(PSSysUniState vt) throws Exception {
        IPSDEUniState iPSUniState = (IPSDEUniState)this.InternalGetModelHelper(vt.getPSSYSUNISTATEID());
        if (iPSUniState != null) {
            return iPSUniState;
        }
        this.setModel(vt.getPSSYSUNISTATEID(), vt, null);
        IPSDEUniState iPSDEUniState = (IPSDEUniState)this.FindModelHelper(vt.getPSSYSUNISTATEID());
        if (iPSDEUniState.isDefault()) {
            this.defaultPSDEUniState = iPSDEUniState;
        }
        return iPSDEUniState;
    }

    @Override
    protected String getObjectId(PSSysUniState vt) {
        return vt.getPSSYSUNISTATEID();
    }

    public IPSDEUniState getDefaultPSDEUniState() {
        this.preloadModels();
        return this.defaultPSDEUniState;
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysUniState vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

