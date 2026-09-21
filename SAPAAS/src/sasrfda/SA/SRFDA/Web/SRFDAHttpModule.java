/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Mobile.UIPart.Model.MBListMgr
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.CodeList.CodeListMgr
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Localization.ISRFExLocalizationHelper
 *  SA.SRFramework.Utility.Base64
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.DP.UI.DPFormItemConfig
 *  SA.SRFramework.WebEx.Data.WebDBCallerHelperEx
 *  SA.SRFramework.WebEx.ISRFExUserDataGridTheme
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExPage
 *  SA.SRFramework.WebEx.SRFExWebHttpModule
 *  SA.SRFramework.WebEx.UI.UserControlMgr
 *  SA.SRFramework.WebEx.Utility.ISRFExPOLogger
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SRFWF.Ctrl.ISRFWFDataCtrl
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 *  org.apache.commons.httpclient.HttpClient
 *  org.apache.commons.httpclient.HttpMethod
 *  org.apache.commons.httpclient.methods.GetMethod
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web;

import SA.SRFDA.CodeList.DACodeListMgr;
import SA.SRFDA.Common.Version;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEDCProcessStorage;
import SA.SRFDA.Ctrl.Data.AppUITheme;
import SA.SRFDA.Ctrl.Data.DBStorage;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.Data.FormItemEx;
import SA.SRFDA.Ctrl.Data.GlobalObject;
import SA.SRFDA.Ctrl.Data.LoginLog;
import SA.SRFDA.Ctrl.Data.OnlineUser;
import SA.SRFDA.Ctrl.DataNotify.IDataNotifyHelper;
import SA.SRFDA.Ctrl.IDAModelHelper;
import SA.SRFDA.Ctrl.IDAModelStorage;
import SA.SRFDA.Ctrl.IDASubSystemHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrlHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IGlobalObject;
import SA.SRFDA.Ctrl.SOAServiceMgr;
import SA.SRFDA.Ctrl.ServiceMgr;
import SA.SRFDA.Localization.SRFDALocalizationHelper;
import SA.SRFDA.Mobile.UIPart.Model.MBListMgr;
import SA.SRFDA.Model.IDAFormItemHelper;
import SA.SRFDA.Web.Utility.ErrorViewHelper;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFDA.Web.Utility.SRFDAPOLogger;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeListMgr;
import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Localization.ISRFExLocalizationHelper;
import SA.SRFramework.Utility.Base64;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.DP.UI.DPFormItemConfig;
import SA.SRFramework.WebEx.Data.WebDBCallerHelperEx;
import SA.SRFramework.WebEx.ISRFExUserDataGridTheme;
import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExWebHttpModule;
import SA.SRFramework.WebEx.UI.UserControlMgr;
import SA.SRFramework.WebEx.Utility.ISRFExPOLogger;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SRFWF.Ctrl.ISRFWFDataCtrl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFDAHttpModule
extends SRFExWebHttpModule {
    public static final String TAG_SRFDAMODELHELPER = "SRFDAMODELHELPER";
    public static final String TAG_SRFDAFORMITEMHELPER = "SRFDAFORMITEMHELPER";
    public static final String TAG_SRFDACONFIGMGR = "SRFDACONFIGMGR";
    public static final String TAG_SRFDACONTEXTHELPER = "SRFDACONTEXTHELPER";
    public static final String TAG_SRFDAMODELSTORAGE = "SRFDAMODELSTORAGE";
    public static final String TAG_SRFDADEDATACTRLHELPER = "SRFDADEDATACTRLHELPER";
    public static final String TAG_SRFDADEDCPROCESSSTORAGE = "SRFDADEDCPROCESSSTORAGE";
    public static final String TAG_SRFDASERVICEMGR = "SRFDASERVICEMGR";
    public static final String TAG_SRFDASOASERVICEMGR = "SRFDASOASERVICEMGR";
    public static final String TAG_SRFDAPAGEHELPER = "SRFDAPAGEHELPER";
    public static final String TAG_SRFDADATANOTIFYHELPER = "SRFDADATANOTIFYHELPER";
    public static final String TAG_SRFDAMBLISTMGR = "SRFDAMBLISTMGR";
    public static final String TAG_SRFDAAPPMODE = "SRFDAAPPMODE";
    protected MBListMgr mgListMgr = new MBListMgr();
    protected boolean bAuthFilter = false;
    protected String strAuthPath = "";
    protected GlobalHelperEx contextHelperEx = null;
    protected Hashtable<String, Integer> unauthpathMap = new Hashtable();
    private DACodeListMgr daCodeListMgr = new DACodeListMgr();
    private static Log log = LogFactory.getLog(SRFDAHttpModule.class);
    private ServiceMgr serviceMgr = null;
    private SOAServiceMgr soaServiceMgr = null;
    private static final String[] minDEList = new String[]{"DE0001", "DE0002", "DE0003"};
    private String strRandomKey = "";
    private static final Random random = new Random();
    private boolean bDevelopMode = true;
    private boolean bNoUserMode = false;
    private static Hashtable<Integer, Integer> accKeyMap = new Hashtable();
    private static Vector<Integer> accKeyList = new Vector();
    private int nIndex = 0;
    private static Hashtable<String, HttpSession> userSessionMap = new Hashtable();
    private static final String TAG_LICENSEKEY = "{49A0D78B-8D96-4EEF-A29A-C98BE65D0321}";
    private static final String TAG_LICENSEPWD = "{715009AA-5AC8-45B6-B2BE-0AC1A7354FE3}";
    private static final String TAG_LASTLICENSETIME = "{74DFFFD5-04B9-4306-9119-2889CD2BB334}";
    private static final String TAG_LICSTATUS = "{075674F3-7934-418D-AC9C-1E3F150C825A}";
    private Timer licenseUpdateTimer = null;
    private boolean bGA = true;
    private boolean bGA2 = false;
    private boolean bGA3 = false;
    private String strProductId = "";
    protected static IDEDataCtrl loginLogDataCtrl = null;
    protected static IDEDataCtrl onlineUserDataCtrl = null;
    private static final String CUSTOMCALL_1 = "1";
    private static final String PERSONID = "PERSONID";
    protected String strServerName = "";
    protected Hashtable<String, String> authPathMap = new Hashtable();
    private IDAModelHelper iDAModelHelper = null;

    static {
        int i2 = 0;
        while (i2 < 10) {
            accKeyList.add(Math.abs(random.nextInt(10000000)));
            ++i2;
        }
        for (int i2 : accKeyList) {
            accKeyMap.put(i2, 0);
        }
    }

    protected void OnInit() {
        super.OnInit();
        this.mgListMgr.setFolderSeperator(this.strFolderSeperator);
        this.mgListMgr.setConfigPaths(this.arrConfigPaths);
        this.mgListMgr.setEncrypt(this.bEncrypt);
        this.filterConfig.getServletContext().setAttribute(TAG_SRFDAMBLISTMGR, (Object)this.mgListMgr);
        this.bGA3 = this.bGA2 = this.bGA;
        this.strProductId = this.GetProductId();
        this.strServerName = this.webConfig.GetExtValue("SERVERNAME", "");
        this.strRandomKey = StringHelper.Format((String)"__%1$s", (Object)random.nextInt(100));
        this.dataGridMgr.setLoadDGTemplate(false);
        this.contextHelperEx = new GlobalHelperEx(this.filterConfig.getServletContext());
        this.filterConfig.getServletContext().setAttribute(TAG_SRFDACONTEXTHELPER, (Object)this.contextHelperEx);
        GlobalHelperEx.setInstance(this.contextHelperEx);
        this.daCodeListMgr.setGlobalHelperEx(this.contextHelperEx);
        if (this.contextHelperEx.getDAConfigMgr() != null) {
            this.contextHelperEx.getDAConfigMgr().setGlobalHelperEx(this.contextHelperEx);
        }
        this.InstallPlugin();
        this.CheckAppLicense();
    }

    private final void InstallPlugin() {
        String strGAApplication = this.webConfig.GetExtValue("HTTPMODULEPLUGIN", "");
    }

    private final void CheckAppLicense() {
        if (!this.bGA) {
            return;
        }
        String strGAApplication = this.webConfig.GetExtValue("GAAPPLICATION", "");
        if (StringHelper.IsNullOrEmpty((String)strGAApplication)) {
            log.info((Object)StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u6388\u6743\u5e94\u7528\u7f16\u53f7"));
            return;
        }
        String strGALicServer = this.webConfig.GetExtValue("GALICSERVER", "");
        if (StringHelper.IsNullOrEmpty((String)strGALicServer)) {
            log.info((Object)StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u6388\u6743\u670d\u52a1\u5668\u8def\u5f84"));
            return;
        }
        log.info((Object)StringHelper.Format((String)"\u6388\u6743\u5e94\u7528\u7f16\u53f7[%1$s]", (Object)strGAApplication));
        String strUrl = StringHelper.Format((String)"%1$s/licaction?GAACTION=REGAPP&GAAPPPID=%2$s", (Object)strGALicServer, (Object)strGAApplication);
        HttpClient httpClient = new HttpClient();
        GetMethod postMethod = new GetMethod(strUrl);
        try {
            int statusCode = httpClient.executeMethod((HttpMethod)postMethod);
            if (statusCode == 200) {
                byte[] body = postMethod.getResponseBody();
                String strResult = new String(body);
                strResult = strResult.trim();
                Calendar calendar = Calendar.getInstance();
                int nYear = calendar.get(1);
                int nMonth = calendar.get(2);
                int nDay = calendar.get(5);
                byte[] keyData = new byte[]{(byte)(nYear / 1000), (byte)(nYear % 1000 / 100), (byte)(nYear % 100 / 10), (byte)(nYear % 10), (byte)(nMonth / 10), (byte)(nMonth % 10), (byte)(nDay / 10), (byte)(nDay % 10)};
                byte[] buff = Base64.decode((String)strResult);
                byte[] buff2 = SRFDAHttpModule.SymmetricDecrypto(buff, keyData);
                this.filterConfig.getServletContext().setAttribute(TAG_LICENSEKEY, (Object)strResult);
                this.filterConfig.getServletContext().setAttribute(TAG_LICENSEPWD, (Object)keyData);
                strResult = new String(buff2);
                XMLConfig xmlConfig = new XMLConfig();
                XMLConfig.LoadFromXML((String)strResult, (XMLConfig)xmlConfig);
                if (xmlConfig.GetExtValue("RETCODE", 1) != 0) {
                    log.info((Object)StringHelper.Format((String)"\u68c0\u67e5\u6388\u6743\u5e94\u7528\u5931\u8d25\uff0c%1$s", (Object)xmlConfig.GetExtValue("RETINFO", "\u4e0d\u660e\u9519\u8bef")));
                } else {
                    String strProductId = xmlConfig.GetExtValue("PRODUCTID", "");
                    if (StringHelper.Compare((String)strProductId, (String)this.strProductId, (boolean)true) != 0) {
                        log.info((Object)StringHelper.Format((String)"\u68c0\u67e5\u6388\u6743\u5e94\u7528\u5931\u8d25\uff0c%1$s", (Object)"\u6388\u6743\u4ea7\u54c1\u4e0e\u5f53\u524d\u4ea7\u54c1\u4e0d\u4e00\u81f4"));
                        return;
                    }
                    int nUserBOCount = xmlConfig.GetExtValue("USERBOCOUNT", 0);
                    int nCPUCount = xmlConfig.GetExtValue("CPUCOUNT", 0);
                    if (nCPUCount > 0 && nCPUCount < Runtime.getRuntime().availableProcessors()) {
                        log.info((Object)StringHelper.Format((String)"\u68c0\u67e5\u6388\u6743\u5e94\u7528\u5931\u8d25\uff0c\u7cfb\u7edfCPU\u6570\u91cf[%1$s]\u8d85\u8fc7\u6388\u6743CPU\u6570\u91cf[%2$s]", (Object)Runtime.getRuntime().availableProcessors(), (Object)nCPUCount));
                        return;
                    }
                    log.info((Object)StringHelper.Format((String)"\u6388\u6743\u52a0\u8f7d\u5b8c\u6210\u3002\r\n\u7528\u6237\u6269\u5c55\u4e1a\u52a1\u5b9e\u4f53\u6570[%1$s]\r\n\u6388\u6743\u5e94\u7528[%2$s]", (Object)nUserBOCount, (Object)strProductId));
                    this.bDevelopMode = false;
                    this.filterConfig.getServletContext().setAttribute(TAG_LASTLICENSETIME, (Object)(calendar.getTime().getTime() / 77L));
                    this.licenseUpdateTimer = new Timer(Helper.GenGuidEx());
                    this.licenseUpdateTimer.schedule((TimerTask)new LicenseUpdater(this.contextHelperEx, xmlConfig.GetExtValue("SESSIONID", "")), 300000L, 300000L);
                    this.contextHelperEx.SetGlobalValue(TAG_LICSTATUS, StringHelper.Format((String)"%1$s", (Object)nUserBOCount));
                }
            }
        }
        catch (Exception e) {
            log.error((Object)e);
            log.error((Object)StringHelper.Format((String)"\u6388\u6743\u68c0\u67e5\u5931\u8d25!"));
        }
    }

    protected void OnAfterInit() {
        boolean bStartSOAServiceMgr;
        boolean bPreload;
        super.OnAfterInit();
        SRFExPage.SetMultiLanguageHeader((String)this.OnGetMultiLanguageHeader());
        String strAppMode = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "APPMODE", "");
        if (!StringHelper.IsNullOrEmpty((String)strAppMode)) {
            this.filterConfig.getServletContext().setAttribute(TAG_SRFDAAPPMODE, (Object)strAppMode);
            log.info((Object)StringHelper.Format((String)"\u7cfb\u7edf\u542f\u7528\u5e94\u7528\u6a21\u5f0f[%1$s]", (Object)strAppMode));
        }
        ErrorViewHelper.setErrorViewUrl(this.contextHelperEx.getWebExConfig().GetValue("SRFDA.DEFAULTVIEW", "ERRORVIEW", "../srfpage/errorview.jsp"));
        DEDCProcessStorage dedcProcessStorage = new DEDCProcessStorage();
        dedcProcessStorage.Init(this.contextHelperEx);
        this.filterConfig.getServletContext().setAttribute(TAG_SRFDADEDCPROCESSSTORAGE, (Object)dedcProcessStorage);
        if (this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "MULTIDBSTORAGE", false)) {
            this.OnPrepareDBStorage();
        }
        if (bPreload = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "PRELOADDEHELPER", false)) {
            this.iDAModelHelper.startPreload();
            this.OnPreloadDEHelper(true);
            if (bPreload) {
                this.OnPreloadDEHelper(false);
            }
            this.iDAModelHelper.stopPreload();
        } else {
            this.OnPreloadDEHelper(true);
        }
        IDataNotifyHelper iDataNotifyHelper = this.CreateDataNotifyHelper();
        if (iDataNotifyHelper != null) {
            this.contextHelperEx.SetGlobalValue(TAG_SRFDADATANOTIFYHELPER, iDataNotifyHelper);
        } else {
            log.warn((Object)StringHelper.Format((String)"\u6570\u636e\u901a\u77e5\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548\uff0c\u53ef\u80fd\u4f1a\u53d1\u751f\u9519\u8bef"));
        }
        this.OnPrepareGlobalObject();
        this.OnPrepareFormItemEx();
        this.OnPrepareAppUITheme();
        this.OnPrepareSubSystem();
        boolean bStartServiceMgr = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "STARTSERVICEMGR", false);
        if (bStartServiceMgr) {
            String strServiceContainer = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "SERVICECONTAINER", "");
            try {
                this.serviceMgr = new ServiceMgr(this.contextHelperEx, strServiceContainer);
                this.contextHelperEx.SetGlobalValue(TAG_SRFDASERVICEMGR, this.serviceMgr);
                this.serviceMgr.Start();
                log.info((Object)StringHelper.Format((String)"\u670d\u52a1\u7ba1\u7406\u5668[%1$s] \u542f\u52a8\u6210\u529f.", (Object)(StringHelper.IsNullOrEmpty((String)strServiceContainer) ? "DEFAULT" : strServiceContainer)));
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u670d\u52a1\u7ba1\u7406\u5668[%1$s] \u542f\u52a8\u5931\u8d25 .%2$s", (Object)(StringHelper.IsNullOrEmpty((String)strServiceContainer) ? "DEFAULT" : strServiceContainer), (Object)ex.getMessage()), (Throwable)ex);
            }
        }
        if (bStartSOAServiceMgr = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "STARTSOASERVICEMGR", false)) {
            try {
                this.soaServiceMgr = new SOAServiceMgr(this.contextHelperEx);
                this.contextHelperEx.SetGlobalValue(TAG_SRFDASOASERVICEMGR, this.soaServiceMgr);
                log.info((Object)StringHelper.Format((String)"SOA \u670d\u52a1\u7ba1\u7406\u5668\u542f\u52a8\u6210\u529f."));
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"SOA \u670d\u52a1\u7ba1\u7406\u5668\u542f\u52a8\u5931\u8d25\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
        if (this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "PREPAREWFENGINE", false)) {
            this.OnPrepareWFEngine();
        }
        if (this.contextHelperEx.getDAModelVersion() >= 10113000) {
            loginLogDataCtrl = this.contextHelperEx.getDAModelStorage().FindDEDataCtrl("DE0143", "SYSTEM", null);
            onlineUserDataCtrl = this.contextHelperEx.getDAModelStorage().FindDEDataCtrl("DE0054", "SYSTEM", null);
            if (onlineUserDataCtrl != null) {
                String strHostId = this.contextHelperEx.getWebExConfig().GetValue("SRFEXWEB", "HOSTID", "");
                if (StringHelper.IsNullOrEmpty((String)strHostId)) {
                    BaseDEDataCtrl.ExecuteWithoutResult(this.contextHelperEx, "DELETE FROM T_SRFONLINEUSER WHERE SERVERID IS NULL", null);
                } else {
                    BaseDEDataCtrl.ExecuteWithoutResult(this.contextHelperEx, StringHelper.Format((String)"DELETE FROM T_SRFONLINEUSER WHERE SERVERID = '%1$s'", (Object)strHostId), null);
                }
            }
        }
        this.OnPrepareAuthFilter();
        this.OnRegisterUserDataGridTheme();
        this.iDAModelHelper.setPreloadDEIds("");
    }

    protected void OnRegisterUserDataGridTheme() {
        Object obj;
        String strObjId = this.contextHelperEx.getWebConfig().GetExtValue("USERDATAGRIDTHEME", "");
        if (StringHelper.Length((String)strObjId) > 0 && (obj = ObjectHelper.Create((String)strObjId)) != null && obj instanceof ISRFExUserDataGridTheme) {
            ISRFExUserDataGridTheme iUserDataGridTheme = (ISRFExUserDataGridTheme)obj;
            SRFExDataGrid.setUserDataGridTheme((ISRFExUserDataGridTheme)iUserDataGridTheme);
        }
    }

    private final void OnPrepareWFEngine() {
        ISRFWFDataCtrl wfDataCtrl;
        log.info((Object)StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u5f15\u64ce\u9884\u51c6\u5907\u5f00\u59cb"));
        String strDataCtrlObject = this.contextHelper.getWebExConfig().GetValue("SRFWF", "WFDATACTRL", "");
        if (StringHelper.IsNullOrEmpty((String)strDataCtrlObject)) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41\u5f15\u64ce\u6570\u636e\u5bf9\u8c61"));
            return;
        }
        Object objDataCtrl = ObjectHelper.Create((String)strDataCtrlObject);
        if (objDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5de5\u4f5c\u6d41\u5f15\u64ce\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)objDataCtrl));
            return;
        }
        if (objDataCtrl instanceof ISRFWFDataCtrl && (wfDataCtrl = (ISRFWFDataCtrl)objDataCtrl).isMultiUse()) {
            WebDBCallerHelperEx dbCallerHelper = (WebDBCallerHelperEx)this.filterConfig.getServletContext().getAttribute("SRFDBCALLERHELPER");
            wfDataCtrl.Init(this.filterConfig.getServletContext(), (BaseDBCallerHelperEx)dbCallerHelper);
            this.filterConfig.getServletContext().setAttribute("SRFWFDATACTRL", (Object)wfDataCtrl);
            log.info((Object)StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u5f15\u64ce\u9884\u51c6\u5907\u5b8c\u6210!"));
            return;
        }
        log.error((Object)StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[ISRFWFDataCtrl]", (Object)objDataCtrl));
    }

    private final void OnPrepareAuthFilter() {
        String strAuthFilter = this.filterConfig.getInitParameter("AUTHFILTER");
        if (!StringHelper.IsNullOrEmpty((String)strAuthFilter)) {
            this.bAuthFilter = StringHelper.Compare((String)strAuthFilter, (String)"TRUE", (boolean)true) == 0;
            this.strAuthPath = this.filterConfig.getInitParameter("AUTHPATH");
            if (StringHelper.IsNullOrEmpty((String)this.strAuthPath)) {
                this.bAuthFilter = false;
                log.error((Object)"\u6ca1\u6709\u6307\u5b9a\u8ba4\u8bc1\u8def\u5f84\uff0c\u4e0d\u542f\u7528\u8ba4\u8bc1\u8fc7\u6ee4");
            }
        }
        if (this.bAuthFilter) {
            String strAuthServer;
            this.unauthpathMap.put("/srfapp/remotecall.jsp", 1);
            this.unauthpathMap.put("/commonex/accessdeny_major.jsp", 1);
            this.unauthpathMap.put("/commonex/accessdeny_minor.jsp", 1);
            this.unauthpathMap.put("/commonex/showerror.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogin2.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogin.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogin3.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogin4.jsp", 1);
            this.unauthpathMap.put("/uacclient/uacremotelogin.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogout.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogin_formaction.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogin_gridaction.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogin_pagemodel.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogin_formaction2.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogin_gridaction2.jsp", 1);
            this.unauthpathMap.put(this.strAuthPath, 1);
            String strUnfilterPath = this.contextHelperEx.getRegisterMgr().GetRegistryParam("SRFDAWEB\\AUTHFILTER.SYSTEM\\UNFILTER", "");
            strUnfilterPath = String.valueOf(strUnfilterPath) + ";";
            strUnfilterPath = String.valueOf(strUnfilterPath) + this.contextHelperEx.getRegisterMgr().GetRegistryParam("SRFDAWEB\\AUTHFILTER.USER\\UNFILTER", "");
            String[] paths = strUnfilterPath.split("[;]");
            int i = 0;
            while (i < paths.length) {
                String strPath = paths[i];
                if (!StringHelper.IsNullOrEmpty((String)strPath)) {
                    this.unauthpathMap.put(strPath, 1);
                }
                ++i;
            }
            if (this.strAuthPath.indexOf("http") != 0 && this.strAuthPath.indexOf("..") != 0) {
                this.strAuthPath = ".." + this.strAuthPath;
                this.strAuthPath = URLHelper.AppendURLSeperator((String)this.strAuthPath);
                this.strAuthPath = String.valueOf(this.strAuthPath) + "RU=";
            }
            if (!StringHelper.IsNullOrEmpty((String)(strAuthServer = this.filterConfig.getInitParameter("AUTHSERVER")))) {
                String[] authServers;
                strAuthServer = strAuthServer.toUpperCase();
                String[] stringArray = authServers = strAuthServer.split("[|]");
                int n = authServers.length;
                int n2 = 0;
                while (n2 < n) {
                    String strAuthServerItem = stringArray[n2];
                    String strAuthPath = this.filterConfig.getInitParameter("AUTHPATH_" + strAuthServerItem.replace(".", "_"));
                    if (!StringHelper.IsNullOrEmpty((String)strAuthPath) && strAuthPath.indexOf("http") != 0 && strAuthPath.indexOf("..") != 0) {
                        strAuthPath = ".." + strAuthPath;
                        strAuthPath = URLHelper.AppendURLSeperator((String)strAuthPath);
                        strAuthPath = String.valueOf(strAuthPath) + "RU=";
                        this.authPathMap.put(strAuthServerItem, strAuthPath);
                    }
                    ++n2;
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void DoWithPage(HttpServletRequest request, HttpServletResponse response) {
        if (this.bGA3) {
            block43: {
                try {
                    HttpSession removeSession;
                    String strSessionId = request.getSession().getId();
                    boolean bContain = true;
                    Hashtable<String, HttpSession> hashtable = userSessionMap;
                    synchronized (hashtable) {
                        bContain = userSessionMap.containsKey(strSessionId);
                    }
                    if (bContain) break block43;
                    if (this.bDevelopMode) {
                        if (this.bGA3 && this.bNoUserMode) {
                            request.getSession().removeAttribute(PERSONID);
                        }
                        removeSession = null;
                        Hashtable<String, HttpSession> hashtable2 = userSessionMap;
                        synchronized (hashtable2) {
                            if (userSessionMap.size() >= 2) {
                                for (String strKey : userSessionMap.keySet()) {
                                    HttpSession session = userSessionMap.get(strKey);
                                    if (removeSession == null) {
                                        removeSession = session;
                                        continue;
                                    }
                                    try {
                                        if (removeSession.getLastAccessedTime() <= session.getLastAccessedTime()) continue;
                                        removeSession = session;
                                    }
                                    catch (Exception ex) {
                                        log.error((Object)ex);
                                        removeSession = session;
                                        break;
                                    }
                                }
                                if (removeSession != null) {
                                    userSessionMap.remove(removeSession.getId());
                                }
                            }
                        }
                        try {
                            if (removeSession != null) {
                                removeSession.invalidate();
                            }
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                    removeSession = userSessionMap;
                    synchronized (removeSession) {
                        userSessionMap.put(strSessionId, request.getSession());
                    }
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
            }
            this.nIndex += 3;
            if (this.nIndex > 100000000) {
                this.nIndex = 0;
            }
            request.setAttribute(this.strRandomKey, (Object)accKeyList.get(this.nIndex % 10));
        }
        if (this.bGA3 && this.bDevelopMode && this.bNoUserMode) {
            request.getSession().removeAttribute(PERSONID);
        }
        if (this.bAuthFilter && request.getSession().getAttribute(PERSONID) == null) {
            String strCurPath = request.getRequestURL().toString();
            String strContextPath = request.getContextPath();
            String strServerName2 = request.getServerName();
            int nStartPos = strCurPath.indexOf(strServerName2);
            nStartPos = nStartPos != -1 ? (nStartPos += strServerName2.length()) : 0;
            int nContextPathPos = strCurPath.indexOf(strContextPath, nStartPos);
            if (nContextPathPos != -1) {
                strCurPath = strCurPath.substring(nContextPathPos + strContextPath.length());
            }
            if (!this.unauthpathMap.containsKey(strCurPath)) {
                try {
                    request.setAttribute("SRF_RESPONSE_REDIRECT", (Object)1);
                    boolean bDirectLogin = false;
                    int nPos = strCurPath.lastIndexOf("backend.jsp");
                    if (nPos != -1) {
                        String strActionType = request.getParameter("srfactiontype");
                        if (StringHelper.IsNullOrEmpty((String)strActionType)) {
                            strActionType = request.getParameter("actiontype");
                        }
                        if (!StringHelper.IsNullOrEmpty((String)strActionType)) {
                            nPos = strCurPath.lastIndexOf("modelbackend.jsp");
                            if (nPos == -1) {
                                if (StringHelper.Compare((String)strActionType, (String)"formaction", (boolean)true) == 0) {
                                    response.sendRedirect("../uacclient/uaclogin_formaction.jsp");
                                    return;
                                }
                                if (StringHelper.Compare((String)strActionType, (String)"gridaction", (boolean)true) == 0) {
                                    response.sendRedirect("../uacclient/uaclogin_gridaction.jsp");
                                    return;
                                }
                                response.sendRedirect("../uacclient/uaclogin_backendaction.jsp");
                                return;
                            }
                            if (StringHelper.Compare((String)strActionType, (String)"formaction", (boolean)true) == 0) {
                                response.sendRedirect("../uacclient/uaclogin_formaction2.jsp");
                                return;
                            }
                            if (StringHelper.Compare((String)strActionType, (String)"gridaction", (boolean)true) == 0) {
                                response.sendRedirect("../uacclient/uaclogin_gridaction2.jsp");
                                return;
                            }
                            response.sendRedirect("../uacclient/uaclogin_backendaction2.jsp");
                            return;
                        }
                    } else {
                        nPos = strCurPath.lastIndexOf("model.jsp");
                        if (nPos != -1) {
                            Hashtable<String, String> urlParams = new Hashtable<String, String>();
                            SRFDAHttpModule.ParseQueryString(request.getQueryString(), urlParams);
                            String strPageModel = urlParams.get("SRFPAGEMODEL");
                            if (!StringHelper.IsNullOrEmpty((String)strPageModel)) {
                                response.sendRedirect("../uacclient/uaclogin_pagemodel.jsp");
                                return;
                            }
                        }
                        if ((nPos = strCurPath.lastIndexOf("/uacclient/uaclogin_popup.jsp")) != -1) {
                            bDirectLogin = true;
                        }
                    }
                    String strRequestUrl = "";
                    strRequestUrl = StringHelper.IsNullOrEmpty((String)this.strServerName) ? request.getRequestURL().toString() : String.valueOf(this.strServerName) + strContextPath + strCurPath;
                    String strQueryString = request.getQueryString();
                    String strParams = "";
                    strParams = StringHelper.IsNullOrEmpty((String)strQueryString) ? String.valueOf(URLHelper.EncodeURLParamValue((String)strRequestUrl)) + (bDirectLogin ? "&DIRECT=TRUE" : "") : String.valueOf(URLHelper.EncodeURLParamValue((String)(String.valueOf(strRequestUrl) + "?" + request.getQueryString()))) + (bDirectLogin ? "&DIRECT=TRUE" : "");
                    String strAuthPath = this.authPathMap.get(request.getServerName().toUpperCase());
                    if (StringHelper.IsNullOrEmpty((String)strAuthPath)) {
                        strAuthPath = this.strAuthPath;
                    }
                    response.sendRedirect(String.valueOf(strAuthPath) + strParams);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
        super.DoWithPage(request, response);
    }

    protected static void ParseQueryString(String strQueryString, Hashtable<String, String> urlParams) {
        if (strQueryString == null) {
            return;
        }
        String[] strLists = strQueryString.split("&");
        int i = 0;
        while (i < strLists.length) {
            String[] set = strLists[i].split("=");
            if (set.length == 2) {
                try {
                    String strValue = URLDecoder.decode(set[1], "UTF-8");
                    if (StringHelper.Length((String)strValue) != 0) {
                        urlParams.put(set[0].toUpperCase(), strValue);
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            ++i;
        }
    }

    private final void OnPrepareDBStorage() {
        Vector<DBStorage> dbStorages = new Vector<DBStorage>();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDBStorages(dbStorages);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5b58\u50a8\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        for (DBStorage dbStorage : dbStorages) {
            String strDBCaller = dbStorage.getDBCALLER();
            if (StringHelper.IsNullOrEmpty((String)strDBCaller)) {
                log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u6570\u636e\u5b58\u50a8[%1$s]\u6307\u5b9a\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)dbStorage.getDBSTORAGEID()));
                return;
            }
            Object objDBCaller = ObjectHelper.Create((String)strDBCaller);
            if (objDBCaller == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61[%1$s]", (Object)strDBCaller));
                return;
            }
            if (!(objDBCaller instanceof WebDBCallerHelperEx)) {
                log.error((Object)StringHelper.Format((String)"[%1$s]\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strDBCaller));
                return;
            }
            WebDBCallerHelperEx webDBCallerHelperEx = (WebDBCallerHelperEx)objDBCaller;
            webDBCallerHelperEx.setDSN(dbStorage.getDSN());
            this.filterConfig.getServletContext().setAttribute("SRFDBCALLERHELPER" + dbStorage.getDBSTORAGEID(), (Object)webDBCallerHelperEx);
        }
    }

    private final void OnPrepareGlobalObject() {
        Vector<GlobalObject> globalObjects = new Vector<GlobalObject>();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetGlobalObjects(globalObjects);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5168\u5c40\u5bf9\u8c61\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        for (GlobalObject globalObject : globalObjects) {
            String strGlobalObject = globalObject.getGOOBJECT();
            if (StringHelper.IsNullOrEmpty((String)strGlobalObject)) {
                log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u5168\u5c40\u5bf9\u8c61[%1$s]\u6307\u5b9a\u7c7b", (Object)strGlobalObject));
                return;
            }
            Object objGlobalObject = ObjectHelper.Create((String)strGlobalObject);
            if (objGlobalObject == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61[%1$s]", (Object)strGlobalObject));
                return;
            }
            if (!(objGlobalObject instanceof IGlobalObject)) {
                log.error((Object)StringHelper.Format((String)"[%1$s]\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strGlobalObject));
                return;
            }
            IGlobalObject iGlobalObject = (IGlobalObject)objGlobalObject;
            iGlobalObject.Init(this.contextHelperEx);
            this.filterConfig.getServletContext().setAttribute("SRFGO:" + globalObject.getGLOBALOBJECTID(), (Object)iGlobalObject);
        }
    }

    private final void OnPrepareFormItemEx() {
        Vector<FormItemEx> formItemexs = new Vector<FormItemEx>();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetValidFormItemExs(formItemexs);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8868\u5355\u9879\u6269\u5c55\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        UserControlMgr userControlMgr = this.contextHelperEx.getGlobalConfigMgr().GetUserControlMgr();
        for (FormItemEx formItemEx : formItemexs) {
            if (formItemEx.getUSERCONTROL()) {
                if (userControlMgr == null) continue;
                userControlMgr.RegisterUserControlItem(formItemEx.getCONFIGCLASS().trim(), formItemEx.getCONTROLCLASS().trim());
                continue;
            }
            String strTagName = formItemEx.getTAGNAME().trim().toUpperCase();
            if (!StringHelper.IsNullOrEmpty((String)strTagName)) {
                DPFormItemConfig.RegisterControl((String)strTagName, (String)formItemEx.getCONFIGCLASS().trim());
            }
            SRFExDPEx.RegisterControl((String)formItemEx.getCONFIGCLASS().trim(), (String)formItemEx.getCONTROLCLASS().trim());
        }
    }

    protected final void OnPreloadDEHelper(boolean bMin) {
        if (!bMin) {
            String strReloadDEHelpers = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "PRELOADDEHELPERS", "");
            String[] deids = null;
            if (!StringHelper.IsNullOrEmpty((String)strReloadDEHelpers)) {
                strReloadDEHelpers = strReloadDEHelpers.replace(",", ";");
                deids = strReloadDEHelpers.split("[;]");
            }
            Vector<DataEntity> list = new Vector<DataEntity>();
            CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDataEntities("SRFDA", list);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6846\u67b6\u5b9e\u4f53\u5217\u8868\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return;
            }
            callResult = this.contextHelperEx.getDAModelHelper().GetDataEntities("APPLICATION", list);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5b9e\u4f53\u5217\u8868\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return;
            }
            callResult = this.contextHelperEx.getDAModelHelper().GetDataEntities("USER", list);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u5b9e\u4f53\u5217\u8868\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return;
            }
            for (DataEntity dataEntity : list) {
                if (deids != null) {
                    boolean bOk = false;
                    String strDEId = dataEntity.getDEID();
                    String[] stringArray = deids;
                    int n = deids.length;
                    int n2 = 0;
                    while (n2 < n) {
                        String strItemId = stringArray[n2];
                        if (strDEId.indexOf(strItemId) == 0) {
                            bOk = true;
                            break;
                        }
                        ++n2;
                    }
                    if (!bOk) continue;
                }
                try {
                    log.debug((Object)StringHelper.Format((String)"\u9884\u52a0\u8f7d\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5f00\u59cb", (Object)dataEntity.getDEID()));
                    IDEHelper iDEHelper = this.contextHelperEx.getDAModelStorage().FindDEHelper(dataEntity.getDEID());
                    if (iDEHelper == null) {
                        log.error((Object)StringHelper.Format((String)"\u9884\u52a0\u8f7d\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)dataEntity.getDEID()));
                        continue;
                    }
                    log.info((Object)StringHelper.Format((String)"\u9884\u52a0\u8f7d\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5b8c\u6210", (Object)dataEntity.getDEID()));
                }
                catch (Exception ex) {
                    log.error((Object)StringHelper.Format((String)"\u9884\u52a0\u8f7d\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)dataEntity.getDEID(), (Object)ex.getMessage()), (Throwable)ex);
                }
            }
        } else {
            int i = 0;
            while (i < minDEList.length) {
                log.debug((Object)StringHelper.Format((String)"\u9884\u52a0\u8f7d\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5f00\u59cb", (Object)minDEList[i]));
                IDEHelper iDEHelper = this.contextHelperEx.getDAModelStorage().FindDEHelper(minDEList[i]);
                if (iDEHelper == null) {
                    log.error((Object)StringHelper.Format((String)"\u9884\u52a0\u8f7d\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)minDEList[i]));
                } else {
                    log.info((Object)StringHelper.Format((String)"\u9884\u52a0\u8f7d\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5b8c\u6210", (Object)minDEList[i]));
                }
                ++i;
            }
        }
    }

    protected final void SetDAModelHelper(IDAModelHelper iDAModelHelper) {
        if (iDAModelHelper != null) {
            iDAModelHelper.SetDAGlobalHelper(this.contextHelperEx);
            this.filterConfig.getServletContext().setAttribute(TAG_SRFDAMODELHELPER, (Object)iDAModelHelper);
            this.iDAModelHelper = iDAModelHelper;
        } else {
            this.iDAModelHelper = null;
        }
    }

    protected final void SetDAFormItemHelper(IDAFormItemHelper iDAFormItemHelper) {
        if (iDAFormItemHelper != null) {
            this.filterConfig.getServletContext().setAttribute(TAG_SRFDAFORMITEMHELPER, (Object)iDAFormItemHelper);
        }
    }

    protected final void SetDAModelStorage(IDAModelStorage daModelStorage) {
        if (daModelStorage != null) {
            this.filterConfig.getServletContext().setAttribute(TAG_SRFDAMODELSTORAGE, (Object)daModelStorage);
            daModelStorage.Init();
        }
    }

    private final void i1() {
    }

    protected String OnGetMultiLanguageHeader() {
        String strSRFLanguageFile = "<script type=\"text/javascript\" src=\"../sasrfex/javascript/sasrfmsg_%1$s.js\"></script>\r\n";
        strSRFLanguageFile = String.valueOf(strSRFLanguageFile) + "<LINK href=\"../sasrfex/css/default/common_%1$s.css\" type=\"text/css\" rel=\"stylesheet\">";
        return strSRFLanguageFile;
    }

    protected CodeListMgr CreateCodeListMgr() {
        return this.daCodeListMgr;
    }

    protected final void SetDADEDataCtrlHelper(IDEDataCtrlHelper iDEDataCtrlHelper) {
        if (iDEDataCtrlHelper != null) {
            iDEDataCtrlHelper.Init(this.contextHelperEx, null);
            this.filterConfig.getServletContext().setAttribute(TAG_SRFDADEDATACTRLHELPER, (Object)iDEDataCtrlHelper);
        }
    }

    protected void OutputLibsVersionInfo() {
        super.OutputLibsVersionInfo();
        log.info((Object)String.format("SASRFDA VERSION[%1$s]", Version.toVersionString()));
    }

    protected void OutputDynamicLibVersionInfo() {
        super.OutputDynamicLibVersionInfo();
        log.info((Object)String.format("SASRFDA MODEL VERSION[%1$s]", this.contextHelperEx.getDAModelVersion()));
    }

    protected void OnDestroy() {
        if (this.serviceMgr != null) {
            this.serviceMgr.Stop();
        }
        this.serviceMgr = null;
        super.OnDestroy();
    }

    protected ISRFExPOLogger CreatePOLogger() {
        boolean bPOLogger = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "STARTPOLOGGER", false);
        if (!bPOLogger) {
            return null;
        }
        SRFDAPOLogger poLogger = new SRFDAPOLogger();
        poLogger.setGlobalHelper(this.contextHelperEx);
        return poLogger;
    }

    protected IDataNotifyHelper CreateDataNotifyHelper() {
        IDataNotifyHelper defaultDataNotifyHelper = (IDataNotifyHelper)ObjectHelper.Create((String)"SA.SRFDA.Ctrl.DataNotify.DefaultDataNotifyHelper");
        CallResult callResult = defaultDataNotifyHelper.Init(this.contextHelperEx);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u6570\u636e\u901a\u77e5\u8f85\u52a9\u5bf9\u8c61\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return null;
        }
        return defaultDataNotifyHelper;
    }

    protected ISRFExLocalizationHelper CreateLocalizationHelper() {
        SRFDALocalizationHelper localizationHelper = new SRFDALocalizationHelper();
        String strLanguage = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "LANGUAGE", "");
        localizationHelper.Init(this.contextHelperEx, strLanguage);
        return localizationHelper;
    }

    private final void OnPrepareAppUITheme() {
        Vector<AppUITheme> appUIThemes = new Vector<AppUITheme>();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetAppUIThemes(appUIThemes);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u754c\u9762\u4e3b\u9898\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        for (AppUITheme appUITheme : appUIThemes) {
            if (StringHelper.IsNullOrEmpty((String)appUITheme.getSTYLE())) continue;
            SRFExPage.RegisterAppUITheme((String)appUITheme.getAPPUITHEMEID(), (String)appUITheme.getSTYLE());
        }
    }

    private final void OnPrepareSubSystem() {
        Iterator<IDASubSystemHelper> subSystemHelpers = this.contextHelperEx.getDAModelStorage().getSubSystems();
        while (subSystemHelpers.hasNext()) {
            IDASubSystemHelper iDASubSystemHelper = subSystemHelpers.next();
            try {
                iDASubSystemHelper.InitGlobalSession();
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u5b50\u7cfb\u7edf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)iDASubSystemHelper.getName(), (Object)ex.getMessage()), (Throwable)ex);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean InternalUpdateSession(ISRFExWebContext iWebContext, ServletRequest request, ServletResponse reponse) {
        if (this.bGA2) {
            HttpServletRequest httpRequest = (HttpServletRequest)request;
            if (!accKeyMap.containsKey(request.getAttribute(this.strRandomKey))) {
                httpRequest.getSession().invalidate();
                return false;
            }
            boolean bContain = false;
            Hashtable<String, HttpSession> hashtable = userSessionMap;
            synchronized (hashtable) {
                bContain = userSessionMap.containsKey(httpRequest.getSession().getId());
            }
            if (!bContain) {
                httpRequest.getSession().invalidate();
                return false;
            }
        }
        return true;
    }

    public final boolean UpdateSession(ISRFExWebContext iWebContext, ServletRequest request, ServletResponse reponse) {
        return this.InternalUpdateSession(iWebContext, request, reponse);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void RemoveSession(HttpSession session) {
        if (session == null) {
            return;
        }
        String strSessionId = session.getId();
        if (this.bGA3) {
            Hashtable<String, HttpSession> hashtable = userSessionMap;
            synchronized (hashtable) {
                userSessionMap.remove(strSessionId);
            }
        }
        if (this.contextHelperEx.getDAModelVersion() >= 10113000) {
            if (loginLogDataCtrl != null) {
                LoginLog loginLog = new LoginLog();
                BaseDEDataCtrl.SetCallParamCheckKey(loginLog, false);
                BaseDEDataCtrl.SetCallParamRetData(loginLog, false);
                loginLog.setLOGINLOGID(strSessionId);
                loginLog.SetParamValue("LOGOUTTIME", DateParser.GetCurTime());
                loginLogDataCtrl.Save(false, loginLog);
            }
            if (onlineUserDataCtrl != null) {
                OnlineUser onlineUser = new OnlineUser();
                BaseDEDataCtrl.SetCallParamCheckKey(onlineUser, false);
                onlineUser.setONLINEUSERID(strSessionId);
                onlineUserDataCtrl.Remove(onlineUser);
            }
        }
    }

    protected String GetProductId() {
        return "";
    }

    private static byte[] SymmetricDecrypto(byte[] byteSource, byte[] keyData) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            int mode = 2;
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            DESKeySpec keySpec = new DESKeySpec(keyData);
            SecretKey key = keyFactory.generateSecret(keySpec);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(mode, key);
            int blockSize = cipher.getBlockSize();
            int position = 0;
            int length = byteSource.length;
            boolean more = true;
            while (more) {
                if (position + blockSize <= length) {
                    baos.write(cipher.update(byteSource, position, blockSize));
                    position += blockSize;
                    continue;
                }
                more = false;
            }
            if (position < length) {
                baos.write(cipher.doFinal(byteSource, position, length - position));
            } else {
                baos.write(cipher.doFinal());
            }
            byte[] byArray = baos.toByteArray();
            return byArray;
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            baos.close();
        }
    }

    protected void OutputConfigInfo() {
        super.OutputConfigInfo();
        boolean bEnableTransaction = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "TRANSACTION", false);
        log.info((Object)String.format("\u7cfb\u7edf\u5904\u7406\u4e8b\u52a1\u8bbe\u7f6e[%1$s]", bEnableTransaction ? "\u542f\u7528" : "\u4e0d\u542f\u7528"));
    }

    protected final void CustomCall(String strCallId, Object[] args) {
        if (StringHelper.Compare((String)strCallId, (String)CUSTOMCALL_1, (boolean)true) == 0) {
            this.bNoUserMode = true;
            return;
        }
    }

    private class LicenseUpdater
    extends TimerTask {
        private GlobalHelperEx globalHelperEx = null;
        private String strSessionId = "";
        private String strGAApplication = null;
        private String strGALicServer = null;
        private int nErrorCount = 0;

        public LicenseUpdater(GlobalHelperEx globalHelperEx, String strSessionId) {
            this.globalHelperEx = globalHelperEx;
            this.strSessionId = strSessionId;
            this.strGAApplication = globalHelperEx.getWebConfig().GetExtValue("GAAPPLICATION", "");
            this.strGALicServer = globalHelperEx.getWebConfig().GetExtValue("GALICSERVER", "");
        }

        @Override
        public void run() {
            block8: {
                String strUrl = StringHelper.Format((String)"%1$s/licaction?GAACTION=UPDATEAPP&GAAPPPID=%2$s&SESSIONID=%3$s", (Object)this.strGALicServer, (Object)this.strGAApplication, (Object)this.strSessionId);
                HttpClient httpClient = new HttpClient();
                GetMethod postMethod = new GetMethod(strUrl);
                try {
                    int statusCode = httpClient.executeMethod((HttpMethod)postMethod);
                    if (statusCode == 200) {
                        byte[] body = postMethod.getResponseBody();
                        String strResult = new String(body);
                        Calendar calendar = Calendar.getInstance();
                        int nYear = calendar.get(1);
                        int nMonth = calendar.get(2);
                        int nDay = calendar.get(5);
                        byte[] keyData = new byte[]{(byte)(nYear / 1000), (byte)(nYear % 1000 / 100), (byte)(nYear % 100 / 10), (byte)(nYear % 10), (byte)(nMonth / 10), (byte)(nMonth % 10), (byte)(nDay / 10), (byte)(nDay % 10)};
                        byte[] buff = Base64.decode((String)strResult);
                        byte[] buff2 = SRFDAHttpModule.SymmetricDecrypto(buff, keyData);
                        strResult = new String(buff2);
                        XMLConfig xmlConfig = new XMLConfig();
                        XMLConfig.LoadFromXML((String)strResult, (XMLConfig)xmlConfig);
                        if (xmlConfig.GetExtValue("RETCODE", 1) == 0) {
                            this.nErrorCount = 0;
                            SRFDAHttpModule.this.bDevelopMode = false;
                            this.globalHelperEx.SetGlobalValue(SRFDAHttpModule.TAG_LASTLICENSETIME, calendar.getTime().getTime() / 77L);
                        } else {
                            if (this.nErrorCount <= 3) {
                                ++this.nErrorCount;
                            }
                            if (this.nErrorCount > 3) {
                                log.info((Object)StringHelper.Format((String)"\u6388\u6743\u66f4\u65b0\u5931\u8d25\uff0c\u6062\u590d\u4e3a\u5f00\u53d1\u6a21\u5f0f"));
                                this.globalHelperEx.SetGlobalValue(SRFDAHttpModule.TAG_LICSTATUS, "");
                                SRFDAHttpModule.this.bDevelopMode = true;
                            }
                        }
                    }
                }
                catch (Exception e) {
                    if (this.nErrorCount <= 3) {
                        ++this.nErrorCount;
                    }
                    if (this.nErrorCount <= 3) break block8;
                    log.info((Object)StringHelper.Format((String)"\u6388\u6743\u66f4\u65b0\u5931\u8d25\uff0c\u6062\u590d\u4e3a\u5f00\u53d1\u6a21\u5f0f"));
                    SRFDAHttpModule.this.bDevelopMode = true;
                    this.globalHelperEx.SetGlobalValue(SRFDAHttpModule.TAG_LICSTATUS, "");
                }
            }
        }
    }
}

