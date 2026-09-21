/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class LayoutPanelItem
extends BaseDataEntity {
    public static final String ITEMTYPE_LABEL = "LABEL";
    public static final String ITEMTYPE_IMAGE = "IMAGE";
    public static final String ITEMTYPE_\u56fe\u5f62 = "\u56fe\u5f62";
    public static final String XYAXIS_LT = "LT";
    public static final String XYAXIS_LC = "LC";
    public static final String XYAXIS_LB = "LB";
    public static final String XYAXIS_CT = "CT";
    public static final String XYAXIS_CC = "CC";
    public static final String XYAXIS_CB = "CB";
    public static final String XYAXIS_RT = "RT";
    public static final String XYAXIS_RC = "RC";
    public static final String XYAXIS_RB = "RB";
    public static final String XY2AXIS_LT = "LT";
    public static final String XY2AXIS_LC = "LC";
    public static final String XY2AXIS_LB = "LB";
    public static final String XY2AXIS_CT = "CT";
    public static final String XY2AXIS_CC = "CC";
    public static final String XY2AXIS_CB = "CB";
    public static final String XY2AXIS_RT = "RT";
    public static final String XY2AXIS_RC = "RC";
    public static final String XY2AXIS_RB = "RB";
    public static final String HALIGN_L = "L";
    public static final String HALIGN_C = "C";
    public static final String HALIGN_R = "R";
    public static final String VALIGN_T = "T";
    public static final String VALIGN_C = "C";
    public static final String VALIGN_B = "B";
    public static final String TAG_LAYOUTPIID = "LAYOUTPIID";
    public static final String TAG_LAYOUTPINAME = "LAYOUTPINAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ITEMTYPE = "ITEMTYPE";
    public static final String TAG_LAYOUTPANELID = "LAYOUTPANELID";
    public static final String TAG_LAYOUTPANELNAME = "LAYOUTPANELNAME";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_X = "X";
    public static final String TAG_X2 = "X2";
    public static final String TAG_Y2 = "Y2";
    public static final String TAG_Y = "Y";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_XYAXIS = "XYAXIS";
    public static final String TAG_XY2AXIS = "XY2AXIS";
    public static final String TAG_BKCOLOR = "BKCOLOR";
    public static final String TAG_FKCOLOR = "FKCOLOR";
    public static final String TAG_HALIGN = "HALIGN";
    public static final String TAG_VALIGN = "VALIGN";
    public static final String TAG_LAYOUTFONTID = "LAYOUTFONTID";
    public static final String TAG_LAYOUTFONTNAME = "LAYOUTFONTNAME";
    public static final String TAG_LAYOUTFONTID2 = "LAYOUTFONTID2";
    public static final String TAG_LAYOUTFONTNAME2 = "LAYOUTFONTNAME2";
    public static final String TAG_MARGIN = "MARGIN";
    public static final String TAG_PADDING = "PADDING";

    public final boolean isLAYOUTPIIDNull() {
        return this.IsParamNull(TAG_LAYOUTPIID);
    }

    public final String getLAYOUTPIID() {
        return this.GetParamStringValue(TAG_LAYOUTPIID, "");
    }

    public final void setLAYOUTPIID(String strValue) {
        this.SetParamValue(TAG_LAYOUTPIID, strValue);
    }

    public final boolean isLAYOUTPINAMENull() {
        return this.IsParamNull(TAG_LAYOUTPINAME);
    }

    public final String getLAYOUTPINAME() {
        return this.GetParamStringValue(TAG_LAYOUTPINAME, "");
    }

    public final void setLAYOUTPINAME(String strValue) {
        this.SetParamValue(TAG_LAYOUTPINAME, strValue);
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

    public final boolean isITEMTYPENull() {
        return this.IsParamNull(TAG_ITEMTYPE);
    }

    public final String getITEMTYPE() {
        return this.GetParamStringValue(TAG_ITEMTYPE, "");
    }

    public final void setITEMTYPE(String strValue) {
        this.SetParamValue(TAG_ITEMTYPE, strValue);
    }

    public final boolean isLAYOUTPANELIDNull() {
        return this.IsParamNull(TAG_LAYOUTPANELID);
    }

    public final String getLAYOUTPANELID() {
        return this.GetParamStringValue(TAG_LAYOUTPANELID, "");
    }

    public final void setLAYOUTPANELID(String strValue) {
        this.SetParamValue(TAG_LAYOUTPANELID, strValue);
    }

    public final boolean isLAYOUTPANELNAMENull() {
        return this.IsParamNull(TAG_LAYOUTPANELNAME);
    }

    public final String getLAYOUTPANELNAME() {
        return this.GetParamStringValue(TAG_LAYOUTPANELNAME, "");
    }

    public final void setLAYOUTPANELNAME(String strValue) {
        this.SetParamValue(TAG_LAYOUTPANELNAME, strValue);
    }

    public final boolean isORDERFLAGNull() {
        return this.IsParamNull(TAG_ORDERFLAG);
    }

    public final int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public final void setORDERFLAG(int nValue) {
        this.SetParamValue(TAG_ORDERFLAG, nValue);
    }

    public final boolean isXNull() {
        return this.IsParamNull(TAG_X);
    }

    public final float getX() {
        return this.GetParamFloatValue(TAG_X, 0.0f);
    }

    public final void setX(float fValue) {
        this.SetParamValue(TAG_X, Float.valueOf(fValue));
    }

    public final boolean isX2Null() {
        return this.IsParamNull(TAG_X2);
    }

    public final float getX2() {
        return this.GetParamFloatValue(TAG_X2, 0.0f);
    }

    public final void setX2(float fValue) {
        this.SetParamValue(TAG_X2, Float.valueOf(fValue));
    }

    public final boolean isY2Null() {
        return this.IsParamNull(TAG_Y2);
    }

    public final float getY2() {
        return this.GetParamFloatValue(TAG_Y2, 0.0f);
    }

    public final void setY2(float fValue) {
        this.SetParamValue(TAG_Y2, Float.valueOf(fValue));
    }

    public final boolean isYNull() {
        return this.IsParamNull(TAG_Y);
    }

    public final float getY() {
        return this.GetParamFloatValue(TAG_Y, 0.0f);
    }

    public final void setY(float fValue) {
        this.SetParamValue(TAG_Y, Float.valueOf(fValue));
    }

    public final boolean isWIDTHNull() {
        return this.IsParamNull(TAG_WIDTH);
    }

    public final float getWIDTH() {
        return this.GetParamFloatValue(TAG_WIDTH, 0.0f);
    }

    public final void setWIDTH(float fValue) {
        this.SetParamValue(TAG_WIDTH, Float.valueOf(fValue));
    }

    public final boolean isHEIGHTNull() {
        return this.IsParamNull(TAG_HEIGHT);
    }

    public final float getHEIGHT() {
        return this.GetParamFloatValue(TAG_HEIGHT, 0.0f);
    }

    public final void setHEIGHT(float fValue) {
        this.SetParamValue(TAG_HEIGHT, Float.valueOf(fValue));
    }

    public final boolean isXYAXISNull() {
        return this.IsParamNull(TAG_XYAXIS);
    }

    public final String getXYAXIS() {
        return this.GetParamStringValue(TAG_XYAXIS, "");
    }

    public final void setXYAXIS(String strValue) {
        this.SetParamValue(TAG_XYAXIS, strValue);
    }

    public final boolean isXY2AXISNull() {
        return this.IsParamNull(TAG_XY2AXIS);
    }

    public final String getXY2AXIS() {
        return this.GetParamStringValue(TAG_XY2AXIS, "");
    }

    public final void setXY2AXIS(String strValue) {
        this.SetParamValue(TAG_XY2AXIS, strValue);
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

    public final boolean isFKCOLORNull() {
        return this.IsParamNull(TAG_FKCOLOR);
    }

    public final String getFKCOLOR() {
        return this.GetParamStringValue(TAG_FKCOLOR, "");
    }

    public final void setFKCOLOR(String strValue) {
        this.SetParamValue(TAG_FKCOLOR, strValue);
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

    public final boolean isLAYOUTFONTIDNull() {
        return this.IsParamNull(TAG_LAYOUTFONTID);
    }

    public final String getLAYOUTFONTID() {
        return this.GetParamStringValue(TAG_LAYOUTFONTID, "");
    }

    public final void setLAYOUTFONTID(String strValue) {
        this.SetParamValue(TAG_LAYOUTFONTID, strValue);
    }

    public final boolean isLAYOUTFONTNAMENull() {
        return this.IsParamNull(TAG_LAYOUTFONTNAME);
    }

    public final String getLAYOUTFONTNAME() {
        return this.GetParamStringValue(TAG_LAYOUTFONTNAME, "");
    }

    public final void setLAYOUTFONTNAME(String strValue) {
        this.SetParamValue(TAG_LAYOUTFONTNAME, strValue);
    }

    public final boolean isLAYOUTFONTID2Null() {
        return this.IsParamNull(TAG_LAYOUTFONTID2);
    }

    public final String getLAYOUTFONTID2() {
        return this.GetParamStringValue(TAG_LAYOUTFONTID2, "");
    }

    public final void setLAYOUTFONTID2(String strValue) {
        this.SetParamValue(TAG_LAYOUTFONTID2, strValue);
    }

    public final boolean isLAYOUTFONTNAME2Null() {
        return this.IsParamNull(TAG_LAYOUTFONTNAME2);
    }

    public final String getLAYOUTFONTNAME2() {
        return this.GetParamStringValue(TAG_LAYOUTFONTNAME2, "");
    }

    public final void setLAYOUTFONTNAME2(String strValue) {
        this.SetParamValue(TAG_LAYOUTFONTNAME2, strValue);
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
}

