/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Date;
import java.util.Properties;

public class Registry
extends BaseDataEntity {
    public static final String TAG_REGISTRYID = "REGISTRYID";
    public static final String TAG_REGISTRYNAME = "REGISTRYNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SECTION = "SECTION";
    public static final String TAG_PARAM1 = "PARAM1";
    public static final String TAG_PARAM2 = "PARAM2";
    public static final String TAG_PARAM3 = "PARAM3";
    public static final String TAG_PARAM4 = "PARAM4";
    public static final String TAG_PARAM5 = "PARAM5";
    public static final String TAG_PARAM6 = "PARAM6";
    public static final String TAG_PARAM7 = "PARAM7";
    public static final String TAG_PARAM8 = "PARAM8";
    public static final String TAG_PARAM9 = "PARAM9";
    private Properties registerParams = null;

    public String getREGISTRYID() {
        return this.GetParamStringValue(TAG_REGISTRYID, "");
    }

    public void setREGISTRYID(String strValue) {
        this.SetParamValue(TAG_REGISTRYID, strValue);
    }

    public String getREGISTRYNAME() {
        return this.GetParamStringValue(TAG_REGISTRYNAME, "");
    }

    public void setREGISTRYNAME(String strValue) {
        this.SetParamValue(TAG_REGISTRYNAME, strValue);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public String getSECTION() {
        return this.GetParamStringValue(TAG_SECTION, "");
    }

    public void setSECTION(String strValue) {
        this.SetParamValue(TAG_SECTION, strValue);
    }

    protected void OnReset() {
        super.OnReset();
        this.registerParams = null;
    }

    private void BuildProperties() {
        try {
            if (this.registerParams != null) {
                return;
            }
            String strParam = this.getPARAM9("");
            this.registerParams = !StringHelper.IsNullOrEmpty((String)strParam) ? PropertiesHelper.Load((Properties)this.registerParams, (String)strParam) : new Properties();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Properties GetParams() {
        this.BuildProperties();
        return this.registerParams;
    }

    public String GetParam(String strKey, String strDefault) {
        this.BuildProperties();
        return PropertiesHelper.GetProperty((Properties)this.registerParams, (String)strKey, (String)strDefault);
    }

    public int GetParam(String strKey, int nDefault) {
        this.BuildProperties();
        String strValue = PropertiesHelper.GetProperty((Properties)this.registerParams, (String)strKey);
        if (strValue == null) {
            return nDefault;
        }
        return Integer.parseInt(strValue);
    }

    public String getPARAM9(String strValue) {
        return this.GetParamStringValue(TAG_PARAM9, strValue);
    }

    public void setPARAM9(String strValue) {
        this.SetParamValue(TAG_PARAM9, strValue);
    }
}

