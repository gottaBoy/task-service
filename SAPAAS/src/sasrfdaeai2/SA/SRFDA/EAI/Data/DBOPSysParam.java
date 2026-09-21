/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DBOPSysParam
extends BaseDataEntity {
    public static final String TAG_EAIDBOPSYSPARAMID = "EAIDBOPSYSPARAMID";
    public static final String TAG_EAIDBOPSYSPARAMNAME = "EAIDBOPSYSPARAMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_LENGTH = "LENGTH";
    public static final String TAG_EAIDBOPSETTINGID = "EAIDBOPSETTINGID";
    public static final String TAG_EAIDBOPSETTINGNAME = "EAIDBOPSETTINGNAME";
    public static final String TAG_PRECISION2 = "PRECISION2";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_DATATYPE = "DATATYPE";
    public static final String TAG_PARAMTYPE = "PARAMTYPE";
    public static final String TAG_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String TAG_LOGICNAME = "LOGICNAME";

    public boolean isEAIDBOPSYSPARAMIDNull() {
        return this.IsParamNull(TAG_EAIDBOPSYSPARAMID);
    }

    public String getEAIDBOPSYSPARAMID() {
        return this.GetParamStringValue(TAG_EAIDBOPSYSPARAMID, "");
    }

    public void setEAIDBOPSYSPARAMID(String strValue) {
        this.SetParamValue(TAG_EAIDBOPSYSPARAMID, strValue);
    }

    public boolean isEAIDBOPSYSPARAMNAMENull() {
        return this.IsParamNull(TAG_EAIDBOPSYSPARAMNAME);
    }

    public String getEAIDBOPSYSPARAMNAME() {
        return this.GetParamStringValue(TAG_EAIDBOPSYSPARAMNAME, "");
    }

    public void setEAIDBOPSYSPARAMNAME(String strValue) {
        this.SetParamValue(TAG_EAIDBOPSYSPARAMNAME, strValue);
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

    public boolean isLENGTHNull() {
        return this.IsParamNull(TAG_LENGTH);
    }

    public int getLENGTH() {
        return this.GetParamIntValue(TAG_LENGTH, 0);
    }

    public void setLENGTH(int strValue) {
        this.SetParamValue(TAG_LENGTH, strValue);
    }

    public boolean isEAIDBOPSETTINGIDNull() {
        return this.IsParamNull(TAG_EAIDBOPSETTINGID);
    }

    public String getEAIDBOPSETTINGID() {
        return this.GetParamStringValue(TAG_EAIDBOPSETTINGID, "");
    }

    public void setEAIDBOPSETTINGID(String strValue) {
        this.SetParamValue(TAG_EAIDBOPSETTINGID, strValue);
    }

    public boolean isEAIDBOPSETTINGNAMENull() {
        return this.IsParamNull(TAG_EAIDBOPSETTINGNAME);
    }

    public String getEAIDBOPSETTINGNAME() {
        return this.GetParamStringValue(TAG_EAIDBOPSETTINGNAME, "");
    }

    public void setEAIDBOPSETTINGNAME(String strValue) {
        this.SetParamValue(TAG_EAIDBOPSETTINGNAME, strValue);
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

    public boolean isORDERFLAGNull() {
        return this.IsParamNull(TAG_ORDERFLAG);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int strValue) {
        this.SetParamValue(TAG_ORDERFLAG, strValue);
    }

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
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

    public boolean isPARAMTYPENull() {
        return this.IsParamNull(TAG_PARAMTYPE);
    }

    public String getPARAMTYPE() {
        return this.GetParamStringValue(TAG_PARAMTYPE, "");
    }

    public void setPARAMTYPE(String strValue) {
        this.SetParamValue(TAG_PARAMTYPE, strValue);
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

    public boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }
}

