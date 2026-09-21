/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DR;

import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDataRelation;
import SA.SRFDA.PS.Core.DataEntity.DR.PSDEDataRelationImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEDataRelation;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDRGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEDataRelation, IPSDEDataRelation> {
    private static final Log log = LogFactory.getLog(PSDEDRGlobalModel.class);

    @Override
    protected PSDEDataRelation GetObject(String strPSDEDataRelationId) {
        if (this.isPrepareModels()) {
            return null;
        }
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7ec4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDataRelationId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEDataRelation OnCreateModelHelper(PSDEDataRelation vt) throws Exception {
        PSDEDataRelationImpl iPSDEDataRelation = new PSDEDataRelationImpl();
        iPSDEDataRelation.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEDataRelation;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEDataRelation obj) {
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
        CallResult callResult = this.iPSModelHelper.getPSDEDataRelations(this.getPSDataEntity().getId(), psDEDataRelation);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5b9e\u4f53\u5173\u7cfb\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataRelation;
    }

    @Override
    protected IPSDEDataRelation registerModel(PSDEDataRelation vt) throws Exception {
        IPSDEDataRelation iPSDEDataRelation = (IPSDEDataRelation)this.InternalGetModelHelper(vt.getPSDEDATARELATIONID());
        if (iPSDEDataRelation != null) {
            return iPSDEDataRelation;
        }
        this.setModel(vt.getPSDEDATARELATIONID(), vt, null);
        return (IPSDEDataRelation)this.FindModelHelper(vt.getPSDEDATARELATIONID());
    }

    @Override
    protected String getObjectId(PSDEDataRelation vt) {
        return vt.getPSDEDATARELATIONID();
    }

    @Override
    protected String getModelInfo() {
        return StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5173\u7cfb\u754c\u9762\u7ec4", (Object)this.getPSDataEntity().getName());
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEDataRelation vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

