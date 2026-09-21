/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEPrint
extends BaseDataEntity {
    public static final String REPORTTYPE_JR = "JR";
    public static final String TAG_PSDEPRINTID = "PSDEPRINTID";
    public static final String TAG_PSDEPRINTNAME = "PSDEPRINTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_ENABLECOLPRIV = "ENABLECOLPRIV";
    public static final String TAG_ENABLELOG = "ENABLELOG";
    public static final String TAG_ENABLEMP = "ENABLEMP";
    public static final String TAG_GETDATAPSDEACTIONID = "GETDATAPSDEACTIONID";
    public static final String TAG_GETDATAPSDEACTIONNAME = "GETDATAPSDEACTIONNAME";
    public static final String TAG_PSDEDATASETID = "PSDEDATASETID";
    public static final String TAG_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String TAG_REPORTTYPE = "REPORTTYPE";
    public static final String TAG_REPORTFILE = "REPORTFILE";
    public static final String TAG_DEFAULTMODE = "DEFAULTMODE";
    public static final String TAG_REFPSDEID = "REFPSDEID";
    public static final String TAG_REFPSDENAME = "REFPSDENAME";
    public static final String TAG_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String TAG_ADPSDELOGICNAME = "ADPSDELOGICNAME";
    public static final String TAG_EXTENDMODE = "EXTENDMODE";
    public static final String TAG_READPSDEOPPRIVID = "READPSDEOPPRIVID";
    public static final String TAG_READPSDEOPPRIVNAME = "READPSDEOPPRIVNAME";

    public final boolean isPSDEPRINTIDNull() {
        return this.isParamNull(TAG_PSDEPRINTID);
    }

    public final String getPSDEPRINTID() {
        return this.getParamStringValue(TAG_PSDEPRINTID, "");
    }

    public final void setPSDEPRINTID(String strValue) {
        this.setParamValue(TAG_PSDEPRINTID, strValue);
    }

    public final boolean isPSDEPRINTNAMENull() {
        return this.isParamNull(TAG_PSDEPRINTNAME);
    }

    public final String getPSDEPRINTNAME() {
        return this.getParamStringValue(TAG_PSDEPRINTNAME, "");
    }

    public final void setPSDEPRINTNAME(String strValue) {
        this.setParamValue(TAG_PSDEPRINTNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
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

    public final boolean isENABLECOLPRIVNull() {
        return this.isParamNull(TAG_ENABLECOLPRIV);
    }

    public final boolean getENABLECOLPRIV() {
        return this.getParamIntValue(TAG_ENABLECOLPRIV, 0) == 1;
    }

    public final void setENABLECOLPRIV(boolean bValue) {
        this.setParamValue(TAG_ENABLECOLPRIV, bValue ? 1 : 0);
    }

    public final boolean isENABLELOGNull() {
        return this.isParamNull(TAG_ENABLELOG);
    }

    public final boolean getENABLELOG() {
        return this.getParamIntValue(TAG_ENABLELOG, 0) == 1;
    }

    public final void setENABLELOG(boolean bValue) {
        this.setParamValue(TAG_ENABLELOG, bValue ? 1 : 0);
    }

    public final boolean isENABLEMPNull() {
        return this.isParamNull(TAG_ENABLEMP);
    }

    public final boolean getENABLEMP() {
        return this.getParamIntValue(TAG_ENABLEMP, 0) == 1;
    }

    public final void setENABLEMP(boolean bValue) {
        this.setParamValue(TAG_ENABLEMP, bValue ? 1 : 0);
    }

    public final boolean isGETDATAPSDEACTIONIDNull() {
        return this.isParamNull(TAG_GETDATAPSDEACTIONID);
    }

    public final String getGETDATAPSDEACTIONID() {
        return this.getParamStringValue(TAG_GETDATAPSDEACTIONID, "");
    }

    public final void setGETDATAPSDEACTIONID(String strValue) {
        this.setParamValue(TAG_GETDATAPSDEACTIONID, strValue);
    }

    public final boolean isGETDATAPSDEACTIONNAMENull() {
        return this.isParamNull(TAG_GETDATAPSDEACTIONNAME);
    }

    public final String getGETDATAPSDEACTIONNAME() {
        return this.getParamStringValue(TAG_GETDATAPSDEACTIONNAME, "");
    }

    public final void setGETDATAPSDEACTIONNAME(String strValue) {
        this.setParamValue(TAG_GETDATAPSDEACTIONNAME, strValue);
    }

    public final boolean isPSDEDATASETIDNull() {
        return this.isParamNull(TAG_PSDEDATASETID);
    }

    public final String getPSDEDATASETID() {
        return this.getParamStringValue(TAG_PSDEDATASETID, "");
    }

    public final void setPSDEDATASETID(String strValue) {
        this.setParamValue(TAG_PSDEDATASETID, strValue);
    }

    public final boolean isPSDEDATASETNAMENull() {
        return this.isParamNull(TAG_PSDEDATASETNAME);
    }

    public final String getPSDEDATASETNAME() {
        return this.getParamStringValue(TAG_PSDEDATASETNAME, "");
    }

    public final void setPSDEDATASETNAME(String strValue) {
        this.setParamValue(TAG_PSDEDATASETNAME, strValue);
    }

    public final boolean isREPORTTYPENull() {
        return this.isParamNull(TAG_REPORTTYPE);
    }

    public final String getREPORTTYPE() {
        return this.getParamStringValue(TAG_REPORTTYPE, "");
    }

    public final void setREPORTTYPE(String strValue) {
        this.setParamValue(TAG_REPORTTYPE, strValue);
    }

    public final boolean isREPORTFILENull() {
        return this.isParamNull(TAG_REPORTFILE);
    }

    public final String getREPORTFILE() {
        return this.getParamStringValue(TAG_REPORTFILE, "");
    }

    public final void setREPORTFILE(String strValue) {
        this.setParamValue(TAG_REPORTFILE, strValue);
    }

    public final boolean isDEFAULTMODENull() {
        return this.isParamNull(TAG_DEFAULTMODE);
    }

    public final boolean getDEFAULTMODE() {
        return this.getParamIntValue(TAG_DEFAULTMODE, 0) == 1;
    }

    public final void setDEFAULTMODE(boolean bValue) {
        this.setParamValue(TAG_DEFAULTMODE, bValue ? 1 : 0);
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

    public final boolean isEXTENDMODENull() {
        return this.isParamNull(TAG_EXTENDMODE);
    }

    public final int getEXTENDMODE() {
        return this.getParamIntValue(TAG_EXTENDMODE, 0);
    }

    public final void setEXTENDMODE(int nValue) {
        this.setParamValue(TAG_EXTENDMODE, nValue);
    }

    public final boolean isREADPSDEOPPRIVIDNull() {
        return this.isParamNull(TAG_READPSDEOPPRIVID);
    }

    public final String getREADPSDEOPPRIVID() {
        return this.getParamStringValue(TAG_READPSDEOPPRIVID, "");
    }

    public final void setREADPSDEOPPRIVID(String strValue) {
        this.setParamValue(TAG_READPSDEOPPRIVID, strValue);
    }

    public final boolean isREADPSDEOPPRIVNAMENull() {
        return this.isParamNull(TAG_READPSDEOPPRIVNAME);
    }

    public final String getREADPSDEOPPRIVNAME() {
        return this.getParamStringValue(TAG_READPSDEOPPRIVNAME, "");
    }

    public final void setREADPSDEOPPRIVNAME(String strValue) {
        this.setParamValue(TAG_READPSDEOPPRIVNAME, strValue);
    }
}

