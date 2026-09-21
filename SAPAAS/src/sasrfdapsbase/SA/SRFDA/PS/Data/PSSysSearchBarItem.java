/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysSearchBarItem
extends BaseDataEntity {
    public static final String ITEMTYPE_INPUT = "INPUT";
    public static final String ITEMTYPE_BUTTON = "BUTTON";
    public static final String ITEMSUBTYPE_INPUT_RADIOBUTTONLIST = "INPUT_RADIOBUTTONLIST";
    public static final String ITEMSUBTYPE_INPUT_CHECKBOXLIST = "INPUT_CHECKBOXLIST";
    public static final String ITEMSUBTYPE_INPUT_CHECKBOX = "INPUT_CHECKBOX";
    public static final String ITEMSUBTYPE_INPUT_TEXTBOX = "INPUT_TEXTBOX";
    public static final String ITEMSUBTYPE_BUTTON_SEARCH = "BUTTON_SEARCH";
    public static final String ITEMSUBTYPE_BUTTON_ADVSEARCH = "BUTTON_ADVSEARCH";
    public static final String TAG_PSSYSSEARCHBARITEMID = "PSSYSSEARCHBARITEMID";
    public static final String TAG_PSSYSSEARCHBARITEMNAME = "PSSYSSEARCHBARITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSSEARCHBARID = "PSSYSSEARCHBARID";
    public static final String TAG_PSSYSSEARCHBARNAME = "PSSYSSEARCHBARNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_SHOWCAPTION = "SHOWCAPTION";
    public static final String TAG_ITEMTYPE = "ITEMTYPE";
    public static final String TAG_ITEMSUBTYPE = "ITEMSUBTYPE";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String TAG_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String TAG_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_PLACEHOLDER = "PLACEHOLDER";
    public static final String TAG_PHPSLANRESID = "PHPSLANRESID";
    public static final String TAG_PHPSLANRESNAME = "PHPSLANRESNAME";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_PSDEFSFITEMID = "PSDEFSFITEMID";
    public static final String TAG_PSDEFSFITEMNAME = "PSDEFSFITEMNAME";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_ADDSEPARATOR = "ADDSEPARATOR";
    public static final String TAG_PSSYSEDITORSTYLEID = "PSSYSEDITORSTYLEID";
    public static final String TAG_PSSYSEDITORSTYLENAME = "PSSYSEDITORSTYLENAME";
    public static final String TAG_EDITORTYPE = "EDITORTYPE";
    public static final String TAG_EDITORTYPENAME = "EDITORTYPENAME";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_DATA = "DATA";
    public static final String TAG_ITEMTAG = "ITEMTAG";
    public static final String TAG_ITEMTAG2 = "ITEMTAG2";
    public static final String TAG_LABELPOS = "LABELPOS";
    public static final String TAG_LABELWIDTH = "LABELWIDTH";
    public static final String TAG_LABELPSSYSCSSID = "LABELPSSYSCSSID";
    public static final String TAG_LABELPSSYSCSSNAME = "LABELPSSYSCSSNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_CREATEDV = "CREATEDV";
    public static final String TAG_CREATEDVT = "CREATEDVT";
    public static final String TAG_MOBFLAG = "MOBFLAG";
    public static final String TAG_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String TAG_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String TAG_CTRLHEIGHT = "CTRLHEIGHT";
    public static final String TAG_CTRLWIDTH = "CTRLWIDTH";
    public static final String TAG_RAWCSSSTYLE = "RAWCSSSTYLE";
    public static final String TAG_LABELRAWCSSSTYLE = "LABELRAWCSSSTYLE";
    public static final String TAG_DYNACLASS = "DYNACLASS";
    public static final String TAG_LABELDYNACLASS = "LABELDYNACLASS";
    public static final String TAG_CTRLPSSYSCSSID = "CTRLPSSYSCSSID";
    public static final String TAG_CTRLPSSYSCSSNAME = "CTRLPSSYSCSSNAME";
    public static final String TAG_CTRLDYNACLASS = "CTRLDYNACLASS";
    public static final String TAG_CTRLRAWCSSSTYLE = "CTRLRAWCSSSTYLE";
    public static final String TAG_TEMPLATEMODE = "TEMPLATEMODE";
    public static final String TAG_EDITORPARAMS = "EDITORPARAMS";
    public static final String TAG_VALUEITEMNAME = "VALUEITEMNAME";
    public static final String TAG_RESETITEMNAME = "RESETITEMNAME";
    public static final String TAG_FILTERPSDEDSID = "FILTERPSDEDSID";
    public static final String TAG_FILTERPSDEDSNAME = "FILTERPSDEDSNAME";
    public static final String TAG_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String TAG_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String TAG_COUNTERMODE = "COUNTERMODE";
    public static final String TAG_COUNTERID = "COUNTERID";

    public final boolean isPSSYSSEARCHBARITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSSEARCHBARITEMID);
    }

    public final String getPSSYSSEARCHBARITEMID() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHBARITEMID, "");
    }

    public final void setPSSYSSEARCHBARITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHBARITEMID, strValue);
    }

    public final boolean isPSSYSSEARCHBARITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSSEARCHBARITEMNAME);
    }

    public final String getPSSYSSEARCHBARITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHBARITEMNAME, "");
    }

    public final void setPSSYSSEARCHBARITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHBARITEMNAME, strValue);
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

    public final boolean isPSSYSSEARCHBARIDNull() {
        return this.IsParamNull(TAG_PSSYSSEARCHBARID);
    }

    public final String getPSSYSSEARCHBARID() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHBARID, "");
    }

    public final void setPSSYSSEARCHBARID(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHBARID, strValue);
    }

    public final boolean isPSSYSSEARCHBARNAMENull() {
        return this.IsParamNull(TAG_PSSYSSEARCHBARNAME);
    }

    public final String getPSSYSSEARCHBARNAME() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHBARNAME, "");
    }

    public final void setPSSYSSEARCHBARNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHBARNAME, strValue);
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

    public final boolean isCAPTIONNull() {
        return this.IsParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
    }

    public final boolean isSHOWCAPTIONNull() {
        return this.IsParamNull(TAG_SHOWCAPTION);
    }

    public final boolean getSHOWCAPTION() {
        return this.GetParamIntValue(TAG_SHOWCAPTION, 0) == 1;
    }

    public final void setSHOWCAPTION(boolean bValue) {
        this.SetParamValue(TAG_SHOWCAPTION, bValue ? 1 : 0);
    }

    public final boolean isITEMTYPENull() {
        return this.IsParamNull(TAG_ITEMTYPE);
    }

    public final String getITEMTYPE() {
        return this.GetParamStringValue(TAG_ITEMTYPE, "");
    }

    public final void setITEMTYPE(String strValue) {
        this.SetParamValue(TAG_ITEMTYPE, strValue);
    }

    public final boolean isITEMSUBTYPENull() {
        return this.IsParamNull(TAG_ITEMSUBTYPE);
    }

    public final String getITEMSUBTYPE() {
        return this.GetParamStringValue(TAG_ITEMSUBTYPE, "");
    }

    public final void setITEMSUBTYPE(String strValue) {
        this.SetParamValue(TAG_ITEMSUBTYPE, strValue);
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

    public final boolean isCAPPSLANRESIDNull() {
        return this.IsParamNull(TAG_CAPPSLANRESID);
    }

    public final String getCAPPSLANRESID() {
        return this.GetParamStringValue(TAG_CAPPSLANRESID, "");
    }

    public final void setCAPPSLANRESID(String strValue) {
        this.SetParamValue(TAG_CAPPSLANRESID, strValue);
    }

    public final boolean isCAPPSLANRESNAMENull() {
        return this.IsParamNull(TAG_CAPPSLANRESNAME);
    }

    public final String getCAPPSLANRESNAME() {
        return this.GetParamStringValue(TAG_CAPPSLANRESNAME, "");
    }

    public final void setCAPPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_CAPPSLANRESNAME, strValue);
    }

    public final boolean isTOOLTIPINFONull() {
        return this.IsParamNull(TAG_TOOLTIPINFO);
    }

    public final String getTOOLTIPINFO() {
        return this.GetParamStringValue(TAG_TOOLTIPINFO, "");
    }

    public final void setTOOLTIPINFO(String strValue) {
        this.SetParamValue(TAG_TOOLTIPINFO, strValue);
    }

    public final boolean isTIPPSLANRESIDNull() {
        return this.IsParamNull(TAG_TIPPSLANRESID);
    }

    public final String getTIPPSLANRESID() {
        return this.GetParamStringValue(TAG_TIPPSLANRESID, "");
    }

    public final void setTIPPSLANRESID(String strValue) {
        this.SetParamValue(TAG_TIPPSLANRESID, strValue);
    }

    public final boolean isTIPPSLANRESNAMENull() {
        return this.IsParamNull(TAG_TIPPSLANRESNAME);
    }

    public final String getTIPPSLANRESNAME() {
        return this.GetParamStringValue(TAG_TIPPSLANRESNAME, "");
    }

    public final void setTIPPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_TIPPSLANRESNAME, strValue);
    }

    public final boolean isWIDTHNull() {
        return this.IsParamNull(TAG_WIDTH);
    }

    public final String getWIDTH() {
        return this.GetParamStringValue(TAG_WIDTH, "");
    }

    public final void setWIDTH(String strValue) {
        this.SetParamValue(TAG_WIDTH, strValue);
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

    public final boolean isPSSYSIMAGEIDNull() {
        return this.IsParamNull(TAG_PSSYSIMAGEID);
    }

    public final String getPSSYSIMAGEID() {
        return this.GetParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.IsParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.GetParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGENAME, strValue);
    }

    public final boolean isPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_PSSYSCSSID);
    }

    public final String getPSSYSCSSID() {
        return this.GetParamStringValue(TAG_PSSYSCSSID, "");
    }

    public final void setPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSID, strValue);
    }

    public final boolean isPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_PSSYSCSSNAME);
    }

    public final String getPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_PSSYSCSSNAME, "");
    }

    public final void setPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSNAME, strValue);
    }

    public final boolean isPLACEHOLDERNull() {
        return this.IsParamNull(TAG_PLACEHOLDER);
    }

    public final String getPLACEHOLDER() {
        return this.GetParamStringValue(TAG_PLACEHOLDER, "");
    }

    public final void setPLACEHOLDER(String strValue) {
        this.SetParamValue(TAG_PLACEHOLDER, strValue);
    }

    public final boolean isPHPSLANRESIDNull() {
        return this.IsParamNull(TAG_PHPSLANRESID);
    }

    public final String getPHPSLANRESID() {
        return this.GetParamStringValue(TAG_PHPSLANRESID, "");
    }

    public final void setPHPSLANRESID(String strValue) {
        this.SetParamValue(TAG_PHPSLANRESID, strValue);
    }

    public final boolean isPHPSLANRESNAMENull() {
        return this.IsParamNull(TAG_PHPSLANRESNAME);
    }

    public final String getPHPSLANRESNAME() {
        return this.GetParamStringValue(TAG_PHPSLANRESNAME, "");
    }

    public final void setPHPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_PHPSLANRESNAME, strValue);
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

    public final boolean isPSDEFSFITEMIDNull() {
        return this.IsParamNull(TAG_PSDEFSFITEMID);
    }

    public final String getPSDEFSFITEMID() {
        return this.GetParamStringValue(TAG_PSDEFSFITEMID, "");
    }

    public final void setPSDEFSFITEMID(String strValue) {
        this.SetParamValue(TAG_PSDEFSFITEMID, strValue);
    }

    public final boolean isPSDEFSFITEMNAMENull() {
        return this.IsParamNull(TAG_PSDEFSFITEMNAME);
    }

    public final String getPSDEFSFITEMNAME() {
        return this.GetParamStringValue(TAG_PSDEFSFITEMNAME, "");
    }

    public final void setPSDEFSFITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFSFITEMNAME, strValue);
    }

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isADDSEPARATORNull() {
        return this.IsParamNull(TAG_ADDSEPARATOR);
    }

    public final boolean getADDSEPARATOR() {
        return this.GetParamIntValue(TAG_ADDSEPARATOR, 0) == 1;
    }

    public final void setADDSEPARATOR(boolean bValue) {
        this.SetParamValue(TAG_ADDSEPARATOR, bValue ? 1 : 0);
    }

    public final boolean isPSSYSEDITORSTYLEIDNull() {
        return this.IsParamNull(TAG_PSSYSEDITORSTYLEID);
    }

    public final String getPSSYSEDITORSTYLEID() {
        return this.GetParamStringValue(TAG_PSSYSEDITORSTYLEID, "");
    }

    public final void setPSSYSEDITORSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSSYSEDITORSTYLEID, strValue);
    }

    public final boolean isPSSYSEDITORSTYLENAMENull() {
        return this.IsParamNull(TAG_PSSYSEDITORSTYLENAME);
    }

    public final String getPSSYSEDITORSTYLENAME() {
        return this.GetParamStringValue(TAG_PSSYSEDITORSTYLENAME, "");
    }

    public final void setPSSYSEDITORSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSEDITORSTYLENAME, strValue);
    }

    public final boolean isEDITORTYPENull() {
        return this.IsParamNull(TAG_EDITORTYPE);
    }

    public final String getEDITORTYPE() {
        return this.GetParamStringValue(TAG_EDITORTYPE, "");
    }

    public final void setEDITORTYPE(String strValue) {
        this.SetParamValue(TAG_EDITORTYPE, strValue);
    }

    public final boolean isEDITORTYPENAMENull() {
        return this.IsParamNull(TAG_EDITORTYPENAME);
    }

    public final String getEDITORTYPENAME() {
        return this.GetParamStringValue(TAG_EDITORTYPENAME, "");
    }

    public final void setEDITORTYPENAME(String strValue) {
        this.SetParamValue(TAG_EDITORTYPENAME, strValue);
    }

    public final boolean isHEIGHTNull() {
        return this.IsParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
    }

    public final boolean isUSERPARAMSNull() {
        return this.IsParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.GetParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.SetParamValue(TAG_USERPARAMS, strValue);
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

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
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

    public final boolean isITEMTAGNull() {
        return this.IsParamNull(TAG_ITEMTAG);
    }

    public final String getITEMTAG() {
        return this.GetParamStringValue(TAG_ITEMTAG, "");
    }

    public final void setITEMTAG(String strValue) {
        this.SetParamValue(TAG_ITEMTAG, strValue);
    }

    public final boolean isITEMTAG2Null() {
        return this.IsParamNull(TAG_ITEMTAG2);
    }

    public final String getITEMTAG2() {
        return this.GetParamStringValue(TAG_ITEMTAG2, "");
    }

    public final void setITEMTAG2(String strValue) {
        this.SetParamValue(TAG_ITEMTAG2, strValue);
    }

    public final boolean isLABELPOSNull() {
        return this.IsParamNull(TAG_LABELPOS);
    }

    public final String getLABELPOS() {
        return this.GetParamStringValue(TAG_LABELPOS, "");
    }

    public final void setLABELPOS(String strValue) {
        this.SetParamValue(TAG_LABELPOS, strValue);
    }

    public final boolean isLABELWIDTHNull() {
        return this.IsParamNull(TAG_LABELWIDTH);
    }

    public final int getLABELWIDTH() {
        return this.GetParamIntValue(TAG_LABELWIDTH, 0);
    }

    public final void setLABELWIDTH(int nValue) {
        this.SetParamValue(TAG_LABELWIDTH, nValue);
    }

    public final boolean isLABELPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_LABELPSSYSCSSID);
    }

    public final String getLABELPSSYSCSSID() {
        return this.GetParamStringValue(TAG_LABELPSSYSCSSID, "");
    }

    public final void setLABELPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_LABELPSSYSCSSID, strValue);
    }

    public final boolean isLABELPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_LABELPSSYSCSSNAME);
    }

    public final String getLABELPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_LABELPSSYSCSSNAME, "");
    }

    public final void setLABELPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_LABELPSSYSCSSNAME, strValue);
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

    public final boolean isCREATEDVNull() {
        return this.IsParamNull(TAG_CREATEDV);
    }

    public final String getCREATEDV() {
        return this.GetParamStringValue(TAG_CREATEDV, "");
    }

    public final void setCREATEDV(String strValue) {
        this.SetParamValue(TAG_CREATEDV, strValue);
    }

    public final boolean isCREATEDVTNull() {
        return this.IsParamNull(TAG_CREATEDVT);
    }

    public final String getCREATEDVT() {
        return this.GetParamStringValue(TAG_CREATEDVT, "");
    }

    public final void setCREATEDVT(String strValue) {
        this.SetParamValue(TAG_CREATEDVT, strValue);
    }

    public final boolean isMOBFLAGNull() {
        return this.IsParamNull(TAG_MOBFLAG);
    }

    public final boolean getMOBFLAG() {
        return this.GetParamIntValue(TAG_MOBFLAG, 0) == 1;
    }

    public final void setMOBFLAG(boolean bValue) {
        this.SetParamValue(TAG_MOBFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSSYSRESOURCEIDNull() {
        return this.IsParamNull(TAG_PSSYSRESOURCEID);
    }

    public final String getPSSYSRESOURCEID() {
        return this.GetParamStringValue(TAG_PSSYSRESOURCEID, "");
    }

    public final void setPSSYSRESOURCEID(String strValue) {
        this.SetParamValue(TAG_PSSYSRESOURCEID, strValue);
    }

    public final boolean isPSSYSRESOURCENAMENull() {
        return this.IsParamNull(TAG_PSSYSRESOURCENAME);
    }

    public final String getPSSYSRESOURCENAME() {
        return this.GetParamStringValue(TAG_PSSYSRESOURCENAME, "");
    }

    public final void setPSSYSRESOURCENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSRESOURCENAME, strValue);
    }

    public final boolean isCTRLHEIGHTNull() {
        return this.IsParamNull(TAG_CTRLHEIGHT);
    }

    public final int getCTRLHEIGHT() {
        return this.GetParamIntValue(TAG_CTRLHEIGHT, 0);
    }

    public final void setCTRLHEIGHT(int nValue) {
        this.SetParamValue(TAG_CTRLHEIGHT, nValue);
    }

    public final boolean isCTRLWIDTHNull() {
        return this.IsParamNull(TAG_CTRLWIDTH);
    }

    public final int getCTRLWIDTH() {
        return this.GetParamIntValue(TAG_CTRLWIDTH, 0);
    }

    public final void setCTRLWIDTH(int nValue) {
        this.SetParamValue(TAG_CTRLWIDTH, nValue);
    }

    public final boolean isCTRLPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_CTRLPSSYSCSSID);
    }

    public final String getCTRLPSSYSCSSID() {
        return this.GetParamStringValue(TAG_CTRLPSSYSCSSID, "");
    }

    public final void setCTRLPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_CTRLPSSYSCSSID, strValue);
    }

    public final boolean isCTRLPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_CTRLPSSYSCSSNAME);
    }

    public final String getCTRLPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_CTRLPSSYSCSSNAME, "");
    }

    public final void setCTRLPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_CTRLPSSYSCSSNAME, strValue);
    }

    public final boolean isCTRLDYNACLASSNull() {
        return this.IsParamNull(TAG_CTRLDYNACLASS);
    }

    public final String getCTRLDYNACLASS() {
        return this.GetParamStringValue(TAG_CTRLDYNACLASS, "");
    }

    public final void setCTRLDYNACLASS(String strValue) {
        this.SetParamValue(TAG_CTRLDYNACLASS, strValue);
    }

    public final boolean isCTRLRAWCSSSTYLENull() {
        return this.IsParamNull(TAG_CTRLRAWCSSSTYLE);
    }

    public final String getCTRLRAWCSSSTYLE() {
        return this.GetParamStringValue(TAG_CTRLRAWCSSSTYLE, "");
    }

    public final void setCTRLRAWCSSSTYLE(String strValue) {
        this.SetParamValue(TAG_CTRLRAWCSSSTYLE, strValue);
    }

    public final boolean isRAWCSSSTYLENull() {
        return this.IsParamNull(TAG_RAWCSSSTYLE);
    }

    public final String getRAWCSSSTYLE() {
        return this.GetParamStringValue(TAG_RAWCSSSTYLE, "");
    }

    public final void setRAWCSSSTYLE(String strValue) {
        this.SetParamValue(TAG_RAWCSSSTYLE, strValue);
    }

    public final boolean isLABELRAWCSSSTYLENull() {
        return this.IsParamNull(TAG_LABELRAWCSSSTYLE);
    }

    public final String getLABELRAWCSSSTYLE() {
        return this.GetParamStringValue(TAG_LABELRAWCSSSTYLE, "");
    }

    public final void setLABELRAWCSSSTYLE(String strValue) {
        this.SetParamValue(TAG_LABELRAWCSSSTYLE, strValue);
    }

    public final boolean isDYNACLASSNull() {
        return this.IsParamNull(TAG_DYNACLASS);
    }

    public final String getDYNACLASS() {
        return this.GetParamStringValue(TAG_DYNACLASS, "");
    }

    public final void setDYNACLASS(String strValue) {
        this.SetParamValue(TAG_DYNACLASS, strValue);
    }

    public final boolean isLABELDYNACLASSNull() {
        return this.IsParamNull(TAG_LABELDYNACLASS);
    }

    public final String getLABELDYNACLASS() {
        return this.GetParamStringValue(TAG_LABELDYNACLASS, "");
    }

    public final void setLABELDYNACLASS(String strValue) {
        this.SetParamValue(TAG_LABELDYNACLASS, strValue);
    }

    public final boolean isTEMPLATEMODENull() {
        return this.IsParamNull(TAG_TEMPLATEMODE);
    }

    public final int getTEMPLATEMODE() {
        return this.GetParamIntValue(TAG_TEMPLATEMODE, 0);
    }

    public final void setTEMPLATEMODE(int nValue) {
        this.SetParamValue(TAG_TEMPLATEMODE, nValue);
    }

    public final boolean isEDITORPARAMSNull() {
        return this.IsParamNull(TAG_EDITORPARAMS);
    }

    public final String getEDITORPARAMS() {
        return this.GetParamStringValue(TAG_EDITORPARAMS, "");
    }

    public final void setEDITORPARAMS(String strValue) {
        this.SetParamValue(TAG_EDITORPARAMS, strValue);
    }

    public final boolean isVALUEITEMNAMENull() {
        return this.IsParamNull(TAG_VALUEITEMNAME);
    }

    public final String getVALUEITEMNAME() {
        return this.GetParamStringValue(TAG_VALUEITEMNAME, "");
    }

    public final void setVALUEITEMNAME(String strValue) {
        this.SetParamValue(TAG_VALUEITEMNAME, strValue);
    }

    public final boolean isRESETITEMNAMENull() {
        return this.IsParamNull(TAG_RESETITEMNAME);
    }

    public final String getRESETITEMNAME() {
        return this.GetParamStringValue(TAG_RESETITEMNAME, "");
    }

    public final void setRESETITEMNAME(String strValue) {
        this.SetParamValue(TAG_RESETITEMNAME, strValue);
    }

    public final boolean isFILTERPSDEDSIDNull() {
        return this.IsParamNull(TAG_FILTERPSDEDSID);
    }

    public final String getFILTERPSDEDSID() {
        return this.GetParamStringValue(TAG_FILTERPSDEDSID, "");
    }

    public final void setFILTERPSDEDSID(String strValue) {
        this.SetParamValue(TAG_FILTERPSDEDSID, strValue);
    }

    public final boolean isFILTERPSDEDSNAMENull() {
        return this.IsParamNull(TAG_FILTERPSDEDSNAME);
    }

    public final String getFILTERPSDEDSNAME() {
        return this.GetParamStringValue(TAG_FILTERPSDEDSNAME, "");
    }

    public final void setFILTERPSDEDSNAME(String strValue) {
        this.SetParamValue(TAG_FILTERPSDEDSNAME, strValue);
    }

    public final boolean isCOUNTERMODENull() {
        return this.IsParamNull(TAG_COUNTERMODE);
    }

    public final int getCOUNTERMODE() {
        return this.GetParamIntValue(TAG_COUNTERMODE, 0);
    }

    public final void setCOUNTERMODE(int nValue) {
        this.SetParamValue(TAG_COUNTERMODE, nValue);
    }

    public final boolean isCOUNTERIDNull() {
        return this.IsParamNull(TAG_COUNTERID);
    }

    public final String getCOUNTERID() {
        return this.GetParamStringValue(TAG_COUNTERID, "");
    }

    public final void setCOUNTERID(String strValue) {
        this.SetParamValue(TAG_COUNTERID, strValue);
    }

    public final boolean isPSSYSCOUNTERIDNull() {
        return this.IsParamNull(TAG_PSSYSCOUNTERID);
    }

    public final String getPSSYSCOUNTERID() {
        return this.GetParamStringValue(TAG_PSSYSCOUNTERID, "");
    }

    public final void setPSSYSCOUNTERID(String strValue) {
        this.SetParamValue(TAG_PSSYSCOUNTERID, strValue);
    }

    public final boolean isPSSYSCOUNTERNAMENull() {
        return this.IsParamNull(TAG_PSSYSCOUNTERNAME);
    }

    public final String getPSSYSCOUNTERNAME() {
        return this.GetParamStringValue(TAG_PSSYSCOUNTERNAME, "");
    }

    public final void setPSSYSCOUNTERNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCOUNTERNAME, strValue);
    }
}

