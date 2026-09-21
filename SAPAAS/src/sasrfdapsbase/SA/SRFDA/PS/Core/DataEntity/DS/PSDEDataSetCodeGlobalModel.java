/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetCode;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataSetCodeImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEDataSetCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataSetCodeGlobalModel
extends PSGlobalModelBase<String, PSDEDataSetCode, IPSDEDataSetCode> {
    private static final Log log = LogFactory.getLog(PSDEDataSetCodeGlobalModel.class);
    protected IPSDEDataSet iPSDEDataSet = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataSet iPSDEDataSet) {
        this.iPSDEDataSet = iPSDEDataSet;
        return super.Init(iDAGlobalHelper);
    }

    @Override
    protected PSDEDataSetCode GetObject(String strPSDEDataSetCodeId) {
        PSDEDataSetCode psDEDataSetCode = new PSDEDataSetCode();
        CallResult callResult = this.iPSModelHelper.getPSDEDataSetCode(this.iPSDEDataSet.getId(), strPSDEDataSetCodeId, psDEDataSetCode);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u4ee3\u7801[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDataSetCodeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDEDataSetCode;
    }

    @Override
    protected IPSDEDataSetCode OnCreateModelHelper(PSDEDataSetCode vt) throws Exception {
        PSDEDataSetCodeImpl iPSDEDataSetCode = new PSDEDataSetCodeImpl();
        iPSDEDataSetCode.init(this.iDAGlobalHelper, this.iPSDEDataSet, vt);
        return iPSDEDataSetCode;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEDataSetCode obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        Vector<PSDEDataSetCode> psDEDataSetCodeList = new Vector<PSDEDataSetCode>();
        CallResult callResult = this.iPSModelHelper.getPSDEDataSetCodes(this.iPSDEDataSet.getId(), psDEDataSetCodeList);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        for (PSDEDataSetCode psDEDataSetCode : psDEDataSetCodeList) {
            this.setModel(psDEDataSetCode.getPSDEDSCODEID(), psDEDataSetCode, null);
        }
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDataSet.getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSDEDataSetCode vt) {
        return vt.getPSDEDSCODEID();
    }
}

