/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQuery
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQueryCode
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.ds;

import java.util.Vector;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCode;
import net.ibizsys.model.dataentity.ds.PSDEDataQueryCodeImpl;
import net.ibizsys.model.entity.PSDEDataQueryCode;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataQueryCodeGlobalModel
extends PSGlobalModelBase<String, PSDEDataQueryCode, IPSDEDataQueryCode> {
    private static final Log log = LogFactory.getLog(PSDEDataQueryCodeGlobalModel.class);
    protected IPSDEDataQuery iPSDEDataQuery = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEDataQuery iPSDEDataQuery) throws Exception {
        this.iPSDEDataQuery = iPSDEDataQuery;
        super.init(iPSModelStorageContext);
    }

    protected IPSDEDataQuery getPSDEDataQuery() {
        return this.iPSDEDataQuery;
    }

    @Override
    protected PSDEDataQueryCode getObject(String strPSDEDataQueryCodeId) {
        PSDEDataQueryCode psDEDataQueryCode = new PSDEDataQueryCode();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEDataQueryCode(strPSDEDataQueryCodeId, psDEDataQueryCode);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u4ee3\u7801[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDataQueryCodeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDEDataQueryCode;
    }

    @Override
    protected IPSDEDataQueryCode onCreateModelHelper(PSDEDataQueryCode vt) throws Exception {
        PSDEDataQueryCodeImpl iPSDEDataQueryCode = new PSDEDataQueryCodeImpl();
        iPSDEDataQueryCode.init(this.getPSModelStorageContext(), this.getPSDEDataQuery(), vt);
        return iPSDEDataQueryCode;
    }

    @Override
    protected Boolean testObjectRenew(PSDEDataQueryCode obj) {
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
        IPSDEDataQueryCode iPSDEDataQueryCode = (IPSDEDataQueryCode)this.internalGetModelHelper(vt.getPSDEDQCODEID());
        if (iPSDEDataQueryCode != null) {
            return iPSDEDataQueryCode;
        }
        this.setModel(vt.getPSDEDQCODEID(), vt, null);
        return (IPSDEDataQueryCode)this.findModelHelper(vt.getPSDEDQCODEID());
    }

    @Override
    protected Vector<PSDEDataQueryCode> getAllModels() throws Exception {
        Vector<PSDEDataQueryCode> psDEDataQueryCodeList = new Vector<PSDEDataQueryCode>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEDataQueryCodes(this.getPSDEDataQuery().getId(), psDEDataQueryCodeList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u6570\u636e\u67e5\u8be2\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataQueryCodeList;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSDEDataQuery).getPSSysModelInstId();
    }

    @Override
    public String getPSDynaInstId() {
        if (this.iPSDEDataQuery != null) {
            return ((IPSModelObjectRuntime)this.iPSDEDataQuery).getPSDynaInstId();
        }
        return super.getPSDynaInstId();
    }

    @Override
    protected String getObjectId(PSDEDataQueryCode vt) {
        return vt.getPSDEDQCODEID();
    }
}

