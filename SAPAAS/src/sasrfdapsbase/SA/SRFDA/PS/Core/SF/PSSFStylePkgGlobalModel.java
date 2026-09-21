/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSFStylePkg;
import SA.SRFDA.PS.Core.SF.PSSFStyleGlobalModelBase;
import SA.SRFDA.PS.Core.SF.PSSFStylePkgImpl;
import SA.SRFDA.PS.Data.PSSFStylePkg;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFStylePkgGlobalModel
extends PSSFStyleGlobalModelBase<String, PSSFStylePkg, IPSSFStylePkg> {
    private static final Log log = LogFactory.getLog(PSSFStylePkgGlobalModel.class);

    @Override
    protected PSSFStylePkg GetObject(String strPSSFStylePkgId) {
        return null;
    }

    @Override
    protected IPSSFStylePkg OnCreateModelHelper(PSSFStylePkg vt) throws Exception {
        PSSFStylePkgImpl iPSSFStylePkg = new PSSFStylePkgImpl();
        iPSSFStylePkg.init(this.iDAGlobalHelper, this.getPSSFStyle(), vt);
        return iPSSFStylePkg;
    }

    @Override
    protected Boolean TestObjectRenew(PSSFStylePkg obj) {
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
    protected IPSSFStylePkg registerModel(PSSFStylePkg vt) throws Exception {
        IPSSFStylePkg iPSSFStylePkg = (IPSSFStylePkg)this.InternalGetModelHelper(vt.getPSSFSTYLEPKGID());
        if (iPSSFStylePkg != null) {
            return iPSSFStylePkg;
        }
        this.setModel(vt.getPSSFSTYLEPKGID(), vt, null);
        return (IPSSFStylePkg)this.FindModelHelper(vt.getPSSFSTYLEPKGID());
    }

    @Override
    protected Vector<PSSFStylePkg> getAllModels() throws Exception {
        Vector<PSSFStylePkg> list = new Vector<PSSFStylePkg>();
        CallResult callResult = this.iPSModelHelper.getPSSFStylePkgs(this.getPSSFStyle().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u540e\u53f0\u670d\u52a1\u6837\u5f0f\u9700\u6c42\u7ec4\u4ef6\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSFStylePkg psPFStylePkg : list) {
            this.setModel(psPFStylePkg.getPSSFSTYLEPKGID(), psPFStylePkg, null);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSFStylePkg vt) {
        return vt.getPSSFSTYLEPKGID();
    }
}

