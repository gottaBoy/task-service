/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.ItemParamConfig;
import SA.SRFramework.WebEx.UI.ItemParamsConfig;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import org.w3c.dom.Node;

public class DataEntityItemConfig
extends XMLConfig {
    public static final String TAG_DATAENTITYITEM = "SRFEXDATAENTITYITEM";
    public static final String TAG_DATATYPE = "DATATYPE";
    public static final String TAG_DBFIELD = "DBFIELD";
    public static final String TAG_EMPTY = "EMPTY";
    public static final String TAG_NAME = "NAME";
    public static final String TAG_ITEMFORMAT = "ITEMFORMAT";
    public static final String TAG_CODELIST = "CODELIST";
    public static final String TAG_PARENTKEY = "PARENTKEY";
    public static final String TAG_KEY = "KEY";
    public static final String TAG_DVT = "DVT";
    public static final String TAG_DVT_SESSION = "SESSION";
    public static final String TAG_DVT_APPLICATION = "APPLICATION";
    public static final String TAG_DVT_UNIQUEID = "UNIQUEID";
    public static final String TAG_DVT_CONTEXT = "CONTEXT";
    public static final String TAG_DVT_OPERATOR = "OPERATOR";
    public static final String TAG_DVT_OPERATORNAME = "OPERATORNAME";
    public static final String TAG_DVT_CURTIME = "CURTIME";
    public static final String TAG_DVT_COPY = "COPY";
    public static final String TAG_DVT_PARAM = "PARAM";
    public static final String TAG_DV = "DV";
    public static final String TAG_ENDOFDAY = "ENDOFDAY";
    protected int nDataType = 25;
    protected String strDBField = "";
    protected String strName = "";
    protected ItemParamsConfig itemParamsConfig = null;
    protected String strItemFormat = "";
    protected boolean bEndOfDay = false;
    protected String strCodeList = "";
    protected String strDVT = "";
    protected String strDV = "";
    protected boolean bKey = false;
    protected boolean bParentKey = false;

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
        if (StringHelper.Compare((String)strName, (String)TAG_DATATYPE, (boolean)true) == 0) {
            this.nDataType = DataTypeHelper.FromString((String)strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_KEY, (boolean)true) == 0) {
            this.bKey = DataEntityItemConfig.GetValue((String)strValue, (boolean)this.bKey);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PARENTKEY, (boolean)true) == 0) {
            this.bParentKey = DataEntityItemConfig.GetValue((String)strValue, (boolean)this.bParentKey);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DBFIELD, (boolean)true) == 0) {
            this.strDBField = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_NAME, (boolean)true) == 0) {
            this.strName = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ITEMFORMAT, (boolean)true) == 0) {
            this.strItemFormat = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ENDOFDAY, (boolean)true) == 0) {
            this.bEndOfDay = DataEntityItemConfig.GetValue((String)strValue, (boolean)this.bEndOfDay);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CODELIST, (boolean)true) == 0) {
            this.strCodeList = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DVT, (boolean)true) == 0) {
            this.strDVT = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DV, (boolean)true) == 0) {
            this.strDV = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void setEndOfDay(boolean bEndOfDay) {
        this.bEndOfDay = bEndOfDay;
    }

    public boolean getEndOfDay() {
        return this.bEndOfDay;
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

    public String getName() {
        if (StringHelper.Length((String)this.strName) > 0) {
            return this.strName;
        }
        return this.getDBField();
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public String getItemFormat() {
        return this.strItemFormat;
    }

    public void setItemFormat(String strItemFormat) {
        this.strItemFormat = strItemFormat;
    }

    public String getCodeList() {
        return this.strCodeList;
    }

    public void setCodeList(String strCodeList) {
        this.strCodeList = strCodeList;
    }

    public String getDVT() {
        return this.strDVT;
    }

    public void setDVT(String strDVT) {
        this.strDVT = strDVT;
    }

    public String getDV() {
        return this.strDV;
    }

    public void setDV(String strDV) {
        this.strDV = strDV;
    }

    public boolean isKey() {
        return this.bKey;
    }

    public void setKey(boolean key) {
        this.bKey = key;
    }

    public boolean isParentKey() {
        return this.bParentKey;
    }

    public void setParentKey(boolean parentKey) {
        this.bParentKey = parentKey;
    }

    public String GetFormItemValue(SRFExWebContext webContext, BaseDataEntity dataEntity) {
        CodeListConfig codeListConfig;
        String strValue = DataEntityItemConfig.InternalGetFormItemValue(webContext, this, dataEntity);
        if (StringHelper.Length((String)this.getCodeList()) > 0 && (codeListConfig = webContext.getCodeListMgr().GetCodeListConfig(this.getCodeList())) != null) {
            strValue = codeListConfig.GetCodeListValue(strValue, false);
        }
        return strValue;
    }

    protected static String InternalGetFormItemValue(SRFExWebContext webContext, DataEntityItemConfig itemConfig, BaseDataEntity dataEntity) {
        ItemParamsConfig itemParamsConfig = itemConfig.getItemParamsConfig();
        String strItemFormat = itemConfig.getItemFormat();
        if (StringHelper.Length((String)strItemFormat) == 0) {
            Object objValue = dataEntity.GetParamValue(itemConfig.getDBField());
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
        if (itemParamsConfig == null) {
            Object objValue = dataEntity.GetParamValue(itemConfig.getDBField());
            if (objValue == null) {
                return "";
            }
            return StringHelper.Format((String)strItemFormat, (Object)objValue);
        }
        Object[] valueObj = new Object[itemParamsConfig.getList().size()];
        int i = 0;
        while (i < itemParamsConfig.getList().size()) {
            ItemParamConfig itemParamConfig = (ItemParamConfig)((Object)itemParamsConfig.getList().get(i));
            valueObj[i] = itemParamConfig.GetParamValue(webContext, dataEntity);
            if (valueObj[i] != null && StringHelper.Length((String)itemParamConfig.getCodeList()) > 0) {
                String strTempValue = valueObj[i].toString();
                CodeListConfig codeListConfig = webContext.getCodeListMgr().GetCodeListConfig(itemParamConfig.getCodeList());
                if (codeListConfig != null) {
                    valueObj[i] = codeListConfig.GetCodeListValue(strTempValue, false);
                }
            }
            ++i;
        }
        return StringHelper.Format((String)strItemFormat, (Object[])valueObj);
    }
}

