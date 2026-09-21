/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFFormCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DGModeDetail
 *  SA.SRFDA.Ctrl.FormCtrlHelper.FormCtrlWriterConfig
 *  SA.SRFDA.Ctrl.FormCtrlHelper.IFormCtrlWriter
 *  SA.SRFDA.Ctrl.IDEMAFieldHelper
 *  SA.SRFDA.Model.ValueRuleConfig
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFramework.Base.PropertyConfig
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.FormCtrlHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFFormCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DGModeDetail;
import SA.SRFDA.Ctrl.FormCtrlHelper.FormCtrlWriterConfig;
import SA.SRFDA.Ctrl.FormCtrlHelper.IFormCtrlWriter;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFDA.Model.ValueRuleConfig;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.Base.PropertyConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.XML.XMLNode;
import java.io.StringReader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseFormCtrlWriter
implements IFormCtrlWriter {
    private static final Log log = LogFactory.getLog(BaseFormCtrlWriter.class);
    public static final String TAG_SRFDAAC = "SRFDAAC";
    public static final String TAG_SRFCP = "CP_";
    public static final String TAG_SRFFI = "FI_";
    public static final String TAG_EXTPARAMS = "EXTPARAMS";
    public static final String TAG_FIEXTPARAMS = "FIEXTPARAMS";
    protected FormCtrlWriterConfig formCtrlHelperConfig = null;
    protected GlobalHelperEx globalHelperEx = null;
    protected String strLanguage = "";
    protected String strPageModel = "";

    public CallResult Init(FormCtrlWriterConfig formCtrlHelperConfig, GlobalHelperEx globalHelperEx, String strPageModel, String strLanguage) {
        this.formCtrlHelperConfig = formCtrlHelperConfig;
        this.globalHelperEx = globalHelperEx;
        this.strLanguage = strLanguage;
        this.strPageModel = strPageModel;
        return new CallResult();
    }

    protected static IDEMAFieldHelper GetDEMAField(IDEFHelper iDEFHelper, XMLNode formCtrlConfig) throws Exception {
        String strDEMainAction = formCtrlConfig.GetExtValue("FC_DEMAINACTION", "");
        if (StringHelper.IsNullOrEmpty((String)strDEMainAction)) {
            return null;
        }
        return iDEFHelper.getDEHelper().FindDEMainAction(strDEMainAction).FindDEMAField(iDEFHelper.getId());
    }

    public XMLNode GetFormCtrlNode(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig) {
        IDEFFormCtrl iFormCtrl = iDEFHelper.GetFormCtrl();
        TreeMap<String, String> ctrlParams = new TreeMap<String, String>();
        BaseFormCtrlWriter.BuildCtrlParams(ctrlParams, formCtrlConfig, iFormCtrl == null ? "" : iFormCtrl.GetUserParam());
        XMLNode formCtrlNode = this.OnGetFormCtrlNode(iDEFHelper, iDEMAFieldHelper, formCtrlConfig, false, ctrlParams);
        if (formCtrlNode != null) {
            XMLNode itemNode;
            if (this.formCtrlHelperConfig != null && this.formCtrlHelperConfig.getPropertiesConfig() != null) {
                for (PropertyConfig propertyConfig : this.formCtrlHelperConfig.getPropertiesConfig()) {
                    if (formCtrlNode.IsContainsKey(propertyConfig.getID())) continue;
                    formCtrlNode.SetValue(propertyConfig.getID(), propertyConfig.getValue());
                }
            }
            if ((itemNode = this.OnAppendFormItemNode(iDEFHelper, formCtrlConfig, formCtrlNode)) != null) {
                if (this.IsAppendFormItemRule()) {
                    this.OnAppendFormItemValueRule(iDEFHelper, formCtrlConfig, formCtrlNode, itemNode);
                }
                String strAllowEmpty = itemNode.GetExtValue("ALLOWEMPTY", "");
                formCtrlConfig.SetValue("ALLOWEMPTY", strAllowEmpty);
            }
            formCtrlNode.setID(iFormCtrl.GetFormCtrlId());
            String strCaption = formCtrlConfig.GetExtValue("CAPTION", "");
            String strCapLanResId = formCtrlConfig.GetExtValue("CAPLANRESID", "");
            if (!StringHelper.IsNullOrEmpty((String)strCapLanResId)) {
                strCaption = this.globalHelperEx.getLocalizationHelper().GetLocalization(this.strLanguage, strCapLanResId, strCaption);
            }
            if (!StringHelper.IsNullOrEmpty((String)strCaption)) {
                formCtrlConfig.SetExtValue("CAPTION", strCaption);
            } else if (formCtrlConfig.GetExtValue("SHOWCAPTION", true)) {
                formCtrlConfig.SetValue("CAPTION", iDEFHelper.getLogicName(this.strLanguage));
            }
            boolean bShowCaptionTips = formCtrlConfig.GetExtValue("SHOWCAPTIPS", true);
            if (bShowCaptionTips) {
                String strCaptionTips = formCtrlConfig.GetExtValue("CAPTIPS", iDEFHelper.getInputTips());
                String strCapTipsLanResId = formCtrlConfig.GetExtValue("CAPTIPSLANRESID", "");
                if (!StringHelper.IsNullOrEmpty((String)strCapLanResId)) {
                    strCaptionTips = this.globalHelperEx.getLocalizationHelper().GetLocalization(this.strLanguage, strCapTipsLanResId, strCaptionTips);
                }
                if (!StringHelper.IsNullOrEmpty((String)strCaptionTips)) {
                    formCtrlConfig.SetExtValue("TIPS", strCaptionTips);
                }
            }
            BaseFormCtrlWriter.CopyCtrlParams(formCtrlNode, ctrlParams);
        }
        return formCtrlNode;
    }

    protected XMLNode OnGetFormCtrlNode(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        return this.OnGetFormCtrlNode(iDEFHelper, formCtrlConfig, bSearchMode, ctrlParams);
    }

    protected XMLNode OnGetFormCtrlNode(IDEFHelper iDEFHelper, XMLNode formCtrlConfig, boolean bSearchMode, TreeMap<String, String> ctrlParams) {
        return null;
    }

    protected boolean IsAppendFormItemRule() {
        return true;
    }

    public XMLNode GetSearchFormCtrlNode(IDEFHelper iDEFHelper, XMLNode formCtrlConfig, String strFormItemId, String strDataType) {
        TreeMap<String, String> ctrlParams = new TreeMap<String, String>();
        BaseFormCtrlWriter.BuildCtrlParams(ctrlParams, formCtrlConfig, "");
        XMLNode formCtrlNode = this.OnGetFormCtrlNode(iDEFHelper, null, formCtrlConfig, true, ctrlParams);
        if (formCtrlNode != null) {
            if (this.formCtrlHelperConfig != null && this.formCtrlHelperConfig.getPropertiesConfig() != null) {
                for (PropertyConfig propertyConfig : this.formCtrlHelperConfig.getPropertiesConfig()) {
                    if (formCtrlNode.IsContainsKey(propertyConfig.getID())) continue;
                    formCtrlNode.SetValue(propertyConfig.getID(), propertyConfig.getValue());
                }
            }
            XMLNode itemNode = this.OnAppendSearchFormItemNode(iDEFHelper, formCtrlConfig, formCtrlNode, strFormItemId, strDataType);
            formCtrlNode.setID(strFormItemId);
        }
        return formCtrlNode;
    }

    protected XMLNode OnAppendFormItemNode(IDEFHelper iDEFHelper, XMLNode formCtrlConfig, XMLNode ctrlNode) {
        XMLNode formItemNode = BaseFormCtrlWriter.AppendFormItemNode(this.globalHelperEx, iDEFHelper, formCtrlConfig, ctrlNode, this.strLanguage);
        return formItemNode;
    }

    protected XMLNode OnAppendSearchFormItemNode(IDEFHelper iDEFHelper, XMLNode formCtrlConfig, XMLNode ctrlNode, String strFormItemId, String strDataType) {
        String strFIParam;
        Hashtable extAttrs;
        String strAllowEmpty;
        XMLNode itemNode = new XMLNode();
        itemNode.setNodeName("SRFEXFORMITEM");
        ctrlNode.AddNode(itemNode);
        itemNode.SetValue("DATATYPE", strDataType);
        if (StringHelper.Compare((String)strDataType, (String)"VARCHAR", (boolean)true) == 0) {
            itemNode.SetValue("MAXLENGTH", "65535");
        }
        if (StringHelper.IsNullOrEmpty((String)(strAllowEmpty = formCtrlConfig.GetExtValue("ALLOWEMPTY", "")))) {
            strAllowEmpty = "TRUE";
        }
        if (!StringHelper.IsNullOrEmpty((String)strAllowEmpty)) {
            formCtrlConfig.SetValue("ALLOWEMPTY", strAllowEmpty);
            itemNode.SetValue("ALLOWEMPTY", strAllowEmpty);
        }
        if (iDEFHelper.IsEnableDEFieldPriv()) {
            itemNode.SetValue("PRIVILEGEID", StringHelper.Format((String)"%1$s|%2$s", (Object)iDEFHelper.getDEHelper().getId(), (Object)iDEFHelper.getId()));
        }
        if ((extAttrs = formCtrlConfig.getExtAttrs()) != null) {
            Enumeration en = extAttrs.keys();
            while (en.hasMoreElements()) {
                String strKey = (String)en.nextElement();
                if (StringHelper.Compare((String)"FI_EXTPARAMS", (String)strKey, (boolean)true) == 0 || (strKey = strKey.toUpperCase()).indexOf(TAG_SRFFI) != 0) continue;
                String strValue = formCtrlConfig.GetExtValue(strKey, "");
                strKey = strKey.replace(TAG_SRFFI, "");
                itemNode.SetValue(strKey, strValue);
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)(strFIParam = formCtrlConfig.GetExtValue(TAG_FIEXTPARAMS, "")))) {
            try {
                Properties properties = new Properties();
                properties.load(new StringReader(strFIParam));
                Enumeration<Object> en = properties.keys();
                while (en.hasMoreElements()) {
                    String strKey = (String)en.nextElement();
                    String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                    itemNode.SetValue(strKey, strValue);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return itemNode;
    }

    protected static XMLNode AppendFormItemNode(GlobalHelperEx globalHelperEx, IDEFHelper iDEFHelper, XMLNode formCtrlConfig, XMLNode ctrlNode, String strLanguage) {
        IDEMAFieldHelper iDEMAFieldHelper = null;
        try {
            iDEMAFieldHelper = BaseFormCtrlWriter.GetDEMAField(iDEFHelper, formCtrlConfig);
        }
        catch (Exception e) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u4e3b\u64cd\u4f5c\u5c5e\u6027\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()));
            return null;
        }
        return BaseFormCtrlWriter.AppendFormItemNode(globalHelperEx, iDEFHelper, iDEMAFieldHelper, formCtrlConfig, ctrlNode, strLanguage);
    }

    protected static XMLNode AppendFormItemNode(GlobalHelperEx globalHelperEx, IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig, XMLNode ctrlNode, String strLanguage) {
        String strValidCond;
        String strFIParam;
        Hashtable extAttrs;
        String strAllowEmptyCond;
        boolean bEnableFormUpdate;
        String strAllowEmpty;
        String strCapLanResId;
        XMLNode itemNode = new XMLNode();
        itemNode.setNodeName("SRFEXFORMITEM");
        ctrlNode.AddNode(itemNode);
        IDEFFormCtrl iFormCtrl = iDEFHelper.GetFormCtrl();
        String strCaption = formCtrlConfig.GetExtValue("CAPTION", "");
        if (!StringHelper.IsNullOrEmpty((String)strCaption) && !StringHelper.IsNullOrEmpty((String)(strCapLanResId = formCtrlConfig.GetExtValue("CAPLANRESID", "")))) {
            strCaption = globalHelperEx.getLocalizationHelper().GetLocalization(strLanguage, strCapLanResId, strCaption);
        }
        if (StringHelper.IsNullOrEmpty((String)strCaption)) {
            strCaption = iDEFHelper.getLogicName(strLanguage);
        }
        itemNode.SetValue("NAME", strCaption);
        itemNode.SetValue("DATATYPE", iDEFHelper.GetStdDataType());
        if (iDEFHelper.GetPrecision() >= 0) {
            itemNode.SetValue("PRECISION", StringHelper.Format((String)"%1$s", (Object)iDEFHelper.GetPrecision()));
        }
        if (iDEFHelper.IsEnableDEFieldPriv()) {
            itemNode.SetValue("PRIVILEGEID", StringHelper.Format((String)"%1$s|%2$s", (Object)iDEFHelper.getDEHelper().getId(), (Object)iDEFHelper.getId()));
        }
        if (!StringHelper.IsNullOrEmpty((String)iDEFHelper.GetStringCase())) {
            itemNode.SetValue("STRINGCASE", iDEFHelper.GetStringCase());
        }
        if (StringHelper.IsNullOrEmpty((String)(strAllowEmpty = formCtrlConfig.GetExtValue("ALLOWEMPTY", ""))) && iFormCtrl != null) {
            strAllowEmpty = iFormCtrl.IsAllowEmpty() ? "TRUE" : "FALSE";
        }
        if (!StringHelper.IsNullOrEmpty((String)strAllowEmpty)) {
            formCtrlConfig.SetValue("ALLOWEMPTY", strAllowEmpty);
            itemNode.SetValue("ALLOWEMPTY", strAllowEmpty);
        }
        boolean bEnableFormCreate = iFormCtrl.IsEnableFormCreate();
        boolean bl = bEnableFormUpdate = iDEMAFieldHelper != null ? iDEMAFieldHelper.isEnableModify() : iFormCtrl.IsEnableFormUpdate();
        if (iFormCtrl != null) {
            if (iFormCtrl.IsKey()) {
                itemNode.SetValue("KEY", "TRUE");
            }
            if (!bEnableFormCreate || !bEnableFormUpdate) {
                if (bEnableFormCreate) {
                    itemNode.SetValue("ENABLECOND", "CREATE");
                } else if (bEnableFormUpdate) {
                    itemNode.SetValue("ENABLECOND", "UPDATE");
                } else {
                    itemNode.SetValue("ENABLECOND", "NONE");
                }
            }
            itemNode.SetValue("ITEMFORMAT", iFormCtrl.GetItemFormat());
        }
        if (!StringHelper.IsNullOrEmpty((String)(strAllowEmptyCond = formCtrlConfig.GetExtValue("ALLOWEMPTYCOND2", "")))) {
            itemNode.SetValue("ALLOWEMPTYCOND", strAllowEmptyCond);
        }
        if ((extAttrs = formCtrlConfig.getExtAttrs()) != null) {
            Enumeration en = extAttrs.keys();
            while (en.hasMoreElements()) {
                String strKey = (String)en.nextElement();
                if (StringHelper.Compare((String)"FI_EXTPARAMS", (String)strKey, (boolean)true) == 0 || (strKey = strKey.toUpperCase()).indexOf(TAG_SRFFI) != 0) continue;
                String strValue = formCtrlConfig.GetExtValue(strKey, "");
                strKey = strKey.replace(TAG_SRFFI, "");
                itemNode.SetValue(strKey, strValue);
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)(strFIParam = formCtrlConfig.GetExtValue(TAG_FIEXTPARAMS, "")))) {
            try {
                Properties properties = PropertiesHelper.Load((String)strFIParam);
                Enumeration<Object> en = properties.keys();
                while (en.hasMoreElements()) {
                    String strKey = (String)en.nextElement();
                    String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                    itemNode.SetValue(strKey, strValue);
                }
            }
            catch (Exception properties) {
                // empty catch block
            }
        }
        if (StringHelper.IsNullOrEmpty((String)(strValidCond = formCtrlConfig.GetExtValue("VALIDCOND", "")))) {
            strValidCond = itemNode.GetExtValue("ENABLECOND", "");
        }
        itemNode.SetValue("VALIDCOND", strValidCond);
        return itemNode;
    }

    protected void OnAppendFormItemValueRule(IDEFHelper iDEFHelper, XMLNode formCtrlConfig, XMLNode ctrlNode, XMLNode formItemNode) {
        ValueRuleConfig valueRuleConfig;
        IDEFFormCtrl iFormCtrl = iDEFHelper.GetFormCtrl();
        if (iFormCtrl != null && iFormCtrl.GetStringLengthRule() > 0) {
            BaseFormCtrlWriter.SetStringLengthRule(formItemNode, iFormCtrl.GetStringLengthRule());
        }
        String strValueRule = formCtrlConfig.GetExtValue("VALUERULE", "");
        String strCustomValueRule = formCtrlConfig.GetExtValue("CUSTOMVALUERULE", "");
        String strValueRuleInfo = formCtrlConfig.GetExtValue("VALUERULEINFO", "");
        String strValueRuleCode = "";
        if (!StringHelper.IsNullOrEmpty((String)strCustomValueRule)) {
            strValueRuleCode = strCustomValueRule;
        } else if (!StringHelper.IsNullOrEmpty((String)strValueRule)) {
            valueRuleConfig = this.globalHelperEx.getDAConfigMgr().getValueRuleMgr().FindRuleConfig(strValueRule);
            if (valueRuleConfig == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9884\u5b9a\u4e49\u503c\u89c4\u5219[%1$s]", (Object)strValueRule));
            } else {
                strValueRuleCode = valueRuleConfig.getRule();
            }
        } else {
            strValueRuleCode = iDEFHelper.GetValueRule();
        }
        if (!StringHelper.IsNullOrEmpty((String)strValueRuleCode)) {
            strValueRuleCode = StringHelper.Format((String)strValueRuleCode, (Object)iDEFHelper.getName());
            formItemNode.SetValue("VALUERULECODE", strValueRuleCode);
        }
        if (StringHelper.IsNullOrEmpty((String)strValueRuleInfo)) {
            if (!StringHelper.IsNullOrEmpty((String)strValueRule)) {
                valueRuleConfig = this.globalHelperEx.getDAConfigMgr().getValueRuleMgr().FindRuleConfig(strValueRule);
                if (valueRuleConfig == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9884\u5b9a\u4e49\u503c\u89c4\u5219[%1$s]", (Object)strValueRule));
                } else {
                    strValueRuleInfo = valueRuleConfig.getRuleInfo();
                }
            } else {
                strValueRuleInfo = iDEFHelper.GetValueRuleInfo();
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strValueRuleInfo)) {
            strValueRuleInfo = StringHelper.Format((String)strValueRuleInfo, (Object)StringHelper.Format((String)"[%1$s]\u8f93\u5165\u4e0d\u6b63\u786e", (Object)iDEFHelper.getLogicName(this.strLanguage)));
            formItemNode.SetValue("VALUERULEINFO", strValueRuleInfo);
        }
    }

    protected static void SetStringLengthRule(XMLNode itemNode, int nLength) {
        itemNode.SetValue("MAXLENGTH", StringHelper.Format((String)"%1$s", (Object)nLength));
    }

    protected static void CopyCtrlParams(XMLNode ctrlNode, TreeMap<String, String> ctrlParams) {
        if (ctrlParams == null) {
            return;
        }
        for (String strKey : ctrlParams.keySet()) {
            String strValue = ctrlParams.get(strKey);
            ctrlNode.SetValue(strKey, strValue);
        }
    }

    protected static void CopyCtrlParams(XMLNode ctrlNode, TreeMap<String, String> ctrlParams, String strPreFix) {
        if (ctrlParams == null) {
            return;
        }
        for (String strKey : ctrlParams.keySet()) {
            if (strKey.indexOf(strPreFix) != 0) continue;
            String strValue = ctrlParams.get(strKey);
            ctrlNode.SetValue(strKey.substring(strPreFix.length()), strValue);
        }
    }

    protected static void BuildCtrlParams(TreeMap<String, String> ctrlParams, XMLNode formCtrlConfig, String strExtConfig) {
        String strParam;
        if (!StringHelper.IsNullOrEmpty((String)strExtConfig)) {
            try {
                Properties properties = PropertiesHelper.Load((String)strExtConfig);
                Enumeration<Object> en = properties.keys();
                while (en.hasMoreElements()) {
                    String strKey = (String)en.nextElement();
                    String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                    ctrlParams.put(strKey.toUpperCase(), strValue);
                }
            }
            catch (Exception ex) {
                return;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)(strParam = formCtrlConfig.GetExtValue("FI_EXTPARAMS", "")))) {
            try {
                Properties properties = PropertiesHelper.Load((String)strParam);
                Enumeration<Object> en = properties.keys();
                while (en.hasMoreElements()) {
                    String strKey = (String)en.nextElement();
                    String strValue = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
                    ctrlParams.put(strKey.toUpperCase(), strValue);
                }
            }
            catch (Exception ex) {
                return;
            }
        }
        formCtrlConfig.SetValue("FI_EXTPARAMS", "");
    }

    public XMLNode GetDGEditor(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, DGModeDetail dgModeDetail) {
        return this.OnGetDGEditor(iDEFHelper, iDEMAFieldHelper, dgModeDetail);
    }

    protected XMLNode OnGetDGEditor(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, DGModeDetail dgModeDetail) {
        return this.OnGetDGEditor(iDEFHelper, dgModeDetail);
    }

    protected XMLNode OnGetDGEditor(IDEFHelper iDEFHelper, DGModeDetail dgModeDetail) {
        return null;
    }

    protected static String GetCtrlParam(TreeMap<String, String> ctrlParams, String strKey, String strDefault) {
        if (ctrlParams == null) {
            return strDefault;
        }
        if (ctrlParams.containsKey(strKey)) {
            return ctrlParams.get(strKey);
        }
        return strDefault;
    }

    protected static String GetFormCtrlCodeList(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig) {
        String strCodeList = formCtrlConfig.GetExtValue("CODELISTID", "");
        if (StringHelper.IsNullOrEmpty((String)strCodeList)) {
            strCodeList = iDEMAFieldHelper != null ? iDEMAFieldHelper.getCodelistId() : iDEFHelper.GetCodeList();
        }
        return strCodeList;
    }

    protected static String GetFormCtrlCodeListParam(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig) {
        String strCodeListParam = formCtrlConfig.GetExtValue("CODELISTPARAM", "");
        if (StringHelper.IsNullOrEmpty((String)strCodeListParam)) {
            return iDEFHelper.getCodeListParam();
        }
        return strCodeListParam;
    }

    protected String GetFormCtrlCodeList(IDEFHelper iDEFHelper, XMLNode formCtrlConfig) {
        return BaseFormCtrlWriter.GetFormCtrlCodeList(iDEFHelper, null, formCtrlConfig);
    }

    protected static boolean GetFormCtrlAllowEmpty(IDEFHelper iDEFHelper, IDEMAFieldHelper iDEMAFieldHelper, XMLNode formCtrlConfig) {
        String strAllowEmpty = formCtrlConfig.GetExtValue("ALLOWEMPTY", "");
        boolean bAllowEmpty = iDEFHelper.GetFormCtrl().IsAllowEmpty();
        if (!StringHelper.IsNullOrEmpty((String)strAllowEmpty)) {
            bAllowEmpty = StringHelper.Compare((String)strAllowEmpty, (String)"TRUE", (boolean)false) == 0;
        }
        return bAllowEmpty;
    }
}

