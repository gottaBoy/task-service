/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Mob;

import SA.SRFDA.PS.Core.DevCenter.PSDCGlobalModelBase;
import SA.SRFDA.PS.Core.Mob.IPSDCMobAppPackCert;
import SA.SRFDA.PS.Core.Mob.PSDCMobAppPackCertImpl;
import SA.SRFDA.PS.Data.PSDCMobAppPackCert;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCMobAppPackCertGlobalModel
extends PSDCGlobalModelBase<String, PSDCMobAppPackCert, IPSDCMobAppPackCert> {
    private static final Log log = LogFactory.getLog(PSDCMobAppPackCertGlobalModel.class);

    @Override
    protected PSDCMobAppPackCert GetObject(String strPSDCMobAppPackCertId) {
        return null;
    }

    @Override
    protected IPSDCMobAppPackCert OnCreateModelHelper(PSDCMobAppPackCert vt) throws Exception {
        PSDCMobAppPackCertImpl iPSDCMobAppPackCert = new PSDCMobAppPackCertImpl();
        iPSDCMobAppPackCert.init(this.iDAGlobalHelper, vt);
        return iPSDCMobAppPackCert;
    }

    @Override
    protected Boolean TestObjectRenew(PSDCMobAppPackCert obj) {
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
    protected IPSDCMobAppPackCert registerModel(PSDCMobAppPackCert vt) throws Exception {
        IPSDCMobAppPackCert iPSDCMobAppPackCert = (IPSDCMobAppPackCert)this.InternalGetModelHelper(vt.getPSDCMOBPACKCERTID());
        if (iPSDCMobAppPackCert != null) {
            return iPSDCMobAppPackCert;
        }
        this.setModel(vt.getPSDCMOBPACKCERTID(), vt, null);
        return (IPSDCMobAppPackCert)this.FindModelHelper(vt.getPSDCMOBPACKCERTID());
    }

    @Override
    protected Vector<PSDCMobAppPackCert> getAllModels() throws Exception {
        Vector<PSDCMobAppPackCert> list = new Vector<PSDCMobAppPackCert>();
        CallResult callResult = this.iPSModelHelper.getPSDCMobAppPackCerts(this.iPSDevCenter.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u4e2d\u5fc3\u5168\u90e8\u79fb\u52a8\u5e94\u7528\u6253\u5305\u8bc1\u4e66\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSDCMobAppPackCert vt) {
        return vt.getPSDCMOBPACKCERTID();
    }
}

