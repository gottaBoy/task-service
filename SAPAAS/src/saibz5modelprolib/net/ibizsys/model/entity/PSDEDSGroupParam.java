/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEDSGroupParam
extends BaseDataEntity {
    public static final String ORDERDIR_ASC = "ASC";
    public static final String ORDERDIR_DESC = "DESC";
    public static final String TAG_PSDEDSGRPPARAMID = "PSDEDSGRPPARAMID";
    public static final String TAG_PSDEDSGRPPARAMNAME = "PSDEDSGRPPARAMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_GROUPCODE = "GROUPCODE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_CUSTOMDEFNAME = "CUSTOMDEFNAME";
    public static final String TAG_GROUPFLAG = "GROUPFLAG";
    public static final String TAG_ORDERDIR = "ORDERDIR";
    public static final String TAG_SORTORDERVALUE = "SORTORDERVALUE";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_USERDATA2 = "USERDATA2";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_STDDATATYPE = "STDDATATYPE";

    public final boolean isPSDEDSGRPPARAMIDNull() {
        return this.isParamNull(TAG_PSDEDSGRPPARAMID);
    }

    public final String getPSDEDSGRPPARAMID() {
        return this.getParamStringValue(TAG_PSDEDSGRPPARAMID, "");
    }

    public final void setPSDEDSGRPPARAMID(String strValue) {
        this.setParamValue(TAG_PSDEDSGRPPARAMID, strValue);
    }

    public final boolean isPSDEDSGRPPARAMNAMENull() {
        return this.isParamNull(TAG_PSDEDSGRPPARAMNAME);
    }

    public final String getPSDEDSGRPPARAMNAME() {
        return this.getParamStringValue(TAG_PSDEDSGRPPARAMNAME, "");
    }

    public final void setPSDEDSGRPPARAMNAME(String strValue) {
        this.setParamValue(TAG_PSDEDSGRPPARAMNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSDEDSIDNull() {
        return this.isParamNull(TAG_PSDEDSID);
    }

    public final String getPSDEDSID() {
        return this.getParamStringValue(TAG_PSDEDSID, "");
    }

    public final void setPSDEDSID(String strValue) {
        this.setParamValue(TAG_PSDEDSID, strValue);
    }

    public final boolean isPSDEDSNAMENull() {
        return this.isParamNull(TAG_PSDEDSNAME);
    }

    public final String getPSDEDSNAME() {
        return this.getParamStringValue(TAG_PSDEDSNAME, "");
    }

    public final void setPSDEDSNAME(String strValue) {
        this.setParamValue(TAG_PSDEDSNAME, strValue);
    }

    public final boolean isGROUPCODENull() {
        return this.isParamNull(TAG_GROUPCODE);
    }

    public final String getGROUPCODE() {
        return this.getParamStringValue(TAG_GROUPCODE, "");
    }

    public final void setGROUPCODE(String strValue) {
        this.setParamValue(TAG_GROUPCODE, strValue);
    }

    public final boolean isPSDEIDNull() {
        return this.isParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.getParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.setParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDEFIDNull() {
        return this.isParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.getParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.setParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.isParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.getParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.setParamValue(TAG_PSDEFNAME, strValue);
    }

    public final boolean isCUSTOMDEFNAMENull() {
        return this.isParamNull(TAG_CUSTOMDEFNAME);
    }

    public final String getCUSTOMDEFNAME() {
        return this.getParamStringValue(TAG_CUSTOMDEFNAME, "");
    }

    public final void setCUSTOMDEFNAME(String strValue) {
        this.setParamValue(TAG_CUSTOMDEFNAME, strValue);
    }

    public final boolean isGROUPFLAGNull() {
        return this.isParamNull(TAG_GROUPFLAG);
    }

    public final boolean getGROUPFLAG() {
        return this.getParamIntValue(TAG_GROUPFLAG, 0) == 1;
    }

    public final void setGROUPFLAG(boolean bValue) {
        this.setParamValue(TAG_GROUPFLAG, bValue ? 1 : 0);
    }

    public final boolean isORDERDIRNull() {
        return this.isParamNull(TAG_ORDERDIR);
    }

    public final String getORDERDIR() {
        return this.getParamStringValue(TAG_ORDERDIR, "");
    }

    public final void setORDERDIR(String strValue) {
        this.setParamValue(TAG_ORDERDIR, strValue);
    }

    public final boolean isSORTORDERVALUENull() {
        return this.isParamNull(TAG_SORTORDERVALUE);
    }

    public final int getSORTORDERVALUE() {
        return this.getParamIntValue(TAG_SORTORDERVALUE, 0);
    }

    public final void setSORTORDERVALUE(int nValue) {
        this.setParamValue(TAG_SORTORDERVALUE, nValue);
    }

    public final boolean isUSERDATANull() {
        return this.isParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.getParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.setParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.isParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.getParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.setParamValue(TAG_USERDATA2, strValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isSTDDATATYPENull() {
        return this.isParamNull(TAG_STDDATATYPE);
    }

    public final int getSTDDATATYPE() {
        return this.getParamIntValue(TAG_STDDATATYPE, 0);
    }

    public final void setSTDDATATYPE(int nValue) {
        this.setParamValue(TAG_STDDATATYPE, nValue);
    }
}

