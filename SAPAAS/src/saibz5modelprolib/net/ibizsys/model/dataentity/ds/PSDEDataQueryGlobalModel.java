/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQuery
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.ds;

import java.util.Vector;
import net.ibizsys.model.dataentity.PSDataEntityGlobalModelBase;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.ds.PSDEDataQueryImpl;
import net.ibizsys.model.entity.PSDEDataQuery;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataQueryGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEDataQuery, IPSDEDataQuery> {
    private static final Log log = LogFactory.getLog(PSDEDataQueryGlobalModel.class);
    private IPSDEDataQuery defaultPSDEDataQuery = null;

    @Override
    protected PSDEDataQuery getObject(String strPSDEDataQueryId) {
        PSDEDataQuery psDEDataQuery = new PSDEDataQuery();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEDataQuery(strPSDEDataQueryId, psDEDataQuery);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u6570\u636e\u67e5\u8be2[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDataQueryId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDEDataQuery;
    }

    @Override
    protected IPSDEDataQuery onCreateModelHelper(PSDEDataQuery vt) throws Exception {
        PSDEDataQueryImpl iPSDEDataQuery = new PSDEDataQueryImpl();
        iPSDEDataQuery.init(this.getPSModelStorageContext(), this.getPSDataEntity(), vt);
        return iPSDEDataQuery;
    }

    @Override
    protected Boolean testObjectRenew(PSDEDataQuery obj) {
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
    protected IPSDEDataQuery registerModel(PSDEDataQuery vt) throws Exception {
        IPSDEDataQuery iPSDEDataQuery = (IPSDEDataQuery)this.internalGetModelHelper(vt.getPSDEDATAQUERYID());
        if (iPSDEDataQuery != null) {
            return iPSDEDataQuery;
        }
        this.setModel(vt.getPSDEDATAQUERYID(), vt, null);
        iPSDEDataQuery = (IPSDEDataQuery)this.findModelHelper(vt.getPSDEDATAQUERYID());
        if (iPSDEDataQuery.isDefaultMode()) {
            this.defaultPSDEDataQuery = iPSDEDataQuery;
        }
        return iPSDEDataQuery;
    }

    @Override
    protected Vector<PSDEDataQuery> getAllModels() throws Exception {
        Vector<PSDEDataQuery> psDEDataQueryList = new Vector<PSDEDataQuery>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEDataQueries(this.getPSDataEntity().getId(), psDEDataQueryList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u6570\u636e\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataQueryList;
    }

    @Override
    protected String getObjectId(PSDEDataQuery vt) {
        return vt.getPSDEDATAQUERYID();
    }

    public IPSDEDataQuery getDefaultPSDEDataQuery() {
        return this.defaultPSDEDataQuery;
    }
}

