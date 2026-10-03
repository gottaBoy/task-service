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
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.core.IDEFInputTip
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEFInputTipModel
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
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
import java.util.Map;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IDEFInputTip;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEFInputTipModel;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.freemarker.EntityTemplateLoader;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDEFGroupDetailModel;
import net.ibizsys.pscore.srv.core.IPSDEFGroupModel;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRTDEFInputTip;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRTDEFInputTipService;
import net.ibizsys.pscore.srv.util.pub.PSCodeListContentMethod;
import net.ibizsys.pscore.srv.util.pub.PSCodeListMethod;
import net.ibizsys.pscore.srv.util.pub.PSSysRTDEFInputTipMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSysRTDEFInputTipHelper {
    private static final Log log = LogFactory.getLog(PSSysRTDEFInputTipHelper.class);
    private static HashMap<String, PSSysRTDEFInputTip> psSysRTDEFInputTipMap = new HashMap();
    private static HashMap<Integer, Template> templateCacheMap = new HashMap();
    private static HashMap<String, IDEFInputTip> cacheDEFInputTipMap = new HashMap();
    private static boolean bFirstTime = true;
    private static boolean bOutputMD = false;
    private static PSCodeListMethod psCodeListMethod = new PSCodeListMethod();
    private static PSCodeListContentMethod psCodeListContentMethod = new PSCodeListContentMethod();
    private static PSSysRTDEFInputTipMethod psSysRTDEFInputTipMethod = new PSSysRTDEFInputTipMethod();

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
        Object object = psSysRTDEFInputTipMap;
        synchronized (object) {
            psSysRTDEFInputTipMap.clear();
        }
        object = templateCacheMap;
        synchronized (object) {
            templateCacheMap.clear();
        }
        object = cacheDEFInputTipMap;
        synchronized (object) {
            cacheDEFInputTipMap.clear();
        }
        object = (PSSysRTDEFInputTipService)ServiceGlobal.getService(PSSysRTDEFInputTipService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.set("VALIDFLAG", (Object)1);
        ArrayList<PSSysRTDEFInputTip> arrayList = ((PSSysRTDEFInputTipService)object).select((ISelectCond)selectCond);
        for (PSSysRTDEFInputTip pSSysRTDEFInputTip : arrayList) {
            if (DataObject.getIntegerValue((Object)pSSysRTDEFInputTip.getOrderValue(), (Integer)0) < 1000 || StringHelper.isNullOrEmpty((String)pSSysRTDEFInputTip.getUniqueTag())) continue;
            psSysRTDEFInputTipMap.put(pSSysRTDEFInputTip.getUniqueTag(), pSSysRTDEFInputTip);
        }
    }

    public static IDEFInputTip getDEFInputTip(String string) throws Exception {
        return PSSysRTDEFInputTipHelper.getDEFInputTip(string, null, false);
    }

    public static IDEFInputTip getDEFInputTip(String string, String string2) throws Exception {
        return PSSysRTDEFInputTipHelper.getDEFInputTip(string, string2, null, false, true);
    }

    public static IDEFInputTip getDEFInputTip(String string, Map<String, Object> map, boolean bl) throws Exception {
        return PSSysRTDEFInputTipHelper.getDEFInputTip(string, null, map, bl, true);
    }

    public static IDEFInputTip getDEFInputTip(String string, String string2, Map<String, Object> map, boolean bl, boolean bl2) throws Exception {
        String string3 = string;
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            string3 = string3 + "|" + string2;
        }
        IDEFInputTip iDEFInputTip = null;
        if (bl2) {
            iDEFInputTip = cacheDEFInputTipMap.get(string3);
        }
        if (iDEFInputTip == null) {
            DEFInputTipModel dEFInputTipModel;
            String string4 = null;
            if (!StringHelper.isNullOrEmpty((String)string2) && (string4 = PSSysRTDEFInputTipHelper.internalGetPSDEFInputTip(string, string2, map, bl)) != null) {
                dEFInputTipModel = new DEFInputTipModel();
                dEFInputTipModel.setContent(string4);
                dEFInputTipModel.setUniqueTag(string.replace("__", StringHelper.format((String)"__%1$s__", (Object)string2)));
                iDEFInputTip = dEFInputTipModel;
            }
            if (StringHelper.isNullOrEmpty(string4)) {
                string4 = PSSysRTDEFInputTipHelper.internalGetPSDEFInputTip(string, null, map, bl);
                if (string4 != null) {
                    dEFInputTipModel = new DEFInputTipModel();
                    dEFInputTipModel.setContent(string4);
                    dEFInputTipModel.setUniqueTag(string);
                    iDEFInputTip = dEFInputTipModel;
                } else {
                    dEFInputTipModel = new DEFInputTipModel();
                    dEFInputTipModel.setContent(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u5c5e\u6027\u63d0\u793a[%1$s]\u5185\u5bb9", (Object)string3));
                    dEFInputTipModel.setUniqueTag(string);
                    iDEFInputTip = dEFInputTipModel;
                }
            }
            if (bl2) {
                cacheDEFInputTipMap.put(string3, iDEFInputTip);
            }
        }
        return iDEFInputTip;
    }

    protected static String internalGetPSDEFInputTip(String string, String string2, Map<String, Object> map, boolean bl) throws Exception {
        StringWriter stringWriter;
        Template template;
        PSSysRTDEFInputTip pSSysRTDEFInputTip;
        String string3;
        if (bFirstTime) {
            PSSysRTDEFInputTipHelper.reload();
            bFirstTime = false;
        }
        String string4 = "";
        try {
            string3 = string;
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                string3 = string3 + "#" + string2;
            }
            if ((pSSysRTDEFInputTip = psSysRTDEFInputTipMap.get(string3)) == null) {
                String string5 = string.replace("__", "|");
                String[] stringArray = string5.split("[|]");
                if (stringArray.length == 2) {
                    IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)stringArray[0], (boolean)true);
                    IPSDataEntityModel iPSDataEntityModel = null;
                    if (iDataEntityModel instanceof IPSDataEntityModel) {
                        iPSDataEntityModel = (IPSDataEntityModel)iDataEntityModel;
                    }
                    if (iPSDataEntityModel != null) {
                        IPSDEFieldModel iPSDEFieldModel;
                        if (!StringHelper.isNullOrEmpty((String)string2)) {
                            IPSDEFGroupDetailModel iPSDEFGroupDetailModel;
                            IPSDEFGroupModel iPSDEFGroupModel = iPSDataEntityModel.getPSDEFGroupModel(string2, true);
                            if (iPSDEFGroupModel != null && (iPSDEFGroupDetailModel = iPSDEFGroupModel.getPSDEFGroupDetailModel(stringArray[1], true)) != null) {
                                ICodeList iCodeList;
                                if (map == null) {
                                    map = new HashMap<String, Object>();
                                }
                                map.put("defield", iPSDEFGroupDetailModel);
                                if (!StringHelper.isNullOrEmpty((String)iPSDEFGroupDetailModel.getCodeListId()) && (iCodeList = CodeListGlobal.getCodeList((String)iPSDEFGroupDetailModel.getCodeListId(), (boolean)true)) != null && StringHelper.compare((String)iCodeList.getUserData(), (String)"RESERVEMODELV2", (boolean)false) != 0) {
                                    map.put("codelistid", iPSDEFGroupDetailModel.getCodeListId());
                                    map.put("codelist", iCodeList);
                                }
                                return PSSysRTDEFInputTipHelper.internalGetPSDEFInputTip("GLOBAL_DEFIELD", "", map, bl);
                            }
                            return null;
                        }
                        IDEField iDEField = iDataEntityModel.getDEField(stringArray[1], true);
                        if (iDEField != null && iDEField instanceof IPSDEFieldModel && !StringHelper.isNullOrEmpty((String)(iPSDEFieldModel = (IPSDEFieldModel)iDEField).getMemo())) {
                            ICodeList iCodeList;
                            if (iPSDEFieldModel.getMemo().indexOf("@") == 0) {
                                return PSSysRTDEFInputTipHelper.internalGetPSDEFInputTip(iPSDEFieldModel.getMemo().substring(1), string2, map, bl);
                            }
                            if (map == null) {
                                map = new HashMap<String, Object>();
                            }
                            map.put("defield", iPSDEFieldModel);
                            if (!StringHelper.isNullOrEmpty((String)iPSDEFieldModel.getCodeListId()) && (iCodeList = CodeListGlobal.getCodeList((String)iPSDEFieldModel.getCodeListId(), (boolean)true)) != null && StringHelper.compare((String)iCodeList.getUserData(), (String)"RESERVEMODELV2", (boolean)false) != 0) {
                                map.put("codelistid", iPSDEFieldModel.getCodeListId());
                                map.put("codelist", iCodeList);
                            }
                            return PSSysRTDEFInputTipHelper.internalGetPSDEFInputTip("GLOBAL_DEFIELD", "", map, bl);
                        }
                    }
                }
                return StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8fd0\u884c\u65f6\u8f93\u5165\u63d0\u793a[%1$s]", (Object)string);
            }
            template = PSSysRTDEFInputTipHelper.getTemplate(pSSysRTDEFInputTip);
            if (template == null) {
                return StringHelper.format((String)"\u6307\u5b9a\u8fd0\u884c\u65f6\u8f93\u5165\u63d0\u793a[%1$s]\u6a21\u677f\u65e0\u6548", (Object)string);
            }
            if (map == null) {
                map = new HashMap<String, Object>();
            }
            map.put("srfcodelist", psCodeListMethod);
            map.put("srfcodelistdesc", psCodeListContentMethod);
            map.put("srfrtinputtip", psSysRTDEFInputTipMethod);
            stringWriter = new StringWriter();
            template.process(map, (Writer)stringWriter);
            string4 = stringWriter.toString();
            if (PSSysRTDEFInputTipHelper.isOutputMD()) {
                return string4;
            }
        }
        catch (Exception exception) {
            log.error((Object)exception.getMessage(), (Throwable)exception);
            if (bl) {
                throw exception;
            }
            return "";
        }
        try {
            MutableDataSet options = new MutableDataSet();
            options.setFrom((MutableDataSetter)ParserEmulationProfile.MARKDOWN);
            options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));
            Parser parser = Parser.builder((DataHolder)options).build();
            HtmlRenderer renderer = HtmlRenderer.builder((DataHolder)options).build();
            Node document = parser.parse(string4);
            String string6 = renderer.render(document);
            string6 = "<div class='markdown-body' >" + string6 + "</div>";
            return string6;
        }
        catch (Exception exception) {
            log.error((Object)exception.getMessage(), (Throwable)exception);
            if (bl) {
                throw exception;
            }
            return "";
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Template getTemplate(PSSysRTDEFInputTip pSSysRTDEFInputTip) throws Exception {
        Template template = null;
        String string = DataObject.getStringValue((Object)pSSysRTDEFInputTip.get("CONTENT"), null);
        if (StringHelper.isNullOrEmpty((String)string)) {
            return template;
        }
        Integer n = string.hashCode();
        HashMap<Integer, Template> cache = templateCacheMap;
        synchronized (cache) {
            template = templateCacheMap.get(n);
        }
        if (template == null) {
            Configuration configuration = new Configuration();
            EntityTemplateLoader entityTemplateLoader = new EntityTemplateLoader(pSSysRTDEFInputTip);
            configuration.setTemplateLoader((TemplateLoader)entityTemplateLoader);
            template = configuration.getTemplate("CONTENT");
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
