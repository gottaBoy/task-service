/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.AppMenu.IPSAppMenuModel;
import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSAppModule;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppModuleImpl
extends PSApplicationObjectImpl
implements IPSAppModule {
    private static final Log log = LogFactory.getLog(PSAppModuleImpl.class);
    protected PSAppModule psAppModule = null;
    private String strMainMenuAlign = "";
    private boolean bCustomPortalStyle = false;
    private IPSAppMenuModel iPSAppMenuModel = null;
    private boolean bDefaultModule = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppModule psAppModule) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.psAppModule = psAppModule;
            this.setId(this.psAppModule.getPSAPPMODULEID());
            this.setName(this.psAppModule.getPSAPPMODULENAME());
            this.setPSObjectData(this.psAppModule);
            this.strMainMenuAlign = this.psAppModule.getMAINMENUSIDE();
            if (!this.psAppModule.isENABLEMODULESTYLENull()) {
                this.bCustomPortalStyle = this.psAppModule.getENABLEMODULESTYLE();
            }
            if (!this.psAppModule.isDEFAULTFLAGNull()) {
                this.bDefaultModule = this.psAppModule.getDEFAULTFLAG();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.psAppModule.getCODENAME();
    }

    @Override
    public String getModelType() {
        return "PSAPPMODULE";
    }

    @Override
    public String getMainMenuAlign() {
        if (StringHelper.isNullOrEmpty((String)this.strMainMenuAlign)) {
            return this.getPSApplication().getMainMenuAlign();
        }
        return this.strMainMenuAlign;
    }

    @Override
    public boolean isCustomPortalStyle() {
        return this.bCustomPortalStyle;
    }

    @Override
    public IPSAppMenuModel getPSAppMenuModel() throws Exception {
        if (this.iPSAppMenuModel != null) {
            return this.iPSAppMenuModel;
        }
        if (!StringHelper.isNullOrEmpty((String)this.psAppModule.getPSAPPMENUID())) {
            this.iPSAppMenuModel = this.getPSApplication().getPSAppMenuModel(this.psAppModule.getPSAPPMENUID());
        }
        return this.iPSAppMenuModel;
    }

    @Override
    public int check() throws Exception {
        this.getPSAppMenuModel();
        return super.check();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6a21\u5757", ignoredumpvalues="false", fields={"DEFAULTFLAG"})
    public boolean isDefaultModule() {
        return this.bDefaultModule;
    }
}

