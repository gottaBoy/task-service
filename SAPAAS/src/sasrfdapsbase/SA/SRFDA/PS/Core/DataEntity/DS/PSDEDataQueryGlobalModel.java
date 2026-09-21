/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataQueryImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEDataQuery;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataQueryGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEDataQuery, IPSDEDataQuery> {
    private static final Log log = LogFactory.getLog(PSDEDataQueryGlobalModel.class);
    private IPSDEDataQuery defaultPSDEDataQuery = null;
    private IPSDEDataQuery viewPSDEDataQuery = null;

    @Override
    protected PSDEDataQuery GetObject(String strPSDEDataQueryId) {
        PSDEDataQuery psDEDataQuery = new PSDEDataQuery();
        CallResult callResult = this.iPSModelHelper.getPSDEDataQuery(strPSDEDataQueryId, psDEDataQuery);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u67e5\u8be2[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDataQueryId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDEDataQuery;
    }

    @Override
    protected IPSDEDataQuery OnCreateModelHelper(PSDEDataQuery vt) throws Exception {
        PSDEDataQueryImpl iPSDEDataQuery = new PSDEDataQueryImpl();
        iPSDEDataQuery.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEDataQuery;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEDataQuery obj) {
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
        IPSDEDataQuery iPSDEDataQuery = (IPSDEDataQuery)this.InternalGetModelHelper(vt.getPSDEDATAQUERYID());
        if (iPSDEDataQuery != null) {
            return iPSDEDataQuery;
        }
        this.setModel(vt.getPSDEDATAQUERYID(), vt, null);
        iPSDEDataQuery = (IPSDEDataQuery)this.FindModelHelper(vt.getPSDEDATAQUERYID());
        if (iPSDEDataQuery.isDefaultMode()) {
            this.defaultPSDEDataQuery = iPSDEDataQuery;
        }
        return iPSDEDataQuery;
    }

    @Override
    protected Vector<PSDEDataQuery> getAllModels() throws Exception {
        PSDEDataQuery psDEDataQuery;
        Vector<PSDEDataQuery> psDEDataQueryList = new Vector<PSDEDataQuery>();
        CallResult callResult = this.iPSModelHelper.getPSDEDataQueries(this.getPSDataEntity().getId(), psDEDataQueryList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u6570\u636e\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        PSDEDataQuery defaultPSDEDataQuery = null;
        Iterator<PSDEDataQuery> iterator = psDEDataQueryList.iterator();
        while (iterator.hasNext()) {
            psDEDataQuery = iterator.next();
            if (!psDEDataQuery.getDEFAULTMODE()) continue;
            defaultPSDEDataQuery = psDEDataQuery;
            break;
        }
        if (defaultPSDEDataQuery == null) {
            iterator = psDEDataQueryList.iterator();
            while (iterator.hasNext()) {
                psDEDataQuery = iterator.next();
                if (StringHelper.Compare((String)psDEDataQuery.getPSDEDATAQUERYNAME(), (String)"DEFAULT", (boolean)true) != 0) continue;
                psDEDataQuery.setDEFAULTMODE(true);
                defaultPSDEDataQuery = psDEDataQuery;
                break;
            }
        }
        if (defaultPSDEDataQuery == null && (iterator = psDEDataQueryList.iterator()).hasNext()) {
            psDEDataQuery = iterator.next();
            psDEDataQuery.setDEFAULTMODE(true);
            defaultPSDEDataQuery = psDEDataQuery;
        }
        return psDEDataQueryList;
    }

    @Override
    protected String getObjectId(PSDEDataQuery vt) {
        return vt.getPSDEDATAQUERYID();
    }

    public IPSDEDataQuery getDefaultPSDEDataQuery() {
        this.preloadModels();
        return this.defaultPSDEDataQuery;
    }

    public IPSDEDataQuery getViewPSDEDataQuery() {
        block6: {
            this.preloadModels();
            if (this.viewPSDEDataQuery == null) {
                try {
                    Iterator psDEDataQueryList = this.getAllModelHelpers();
                    if (psDEDataQueryList == null) break block6;
                    while (psDEDataQueryList.hasNext()) {
                        IPSDEDataQuery iPSDEDataQuery = (IPSDEDataQuery)psDEDataQueryList.next();
                        if (iPSDEDataQuery.getViewLevel() != 0) continue;
                        if ("VIEW".equalsIgnoreCase(iPSDEDataQuery.getName())) {
                            this.viewPSDEDataQuery = iPSDEDataQuery;
                            break;
                        }
                        this.viewPSDEDataQuery = iPSDEDataQuery;
                    }
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
            }
        }
        if (this.viewPSDEDataQuery == null) {
            this.viewPSDEDataQuery = this.getDefaultPSDEDataQuery();
        }
        return this.viewPSDEDataQuery;
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEDataQuery vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getPSDEDATAQUERYNAME())) {
            return new String[]{vt.getPSDEDATAQUERYNAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

