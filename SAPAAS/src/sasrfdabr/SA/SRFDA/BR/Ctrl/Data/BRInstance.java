/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.BR.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Date;
import java.util.Properties;

public class BRInstance
extends BaseDataEntity {
    public static final String TAG_BRINSTANCEID = "BRINSTANCEID";
    public static final String TAG_BRINSTANCENAME = "BRINSTANCENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_INSTOBJECT = "INSTOBJECT";
    public static final String TAG_INSTPARAM = "INSTPARAM";
    public static final String TAG_INSTDATA = "INSTDATA";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_INSTDATA2 = "INSTDATA2";
    public static final String TAG_INSTDATA3 = "INSTDATA3";
    public static final String TAG_INSTDATA4 = "INSTDATA4";
    public static final String TAG_BRENGINEID = "BRENGINEID";
    public static final String TAG_BRENGINENAME = "BRENGINENAME";
    protected Properties instParams = null;

    public synchronized Properties getInstParam() {
        if (this.instParams != null) {
            return this.instParams;
        }
        try {
            this.instParams = PropertiesHelper.Load((String)this.getINSTPARAM());
            return this.instParams;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getBRINSTANCEID() {
        return this.GetParamStringValue(TAG_BRINSTANCEID, "");
    }

    public void setBRINSTANCEID(String strValue) {
        this.SetParamValue(TAG_BRINSTANCEID, strValue);
    }

    public String getBRINSTANCENAME() {
        return this.GetParamStringValue(TAG_BRINSTANCENAME, "");
    }

    public void setBRINSTANCENAME(String strValue) {
        this.SetParamValue(TAG_BRINSTANCENAME, strValue);
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

    public String getINSTOBJECT() {
        return this.GetParamStringValue(TAG_INSTOBJECT, "");
    }

    public void setINSTOBJECT(String strValue) {
        this.SetParamValue(TAG_INSTOBJECT, strValue);
    }

    public String getINSTPARAM() {
        return this.GetParamStringValue(TAG_INSTPARAM, "");
    }

    public void setINSTPARAM(String strValue) {
        this.SetParamValue(TAG_INSTPARAM, strValue);
    }

    public String getINSTDATA() {
        return this.GetParamStringValue(TAG_INSTDATA, "");
    }

    public void setINSTDATA(String strValue) {
        this.SetParamValue(TAG_INSTDATA, strValue);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public String getINSTDATA2() {
        return this.GetParamStringValue(TAG_INSTDATA2, "");
    }

    public void setINSTDATA2(String strValue) {
        this.SetParamValue(TAG_INSTDATA2, strValue);
    }

    public String getINSTDATA3() {
        return this.GetParamStringValue(TAG_INSTDATA3, "");
    }

    public void setINSTDATA3(String strValue) {
        this.SetParamValue(TAG_INSTDATA3, strValue);
    }

    public String getINSTDATA4() {
        return this.GetParamStringValue(TAG_INSTDATA4, "");
    }

    public void setINSTDATA4(String strValue) {
        this.SetParamValue(TAG_INSTDATA4, strValue);
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
}

