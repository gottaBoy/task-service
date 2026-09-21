/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysSearchField
extends BaseDataEntity {
    public static final String FIELDTYPE_TEXT = "TEXT";
    public static final String FIELDTYPE_INTEGER = "INTEGER";
    public static final String FIELDTYPE_LONG = "LONG";
    public static final String FIELDTYPE_DATE = "DATE";
    public static final String FIELDTYPE_FLOAT = "FLOAT";
    public static final String FIELDTYPE_DOUBLE = "DOUBLE";
    public static final String FIELDTYPE_BOOLEAN = "BOOLEAN";
    public static final String FIELDTYPE_OBJECT = "OBJECT";
    public static final String FIELDTYPE_AUTO = "AUTO";
    public static final String FIELDTYPE_NESTED = "NESTED";
    public static final String FIELDTYPE_IP = "IP";
    public static final String FIELDTYPE_ATTACHMENT = "ATTACHMENT";
    public static final String FIELDTYPE_KEYWORD = "KEYWORD";
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSSYSSEARCHFIELDID = "PSSYSSEARCHFIELDID";
    public static final String TAG_PSSYSSEARCHFIELDNAME = "PSSYSSEARCHFIELDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSSEARCHDOCID = "PSSYSSEARCHDOCID";
    public static final String TAG_PSSYSSEARCHDOCNAME = "PSSYSSEARCHDOCNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_INDEXFLAG = "INDEXFLAG";
    public static final String TAG_STOREFLAG = "STOREFLAG";
    public static final String TAG_FIELDDATAFLAG = "FIELDDATAFLAG";
    public static final String TAG_DATEFORMAT = "DATEFORMAT";
    public static final String TAG_PATTERN = "PATTERN";
    public static final String TAG_INCINPARENTFLAG = "INCINPARENTFLAG";
    public static final String TAG_ANALYZER = "ANALYZER";
    public static final String TAG_SEARCHANALYZER = "SEARCHANALYZER";
    public static final String TAG_IGNOREFIELDS = "IGNOREFIELDS";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_FIELDTAG = "FIELDTAG";
    public static final String TAG_FIELDTAG2 = "FIELDTAG2";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_FIELDTYPE = "FIELDTYPE";
    public static final String TAG_STDDATATYPE = "STDDATATYPE";
    public static final String TAG_PKEY = "PKEY";
    public static final String TAG_FIELDPARAMS = "FIELDPARAMS";

    public final boolean isPSSYSSEARCHFIELDIDNull() {
        return this.IsParamNull(TAG_PSSYSSEARCHFIELDID);
    }

    public final String getPSSYSSEARCHFIELDID() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHFIELDID, "");
    }

    public final void setPSSYSSEARCHFIELDID(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHFIELDID, strValue);
    }

    public final boolean isPSSYSSEARCHFIELDNAMENull() {
        return this.IsParamNull(TAG_PSSYSSEARCHFIELDNAME);
    }

    public final String getPSSYSSEARCHFIELDNAME() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHFIELDNAME, "");
    }

    public final void setPSSYSSEARCHFIELDNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHFIELDNAME, strValue);
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

    public final boolean isPSSYSSEARCHDOCIDNull() {
        return this.IsParamNull(TAG_PSSYSSEARCHDOCID);
    }

    public final String getPSSYSSEARCHDOCID() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHDOCID, "");
    }

    public final void setPSSYSSEARCHDOCID(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHDOCID, strValue);
    }

    public final boolean isPSSYSSEARCHDOCNAMENull() {
        return this.IsParamNull(TAG_PSSYSSEARCHDOCNAME);
    }

    public final String getPSSYSSEARCHDOCNAME() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHDOCNAME, "");
    }

    public final void setPSSYSSEARCHDOCNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHDOCNAME, strValue);
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

    public final boolean isINDEXFLAGNull() {
        return this.IsParamNull(TAG_INDEXFLAG);
    }

    public final boolean getINDEXFLAG() {
        return this.GetParamIntValue(TAG_INDEXFLAG, 0) == 1;
    }

    public final void setINDEXFLAG(boolean bValue) {
        this.SetParamValue(TAG_INDEXFLAG, bValue ? 1 : 0);
    }

    public final boolean isSTOREFLAGNull() {
        return this.IsParamNull(TAG_STOREFLAG);
    }

    public final boolean getSTOREFLAG() {
        return this.GetParamIntValue(TAG_STOREFLAG, 0) == 1;
    }

    public final void setSTOREFLAG(boolean bValue) {
        this.SetParamValue(TAG_STOREFLAG, bValue ? 1 : 0);
    }

    public final boolean isFIELDDATAFLAGNull() {
        return this.IsParamNull(TAG_FIELDDATAFLAG);
    }

    public final boolean getFIELDDATAFLAG() {
        return this.GetParamIntValue(TAG_FIELDDATAFLAG, 0) == 1;
    }

    public final void setFIELDDATAFLAG(boolean bValue) {
        this.SetParamValue(TAG_FIELDDATAFLAG, bValue ? 1 : 0);
    }

    public final boolean isDATEFORMATNull() {
        return this.IsParamNull(TAG_DATEFORMAT);
    }

    public final String getDATEFORMAT() {
        return this.GetParamStringValue(TAG_DATEFORMAT, "");
    }

    public final void setDATEFORMAT(String strValue) {
        this.SetParamValue(TAG_DATEFORMAT, strValue);
    }

    public final boolean isPATTERNNull() {
        return this.IsParamNull(TAG_PATTERN);
    }

    public final String getPATTERN() {
        return this.GetParamStringValue(TAG_PATTERN, "");
    }

    public final void setPATTERN(String strValue) {
        this.SetParamValue(TAG_PATTERN, strValue);
    }

    public final boolean isINCINPARENTFLAGNull() {
        return this.IsParamNull(TAG_INCINPARENTFLAG);
    }

    public final boolean getINCINPARENTFLAG() {
        return this.GetParamIntValue(TAG_INCINPARENTFLAG, 0) == 1;
    }

    public final void setINCINPARENTFLAG(boolean bValue) {
        this.SetParamValue(TAG_INCINPARENTFLAG, bValue ? 1 : 0);
    }

    public final boolean isANALYZERNull() {
        return this.IsParamNull(TAG_ANALYZER);
    }

    public final String getANALYZER() {
        return this.GetParamStringValue(TAG_ANALYZER, "");
    }

    public final void setANALYZER(String strValue) {
        this.SetParamValue(TAG_ANALYZER, strValue);
    }

    public final boolean isSEARCHANALYZERNull() {
        return this.IsParamNull(TAG_SEARCHANALYZER);
    }

    public final String getSEARCHANALYZER() {
        return this.GetParamStringValue(TAG_SEARCHANALYZER, "");
    }

    public final void setSEARCHANALYZER(String strValue) {
        this.SetParamValue(TAG_SEARCHANALYZER, strValue);
    }

    public final boolean isIGNOREFIELDSNull() {
        return this.IsParamNull(TAG_IGNOREFIELDS);
    }

    public final String getIGNOREFIELDS() {
        return this.GetParamStringValue(TAG_IGNOREFIELDS, "");
    }

    public final void setIGNOREFIELDS(String strValue) {
        this.SetParamValue(TAG_IGNOREFIELDS, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
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

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isSTDDATATYPENull() {
        return this.IsParamNull(TAG_STDDATATYPE);
    }

    public final int getSTDDATATYPE() {
        return this.GetParamIntValue(TAG_STDDATATYPE, 0);
    }

    public final void setSTDDATATYPE(int nValue) {
        this.SetParamValue(TAG_STDDATATYPE, nValue);
    }

    public final boolean isPKEYNull() {
        return this.IsParamNull(TAG_PKEY);
    }

    public final boolean getPKEY() {
        return this.GetParamIntValue(TAG_PKEY, 0) == 1;
    }

    public final void setPKEY(boolean bValue) {
        this.SetParamValue(TAG_PKEY, bValue ? 1 : 0);
    }

    public final boolean isFIELDPARAMSNull() {
        return this.IsParamNull(TAG_FIELDPARAMS);
    }

    public final String getFIELDPARAMS() {
        return this.GetParamStringValue(TAG_FIELDPARAMS, "");
    }

    public final void setFIELDPARAMS(String strValue) {
        this.SetParamValue(TAG_FIELDPARAMS, strValue);
    }
}

