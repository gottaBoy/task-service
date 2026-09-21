/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEReport
extends BaseDataEntity {
    public static final String REPORTTYPE_JR = "JR";
    public static final String TAG_PSDEREPORTID = "PSDEREPORTID";
    public static final String TAG_PSDEREPORTNAME = "PSDEREPORTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MULTIPAGE = "MULTIPAGE";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_REPORTMODEL = "REPORTMODEL";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_REPORTTYPE = "REPORTTYPE";
    public static final String TAG_REPORTFILE = "REPORTFILE";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String TAG_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String TAG_ENABLELOG = "ENABLELOG";
    public static final String TAG_PSDEDSID2 = "PSDEDSID2";
    public static final String TAG_PSDEDSNAME2 = "PSDEDSNAME2";
    public static final String TAG_PSDEDSID3 = "PSDEDSID3";
    public static final String TAG_PSDEDSNAME3 = "PSDEDSNAME3";
    public static final String TAG_PSDEDSID4 = "PSDEDSID4";
    public static final String TAG_PSDEDSNAME4 = "PSDEDSNAME4";
    public static final String TAG_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String TAG_ADPSDELOGICNAME = "ADPSDELOGICNAME";
    public static final String TAG_EXTENDMODE = "EXTENDMODE";

    public final boolean isPSDEREPORTIDNull() {
        return this.isParamNull(TAG_PSDEREPORTID);
    }

    public final String getPSDEREPORTID() {
        return this.getParamStringValue(TAG_PSDEREPORTID, "");
    }

    public final void setPSDEREPORTID(String strValue) {
        this.setParamValue(TAG_PSDEREPORTID, strValue);
    }

    public final boolean isPSDEREPORTNAMENull() {
        return this.isParamNull(TAG_PSDEREPORTNAME);
    }

    public final String getPSDEREPORTNAME() {
        return this.getParamStringValue(TAG_PSDEREPORTNAME, "");
    }

    public final void setPSDEREPORTNAME(String strValue) {
        this.setParamValue(TAG_PSDEREPORTNAME, strValue);
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

    public final boolean isMULTIPAGENull() {
        return this.isParamNull(TAG_MULTIPAGE);
    }

    public final boolean getMULTIPAGE() {
        return this.getParamIntValue(TAG_MULTIPAGE, 0) == 1;
    }

    public final void setMULTIPAGE(boolean bValue) {
        this.setParamValue(TAG_MULTIPAGE, bValue ? 1 : 0);
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

    public final boolean isREPORTMODELNull() {
        return this.isParamNull(TAG_REPORTMODEL);
    }

    public final String getREPORTMODEL() {
        return this.getParamStringValue(TAG_REPORTMODEL, "");
    }

    public final void setREPORTMODEL(String strValue) {
        this.setParamValue(TAG_REPORTMODEL, strValue);
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

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
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

    public final boolean isLOGICNAMENull() {
        return this.isParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.getParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.setParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isPSSYSUNIRESIDNull() {
        return this.isParamNull(TAG_PSSYSUNIRESID);
    }

    public final String getPSSYSUNIRESID() {
        return this.getParamStringValue(TAG_PSSYSUNIRESID, "");
    }

    public final void setPSSYSUNIRESID(String strValue) {
        this.setParamValue(TAG_PSSYSUNIRESID, strValue);
    }

    public final boolean isPSSYSUNIRESNAMENull() {
        return this.isParamNull(TAG_PSSYSUNIRESNAME);
    }

    public final String getPSSYSUNIRESNAME() {
        return this.getParamStringValue(TAG_PSSYSUNIRESNAME, "");
    }

    public final void setPSSYSUNIRESNAME(String strValue) {
        this.setParamValue(TAG_PSSYSUNIRESNAME, strValue);
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

    public final boolean isPSDEDSID2Null() {
        return this.isParamNull(TAG_PSDEDSID2);
    }

    public final String getPSDEDSID2() {
        return this.getParamStringValue(TAG_PSDEDSID2, "");
    }

    public final void setPSDEDSID2(String strValue) {
        this.setParamValue(TAG_PSDEDSID2, strValue);
    }

    public final boolean isPSDEDSNAME2Null() {
        return this.isParamNull(TAG_PSDEDSNAME2);
    }

    public final String getPSDEDSNAME2() {
        return this.getParamStringValue(TAG_PSDEDSNAME2, "");
    }

    public final void setPSDEDSNAME2(String strValue) {
        this.setParamValue(TAG_PSDEDSNAME2, strValue);
    }

    public final boolean isPSDEDSID3Null() {
        return this.isParamNull(TAG_PSDEDSID3);
    }

    public final String getPSDEDSID3() {
        return this.getParamStringValue(TAG_PSDEDSID3, "");
    }

    public final void setPSDEDSID3(String strValue) {
        this.setParamValue(TAG_PSDEDSID3, strValue);
    }

    public final boolean isPSDEDSNAME3Null() {
        return this.isParamNull(TAG_PSDEDSNAME3);
    }

    public final String getPSDEDSNAME3() {
        return this.getParamStringValue(TAG_PSDEDSNAME3, "");
    }

    public final void setPSDEDSNAME3(String strValue) {
        this.setParamValue(TAG_PSDEDSNAME3, strValue);
    }

    public final boolean isPSDEDSID4Null() {
        return this.isParamNull(TAG_PSDEDSID4);
    }

    public final String getPSDEDSID4() {
        return this.getParamStringValue(TAG_PSDEDSID4, "");
    }

    public final void setPSDEDSID4(String strValue) {
        this.setParamValue(TAG_PSDEDSID4, strValue);
    }

    public final boolean isPSDEDSNAME4Null() {
        return this.isParamNull(TAG_PSDEDSNAME4);
    }

    public final String getPSDEDSNAME4() {
        return this.getParamStringValue(TAG_PSDEDSNAME4, "");
    }

    public final void setPSDEDSNAME4(String strValue) {
        this.setParamValue(TAG_PSDEDSNAME4, strValue);
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
}

