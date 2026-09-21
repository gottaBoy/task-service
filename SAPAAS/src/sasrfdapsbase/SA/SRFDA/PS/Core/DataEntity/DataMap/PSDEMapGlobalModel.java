/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataMap;

import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMap;
import SA.SRFDA.PS.Core.DataEntity.DataMap.PSDEMapImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEMap;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEMapGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEMap, IPSDEMap> {
    private static final Log log = LogFactory.getLog(PSDEMapGlobalModel.class);

    @Override
    protected PSDEMap GetObject(String strPSDEMapId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u6620\u5c04[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEMapId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEMap OnCreateModelHelper(PSDEMap vt) throws Exception {
        PSDEMapImpl iPSDEMap = new PSDEMapImpl();
        iPSDEMap.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEMap;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEMap obj) {
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
    protected Vector<PSDEMap> getAllModels() throws Exception {
        Vector<PSDEMap> psDEMap = new Vector<PSDEMap>();
        CallResult callResult = this.iPSModelHelper.getPSDEMaps(this.getPSDataEntity().getId(), psDEMap);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u6570\u636e\u6620\u5c04\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEMap;
    }

    @Override
    protected IPSDEMap registerModel(PSDEMap vt) throws Exception {
        IPSDEMap iPSDEMap = (IPSDEMap)this.InternalGetModelHelper(vt.getPSDEMAPID());
        if (iPSDEMap != null) {
            return iPSDEMap;
        }
        this.setModel(vt.getPSDEMAPID(), vt, null);
        return (IPSDEMap)this.FindModelHelper(vt.getPSDEMAPID());
    }

    @Override
    protected String getObjectId(PSDEMap vt) {
        return vt.getPSDEMAPID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20005, objObjectId);
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEMap vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

