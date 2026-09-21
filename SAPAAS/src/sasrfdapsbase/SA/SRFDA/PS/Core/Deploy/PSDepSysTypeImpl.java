/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSysApp;
import SA.SRFDA.PS.Core.Deploy.IPSDepSysType;
import SA.SRFDA.PS.Core.Deploy.IPSDepSysVer;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDepSysApp;
import SA.SRFDA.PS.Data.PSDepSysType;
import SA.SRFDA.PS.Data.PSDepSysVer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSysTypeImpl
extends PSObjectImpl
implements IPSDepSysType {
    protected PSDepSysType psDepSysType = null;
    private static final Log log = LogFactory.getLog(PSDepSysTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDepSysType psDepSysType) throws Exception {
        this.psDepSysType = psDepSysType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDepSysType.getPSDEPSYSTYPEID());
        this.setName(psDepSysType.getPSDEPSYSTYPENAME());
        this.setPSObjectData(this.psDepSysType);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public IPSDepSysVer createPSDepSysVer(PSDepSysVer psDepSysVer) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDepSysType.getSYSVEROBJ())) {
            return (IPSDepSysVer)ObjectHelper.Create((String)this.psDepSysType.getSYSVEROBJ());
        }
        throw new Exception("\u6ca1\u6709\u5b9a\u4e49\u53ef\u90e8\u7f72\u7cfb\u7edf\u7248\u672c\u7c7b\u578b\u5bf9\u8c61");
    }

    @Override
    public IPSDepSysApp createPSDepSysApp(PSDepSysApp psDepSysApp) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDepSysType.getSYSAPPOBJ())) {
            return (IPSDepSysApp)ObjectHelper.Create((String)this.psDepSysType.getSYSAPPOBJ());
        }
        throw new Exception("\u6ca1\u6709\u5b9a\u4e49\u53ef\u90e8\u7f72\u7cfb\u7edf\u5e94\u7528\u7c7b\u578b\u5bf9\u8c61");
    }
}

