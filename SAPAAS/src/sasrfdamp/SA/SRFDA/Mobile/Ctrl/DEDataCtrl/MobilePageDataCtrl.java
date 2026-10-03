/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.MobilePage
 *  SA.SRFDA.Ctrl.Data.MobilePageConfig
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IPageHelper
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFDA.Web.SRFDAPageProxy
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFDA.Web.ViewModel.ControlModel
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Utility.ContextHelper
 *  SA.SRFramework.WebEx.Utility.Jsp.SimplePageContext
 *  SA.SRFramework.WebEx.Utility.Jsp.SimpleServletRequest
 *  SA.SRFramework.WebEx.Utility.Jsp.SimpleServletResponse
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.jsp.PageContext
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Mobile.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.MobilePage;
import SA.SRFDA.Ctrl.Data.MobilePageConfig;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IPageHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.SRFDAPageProxy;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.ViewModel.ControlModel;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Utility.ContextHelper;
import SA.SRFramework.WebEx.Utility.Jsp.SimplePageContext;
import SA.SRFramework.WebEx.Utility.Jsp.SimpleServletRequest;
import SA.SRFramework.WebEx.Utility.Jsp.SimpleServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.jsp.PageContext;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MobilePageDataCtrl
extends BaseDEDataCtrl {
    private static HashMap<String, String> pageObjectMap = new HashMap();
    private static final Log log;
    public static final String CUSTOMCALL_REFRESHMODEL = "REFRESHMODEL";

    static {
        pageObjectMap.put("../srfpage/editview.jsp", "SA.SRFDA.Web.Default.EditViewPage");
        pageObjectMap.put("../srfpage/editview2.jsp", "SA.SRFDA.Web.Default.EditViewPage2");
        pageObjectMap.put("../srfpage/simpleeditview.jsp", "SA.SRFDA.Web.Default.EditViewPage2");
        pageObjectMap.put("../srfpage/gridview.jsp", "SA.SRFDA.Web.Default.GridViewPage");
        pageObjectMap.put("../srfpage/embedgridview.jsp", "SA.SRFDA.Web.Default.EmbedGridViewPage");
        pageObjectMap.put("../srfwf/wftreegridview.jsp", "SA.SRFDA.WF.Web.WFTreeGridViewPage");
        pageObjectMap.put("../srfwf/wfinfoview2.jsp", "SA.SRFDA.WF.Web.WFInfoViewPage2");
        pageObjectMap.put("../srfpage/indexview.jsp", "SA.SRFDA.Web.Default.IndexPage");
        log = LogFactory.getLog(MobilePageDataCtrl.class);
    }

    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_REFRESHMODEL, (boolean)true) == 0) {
            MobilePage mobilePage = new MobilePage();
            mobilePage.Proxy(dataEntity);
            return this.RefreshModel(mobilePage);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    protected CallResult RefreshModel(MobilePage mobilePage) {
        CallResult callResult = new CallResult();
        try {
            HashMap<String, String> refreshPageMap = new HashMap<String, String>();
            HashMap<String, MobilePage> mobilePageMap = new HashMap<String, MobilePage>();
            callResult = this.Get((BaseDataEntity)mobilePage);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u79bb\u7ebf\u754c\u9762\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            mobilePageMap.put(mobilePage.getMOBILEPAGEID(), mobilePage);
            boolean bProcessFinish = false;
            block2: while (!bProcessFinish) {
                bProcessFinish = true;
                for (String strKey : mobilePageMap.keySet()) {
                    if (refreshPageMap.containsKey(strKey)) continue;
                    bProcessFinish = false;
                    refreshPageMap.put(strKey, "");
                    this.InternalRefreshModel((MobilePage)mobilePageMap.get(strKey), mobilePageMap);
                    continue block2;
                }
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            log.error((Object)ex.getMessage(), (Throwable)ex);
            return callResult;
        }
    }

    protected void InternalRefreshModel(MobilePage mobilePage, HashMap<String, MobilePage> mobilePageMap) throws Exception {
        Enumeration ctrls;
        String strPageId = mobilePage.getPAGEID();
        IPageHelper iPageHelper = this.getGlobalHelper().getDAModelStorage().FindPage2(strPageId);
        String strPagePath = iPageHelper.getPagePath();
        String strDefaultPageObject = iPageHelper.getPageObject();
        if (StringHelper.IsNullOrEmpty((String)strDefaultPageObject)) {
            strDefaultPageObject = pageObjectMap.get(strPagePath);
        }
        if (StringHelper.IsNullOrEmpty((String)strDefaultPageObject)) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]\u9ed8\u8ba4\u9875\u9762\u5bf9\u8c61", (Object)strPagePath));
        }
        mobilePage.setPAGEPATH(strPagePath);
        mobilePage.setPAGEID(iPageHelper.getId());
        mobilePage.setPAGEDEID(iPageHelper.getDEId());
        SimplePageContext simplePageContext = new SimplePageContext();
        SimpleServletRequest simpleServletRequest = new SimpleServletRequest();
        simpleServletRequest.getParameterMap().put("SRFPAGEID", strPageId);
        SimpleServletResponse simpleServletResponse = new SimpleServletResponse();
        SRFDAWebContext webContext = (SRFDAWebContext)this.getWebContext();
        String strContextPath = webContext.getPage().getRequest().getContextPath();
        String strRequestURI = webContext.getPage().getRequest().getRequestURI();
        simpleServletRequest.setContextPath(strContextPath);
        strPagePath = strPagePath.replace(".jsp", "model.jsp");
        simpleServletRequest.setRequestURI(strPagePath.replace("..", strContextPath));
        String strQueryString = StringHelper.Format((String)"SRFDEID=%1$s&SRFPAGEID=%2$s&SRFPAGEMODEL=SL", (Object)iPageHelper.getDEId(), (Object)strPageId);
        simpleServletRequest.setQueryString(strQueryString);
        ContextHelper contextHelper = (ContextHelper)this.getGlobalHelper();
        simplePageContext.initialize(contextHelper.getServletContext(), (ServletRequest)simpleServletRequest, (ServletResponse)simpleServletResponse);
        SRFDAPageEx page1 = null;
        try {
            page1 = SRFDAPageProxy.GetPage((PageContext)simplePageContext, (String)strDefaultPageObject);
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            page1 = (SRFDAPageEx)ObjectHelper.Create((String)strDefaultPageObject);
        }
        page1.InitImitatedMode(simplePageContext);
        page1.Load();
        JSONObject jo = new JSONObject();
        PageModel pageModel = page1.GetOfflinePageModel(jo);
        mobilePage.setPAGEMODEL(jo.toString());
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("MOBILEPAGEID", (Object)mobilePage.getMOBILEPAGEID());
        IDEDataCtrl mobilePageConfigDataCtrl = this.GetRelatedDataCtrl("DE0383");
        CallResult callResult = mobilePageConfigDataCtrl.RemoveMulti(cond);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u5220\u9664\u79bb\u7ebf\u754c\u9762\u90e8\u4ef6\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (pageModel != null && (ctrls = pageModel.GetCtrlModelNames()) != null) {
            while (ctrls.hasMoreElements()) {
                String strKey = (String)ctrls.nextElement();
                ControlModel controlModel = pageModel.GetCtrlModel(strKey);
                MobilePageConfig mobilePageConfig = new MobilePageConfig();
                mobilePageConfig.setMOBILEPAGEID(mobilePage.getMOBILEPAGEID());
                mobilePageConfig.setCONFIGID(controlModel.getConfigId());
                mobilePageConfig.setMOBPAGECFGNAME(strKey);
                if (StringHelper.IsNullOrEmpty((String)controlModel.getConfigId())) continue;
                String strConfigPath = "";
                if (StringHelper.Compare((String)strKey, (String)"toolbar", (boolean)true) == 0) {
                    mobilePageConfig.setCONFIGTYPE("TOOLBAR");
                    strConfigPath = webContext.getToolbarMgr().GetRealConfigFilePath(controlModel.getConfigId());
                } else if (StringHelper.Compare((String)strKey, (String)"datagrid", (boolean)true) == 0) {
                    mobilePageConfig.setCONFIGTYPE("DATAGRID");
                    strConfigPath = webContext.getDataGridMgr().GetRealConfigFilePath(controlModel.getConfigId());
                } else if (StringHelper.Compare((String)strKey, (String)"spex", (boolean)true) == 0) {
                    mobilePageConfig.setCONFIGTYPE("SPEX");
                    strConfigPath = webContext.getSearchPanelMgr().GetRealConfigFilePath(controlModel.getConfigId());
                } else if (StringHelper.Compare((String)strKey, (String)"tabview", (boolean)true) == 0) {
                    mobilePageConfig.setCONFIGTYPE("TABVIEW");
                    strConfigPath = webContext.getTabViewMgr().GetRealConfigFilePath(controlModel.getConfigId());
                } else if (StringHelper.Compare((String)strKey, (String)"dpex", (boolean)true) == 0) {
                    mobilePageConfig.setCONFIGTYPE("DPEX");
                    strConfigPath = webContext.getDynamicPanelMgr().GetRealConfigFilePath(controlModel.getConfigId());
                } else {
                    log.warn((Object)StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u914d\u7f6e\u5bf9\u8c61[%1$s]", (Object)strKey));
                    continue;
                }
                if (!StringHelper.IsNullOrEmpty((String)strConfigPath)) {
                    StringBuilderEx sb = new StringBuilderEx();
                    MobilePageDataCtrl.ReadConfigFile(strConfigPath, sb);
                    mobilePageConfig.setCONFIGMODEL(sb.toString());
                }
                if (!(callResult = mobilePageConfigDataCtrl.Save(true, (BaseDataEntity)mobilePageConfig)).IsError()) continue;
                throw new Exception(StringHelper.Format((String)"\u65b0\u5efa\u79bb\u7ebf\u754c\u9762\u90e8\u4ef6\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
        if ((callResult = this.Save(false, (BaseDataEntity)mobilePage)).IsError()) {
            throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u79bb\u7ebf\u754c\u9762\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (this.getTransactionManager() != null) {
            this.getTransactionManager().CommitAndBegin();
        }
    }

    public static void ReadConfigFile(String strConfigFilePath, StringBuilderEx sb) throws Exception {
        InputStreamReader read;
        boolean bFirst = true;
        String encoding = "UTF8";
        File file = new File(strConfigFilePath);
        if (file.isFile() && file.exists()) {
            read = new InputStreamReader((InputStream)new FileInputStream(file), encoding);
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sb.Append("\r\n");
                }
                sb.Append(lineTxt);
            }
        } else {
            throw new Exception("\u627e\u4e0d\u5230\u6307\u5b9a\u7684\u6587\u4ef6");
        }
        read.close();
    }
}

