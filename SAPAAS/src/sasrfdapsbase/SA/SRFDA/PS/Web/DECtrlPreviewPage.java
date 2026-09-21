/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.PS.Web;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Web.SRFDAPSPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.HashMap;

public class DECtrlPreviewPage
extends SRFDAPSPage {
    protected HashMap<String, IPSGenerateCodeResult> psCodeResultMap = new HashMap();
    protected StringBuilderEx sb = new StringBuilderEx();
    private String strPFType = null;

    public String getPFType() {
        return this.strPFType;
    }

    protected void setPFType(String strPFType) {
        this.strPFType = strPFType;
    }

    public String renderCode(String strCode) {
        return this.renderCode(strCode, 0);
    }

    public String renderCode(String strCode, int nIndex) {
        IPSGenerateCodeResult codeResult = this.psCodeResultMap.get(strCode);
        if (codeResult == null) {
            return "";
        }
        switch (nIndex) {
            case 0: {
                return this.replaceCode(codeResult.getCode());
            }
            case 1: {
                return this.replaceCode(codeResult.getCode2());
            }
            case 2: {
                return this.replaceCode(codeResult.getCode3());
            }
            case 3: {
                return this.replaceCode(codeResult.getCode4());
            }
        }
        return "";
    }

    protected String replaceCode(String strCode) {
        return strCode.replace("${cid}", "").replace("<%=strCId%>", "");
    }

    public String renderCtrl() {
        return this.sb.toString();
    }

    public String getCId() {
        return "";
    }

    protected IPSSystem getPSSystem(String strPSDevSlnSysId, String strPSSystemId) throws Exception {
        return this.getPSSystem(strPSDevSlnSysId, strPSSystemId, IPSSystem.LOADLEVEL_PREVIEW);
    }

    protected IPSSystem getPSSystem(String strPSDevSlnSysId, String strPSSystemId, int nLoadLevel) throws Exception {
        IPSSystem iPSSystem = null;
        if (!StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId)) {
            IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
            iPSSystem = iPSDevSlnSys.getPSSystem(false);
            if (iPSSystem.getLoadedLevel() < nLoadLevel) {
                return iPSDevSlnSys.reloadPSSystem(nLoadLevel);
            }
            return iPSSystem;
        }
        iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
        if (iPSSystem.getLoadedLevel() < nLoadLevel) {
            this.getPSModelStorage().resetPSSystem(strPSSystemId);
            this.getPSModelHelper().startLoadPSSystem(strPSSystemId, nLoadLevel);
            try {
                IPSSystem ipsSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
                ipsSystem.load(nLoadLevel);
                this.getPSModelHelper().stopLoadPSSystem();
            }
            catch (Exception ex) {
                this.getPSModelHelper().stopLoadPSSystem();
                throw ex;
            }
        }
        iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
        return iPSSystem;
    }

    protected IPSApplication getPSApplication(IPSSystem iPSSystem, String strPSSysAppId) throws Exception {
        return this.getPSApplication(iPSSystem, strPSSysAppId, IPSSystem.LOADLEVEL_PREVIEW);
    }

    protected IPSApplication getPSApplication(IPSSystem iPSSystem, String strPSSysAppId, int nLoadLevel) throws Exception {
        IPSApplication iPSApplication = iPSSystem.getPSApplication(strPSSysAppId);
        if (iPSApplication.getLoadedLevel() >= nLoadLevel) {
            return iPSApplication;
        }
        return PSSystemUtil.loadPSApplication(iPSSystem, strPSSysAppId, nLoadLevel);
    }

    protected boolean PreparePageEnv() {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        return super.PreparePageEnv();
    }
}

