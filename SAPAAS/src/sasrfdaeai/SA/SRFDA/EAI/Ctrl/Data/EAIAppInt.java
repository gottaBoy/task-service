/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Ctrl.Data;

import SA.SRFDA.EAI.Ctrl.Data.BaseEAIObject;
import java.util.Date;

public class EAIAppInt
extends BaseEAIObject {
    public static final String TAG_EAIAPPINTID = "EAIAPPINTID";
    public static final String TAG_EAIAPPINTNAME = "EAIAPPINTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_APPINTTYPE = "APPINTTYPE";
    public static final String TAG_PORT = "PORT";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_PWD = "PWD";
    public static final String TAG_HOSTNAME = "HOSTNAME";
    public static final String TAG_SYNCMODE = "SYNCMODE";
    public static final String TAG_INTPARAM = "INTPARAM";
    public static final String TAG_EAIAPPINTFULLNAME = "EAIAPPINTFULLNAME";
    public static final String TAG_PARAM = "PARAM";
    public static final String TAG_PARAM2 = "PARAM2";
    public static final String TAG_PARAM3 = "PARAM3";
    public static final String TAG_PARAM6 = "PARAM6";
    public static final String TAG_PARAM8 = "PARAM8";
    public static final String TAG_PARAM4 = "PARAM4";
    public static final String TAG_PARAM5 = "PARAM5";
    public static final String TAG_ISONLINE = "ISONLINE";
    public static final String TAG_TIMEOUT = "TIMEOUT";
    public static final String TAG_PARAM7 = "PARAM7";
    public static final String TAG_EAIAPPNAME = "EAIAPPNAME";
    public static final String TAG_EAIOUTPRONAME = "EAIOUTPRONAME";
    public static final String TAG_EAIINPRONAME = "EAIINPRONAME";
    public static final String TAG_EAIACCLISTNAME = "EAIACCLISTNAME";
    public static final String TAG_EAIAPPID = "EAIAPPID";
    public static final String TAG_EAIOUTPROID = "EAIOUTPROID";
    public static final String TAG_EAIINPROID = "EAIINPROID";
    public static final String TAG_EAIACCLISTID = "EAIACCLISTID";
    public static final String TAG_ISKEEPALIVE = "ISKEEPALIVE";

    public String getEAIAPPINTID() {
        return this.GetParamStringValue(TAG_EAIAPPINTID, "");
    }

    public void setEAIAPPINTID(String strValue) {
        this.SetParamValue(TAG_EAIAPPINTID, strValue);
    }

    public String getEAIAPPINTNAME() {
        return this.GetParamStringValue(TAG_EAIAPPINTNAME, "");
    }

    public void setEAIAPPINTNAME(String strValue) {
        this.SetParamValue(TAG_EAIAPPINTNAME, strValue);
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

    public String getAPPINTTYPE() {
        return this.GetParamStringValue(TAG_APPINTTYPE, "");
    }

    public void setAPPINTTYPE(String strValue) {
        this.SetParamValue(TAG_APPINTTYPE, strValue);
    }

    public int getPORT(int nDefaultPort) {
        return this.GetParamIntValue(TAG_PORT, nDefaultPort);
    }

    public void setPORT(int nValue) {
        this.SetParamValue(TAG_PORT, nValue);
    }

    public String getUSERNAME() {
        return this.GetParamStringValue(TAG_USERNAME, "");
    }

    public void setUSERNAME(String strValue) {
        this.SetParamValue(TAG_USERNAME, strValue);
    }

    public String getPWD() {
        return this.GetParamStringValue(TAG_PWD, "");
    }

    public void setPWD(String strValue) {
        this.SetParamValue(TAG_PWD, strValue);
    }

    public String getHOSTNAME() {
        return this.GetParamStringValue(TAG_HOSTNAME, "");
    }

    public void setHOSTNAME(String strValue) {
        this.SetParamValue(TAG_HOSTNAME, strValue);
    }

    public boolean getSYNCMODE() {
        return this.GetParamIntValue(TAG_SYNCMODE, 0) == 1;
    }

    public void setSYNCMODE(boolean bValue) {
        this.SetParamValue(TAG_SYNCMODE, bValue ? 1 : 0);
    }

    public String getINTPARAM() {
        return this.GetParamStringValue(TAG_INTPARAM, "");
    }

    public void setINTPARAM(String strValue) {
        this.SetParamValue(TAG_INTPARAM, strValue);
    }

    public String getEAIAPPINTFULLNAME() {
        return this.GetParamStringValue(TAG_EAIAPPINTFULLNAME, "");
    }

    public void setEAIAPPINTFULLNAME(String strValue) {
        this.SetParamValue(TAG_EAIAPPINTFULLNAME, strValue);
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

    public String getPARAM6() {
        return this.GetParamStringValue(TAG_PARAM6, "");
    }

    public void setPARAM6(String strValue) {
        this.SetParamValue(TAG_PARAM6, strValue);
    }

    public boolean getPARAM8() {
        return this.GetParamIntValue(TAG_PARAM8, 0) == 1;
    }

    public void setPARAM8(boolean bValue) {
        this.SetParamValue(TAG_PARAM8, bValue ? 1 : 0);
    }

    public String getPARAM4() {
        return this.GetParamStringValue(TAG_PARAM4, "");
    }

    public void setPARAM4(String strValue) {
        this.SetParamValue(TAG_PARAM4, strValue);
    }

    public String getPARAM5() {
        return this.GetParamStringValue(TAG_PARAM5, "");
    }

    public void setPARAM5(String strValue) {
        this.SetParamValue(TAG_PARAM5, strValue);
    }

    public String getISONLINE() {
        return this.GetParamStringValue(TAG_ISONLINE, "");
    }

    public void setISONLINE(String strValue) {
        this.SetParamValue(TAG_ISONLINE, strValue);
    }

    public String getTIMEOUT() {
        return this.GetParamStringValue(TAG_TIMEOUT, "");
    }

    public void setTIMEOUT(String strValue) {
        this.SetParamValue(TAG_TIMEOUT, strValue);
    }

    public boolean getPARAM7() {
        return this.GetParamIntValue(TAG_PARAM7, 0) == 1;
    }

    public void setPARAM7(boolean bValue) {
        this.SetParamValue(TAG_PARAM7, bValue ? 1 : 0);
    }

    public String getEAIAPPNAME() {
        return this.GetParamStringValue(TAG_EAIAPPNAME, "");
    }

    public void setEAIAPPNAME(String strValue) {
        this.SetParamValue(TAG_EAIAPPNAME, strValue);
    }

    public String getEAIOUTPRONAME() {
        return this.GetParamStringValue(TAG_EAIOUTPRONAME, "");
    }

    public void setEAIOUTPRONAME(String strValue) {
        this.SetParamValue(TAG_EAIOUTPRONAME, strValue);
    }

    public String getEAIINPRONAME() {
        return this.GetParamStringValue(TAG_EAIINPRONAME, "");
    }

    public void setEAIINPRONAME(String strValue) {
        this.SetParamValue(TAG_EAIINPRONAME, strValue);
    }

    public String getEAIACCLISTNAME() {
        return this.GetParamStringValue(TAG_EAIACCLISTNAME, "");
    }

    public void setEAIACCLISTNAME(String strValue) {
        this.SetParamValue(TAG_EAIACCLISTNAME, strValue);
    }

    public String getEAIAPPID() {
        return this.GetParamStringValue(TAG_EAIAPPID, "");
    }

    public void setEAIAPPID(String strValue) {
        this.SetParamValue(TAG_EAIAPPID, strValue);
    }

    public String getEAIOUTPROID() {
        return this.GetParamStringValue(TAG_EAIOUTPROID, "");
    }

    public void setEAIOUTPROID(String strValue) {
        this.SetParamValue(TAG_EAIOUTPROID, strValue);
    }

    public String getEAIINPROID() {
        return this.GetParamStringValue(TAG_EAIINPROID, "");
    }

    public void setEAIINPROID(String strValue) {
        this.SetParamValue(TAG_EAIINPROID, strValue);
    }

    public String getEAIACCLISTID() {
        return this.GetParamStringValue(TAG_EAIACCLISTID, "");
    }

    public void setEAIACCLISTID(String strValue) {
        this.SetParamValue(TAG_EAIACCLISTID, strValue);
    }

    public boolean isKEEPALIVE() {
        return this.GetParamIntValue(TAG_ISKEEPALIVE, 1) == 1;
    }
}

