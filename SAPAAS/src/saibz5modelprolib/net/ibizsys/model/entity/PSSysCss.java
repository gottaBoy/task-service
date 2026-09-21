/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSSysCss
extends BaseDataEntity {
    public static final String BORDERSTYLE_NONE = "NONE";
    public static final String BORDERSTYLE_SOLID = "SOLID";
    public static final String BORDERSTYLE_DOTTED = "DOTTED";
    public static final String BORDERSTYLE_DASHED = "DASHED";
    public static final String BORDERSTYLE_DOUBLE = "DOUBLE";
    public static final int FONTSTYLE_BOLD = 1;
    public static final int FONTSTYLE_ITALIC = 2;
    public static final int FONTSTYLE_UNDERLINE = 4;
    public static final String HALIGN_LEFT = "LEFT";
    public static final String HALIGN_CENTER = "CENTER";
    public static final String HALIGN_RIGHT = "RIGHT";
    public static final String HALIGN_JUSTIFY = "JUSTIFY";
    public static final String VALIGN_TOP = "TOP";
    public static final String VALIGN_MIDDLE = "MIDDLE";
    public static final String VALIGN_BOTTOM = "BOTTOM";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSCSSTEMPLID = "PSCSSTEMPLID";
    public static final String TAG_PSCSSTEMPLNAME = "PSCSSTEMPLNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CSSNAME = "CSSNAME";
    public static final String TAG_CSSSTYLE = "CSSSTYLE";
    public static final String TAG_PSSYSCSSCATID = "PSSYSCSSCATID";
    public static final String TAG_PSSYSCSSCATNAME = "PSSYSCSSCATNAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_LOCKFLAG = "LOCKFLAG";
    public static final String TAG_BKCOLOR = "BKCOLOR";
    public static final String TAG_BORDERCOLOR = "BORDERCOLOR";
    public static final String TAG_BORDERSTYLE = "BORDERSTYLE";
    public static final String TAG_BORDER = "BORDER";
    public static final String TAG_MARGIN = "MARGIN";
    public static final String TAG_PADDING = "PADDING";
    public static final String TAG_FONTFAMILY = "FONTFAMILY";
    public static final String TAG_FONTSIZE = "FONTSIZE";
    public static final String TAG_FONTCOLOR = "FONTCOLOR";
    public static final String TAG_FONTSTYLE = "FONTSTYLE";
    public static final String TAG_HALIGN = "HALIGN";
    public static final String TAG_VALIGN = "VALIGN";
    public static final String TAG_SAMPLECONTENT = "SAMPLECONTENT";

    public final boolean isPSSYSCSSIDNull() {
        return this.isParamNull(TAG_PSSYSCSSID);
    }

    public final String getPSSYSCSSID() {
        return this.getParamStringValue(TAG_PSSYSCSSID, "");
    }

    public final void setPSSYSCSSID(String strValue) {
        this.setParamValue(TAG_PSSYSCSSID, strValue);
    }

    public final boolean isPSSYSCSSNAMENull() {
        return this.isParamNull(TAG_PSSYSCSSNAME);
    }

    public final String getPSSYSCSSNAME() {
        return this.getParamStringValue(TAG_PSSYSCSSNAME, "");
    }

    public final void setPSSYSCSSNAME(String strValue) {
        this.setParamValue(TAG_PSSYSCSSNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.isParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.getParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.setParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isPSCSSTEMPLIDNull() {
        return this.isParamNull(TAG_PSCSSTEMPLID);
    }

    public final String getPSCSSTEMPLID() {
        return this.getParamStringValue(TAG_PSCSSTEMPLID, "");
    }

    public final void setPSCSSTEMPLID(String strValue) {
        this.setParamValue(TAG_PSCSSTEMPLID, strValue);
    }

    public final boolean isPSCSSTEMPLNAMENull() {
        return this.isParamNull(TAG_PSCSSTEMPLNAME);
    }

    public final String getPSCSSTEMPLNAME() {
        return this.getParamStringValue(TAG_PSCSSTEMPLNAME, "");
    }

    public final void setPSCSSTEMPLNAME(String strValue) {
        this.setParamValue(TAG_PSCSSTEMPLNAME, strValue);
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

    public final boolean isCSSNAMENull() {
        return this.isParamNull(TAG_CSSNAME);
    }

    public final String getCSSNAME() {
        return this.getParamStringValue(TAG_CSSNAME, "");
    }

    public final void setCSSNAME(String strValue) {
        this.setParamValue(TAG_CSSNAME, strValue);
    }

    public final boolean isCSSSTYLENull() {
        return this.isParamNull(TAG_CSSSTYLE);
    }

    public final String getCSSSTYLE() {
        return this.getParamStringValue(TAG_CSSSTYLE, "");
    }

    public final void setCSSSTYLE(String strValue) {
        this.setParamValue(TAG_CSSSTYLE, strValue);
    }

    public final boolean isPSSYSCSSCATIDNull() {
        return this.isParamNull(TAG_PSSYSCSSCATID);
    }

    public final String getPSSYSCSSCATID() {
        return this.getParamStringValue(TAG_PSSYSCSSCATID, "");
    }

    public final void setPSSYSCSSCATID(String strValue) {
        this.setParamValue(TAG_PSSYSCSSCATID, strValue);
    }

    public final boolean isPSSYSCSSCATNAMENull() {
        return this.isParamNull(TAG_PSSYSCSSCATNAME);
    }

    public final String getPSSYSCSSCATNAME() {
        return this.getParamStringValue(TAG_PSSYSCSSCATNAME, "");
    }

    public final void setPSSYSCSSCATNAME(String strValue) {
        this.setParamValue(TAG_PSSYSCSSCATNAME, strValue);
    }

    public final boolean isPSMODULEIDNull() {
        return this.isParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.getParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.setParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.isParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.getParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.setParamValue(TAG_PSMODULENAME, strValue);
    }

    public final boolean isLOCKFLAGNull() {
        return this.isParamNull(TAG_LOCKFLAG);
    }

    public final boolean getLOCKFLAG() {
        return this.getParamIntValue(TAG_LOCKFLAG, 0) == 1;
    }

    public final void setLOCKFLAG(boolean bValue) {
        this.setParamValue(TAG_LOCKFLAG, bValue ? 1 : 0);
    }

    public final boolean isBKCOLORNull() {
        return this.isParamNull(TAG_BKCOLOR);
    }

    public final String getBKCOLOR() {
        return this.getParamStringValue(TAG_BKCOLOR, "");
    }

    public final void setBKCOLOR(String strValue) {
        this.setParamValue(TAG_BKCOLOR, strValue);
    }

    public final boolean isBORDERCOLORNull() {
        return this.isParamNull(TAG_BORDERCOLOR);
    }

    public final String getBORDERCOLOR() {
        return this.getParamStringValue(TAG_BORDERCOLOR, "");
    }

    public final void setBORDERCOLOR(String strValue) {
        this.setParamValue(TAG_BORDERCOLOR, strValue);
    }

    public final boolean isBORDERSTYLENull() {
        return this.isParamNull(TAG_BORDERSTYLE);
    }

    public final String getBORDERSTYLE() {
        return this.getParamStringValue(TAG_BORDERSTYLE, "");
    }

    public final void setBORDERSTYLE(String strValue) {
        this.setParamValue(TAG_BORDERSTYLE, strValue);
    }

    public final boolean isBORDERNull() {
        return this.isParamNull(TAG_BORDER);
    }

    public final String getBORDER() {
        return this.getParamStringValue(TAG_BORDER, "");
    }

    public final void setBORDER(String strValue) {
        this.setParamValue(TAG_BORDER, strValue);
    }

    public final boolean isMARGINNull() {
        return this.isParamNull(TAG_MARGIN);
    }

    public final String getMARGIN() {
        return this.getParamStringValue(TAG_MARGIN, "");
    }

    public final void setMARGIN(String strValue) {
        this.setParamValue(TAG_MARGIN, strValue);
    }

    public final boolean isPADDINGNull() {
        return this.isParamNull(TAG_PADDING);
    }

    public final String getPADDING() {
        return this.getParamStringValue(TAG_PADDING, "");
    }

    public final void setPADDING(String strValue) {
        this.setParamValue(TAG_PADDING, strValue);
    }

    public final boolean isFONTFAMILYNull() {
        return this.isParamNull(TAG_FONTFAMILY);
    }

    public final String getFONTFAMILY() {
        return this.getParamStringValue(TAG_FONTFAMILY, "");
    }

    public final void setFONTFAMILY(String strValue) {
        this.setParamValue(TAG_FONTFAMILY, strValue);
    }

    public final boolean isFONTSIZENull() {
        return this.isParamNull(TAG_FONTSIZE);
    }

    public final int getFONTSIZE() {
        return this.getParamIntValue(TAG_FONTSIZE, 0);
    }

    public final void setFONTSIZE(int nValue) {
        this.setParamValue(TAG_FONTSIZE, nValue);
    }

    public final boolean isFONTCOLORNull() {
        return this.isParamNull(TAG_FONTCOLOR);
    }

    public final String getFONTCOLOR() {
        return this.getParamStringValue(TAG_FONTCOLOR, "");
    }

    public final void setFONTCOLOR(String strValue) {
        this.setParamValue(TAG_FONTCOLOR, strValue);
    }

    public final boolean isFONTSTYLENull() {
        return this.isParamNull(TAG_FONTSTYLE);
    }

    public final int getFONTSTYLE() {
        return this.getParamIntValue(TAG_FONTSTYLE, 0);
    }

    public final void setFONTSTYLE(int nValue) {
        this.setParamValue(TAG_FONTSTYLE, nValue);
    }

    public final boolean isHALIGNNull() {
        return this.isParamNull(TAG_HALIGN);
    }

    public final String getHALIGN() {
        return this.getParamStringValue(TAG_HALIGN, "");
    }

    public final void setHALIGN(String strValue) {
        this.setParamValue(TAG_HALIGN, strValue);
    }

    public final boolean isVALIGNNull() {
        return this.isParamNull(TAG_VALIGN);
    }

    public final String getVALIGN() {
        return this.getParamStringValue(TAG_VALIGN, "");
    }

    public final void setVALIGN(String strValue) {
        this.setParamValue(TAG_VALIGN, strValue);
    }

    public final boolean isSAMPLECONTENTNull() {
        return this.isParamNull(TAG_SAMPLECONTENT);
    }

    public final String getSAMPLECONTENT() {
        return this.getParamStringValue(TAG_SAMPLECONTENT, "");
    }

    public final void setSAMPLECONTENT(String strValue) {
        this.setParamValue(TAG_SAMPLECONTENT, strValue);
    }
}

