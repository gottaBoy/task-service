/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.ds;

import java.util.Vector;
import net.ibizsys.model.dataentity.PSDataEntityGlobalModelBase;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.ds.PSDEDataSetImpl;
import net.ibizsys.model.entity.PSDEDataSet;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataSetGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEDataSet, IPSDEDataSet> {
    private static final Log log = LogFactory.getLog(PSDEDataSetGlobalModel.class);

    @Override
    protected PSDEDataSet getObject(String strPSDEDataSetId) {
        PSDEDataSet psDEDataSet = new PSDEDataSet();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEDataSet(strPSDEDataSetId, psDEDataSet);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u6570\u636e\u96c6\u5408[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDataSetId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDEDataSet;
    }

    @Override
    protected IPSDEDataSet onCreateModelHelper(PSDEDataSet vt) throws Exception {
        PSDEDataSetImpl iPSDEDataSet = new PSDEDataSetImpl();
        iPSDEDataSet.init(this.getPSModelStorageContext(), this.getPSDataEntity(), vt);
        return iPSDEDataSet;
    }

    @Override
    protected Boolean testObjectRenew(PSDEDataSet obj) {
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
    protected IPSDEDataSet registerModel(PSDEDataSet vt) throws Exception {
        IPSDEDataSet iPSDEDataSet = (IPSDEDataSet)this.internalGetModelHelper(vt.getPSDEDATASETID());
        if (iPSDEDataSet != null) {
            return iPSDEDataSet;
        }
        this.setModel(vt.getPSDEDATASETID(), vt, null);
        return (IPSDEDataSet)this.findModelHelper(vt.getPSDEDATASETID());
    }

    @Override
    protected Vector<PSDEDataSet> getAllModels() throws Exception {
        Vector<PSDEDataSet> psDEDataSetList = new Vector<PSDEDataSet>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEDataSets(this.getPSDataEntity().getId(), psDEDataSetList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u6570\u636e\u96c6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDataSetList;
    }

    @Override
    protected String getObjectId(PSDEDataSet vt) {
        return vt.getPSDEDATASETID();
    }
}

