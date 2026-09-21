/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysDynaModelAttr
extends BaseDataEntity {
    public static final String VALUETYPE_VALUE = "VALUE";
    public static final String VALUETYPE_OBJECT = "OBJECT";
    public static final String VALUETYPE_DE = "DE";
    public static final String TAG_PSSYSDYNAMODELATTRID = "PSSYSDYNAMODELATTRID";
    public static final String TAG_PSSYSDYNAMODELATTRNAME = "PSSYSDYNAMODELATTRNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_VALUETYPE = "VALUETYPE";
    public static final String TAG_ATTRVALUE = "ATTRVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ATTRVALUE2 = "ATTRVALUE2";
    public static final String TAG_ATTRVALUE3 = "ATTRVALUE3";
    public static final String TAG_ATTRVALUE4 = "ATTRVALUE4";
    public static final String TAG_ATTRVALUE5 = "ATTRVALUE5";
    public static final String TAG_ATTRVALUE6 = "ATTRVALUE6";
    public static final String TAG_ATTRVALUE7 = "ATTRVALUE7";
    public static final String TAG_ATTRVALUE8 = "ATTRVALUE8";
    public static final String TAG_ATTRVALUE9 = "ATTRVALUE9";
    public static final String TAG_ATTRVALUE10 = "ATTRVALUE10";
    public static final String TAG_ATTRVALUE11 = "ATTRVALUE11";
    public static final String TAG_ATTRVALUE12 = "ATTRVALUE12";
    public static final String TAG_ATTRVALUE13 = "ATTRVALUE13";
    public static final String TAG_ATTRVALUE14 = "ATTRVALUE14";
    public static final String TAG_ATTRVALUE15 = "ATTRVALUE15";
    public static final String TAG_ATTRVALUE16 = "ATTRVALUE16";
    public static final String TAG_REFPSSYSDYNAMODELID = "REFPSSYSDYNAMODELID";
    public static final String TAG_REFPSSYSDYNAMODELNAME = "REFPSSYSDYNAMODELNAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_ATTRVALUE20 = "ATTRVALUE20";
    public static final String TAG_ATTRVALUE21 = "ATTRVALUE21";
    public static final String TAG_ATTRVALUE22 = "ATTRVALUE22";
    public static final String TAG_ATTRVALUE23 = "ATTRVALUE23";
    public static final String TAG_ATTRVALUE24 = "ATTRVALUE24";
    public static final String TAG_ATTRVALUE25 = "ATTRVALUE25";
    public static final String TAG_ATTRVALUE26 = "ATTRVALUE26";
    public static final String TAG_ATTRVALUE27 = "ATTRVALUE27";
    public static final String TAG_ATTRVALUE28 = "ATTRVALUE28";
    public static final String TAG_ATTRVALUE29 = "ATTRVALUE29";
    public static final String TAG_ATTRVALUE30 = "ATTRVALUE30";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_REFPSDEID = "REFPSDEID";
    public static final String TAG_REFPSDENAME = "REFPSDENAME";
    public static final String TAG_REFPSDEFGROUPID = "REFPSDEFGROUPID";
    public static final String TAG_REFPSDEFGROUPNAME = "REFPSDEFGROUPNAME";
    public static final String TAG_ATTRTAG = "ATTRTAG";
    public static final String TAG_ATTRTAG2 = "ATTRTAG2";
    public static final String TAG_STDDATATYPE = "STDDATATYPE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_ARRAYFLAG = "ARRAYFLAG";
    public static final String TAG_DYNAMODELUSAGE = "DYNAMODELUSAGE";
    public static final String TAG_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String TAG_JSONFORMAT = "JSONFORMAT";

    public final boolean isPSSYSDYNAMODELATTRIDNull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELATTRID);
    }

    public final String getPSSYSDYNAMODELATTRID() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELATTRID, "");
    }

    public final void setPSSYSDYNAMODELATTRID(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELATTRID, strValue);
    }

    public final boolean isPSSYSDYNAMODELATTRNAMENull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELATTRNAME);
    }

    public final String getPSSYSDYNAMODELATTRNAME() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELATTRNAME, "");
    }

    public final void setPSSYSDYNAMODELATTRNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELATTRNAME, strValue);
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

    public final boolean isPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELID);
    }

    public final String getPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELID, "");
    }

    public final void setPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELID, strValue);
    }

    public final boolean isPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELNAME);
    }

    public final String getPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELNAME, "");
    }

    public final void setPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELNAME, strValue);
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

    public final boolean isATTRVALUENull() {
        return this.IsParamNull(TAG_ATTRVALUE);
    }

    public final String getATTRVALUE() {
        return this.GetParamStringValue(TAG_ATTRVALUE, "");
    }

    public final void setATTRVALUE(String strValue) {
        this.SetParamValue(TAG_ATTRVALUE, strValue);
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

    public final boolean isATTRVALUE2Null() {
        return this.IsParamNull(TAG_ATTRVALUE2);
    }

    public final String getATTRVALUE2() {
        return this.GetParamStringValue(TAG_ATTRVALUE2, "");
    }

    public final void setATTRVALUE2(String strValue) {
        this.SetParamValue(TAG_ATTRVALUE2, strValue);
    }

    public final boolean isATTRVALUE3Null() {
        return this.IsParamNull(TAG_ATTRVALUE3);
    }

    public final String getATTRVALUE3() {
        return this.GetParamStringValue(TAG_ATTRVALUE3, "");
    }

    public final void setATTRVALUE3(String strValue) {
        this.SetParamValue(TAG_ATTRVALUE3, strValue);
    }

    public final boolean isATTRVALUE4Null() {
        return this.IsParamNull(TAG_ATTRVALUE4);
    }

    public final String getATTRVALUE4() {
        return this.GetParamStringValue(TAG_ATTRVALUE4, "");
    }

    public final void setATTRVALUE4(String strValue) {
        this.SetParamValue(TAG_ATTRVALUE4, strValue);
    }

    public final boolean isATTRVALUE5Null() {
        return this.IsParamNull(TAG_ATTRVALUE5);
    }

    public final int getATTRVALUE5() {
        return this.GetParamIntValue(TAG_ATTRVALUE5, 0);
    }

    public final void setATTRVALUE5(int nValue) {
        this.SetParamValue(TAG_ATTRVALUE5, nValue);
    }

    public final boolean isATTRVALUE6Null() {
        return this.IsParamNull(TAG_ATTRVALUE6);
    }

    public final int getATTRVALUE6() {
        return this.GetParamIntValue(TAG_ATTRVALUE6, 0);
    }

    public final void setATTRVALUE6(int nValue) {
        this.SetParamValue(TAG_ATTRVALUE6, nValue);
    }

    public final boolean isATTRVALUE7Null() {
        return this.IsParamNull(TAG_ATTRVALUE7);
    }

    public final int getATTRVALUE7() {
        return this.GetParamIntValue(TAG_ATTRVALUE7, 0);
    }

    public final void setATTRVALUE7(int nValue) {
        this.SetParamValue(TAG_ATTRVALUE7, nValue);
    }

    public final boolean isATTRVALUE8Null() {
        return this.IsParamNull(TAG_ATTRVALUE8);
    }

    public final int getATTRVALUE8() {
        return this.GetParamIntValue(TAG_ATTRVALUE8, 0);
    }

    public final void setATTRVALUE8(int nValue) {
        this.SetParamValue(TAG_ATTRVALUE8, nValue);
    }

    public final boolean isATTRVALUE9Null() {
        return this.IsParamNull(TAG_ATTRVALUE9);
    }

    public final String getATTRVALUE9() {
        return this.GetParamStringValue(TAG_ATTRVALUE9, "");
    }

    public final void setATTRVALUE9(String strValue) {
        this.SetParamValue(TAG_ATTRVALUE9, strValue);
    }

    public final boolean isATTRVALUE10Null() {
        return this.IsParamNull(TAG_ATTRVALUE10);
    }

    public final String getATTRVALUE10() {
        return this.GetParamStringValue(TAG_ATTRVALUE10, "");
    }

    public final void setATTRVALUE10(String strValue) {
        this.SetParamValue(TAG_ATTRVALUE10, strValue);
    }

    public final boolean isATTRVALUE11Null() {
        return this.IsParamNull(TAG_ATTRVALUE11);
    }

    public final String getATTRVALUE11() {
        return this.GetParamStringValue(TAG_ATTRVALUE11, "");
    }

    public final void setATTRVALUE11(String strValue) {
        this.SetParamValue(TAG_ATTRVALUE11, strValue);
    }

    public final boolean isATTRVALUE12Null() {
        return this.IsParamNull(TAG_ATTRVALUE12);
    }

    public final String getATTRVALUE12() {
        return this.GetParamStringValue(TAG_ATTRVALUE12, "");
    }

    public final void setATTRVALUE12(String strValue) {
        this.SetParamValue(TAG_ATTRVALUE12, strValue);
    }

    public final boolean isATTRVALUE13Null() {
        return this.IsParamNull(TAG_ATTRVALUE13);
    }

    public final Date getATTRVALUE13() {
        return this.GetParamDateValue(TAG_ATTRVALUE13, null);
    }

    public final void setATTRVALUE13(Date dtValue) {
        this.SetParamValue(TAG_ATTRVALUE13, dtValue);
    }

    public final boolean isATTRVALUE14Null() {
        return this.IsParamNull(TAG_ATTRVALUE14);
    }

    public final Date getATTRVALUE14() {
        return this.GetParamDateValue(TAG_ATTRVALUE14, null);
    }

    public final void setATTRVALUE14(Date dtValue) {
        this.SetParamValue(TAG_ATTRVALUE14, dtValue);
    }

    public final boolean isATTRVALUE15Null() {
        return this.IsParamNull(TAG_ATTRVALUE15);
    }

    public final Date getATTRVALUE15() {
        return this.GetParamDateValue(TAG_ATTRVALUE15, null);
    }

    public final void setATTRVALUE15(Date dtValue) {
        this.SetParamValue(TAG_ATTRVALUE15, dtValue);
    }

    public final boolean isATTRVALUE16Null() {
        return this.IsParamNull(TAG_ATTRVALUE16);
    }

    public final Date getATTRVALUE16() {
        return this.GetParamDateValue(TAG_ATTRVALUE16, null);
    }

    public final void setATTRVALUE16(Date dtValue) {
        this.SetParamValue(TAG_ATTRVALUE16, dtValue);
    }

    public final boolean isREFPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_REFPSSYSDYNAMODELID);
    }

    public final String getREFPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_REFPSSYSDYNAMODELID, "");
    }

    public final void setREFPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_REFPSSYSDYNAMODELID, strValue);
    }

    public final boolean isREFPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_REFPSSYSDYNAMODELNAME);
    }

    public final String getREFPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_REFPSSYSDYNAMODELNAME, "");
    }

    public final void setREFPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_REFPSSYSDYNAMODELNAME, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isATTRVALUE20Null() {
        return this.IsParamNull(TAG_ATTRVALUE20);
    }

    public final String getATTRVALUE20() {
        return this.GetParamStringValue(TAG_ATTRVALUE20, "");
    }

    public final void setATTRVALUE20(String strValue) {
        this.SetParamValue(TAG_ATTRVALUE20, strValue);
    }

    public final boolean isATTRVALUE21Null() {
        return this.IsParamNull(TAG_ATTRVALUE21);
    }

    public final String getATTRVALUE21() {
        return this.GetParamStringValue(TAG_ATTRVALUE21, "");
    }

    public final void setATTRVALUE21(String strValue) {
        this.SetParamValue(TAG_ATTRVALUE21, strValue);
    }

    public final boolean isATTRVALUE22Null() {
        return this.IsParamNull(TAG_ATTRVALUE22);
    }

    public final String getATTRVALUE22() {
        return this.GetParamStringValue(TAG_ATTRVALUE22, "");
    }

    public final void setATTRVALUE22(String strValue) {
        this.SetParamValue(TAG_ATTRVALUE22, strValue);
    }

    public final boolean isATTRVALUE23Null() {
        return this.IsParamNull(TAG_ATTRVALUE23);
    }

    public final String getATTRVALUE23() {
        return this.GetParamStringValue(TAG_ATTRVALUE23, "");
    }

    public final void setATTRVALUE23(String strValue) {
        this.SetParamValue(TAG_ATTRVALUE23, strValue);
    }

    public final boolean isATTRVALUE24Null() {
        return this.IsParamNull(TAG_ATTRVALUE24);
    }

    public final String getATTRVALUE24() {
        return this.GetParamStringValue(TAG_ATTRVALUE24, "");
    }

    public final void setATTRVALUE24(String strValue) {
        this.SetParamValue(TAG_ATTRVALUE24, strValue);
    }

    public final boolean isATTRVALUE25Null() {
        return this.IsParamNull(TAG_ATTRVALUE25);
    }

    public final String getATTRVALUE25() {
        return this.GetParamStringValue(TAG_ATTRVALUE25, "");
    }

    public final void setATTRVALUE25(String strValue) {
        this.SetParamValue(TAG_ATTRVALUE25, strValue);
    }

    public final boolean isATTRVALUE26Null() {
        return this.IsParamNull(TAG_ATTRVALUE26);
    }

    public final String getATTRVALUE26() {
        return this.GetParamStringValue(TAG_ATTRVALUE26, "");
    }

    public final void setATTRVALUE26(String strValue) {
        this.SetParamValue(TAG_ATTRVALUE26, strValue);
    }

    public final boolean isATTRVALUE27Null() {
        return this.IsParamNull(TAG_ATTRVALUE27);
    }

    public final String getATTRVALUE27() {
        return this.GetParamStringValue(TAG_ATTRVALUE27, "");
    }

    public final void setATTRVALUE27(String strValue) {
        this.SetParamValue(TAG_ATTRVALUE27, strValue);
    }

    public final boolean isATTRVALUE28Null() {
        return this.IsParamNull(TAG_ATTRVALUE28);
    }

    public final String getATTRVALUE28() {
        return this.GetParamStringValue(TAG_ATTRVALUE28, "");
    }

    public final void setATTRVALUE28(String strValue) {
        this.SetParamValue(TAG_ATTRVALUE28, strValue);
    }

    public final boolean isATTRVALUE29Null() {
        return this.IsParamNull(TAG_ATTRVALUE29);
    }

    public final String getATTRVALUE29() {
        return this.GetParamStringValue(TAG_ATTRVALUE29, "");
    }

    public final void setATTRVALUE29(String strValue) {
        this.SetParamValue(TAG_ATTRVALUE29, strValue);
    }

    public final boolean isATTRVALUE30Null() {
        return this.IsParamNull(TAG_ATTRVALUE30);
    }

    public final String getATTRVALUE30() {
        return this.GetParamStringValue(TAG_ATTRVALUE30, "");
    }

    public final void setATTRVALUE30(String strValue) {
        this.SetParamValue(TAG_ATTRVALUE30, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isREFPSDEIDNull() {
        return this.IsParamNull(TAG_REFPSDEID);
    }

    public final String getREFPSDEID() {
        return this.GetParamStringValue(TAG_REFPSDEID, "");
    }

    public final void setREFPSDEID(String strValue) {
        this.SetParamValue(TAG_REFPSDEID, strValue);
    }

    public final boolean isREFPSDENAMENull() {
        return this.IsParamNull(TAG_REFPSDENAME);
    }

    public final String getREFPSDENAME() {
        return this.GetParamStringValue(TAG_REFPSDENAME, "");
    }

    public final void setREFPSDENAME(String strValue) {
        this.SetParamValue(TAG_REFPSDENAME, strValue);
    }

    public final boolean isREFPSDEFGROUPIDNull() {
        return this.IsParamNull(TAG_REFPSDEFGROUPID);
    }

    public final String getREFPSDEFGROUPID() {
        return this.GetParamStringValue(TAG_REFPSDEFGROUPID, "");
    }

    public final void setREFPSDEFGROUPID(String strValue) {
        this.SetParamValue(TAG_REFPSDEFGROUPID, strValue);
    }

    public final boolean isREFPSDEFGROUPNAMENull() {
        return this.IsParamNull(TAG_REFPSDEFGROUPNAME);
    }

    public final String getREFPSDEFGROUPNAME() {
        return this.GetParamStringValue(TAG_REFPSDEFGROUPNAME, "");
    }

    public final void setREFPSDEFGROUPNAME(String strValue) {
        this.SetParamValue(TAG_REFPSDEFGROUPNAME, strValue);
    }

    public final boolean isATTRTAGNull() {
        return this.IsParamNull(TAG_ATTRTAG);
    }

    public final String getATTRTAG() {
        return this.GetParamStringValue(TAG_ATTRTAG, "");
    }

    public final void setATTRTAG(String strValue) {
        this.SetParamValue(TAG_ATTRTAG, strValue);
    }

    public final boolean isATTRTAG2Null() {
        return this.IsParamNull(TAG_ATTRTAG2);
    }

    public final String getATTRTAG2() {
        return this.GetParamStringValue(TAG_ATTRTAG2, "");
    }

    public final void setATTRTAG2(String strValue) {
        this.SetParamValue(TAG_ATTRTAG2, strValue);
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

    public final boolean isPSCODELISTIDNull() {
        return this.IsParamNull(TAG_PSCODELISTID);
    }

    public final String getPSCODELISTID() {
        return this.GetParamStringValue(TAG_PSCODELISTID, "");
    }

    public final void setPSCODELISTID(String strValue) {
        this.SetParamValue(TAG_PSCODELISTID, strValue);
    }

    public final boolean isPSCODELISTNAMENull() {
        return this.IsParamNull(TAG_PSCODELISTNAME);
    }

    public final String getPSCODELISTNAME() {
        return this.GetParamStringValue(TAG_PSCODELISTNAME, "");
    }

    public final void setPSCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_PSCODELISTNAME, strValue);
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

    public final boolean isDYNAMODELUSAGENull() {
        return this.IsParamNull(TAG_DYNAMODELUSAGE);
    }

    public final String getDYNAMODELUSAGE() {
        return this.GetParamStringValue(TAG_DYNAMODELUSAGE, "");
    }

    public final void setDYNAMODELUSAGE(String strValue) {
        this.SetParamValue(TAG_DYNAMODELUSAGE, strValue);
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

