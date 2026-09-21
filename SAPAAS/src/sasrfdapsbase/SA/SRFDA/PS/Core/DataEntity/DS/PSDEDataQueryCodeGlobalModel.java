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

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCode;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataQueryCodeImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEDataQueryCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataQueryCodeGlobalModel
extends PSGlobalModelBase<String, PSDEDataQueryCode, IPSDEDataQueryCode> {
    private static final Log log = LogFactory.getLog(PSDEDataQueryCodeGlobalModel.class);
    protected IPSDEDataQuery iPSDEDataQuery = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataQuery iPSDEDataQuery) {
        this.iPSDEDataQuery = iPSDEDataQuery;
        return super.Init(iDAGlobalHelper);
    }

    protected IPSDEDataQuery getPSDEDataQuery() {
        return this.iPSDEDataQuery;
    }

    @Override
    protected PSDEDataQueryCode GetObject(String strPSDEDataQueryCodeId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSDEDataQueryCode psDEDataQueryCode = new PSDEDataQueryCode();
        CallResult callResult = this.iPSModelHelper.getPSDEDataQueryCode(this.getPSDEDataQuery().getId(), strPSDEDataQueryCodeId, psDEDataQueryCode);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u4ee3\u7801[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDataQueryCodeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDEDataQueryCode;
    }

    @Override
    protected IPSDEDataQueryCode OnCreateModelHelper(PSDEDataQueryCode vt) throws Exception {
        PSDEDataQueryCodeImpl iPSDEDataQueryCode = new PSDEDataQueryCodeImpl();
        iPSDEDataQueryCode.init(this.iDAGlobalHelper, this.getPSDEDataQuery(), vt);
        return iPSDEDataQueryCode;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEDataQueryCode obj) {
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
    protected IPSDEDataQueryCode registerModel(PSDEDataQueryCode vt) throws Exception {
        IPSDEDataQueryCode iPSDEDataQueryCode = (IPSDEDataQueryCode)this.InternalGetModelHelper(vt.getPSDEDQCODEID());
        if (iPSDEDataQueryCode != null) {
            return iPSDEDataQueryCode;
        }
        this.setModel(vt.getPSDEDQCODEID(), vt, null);
        return (IPSDEDataQueryCode)this.FindModelHelper(vt.getPSDEDQCODEID());
    }

    @Override
    protected Vector<PSDEDataQueryCode> getAllModels() throws Exception {
        Vector<PSDEDataQueryCode> psDEDataQueryCodeList = new Vector<PSDEDataQueryCode>();
        CallResult callResult = this.iPSModelHelper.getPSDEDataQueryCodes(this.getPSDEDataQuery().getId(), psDEDataQueryCodeList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u6570\u636e\u67e5\u8be2\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataQueryCodeList;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDataQuery.getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSDEDataQueryCode vt) {
        return vt.getPSDEDQCODEID();
    }
}

