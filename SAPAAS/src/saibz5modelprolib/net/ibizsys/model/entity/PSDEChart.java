/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEChart
extends BaseDataEntity {
    public static final String TITLEPOS_TOP = "TOP";
    public static final String TITLEPOS_BOTTOM = "BOTTOM";
    public static final String TITLEPOS_LEFT = "LEFT";
    public static final String TITLEPOS_RIGHT = "RIGHT";
    public static final String LEGENDPOS_TOP = "TOP";
    public static final String LEGENDPOS_BOTTOM = "BOTTOM";
    public static final String LEGENDPOS_LEFT = "LEFT";
    public static final String LEGENDPOS_RIGHT = "RIGHT";
    public static final String COORDINATESYSTEM_XY = "XY";
    public static final String COORDINATESYSTEM_POLAR = "POLAR";
    public static final String COORDINATESYSTEM_RADAR = "RADAR";
    public static final String COORDINATESYSTEM_PARALLEL = "PARALLEL";
    public static final String COORDINATESYSTEM_SINGLE = "SINGLE";
    public static final String COORDINATESYSTEM_CALENDAR = "CALENDAR";
    public static final String COORDINATESYSTEM_MAP = "MAP";
    public static final String COORDINATESYSTEM_NONE = "NONE";
    public static final String TAG_PSDECHARTID = "PSDECHARTID";
    public static final String TAG_PSDECHARTNAME = "PSDECHARTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_SUBTITLE = "SUBTITLE";
    public static final String TAG_SHOWTITLE = "SHOWTITLE";
    public static final String TAG_CHARTTHEME = "CHARTTHEME";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_LNPSLANRESID = "LNPSLANRESID";
    public static final String TAG_LNPSLANRESNAME = "LNPSLANRESNAME";
    public static final String TAG_SUBTITLEPSLANRESID = "SUBTITLEPSLANRESID";
    public static final String TAG_SUBTITLEPSLANRESNAME = "SUBTITLEPSLANRESNAME";
    public static final String TAG_EMPTYTEXT = "EMPTYTEXT";
    public static final String TAG_EMPTYTEXTPSLANRESID = "EMPTYTEXTPSLANRESID";
    public static final String TAG_EMPTYTEXTPSLANRESNAME = "EMPTYTEXTPSLANRESNAME";
    public static final String TAG_TITLEPOS = "TITLEPOS";
    public static final String TAG_LEGENDPOS = "LEGENDPOS";
    public static final String TAG_SHOWLEGEND = "SHOWLEGEND";
    public static final String TAG_COORDINATESYSTEM = "COORDINATESYSTEM";
    public static final String TAG_PSACHANDLERID = "PSACHANDLERID";
    public static final String TAG_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String TAG_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String TAG_ADPSDELOGICNAME = "ADPSDELOGICNAME";

    public final boolean isPSDECHARTIDNull() {
        return this.isParamNull(TAG_PSDECHARTID);
    }

    public final String getPSDECHARTID() {
        return this.getParamStringValue(TAG_PSDECHARTID, "");
    }

    public final void setPSDECHARTID(String strValue) {
        this.setParamValue(TAG_PSDECHARTID, strValue);
    }

    public final boolean isPSDECHARTNAMENull() {
        return this.isParamNull(TAG_PSDECHARTNAME);
    }

    public final String getPSDECHARTNAME() {
        return this.getParamStringValue(TAG_PSDECHARTNAME, "");
    }

    public final void setPSDECHARTNAME(String strValue) {
        this.setParamValue(TAG_PSDECHARTNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
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

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isPSDEDSIDNull() {
        return this.isParamNull(TAG_PSDEDSID);
    }

    public final String getPSDEDSID() {
        return this.getParamStringValue(TAG_PSDEDSID, "");
    }

    public final void setPSDEDSID(String strValue) {
        this.setParamValue(TAG_PSDEDSID, strValue);
    }

    public final boolean isPSDEDSNAMENull() {
        return this.isParamNull(TAG_PSDEDSNAME);
    }

    public final String getPSDEDSNAME() {
        return this.getParamStringValue(TAG_PSDEDSNAME, "");
    }

    public final void setPSDEDSNAME(String strValue) {
        this.setParamValue(TAG_PSDEDSNAME, strValue);
    }

    public final boolean isSUBTITLENull() {
        return this.isParamNull(TAG_SUBTITLE);
    }

    public final String getSUBTITLE() {
        return this.getParamStringValue(TAG_SUBTITLE, "");
    }

    public final void setSUBTITLE(String strValue) {
        this.setParamValue(TAG_SUBTITLE, strValue);
    }

    public final boolean isSHOWTITLENull() {
        return this.isParamNull(TAG_SHOWTITLE);
    }

    public final boolean getSHOWTITLE() {
        return this.getParamIntValue(TAG_SHOWTITLE, 0) == 1;
    }

    public final void setSHOWTITLE(boolean bValue) {
        this.setParamValue(TAG_SHOWTITLE, bValue ? 1 : 0);
    }

    public final boolean isCHARTTHEMENull() {
        return this.isParamNull(TAG_CHARTTHEME);
    }

    public final String getCHARTTHEME() {
        return this.getParamStringValue(TAG_CHARTTHEME, "");
    }

    public final void setCHARTTHEME(String strValue) {
        this.setParamValue(TAG_CHARTTHEME, strValue);
    }

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.isParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.getParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.setParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.isParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.getParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.setParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isLNPSLANRESIDNull() {
        return this.isParamNull(TAG_LNPSLANRESID);
    }

    public final String getLNPSLANRESID() {
        return this.getParamStringValue(TAG_LNPSLANRESID, "");
    }

    public final void setLNPSLANRESID(String strValue) {
        this.setParamValue(TAG_LNPSLANRESID, strValue);
    }

    public final boolean isLNPSLANRESNAMENull() {
        return this.isParamNull(TAG_LNPSLANRESNAME);
    }

    public final String getLNPSLANRESNAME() {
        return this.getParamStringValue(TAG_LNPSLANRESNAME, "");
    }

    public final void setLNPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_LNPSLANRESNAME, strValue);
    }

    public final boolean isSUBTITLEPSLANRESIDNull() {
        return this.isParamNull(TAG_SUBTITLEPSLANRESID);
    }

    public final String getSUBTITLEPSLANRESID() {
        return this.getParamStringValue(TAG_SUBTITLEPSLANRESID, "");
    }

    public final void setSUBTITLEPSLANRESID(String strValue) {
        this.setParamValue(TAG_SUBTITLEPSLANRESID, strValue);
    }

    public final boolean isSUBTITLEPSLANRESNAMENull() {
        return this.isParamNull(TAG_SUBTITLEPSLANRESNAME);
    }

    public final String getSUBTITLEPSLANRESNAME() {
        return this.getParamStringValue(TAG_SUBTITLEPSLANRESNAME, "");
    }

    public final void setSUBTITLEPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_SUBTITLEPSLANRESNAME, strValue);
    }

    public final boolean isEMPTYTEXTNull() {
        return this.isParamNull(TAG_EMPTYTEXT);
    }

    public final String getEMPTYTEXT() {
        return this.getParamStringValue(TAG_EMPTYTEXT, "");
    }

    public final void setEMPTYTEXT(String strValue) {
        this.setParamValue(TAG_EMPTYTEXT, strValue);
    }

    public final boolean isEMPTYTEXTPSLANRESIDNull() {
        return this.isParamNull(TAG_EMPTYTEXTPSLANRESID);
    }

    public final String getEMPTYTEXTPSLANRESID() {
        return this.getParamStringValue(TAG_EMPTYTEXTPSLANRESID, "");
    }

    public final void setEMPTYTEXTPSLANRESID(String strValue) {
        this.setParamValue(TAG_EMPTYTEXTPSLANRESID, strValue);
    }

    public final boolean isEMPTYTEXTPSLANRESNAMENull() {
        return this.isParamNull(TAG_EMPTYTEXTPSLANRESNAME);
    }

    public final String getEMPTYTEXTPSLANRESNAME() {
        return this.getParamStringValue(TAG_EMPTYTEXTPSLANRESNAME, "");
    }

    public final void setEMPTYTEXTPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_EMPTYTEXTPSLANRESNAME, strValue);
    }

    public final boolean isTITLEPOSNull() {
        return this.isParamNull(TAG_TITLEPOS);
    }

    public final String getTITLEPOS() {
        return this.getParamStringValue(TAG_TITLEPOS, "");
    }

    public final void setTITLEPOS(String strValue) {
        this.setParamValue(TAG_TITLEPOS, strValue);
    }

    public final boolean isLEGENDPOSNull() {
        return this.isParamNull(TAG_LEGENDPOS);
    }

    public final String getLEGENDPOS() {
        return this.getParamStringValue(TAG_LEGENDPOS, "");
    }

    public final void setLEGENDPOS(String strValue) {
        this.setParamValue(TAG_LEGENDPOS, strValue);
    }

    public final boolean isSHOWLEGENDNull() {
        return this.isParamNull(TAG_SHOWLEGEND);
    }

    public final boolean getSHOWLEGEND() {
        return this.getParamIntValue(TAG_SHOWLEGEND, 0) == 1;
    }

    public final void setSHOWLEGEND(boolean bValue) {
        this.setParamValue(TAG_SHOWLEGEND, bValue ? 1 : 0);
    }

    public final boolean isCOORDINATESYSTEMNull() {
        return this.isParamNull(TAG_COORDINATESYSTEM);
    }

    public final String getCOORDINATESYSTEM() {
        return this.getParamStringValue(TAG_COORDINATESYSTEM, "");
    }

    public final void setCOORDINATESYSTEM(String strValue) {
        this.setParamValue(TAG_COORDINATESYSTEM, strValue);
    }

    public final boolean isPSACHANDLERIDNull() {
        return this.isParamNull(TAG_PSACHANDLERID);
    }

    public final String getPSACHANDLERID() {
        return this.getParamStringValue(TAG_PSACHANDLERID, "");
    }

    public final void setPSACHANDLERID(String strValue) {
        this.setParamValue(TAG_PSACHANDLERID, strValue);
    }

    public final boolean isPSACHANDLERNAMENull() {
        return this.isParamNull(TAG_PSACHANDLERNAME);
    }

    public final String getPSACHANDLERNAME() {
        return this.getParamStringValue(TAG_PSACHANDLERNAME, "");
    }

    public final void setPSACHANDLERNAME(String strValue) {
        this.setParamValue(TAG_PSACHANDLERNAME, strValue);
    }

    public final boolean isADPSDELOGICIDNull() {
        return this.isParamNull(TAG_ADPSDELOGICID);
    }

    public final String getADPSDELOGICID() {
        return this.getParamStringValue(TAG_ADPSDELOGICID, "");
    }

    public final void setADPSDELOGICID(String strValue) {
        this.setParamValue(TAG_ADPSDELOGICID, strValue);
    }

    public final boolean isADPSDELOGICNAMENull() {
        return this.isParamNull(TAG_ADPSDELOGICNAME);
    }

    public final String getADPSDELOGICNAME() {
        return this.getParamStringValue(TAG_ADPSDELOGICNAME, "");
    }

    public final void setADPSDELOGICNAME(String strValue) {
        this.setParamValue(TAG_ADPSDELOGICNAME, strValue);
    }
}

