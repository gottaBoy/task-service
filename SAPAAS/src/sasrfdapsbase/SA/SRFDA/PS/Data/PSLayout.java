/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class PSLayout
extends BaseDataEntity {
    public static final String LAYOUTMODE_AUTOTABLE = "AUTOTABLE";
    public static final String LAYOUTMODE_TABLE = "TABLE";
    public static final String LAYOUTMODE_TABLE_12COL = "TABLE_12COL";
    public static final String LAYOUTMODE_TABLE_24COL = "TABLE_24COL";
    public static final String LAYOUTMODE_BORDER = "BORDER";
    public static final String BL_POS_NORTH = "NORTH";
    public static final String BL_POS_WEST = "WEST";
    public static final String BL_POS_EAST = "EAST";
    public static final String BL_POS_SOUTH = "SOUTH";
    public static final String BL_POS_CENTER = "CENTER";
    public static final String DETAILSTYLE_DEFAULT = "DEFAULT";
    public static final String DETAILSTYLE_STYLE2 = "STYLE2";
    public static final String DETAILSTYLE_STYLE3 = "STYLE3";
    public static final String DETAILSTYLE_STYLE4 = "STYLE4";
    public static final String TAG_LEFTPOS = "LEFTPOS";
    public static final String TAG_TOPPOS = "TOPPOS";
    public static final String TAG_RIGHTPOS = "RIGHTPOS";
    public static final String TAG_BOTTOMPOS = "BOTTOMPOS";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_LAYOUTMODE = "LAYOUTMODE";
    public static final String TAG_CAPTIONPOS = "CAPTIONPOS";
    public static final String TAG_BL_POS = "BL_POS";
    public static final String TAG_COL_WIDTH = "COL_WIDTH";
    public static final String TAG_CHILD_COL_LG = "CHILD_COL_LG";
    public static final String TAG_CHILD_COL_MD = "CHILD_COL_MD";
    public static final String TAG_CHILD_COL_SM = "CHILD_COL_SM";
    public static final String TAG_CHILD_COL_XS = "CHILD_COL_XS";
    public static final String TAG_COL_MD_OS = "COL_MD_OS";
    public static final String TAG_COL_SM_OS = "COL_SM_OS";
    public static final String TAG_COL_XS_OS = "COL_XS_OS";
    public static final String TAG_COL_LG_OS = "COL_LG_OS";
    public static final String TAG_COL_LG = "COL_LG";
    public static final String TAG_COL_MD = "COL_MD";
    public static final String TAG_COL_SM = "COL_SM";
    public static final String TAG_COL_XS = "COL_XS";
    public static final String TAG_COLMODEL = "COLMODEL";
    public static final String TAG_ROWSPAN = "ROWSPAN";
    public static final String TAG_COLSPAN = "COLSPAN";
    public static final String TAG_COLID = "COLID";
    public static final String TAG_FLEXDIR = "FLEXDIR";
    public static final String TAG_FLEXALIGN = "FLEXALIGN";
    public static final String TAG_FLEXVALIGN = "FLEXVALIGN";
    public static final String TAG_FLEXGROW = "FLEXGROW";
    public static final String TAG_AL_POS = "AL_POS";
    public static final String TAG_SPACINGTOP = "SPACINGTOP";
    public static final String TAG_SPACINGBOTTOM = "SPACINGBOTTOM";
    public static final String TAG_SPACINGLEFT = "SPACINGLEFT";
    public static final String TAG_SPACINGRIGHT = "SPACINGRIGHT";
    public static final String TAG_VALIGNSELF = "VALIGNSELF";
    public static final String TAG_HALIGNSELF = "HALIGNSELF";
    public static final String TAG_HEIGHTMODE = "HEIGHTMODE";
    public static final String TAG_WIDTHMODE = "WIDTHMODE";
    public static final String TAG_FLEXSHRINK = "FLEXSHRINK";
    public static final String TAG_FLEXBASIS = "FLEXBASIS";

    public final boolean isLEFTPOSNull() {
        return this.IsParamNull(TAG_LEFTPOS);
    }

    public final int getLEFTPOS() {
        return this.GetParamIntValue(TAG_LEFTPOS, 0);
    }

    public final void setLEFTPOS(int nValue) {
        this.SetParamValue(TAG_LEFTPOS, nValue);
    }

    public final boolean isTOPPOSNull() {
        return this.IsParamNull(TAG_TOPPOS);
    }

    public final int getTOPPOS() {
        return this.GetParamIntValue(TAG_TOPPOS, 0);
    }

    public final void setTOPPOS(int nValue) {
        this.SetParamValue(TAG_TOPPOS, nValue);
    }

    public final boolean isRIGHTPOSNull() {
        return this.IsParamNull(TAG_RIGHTPOS);
    }

    public final int getRIGHTPOS() {
        return this.GetParamIntValue(TAG_RIGHTPOS, 0);
    }

    public final void setRIGHTPOS(int nValue) {
        this.SetParamValue(TAG_RIGHTPOS, nValue);
    }

    public final boolean isBOTTOMPOSNull() {
        return this.IsParamNull(TAG_BOTTOMPOS);
    }

    public final int getBOTTOMPOS() {
        return this.GetParamIntValue(TAG_BOTTOMPOS, 0);
    }

    public final void setBOTTOMPOS(int nValue) {
        this.SetParamValue(TAG_BOTTOMPOS, nValue);
    }

    public final boolean isWIDTHNull() {
        return this.IsParamNull(TAG_WIDTH);
    }

    public final int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public final void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
    }

    public final boolean isHEIGHTNull() {
        return this.IsParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
    }

    public final boolean isLAYOUTMODENull() {
        return this.IsParamNull(TAG_LAYOUTMODE);
    }

    public final String getLAYOUTMODE() {
        return this.GetParamStringValue(TAG_LAYOUTMODE, "");
    }

    public final void setLAYOUTMODE(String strValue) {
        this.SetParamValue(TAG_LAYOUTMODE, strValue);
    }

    public final boolean isCAPTIONPOSNull() {
        return this.IsParamNull(TAG_CAPTIONPOS);
    }

    public final String getCAPTIONPOS() {
        return this.GetParamStringValue(TAG_CAPTIONPOS, "");
    }

    public final void setCAPTIONPOS(String strValue) {
        this.SetParamValue(TAG_CAPTIONPOS, strValue);
    }

    public final boolean isBL_POSNull() {
        return this.IsParamNull(TAG_BL_POS);
    }

    public final String getBL_POS() {
        return this.GetParamStringValue(TAG_BL_POS, "");
    }

    public final void setBL_POS(String strValue) {
        this.SetParamValue(TAG_BL_POS, strValue);
    }

    public final boolean isCOL_WIDTHNull() {
        return this.IsParamNull(TAG_COL_WIDTH);
    }

    public final int getCOL_WIDTH() {
        return this.GetParamIntValue(TAG_COL_WIDTH, 0);
    }

    public final void setCOL_WIDTH(int nValue) {
        this.SetParamValue(TAG_COL_WIDTH, nValue);
    }

    public final boolean isCHILD_COL_LGNull() {
        return this.IsParamNull(TAG_CHILD_COL_LG);
    }

    public final int getCHILD_COL_LG() {
        return this.GetParamIntValue(TAG_CHILD_COL_LG, 0);
    }

    public final void setCHILD_COL_LG(int nValue) {
        this.SetParamValue(TAG_CHILD_COL_LG, nValue);
    }

    public final boolean isCHILD_COL_MDNull() {
        return this.IsParamNull(TAG_CHILD_COL_MD);
    }

    public final int getCHILD_COL_MD() {
        return this.GetParamIntValue(TAG_CHILD_COL_MD, 0);
    }

    public final void setCHILD_COL_MD(int nValue) {
        this.SetParamValue(TAG_CHILD_COL_MD, nValue);
    }

    public final boolean isCHILD_COL_SMNull() {
        return this.IsParamNull(TAG_CHILD_COL_SM);
    }

    public final int getCHILD_COL_SM() {
        return this.GetParamIntValue(TAG_CHILD_COL_SM, 0);
    }

    public final void setCHILD_COL_SM(int nValue) {
        this.SetParamValue(TAG_CHILD_COL_SM, nValue);
    }

    public final boolean isCHILD_COL_XSNull() {
        return this.IsParamNull(TAG_CHILD_COL_XS);
    }

    public final int getCHILD_COL_XS() {
        return this.GetParamIntValue(TAG_CHILD_COL_XS, 0);
    }

    public final void setCHILD_COL_XS(int nValue) {
        this.SetParamValue(TAG_CHILD_COL_XS, nValue);
    }

    public final boolean isCOL_MD_OSNull() {
        return this.IsParamNull(TAG_COL_MD_OS);
    }

    public final int getCOL_MD_OS() {
        return this.GetParamIntValue(TAG_COL_MD_OS, 0);
    }

    public final void setCOL_MD_OS(int nValue) {
        this.SetParamValue(TAG_COL_MD_OS, nValue);
    }

    public final boolean isCOL_SM_OSNull() {
        return this.IsParamNull(TAG_COL_SM_OS);
    }

    public final int getCOL_SM_OS() {
        return this.GetParamIntValue(TAG_COL_SM_OS, 0);
    }

    public final void setCOL_SM_OS(int nValue) {
        this.SetParamValue(TAG_COL_SM_OS, nValue);
    }

    public final boolean isCOL_XS_OSNull() {
        return this.IsParamNull(TAG_COL_XS_OS);
    }

    public final int getCOL_XS_OS() {
        return this.GetParamIntValue(TAG_COL_XS_OS, 0);
    }

    public final void setCOL_XS_OS(int nValue) {
        this.SetParamValue(TAG_COL_XS_OS, nValue);
    }

    public final boolean isCOL_LG_OSNull() {
        return this.IsParamNull(TAG_COL_LG_OS);
    }

    public final int getCOL_LG_OS() {
        return this.GetParamIntValue(TAG_COL_LG_OS, 0);
    }

    public final void setCOL_LG_OS(int nValue) {
        this.SetParamValue(TAG_COL_LG_OS, nValue);
    }

    public final boolean isCOL_LGNull() {
        return this.IsParamNull(TAG_COL_LG);
    }

    public final int getCOL_LG() {
        return this.GetParamIntValue(TAG_COL_LG, 0);
    }

    public final void setCOL_LG(int nValue) {
        this.SetParamValue(TAG_COL_LG, nValue);
    }

    public final boolean isCOL_MDNull() {
        return this.IsParamNull(TAG_COL_MD);
    }

    public final int getCOL_MD() {
        return this.GetParamIntValue(TAG_COL_MD, 0);
    }

    public final void setCOL_MD(int nValue) {
        this.SetParamValue(TAG_COL_MD, nValue);
    }

    public final boolean isCOL_SMNull() {
        return this.IsParamNull(TAG_COL_SM);
    }

    public final int getCOL_SM() {
        return this.GetParamIntValue(TAG_COL_SM, 0);
    }

    public final void setCOL_SM(int nValue) {
        this.SetParamValue(TAG_COL_SM, nValue);
    }

    public final boolean isCOL_XSNull() {
        return this.IsParamNull(TAG_COL_XS);
    }

    public final int getCOL_XS() {
        return this.GetParamIntValue(TAG_COL_XS, 0);
    }

    public final void setCOL_XS(int nValue) {
        this.SetParamValue(TAG_COL_XS, nValue);
    }

    public final boolean isCOLMODELNull() {
        return this.IsParamNull(TAG_COLMODEL);
    }

    public final String getCOLMODEL() {
        return this.GetParamStringValue(TAG_COLMODEL, "");
    }

    public final void setCOLMODEL(String strValue) {
        this.SetParamValue(TAG_COLMODEL, strValue);
    }

    public final boolean isROWSPANNull() {
        return this.IsParamNull(TAG_ROWSPAN);
    }

    public final int getROWSPAN() {
        return this.GetParamIntValue(TAG_ROWSPAN, 0);
    }

    public final void setROWSPAN(int nValue) {
        this.SetParamValue(TAG_ROWSPAN, nValue);
    }

    public final boolean isCOLSPANNull() {
        return this.IsParamNull(TAG_COLSPAN);
    }

    public final int getCOLSPAN() {
        return this.GetParamIntValue(TAG_COLSPAN, 0);
    }

    public final void setCOLSPAN(int nValue) {
        this.SetParamValue(TAG_COLSPAN, nValue);
    }

    public final boolean isCOLIDNull() {
        return this.IsParamNull(TAG_COLID);
    }

    public final int getCOLID() {
        return this.GetParamIntValue(TAG_COLID, 0);
    }

    public final void setCOLID(int nValue) {
        this.SetParamValue(TAG_COLID, nValue);
    }

    public final boolean isFLEXDIRNull() {
        return this.IsParamNull(TAG_FLEXDIR);
    }

    public final String getFLEXDIR() {
        return this.GetParamStringValue(TAG_FLEXDIR, "");
    }

    public final void setFLEXDIR(String strValue) {
        this.SetParamValue(TAG_FLEXDIR, strValue);
    }

    public final boolean isFLEXALIGNNull() {
        return this.IsParamNull(TAG_FLEXALIGN);
    }

    public final String getFLEXALIGN() {
        return this.GetParamStringValue(TAG_FLEXALIGN, "");
    }

    public final void setFLEXALIGN(String strValue) {
        this.SetParamValue(TAG_FLEXALIGN, strValue);
    }

    public final boolean isFLEXVALIGNNull() {
        return this.IsParamNull(TAG_FLEXVALIGN);
    }

    public final String getFLEXVALIGN() {
        return this.GetParamStringValue(TAG_FLEXVALIGN, "");
    }

    public final void setFLEXVALIGN(String strValue) {
        this.SetParamValue(TAG_FLEXVALIGN, strValue);
    }

    public final boolean isFLEXGROWNull() {
        return this.IsParamNull(TAG_FLEXGROW);
    }

    public final int getFLEXGROW() {
        return this.GetParamIntValue(TAG_FLEXGROW, 0);
    }

    public final void setFLEXGROW(int nValue) {
        this.SetParamValue(TAG_FLEXGROW, nValue);
    }

    public final boolean isAL_POSNull() {
        return this.IsParamNull(TAG_AL_POS);
    }

    public final String getAL_POS() {
        return this.GetParamStringValue(TAG_AL_POS, "");
    }

    public final void setAL_POS(String strValue) {
        this.SetParamValue(TAG_AL_POS, strValue);
    }

    public final boolean isSPACINGTOPNull() {
        return this.IsParamNull(TAG_SPACINGTOP);
    }

    public final String getSPACINGTOP() {
        return this.GetParamStringValue(TAG_SPACINGTOP, "");
    }

    public final void setSPACINGTOP(String strValue) {
        this.SetParamValue(TAG_SPACINGTOP, strValue);
    }

    public final boolean isSPACINGBOTTOMNull() {
        return this.IsParamNull(TAG_SPACINGBOTTOM);
    }

    public final String getSPACINGBOTTOM() {
        return this.GetParamStringValue(TAG_SPACINGBOTTOM, "");
    }

    public final void setSPACINGBOTTOM(String strValue) {
        this.SetParamValue(TAG_SPACINGBOTTOM, strValue);
    }

    public final boolean isSPACINGLEFTNull() {
        return this.IsParamNull(TAG_SPACINGLEFT);
    }

    public final String getSPACINGLEFT() {
        return this.GetParamStringValue(TAG_SPACINGLEFT, "");
    }

    public final void setSPACINGLEFT(String strValue) {
        this.SetParamValue(TAG_SPACINGLEFT, strValue);
    }

    public final boolean isSPACINGRIGHTNull() {
        return this.IsParamNull(TAG_SPACINGRIGHT);
    }

    public final String getSPACINGRIGHT() {
        return this.GetParamStringValue(TAG_SPACINGRIGHT, "");
    }

    public final void setSPACINGRIGHT(String strValue) {
        this.SetParamValue(TAG_SPACINGRIGHT, strValue);
    }

    public final boolean isVALIGNSELFNull() {
        return this.IsParamNull(TAG_VALIGNSELF);
    }

    public final String getVALIGNSELF() {
        return this.GetParamStringValue(TAG_VALIGNSELF, "");
    }

    public final void setVALIGNSELF(String strValue) {
        this.SetParamValue(TAG_VALIGNSELF, strValue);
    }

    public final boolean isHALIGNSELFNull() {
        return this.IsParamNull(TAG_HALIGNSELF);
    }

    public final String getHALIGNSELF() {
        return this.GetParamStringValue(TAG_HALIGNSELF, "");
    }

    public final void setHALIGNSELF(String strValue) {
        this.SetParamValue(TAG_HALIGNSELF, strValue);
    }

    public final boolean isHEIGHTMODENull() {
        return this.IsParamNull(TAG_HEIGHTMODE);
    }

    public final String getHEIGHTMODE() {
        return this.GetParamStringValue(TAG_HEIGHTMODE, "");
    }

    public final void setHEIGHTMODE(String strValue) {
        this.SetParamValue(TAG_HEIGHTMODE, strValue);
    }

    public final boolean isWIDTHMODENull() {
        return this.IsParamNull(TAG_WIDTHMODE);
    }

    public final String getWIDTHMODE() {
        return this.GetParamStringValue(TAG_WIDTHMODE, "");
    }

    public final void setWIDTHMODE(String strValue) {
        this.SetParamValue(TAG_WIDTHMODE, strValue);
    }

    public final boolean isFLEXSHRINKNull() {
        return this.IsParamNull(TAG_FLEXSHRINK);
    }

    public final int getFLEXSHRINK() {
        return this.GetParamIntValue(TAG_FLEXSHRINK, 0);
    }

    public final void setFLEXSHRINK(int nValue) {
        this.SetParamValue(TAG_FLEXSHRINK, nValue);
    }

    public final boolean isFLEXBASISNull() {
        return this.IsParamNull(TAG_FLEXBASIS);
    }

    public final int getFLEXBASIS() {
        return this.GetParamIntValue(TAG_FLEXBASIS, 0);
    }

    public final void setFLEXBASIS(int nValue) {
        this.SetParamValue(TAG_FLEXBASIS, nValue);
    }
}

