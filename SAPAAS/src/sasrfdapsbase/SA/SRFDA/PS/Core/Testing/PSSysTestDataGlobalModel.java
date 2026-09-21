/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestData;
import SA.SRFDA.PS.Core.Testing.PSSysTestDataImpl;
import SA.SRFDA.PS.Data.PSSysTestData;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysTestDataGlobalModel
extends PSSystemGlobalModelBase<String, PSSysTestData, IPSSysTestData> {
    private static final Log log = LogFactory.getLog(PSSysTestDataGlobalModel.class);

    @Override
    protected PSSysTestData GetObject(String strPSSysTestDataId) {
        PSSysTestData psSysTestData = new PSSysTestData();
        CallResult callResult = this.iPSModelHelper.getPSSysTestData(strPSSysTestDataId, psSysTestData);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u6d4b\u8bd5\u6570\u636e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysTestDataId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysTestData;
    }

    @Override
    protected IPSSysTestData OnCreateModelHelper(PSSysTestData vt) throws Exception {
        PSSysTestDataImpl iPSSysTestData = null;
        iPSSysTestData = new PSSysTestDataImpl();
        iPSSysTestData.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysTestData;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysTestData obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysTestData registerModel(PSSysTestData vt) throws Exception {
        IPSSysTestData iIPSSysTestData = (IPSSysTestData)this.InternalGetModelHelper(vt.getPSSYSTESTDATAID());
        if (iIPSSysTestData != null) {
            return iIPSSysTestData;
        }
        this.setModel(vt.getPSSYSTESTDATAID(), vt, null);
        return (IPSSysTestData)this.FindModelHelper(vt.getPSSYSTESTDATAID());
    }

    @Override
    protected Vector<PSSysTestData> getAllModels() throws Exception {
        Vector<PSSysTestData> list = new Vector<PSSysTestData>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysTestDatas(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d4b\u8bd5\u6570\u636e\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysTestData vt) {
        return vt.getPSSYSTESTDATAID();
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

    protected String[] getObjectAliases(PSSysTestData vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

