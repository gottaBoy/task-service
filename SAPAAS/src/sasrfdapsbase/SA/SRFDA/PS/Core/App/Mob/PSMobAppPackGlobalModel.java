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

import SA.SRFDA.PS.Core.App.Mob.IPSMobAppPack;
import SA.SRFDA.PS.Core.App.Mob.PSMobAppPackImpl;
import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Data.PSMobAppPack;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMobAppPackGlobalModel
extends PSApplicationGlobalModelBase<String, PSMobAppPack, IPSMobAppPack> {
    private static final Log log = LogFactory.getLog(PSMobAppPackGlobalModel.class);

    @Override
    protected PSMobAppPack GetObject(String strPSMobAppPackId) {
        PSMobAppPack psMobAppPack = new PSMobAppPack();
        CallResult callResult = this.iPSModelHelper.getPSMobAppPack(strPSMobAppPackId, psMobAppPack);
        if (callResult.isError()) {
            String strInfo = StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u79fb\u52a8\u5e94\u7528\u6253\u5305\u914d\u7f6e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSMobAppPackId, (Object)callResult.getErrorInfo());
            log.error((Object)strInfo);
            this.getPSApplicationRuntime().log(1, this.getPSApplication(), strInfo);
            return null;
        }
        return psMobAppPack;
    }

    @Override
    protected IPSMobAppPack OnCreateModelHelper(PSMobAppPack vt) throws Exception {
        PSMobAppPackImpl iPSMobAppPack = new PSMobAppPackImpl();
        iPSMobAppPack.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSMobAppPack;
    }

    @Override
    protected Boolean TestObjectRenew(PSMobAppPack obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSMobAppPack vt) {
        return vt.getPSMOBAPPPACKID();
    }

    @Override
    protected IPSMobAppPack registerModel(PSMobAppPack vt) throws Exception {
        IPSMobAppPack iPSMobAppPack = (IPSMobAppPack)this.InternalGetModelHelper(vt.getPSMOBAPPPACKID());
        if (iPSMobAppPack != null) {
            return iPSMobAppPack;
        }
        this.setModel(vt.getPSMOBAPPPACKID(), vt, null);
        return (IPSMobAppPack)this.FindModelHelper(vt.getPSMOBAPPPACKID());
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSApplicationException.create(this.getPSApplication(), 40009, objObjectId);
    }
}

