/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  freemarker.cache.StringTemplateLoader
 *  freemarker.cache.TemplateLoader
 *  freemarker.template.Configuration
 *  freemarker.template.Template
 *  freemarker.template.TemplateException
 */
package SA.SRFDA.WS.Web;

import SA.SRFDA.WS.Ctrl.IWSModelHelper;
import SA.SRFDA.WS.Ctrl.IWSModelStorage;
import SA.SRFDA.WS.Ctrl.WSModelHelperFactory;
import SA.SRFDA.WS.Ctrl.WSModelStorageFactory;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import freemarker.cache.StringTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.TreeMap;

public class BaseWSMainPage
extends BaseMainPage {
    public String RenderNavBar(String strNavBarId) {
        return "";
    }

    public String RenderAlbumPics(String strWSWebSiteId, String strPageId, String strWBTypeId, String strWebPartId, String strWSPageWBId) {
        return "";
    }

    protected String TemplateProcess(String strWebPartTemplModel) {
        TreeMap<String, Object> pageModellMap = new TreeMap<String, Object>();
        this.OnFillTemplateContext(pageModellMap);
        StringTemplateLoader templLoader = new StringTemplateLoader();
        templLoader.putTemplate("HTML", strWebPartTemplModel);
        Configuration config = new Configuration();
        config.setTemplateLoader((TemplateLoader)templLoader);
        StringWriter sw = new StringWriter();
        try {
            Template templ = config.getTemplate("HTML");
            templ.process(pageModellMap, (Writer)sw);
        }
        catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        catch (TemplateException e) {
            e.printStackTrace();
            return "";
        }
        return sw.toString();
    }

    protected void OnFillTemplateContext(Map<String, Object> pageModellMap) {
    }

    protected IWSModelHelper getWSModelHelper() throws Exception {
        return WSModelHelperFactory.Create((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
    }

    protected IWSModelStorage getWSModelStorage() throws Exception {
        return WSModelStorageFactory.Create((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
    }
}

