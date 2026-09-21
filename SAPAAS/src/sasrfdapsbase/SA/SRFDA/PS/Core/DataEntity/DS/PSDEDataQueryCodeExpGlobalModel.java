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
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCodeExp;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataQueryCodeExpImp;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEDataQueryCodeExp;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataQueryCodeExpGlobalModel
extends PSGlobalModelBase<String, PSDEDataQueryCodeExp, IPSDEDataQueryCodeExp> {
    private static final Log log = LogFactory.getLog(PSDEDataQueryCodeExpGlobalModel.class);
    protected IPSDEDataQueryCode iPSDEDataQueryCode = null;
    private static final PSDEDataQueryCodeExp PSDEDATAQUERYCODEEXP = new PSDEDataQueryCodeExp();

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataQueryCode iPSDEDataQueryCode) {
        this.iPSDEDataQueryCode = iPSDEDataQueryCode;
        return super.Init(iDAGlobalHelper);
    }

    protected IPSDEDataQueryCode getPSDEDataQueryCode() {
        return this.iPSDEDataQueryCode;
    }

    @Override
    protected PSDEDataQueryCodeExp GetObject(String strPSDEDataQueryCodeExpId) {
        if (this.isPrepareModels()) {
            return null;
        }
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u4ee3\u7801\u8868\u8fbe\u5f0f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDataQueryCodeExpId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEDataQueryCodeExp OnCreateModelHelper(PSDEDataQueryCodeExp vt) throws Exception {
        PSDEDataQueryCodeExpImp iPSDEDataQueryCodeExp = new PSDEDataQueryCodeExpImp();
        iPSDEDataQueryCodeExp.init(this.iDAGlobalHelper, this.getPSDEDataQueryCode(), vt);
        return iPSDEDataQueryCodeExp;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEDataQueryCodeExp obj) {
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
    protected IPSDEDataQueryCodeExp registerModel(PSDEDataQueryCodeExp vt) throws Exception {
        IPSDEDataQueryCodeExp iPSDEDataQueryCodeExp = (IPSDEDataQueryCodeExp)this.InternalGetModelHelper(vt.getPSDEDQCodeExpId());
        if (iPSDEDataQueryCodeExp != null) {
            return iPSDEDataQueryCodeExp;
        }
        this.setModel(vt.getPSDEDQCodeExpId(), vt, null);
        iPSDEDataQueryCodeExp = (IPSDEDataQueryCodeExp)this.FindModelHelper(vt.getPSDEDQCodeExpId());
        this.setModel(vt.getPSDEDQCodeExpId(), PSDEDATAQUERYCODEEXP, iPSDEDataQueryCodeExp);
        return iPSDEDataQueryCodeExp;
    }

    @Override
    protected Vector<PSDEDataQueryCodeExp> getAllModels() throws Exception {
        Vector<PSDEDataQueryCodeExp> psDEDataQueryCodeExpList = new Vector<PSDEDataQueryCodeExp>();
        CallResult callResult = this.iPSModelHelper.getPSDEDataQueryCodeExps(this.getPSDEDataQueryCode().getId(), psDEDataQueryCodeExpList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u6570\u636e\u67e5\u8be2\u4ee3\u7801\u8868\u8fbe\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataQueryCodeExpList;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDataQueryCode.getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSDEDataQueryCodeExp vt) {
        return vt.getPSDEDQCodeExpId();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEDataQueryCodeExp vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getPSDEDQCodeExpName())) {
            return new String[]{vt.getPSDEDQCodeExpName().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

