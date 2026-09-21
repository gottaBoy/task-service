/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEChartCS
extends BaseDataEntity {
    public static final String TAG_PSDECHARTCSID = "PSDECHARTCSID";
    public static final String TAG_PSDECHARTCSNAME = "PSDECHARTCSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDECHARTID = "PSDECHARTID";
    public static final String TAG_PSDECHARTNAME = "PSDECHARTNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CHARTTYPE = "CHARTTYPE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_XFIELD = "XFIELD";
    public static final String TAG_YFIELD = "YFIELD";
    public static final String TAG_ZFIELD = "ZFIELD";
    public static final String TAG_XPSDECHARTAXESID = "XPSDECHARTAXESID";
    public static final String TAG_XPSDECHARTAXESNAME = "XPSDECHARTAXESNAME";
    public static final String TAG_YPSDECHARTAXESID = "YPSDECHARTAXESID";
    public static final String TAG_YPSDECHARTAXESNAME = "YPSDECHARTAXESNAME";
    public static final String TAG_SERIESFIELD = "SERIESFIELD";
    public static final String TAG_TIMEGROUP = "TIMEGROUP";
    public static final String TAG_SFPSCODELISTID = "SFPSCODELISTID";
    public static final String TAG_SFPSCODELISTNAME = "SFPSCODELISTNAME";
    public static final String TAG_XFPSCODELISTID = "XFPSCODELISTID";
    public static final String TAG_XFPSCODELISTNAME = "XFPSCODELISTNAME";
    public static final String TAG_EXTFIELD = "EXTFIELD";
    public static final String TAG_EXTFIELD2 = "EXTFIELD2";
    public static final String TAG_EXTFIELD3 = "EXTFIELD3";
    public static final String TAG_EXTFIELD4 = "EXTFIELD4";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_SAMPLEDATA = "SAMPLEDATA";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_TOPPOS = "TOPPOS";
    public static final String TAG_LEFTPOS = "LEFTPOS";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_SERIESLAYOUTBY = "SERIESLAYOUTBY";
    public static final String TAG_RIGHTPOS = "RIGHTPOS";
    public static final String TAG_BOTTOMPOS = "BOTTOMPOS";
    public static final String TAG_SORTDIR = "SORTDIR";
    public static final String TAG_COORDINATESYSTEM = "COORDINATESYSTEM";
    public static final String TAG_COORDINATESYSTEMID = "COORDINATESYSTEMID";
    public static final String TAG_CSPSSYSPFPLUGINID = "CSPSSYSPFPLUGINID";
    public static final String TAG_CSPSSYSPFPLUGINNAME = "CSPSSYSPFPLUGINNAME";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_CSPSSYSDYNAMODELID = "CSPSSYSDYNAMODELID";
    public static final String TAG_CSPSSYSDYNAMODELNAME = "CSPSSYSDYNAMODELNAME";

    public final boolean isPSDECHARTCSIDNull() {
        return this.IsParamNull(TAG_PSDECHARTCSID);
    }

    public final String getPSDECHARTCSID() {
        return this.GetParamStringValue(TAG_PSDECHARTCSID, "");
    }

    public final void setPSDECHARTCSID(String strValue) {
        this.SetParamValue(TAG_PSDECHARTCSID, strValue);
    }

    public final boolean isPSDECHARTCSNAMENull() {
        return this.IsParamNull(TAG_PSDECHARTCSNAME);
    }

    public final String getPSDECHARTCSNAME() {
        return this.GetParamStringValue(TAG_PSDECHARTCSNAME, "");
    }

    public final void setPSDECHARTCSNAME(String strValue) {
        this.SetParamValue(TAG_PSDECHARTCSNAME, strValue);
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

    public final boolean isPSDECHARTIDNull() {
        return this.IsParamNull(TAG_PSDECHARTID);
    }

    public final String getPSDECHARTID() {
        return this.GetParamStringValue(TAG_PSDECHARTID, "");
    }

    public final void setPSDECHARTID(String strValue) {
        this.SetParamValue(TAG_PSDECHARTID, strValue);
    }

    public final boolean isPSDECHARTNAMENull() {
        return this.IsParamNull(TAG_PSDECHARTNAME);
    }

    public final String getPSDECHARTNAME() {
        return this.GetParamStringValue(TAG_PSDECHARTNAME, "");
    }

    public final void setPSDECHARTNAME(String strValue) {
        this.SetParamValue(TAG_PSDECHARTNAME, strValue);
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

    public final boolean isCHARTTYPENull() {
        return this.IsParamNull(TAG_CHARTTYPE);
    }

    public final String getCHARTTYPE() {
        return this.GetParamStringValue(TAG_CHARTTYPE, "");
    }

    public final void setCHARTTYPE(String strValue) {
        this.SetParamValue(TAG_CHARTTYPE, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isXFIELDNull() {
        return this.IsParamNull(TAG_XFIELD);
    }

    public final String getXFIELD() {
        return this.GetParamStringValue(TAG_XFIELD, "");
    }

    public final void setXFIELD(String strValue) {
        this.SetParamValue(TAG_XFIELD, strValue);
    }

    public final boolean isYFIELDNull() {
        return this.IsParamNull(TAG_YFIELD);
    }

    public final String getYFIELD() {
        return this.GetParamStringValue(TAG_YFIELD, "");
    }

    public final void setYFIELD(String strValue) {
        this.SetParamValue(TAG_YFIELD, strValue);
    }

    public final boolean isZFIELDNull() {
        return this.IsParamNull(TAG_ZFIELD);
    }

    public final String getZFIELD() {
        return this.GetParamStringValue(TAG_ZFIELD, "");
    }

    public final void setZFIELD(String strValue) {
        this.SetParamValue(TAG_ZFIELD, strValue);
    }

    public final boolean isXPSDECHARTAXESIDNull() {
        return this.IsParamNull(TAG_XPSDECHARTAXESID);
    }

    public final String getXPSDECHARTAXESID() {
        return this.GetParamStringValue(TAG_XPSDECHARTAXESID, "");
    }

    public final void setXPSDECHARTAXESID(String strValue) {
        this.SetParamValue(TAG_XPSDECHARTAXESID, strValue);
    }

    public final boolean isXPSDECHARTAXESNAMENull() {
        return this.IsParamNull(TAG_XPSDECHARTAXESNAME);
    }

    public final String getXPSDECHARTAXESNAME() {
        return this.GetParamStringValue(TAG_XPSDECHARTAXESNAME, "");
    }

    public final void setXPSDECHARTAXESNAME(String strValue) {
        this.SetParamValue(TAG_XPSDECHARTAXESNAME, strValue);
    }

    public final boolean isYPSDECHARTAXESIDNull() {
        return this.IsParamNull(TAG_YPSDECHARTAXESID);
    }

    public final String getYPSDECHARTAXESID() {
        return this.GetParamStringValue(TAG_YPSDECHARTAXESID, "");
    }

    public final void setYPSDECHARTAXESID(String strValue) {
        this.SetParamValue(TAG_YPSDECHARTAXESID, strValue);
    }

    public final boolean isYPSDECHARTAXESNAMENull() {
        return this.IsParamNull(TAG_YPSDECHARTAXESNAME);
    }

    public final String getYPSDECHARTAXESNAME() {
        return this.GetParamStringValue(TAG_YPSDECHARTAXESNAME, "");
    }

    public final void setYPSDECHARTAXESNAME(String strValue) {
        this.SetParamValue(TAG_YPSDECHARTAXESNAME, strValue);
    }

    public final boolean isSERIESFIELDNull() {
        return this.IsParamNull(TAG_SERIESFIELD);
    }

    public final String getSERIESFIELD() {
        return this.GetParamStringValue(TAG_SERIESFIELD, "");
    }

    public final void setSERIESFIELD(String strValue) {
        this.SetParamValue(TAG_SERIESFIELD, strValue);
    }

    public final boolean isTIMEGROUPNull() {
        return this.IsParamNull(TAG_TIMEGROUP);
    }

    public final String getTIMEGROUP() {
        return this.GetParamStringValue(TAG_TIMEGROUP, "");
    }

    public final void setTIMEGROUP(String strValue) {
        this.SetParamValue(TAG_TIMEGROUP, strValue);
    }

    public final boolean isSFPSCODELISTIDNull() {
        return this.IsParamNull(TAG_SFPSCODELISTID);
    }

    public final String getSFPSCODELISTID() {
        return this.GetParamStringValue(TAG_SFPSCODELISTID, "");
    }

    public final void setSFPSCODELISTID(String strValue) {
        this.SetParamValue(TAG_SFPSCODELISTID, strValue);
    }

    public final boolean isSFPSCODELISTNAMENull() {
        return this.IsParamNull(TAG_SFPSCODELISTNAME);
    }

    public final String getSFPSCODELISTNAME() {
        return this.GetParamStringValue(TAG_SFPSCODELISTNAME, "");
    }

    public final void setSFPSCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_SFPSCODELISTNAME, strValue);
    }

    public final boolean isXFPSCODELISTIDNull() {
        return this.IsParamNull(TAG_XFPSCODELISTID);
    }

    public final String getXFPSCODELISTID() {
        return this.GetParamStringValue(TAG_XFPSCODELISTID, "");
    }

    public final void setXFPSCODELISTID(String strValue) {
        this.SetParamValue(TAG_XFPSCODELISTID, strValue);
    }

    public final boolean isXFPSCODELISTNAMENull() {
        return this.IsParamNull(TAG_XFPSCODELISTNAME);
    }

    public final String getXFPSCODELISTNAME() {
        return this.GetParamStringValue(TAG_XFPSCODELISTNAME, "");
    }

    public final void setXFPSCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_XFPSCODELISTNAME, strValue);
    }

    public final boolean isEXTFIELDNull() {
        return this.IsParamNull(TAG_EXTFIELD);
    }

    public final String getEXTFIELD() {
        return this.GetParamStringValue(TAG_EXTFIELD, "");
    }

    public final void setEXTFIELD(String strValue) {
        this.SetParamValue(TAG_EXTFIELD, strValue);
    }

    public final boolean isEXTFIELD2Null() {
        return this.IsParamNull(TAG_EXTFIELD2);
    }

    public final String getEXTFIELD2() {
        return this.GetParamStringValue(TAG_EXTFIELD2, "");
    }

    public final void setEXTFIELD2(String strValue) {
        this.SetParamValue(TAG_EXTFIELD2, strValue);
    }

    public final boolean isEXTFIELD3Null() {
        return this.IsParamNull(TAG_EXTFIELD3);
    }

    public final String getEXTFIELD3() {
        return this.GetParamStringValue(TAG_EXTFIELD3, "");
    }

    public final void setEXTFIELD3(String strValue) {
        this.SetParamValue(TAG_EXTFIELD3, strValue);
    }

    public final boolean isEXTFIELD4Null() {
        return this.IsParamNull(TAG_EXTFIELD4);
    }

    public final String getEXTFIELD4() {
        return this.GetParamStringValue(TAG_EXTFIELD4, "");
    }

    public final void setEXTFIELD4(String strValue) {
        this.SetParamValue(TAG_EXTFIELD4, strValue);
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

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isSAMPLEDATANull() {
        return this.IsParamNull(TAG_SAMPLEDATA);
    }

    public final String getSAMPLEDATA() {
        return this.GetParamStringValue(TAG_SAMPLEDATA, "");
    }

    public final void setSAMPLEDATA(String strValue) {
        this.SetParamValue(TAG_SAMPLEDATA, strValue);
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

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isTOPPOSNull() {
        return this.IsParamNull(TAG_TOPPOS);
    }

    public final String getTOPPOS() {
        return this.GetParamStringValue(TAG_TOPPOS, "");
    }

    public final void setTOPPOS(String strValue) {
        this.SetParamValue(TAG_TOPPOS, strValue);
    }

    public final boolean isLEFTPOSNull() {
        return this.IsParamNull(TAG_LEFTPOS);
    }

    public final String getLEFTPOS() {
        return this.GetParamStringValue(TAG_LEFTPOS, "");
    }

    public final void setLEFTPOS(String strValue) {
        this.SetParamValue(TAG_LEFTPOS, strValue);
    }

    public final boolean isWIDTHNull() {
        return this.IsParamNull(TAG_WIDTH);
    }

    public final String getWIDTH() {
        return this.GetParamStringValue(TAG_WIDTH, "");
    }

    public final void setWIDTH(String strValue) {
        this.SetParamValue(TAG_WIDTH, strValue);
    }

    public final boolean isHEIGHTNull() {
        return this.IsParamNull(TAG_HEIGHT);
    }

    public final String getHEIGHT() {
        return this.GetParamStringValue(TAG_HEIGHT, "");
    }

    public final void setHEIGHT(String strValue) {
        this.SetParamValue(TAG_HEIGHT, strValue);
    }

    public final boolean isSERIESLAYOUTBYNull() {
        return this.IsParamNull(TAG_SERIESLAYOUTBY);
    }

    public final String getSERIESLAYOUTBY() {
        return this.GetParamStringValue(TAG_SERIESLAYOUTBY, "");
    }

    public final void setSERIESLAYOUTBY(String strValue) {
        this.SetParamValue(TAG_SERIESLAYOUTBY, strValue);
    }

    public final boolean isRIGHTPOSNull() {
        return this.IsParamNull(TAG_RIGHTPOS);
    }

    public final String getRIGHTPOS() {
        return this.GetParamStringValue(TAG_RIGHTPOS, "");
    }

    public final void setRIGHTPOS(String strValue) {
        this.SetParamValue(TAG_RIGHTPOS, strValue);
    }

    public final boolean isBOTTOMPOSNull() {
        return this.IsParamNull(TAG_BOTTOMPOS);
    }

    public final String getBOTTOMPOS() {
        return this.GetParamStringValue(TAG_BOTTOMPOS, "");
    }

    public final void setBOTTOMPOS(String strValue) {
        this.SetParamValue(TAG_BOTTOMPOS, strValue);
    }

    public final boolean isSORTDIRNull() {
        return this.IsParamNull(TAG_SORTDIR);
    }

    public final String getSORTDIR() {
        return this.GetParamStringValue(TAG_SORTDIR, "");
    }

    public final void setSORTDIR(String strValue) {
        this.SetParamValue(TAG_SORTDIR, strValue);
    }

    public final boolean isCOORDINATESYSTEMNull() {
        return this.IsParamNull(TAG_COORDINATESYSTEM);
    }

    public final String getCOORDINATESYSTEM() {
        return this.GetParamStringValue(TAG_COORDINATESYSTEM, "");
    }

    public final void setCOORDINATESYSTEM(String strValue) {
        this.SetParamValue(TAG_COORDINATESYSTEM, strValue);
    }

    public final boolean isCOORDINATESYSTEMIDNull() {
        return this.IsParamNull(TAG_COORDINATESYSTEMID);
    }

    public final int getCOORDINATESYSTEMID() {
        return this.GetParamIntValue(TAG_COORDINATESYSTEMID, 0);
    }

    public final void setCOORDINATESYSTEMID(int nValue) {
        this.SetParamValue(TAG_COORDINATESYSTEMID, nValue);
    }

    public final boolean isCSPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_CSPSSYSPFPLUGINID);
    }

    public final String getCSPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_CSPSSYSPFPLUGINID, "");
    }

    public final void setCSPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_CSPSSYSPFPLUGINID, strValue);
    }

    public final boolean isCSPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_CSPSSYSPFPLUGINNAME);
    }

    public final String getCSPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_CSPSSYSPFPLUGINNAME, "");
    }

    public final void setCSPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_CSPSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELID);
    }

    public final String getPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELID, "");
    }

    public final void setPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELID, strValue);
    }

    public final boolean isPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELNAME);
    }

    public final String getPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELNAME, "");
    }

    public final void setPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELNAME, strValue);
    }

    public final boolean isCSPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_CSPSSYSDYNAMODELID);
    }

    public final String getCSPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_CSPSSYSDYNAMODELID, "");
    }

    public final void setCSPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_CSPSSYSDYNAMODELID, strValue);
    }

    public final boolean isCSPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_CSPSSYSDYNAMODELNAME);
    }

    public final String getCSPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_CSPSSYSDYNAMODELNAME, "");
    }

    public final void setCSPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_CSPSSYSDYNAMODELNAME, strValue);
    }
}

