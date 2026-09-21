/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSSysBDColSet;
import SA.SRFDA.PS.Core.BA.PSSysBDColSetImpl;
import SA.SRFDA.PS.Core.BA.PSSysBDTableGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysBDColSet;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBDColSetGlobalModel
extends PSSysBDTableGlobalModelBase<String, PSSysBDColSet, IPSSysBDColSet> {
    private static final Log log = LogFactory.getLog(PSSysBDColSetGlobalModel.class);
    private IPSSysBDColSet defaultPSSysBDColSet = null;

    @Override
    protected PSSysBDColSet GetObject(String strPSSysBDColSetId) {
        return null;
    }

    @Override
    protected IPSSysBDColSet OnCreateModelHelper(PSSysBDColSet vt) throws Exception {
        PSSysBDColSetImpl iPSSysBDColSet = new PSSysBDColSetImpl();
        iPSSysBDColSet.init(this.iDAGlobalHelper, this.getPSSysBDTable(), vt);
        return iPSSysBDColSet;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysBDColSet obj) {
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
    protected IPSSysBDColSet registerModel(PSSysBDColSet vt) throws Exception {
        IPSSysBDColSet iPSSysBDColSet = (IPSSysBDColSet)this.InternalGetModelHelper(vt.getPSSYSBDCOLSETID());
        if (iPSSysBDColSet != null) {
            return iPSSysBDColSet;
        }
        this.setModel(vt.getPSSYSBDCOLSETID(), vt, null);
        iPSSysBDColSet = (IPSSysBDColSet)this.FindModelHelper(vt.getPSSYSBDCOLSETID());
        if (iPSSysBDColSet.isDefault()) {
            this.defaultPSSysBDColSet = iPSSysBDColSet;
        }
        return iPSSysBDColSet;
    }

    @Override
    protected Vector<PSSysBDColSet> getAllModels() throws Exception {
        Vector<PSSysBDColSet> list = new Vector<PSSysBDColSet>();
        CallResult callResult = this.iPSModelHelper.getPSSysBDColSets(this.iPSSysBDTable.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5927\u6570\u636e\u8868\u5168\u90e8\u5217\u65cf\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysBDColSet vt) {
        return vt.getPSSYSBDCOLSETID();
    }

    public IPSSysBDColSet getDefaultPSSysBDColSet() {
        this.preloadModels();
        return this.defaultPSSysBDColSet;
    }
}

