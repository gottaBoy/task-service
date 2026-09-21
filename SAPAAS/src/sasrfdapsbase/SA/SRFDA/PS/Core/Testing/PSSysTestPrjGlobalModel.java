/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestPrj;
import SA.SRFDA.PS.Core.Testing.PSSysTestPrjImpl;
import SA.SRFDA.PS.Data.PSSysTestPrj;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysTestPrjGlobalModel
extends PSSystemGlobalModelBase<String, PSSysTestPrj, IPSSysTestPrj> {
    private static final Log log = LogFactory.getLog(PSSysTestPrjGlobalModel.class);

    @Override
    protected PSSysTestPrj GetObject(String strPSSysTestPrjId) {
        return null;
    }

    @Override
    protected IPSSysTestPrj OnCreateModelHelper(PSSysTestPrj vt) throws Exception {
        PSSysTestPrjImpl iPSSysTestPrj = new PSSysTestPrjImpl();
        iPSSysTestPrj.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysTestPrj;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysTestPrj obj) {
        return false;
    }

    @Override
    protected IPSSysTestPrj registerModel(PSSysTestPrj vt) throws Exception {
        IPSSysTestPrj iPSSysTestPrj = (IPSSysTestPrj)this.InternalGetModelHelper(vt.getPSSYSTESTPRJID());
        if (iPSSysTestPrj != null) {
            return iPSSysTestPrj;
        }
        this.setModel(vt.getPSSYSTESTPRJID(), vt, null);
        iPSSysTestPrj = (IPSSysTestPrj)this.FindModelHelper(vt.getPSSYSTESTPRJID());
        return iPSSysTestPrj;
    }

    @Override
    protected void onPreloadModels() {
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected Vector<PSSysTestPrj> getAllModels() throws Exception {
        Vector<PSSysTestPrj> list = new Vector<PSSysTestPrj>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysTestPrjs(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d4b\u8bd5\u9879\u76ee\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysTestPrj vt) {
        return vt.getPSSYSTESTPRJID();
    }
}

