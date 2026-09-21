/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEDSParam
extends BaseDataEntity {
    public static final String TAG_PSDEDSPARAMID = "PSDEDSPARAMID";
    public static final String TAG_PSDEDSPARAMNAME = "PSDEDSPARAMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_JSONFORMAT = "JSONFORMAT";
    public static final String TAG_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String TAG_PARAMTAG2 = "PARAMTAG2";
    public static final String TAG_PARAMTAG = "PARAMTAG";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_VALUEDESC = "VALUEDESC";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PARAMDESC = "PARAMDESC";
    public static final String TAG_VALUE = "VALUE";
    public static final String TAG_VALUETYPE = "VALUETYPE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSDEFSFITEMID = "PSDEFSFITEMID";
    public static final String TAG_PSDEFSFITEMNAME = "PSDEFSFITEMNAME";
    public static final String TAG_ARRAYFLAG = "ARRAYFLAG";
    public static final String TAG_STDDATATYPE = "STDDATATYPE";
    public static final String TAG_PSDEFVALUERULEID = "PSDEFVALUERULEID";
    public static final String TAG_PSDEFVALUERULENAME = "PSDEFVALUERULENAME";
    public static final String TAG_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String TAG_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";

    public final boolean isPSDEDSPARAMIDNull() {
        return this.IsParamNull(TAG_PSDEDSPARAMID);
    }

    public final String getPSDEDSPARAMID() {
        return this.GetParamStringValue(TAG_PSDEDSPARAMID, "");
    }

    public final void setPSDEDSPARAMID(String strValue) {
        this.SetParamValue(TAG_PSDEDSPARAMID, strValue);
    }

    public final boolean isPSDEDSPARAMNAMENull() {
        return this.IsParamNull(TAG_PSDEDSPARAMNAME);
    }

    public final String getPSDEDSPARAMNAME() {
        return this.GetParamStringValue(TAG_PSDEDSPARAMNAME, "");
    }

    public final void setPSDEDSPARAMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDSPARAMNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSDEDSIDNull() {
        return this.IsParamNull(TAG_PSDEDSID);
    }

    public final String getPSDEDSID() {
        return this.GetParamStringValue(TAG_PSDEDSID, "");
    }

    public final void setPSDEDSID(String strValue) {
        this.SetParamValue(TAG_PSDEDSID, strValue);
    }

    public final boolean isPSDEDSNAMENull() {
        return this.IsParamNull(TAG_PSDEDSNAME);
    }

    public final String getPSDEDSNAME() {
        return this.GetParamStringValue(TAG_PSDEDSNAME, "");
    }

    public final void setPSDEDSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDSNAME, strValue);
    }

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isJSONFORMATNull() {
        return this.IsParamNull(TAG_JSONFORMAT);
    }

    public final String getJSONFORMAT() {
        return this.GetParamStringValue(TAG_JSONFORMAT, "");
    }

    public final void setJSONFORMAT(String strValue) {
        this.SetParamValue(TAG_JSONFORMAT, strValue);
    }

    public final boolean isALLOWEMPTYNull() {
        return this.IsParamNull(TAG_ALLOWEMPTY);
    }

    public final boolean getALLOWEMPTY() {
        return this.GetParamIntValue(TAG_ALLOWEMPTY, 0) == 1;
    }

    public final void setALLOWEMPTY(boolean bValue) {
        this.SetParamValue(TAG_ALLOWEMPTY, bValue ? 1 : 0);
    }

    public final boolean isPARAMTAG2Null() {
        return this.IsParamNull(TAG_PARAMTAG2);
    }

    public final String getPARAMTAG2() {
        return this.GetParamStringValue(TAG_PARAMTAG2, "");
    }

    public final void setPARAMTAG2(String strValue) {
        this.SetParamValue(TAG_PARAMTAG2, strValue);
    }

    public final boolean isPARAMTAGNull() {
        return this.IsParamNull(TAG_PARAMTAG);
    }

    public final String getPARAMTAG() {
        return this.GetParamStringValue(TAG_PARAMTAG, "");
    }

    public final void setPARAMTAG(String strValue) {
        this.SetParamValue(TAG_PARAMTAG, strValue);
    }

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
    }

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
    }

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isVALUEDESCNull() {
        return this.IsParamNull(TAG_VALUEDESC);
    }

    public final String getVALUEDESC() {
        return this.GetParamStringValue(TAG_VALUEDESC, "");
    }

    public final void setVALUEDESC(String strValue) {
        this.SetParamValue(TAG_VALUEDESC, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPARAMDESCNull() {
        return this.IsParamNull(TAG_PARAMDESC);
    }

    public final String getPARAMDESC() {
        return this.GetParamStringValue(TAG_PARAMDESC, "");
    }

    public final void setPARAMDESC(String strValue) {
        this.SetParamValue(TAG_PARAMDESC, strValue);
    }

    public final boolean isVALUENull() {
        return this.IsParamNull(TAG_VALUE);
    }

    public final String getVALUE() {
        return this.GetParamStringValue(TAG_VALUE, "");
    }

    public final void setVALUE(String strValue) {
        this.SetParamValue(TAG_VALUE, strValue);
    }

    public final boolean isVALUETYPENull() {
        return this.IsParamNull(TAG_VALUETYPE);
    }

    public final String getVALUETYPE() {
        return this.GetParamStringValue(TAG_VALUETYPE, "");
    }

    public final void setVALUETYPE(String strValue) {
        this.SetParamValue(TAG_VALUETYPE, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isPSDEFSFITEMIDNull() {
        return this.IsParamNull(TAG_PSDEFSFITEMID);
    }

    public final String getPSDEFSFITEMID() {
        return this.GetParamStringValue(TAG_PSDEFSFITEMID, "");
    }

    public final void setPSDEFSFITEMID(String strValue) {
        this.SetParamValue(TAG_PSDEFSFITEMID, strValue);
    }

    public final boolean isPSDEFSFITEMNAMENull() {
        return this.IsParamNull(TAG_PSDEFSFITEMNAME);
    }

    public final String getPSDEFSFITEMNAME() {
        return this.GetParamStringValue(TAG_PSDEFSFITEMNAME, "");
    }

    public final void setPSDEFSFITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFSFITEMNAME, strValue);
    }

    public final boolean isARRAYFLAGNull() {
        return this.IsParamNull(TAG_ARRAYFLAG);
    }

    public final boolean getARRAYFLAG() {
        return this.GetParamIntValue(TAG_ARRAYFLAG, 0) == 1;
    }

    public final void setARRAYFLAG(boolean bValue) {
        this.SetParamValue(TAG_ARRAYFLAG, bValue ? 1 : 0);
    }

    public final boolean isSTDDATATYPENull() {
        return this.IsParamNull(TAG_STDDATATYPE);
    }

    public final int getSTDDATATYPE() {
        return this.GetParamIntValue(TAG_STDDATATYPE, 0);
    }

    public final void setSTDDATATYPE(int nValue) {
        this.SetParamValue(TAG_STDDATATYPE, nValue);
    }

    public final boolean isPSDEFVALUERULEIDNull() {
        return this.IsParamNull(TAG_PSDEFVALUERULEID);
    }

    public final String getPSDEFVALUERULEID() {
        return this.GetParamStringValue(TAG_PSDEFVALUERULEID, "");
    }

    public final void setPSDEFVALUERULEID(String strValue) {
        this.SetParamValue(TAG_PSDEFVALUERULEID, strValue);
    }

    public final boolean isPSDEFVALUERULENAMENull() {
        return this.IsParamNull(TAG_PSDEFVALUERULENAME);
    }

    public final String getPSDEFVALUERULENAME() {
        return this.GetParamStringValue(TAG_PSDEFVALUERULENAME, "");
    }

    public final void setPSDEFVALUERULENAME(String strValue) {
        this.SetParamValue(TAG_PSDEFVALUERULENAME, strValue);
    }

    public final boolean isPSSYSVALUERULEIDNull() {
        return this.IsParamNull(TAG_PSSYSVALUERULEID);
    }

    public final String getPSSYSVALUERULEID() {
        return this.GetParamStringValue(TAG_PSSYSVALUERULEID, "");
    }

    public final void setPSSYSVALUERULEID(String strValue) {
        this.SetParamValue(TAG_PSSYSVALUERULEID, strValue);
    }

    public final boolean isPSSYSVALUERULENAMENull() {
        return this.IsParamNull(TAG_PSSYSVALUERULENAME);
    }

    public final String getPSSYSVALUERULENAME() {
        return this.GetParamStringValue(TAG_PSSYSVALUERULENAME, "");
    }

    public final void setPSSYSVALUERULENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVALUERULENAME, strValue);
    }
}

