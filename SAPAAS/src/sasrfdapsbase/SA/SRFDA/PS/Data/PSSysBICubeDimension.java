/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysBICubeDimension
extends BaseDataEntity {
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSSYSBICUBEDIMENSIONID = "PSSYSBICUBEDIMENSIONID";
    public static final String TAG_PSSYSBICUBEDIMENSIONNAME = "PSSYSBICUBEDIMENSIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSBICUBEID = "PSSYSBICUBEID";
    public static final String TAG_PSSYSBICUBENAME = "PSSYSBICUBENAME";
    public static final String TAG_PSSYSBIDIMENSIONID = "PSSYSBIDIMENSIONID";
    public static final String TAG_PSSYSBIDIMENSIONNAME = "PSSYSBIDIMENSIONNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_BICUBEDIMENSIONTAG = "BICUBEDIMENSIONTAG";
    public static final String TAG_BICUBEDIMENSIONTAG2 = "BICUBEDIMENSIONTAG2";
    public static final String TAG_PSSYSBISCHEMEID = "PSSYSBISCHEMEID";
    public static final String TAG_EXPANDFLAG = "EXPANDFLAG";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_BIDIMENSIONTYPE = "BIDIMENSIONTYPE";
    public static final String TAG_DIMENSIONFORMULA = "DIMENSIONFORMULA";
    public static final String TAG_PSSYSDBVFID = "PSSYSDBVFID";
    public static final String TAG_PSSYSDBVFNAME = "PSSYSDBVFNAME";
    public static final String TAG_ALLHIERARCHYFLAG = "ALLHIERARCHYFLAG";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_PARAMPSDEUIACTIONID = "PARAMPSDEUIACTIONID";
    public static final String TAG_PARAMPSDEUIACTIONNAME = "PARAMPSDEUIACTIONNAME";
    public static final String TAG_TEXTPSDEFID = "TEXTPSDEFID";
    public static final String TAG_TEXTPSDEFNAME = "TEXTPSDEFNAME";
    public static final String TAG_STDDATATYPE = "STDDATATYPE";
    public static final String TAG_TEXTTEMPLATE = "TEXTTEMPLATE";
    public static final String TAG_TIPTEMPLATE = "TIPTEMPLATE";

    public final boolean isPSSYSBICUBEDIMENSIONIDNull() {
        return this.IsParamNull(TAG_PSSYSBICUBEDIMENSIONID);
    }

    public final String getPSSYSBICUBEDIMENSIONID() {
        return this.GetParamStringValue(TAG_PSSYSBICUBEDIMENSIONID, "");
    }

    public final void setPSSYSBICUBEDIMENSIONID(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBEDIMENSIONID, strValue);
    }

    public final boolean isPSSYSBICUBEDIMENSIONNAMENull() {
        return this.IsParamNull(TAG_PSSYSBICUBEDIMENSIONNAME);
    }

    public final String getPSSYSBICUBEDIMENSIONNAME() {
        return this.GetParamStringValue(TAG_PSSYSBICUBEDIMENSIONNAME, "");
    }

    public final void setPSSYSBICUBEDIMENSIONNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBEDIMENSIONNAME, strValue);
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

    public final boolean isPSSYSBICUBEIDNull() {
        return this.IsParamNull(TAG_PSSYSBICUBEID);
    }

    public final String getPSSYSBICUBEID() {
        return this.GetParamStringValue(TAG_PSSYSBICUBEID, "");
    }

    public final void setPSSYSBICUBEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBEID, strValue);
    }

    public final boolean isPSSYSBICUBENAMENull() {
        return this.IsParamNull(TAG_PSSYSBICUBENAME);
    }

    public final String getPSSYSBICUBENAME() {
        return this.GetParamStringValue(TAG_PSSYSBICUBENAME, "");
    }

    public final void setPSSYSBICUBENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBENAME, strValue);
    }

    public final boolean isPSSYSBIDIMENSIONIDNull() {
        return this.IsParamNull(TAG_PSSYSBIDIMENSIONID);
    }

    public final String getPSSYSBIDIMENSIONID() {
        return this.GetParamStringValue(TAG_PSSYSBIDIMENSIONID, "");
    }

    public final void setPSSYSBIDIMENSIONID(String strValue) {
        this.SetParamValue(TAG_PSSYSBIDIMENSIONID, strValue);
    }

    public final boolean isPSSYSBIDIMENSIONNAMENull() {
        return this.IsParamNull(TAG_PSSYSBIDIMENSIONNAME);
    }

    public final String getPSSYSBIDIMENSIONNAME() {
        return this.GetParamStringValue(TAG_PSSYSBIDIMENSIONNAME, "");
    }

    public final void setPSSYSBIDIMENSIONNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBIDIMENSIONNAME, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

    public final boolean isBICUBEDIMENSIONTAGNull() {
        return this.IsParamNull(TAG_BICUBEDIMENSIONTAG);
    }

    public final String getBICUBEDIMENSIONTAG() {
        return this.GetParamStringValue(TAG_BICUBEDIMENSIONTAG, "");
    }

    public final void setBICUBEDIMENSIONTAG(String strValue) {
        this.SetParamValue(TAG_BICUBEDIMENSIONTAG, strValue);
    }

    public final boolean isBICUBEDIMENSIONTAG2Null() {
        return this.IsParamNull(TAG_BICUBEDIMENSIONTAG2);
    }

    public final String getBICUBEDIMENSIONTAG2() {
        return this.GetParamStringValue(TAG_BICUBEDIMENSIONTAG2, "");
    }

    public final void setBICUBEDIMENSIONTAG2(String strValue) {
        this.SetParamValue(TAG_BICUBEDIMENSIONTAG2, strValue);
    }

    public final boolean isPSSYSBISCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSBISCHEMEID);
    }

    public final String getPSSYSBISCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSBISCHEMEID, "");
    }

    public final void setPSSYSBISCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBISCHEMEID, strValue);
    }

    public final boolean isEXPANDFLAGNull() {
        return this.IsParamNull(TAG_EXPANDFLAG);
    }

    public final boolean getEXPANDFLAG() {
        return this.GetParamIntValue(TAG_EXPANDFLAG, 0) == 1;
    }

    public final void setEXPANDFLAG(boolean bValue) {
        this.SetParamValue(TAG_EXPANDFLAG, bValue ? 1 : 0);
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

    public final boolean isBIDIMENSIONTYPENull() {
        return this.IsParamNull(TAG_BIDIMENSIONTYPE);
    }

    public final String getBIDIMENSIONTYPE() {
        return this.GetParamStringValue(TAG_BIDIMENSIONTYPE, "");
    }

    public final void setBIDIMENSIONTYPE(String strValue) {
        this.SetParamValue(TAG_BIDIMENSIONTYPE, strValue);
    }

    public final boolean isDIMENSIONFORMULANull() {
        return this.IsParamNull(TAG_DIMENSIONFORMULA);
    }

    public final String getDIMENSIONFORMULA() {
        return this.GetParamStringValue(TAG_DIMENSIONFORMULA, "");
    }

    public final void setDIMENSIONFORMULA(String strValue) {
        this.SetParamValue(TAG_DIMENSIONFORMULA, strValue);
    }

    public final boolean isALLHIERARCHYFLAGNull() {
        return this.IsParamNull(TAG_ALLHIERARCHYFLAG);
    }

    public final boolean getALLHIERARCHYFLAG() {
        return this.GetParamIntValue(TAG_ALLHIERARCHYFLAG, 0) == 1;
    }

    public final void setALLHIERARCHYFLAG(boolean bValue) {
        this.SetParamValue(TAG_ALLHIERARCHYFLAG, bValue ? 1 : 0);
    }

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
    }

    public final boolean isPARAMPSDEUIACTIONIDNull() {
        return this.IsParamNull(TAG_PARAMPSDEUIACTIONID);
    }

    public final String getPARAMPSDEUIACTIONID() {
        return this.GetParamStringValue(TAG_PARAMPSDEUIACTIONID, "");
    }

    public final void setPARAMPSDEUIACTIONID(String strValue) {
        this.SetParamValue(TAG_PARAMPSDEUIACTIONID, strValue);
    }

    public final boolean isPARAMPSDEUIACTIONNAMENull() {
        return this.IsParamNull(TAG_PARAMPSDEUIACTIONNAME);
    }

    public final String getPARAMPSDEUIACTIONNAME() {
        return this.GetParamStringValue(TAG_PARAMPSDEUIACTIONNAME, "");
    }

    public final void setPARAMPSDEUIACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PARAMPSDEUIACTIONNAME, strValue);
    }

    public final boolean isTEXTPSDEFIDNull() {
        return this.IsParamNull(TAG_TEXTPSDEFID);
    }

    public final String getTEXTPSDEFID() {
        return this.GetParamStringValue(TAG_TEXTPSDEFID, "");
    }

    public final void setTEXTPSDEFID(String strValue) {
        this.SetParamValue(TAG_TEXTPSDEFID, strValue);
    }

    public final boolean isTEXTPSDEFNAMENull() {
        return this.IsParamNull(TAG_TEXTPSDEFNAME);
    }

    public final String getTEXTPSDEFNAME() {
        return this.GetParamStringValue(TAG_TEXTPSDEFNAME, "");
    }

    public final void setTEXTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TEXTPSDEFNAME, strValue);
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

    public final boolean isTEXTTEMPLATENull() {
        return this.IsParamNull(TAG_TEXTTEMPLATE);
    }

    public final String getTEXTTEMPLATE() {
        return this.GetParamStringValue(TAG_TEXTTEMPLATE, "");
    }

    public final void setTEXTTEMPLATE(String strValue) {
        this.SetParamValue(TAG_TEXTTEMPLATE, strValue);
    }

    public final boolean isTIPTEMPLATENull() {
        return this.IsParamNull(TAG_TIPTEMPLATE);
    }

    public final String getTIPTEMPLATE() {
        return this.GetParamStringValue(TAG_TIPTEMPLATE, "");
    }

    public final void setTIPTEMPLATE(String strValue) {
        this.SetParamValue(TAG_TIPTEMPLATE, strValue);
    }
}

