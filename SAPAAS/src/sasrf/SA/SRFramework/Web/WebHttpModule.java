/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.Filter
 *  javax.servlet.FilterChain
 *  javax.servlet.FilterConfig
 *  javax.servlet.ServletException
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.Web;

import SA.SRFramework.Common.Version;
import SA.SRFramework.Data.DBCallConfigMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Data.WebDBCallerHelper;
import SA.SRFramework.Web.UI.DynamicFormMgr;
import SA.SRFramework.Web.UI.IconViewMgr;
import SA.SRFramework.Web.UI.MainListMgr;
import SA.SRFramework.Web.UI.MenuConfigMgr;
import SA.SRFramework.Web.UI.PageConfigMgr;
import SA.SRFramework.Web.UI.SearchFormMgr;
import SA.SRFramework.Web.UI.SubListMgr;
import SA.SRFramework.Web.UI.SubViewMgr;
import SA.SRFramework.Web.UI.TipsMgr;
import SA.SRFramework.Web.UI.UserCtrlMgr;
import SA.SRFramework.Web.UI.WebThemeMgr;
import SA.SRFramework.Web.WebConfig;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WebHttpModule
implements Filter {
    protected FilterConfig filterConfig;
    protected boolean bEncrypt = true;
    protected WebConfig webConfig = null;
    protected String strRootPath = "";
    protected DynamicFormMgr dynamicFormMgr = new DynamicFormMgr();
    protected SearchFormMgr searchFormMgr = new SearchFormMgr();
    protected WebThemeMgr webThemeMgr = new WebThemeMgr();
    protected MainListMgr mainListMgr = new MainListMgr();
    protected DBCallConfigMgr dbCallConfigMgr = new DBCallConfigMgr();
    protected WebDBCallerHelper dbCallerHelper = null;
    protected SubViewMgr subViewMgr = new SubViewMgr();
    protected PageConfigMgr pageConfigMgr = new PageConfigMgr();
    protected MenuConfigMgr menuConfigMgr = new MenuConfigMgr();
    protected SubListMgr subListMgr = new SubListMgr();
    protected UserCtrlMgr userCtrlMgr = new UserCtrlMgr();
    protected TipsMgr tipsMgr = new TipsMgr();
    protected IconViewMgr iconviewMgr = new IconViewMgr();
    protected Hashtable systemCallList = new Hashtable();
    protected String strFolderSeperator = File.separator;
    public static final String DBPROCNAME = "DBPROCNAME";
    public static final String RESPONSE_REDIRECT = "SRF_RESPONSE_REDIRECT";
    private static Log log = LogFactory.getLog(WebHttpModule.class);

    public void init(FilterConfig config) {
        char ch;
        this.filterConfig = config;
        this.webConfig = new WebConfig(config);
        this.filterConfig.getServletContext().setAttribute("SRFWEBCONFIG", (Object)this.webConfig);
        String strEncryptFlag = config.getInitParameter("ENCRYPT");
        if (StringHelper.Length(strEncryptFlag) != 0 && StringHelper.Compare(strEncryptFlag, "false", true) == 0) {
            this.bEncrypt = false;
        }
        this.strRootPath = this.webConfig.GetExtValue("APPPATH", "");
        if (StringHelper.IsNullOrEmpty(this.strRootPath)) {
            this.strRootPath = this.filterConfig.getServletContext().getRealPath("/");
        }
        if (!StringHelper.IsNullOrEmpty(this.strRootPath) && (ch = this.strRootPath.charAt(this.strRootPath.length() - 1)) != File.separatorChar) {
            this.strRootPath = String.valueOf(this.strRootPath) + File.separator;
        }
        this.strFolderSeperator = File.separator;
        String strDefaultConfigFolderPath = "config" + this.strFolderSeperator;
        strDefaultConfigFolderPath = this.webConfig.GetExtValue("CONFIGPATH", strDefaultConfigFolderPath);
        String strConfigPath = String.valueOf(this.strRootPath) + strDefaultConfigFolderPath;
        this.dynamicFormMgr.setFolderSeperator(this.strFolderSeperator);
        this.webThemeMgr.setFolderSeperator(this.strFolderSeperator);
        this.searchFormMgr.setFolderSeperator(this.strFolderSeperator);
        this.dbCallConfigMgr.setFolderSeperator(this.strFolderSeperator);
        int nDBProcName = this.webConfig.GetExtValue(DBPROCNAME, 0);
        switch (nDBProcName) {
            case 2: {
                this.dbCallConfigMgr.setUseProcName2(true);
                break;
            }
            case 3: {
                this.dbCallConfigMgr.setUseProcName3(true);
                break;
            }
            case 4: {
                this.dbCallConfigMgr.setUseProcName4(true);
            }
        }
        this.mainListMgr.setFolderSeperator(this.strFolderSeperator);
        this.subViewMgr.setFolderSeperator(this.strFolderSeperator);
        this.pageConfigMgr.setFolderSeperator(this.strFolderSeperator);
        this.menuConfigMgr.setFolderSeperator(this.strFolderSeperator);
        this.subListMgr.setFolderSeperator(this.strFolderSeperator);
        this.tipsMgr.setFolderSeperator(this.strFolderSeperator);
        this.iconviewMgr.setFolderSeperator(this.strFolderSeperator);
        this.dynamicFormMgr.setConfigPath(strConfigPath);
        this.webThemeMgr.setConfigPath(strConfigPath);
        this.searchFormMgr.setConfigPath(strConfigPath);
        this.dbCallConfigMgr.setConfigPath(strConfigPath);
        this.mainListMgr.setConfigPath(strConfigPath);
        this.subViewMgr.setConfigPath(strConfigPath);
        this.pageConfigMgr.setConfigPath(strConfigPath);
        this.menuConfigMgr.setConfigPath(strConfigPath);
        this.subListMgr.setConfigPath(strConfigPath);
        this.tipsMgr.setConfigPath(strConfigPath);
        this.iconviewMgr.setConfigPath(strConfigPath);
        this.dynamicFormMgr.setEncrypt(this.bEncrypt);
        this.webThemeMgr.setEncrypt(this.bEncrypt);
        this.searchFormMgr.setEncrypt(this.bEncrypt);
        this.dbCallConfigMgr.setEncrypt(this.bEncrypt);
        this.mainListMgr.setEncrypt(this.bEncrypt);
        this.subViewMgr.setEncrypt(this.bEncrypt);
        this.pageConfigMgr.setEncrypt(this.bEncrypt);
        this.menuConfigMgr.setEncrypt(this.bEncrypt);
        this.subListMgr.setEncrypt(this.bEncrypt);
        this.tipsMgr.setEncrypt(this.bEncrypt);
        this.iconviewMgr.setEncrypt(this.bEncrypt);
        this.dbCallerHelper = this.CreateBCallerHelper();
        if (this.dbCallerHelper != null) {
            this.dbCallerHelper.setConfigMgr(this.dbCallConfigMgr);
            this.dbCallerHelper.setWebConfig(this.webConfig);
            this.dbCallerHelper.Init();
            this.filterConfig.getServletContext().setAttribute("SRFDBCALLERHELPER", (Object)this.dbCallerHelper);
        }
        this.filterConfig.getServletContext().setAttribute("SRFDYNAMICFORMMGR", (Object)this.dynamicFormMgr);
        this.filterConfig.getServletContext().setAttribute("SRFTHEMEMGR", (Object)this.webThemeMgr);
        this.filterConfig.getServletContext().setAttribute("SRFSEARCHFORMMGR", (Object)this.searchFormMgr);
        this.filterConfig.getServletContext().setAttribute("SRFSEARCHFORMMGR", (Object)this.searchFormMgr);
        this.filterConfig.getServletContext().setAttribute("SRFSYSTEMCALLLIST", (Object)this.systemCallList);
        this.filterConfig.getServletContext().setAttribute("SRFDBCALLERMGR", (Object)this.dbCallConfigMgr);
        this.filterConfig.getServletContext().setAttribute("SRFMAINLISTMGR", (Object)this.mainListMgr);
        this.filterConfig.getServletContext().setAttribute("SRFSUBVIEWMGR", (Object)this.subViewMgr);
        this.filterConfig.getServletContext().setAttribute("SRFPAGEMGR", (Object)this.pageConfigMgr);
        this.filterConfig.getServletContext().setAttribute("SRFMENUMGR", (Object)this.menuConfigMgr);
        this.filterConfig.getServletContext().setAttribute("SRFSUBLISTMGR", (Object)this.subListMgr);
        this.filterConfig.getServletContext().setAttribute("SRFUSERCTRLMGR", (Object)this.userCtrlMgr);
        this.filterConfig.getServletContext().setAttribute("SRFTIPSMGR", (Object)this.tipsMgr);
        this.filterConfig.getServletContext().setAttribute("SRFICONVIEWMGR", (Object)this.iconviewMgr);
        this.filterConfig.getServletContext().setAttribute("APPROOTPATH", (Object)this.strRootPath);
        this.OutputLibsVersionInfo();
        this.OnInit();
        this.OnAfterInit();
        this.PrepareSystemCallList();
        this.OutputDynamicLibVersionInfo();
        log.info((Object)String.format("\u7cfb\u7edf\u914d\u7f6e\u4fe1\u606f", new Object[0]));
        this.OutputConfigInfo();
    }

    protected void OutputLibsVersionInfo() {
        log.info((Object)String.format("SASRF VERSION[%1$s]", Version.toVersionString()));
    }

    protected void OutputDynamicLibVersionInfo() {
    }

    protected void OutputConfigInfo() {
    }

    protected void OnInit() {
    }

    protected void OnAfterInit() {
    }

    public void destroy() {
        this.OnDestroy();
        if (this.dbCallerHelper != null) {
            this.dbCallerHelper.Clear();
        }
        this.filterConfig = null;
    }

    protected void OnDestroy() {
    }

    @Deprecated
    protected WebDBCallerHelper CreateBCallerHelper() {
        return this.CreateDBCallerHelper();
    }

    protected WebDBCallerHelper CreateDBCallerHelper() {
        return null;
    }

    private void PrepareSystemCallList() {
        this.systemCallList.put("RU", "");
        this.systemCallList.put("SEARCHMODE", "");
        this.systemCallList.put("IF_NAME", "");
        this.systemCallList.put("MENUMODE", "");
        this.systemCallList.put("ORDERFIELDID", "");
        this.systemCallList.put("ORDERDIRECT", "");
        this.systemCallList.put("SHOWTABVIEW", "");
        this.systemCallList.put("SHOWCONDITION", "");
        this.systemCallList.put("SEARCHCOND", "");
        this.systemCallList.put("LOADSC", "");
        this.systemCallList.put("PICKMODE", "");
        this.OnPrepareSystemCallList(this.systemCallList);
    }

    protected void OnPrepareSystemCallList(Hashtable sysCallList) {
    }

    public final void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding("GBK");
        HttpServletRequest curRequest = (HttpServletRequest)request;
        HttpServletResponse curResponse = (HttpServletResponse)response;
        String strRequestURL = curRequest.getRequestURL().toString();
        int nPos = strRequestURL.lastIndexOf(".jsp");
        if (nPos != -1) {
            if (nPos == strRequestURL.length() - 4) {
                this.DoWithPage(curRequest, curResponse);
                Object objValue = curRequest.getAttribute(RESPONSE_REDIRECT);
                if (objValue != null && StringHelper.Compare(objValue.toString(), "1", true) == 0) {
                    return;
                }
            }
        } else {
            this.DoWithOther(curRequest, curResponse);
        }
        filterChain.doFilter(request, response);
    }

    protected void DoWithPage(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void DoWithOther(HttpServletRequest request, HttpServletResponse response) {
    }
}

