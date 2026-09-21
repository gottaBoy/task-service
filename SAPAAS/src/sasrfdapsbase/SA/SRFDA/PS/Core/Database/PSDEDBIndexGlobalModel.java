/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndex;
import SA.SRFDA.PS.Core.Database.PSDEDBIndexImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEDBIndex;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEDBIndexGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEDBIndex, IPSDEDBIndex> {
    private static final Log log = LogFactory.getLog(PSDEDBIndexGlobalModel.class);

    @Override
    protected PSDEDBIndex GetObject(String strPSDEDBIndexId) {
        return null;
    }

    @Override
    protected IPSDEDBIndex OnCreateModelHelper(PSDEDBIndex vt) throws Exception {
        PSDEDBIndexImpl iPSDEDBIndex = new PSDEDBIndexImpl();
        iPSDEDBIndex.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEDBIndex;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEDBIndex obj) {
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
    protected Vector<PSDEDBIndex> getAllModels() throws Exception {
        Vector<PSDEDBIndex> psDEDBIndexList = new Vector<PSDEDBIndex>();
        CallResult callResult = this.iPSModelHelper.getPSDEDBIndexs(this.getPSDataEntity().getId(), psDEDBIndexList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u6570\u636e\u5e93\u7d22\u5f15\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDBIndexList;
    }

    @Override
    protected IPSDEDBIndex registerModel(PSDEDBIndex vt) throws Exception {
        IPSDEDBIndex iPSDEDBIndex = (IPSDEDBIndex)this.InternalGetModelHelper(vt.getPSDEDBINDEXID());
        if (iPSDEDBIndex != null) {
            return iPSDEDBIndex;
        }
        this.setModel(vt.getPSDEDBINDEXID(), vt, null);
        return (IPSDEDBIndex)this.FindModelHelper(vt.getPSDEDBINDEXID());
    }

    @Override
    protected String getObjectId(PSDEDBIndex vt) {
        return vt.getPSDEDBINDEXID();
    }

    @Override
    protected String getModelInfo() {
        return StringHelper.Format((String)"%1$s[%2$s]", (Object)super.getModelInfo(), (Object)this.getPSDataEntity().getName());
    }
}

