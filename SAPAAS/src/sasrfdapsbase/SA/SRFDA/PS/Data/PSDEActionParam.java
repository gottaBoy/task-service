/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEActionParam
extends BaseDataEntity {
    public static final String VALUETYPE_VALUE = "VALUE";
    public static final String VALUETYPE_NULLVALUE = "NULLVALUE";
    public static final String VALUETYPE_SESSION = "SESSION";
    public static final String VALUETYPE_APPLICATION = "APPLICATION";
    public static final String VALUETYPE_UNIQUEID = "UNIQUEID";
    public static final String VALUETYPE_CONTEXT = "CONTEXT";
    public static final String VALUETYPE_PARAM = "PARAM";
    public static final String VALUETYPE_OPERATOR = "OPERATOR";
    public static final String VALUETYPE_OPERATORNAME = "OPERATORNAME";
    public static final String VALUETYPE_CURTIME = "CURTIME";
    public static final String VALUETYPE_APPDATA = "APPDATA";
    public static final String VALUETYPE_NONEVALUE = "NONEVALUE";
    public static final String TAG_PSDEACTIONPARAMID = "PSDEACTIONPARAMID";
    public static final String TAG_PSDEACTIONPARAMNAME = "PSDEACTIONPARAMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_VALUETYPE = "VALUETYPE";
    public static final String TAG_VALUE = "VALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PARAMDESC = "PARAMDESC";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_STDDATATYPE = "STDDATATYPE";
    public static final String TAG_ARRAYFLAG = "ARRAYFLAG";
    public static final String TAG_PARAMTAG = "PARAMTAG";
    public static final String TAG_PARAMTAG2 = "PARAMTAG2";
    public static final String TAG_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String TAG_JSONFORMAT = "JSONFORMAT";

    public final boolean isPSDEACTIONPARAMIDNull() {
        return this.IsParamNull(TAG_PSDEACTIONPARAMID);
    }

    public final String getPSDEACTIONPARAMID() {
        return this.GetParamStringValue(TAG_PSDEACTIONPARAMID, "");
    }

    public final void setPSDEACTIONPARAMID(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONPARAMID, strValue);
    }

    public final boolean isPSDEACTIONPARAMNAMENull() {
        return this.IsParamNull(TAG_PSDEACTIONPARAMNAME);
    }

    public final String getPSDEACTIONPARAMNAME() {
        return this.GetParamStringValue(TAG_PSDEACTIONPARAMNAME, "");
    }

    public final void setPSDEACTIONPARAMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONPARAMNAME, strValue);
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

    public final boolean isPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_PSDEACTIONID);
    }

    public final String getPSDEACTIONID() {
        return this.GetParamStringValue(TAG_PSDEACTIONID, "");
    }

    public final void setPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONID, strValue);
    }

    public final boolean isPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDEACTIONNAME);
    }

    public final String getPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDEACTIONNAME, "");
    }

    public final void setPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONNAME, strValue);
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

    public final boolean isVALUENull() {
        return this.IsParamNull("VALUE");
    }

    public final String getVALUE() {
        return this.GetParamStringValue("VALUE", "");
    }

    public final void setVALUE(String strValue) {
        this.SetParamValue("VALUE", strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isPARAMTAGNull() {
        return this.IsParamNull(TAG_PARAMTAG);
    }

    public final String getPARAMTAG() {
        return this.GetParamStringValue(TAG_PARAMTAG, "");
    }

    public final void setPARAMTAG(String strValue) {
        this.SetParamValue(TAG_PARAMTAG, strValue);
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

    public final boolean isALLOWEMPTYNull() {
        return this.IsParamNull(TAG_ALLOWEMPTY);
    }

    public final boolean getALLOWEMPTY() {
        return this.GetParamIntValue(TAG_ALLOWEMPTY, 0) == 1;
    }

    public final void setALLOWEMPTY(boolean bValue) {
        this.SetParamValue(TAG_ALLOWEMPTY, bValue ? 1 : 0);
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
}

