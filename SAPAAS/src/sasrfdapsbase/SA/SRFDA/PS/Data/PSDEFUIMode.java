/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEFUIMode
extends BaseDataEntity {
    public static final String UIMODE_DEFAULT = "DEFAULT";
    public static final String UIMODE_CUSTOM = "CUSTOM";
    public static final String UIMODE_MOBILEDEFAULT = "MOBILEDEFAULT";
    public static final String UIMODE_APPDEFAULT = "APPDEFAULT";
    public static final String EDITORTYPE_TEXTBOX = "TEXTBOX";
    public static final String EDITORTYPE_USERCONTROL = "USERCONTROL";
    public static final String EDITORTYPE_HIDDEN = "HIDDEN";
    public static final String EDITORTYPE_IPADDRESSTEXTBOX = "IPADDRESSTEXTBOX";
    public static final String EDITORTYPE_SPAN = "SPAN";
    public static final String EDITORTYPE_TEXTAREA = "TEXTAREA";
    public static final String EDITORTYPE_PICKER = "PICKER";
    public static final String EDITORTYPE_DROPDOWNLIST = "DROPDOWNLIST";
    public static final String EDITORTYPE_HTMLEDITOR = "HTMLEDITOR";
    public static final String EDITORTYPE_RAW = "RAW";
    public static final String EDITORTYPE_DATEPICKER = "DATEPICKER";
    public static final String EDITORTYPE_LISTBOX = "LISTBOX";
    public static final String EDITORTYPE_CHECKBOXLIST = "CHECKBOXLIST";
    public static final String EDITORTYPE_CHECKBOX = "CHECKBOX";
    public static final String EDITORTYPE_RADIOBUTTONLIST = "RADIOBUTTONLIST";
    public static final String EDITORTYPE_FILEUPLOADER = "FILEUPLOADER";
    public static final String UPDATEDVT_SESSION = "SESSION";
    public static final String UPDATEDVT_APPLICATION = "APPLICATION";
    public static final String UPDATEDVT_UNIQUEID = "UNIQUEID";
    public static final String UPDATEDVT_CONTEXT = "CONTEXT";
    public static final String UPDATEDVT_PARAM = "PARAM";
    public static final String UPDATEDVT_OPERATOR = "OPERATOR";
    public static final String UPDATEDVT_OPERATORNAME = "OPERATORNAME";
    public static final String UPDATEDVT_CURTIME = "CURTIME";
    public static final String CREATEDVT_SESSION = "SESSION";
    public static final String CREATEDVT_APPLICATION = "APPLICATION";
    public static final String CREATEDVT_UNIQUEID = "UNIQUEID";
    public static final String CREATEDVT_CONTEXT = "CONTEXT";
    public static final String CREATEDVT_PARAM = "PARAM";
    public static final String CREATEDVT_OPERATOR = "OPERATOR";
    public static final String CREATEDVT_OPERATORNAME = "OPERATORNAME";
    public static final String CREATEDVT_CURTIME = "CURTIME";
    public static final int IGNOREINPUT_NONE = 0;
    public static final int IGNOREINPUT_CREATE = 1;
    public static final int IGNOREINPUT_UPDATE = 2;
    public static final int IGNOREINPUT_ALL = 3;
    public static final int PICKUPTEXTOPTS_IGNOREEXTRESTRICT = 1;
    public static final int PICKUPTEXTOPTS_IGNORETEMPDATA = 2;
    public static final int CODELISTCONFIGMODE_NONE = 0;
    public static final int CODELISTCONFIGMODE_SELECTEDONLY = 1;
    public static final int CODELISTCONFIGMODE_INCLUDECHILD = 2;
    public static final String TAG_PSDEFFORMITEMID = "PSDEFFORMITEMID";
    public static final String TAG_PSDEFFORMITEMNAME = "PSDEFFORMITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_FTMODE = "FTMODE";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_EDITORTYPE = "EDITORTYPE";
    public static final String TAG_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String TAG_REFPSDEID = "REFPSDEID";
    public static final String TAG_REFPSDENAME = "REFPSDENAME";
    public static final String TAG_REFPSDEACMODEID = "REFPSDEACMODEID";
    public static final String TAG_REFPSDEACMODENAME = "REFPSDEACMODENAME";
    public static final String TAG_VALUEFORMAT = "VALUEFORMAT";
    public static final String TAG_GRIDCOLWIDTH = "GRIDCOLWIDTH";
    public static final String TAG_PSSYSEDITORSTYLEID = "PSSYSEDITORSTYLEID";
    public static final String TAG_PSSYSEDITORSTYLENAME = "PSSYSEDITORSTYLENAME";
    public static final String TAG_REFPICKUPPSDEVIEWID = "REFPICKUPPSDEVIEWID";
    public static final String TAG_REFPICKUPPSDEVIEWNAME = "REFPICKUPPSDEVIEWNAME";
    public static final String TAG_UPDATEDV = "UPDATEDV";
    public static final String TAG_CREATEDV = "CREATEDV";
    public static final String TAG_UPDATEDVT = "UPDATEDVT";
    public static final String TAG_CREATEDVT = "CREATEDVT";
    public static final String TAG_NOSORT = "NOSORT";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_REFMPICKUPPSDEVIEWID = "REFMPICKUPPSDEVIEWID";
    public static final String TAG_REFMPICKUPPSDEVIEWNAME = "REFMPICKUPPSDEVIEWNAME";
    public static final String TAG_REFPSDEDATASETID = "REFPSDEDATASETID";
    public static final String TAG_REFPSDEDATASETNAME = "REFPSDEDATASETNAME";
    public static final String TAG_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String TAG_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String TAG_IGNOREINPUT = "IGNOREINPUT";
    public static final String TAG_EDITORPARAMS = "EDITORPARAMS";
    public static final String TAG_VALUEITEMNAME = "VALUEITEMNAME";
    public static final String TAG_NEEDCODELISTCONFIG = "NEEDCODELISTCONFIG";
    public static final String TAG_GCRPSSYSPFPLUGINID = "GCRPSSYSPFPLUGINID";
    public static final String TAG_GCRPSSYSPFPLUGINNAME = "GCRPSSYSPFPLUGINNAME";
    public static final String TAG_PSSYSDICTCATID = "PSSYSDICTCATID";
    public static final String TAG_PSSYSDICTCATNAME = "PSSYSDICTCATNAME";
    public static final String TAG_GRIDCOLALIGN = "GRIDCOLALIGN";
    public static final String TAG_REFLINKPSDEVIEWID = "REFLINKPSDEVIEWID";
    public static final String TAG_REFLINKPSDEVIEWNAME = "REFLINKPSDEVIEWNAME";
    public static final String TAG_PLACEHOLDER = "PLACEHOLDER";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_REFTEMPDATA = "REFTEMPDATA";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_ITEMPSACHANDLERID = "ITEMPSACHANDLERID";
    public static final String TAG_ITEMPSACHANDLERNAME = "ITEMPSACHANDLERNAME";
    public static final String TAG_PICKUPTEXTOPTS = "PICKUPTEXTOPTS";
    public static final String TAG_RESETITEMNAME = "RESETITEMNAME";
    public static final String TAG_ENABLERESETITEMNAME = "ENABLERESETITEMNAME";
    public static final String TAG_CODELISTCONFIGMODE = "CODELISTCONFIGMODE";
    public static final String TAG_UNITNAME = "UNITNAME";
    public static final String TAG_UNITNAMEWIDTH = "UNITNAMEWIDTH";
    public static final String TAG_ENABLEUNITNAME = "ENABLEUNITNAME";
    public static final String TAG_PSDEFINPUTTIPID = "PSDEFINPUTTIPID";
    public static final String TAG_PSDEFINPUTTIPNAME = "PSDEFINPUTTIPNAME";
    public static final String TAG_ENABLEINPUTTIP = "ENABLEINPUTTIP";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_PSSYSUNITID = "PSSYSUNITID";
    public static final String TAG_PSSYSUNITNAME = "PSSYSUNITNAME";
    public static final String TAG_PHPSLANRESID = "PHPSLANRESID";
    public static final String TAG_PHPSLANRESNAME = "PHPSLANRESNAME";
    public static final String TAG_CONVERTCITEXT = "CONVERTCITEXT";
    public static final String TAG_GRIDCOLCLMODE = "GRIDCOLCLMODE";
    public static final String TAG_REFADPSDELOGICID = "REFADPSDELOGICID";
    public static final String TAG_REFADPSDELOGICNAME = "REFADPSDELOGICNAME";
    public static final String TAG_REFPSDERID = "REFPSDERID";
    public static final String TAG_REFPSDERNAME = "REFPSDERNAME";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_MINSTRLENGTH = "MINSTRLENGTH";
    public static final String TAG_MINVALUE = "MINVALUE";
    public static final String TAG_MAXVALUE = "MAXVALUE";
    public static final String TAG_STRLENGTH = "STRLENGTH";
    public static final String TAG_STRINGCASE = "STRINGCASE";
    @Deprecated
    public static final String TAG_PRECISION2 = "PRECISION2";
    public static final String TAG_PRECISION = "PRECISION";
    public static final String TAG_ENABLEVALUERULE = "ENABLEVALUERULE";

    public final boolean isPSDEFFORMITEMIDNull() {
        return this.IsParamNull(TAG_PSDEFFORMITEMID);
    }

    public final String getPSDEFFORMITEMID() {
        return this.GetParamStringValue(TAG_PSDEFFORMITEMID, "");
    }

    public final void setPSDEFFORMITEMID(String strValue) {
        this.SetParamValue(TAG_PSDEFFORMITEMID, strValue);
    }

    public final boolean isPSDEFFORMITEMNAMENull() {
        return this.IsParamNull(TAG_PSDEFFORMITEMNAME);
    }

    public final String getPSDEFFORMITEMNAME() {
        return this.GetParamStringValue(TAG_PSDEFFORMITEMNAME, "");
    }

    public final void setPSDEFFORMITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFFORMITEMNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isFTMODENull() {
        return this.IsParamNull(TAG_FTMODE);
    }

    public final String getFTMODE() {
        return this.GetParamStringValue(TAG_FTMODE, "");
    }

    public final void setFTMODE(String strValue) {
        this.SetParamValue(TAG_FTMODE, strValue);
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

    public final boolean isHEIGHTNull() {
        return this.IsParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
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

    public final boolean isALLOWEMPTYNull() {
        return this.IsParamNull(TAG_ALLOWEMPTY);
    }

    public final boolean getALLOWEMPTY() {
        return this.GetParamIntValue(TAG_ALLOWEMPTY, 0) == 1;
    }

    public final void setALLOWEMPTY(boolean bValue) {
        this.SetParamValue(TAG_ALLOWEMPTY, bValue ? 1 : 0);
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

    public final boolean isREFPSDEACMODEIDNull() {
        return this.IsParamNull(TAG_REFPSDEACMODEID);
    }

    public final String getREFPSDEACMODEID() {
        return this.GetParamStringValue(TAG_REFPSDEACMODEID, "");
    }

    public final void setREFPSDEACMODEID(String strValue) {
        this.SetParamValue(TAG_REFPSDEACMODEID, strValue);
    }

    public final boolean isREFPSDEACMODENAMENull() {
        return this.IsParamNull(TAG_REFPSDEACMODENAME);
    }

    public final String getREFPSDEACMODENAME() {
        return this.GetParamStringValue(TAG_REFPSDEACMODENAME, "");
    }

    public final void setREFPSDEACMODENAME(String strValue) {
        this.SetParamValue(TAG_REFPSDEACMODENAME, strValue);
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

    public final boolean isGRIDCOLWIDTHNull() {
        return this.IsParamNull(TAG_GRIDCOLWIDTH);
    }

    public final int getGRIDCOLWIDTH() {
        return this.GetParamIntValue(TAG_GRIDCOLWIDTH, 0);
    }

    public final void setGRIDCOLWIDTH(int nValue) {
        this.SetParamValue(TAG_GRIDCOLWIDTH, nValue);
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

    public final boolean isREFPICKUPPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_REFPICKUPPSDEVIEWID);
    }

    public final String getREFPICKUPPSDEVIEWID() {
        return this.GetParamStringValue(TAG_REFPICKUPPSDEVIEWID, "");
    }

    public final void setREFPICKUPPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_REFPICKUPPSDEVIEWID, strValue);
    }

    public final boolean isREFPICKUPPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_REFPICKUPPSDEVIEWNAME);
    }

    public final String getREFPICKUPPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_REFPICKUPPSDEVIEWNAME, "");
    }

    public final void setREFPICKUPPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_REFPICKUPPSDEVIEWNAME, strValue);
    }

    public final boolean isUPDATEDVNull() {
        return this.IsParamNull(TAG_UPDATEDV);
    }

    public final String getUPDATEDV() {
        return this.GetParamStringValue(TAG_UPDATEDV, "");
    }

    public final void setUPDATEDV(String strValue) {
        this.SetParamValue(TAG_UPDATEDV, strValue);
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

    public final boolean isUPDATEDVTNull() {
        return this.IsParamNull(TAG_UPDATEDVT);
    }

    public final String getUPDATEDVT() {
        return this.GetParamStringValue(TAG_UPDATEDVT, "");
    }

    public final void setUPDATEDVT(String strValue) {
        this.SetParamValue(TAG_UPDATEDVT, strValue);
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

    public final boolean isNOSORTNull() {
        return this.IsParamNull(TAG_NOSORT);
    }

    public final boolean getNOSORT() {
        return this.GetParamIntValue(TAG_NOSORT, 0) == 1;
    }

    public final void setNOSORT(boolean bValue) {
        this.SetParamValue(TAG_NOSORT, bValue ? 1 : 0);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
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

    public final boolean isREFMPICKUPPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_REFMPICKUPPSDEVIEWID);
    }

    public final String getREFMPICKUPPSDEVIEWID() {
        return this.GetParamStringValue(TAG_REFMPICKUPPSDEVIEWID, "");
    }

    public final void setREFMPICKUPPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_REFMPICKUPPSDEVIEWID, strValue);
    }

    public final boolean isREFMPICKUPPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_REFMPICKUPPSDEVIEWNAME);
    }

    public final String getREFMPICKUPPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_REFMPICKUPPSDEVIEWNAME, "");
    }

    public final void setREFMPICKUPPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_REFMPICKUPPSDEVIEWNAME, strValue);
    }

    public final boolean isREFPSDEDATASETIDNull() {
        return this.IsParamNull(TAG_REFPSDEDATASETID);
    }

    public final String getREFPSDEDATASETID() {
        return this.GetParamStringValue(TAG_REFPSDEDATASETID, "");
    }

    public final void setREFPSDEDATASETID(String strValue) {
        this.SetParamValue(TAG_REFPSDEDATASETID, strValue);
    }

    public final boolean isREFPSDEDATASETNAMENull() {
        return this.IsParamNull(TAG_REFPSDEDATASETNAME);
    }

    public final String getREFPSDEDATASETNAME() {
        return this.GetParamStringValue(TAG_REFPSDEDATASETNAME, "");
    }

    public final void setREFPSDEDATASETNAME(String strValue) {
        this.SetParamValue(TAG_REFPSDEDATASETNAME, strValue);
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

    public final boolean isIGNOREINPUTNull() {
        return this.IsParamNull(TAG_IGNOREINPUT);
    }

    public final int getIGNOREINPUT() {
        return this.GetParamIntValue(TAG_IGNOREINPUT, 0);
    }

    public final void setIGNOREINPUT(int nValue) {
        this.SetParamValue(TAG_IGNOREINPUT, nValue);
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

    public final boolean isNEEDCODELISTCONFIGNull() {
        return this.IsParamNull(TAG_NEEDCODELISTCONFIG);
    }

    public final boolean getNEEDCODELISTCONFIG() {
        return this.GetParamIntValue(TAG_NEEDCODELISTCONFIG, 0) == 1;
    }

    public final void setNEEDCODELISTCONFIG(boolean bValue) {
        this.SetParamValue(TAG_NEEDCODELISTCONFIG, bValue ? 1 : 0);
    }

    public final boolean isGCRPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_GCRPSSYSPFPLUGINID);
    }

    public final String getGCRPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_GCRPSSYSPFPLUGINID, "");
    }

    public final void setGCRPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_GCRPSSYSPFPLUGINID, strValue);
    }

    public final boolean isGCRPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_GCRPSSYSPFPLUGINNAME);
    }

    public final String getGCRPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_GCRPSSYSPFPLUGINNAME, "");
    }

    public final void setGCRPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_GCRPSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isPSSYSDICTCATIDNull() {
        return this.IsParamNull(TAG_PSSYSDICTCATID);
    }

    public final String getPSSYSDICTCATID() {
        return this.GetParamStringValue(TAG_PSSYSDICTCATID, "");
    }

    public final void setPSSYSDICTCATID(String strValue) {
        this.SetParamValue(TAG_PSSYSDICTCATID, strValue);
    }

    public final boolean isPSSYSDICTCATNAMENull() {
        return this.IsParamNull(TAG_PSSYSDICTCATNAME);
    }

    public final String getPSSYSDICTCATNAME() {
        return this.GetParamStringValue(TAG_PSSYSDICTCATNAME, "");
    }

    public final void setPSSYSDICTCATNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDICTCATNAME, strValue);
    }

    public final boolean isGRIDCOLALIGNNull() {
        return this.IsParamNull(TAG_GRIDCOLALIGN);
    }

    public final String getGRIDCOLALIGN() {
        return this.GetParamStringValue(TAG_GRIDCOLALIGN, "");
    }

    public final void setGRIDCOLALIGN(String strValue) {
        this.SetParamValue(TAG_GRIDCOLALIGN, strValue);
    }

    public final boolean isREFLINKPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_REFLINKPSDEVIEWID);
    }

    public final String getREFLINKPSDEVIEWID() {
        return this.GetParamStringValue(TAG_REFLINKPSDEVIEWID, "");
    }

    public final void setREFLINKPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_REFLINKPSDEVIEWID, strValue);
    }

    public final boolean isREFLINKPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_REFLINKPSDEVIEWNAME);
    }

    public final String getREFLINKPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_REFLINKPSDEVIEWNAME, "");
    }

    public final void setREFLINKPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_REFLINKPSDEVIEWNAME, strValue);
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

    public final boolean isREFTEMPDATANull() {
        return this.IsParamNull(TAG_REFTEMPDATA);
    }

    public final boolean getREFTEMPDATA() {
        return this.GetParamIntValue(TAG_REFTEMPDATA, 0) == 1;
    }

    public final void setREFTEMPDATA(boolean bValue) {
        this.SetParamValue(TAG_REFTEMPDATA, bValue ? 1 : 0);
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

    public final boolean isITEMPSACHANDLERIDNull() {
        return this.IsParamNull(TAG_ITEMPSACHANDLERID);
    }

    public final String getITEMPSACHANDLERID() {
        return this.GetParamStringValue(TAG_ITEMPSACHANDLERID, "");
    }

    public final void setITEMPSACHANDLERID(String strValue) {
        this.SetParamValue(TAG_ITEMPSACHANDLERID, strValue);
    }

    public final boolean isITEMPSACHANDLERNAMENull() {
        return this.IsParamNull(TAG_ITEMPSACHANDLERNAME);
    }

    public final String getITEMPSACHANDLERNAME() {
        return this.GetParamStringValue(TAG_ITEMPSACHANDLERNAME, "");
    }

    public final void setITEMPSACHANDLERNAME(String strValue) {
        this.SetParamValue(TAG_ITEMPSACHANDLERNAME, strValue);
    }

    public final boolean isPICKUPTEXTOPTSNull() {
        return this.IsParamNull(TAG_PICKUPTEXTOPTS);
    }

    public final int getPICKUPTEXTOPTS() {
        return this.GetParamIntValue(TAG_PICKUPTEXTOPTS, 0);
    }

    public final void setPICKUPTEXTOPTS(int nValue) {
        this.SetParamValue(TAG_PICKUPTEXTOPTS, nValue);
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

    public final boolean isENABLERESETITEMNAMENull() {
        return this.IsParamNull(TAG_ENABLERESETITEMNAME);
    }

    public final boolean getENABLERESETITEMNAME() {
        return this.GetParamIntValue(TAG_ENABLERESETITEMNAME, 0) == 1;
    }

    public final void setENABLERESETITEMNAME(boolean bValue) {
        this.SetParamValue(TAG_ENABLERESETITEMNAME, bValue ? 1 : 0);
    }

    public final boolean isCODELISTCONFIGMODENull() {
        return this.IsParamNull(TAG_CODELISTCONFIGMODE);
    }

    public final int getCODELISTCONFIGMODE() {
        return this.GetParamIntValue(TAG_CODELISTCONFIGMODE, 0);
    }

    public final void setCODELISTCONFIGMODE(int nValue) {
        this.SetParamValue(TAG_CODELISTCONFIGMODE, nValue);
    }

    public final boolean isUNITNAMENull() {
        return this.IsParamNull(TAG_UNITNAME);
    }

    public final String getUNITNAME() {
        return this.GetParamStringValue(TAG_UNITNAME, "");
    }

    public final void setUNITNAME(String strValue) {
        this.SetParamValue(TAG_UNITNAME, strValue);
    }

    public final boolean isUNITNAMEWIDTHNull() {
        return this.IsParamNull(TAG_UNITNAMEWIDTH);
    }

    public final int getUNITNAMEWIDTH() {
        return this.GetParamIntValue(TAG_UNITNAMEWIDTH, 0);
    }

    public final void setUNITNAMEWIDTH(int nValue) {
        this.SetParamValue(TAG_UNITNAMEWIDTH, nValue);
    }

    public final boolean isENABLEUNITNAMENull() {
        return this.IsParamNull(TAG_ENABLEUNITNAME);
    }

    public final boolean getENABLEUNITNAME() {
        return this.GetParamIntValue(TAG_ENABLEUNITNAME, 0) == 1;
    }

    public final void setENABLEUNITNAME(boolean bValue) {
        this.SetParamValue(TAG_ENABLEUNITNAME, bValue ? 1 : 0);
    }

    public final boolean isPSDEFINPUTTIPIDNull() {
        return this.IsParamNull(TAG_PSDEFINPUTTIPID);
    }

    public final String getPSDEFINPUTTIPID() {
        return this.GetParamStringValue(TAG_PSDEFINPUTTIPID, "");
    }

    public final void setPSDEFINPUTTIPID(String strValue) {
        this.SetParamValue(TAG_PSDEFINPUTTIPID, strValue);
    }

    public final boolean isPSDEFINPUTTIPNAMENull() {
        return this.IsParamNull(TAG_PSDEFINPUTTIPNAME);
    }

    public final String getPSDEFINPUTTIPNAME() {
        return this.GetParamStringValue(TAG_PSDEFINPUTTIPNAME, "");
    }

    public final void setPSDEFINPUTTIPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFINPUTTIPNAME, strValue);
    }

    public final boolean isENABLEINPUTTIPNull() {
        return this.IsParamNull(TAG_ENABLEINPUTTIP);
    }

    public final boolean getENABLEINPUTTIP() {
        return this.GetParamIntValue(TAG_ENABLEINPUTTIP, 0) == 1;
    }

    public final void setENABLEINPUTTIP(boolean bValue) {
        this.SetParamValue(TAG_ENABLEINPUTTIP, bValue ? 1 : 0);
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

    public final boolean isPSSYSUNITIDNull() {
        return this.IsParamNull(TAG_PSSYSUNITID);
    }

    public final String getPSSYSUNITID() {
        return this.GetParamStringValue(TAG_PSSYSUNITID, "");
    }

    public final void setPSSYSUNITID(String strValue) {
        this.SetParamValue(TAG_PSSYSUNITID, strValue);
    }

    public final boolean isPSSYSUNITNAMENull() {
        return this.IsParamNull(TAG_PSSYSUNITNAME);
    }

    public final String getPSSYSUNITNAME() {
        return this.GetParamStringValue(TAG_PSSYSUNITNAME, "");
    }

    public final void setPSSYSUNITNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUNITNAME, strValue);
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

    public final boolean isCONVERTCITEXTNull() {
        return this.IsParamNull(TAG_CONVERTCITEXT);
    }

    public final boolean getCONVERTCITEXT() {
        return this.GetParamIntValue(TAG_CONVERTCITEXT, 0) == 1;
    }

    public final void setCONVERTCITEXT(boolean bValue) {
        this.SetParamValue(TAG_CONVERTCITEXT, bValue ? 1 : 0);
    }

    public final boolean isGRIDCOLCLMODENull() {
        return this.IsParamNull(TAG_GRIDCOLCLMODE);
    }

    public final String getGRIDCOLCLMODE() {
        return this.GetParamStringValue(TAG_GRIDCOLCLMODE, "");
    }

    public final void setGRIDCOLCLMODE(String strValue) {
        this.SetParamValue(TAG_GRIDCOLCLMODE, strValue);
    }

    public final boolean isREFADPSDELOGICIDNull() {
        return this.IsParamNull(TAG_REFADPSDELOGICID);
    }

    public final String getREFADPSDELOGICID() {
        return this.GetParamStringValue(TAG_REFADPSDELOGICID, "");
    }

    public final void setREFADPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_REFADPSDELOGICID, strValue);
    }

    public final boolean isREFADPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_REFADPSDELOGICNAME);
    }

    public final String getREFADPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_REFADPSDELOGICNAME, "");
    }

    public final void setREFADPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_REFADPSDELOGICNAME, strValue);
    }

    public final boolean isREFPSDERIDNull() {
        return this.IsParamNull(TAG_REFPSDERID);
    }

    public final String getREFPSDERID() {
        return this.GetParamStringValue(TAG_REFPSDERID, "");
    }

    public final void setREFPSDERID(String strValue) {
        this.SetParamValue(TAG_REFPSDERID, strValue);
    }

    public final boolean isREFPSDERNAMENull() {
        return this.IsParamNull(TAG_REFPSDERNAME);
    }

    public final String getREFPSDERNAME() {
        return this.GetParamStringValue(TAG_REFPSDERNAME, "");
    }

    public final void setREFPSDERNAME(String strValue) {
        this.SetParamValue(TAG_REFPSDERNAME, strValue);
    }

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

    public final boolean isMINVALUENull() {
        return this.IsParamNull(TAG_MINVALUE);
    }

    public final String getMINVALUE() {
        return this.GetParamStringValue(TAG_MINVALUE, "");
    }

    public final void setMINVALUE(String strValue) {
        this.SetParamValue(TAG_MINVALUE, strValue);
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

    public final boolean isSTRLENGTHNull() {
        return this.IsParamNull(TAG_STRLENGTH);
    }

    public final int getSTRLENGTH() {
        return this.GetParamIntValue(TAG_STRLENGTH, 0);
    }

    public final void setSTRLENGTH(int nValue) {
        this.SetParamValue(TAG_STRLENGTH, nValue);
    }

    public final boolean isSTRINGCASENull() {
        return this.IsParamNull(TAG_STRINGCASE);
    }

    public final String getSTRINGCASE() {
        return this.GetParamStringValue(TAG_STRINGCASE, "");
    }

    public final void setSTRINGCASE(String strValue) {
        this.SetParamValue(TAG_STRINGCASE, strValue);
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

    public final boolean isENABLEVALUERULENull() {
        return this.IsParamNull(TAG_ENABLEVALUERULE);
    }

    public final boolean getENABLEVALUERULE() {
        return this.GetParamIntValue(TAG_ENABLEVALUERULE, 0) == 1;
    }

    public final void setENABLEVALUERULE(boolean bValue) {
        this.SetParamValue(TAG_ENABLEVALUERULE, bValue ? 1 : 0);
    }
}

