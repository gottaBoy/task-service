/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.UI.ItemParamsConfig
 */
package SA.SRFDA.Mobile.UIPart.Model;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.ItemParamsConfig;
import java.util.HashMap;
import org.w3c.dom.Node;

public class MBUIPartDSItemConfig
extends XMLConfig {
    public static final String TAG_MBUIPARTDSITEM = "SRFDAMBUIPARTDSITEM";
    public static final String TAG_ITEMFORMAT = "ITEMFORMAT";
    public static final String TAG_CUSTOM = "CUSTOM";
    public static final String TAG_KEY = "KEY";
    public static final String TAG_CODELIST = "CODELIST";
    public static final String TAG_EXCELCODELIST = "EXCELCODELIST";
    public static final String TAG_CSSCLASS = "CSSCLASS";
    public static final String TAG_EXCELFORMAT = "EXCELFORMAT";
    public static final String TAG_SORTPARAM = "SORTPARAM";
    public static final String TAG_DATATYPE = "DATATYPE";
    public static final String TAG_EDITITEMSRC = "EDITITEMSRC";
    public static final String TAG_KEYFORMAT = "KEYFORMAT";
    public static final String TAG_PRIVILEGEID = "PRIVILEGEID";
    protected String strItemFormat = "";
    protected String strExcelFormat = "";
    protected String strCustom = "";
    protected boolean bKey = false;
    protected ItemParamsConfig itemParamsConfig = null;
    protected String strCodeList = "";
    protected String strExcelCodeList = "";
    protected String strCssClass = "";
    protected String strKeyFormat = "";
    protected String strSortParam = "";
    protected int nDataType = 25;
    protected boolean bEditItemSrc = true;
    protected String strPrivilegeId = "";

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXITEMPARAMS", (boolean)true) == 0) {
            if (this.itemParamsConfig == null) {
                this.itemParamsConfig = new ItemParamsConfig();
            }
            this.itemParamsConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    protected void OnSetPropertyEx(HashMap<String, String> attrMap) {
        if (attrMap.size() == 0) {
            return;
        }
        String strValue = "";
        strValue = attrMap.remove(TAG_ITEMFORMAT);
        if (strValue != null) {
            this.strItemFormat = strValue;
        }
        if ((strValue = attrMap.remove(TAG_EXCELFORMAT)) != null) {
            this.strExcelFormat = strValue;
        }
        if ((strValue = attrMap.remove(TAG_CUSTOM)) != null) {
            this.strCustom = strValue;
        }
        if ((strValue = attrMap.remove(TAG_KEY)) != null) {
            this.bKey = MBUIPartDSItemConfig.GetValue((String)strValue, (boolean)this.bKey);
        }
        if ((strValue = attrMap.remove(TAG_EDITITEMSRC)) != null) {
            this.bEditItemSrc = MBUIPartDSItemConfig.GetValue((String)strValue, (boolean)this.bEditItemSrc);
        }
        if ((strValue = attrMap.remove(TAG_CODELIST)) != null) {
            this.strCodeList = strValue;
        }
        if ((strValue = attrMap.remove(TAG_EXCELCODELIST)) != null) {
            this.strExcelCodeList = strValue;
        }
        if ((strValue = attrMap.remove(TAG_CSSCLASS)) != null) {
            this.strCssClass = strValue;
        }
        if ((strValue = attrMap.remove(TAG_KEYFORMAT)) != null) {
            this.strKeyFormat = strValue;
        }
        if ((strValue = attrMap.remove(TAG_SORTPARAM)) != null) {
            this.strSortParam = strValue;
        }
        if ((strValue = attrMap.remove(TAG_DATATYPE)) != null) {
            this.nDataType = DataTypeHelper.FromString((String)strValue);
        }
        if ((strValue = attrMap.remove(TAG_PRIVILEGEID)) != null) {
            this.setPrivilegeId(strValue);
        }
        super.OnSetPropertyEx(attrMap);
    }

    public String getItemFormat() {
        return this.strItemFormat;
    }

    public void setItemFormat(String strItemFormat) {
        this.strItemFormat = strItemFormat;
    }

    public String getKeyFormat() {
        if (StringHelper.Length((String)this.strKeyFormat) > 0) {
            return this.strKeyFormat;
        }
        return this.getItemFormat();
    }

    public void setKeyFormat(String strKeyFormat) {
        this.strKeyFormat = strKeyFormat;
    }

    public String getExcelFormat() {
        if (StringHelper.Length((String)this.strExcelFormat) == 0) {
            return this.getItemFormat();
        }
        return this.strExcelFormat;
    }

    public void setExcelFormat(String strExcelFormat) {
        this.strExcelFormat = strExcelFormat;
    }

    public String getCustom() {
        return this.strCustom;
    }

    public void setCustom(String strCustom) {
        this.strCustom = strCustom;
    }

    public String getCodeList() {
        return this.strCodeList;
    }

    public void setCodeList(String strCodeList) {
        this.strCodeList = strCodeList;
    }

    public ItemParamsConfig getItemParamsConfig() {
        if (this.itemParamsConfig != null && this.itemParamsConfig.getList().size() == 0) {
            this.itemParamsConfig = null;
        }
        return this.itemParamsConfig;
    }

    public ItemParamsConfig getItemParamsConfig(boolean bCreateIfNull) {
        if (bCreateIfNull && this.itemParamsConfig == null) {
            this.itemParamsConfig = new ItemParamsConfig();
        }
        return this.itemParamsConfig;
    }

    public boolean getKey() {
        return this.bKey;
    }

    public void setKey(boolean bKey) {
        this.bKey = bKey;
    }

    public String getCssClass() {
        return this.strCssClass;
    }

    public void setCssClass(String strCssClass) {
        this.strCssClass = strCssClass;
    }

    public String getSortParam() {
        if (StringHelper.Length((String)this.strSortParam) == 0) {
            return this.getID();
        }
        return this.strSortParam;
    }

    public void setSortParam(String strSortParam) {
        this.strSortParam = strSortParam;
    }

    public int getDataType() {
        return this.nDataType;
    }

    public void setDataType(int nDataType) {
        this.nDataType = nDataType;
    }

    public String getExcelCodeList() {
        if (!StringHelper.IsNullOrEmpty((String)this.strExcelCodeList)) {
            return this.strExcelCodeList;
        }
        return this.getCodeList();
    }

    public void setExcelCodeList(String strExcelCodeList) {
        this.strExcelCodeList = strExcelCodeList;
    }

    public String getPrivilegeId() {
        return this.strPrivilegeId;
    }

    public void setPrivilegeId(String strPrivilegeId) {
        this.strPrivilegeId = strPrivilegeId;
    }
}

