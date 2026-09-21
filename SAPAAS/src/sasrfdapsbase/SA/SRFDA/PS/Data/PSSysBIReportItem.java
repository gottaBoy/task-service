/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysBIReportItem
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
    public static final String BIREPITEMTYPE_MEASURE = "MEASURE";
    public static final String BIREPITEMTYPE_DIMENSION = "DIMENSION";
    public static final String BIREPITEMTYPE_USER = "USER";
    public static final String TAG_PSSYSBIREPORTITEMID = "PSSYSBIREPORTITEMID";
    public static final String TAG_PSSYSBIREPORTITEMNAME = "PSSYSBIREPORTITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_BIREPITEMTAG2 = "BIREPITEMTAG2";
    public static final String TAG_BIREPITEMTAG = "BIREPITEMTAG";
    public static final String TAG_BIREPITEMTYPE = "BIREPITEMTYPE";
    public static final String TAG_PSSYSBICUBEDIMENSIONID = "PSSYSBICUBEDIMENSIONID";
    public static final String TAG_PSSYSBICUBEDIMENSIONNAME = "PSSYSBICUBEDIMENSIONNAME";
    public static final String TAG_PSSYSBICUBEMEASUREID = "PSSYSBICUBEMEASUREID";
    public static final String TAG_PSSYSBICUBEMEASURENAME = "PSSYSBICUBEMEASURENAME";
    public static final String TAG_PSSYSBIREPORTID = "PSSYSBIREPORTID";
    public static final String TAG_PSSYSBIREPORTNAME = "PSSYSBIREPORTNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_PPSSYSBIREPORTITEMID = "PPSSYSBIREPORTITEMID";
    public static final String TAG_PPSSYSBIREPORTITEMNAME = "PPSSYSBIREPORTITEMNAME";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_WIDTHUNIT = "WIDTHUNIT";
    public static final String TAG_AGGTYPE = "AGGTYPE";
    public static final String TAG_REFPSSYSBICUBEMEASUREID = "REFPSSYSBICUBEMEASUREID";
    public static final String TAG_REFPSSYSBICUBEMEASURENAME = "REFPSSYSBICUBEMEASURENAME";
    public static final String TAG_REFTYPE = "REFTYPE";
    public static final String TAG_VALUEFORMAT = "VALUEFORMAT";
    public static final String TAG_PSSYSBICUBEID = "PSSYSBICUBEID";
    public static final String TAG_PSSYSBICUBENAME = "PSSYSBICUBENAME";
    public static final String TAG_PSSYSBISCHEMEID = "PSSYSBISCHEMEID";
    public static final String TAG_PSSYSBICUBELEVELID = "PSSYSBICUBELEVELID";
    public static final String TAG_PSSYSBICUBELEVELNAME = "PSSYSBICUBELEVELNAME";
    public static final String TAG_DATA = "DATA";
    public static final String TAG_BIREPITEMPARAMS = "BIREPITEMPARAMS";
    public static final String TAG_PLACEMENT = "PLACEMENT";
    public static final String TAG_PLACETYPE = "PLACETYPE";

    public final boolean isPSSYSBIREPORTITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSBIREPORTITEMID);
    }

    public final String getPSSYSBIREPORTITEMID() {
        return this.GetParamStringValue(TAG_PSSYSBIREPORTITEMID, "");
    }

    public final void setPSSYSBIREPORTITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSBIREPORTITEMID, strValue);
    }

    public final boolean isPSSYSBIREPORTITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSBIREPORTITEMNAME);
    }

    public final String getPSSYSBIREPORTITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSBIREPORTITEMNAME, "");
    }

    public final void setPSSYSBIREPORTITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBIREPORTITEMNAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
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

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
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

    public final boolean isBIREPITEMTAG2Null() {
        return this.IsParamNull(TAG_BIREPITEMTAG2);
    }

    public final String getBIREPITEMTAG2() {
        return this.GetParamStringValue(TAG_BIREPITEMTAG2, "");
    }

    public final void setBIREPITEMTAG2(String strValue) {
        this.SetParamValue(TAG_BIREPITEMTAG2, strValue);
    }

    public final boolean isBIREPITEMTAGNull() {
        return this.IsParamNull(TAG_BIREPITEMTAG);
    }

    public final String getBIREPITEMTAG() {
        return this.GetParamStringValue(TAG_BIREPITEMTAG, "");
    }

    public final void setBIREPITEMTAG(String strValue) {
        this.SetParamValue(TAG_BIREPITEMTAG, strValue);
    }

    public final boolean isBIREPITEMTYPENull() {
        return this.IsParamNull(TAG_BIREPITEMTYPE);
    }

    public final String getBIREPITEMTYPE() {
        return this.GetParamStringValue(TAG_BIREPITEMTYPE, "");
    }

    public final void setBIREPITEMTYPE(String strValue) {
        this.SetParamValue(TAG_BIREPITEMTYPE, strValue);
    }

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

    public final boolean isPSSYSBICUBEMEASUREIDNull() {
        return this.IsParamNull(TAG_PSSYSBICUBEMEASUREID);
    }

    public final String getPSSYSBICUBEMEASUREID() {
        return this.GetParamStringValue(TAG_PSSYSBICUBEMEASUREID, "");
    }

    public final void setPSSYSBICUBEMEASUREID(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBEMEASUREID, strValue);
    }

    public final boolean isPSSYSBICUBEMEASURENAMENull() {
        return this.IsParamNull(TAG_PSSYSBICUBEMEASURENAME);
    }

    public final String getPSSYSBICUBEMEASURENAME() {
        return this.GetParamStringValue(TAG_PSSYSBICUBEMEASURENAME, "");
    }

    public final void setPSSYSBICUBEMEASURENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBEMEASURENAME, strValue);
    }

    public final boolean isPSSYSBIREPORTIDNull() {
        return this.IsParamNull(TAG_PSSYSBIREPORTID);
    }

    public final String getPSSYSBIREPORTID() {
        return this.GetParamStringValue(TAG_PSSYSBIREPORTID, "");
    }

    public final void setPSSYSBIREPORTID(String strValue) {
        this.SetParamValue(TAG_PSSYSBIREPORTID, strValue);
    }

    public final boolean isPSSYSBIREPORTNAMENull() {
        return this.IsParamNull(TAG_PSSYSBIREPORTNAME);
    }

    public final String getPSSYSBIREPORTNAME() {
        return this.GetParamStringValue(TAG_PSSYSBIREPORTNAME, "");
    }

    public final void setPSSYSBIREPORTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBIREPORTNAME, strValue);
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

    public final boolean isPPSSYSBIREPORTITEMIDNull() {
        return this.IsParamNull(TAG_PPSSYSBIREPORTITEMID);
    }

    public final String getPPSSYSBIREPORTITEMID() {
        return this.GetParamStringValue(TAG_PPSSYSBIREPORTITEMID, "");
    }

    public final void setPPSSYSBIREPORTITEMID(String strValue) {
        this.SetParamValue(TAG_PPSSYSBIREPORTITEMID, strValue);
    }

    public final boolean isPPSSYSBIREPORTITEMNAMENull() {
        return this.IsParamNull(TAG_PPSSYSBIREPORTITEMNAME);
    }

    public final String getPPSSYSBIREPORTITEMNAME() {
        return this.GetParamStringValue(TAG_PPSSYSBIREPORTITEMNAME, "");
    }

    public final void setPPSSYSBIREPORTITEMNAME(String strValue) {
        this.SetParamValue(TAG_PPSSYSBIREPORTITEMNAME, strValue);
    }

    public final boolean isWIDTHNull() {
        return this.IsParamNull(TAG_WIDTH);
    }

    public final int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public final void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
    }

    public final boolean isWIDTHUNITNull() {
        return this.IsParamNull(TAG_WIDTHUNIT);
    }

    public final String getWIDTHUNIT() {
        return this.GetParamStringValue(TAG_WIDTHUNIT, "");
    }

    public final void setWIDTHUNIT(String strValue) {
        this.SetParamValue(TAG_WIDTHUNIT, strValue);
    }

    public final boolean isAGGTYPENull() {
        return this.IsParamNull(TAG_AGGTYPE);
    }

    public final String getAGGTYPE() {
        return this.GetParamStringValue(TAG_AGGTYPE, "");
    }

    public final void setAGGTYPE(String strValue) {
        this.SetParamValue(TAG_AGGTYPE, strValue);
    }

    public final boolean isREFPSSYSBICUBEMEASUREIDNull() {
        return this.IsParamNull(TAG_REFPSSYSBICUBEMEASUREID);
    }

    public final String getREFPSSYSBICUBEMEASUREID() {
        return this.GetParamStringValue(TAG_REFPSSYSBICUBEMEASUREID, "");
    }

    public final void setREFPSSYSBICUBEMEASUREID(String strValue) {
        this.SetParamValue(TAG_REFPSSYSBICUBEMEASUREID, strValue);
    }

    public final boolean isREFPSSYSBICUBEMEASURENAMENull() {
        return this.IsParamNull(TAG_REFPSSYSBICUBEMEASURENAME);
    }

    public final String getREFPSSYSBICUBEMEASURENAME() {
        return this.GetParamStringValue(TAG_REFPSSYSBICUBEMEASURENAME, "");
    }

    public final void setREFPSSYSBICUBEMEASURENAME(String strValue) {
        this.SetParamValue(TAG_REFPSSYSBICUBEMEASURENAME, strValue);
    }

    public final boolean isREFTYPENull() {
        return this.IsParamNull(TAG_REFTYPE);
    }

    public final String getREFTYPE() {
        return this.GetParamStringValue(TAG_REFTYPE, "");
    }

    public final void setREFTYPE(String strValue) {
        this.SetParamValue(TAG_REFTYPE, strValue);
    }

    public final boolean isVALUEFORMATNull() {
        return this.IsParamNull(TAG_VALUEFORMAT);
    }

    public final String getVALUEFORMAT() {
        return this.GetParamStringValue(TAG_VALUEFORMAT, "");
    }

    public final void setVALUEFORMAT(String strValue) {
        this.SetParamValue(TAG_VALUEFORMAT, strValue);
    }

    public final boolean isPSSYSBICUBELEVELIDNull() {
        return this.IsParamNull(TAG_PSSYSBICUBELEVELID);
    }

    public final String getPSSYSBICUBELEVELID() {
        return this.GetParamStringValue(TAG_PSSYSBICUBELEVELID, "");
    }

    public final void setPSSYSBICUBELEVELID(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBELEVELID, strValue);
    }

    public final boolean isPSSYSBICUBELEVELNAMENull() {
        return this.IsParamNull(TAG_PSSYSBICUBELEVELNAME);
    }

    public final String getPSSYSBICUBELEVELNAME() {
        return this.GetParamStringValue(TAG_PSSYSBICUBELEVELNAME, "");
    }

    public final void setPSSYSBICUBELEVELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBELEVELNAME, strValue);
    }

    public final boolean isDATANull() {
        return this.IsParamNull(TAG_DATA);
    }

    public final String getDATA() {
        return this.GetParamStringValue(TAG_DATA, "");
    }

    public final void setDATA(String strValue) {
        this.SetParamValue(TAG_DATA, strValue);
    }

    public final boolean isBIREPITEMPARAMSNull() {
        return this.IsParamNull(TAG_BIREPITEMPARAMS);
    }

    public final String getBIREPITEMPARAMS() {
        return this.GetParamStringValue(TAG_BIREPITEMPARAMS, "");
    }

    public final void setBIREPITEMPARAMS(String strValue) {
        this.SetParamValue(TAG_BIREPITEMPARAMS, strValue);
    }

    public final boolean isPLACEMENTNull() {
        return this.IsParamNull(TAG_PLACEMENT);
    }

    public final String getPLACEMENT() {
        return this.GetParamStringValue(TAG_PLACEMENT, "");
    }

    public final void setPLACEMENT(String strValue) {
        this.SetParamValue(TAG_PLACEMENT, strValue);
    }

    public final boolean isPLACETYPENull() {
        return this.IsParamNull(TAG_PLACETYPE);
    }

    public final String getPLACETYPE() {
        return this.GetParamStringValue(TAG_PLACETYPE, "");
    }

    public final void setPLACETYPE(String strValue) {
        this.SetParamValue(TAG_PLACETYPE, strValue);
    }
}

