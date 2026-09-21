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

import SA.SRFDA.PS.Core.App.IPSAppPkg;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFPkg;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSAppPkg;
import SA.SRFDA.PS.Data.PSPFPkgVer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppPkgImpl
extends PSApplicationObjectImpl
implements IPSAppPkg {
    private static final Log log = LogFactory.getLog(PSAppPkgImpl.class);
    protected PSAppPkg psAppPkg = null;
    private IPSPFPkg iPSPFPkg = null;
    private int nOrderValue = 0;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppPkg psAppPkg) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.psAppPkg = psAppPkg;
            this.setId(this.psAppPkg.getPSAPPPKGID());
            this.setName(this.psAppPkg.getPSAPPPKGNAME());
            this.setPSObjectData(this.psAppPkg);
            if (!this.psAppPkg.isORDERVALUENull()) {
                this.nOrderValue = this.psAppPkg.getORDERVALUE();
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
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psAppPkg.getPSPFPKGID())) {
            this.iPSPFPkg = this.getPSApplication().getPSPF().getPSPFPkg(this.psAppPkg.getPSPFPKGID());
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", hideempty2=true)
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.psAppPkg.getCODENAME();
    }

    @Override
    public String getModelType() {
        return "PSAPPPKG";
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, PSPFPkgVer psSFPkgVer) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSPFPkg getPSPFPkg() {
        return this.iPSPFPkg;
    }

    @Override
    @PSModelRTMeta(description="\u7248\u672c\u6807\u8bb0")
    public String getVerTag() {
        if (this.getPSPFPkg() != null) {
            return this.getPSPFPkg().getTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7248\u672c\u6807\u8bb02")
    public String getVerTag2() {
        if (this.getPSPFPkg() != null) {
            return this.getPSPFPkg().getTag2();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7248\u672c\u53c2\u6570", fields={"PKGPARAM"})
    public String getVerParam() {
        return this.psAppPkg.getPKGPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u7248\u672c\u53c2\u65702", fields={"PKGPARAM2"})
    public String getVerParam2() {
        return this.psAppPkg.getPKGPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u7248\u672c\u53c2\u65703", fields={"PKGPARAM3"})
    public String getVerParam3() {
        return this.psAppPkg.getPKGPARAM3();
    }

    @Override
    @PSModelRTMeta(description="\u7248\u672c\u53c2\u65704", fields={"PKGPARAM4"})
    public String getVerParam4() {
        return this.psAppPkg.getPKGPARAM4();
    }

    @Override
    public IPSPF getPSPF() {
        return this.getPSApplication().getPSPF();
    }

    @Override
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        if (this.getPSApplication() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSApplication().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }
}

