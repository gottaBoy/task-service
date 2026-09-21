/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.DP.DefaultDPExBuilder
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.DP.UI.DPConfig
 *  freemarker.cache.StringTemplateLoader
 *  freemarker.cache.TemplateLoader
 *  freemarker.template.Configuration
 *  freemarker.template.Template
 *  freemarker.template.TemplateException
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web.Render;

import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Render.FIMacroParam;
import SA.SRFDA.Web.Render.FormMacroParam;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DP.DefaultDPExBuilder;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.DP.UI.DPConfig;
import freemarker.cache.StringTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Hashtable;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DPExBuilder3
extends DefaultDPExBuilder {
    private static final Log log = LogFactory.getLog(DPExBuilder3.class);
    private static Hashtable<String, Configuration> configMap = new Hashtable();

    public void Render(Writer writer, SRFExDPEx dpEx) {
        StringWriter sw;
        Template template;
        super.Render(writer, dpEx);
        if (dpEx.getPage().IsBackEndMode()) {
            return;
        }
        String strFIVCScript = dpEx.getDPConfig().GetExtValue("FIVCSCRIPT", "");
        String strFormScript = dpEx.getDPConfig().GetExtValue("FORMSCRIPTEX", "");
        String strFormScript2 = dpEx.getDPConfig().GetExtValue("FORMSCRIPTEX2", "");
        String strFormBSScript = dpEx.getDPConfig().GetExtValue("FORMBSSCRIPT", "");
        if (StringHelper.IsNullOrEmpty((String)strFIVCScript) && StringHelper.IsNullOrEmpty((String)strFormScript) && StringHelper.IsNullOrEmpty((String)strFormScript2) && StringHelper.IsNullOrEmpty((String)strFormBSScript)) {
            return;
        }
        Configuration config = DPExBuilder3.GetConfiguration(dpEx.getDPConfig());
        if (config == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u52a8\u6001\u9762\u677f[%1$s]\u6a21\u677f\u8f85\u52a9\u5bf9\u8c61", (Object)dpEx.getDPConfig().getID()));
            return;
        }
        Date startDate = new Date();
        SRFDAPage page = (SRFDAPage)dpEx.getPage();
        TreeMap<String, Object> params = new TreeMap<String, Object>();
        MacroHelper.FillMacroParams(params, (ISRFDAWebContext)page.getWebContext(), (ISRFDAGlobalHelper)page.getWebContext().getGlobalHelper(), (String)page.getWebContext().getCurUserId(), null, null, (String)"");
        FIMacroParam fiMacroParam = new FIMacroParam();
        fiMacroParam.setForm(this.form);
        params.put("fi", fiMacroParam);
        FormMacroParam formMacroParam = new FormMacroParam();
        formMacroParam.setForm(this.form);
        params.put("form", formMacroParam);
        if (!StringHelper.IsNullOrEmpty((String)strFIVCScript)) {
            try {
                template = config.getTemplate("FIVCSCRIPT");
                sw = new StringWriter();
                template.process(params, (Writer)sw);
                this.form.getItemValueChangedAction().AppendAfterCode(sw.toString());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (TemplateException e) {
                e.printStackTrace();
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strFormBSScript)) {
            try {
                template = config.getTemplate("FORMBSSCRIPT");
                sw = new StringWriter();
                template.process(params, (Writer)sw);
                this.form.getSaveAction().AppendBeforeCode(sw.toString());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (TemplateException e) {
                e.printStackTrace();
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strFormScript)) {
            try {
                template = config.getTemplate("FORMSCRIPTEX");
                sw = new StringWriter();
                template.process(params, (Writer)sw);
                dpEx.getPage().RegisterScript(3, sw.toString());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (TemplateException e) {
                e.printStackTrace();
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strFormScript2)) {
            try {
                template = config.getTemplate("FORMSCRIPTEX2");
                sw = new StringWriter();
                template.process(params, (Writer)sw);
                dpEx.getPage().RegisterOnReadyScript(3, sw.toString());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (TemplateException e) {
                e.printStackTrace();
            }
        }
        Date endDate = new Date();
        log.debug((Object)StringHelper.Format((String)"\u52a8\u6001\u9762\u677f\u52a8\u6001\u811a\u672c\u5904\u7406\u65f6\u95f4[%1$s]", (Object)(endDate.getTime() - startDate.getTime())));
    }

    protected void OnReset() {
        super.OnReset();
    }

    protected static Configuration GetConfiguration(DPConfig dpConfig) {
        Configuration config = null;
        String strId = dpConfig.getConfigId();
        if (!StringHelper.IsNullOrEmpty((String)strId)) {
            config = configMap.get(strId);
        }
        if (config != null) {
            return config;
        }
        String strFIVCScript = dpConfig.GetExtValue("FIVCSCRIPT", "");
        String strFormScript = dpConfig.GetExtValue("FORMSCRIPTEX", "");
        String strFormScript2 = dpConfig.GetExtValue("FORMSCRIPTEX2", "");
        String strFormBSScript = dpConfig.GetExtValue("FORMBSSCRIPT", "");
        StringTemplateLoader dpTemplate = new StringTemplateLoader();
        dpTemplate.putTemplate("FIVCSCRIPT", strFIVCScript);
        dpTemplate.putTemplate("FORMSCRIPTEX", strFormScript);
        dpTemplate.putTemplate("FORMSCRIPTEX2", strFormScript2);
        dpTemplate.putTemplate("FORMBSSCRIPT", strFormBSScript);
        config = new Configuration();
        config.setTemplateLoader((TemplateLoader)dpTemplate);
        if (!StringHelper.IsNullOrEmpty((String)strId)) {
            if (configMap.size() > 1000) {
                configMap.clear();
            }
            configMap.put(strId, config);
        }
        return config;
    }
}

