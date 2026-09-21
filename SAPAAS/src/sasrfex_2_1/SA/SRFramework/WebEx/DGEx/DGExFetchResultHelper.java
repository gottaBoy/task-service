/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Data.MultiDataTable
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.DGEx;

import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.MultiDataTable;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Builder.AttributeBuilder;
import SA.SRFramework.WebEx.DGEx.DGExFetchResultHelperContext;
import SA.SRFramework.WebEx.DGEx.ISRFExDGExCell;
import SA.SRFramework.WebEx.DGEx.UI.DGExBaseCellConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExBaseColumnConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExCellConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExColumnConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExComplexCellConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExComplexColumnConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExDataGroupConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExGroupBottomConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExGroupCellConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExGroupConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExGroupContentConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExGroupHeaderConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExLabelCellConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExMacroCellConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExMacroConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExMacroParamConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExSNCellConfig;
import SA.SRFramework.WebEx.UI.ItemParamConfig;
import SA.SRFramework.WebEx.UI.ItemParamsConfig;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DGExFetchResultHelper {
    private static final Log log = LogFactory.getLog(DGExFetchResultHelper.class);

    public static boolean Output(DGExFetchResultHelperContext context, StringBuilderEx sb, DataTable dataTable) throws Exception {
        context.setGroupLevel(0);
        if (context.getDGExConfig().getRootGroupConfig() == null) {
            log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u6839\u5206\u7ec4\u914d\u7f6e"));
            return false;
        }
        context.PushDataGroup(context.getDGExConfig().getDataGroupConfig());
        return DGExFetchResultHelper.OutputGroup(sb, context, dataTable, context.getDGExConfig().getRootGroupConfig());
    }

    protected static boolean OutputGroup(StringBuilderEx sb, DGExFetchResultHelperContext context, DataTable dataTable, DGExGroupConfig groupConfig) throws Exception {
        String strTDCss;
        int nGroupLevel = context.getGroupLevel();
        if (nGroupLevel == 0 && !context.isExportMode()) {
            sb.Append("<DIV style='padding:2px;'>");
        }
        sb.Append("<table class='sx-dg-tb' cellpadding='0' cellspacing='0'>");
        if (groupConfig.getGroupHeaderConfig() != null) {
            strTDCss = DGExFetchResultHelper.GetCellBorderCss(groupConfig.getGroupHeaderConfig().getBorder());
            if (!StringHelper.IsNullOrEmpty((String)groupConfig.getGroupHeaderConfig().getCssClass())) {
                strTDCss = String.valueOf(strTDCss) + " ";
                strTDCss = String.valueOf(strTDCss) + groupConfig.getGroupHeaderConfig().getCssClass();
            }
            sb.Append("<TR ><TD class='%1$s' >", strTDCss);
            if (!DGExFetchResultHelper.OutputGroupHeader(sb, context, groupConfig.getGroupHeaderConfig())) {
                return false;
            }
            sb.Append("</TD></TR>");
        }
        if (groupConfig.getGroupContentConfig() != null) {
            strTDCss = DGExFetchResultHelper.GetCellBorderCss(groupConfig.getGroupContentConfig().getBorder());
            if (!StringHelper.IsNullOrEmpty((String)groupConfig.getGroupContentConfig().getCssClass())) {
                strTDCss = String.valueOf(strTDCss) + " ";
                strTDCss = String.valueOf(strTDCss) + groupConfig.getGroupContentConfig().getCssClass();
            }
            sb.Append("<TR ><TD class='%1$s' >", strTDCss);
            if (!DGExFetchResultHelper.OutputGroupContent(sb, context, dataTable, groupConfig.getGroupContentConfig())) {
                return false;
            }
            sb.Append("</TD></TR>");
        }
        if (groupConfig.getGroupBottomConfig() != null) {
            strTDCss = DGExFetchResultHelper.GetCellBorderCss(groupConfig.getGroupBottomConfig().getBorder());
            if (!StringHelper.IsNullOrEmpty((String)groupConfig.getGroupBottomConfig().getCssClass())) {
                strTDCss = String.valueOf(strTDCss) + " ";
                strTDCss = String.valueOf(strTDCss) + groupConfig.getGroupBottomConfig().getCssClass();
            }
            sb.Append("<TR ><TD class='%1$s' >", strTDCss);
            if (!DGExFetchResultHelper.OutputGroupBottom(sb, context, dataTable, groupConfig.getGroupBottomConfig())) {
                return false;
            }
            sb.Append("</TD></TR>");
        }
        sb.Append("</table>");
        if (nGroupLevel == 0 && !context.isExportMode()) {
            sb.Append("</DIV>");
        }
        context.setGroupLevel(nGroupLevel);
        return true;
    }

    protected static boolean OutputGroupHeader(StringBuilderEx sb, DGExFetchResultHelperContext context, DGExGroupHeaderConfig groupHeaderConfig) {
        if (groupHeaderConfig.getColumnsConfig() == null) {
            return true;
        }
        sb.Append("<table class='sx-dg-tb' cellpadding='0' cellspacing='0' ><TR>\r\n");
        int nWidth = 0;
        Iterator iterator = groupHeaderConfig.getColumnsConfig().iterator();
        while (iterator.hasNext()) {
            DGExBaseColumnConfig columnConfig = (DGExBaseColumnConfig)((Object)iterator.next());
            nWidth += columnConfig.getWidth();
            if (DGExFetchResultHelper.OutputColumn(sb, context, columnConfig)) continue;
            return false;
        }
        sb.Append("</TR></table>");
        return true;
    }

    protected static boolean OutputColumn(StringBuilderEx sb, DGExFetchResultHelperContext context, DGExBaseColumnConfig columnConfig) {
        AttributeBuilder attributesBuilder = new AttributeBuilder();
        if (columnConfig.getWidth() != 0) {
            attributesBuilder.Set("width", StringHelper.Format((String)"%1$s", (Object)columnConfig.getWidth()));
        }
        if (columnConfig.getHeight() != 0) {
            attributesBuilder.Set("height", StringHelper.Format((String)"%1$s", (Object)columnConfig.getHeight()));
        }
        if (!StringHelper.IsNullOrEmpty((String)columnConfig.getExtStyle())) {
            attributesBuilder.Set("style", columnConfig.getExtStyle());
        }
        if (!StringHelper.IsNullOrEmpty((String)columnConfig.getAlign())) {
            attributesBuilder.Set("align", columnConfig.getAlign());
        }
        String strTDCss = DGExFetchResultHelper.GetCellBorderCss(columnConfig.getBorder());
        strTDCss = String.valueOf(strTDCss) + " sx-dg-column";
        if (!StringHelper.IsNullOrEmpty((String)columnConfig.getCssClass())) {
            strTDCss = String.valueOf(strTDCss) + " ";
            strTDCss = String.valueOf(strTDCss) + columnConfig.getCssClass();
        }
        sb.Append("<TD %1$s class='%2$s' >", attributesBuilder.ToOutputString(), strTDCss);
        if (columnConfig instanceof DGExColumnConfig) {
            DGExColumnConfig realColumnConfig = (DGExColumnConfig)columnConfig;
            String strCaptionCssClass = "sx-dg-column-text";
            if (!StringHelper.IsNullOrEmpty((String)realColumnConfig.getCaptionCssClass())) {
                strCaptionCssClass = realColumnConfig.getCaptionCssClass();
            }
            if (context.getGroupLevel() == 0 && !StringHelper.IsNullOrEmpty((String)realColumnConfig.getSortField())) {
                boolean bOutputImage = false;
                String strSortDir = "ASC";
                if (StringHelper.Compare((String)context.getSortField(), (String)realColumnConfig.getSortField(), (boolean)true) == 0) {
                    bOutputImage = true;
                    strSortDir = StringHelper.Compare((String)context.getSortDir(), (String)"asc", (boolean)true) == 0 ? "DESC" : "ASC";
                }
                sb.Append("<A HREF='#' onclick=\"$P.gridex['%1$s'].sort('%2$s','%3$s')\">", context.getDGExUniqueId(), realColumnConfig.getSortField(), strSortDir);
                sb.Append("<span class='%2$s'>%1$s</span>", realColumnConfig.getCaption(), strCaptionCssClass);
                if (bOutputImage) {
                    if (StringHelper.Compare((String)context.getSortDir(), (String)"ASC", (boolean)true) == 0) {
                        sb.Append("<IMG src='../sasrfex/images/default/grid/sort_asc.gif' border='0'>");
                    } else {
                        sb.Append("<IMG src='../sasrfex/images/default/grid/sort_desc.gif' border='0'>");
                    }
                }
                sb.Append("</A>");
            } else {
                sb.Append("<span class='%2$s'>%1$s</span>", realColumnConfig.getCaption(), strCaptionCssClass);
            }
        } else if (columnConfig instanceof DGExComplexColumnConfig) {
            DGExComplexColumnConfig complexColumnConfig = (DGExComplexColumnConfig)columnConfig;
            if (complexColumnConfig.getColumnsConfig() == null) {
                return false;
            }
            sb.Append("<table class='sx-dg-tb' >");
            if (complexColumnConfig.isHorizontal()) {
                sb.Append("<TR>");
                Iterator iterator = complexColumnConfig.getColumnsConfig().iterator();
                while (iterator.hasNext()) {
                    DGExBaseColumnConfig childColumnConfig = (DGExBaseColumnConfig)((Object)iterator.next());
                    if (DGExFetchResultHelper.OutputColumn(sb, context, childColumnConfig)) continue;
                    return false;
                }
                sb.Append("</TR>");
            } else {
                Iterator iterator = complexColumnConfig.getColumnsConfig().iterator();
                while (iterator.hasNext()) {
                    DGExBaseColumnConfig childColumnConfig = (DGExBaseColumnConfig)((Object)iterator.next());
                    sb.Append("<TR>");
                    if (!DGExFetchResultHelper.OutputColumn(sb, context, childColumnConfig)) {
                        return false;
                    }
                    sb.Append("</TR>");
                }
            }
            sb.Append("</table>");
        }
        sb.Append("</TD>");
        return true;
    }

    protected static boolean OutputGroupContent(StringBuilderEx sb, DGExFetchResultHelperContext context, DataTable dataTable, DGExGroupContentConfig groupContentConfig) throws Exception {
        if (groupContentConfig.getCellsConfig() == null) {
            return false;
        }
        sb.Append("<table class='sx-dg-tb' >\r\n");
        int nRowCount = dataTable.GetRowCount();
        int i = 0;
        while (i < nRowCount) {
            DataRow dr = dataTable.GetRow(i);
            sb.Append("<tr>");
            Iterator iterator = groupContentConfig.getCellsConfig().iterator();
            while (iterator.hasNext()) {
                DGExBaseCellConfig cellConfig;
                if (DGExFetchResultHelper.OutputCell(sb, true, i, i == nRowCount - 1, context, dr, cellConfig = (DGExBaseCellConfig)((Object)iterator.next()))) continue;
                return false;
            }
            sb.Append("</tr>");
            ++i;
        }
        sb.Append("</table>");
        return true;
    }

    protected static boolean OutputCell(StringBuilderEx sb, boolean bContentCell, int nRowIndex, boolean bLastRow, DGExFetchResultHelperContext context, DataRow dr, DGExBaseCellConfig cellConfig) throws Exception {
        AttributeBuilder attributesBuilder = new AttributeBuilder();
        if (cellConfig.getWidth() != 0) {
            attributesBuilder.Set("width", StringHelper.Format((String)"%1$s", (Object)cellConfig.getWidth()));
        }
        if (cellConfig.getHeight() != 0) {
            attributesBuilder.Set("height", StringHelper.Format((String)"%1$s", (Object)cellConfig.getHeight()));
        }
        if (!StringHelper.IsNullOrEmpty((String)cellConfig.getExtStyle())) {
            attributesBuilder.Set("style", cellConfig.getExtStyle());
        }
        if (!StringHelper.IsNullOrEmpty((String)cellConfig.getAlign())) {
            attributesBuilder.Set("align", cellConfig.getAlign());
        }
        String strTDCss = DGExFetchResultHelper.GetCellBorderCss(bLastRow ? cellConfig.getLastBorder() : cellConfig.getBorder());
        if (!StringHelper.IsNullOrEmpty((String)cellConfig.getCssClass())) {
            strTDCss = String.valueOf(strTDCss) + " ";
            strTDCss = String.valueOf(strTDCss) + cellConfig.getCssClass();
        }
        sb.Append("<TD %1$s class='%2$s' >", attributesBuilder.ToOutputString(), strTDCss);
        if (cellConfig instanceof DGExCellConfig) {
            if (!bContentCell) {
                throw new Exception("\u5f53\u524d\u533a\u57df\u4e0d\u80fd\u8f93\u51fa\u6570\u636e\u7ed1\u5b9a\u5355\u5143\u683c");
            }
            DGExCellConfig realCellConfig = (DGExCellConfig)cellConfig;
            String strValue = DGExFetchResultHelper.GetCellValue(context, dr, realCellConfig);
            if (strValue == null) {
                return false;
            }
            String strTextCssClass = "sx-dg-cell-text";
            if (!StringHelper.IsNullOrEmpty((String)realCellConfig.getTextCssClass())) {
                strTextCssClass = realCellConfig.getTextCssClass();
            }
            sb.Append("<span class='%2$s'>%1$s</span>", strValue, strTextCssClass);
        } else if (cellConfig instanceof DGExGroupCellConfig) {
            DGExGroupCellConfig groupCellConfig = (DGExGroupCellConfig)cellConfig;
            DGExDataGroupConfig dataGroupConfig = context.GetActiveDataGroup().FindDataGroup(groupCellConfig.getDataGroupId());
            DataTable groupDataTable = context.FindActiveDataGroupGroupDataTable(dr, groupCellConfig.getDataGroupId());
            if (groupDataTable == null) {
                return false;
            }
            if (groupDataTable.GetRowCount() > 0) {
                context.setGroupLevel(context.getGroupLevel() + 1);
                context.PushDataGroup(dataGroupConfig);
                DGExFetchResultHelper.OutputGroup(sb, context, groupDataTable, groupCellConfig.getGroupConfig());
                context.PopDataGroup();
            }
        } else if (cellConfig instanceof DGExMacroCellConfig) {
            DGExMacroCellConfig realCellConfig = (DGExMacroCellConfig)cellConfig;
            String strValue = null;
            strValue = bContentCell ? DGExFetchResultHelper.GetMacroCellValue(context, dr, realCellConfig) : DGExFetchResultHelper.GetMacroCellValue(context, realCellConfig);
            if (strValue == null) {
                return false;
            }
            String strTextCssClass = "sx-dg-cell-text";
            if (!StringHelper.IsNullOrEmpty((String)realCellConfig.getTextCssClass())) {
                strTextCssClass = realCellConfig.getTextCssClass();
            }
            sb.Append("<span class='%2$s'>%1$s</span>", strValue, strTextCssClass);
        } else if (!(cellConfig instanceof DGExComplexCellConfig)) {
            if (cellConfig instanceof DGExLabelCellConfig) {
                DGExLabelCellConfig labelCellConfig = (DGExLabelCellConfig)cellConfig;
                String strTextCssClass = "sx-dg-cell-text";
                if (!StringHelper.IsNullOrEmpty((String)labelCellConfig.getTextCssClass())) {
                    strTextCssClass = labelCellConfig.getTextCssClass();
                }
                sb.Append("<span class='%2$s'>%1$s</span>", labelCellConfig.getText(), strTextCssClass);
            } else if (cellConfig instanceof DGExSNCellConfig) {
                DGExSNCellConfig snCellConfig = (DGExSNCellConfig)cellConfig;
                String strTextCssClass = "sx-dg-cell-text";
                if (!StringHelper.IsNullOrEmpty((String)snCellConfig.getTextCssClass())) {
                    strTextCssClass = snCellConfig.getTextCssClass();
                }
                sb.Append("<span class='%2$s'>%1$s</span>", nRowIndex + snCellConfig.getStartFrom(), strTextCssClass);
            }
        }
        sb.Append("</TD>");
        return true;
    }

    protected static String GetCellValue(DGExFetchResultHelperContext context, DataRow dr, DGExCellConfig cellConfig) {
        try {
            String strCustom;
            String strItemFormat = cellConfig.getItemFormat();
            String strValue = "";
            if (StringHelper.Length((String)strItemFormat) == 0) {
                strItemFormat = "%1$s";
            }
            if (StringHelper.IsNullOrEmpty((String)(strCustom = cellConfig.getCustom()))) {
                CodeListConfig codeListConfig;
                ItemParamsConfig itemParamsConfig = cellConfig.getItemParamsConfig();
                if (itemParamsConfig == null || itemParamsConfig.getList().size() == 0) {
                    Object objValue;
                    strValue = dr.IsDBNull(cellConfig.getID()) ? "" : ((objValue = dr.Get(cellConfig.getID())) == null ? "" : StringHelper.Format((String)strItemFormat, (Object)objValue));
                } else {
                    Object[] valueObj = new Object[itemParamsConfig.getList().size()];
                    int j = 0;
                    while (j < itemParamsConfig.getList().size()) {
                        ItemParamConfig itemParamConfig = (ItemParamConfig)((Object)itemParamsConfig.getList().get(j));
                        if (dr.IsDBNull(itemParamConfig.getID())) {
                            valueObj[j] = StringHelper.IsNullOrEmpty((String)itemParamConfig.getDefault()) ? null : itemParamConfig.getDefault();
                        } else {
                            Object objValue = null;
                            if (StringHelper.Length((String)itemParamConfig.getItemFormat()) > 0) {
                                objValue = dr.Get(itemParamConfig.getID());
                                objValue = StringHelper.Format((String)itemParamConfig.getItemFormat(), (Object)objValue);
                            } else {
                                objValue = dr.Get(itemParamConfig.getID());
                            }
                            if (StringHelper.Length((String)itemParamConfig.getCodeList()) > 0) {
                                String strTempValue = objValue.toString();
                                CodeListConfig codeListConfig2 = context.getWebContext().getCodeListMgr().GetCodeListConfig(itemParamConfig.getCodeList());
                                if (codeListConfig2 != null) {
                                    objValue = codeListConfig2.GetCodeListValueWithStyle(strTempValue, true);
                                }
                            }
                            valueObj[j] = objValue;
                        }
                        ++j;
                    }
                    boolean bNullValue = true;
                    int j2 = 0;
                    while (j2 < valueObj.length) {
                        if (valueObj[j2] != null) {
                            bNullValue = false;
                            break;
                        }
                        ++j2;
                    }
                    strValue = bNullValue ? "" : StringHelper.Format((String)strItemFormat, (Object[])valueObj);
                }
                if (StringHelper.Length((String)cellConfig.getCodeList()) > 0 && (codeListConfig = context.getWebContext().getCodeListMgr().GetCodeListConfig(cellConfig.getCodeList())) != null) {
                    strValue = codeListConfig.GetCodeListValueWithStyle(strValue, true);
                }
            } else {
                Object objCustom = context.getAttribute(strCustom);
                if (objCustom == null) {
                    objCustom = ObjectHelper.Create(strCustom);
                    if (objCustom == null) {
                        return StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5bf9\u8c61[%1$s]", (Object)strCustom);
                    }
                    context.setAttribute(strCustom, objCustom);
                }
                if (!(objCustom instanceof ISRFExDGExCell)) {
                    return StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strCustom);
                }
                ISRFExDGExCell iDGExCell = (ISRFExDGExCell)objCustom;
                strValue = iDGExCell.GetCellContent(context, dr, cellConfig);
            }
            return strValue;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    protected static String GetMacroCellValue(DGExFetchResultHelperContext context, DGExMacroCellConfig cellConfig) {
        try {
            Object objValue = context.CalcMacroValue(cellConfig.getMacro());
            String strItemFormat = cellConfig.getItemFormat();
            String strValue = "";
            if (StringHelper.Length((String)strItemFormat) == 0) {
                strItemFormat = "%1$s";
            }
            strValue = objValue == null ? "" : StringHelper.Format((String)strItemFormat, (Object)objValue);
            return strValue;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    protected static String GetMacroCellValue(DGExFetchResultHelperContext context, DataRow dr, DGExMacroCellConfig cellConfig) {
        try {
            Object objValue = context.CalcMacroValue(cellConfig.getMacro(), dr);
            String strItemFormat = cellConfig.getItemFormat();
            String strValue = "";
            if (StringHelper.Length((String)strItemFormat) == 0) {
                strItemFormat = "%1$s";
            }
            strValue = objValue == null ? "" : StringHelper.Format((String)strItemFormat, (Object)objValue);
            return strValue;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    protected static String GetCellBorderCss(int nBorder) {
        if (nBorder == 0) {
            return "";
        }
        if (nBorder == 15) {
            return "sx-dgcb-a";
        }
        String strBorder = "";
        if ((nBorder & 1) > 0) {
            if (!StringHelper.IsNullOrEmpty((String)strBorder)) {
                strBorder = String.valueOf(strBorder) + " ";
            }
            strBorder = String.valueOf(strBorder) + "sx-dgcb-l";
        }
        if ((nBorder & 2) > 0) {
            if (!StringHelper.IsNullOrEmpty((String)strBorder)) {
                strBorder = String.valueOf(strBorder) + " ";
            }
            strBorder = String.valueOf(strBorder) + "sx-dgcb-t";
        }
        if ((nBorder & 8) > 0) {
            if (!StringHelper.IsNullOrEmpty((String)strBorder)) {
                strBorder = String.valueOf(strBorder) + " ";
            }
            strBorder = String.valueOf(strBorder) + "sx-dgcb-b";
        }
        if ((nBorder & 4) > 0) {
            if (!StringHelper.IsNullOrEmpty((String)strBorder)) {
                strBorder = String.valueOf(strBorder) + " ";
            }
            strBorder = String.valueOf(strBorder) + "sx-dgcb-r";
        }
        return strBorder;
    }

    protected static boolean OutputGroupBottom(StringBuilderEx sb, DGExFetchResultHelperContext context, DataTable dataTable, DGExGroupBottomConfig groupBottomConfig) throws Exception {
        if (groupBottomConfig.getCellsConfig() == null) {
            return false;
        }
        if (!DGExFetchResultHelper.CalcGroupBottomMacro(context, dataTable, groupBottomConfig)) {
            return false;
        }
        sb.Append("<table class='sx-dg-tb' >\r\n");
        sb.Append("<tr>");
        Iterator iterator = groupBottomConfig.getCellsConfig().iterator();
        while (iterator.hasNext()) {
            DGExBaseCellConfig cellConfig = (DGExBaseCellConfig)((Object)iterator.next());
            if (DGExFetchResultHelper.OutputCell(sb, false, -1, false, context, null, cellConfig)) continue;
            return false;
        }
        sb.Append("</tr>");
        sb.Append("</table>");
        return true;
    }

    protected static boolean CalcGroupBottomMacro(DGExFetchResultHelperContext context, DataTable dataTable, DGExGroupBottomConfig groupBottomConfig) throws Exception {
        if (groupBottomConfig.getMacrosConfig() == null) {
            return true;
        }
        context.ResetMacroValue();
        Iterator iterator = groupBottomConfig.getMacrosConfig().iterator();
        while (iterator.hasNext()) {
            DGExMacroConfig macroConfig = (DGExMacroConfig)((Object)iterator.next());
            if (DGExFetchResultHelper.CalcMacro(context, dataTable, macroConfig)) continue;
            return false;
        }
        return true;
    }

    protected static boolean CalcMacro(DGExFetchResultHelperContext context, DataTable dataTable, DGExMacroConfig macroConfig) throws Exception {
        if (macroConfig == null) {
            return false;
        }
        String strFunc = macroConfig.getFunc();
        if (StringHelper.Compare((String)strFunc, (String)"SUM", (boolean)true) == 0) {
            double fValue = DGExFetchResultHelper.CalcMacro_Sum(context, dataTable, macroConfig);
            context.setMacroValue(macroConfig.getID(), fValue);
            return true;
        }
        if (StringHelper.Compare((String)strFunc, (String)"AVG", (boolean)true) == 0) {
            double fValue = DGExFetchResultHelper.CalcMacro_Avg(context, dataTable, macroConfig);
            context.setMacroValue(macroConfig.getID(), fValue);
            return true;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8ba1\u7b97\u51fd\u6570[%1$s]", (Object)strFunc));
    }

    protected static double CalcMacro_Sum(DGExFetchResultHelperContext context, DataTable dataTable, DGExMacroConfig macroConfig) throws Exception {
        if (macroConfig.getMacroParamsConfig().size() != 1) {
            throw new Exception(StringHelper.Format((String)"\u8ba1\u7b97\u51fd\u6570[%1$s]\u5fc5\u9700\u6307\u5b9a\u4e00\u4e2a\u53c2\u6570", (Object)"SUM"));
        }
        DataTable curDataTable = null;
        if (StringHelper.IsNullOrEmpty((String)macroConfig.getDataGroupId())) {
            curDataTable = dataTable;
        } else {
            Vector<DataTable> dataTables = context.GetActiveDataGroupGroupDataTables(dataTable, macroConfig.getDataGroupId(), null);
            MultiDataTable multiDataTable = new MultiDataTable();
            multiDataTable.AddDataTables(dataTables);
            curDataTable = multiDataTable;
        }
        DGExMacroParamConfig macroParamConfig = (DGExMacroParamConfig)((Object)macroConfig.getMacroParamsConfig().get(0));
        double fNullValue = 0.0;
        if (!StringHelper.IsNullOrEmpty((String)macroParamConfig.getNullValue())) {
            fNullValue = Double.parseDouble(macroParamConfig.getNullValue());
        }
        double fTotalValue = 0.0;
        int nRowCount = curDataTable.GetRowCount();
        int i = 0;
        while (i < nRowCount) {
            DataRow dr = curDataTable.GetRow(i);
            Object objValue = dr.Get(macroParamConfig.getID());
            fTotalValue = objValue == null ? (fTotalValue += fNullValue) : (objValue instanceof Double ? (fTotalValue += ((Double)objValue).doubleValue()) : (fTotalValue += Double.parseDouble(objValue.toString())));
            ++i;
        }
        return fTotalValue;
    }

    protected static double CalcMacro_Avg(DGExFetchResultHelperContext context, DataTable dataTable, DGExMacroConfig macroConfig) throws Exception {
        if (macroConfig.getMacroParamsConfig().size() != 1) {
            throw new Exception(StringHelper.Format((String)"\u8ba1\u7b97\u51fd\u6570[%1$s]\u5fc5\u9700\u6307\u5b9a\u4e00\u4e2a\u53c2\u6570", (Object)"AVG"));
        }
        DataTable curDataTable = null;
        if (StringHelper.IsNullOrEmpty((String)macroConfig.getDataGroupId())) {
            curDataTable = dataTable;
        } else {
            Vector<DataTable> dataTables = context.GetActiveDataGroupGroupDataTables(dataTable, macroConfig.getDataGroupId(), null);
            MultiDataTable multiDataTable = new MultiDataTable();
            multiDataTable.AddDataTables(dataTables);
            curDataTable = multiDataTable;
        }
        DGExMacroParamConfig macroParamConfig = (DGExMacroParamConfig)((Object)macroConfig.getMacroParamsConfig().get(0));
        double fNullValue = 0.0;
        if (!StringHelper.IsNullOrEmpty((String)macroParamConfig.getNullValue())) {
            fNullValue = Double.parseDouble(macroParamConfig.getNullValue());
        }
        double fTotalValue = 0.0;
        int nRowCount = curDataTable.GetRowCount();
        int i = 0;
        while (i < nRowCount) {
            DataRow dr = curDataTable.GetRow(i);
            Object objValue = dr.Get(macroParamConfig.getID());
            fTotalValue = objValue == null ? (fTotalValue += fNullValue) : (objValue instanceof Double ? (fTotalValue += ((Double)objValue).doubleValue()) : (fTotalValue += Double.parseDouble(objValue.toString())));
            ++i;
        }
        if (curDataTable.GetRowCount() == 0) {
            return fTotalValue;
        }
        return fTotalValue / (double)curDataTable.GetRowCount();
    }
}

