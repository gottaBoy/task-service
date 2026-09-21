/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Res.IPSSysUtil;
import SA.SRFDA.PS.Core.Res.PSSysUtilImpl;
import SA.SRFDA.PS.Data.PSSysUtil;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUtilGlobalModel
extends PSSystemGlobalModelBase<String, PSSysUtil, IPSSysUtil> {
    private static final Log log = LogFactory.getLog(PSSysUtilGlobalModel.class);

    @Override
    protected PSSysUtil GetObject(String strPSSysUtilId) {
        return null;
    }

    @Override
    protected IPSSysUtil OnCreateModelHelper(PSSysUtil vt) throws Exception {
        PSSysUtilImpl iPSSysUtil = null;
        iPSSysUtil = new PSSysUtilImpl();
        iPSSysUtil.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysUtil;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysUtil obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysUtil registerModel(PSSysUtil vt) throws Exception {
        IPSSysUtil iIPSSysUtil = (IPSSysUtil)this.InternalGetModelHelper(vt.getPSSYSUTILDEID());
        if (iIPSSysUtil != null) {
            return iIPSSysUtil;
        }
        this.setModel(vt.getPSSYSUTILDEID(), vt, null);
        if (StringHelper.Compare((String)vt.getUTILTYPE(), (String)"USER", (boolean)true) != 0) {
            this.setModel(vt.getUTILTYPE(), vt, null);
        }
        return (IPSSysUtil)this.FindModelHelper(vt.getPSSYSUTILDEID());
    }

    @Override
    protected Vector<PSSysUtil> getAllModels() throws Exception {
        Vector<PSSysUtil> list = new Vector<PSSysUtil>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysUtils(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5b9e\u4f53\u529f\u80fd\u914d\u7f6e\u5bf9\u8c61\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysUtil vt) {
        return vt.getPSSYSUTILDEID();
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
}

