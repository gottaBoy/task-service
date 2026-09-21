/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

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
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_REFPSDERID = "REFPSDERID";
    public static final String TAG_REFPSDERNAME = "REFPSDERNAME";
    public static final String TAG_SEARCHMODE = "SEARCHMODE";
    public static final String TAG_REFMOBMPICKUPPSDEVIEWID = "REFMOBMPICKUPPSDEVIEWID";
    public static final String TAG_REFMOBMPICKUPPSDEVIEWNAME = "REFMOBMPICKUPPSDEVIEWNAME";
    public static final String TAG_REFMOBPICKUPPSDEVIEWID = "REFMOBPICKUPPSDEVIEWID";
    public static final String TAG_REFMOBPICKUPPSDEVIEWNAME = "REFMOBPICKUPPSDEVIEWNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_JSONFORMAT = "JSONFORMAT";
    public static final String TAG_ITEMTAG = "ITEMTAG";
    public static final String TAG_ITEMTAG2 = "ITEMTAG2";
    public static final String TAG_ARRAYFLAG = "ARRAYFLAG";
    public static final String TAG_VALUESEPERATOR = "VALUESEPERATOR";
    public static final String TAG_DSTPSDEFSFITEMID = "DSTPSDEFSFITEMID";
    public static final String TAG_DSTPSDEFSFITEMNAME = "DSTPSDEFSFITEMNAME";
    public static final String TAG_DSTPSDEFID = "DSTPSDEFID";
    public static final String TAG_DSTPSDEID = "DSTPSDEID";
    public static final String TAG_SERVICECODENAME = "SERVICECODENAME";
    public static final String TAG_PSSYSTRANSLATORID = "PSSYSTRANSLATORID";
    public static final String TAG_PSSYSTRANSLATORNAME = "PSSYSTRANSLATORNAME";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";

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

    public final boolean isPSSYSDBVFIDNull() {
        return this.IsParamNull(TAG_PSSYSDBVFID);
    }

    public final String getPSSYSDBVFID() {
        return this.GetParamStringValue(TAG_PSSYSDBVFID, "");
    }

    public final void setPSSYSDBVFID(String strValue) {
        this.SetParamValue(TAG_PSSYSDBVFID, strValue);
    }

    public final boolean isPSSYSDBVFNAMENull() {
        return this.IsParamNull(TAG_PSSYSDBVFNAME);
    }

    public final String getPSSYSDBVFNAME() {
        return this.GetParamStringValue(TAG_PSSYSDBVFNAME, "");
    }

    public final void setPSSYSDBVFNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDBVFNAME, strValue);
    }

    public final boolean isPSDBVALUEOPIDNull() {
        return this.IsParamNull(TAG_PSDBVALUEOPID);
    }

    public final String getPSDBVALUEOPID() {
        return this.GetParamStringValue(TAG_PSDBVALUEOPID, "");
    }

    public final void setPSDBVALUEOPID(String strValue) {
        this.SetParamValue(TAG_PSDBVALUEOPID, strValue);
    }

    public final boolean isPSDBVALUEOPNAMENull() {
        return this.IsParamNull(TAG_PSDBVALUEOPNAME);
    }

    public final String getPSDBVALUEOPNAME() {
        return this.GetParamStringValue(TAG_PSDBVALUEOPNAME, "");
    }

    public final void setPSDBVALUEOPNAME(String strValue) {
        this.SetParamValue(TAG_PSDBVALUEOPNAME, strValue);
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

    public final boolean isHEIGHTNull() {
        return this.IsParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
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

    public final boolean isVALUEFORMATNull() {
        return this.IsParamNull(TAG_VALUEFORMAT);
    }

    public final String getVALUEFORMAT() {
        return this.GetParamStringValue(TAG_VALUEFORMAT, "");
    }

    public final void setVALUEFORMAT(String strValue) {
        this.SetParamValue(TAG_VALUEFORMAT, strValue);
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

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
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

    public final boolean isPLACEHOLDERNull() {
        return this.IsParamNull(TAG_PLACEHOLDER);
    }

    public final String getPLACEHOLDER() {
        return this.GetParamStringValue(TAG_PLACEHOLDER, "");
    }

    public final void setPLACEHOLDER(String strValue) {
        this.SetParamValue(TAG_PLACEHOLDER, strValue);
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

    public final boolean isEXTENDMODENull() {
        return this.IsParamNull(TAG_EXTENDMODE);
    }

    public final int getEXTENDMODE() {
        return this.GetParamIntValue(TAG_EXTENDMODE, 0);
    }

    public final void setEXTENDMODE(int nValue) {
        this.SetParamValue(TAG_EXTENDMODE, nValue);
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

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
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

    public final boolean isSEARCHMODENull() {
        return this.IsParamNull(TAG_SEARCHMODE);
    }

    public final String getSEARCHMODE() {
        return this.GetParamStringValue(TAG_SEARCHMODE, "");
    }

    public final void setSEARCHMODE(String strValue) {
        this.SetParamValue(TAG_SEARCHMODE, strValue);
    }

    public final boolean isREFMOBMPICKUPPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_REFMOBMPICKUPPSDEVIEWID);
    }

    public final String getREFMOBMPICKUPPSDEVIEWID() {
        return this.GetParamStringValue(TAG_REFMOBMPICKUPPSDEVIEWID, "");
    }

    public final void setREFMOBMPICKUPPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_REFMOBMPICKUPPSDEVIEWID, strValue);
    }

    public final boolean isREFMOBMPICKUPPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_REFMOBMPICKUPPSDEVIEWNAME);
    }

    public final String getREFMOBMPICKUPPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_REFMOBMPICKUPPSDEVIEWNAME, "");
    }

    public final void setREFMOBMPICKUPPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_REFMOBMPICKUPPSDEVIEWNAME, strValue);
    }

    public final boolean isREFMOBPICKUPPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_REFMOBPICKUPPSDEVIEWID);
    }

    public final String getREFMOBPICKUPPSDEVIEWID() {
        return this.GetParamStringValue(TAG_REFMOBPICKUPPSDEVIEWID, "");
    }

    public final void setREFMOBPICKUPPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_REFMOBPICKUPPSDEVIEWID, strValue);
    }

    public final boolean isREFMOBPICKUPPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_REFMOBPICKUPPSDEVIEWNAME);
    }

    public final String getREFMOBPICKUPPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_REFMOBPICKUPPSDEVIEWNAME, "");
    }

    public final void setREFMOBPICKUPPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_REFMOBPICKUPPSDEVIEWNAME, strValue);
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

    public final boolean isJSONFORMATNull() {
        return this.IsParamNull(TAG_JSONFORMAT);
    }

    public final String getJSONFORMAT() {
        return this.GetParamStringValue(TAG_JSONFORMAT, "");
    }

    public final void setJSONFORMAT(String strValue) {
        this.SetParamValue(TAG_JSONFORMAT, strValue);
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

    public final boolean isARRAYFLAGNull() {
        return this.IsParamNull(TAG_ARRAYFLAG);
    }

    public final boolean getARRAYFLAG() {
        return this.GetParamIntValue(TAG_ARRAYFLAG, 0) == 1;
    }

    public final void setARRAYFLAG(boolean bValue) {
        this.SetParamValue(TAG_ARRAYFLAG, bValue ? 1 : 0);
    }

    public final boolean isVALUESEPERATORNull() {
        return this.IsParamNull(TAG_VALUESEPERATOR);
    }

    public final String getVALUESEPERATOR() {
        return this.GetParamStringValue(TAG_VALUESEPERATOR, "");
    }

    public final void setVALUESEPERATOR(String strValue) {
        this.SetParamValue(TAG_VALUESEPERATOR, strValue);
    }

    public final boolean isDSTPSDEFSFITEMIDNull() {
        return this.IsParamNull(TAG_DSTPSDEFSFITEMID);
    }

    public final String getDSTPSDEFSFITEMID() {
        return this.GetParamStringValue(TAG_DSTPSDEFSFITEMID, "");
    }

    public final void setDSTPSDEFSFITEMID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEFSFITEMID, strValue);
    }

    public final boolean isDSTPSDEFSFITEMNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEFSFITEMNAME);
    }

    public final String getDSTPSDEFSFITEMNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEFSFITEMNAME, "");
    }

    public final void setDSTPSDEFSFITEMNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEFSFITEMNAME, strValue);
    }

    public final boolean isDSTPSDEFIDNull() {
        return this.IsParamNull(TAG_DSTPSDEFID);
    }

    public final String getDSTPSDEFID() {
        return this.GetParamStringValue(TAG_DSTPSDEFID, "");
    }

    public final void setDSTPSDEFID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEFID, strValue);
    }

    public final boolean isDSTPSDEIDNull() {
        return this.IsParamNull(TAG_DSTPSDEID);
    }

    public final String getDSTPSDEID() {
        return this.GetParamStringValue(TAG_DSTPSDEID, "");
    }

    public final void setDSTPSDEID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEID, strValue);
    }

    public final boolean isSERVICECODENAMENull() {
        return this.IsParamNull(TAG_SERVICECODENAME);
    }

    public final String getSERVICECODENAME() {
        return this.GetParamStringValue(TAG_SERVICECODENAME, "");
    }

    public final void setSERVICECODENAME(String strValue) {
        this.SetParamValue(TAG_SERVICECODENAME, strValue);
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

    public final boolean isPSSYSSFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINID);
    }

    public final String getPSSYSSFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINID, "");
    }

    public final void setPSSYSSFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINID, strValue);
    }

    public final boolean isPSSYSSFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINNAME);
    }

    public final String getPSSYSSFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINNAME, "");
    }

    public final void setPSSYSSFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINNAME, strValue);
    }
}

