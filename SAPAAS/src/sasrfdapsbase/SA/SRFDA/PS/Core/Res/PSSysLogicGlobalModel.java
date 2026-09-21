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
import SA.SRFDA.PS.Core.Res.IPSSysLogic;
import SA.SRFDA.PS.Core.Res.PSSysLogicImpl;
import SA.SRFDA.PS.Data.PSSysLogic;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysLogicGlobalModel
extends PSSystemGlobalModelBase<String, PSSysLogic, IPSSysLogic> {
    private static final Log log = LogFactory.getLog(PSSysLogicGlobalModel.class);

    @Override
    protected PSSysLogic GetObject(String strPSSysLogicId) {
        PSSysLogic psSysLogic = new PSSysLogic();
        CallResult callResult = this.iPSModelHelper.getPSSysLogic(strPSSysLogicId, psSysLogic);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u903b\u8f91[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysLogicId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysLogic;
    }

    @Override
    protected IPSSysLogic OnCreateModelHelper(PSSysLogic vt) throws Exception {
        PSSysLogicImpl iPSSysLogic = null;
        iPSSysLogic = new PSSysLogicImpl();
        iPSSysLogic.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysLogic;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysLogic obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysLogic registerModel(PSSysLogic vt) throws Exception {
        IPSSysLogic iIPSSysLogic = (IPSSysLogic)this.InternalGetModelHelper(vt.getPSSYSDELOGICNODEID());
        if (iIPSSysLogic != null) {
            return iIPSSysLogic;
        }
        this.setModel(vt.getPSSYSDELOGICNODEID(), vt, null);
        return (IPSSysLogic)this.FindModelHelper(vt.getPSSYSDELOGICNODEID());
    }

    @Override
    protected Vector<PSSysLogic> getAllModels() throws Exception {
        Vector<PSSysLogic> list = new Vector<PSSysLogic>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysLogics(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u7cfb\u7edf\u903b\u8f91\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysLogic vt) {
        return vt.getPSSYSDELOGICNODEID();
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

