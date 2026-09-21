/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEDRItem
extends BaseDataEntity {
    public static final String DRITEMTYPE_DER1N = "DER1N";
    public static final String DRITEMTYPE_SYSDER1N = "SYSDER1N";
    public static final String DRITEMTYPE_DER11 = "DER11";
    public static final String DRITEMTYPE_SYSDER11 = "SYSDER11";
    public static final String ENABLEMODE_ALL = "ALL";
    public static final String ENABLEMODE_INWF = "INWF";
    public static final String ENABLEMODE_ALLWF = "ALLWF";
    public static final String ENABLEMODE_CUSTOM = "CUSTOM";
    public static final String ENABLEMODE_DEOPPRIV = "DEOPPRIV";
    public static final String TAG_PSDEDRITEMID = "PSDEDRITEMID";
    public static final String TAG_PSDEDRITEMNAME = "PSDEDRITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DRITEMTYPE = "DRITEMTYPE";
    public static final String TAG_PSDEDRID = "PSDEDRID";
    public static final String TAG_PSDEDRNAME = "PSDEDRNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDEDRGROUPID = "PSDEDRGROUPID";
    public static final String TAG_PSDEDRGROUPNAME = "PSDEDRGROUPNAME";
    public static final String TAG_PSDERID = "PSDERID";
    public static final String TAG_PSDERNAME = "PSDERNAME";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String TAG_VIEWPSDEID = "VIEWPSDEID";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_TESTPSDEACTIONID = "TESTPSDEACTIONID";
    public static final String TAG_TESTPSDEACTIONNAME = "TESTPSDEACTIONNAME";
    public static final String TAG_COUNTERID = "COUNTERID";
    public static final String TAG_COUNTERMODE = "COUNTERMODE";
    public static final String TAG_ENABLEMODE = "ENABLEMODE";
    public static final String TAG_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String TAG_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String TAG_VIEWPARAMS = "VIEWPARAMS";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";

    public final boolean isPSDEDRITEMIDNull() {
        return this.isParamNull(TAG_PSDEDRITEMID);
    }

    public final String getPSDEDRITEMID() {
        return this.getParamStringValue(TAG_PSDEDRITEMID, "");
    }

    public final void setPSDEDRITEMID(String strValue) {
        this.setParamValue(TAG_PSDEDRITEMID, strValue);
    }

    public final boolean isPSDEDRITEMNAMENull() {
        return this.isParamNull(TAG_PSDEDRITEMNAME);
    }

    public final String getPSDEDRITEMNAME() {
        return this.getParamStringValue(TAG_PSDEDRITEMNAME, "");
    }

    public final void setPSDEDRITEMNAME(String strValue) {
        this.setParamValue(TAG_PSDEDRITEMNAME, strValue);
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

    public final boolean isDRITEMTYPENull() {
        return this.isParamNull(TAG_DRITEMTYPE);
    }

    public final String getDRITEMTYPE() {
        return this.getParamStringValue(TAG_DRITEMTYPE, "");
    }

    public final void setDRITEMTYPE(String strValue) {
        this.setParamValue(TAG_DRITEMTYPE, strValue);
    }

    public final boolean isPSDEDRIDNull() {
        return this.isParamNull(TAG_PSDEDRID);
    }

    public final String getPSDEDRID() {
        return this.getParamStringValue(TAG_PSDEDRID, "");
    }

    public final void setPSDEDRID(String strValue) {
        this.setParamValue(TAG_PSDEDRID, strValue);
    }

    public final boolean isPSDEDRNAMENull() {
        return this.isParamNull(TAG_PSDEDRNAME);
    }

    public final String getPSDEDRNAME() {
        return this.getParamStringValue(TAG_PSDEDRNAME, "");
    }

    public final void setPSDEDRNAME(String strValue) {
        this.setParamValue(TAG_PSDEDRNAME, strValue);
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

    public final boolean isPSDEDRGROUPIDNull() {
        return this.isParamNull(TAG_PSDEDRGROUPID);
    }

    public final String getPSDEDRGROUPID() {
        return this.getParamStringValue(TAG_PSDEDRGROUPID, "");
    }

    public final void setPSDEDRGROUPID(String strValue) {
        this.setParamValue(TAG_PSDEDRGROUPID, strValue);
    }

    public final boolean isPSDEDRGROUPNAMENull() {
        return this.isParamNull(TAG_PSDEDRGROUPNAME);
    }

    public final String getPSDEDRGROUPNAME() {
        return this.getParamStringValue(TAG_PSDEDRGROUPNAME, "");
    }

    public final void setPSDEDRGROUPNAME(String strValue) {
        this.setParamValue(TAG_PSDEDRGROUPNAME, strValue);
    }

    public final boolean isPSDERIDNull() {
        return this.isParamNull(TAG_PSDERID);
    }

    public final String getPSDERID() {
        return this.getParamStringValue(TAG_PSDERID, "");
    }

    public final void setPSDERID(String strValue) {
        this.setParamValue(TAG_PSDERID, strValue);
    }

    public final boolean isPSDERNAMENull() {
        return this.isParamNull(TAG_PSDERNAME);
    }

    public final String getPSDERNAME() {
        return this.getParamStringValue(TAG_PSDERNAME, "");
    }

    public final void setPSDERNAME(String strValue) {
        this.setParamValue(TAG_PSDERNAME, strValue);
    }

    public final boolean isPSDEVIEWBASEIDNull() {
        return this.isParamNull(TAG_PSDEVIEWBASEID);
    }

    public final String getPSDEVIEWBASEID() {
        return this.getParamStringValue(TAG_PSDEVIEWBASEID, "");
    }

    public final void setPSDEVIEWBASEID(String strValue) {
        this.setParamValue(TAG_PSDEVIEWBASEID, strValue);
    }

    public final boolean isPSDEVIEWBASENAMENull() {
        return this.isParamNull(TAG_PSDEVIEWBASENAME);
    }

    public final String getPSDEVIEWBASENAME() {
        return this.getParamStringValue(TAG_PSDEVIEWBASENAME, "");
    }

    public final void setPSDEVIEWBASENAME(String strValue) {
        this.setParamValue(TAG_PSDEVIEWBASENAME, strValue);
    }

    public final boolean isVIEWPSDEIDNull() {
        return this.isParamNull(TAG_VIEWPSDEID);
    }

    public final String getVIEWPSDEID() {
        return this.getParamStringValue(TAG_VIEWPSDEID, "");
    }

    public final void setVIEWPSDEID(String strValue) {
        this.setParamValue(TAG_VIEWPSDEID, strValue);
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

    public final boolean isTESTPSDEACTIONIDNull() {
        return this.isParamNull(TAG_TESTPSDEACTIONID);
    }

    public final String getTESTPSDEACTIONID() {
        return this.getParamStringValue(TAG_TESTPSDEACTIONID, "");
    }

    public final void setTESTPSDEACTIONID(String strValue) {
        this.setParamValue(TAG_TESTPSDEACTIONID, strValue);
    }

    public final boolean isTESTPSDEACTIONNAMENull() {
        return this.isParamNull(TAG_TESTPSDEACTIONNAME);
    }

    public final String getTESTPSDEACTIONNAME() {
        return this.getParamStringValue(TAG_TESTPSDEACTIONNAME, "");
    }

    public final void setTESTPSDEACTIONNAME(String strValue) {
        this.setParamValue(TAG_TESTPSDEACTIONNAME, strValue);
    }

    public final boolean isCOUNTERIDNull() {
        return this.isParamNull(TAG_COUNTERID);
    }

    public final String getCOUNTERID() {
        return this.getParamStringValue(TAG_COUNTERID, "");
    }

    public final void setCOUNTERID(String strValue) {
        this.setParamValue(TAG_COUNTERID, strValue);
    }

    public final boolean isCOUNTERMODENull() {
        return this.isParamNull(TAG_COUNTERMODE);
    }

    public final int getCOUNTERMODE() {
        return this.getParamIntValue(TAG_COUNTERMODE, 0);
    }

    public final void setCOUNTERMODE(int nValue) {
        this.setParamValue(TAG_COUNTERMODE, nValue);
    }

    public final boolean isENABLEMODENull() {
        return this.isParamNull(TAG_ENABLEMODE);
    }

    public final String getENABLEMODE() {
        return this.getParamStringValue(TAG_ENABLEMODE, "");
    }

    public final void setENABLEMODE(String strValue) {
        this.setParamValue(TAG_ENABLEMODE, strValue);
    }

    public final boolean isPSDEOPPRIVIDNull() {
        return this.isParamNull(TAG_PSDEOPPRIVID);
    }

    public final String getPSDEOPPRIVID() {
        return this.getParamStringValue(TAG_PSDEOPPRIVID, "");
    }

    public final void setPSDEOPPRIVID(String strValue) {
        this.setParamValue(TAG_PSDEOPPRIVID, strValue);
    }

    public final boolean isPSDEOPPRIVNAMENull() {
        return this.isParamNull(TAG_PSDEOPPRIVNAME);
    }

    public final String getPSDEOPPRIVNAME() {
        return this.getParamStringValue(TAG_PSDEOPPRIVNAME, "");
    }

    public final void setPSDEOPPRIVNAME(String strValue) {
        this.setParamValue(TAG_PSDEOPPRIVNAME, strValue);
    }

    public final boolean isVIEWPARAMSNull() {
        return this.isParamNull(TAG_VIEWPARAMS);
    }

    public final String getVIEWPARAMS() {
        return this.getParamStringValue(TAG_VIEWPARAMS, "");
    }

    public final void setVIEWPARAMS(String strValue) {
        this.setParamValue(TAG_VIEWPARAMS, strValue);
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
}

