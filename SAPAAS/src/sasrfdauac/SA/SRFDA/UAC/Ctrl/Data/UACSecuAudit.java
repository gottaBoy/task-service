/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.UAC.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class UACSecuAudit
extends BaseDataEntity {
    public static final String UACSECUAUDITNAME_WEBLOGIN = "\u7f51\u9875\u8ba4\u8bc1";
    public static final String TAG_UACSECUAUDITID = "UACSECUAUDITID";
    public static final String TAG_UACSECUAUDITNAME = "UACSECUAUDITNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_CLIENTADDR = "CLIENTADDR";
    public static final String TAG_PARAM = "PARAM";
    public static final String TAG_PARAM2 = "PARAM2";
    public static final String TAG_PARAM3 = "PARAM3";
    public static final String TAG_PARAM4 = "PARAM4";
    public static final String TAG_EVENTINFO = "EVENTINFO";
    public static final String TAG_SUCCESSFLAG = "SUCCESSFLAG";
    public static final String TAG_UACSERVERNAME = "UACSERVERNAME";
    public static final String TAG_UACSERVERID = "UACSERVERID";

    public String getUACSECUAUDITID() {
        return this.GetParamStringValue(TAG_UACSECUAUDITID, "");
    }

    public void setUACSECUAUDITID(String strValue) {
        this.SetParamValue(TAG_UACSECUAUDITID, strValue);
    }

    public String getUACSECUAUDITNAME() {
        return this.GetParamStringValue(TAG_UACSECUAUDITNAME, "");
    }

    public void setUACSECUAUDITNAME(String strValue) {
        this.SetParamValue(TAG_UACSECUAUDITNAME, strValue);
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

    public String getCLIENTADDR() {
        return this.GetParamStringValue(TAG_CLIENTADDR, "");
    }

    public void setCLIENTADDR(String strValue) {
        this.SetParamValue(TAG_CLIENTADDR, strValue);
    }

    public String getPARAM() {
        return this.GetParamStringValue(TAG_PARAM, "");
    }

    public void setPARAM(String strValue) {
        this.SetParamValue(TAG_PARAM, strValue);
    }

    public String getPARAM2() {
        return this.GetParamStringValue(TAG_PARAM2, "");
    }

    public void setPARAM2(String strValue) {
        this.SetParamValue(TAG_PARAM2, strValue);
    }

    public String getPARAM3() {
        return this.GetParamStringValue(TAG_PARAM3, "");
    }

    public void setPARAM3(String strValue) {
        this.SetParamValue(TAG_PARAM3, strValue);
    }

    public String getPARAM4() {
        return this.GetParamStringValue(TAG_PARAM4, "");
    }

    public void setPARAM4(String strValue) {
        this.SetParamValue(TAG_PARAM4, strValue);
    }

    public String getEVENTINFO() {
        return this.GetParamStringValue(TAG_EVENTINFO, "");
    }

    public void setEVENTINFO(String strValue) {
        this.SetParamValue(TAG_EVENTINFO, strValue);
    }

    public boolean getSUCCESSFLAG() {
        return this.GetParamIntValue(TAG_SUCCESSFLAG, 0) == 1;
    }

    public void setSUCCESSFLAG(boolean bValue) {
        this.SetParamValue(TAG_SUCCESSFLAG, bValue ? 1 : 0);
    }

    public String getUACSERVERNAME() {
        return this.GetParamStringValue(TAG_UACSERVERNAME, "");
    }

    public void setUACSERVERNAME(String strValue) {
        this.SetParamValue(TAG_UACSERVERNAME, strValue);
    }

    public String getUACSERVERID() {
        return this.GetParamStringValue(TAG_UACSERVERID, "");
    }

    public void setUACSERVERID(String strValue) {
        this.SetParamValue(TAG_UACSERVERID, strValue);
    }
}

