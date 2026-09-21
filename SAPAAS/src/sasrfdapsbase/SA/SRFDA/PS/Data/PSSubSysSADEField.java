/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSubSysSADEField
extends BaseDataEntity {
    public static final int PKEY_0 = 0;
    public static final int PKEY_1 = 1;
    public static final int PKEY_2 = 2;
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
    public static final String TAG_PSSUBSYSSADEFIELDID = "PSSUBSYSSADEFIELDID";
    public static final String TAG_PSSUBSYSSADEFIELDNAME = "PSSUBSYSSADEFIELDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSUBSYSSADEID = "PSSUBSYSSADEID";
    public static final String TAG_PSSUBSYSSADENAME = "PSSUBSYSSADENAME";
    public static final String TAG_PKEY = "PKEY";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String TAG_MAJORFIELD = "MAJORFIELD";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_LENGTH = "LENGTH";
    @Deprecated
    public static final String TAG_PRECISION2 = "PRECISION2";
    public static final String TAG_PRECISION = "PRECISION";
    public static final String TAG_STDDATATYPE = "STDDATATYPE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_CODENAME2 = "CODENAME2";
    public static final String TAG_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String TAG_PSDATATYPEID = "PSDATATYPEID";
    public static final String TAG_PSDATATYPENAME = "PSDATATYPENAME";
    public static final String TAG_FIELDTAG = "FIELDTAG";
    public static final String TAG_FIELDTAG2 = "FIELDTAG2";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_MAXVALUE = "MAXVALUE";
    public static final String TAG_MINVALUE = "MINVALUE";
    public static final String TAG_MINSTRLENGTH = "MINSTRLENGTH";
    public static final String TAG_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String TAG_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String TAG_EXAMPLEVALUE = "EXAMPLEVALUE";
    public static final String TAG_REFPSSUBSYSSADEID = "REFPSSUBSYSSADEID";
    public static final String TAG_REFPSSUBSYSSADENAME = "REFPSSUBSYSSADENAME";
    public static final String TAG_ARRAYFLAG = "ARRAYFLAG";
    public static final String TAG_FIELDTYPE = "FIELDTYPE";
    public static final String TAG_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String TAG_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";

    public final boolean isPSSUBSYSSADEFIELDIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSSADEFIELDID);
    }

    public final String getPSSUBSYSSADEFIELDID() {
        return this.GetParamStringValue(TAG_PSSUBSYSSADEFIELDID, "");
    }

    public final void setPSSUBSYSSADEFIELDID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSADEFIELDID, strValue);
    }

    public final boolean isPSSUBSYSSADEFIELDNAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSSADEFIELDNAME);
    }

    public final String getPSSUBSYSSADEFIELDNAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSSADEFIELDNAME, "");
    }

    public final void setPSSUBSYSSADEFIELDNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSADEFIELDNAME, strValue);
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

    public final boolean isPSSUBSYSSADEIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSSADEID);
    }

    public final String getPSSUBSYSSADEID() {
        return this.GetParamStringValue(TAG_PSSUBSYSSADEID, "");
    }

    public final void setPSSUBSYSSADEID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSADEID, strValue);
    }

    public final boolean isPSSUBSYSSADENAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSSADENAME);
    }

    public final String getPSSUBSYSSADENAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSSADENAME, "");
    }

    public final void setPSSUBSYSSADENAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSADENAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isDEFAULTVALUENull() {
        return this.IsParamNull(TAG_DEFAULTVALUE);
    }

    public final String getDEFAULTVALUE() {
        return this.GetParamStringValue(TAG_DEFAULTVALUE, "");
    }

    public final void setDEFAULTVALUE(String strValue) {
        this.SetParamValue(TAG_DEFAULTVALUE, strValue);
    }

    public final boolean isMAJORFIELDNull() {
        return this.IsParamNull(TAG_MAJORFIELD);
    }

    public final boolean getMAJORFIELD() {
        return this.GetParamIntValue(TAG_MAJORFIELD, 0) == 1;
    }

    public final void setMAJORFIELD(boolean bValue) {
        this.SetParamValue(TAG_MAJORFIELD, bValue ? 1 : 0);
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

    public final boolean isLENGTHNull() {
        return this.IsParamNull(TAG_LENGTH);
    }

    public final int getLENGTH() {
        return this.GetParamIntValue(TAG_LENGTH, 0);
    }

    public final void setLENGTH(int nValue) {
        this.SetParamValue(TAG_LENGTH, nValue);
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

    public final boolean isSTDDATATYPENull() {
        return this.IsParamNull(TAG_STDDATATYPE);
    }

    public final int getSTDDATATYPE() {
        return this.GetParamIntValue(TAG_STDDATATYPE, 0);
    }

    public final void setSTDDATATYPE(int nValue) {
        this.SetParamValue(TAG_STDDATATYPE, nValue);
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

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isALLOWEMPTYNull() {
        return this.IsParamNull(TAG_ALLOWEMPTY);
    }

    public final boolean getALLOWEMPTY() {
        return this.GetParamIntValue(TAG_ALLOWEMPTY, 0) == 1;
    }

    public final void setALLOWEMPTY(boolean bValue) {
        this.SetParamValue(TAG_ALLOWEMPTY, bValue ? 1 : 0);
    }

    public final boolean isPSDATATYPEIDNull() {
        return this.IsParamNull(TAG_PSDATATYPEID);
    }

    public final String getPSDATATYPEID() {
        return this.GetParamStringValue(TAG_PSDATATYPEID, "");
    }

    public final void setPSDATATYPEID(String strValue) {
        this.SetParamValue(TAG_PSDATATYPEID, strValue);
    }

    public final boolean isPSDATATYPENAMENull() {
        return this.IsParamNull(TAG_PSDATATYPENAME);
    }

    public final String getPSDATATYPENAME() {
        return this.GetParamStringValue(TAG_PSDATATYPENAME, "");
    }

    public final void setPSDATATYPENAME(String strValue) {
        this.SetParamValue(TAG_PSDATATYPENAME, strValue);
    }

    public final boolean isFIELDTAGNull() {
        return this.IsParamNull(TAG_FIELDTAG);
    }

    public final String getFIELDTAG() {
        return this.GetParamStringValue(TAG_FIELDTAG, "");
    }

    public final void setFIELDTAG(String strValue) {
        this.SetParamValue(TAG_FIELDTAG, strValue);
    }

    public final boolean isFIELDTAG2Null() {
        return this.IsParamNull(TAG_FIELDTAG2);
    }

    public final String getFIELDTAG2() {
        return this.GetParamStringValue(TAG_FIELDTAG2, "");
    }

    public final void setFIELDTAG2(String strValue) {
        this.SetParamValue(TAG_FIELDTAG2, strValue);
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

    public final boolean isMAXVALUENull() {
        return this.IsParamNull(TAG_MAXVALUE);
    }

    public final String getMAXVALUE() {
        return this.GetParamStringValue(TAG_MAXVALUE, "");
    }

    public final void setMAXVALUE(String strValue) {
        this.SetParamValue(TAG_MAXVALUE, strValue);
    }

    public final boolean isMINVALUENull() {
        return this.IsParamNull(TAG_MINVALUE);
    }

    public final String getMINVALUE() {
        return this.GetParamStringValue(TAG_MINVALUE, "");
    }

    public final void setMINVALUE(String strValue) {
        this.SetParamValue(TAG_MINVALUE, strValue);
    }

    public final boolean isMINSTRLENGTHNull() {
        return this.IsParamNull(TAG_MINSTRLENGTH);
    }

    public final int getMINSTRLENGTH() {
        return this.GetParamIntValue(TAG_MINSTRLENGTH, 0);
    }

    public final void setMINSTRLENGTH(int nValue) {
        this.SetParamValue(TAG_MINSTRLENGTH, nValue);
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

    public final boolean isEXAMPLEVALUENull() {
        return this.IsParamNull(TAG_EXAMPLEVALUE);
    }

    public final String getEXAMPLEVALUE() {
        return this.GetParamStringValue(TAG_EXAMPLEVALUE, "");
    }

    public final void setEXAMPLEVALUE(String strValue) {
        this.SetParamValue(TAG_EXAMPLEVALUE, strValue);
    }

    public final boolean isREFPSSUBSYSSADEIDNull() {
        return this.IsParamNull(TAG_REFPSSUBSYSSADEID);
    }

    public final String getREFPSSUBSYSSADEID() {
        return this.GetParamStringValue(TAG_REFPSSUBSYSSADEID, "");
    }

    public final void setREFPSSUBSYSSADEID(String strValue) {
        this.SetParamValue(TAG_REFPSSUBSYSSADEID, strValue);
    }

    public final boolean isREFPSSUBSYSSADENAMENull() {
        return this.IsParamNull(TAG_REFPSSUBSYSSADENAME);
    }

    public final String getREFPSSUBSYSSADENAME() {
        return this.GetParamStringValue(TAG_REFPSSUBSYSSADENAME, "");
    }

    public final void setREFPSSUBSYSSADENAME(String strValue) {
        this.SetParamValue(TAG_REFPSSUBSYSSADENAME, strValue);
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

    public final boolean isFIELDTYPENull() {
        return this.IsParamNull(TAG_FIELDTYPE);
    }

    public final String getFIELDTYPE() {
        return this.GetParamStringValue(TAG_FIELDTYPE, "");
    }

    public final void setFIELDTYPE(String strValue) {
        this.SetParamValue(TAG_FIELDTYPE, strValue);
    }

    public final boolean isPREDEFINEDTYPENull() {
        return this.IsParamNull(TAG_PREDEFINEDTYPE);
    }

    public final String getPREDEFINEDTYPE() {
        return this.GetParamStringValue(TAG_PREDEFINEDTYPE, "");
    }

    public final void setPREDEFINEDTYPE(String strValue) {
        this.SetParamValue(TAG_PREDEFINEDTYPE, strValue);
    }

    public final boolean isPSSUBSYSSERVICEAPIIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSSERVICEAPIID);
    }

    public final String getPSSUBSYSSERVICEAPIID() {
        return this.GetParamStringValue(TAG_PSSUBSYSSERVICEAPIID, "");
    }

    public final void setPSSUBSYSSERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSERVICEAPIID, strValue);
    }
}

