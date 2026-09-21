/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class EAIProcessConfig
extends BaseDataEntity {
    public static final String TAG_EAIPROCESSCONFIGID = "EAIPROCESSCONFIGID";
    public static final String TAG_EAIPROCESSCONFIGNAME = "EAIPROCESSCONFIGNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PARAM1 = "PARAM1";
    public static final String TAG_PARAM2 = "PARAM2";
    public static final String TAG_PARAM3 = "PARAM3";
    public static final String TAG_PARAM4 = "PARAM4";
    public static final String TAG_PARAM5 = "PARAM5";
    public static final String TAG_PARAM6 = "PARAM6";
    public static final String TAG_PARAM7 = "PARAM7";
    public static final String TAG_PARAM8 = "PARAM8";
    public static final String TAG_PARAM9 = "PARAM9";
    public static final String TAG_PARAM10 = "PARAM10";
    public static final String TAG_PARAM11 = "PARAM11";
    public static final String TAG_PARAM12 = "PARAM12";
    public static final String TAG_EAIDATASOURCENAME = "EAIDATASOURCENAME";
    public static final String TAG_EAISERVICENAME = "EAISERVICENAME";
    public static final String TAG_EAIDATASOURCEID = "EAIDATASOURCEID";
    public static final String TAG_EAISERVICEID = "EAISERVICEID";
    public static final String TAG_PROCESSID = "PROCESSID";
    public static final String TAG_SYNCMODE = "SYNCMODE";
    public static final String TAG_TSFPARAMS = "TSFPARAMS";
    public static final String TAG_REPTSFPARAMS = "REPTSFPARAMS";
    public static final String TAG_PARAMS = "PARAMS";
    public static final String TAG_COMOBJECT = "COMOBJECT";
    public static final String TAG_EAIPROTOCOLID = "EAIPROTOCOLID";
    public static final String TAG_EAIIBREPPROTOCOLID = "EAIIBREPPROTOCOLID";
    public static final String TAG_EAIOBPROTOCOLID = "EAIOBPROTOCOLID";
    public static final String TAG_OBTSFPARAMS = "OBTSFPARAMS";
    public static final String TAG_EAIPROTOCOLNAME = "EAIPROTOCOLNAME";
    public static final String TAG_EAIIBREPPROTOCOLNAME = "EAIIBREPPROTOCOLNAME";
    public static final String TAG_EAIOBPROTOCOLNAME = "EAIOBPROTOCOLNAME";
    public static final String TAG_EAIOBREPPROTOCOLID = "EAIOBREPPROTOCOLID";
    public static final String TAG_OBREPTSFPARAMS = "OBREPTSFPARAMS";
    public static final String TAG_EAIAPPINTID = "EAIAPPINTID";
    public static final String TAG_TRANMODE = "TRANMODE";
    public static final String TAG_TRANTIMEOUT = "TRANTIMEOUT";

    public String getEAIPROCESSCONFIGID() {
        return this.GetParamStringValue(TAG_EAIPROCESSCONFIGID, "");
    }

    public void setEAIPROCESSCONFIGID(String strValue) {
        this.SetParamValue(TAG_EAIPROCESSCONFIGID, strValue);
    }

    public String getEAIPROCESSCONFIGNAME() {
        return this.GetParamStringValue(TAG_EAIPROCESSCONFIGNAME, "");
    }

    public void setEAIPROCESSCONFIGNAME(String strValue) {
        this.SetParamValue(TAG_EAIPROCESSCONFIGNAME, strValue);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public int getPARAM1(int nDefault) {
        return this.GetParamIntValue(TAG_PARAM1, nDefault);
    }

    public void setPARAM1(int nValue) {
        this.SetParamValue(TAG_PARAM1, nValue);
    }

    public int getPARAM2(int nDefault) {
        return this.GetParamIntValue(TAG_PARAM2, nDefault);
    }

    public void setPARAM2(int nValue) {
        this.SetParamValue(TAG_PARAM2, nValue);
    }

    public int getPARAM11(int nDefault) {
        return this.GetParamIntValue(TAG_PARAM11, nDefault);
    }

    public void setPARAM11(int nValue) {
        this.SetParamValue(TAG_PARAM11, nValue);
    }

    public int getPARAM12(int nDefault) {
        return this.GetParamIntValue(TAG_PARAM12, nDefault);
    }

    public void setPARAM12(int nValue) {
        this.SetParamValue(TAG_PARAM12, nValue);
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

    public String getPARAM5() {
        return this.GetParamStringValue(TAG_PARAM5, "");
    }

    public void setPARAM5(String strValue) {
        this.SetParamValue(TAG_PARAM5, strValue);
    }

    public String getPARAM6() {
        return this.GetParamStringValue(TAG_PARAM6, "");
    }

    public void setPARAM6(String strValue) {
        this.SetParamValue(TAG_PARAM6, strValue);
    }

    public String getPARAM7() {
        return this.GetParamStringValue(TAG_PARAM7, "");
    }

    public void setPARAM7(String strValue) {
        this.SetParamValue(TAG_PARAM7, strValue);
    }

    public String getPARAM8() {
        return this.GetParamStringValue(TAG_PARAM8, "");
    }

    public void setPARAM8(String strValue) {
        this.SetParamValue(TAG_PARAM8, strValue);
    }

    public String getPARAM9() {
        return this.GetParamStringValue(TAG_PARAM9, "");
    }

    public void setPARAM9(String strValue) {
        this.SetParamValue(TAG_PARAM9, strValue);
    }

    public String getPARAM10() {
        return this.GetParamStringValue(TAG_PARAM10, "");
    }

    public void setPARAM10(String strValue) {
        this.SetParamValue(TAG_PARAM10, strValue);
    }

    public String getEAIDATASOURCENAME() {
        return this.GetParamStringValue(TAG_EAIDATASOURCENAME, "");
    }

    public void setEAIDATASOURCENAME(String strValue) {
        this.SetParamValue(TAG_EAIDATASOURCENAME, strValue);
    }

    public String getEAISERVICENAME() {
        return this.GetParamStringValue(TAG_EAISERVICENAME, "");
    }

    public void setEAISERVICENAME(String strValue) {
        this.SetParamValue(TAG_EAISERVICENAME, strValue);
    }

    public String getEAIDATASOURCEID() {
        return this.GetParamStringValue(TAG_EAIDATASOURCEID, "");
    }

    public void setEAIDATASOURCEID(String strValue) {
        this.SetParamValue(TAG_EAIDATASOURCEID, strValue);
    }

    public String getEAISERVICEID() {
        return this.GetParamStringValue(TAG_EAISERVICEID, "");
    }

    public void setEAISERVICEID(String strValue) {
        this.SetParamValue(TAG_EAISERVICEID, strValue);
    }

    public String getPROCESSID() {
        return this.GetParamStringValue(TAG_PROCESSID, "");
    }

    public void setPROCESSID(String strValue) {
        this.SetParamValue(TAG_PROCESSID, strValue);
    }

    public boolean getSYNCMODE() {
        return this.GetParamIntValue(TAG_SYNCMODE, 0) == 1;
    }

    public void setSYNCMODE(boolean bValue) {
        this.SetParamValue(TAG_SYNCMODE, bValue ? 1 : 0);
    }

    public String getTSFPARAMS() {
        return this.GetParamStringValue(TAG_TSFPARAMS, "");
    }

    public void setTSFPARAMS(String strValue) {
        this.SetParamValue(TAG_TSFPARAMS, strValue);
    }

    public String getREPTSFPARAMS() {
        return this.GetParamStringValue(TAG_REPTSFPARAMS, "");
    }

    public void setREPTSFPARAMS(String strValue) {
        this.SetParamValue(TAG_REPTSFPARAMS, strValue);
    }

    public String getEAIPROTOCOLID() {
        return this.GetParamStringValue(TAG_EAIPROTOCOLID, "");
    }

    public void setEAIPROTOCOLID(String strValue) {
        this.SetParamValue(TAG_EAIPROTOCOLID, strValue);
    }

    public String getCOMOBJECT() {
        return this.GetParamStringValue(TAG_COMOBJECT, "");
    }

    public void setCOMOBJECT(String strValue) {
        this.SetParamValue(TAG_COMOBJECT, strValue);
    }

    public String getPARAMS() {
        return this.GetParamStringValue(TAG_PARAMS, "");
    }

    public void setPARAMS(String strValue) {
        this.SetParamValue(TAG_PARAMS, strValue);
    }

    public String getPARAM1() {
        return this.GetParamStringValue(TAG_PARAM1, "");
    }

    public void setPARAM1(String strValue) {
        this.SetParamValue(TAG_PARAM1, strValue);
    }

    public String getPARAM2() {
        return this.GetParamStringValue(TAG_PARAM2, "");
    }

    public void setPARAM2(String strValue) {
        this.SetParamValue(TAG_PARAM2, strValue);
    }

    public String getPARAM11() {
        return this.GetParamStringValue(TAG_PARAM11, "");
    }

    public void setPARAM11(String strValue) {
        this.SetParamValue(TAG_PARAM11, strValue);
    }

    public String getPARAM12() {
        return this.GetParamStringValue(TAG_PARAM12, "");
    }

    public void setPARAM12(String strValue) {
        this.SetParamValue(TAG_PARAM12, strValue);
    }

    public String getOBTSFPARAMS() {
        return this.GetParamStringValue(TAG_OBTSFPARAMS, "");
    }

    public void setOBTSFPARAMS(String strValue) {
        this.SetParamValue(TAG_OBTSFPARAMS, strValue);
    }

    public String getEAIPROTOCOLNAME() {
        return this.GetParamStringValue(TAG_EAIPROTOCOLNAME, "");
    }

    public void setEAIPROTOCOLNAME(String strValue) {
        this.SetParamValue(TAG_EAIPROTOCOLNAME, strValue);
    }

    public String getEAIIBREPPROTOCOLNAME() {
        return this.GetParamStringValue(TAG_EAIIBREPPROTOCOLNAME, "");
    }

    public void setEAIIBREPPROTOCOLNAME(String strValue) {
        this.SetParamValue(TAG_EAIIBREPPROTOCOLNAME, strValue);
    }

    public String getEAIOBPROTOCOLNAME() {
        return this.GetParamStringValue(TAG_EAIOBPROTOCOLNAME, "");
    }

    public void setEAIOBPROTOCOLNAME(String strValue) {
        this.SetParamValue(TAG_EAIOBPROTOCOLNAME, strValue);
    }

    public String getEAIIBREPPROTOCOLID() {
        return this.GetParamStringValue(TAG_EAIIBREPPROTOCOLID, "");
    }

    public void setEAIIBREPPROTOCOLID(String strValue) {
        this.SetParamValue(TAG_EAIIBREPPROTOCOLID, strValue);
    }

    public String getEAIOBPROTOCOLID() {
        return this.GetParamStringValue(TAG_EAIOBPROTOCOLID, "");
    }

    public void setEAIOBPROTOCOLID(String strValue) {
        this.SetParamValue(TAG_EAIOBPROTOCOLID, strValue);
    }

    public String getEAIOBREPPROTOCOLID() {
        return this.GetParamStringValue(TAG_EAIOBREPPROTOCOLID, "");
    }

    public void setEAIOBREPPROTOCOLID(String strValue) {
        this.SetParamValue(TAG_EAIOBREPPROTOCOLID, strValue);
    }

    public String getOBREPTSFPARAMS() {
        return this.GetParamStringValue(TAG_OBREPTSFPARAMS, "");
    }

    public void setOBREPTSFPARAMS(String strValue) {
        this.SetParamValue(TAG_OBREPTSFPARAMS, strValue);
    }

    public String getEAIAPPINTID() {
        return this.GetParamStringValue(TAG_EAIAPPINTID, "");
    }

    public void setEAIAPPINTID(String strValue) {
        this.SetParamValue(TAG_EAIAPPINTID, strValue);
    }

    public String getTRANMODE() {
        return this.GetParamStringValue(TAG_TRANMODE, "");
    }

    public void setTRANMODE(String strValue) {
        this.SetParamValue(TAG_TRANMODE, strValue);
    }

    public int getTRANTIMEOUT() {
        return this.GetParamIntValue(TAG_TRANTIMEOUT, 0);
    }

    public void setTRANTIMEOUT(int strValue) {
        this.SetParamValue(TAG_TRANTIMEOUT, strValue);
    }
}

