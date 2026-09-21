/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEListItem
extends BaseDataEntity {
    public static final String WIDTHUNIT_PX = "PX";
    public static final String WIDTHUNIT_STAR = "STAR";
    public static final String CLCONVERTMODE_NONE = "NONE";
    public static final String CLCONVERTMODE_FRONT = "FRONT";
    public static final String CLCONVERTMODE_BACKEND = "BACKEND";
    public static final String ITEMTYPE_TEXTITEM = "TEXTITEM";
    public static final String ITEMTYPE_ACTIONITEM = "ACTIONITEM";
    public static final String ITEMTYPE_DATAITEM = "DATAITEM";
    public static final String ALIGN_LEFT = "LEFT";
    public static final String ALIGN_CENTER = "CENTER";
    public static final String ALIGN_RIGHT = "RIGHT";
    public static final String TAG_CLCONVERTMODE = "CLCONVERTMODE";
    public static final String TAG_PSDELISTITEMID = "PSDELISTITEMID";
    public static final String TAG_PSDELISTITEMNAME = "PSDELISTITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDELISTID = "PSDELISTID";
    public static final String TAG_PSDELISTNAME = "PSDELISTNAME";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_WIDTHUNIT = "WIDTHUNIT";
    public static final String TAG_ITEMTYPE = "ITEMTYPE";
    public static final String TAG_NOSORT = "NOSORT";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_LCRPSSYSPFPLUGINID = "LCRPSSYSPFPLUGINID";
    public static final String TAG_LCRPSSYSPFPLUGINNAME = "LCRPSSYSPFPLUGINNAME";
    public static final String TAG_VALUEFORMAT = "VALUEFORMAT";
    public static final String TAG_ALIGN = "ALIGN";
    public static final String TAG_DATAITEMS = "DATAITEMS";
    public static final String TAG_PSDEDATAVIEWID = "PSDEDATAVIEWID";
    public static final String TAG_PSDEDATAVIEWNAME = "PSDEDATAVIEWNAME";
    public static final String TAG_ENABLEITEMPRIV = "ENABLEITEMPRIV";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";

    public final boolean isPSDELISTITEMIDNull() {
        return this.isParamNull(TAG_PSDELISTITEMID);
    }

    public final String getPSDELISTITEMID() {
        return this.getParamStringValue(TAG_PSDELISTITEMID, "");
    }

    public final void setPSDELISTITEMID(String strValue) {
        this.setParamValue(TAG_PSDELISTITEMID, strValue);
    }

    public final boolean isPSDELISTITEMNAMENull() {
        return this.isParamNull(TAG_PSDELISTITEMNAME);
    }

    public final String getPSDELISTITEMNAME() {
        return this.getParamStringValue(TAG_PSDELISTITEMNAME, "");
    }

    public final void setPSDELISTITEMNAME(String strValue) {
        this.setParamValue(TAG_PSDELISTITEMNAME, strValue);
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

    public final boolean isCAPTIONNull() {
        return this.isParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.getParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.setParamValue(TAG_CAPTION, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.isParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.getParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.setParamValue(TAG_ORDERVALUE, nValue);
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

    public final boolean isWIDTHUNITNull() {
        return this.isParamNull(TAG_WIDTHUNIT);
    }

    public final String getWIDTHUNIT() {
        return this.getParamStringValue(TAG_WIDTHUNIT, "");
    }

    public final void setWIDTHUNIT(String strValue) {
        this.setParamValue(TAG_WIDTHUNIT, strValue);
    }

    public final boolean isITEMTYPENull() {
        return this.isParamNull(TAG_ITEMTYPE);
    }

    public final String getITEMTYPE() {
        return this.getParamStringValue(TAG_ITEMTYPE, "");
    }

    public final void setITEMTYPE(String strValue) {
        this.setParamValue(TAG_ITEMTYPE, strValue);
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

    public final boolean isLCRPSSYSPFPLUGINIDNull() {
        return this.isParamNull(TAG_LCRPSSYSPFPLUGINID);
    }

    public final String getLCRPSSYSPFPLUGINID() {
        return this.getParamStringValue(TAG_LCRPSSYSPFPLUGINID, "");
    }

    public final void setLCRPSSYSPFPLUGINID(String strValue) {
        this.setParamValue(TAG_LCRPSSYSPFPLUGINID, strValue);
    }

    public final boolean isLCRPSSYSPFPLUGINNAMENull() {
        return this.isParamNull(TAG_LCRPSSYSPFPLUGINNAME);
    }

    public final String getLCRPSSYSPFPLUGINNAME() {
        return this.getParamStringValue(TAG_LCRPSSYSPFPLUGINNAME, "");
    }

    public final void setLCRPSSYSPFPLUGINNAME(String strValue) {
        this.setParamValue(TAG_LCRPSSYSPFPLUGINNAME, strValue);
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

    public final boolean isALIGNNull() {
        return this.isParamNull(TAG_ALIGN);
    }

    public final String getALIGN() {
        return this.getParamStringValue(TAG_ALIGN, "");
    }

    public final void setALIGN(String strValue) {
        this.setParamValue(TAG_ALIGN, strValue);
    }

    public final boolean isDATAITEMSNull() {
        return this.isParamNull(TAG_DATAITEMS);
    }

    public final String getDATAITEMS() {
        return this.getParamStringValue(TAG_DATAITEMS, "");
    }

    public final void setDATAITEMS(String strValue) {
        this.setParamValue(TAG_DATAITEMS, strValue);
    }

    public final boolean isPSDEDATAVIEWIDNull() {
        return this.isParamNull(TAG_PSDEDATAVIEWID);
    }

    public final String getPSDEDATAVIEWID() {
        return this.getParamStringValue(TAG_PSDEDATAVIEWID, "");
    }

    public final void setPSDEDATAVIEWID(String strValue) {
        this.setParamValue(TAG_PSDEDATAVIEWID, strValue);
    }

    public final boolean isPSDEDATAVIEWNAMENull() {
        return this.isParamNull(TAG_PSDEDATAVIEWNAME);
    }

    public final String getPSDEDATAVIEWNAME() {
        return this.getParamStringValue(TAG_PSDEDATAVIEWNAME, "");
    }

    public final void setPSDEDATAVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSDEDATAVIEWNAME, strValue);
    }

    public final boolean isCLCONVERTMODENull() {
        return this.isParamNull(TAG_CLCONVERTMODE);
    }

    public final String getCLCONVERTMODE() {
        return this.getParamStringValue(TAG_CLCONVERTMODE, "");
    }

    public final void setCLCONVERTMODE(String strValue) {
        this.setParamValue(TAG_CLCONVERTMODE, strValue);
    }

    public final boolean isENABLEITEMPRIVNull() {
        return this.isParamNull(TAG_ENABLEITEMPRIV);
    }

    public final boolean getENABLEITEMPRIV() {
        return this.getParamIntValue(TAG_ENABLEITEMPRIV, 0) == 1;
    }

    public final void setENABLEITEMPRIV(boolean bValue) {
        this.setParamValue(TAG_ENABLEITEMPRIV, bValue ? 1 : 0);
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

