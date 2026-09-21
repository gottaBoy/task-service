/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.ReportEx.Model;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.ReportEx.Model.ExcelCellType;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.ItemParamConfig;
import SA.SRFramework.WebEx.UI.ItemParamsConfig;
import SA.SRFramework.WebEx.Utility.ContextHelper;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import org.w3c.dom.Node;

public class GridExcelExportColumnConfig
extends XMLConfig {
    public static final String TAG_GRIDEXCELEXPORTCOLUMN = "SRFEXGRIDEXCELEXPORTCOLUMN";
    public static final String TAG_ROWCOUNT = "ROWCOUNT";
    public static final String TAG_COLUMNCOUNT = "COLUMNCOUNT";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CELLTYPE = "CELLTYPE";
    public static final String TAG_CELLFORMAT = "CELLFORMAT";
    public static final String TAG_DATATYPE = "DATATYPE";
    public static final String TAG_DBFIELD = "DBFIELD";
    public static final String TAG_ITEMFORMAT = "ITEMFORMAT";
    public static final String TAG_VALUE = "VALUE";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEADERCELLSTYLE = "HEADERCELLSTYLE";
    public static final String TAG_ROWCELLSTYLE = "ROWCELLSTYLE";
    public static final String TAG_CODELIST = "CODELIST";
    protected int nRowCount = 1;
    protected int nColumnCount = 1;
    protected int nCellType = 1;
    protected ItemParamsConfig itemParamsConfig = null;
    protected int nDataType = 25;
    protected String strDBField = "";
    protected String strItemFormat = "";
    protected String strCellFormat = "";
    protected String strCaption = "";
    protected String strValue = "";
    protected int nWidth = 0;
    protected String strHeaderCellStyle = "";
    protected String strRowCellStyle = "";
    protected String strCodeList = "";

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)"SRFEXITEMPARAMS", (String)strName, (boolean)true) == 0) {
            if (this.itemParamsConfig == null) {
                this.itemParamsConfig = new ItemParamsConfig();
            }
            this.itemParamsConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public ItemParamsConfig getItemParamsConfig() {
        return this.itemParamsConfig;
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_CELLTYPE, (boolean)true) == 0) {
            this.nCellType = ExcelCellType.Parse(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ROWCOUNT, (boolean)true) == 0) {
            this.nRowCount = GridExcelExportColumnConfig.GetValue((String)strValue, (int)this.nRowCount);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_COLUMNCOUNT, (boolean)true) == 0) {
            this.nColumnCount = GridExcelExportColumnConfig.GetValue((String)strValue, (int)this.nColumnCount);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DATATYPE, (boolean)true) == 0) {
            this.nDataType = DataTypeHelper.FromString((String)strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DBFIELD, (boolean)true) == 0) {
            this.strDBField = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ITEMFORMAT, (boolean)true) == 0) {
            this.strItemFormat = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CELLFORMAT, (boolean)true) == 0) {
            this.strCellFormat = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTION, (boolean)true) == 0) {
            this.strCaption = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VALUE, (boolean)true) == 0) {
            this.strValue = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_WIDTH, (boolean)true) == 0) {
            this.nWidth = GridExcelExportColumnConfig.GetValue((String)strValue, (int)this.nWidth);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HEADERCELLSTYLE, (boolean)true) == 0) {
            this.strHeaderCellStyle = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ROWCELLSTYLE, (boolean)true) == 0) {
            this.strRowCellStyle = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CODELIST, (boolean)true) == 0) {
            this.strCodeList = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public int getDataType() {
        return this.nDataType;
    }

    public void setDataType(int nDataType) {
        this.nDataType = nDataType;
    }

    public String getDBField() {
        if (StringHelper.Length((String)this.strDBField) == 0) {
            return this.getID();
        }
        return this.strDBField;
    }

    public void setDBField(String strDBField) {
        this.strDBField = strDBField;
    }

    public String getItemFormat() {
        return this.strItemFormat;
    }

    public void setItemFormat(String strItemFormat) {
        this.strItemFormat = strItemFormat;
    }

    public String getCellFormat() {
        return this.strCellFormat;
    }

    public void setCellFormat(String strCellFormat) {
        this.strCellFormat = strCellFormat;
    }

    public int getCellType() {
        return this.nCellType;
    }

    public void setCellType(int nCellType) {
        this.nCellType = nCellType;
    }

    public int getRowCount() {
        return this.nRowCount;
    }

    public void setRowCount(int nRowCount) {
        this.nRowCount = nRowCount;
    }

    public int getColumnCount() {
        return this.nColumnCount;
    }

    public void setColumn(int nColumnCount) {
        this.nColumnCount = nColumnCount;
    }

    public String getCaption() {
        return this.strCaption;
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public String getValue() {
        return this.strValue;
    }

    public void setValue(String strValue) {
        this.strValue = strValue;
    }

    public int getWidth() {
        return this.nWidth;
    }

    public void setWidth(int nWidth) {
        this.nWidth = nWidth;
    }

    public String getHeaderCellStyle() {
        return this.strHeaderCellStyle;
    }

    public void setHeaderCellStyle(String strHeaderCellStyle) {
        this.strHeaderCellStyle = strHeaderCellStyle;
    }

    public String getRowCellStyle() {
        return this.strRowCellStyle;
    }

    public void setRowCellStyle(String strRowCellStyle) {
        this.strRowCellStyle = strRowCellStyle;
    }

    public String getCodeList() {
        return this.strCodeList;
    }

    public void setCodeList(String strCodeList) {
        this.strCodeList = strCodeList;
    }

    public String GetItemValue(SRFExWebContext webContext, BaseDataEntity dataEntity) {
        return this.InternalGetItemValue(webContext.getGlobalHelper(), dataEntity);
    }

    protected String InternalGetItemValue(SRFExWebContext webContext, BaseDataEntity dataEntity) {
        return this.InternalGetItemValue(webContext.getGlobalHelper(), dataEntity);
    }

    protected String InternalGetItemValue(ContextHelper contextHelper, BaseDataEntity dataEntity) {
        if (StringHelper.Length((String)this.strValue) != 0) {
            return this.strValue;
        }
        if (StringHelper.Length((String)this.strItemFormat) == 0) {
            Object objValue = dataEntity.GetParamValue(this.getDBField());
            if (objValue == null) {
                return "";
            }
            if (objValue instanceof Timestamp) {
                Timestamp ti = (Timestamp)objValue;
                if (String.format("%1$tH:%1$tM:%1$tS", ti).equals("00:00:00")) {
                    return String.format("%1$tY-%1$tm-%1$td", ti);
                }
                return String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", ti);
            }
            if (objValue instanceof Time) {
                Time ti = (Time)objValue;
                if (String.format("%1$tH:%1$tM:%1$tS", ti).equals("00:00:00")) {
                    return String.format("%1$tY-%1$tm-%1$td", ti);
                }
                return String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", ti);
            }
            if (objValue instanceof Date) {
                Date ti = (Date)objValue;
                if (String.format("%1$tH:%1$tM:%1$tS", ti).equals("00:00:00")) {
                    return String.format("%1$tY-%1$tm-%1$td", ti);
                }
                return String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", ti);
            }
            return objValue.toString();
        }
        if (this.itemParamsConfig == null) {
            Object objValue = dataEntity.GetParamValue(this.getDBField());
            if (objValue == null) {
                return "";
            }
            return StringHelper.Format((String)this.strItemFormat, (Object)objValue);
        }
        Object[] valueObj = new Object[this.itemParamsConfig.getList().size()];
        int i = 0;
        while (i < this.itemParamsConfig.getList().size()) {
            ItemParamConfig itemParamConfig = (ItemParamConfig)((Object)this.itemParamsConfig.getList().get(i));
            valueObj[i] = itemParamConfig.GetParamValue(contextHelper, dataEntity);
            ++i;
        }
        return StringHelper.Format((String)this.strItemFormat, (Object[])valueObj);
    }

    public String GetItemValue(SRFExWebContext webContext, DataRow dataEntity) {
        return this.GetItemValue(webContext.getGlobalHelper(), dataEntity);
    }

    public String GetItemValue(ContextHelper contextHelper, DataRow dataEntity) {
        CodeListConfig codeListConfig;
        String strValue = this.InternalGetItemValue(contextHelper, dataEntity);
        if (StringHelper.Length((String)this.getCodeList()) > 0 && (codeListConfig = contextHelper.getCodeListMgr().GetCodeListConfig(this.getCodeList())) != null) {
            strValue = codeListConfig.GetCodeListValue(strValue, false);
        }
        return strValue;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected String InternalGetItemValue(ContextHelper contextHelper, DataRow dataEntity) {
        try {
            if (StringHelper.Length((String)this.strValue) != 0) {
                return this.strValue;
            }
            if (StringHelper.Length((String)this.strItemFormat) == 0) {
                Object objValue = dataEntity.Get(this.getDBField());
                if (objValue == null) {
                    return "";
                }
                if (objValue instanceof Timestamp) {
                    Timestamp ti = (Timestamp)objValue;
                    if (String.format("%1$tH:%1$tM:%1$tS", ti).equals("00:00:00")) {
                        return String.format("%1$tY-%1$tm-%1$td", ti);
                    }
                    return String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", ti);
                }
                if (objValue instanceof Time) {
                    Time ti = (Time)objValue;
                    if (String.format("%1$tH:%1$tM:%1$tS", ti).equals("00:00:00")) {
                        return String.format("%1$tY-%1$tm-%1$td", ti);
                    }
                    return String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", ti);
                }
                if (!(objValue instanceof Date)) {
                    return objValue.toString();
                }
                Date ti = (Date)objValue;
                if (String.format("%1$tH:%1$tM:%1$tS", ti).equals("00:00:00")) {
                    return String.format("%1$tY-%1$tm-%1$td", ti);
                }
                return String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", ti);
            }
            if (this.itemParamsConfig == null) {
                Object objValue = dataEntity.Get(this.getDBField());
                if (objValue == null) {
                    return "";
                }
                return StringHelper.Format((String)this.strItemFormat, (Object)objValue);
            }
            Object[] valueObj = new Object[this.itemParamsConfig.getList().size()];
            int i = 0;
            while (true) {
                if (i >= this.itemParamsConfig.getList().size()) {
                    return StringHelper.Format((String)this.strItemFormat, (Object[])valueObj);
                }
                ItemParamConfig itemParamConfig = (ItemParamConfig)((Object)this.itemParamsConfig.getList().get(i));
                valueObj[i] = itemParamConfig.GetParamValue(contextHelper, dataEntity);
                ++i;
            }
        }
        catch (Exception ex) {
            return "";
        }
    }
}

