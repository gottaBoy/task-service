/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BR.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;

public class BRInstParam
extends BaseDataEntity {
    public static final String UPDATEMODE_OVERWRITE = "1";
    public static final String UPDATEMODE_ADD = "2";
    public static final String UPDATEMODE_SUBTRACTION = "3";
    public static final String UPDATEMODE_AVG = "4";
    public static final String TAG_BRINSTPARAMID = "BRINSTPARAMID";
    public static final String TAG_BRINSTPARAMNAME = "BRINSTPARAMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BRENGINEID = "BRENGINEID";
    public static final String TAG_BRENGINENAME = "BRENGINENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_INITVALUE = "INITVALUE";
    public static final String TAG_UPDATEMODE = "UPDATEMODE";
    public static final String TAG_RESETCOUNTER = "RESETCOUNTER";
    public static final String TAG_PBRINSTPARAMID = "PBRINSTPARAMID";
    public static final String TAG_PBRINSTPARAMNAME = "PBRINSTPARAMNAME";
    protected long nLastTickValue = 0L;

    public long getLastTickValue() {
        return this.nLastTickValue;
    }

    public void setLastTickValue(long nLastTickValue) {
        this.nLastTickValue = nLastTickValue;
    }

    public String getRefParamName() {
        if (!StringHelper.IsNullOrEmpty((String)this.getPBRINSTPARAMNAME())) {
            return this.getPBRINSTPARAMNAME();
        }
        return this.getBRINSTPARAMNAME();
    }

    public double getInitValue() {
        String strInitValue = this.getINITVALUE();
        if (StringHelper.IsNullOrEmpty((String)strInitValue)) {
            return 0.0;
        }
        return Double.parseDouble(strInitValue);
    }

    public String getBRINSTPARAMID() {
        return this.GetParamStringValue(TAG_BRINSTPARAMID, "");
    }

    public void setBRINSTPARAMID(String strValue) {
        this.SetParamValue(TAG_BRINSTPARAMID, strValue);
    }

    public String getBRINSTPARAMNAME() {
        return this.GetParamStringValue(TAG_BRINSTPARAMNAME, "");
    }

    public void setBRINSTPARAMNAME(String strValue) {
        this.SetParamValue(TAG_BRINSTPARAMNAME, strValue);
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

    public String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public String getINITVALUE() {
        return this.GetParamStringValue(TAG_INITVALUE, "");
    }

    public void setINITVALUE(String strValue) {
        this.SetParamValue(TAG_INITVALUE, strValue);
    }

    public String getUPDATEMODE() {
        return this.GetParamStringValue(TAG_UPDATEMODE, "");
    }

    public void setUPDATEMODE(String strValue) {
        this.SetParamValue(TAG_UPDATEMODE, strValue);
    }

    public int getRESETCOUNTER() {
        return this.GetParamIntValue(TAG_RESETCOUNTER, 0);
    }

    public void setRESETCOUNTER(int strValue) {
        this.SetParamValue(TAG_RESETCOUNTER, strValue);
    }

    public String getPBRINSTPARAMID() {
        return this.GetParamStringValue(TAG_PBRINSTPARAMID, "");
    }

    public void setPBRINSTPARAMID(String strValue) {
        this.SetParamValue(TAG_PBRINSTPARAMID, strValue);
    }

    public String getPBRINSTPARAMNAME() {
        return this.GetParamStringValue(TAG_PBRINSTPARAMNAME, "");
    }

    public void setPBRINSTPARAMNAME(String strValue) {
        this.SetParamValue(TAG_PBRINSTPARAMNAME, strValue);
    }
}

