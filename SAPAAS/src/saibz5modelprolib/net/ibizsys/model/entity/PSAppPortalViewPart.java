/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSAppPortalViewPart
extends BaseDataEntity {
    public static final String PVPARTTYPE_SYSPORTLET = "SYSPORTLET";
    public static final String PVPARTTYPE_APPMENU = "APPMENU";
    public static final String PORTLETTYPE_CHART = "CHART";
    public static final String PORTLETTYPE_LIST = "LIST";
    public static final String PORTLETTYPE_CUSTOM = "CUSTOM";
    public static final String PORTLETTYPE_VIEW = "VIEW";
    public static final String PORTLETTYPE_HTML = "HTML";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSAPPPVPARTID = "PSAPPPVPARTID";
    public static final String TAG_PSAPPPVPARTNAME = "PSAPPPVPARTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSAPPPORTALVIEWID = "PSAPPPORTALVIEWID";
    public static final String TAG_PSAPPPORTALVIEWNAME = "PSAPPPORTALVIEWNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_COLID = "COLID";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSPORTLETID = "PSSYSPORTLETID";
    public static final String TAG_PSSYSPORTLETNAME = "PSSYSPORTLETNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_PORTLETTYPE = "PORTLETTYPE";
    public static final String TAG_COLSPAN = "COLSPAN";
    public static final String TAG_COL_LG = "COL_LG";
    public static final String TAG_COL_LG_OS = "COL_LG_OS";
    public static final String TAG_COL_MD = "COL_MD";
    public static final String TAG_COL_MD_OS = "COL_MD_OS";
    public static final String TAG_COL_SM = "COL_SM";
    public static final String TAG_COL_SM_OS = "COL_SM_OS";
    public static final String TAG_COL_XS = "COL_XS";
    public static final String TAG_COL_XS_OS = "COL_XS_OS";
    public static final String TAG_NEWROWMODE = "NEWROWMODE";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_PSAPPMENUID = "PSAPPMENUID";
    public static final String TAG_PSAPPMENUNAME = "PSAPPMENUNAME";
    public static final String TAG_PVPARTTYPE = "PVPARTTYPE";
    public static final String TAG_AMPSSYSPFPLUGINID = "AMPSSYSPFPLUGINID";
    public static final String TAG_AMPSSYSPFPLUGINNAME = "AMPSSYSPFPLUGINNAME";
    public static final String TAG_MOBAMTYLE = "MOBAMTYLE";
    public static final String TAG_TITLE = "TITLE";
    public static final String TAG_SHOWTITLEBAR = "SHOWTITLEBAR";
    public static final String TAG_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String TAG_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String TAG_TITLEPSLANRESID = "TITLEPSLANRESID";
    public static final String TAG_TITLEPSLANRESNAME = "TITLEPSLANRESNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";

    public final boolean isPSAPPPVPARTIDNull() {
        return this.isParamNull(TAG_PSAPPPVPARTID);
    }

    public final String getPSAPPPVPARTID() {
        return this.getParamStringValue(TAG_PSAPPPVPARTID, "");
    }

    public final void setPSAPPPVPARTID(String strValue) {
        this.setParamValue(TAG_PSAPPPVPARTID, strValue);
    }

    public final boolean isPSAPPPVPARTNAMENull() {
        return this.isParamNull(TAG_PSAPPPVPARTNAME);
    }

    public final String getPSAPPPVPARTNAME() {
        return this.getParamStringValue(TAG_PSAPPPVPARTNAME, "");
    }

    public final void setPSAPPPVPARTNAME(String strValue) {
        this.setParamValue(TAG_PSAPPPVPARTNAME, strValue);
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

    public final boolean isPSAPPPORTALVIEWIDNull() {
        return this.isParamNull(TAG_PSAPPPORTALVIEWID);
    }

    public final String getPSAPPPORTALVIEWID() {
        return this.getParamStringValue(TAG_PSAPPPORTALVIEWID, "");
    }

    public final void setPSAPPPORTALVIEWID(String strValue) {
        this.setParamValue(TAG_PSAPPPORTALVIEWID, strValue);
    }

    public final boolean isPSAPPPORTALVIEWNAMENull() {
        return this.isParamNull(TAG_PSAPPPORTALVIEWNAME);
    }

    public final String getPSAPPPORTALVIEWNAME() {
        return this.getParamStringValue(TAG_PSAPPPORTALVIEWNAME, "");
    }

    public final void setPSAPPPORTALVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSAPPPORTALVIEWNAME, strValue);
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

    public final boolean isCOLIDNull() {
        return this.isParamNull(TAG_COLID);
    }

    public final int getCOLID() {
        return this.getParamIntValue(TAG_COLID, 0);
    }

    public final void setCOLID(int nValue) {
        this.setParamValue(TAG_COLID, nValue);
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

    public final boolean isPSSYSPORTLETIDNull() {
        return this.isParamNull(TAG_PSSYSPORTLETID);
    }

    public final String getPSSYSPORTLETID() {
        return this.getParamStringValue(TAG_PSSYSPORTLETID, "");
    }

    public final void setPSSYSPORTLETID(String strValue) {
        this.setParamValue(TAG_PSSYSPORTLETID, strValue);
    }

    public final boolean isPSSYSPORTLETNAMENull() {
        return this.isParamNull(TAG_PSSYSPORTLETNAME);
    }

    public final String getPSSYSPORTLETNAME() {
        return this.getParamStringValue(TAG_PSSYSPORTLETNAME, "");
    }

    public final void setPSSYSPORTLETNAME(String strValue) {
        this.setParamValue(TAG_PSSYSPORTLETNAME, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.isParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.getParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.setParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isPORTLETTYPENull() {
        return this.isParamNull(TAG_PORTLETTYPE);
    }

    public final String getPORTLETTYPE() {
        return this.getParamStringValue(TAG_PORTLETTYPE, "");
    }

    public final void setPORTLETTYPE(String strValue) {
        this.setParamValue(TAG_PORTLETTYPE, strValue);
    }

    public final boolean isCOLSPANNull() {
        return this.isParamNull(TAG_COLSPAN);
    }

    public final int getCOLSPAN() {
        return this.getParamIntValue(TAG_COLSPAN, 0);
    }

    public final void setCOLSPAN(int nValue) {
        this.setParamValue(TAG_COLSPAN, nValue);
    }

    public final boolean isCOL_LGNull() {
        return this.isParamNull(TAG_COL_LG);
    }

    public final int getCOL_LG() {
        return this.getParamIntValue(TAG_COL_LG, 0);
    }

    public final void setCOL_LG(int nValue) {
        this.setParamValue(TAG_COL_LG, nValue);
    }

    public final boolean isCOL_LG_OSNull() {
        return this.isParamNull(TAG_COL_LG_OS);
    }

    public final int getCOL_LG_OS() {
        return this.getParamIntValue(TAG_COL_LG_OS, 0);
    }

    public final void setCOL_LG_OS(int nValue) {
        this.setParamValue(TAG_COL_LG_OS, nValue);
    }

    public final boolean isCOL_MDNull() {
        return this.isParamNull(TAG_COL_MD);
    }

    public final int getCOL_MD() {
        return this.getParamIntValue(TAG_COL_MD, 0);
    }

    public final void setCOL_MD(int nValue) {
        this.setParamValue(TAG_COL_MD, nValue);
    }

    public final boolean isCOL_MD_OSNull() {
        return this.isParamNull(TAG_COL_MD_OS);
    }

    public final int getCOL_MD_OS() {
        return this.getParamIntValue(TAG_COL_MD_OS, 0);
    }

    public final void setCOL_MD_OS(int nValue) {
        this.setParamValue(TAG_COL_MD_OS, nValue);
    }

    public final boolean isCOL_SMNull() {
        return this.isParamNull(TAG_COL_SM);
    }

    public final int getCOL_SM() {
        return this.getParamIntValue(TAG_COL_SM, 0);
    }

    public final void setCOL_SM(int nValue) {
        this.setParamValue(TAG_COL_SM, nValue);
    }

    public final boolean isCOL_SM_OSNull() {
        return this.isParamNull(TAG_COL_SM_OS);
    }

    public final int getCOL_SM_OS() {
        return this.getParamIntValue(TAG_COL_SM_OS, 0);
    }

    public final void setCOL_SM_OS(int nValue) {
        this.setParamValue(TAG_COL_SM_OS, nValue);
    }

    public final boolean isCOL_XSNull() {
        return this.isParamNull(TAG_COL_XS);
    }

    public final int getCOL_XS() {
        return this.getParamIntValue(TAG_COL_XS, 0);
    }

    public final void setCOL_XS(int nValue) {
        this.setParamValue(TAG_COL_XS, nValue);
    }

    public final boolean isCOL_XS_OSNull() {
        return this.isParamNull(TAG_COL_XS_OS);
    }

    public final int getCOL_XS_OS() {
        return this.getParamIntValue(TAG_COL_XS_OS, 0);
    }

    public final void setCOL_XS_OS(int nValue) {
        this.setParamValue(TAG_COL_XS_OS, nValue);
    }

    public final boolean isNEWROWMODENull() {
        return this.isParamNull(TAG_NEWROWMODE);
    }

    public final boolean getNEWROWMODE() {
        return this.getParamIntValue(TAG_NEWROWMODE, 0) == 1;
    }

    public final void setNEWROWMODE(boolean bValue) {
        this.setParamValue(TAG_NEWROWMODE, bValue ? 1 : 0);
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

    public final boolean isPSAPPMENUIDNull() {
        return this.isParamNull(TAG_PSAPPMENUID);
    }

    public final String getPSAPPMENUID() {
        return this.getParamStringValue(TAG_PSAPPMENUID, "");
    }

    public final void setPSAPPMENUID(String strValue) {
        this.setParamValue(TAG_PSAPPMENUID, strValue);
    }

    public final boolean isPSAPPMENUNAMENull() {
        return this.isParamNull(TAG_PSAPPMENUNAME);
    }

    public final String getPSAPPMENUNAME() {
        return this.getParamStringValue(TAG_PSAPPMENUNAME, "");
    }

    public final void setPSAPPMENUNAME(String strValue) {
        this.setParamValue(TAG_PSAPPMENUNAME, strValue);
    }

    public final boolean isPVPARTTYPENull() {
        return this.isParamNull(TAG_PVPARTTYPE);
    }

    public final String getPVPARTTYPE() {
        return this.getParamStringValue(TAG_PVPARTTYPE, "");
    }

    public final void setPVPARTTYPE(String strValue) {
        this.setParamValue(TAG_PVPARTTYPE, strValue);
    }

    public final boolean isAMPSSYSPFPLUGINIDNull() {
        return this.isParamNull(TAG_AMPSSYSPFPLUGINID);
    }

    public final String getAMPSSYSPFPLUGINID() {
        return this.getParamStringValue(TAG_AMPSSYSPFPLUGINID, "");
    }

    public final void setAMPSSYSPFPLUGINID(String strValue) {
        this.setParamValue(TAG_AMPSSYSPFPLUGINID, strValue);
    }

    public final boolean isAMPSSYSPFPLUGINNAMENull() {
        return this.isParamNull(TAG_AMPSSYSPFPLUGINNAME);
    }

    public final String getAMPSSYSPFPLUGINNAME() {
        return this.getParamStringValue(TAG_AMPSSYSPFPLUGINNAME, "");
    }

    public final void setAMPSSYSPFPLUGINNAME(String strValue) {
        this.setParamValue(TAG_AMPSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isMOBAMTYLENull() {
        return this.isParamNull(TAG_MOBAMTYLE);
    }

    public final String getMOBAMTYLE() {
        return this.getParamStringValue(TAG_MOBAMTYLE, "");
    }

    public final void setMOBAMTYLE(String strValue) {
        this.setParamValue(TAG_MOBAMTYLE, strValue);
    }

    public final boolean isTITLENull() {
        return this.isParamNull(TAG_TITLE);
    }

    public final String getTITLE() {
        return this.getParamStringValue(TAG_TITLE, "");
    }

    public final void setTITLE(String strValue) {
        this.setParamValue(TAG_TITLE, strValue);
    }

    public final boolean isSHOWTITLEBARNull() {
        return this.isParamNull(TAG_SHOWTITLEBAR);
    }

    public final boolean getSHOWTITLEBAR() {
        return this.getParamIntValue(TAG_SHOWTITLEBAR, 0) == 1;
    }

    public final void setSHOWTITLEBAR(boolean bValue) {
        this.setParamValue(TAG_SHOWTITLEBAR, bValue ? 1 : 0);
    }

    public final boolean isPSAPPVIEWIDNull() {
        return this.isParamNull(TAG_PSAPPVIEWID);
    }

    public final String getPSAPPVIEWID() {
        return this.getParamStringValue(TAG_PSAPPVIEWID, "");
    }

    public final void setPSAPPVIEWID(String strValue) {
        this.setParamValue(TAG_PSAPPVIEWID, strValue);
    }

    public final boolean isPSAPPVIEWNAMENull() {
        return this.isParamNull(TAG_PSAPPVIEWNAME);
    }

    public final String getPSAPPVIEWNAME() {
        return this.getParamStringValue(TAG_PSAPPVIEWNAME, "");
    }

    public final void setPSAPPVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSAPPVIEWNAME, strValue);
    }

    public final boolean isTITLEPSLANRESIDNull() {
        return this.isParamNull(TAG_TITLEPSLANRESID);
    }

    public final String getTITLEPSLANRESID() {
        return this.getParamStringValue(TAG_TITLEPSLANRESID, "");
    }

    public final void setTITLEPSLANRESID(String strValue) {
        this.setParamValue(TAG_TITLEPSLANRESID, strValue);
    }

    public final boolean isTITLEPSLANRESNAMENull() {
        return this.isParamNull(TAG_TITLEPSLANRESNAME);
    }

    public final String getTITLEPSLANRESNAME() {
        return this.getParamStringValue(TAG_TITLEPSLANRESNAME, "");
    }

    public final void setTITLEPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_TITLEPSLANRESNAME, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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
}

