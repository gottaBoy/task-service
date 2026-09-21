/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.BR.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Date;
import java.util.Properties;

public class BREngine
extends BaseDataEntity {
    public static final String TAG_BRENGINEID = "BRENGINEID";
    public static final String TAG_BRENGINENAME = "BRENGINENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_TIMECOUNTER = "TIMECOUNTER";
    public static final String TAG_MINOBJCNT = "MINOBJCNT";
    public static final String TAG_MAXOBJCNT = "MAXOBJCNT";
    public static final String TAG_ENGINEOBJECT = "ENGINEOBJECT";
    public static final String TAG_ENGINEPARAM = "ENGINEPARAM";
    private Properties engineParams = null;

    public Properties getEngineParams() {
        if (this.engineParams != null) {
            return this.engineParams;
        }
        this.engineParams = new Properties();
        if (!StringHelper.IsNullOrEmpty((String)this.getENGINEPARAM())) {
            try {
                this.engineParams = PropertiesHelper.Load((Properties)this.engineParams, (String)this.getENGINEPARAM());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.engineParams;
    }

    public String GetEngineParam(String strName, String strDefault) {
        if (this.getEngineParams() == null) {
            return strDefault;
        }
        String strValue = PropertiesHelper.GetProperty((Properties)this.getEngineParams(), (String)strName);
        if (strValue == null) {
            return strDefault;
        }
        return strValue;
    }

    public String getBRENGINEID() {
        return this.GetParamStringValue(TAG_BRENGINEID, "");
    }

    public void setBRENGINEID(String strValue) {
        this.SetParamValue(TAG_BRENGINEID, strValue);
    }

    public String getBRENGINENAME() {
        return this.GetParamStringValue(TAG_BRENGINENAME, "");
    }

    public void setBRENGINENAME(String strValue) {
        this.SetParamValue(TAG_BRENGINENAME, strValue);
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

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public int getTIMECOUNTER() {
        return this.GetParamIntValue(TAG_TIMECOUNTER, 0);
    }

    public void setTIMECOUNTER(int strValue) {
        this.SetParamValue(TAG_TIMECOUNTER, strValue);
    }

    public int getMINOBJCNT() {
        return this.GetParamIntValue(TAG_MINOBJCNT, 0);
    }

    public void setMINOBJCNT(int strValue) {
        this.SetParamValue(TAG_MINOBJCNT, strValue);
    }

    public int getMAXOBJCNT() {
        return this.GetParamIntValue(TAG_MAXOBJCNT, 0);
    }

    public void setMAXOBJCNT(int strValue) {
        this.SetParamValue(TAG_MAXOBJCNT, strValue);
    }

    public String getENGINEOBJECT() {
        return this.GetParamStringValue(TAG_ENGINEOBJECT, "");
    }

    public void setENGINEOBJECT(String strValue) {
        this.SetParamValue(TAG_ENGINEOBJECT, strValue);
    }

    public String getENGINEPARAM() {
        return this.GetParamStringValue(TAG_ENGINEPARAM, "");
    }

    public void setENGINEPARAM(String strValue) {
        this.SetParamValue(TAG_ENGINEPARAM, strValue);
    }
}

