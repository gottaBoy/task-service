/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEChartSeries
extends BaseDataEntity {
    public static final String CHARTTYPE_area = "area";
    public static final String CHARTTYPE_bar = "bar";
    public static final String CHARTTYPE_bar3d = "bar3d";
    public static final String CHARTTYPE_candlestick = "candlestick";
    public static final String CHARTTYPE_gauge = "gauge";
    public static final String CHARTTYPE_line = "line";
    public static final String CHARTTYPE_pie = "pie";
    public static final String CHARTTYPE_pie3d = "pie3d";
    public static final String CHARTTYPE_radar = "radar";
    public static final String CHARTTYPE_scatter = "scatter";
    public static final String TIMEGROUP_YEAR = "YEAR";
    public static final String TIMEGROUP_QUARTER = "QUARTER";
    public static final String TIMEGROUP_MONTH = "MONTH";
    public static final String TIMEGROUP_YEARWEEK = "YEARWEEK";
    public static final String TIMEGROUP_DAY = "DAY";
    public static final String TAG_PSDECHARTPARAMID = "PSDECHARTPARAMID";
    public static final String TAG_PSDECHARTPARAMNAME = "PSDECHARTPARAMNAME";
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
    public static final String TAG_SERIESPARAM3 = "SERIESPARAM3";
    public static final String TAG_SERIESPARAM4 = "SERIESPARAM4";
    public static final String TAG_SERIESPARAM5 = "SERIESPARAM5";
    public static final String TAG_SERIESPARAM6 = "SERIESPARAM6";
    public static final String TAG_SERIESPARAM7 = "SERIESPARAM7";
    public static final String TAG_SERIESPARAM8 = "SERIESPARAM8";
    public static final String TAG_SERIESPARAM9 = "SERIESPARAM9";
    public static final String TAG_SERIESPARAM10 = "SERIESPARAM10";
    public static final String TAG_SERIESPARAM11 = "SERIESPARAM11";
    public static final String TAG_SERIESPARAM12 = "SERIESPARAM12";
    public static final String TAG_SERIESPARAM2 = "SERIESPARAM2";
    public static final String TAG_SERIESPARAM = "SERIESPARAM";
    public static final String TAG_BARWIDTH = "BARWIDTH";
    public static final String TAG_BARMAXWIDTH = "BARMAXWIDTH";
    public static final String TAG_BARMINWIDTH = "BARMINWIDTH";
    public static final String TAG_BARMINHEIGHT = "BARMINHEIGHT";
    public static final String TAG_BARGAP = "BARGAP";
    public static final String TAG_BARCATEGORYGAP = "BARCATEGORYGAP";
    public static final String TAG_BOXWIDTHS = "BOXWIDTHS";
    public static final String TAG_STARTANGLE = "STARTANGLE";
    public static final String TAG_MINANGLE = "MINANGLE";
    public static final String TAG_MINSHOWLABELANGLE = "MINSHOWLABELANGLE";
    public static final String TAG_ROSETYPE = "ROSETYPE";
    public static final String TAG_MINVALUE = "MINVALUE";
    public static final String TAG_MAXVALUE = "MAXVALUE";
    public static final String TAG_MAXSIZE = "MAXSIZE";
    public static final String TAG_MINSIZE = "MINSIZE";
    public static final String TAG_FUNNELALIGN = "FUNNELALIGN";
    public static final String TAG_RADIUS = "RADIUS";
    public static final String TAG_ENDANGLE = "ENDANGLE";
    public static final String TAG_CLOCKWISE = "CLOCKWISE";
    public static final String TAG_SPLITNUMBER = "SPLITNUMBER";
    public static final String TAG_STACK = "STACK";
    public static final String TAG_STEP = "STEP";
    public static final String TAG_CENTER = "CENTER";
    public static final String TAG_TAGFIELD = "TAGFIELD";
    public static final String TAG_DATAFIELD = "DATAFIELD";
    public static final String TAG_MAPTYPE = "MAPTYPE";
    public static final String TAG_PSDEID = "PSDEID";

    public final boolean isPSDECHARTPARAMIDNull() {
        return this.IsParamNull(TAG_PSDECHARTPARAMID);
    }

    public final String getPSDECHARTPARAMID() {
        return this.GetParamStringValue(TAG_PSDECHARTPARAMID, "");
    }

    public final void setPSDECHARTPARAMID(String strValue) {
        this.SetParamValue(TAG_PSDECHARTPARAMID, strValue);
    }

    public final boolean isPSDECHARTPARAMNAMENull() {
        return this.IsParamNull(TAG_PSDECHARTPARAMNAME);
    }

    public final String getPSDECHARTPARAMNAME() {
        return this.GetParamStringValue(TAG_PSDECHARTPARAMNAME, "");
    }

    public final void setPSDECHARTPARAMNAME(String strValue) {
        this.SetParamValue(TAG_PSDECHARTPARAMNAME, strValue);
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

    public final boolean isSERIESPARAM3Null() {
        return this.IsParamNull(TAG_SERIESPARAM3);
    }

    public final String getSERIESPARAM3() {
        return this.GetParamStringValue(TAG_SERIESPARAM3, "");
    }

    public final void setSERIESPARAM3(String strValue) {
        this.SetParamValue(TAG_SERIESPARAM3, strValue);
    }

    public final boolean isSERIESPARAM4Null() {
        return this.IsParamNull(TAG_SERIESPARAM4);
    }

    public final String getSERIESPARAM4() {
        return this.GetParamStringValue(TAG_SERIESPARAM4, "");
    }

    public final void setSERIESPARAM4(String strValue) {
        this.SetParamValue(TAG_SERIESPARAM4, strValue);
    }

    public final boolean isSERIESPARAM5Null() {
        return this.IsParamNull(TAG_SERIESPARAM5);
    }

    public final boolean getSERIESPARAM5() {
        return this.GetParamIntValue(TAG_SERIESPARAM5, 0) == 1;
    }

    public final void setSERIESPARAM5(boolean bValue) {
        this.SetParamValue(TAG_SERIESPARAM5, bValue ? 1 : 0);
    }

    public final boolean isSERIESPARAM6Null() {
        return this.IsParamNull(TAG_SERIESPARAM6);
    }

    public final boolean getSERIESPARAM6() {
        return this.GetParamIntValue(TAG_SERIESPARAM6, 0) == 1;
    }

    public final void setSERIESPARAM6(boolean bValue) {
        this.SetParamValue(TAG_SERIESPARAM6, bValue ? 1 : 0);
    }

    public final boolean isSERIESPARAM7Null() {
        return this.IsParamNull(TAG_SERIESPARAM7);
    }

    public final int getSERIESPARAM7() {
        return this.GetParamIntValue(TAG_SERIESPARAM7, 0);
    }

    public final void setSERIESPARAM7(int nValue) {
        this.SetParamValue(TAG_SERIESPARAM7, nValue);
    }

    public final boolean isSERIESPARAM8Null() {
        return this.IsParamNull(TAG_SERIESPARAM8);
    }

    public final int getSERIESPARAM8() {
        return this.GetParamIntValue(TAG_SERIESPARAM8, 0);
    }

    public final void setSERIESPARAM8(int nValue) {
        this.SetParamValue(TAG_SERIESPARAM8, nValue);
    }

    public final boolean isSERIESPARAM9Null() {
        return this.IsParamNull(TAG_SERIESPARAM9);
    }

    public final float getSERIESPARAM9() {
        return this.GetParamFloatValue(TAG_SERIESPARAM9, 0.0f);
    }

    public final void setSERIESPARAM9(float fValue) {
        this.SetParamValue(TAG_SERIESPARAM9, Float.valueOf(fValue));
    }

    public final boolean isSERIESPARAM10Null() {
        return this.IsParamNull(TAG_SERIESPARAM10);
    }

    public final float getSERIESPARAM10() {
        return this.GetParamFloatValue(TAG_SERIESPARAM10, 0.0f);
    }

    public final void setSERIESPARAM10(float fValue) {
        this.SetParamValue(TAG_SERIESPARAM10, Float.valueOf(fValue));
    }

    public final boolean isSERIESPARAM11Null() {
        return this.IsParamNull(TAG_SERIESPARAM11);
    }

    public final int getSERIESPARAM11() {
        return this.GetParamIntValue(TAG_SERIESPARAM11, 0);
    }

    public final void setSERIESPARAM11(int nValue) {
        this.SetParamValue(TAG_SERIESPARAM11, nValue);
    }

    public final boolean isSERIESPARAM12Null() {
        return this.IsParamNull(TAG_SERIESPARAM12);
    }

    public final int getSERIESPARAM12() {
        return this.GetParamIntValue(TAG_SERIESPARAM12, 0);
    }

    public final void setSERIESPARAM12(int nValue) {
        this.SetParamValue(TAG_SERIESPARAM12, nValue);
    }

    public final boolean isSERIESPARAM2Null() {
        return this.IsParamNull(TAG_SERIESPARAM2);
    }

    public final String getSERIESPARAM2() {
        return this.GetParamStringValue(TAG_SERIESPARAM2, "");
    }

    public final void setSERIESPARAM2(String strValue) {
        this.SetParamValue(TAG_SERIESPARAM2, strValue);
    }

    public final boolean isSERIESPARAMNull() {
        return this.IsParamNull(TAG_SERIESPARAM);
    }

    public final String getSERIESPARAM() {
        return this.GetParamStringValue(TAG_SERIESPARAM, "");
    }

    public final void setSERIESPARAM(String strValue) {
        this.SetParamValue(TAG_SERIESPARAM, strValue);
    }

    public final boolean isBARWIDTHNull() {
        return this.IsParamNull(TAG_BARWIDTH);
    }

    public final String getBARWIDTH() {
        return this.GetParamStringValue(TAG_BARWIDTH, "");
    }

    public final void setBARWIDTH(String strValue) {
        this.SetParamValue(TAG_BARWIDTH, strValue);
    }

    public final boolean isBARMAXWIDTHNull() {
        return this.IsParamNull(TAG_BARMAXWIDTH);
    }

    public final String getBARMAXWIDTH() {
        return this.GetParamStringValue(TAG_BARMAXWIDTH, "");
    }

    public final void setBARMAXWIDTH(String strValue) {
        this.SetParamValue(TAG_BARMAXWIDTH, strValue);
    }

    public final boolean isBARMINWIDTHNull() {
        return this.IsParamNull(TAG_BARMINWIDTH);
    }

    public final String getBARMINWIDTH() {
        return this.GetParamStringValue(TAG_BARMINWIDTH, "");
    }

    public final void setBARMINWIDTH(String strValue) {
        this.SetParamValue(TAG_BARMINWIDTH, strValue);
    }

    public final boolean isBARMINHEIGHTNull() {
        return this.IsParamNull(TAG_BARMINHEIGHT);
    }

    public final String getBARMINHEIGHT() {
        return this.GetParamStringValue(TAG_BARMINHEIGHT, "");
    }

    public final void setBARMINHEIGHT(String strValue) {
        this.SetParamValue(TAG_BARMINHEIGHT, strValue);
    }

    public final boolean isBARGAPNull() {
        return this.IsParamNull(TAG_BARGAP);
    }

    public final String getBARGAP() {
        return this.GetParamStringValue(TAG_BARGAP, "");
    }

    public final void setBARGAP(String strValue) {
        this.SetParamValue(TAG_BARGAP, strValue);
    }

    public final boolean isBARCATEGORYGAPNull() {
        return this.IsParamNull(TAG_BARCATEGORYGAP);
    }

    public final String getBARCATEGORYGAP() {
        return this.GetParamStringValue(TAG_BARCATEGORYGAP, "");
    }

    public final void setBARCATEGORYGAP(String strValue) {
        this.SetParamValue(TAG_BARCATEGORYGAP, strValue);
    }

    public final boolean isBOXWIDTHSNull() {
        return this.IsParamNull(TAG_BOXWIDTHS);
    }

    public final String getBOXWIDTHS() {
        return this.GetParamStringValue(TAG_BOXWIDTHS, "");
    }

    public final void setBOXWIDTHS(String strValue) {
        this.SetParamValue(TAG_BOXWIDTHS, strValue);
    }

    public final boolean isSTARTANGLENull() {
        return this.IsParamNull(TAG_STARTANGLE);
    }

    public final int getSTARTANGLE() {
        return this.GetParamIntValue(TAG_STARTANGLE, 0);
    }

    public final void setSTARTANGLE(int nValue) {
        this.SetParamValue(TAG_STARTANGLE, nValue);
    }

    public final boolean isMINANGLENull() {
        return this.IsParamNull(TAG_MINANGLE);
    }

    public final int getMINANGLE() {
        return this.GetParamIntValue(TAG_MINANGLE, 0);
    }

    public final void setMINANGLE(int nValue) {
        this.SetParamValue(TAG_MINANGLE, nValue);
    }

    public final boolean isMINSHOWLABELANGLENull() {
        return this.IsParamNull(TAG_MINSHOWLABELANGLE);
    }

    public final int getMINSHOWLABELANGLE() {
        return this.GetParamIntValue(TAG_MINSHOWLABELANGLE, 0);
    }

    public final void setMINSHOWLABELANGLE(int nValue) {
        this.SetParamValue(TAG_MINSHOWLABELANGLE, nValue);
    }

    public final boolean isROSETYPENull() {
        return this.IsParamNull(TAG_ROSETYPE);
    }

    public final String getROSETYPE() {
        return this.GetParamStringValue(TAG_ROSETYPE, "");
    }

    public final void setROSETYPE(String strValue) {
        this.SetParamValue(TAG_ROSETYPE, strValue);
    }

    public final boolean isMINVALUENull() {
        return this.IsParamNull(TAG_MINVALUE);
    }

    public final int getMINVALUE() {
        return this.GetParamIntValue(TAG_MINVALUE, 0);
    }

    public final void setMINVALUE(int nValue) {
        this.SetParamValue(TAG_MINVALUE, nValue);
    }

    public final boolean isMAXVALUENull() {
        return this.IsParamNull(TAG_MAXVALUE);
    }

    public final int getMAXVALUE() {
        return this.GetParamIntValue(TAG_MAXVALUE, 0);
    }

    public final void setMAXVALUE(int nValue) {
        this.SetParamValue(TAG_MAXVALUE, nValue);
    }

    public final boolean isMAXSIZENull() {
        return this.IsParamNull(TAG_MAXSIZE);
    }

    public final String getMAXSIZE() {
        return this.GetParamStringValue(TAG_MAXSIZE, "");
    }

    public final void setMAXSIZE(String strValue) {
        this.SetParamValue(TAG_MAXSIZE, strValue);
    }

    public final boolean isMINSIZENull() {
        return this.IsParamNull(TAG_MINSIZE);
    }

    public final String getMINSIZE() {
        return this.GetParamStringValue(TAG_MINSIZE, "");
    }

    public final void setMINSIZE(String strValue) {
        this.SetParamValue(TAG_MINSIZE, strValue);
    }

    public final boolean isFUNNELALIGNNull() {
        return this.IsParamNull(TAG_FUNNELALIGN);
    }

    public final String getFUNNELALIGN() {
        return this.GetParamStringValue(TAG_FUNNELALIGN, "");
    }

    public final void setFUNNELALIGN(String strValue) {
        this.SetParamValue(TAG_FUNNELALIGN, strValue);
    }

    public final boolean isRADIUSNull() {
        return this.IsParamNull(TAG_RADIUS);
    }

    public final String getRADIUS() {
        return this.GetParamStringValue(TAG_RADIUS, "");
    }

    public final void setRADIUS(String strValue) {
        this.SetParamValue(TAG_RADIUS, strValue);
    }

    public final boolean isENDANGLENull() {
        return this.IsParamNull(TAG_ENDANGLE);
    }

    public final int getENDANGLE() {
        return this.GetParamIntValue(TAG_ENDANGLE, 0);
    }

    public final void setENDANGLE(int nValue) {
        this.SetParamValue(TAG_ENDANGLE, nValue);
    }

    public final boolean isCLOCKWISENull() {
        return this.IsParamNull(TAG_CLOCKWISE);
    }

    public final boolean getCLOCKWISE() {
        return this.GetParamIntValue(TAG_CLOCKWISE, 0) == 1;
    }

    public final void setCLOCKWISE(boolean bValue) {
        this.SetParamValue(TAG_CLOCKWISE, bValue ? 1 : 0);
    }

    public final boolean isSPLITNUMBERNull() {
        return this.IsParamNull(TAG_SPLITNUMBER);
    }

    public final int getSPLITNUMBER() {
        return this.GetParamIntValue(TAG_SPLITNUMBER, 0);
    }

    public final void setSPLITNUMBER(int nValue) {
        this.SetParamValue(TAG_SPLITNUMBER, nValue);
    }

    public final boolean isSTACKNull() {
        return this.IsParamNull(TAG_STACK);
    }

    public final boolean getSTACK() {
        return this.GetParamIntValue(TAG_STACK, 0) == 1;
    }

    public final void setSTACK(boolean bValue) {
        this.SetParamValue(TAG_STACK, bValue ? 1 : 0);
    }

    public final boolean isSTEPNull() {
        return this.IsParamNull(TAG_STEP);
    }

    public final String getSTEP() {
        return this.GetParamStringValue(TAG_STEP, "");
    }

    public final void setSTEP(String strValue) {
        this.SetParamValue(TAG_STEP, strValue);
    }

    public final boolean isCENTERNull() {
        return this.IsParamNull(TAG_CENTER);
    }

    public final String getCENTER() {
        return this.GetParamStringValue(TAG_CENTER, "");
    }

    public final void setCENTER(String strValue) {
        this.SetParamValue(TAG_CENTER, strValue);
    }

    public final boolean isMAPTYPENull() {
        return this.IsParamNull(TAG_MAPTYPE);
    }

    public final String getMAPTYPE() {
        return this.GetParamStringValue(TAG_MAPTYPE, "");
    }

    public final void setMAPTYPE(String strValue) {
        this.SetParamValue(TAG_MAPTYPE, strValue);
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

    public final boolean isTAGFIELDNull() {
        return this.IsParamNull(TAG_TAGFIELD);
    }

    public final String getTAGFIELD() {
        return this.GetParamStringValue(TAG_TAGFIELD, "");
    }

    public final void setTAGFIELD(String strValue) {
        this.SetParamValue(TAG_TAGFIELD, strValue);
    }

    public final boolean isDATAFIELDNull() {
        return this.IsParamNull(TAG_DATAFIELD);
    }

    public final String getDATAFIELD() {
        return this.GetParamStringValue(TAG_DATAFIELD, "");
    }

    public final void setDATAFIELD(String strValue) {
        this.SetParamValue(TAG_DATAFIELD, strValue);
    }
}

