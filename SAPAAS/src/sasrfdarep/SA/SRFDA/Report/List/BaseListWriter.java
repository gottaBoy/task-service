/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Report.List.ListColumnConfig
 *  SA.SRFDA.Report.List.ListConfig
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.WebUtility
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Report.List;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Report.List.IListCell;
import SA.SRFDA.Report.List.ListColumnConfig;
import SA.SRFDA.Report.List.ListConfig;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.WebUtility;
import java.util.TreeMap;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseListWriter {
    private static final Log log = LogFactory.getLog(BaseListWriter.class);
    protected TreeMap<String, IListCell> customObjects = new TreeMap();

    public String Export(IDEHelper iDEHelper, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalContext, ListConfig listConfig, DataTable dataTable) {
        return this.OnExport(iDEHelper, webContext, globalContext, listConfig, dataTable);
    }

    protected String OnExport(IDEHelper iDEHelper, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalContext, ListConfig listConfig, DataTable dataTable) {
        int nRowCount;
        StringBuilderEx html = new StringBuilderEx();
        this.AppendTableStartTag(html, webContext, globalContext, listConfig);
        if (!listConfig.isHideHeader()) {
            this.AppendTableHeader(html, webContext, globalContext, listConfig);
        }
        if ((nRowCount = dataTable.GetRowCount()) == 0) {
            this.AppendEmptyMsg(html, webContext, globalContext, listConfig);
        } else {
            int i = 0;
            while (i < nRowCount) {
                this.AppendTableRow(html, i % 2 != 0, iDEHelper, webContext, globalContext, listConfig, dataTable.GetRow(i));
                ++i;
            }
        }
        this.AppendTableEndTag(html, webContext, globalContext, listConfig);
        return html.toString();
    }

    protected void AppendTableHeader(StringBuilderEx html, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalContext, ListConfig listConfig) {
        html.Append("<tr>");
        for (ListColumnConfig listColumnConfig : listConfig.getListColumnsConfig()) {
            html.Append("<td height='25' class='gridheader headerwhite' ");
            if (!StringHelper.IsNullOrEmpty((String)listColumnConfig.getAlign())) {
                html.Append("align='%1$s' ", (Object)listColumnConfig.getAlign());
            }
            if (listColumnConfig.getWidth() > 0) {
                html.Append("width='%1$s' ", (Object)listColumnConfig.getWidth());
            }
            html.Append(">&nbsp;");
            html.Append(webContext.getGlobalHelper().getLocalizationHelper().GetLocalization(webContext.getLocalization(), listColumnConfig.getCapLanResId(), listColumnConfig.getCaption()));
            html.Append("&nbsp;</td>");
        }
        html.Append("</tr>");
    }

    protected void AppendEmptyMsg(StringBuilderEx html, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalContext, ListConfig listConfig) {
        html.Append("<tr>");
        html.Append("<td height='50' align='center' valign='middle' class='gridLightStrip' colspan='%1$s' ", (Object)listConfig.getListColumnsConfig().size());
        html.Append("<span class='sx-normaltext'>%1$s</span>", (Object)listConfig.getEmptyMsg());
        html.Append("</td>");
        html.Append("</tr>");
    }

    protected void AppendTableRow(StringBuilderEx html, boolean bAlternative, IDEHelper iDEHelper, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalContext, ListConfig listConfig, DataRow dr) {
        html.Append("<tr height='20'>");
        for (ListColumnConfig listColumnConfig : listConfig.getListColumnsConfig()) {
            if (bAlternative) {
                html.Append("<td  class='gridDarkStrip' ");
            } else {
                html.Append("<td  class='gridLightStrip' ");
            }
            if (!StringHelper.IsNullOrEmpty((String)listColumnConfig.getAlign())) {
                html.Append("align='%1$s' ", (Object)listColumnConfig.getAlign());
            }
            if (listColumnConfig.getWidth() > 0) {
                html.Append("width='%1$s' ", (Object)listColumnConfig.getWidth());
            }
            html.Append(">&nbsp;<span class='sx-normaltext'>");
            html.Append(this.OnGetCellValue(iDEHelper, webContext, globalContext, dr, listColumnConfig));
            html.Append("</span>&nbsp;</td>");
        }
        html.Append("</tr>");
    }

    protected void AppendTableStartTag(StringBuilderEx html, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalContext, ListConfig listConfig) {
        html.Append("<table width='100%' border='0' cellpadding='3' cellspacing='1' class='greyBorderTable text'>");
    }

    protected void AppendTableEndTag(StringBuilderEx html, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalContext, ListConfig listConfig) {
        html.Append("</table>");
    }

    protected String OnGetCellValue(IDEHelper iDEHelper, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalContext, DataRow dr, ListColumnConfig listColumnConfig) {
        return BaseListWriter.GetCellValue(iDEHelper, webContext, globalContext, dr, listColumnConfig, this.customObjects);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String GetCellValue(IDEHelper iDEHelper, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalContext, DataRow dr, ListColumnConfig listColumnConfig, TreeMap<String, IListCell> customObjects) {
        try {
            if (!StringHelper.IsNullOrEmpty((String)listColumnConfig.getCustom())) {
                IListCell listCell = null;
                if (customObjects.containsKey(listColumnConfig.getCustom())) {
                    listCell = customObjects.get(listColumnConfig.getCustom());
                    return listCell.GetValue(iDEHelper, webContext, globalContext, dr, listColumnConfig);
                }
                Object objCell = ObjectHelper.Create((String)listColumnConfig.getCustom());
                if (objCell == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5bf9\u8c61[%1$s]", (Object)listColumnConfig.getCustom()));
                    return "\u503c\u9519\u8bef";
                }
                if (!(objCell instanceof IListCell)) {
                    log.error((Object)StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)listColumnConfig.getCustom()));
                    return "\u503c\u9519\u8bef";
                }
                listCell = (IListCell)objCell;
                customObjects.put(listColumnConfig.getCustom(), listCell);
                return listCell.GetValue(iDEHelper, webContext, globalContext, dr, listColumnConfig);
            }
            String strItemFormat = listColumnConfig.getFormat();
            String strValue = "";
            if (StringHelper.Length((String)strItemFormat) == 0) {
                strItemFormat = "%1$s";
            }
            String strItemParams = listColumnConfig.getParams();
            if (StringHelper.IsNullOrEmpty((String)(strItemParams = strItemParams.trim()))) {
                return "\u6ca1\u6709\u5b9a\u4e49\u53c2\u6570";
            }
            String[] itemParams = strItemParams.split("[|]");
            Object[] valueObj = new Object[itemParams.length];
            int i = 0;
            while (true) {
                IDEFHelper iDEFHelper;
                if (i >= itemParams.length) {
                    return StringHelper.Format((String)strItemFormat, (Object[])valueObj);
                }
                if (dr.IsDBNull(itemParams[i])) {
                    return listColumnConfig.getDefault();
                }
                Object objValue = dr.Get(itemParams[i]);
                if (iDEHelper.IsContainDEField(itemParams[i]) && (iDEFHelper = iDEHelper.GetDEFHelper(itemParams[i])) != null && !StringHelper.IsNullOrEmpty((String)iDEFHelper.GetCodeList())) {
                    String strTempValue = objValue.toString();
                    CodeListConfig codeListConfig = globalContext.getCodeListMgr().GetCodeListConfig(iDEFHelper.GetCodeList(), webContext.getLocalization());
                    if (codeListConfig != null) {
                        String strPageModel = SRFDAWebCTXHelper.GetPageModel((ISRFDAWebContext)webContext);
                        if (StringHelper.IsNullOrEmpty((String)strPageModel)) {
                            objValue = codeListConfig.GetCodeListValueWithStyle(strTempValue, true);
                        } else {
                            CodeItemConfig codeItemConfig = codeListConfig.FindCodeItemConfigByValue(strTempValue, true);
                            if (codeItemConfig == null) {
                                objValue = codeListConfig.getEmptyText();
                            } else if (StringHelper.Compare((String)strItemFormat, (String)"%1$s", (boolean)true) == 0) {
                                JSONObject jo = new JSONObject();
                                jo.put("text", (Object)WebUtility.GetJSONText((String)codeItemConfig.getText()));
                                jo.put("color", (Object)codeItemConfig.getColor());
                                if (!StringHelper.IsNullOrEmpty((String)codeItemConfig.getIcon())) {
                                    jo.put("icon", (Object)codeItemConfig.getIcon());
                                }
                                if (!StringHelper.IsNullOrEmpty((String)codeItemConfig.getIconCls())) {
                                    jo.put("icon", (Object)codeItemConfig.getIconCls());
                                }
                                objValue = jo.toString();
                            } else {
                                objValue = codeItemConfig.getText();
                            }
                        }
                    }
                }
                valueObj[i] = objValue;
                ++i;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
}

