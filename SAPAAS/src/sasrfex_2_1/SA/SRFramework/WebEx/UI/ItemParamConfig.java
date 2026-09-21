/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Utility.ContextHelper;

public class ItemParamConfig
extends XMLConfig {
    public static final String TAG_ITEMPARAM = "SRFEXITEMPARAM";
    public static final String TAG_ITEMFORMAT = "ITEMFORMAT";
    public static final String TAG_DEFAULT = "DEFAULT";
    public static final String TAG_KEYFORMAT = "KEYFORMAT";
    public static final String TAG_CODELIST = "CODELIST";
    protected String strItemFormat = "";
    protected String strDefault = "";
    protected String strCodeList = "";
    protected String strKeyFormat = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_ITEMFORMAT, (boolean)true) == 0) {
            this.strItemFormat = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_KEYFORMAT, (boolean)true) == 0) {
            this.strKeyFormat = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DEFAULT, (boolean)true) == 0) {
            this.strDefault = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CODELIST, (boolean)true) == 0) {
            this.strCodeList = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
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

    public String getDefault() {
        return this.strDefault;
    }

    public void setDefault(String strDefault) {
        this.strDefault = strDefault;
    }

    public String getCodeList() {
        return this.strCodeList;
    }

    public void setCodeList(String strCodeList) {
        this.strCodeList = strCodeList;
    }

    public Object GetParamValue(SRFExWebContext webContext, BaseDataEntity dataEntity) {
        return this.GetParamValue(webContext.getGlobalHelper(), dataEntity);
    }

    public Object GetParamValue(ContextHelper contextHelper, BaseDataEntity dataEntity) {
        CodeListConfig codeListConfig;
        Object objValue = dataEntity.GetParamValue(this.getID());
        if (objValue == null) {
            return this.getDefault();
        }
        if (StringHelper.Length((String)this.strItemFormat) != 0) {
            objValue = StringHelper.Format((String)this.strItemFormat, (Object)objValue);
        }
        if (StringHelper.Length((String)this.getCodeList()) != 0 && (codeListConfig = contextHelper.getCodeListMgr().GetCodeListConfig(this.getCodeList())) != null) {
            return codeListConfig.GetCodeListValue(objValue.toString(), false);
        }
        return objValue;
    }

    public Object GetParamValue(SRFExWebContext webContext, DataRow dataEntity) {
        return this.GetParamValue(webContext.getGlobalHelper(), dataEntity);
    }

    public Object GetParamValue(ContextHelper contextHelper, DataRow dataEntity) {
        try {
            CodeListConfig codeListConfig;
            Object objValue = dataEntity.Get(this.getID());
            if (objValue == null) {
                return this.getDefault();
            }
            if (StringHelper.Length((String)this.strItemFormat) != 0) {
                objValue = StringHelper.Format((String)this.strItemFormat, (Object)objValue);
            }
            if (StringHelper.Length((String)this.getCodeList()) != 0 && (codeListConfig = contextHelper.getCodeListMgr().GetCodeListConfig(this.getCodeList())) != null) {
                return codeListConfig.GetCodeListValue(objValue.toString(), false);
            }
            return objValue;
        }
        catch (Exception ex) {
            return null;
        }
    }
}

