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
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Res.IPSSysSampleValue;
import SA.SRFDA.PS.Core.Res.PSSysSampleValueImpl;
import SA.SRFDA.PS.Data.PSSysSampleValue;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysSampleValueGlobalModel
extends PSSystemGlobalModelBase<String, PSSysSampleValue, IPSSysSampleValue> {
    private static final Log log = LogFactory.getLog(PSSysSampleValueGlobalModel.class);

    @Override
    protected PSSysSampleValue GetObject(String strPSSysSampleValueId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSSysSampleValue psSysSampleValue = new PSSysSampleValue();
        CallResult callResult = this.iPSModelHelper.getPSSysSampleValue(strPSSysSampleValueId, psSysSampleValue);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u793a\u4f8b\u503c[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysSampleValueId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysSampleValue;
    }

    @Override
    protected IPSSysSampleValue OnCreateModelHelper(PSSysSampleValue vt) throws Exception {
        PSSysSampleValueImpl iPSSysSampleValue = new PSSysSampleValueImpl();
        iPSSysSampleValue.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysSampleValue;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysSampleValue obj) {
        return false;
    }

    @Override
    protected IPSSysSampleValue registerModel(PSSysSampleValue vt) throws Exception {
        IPSSysSampleValue iPSSysSampleValue = (IPSSysSampleValue)this.InternalGetModelHelper(vt.getPSSYSSAMPLEVALUEID());
        if (iPSSysSampleValue != null) {
            return iPSSysSampleValue;
        }
        this.setModel(vt.getPSSYSSAMPLEVALUEID(), vt, null);
        iPSSysSampleValue = (IPSSysSampleValue)this.FindModelHelper(vt.getPSSYSSAMPLEVALUEID());
        return iPSSysSampleValue;
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
    protected Vector<PSSysSampleValue> getAllModels() throws Exception {
        Vector<PSSysSampleValue> list = new Vector<PSSysSampleValue>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysSampleValues(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u793a\u4f8b\u503c\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysSampleValue vt) {
        return vt.getPSSYSSAMPLEVALUEID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysSampleValue vt) {
        if (!net.ibizsys.paas.util.StringHelper.isNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

