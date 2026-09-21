/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEServiceAPIImpl;
import SA.SRFDA.PS.Data.PSDEServiceAPI;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEServiceAPIGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEServiceAPI, IPSDEServiceAPI> {
    private static final Log log = LogFactory.getLog(PSDEServiceAPIGlobalModel.class);

    @Override
    protected PSDEServiceAPI GetObject(String strPSDEServiceAPIId) {
        if (this.isPrepareModels()) {
            return null;
        }
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEServiceAPIId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEServiceAPI OnCreateModelHelper(PSDEServiceAPI vt) throws Exception {
        PSDEServiceAPIImpl iPSDEServiceAPI = new PSDEServiceAPIImpl();
        iPSDEServiceAPI.init(this.iDAGlobalHelper, null, this.getPSDataEntity(), vt);
        return iPSDEServiceAPI;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEServiceAPI obj) {
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
    protected Vector<PSDEServiceAPI> getAllModels() throws Exception {
        Vector<PSDEServiceAPI> psDEServiceAPIList = new Vector<PSDEServiceAPI>();
        CallResult callResult = this.iPSModelHelper.getPSDEServiceAPIs(this.getPSDataEntity().getId(), psDEServiceAPIList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEServiceAPIList;
    }

    @Override
    protected IPSDEServiceAPI registerModel(PSDEServiceAPI vt) throws Exception {
        IPSDEServiceAPI iPSDEServiceAPI = (IPSDEServiceAPI)this.InternalGetModelHelper(vt.getPSDESERVICEAPIID());
        if (iPSDEServiceAPI != null) {
            return iPSDEServiceAPI;
        }
        this.setModel(vt.getPSDESERVICEAPIID(), vt, null);
        return (IPSDEServiceAPI)this.FindModelHelper(vt.getPSDESERVICEAPIID());
    }

    @Override
    protected String getObjectId(PSDEServiceAPI vt) {
        return vt.getPSDESERVICEAPIID();
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSDataEntityException.create(this.getPSDataEntity(), 20019, objObjectId);
    }
}

