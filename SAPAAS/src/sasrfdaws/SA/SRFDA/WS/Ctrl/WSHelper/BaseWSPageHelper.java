/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  freemarker.cache.StringTemplateLoader
 *  freemarker.cache.TemplateLoader
 *  freemarker.template.Configuration
 *  freemarker.template.Template
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WS.Ctrl.WSHelper;

import SA.SRFDA.WS.Ctrl.BaseWSObject;
import SA.SRFDA.WS.Ctrl.Data.WSPage;
import SA.SRFDA.WS.Ctrl.Data.WSPageWB;
import SA.SRFDA.WS.Ctrl.Data.WSWebPart;
import SA.SRFDA.WS.Ctrl.DefaultWSWebPartPublishContext;
import SA.SRFDA.WS.Ctrl.IWSPageHelper;
import SA.SRFDA.WS.Ctrl.IWSPagePublishContext;
import SA.SRFDA.WS.Ctrl.IWSPageTemplHelper;
import SA.SRFDA.WS.Ctrl.IWSWebPartHelper;
import SA.SRFDA.WS.Ctrl.IWSWebSiteHelper;
import SA.SRFDA.WS.Web.BaseWSMainPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import freemarker.cache.StringTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseWSPageHelper
extends BaseWSObject
implements IWSPageHelper {
    Log log = LogFactory.getLog(BaseWSPageHelper.class);
    protected IWSWebSiteHelper iWSWebSiteHelper = null;
    protected IWSPageTemplHelper iWSPageTemplHelper = null;
    protected WSPage wsPage = null;
    protected IWSPagePublishContext publishContext = null;
    Vector<WSPageWB> pageWBs = new Vector();
    StringBuilderEx sbEx = new StringBuilderEx();

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IWSWebSiteHelper iWSWebSiteHelper, IWSPageTemplHelper iWSPageTemplHelper, WSPage wsPage) throws Exception {
        this.iWSWebSiteHelper = iWSWebSiteHelper;
        this.iWSPageTemplHelper = iWSPageTemplHelper;
        this.wsPage = wsPage;
        this.OnPrepareWSPageWBs();
        this.OnInit();
    }

    protected void OnPrepareWSPageWBs() throws Exception {
        CallResult callResult = this.getWSModelHelper().GetWSPageWBs(this.getId(), this.pageWBs);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7f51\u7ad9\u9891\u9053\u5185\u5bb9\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public void Publish(IWSPagePublishContext iWSPagePublishContext) throws Exception {
        this.publishContext = iWSPagePublishContext;
        this.Debug("\u5f00\u59cb\u53d1\u5e03\u7f51\u9875[%2$s:%1$s]", this.getId(), this.getName());
        this.sbEx.Reset();
        this.PrepareContent();
        this.OnPublish();
    }

    protected void PrepareContent() throws Exception {
        this.OnAppendHeader();
        String strPageTemplModel = this.iWSPageTemplHelper.getWsPageTempl().getPAGEMODEL();
        TreeMap<String, Object> pageModellMap = new TreeMap<String, Object>();
        pageModellMap.put("websitename", this.getWebSiteName());
        pageModellMap.put("pagename", this.getName());
        this.FillPageModelContext(pageModellMap);
        this.FillWebPartsContext(pageModellMap);
        pageModellMap.put("URI", StringHelper.Format((String)"../%1$s", (Object)this.getPublishedPageUrl()));
        StringTemplateLoader templLoader = new StringTemplateLoader();
        templLoader.putTemplate("HTML", strPageTemplModel);
        Configuration config = new Configuration();
        config.setTemplateLoader((TemplateLoader)templLoader);
        StringWriter sw = new StringWriter();
        Template templ = config.getTemplate("HTML");
        templ.process(pageModellMap, (Writer)sw);
        this.sbEx.Append("%1$s", (Object)sw.toString());
    }

    protected void FillPageModelContext(Map<String, Object> pageModellMap) throws Exception {
    }

    @Override
    public WSPageWB FindWSPageWB(String strWSPageWBId) {
        for (WSPageWB wsPageWB : this.pageWBs) {
            if (StringHelper.Compare((String)wsPageWB.getWSPAGEWBID(), (String)strWSPageWBId, (boolean)true) != 0) continue;
            return wsPageWB;
        }
        return null;
    }

    protected void FillWebPartsContext(Map<String, Object> pageModellMap) throws Exception {
        for (WSPageWB wsPageWB : this.pageWBs) {
            String strWSWebPartId = wsPageWB.getWSWEBPARTID();
            IWSWebPartHelper wsWebPartHelper = this.getWSModelStorage().FindWSWebPartHelper(strWSWebPartId);
            WSWebPart wsWebPart = wsWebPartHelper.getWSWebPart();
            DefaultWSWebPartPublishContext context = new DefaultWSWebPartPublishContext(this, wsWebPart, wsPageWB);
            wsWebPartHelper.Publish(context);
            pageModellMap.put(wsPageWB.getWSPAGEWBNAME(), context.getWebPartPublishedModel());
        }
    }

    protected void OnAppendHeader() throws Exception {
        this.sbEx.Append("<%@page contentType=\"text/html; charset=GBK\"%>");
        String strPageId = this.getPageId();
        this.sbEx.Append("<jsp:useBean id=\"%1$s\" scope=\"page\" class=\"%2$s\" />", (Object)strPageId, (Object)this.OnGetPageObject());
        this.sbEx.Append("<%%%1$s.Init(pageContext);\t%1$s.Load(); if(%1$s.IsStop()) return;%%>\r\n", (Object)strPageId);
    }

    protected String OnGetPageObject() throws Exception {
        String strPageObject = this.iWSPageTemplHelper.getWSPageTypeHelper().getPageObject();
        if (StringHelper.IsNullOrEmpty((String)strPageObject)) {
            return BaseWSMainPage.class.getName();
        }
        Object obj = ObjectHelper.Create((String)strPageObject);
        if (!(obj instanceof BaseWSMainPage)) {
            throw new Exception(StringHelper.Format((String)"\u9875\u9762\u5bf9\u8c61[%1$s]\u4e0d\u7b26\u5408[%1$s]\u7c7b\u578b\u8981\u6c42", (Object)strPageObject, (Object)BaseWSMainPage.class.getName()));
        }
        return strPageObject;
    }

    protected void OnPublish() throws Exception {
        String strPath = this.publishContext.getRootPath();
        strPath = String.valueOf(strPath) + "/";
        strPath = String.valueOf(strPath) + this.OnGetRelativePath();
        String strFileName = this.GetFileName();
        File file = new File(strFileName = StringHelper.Format((String)"%1$s/%2$s", (Object)strPath, (Object)strFileName));
        if (file.exists()) {
            if (!file.canWrite()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6587\u4ef6[%1$s]\u5199\u64cd\u4f5c\u6743\u9650\u5931\u8d25", (Object)strFileName));
            }
        } else {
            File folder = new File(file.getParent());
            folder.mkdirs();
        }
        file.exists();
        this.publishContext.setRelativePath(strFileName);
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(strFileName));
        writer.write(this.sbEx.toString());
        writer.flush();
        writer.close();
    }

    @Override
    public String getPublishedPageUrl() {
        return StringHelper.Format((String)"%1$s/%2$s", (Object)this.OnGetRelativePath(), (Object)this.GetFileName());
    }

    protected String GetFileName() {
        return StringHelper.Format((String)"%1$s.jsp", (Object)this.getId().toLowerCase());
    }

    private String getWebSiteName() {
        return this.getWSWebSiteHelper().getName();
    }

    @Override
    public String getPageId() {
        return "page1";
    }

    protected String OnGetRelativePath() {
        return this.getId().toLowerCase();
    }

    @Override
    public WSPage getWSPage() {
        return this.wsPage;
    }

    @Override
    public IWSPageTemplHelper getWSPageTemplHelper() {
        return this.iWSPageTemplHelper;
    }

    @Override
    public IWSWebSiteHelper getWSWebSiteHelper() {
        return this.iWSWebSiteHelper;
    }

    @Override
    public String getId() {
        return this.wsPage.getWSPAGEID();
    }

    @Override
    public String getName() {
        return this.wsPage.getWSPAGENAME();
    }

    protected void Debug(String strFormat, Object ... args) {
        this.log.debug((Object)String.format(strFormat, args));
    }
}

