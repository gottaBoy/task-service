/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.cache.TemplateLoader
 *  freemarker.template.Configuration
 *  freemarker.template.Template
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.freemarker.EntityTemplateLoader
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.util;

import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.freemarker.EntityTemplateLoader;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSPFQuickTempl;
import net.ibizsys.pscore.srv.config.service.PSPFQuickTemplService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSPFQuickPreviewHelper {
    private static final Log log = LogFactory.getLog(PSPFQuickPreviewHelper.class);
    private static HashMap<String, PSPFQuickTempl> psPFQuickTemplMap = new HashMap();
    private static HashMap<Integer, Template> templateCacheMap = new HashMap();
    private static boolean bFirstTime = true;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void reload() throws Exception {
        Object object = psPFQuickTemplMap;
        synchronized (object) {
            psPFQuickTemplMap.clear();
        }
        object = templateCacheMap;
        synchronized (object) {
            templateCacheMap.clear();
        }
        object = (PSPFQuickTemplService)ServiceGlobal.getService(PSPFQuickTemplService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.set("VALIDFLAG", (Object)1);
        ArrayList arrayList = object.select((ISelectCond)selectCond);
        for (PSPFQuickTempl pSPFQuickTempl : arrayList) {
            psPFQuickTemplMap.put(pSPFQuickTempl.getPSPFQuickTemplId(), pSPFQuickTempl);
        }
    }

    public static String getQuickTempl(String string, IEntity iEntity) throws Exception {
        return PSPFQuickPreviewHelper.getQuickTempl(string, iEntity, false);
    }

    public static String getQuickTempl(String string, IEntity iEntity, boolean bl) throws Exception {
        if (bFirstTime) {
            PSPFQuickPreviewHelper.reload();
            bFirstTime = false;
        }
        String string2 = "";
        try {
            PSPFQuickTempl pSPFQuickTempl = psPFQuickTemplMap.get(string);
            if (pSPFQuickTempl == null) {
                return null;
            }
            Template template = PSPFQuickPreviewHelper.getTemplate(pSPFQuickTempl);
            if (template == null) {
                return null;
            }
            HashMap<String, IEntity> hashMap = new HashMap<String, IEntity>();
            hashMap.put("item", iEntity);
            StringWriter stringWriter = new StringWriter();
            template.process(hashMap, (Writer)stringWriter);
            string2 = stringWriter.toString();
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
    public static Template getTemplate(PSPFQuickTempl pSPFQuickTempl) throws Exception {
        Template template = null;
        String string = DataObject.getStringValue((Object)pSPFQuickTempl.get("TEMPLCODE"), null);
        if (StringHelper.isNullOrEmpty((String)string)) {
            return template;
        }
        Integer n = string.hashCode();
        Configuration configuration = templateCacheMap;
        synchronized (configuration) {
            template = templateCacheMap.get(n);
        }
        if (template == null) {
            configuration = new Configuration();
            EntityTemplateLoader entityTemplateLoader = new EntityTemplateLoader((IEntity)pSPFQuickTempl);
            configuration.setTemplateLoader((TemplateLoader)entityTemplateLoader);
            template = configuration.getTemplate("TEMPLCODE");
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

