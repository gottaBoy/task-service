/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Utility.DETemplateLoader
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  freemarker.cache.TemplateLoader
 *  freemarker.template.Configuration
 *  freemarker.template.Template
 *  freemarker.template.TemplateException
 *  freemarker.template.TemplateModel
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.Version
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub.Util;

import SA.SRFDA.Ctrl.Utility.DETemplateLoader;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.PSRecursionException;
import SA.SRFDA.PS.Core.Pub.Util.PSBitFuncMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSBoolValueMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSCSTypeMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSCSTypeMethod2;
import SA.SRFDA.PS.Core.Pub.Util.PSCaseFormatMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSClassNameMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSCodeListMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSCodeListMethod2;
import SA.SRFDA.PS.Core.Pub.Util.PSCodeListMethod3;
import SA.SRFDA.PS.Core.Pub.Util.PSCtrlCssStyleMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSDataTypeMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSDataTypeMethod2;
import SA.SRFDA.PS.Core.Pub.Util.PSEmptyListMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSFilePathExMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSHtmlTextMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSImportHelperMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSIndentDirective;
import SA.SRFDA.PS.Core.Pub.Util.PSJSHtmlStringMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSJSStringMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSJSTypeMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSJSTypeMethod2;
import SA.SRFDA.PS.Core.Pub.Util.PSJavaSQLCodeMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSJavaStringMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSJavaTypeMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSJavaTypeMethod2;
import SA.SRFDA.PS.Core.Pub.Util.PSJson2YamlMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSListMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSListPosMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSMethodNameMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSNotEmptyMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSParamNameMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSPluralizeMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSPubParamMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSPythonTypeMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSR7JavaTypeMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSR8JavaTypeMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSSQLCodeMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplException;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplLimitException;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplWriter;
import SA.SRFDA.PS.Core.Pub.Util.PSUnicodeStringMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSUrlParamMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSUserCodeMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSXmlValueMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSYaml2JsonMethod;
import SA.SRFramework.DataEx.BaseDataEntity;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.Version;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSTemplHelper {
    private static final Log log = LogFactory.getLog(PSTemplHelper.class);
    public static final String ERRORMSG = "!!!!\u6a21\u7248\u4ea7\u751f\u4ee3\u7801\u9519\u8bef:";
    public static final String ACCESSDENYMSG = "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
    public static final String OUTOFMEMORYMSG = "!!!!\u51fa\u73b0\u9012\u5f52\u6216\u662f\u7834\u574f\u6027\u4ee3\u7801";
    private static final int nMaxCacheSize = 500;
    private static final int nMaxLoopCnt = 200;
    private static HashMap<Integer, Template> templateCacheMap = new HashMap();
    private static PSUserCodeMethod psUserCodeMethod = new PSUserCodeMethod();
    private static PSXmlValueMethod psXmlValueMethod = new PSXmlValueMethod();
    private static PSBoolValueMethod psBoolValueMethod = new PSBoolValueMethod();
    private static PSListMethod psListMethod = new PSListMethod();
    private static PSDataTypeMethod psDataTypeMethod = new PSDataTypeMethod();
    private static PSDataTypeMethod2 psDataTypeMethod2 = new PSDataTypeMethod2();
    private static PSJavaTypeMethod psJavaTypeMethod = new PSJavaTypeMethod();
    private static PSJavaTypeMethod2 psJavaTypeMethod2 = new PSJavaTypeMethod2();
    private static PSClassNameMethod psClassNameMethod = new PSClassNameMethod();
    private static PSParamNameMethod psParamNameMethod = new PSParamNameMethod();
    private static PSSQLCodeMethod psSQLCodeMethod = new PSSQLCodeMethod();
    private static PSJavaStringMethod psJavaStringMethod = new PSJavaStringMethod();
    private static PSMethodNameMethod psMethodNameMethod = new PSMethodNameMethod();
    private static PSJavaSQLCodeMethod psJavaSQLCodeMethod = new PSJavaSQLCodeMethod();
    private static PSBitFuncMethod psBitFuncMethod = new PSBitFuncMethod();
    private static PSListPosMethod psListPosMethod = new PSListPosMethod();
    private static PSJSStringMethod psJSStringMethod = new PSJSStringMethod();
    private static PSJSHtmlStringMethod psJSHtmlMethod = new PSJSHtmlStringMethod();
    private static PSCodeListMethod psCodeListMethod = new PSCodeListMethod();
    private static PSCodeListMethod2 psCodeListMethod2 = new PSCodeListMethod2();
    private static PSCodeListMethod3 psCodeListMethod3 = new PSCodeListMethod3();
    private static PSHtmlTextMethod psHtmlTextMethod = new PSHtmlTextMethod();
    private static PSUrlParamMethod psUrlParamMethod = new PSUrlParamMethod();
    private static PSCtrlCssStyleMethod psCtrlCssStyleMethod = new PSCtrlCssStyleMethod();
    private static PSUnicodeStringMethod psUnicodeStringMethod = new PSUnicodeStringMethod();
    private static PSPubParamMethod psPubParamMethod = new PSPubParamMethod();
    private static PSCSTypeMethod psCSTypeMethod = new PSCSTypeMethod();
    private static PSCSTypeMethod2 psCSTypeMethod2 = new PSCSTypeMethod2();
    private static PSImportHelperMethod psImportHelperMethod = new PSImportHelperMethod();
    private static PSFilePathExMethod psFilePathExMethod = new PSFilePathExMethod();
    private static PSEmptyListMethod psEmptyListMethod = new PSEmptyListMethod();
    private static PSPluralizeMethod psPluralizeMethod = new PSPluralizeMethod();
    private static PSJSTypeMethod psJSTypeMethod = new PSJSTypeMethod();
    private static PSJSTypeMethod2 psJSTypeMethod2 = new PSJSTypeMethod2();
    private static PSCaseFormatMethod psCaseFormatMethod = new PSCaseFormatMethod();
    private static PSR7JavaTypeMethod psR7JavaTypeMethod = new PSR7JavaTypeMethod();
    private static PSR8JavaTypeMethod psR8JavaTypeMethod = new PSR8JavaTypeMethod();
    private static PSNotEmptyMethod psNotEmptyMethod = new PSNotEmptyMethod();
    private static PSJson2YamlMethod psJson2YamlMethod = new PSJson2YamlMethod();
    private static PSYaml2JsonMethod psYaml2JsonMethod = new PSYaml2JsonMethod();
    private static PSPythonTypeMethod psPythonTypeMethod = new PSPythonTypeMethod();
    private static ThreadLocal<Map<String, Object>> currentParams = new ThreadLocal();
    private static ThreadLocal<ArrayList<String>> currentPubList = new ThreadLocal();
    private static boolean bExceptionWhenError = false;

    public static String generateCode(BaseDataEntity psSFCodeTempl, String strPropertyName, Map<String, Object> params) throws Exception {
        return PSTemplHelper.generateCode(psSFCodeTempl, strPropertyName, params, PSTemplHelper.isExceptionWhenError());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String generateCode(BaseDataEntity psSFCodeTempl, String strPropertyName, Map<String, Object> params, boolean bExceptionWhenErrorCur) throws Exception {
        params.put("srfmodelver", Version.MODEL);
        params.put("srfusercode", psUserCodeMethod);
        params.put("srfxmlvalue", psXmlValueMethod);
        params.put("srfboolvalue", psBoolValueMethod);
        params.put("srflist", psListMethod);
        params.put("srflistpos", psListPosMethod);
        params.put("srfdatatype", psDataTypeMethod);
        params.put("srfdatatype2", psDataTypeMethod2);
        params.put("srfjavatype", psJavaTypeMethod);
        params.put("srfjavatype2", psJavaTypeMethod2);
        params.put("srfclassname", psClassNameMethod);
        params.put("srfparamname", psParamNameMethod);
        params.put("srfsqlcode", psSQLCodeMethod);
        params.put("srfjavasqlcode", psJavaSQLCodeMethod);
        params.put("srfjavastring", psJavaStringMethod);
        params.put("srfmethodname", psMethodNameMethod);
        params.put("srfbitfunc", psBitFuncMethod);
        params.put("srfjsstring", psJSStringMethod);
        params.put("srfjshtml", psJSHtmlMethod);
        params.put("srfcodelist", psCodeListMethod2);
        params.put("srfcodelist2", psCodeListMethod2);
        params.put("srfcodelist3", psCodeListMethod3);
        params.put("srfhtmltext", psHtmlTextMethod);
        params.put("srfurlparam", psUrlParamMethod);
        params.put("srfctrlcssstyle", psCtrlCssStyleMethod);
        params.put("srfunicodestring", psUnicodeStringMethod);
        params.put("srfpubparam", psPubParamMethod);
        params.put("srfcstype", psCSTypeMethod);
        params.put("srfcstype2", psCSTypeMethod2);
        params.put("srfimports", psImportHelperMethod);
        params.put("srffilepath2", psFilePathExMethod);
        params.put("srfemptylist", psEmptyListMethod);
        params.put("srfpluralize", psPluralizeMethod);
        params.put("srfjstype", psJSTypeMethod);
        params.put("srfjstype2", psJSTypeMethod2);
        params.put("srfcaseformat", psCaseFormatMethod);
        params.put("srfr7javatype", psR7JavaTypeMethod);
        params.put("srfr8javatype", psR8JavaTypeMethod);
        params.put("srfnotempty", psNotEmptyMethod);
        params.put("srfyaml2json", psYaml2JsonMethod);
        params.put("srfjson2yaml", psJson2YamlMethod);
        params.put("srfpytype", psPythonTypeMethod);
        boolean bAddFlag = false;
        if (PSTaskServerEnvImpl.getCurrent() != null) {
            params.put("srfenv", PSTaskServerEnvImpl.getCurrent());
        }
        Map<String, Object> lastParams = currentParams.get();
        try {
            Template template = null;
            String strCode = psSFCodeTempl.getParamStringValue(strPropertyName, "");
            Integer nHashCode = strCode.hashCode();
            HashMap<Integer, Template> hashMap = templateCacheMap;
            synchronized (hashMap) {
                template = templateCacheMap.get(nHashCode);
            }
            if (template == null) {
                Configuration config = new Configuration(Configuration.VERSION_2_3_21);
                DETemplateLoader deTemplateLoader = new DETemplateLoader(psSFCodeTempl);
                config.setTemplateLoader((TemplateLoader)deTemplateLoader);
                config.setSharedVariable("ibizindent", (TemplateModel)new PSIndentDirective());
                template = config.getTemplate(strPropertyName);
                HashMap<Integer, Template> hashMap2 = templateCacheMap;
                synchronized (hashMap2) {
                    if (templateCacheMap.size() > 500) {
                        templateCacheMap.clear();
                    }
                    templateCacheMap.put(nHashCode, template);
                }
            }
            String strMode = psSFCodeTempl.getParamStringValue("SECURITYTEMPL", "0");
            PSTemplWriter sw = new PSTemplWriter();
            currentParams.set(params);
            PSTemplHelper.addPub(strMode);
            bAddFlag = true;
            template.process(params, (Writer)sw);
            PSTemplHelper.releasePub();
            bAddFlag = false;
            currentParams.set(lastParams);
            return sw.toString();
        }
        catch (PSRecursionException e) {
            if (bAddFlag) {
                PSTemplHelper.releasePub();
                bAddFlag = false;
            }
            currentParams.set(lastParams);
            throw e;
        }
        catch (PSTemplLimitException e) {
            if (bAddFlag) {
                PSTemplHelper.releasePub();
                bAddFlag = false;
            }
            currentParams.set(lastParams);
            throw e;
        }
        catch (IOException e) {
            if (bAddFlag) {
                PSTemplHelper.releasePub();
                bAddFlag = false;
            }
            currentParams.set(lastParams);
            log.error((Object)e.getMessage());
            log.error(psSFCodeTempl.getParamValue(strPropertyName));
            String strErrorMsg = ERRORMSG + PSTemplHelper.getRealTemplateError(e.getMessage());
            if (e.getCause() != null && e.getCause() instanceof Exception) {
                if (e.getCause() instanceof PSRecursionException) {
                    throw (PSRecursionException)e.getCause();
                }
                strErrorMsg = String.valueOf(strErrorMsg) + "\r\n";
                strErrorMsg = String.valueOf(strErrorMsg) + PSTemplHelper.getRealTemplateError(((Exception)e.getCause()).getMessage());
            }
            if (bExceptionWhenErrorCur) {
                throw new PSTemplException(strErrorMsg, e);
            }
            return strErrorMsg;
        }
        catch (TemplateException e) {
            if (bAddFlag) {
                PSTemplHelper.releasePub();
                bAddFlag = false;
            }
            currentParams.set(lastParams);
            log.error((Object)e.getMessage());
            log.error(psSFCodeTempl.getParamValue(strPropertyName));
            String strErrorMsg = ERRORMSG + PSTemplHelper.getRealTemplateError(e.getMessage());
            if (e.getCause() != null && e.getCause() instanceof Exception) {
                if (e.getCause() instanceof PSRecursionException) {
                    throw (PSRecursionException)e.getCause();
                }
                strErrorMsg = String.valueOf(strErrorMsg) + "\r\n";
                strErrorMsg = String.valueOf(strErrorMsg) + PSTemplHelper.getRealTemplateError(((Exception)e.getCause()).getMessage());
            }
            if (bExceptionWhenErrorCur) {
                throw new PSTemplException(strErrorMsg, e);
            }
            return strErrorMsg;
        }
        catch (OutOfMemoryError e) {
            if (bAddFlag) {
                PSTemplHelper.releasePub();
                bAddFlag = false;
            }
            currentParams.set(lastParams);
            log.error((Object)e.getMessage());
            log.error(psSFCodeTempl.getParamValue(strPropertyName));
            String strErrorMsg = ERRORMSG + PSTemplHelper.getRealTemplateError(e.getMessage());
            if (e instanceof OutOfMemoryError) {
                throw new PSRecursionException(OUTOFMEMORYMSG);
            }
            if (e.getCause() != null && e.getCause() instanceof Exception) {
                strErrorMsg = String.valueOf(strErrorMsg) + "\r\n";
                strErrorMsg = String.valueOf(strErrorMsg) + PSTemplHelper.getRealTemplateError(((Exception)e.getCause()).getMessage());
            }
            if (bExceptionWhenErrorCur) {
                throw new PSTemplException(strErrorMsg, e);
            }
            return strErrorMsg;
        }
    }

    public static String generateCode(BaseDataEntity psSFCodeTempl, String strPropertyName) throws Exception {
        return PSTemplHelper.generateCode(psSFCodeTempl, strPropertyName, PSTemplHelper.isExceptionWhenError());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String generateCode(BaseDataEntity psSFCodeTempl, String strPropertyName, boolean bExceptionWhenErrorCur) throws Exception {
        try {
            Template template = null;
            String strCode = psSFCodeTempl.getParamStringValue(strPropertyName, "");
            Integer nHashCode = strCode.hashCode();
            HashMap<Integer, Template> hashMap = templateCacheMap;
            synchronized (hashMap) {
                template = templateCacheMap.get(nHashCode);
            }
            if (template == null) {
                Configuration config = new Configuration(Configuration.VERSION_2_3_21);
                DETemplateLoader deTemplateLoader = new DETemplateLoader(psSFCodeTempl);
                config.setTemplateLoader((TemplateLoader)deTemplateLoader);
                config.setSharedVariable("ibizindent", (TemplateModel)new PSIndentDirective());
                template = config.getTemplate(strPropertyName);
                HashMap<Integer, Template> hashMap2 = templateCacheMap;
                synchronized (hashMap2) {
                    if (templateCacheMap.size() > 500) {
                        templateCacheMap.clear();
                    }
                    templateCacheMap.put(nHashCode, template);
                }
            }
            PSTemplWriter sw = new PSTemplWriter();
            template.process(PSTemplHelper.getCurrentParams(), (Writer)sw);
            return sw.toString();
        }
        catch (IOException e) {
            log.error((Object)e.getMessage());
            log.error(psSFCodeTempl.getParamValue(strPropertyName));
            String strErrorMsg = ERRORMSG + PSTemplHelper.getRealTemplateError(e.getMessage());
            if (e.getCause() != null && e.getCause() instanceof Exception) {
                if (e.getCause() instanceof PSRecursionException) {
                    throw (PSRecursionException)e.getCause();
                }
                strErrorMsg = String.valueOf(strErrorMsg) + "\r\n";
                strErrorMsg = String.valueOf(strErrorMsg) + PSTemplHelper.getRealTemplateError(((Exception)e.getCause()).getMessage());
            }
            if (bExceptionWhenErrorCur) {
                throw new PSTemplException(strErrorMsg, e);
            }
            return strErrorMsg;
        }
        catch (TemplateException e) {
            log.error((Object)e.getMessage());
            log.error(psSFCodeTempl.getParamValue(strPropertyName));
            String strErrorMsg = ERRORMSG + PSTemplHelper.getRealTemplateError(e.getMessage());
            if (e.getCause() != null && e.getCause() instanceof Exception) {
                if (e.getCause() instanceof PSRecursionException) {
                    throw (PSRecursionException)e.getCause();
                }
                strErrorMsg = String.valueOf(strErrorMsg) + "\r\n";
                strErrorMsg = String.valueOf(strErrorMsg) + PSTemplHelper.getRealTemplateError(((Exception)e.getCause()).getMessage());
            }
            if (bExceptionWhenErrorCur) {
                throw new PSTemplException(strErrorMsg, e);
            }
            return strErrorMsg;
        }
    }

    public static String generateCode2(BaseDataEntity psSFCodeTempl, String strPropertyName, Map<String, Object> params) throws Exception {
        return PSTemplHelper.generateCode2(psSFCodeTempl, strPropertyName, params, PSTemplHelper.isExceptionWhenError());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String generateCode2(BaseDataEntity psSFCodeTempl, String strPropertyName, Map<String, Object> params, boolean bExceptionWhenErrorCur) throws Exception {
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
                Configuration config = new Configuration(Configuration.VERSION_2_3_21);
                DETemplateLoader deTemplateLoader = new DETemplateLoader(psSFCodeTempl);
                config.setTemplateLoader((TemplateLoader)deTemplateLoader);
                config.setSharedVariable("ibizindent", (TemplateModel)new PSIndentDirective());
                template = config.getTemplate(strPropertyName);
                HashMap<Integer, Template> hashMap2 = templateCacheMap;
                synchronized (hashMap2) {
                    if (templateCacheMap.size() > 2000) {
                        templateCacheMap.clear();
                    }
                    templateCacheMap.put(nHashCode, template);
                }
            }
            PSTemplWriter sw = new PSTemplWriter();
            template.process(realParams, (Writer)sw);
            return sw.toString();
        }
        catch (IOException e) {
            log.error((Object)e.getMessage());
            log.error(psSFCodeTempl.getParamValue(strPropertyName));
            String strErrorMsg = ERRORMSG + PSTemplHelper.getRealTemplateError(e.getMessage());
            if (e.getCause() != null && e.getCause() instanceof Exception) {
                if (e.getCause() instanceof PSRecursionException) {
                    throw (PSRecursionException)e.getCause();
                }
                strErrorMsg = String.valueOf(strErrorMsg) + "\r\n";
                strErrorMsg = String.valueOf(strErrorMsg) + PSTemplHelper.getRealTemplateError(((Exception)e.getCause()).getMessage());
            }
            if (bExceptionWhenErrorCur) {
                throw new PSTemplException(strErrorMsg, e);
            }
            return strErrorMsg;
        }
        catch (TemplateException e) {
            log.error((Object)e.getMessage());
            log.error(psSFCodeTempl.getParamValue(strPropertyName));
            String strErrorMsg = ERRORMSG + PSTemplHelper.getRealTemplateError(e.getMessage());
            if (e.getCause() != null && e.getCause() instanceof Exception) {
                if (e.getCause() instanceof PSRecursionException) {
                    throw (PSRecursionException)e.getCause();
                }
                strErrorMsg = String.valueOf(strErrorMsg) + "\r\n";
                strErrorMsg = String.valueOf(strErrorMsg) + PSTemplHelper.getRealTemplateError(((Exception)e.getCause()).getMessage());
            }
            if (bExceptionWhenErrorCur) {
                throw new PSTemplException(strErrorMsg, e);
            }
            return strErrorMsg;
        }
    }

    public static String generateCode(String strCode, Map<String, Object> params) throws Exception {
        BaseDataEntity codeEntity = new BaseDataEntity();
        codeEntity.setParamValue("CODE", (Object)strCode);
        return PSTemplHelper.generateCode(codeEntity, "CODE", params);
    }

    public static String generateCode2(String strCode, Map<String, Object> params) throws Exception {
        BaseDataEntity codeEntity = new BaseDataEntity();
        codeEntity.setParamValue("CODE", (Object)strCode);
        return PSTemplHelper.generateCode2(codeEntity, "CODE", params);
    }

    public static Map<String, Object> getCurrentParams() {
        return currentParams.get();
    }

    public static void setCurrentParams(Map<String, Object> params) {
        currentParams.set(params);
    }

    private static int addPub(String strMode) throws PSRecursionException {
        ArrayList<String> list = currentPubList.get();
        if (list == null) {
            list = new ArrayList();
            currentPubList.set(list);
        } else if (list.size() > 200) {
            throw new PSRecursionException(StringHelper.format((String)"\u6a21\u677f\u53d1\u5e03\u5c42\u6b21\u8d85\u8fc7[%1$s]", (Object)200));
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

    public static String getRealTemplateError(String strMessage) {
        if (StringHelper.isNullOrEmpty((String)strMessage)) {
            return strMessage;
        }
        int nPos = strMessage.indexOf("----");
        if (nPos != -1) {
            return strMessage.substring(nPos);
        }
        return strMessage;
    }

    public static boolean hasError(String strContent) {
        if (!StringHelper.isNullOrEmpty((String)strContent)) {
            if (strContent.indexOf(ERRORMSG) != -1) {
                return true;
            }
            if (strContent.indexOf(ACCESSDENYMSG) != -1) {
                return true;
            }
            if (strContent.indexOf(OUTOFMEMORYMSG) != -1) {
                return true;
            }
        }
        return false;
    }

    public static void setExceptionWhenError(boolean bExceptionWhenError) {
        PSTemplHelper.bExceptionWhenError = bExceptionWhenError;
    }

    public static boolean isExceptionWhenError() {
        return bExceptionWhenError;
    }

    public static void assertNotBusy() throws Exception {
        if (PSTemplHelper.isBusy()) {
            throw new Exception(StringHelper.format((String)"\u4e0d\u80fd\u5728\u6a21\u677f\u53d1\u5e03\u8fc7\u7a0b\u4e2d\u8c03\u7528\u6b64\u65b9\u6cd5"));
        }
    }
}

