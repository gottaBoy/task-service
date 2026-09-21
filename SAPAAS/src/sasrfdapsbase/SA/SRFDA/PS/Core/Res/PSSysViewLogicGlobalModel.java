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
import SA.SRFDA.PS.Core.Res.IPSSysViewLogic;
import SA.SRFDA.PS.Core.Res.PSSysViewLogicImpl;
import SA.SRFDA.PS.Data.PSSysViewLogic;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysViewLogicGlobalModel
extends PSSystemGlobalModelBase<String, PSSysViewLogic, IPSSysViewLogic> {
    private static final Log log = LogFactory.getLog(PSSysViewLogicGlobalModel.class);

    @Override
    protected PSSysViewLogic GetObject(String strPSSysViewLogicId) {
        PSSysViewLogic psSysViewLogic = new PSSysViewLogic();
        CallResult callResult = this.iPSModelHelper.getPSSysViewLogic(strPSSysViewLogicId, psSysViewLogic);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u9884\u7f6e\u89c6\u56fe\u903b\u8f91[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysViewLogicId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysViewLogic;
    }

    @Override
    protected IPSSysViewLogic OnCreateModelHelper(PSSysViewLogic vt) throws Exception {
        PSSysViewLogicImpl iPSSysViewLogic = new PSSysViewLogicImpl();
        iPSSysViewLogic.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysViewLogic;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysViewLogic obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysViewLogic registerModel(PSSysViewLogic vt) throws Exception {
        IPSSysViewLogic iIPSSysViewLogic = (IPSSysViewLogic)this.InternalGetModelHelper(vt.getPSSYSVIEWLOGICID());
        if (iIPSSysViewLogic != null) {
            return iIPSSysViewLogic;
        }
        this.setModel(vt.getPSSYSVIEWLOGICID(), vt, null);
        return (IPSSysViewLogic)this.FindModelHelper(vt.getPSSYSVIEWLOGICID());
    }

    @Override
    protected Vector<PSSysViewLogic> getAllModels() throws Exception {
        Vector<PSSysViewLogic> list = new Vector<PSSysViewLogic>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysViewLogics(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u9884\u7f6e\u89c6\u56fe\u903b\u8f91\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysViewLogic vt) {
        return vt.getPSSYSVIEWLOGICID();
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
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysViewLogic vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

