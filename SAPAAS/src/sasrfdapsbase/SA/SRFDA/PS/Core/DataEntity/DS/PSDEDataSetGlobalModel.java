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

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataSetImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEDataSet;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataSetGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEDataSet, IPSDEDataSet> {
    private static final Log log = LogFactory.getLog(PSDEDataSetGlobalModel.class);
    private IPSDEDataSet defaultPSDEDataSet = null;

    @Override
    protected PSDEDataSet GetObject(String strPSDEDataSetId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSDEDataSet psDEDataSet = new PSDEDataSet();
        CallResult callResult = this.iPSModelHelper.getPSDEDataSet(strPSDEDataSetId, psDEDataSet);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u96c6\u5408[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDataSetId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDEDataSet;
    }

    @Override
    protected IPSDEDataSet OnCreateModelHelper(PSDEDataSet vt) throws Exception {
        PSDEDataSetImpl iPSDEDataSet = new PSDEDataSetImpl();
        iPSDEDataSet.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEDataSet;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEDataSet obj) {
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
        IPSDEDataSet iPSDEDataSet = (IPSDEDataSet)this.InternalGetModelHelper(vt.getPSDEDATASETID());
        if (iPSDEDataSet != null) {
            return iPSDEDataSet;
        }
        this.setModel(vt.getPSDEDATASETID(), vt, null);
        iPSDEDataSet = (IPSDEDataSet)this.FindModelHelper(vt.getPSDEDATASETID());
        if (iPSDEDataSet.isDefaultMode()) {
            this.defaultPSDEDataSet = iPSDEDataSet;
        }
        return iPSDEDataSet;
    }

    @Override
    protected Vector<PSDEDataSet> getAllModels() throws Exception {
        Vector<PSDEDataSet> psDEDataSetList = new Vector<PSDEDataSet>();
        CallResult callResult = this.iPSModelHelper.getPSDEDataSets(this.getPSDataEntity().getId(), psDEDataSetList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5168\u90e8\u6570\u636e\u96c6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        boolean bHasDefault = false;
        for (PSDEDataSet psDEDataSet : psDEDataSetList) {
            if (!psDEDataSet.getDEFAULTMODE()) continue;
            bHasDefault = true;
        }
        if (!bHasDefault) {
            for (PSDEDataSet psDEDataSet : psDEDataSetList) {
                if (StringHelper.Compare((String)psDEDataSet.getPSDEDATASETNAME(), (String)"DEFAULT", (boolean)true) != 0) continue;
                psDEDataSet.setDEFAULTMODE(true);
                break;
            }
        }
        return psDEDataSetList;
    }

    @Override
    protected String getObjectId(PSDEDataSet vt) {
        return vt.getPSDEDATASETID();
    }

    public IPSDEDataSet getDefaultPSDEDataSet() {
        this.preloadModels();
        return this.defaultPSDEDataSet;
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEDataSet vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getPSDEDATASETNAME())) {
            return new String[]{vt.getPSDEDATASETNAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

