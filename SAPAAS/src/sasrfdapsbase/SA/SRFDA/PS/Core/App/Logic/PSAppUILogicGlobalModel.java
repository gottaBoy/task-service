/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Logic;

import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.App.Logic.PSAppUILogicImpl;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysViewLogic;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppUILogicGlobalModel
extends PSApplicationGlobalModelBase<String, PSSysViewLogic, IPSAppUILogic> {
    private static final Log log = LogFactory.getLog(PSAppUILogicGlobalModel.class);

    @Override
    protected PSSysViewLogic GetObject(String strPSSysViewLogicId) {
        PSSysViewLogic psSysViewLogic = new PSSysViewLogic();
        CallResult callResult = this.iPSModelHelper.getPSSysViewLogic(strPSSysViewLogicId, psSysViewLogic);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u9884\u7f6e\u754c\u9762\u903b\u8f91[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysViewLogicId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysViewLogic;
    }

    @Override
    protected IPSAppUILogic OnCreateModelHelper(PSSysViewLogic vt) throws Exception {
        PSAppUILogicImpl iPSAppUILogic = new PSAppUILogicImpl();
        iPSAppUILogic.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppUILogic;
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
    protected IPSAppUILogic registerModel(PSSysViewLogic vt) throws Exception {
        IPSAppUILogic iPSAppUILogic = (IPSAppUILogic)this.InternalGetModelHelper(vt.getPSSYSVIEWLOGICID());
        if (iPSAppUILogic != null) {
            return iPSAppUILogic;
        }
        this.setModel(vt.getPSSYSVIEWLOGICID(), vt, null);
        return (IPSAppUILogic)this.FindModelHelper(vt.getPSSYSVIEWLOGICID());
    }

    @Override
    protected Vector<PSSysViewLogic> getAllModels() throws Exception {
        Vector<PSSysViewLogic> list = new Vector<PSSysViewLogic>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysViewLogics(this.getPSApplication().getPSSystem().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u754c\u9762\u903b\u8f91\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysViewLogic vt) {
        return vt.getPSSYSVIEWLOGICID();
    }
}

