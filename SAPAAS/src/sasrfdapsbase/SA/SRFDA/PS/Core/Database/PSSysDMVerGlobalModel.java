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

import SA.SRFDA.PS.Core.Database.IPSSysDMVer;
import SA.SRFDA.PS.Core.Database.PSSysDMVerImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysDMVer;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSSysDMVerGlobalModel
extends PSSystemGlobalModelBase<String, PSSysDMVer, IPSSysDMVer> {
    private static final Log log = LogFactory.getLog(PSSysDMVerGlobalModel.class);
    private IPSSysDMVer activePSSysDMVer = null;

    @Override
    protected PSSysDMVer GetObject(String strPSSysDMVerId) {
        return null;
    }

    @Override
    protected IPSSysDMVer OnCreateModelHelper(PSSysDMVer vt) throws Exception {
        PSSysDMVerImpl iPSSysDMVer = new PSSysDMVerImpl();
        iPSSysDMVer.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysDMVer;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysDMVer obj) {
        return false;
    }

    @Override
    protected IPSSysDMVer registerModel(PSSysDMVer vt) throws Exception {
        IPSSysDMVer iPSSysDMVer = (IPSSysDMVer)this.InternalGetModelHelper(vt.getPSSYSDMVERID());
        if (iPSSysDMVer != null) {
            return iPSSysDMVer;
        }
        this.setModel(vt.getPSSYSDMVERID(), vt, null);
        iPSSysDMVer = (IPSSysDMVer)this.FindModelHelper(vt.getPSSYSDMVERID());
        if (this.activePSSysDMVer == null || iPSSysDMVer.isActive()) {
            this.activePSSysDMVer = iPSSysDMVer;
        }
        return iPSSysDMVer;
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
    protected Vector<PSSysDMVer> getAllModels() throws Exception {
        Vector<PSSysDMVer> list = new Vector<PSSysDMVer>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysDMVers(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6570\u636e\u5e93\u6a21\u578b\u7248\u672c\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysDMVer vt) {
        return vt.getPSSYSDMVERID();
    }

    public IPSSysDMVer getActivePSSysDMVer() {
        return this.activePSSysDMVer;
    }
}

