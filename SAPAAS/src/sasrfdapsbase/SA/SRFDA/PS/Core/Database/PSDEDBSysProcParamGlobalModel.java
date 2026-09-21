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
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDBProcParam;
import SA.SRFDA.PS.Core.Database.IPSDEDBSysProcCode;
import SA.SRFDA.PS.Core.Database.PSDBProcParamImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDBProcParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEDBSysProcParamGlobalModel
extends PSGlobalModelBase<String, PSDBProcParam, IPSDBProcParam> {
    private static final Log log = LogFactory.getLog(PSDEDBSysProcParamGlobalModel.class);
    protected IPSDEDBSysProcCode iPSDEDBSysProcCode = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDBSysProcCode iPSDEDBSysProcCode) {
        this.iPSDEDBSysProcCode = iPSDEDBSysProcCode;
        return super.Init(iDAGlobalHelper);
    }

    @Override
    protected PSDBProcParam GetObject(String strPSDBProcParamId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b58\u50a8\u8fc7\u7a0b\u53c2\u6570[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDBProcParamId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDBProcParam OnCreateModelHelper(PSDBProcParam vt) throws Exception {
        PSDBProcParamImpl iPSDBProcParam = new PSDBProcParamImpl();
        iPSDBProcParam.init(this.iDAGlobalHelper, this.iPSDEDBSysProcCode, vt);
        return iPSDBProcParam;
    }

    @Override
    protected Boolean TestObjectRenew(PSDBProcParam obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        Vector<PSDBProcParam> psDBProcParamList = new Vector<PSDBProcParam>();
        CallResult callResult = this.iPSModelHelper.getPSDBSysProcParams(this.iPSDEDBSysProcCode.getId(), psDBProcParamList);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b58\u50a8\u8fc7\u7a0b\u53c2\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        for (PSDBProcParam psDBProcParam : psDBProcParamList) {
            this.setModel(psDBProcParam.getPSDBPROCPARAMID(), psDBProcParam, null);
        }
    }

    @Override
    protected IPSDBProcParam registerModel(PSDBProcParam vt) throws Exception {
        IPSDBProcParam iPSDBProcParam = (IPSDBProcParam)this.FindModelHelper(vt.getPSDBPROCPARAMID(), true);
        if (iPSDBProcParam != null) {
            return iPSDBProcParam;
        }
        return (IPSDBProcParam)this.FindModelHelper(vt.getPSDBPROCPARAMID(), vt);
    }

    @Override
    protected Vector<PSDBProcParam> getAllModels() throws Exception {
        Vector<PSDBProcParam> psDBProcParamList = new Vector<PSDBProcParam>();
        CallResult callResult = this.iPSModelHelper.getPSDBSysProcParams(this.iPSDEDBSysProcCode.getId(), psDBProcParamList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b58\u50a8\u8fc7\u7a0b\u53c2\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDBProcParamList;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDBSysProcCode.getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSDBProcParam vt) {
        return vt.getPSDBPROCPARAMID();
    }
}

