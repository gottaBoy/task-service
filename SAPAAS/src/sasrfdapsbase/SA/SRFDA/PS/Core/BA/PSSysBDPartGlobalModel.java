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

import SA.SRFDA.PS.Core.BA.IPSSysBDPart;
import SA.SRFDA.PS.Core.BA.PSSysBDPartImpl;
import SA.SRFDA.PS.Core.BA.PSSysBDSchemeGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysBDPart;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBDPartGlobalModel
extends PSSysBDSchemeGlobalModelBase<String, PSSysBDPart, IPSSysBDPart> {
    private static final Log log = LogFactory.getLog(PSSysBDPartGlobalModel.class);

    @Override
    protected PSSysBDPart GetObject(String strPSSysBDPartId) {
        return null;
    }

    @Override
    protected IPSSysBDPart OnCreateModelHelper(PSSysBDPart vt) throws Exception {
        PSSysBDPartImpl iPSSysBDPart = new PSSysBDPartImpl();
        iPSSysBDPart.init(this.iDAGlobalHelper, this.getPSSysBDScheme(), vt);
        return iPSSysBDPart;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysBDPart obj) {
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
    protected IPSSysBDPart registerModel(PSSysBDPart vt) throws Exception {
        IPSSysBDPart iPSSysBDPart = (IPSSysBDPart)this.InternalGetModelHelper(vt.getPSSYSBDPARTID());
        if (iPSSysBDPart != null) {
            return iPSSysBDPart;
        }
        this.setModel(vt.getPSSYSBDPARTID(), vt, null);
        return (IPSSysBDPart)this.FindModelHelper(vt.getPSSYSBDPARTID());
    }

    @Override
    protected Vector<PSSysBDPart> getAllModels() throws Exception {
        Vector<PSSysBDPart> list = new Vector<PSSysBDPart>();
        CallResult callResult = this.iPSModelHelper.getPSSysBDParts(this.iPSSysBDScheme.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5927\u6570\u636e\u67b6\u6784\u5168\u90e8\u5206\u533a\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysBDPart vt) {
        return vt.getPSSYSBDPARTID();
    }
}

