/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Counter;

import SA.SRFDA.PS.Core.Control.Counter.IPSCounterType;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysCounter;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysCounterGlobalModel
extends PSSystemGlobalModelBase<String, PSSysCounter, IPSSysCounter> {
    private static final Log log = LogFactory.getLog(PSSysCounterGlobalModel.class);

    @Override
    protected PSSysCounter GetObject(String strPSSysCounterId) {
        PSSysCounter psSysCounter = new PSSysCounter();
        CallResult callResult = this.iPSModelHelper.getPSSysCounter(strPSSysCounterId, psSysCounter);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u8ba1\u6570\u5668[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysCounterId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysCounter;
    }

    @Override
    protected IPSSysCounter OnCreateModelHelper(PSSysCounter vt) throws Exception {
        IPSCounterType iPSCounterType = this.iPSModelStorage.getPSCounterType(vt.getCOUNTERTYPE());
        IPSSysCounter iPSSysCounter = iPSCounterType.createPSSysCounter(vt);
        iPSSysCounter.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysCounter;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysCounter obj) {
        return false;
    }

    @Override
    protected IPSSysCounter registerModel(PSSysCounter vt) throws Exception {
        IPSSysCounter iPSSysCounter = (IPSSysCounter)this.InternalGetModelHelper(vt.getPSSYSCOUNTERID());
        if (iPSSysCounter != null) {
            return iPSSysCounter;
        }
        this.setModel(vt.getPSSYSCOUNTERID(), vt, null);
        iPSSysCounter = (IPSSysCounter)this.FindModelHelper(vt.getPSSYSCOUNTERID());
        return iPSSysCounter;
    }

    @Override
    protected Vector<PSSysCounter> getAllModels() throws Exception {
        Vector<PSSysCounter> list = new Vector<PSSysCounter>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysCounters(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u8ba1\u6570\u5668\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysCounter vt) {
        return vt.getPSSYSCOUNTERID();
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
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysCounter vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

