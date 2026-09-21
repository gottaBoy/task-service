/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DBProcPkgParam
extends BaseDataEntity {
    public static final String PARAMTYPE_IN = "IN";
    public static final String PARAMTYPE_INOUT = "INOUT";
    public static final String PARAMTYPE_OUT = "OUT";
    public static final String PARAMTYPE_INTERNAL = "INTERNAL";
    public static final String TAG_EAIDBOPPKGPARAMID = "EAIDBOPPKGPARAMID";
    public static final String TAG_EAIDBOPPKGPARAMNAME = "EAIDBOPPKGPARAMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_EAIDBOPPKGID = "EAIDBOPPKGID";
    public static final String TAG_EAIDBOPPKGNAME = "EAIDBOPPKGNAME";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_DATATYPE = "DATATYPE";
    public static final String TAG_LENGTH = "LENGTH";
    public static final String TAG_PRECISION2 = "PRECISION2";
    public static final String TAG_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String TAG_PARAMTYPE = "PARAMTYPE";

    public boolean isEAIDBOPPKGPARAMIDNull() {
        return this.IsParamNull(TAG_EAIDBOPPKGPARAMID);
    }

    public String getEAIDBOPPKGPARAMID() {
        return this.GetParamStringValue(TAG_EAIDBOPPKGPARAMID, "");
    }

    public void setEAIDBOPPKGPARAMID(String strValue) {
        this.SetParamValue(TAG_EAIDBOPPKGPARAMID, strValue);
    }

    public boolean isEAIDBOPPKGPARAMNAMENull() {
        return this.IsParamNull(TAG_EAIDBOPPKGPARAMNAME);
    }

    public String getEAIDBOPPKGPARAMNAME() {
        return this.GetParamStringValue(TAG_EAIDBOPPKGPARAMNAME, "");
    }

    public void setEAIDBOPPKGPARAMNAME(String strValue) {
        this.SetParamValue(TAG_EAIDBOPPKGPARAMNAME, strValue);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public boolean isEAIDBOPPKGIDNull() {
        return this.IsParamNull(TAG_EAIDBOPPKGID);
    }

    public String getEAIDBOPPKGID() {
        return this.GetParamStringValue(TAG_EAIDBOPPKGID, "");
    }

    public void setEAIDBOPPKGID(String strValue) {
        this.SetParamValue(TAG_EAIDBOPPKGID, strValue);
    }

    public boolean isEAIDBOPPKGNAMENull() {
        return this.IsParamNull(TAG_EAIDBOPPKGNAME);
    }

    public String getEAIDBOPPKGNAME() {
        return this.GetParamStringValue(TAG_EAIDBOPPKGNAME, "");
    }

    public void setEAIDBOPPKGNAME(String strValue) {
        this.SetParamValue(TAG_EAIDBOPPKGNAME, strValue);
    }

    public boolean isORDERFLAGNull() {
        return this.IsParamNull(TAG_ORDERFLAG);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int strValue) {
        this.SetParamValue(TAG_ORDERFLAG, strValue);
    }

    public boolean isDATATYPENull() {
        return this.IsParamNull(TAG_DATATYPE);
    }

    public String getDATATYPE() {
        return this.GetParamStringValue(TAG_DATATYPE, "");
    }

    public void setDATATYPE(String strValue) {
        this.SetParamValue(TAG_DATATYPE, strValue);
    }

    public boolean isLENGTHNull() {
        return this.IsParamNull(TAG_LENGTH);
    }

    public int getLENGTH() {
        return this.GetParamIntValue(TAG_LENGTH, 0);
    }

    public void setLENGTH(int strValue) {
        this.SetParamValue(TAG_LENGTH, strValue);
    }

    public boolean isPRECISION2Null() {
        return this.IsParamNull(TAG_PRECISION2);
    }

    public int getPRECISION2() {
        return this.GetParamIntValue(TAG_PRECISION2, 0);
    }

    public void setPRECISION2(int strValue) {
        this.SetParamValue(TAG_PRECISION2, strValue);
    }

    public boolean isDEFAULTVALUENull() {
        return this.IsParamNull(TAG_DEFAULTVALUE);
    }

    public String getDEFAULTVALUE() {
        return this.GetParamStringValue(TAG_DEFAULTVALUE, "");
    }

    public void setDEFAULTVALUE(String strValue) {
        this.SetParamValue(TAG_DEFAULTVALUE, strValue);
    }

    public boolean isPARAMTYPENull() {
        return this.IsParamNull(TAG_PARAMTYPE);
    }

    public String getPARAMTYPE() {
        return this.GetParamStringValue(TAG_PARAMTYPE, "");
    }

    public void setPARAMTYPE(String strValue) {
        this.SetParamValue(TAG_PARAMTYPE, strValue);
    }
}

