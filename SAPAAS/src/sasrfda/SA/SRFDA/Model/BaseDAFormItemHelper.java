/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.Conditions
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Model;

import SA.SRFDA.Common.DAConfigMgr;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.Data.DGModeDetail;
import SA.SRFDA.Ctrl.FormCtrlHelper.IFormCtrlWriter;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFDA.Model.IDAFormItemHelper;
import SA.SRFDA.Model.IDAValueFunc;
import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.DataEx.Conditions;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseDAFormItemHelper
implements IDAFormItemHelper {
    public static final String TAG_SRFEXPICKEREX = "SRFEXPICKEREX";
    public static final String TAG_SRFEXTEXTBOX = "SRFEXTEXTBOX";
    public static final String TAG_SRFEXSPANEX = "SRFEXSPANEX";
    public static final String TAG_SRFEXHIDDEN = "SRFEXHIDDEN";
    public static final String TAG_SRFEXDROPDOWNLIST = "SRFEXDROPDOWNLIST";
    public static final String TAG_SRFEXHTMLEDITOR = "SRFEXHTMLEDITOR";
    public static final String TAG_SRFEXRAW = "SRFEXRAW";
    public static final String TAG_SRFEXDATEPICKEREX = "SRFEXDATEPICKEREX";
    public static final String TAG_SRFEXLISTBOX = "SRFEXLISTBOX";
    public static final String TAG_SRFEXCHECKBOXLIST = "SRFEXCHECKBOXLIST";
    public static final String TAG_SRFEXCHECKBOX = "SRFEXCHECKBOX";
    public static final String TAG_SRFEXRADIOBUTTONLIST = "SRFEXRADIOBUTTONLIST";
    public static final String TAG_SRFEXLISTBOXPICKUP = "SRFEXLISTBOXPICKUP";
    public static final String TAG_SRFEXUSERCONTROL = "SRFEXUSERCONTROL";
    protected GlobalHelperEx contextHelper = null;
    private static final Log log = LogFactory.getLog(BaseDAFormItemHelper.class);
    public static final String TAG_SRFDAAC = "SRFDAAC";
    public static final String TAG_SRFCP = "SRFCP_";
    public static final String TAG_EXTPARAMS = "EXTPARAMS";
    public static final String TAG_DEMAINACTION = "FC_DEMAINACTION";
    protected boolean bSearchTimeItemAppendEndOfDay = false;

    @Override
    public void Init(GlobalHelperEx contextHelper) {
        this.contextHelper = contextHelper;
    }

    public void setSearchTimeItemAppendEndOfDay(boolean bValue) {
        this.bSearchTimeItemAppendEndOfDay = bValue;
    }

    @Override
    public XMLNode GetSearchFormCtrlNode(String strPageModel, String strLanguage, IDEHelper iDEHelper, IDEFHelper iDEFHelper, SearchItemConfig searchItemConfig) {
        XMLNode xmlNode;
        String strFunc = searchItemConfig.getFunc();
        String strDataType = "";
        IDAValueFunc iDAValueFunc = null;
        if (!StringHelper.IsNullOrEmpty((String)strFunc)) {
            iDAValueFunc = this.getDAConfigMgr().getValueFuncMgr().FindFunc(strFunc);
            if (iDAValueFunc == null) {
                return null;
            }
            strDataType = iDAValueFunc.GetDataType();
        } else {
            strDataType = iDEFHelper.GetStdDataType();
        }
        boolean bAppendEmptyCodeListItem = true;
        if (StringHelper.Compare((String)searchItemConfig.getAction(), (String)"IN", (boolean)true) == 0 || StringHelper.Compare((String)searchItemConfig.getAction(), (String)"NOTIN", (boolean)true) == 0) {
            if (StringHelper.IsNullOrEmpty((String)searchItemConfig.getFormItem())) {
                if (iDEFHelper instanceof IPickupDEFHelper) {
                    searchItemConfig.setFormItem("SRFEXMULTIPICKER");
                } else if (!StringHelper.IsNullOrEmpty((String)iDEFHelper.GetCodeList())) {
                    searchItemConfig.setFormItem(TAG_SRFEXCHECKBOXLIST);
                } else {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u81ea\u52a8\u8ba1\u7b97\u641c\u7d22\u9879[%1$s:%2$s]\u8868\u73b0\u6837\u5f0f", (Object)iDEFHelper.getName(), (Object)searchItemConfig.getAction()));
                    return null;
                }
            }
            strDataType = "VARCHAR";
            bAppendEmptyCodeListItem = false;
        }
        boolean bTestNull = false;
        if (StringHelper.Compare((String)searchItemConfig.getAction(), (String)"TESTNULL", (boolean)true) == 0) {
            bTestNull = true;
            if (StringHelper.IsNullOrEmpty((String)searchItemConfig.getFormItem())) {
                searchItemConfig.setFormItem(TAG_SRFEXDROPDOWNLIST);
            }
            strDataType = "INT";
        }
        String strFormItemId = this.GetSearchFormItemId(iDEFHelper, searchItemConfig);
        XMLNode dpFormItemNode = new XMLNode();
        dpFormItemNode.setNodeName("SRFEXDPFORMITEM");
        dpFormItemNode.SetValue("ALLOWEMPTY", "TRUE");
        if (StringHelper.IsNullOrEmpty((String)searchItemConfig.getCaption())) {
            dpFormItemNode.SetValue("CAPTION", this.GetSearchItemCaption(strLanguage, iDAValueFunc, iDEFHelper, searchItemConfig));
        } else {
            dpFormItemNode.SetValue("CAPTION", searchItemConfig.getCaption());
        }
        XMLNode formCtrlNode = this.GetSearchFormCtrlNode(strPageModel, strLanguage, dpFormItemNode, iDEHelper, strFormItemId, iDEFHelper, iDAValueFunc, strDataType, searchItemConfig.getFormItem(), searchItemConfig.getFormItemParam(), null);
        if (formCtrlNode != null) {
            formCtrlNode.setID(strFormItemId);
            dpFormItemNode.AddNode(formCtrlNode);
            String strFormItemParam = searchItemConfig.getFormItemParam();
            String strFormItemParams = searchItemConfig.getFormItemParams();
            String strCtrlParams = searchItemConfig.getCtrlParams();
            ArrayList childNodes = new ArrayList();
            formCtrlNode.GetChildNodeByNodeName("SRFEXLISTFILLER", childNodes);
            for (XMLNode child : childNodes) {
                if (bAppendEmptyCodeListItem) {
                    child.SetValue("EMPTYSUPPORTED", "TRUE");
                    child.SetValue("EMPTYATFIRST", "TRUE");
                    child.SetValue("EMPTYTEXT", this.contextHelper.getLocalizationHelper().GetLocalization(strLanguage, "CONTROL.SPEXITEM.EMPTYTEXT", "(\u672a\u6307\u5b9a)"));
                }
                if (bTestNull) {
                    child.SetValue("RAWCODELIST", "");
                    child.SetValue("CODELIST", "SRFDA.CODELIST_YESNO");
                    continue;
                }
                if (StringHelper.IsNullOrEmpty((String)strFormItemParam) || StringHelper.IsNullOrEmpty((String)searchItemConfig.getFormItem())) continue;
                child.SetValue("CODELIST", "");
                child.SetValue("RAWCODELIST", strFormItemParam);
            }
            if (!StringHelper.IsNullOrEmpty((String)strCtrlParams)) {
                String[] parts = strCtrlParams.split("[;]");
                int i = 0;
                while (i < parts.length) {
                    String[] part2 = parts[i].split("[=]");
                    if (part2.length == 2) {
                        formCtrlNode.SetValue(part2[0], part2[1]);
                    }
                    ++i;
                }
            }
            if (!StringHelper.IsNullOrEmpty((String)strFormItemParams)) {
                XMLNode itemNode = formCtrlNode.GetChildNodeByNodeName("SRFEXFORMITEM");
                String[] parts = strFormItemParams.split("[;]");
                int i = 0;
                while (i < parts.length) {
                    String[] part2 = parts[i].split("[=]");
                    if (part2.length == 2) {
                        itemNode.SetValue(part2[0], part2[1]);
                    }
                    ++i;
                }
            }
        }
        if (!(!this.bSearchTimeItemAppendEndOfDay || StringHelper.Compare((String)strDataType, (String)"DATE", (boolean)true) != 0 && StringHelper.Compare((String)strDataType, (String)"DATETIME", (boolean)true) != 0 || StringHelper.Compare((String)searchItemConfig.getAction(), (String)"<", (boolean)true) != 0 && StringHelper.Compare((String)searchItemConfig.getAction(), (String)"<=", (boolean)true) != 0 || (xmlNode = formCtrlNode.GetChildNodeByNodeName("SRFEXFORMITEM")) == null || xmlNode.getExtAttrs() != null && xmlNode.getExtAttrs().containsKey("ENDOFDAY"))) {
            xmlNode.SetExtValue("ENDOFDAY", "TRUE");
        }
        return dpFormItemNode;
    }

    @Override
    public XMLNode GetSearchFormCtrlNode(String strPageModel, String strLanguage, IDEHelper iDEHelper, IDEFHelper iDEFHelper, SearchItemConfig searchItemConfig, XMLNode formCtrlConfig) {
        XMLNode xmlNode;
        XMLNode formCtrlNode;
        String strFunc = searchItemConfig.getFunc();
        String strDataType = "";
        IDAValueFunc iDAValueFunc = null;
        if (!StringHelper.IsNullOrEmpty((String)strFunc)) {
            iDAValueFunc = this.getDAConfigMgr().getValueFuncMgr().FindFunc(strFunc);
            if (iDAValueFunc == null) {
                return null;
            }
            strDataType = iDAValueFunc.GetDataType();
        } else {
            strDataType = iDEFHelper.GetStdDataType();
        }
        boolean bAppendEmptyCodeListItem = true;
        if (StringHelper.Compare((String)searchItemConfig.getAction(), (String)"IN", (boolean)true) == 0 || StringHelper.Compare((String)searchItemConfig.getAction(), (String)"NOTIN", (boolean)true) == 0) {
            if (StringHelper.IsNullOrEmpty((String)searchItemConfig.getFormItem())) {
                if (iDEFHelper instanceof IPickupDEFHelper) {
                    searchItemConfig.setFormItem("SRFEXMULTIPICKER");
                } else if (!StringHelper.IsNullOrEmpty((String)iDEFHelper.GetCodeList())) {
                    searchItemConfig.setFormItem(TAG_SRFEXCHECKBOXLIST);
                } else {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u81ea\u52a8\u8ba1\u7b97\u641c\u7d22\u9879[%1$s:%2$s]\u8868\u73b0\u6837\u5f0f", (Object)iDEFHelper.getName(), (Object)searchItemConfig.getAction()));
                    return null;
                }
            }
            strDataType = "VARCHAR";
            bAppendEmptyCodeListItem = false;
        }
        boolean bTestNull = false;
        if (StringHelper.Compare((String)searchItemConfig.getAction(), (String)"TESTNULL", (boolean)true) == 0) {
            bTestNull = true;
            if (StringHelper.IsNullOrEmpty((String)searchItemConfig.getFormItem())) {
                searchItemConfig.setFormItem(TAG_SRFEXDROPDOWNLIST);
            }
            strDataType = "INT";
        }
        String strFormItemId = this.GetSearchFormItemId(iDEFHelper, searchItemConfig);
        boolean bShowCaption = true;
        boolean bAllowEmpty = true;
        String strFormItemStyle = "";
        String strCaption = "";
        String strFormParam = "";
        if (formCtrlConfig != null) {
            String strCapLanResId;
            strCaption = formCtrlConfig.GetExtValue("CAPTION", "");
            bShowCaption = formCtrlConfig.GetExtValue("SHOWCAPTION", true);
            bAllowEmpty = formCtrlConfig.GetExtValue("ALLOWEMPTY", true);
            strFormItemStyle = formCtrlConfig.GetExtValue("FC_FORMITEMSTYLE", "");
            strFormParam = formCtrlConfig.GetExtValue("FI_EXTPARAMS", "");
            if (!StringHelper.IsNullOrEmpty((String)strCaption) && !StringHelper.IsNullOrEmpty((String)(strCapLanResId = formCtrlConfig.GetExtValue("CAPLANRESID", "")))) {
                strCaption = this.contextHelper.getLocalizationHelper().GetLocalization(strLanguage, strCapLanResId, strCaption);
            }
        }
        if (StringHelper.IsNullOrEmpty((String)strCaption) && bShowCaption) {
            strCaption = StringHelper.IsNullOrEmpty((String)searchItemConfig.getCaption()) ? this.GetSearchItemCaption(strLanguage, iDAValueFunc, iDEFHelper, searchItemConfig) : searchItemConfig.getCaption();
        }
        if (StringHelper.IsNullOrEmpty((String)strFormItemStyle)) {
            strFormItemStyle = searchItemConfig.getFormItem();
        }
        if ((formCtrlNode = this.GetSearchFormCtrlNode(strPageModel, strLanguage, formCtrlConfig, iDEHelper, strFormItemId, iDEFHelper, iDAValueFunc, strDataType, strFormItemStyle, searchItemConfig.getFormItemParam(), null)) != null) {
            formCtrlConfig.SetValue("CAPTION", strCaption);
            formCtrlNode.setID(strFormItemId);
            String strFormItemParams = searchItemConfig.getFormItemParam();
            ArrayList childNodes = new ArrayList();
            formCtrlNode.GetChildNodeByNodeName("SRFEXLISTFILLER", childNodes);
            for (XMLNode child : childNodes) {
                if (bAllowEmpty && bAppendEmptyCodeListItem) {
                    String strEmptySupported = "TRUE";
                    String strEmptyAtFirst = "TRUE";
                    String strEmptyText = this.contextHelper.getLocalizationHelper().GetLocalization(strLanguage, "CONTROL.SPEXITEM.EMPTYTEXT", "(\u672a\u6307\u5b9a)");
                    try {
                        if (!StringHelper.IsNullOrEmpty((String)strFormParam)) {
                            Properties properties = PropertiesHelper.Load((String)strFormParam);
                            strEmptySupported = PropertiesHelper.GetProperty((Properties)properties, (String)"LISTFILLER.EMPTYSUPPORTED", (String)strEmptySupported);
                            strEmptyAtFirst = PropertiesHelper.GetProperty((Properties)properties, (String)"LISTFILLER.EMPTYATFIRST", (String)strEmptyAtFirst);
                            String strEmptyTextKey = "LISTFILLER.EMPTYTEXT";
                            if (!StringHelper.IsNullOrEmpty((String)strLanguage)) {
                                strEmptyTextKey = String.valueOf(strEmptyTextKey) + "." + strLanguage;
                            }
                            strEmptyText = PropertiesHelper.GetProperty((Properties)properties, (String)strEmptyTextKey, (String)strEmptyText);
                        }
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    child.SetValue("EMPTYSUPPORTED", strEmptySupported);
                    child.SetValue("EMPTYATFIRST", strEmptyAtFirst);
                    child.SetValue("EMPTYTEXT", strEmptyText);
                }
                if (bTestNull) {
                    child.SetValue("RAWCODELIST", "");
                    child.SetValue("CODELIST", "SRFDA.CODELIST_YESNO");
                    continue;
                }
                if (StringHelper.IsNullOrEmpty((String)strFormItemParams) || StringHelper.IsNullOrEmpty((String)strFormItemStyle)) continue;
                child.SetValue("CODELIST", "");
                child.SetValue("RAWCODELIST", strFormItemParams);
            }
        }
        if (!(!this.bSearchTimeItemAppendEndOfDay || StringHelper.Compare((String)strDataType, (String)"DATE", (boolean)true) != 0 && StringHelper.Compare((String)strDataType, (String)"DATETIME", (boolean)true) != 0 || StringHelper.Compare((String)searchItemConfig.getAction(), (String)"<", (boolean)true) != 0 && StringHelper.Compare((String)searchItemConfig.getAction(), (String)"<=", (boolean)true) != 0 || (xmlNode = formCtrlNode.GetChildNodeByNodeName("SRFEXFORMITEM")) == null || xmlNode.getExtAttrs() != null && xmlNode.getExtAttrs().containsKey("ENDOFDAY"))) {
            xmlNode.SetExtValue("ENDOFDAY", "TRUE");
        }
        return formCtrlNode;
    }

    protected String GetSearchItemCaption(String strLanguage, IDAValueFunc iDAValueFunc, IDEFHelper iDEFHelper, SearchItemConfig searchItemConfig) {
        if (iDAValueFunc != null) {
            return StringHelper.Format((String)"%1$s[%3$s](%2$s)", (Object)iDEFHelper.getLogicName(strLanguage), (Object)Conditions.GetConditionLogicName((ISRFExGlobalHelper)this.contextHelper, (String)strLanguage, (String)searchItemConfig.getAction()), (Object)iDAValueFunc.getValueFuncConfig().getLogicName());
        }
        return StringHelper.Format((String)"%1$s(%2$s)", (Object)iDEFHelper.getLogicName(strLanguage), (Object)Conditions.GetConditionLogicName((ISRFExGlobalHelper)this.contextHelper, (String)strLanguage, (String)searchItemConfig.getAction()));
    }

    @Override
    public String GetSearchFormItemId(IDEFHelper iDEFHelper, SearchItemConfig searchItemConfig) {
        String strFunc = searchItemConfig.getFunc();
        String strFormItemId = "";
        strFormItemId = !StringHelper.IsNullOrEmpty((String)strFunc) ? StringHelper.Format((String)"F_%1$s_%2$s_%3$s", (Object)iDEFHelper.GetFormCtrl().GetFormCtrlId(), (Object)strFunc, (Object)Conditions.GetConditionName((String)searchItemConfig.getAction())) : StringHelper.Format((String)"N_%1$s_%2$s", (Object)iDEFHelper.GetFormCtrl().GetFormCtrlId(), (Object)Conditions.GetConditionName((String)searchItemConfig.getAction()));
        return strFormItemId;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected XMLNode GetSearchFormCtrlNode(String strPageModel, String strLanguage, XMLNode dpFormItemNode, IDEHelper iDEHelper, String strFormItemId, IDEFHelper iDEFHelper, IDAValueFunc iDAValueFunc, String strDataType, String strFormItemStyle, String strFormItemParam, XMLNode exFormItemConfig) {
        IFormCtrlWriter iFormCtrlWriter;
        block20: {
            if (iDAValueFunc == null) {
                if (StringHelper.IsNullOrEmpty((String)strFormItemStyle)) {
                    if (iDEFHelper instanceof IPickupDEFHelper) {
                        IFormCtrlWriter iFormCtrlWriter2 = this.contextHelper.getDAConfigMgr().getFormCtrlWriterMgr().FindFormCtrlWriter(TAG_SRFEXPICKEREX, strPageModel, strLanguage);
                        if (iFormCtrlWriter2 == null) {
                            return null;
                        }
                        return iFormCtrlWriter2.GetSearchFormCtrlNode(iDEFHelper, dpFormItemNode, strFormItemId, strDataType);
                    }
                    if (!StringHelper.IsNullOrEmpty((String)iDEFHelper.GetCodeList())) {
                        IFormCtrlWriter iFormCtrlWriter3 = this.contextHelper.getDAConfigMgr().getFormCtrlWriterMgr().FindFormCtrlWriter(TAG_SRFEXDROPDOWNLIST, strPageModel, strLanguage);
                        if (iFormCtrlWriter3 == null) {
                            return null;
                        }
                        return iFormCtrlWriter3.GetSearchFormCtrlNode(iDEFHelper, dpFormItemNode, strFormItemId, strDataType);
                    }
                    if (StringHelper.Compare((String)strDataType, (String)"DATE", (boolean)true) == 0) {
                        IFormCtrlWriter iFormCtrlWriter4 = this.contextHelper.getDAConfigMgr().getFormCtrlWriterMgr().FindFormCtrlWriter(TAG_SRFEXDATEPICKEREX, strPageModel, strLanguage);
                        if (iFormCtrlWriter4 == null) {
                            return null;
                        }
                        return iFormCtrlWriter4.GetSearchFormCtrlNode(iDEFHelper, dpFormItemNode, strFormItemId, strDataType);
                    }
                    if (StringHelper.Compare((String)strDataType, (String)"DATETIME", (boolean)true) == 0) {
                        IFormCtrlWriter iFormCtrlWriter5 = this.contextHelper.getDAConfigMgr().getFormCtrlWriterMgr().FindFormCtrlWriter(TAG_SRFEXDATEPICKEREX, strPageModel, strLanguage);
                        if (iFormCtrlWriter5 == null) {
                            return null;
                        }
                        return iFormCtrlWriter5.GetSearchFormCtrlNode(iDEFHelper, dpFormItemNode, strFormItemId, strDataType);
                    }
                    break block20;
                } else {
                    IFormCtrlWriter iFormCtrlWriter6 = this.contextHelper.getDAConfigMgr().getFormCtrlWriterMgr().FindFormCtrlWriter(strFormItemStyle, strPageModel, strLanguage);
                    if (iFormCtrlWriter6 == null) {
                        return null;
                    }
                    return iFormCtrlWriter6.GetSearchFormCtrlNode(iDEFHelper, dpFormItemNode, strFormItemId, strDataType);
                }
            }
            if (StringHelper.IsNullOrEmpty((String)strFormItemStyle)) {
                if (StringHelper.Compare((String)strDataType, (String)"DATE", (boolean)true) == 0) {
                    IFormCtrlWriter iFormCtrlWriter7 = this.contextHelper.getDAConfigMgr().getFormCtrlWriterMgr().FindFormCtrlWriter(TAG_SRFEXDATEPICKEREX, strPageModel, strLanguage);
                    if (iFormCtrlWriter7 == null) {
                        return null;
                    }
                    return iFormCtrlWriter7.GetSearchFormCtrlNode(iDEFHelper, dpFormItemNode, strFormItemId, strDataType);
                }
                if (StringHelper.Compare((String)strDataType, (String)"DATETIME", (boolean)true) == 0) {
                    IFormCtrlWriter iFormCtrlWriter8 = this.contextHelper.getDAConfigMgr().getFormCtrlWriterMgr().FindFormCtrlWriter("SRFEXDATEPICKEREX_SECOND", strPageModel, strLanguage);
                    if (iFormCtrlWriter8 == null) {
                        return null;
                    }
                    return iFormCtrlWriter8.GetSearchFormCtrlNode(iDEFHelper, dpFormItemNode, strFormItemId, strDataType);
                }
            } else {
                IFormCtrlWriter iFormCtrlWriter9 = this.contextHelper.getDAConfigMgr().getFormCtrlWriterMgr().FindFormCtrlWriter(strFormItemStyle, strPageModel, strLanguage);
                if (iFormCtrlWriter9 == null) {
                    return null;
                }
                return iFormCtrlWriter9.GetSearchFormCtrlNode(iDEFHelper, dpFormItemNode, strFormItemId, strDataType);
            }
        }
        if ((iFormCtrlWriter = this.contextHelper.getDAConfigMgr().getFormCtrlWriterMgr().FindFormCtrlWriter(TAG_SRFEXTEXTBOX, strPageModel, strLanguage)) == null) {
            return null;
        }
        return iFormCtrlWriter.GetSearchFormCtrlNode(iDEFHelper, dpFormItemNode, strFormItemId, strDataType);
    }

    protected XMLNode GetSearchTextBoxNode(String strLanguage, XMLNode dpFormItemNode, IDEHelper iDEHelper, String strFormItemId, IDEFHelper iDEFHelper, String strDataType, XMLNode exFormItemConfig) {
        XMLNode ctrlNode = new XMLNode();
        ctrlNode.setNodeName(TAG_SRFEXTEXTBOX);
        BaseDAFormItemHelper.AppendSearchFormItemNode(dpFormItemNode, strFormItemId, ctrlNode, strDataType);
        return ctrlNode;
    }

    @Override
    public XMLNode GetFormCtrlNode(String strPageModel, String strLanguage, IDEHelper iDEHelper, IDEFHelper iDEFHelper, XMLNode formCtrlConfig) {
        XMLNode formCtrlNode = this.InternalGetFormCtrlNode(strPageModel, strLanguage, iDEHelper, iDEFHelper, formCtrlConfig);
        if (formCtrlNode != null) {
            String strUnit;
            formCtrlNode.setID(iDEFHelper.getName());
            String strCaption = formCtrlConfig.GetExtValue("CAPTION", "");
            if (StringHelper.IsNullOrEmpty((String)strCaption) && formCtrlConfig.GetExtValue("SHOWCAPTION", true)) {
                formCtrlConfig.SetValue("CAPTION", iDEFHelper.getLogicName(strLanguage));
            }
            if (StringHelper.IsNullOrEmpty((String)(strUnit = formCtrlConfig.GetExtValue("UNIT", "")))) {
                strUnit = iDEFHelper.GetUnit();
            }
            if (!StringHelper.IsNullOrEmpty((String)strUnit)) {
                formCtrlConfig.SetValue("UNIT", strUnit);
                int nWidth = formCtrlConfig.GetExtValue("UNITWIDTH", 0);
                if (nWidth == 0) {
                    nWidth = iDEFHelper.GetUnitWidth();
                }
                if (nWidth != 0) {
                    formCtrlConfig.SetValue("UNITWIDTH", StringHelper.Format((String)"%1$s", (Object)nWidth));
                }
            }
        }
        return formCtrlNode;
    }

    protected XMLNode InternalGetFormCtrlNode(String strPageModel, String strLanguage, IDEHelper iDEHelper, IDEFHelper iDEFHelper, XMLNode formCtrlConfig) {
        IFormCtrlWriter iFormCtrlWriter;
        IDEMAFieldHelper iDEMAFieldHelper = null;
        try {
            iDEMAFieldHelper = BaseDAFormItemHelper.GetDEMAField(iDEFHelper, formCtrlConfig);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u4e3b\u64cd\u4f5c\u5c5e\u6027[%1$s]\u6269\u5c55\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)iDEFHelper.getName(), (Object)ex.getMessage()), (Throwable)ex);
            return null;
        }
        String strFormItemStyle = formCtrlConfig.GetExtValue("FC_FORMITEMSTYLE", "");
        if (StringHelper.IsNullOrEmpty((String)strFormItemStyle)) {
            strFormItemStyle = iDEMAFieldHelper != null ? iDEMAFieldHelper.getFormItemStyle() : iDEFHelper.GetFormItemStyle();
        }
        if ((iFormCtrlWriter = this.contextHelper.getDAConfigMgr().getFormCtrlWriterMgr().FindFormCtrlWriter(strFormItemStyle, strPageModel, strLanguage)) == null) {
            return null;
        }
        return iFormCtrlWriter.GetFormCtrlNode(iDEFHelper, iDEMAFieldHelper, formCtrlConfig);
    }

    protected static XMLNode AppendSearchFormItemNode(XMLNode dpFormItemNode, String strFormItemId, XMLNode ctrlNode, String strDataType) {
        XMLNode itemNode = new XMLNode();
        itemNode.setNodeName("SRFEXFORMITEM");
        ctrlNode.AddNode(itemNode);
        itemNode.SetValue("DATATYPE", strDataType);
        String strAllowEmpty = "TRUE";
        itemNode.SetValue("ALLOWEMPTY", strAllowEmpty);
        itemNode.SetValue("KEY", "FALSE");
        return itemNode;
    }

    public DAConfigMgr getDAConfigMgr() {
        return (DAConfigMgr)((Object)this.contextHelper.getServletContext().getAttribute("SRFDACONFIGMGR"));
    }

    protected static XMLNode AppendListFillterNode(XMLNode formItemNode, DEField field, XMLNode ctrlNode, String strCodeList, boolean bAllowEmpty) {
        XMLNode listFillerNode = new XMLNode();
        listFillerNode.setNodeName("SRFEXLISTFILLER");
        ctrlNode.AddNode(listFillerNode);
        listFillerNode.SetValue("CODELIST", strCodeList);
        if (bAllowEmpty) {
            listFillerNode.SetValue("EMPTYSUPPORTED", "TRUE");
            listFillerNode.SetValue("EMPTYATFIRST", "TRUE");
            listFillerNode.SetValue("EMPTYTEXT", "");
        }
        return listFillerNode;
    }

    @Override
    public XMLNode GetDGEditorNode(String strPageModel, String strLanguage, IDEHelper iDEHelper, IDEFHelper iDEFHelper, DGModeDetail dgModeDetail) {
        XMLNode dgEditorNode = this.InternalGetDGEditorNode(strPageModel, strLanguage, iDEHelper, iDEFHelper, dgModeDetail);
        return dgEditorNode;
    }

    protected XMLNode InternalGetDGEditorNode(String strPageModel, String strLanguage, IDEHelper iDEHelper, IDEFHelper iDEFHelper, DGModeDetail dgModeDetail) {
        IDEMAFieldHelper iDEMAFieldHelper = null;
        String strFormItemStyle = iDEFHelper.getDGItem().GetEditorStyle(dgModeDetail);
        IFormCtrlWriter iFormCtrlWriter = this.contextHelper.getDAConfigMgr().getFormCtrlWriterMgr().FindFormCtrlWriter(strFormItemStyle, strPageModel, strLanguage);
        if (iFormCtrlWriter == null) {
            return null;
        }
        return iFormCtrlWriter.GetDGEditor(iDEFHelper, iDEMAFieldHelper, dgModeDetail);
    }

    protected static IDEMAFieldHelper GetDEMAField(IDEFHelper iDEFHelper, XMLNode formCtrlConfig) throws Exception {
        String strDEMainAction = formCtrlConfig.GetExtValue(TAG_DEMAINACTION, "");
        if (StringHelper.IsNullOrEmpty((String)strDEMainAction)) {
            return null;
        }
        return iDEFHelper.getDEHelper().FindDEMainAction(strDEMainAction).FindDEMAField(iDEFHelper.getId());
    }
}

