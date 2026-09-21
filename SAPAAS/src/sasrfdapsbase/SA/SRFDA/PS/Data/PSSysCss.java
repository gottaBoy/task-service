/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

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
    public static final String TAG_CODENAME = "CODENAME";

    public final boolean isPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_PSSYSCSSID);
    }

    public final String getPSSYSCSSID() {
        return this.GetParamStringValue(TAG_PSSYSCSSID, "");
    }

    public final void setPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSID, strValue);
    }

    public final boolean isPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_PSSYSCSSNAME);
    }

    public final String getPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_PSSYSCSSNAME, "");
    }

    public final void setPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isPSCSSTEMPLIDNull() {
        return this.IsParamNull(TAG_PSCSSTEMPLID);
    }

    public final String getPSCSSTEMPLID() {
        return this.GetParamStringValue(TAG_PSCSSTEMPLID, "");
    }

    public final void setPSCSSTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSCSSTEMPLID, strValue);
    }

    public final boolean isPSCSSTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSCSSTEMPLNAME);
    }

    public final String getPSCSSTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSCSSTEMPLNAME, "");
    }

    public final void setPSCSSTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSCSSTEMPLNAME, strValue);
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

    public final boolean isCSSNAMENull() {
        return this.IsParamNull(TAG_CSSNAME);
    }

    public final String getCSSNAME() {
        return this.GetParamStringValue(TAG_CSSNAME, "");
    }

    public final void setCSSNAME(String strValue) {
        this.SetParamValue(TAG_CSSNAME, strValue);
    }

    public final boolean isCSSSTYLENull() {
        return this.IsParamNull(TAG_CSSSTYLE);
    }

    public final String getCSSSTYLE() {
        return this.GetParamStringValue(TAG_CSSSTYLE, "");
    }

    public final void setCSSSTYLE(String strValue) {
        this.SetParamValue(TAG_CSSSTYLE, strValue);
    }

    public final boolean isPSSYSCSSCATIDNull() {
        return this.IsParamNull(TAG_PSSYSCSSCATID);
    }

    public final String getPSSYSCSSCATID() {
        return this.GetParamStringValue(TAG_PSSYSCSSCATID, "");
    }

    public final void setPSSYSCSSCATID(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSCATID, strValue);
    }

    public final boolean isPSSYSCSSCATNAMENull() {
        return this.IsParamNull(TAG_PSSYSCSSCATNAME);
    }

    public final String getPSSYSCSSCATNAME() {
        return this.GetParamStringValue(TAG_PSSYSCSSCATNAME, "");
    }

    public final void setPSSYSCSSCATNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSCATNAME, strValue);
    }

    public final boolean isPSMODULEIDNull() {
        return this.IsParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.GetParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.SetParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.IsParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.GetParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSMODULENAME, strValue);
    }

    public final boolean isLOCKFLAGNull() {
        return this.IsParamNull(TAG_LOCKFLAG);
    }

    public final boolean getLOCKFLAG() {
        return this.GetParamIntValue(TAG_LOCKFLAG, 0) == 1;
    }

    public final void setLOCKFLAG(boolean bValue) {
        this.SetParamValue(TAG_LOCKFLAG, bValue ? 1 : 0);
    }

    public final boolean isBKCOLORNull() {
        return this.IsParamNull(TAG_BKCOLOR);
    }

    public final String getBKCOLOR() {
        return this.GetParamStringValue(TAG_BKCOLOR, "");
    }

    public final void setBKCOLOR(String strValue) {
        this.SetParamValue(TAG_BKCOLOR, strValue);
    }

    public final boolean isBORDERCOLORNull() {
        return this.IsParamNull(TAG_BORDERCOLOR);
    }

    public final String getBORDERCOLOR() {
        return this.GetParamStringValue(TAG_BORDERCOLOR, "");
    }

    public final void setBORDERCOLOR(String strValue) {
        this.SetParamValue(TAG_BORDERCOLOR, strValue);
    }

    public final boolean isBORDERSTYLENull() {
        return this.IsParamNull(TAG_BORDERSTYLE);
    }

    public final String getBORDERSTYLE() {
        return this.GetParamStringValue(TAG_BORDERSTYLE, "");
    }

    public final void setBORDERSTYLE(String strValue) {
        this.SetParamValue(TAG_BORDERSTYLE, strValue);
    }

    public final boolean isBORDERNull() {
        return this.IsParamNull(TAG_BORDER);
    }

    public final String getBORDER() {
        return this.GetParamStringValue(TAG_BORDER, "");
    }

    public final void setBORDER(String strValue) {
        this.SetParamValue(TAG_BORDER, strValue);
    }

    public final boolean isMARGINNull() {
        return this.IsParamNull(TAG_MARGIN);
    }

    public final String getMARGIN() {
        return this.GetParamStringValue(TAG_MARGIN, "");
    }

    public final void setMARGIN(String strValue) {
        this.SetParamValue(TAG_MARGIN, strValue);
    }

    public final boolean isPADDINGNull() {
        return this.IsParamNull(TAG_PADDING);
    }

    public final String getPADDING() {
        return this.GetParamStringValue(TAG_PADDING, "");
    }

    public final void setPADDING(String strValue) {
        this.SetParamValue(TAG_PADDING, strValue);
    }

    public final boolean isFONTFAMILYNull() {
        return this.IsParamNull(TAG_FONTFAMILY);
    }

    public final String getFONTFAMILY() {
        return this.GetParamStringValue(TAG_FONTFAMILY, "");
    }

    public final void setFONTFAMILY(String strValue) {
        this.SetParamValue(TAG_FONTFAMILY, strValue);
    }

    public final boolean isFONTSIZENull() {
        return this.IsParamNull(TAG_FONTSIZE);
    }

    public final int getFONTSIZE() {
        return this.GetParamIntValue(TAG_FONTSIZE, 0);
    }

    public final void setFONTSIZE(int nValue) {
        this.SetParamValue(TAG_FONTSIZE, nValue);
    }

    public final boolean isFONTCOLORNull() {
        return this.IsParamNull(TAG_FONTCOLOR);
    }

    public final String getFONTCOLOR() {
        return this.GetParamStringValue(TAG_FONTCOLOR, "");
    }

    public final void setFONTCOLOR(String strValue) {
        this.SetParamValue(TAG_FONTCOLOR, strValue);
    }

    public final boolean isFONTSTYLENull() {
        return this.IsParamNull(TAG_FONTSTYLE);
    }

    public final int getFONTSTYLE() {
        return this.GetParamIntValue(TAG_FONTSTYLE, 0);
    }

    public final void setFONTSTYLE(int nValue) {
        this.SetParamValue(TAG_FONTSTYLE, nValue);
    }

    public final boolean isHALIGNNull() {
        return this.IsParamNull(TAG_HALIGN);
    }

    public final String getHALIGN() {
        return this.GetParamStringValue(TAG_HALIGN, "");
    }

    public final void setHALIGN(String strValue) {
        this.SetParamValue(TAG_HALIGN, strValue);
    }

    public final boolean isVALIGNNull() {
        return this.IsParamNull(TAG_VALIGN);
    }

    public final String getVALIGN() {
        return this.GetParamStringValue(TAG_VALIGN, "");
    }

    public final void setVALIGN(String strValue) {
        this.SetParamValue(TAG_VALIGN, strValue);
    }

    public final boolean isSAMPLECONTENTNull() {
        return this.IsParamNull(TAG_SAMPLECONTENT);
    }

    public final String getSAMPLECONTENT() {
        return this.GetParamStringValue(TAG_SAMPLECONTENT, "");
    }

    public final void setSAMPLECONTENT(String strValue) {
        this.SetParamValue(TAG_SAMPLECONTENT, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }
}

