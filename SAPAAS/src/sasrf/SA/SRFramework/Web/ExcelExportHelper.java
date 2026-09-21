/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.SearchResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.UI.ListColumnConfig;
import SA.SRFramework.Web.UI.MainListConfig;
import SA.SRFramework.Web.UI.ParamConfig;
import SA.SRFramework.Web.WebUtility;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.TreeMap;

public class ExcelExportHelper {
    protected static String STYLE_LEFTBORDER = "border-left:0.5pt solid black;";
    protected static String STYLE_TOPBORDER = "border-top:0.5pt solid black;";
    protected static String STYLE_RIGHTBORDER = "border-right:0.5pt solid black;";
    protected static String STYLE_BOTTOMBORDER = "border-bottom:0.5pt solid black;";
    protected static String STYLE_WHITETILETEXT = "FONT-WEIGHT: bold; FONT-SIZE: 10pt; COLOR: #ffffff;";
    protected static String STYLE_BLACKTILETEXT11 = "FONT-WEIGHT: bold; FONT-SIZE: 11pt; COLOR: #000000;";
    protected static String STYLE_NORMALTEXT10 = "FONT-SIZE: 10pt; COLOR: #000000;";
    private MainListConfig mainListConfig = null;
    protected SearchResult searchResult = null;

    public void setDataSource(SearchResult value) {
        this.searchResult = value;
    }

    public void setConfig(MainListConfig value) {
        this.mainListConfig = value;
    }

    public void Output(PrintWriter writer) throws Exception {
        if (this.mainListConfig == null) {
            writer.write("Excel \u7ed3\u6784\u903b\u8f91\u6709\u8bef\uff0c\u8bf7\u786e\u8ba4\uff01\n");
            return;
        }
        if (this.searchResult == null) {
            writer.write("\u6570\u636e\u96c6\u5408\u6709\u8bef\uff0c\u8bf7\u786e\u8ba4\uff01");
            return;
        }
        TreeMap<Integer, Object> outputColumns = new TreeMap<Integer, Object>();
        if (this.mainListConfig != null) {
            int nBestOrderId = -1;
            for (Object tempItemObj : this.mainListConfig.getColumnItems()) {
                ListColumnConfig item = (ListColumnConfig)tempItemObj;
                if (item.getShowOrder() == -1) continue;
                outputColumns.put(item.getShowOrder(), item);
            }
        }
        int nColumnCount = outputColumns.size();
        writer.write("<HTML><head><meta http-equiv=Content-Type content=\"text/html; charset=gb2312\"></head>\n");
        writer.write("<body>\n");
        writer.write("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"0\">\n");
        writer.write("<TR>\n");
        int nIndex = 0;
        for (ListColumnConfig item : outputColumns.values()) {
            String strAlign = item.getAlign();
            if (StringHelper.Length(strAlign) == 0) {
                strAlign = nIndex == 0 ? "left" : "center";
            }
            if (nIndex == 0) {
                writer.write(StringHelper.Format("<td width=\"%1$s\" align=\"center\" style=\"%2$s\">\n", item.getWidth(), String.valueOf(STYLE_LEFTBORDER) + STYLE_RIGHTBORDER + STYLE_TOPBORDER + STYLE_BOTTOMBORDER + STYLE_BLACKTILETEXT11));
            } else {
                writer.write(StringHelper.Format("<td width=\"%1$s\" align=\"center\" style=\"%2$s\">\n", item.getWidth(), String.valueOf(STYLE_RIGHTBORDER) + STYLE_TOPBORDER + STYLE_BOTTOMBORDER + STYLE_BLACKTILETEXT11));
            }
            writer.write(item.getColumnName());
            writer.write("</td>\n");
            ++nIndex;
        }
        writer.write("</TR>\n");
        if (this.searchResult != null && this.searchResult.getSearchData() != null && this.searchResult.getSearchData().getTableCount() != 0) {
            DataTable searchTable = this.searchResult.getMainTable();
            for (Object tempRowObj : searchTable.getRows()) {
                DataRow row = (DataRow)tempRowObj;
                writer.write("<TR>\n");
                nIndex = 0;
                for (ListColumnConfig item : outputColumns.values()) {
                    String strAlign = item.getAlign();
                    String strStyle = "";
                    if (StringHelper.Length(strAlign) == 0) {
                        strAlign = nIndex == 0 ? "left" : "center";
                    }
                    strStyle = nIndex == 0 ? String.valueOf(STYLE_LEFTBORDER) + STYLE_RIGHTBORDER + STYLE_TOPBORDER + STYLE_BOTTOMBORDER + STYLE_NORMALTEXT10 : String.valueOf(STYLE_RIGHTBORDER) + STYLE_TOPBORDER + STYLE_BOTTOMBORDER + STYLE_NORMALTEXT10;
                    writer.write(StringHelper.Format("<td align=\"%1$s\" style=\"%2$s\" >\n", strAlign, strStyle));
                    writer.write(this.OutputCell(item, row));
                    writer.write("</td>\n");
                    ++nIndex;
                }
                writer.write("</tr>\n");
            }
        }
        writer.write("</TABLE>\n");
        writer.write("</body></HTML>\n");
    }

    protected String OutputCell(ListColumnConfig item, DataRow row) throws Exception {
        if (item.getManual()) {
            return "\u4e0d\u80fd\u8f93\u51fa\u81ea\u5b9a\u4e49\u5217";
        }
        if (item.getItemParams().size() == 0) {
            return String.format(item.getItemFormat(), "");
        }
        Object[] valueObj = new Object[item.getItemParams().size()];
        int i = 0;
        while (i < valueObj.length) {
            ParamConfig paramConfig = (ParamConfig)item.getItemParams().get(i);
            if (paramConfig.getMust() && row.IsDBNull(paramConfig.getID())) {
                return "&nbsp";
            }
            Object tempObj = row.Get(paramConfig.getID());
            String strObjValue = "";
            strObjValue = tempObj == null ? paramConfig.getDefaultValue() : (StringHelper.StringLength(paramConfig.getValueFormat()) == 0 ? tempObj.toString() : String.format(paramConfig.getValueFormat(), tempObj));
            if (paramConfig.getEncode()) {
                strObjValue = URLEncoder.encode(strObjValue, "UTF-8");
            }
            valueObj[i] = strObjValue;
            ++i;
        }
        String strOutput = StringHelper.Format(item.getItemFormat(), valueObj);
        if (item.getTrimLen() != 0) {
            String strValue = strOutput;
            if (strValue.length() > item.getTrimLen()) {
                strValue = strValue.substring(0, item.getTrimLen());
                strValue = String.valueOf(strValue) + "...";
            }
            strOutput = WebUtility.TextToHTMLWithoutReturn(strValue);
        }
        return strOutput;
    }
}

