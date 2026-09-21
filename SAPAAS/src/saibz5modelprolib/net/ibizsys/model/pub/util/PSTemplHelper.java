/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  freemarker.cache.TemplateLoader
 *  freemarker.template.Configuration
 *  freemarker.template.Template
 *  freemarker.template.TemplateException
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pub.util;

import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.model.entity.BaseDataEntity;
import net.ibizsys.model.pub.util.EntityTemplateLoader;
import net.ibizsys.model.pub.util.PSHtmlTextMethod;
import net.ibizsys.model.pub.util.PSJSHtmlStringMethod;
import net.ibizsys.model.pub.util.PSJSStringMethod;
import net.ibizsys.model.pub.util.PSPubParamMethod;
import net.ibizsys.model.pub.util.PSUrlParamMethod;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSTemplHelper {
    private static final Log log = LogFactory.getLog(PSTemplHelper.class);
    public static final String ERRORMSG = "!!!!\u6a21\u7248\u4ea7\u751f\u4ee3\u7801\u9519\u8bef:";
    public static final String ACCESSDENYMSG = "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
    private static final int nMaxCacheSize = 500;
    private static HashMap<Integer, Template> templateCacheMap = new HashMap();
    private static PSJSStringMethod psJSStringMethod = new PSJSStringMethod();
    private static PSJSHtmlStringMethod psJSHtmlMethod = new PSJSHtmlStringMethod();
    private static PSHtmlTextMethod psHtmlTextMethod = new PSHtmlTextMethod();
    private static PSPubParamMethod psPubParamMethod = new PSPubParamMethod();
    private static PSUrlParamMethod psUrlParamMethod = new PSUrlParamMethod();
    private static ThreadLocal<Map<String, Object>> currentParams = new ThreadLocal();
    private static ThreadLocal<ArrayList<String>> currentPubList = new ThreadLocal();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String generateCode(IEntity psSFCodeTempl, String strPropertyName, Map<String, Object> params) throws Exception {
        params.put("srfjsstring", psJSStringMethod);
        params.put("srfjshtml", psJSHtmlMethod);
        params.put("srfhtmltext", psHtmlTextMethod);
        params.put("srfurlparam", psUrlParamMethod);
        params.put("srfpubparam", psPubParamMethod);
        boolean bAddFlag = false;
        try {
            Template template = null;
            String strCode = DataObject.getStringValue((Object)psSFCodeTempl.get(strPropertyName), (String)"");
            Integer nHashCode = strCode.hashCode();
            HashMap<Integer, Template> hashMap = templateCacheMap;
            synchronized (hashMap) {
                template = templateCacheMap.get(nHashCode);
            }
            if (template == null) {
                Configuration config = new Configuration();
                EntityTemplateLoader deTemplateLoader = new EntityTemplateLoader(psSFCodeTempl);
                config.setTemplateLoader((TemplateLoader)deTemplateLoader);
                template = config.getTemplate(strPropertyName);
                HashMap<Integer, Template> hashMap2 = templateCacheMap;
                synchronized (hashMap2) {
                    if (templateCacheMap.size() > 500) {
                        templateCacheMap.clear();
                    }
                    templateCacheMap.put(nHashCode, template);
                }
            }
            String strMode = "";
            StringWriter sw = new StringWriter();
            currentParams.set(params);
            PSTemplHelper.addPub(strMode);
            bAddFlag = true;
            template.process(params, (Writer)sw);
            PSTemplHelper.releasePub();
            bAddFlag = false;
            currentParams.set(null);
            return sw.toString();
        }
        catch (IOException e) {
            if (bAddFlag) {
                PSTemplHelper.releasePub();
                bAddFlag = false;
            }
            currentParams.set(null);
            log.error((Object)e.getMessage());
            log.error(psSFCodeTempl.get(strPropertyName));
            String strErrorMsg = ERRORMSG + e.getMessage();
            if (e.getCause() != null && e.getCause() instanceof Exception) {
                strErrorMsg = String.valueOf(strErrorMsg) + "\r\n";
                strErrorMsg = String.valueOf(strErrorMsg) + ((Exception)e.getCause()).getMessage();
            }
            return strErrorMsg;
        }
        catch (TemplateException e) {
            if (bAddFlag) {
                PSTemplHelper.releasePub();
                bAddFlag = false;
            }
            currentParams.set(null);
            log.error((Object)e.getMessage());
            log.error(psSFCodeTempl.get(strPropertyName));
            String strErrorMsg = ERRORMSG + e.getMessage();
            if (e.getCause() != null && e.getCause() instanceof Exception) {
                strErrorMsg = String.valueOf(strErrorMsg) + "\r\n";
                strErrorMsg = String.valueOf(strErrorMsg) + ((Exception)e.getCause()).getMessage();
            }
            return strErrorMsg;
        }
        catch (OutOfMemoryError e) {
            if (bAddFlag) {
                PSTemplHelper.releasePub();
                bAddFlag = false;
            }
            currentParams.set(null);
            log.error((Object)e.getMessage());
            log.error(psSFCodeTempl.get(strPropertyName));
            String strErrorMsg = ERRORMSG + e.getMessage();
            if (e.getCause() != null && e.getCause() instanceof Exception) {
                strErrorMsg = String.valueOf(strErrorMsg) + "\r\n";
                strErrorMsg = String.valueOf(strErrorMsg) + ((Exception)e.getCause()).getMessage();
            }
            return strErrorMsg;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String generateCode(BaseDataEntity psSFCodeTempl, String strPropertyName) throws Exception {
        try {
            Template template = null;
            String strCode = psSFCodeTempl.getParamStringValue(strPropertyName, "");
            Integer nHashCode = strCode.hashCode();
            HashMap<Integer, Template> hashMap = templateCacheMap;
            synchronized (hashMap) {
                template = templateCacheMap.get(nHashCode);
            }
            if (template == null) {
                Configuration config = new Configuration();
                EntityTemplateLoader deTemplateLoader = new EntityTemplateLoader((IEntity)psSFCodeTempl);
                config.setTemplateLoader((TemplateLoader)deTemplateLoader);
                template = config.getTemplate(strPropertyName);
                HashMap<Integer, Template> hashMap2 = templateCacheMap;
                synchronized (hashMap2) {
                    if (templateCacheMap.size() > 500) {
                        templateCacheMap.clear();
                    }
                    templateCacheMap.put(nHashCode, template);
                }
            }
            StringWriter sw = new StringWriter();
            template.process(PSTemplHelper.getCurrentParams(), (Writer)sw);
            return sw.toString();
        }
        catch (IOException e) {
            log.error((Object)e.getMessage());
            log.error(psSFCodeTempl.get(strPropertyName));
            String strErrorMsg = ERRORMSG + e.getMessage();
            if (e.getCause() != null && e.getCause() instanceof Exception) {
                strErrorMsg = String.valueOf(strErrorMsg) + "\r\n";
                strErrorMsg = String.valueOf(strErrorMsg) + ((Exception)e.getCause()).getMessage();
            }
            return strErrorMsg;
        }
        catch (TemplateException e) {
            log.error((Object)e.getMessage());
            log.error(psSFCodeTempl.get(strPropertyName));
            String strErrorMsg = ERRORMSG + e.getMessage();
            if (e.getCause() != null && e.getCause() instanceof Exception) {
                strErrorMsg = String.valueOf(strErrorMsg) + "\r\n";
                strErrorMsg = String.valueOf(strErrorMsg) + ((Exception)e.getCause()).getMessage();
            }
            return strErrorMsg;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String generateCode2(BaseDataEntity psSFCodeTempl, String strPropertyName, Map<String, Object> params) throws Exception {
        try {
            HashMap<String, Object> realParams = new HashMap<String, Object>();
            if (PSTemplHelper.getCurrentParams() != null) {
                realParams.putAll(PSTemplHelper.getCurrentParams());
            }
            if (params != null) {
                realParams.putAll(params);
            }
            Template template = null;
            String strCode = psSFCodeTempl.getParamStringValue(strPropertyName, "");
            Integer nHashCode = strCode.hashCode();
            HashMap<Integer, Template> hashMap = templateCacheMap;
            synchronized (hashMap) {
                template = templateCacheMap.get(nHashCode);
            }
            if (template == null) {
                Configuration config = new Configuration();
                EntityTemplateLoader deTemplateLoader = new EntityTemplateLoader((IEntity)psSFCodeTempl);
                config.setTemplateLoader((TemplateLoader)deTemplateLoader);
                template = config.getTemplate(strPropertyName);
                HashMap<Integer, Template> hashMap2 = templateCacheMap;
                synchronized (hashMap2) {
                    if (templateCacheMap.size() > 2000) {
                        templateCacheMap.clear();
                    }
                    templateCacheMap.put(nHashCode, template);
                }
            }
            StringWriter sw = new StringWriter();
            template.process(realParams, (Writer)sw);
            return sw.toString();
        }
        catch (IOException e) {
            log.error((Object)e.getMessage());
            log.error(psSFCodeTempl.get(strPropertyName));
            String strErrorMsg = ERRORMSG + e.getMessage();
            if (e.getCause() != null && e.getCause() instanceof Exception) {
                strErrorMsg = String.valueOf(strErrorMsg) + "\r\n";
                strErrorMsg = String.valueOf(strErrorMsg) + ((Exception)e.getCause()).getMessage();
            }
            return strErrorMsg;
        }
        catch (TemplateException e) {
            log.error((Object)e.getMessage());
            log.error(psSFCodeTempl.get(strPropertyName));
            String strErrorMsg = ERRORMSG + e.getMessage();
            if (e.getCause() != null && e.getCause() instanceof Exception) {
                strErrorMsg = String.valueOf(strErrorMsg) + "\r\n";
                strErrorMsg = String.valueOf(strErrorMsg) + ((Exception)e.getCause()).getMessage();
            }
            return strErrorMsg;
        }
    }

    public static String generateCode(String strCode, Map<String, Object> params) throws Exception {
        BaseDataEntity codeEntity = new BaseDataEntity();
        codeEntity.setParamValue("CODE", strCode);
        return PSTemplHelper.generateCode((IEntity)codeEntity, "CODE", params);
    }

    public static String generateCode2(String strCode, Map<String, Object> params) throws Exception {
        BaseDataEntity codeEntity = new BaseDataEntity();
        codeEntity.setParamValue("CODE", strCode);
        return PSTemplHelper.generateCode2(codeEntity, "CODE", params);
    }

    public static Map<String, Object> getCurrentParams() {
        return currentParams.get();
    }

    private static int addPub(String strMode) {
        ArrayList<String> list = currentPubList.get();
        if (list == null) {
            list = new ArrayList();
            currentPubList.set(list);
        }
        list.add(0, strMode);
        return list.size();
    }

    private static int releasePub() {
        ArrayList<String> list = currentPubList.get();
        if (list == null) {
            return 0;
        }
        if (list.size() > 0) {
            list.remove(0);
        }
        return list.size();
    }

    public static boolean isBusy() {
        ArrayList<String> list = currentPubList.get();
        return list != null && list.size() > 0;
    }

    public static boolean isSecurityPub() {
        return true;
    }
}

