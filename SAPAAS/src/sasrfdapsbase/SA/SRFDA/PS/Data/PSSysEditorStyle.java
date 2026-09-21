/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysEditorStyle
extends BaseDataEntity {
    public static final String LINKVIEWSHOWMODE_NORMAL = "NORMAL";
    public static final String LINKVIEWSHOWMODE_MODAL = "MODAL";
    public static final String LINKVIEWSHOWMODE_EMBEDDED = "EMBEDDED";
    public static final String TAG_PSSYSEDITORSTYLEID = "PSSYSEDITORSTYLEID";
    public static final String TAG_PSSYSEDITORSTYLENAME = "PSSYSEDITORSTYLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSEDITORTYPEID = "PSEDITORTYPEID";
    public static final String TAG_PSEDITORTYPENAME = "PSEDITORTYPENAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_REPDEFAULT = "REPDEFAULT";
    public static final String TAG_PSEDITORSTYLEID = "PSEDITORSTYLEID";
    public static final String TAG_PSEDITORSTYLENAME = "PSEDITORSTYLENAME";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_CTRLPARAM = "CTRLPARAM";
    public static final String TAG_CTRLPARAM10 = "CTRLPARAM10";
    public static final String TAG_CTRLPARAM11 = "CTRLPARAM11";
    public static final String TAG_CTRLPARAM12 = "CTRLPARAM12";
    public static final String TAG_CTRLPARAM2 = "CTRLPARAM2";
    public static final String TAG_CTRLPARAM3 = "CTRLPARAM3";
    public static final String TAG_CTRLPARAM4 = "CTRLPARAM4";
    public static final String TAG_CTRLPARAM5 = "CTRLPARAM5";
    public static final String TAG_CTRLPARAM6 = "CTRLPARAM6";
    public static final String TAG_CTRLPARAM7 = "CTRLPARAM7";
    public static final String TAG_CTRLPARAM8 = "CTRLPARAM8";
    public static final String TAG_CTRLPARAM9 = "CTRLPARAM9";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_CTRLPARAMS = "CTRLPARAMS";
    public static final String TAG_AJAXHANDLER = "AJAXHANDLER";
    public static final String TAG_PSACHANDLERID = "PSACHANDLERID";
    public static final String TAG_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String TAG_REFVIEWSHOWMODE = "REFVIEWSHOWMODE";
    public static final String TAG_LINKVIEWSHOWMODE = "LINKVIEWSHOWMODE";
    public static final String TAG_CONTAINERTYPE = "CONTAINERTYPE";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_EXTENDSTYLEONLY = "EXTENDSTYLEONLY";

    public final boolean isPSSYSEDITORSTYLEIDNull() {
        return this.IsParamNull(TAG_PSSYSEDITORSTYLEID);
    }

    public final String getPSSYSEDITORSTYLEID() {
        return this.GetParamStringValue(TAG_PSSYSEDITORSTYLEID, "");
    }

    public final void setPSSYSEDITORSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSSYSEDITORSTYLEID, strValue);
    }

    public final boolean isPSSYSEDITORSTYLENAMENull() {
        return this.IsParamNull(TAG_PSSYSEDITORSTYLENAME);
    }

    public final String getPSSYSEDITORSTYLENAME() {
        return this.GetParamStringValue(TAG_PSSYSEDITORSTYLENAME, "");
    }

    public final void setPSSYSEDITORSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSEDITORSTYLENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPSEDITORTYPEIDNull() {
        return this.IsParamNull(TAG_PSEDITORTYPEID);
    }

    public final String getPSEDITORTYPEID() {
        return this.GetParamStringValue(TAG_PSEDITORTYPEID, "");
    }

    public final void setPSEDITORTYPEID(String strValue) {
        this.SetParamValue(TAG_PSEDITORTYPEID, strValue);
    }

    public final boolean isPSEDITORTYPENAMENull() {
        return this.IsParamNull(TAG_PSEDITORTYPENAME);
    }

    public final String getPSEDITORTYPENAME() {
        return this.GetParamStringValue(TAG_PSEDITORTYPENAME, "");
    }

    public final void setPSEDITORTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSEDITORTYPENAME, strValue);
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

    public final boolean isREPDEFAULTNull() {
        return this.IsParamNull(TAG_REPDEFAULT);
    }

    public final boolean getREPDEFAULT() {
        return this.GetParamIntValue(TAG_REPDEFAULT, 0) == 1;
    }

    public final void setREPDEFAULT(boolean bValue) {
        this.SetParamValue(TAG_REPDEFAULT, bValue ? 1 : 0);
    }

    public final boolean isPSEDITORSTYLEIDNull() {
        return this.IsParamNull(TAG_PSEDITORSTYLEID);
    }

    public final String getPSEDITORSTYLEID() {
        return this.GetParamStringValue(TAG_PSEDITORSTYLEID, "");
    }

    public final void setPSEDITORSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSEDITORSTYLEID, strValue);
    }

    public final boolean isPSEDITORSTYLENAMENull() {
        return this.IsParamNull(TAG_PSEDITORSTYLENAME);
    }

    public final String getPSEDITORSTYLENAME() {
        return this.GetParamStringValue(TAG_PSEDITORSTYLENAME, "");
    }

    public final void setPSEDITORSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSEDITORSTYLENAME, strValue);
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

    public final boolean isCTRLPARAMNull() {
        return this.IsParamNull(TAG_CTRLPARAM);
    }

    public final String getCTRLPARAM() {
        return this.GetParamStringValue(TAG_CTRLPARAM, "");
    }

    public final void setCTRLPARAM(String strValue) {
        this.SetParamValue(TAG_CTRLPARAM, strValue);
    }

    public final boolean isCTRLPARAM10Null() {
        return this.IsParamNull(TAG_CTRLPARAM10);
    }

    public final float getCTRLPARAM10() {
        return this.GetParamFloatValue(TAG_CTRLPARAM10, 0.0f);
    }

    public final void setCTRLPARAM10(float fValue) {
        this.SetParamValue(TAG_CTRLPARAM10, Float.valueOf(fValue));
    }

    public final boolean isCTRLPARAM11Null() {
        return this.IsParamNull(TAG_CTRLPARAM11);
    }

    public final int getCTRLPARAM11() {
        return this.GetParamIntValue(TAG_CTRLPARAM11, 0);
    }

    public final void setCTRLPARAM11(int nValue) {
        this.SetParamValue(TAG_CTRLPARAM11, nValue);
    }

    public final boolean isCTRLPARAM12Null() {
        return this.IsParamNull(TAG_CTRLPARAM12);
    }

    public final int getCTRLPARAM12() {
        return this.GetParamIntValue(TAG_CTRLPARAM12, 0);
    }

    public final void setCTRLPARAM12(int nValue) {
        this.SetParamValue(TAG_CTRLPARAM12, nValue);
    }

    public final boolean isCTRLPARAM2Null() {
        return this.IsParamNull(TAG_CTRLPARAM2);
    }

    public final String getCTRLPARAM2() {
        return this.GetParamStringValue(TAG_CTRLPARAM2, "");
    }

    public final void setCTRLPARAM2(String strValue) {
        this.SetParamValue(TAG_CTRLPARAM2, strValue);
    }

    public final boolean isCTRLPARAM3Null() {
        return this.IsParamNull(TAG_CTRLPARAM3);
    }

    public final String getCTRLPARAM3() {
        return this.GetParamStringValue(TAG_CTRLPARAM3, "");
    }

    public final void setCTRLPARAM3(String strValue) {
        this.SetParamValue(TAG_CTRLPARAM3, strValue);
    }

    public final boolean isCTRLPARAM4Null() {
        return this.IsParamNull(TAG_CTRLPARAM4);
    }

    public final String getCTRLPARAM4() {
        return this.GetParamStringValue(TAG_CTRLPARAM4, "");
    }

    public final void setCTRLPARAM4(String strValue) {
        this.SetParamValue(TAG_CTRLPARAM4, strValue);
    }

    public final boolean isCTRLPARAM5Null() {
        return this.IsParamNull(TAG_CTRLPARAM5);
    }

    public final boolean getCTRLPARAM5() {
        return this.GetParamIntValue(TAG_CTRLPARAM5, 0) == 1;
    }

    public final void setCTRLPARAM5(boolean bValue) {
        this.SetParamValue(TAG_CTRLPARAM5, bValue ? 1 : 0);
    }

    public final boolean isCTRLPARAM6Null() {
        return this.IsParamNull(TAG_CTRLPARAM6);
    }

    public final boolean getCTRLPARAM6() {
        return this.GetParamIntValue(TAG_CTRLPARAM6, 0) == 1;
    }

    public final void setCTRLPARAM6(boolean bValue) {
        this.SetParamValue(TAG_CTRLPARAM6, bValue ? 1 : 0);
    }

    public final boolean isCTRLPARAM7Null() {
        return this.IsParamNull(TAG_CTRLPARAM7);
    }

    public final int getCTRLPARAM7() {
        return this.GetParamIntValue(TAG_CTRLPARAM7, 0);
    }

    public final void setCTRLPARAM7(int nValue) {
        this.SetParamValue(TAG_CTRLPARAM7, nValue);
    }

    public final boolean isCTRLPARAM8Null() {
        return this.IsParamNull(TAG_CTRLPARAM8);
    }

    public final int getCTRLPARAM8() {
        return this.GetParamIntValue(TAG_CTRLPARAM8, 0);
    }

    public final void setCTRLPARAM8(int nValue) {
        this.SetParamValue(TAG_CTRLPARAM8, nValue);
    }

    public final boolean isCTRLPARAM9Null() {
        return this.IsParamNull(TAG_CTRLPARAM9);
    }

    public final float getCTRLPARAM9() {
        return this.GetParamFloatValue(TAG_CTRLPARAM9, 0.0f);
    }

    public final void setCTRLPARAM9(float fValue) {
        this.SetParamValue(TAG_CTRLPARAM9, Float.valueOf(fValue));
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isCTRLPARAMSNull() {
        return this.IsParamNull(TAG_CTRLPARAMS);
    }

    public final String getCTRLPARAMS() {
        return this.GetParamStringValue(TAG_CTRLPARAMS, "");
    }

    public final void setCTRLPARAMS(String strValue) {
        this.SetParamValue(TAG_CTRLPARAMS, strValue);
    }

    public final boolean isAJAXHANDLERNull() {
        return this.IsParamNull(TAG_AJAXHANDLER);
    }

    public final String getAJAXHANDLER() {
        return this.GetParamStringValue(TAG_AJAXHANDLER, "");
    }

    public final void setAJAXHANDLER(String strValue) {
        this.SetParamValue(TAG_AJAXHANDLER, strValue);
    }

    public final boolean isPSACHANDLERIDNull() {
        return this.IsParamNull(TAG_PSACHANDLERID);
    }

    public final String getPSACHANDLERID() {
        return this.GetParamStringValue(TAG_PSACHANDLERID, "");
    }

    public final void setPSACHANDLERID(String strValue) {
        this.SetParamValue(TAG_PSACHANDLERID, strValue);
    }

    public final boolean isPSACHANDLERNAMENull() {
        return this.IsParamNull(TAG_PSACHANDLERNAME);
    }

    public final String getPSACHANDLERNAME() {
        return this.GetParamStringValue(TAG_PSACHANDLERNAME, "");
    }

    public final void setPSACHANDLERNAME(String strValue) {
        this.SetParamValue(TAG_PSACHANDLERNAME, strValue);
    }

    public final boolean isREFVIEWSHOWMODENull() {
        return this.IsParamNull(TAG_REFVIEWSHOWMODE);
    }

    public final String getREFVIEWSHOWMODE() {
        return this.GetParamStringValue(TAG_REFVIEWSHOWMODE, "");
    }

    public final void setREFVIEWSHOWMODE(String strValue) {
        this.SetParamValue(TAG_REFVIEWSHOWMODE, strValue);
    }

    public final boolean isLINKVIEWSHOWMODENull() {
        return this.IsParamNull(TAG_LINKVIEWSHOWMODE);
    }

    public final String getLINKVIEWSHOWMODE() {
        return this.GetParamStringValue(TAG_LINKVIEWSHOWMODE, "");
    }

    public final void setLINKVIEWSHOWMODE(String strValue) {
        this.SetParamValue(TAG_LINKVIEWSHOWMODE, strValue);
    }

    public final boolean isCONTAINERTYPENull() {
        return this.IsParamNull(TAG_CONTAINERTYPE);
    }

    public final String getCONTAINERTYPE() {
        return this.GetParamStringValue(TAG_CONTAINERTYPE, "");
    }

    public final void setCONTAINERTYPE(String strValue) {
        this.SetParamValue(TAG_CONTAINERTYPE, strValue);
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

    public final boolean isEXTENDSTYLEONLYNull() {
        return this.IsParamNull(TAG_EXTENDSTYLEONLY);
    }

    public final boolean getEXTENDSTYLEONLY() {
        return this.GetParamIntValue(TAG_EXTENDSTYLEONLY, 0) == 1;
    }

    public final void setEXTENDSTYLEONLY(boolean bValue) {
        this.SetParamValue(TAG_EXTENDSTYLEONLY, bValue ? 1 : 0);
    }
}

