/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQueryCode
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeExp
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
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCode;
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeExp;
import net.ibizsys.model.dataentity.ds.PSDEDataQueryCodeExpImp;
import net.ibizsys.model.entity.PSDEDataQueryCodeExp;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataQueryCodeExpGlobalModel
extends PSGlobalModelBase<String, PSDEDataQueryCodeExp, IPSDEDataQueryCodeExp> {
    private static final Log log = LogFactory.getLog(PSDEDataQueryCodeExpGlobalModel.class);
    protected IPSDEDataQueryCode iPSDEDataQueryCode = null;
    private static final PSDEDataQueryCodeExp PSDEDATAQUERYCODEEXP = new PSDEDataQueryCodeExp();

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEDataQueryCode iPSDEDataQueryCode) throws Exception {
        this.iPSDEDataQueryCode = iPSDEDataQueryCode;
        super.init(iPSModelStorageContext);
    }

    protected IPSDEDataQueryCode getPSDEDataQueryCode() {
        return this.iPSDEDataQueryCode;
    }

    @Override
    protected PSDEDataQueryCodeExp getObject(String strPSDEDataQueryCodeExpId) {
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u4ee3\u7801\u8868\u8fbe\u5f0f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDataQueryCodeExpId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEDataQueryCodeExp onCreateModelHelper(PSDEDataQueryCodeExp vt) throws Exception {
        PSDEDataQueryCodeExpImp iPSDEDataQueryCodeExp = new PSDEDataQueryCodeExpImp();
        iPSDEDataQueryCodeExp.init(this.getPSModelStorageContext(), this.getPSDEDataQueryCode(), vt);
        return iPSDEDataQueryCodeExp;
    }

    @Override
    protected Boolean testObjectRenew(PSDEDataQueryCodeExp obj) {
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
        IPSDEDataQueryCodeExp iPSDEDataQueryCodeExp = (IPSDEDataQueryCodeExp)this.internalGetModelHelper(vt.getPSDEDQCODEEXPID());
        if (iPSDEDataQueryCodeExp != null) {
            return iPSDEDataQueryCodeExp;
        }
        this.setModel(vt.getPSDEDQCODEEXPID(), vt, null);
        iPSDEDataQueryCodeExp = (IPSDEDataQueryCodeExp)this.findModelHelper(vt.getPSDEDQCODEEXPID());
        this.setModel(vt.getPSDEDQCODEEXPID(), PSDEDATAQUERYCODEEXP, iPSDEDataQueryCodeExp);
        return iPSDEDataQueryCodeExp;
    }

    @Override
    protected Vector<PSDEDataQueryCodeExp> getAllModels() throws Exception {
        Vector<PSDEDataQueryCodeExp> psDEDataQueryCodeExpList = new Vector<PSDEDataQueryCodeExp>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEDataQueryCodeExps(this.getPSDEDataQueryCode().getId(), psDEDataQueryCodeExpList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u6570\u636e\u67e5\u8be2\u4ee3\u7801\u8868\u8fbe\u5f0f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataQueryCodeExpList;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSDEDataQueryCode).getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSDEDataQueryCodeExp vt) {
        return vt.getPSDEDQCODEEXPID();
    }

    @Override
    public String getPSDynaInstId() {
        if (this.iPSDEDataQueryCode != null) {
            return ((IPSModelObjectRuntime)this.iPSDEDataQueryCode).getPSDynaInstId();
        }
        return super.getPSDynaInstId();
    }
}

