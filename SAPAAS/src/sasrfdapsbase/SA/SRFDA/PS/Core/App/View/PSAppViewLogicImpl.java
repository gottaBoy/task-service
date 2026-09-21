/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngine;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImplBase;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppViewLogicImpl
extends PSAppViewLogicImplBase
implements IPSAppViewLogic {
    private static final Log log = LogFactory.getLog(PSAppViewLogicImpl.class);

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, Object objOwner, PSAppViewLogic psAppViewLogic, IPSAppViewEngine iPSAppViewEngine) throws Exception {
        this.setPSAppViewEngine(iPSAppViewEngine);
        this.setBuiltinLogic(true);
        psAppViewLogic.setDSTLOGICTYPE("APPVIEWENGINE");
        this.init(iDAGlobalHelper, objOwner, psAppViewLogic);
    }

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, Object objOwner, PSAppViewLogic psAppViewLogic, IPSAppViewUIAction iPSAppViewUIAction) throws Exception {
        this.setPSAppViewUIAction(iPSAppViewUIAction);
        this.setBuiltinLogic(true);
        psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
        this.init(iDAGlobalHelper, objOwner, psAppViewLogic);
    }

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, Object objOwner, PSAppViewLogic psAppViewLogic, IPSAppUILogic iPSAppUILogic) throws Exception {
        this.setPSAppUILogic(iPSAppUILogic);
        this.setBuiltinLogic(true);
        psAppViewLogic.setDSTLOGICTYPE("SYSVIEWLOGIC");
        this.init(iDAGlobalHelper, objOwner, psAppViewLogic);
    }

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, Object objOwner, PSAppViewLogic psAppViewLogic) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setOwner(objOwner);
            this.psAppViewLogic = psAppViewLogic;
            this.setId(this.psAppViewLogic.getPSAPPVIEWLOGICID());
            this.setName(this.psAppViewLogic.getPSAPPVIEWLOGICNAME());
            this.setPSObjectData(this.psAppViewLogic);
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }
}

