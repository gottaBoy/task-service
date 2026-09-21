/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysBICubeMeasure
extends BaseDataEntity {
    public static final String BIMEASURETYPE_COMMON = "COMMON";
    public static final String BIMEASURETYPE_CALCULATED = "CALCULATED";
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSSYSBICUBEMEASUREID = "PSSYSBICUBEMEASUREID";
    public static final String TAG_PSSYSBICUBEMEASURENAME = "PSSYSBICUBEMEASURENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSBICUBEID = "PSSYSBICUBEID";
    public static final String TAG_PSSYSBICUBENAME = "PSSYSBICUBENAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSTHRESHOLDGROUPID = "PSTHRESHOLDGROUPID";
    public static final String TAG_PSTHRESHOLDGROUPNAME = "PSTHRESHOLDGROUPNAME";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEASUREFORMULA = "MEASUREFORMULA";
    public static final String TAG_VALUEFORMAT = "VALUEFORMAT";
    public static final String TAG_BIMEASURETYPE = "BIMEASURETYPE";
    public static final String TAG_BICUBEMEASURETAG = "BICUBEMEASURETAG";
    public static final String TAG_BICUBEMEASURETAG2 = "BICUBEMEASURETAG2";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_HIDDENDATAITEM = "HIDDENDATAITEM";
    public static final String TAG_PSSYSBISCHEMEID = "PSSYSBISCHEMEID";
    public static final String TAG_AGGTYPE = "AGGTYPE";
    public static final String TAG_JSONFORMAT = "JSONFORMAT";
    public static final String TAG_BIMEASUREGROUP = "BIMEASUREGROUP";
    public static final String TAG_PSSYSTRANSLATORID = "PSSYSTRANSLATORID";
    public static final String TAG_PSSYSTRANSLATORNAME = "PSSYSTRANSLATORNAME";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_DRILLDOWNPSDEVIEWID = "DRILLDOWNPSDEVIEWID";
    public static final String TAG_DRILLDOWNPSDEVIEWNAME = "DRILLDOWNPSDEVIEWNAME";
    public static final String TAG_PARAMPSDEUIACTIONID = "PARAMPSDEUIACTIONID";
    public static final String TAG_PARAMPSDEUIACTIONNAME = "PARAMPSDEUIACTIONNAME";
    public static final String TAG_DRILLDOWNCUSTOMTYPE = "DRILLDOWNCUSTOMTYPE";
    public static final String TAG_DRILLDOWNCUSTOMCOND = "DRILLDOWNCUSTOMCOND";
    public static final String TAG_DRILLDETAILCUSTOMTYPE = "DRILLDETAILCUSTOMTYPE";
    public static final String TAG_DRILLDETAILCUSTOMCOND = "DRILLDETAILCUSTOMCOND";
    public static final String TAG_DRILLDETAILPSDEVIEWID = "DRILLDETAILPSDEVIEWID";
    public static final String TAG_DRILLDETAILPSDEVIEWNAME = "DRILLDETAILPSDEVIEWNAME";
    public static final String TAG_STDDATATYPE = "STDDATATYPE";
    public static final String TAG_TEXTTEMPLATE = "TEXTTEMPLATE";
    public static final String TAG_TIPTEMPLATE = "TIPTEMPLATE";

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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSTHRESHOLDGROUPIDNull() {
        return this.IsParamNull(TAG_PSTHRESHOLDGROUPID);
    }

    public final String getPSTHRESHOLDGROUPID() {
        return this.GetParamStringValue(TAG_PSTHRESHOLDGROUPID, "");
    }

    public final void setPSTHRESHOLDGROUPID(String strValue) {
        this.SetParamValue(TAG_PSTHRESHOLDGROUPID, strValue);
    }

    public final boolean isPSTHRESHOLDGROUPNAMENull() {
        return this.IsParamNull(TAG_PSTHRESHOLDGROUPNAME);
    }

    public final String getPSTHRESHOLDGROUPNAME() {
        return this.GetParamStringValue(TAG_PSTHRESHOLDGROUPNAME, "");
    }

    public final void setPSTHRESHOLDGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSTHRESHOLDGROUPNAME, strValue);
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

    public final boolean isMEASUREFORMULANull() {
        return this.IsParamNull(TAG_MEASUREFORMULA);
    }

    public final String getMEASUREFORMULA() {
        return this.GetParamStringValue(TAG_MEASUREFORMULA, "");
    }

    public final void setMEASUREFORMULA(String strValue) {
        this.SetParamValue(TAG_MEASUREFORMULA, strValue);
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

    public final boolean isBIMEASURETYPENull() {
        return this.IsParamNull(TAG_BIMEASURETYPE);
    }

    public final String getBIMEASURETYPE() {
        return this.GetParamStringValue(TAG_BIMEASURETYPE, "");
    }

    public final void setBIMEASURETYPE(String strValue) {
        this.SetParamValue(TAG_BIMEASURETYPE, strValue);
    }

    public final boolean isBICUBEMEASURETAGNull() {
        return this.IsParamNull(TAG_BICUBEMEASURETAG);
    }

    public final String getBICUBEMEASURETAG() {
        return this.GetParamStringValue(TAG_BICUBEMEASURETAG, "");
    }

    public final void setBICUBEMEASURETAG(String strValue) {
        this.SetParamValue(TAG_BICUBEMEASURETAG, strValue);
    }

    public final boolean isBICUBEMEASURETAG2Null() {
        return this.IsParamNull(TAG_BICUBEMEASURETAG2);
    }

    public final String getBICUBEMEASURETAG2() {
        return this.GetParamStringValue(TAG_BICUBEMEASURETAG2, "");
    }

    public final void setBICUBEMEASURETAG2(String strValue) {
        this.SetParamValue(TAG_BICUBEMEASURETAG2, strValue);
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

    public final boolean isHIDDENDATAITEMNull() {
        return this.IsParamNull(TAG_HIDDENDATAITEM);
    }

    public final boolean getHIDDENDATAITEM() {
        return this.GetParamIntValue(TAG_HIDDENDATAITEM, 0) == 1;
    }

    public final void setHIDDENDATAITEM(boolean bValue) {
        this.SetParamValue(TAG_HIDDENDATAITEM, bValue ? 1 : 0);
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

    public final boolean isAGGTYPENull() {
        return this.IsParamNull(TAG_AGGTYPE);
    }

    public final String getAGGTYPE() {
        return this.GetParamStringValue(TAG_AGGTYPE, "");
    }

    public final void setAGGTYPE(String strValue) {
        this.SetParamValue(TAG_AGGTYPE, strValue);
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

    public final boolean isBIMEASUREGROUPNull() {
        return this.IsParamNull(TAG_BIMEASUREGROUP);
    }

    public final String getBIMEASUREGROUP() {
        return this.GetParamStringValue(TAG_BIMEASUREGROUP, "");
    }

    public final void setBIMEASUREGROUP(String strValue) {
        this.SetParamValue(TAG_BIMEASUREGROUP, strValue);
    }

    public final boolean isPSSYSTRANSLATORIDNull() {
        return this.IsParamNull(TAG_PSSYSTRANSLATORID);
    }

    public final String getPSSYSTRANSLATORID() {
        return this.GetParamStringValue(TAG_PSSYSTRANSLATORID, "");
    }

    public final void setPSSYSTRANSLATORID(String strValue) {
        this.SetParamValue(TAG_PSSYSTRANSLATORID, strValue);
    }

    public final boolean isPSSYSTRANSLATORNAMENull() {
        return this.IsParamNull(TAG_PSSYSTRANSLATORNAME);
    }

    public final String getPSSYSTRANSLATORNAME() {
        return this.GetParamStringValue(TAG_PSSYSTRANSLATORNAME, "");
    }

    public final void setPSSYSTRANSLATORNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTRANSLATORNAME, strValue);
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

    public final boolean isDRILLDOWNPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_DRILLDOWNPSDEVIEWID);
    }

    public final String getDRILLDOWNPSDEVIEWID() {
        return this.GetParamStringValue(TAG_DRILLDOWNPSDEVIEWID, "");
    }

    public final void setDRILLDOWNPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_DRILLDOWNPSDEVIEWID, strValue);
    }

    public final boolean isDRILLDOWNPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_DRILLDOWNPSDEVIEWNAME);
    }

    public final String getDRILLDOWNPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_DRILLDOWNPSDEVIEWNAME, "");
    }

    public final void setDRILLDOWNPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_DRILLDOWNPSDEVIEWNAME, strValue);
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

    public final boolean isDRILLDOWNCUSTOMTYPENull() {
        return this.IsParamNull(TAG_DRILLDOWNCUSTOMTYPE);
    }

    public final String getDRILLDOWNCUSTOMTYPE() {
        return this.GetParamStringValue(TAG_DRILLDOWNCUSTOMTYPE, "");
    }

    public final void setDRILLDOWNCUSTOMTYPE(String strValue) {
        this.SetParamValue(TAG_DRILLDOWNCUSTOMTYPE, strValue);
    }

    public final boolean isDRILLDOWNCUSTOMCONDNull() {
        return this.IsParamNull(TAG_DRILLDOWNCUSTOMCOND);
    }

    public final String getDRILLDOWNCUSTOMCOND() {
        return this.GetParamStringValue(TAG_DRILLDOWNCUSTOMCOND, "");
    }

    public final void setDRILLDOWNCUSTOMCOND(String strValue) {
        this.SetParamValue(TAG_DRILLDOWNCUSTOMCOND, strValue);
    }

    public final boolean isDRILLDETAILCUSTOMTYPENull() {
        return this.IsParamNull(TAG_DRILLDETAILCUSTOMTYPE);
    }

    public final String getDRILLDETAILCUSTOMTYPE() {
        return this.GetParamStringValue(TAG_DRILLDETAILCUSTOMTYPE, "");
    }

    public final void setDRILLDETAILCUSTOMTYPE(String strValue) {
        this.SetParamValue(TAG_DRILLDETAILCUSTOMTYPE, strValue);
    }

    public final boolean isDRILLDETAILCUSTOMCONDNull() {
        return this.IsParamNull(TAG_DRILLDETAILCUSTOMCOND);
    }

    public final String getDRILLDETAILCUSTOMCOND() {
        return this.GetParamStringValue(TAG_DRILLDETAILCUSTOMCOND, "");
    }

    public final void setDRILLDETAILCUSTOMCOND(String strValue) {
        this.SetParamValue(TAG_DRILLDETAILCUSTOMCOND, strValue);
    }

    public final boolean isDRILLDETAILPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_DRILLDETAILPSDEVIEWID);
    }

    public final String getDRILLDETAILPSDEVIEWID() {
        return this.GetParamStringValue(TAG_DRILLDETAILPSDEVIEWID, "");
    }

    public final void setDRILLDETAILPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_DRILLDETAILPSDEVIEWID, strValue);
    }

    public final boolean isDRILLDETAILPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_DRILLDETAILPSDEVIEWNAME);
    }

    public final String getDRILLDETAILPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_DRILLDETAILPSDEVIEWNAME, "");
    }

    public final void setDRILLDETAILPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_DRILLDETAILPSDEVIEWNAME, strValue);
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

