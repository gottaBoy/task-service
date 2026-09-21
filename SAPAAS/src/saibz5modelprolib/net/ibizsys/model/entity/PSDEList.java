/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEList
extends BaseDataEntity {
    public static final String MOBLISTSTYLE_ICONVIEW = "ICONVIEW";
    public static final String MOBLISTSTYLE_LISTVIEW = "LISTVIEW";
    public static final String MOBLISTSTYLE_SWIPERVIEW = "SWIPERVIEW";
    public static final String TAG_PSDELISTID = "PSDELISTID";
    public static final String TAG_PSDELISTNAME = "PSDELISTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_SHOWHEADER = "SHOWHEADER";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PAGESIZE = "PAGESIZE";
    public static final String TAG_MINORSORTPSDEFID = "MINORSORTPSDEFID";
    public static final String TAG_MINORSORTPSDEFNAME = "MINORSORTPSDEFNAME";
    public static final String TAG_MINORSORTDIR = "MINORSORTDIR";
    public static final String TAG_NOSORT = "NOSORT";
    public static final String TAG_APPENDDEITEMS = "APPENDDEITEMS";
    public static final String TAG_MOBLISTSTYLE = "MOBLISTSTYLE";
    public static final String TAG_EMPTYTEXT = "EMPTYTEXT";
    public static final String TAG_EMPTYTEXTPSLANRESID = "EMPTYTEXTPSLANRESID";
    public static final String TAG_EMPTYTEXTPSLANRESNAME = "EMPTYTEXTPSLANRESNAME";
    public static final String TAG_PSACHANDLERID = "PSACHANDLERID";
    public static final String TAG_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String TAG_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String TAG_ADPSDELOGICNAME = "ADPSDELOGICNAME";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";

    public final boolean isPSDELISTIDNull() {
        return this.isParamNull(TAG_PSDELISTID);
    }

    public final String getPSDELISTID() {
        return this.getParamStringValue(TAG_PSDELISTID, "");
    }

    public final void setPSDELISTID(String strValue) {
        this.setParamValue(TAG_PSDELISTID, strValue);
    }

    public final boolean isPSDELISTNAMENull() {
        return this.isParamNull(TAG_PSDELISTNAME);
    }

    public final String getPSDELISTNAME() {
        return this.getParamStringValue(TAG_PSDELISTNAME, "");
    }

    public final void setPSDELISTNAME(String strValue) {
        this.setParamValue(TAG_PSDELISTNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isSHOWHEADERNull() {
        return this.isParamNull(TAG_SHOWHEADER);
    }

    public final boolean getSHOWHEADER() {
        return this.getParamIntValue(TAG_SHOWHEADER, 0) == 1;
    }

    public final void setSHOWHEADER(boolean bValue) {
        this.setParamValue(TAG_SHOWHEADER, bValue ? 1 : 0);
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

    public final boolean isPAGESIZENull() {
        return this.isParamNull(TAG_PAGESIZE);
    }

    public final int getPAGESIZE() {
        return this.getParamIntValue(TAG_PAGESIZE, 0);
    }

    public final void setPAGESIZE(int nValue) {
        this.setParamValue(TAG_PAGESIZE, nValue);
    }

    public final boolean isMINORSORTPSDEFIDNull() {
        return this.isParamNull(TAG_MINORSORTPSDEFID);
    }

    public final String getMINORSORTPSDEFID() {
        return this.getParamStringValue(TAG_MINORSORTPSDEFID, "");
    }

    public final void setMINORSORTPSDEFID(String strValue) {
        this.setParamValue(TAG_MINORSORTPSDEFID, strValue);
    }

    public final boolean isMINORSORTPSDEFNAMENull() {
        return this.isParamNull(TAG_MINORSORTPSDEFNAME);
    }

    public final String getMINORSORTPSDEFNAME() {
        return this.getParamStringValue(TAG_MINORSORTPSDEFNAME, "");
    }

    public final void setMINORSORTPSDEFNAME(String strValue) {
        this.setParamValue(TAG_MINORSORTPSDEFNAME, strValue);
    }

    public final boolean isMINORSORTDIRNull() {
        return this.isParamNull(TAG_MINORSORTDIR);
    }

    public final String getMINORSORTDIR() {
        return this.getParamStringValue(TAG_MINORSORTDIR, "");
    }

    public final void setMINORSORTDIR(String strValue) {
        this.setParamValue(TAG_MINORSORTDIR, strValue);
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

    public final boolean isAPPENDDEITEMSNull() {
        return this.isParamNull(TAG_APPENDDEITEMS);
    }

    public final boolean getAPPENDDEITEMS() {
        return this.getParamIntValue(TAG_APPENDDEITEMS, 0) == 1;
    }

    public final void setAPPENDDEITEMS(boolean bValue) {
        this.setParamValue(TAG_APPENDDEITEMS, bValue ? 1 : 0);
    }

    public final boolean isMOBLISTSTYLENull() {
        return this.isParamNull(TAG_MOBLISTSTYLE);
    }

    public final String getMOBLISTSTYLE() {
        return this.getParamStringValue(TAG_MOBLISTSTYLE, "");
    }

    public final void setMOBLISTSTYLE(String strValue) {
        this.setParamValue(TAG_MOBLISTSTYLE, strValue);
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

    public final boolean isPSSYSVIEWPANELIDNull() {
        return this.isParamNull(TAG_PSSYSVIEWPANELID);
    }

    public final String getPSSYSVIEWPANELID() {
        return this.getParamStringValue(TAG_PSSYSVIEWPANELID, "");
    }

    public final void setPSSYSVIEWPANELID(String strValue) {
        this.setParamValue(TAG_PSSYSVIEWPANELID, strValue);
    }

    public final boolean isPSSYSVIEWPANELNAMENull() {
        return this.isParamNull(TAG_PSSYSVIEWPANELNAME);
    }

    public final String getPSSYSVIEWPANELNAME() {
        return this.getParamStringValue(TAG_PSSYSVIEWPANELNAME, "");
    }

    public final void setPSSYSVIEWPANELNAME(String strValue) {
        this.setParamValue(TAG_PSSYSVIEWPANELNAME, strValue);
    }
}

