/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQueryCode
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeCond
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
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeCond;
import net.ibizsys.model.dataentity.ds.PSDEDataQueryCodeCondImp;
import net.ibizsys.model.entity.PSDEDataQueryCodeCond;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataQueryCodeCondGlobalModel
extends PSGlobalModelBase<String, PSDEDataQueryCodeCond, IPSDEDataQueryCodeCond> {
    private static final Log log = LogFactory.getLog(PSDEDataQueryCodeCondGlobalModel.class);
    protected IPSDEDataQueryCode iPSDEDataQueryCode = null;
    private static final PSDEDataQueryCodeCond PSDEDATAQUERYCODECOND = new PSDEDataQueryCodeCond();

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEDataQueryCode iPSDEDataQueryCode) throws Exception {
        this.iPSDEDataQueryCode = iPSDEDataQueryCode;
        super.init(iPSModelStorageContext);
    }

    protected IPSDEDataQueryCode getPSDEDataQueryCode() {
        return this.iPSDEDataQueryCode;
    }

    @Override
    protected PSDEDataQueryCodeCond getObject(String strPSDEDataQueryCodeCondId) {
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u4ee3\u7801\u6761\u4ef6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDataQueryCodeCondId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEDataQueryCodeCond onCreateModelHelper(PSDEDataQueryCodeCond vt) throws Exception {
        PSDEDataQueryCodeCondImp iPSDEDataQueryCodeCond = new PSDEDataQueryCodeCondImp();
        iPSDEDataQueryCodeCond.init(this.getPSModelStorageContext(), this.getPSDEDataQueryCode(), vt);
        return iPSDEDataQueryCodeCond;
    }

    @Override
    protected Boolean testObjectRenew(PSDEDataQueryCodeCond obj) {
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
        IPSDEDataQueryCodeCond iPSDEDataQueryCodeCond = (IPSDEDataQueryCodeCond)this.internalGetModelHelper(vt.getPSDEDQCODECONDID());
        if (iPSDEDataQueryCodeCond != null) {
            return iPSDEDataQueryCodeCond;
        }
        this.setModel(vt.getPSDEDQCODECONDID(), vt, null);
        iPSDEDataQueryCodeCond = (IPSDEDataQueryCodeCond)this.findModelHelper(vt.getPSDEDQCODECONDID());
        this.setModel(vt.getPSDEDQCODECONDID(), PSDEDATAQUERYCODECOND, iPSDEDataQueryCodeCond);
        return iPSDEDataQueryCodeCond;
    }

    @Override
    protected Vector<PSDEDataQueryCodeCond> getAllModels() throws Exception {
        Vector<PSDEDataQueryCodeCond> psDEDataQueryCodeCondList = new Vector<PSDEDataQueryCodeCond>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEDataQueryCodeConds(this.getPSDEDataQueryCode().getId(), psDEDataQueryCodeCondList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u6570\u636e\u67e5\u8be2\u4ee3\u7801\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataQueryCodeCondList;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSDEDataQueryCode).getPSSysModelInstId();
    }

    @Override
    protected String getObjectId(PSDEDataQueryCodeCond vt) {
        return vt.getPSDEDQCODECONDID();
    }

    @Override
    public String getPSDynaInstId() {
        if (this.iPSDEDataQueryCode != null) {
            return ((IPSModelObjectRuntime)this.iPSDEDataQueryCode).getPSDynaInstId();
        }
        return super.getPSDynaInstId();
    }
}

