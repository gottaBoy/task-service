/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.dr.IPSDEDataRelation
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.dr;

import java.util.Vector;
import net.ibizsys.model.dataentity.PSDataEntityGlobalModelBase;
import net.ibizsys.model.dataentity.dr.IPSDEDataRelation;
import net.ibizsys.model.dataentity.dr.PSDEDataRelationImpl;
import net.ibizsys.model.entity.PSDEDataRelation;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDRGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEDataRelation, IPSDEDataRelation> {
    private static final Log log = LogFactory.getLog(PSDEDRGlobalModel.class);

    @Override
    protected PSDEDataRelation getObject(String strPSDEDataRelationId) {
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u5b9e\u4f53\u5173\u7cfb\u7ec4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDataRelationId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEDataRelation onCreateModelHelper(PSDEDataRelation vt) throws Exception {
        PSDEDataRelationImpl iPSDEDataRelation = new PSDEDataRelationImpl();
        iPSDEDataRelation.init(this.getPSModelStorageContext(), this.getPSDataEntity(), vt);
        return iPSDEDataRelation;
    }

    @Override
    protected Boolean testObjectRenew(PSDEDataRelation obj) {
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
    protected Vector<PSDEDataRelation> getAllModels() throws Exception {
        Vector<PSDEDataRelation> psDEDataRelation = new Vector<PSDEDataRelation>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEDataRelations(this.getPSDataEntity().getId(), psDEDataRelation);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u5b9e\u4f53\u5173\u7cfb\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataRelation;
    }

    @Override
    protected IPSDEDataRelation registerModel(PSDEDataRelation vt) throws Exception {
        IPSDEDataRelation iPSDEDataRelation = (IPSDEDataRelation)this.internalGetModelHelper(vt.getPSDEDATARELATIONID());
        if (iPSDEDataRelation != null) {
            return iPSDEDataRelation;
        }
        this.setModel(vt.getPSDEDATARELATIONID(), vt, null);
        return (IPSDEDataRelation)this.findModelHelper(vt.getPSDEDATARELATIONID());
    }

    @Override
    protected String getObjectId(PSDEDataRelation vt) {
        return vt.getPSDEDATARELATIONID();
    }

    @Override
    protected String getModelInfo() {
        return StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5173\u7cfb\u754c\u9762\u7ec4", (Object)this.getPSDataEntity().getName());
    }
}

