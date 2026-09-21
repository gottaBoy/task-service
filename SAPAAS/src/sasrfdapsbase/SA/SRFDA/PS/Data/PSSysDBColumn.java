/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysDBColumn
extends BaseDataEntity {
    public static final int STDDATATYPE_0 = 0;
    public static final int STDDATATYPE_1 = 1;
    public static final int STDDATATYPE_2 = 2;
    public static final int STDDATATYPE_3 = 3;
    public static final int STDDATATYPE_4 = 4;
    public static final int STDDATATYPE_5 = 5;
    public static final int STDDATATYPE_6 = 6;
    public static final int STDDATATYPE_7 = 7;
    public static final int STDDATATYPE_8 = 8;
    public static final int STDDATATYPE_9 = 9;
    public static final int STDDATATYPE_10 = 10;
    public static final int STDDATATYPE_11 = 11;
    public static final int STDDATATYPE_12 = 12;
    public static final int STDDATATYPE_13 = 13;
    public static final int STDDATATYPE_14 = 14;
    public static final int STDDATATYPE_15 = 15;
    public static final int STDDATATYPE_16 = 16;
    public static final int STDDATATYPE_17 = 17;
    public static final int STDDATATYPE_18 = 18;
    public static final int STDDATATYPE_19 = 19;
    public static final int STDDATATYPE_20 = 20;
    public static final int STDDATATYPE_21 = 21;
    public static final int STDDATATYPE_22 = 22;
    public static final int STDDATATYPE_23 = 23;
    public static final int STDDATATYPE_24 = 24;
    public static final int STDDATATYPE_25 = 25;
    public static final int STDDATATYPE_26 = 26;
    public static final int STDDATATYPE_27 = 27;
    public static final int STDDATATYPE_28 = 28;
    public static final int PKEY_0 = 0;
    public static final int PKEY_1 = 1;
    public static final int PKEY_2 = 2;
    public static final String TAG_PSSYSDBCOLUMNID = "PSSYSDBCOLUMNID";
    public static final String TAG_PSSYSDBCOLUMNNAME = "PSSYSDBCOLUMNNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSDBTABLEID = "PSSYSDBTABLEID";
    public static final String TAG_PSSYSDBTABLENAME = "PSSYSDBTABLENAME";
    public static final String TAG_LENGTH = "LENGTH";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PRECISION2 = "PRECISION2";
    public static final String TAG_DATATYPE = "DATATYPE";
    public static final String TAG_STDDATATYPE = "STDDATATYPE";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PKEY = "PKEY";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String TAG_CODENAME2 = "CODENAME2";
    public static final String TAG_IDENTITYMODE = "IDENTITYMODE";
    public static final String TAG_UNSIGNEDMODE = "UNSIGNEDMODE";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_COLDESC = "COLDESC";
    public static final String TAG_REFPSSYSDBTABLEID = "REFPSSYSDBTABLEID";
    public static final String TAG_REFPSSYSDBTABLENAME = "REFPSSYSDBTABLENAME";
    public static final String TAG_REFPSSYSDBCOLUMNID = "REFPSSYSDBCOLUMNID";
    public static final String TAG_REFPSSYSDBCOLUMNNAME = "REFPSSYSDBCOLUMNNAME";
    public static final String TAG_FKEY = "FKEY";
    public static final String TAG_DROPSQL = "DROPSQL";
    public static final String TAG_CREATESQL = "CREATESQL";
    public static final String TAG_COLUMNTAG = "COLUMNTAG";
    public static final String TAG_COLUMNTAG2 = "COLUMNTAG2";

    public final boolean isPSSYSDBCOLUMNIDNull() {
        return this.IsParamNull(TAG_PSSYSDBCOLUMNID);
    }

    public final String getPSSYSDBCOLUMNID() {
        return this.GetParamStringValue(TAG_PSSYSDBCOLUMNID, "");
    }

    public final void setPSSYSDBCOLUMNID(String strValue) {
        this.SetParamValue(TAG_PSSYSDBCOLUMNID, strValue);
    }

    public final boolean isPSSYSDBCOLUMNNAMENull() {
        return this.IsParamNull(TAG_PSSYSDBCOLUMNNAME);
    }

    public final String getPSSYSDBCOLUMNNAME() {
        return this.GetParamStringValue(TAG_PSSYSDBCOLUMNNAME, "");
    }

    public final void setPSSYSDBCOLUMNNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDBCOLUMNNAME, strValue);
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

    public final boolean isPSSYSDBTABLEIDNull() {
        return this.IsParamNull(TAG_PSSYSDBTABLEID);
    }

    public final String getPSSYSDBTABLEID() {
        return this.GetParamStringValue(TAG_PSSYSDBTABLEID, "");
    }

    public final void setPSSYSDBTABLEID(String strValue) {
        this.SetParamValue(TAG_PSSYSDBTABLEID, strValue);
    }

    public final boolean isPSSYSDBTABLENAMENull() {
        return this.IsParamNull(TAG_PSSYSDBTABLENAME);
    }

    public final String getPSSYSDBTABLENAME() {
        return this.GetParamStringValue(TAG_PSSYSDBTABLENAME, "");
    }

    public final void setPSSYSDBTABLENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDBTABLENAME, strValue);
    }

    public final boolean isLENGTHNull() {
        return this.IsParamNull(TAG_LENGTH);
    }

    public final int getLENGTH() {
        return this.GetParamIntValue(TAG_LENGTH, 0);
    }

    public final void setLENGTH(int nValue) {
        this.SetParamValue(TAG_LENGTH, nValue);
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

    public final boolean isPRECISION2Null() {
        return this.IsParamNull(TAG_PRECISION2);
    }

    public final int getPRECISION2() {
        return this.GetParamIntValue(TAG_PRECISION2, 0);
    }

    public final void setPRECISION2(int nValue) {
        this.SetParamValue(TAG_PRECISION2, nValue);
    }

    public final boolean isDATATYPENull() {
        return this.IsParamNull(TAG_DATATYPE);
    }

    public final String getDATATYPE() {
        return this.GetParamStringValue(TAG_DATATYPE, "");
    }

    public final void setDATATYPE(String strValue) {
        this.SetParamValue(TAG_DATATYPE, strValue);
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

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isDEFAULTVALUENull() {
        return this.IsParamNull(TAG_DEFAULTVALUE);
    }

    public final String getDEFAULTVALUE() {
        return this.GetParamStringValue(TAG_DEFAULTVALUE, "");
    }

    public final void setDEFAULTVALUE(String strValue) {
        this.SetParamValue(TAG_DEFAULTVALUE, strValue);
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

    public final boolean isPKEYNull() {
        return this.IsParamNull(TAG_PKEY);
    }

    public final int getPKEY() {
        return this.GetParamIntValue(TAG_PKEY, 0);
    }

    public final void setPKEY(int nValue) {
        this.SetParamValue(TAG_PKEY, nValue);
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

    public final boolean isALLOWEMPTYNull() {
        return this.IsParamNull(TAG_ALLOWEMPTY);
    }

    public final boolean getALLOWEMPTY() {
        return this.GetParamIntValue(TAG_ALLOWEMPTY, 0) == 1;
    }

    public final void setALLOWEMPTY(boolean bValue) {
        this.SetParamValue(TAG_ALLOWEMPTY, bValue ? 1 : 0);
    }

    public final boolean isCODENAME2Null() {
        return this.IsParamNull(TAG_CODENAME2);
    }

    public final String getCODENAME2() {
        return this.GetParamStringValue(TAG_CODENAME2, "");
    }

    public final void setCODENAME2(String strValue) {
        this.SetParamValue(TAG_CODENAME2, strValue);
    }

    public final boolean isIDENTITYMODENull() {
        return this.IsParamNull(TAG_IDENTITYMODE);
    }

    public final boolean getIDENTITYMODE() {
        return this.GetParamIntValue(TAG_IDENTITYMODE, 0) == 1;
    }

    public final void setIDENTITYMODE(boolean bValue) {
        this.SetParamValue(TAG_IDENTITYMODE, bValue ? 1 : 0);
    }

    public final boolean isUNSIGNEDMODENull() {
        return this.IsParamNull(TAG_UNSIGNEDMODE);
    }

    public final boolean getUNSIGNEDMODE() {
        return this.GetParamIntValue(TAG_UNSIGNEDMODE, 0) == 1;
    }

    public final void setUNSIGNEDMODE(boolean bValue) {
        this.SetParamValue(TAG_UNSIGNEDMODE, bValue ? 1 : 0);
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

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
    }

    public final boolean isCOLDESCNull() {
        return this.IsParamNull(TAG_COLDESC);
    }

    public final String getCOLDESC() {
        return this.GetParamStringValue(TAG_COLDESC, "");
    }

    public final void setCOLDESC(String strValue) {
        this.SetParamValue(TAG_COLDESC, strValue);
    }

    public final boolean isREFPSSYSDBTABLEIDNull() {
        return this.IsParamNull(TAG_REFPSSYSDBTABLEID);
    }

    public final String getREFPSSYSDBTABLEID() {
        return this.GetParamStringValue(TAG_REFPSSYSDBTABLEID, "");
    }

    public final void setREFPSSYSDBTABLEID(String strValue) {
        this.SetParamValue(TAG_REFPSSYSDBTABLEID, strValue);
    }

    public final boolean isREFPSSYSDBTABLENAMENull() {
        return this.IsParamNull(TAG_REFPSSYSDBTABLENAME);
    }

    public final String getREFPSSYSDBTABLENAME() {
        return this.GetParamStringValue(TAG_REFPSSYSDBTABLENAME, "");
    }

    public final void setREFPSSYSDBTABLENAME(String strValue) {
        this.SetParamValue(TAG_REFPSSYSDBTABLENAME, strValue);
    }

    public final boolean isREFPSSYSDBCOLUMNIDNull() {
        return this.IsParamNull(TAG_REFPSSYSDBCOLUMNID);
    }

    public final String getREFPSSYSDBCOLUMNID() {
        return this.GetParamStringValue(TAG_REFPSSYSDBCOLUMNID, "");
    }

    public final void setREFPSSYSDBCOLUMNID(String strValue) {
        this.SetParamValue(TAG_REFPSSYSDBCOLUMNID, strValue);
    }

    public final boolean isREFPSSYSDBCOLUMNNAMENull() {
        return this.IsParamNull(TAG_REFPSSYSDBCOLUMNNAME);
    }

    public final String getREFPSSYSDBCOLUMNNAME() {
        return this.GetParamStringValue(TAG_REFPSSYSDBCOLUMNNAME, "");
    }

    public final void setREFPSSYSDBCOLUMNNAME(String strValue) {
        this.SetParamValue(TAG_REFPSSYSDBCOLUMNNAME, strValue);
    }

    public final boolean isFKEYNull() {
        return this.IsParamNull(TAG_FKEY);
    }

    public final boolean getFKEY() {
        return this.GetParamIntValue(TAG_FKEY, 0) == 1;
    }

    public final void setFKEY(boolean bValue) {
        this.SetParamValue(TAG_FKEY, bValue ? 1 : 0);
    }

    public final boolean isDROPSQLNull() {
        return this.IsParamNull(TAG_DROPSQL);
    }

    public final String getDROPSQL() {
        return this.GetParamStringValue(TAG_DROPSQL, "");
    }

    public final void setDROPSQL(String strValue) {
        this.SetParamValue(TAG_DROPSQL, strValue);
    }

    public final boolean isCREATESQLNull() {
        return this.IsParamNull(TAG_CREATESQL);
    }

    public final String getCREATESQL() {
        return this.GetParamStringValue(TAG_CREATESQL, "");
    }

    public final void setCREATESQL(String strValue) {
        this.SetParamValue(TAG_CREATESQL, strValue);
    }

    public final boolean isCOLUMNTAGNull() {
        return this.IsParamNull(TAG_COLUMNTAG);
    }

    public final String getCOLUMNTAG() {
        return this.GetParamStringValue(TAG_COLUMNTAG, "");
    }

    public final void setCOLUMNTAG(String strValue) {
        this.SetParamValue(TAG_COLUMNTAG, strValue);
    }

    public final boolean isCOLUMNTAG2Null() {
        return this.IsParamNull(TAG_COLUMNTAG2);
    }

    public final String getCOLUMNTAG2() {
        return this.GetParamStringValue(TAG_COLUMNTAG2, "");
    }

    public final void setCOLUMNTAG2(String strValue) {
        this.SetParamValue(TAG_COLUMNTAG2, strValue);
    }
}

