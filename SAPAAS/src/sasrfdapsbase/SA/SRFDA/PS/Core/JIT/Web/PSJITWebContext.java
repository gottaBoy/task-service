/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  javax.servlet.ServletContext
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.ibizsys.paas.util.Base64Helper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 */
package SA.SRFDA.PS.Core.JIT.Web;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSJITSystem;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.IPSModelStorage;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.JIT.App.IPSJITAppModel;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import SA.SRFDA.PS.Core.JIT.Web.IPSJITWebContext;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.Util.FileWriterHelper;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Locale;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;

public class PSJITWebContext
extends WebContext
implements IPSJITWebContext {
    private HashMap<String, Object> sessionValueMap = new HashMap();
    private String strAppName = null;
    private String strAppViewId = null;
    private IPSSystem iPSSystem = null;
    private IPSApplication iPSApplication = null;
    private String strCode = null;
    private IPSJITAppModel iPSJITAppModel = null;
    private IPSJITSystemModel iPSJITSystemModel = null;
    private String strContextPath = null;
    private boolean bRealWriteFile = false;
    private boolean bPreviewMode = false;

    public void init(HttpServletRequest arg0, HttpServletResponse arg1, ServletContext arg2) throws Exception {
        super.init(arg0, arg1, arg2);
        String strUserId = arg0.getHeader("X-SRFUSERID");
        String strUserName = arg0.getHeader("X-SRFUSERNAME");
        if (!StringHelper.IsNullOrEmpty((String)strUserName)) {
            strUserName = new String(Base64Helper.decode((String)strUserName), "UTF-8");
        }
        String strLoginName = arg0.getHeader("X-SRFLOGINNAME");
        WebContext.setCurrent((IWebContext)this);
        String strDevSlnSys = arg0.getHeader("X-SRFDEVSLNSYS");
        String strSystemId = arg0.getHeader("X-SRFSYSTEMID");
        this.strAppViewId = this.getParamValue("PSAPPVIEWID");
        String strAppId = arg0.getHeader("X-SRFAPPID");
        this.strAppName = arg0.getHeader("X-SRFAPPNAME");
        this.strContextPath = arg0.getHeader("X-SRFCTXPATH");
        String strPreviewMode = arg0.getHeader("X-SRFPREVIEW");
        if (StringHelper.Compare((String)strPreviewMode, (String)"1", (boolean)true) == 0) {
            this.bPreviewMode = true;
        }
        this.setCurUserId(strUserId);
        this.setCurUserName(strUserName);
        this.setCurLoginName(strLoginName);
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            this.setSessionValue("SRFSUPERUSER", "1");
            this.setCurUserId("JITUSER");
            this.setCurUserName("JIT\u7528\u6237");
        }
        if (StringHelper.IsNullOrEmpty((String)strLoginName)) {
            this.setCurLoginName("JITUSER");
        }
        this.iPSSystem = StringHelper.Compare((String)strDevSlnSys, (String)"1", (boolean)true) == 0 ? this.getPSSystem(strSystemId, null) : this.getPSSystem(null, strSystemId);
        if (!this.isPreviewMode()) {
            this.iPSJITSystemModel = ((IPSSystemUtil)((Object)this.iPSSystem)).getPSJITSystemModel(this.isPreviewMode());
            if (this.iPSJITSystemModel == null) {
                if (StringHelper.Compare((String)strDevSlnSys, (String)"1", (boolean)true) == 0) {
                    IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strSystemId);
                    this.iPSSystem = iPSDevSlnSys.reloadPSSystem(IPSSystem.LOADLEVEL_JIT);
                }
                this.iPSJITSystemModel = ((IPSSystemUtil)((Object)this.iPSSystem)).getPSJITSystemModel(this.isPreviewMode());
            }
            if (this.iPSJITSystemModel == null) {
                throw new Exception("JIT\u7cfb\u7edf\u6a21\u578b\u65e0\u6548");
            }
        }
        this.iPSApplication = this.getPSApplication(this.iPSSystem, strAppId);
        if (!this.isPreviewMode()) {
            this.iPSJITAppModel = this.iPSJITSystemModel.getAppModel(this.iPSApplication);
        }
    }

    protected void prepareWebApplicationContext() throws Exception {
    }

    @Override
    public String getPSAppViewId() {
        return this.strAppViewId;
    }

    @Override
    public String getPSAppName() {
        return this.strAppName;
    }

    @Override
    public IPSSystem getPSSystem() throws Exception {
        return this.iPSSystem;
    }

    @Override
    public IPSApplication getPSApplication() throws Exception {
        return this.iPSApplication;
    }

    public Object getSessionValue(String strKey) {
        return this.getSessionValue(strKey, true);
    }

    public void setSessionValue(String strKey, Object objValue) {
        this.setSessionValue(strKey, objValue, true);
    }

    public Object getSessionValue(String strKey, boolean bSerializable) {
        return this.sessionValueMap.get(strKey);
    }

    public void setSessionValue(String strKey, Object objValue, boolean bSerializable) {
        if (objValue == null) {
            this.sessionValueMap.remove(strKey);
        } else {
            this.sessionValueMap.put(strKey, objValue);
        }
    }

    @Override
    public ISRFDAGlobalHelper getDAGlobalHelper() {
        return (GlobalHelperEx)this.getGlobalValue("SRFDACONTEXTHELPER");
    }

    protected IPSSystem getPSSystem(String strPSDevSlnSysId, String strPSSystemId) throws Exception {
        IPSSystem iPSSystem = null;
        if (!StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId)) {
            IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
            iPSSystem = iPSDevSlnSys.getPSSystem(false);
            if (iPSSystem.getLoadedLevel() < IPSSystem.LOADLEVEL_JIT) {
                iPSDevSlnSys.reloadPSSystem(IPSSystem.LOADLEVEL_JIT);
            }
            iPSSystem = iPSDevSlnSys.getPSSystem(true);
            if (!this.isPreviewMode() && iPSSystem.getJITPSDBDevInst() == null) {
                throw new Exception("\u5f53\u524d\u6ca1\u6709\u6307\u5b9aJIT\u6570\u636e\u6e90");
            }
        } else {
            iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
            if (iPSSystem.getLoadedLevel() < IPSSystem.LOADLEVEL_JIT) {
                this.getPSModelStorage().resetPSSystem(strPSSystemId);
                this.getPSModelHelper().startLoadPSSystem(strPSSystemId, IPSSystem.LOADLEVEL_JIT);
                try {
                    IPSSystem ipsSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
                    ipsSystem.load(IPSSystem.LOADLEVEL_JIT);
                    this.getPSModelHelper().stopLoadPSSystem();
                }
                catch (Exception ex) {
                    this.getPSModelHelper().stopLoadPSSystem();
                    throw ex;
                }
            }
            iPSSystem = this.getPSModelStorage().getPSSystem(strPSSystemId);
        }
        return iPSSystem;
    }

    protected IPSApplication getPSApplication(IPSSystem iPSSystem, String strPSSysAppId) throws Exception {
        IPSApplication iPSApplication = ((IPSJITSystem)iPSSystem).getPSJITApplication(strPSSysAppId);
        if (iPSApplication.getLoadedLevel() >= IPSSystem.LOADLEVEL_JIT && iPSApplication.isPreviewMode() == this.isPreviewMode()) {
            return iPSApplication;
        }
        return PSSystemUtil.loadPSApplication(iPSSystem, strPSSysAppId, IPSSystem.LOADLEVEL_JIT, true);
    }

    protected IPSModelHelper getPSModelHelper(String strPSSysModelInstId) throws Exception {
        return PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), strPSSysModelInstId);
    }

    protected IPSModelStorage getPSModelStorage() throws Exception {
        return PSObjectFactory.getPSModelStorage(this.getDAGlobalHelper());
    }

    protected IPSModelHelper getPSModelHelper() throws Exception {
        return PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null);
    }

    public static IPSJITWebContext getInstance() {
        IWebContext iWebContext = WebContext.getCurrent();
        if (iWebContext != null && iWebContext instanceof IPSJITWebContext) {
            return (IPSJITWebContext)iWebContext;
        }
        return null;
    }

    @Override
    public String getCode() {
        return this.strCode;
    }

    @Override
    public void writeFile(String strFullPath, String strCode, Object strTag) throws Exception {
        if (this.isRealWriteFile()) {
            FileWriterHelper.write(strFullPath, strCode);
        } else {
            this.strCode = strCode;
        }
    }

    @Override
    public IPSJITAppModel getAppModel() {
        return this.iPSJITAppModel;
    }

    @Override
    public IPSJITSystemModel getSystemModel() {
        return this.iPSJITSystemModel;
    }

    @Override
    public String getContextPath() {
        return this.strContextPath;
    }

    public String getLocalization(String strResId, String strDefault) {
        return strDefault;
    }

    public String getLocalization(String strResId, Object[] params, String strDefault) {
        return strDefault;
    }

    public String getLocalization(String strResId, String strDefault, Locale locale) {
        return strDefault;
    }

    public String getLocalization(String strResId, Object[] params, String strDefault, Locale locale) {
        return strDefault;
    }

    @Override
    public boolean isRealWriteFile() {
        return this.bRealWriteFile;
    }

    @Override
    public void setRealWriteFile(boolean bRealWriteFile) {
        this.bRealWriteFile = bRealWriteFile;
    }

    @Override
    public boolean isPreviewMode() {
        return this.bPreviewMode;
    }

    @Override
    public void resetCode() {
        this.strCode = null;
    }
}

