/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEFUIMode
extends BaseDataEntity {
    public static final String UIMODE_DEFAULT = "DEFAULT";
    public static final String UIMODE_CUSTOM = "CUSTOM";
    public static final String UIMODE_MOBILEDEFAULT = "MOBILEDEFAULT";
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

    public final boolean isPSDEFFORMITEMIDNull() {
        return this.isParamNull(TAG_PSDEFFORMITEMID);
    }

    public final String getPSDEFFORMITEMID() {
        return this.getParamStringValue(TAG_PSDEFFORMITEMID, "");
    }

    public final void setPSDEFFORMITEMID(String strValue) {
        this.setParamValue(TAG_PSDEFFORMITEMID, strValue);
    }

    public final boolean isPSDEFFORMITEMNAMENull() {
        return this.isParamNull(TAG_PSDEFFORMITEMNAME);
    }

    public final String getPSDEFFORMITEMNAME() {
        return this.getParamStringValue(TAG_PSDEFFORMITEMNAME, "");
    }

    public final void setPSDEFFORMITEMNAME(String strValue) {
        this.setParamValue(TAG_PSDEFFORMITEMNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSDEFIDNull() {
        return this.isParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.getParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.setParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.isParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.getParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.setParamValue(TAG_PSDEFNAME, strValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isFTMODENull() {
        return this.isParamNull(TAG_FTMODE);
    }

    public final String getFTMODE() {
        return this.getParamStringValue(TAG_FTMODE, "");
    }

    public final void setFTMODE(String strValue) {
        this.setParamValue(TAG_FTMODE, strValue);
    }

    public final boolean isWIDTHNull() {
        return this.isParamNull(TAG_WIDTH);
    }

    public final int getWIDTH() {
        return this.getParamIntValue(TAG_WIDTH, 0);
    }

    public final void setWIDTH(int nValue) {
        this.setParamValue(TAG_WIDTH, nValue);
    }

    public final boolean isHEIGHTNull() {
        return this.isParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.getParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.setParamValue(TAG_HEIGHT, nValue);
    }

    public final boolean isEDITORTYPENull() {
        return this.isParamNull(TAG_EDITORTYPE);
    }

    public final String getEDITORTYPE() {
        return this.getParamStringValue(TAG_EDITORTYPE, "");
    }

    public final void setEDITORTYPE(String strValue) {
        this.setParamValue(TAG_EDITORTYPE, strValue);
    }

    public final boolean isALLOWEMPTYNull() {
        return this.isParamNull(TAG_ALLOWEMPTY);
    }

    public final boolean getALLOWEMPTY() {
        return this.getParamIntValue(TAG_ALLOWEMPTY, 0) == 1;
    }

    public final void setALLOWEMPTY(boolean bValue) {
        this.setParamValue(TAG_ALLOWEMPTY, bValue ? 1 : 0);
    }

    public final boolean isREFPSDEIDNull() {
        return this.isParamNull(TAG_REFPSDEID);
    }

    public final String getREFPSDEID() {
        return this.getParamStringValue(TAG_REFPSDEID, "");
    }

    public final void setREFPSDEID(String strValue) {
        this.setParamValue(TAG_REFPSDEID, strValue);
    }

    public final boolean isREFPSDENAMENull() {
        return this.isParamNull(TAG_REFPSDENAME);
    }

    public final String getREFPSDENAME() {
        return this.getParamStringValue(TAG_REFPSDENAME, "");
    }

    public final void setREFPSDENAME(String strValue) {
        this.setParamValue(TAG_REFPSDENAME, strValue);
    }

    public final boolean isREFPSDEACMODEIDNull() {
        return this.isParamNull(TAG_REFPSDEACMODEID);
    }

    public final String getREFPSDEACMODEID() {
        return this.getParamStringValue(TAG_REFPSDEACMODEID, "");
    }

    public final void setREFPSDEACMODEID(String strValue) {
        this.setParamValue(TAG_REFPSDEACMODEID, strValue);
    }

    public final boolean isREFPSDEACMODENAMENull() {
        return this.isParamNull(TAG_REFPSDEACMODENAME);
    }

    public final String getREFPSDEACMODENAME() {
        return this.getParamStringValue(TAG_REFPSDEACMODENAME, "");
    }

    public final void setREFPSDEACMODENAME(String strValue) {
        this.setParamValue(TAG_REFPSDEACMODENAME, strValue);
    }

    public final boolean isVALUEFORMATNull() {
        return this.isParamNull(TAG_VALUEFORMAT);
    }

    public final String getVALUEFORMAT() {
        return this.getParamStringValue(TAG_VALUEFORMAT, "");
    }

    public final void setVALUEFORMAT(String strValue) {
        this.setParamValue(TAG_VALUEFORMAT, strValue);
    }

    public final boolean isGRIDCOLWIDTHNull() {
        return this.isParamNull(TAG_GRIDCOLWIDTH);
    }

    public final int getGRIDCOLWIDTH() {
        return this.getParamIntValue(TAG_GRIDCOLWIDTH, 0);
    }

    public final void setGRIDCOLWIDTH(int nValue) {
        this.setParamValue(TAG_GRIDCOLWIDTH, nValue);
    }

    public final boolean isPSSYSEDITORSTYLEIDNull() {
        return this.isParamNull(TAG_PSSYSEDITORSTYLEID);
    }

    public final String getPSSYSEDITORSTYLEID() {
        return this.getParamStringValue(TAG_PSSYSEDITORSTYLEID, "");
    }

    public final void setPSSYSEDITORSTYLEID(String strValue) {
        this.setParamValue(TAG_PSSYSEDITORSTYLEID, strValue);
    }

    public final boolean isPSSYSEDITORSTYLENAMENull() {
        return this.isParamNull(TAG_PSSYSEDITORSTYLENAME);
    }

    public final String getPSSYSEDITORSTYLENAME() {
        return this.getParamStringValue(TAG_PSSYSEDITORSTYLENAME, "");
    }

    public final void setPSSYSEDITORSTYLENAME(String strValue) {
        this.setParamValue(TAG_PSSYSEDITORSTYLENAME, strValue);
    }

    public final boolean isREFPICKUPPSDEVIEWIDNull() {
        return this.isParamNull(TAG_REFPICKUPPSDEVIEWID);
    }

    public final String getREFPICKUPPSDEVIEWID() {
        return this.getParamStringValue(TAG_REFPICKUPPSDEVIEWID, "");
    }

    public final void setREFPICKUPPSDEVIEWID(String strValue) {
        this.setParamValue(TAG_REFPICKUPPSDEVIEWID, strValue);
    }

    public final boolean isREFPICKUPPSDEVIEWNAMENull() {
        return this.isParamNull(TAG_REFPICKUPPSDEVIEWNAME);
    }

    public final String getREFPICKUPPSDEVIEWNAME() {
        return this.getParamStringValue(TAG_REFPICKUPPSDEVIEWNAME, "");
    }

    public final void setREFPICKUPPSDEVIEWNAME(String strValue) {
        this.setParamValue(TAG_REFPICKUPPSDEVIEWNAME, strValue);
    }

    public final boolean isUPDATEDVNull() {
        return this.isParamNull(TAG_UPDATEDV);
    }

    public final String getUPDATEDV() {
        return this.getParamStringValue(TAG_UPDATEDV, "");
    }

    public final void setUPDATEDV(String strValue) {
        this.setParamValue(TAG_UPDATEDV, strValue);
    }

    public final boolean isCREATEDVNull() {
        return this.isParamNull(TAG_CREATEDV);
    }

    public final String getCREATEDV() {
        return this.getParamStringValue(TAG_CREATEDV, "");
    }

    public final void setCREATEDV(String strValue) {
        this.setParamValue(TAG_CREATEDV, strValue);
    }

    public final boolean isUPDATEDVTNull() {
        return this.isParamNull(TAG_UPDATEDVT);
    }

    public final String getUPDATEDVT() {
        return this.getParamStringValue(TAG_UPDATEDVT, "");
    }

    public final void setUPDATEDVT(String strValue) {
        this.setParamValue(TAG_UPDATEDVT, strValue);
    }

    public final boolean isCREATEDVTNull() {
        return this.isParamNull(TAG_CREATEDVT);
    }

    public final String getCREATEDVT() {
        return this.getParamStringValue(TAG_CREATEDVT, "");
    }

    public final void setCREATEDVT(String strValue) {
        this.setParamValue(TAG_CREATEDVT, strValue);
    }

    public final boolean isNOSORTNull() {
        return this.isParamNull(TAG_NOSORT);
    }

    public final boolean getNOSORT() {
        return this.getParamIntValue(TAG_NOSORT, 0) == 1;
    }

    public final void setNOSORT(boolean bValue) {
        this.setParamValue(TAG_NOSORT, bValue ? 1 : 0);
    }

    public final boolean isPSDEIDNull() {
        return this.isParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.getParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.setParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSCODELISTIDNull() {
        return this.isParamNull(TAG_PSCODELISTID);
    }

    public final String getPSCODELISTID() {
        return this.getParamStringValue(TAG_PSCODELISTID, "");
    }

    public final void setPSCODELISTID(String strValue) {
        this.setParamValue(TAG_PSCODELISTID, strValue);
    }

    public final boolean isPSCODELISTNAMENull() {
        return this.isParamNull(TAG_PSCODELISTNAME);
    }

    public final String getPSCODELISTNAME() {
        return this.getParamStringValue(TAG_PSCODELISTNAME, "");
    }

    public final void setPSCODELISTNAME(String strValue) {
        this.setParamValue(TAG_PSCODELISTNAME, strValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isCAPTIONNull() {
        return this.isParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.getParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.setParamValue(TAG_CAPTION, strValue);
    }

    public final boolean isREFMPICKUPPSDEVIEWIDNull() {
        return this.isParamNull(TAG_REFMPICKUPPSDEVIEWID);
    }

    public final String getREFMPICKUPPSDEVIEWID() {
        return this.getParamStringValue(TAG_REFMPICKUPPSDEVIEWID, "");
    }

    public final void setREFMPICKUPPSDEVIEWID(String strValue) {
        this.setParamValue(TAG_REFMPICKUPPSDEVIEWID, strValue);
    }

    public final boolean isREFMPICKUPPSDEVIEWNAMENull() {
        return this.isParamNull(TAG_REFMPICKUPPSDEVIEWNAME);
    }

    public final String getREFMPICKUPPSDEVIEWNAME() {
        return this.getParamStringValue(TAG_REFMPICKUPPSDEVIEWNAME, "");
    }

    public final void setREFMPICKUPPSDEVIEWNAME(String strValue) {
        this.setParamValue(TAG_REFMPICKUPPSDEVIEWNAME, strValue);
    }

    public final boolean isREFPSDEDATASETIDNull() {
        return this.isParamNull(TAG_REFPSDEDATASETID);
    }

    public final String getREFPSDEDATASETID() {
        return this.getParamStringValue(TAG_REFPSDEDATASETID, "");
    }

    public final void setREFPSDEDATASETID(String strValue) {
        this.setParamValue(TAG_REFPSDEDATASETID, strValue);
    }

    public final boolean isREFPSDEDATASETNAMENull() {
        return this.isParamNull(TAG_REFPSDEDATASETNAME);
    }

    public final String getREFPSDEDATASETNAME() {
        return this.getParamStringValue(TAG_REFPSDEDATASETNAME, "");
    }

    public final void setREFPSDEDATASETNAME(String strValue) {
        this.setParamValue(TAG_REFPSDEDATASETNAME, strValue);
    }

    public final boolean isPSSYSVALUERULEIDNull() {
        return this.isParamNull(TAG_PSSYSVALUERULEID);
    }

    public final String getPSSYSVALUERULEID() {
        return this.getParamStringValue(TAG_PSSYSVALUERULEID, "");
    }

    public final void setPSSYSVALUERULEID(String strValue) {
        this.setParamValue(TAG_PSSYSVALUERULEID, strValue);
    }

    public final boolean isPSSYSVALUERULENAMENull() {
        return this.isParamNull(TAG_PSSYSVALUERULENAME);
    }

    public final String getPSSYSVALUERULENAME() {
        return this.getParamStringValue(TAG_PSSYSVALUERULENAME, "");
    }

    public final void setPSSYSVALUERULENAME(String strValue) {
        this.setParamValue(TAG_PSSYSVALUERULENAME, strValue);
    }

    public final boolean isIGNOREINPUTNull() {
        return this.isParamNull(TAG_IGNOREINPUT);
    }

    public final int getIGNOREINPUT() {
        return this.getParamIntValue(TAG_IGNOREINPUT, 0);
    }

    public final void setIGNOREINPUT(int nValue) {
        this.setParamValue(TAG_IGNOREINPUT, nValue);
    }

    public final boolean isEDITORPARAMSNull() {
        return this.isParamNull(TAG_EDITORPARAMS);
    }

    public final String getEDITORPARAMS() {
        return this.getParamStringValue(TAG_EDITORPARAMS, "");
    }

    public final void setEDITORPARAMS(String strValue) {
        this.setParamValue(TAG_EDITORPARAMS, strValue);
    }

    public final boolean isVALUEITEMNAMENull() {
        return this.isParamNull(TAG_VALUEITEMNAME);
    }

    public final String getVALUEITEMNAME() {
        return this.getParamStringValue(TAG_VALUEITEMNAME, "");
    }

    public final void setVALUEITEMNAME(String strValue) {
        this.setParamValue(TAG_VALUEITEMNAME, strValue);
    }

    public final boolean isNEEDCODELISTCONFIGNull() {
        return this.isParamNull(TAG_NEEDCODELISTCONFIG);
    }

    public final boolean getNEEDCODELISTCONFIG() {
        return this.getParamIntValue(TAG_NEEDCODELISTCONFIG, 0) == 1;
    }

    public final void setNEEDCODELISTCONFIG(boolean bValue) {
        this.setParamValue(TAG_NEEDCODELISTCONFIG, bValue ? 1 : 0);
    }

    public final boolean isGCRPSSYSPFPLUGINIDNull() {
        return this.isParamNull(TAG_GCRPSSYSPFPLUGINID);
    }

    public final String getGCRPSSYSPFPLUGINID() {
        return this.getParamStringValue(TAG_GCRPSSYSPFPLUGINID, "");
    }

    public final void setGCRPSSYSPFPLUGINID(String strValue) {
        this.setParamValue(TAG_GCRPSSYSPFPLUGINID, strValue);
    }

    public final boolean isGCRPSSYSPFPLUGINNAMENull() {
        return this.isParamNull(TAG_GCRPSSYSPFPLUGINNAME);
    }

    public final String getGCRPSSYSPFPLUGINNAME() {
        return this.getParamStringValue(TAG_GCRPSSYSPFPLUGINNAME, "");
    }

    public final void setGCRPSSYSPFPLUGINNAME(String strValue) {
        this.setParamValue(TAG_GCRPSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isPSSYSDICTCATIDNull() {
        return this.isParamNull(TAG_PSSYSDICTCATID);
    }

    public final String getPSSYSDICTCATID() {
        return this.getParamStringValue(TAG_PSSYSDICTCATID, "");
    }

    public final void setPSSYSDICTCATID(String strValue) {
        this.setParamValue(TAG_PSSYSDICTCATID, strValue);
    }

    public final boolean isPSSYSDICTCATNAMENull() {
        return this.isParamNull(TAG_PSSYSDICTCATNAME);
    }

    public final String getPSSYSDICTCATNAME() {
        return this.getParamStringValue(TAG_PSSYSDICTCATNAME, "");
    }

    public final void setPSSYSDICTCATNAME(String strValue) {
        this.setParamValue(TAG_PSSYSDICTCATNAME, strValue);
    }

    public final boolean isGRIDCOLALIGNNull() {
        return this.isParamNull(TAG_GRIDCOLALIGN);
    }

    public final String getGRIDCOLALIGN() {
        return this.getParamStringValue(TAG_GRIDCOLALIGN, "");
    }

    public final void setGRIDCOLALIGN(String strValue) {
        this.setParamValue(TAG_GRIDCOLALIGN, strValue);
    }

    public final boolean isREFLINKPSDEVIEWIDNull() {
        return this.isParamNull(TAG_REFLINKPSDEVIEWID);
    }

    public final String getREFLINKPSDEVIEWID() {
        return this.getParamStringValue(TAG_REFLINKPSDEVIEWID, "");
    }

    public final void setREFLINKPSDEVIEWID(String strValue) {
        this.setParamValue(TAG_REFLINKPSDEVIEWID, strValue);
    }

    public final boolean isREFLINKPSDEVIEWNAMENull() {
        return this.isParamNull(TAG_REFLINKPSDEVIEWNAME);
    }

    public final String getREFLINKPSDEVIEWNAME() {
        return this.getParamStringValue(TAG_REFLINKPSDEVIEWNAME, "");
    }

    public final void setREFLINKPSDEVIEWNAME(String strValue) {
        this.setParamValue(TAG_REFLINKPSDEVIEWNAME, strValue);
    }

    public final boolean isPLACEHOLDERNull() {
        return this.isParamNull(TAG_PLACEHOLDER);
    }

    public final String getPLACEHOLDER() {
        return this.getParamStringValue(TAG_PLACEHOLDER, "");
    }

    public final void setPLACEHOLDER(String strValue) {
        this.setParamValue(TAG_PLACEHOLDER, strValue);
    }

    public final boolean isPSSYSIMAGEIDNull() {
        return this.isParamNull(TAG_PSSYSIMAGEID);
    }

    public final String getPSSYSIMAGEID() {
        return this.getParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.setParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.isParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.getParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.setParamValue(TAG_PSSYSIMAGENAME, strValue);
    }

    public final boolean isREFTEMPDATANull() {
        return this.isParamNull(TAG_REFTEMPDATA);
    }

    public final boolean getREFTEMPDATA() {
        return this.getParamIntValue(TAG_REFTEMPDATA, 0) == 1;
    }

    public final void setREFTEMPDATA(boolean bValue) {
        this.setParamValue(TAG_REFTEMPDATA, bValue ? 1 : 0);
    }

    public final boolean isUSERPARAMSNull() {
        return this.isParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.getParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.setParamValue(TAG_USERPARAMS, strValue);
    }

    public final boolean isITEMPSACHANDLERIDNull() {
        return this.isParamNull(TAG_ITEMPSACHANDLERID);
    }

    public final String getITEMPSACHANDLERID() {
        return this.getParamStringValue(TAG_ITEMPSACHANDLERID, "");
    }

    public final void setITEMPSACHANDLERID(String strValue) {
        this.setParamValue(TAG_ITEMPSACHANDLERID, strValue);
    }

    public final boolean isITEMPSACHANDLERNAMENull() {
        return this.isParamNull(TAG_ITEMPSACHANDLERNAME);
    }

    public final String getITEMPSACHANDLERNAME() {
        return this.getParamStringValue(TAG_ITEMPSACHANDLERNAME, "");
    }

    public final void setITEMPSACHANDLERNAME(String strValue) {
        this.setParamValue(TAG_ITEMPSACHANDLERNAME, strValue);
    }

    public final boolean isPICKUPTEXTOPTSNull() {
        return this.isParamNull(TAG_PICKUPTEXTOPTS);
    }

    public final int getPICKUPTEXTOPTS() {
        return this.getParamIntValue(TAG_PICKUPTEXTOPTS, 0);
    }

    public final void setPICKUPTEXTOPTS(int nValue) {
        this.setParamValue(TAG_PICKUPTEXTOPTS, nValue);
    }

    public final boolean isRESETITEMNAMENull() {
        return this.isParamNull(TAG_RESETITEMNAME);
    }

    public final String getRESETITEMNAME() {
        return this.getParamStringValue(TAG_RESETITEMNAME, "");
    }

    public final void setRESETITEMNAME(String strValue) {
        this.setParamValue(TAG_RESETITEMNAME, strValue);
    }

    public final boolean isENABLERESETITEMNAMENull() {
        return this.isParamNull(TAG_ENABLERESETITEMNAME);
    }

    public final boolean getENABLERESETITEMNAME() {
        return this.getParamIntValue(TAG_ENABLERESETITEMNAME, 0) == 1;
    }

    public final void setENABLERESETITEMNAME(boolean bValue) {
        this.setParamValue(TAG_ENABLERESETITEMNAME, bValue ? 1 : 0);
    }

    public final boolean isCODELISTCONFIGMODENull() {
        return this.isParamNull(TAG_CODELISTCONFIGMODE);
    }

    public final int getCODELISTCONFIGMODE() {
        return this.getParamIntValue(TAG_CODELISTCONFIGMODE, 0);
    }

    public final void setCODELISTCONFIGMODE(int nValue) {
        this.setParamValue(TAG_CODELISTCONFIGMODE, nValue);
    }

    public final boolean isUNITNAMENull() {
        return this.isParamNull(TAG_UNITNAME);
    }

    public final String getUNITNAME() {
        return this.getParamStringValue(TAG_UNITNAME, "");
    }

    public final void setUNITNAME(String strValue) {
        this.setParamValue(TAG_UNITNAME, strValue);
    }

    public final boolean isUNITNAMEWIDTHNull() {
        return this.isParamNull(TAG_UNITNAMEWIDTH);
    }

    public final int getUNITNAMEWIDTH() {
        return this.getParamIntValue(TAG_UNITNAMEWIDTH, 0);
    }

    public final void setUNITNAMEWIDTH(int nValue) {
        this.setParamValue(TAG_UNITNAMEWIDTH, nValue);
    }

    public final boolean isENABLEUNITNAMENull() {
        return this.isParamNull(TAG_ENABLEUNITNAME);
    }

    public final boolean getENABLEUNITNAME() {
        return this.getParamIntValue(TAG_ENABLEUNITNAME, 0) == 1;
    }

    public final void setENABLEUNITNAME(boolean bValue) {
        this.setParamValue(TAG_ENABLEUNITNAME, bValue ? 1 : 0);
    }

    public final boolean isPSDEFINPUTTIPIDNull() {
        return this.isParamNull(TAG_PSDEFINPUTTIPID);
    }

    public final String getPSDEFINPUTTIPID() {
        return this.getParamStringValue(TAG_PSDEFINPUTTIPID, "");
    }

    public final void setPSDEFINPUTTIPID(String strValue) {
        this.setParamValue(TAG_PSDEFINPUTTIPID, strValue);
    }

    public final boolean isPSDEFINPUTTIPNAMENull() {
        return this.isParamNull(TAG_PSDEFINPUTTIPNAME);
    }

    public final String getPSDEFINPUTTIPNAME() {
        return this.getParamStringValue(TAG_PSDEFINPUTTIPNAME, "");
    }

    public final void setPSDEFINPUTTIPNAME(String strValue) {
        this.setParamValue(TAG_PSDEFINPUTTIPNAME, strValue);
    }

    public final boolean isENABLEINPUTTIPNull() {
        return this.isParamNull(TAG_ENABLEINPUTTIP);
    }

    public final boolean getENABLEINPUTTIP() {
        return this.getParamIntValue(TAG_ENABLEINPUTTIP, 0) == 1;
    }

    public final void setENABLEINPUTTIP(boolean bValue) {
        this.setParamValue(TAG_ENABLEINPUTTIP, bValue ? 1 : 0);
    }

    public final boolean isCAPPSLANRESIDNull() {
        return this.isParamNull(TAG_CAPPSLANRESID);
    }

    public final String getCAPPSLANRESID() {
        return this.getParamStringValue(TAG_CAPPSLANRESID, "");
    }

    public final void setCAPPSLANRESID(String strValue) {
        this.setParamValue(TAG_CAPPSLANRESID, strValue);
    }

    public final boolean isCAPPSLANRESNAMENull() {
        return this.isParamNull(TAG_CAPPSLANRESNAME);
    }

    public final String getCAPPSLANRESNAME() {
        return this.getParamStringValue(TAG_CAPPSLANRESNAME, "");
    }

    public final void setCAPPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_CAPPSLANRESNAME, strValue);
    }

    public final boolean isPSSYSUNITIDNull() {
        return this.isParamNull(TAG_PSSYSUNITID);
    }

    public final String getPSSYSUNITID() {
        return this.getParamStringValue(TAG_PSSYSUNITID, "");
    }

    public final void setPSSYSUNITID(String strValue) {
        this.setParamValue(TAG_PSSYSUNITID, strValue);
    }

    public final boolean isPSSYSUNITNAMENull() {
        return this.isParamNull(TAG_PSSYSUNITNAME);
    }

    public final String getPSSYSUNITNAME() {
        return this.getParamStringValue(TAG_PSSYSUNITNAME, "");
    }

    public final void setPSSYSUNITNAME(String strValue) {
        this.setParamValue(TAG_PSSYSUNITNAME, strValue);
    }

    public final boolean isPHPSLANRESIDNull() {
        return this.isParamNull(TAG_PHPSLANRESID);
    }

    public final String getPHPSLANRESID() {
        return this.getParamStringValue(TAG_PHPSLANRESID, "");
    }

    public final void setPHPSLANRESID(String strValue) {
        this.setParamValue(TAG_PHPSLANRESID, strValue);
    }

    public final boolean isPHPSLANRESNAMENull() {
        return this.isParamNull(TAG_PHPSLANRESNAME);
    }

    public final String getPHPSLANRESNAME() {
        return this.getParamStringValue(TAG_PHPSLANRESNAME, "");
    }

    public final void setPHPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_PHPSLANRESNAME, strValue);
    }

    public final boolean isCONVERTCITEXTNull() {
        return this.isParamNull(TAG_CONVERTCITEXT);
    }

    public final boolean getCONVERTCITEXT() {
        return this.getParamIntValue(TAG_CONVERTCITEXT, 0) == 1;
    }

    public final void setCONVERTCITEXT(boolean bValue) {
        this.setParamValue(TAG_CONVERTCITEXT, bValue ? 1 : 0);
    }

    public final boolean isGRIDCOLCLMODENull() {
        return this.isParamNull(TAG_GRIDCOLCLMODE);
    }

    public final String getGRIDCOLCLMODE() {
        return this.getParamStringValue(TAG_GRIDCOLCLMODE, "");
    }

    public final void setGRIDCOLCLMODE(String strValue) {
        this.setParamValue(TAG_GRIDCOLCLMODE, strValue);
    }

    public final boolean isREFADPSDELOGICIDNull() {
        return this.isParamNull(TAG_REFADPSDELOGICID);
    }

    public final String getREFADPSDELOGICID() {
        return this.getParamStringValue(TAG_REFADPSDELOGICID, "");
    }

    public final void setREFADPSDELOGICID(String strValue) {
        this.setParamValue(TAG_REFADPSDELOGICID, strValue);
    }

    public final boolean isREFADPSDELOGICNAMENull() {
        return this.isParamNull(TAG_REFADPSDELOGICNAME);
    }

    public final String getREFADPSDELOGICNAME() {
        return this.getParamStringValue(TAG_REFADPSDELOGICNAME, "");
    }

    public final void setREFADPSDELOGICNAME(String strValue) {
        this.setParamValue(TAG_REFADPSDELOGICNAME, strValue);
    }
}

