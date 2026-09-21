/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Mob;

import SA.SRFDA.PS.Core.App.Mob.IPSAppLocalDE;
import SA.SRFDA.PS.Core.App.Mob.PSAppLocalDEImpl;
import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Data.PSAppLocalDE;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppLocalDEGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppLocalDE, IPSAppLocalDE> {
    private static final Log log = LogFactory.getLog(PSAppLocalDEGlobalModel.class);

    @Override
    protected PSAppLocalDE GetObject(String strPSAppLocalDEId) {
        PSAppLocalDE psAppLocalDE = new PSAppLocalDE();
        CallResult callResult = this.iPSModelHelper.getPSAppLocalDE(strPSAppLocalDEId, psAppLocalDE);
        if (callResult.isError()) {
            String strInfo = StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u672c\u5730\u5b9e\u4f53[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppLocalDEId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, this.getPSApplication(), strInfo);
            return null;
        }
        return psAppLocalDE;
    }

    @Override
    protected IPSAppLocalDE OnCreateModelHelper(PSAppLocalDE vt) throws Exception {
        PSAppLocalDEImpl iPSAppLocalDE = new PSAppLocalDEImpl();
        iPSAppLocalDE.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppLocalDE;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppLocalDE obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSAppLocalDE vt) {
        return vt.getPSAPPLOCALDEID();
    }

    @Override
    protected IPSAppLocalDE registerModel(PSAppLocalDE vt) throws Exception {
        IPSAppLocalDE iPSAppLocalDE = (IPSAppLocalDE)this.InternalGetModelHelper(vt.getPSAPPLOCALDEID());
        if (iPSAppLocalDE != null) {
            return iPSAppLocalDE;
        }
        this.setModel(vt.getPSAPPLOCALDEID(), vt, null);
        return (IPSAppLocalDE)this.FindModelHelper(vt.getPSAPPLOCALDEID());
    }

    @Override
    protected Vector<PSAppLocalDE> getAllModels() throws Exception {
        Vector<PSAppLocalDE> list = new Vector<PSAppLocalDE>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppLocalDEs(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u672c\u5730\u5b9e\u4f53\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppLocalDE psAppLocalDE : list) {
            this.setModel(psAppLocalDE.getPSAPPLOCALDEID(), psAppLocalDE, null);
        }
        return list;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSApplicationException.create(this.getPSApplication(), 40011, objObjectId);
    }
}

