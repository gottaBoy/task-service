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

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCodeCond;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataQueryCodeCondImp;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEDataQueryCodeCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataQueryCodeCondGlobalModel
extends PSGlobalModelBase<String, PSDEDataQueryCodeCond, IPSDEDataQueryCodeCond> {
    private static final Log log = LogFactory.getLog(PSDEDataQueryCodeCondGlobalModel.class);
    protected IPSDEDataQueryCode iPSDEDataQueryCode = null;
    private static final PSDEDataQueryCodeCond PSDEDATAQUERYCODECOND = new PSDEDataQueryCodeCond();

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataQueryCode iPSDEDataQueryCode) {
        this.iPSDEDataQueryCode = iPSDEDataQueryCode;
        return super.Init(iDAGlobalHelper);
    }

    protected IPSDEDataQueryCode getPSDEDataQueryCode() {
        return this.iPSDEDataQueryCode;
    }

    @Override
    protected PSDEDataQueryCodeCond GetObject(String strPSDEDataQueryCodeCondId) {
        if (this.isPrepareModels()) {
            return null;
        }
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u4ee3\u7801\u6761\u4ef6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDataQueryCodeCondId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEDataQueryCodeCond OnCreateModelHelper(PSDEDataQueryCodeCond vt) throws Exception {
        PSDEDataQueryCodeCondImp iPSDEDataQueryCodeCond = new PSDEDataQueryCodeCondImp();
        iPSDEDataQueryCodeCond.init(this.iDAGlobalHelper, this.getPSDEDataQueryCode(), vt);
        return iPSDEDataQueryCodeCond;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEDataQueryCodeCond obj) {
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
    protected IPSDEDataQueryCodeCond registerModel(PSDEDataQueryCodeCond vt) throws Exception {
        IPSDEDataQueryCodeCond iPSDEDataQueryCodeCond = (IPSDEDataQueryCodeCond)this.InternalGetModelHelper(vt.getPSDEDQCODECONDID());
        if (iPSDEDataQueryCodeCond != null) {
            return iPSDEDataQueryCodeCond;
        }
        this.setModel(vt.getPSDEDQCODECONDID(), vt, null);
        iPSDEDataQueryCodeCond = (IPSDEDataQueryCodeCond)this.FindModelHelper(vt.getPSDEDQCODECONDID());
        this.setModel(vt.getPSDEDQCODECONDID(), PSDEDATAQUERYCODECOND, iPSDEDataQueryCodeCond);
        return iPSDEDataQueryCodeCond;
    }

    @Override
    protected Vector<PSDEDataQueryCodeCond> getAllModels() throws Exception {
        Vector<PSDEDataQueryCodeCond> psDEDataQueryCodeCondList = new Vector<PSDEDataQueryCodeCond>();
        CallResult callResult = this.iPSModelHelper.getPSDEDataQueryCodeConds(this.getPSDEDataQueryCode().getId(), psDEDataQueryCodeCondList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u6570\u636e\u67e5\u8be2\u4ee3\u7801\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataQueryCodeCondList;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDataQueryCode.getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSDEDataQueryCodeCond vt) {
        return vt.getPSDEDQCODECONDID();
    }
}

