/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Search;

import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.Search.IPSDESearch;
import SA.SRFDA.PS.Core.DataEntity.Search.PSDESearchImpl;
import SA.SRFDA.PS.Data.PSSysSearchDE;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDESearchGlobalModel
extends PSDataEntityGlobalModelBase<String, PSSysSearchDE, IPSDESearch> {
    private static final Log log = LogFactory.getLog(PSDESearchGlobalModel.class);

    @Override
    protected PSSysSearchDE GetObject(String strPSSysSearchDEId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5168\u6587\u68c0\u7d22\u914d\u7f6e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysSearchDEId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDESearch OnCreateModelHelper(PSSysSearchDE vt) throws Exception {
        PSDESearchImpl psDESearchImpl = new PSDESearchImpl();
        psDESearchImpl.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return psDESearchImpl;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysSearchDE obj) {
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
    protected Vector<PSSysSearchDE> getAllModels() throws Exception {
        Vector<PSSysSearchDE> psSysSearchDEList = new Vector<PSSysSearchDE>();
        CallResult callResult = this.iPSModelHelper.getPSDESearchs(this.getPSDataEntity().getId(), psSysSearchDEList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u5168\u6587\u68c0\u7d22\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psSysSearchDEList;
    }

    @Override
    protected IPSDESearch registerModel(PSSysSearchDE vt) throws Exception {
        IPSDESearch iPSDESearch = (IPSDESearch)this.InternalGetModelHelper(vt.getPSSYSSEARCHDEID());
        if (iPSDESearch != null) {
            return iPSDESearch;
        }
        this.setModel(vt.getPSSYSSEARCHDEID(), vt, null);
        return (IPSDESearch)this.FindModelHelper(vt.getPSSYSSEARCHDEID());
    }

    @Override
    protected String getObjectId(PSSysSearchDE vt) {
        return vt.getPSSYSSEARCHDEID();
    }
}

