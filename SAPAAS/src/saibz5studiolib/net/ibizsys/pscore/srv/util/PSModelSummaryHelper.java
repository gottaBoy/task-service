/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vladsch.flexmark.ast.Node
 *  com.vladsch.flexmark.ext.tables.TablesExtension
 *  com.vladsch.flexmark.html.HtmlRenderer
 *  com.vladsch.flexmark.parser.Parser
 *  com.vladsch.flexmark.parser.ParserEmulationProfile
 *  com.vladsch.flexmark.util.options.DataHolder
 *  com.vladsch.flexmark.util.options.MutableDataSet
 *  com.vladsch.flexmark.util.options.MutableDataSetter
 *  freemarker.cache.TemplateLoader
 *  freemarker.template.Configuration
 *  freemarker.template.Template
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.freemarker.EntityTemplateLoader
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.util;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.options.DataHolder;
import com.vladsch.flexmark.util.options.MutableDataSet;
import com.vladsch.flexmark.util.options.MutableDataSetter;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.freemarker.EntityTemplateLoader;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSModelSummaryTempl;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSModelSummaryTemplService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSModelSummaryHelper {
    private static final Log log = LogFactory.getLog(PSModelSummaryHelper.class);
    private static HashMap<String, PSModelSummaryTempl> psModelSummaryTemplMap = new HashMap();
    private static HashMap<Integer, Template> templateCacheMap = new HashMap();
    private static boolean bFirstTime = true;
    private static boolean bOutputMD = false;

    public static void setOutputMD(boolean bl) {
        bOutputMD = bl;
    }

    public static boolean isOutputMD() {
        return bOutputMD;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void reload() throws Exception {
        Object object = psModelSummaryTemplMap;
        synchronized (object) {
            psModelSummaryTemplMap.clear();
        }
        object = templateCacheMap;
        synchronized (object) {
            templateCacheMap.clear();
        }
        PSModelSummaryTemplService service = (PSModelSummaryTemplService)ServiceGlobal.getService(PSModelSummaryTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.set("VALIDFLAG", (Object)1);
        ArrayList<PSModelSummaryTempl> arrayList = service.select((ISelectCond)selectCond);
        for (PSModelSummaryTempl pSModelSummaryTempl : arrayList) {
            psModelSummaryTemplMap.put(pSModelSummaryTempl.getPSModelSummaryTemplId(), pSModelSummaryTempl);
        }
    }

    public static String getPSModelSummary(IDataEntityModel iDataEntityModel, IEntity iEntity) throws Exception {
        return PSModelSummaryHelper.getPSModelSummary(iDataEntityModel, iEntity, false);
    }

    public static String getPSModelSummary(IDataEntityModel iDataEntityModel, IEntity iEntity, boolean bl) throws Exception {
        Template template;
        PSModelSummaryTempl pSModelSummaryTempl;
        if (bFirstTime) {
            PSModelSummaryHelper.reload();
            bFirstTime = false;
        }
        String string = "";
        try {
            pSModelSummaryTempl = psModelSummaryTemplMap.get(iDataEntityModel.getName());
            if (pSModelSummaryTempl == null) {
                return null;
            }
            template = PSModelSummaryHelper.getTemplate(pSModelSummaryTempl);
            if (template == null) {
                return null;
            }
            HashMap<String, Object> templateData = new HashMap<String, Object>();
            templateData.put("demodel", iDataEntityModel);
            templateData.put("data", iEntity);
            StringWriter stringWriter = new StringWriter();
            template.process(templateData, (Writer)stringWriter);
            string = stringWriter.toString();
            if (PSModelSummaryHelper.isOutputMD()) {
                return string;
            }
        }
        catch (Exception exception) {
            log.error((Object)exception.getMessage(), (Throwable)exception);
            if (bl) {
                throw exception;
            }
            return null;
        }
        try {
            MutableDataSet options = new MutableDataSet();
            options.setFrom((MutableDataSetter)ParserEmulationProfile.MARKDOWN);
            options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));
            Parser parser = Parser.builder((DataHolder)options).build();
            HtmlRenderer htmlRenderer = HtmlRenderer.builder((DataHolder)options).build();
            Node document = parser.parse(string);
            String string2 = htmlRenderer.render(document);
            string2 = "<div class='markdown-body' >" + string2 + "</div>";
            return string2;
        }
        catch (Exception exception) {
            log.error((Object)exception.getMessage(), (Throwable)exception);
            if (bl) {
                throw exception;
            }
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Template getTemplate(PSModelSummaryTempl pSModelSummaryTempl) throws Exception {
        Template template = null;
        String string = DataObject.getStringValue((Object)pSModelSummaryTempl.get("TEMPLCONTENT"), null);
        if (StringHelper.isNullOrEmpty((String)string)) {
            return template;
        }
        Integer n = string.hashCode();
        synchronized (templateCacheMap) {
            template = templateCacheMap.get(n);
        }
        if (template == null) {
            Configuration configuration = new Configuration();
            EntityTemplateLoader entityTemplateLoader = new EntityTemplateLoader(pSModelSummaryTempl);
            configuration.setTemplateLoader((TemplateLoader)entityTemplateLoader);
            template = configuration.getTemplate("TEMPLCONTENT");
            HashMap<Integer, Template> hashMap = templateCacheMap;
            synchronized (hashMap) {
                if (templateCacheMap.size() > 2000) {
                    templateCacheMap.clear();
                }
                templateCacheMap.put(n, template);
            }
        }
        return template;
    }
}
