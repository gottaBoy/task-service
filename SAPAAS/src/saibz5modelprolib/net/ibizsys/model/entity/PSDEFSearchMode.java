/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEFSearchMode
extends BaseDataEntity {
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
    public static final String TAG_PSDEFSFITEMID = "PSDEFSFITEMID";
    public static final String TAG_PSDEFSFITEMNAME = "PSDEFSFITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSDBVFID = "PSSYSDBVFID";
    public static final String TAG_PSSYSDBVFNAME = "PSSYSDBVFNAME";
    public static final String TAG_PSDBVALUEOPID = "PSDBVALUEOPID";
    public static final String TAG_PSDBVALUEOPNAME = "PSDBVALUEOPNAME";
    public static final String TAG_EDITORTYPE = "EDITORTYPE";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_VALUEFORMAT = "VALUEFORMAT";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String TAG_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_PLACEHOLDER = "PLACEHOLDER";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_REFPSDEACMODEID = "REFPSDEACMODEID";
    public static final String TAG_REFPSDEACMODENAME = "REFPSDEACMODENAME";
    public static final String TAG_REFPICKUPPSDEVIEWID = "REFPICKUPPSDEVIEWID";
    public static final String TAG_REFPICKUPPSDEVIEWNAME = "REFPICKUPPSDEVIEWNAME";
    public static final String TAG_REFMPICKUPPSDEVIEWID = "REFMPICKUPPSDEVIEWID";
    public static final String TAG_REFMPICKUPPSDEVIEWNAME = "REFMPICKUPPSDEVIEWNAME";
    public static final String TAG_REFPSDEDATASETID = "REFPSDEDATASETID";
    public static final String TAG_REFPSDEDATASETNAME = "REFPSDEDATASETNAME";
    public static final String TAG_REFPSDEID = "REFPSDEID";
    public static final String TAG_REFPSDENAME = "REFPSDENAME";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_PHPSLANRESID = "PHPSLANRESID";
    public static final String TAG_PHPSLANRESNAME = "PHPSLANRESNAME";
    public static final String TAG_PSSYSEDITORSTYLEID = "PSSYSEDITORSTYLEID";
    public static final String TAG_PSSYSEDITORSTYLENAME = "PSSYSEDITORSTYLENAME";
    public static final String TAG_EXTENDMODE = "EXTENDMODE";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_REFADPSDELOGICID = "REFADPSDELOGICID";
    public static final String TAG_REFADPSDELOGICNAME = "REFADPSDELOGICNAME";

    public final boolean isPSDEFSFITEMIDNull() {
        return this.isParamNull(TAG_PSDEFSFITEMID);
    }

    public final String getPSDEFSFITEMID() {
        return this.getParamStringValue(TAG_PSDEFSFITEMID, "");
    }

    public final void setPSDEFSFITEMID(String strValue) {
        this.setParamValue(TAG_PSDEFSFITEMID, strValue);
    }

    public final boolean isPSDEFSFITEMNAMENull() {
        return this.isParamNull(TAG_PSDEFSFITEMNAME);
    }

    public final String getPSDEFSFITEMNAME() {
        return this.getParamStringValue(TAG_PSDEFSFITEMNAME, "");
    }

    public final void setPSDEFSFITEMNAME(String strValue) {
        this.setParamValue(TAG_PSDEFSFITEMNAME, strValue);
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

    public final boolean isPSSYSDBVFIDNull() {
        return this.isParamNull(TAG_PSSYSDBVFID);
    }

    public final String getPSSYSDBVFID() {
        return this.getParamStringValue(TAG_PSSYSDBVFID, "");
    }

    public final void setPSSYSDBVFID(String strValue) {
        this.setParamValue(TAG_PSSYSDBVFID, strValue);
    }

    public final boolean isPSSYSDBVFNAMENull() {
        return this.isParamNull(TAG_PSSYSDBVFNAME);
    }

    public final String getPSSYSDBVFNAME() {
        return this.getParamStringValue(TAG_PSSYSDBVFNAME, "");
    }

    public final void setPSSYSDBVFNAME(String strValue) {
        this.setParamValue(TAG_PSSYSDBVFNAME, strValue);
    }

    public final boolean isPSDBVALUEOPIDNull() {
        return this.isParamNull(TAG_PSDBVALUEOPID);
    }

    public final String getPSDBVALUEOPID() {
        return this.getParamStringValue(TAG_PSDBVALUEOPID, "");
    }

    public final void setPSDBVALUEOPID(String strValue) {
        this.setParamValue(TAG_PSDBVALUEOPID, strValue);
    }

    public final boolean isPSDBVALUEOPNAMENull() {
        return this.isParamNull(TAG_PSDBVALUEOPNAME);
    }

    public final String getPSDBVALUEOPNAME() {
        return this.getParamStringValue(TAG_PSDBVALUEOPNAME, "");
    }

    public final void setPSDBVALUEOPNAME(String strValue) {
        this.setParamValue(TAG_PSDBVALUEOPNAME, strValue);
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

    public final boolean isHEIGHTNull() {
        return this.isParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.getParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.setParamValue(TAG_HEIGHT, nValue);
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

    public final boolean isVALUEFORMATNull() {
        return this.isParamNull(TAG_VALUEFORMAT);
    }

    public final String getVALUEFORMAT() {
        return this.getParamStringValue(TAG_VALUEFORMAT, "");
    }

    public final void setVALUEFORMAT(String strValue) {
        this.setParamValue(TAG_VALUEFORMAT, strValue);
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

    public final boolean isLOGICNAMENull() {
        return this.isParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.getParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.setParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isPSDENAMENull() {
        return this.isParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.getParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.setParamValue(TAG_PSDENAME, strValue);
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

    public final boolean isPLACEHOLDERNull() {
        return this.isParamNull(TAG_PLACEHOLDER);
    }

    public final String getPLACEHOLDER() {
        return this.getParamStringValue(TAG_PLACEHOLDER, "");
    }

    public final void setPLACEHOLDER(String strValue) {
        this.setParamValue(TAG_PLACEHOLDER, strValue);
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

    public final boolean isEXTENDMODENull() {
        return this.isParamNull(TAG_EXTENDMODE);
    }

    public final int getEXTENDMODE() {
        return this.getParamIntValue(TAG_EXTENDMODE, 0);
    }

    public final void setEXTENDMODE(int nValue) {
        this.setParamValue(TAG_EXTENDMODE, nValue);
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

