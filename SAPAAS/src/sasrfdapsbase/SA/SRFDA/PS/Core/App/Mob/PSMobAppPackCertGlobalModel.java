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

import SA.SRFDA.PS.Core.App.Mob.IPSMobAppPackCert;
import SA.SRFDA.PS.Core.App.Mob.PSMobAppPackCertImpl;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Data.PSDCMobAppPackCert;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMobAppPackCertGlobalModel
extends PSApplicationGlobalModelBase<String, PSDCMobAppPackCert, IPSMobAppPackCert> {
    private static final Log log = LogFactory.getLog(PSMobAppPackCertGlobalModel.class);

    @Override
    protected PSDCMobAppPackCert GetObject(String strPSDCMobAppPackCertId) {
        PSDCMobAppPackCert psDCMobAppPackCert = new PSDCMobAppPackCert();
        CallResult callResult = this.iPSModelHelper.getPSMobAppPackCert(strPSDCMobAppPackCertId, psDCMobAppPackCert);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u79fb\u52a8\u5e94\u7528\u6253\u5305\u8bc1\u4e66[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDCMobAppPackCertId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDCMobAppPackCert;
    }

    @Override
    protected IPSMobAppPackCert OnCreateModelHelper(PSDCMobAppPackCert vt) throws Exception {
        PSMobAppPackCertImpl iPSDCMobAppPackCert = new PSMobAppPackCertImpl();
        iPSDCMobAppPackCert.init(this.iDAGlobalHelper, this.iPSApplication, vt);
        return iPSDCMobAppPackCert;
    }

    @Override
    protected Boolean TestObjectRenew(PSDCMobAppPackCert obj) {
        return false;
    }

    @Override
    protected IPSMobAppPackCert registerModel(PSDCMobAppPackCert vt) throws Exception {
        IPSMobAppPackCert iPSDCMobAppPackCert = (IPSMobAppPackCert)this.InternalGetModelHelper(vt.getPSDCMOBPACKCERTID());
        if (iPSDCMobAppPackCert != null) {
            return iPSDCMobAppPackCert;
        }
        this.setModel(vt.getPSDCMOBPACKCERTID(), vt, null);
        return (IPSMobAppPackCert)this.FindModelHelper(vt.getPSDCMOBPACKCERTID());
    }

    @Override
    protected String getObjectId(PSDCMobAppPackCert vt) {
        return vt.getPSDCMOBPACKCERTID();
    }
}

