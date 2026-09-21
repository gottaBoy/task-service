/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

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
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_AGGMODE = "AGGMODE";
    public static final String TAG_ALIASNAME = "ALIASNAME";
    public static final String TAG_GROUPJOINCODE = "GROUPJOINCODE";

    public final boolean isPSDEDSGRPPARAMIDNull() {
        return this.IsParamNull(TAG_PSDEDSGRPPARAMID);
    }

    public final String getPSDEDSGRPPARAMID() {
        return this.GetParamStringValue(TAG_PSDEDSGRPPARAMID, "");
    }

    public final void setPSDEDSGRPPARAMID(String strValue) {
        this.SetParamValue(TAG_PSDEDSGRPPARAMID, strValue);
    }

    public final boolean isPSDEDSGRPPARAMNAMENull() {
        return this.IsParamNull(TAG_PSDEDSGRPPARAMNAME);
    }

    public final String getPSDEDSGRPPARAMNAME() {
        return this.GetParamStringValue(TAG_PSDEDSGRPPARAMNAME, "");
    }

    public final void setPSDEDSGRPPARAMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDSGRPPARAMNAME, strValue);
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

    public final boolean isGROUPCODENull() {
        return this.IsParamNull(TAG_GROUPCODE);
    }

    public final String getGROUPCODE() {
        return this.GetParamStringValue(TAG_GROUPCODE, "");
    }

    public final void setGROUPCODE(String strValue) {
        this.SetParamValue(TAG_GROUPCODE, strValue);
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

    public final boolean isPSDEFIDNull() {
        return this.IsParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.GetParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.SetParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.IsParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.GetParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFNAME, strValue);
    }

    public final boolean isCUSTOMDEFNAMENull() {
        return this.IsParamNull(TAG_CUSTOMDEFNAME);
    }

    public final String getCUSTOMDEFNAME() {
        return this.GetParamStringValue(TAG_CUSTOMDEFNAME, "");
    }

    public final void setCUSTOMDEFNAME(String strValue) {
        this.SetParamValue(TAG_CUSTOMDEFNAME, strValue);
    }

    public final boolean isGROUPFLAGNull() {
        return this.IsParamNull(TAG_GROUPFLAG);
    }

    public final boolean getGROUPFLAG() {
        return this.GetParamIntValue(TAG_GROUPFLAG, 0) == 1;
    }

    public final void setGROUPFLAG(boolean bValue) {
        this.SetParamValue(TAG_GROUPFLAG, bValue ? 1 : 0);
    }

    public final boolean isORDERDIRNull() {
        return this.IsParamNull(TAG_ORDERDIR);
    }

    public final String getORDERDIR() {
        return this.GetParamStringValue(TAG_ORDERDIR, "");
    }

    public final void setORDERDIR(String strValue) {
        this.SetParamValue(TAG_ORDERDIR, strValue);
    }

    public final boolean isSORTORDERVALUENull() {
        return this.IsParamNull(TAG_SORTORDERVALUE);
    }

    public final int getSORTORDERVALUE() {
        return this.GetParamIntValue(TAG_SORTORDERVALUE, 0);
    }

    public final void setSORTORDERVALUE(int nValue) {
        this.SetParamValue(TAG_SORTORDERVALUE, nValue);
    }

    public final boolean isUSERDATANull() {
        return this.IsParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.GetParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.SetParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.IsParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.GetParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.SetParamValue(TAG_USERDATA2, strValue);
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

    public final boolean isSTDDATATYPENull() {
        return this.IsParamNull(TAG_STDDATATYPE);
    }

    public final int getSTDDATATYPE() {
        return this.GetParamIntValue(TAG_STDDATATYPE, 0);
    }

    public final void setSTDDATATYPE(int nValue) {
        this.SetParamValue(TAG_STDDATATYPE, nValue);
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

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
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

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
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

    public final boolean isAGGMODENull() {
        return this.IsParamNull(TAG_AGGMODE);
    }

    public final String getAGGMODE() {
        return this.GetParamStringValue(TAG_AGGMODE, "");
    }

    public final void setAGGMODE(String strValue) {
        this.SetParamValue(TAG_AGGMODE, strValue);
    }

    public final boolean isALIASNAMENull() {
        return this.IsParamNull(TAG_ALIASNAME);
    }

    public final String getALIASNAME() {
        return this.GetParamStringValue(TAG_ALIASNAME, "");
    }

    public final void setALIASNAME(String strValue) {
        this.SetParamValue(TAG_ALIASNAME, strValue);
    }

    public final boolean isGROUPJOINCODENull() {
        return this.IsParamNull(TAG_GROUPJOINCODE);
    }

    public final String getGROUPJOINCODE() {
        return this.GetParamStringValue(TAG_GROUPJOINCODE, "");
    }

    public final void setGROUPJOINCODE(String strValue) {
        this.SetParamValue(TAG_GROUPJOINCODE, strValue);
    }
}

