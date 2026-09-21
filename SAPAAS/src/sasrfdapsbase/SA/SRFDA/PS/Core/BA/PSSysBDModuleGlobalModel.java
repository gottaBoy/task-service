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

import SA.SRFDA.PS.Core.BA.IPSSysBDModule;
import SA.SRFDA.PS.Core.BA.PSSysBDModuleImpl;
import SA.SRFDA.PS.Core.BA.PSSysBDSchemeGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysBDModule;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBDModuleGlobalModel
extends PSSysBDSchemeGlobalModelBase<String, PSSysBDModule, IPSSysBDModule> {
    private static final Log log = LogFactory.getLog(PSSysBDModuleGlobalModel.class);

    @Override
    protected PSSysBDModule GetObject(String strPSSysBDModuleId) {
        return null;
    }

    @Override
    protected IPSSysBDModule OnCreateModelHelper(PSSysBDModule vt) throws Exception {
        PSSysBDModuleImpl iPSSysBDModule = new PSSysBDModuleImpl();
        iPSSysBDModule.init(this.iDAGlobalHelper, this.getPSSysBDScheme(), vt);
        return iPSSysBDModule;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysBDModule obj) {
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
    protected IPSSysBDModule registerModel(PSSysBDModule vt) throws Exception {
        IPSSysBDModule iPSSysBDModule = (IPSSysBDModule)this.InternalGetModelHelper(vt.getPSSYSBDMODULEID());
        if (iPSSysBDModule != null) {
            return iPSSysBDModule;
        }
        this.setModel(vt.getPSSYSBDMODULEID(), vt, null);
        return (IPSSysBDModule)this.FindModelHelper(vt.getPSSYSBDMODULEID());
    }

    @Override
    protected Vector<PSSysBDModule> getAllModels() throws Exception {
        Vector<PSSysBDModule> list = new Vector<PSSysBDModule>();
        CallResult callResult = this.iPSModelHelper.getPSSysBDModules(this.iPSSysBDScheme.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5927\u6570\u636e\u67b6\u6784\u5168\u90e8\u6a21\u5757\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysBDModule vt) {
        return vt.getPSSYSBDMODULEID();
    }
}

