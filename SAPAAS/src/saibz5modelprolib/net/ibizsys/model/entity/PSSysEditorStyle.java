/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

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

    public final boolean isPSSYSEDITORSTYLEIDNull() {
        return this.isParamNull(TAG_PSSYSEDITORSTYLEID);
    }

    public final String getPSSYSEDITORSTYLEID() {
        return this.getParamStringValue(TAG_PSSYSEDITORSTYLEID, "");
    }

    public final void setPSSYSEDITORSTYLEID(String strValue) {
        this.setParamValue(TAG_PSSYSEDITORSTYLEID, strValue);
    }

    public final boolean isPSSYSEDITORSTYLENAMENull() {
        return this.isParamNull(TAG_PSSYSEDITORSTYLENAME);
    }

    public final String getPSSYSEDITORSTYLENAME() {
        return this.getParamStringValue(TAG_PSSYSEDITORSTYLENAME, "");
    }

    public final void setPSSYSEDITORSTYLENAME(String strValue) {
        this.setParamValue(TAG_PSSYSEDITORSTYLENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPSEDITORTYPEIDNull() {
        return this.isParamNull(TAG_PSEDITORTYPEID);
    }

    public final String getPSEDITORTYPEID() {
        return this.getParamStringValue(TAG_PSEDITORTYPEID, "");
    }

    public final void setPSEDITORTYPEID(String strValue) {
        this.setParamValue(TAG_PSEDITORTYPEID, strValue);
    }

    public final boolean isPSEDITORTYPENAMENull() {
        return this.isParamNull(TAG_PSEDITORTYPENAME);
    }

    public final String getPSEDITORTYPENAME() {
        return this.getParamStringValue(TAG_PSEDITORTYPENAME, "");
    }

    public final void setPSEDITORTYPENAME(String strValue) {
        this.setParamValue(TAG_PSEDITORTYPENAME, strValue);
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

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.isParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.getParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.setParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.isParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.getParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.setParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isREPDEFAULTNull() {
        return this.isParamNull(TAG_REPDEFAULT);
    }

    public final boolean getREPDEFAULT() {
        return this.getParamIntValue(TAG_REPDEFAULT, 0) == 1;
    }

    public final void setREPDEFAULT(boolean bValue) {
        this.setParamValue(TAG_REPDEFAULT, bValue ? 1 : 0);
    }

    public final boolean isPSEDITORSTYLEIDNull() {
        return this.isParamNull(TAG_PSEDITORSTYLEID);
    }

    public final String getPSEDITORSTYLEID() {
        return this.getParamStringValue(TAG_PSEDITORSTYLEID, "");
    }

    public final void setPSEDITORSTYLEID(String strValue) {
        this.setParamValue(TAG_PSEDITORSTYLEID, strValue);
    }

    public final boolean isPSEDITORSTYLENAMENull() {
        return this.isParamNull(TAG_PSEDITORSTYLENAME);
    }

    public final String getPSEDITORSTYLENAME() {
        return this.getParamStringValue(TAG_PSEDITORSTYLENAME, "");
    }

    public final void setPSEDITORSTYLENAME(String strValue) {
        this.setParamValue(TAG_PSEDITORSTYLENAME, strValue);
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

    public final boolean isHEIGHTNull() {
        return this.isParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.getParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.setParamValue(TAG_HEIGHT, nValue);
    }

    public final boolean isCTRLPARAMNull() {
        return this.isParamNull(TAG_CTRLPARAM);
    }

    public final String getCTRLPARAM() {
        return this.getParamStringValue(TAG_CTRLPARAM, "");
    }

    public final void setCTRLPARAM(String strValue) {
        this.setParamValue(TAG_CTRLPARAM, strValue);
    }

    public final boolean isCTRLPARAM10Null() {
        return this.isParamNull(TAG_CTRLPARAM10);
    }

    public final float getCTRLPARAM10() {
        return this.getParamFloatValue(TAG_CTRLPARAM10, 0.0f);
    }

    public final void setCTRLPARAM10(float fValue) {
        this.setParamValue(TAG_CTRLPARAM10, Float.valueOf(fValue));
    }

    public final boolean isCTRLPARAM11Null() {
        return this.isParamNull(TAG_CTRLPARAM11);
    }

    public final int getCTRLPARAM11() {
        return this.getParamIntValue(TAG_CTRLPARAM11, 0);
    }

    public final void setCTRLPARAM11(int nValue) {
        this.setParamValue(TAG_CTRLPARAM11, nValue);
    }

    public final boolean isCTRLPARAM12Null() {
        return this.isParamNull(TAG_CTRLPARAM12);
    }

    public final int getCTRLPARAM12() {
        return this.getParamIntValue(TAG_CTRLPARAM12, 0);
    }

    public final void setCTRLPARAM12(int nValue) {
        this.setParamValue(TAG_CTRLPARAM12, nValue);
    }

    public final boolean isCTRLPARAM2Null() {
        return this.isParamNull(TAG_CTRLPARAM2);
    }

    public final String getCTRLPARAM2() {
        return this.getParamStringValue(TAG_CTRLPARAM2, "");
    }

    public final void setCTRLPARAM2(String strValue) {
        this.setParamValue(TAG_CTRLPARAM2, strValue);
    }

    public final boolean isCTRLPARAM3Null() {
        return this.isParamNull(TAG_CTRLPARAM3);
    }

    public final String getCTRLPARAM3() {
        return this.getParamStringValue(TAG_CTRLPARAM3, "");
    }

    public final void setCTRLPARAM3(String strValue) {
        this.setParamValue(TAG_CTRLPARAM3, strValue);
    }

    public final boolean isCTRLPARAM4Null() {
        return this.isParamNull(TAG_CTRLPARAM4);
    }

    public final String getCTRLPARAM4() {
        return this.getParamStringValue(TAG_CTRLPARAM4, "");
    }

    public final void setCTRLPARAM4(String strValue) {
        this.setParamValue(TAG_CTRLPARAM4, strValue);
    }

    public final boolean isCTRLPARAM5Null() {
        return this.isParamNull(TAG_CTRLPARAM5);
    }

    public final boolean getCTRLPARAM5() {
        return this.getParamIntValue(TAG_CTRLPARAM5, 0) == 1;
    }

    public final void setCTRLPARAM5(boolean bValue) {
        this.setParamValue(TAG_CTRLPARAM5, bValue ? 1 : 0);
    }

    public final boolean isCTRLPARAM6Null() {
        return this.isParamNull(TAG_CTRLPARAM6);
    }

    public final boolean getCTRLPARAM6() {
        return this.getParamIntValue(TAG_CTRLPARAM6, 0) == 1;
    }

    public final void setCTRLPARAM6(boolean bValue) {
        this.setParamValue(TAG_CTRLPARAM6, bValue ? 1 : 0);
    }

    public final boolean isCTRLPARAM7Null() {
        return this.isParamNull(TAG_CTRLPARAM7);
    }

    public final int getCTRLPARAM7() {
        return this.getParamIntValue(TAG_CTRLPARAM7, 0);
    }

    public final void setCTRLPARAM7(int nValue) {
        this.setParamValue(TAG_CTRLPARAM7, nValue);
    }

    public final boolean isCTRLPARAM8Null() {
        return this.isParamNull(TAG_CTRLPARAM8);
    }

    public final int getCTRLPARAM8() {
        return this.getParamIntValue(TAG_CTRLPARAM8, 0);
    }

    public final void setCTRLPARAM8(int nValue) {
        this.setParamValue(TAG_CTRLPARAM8, nValue);
    }

    public final boolean isCTRLPARAM9Null() {
        return this.isParamNull(TAG_CTRLPARAM9);
    }

    public final float getCTRLPARAM9() {
        return this.getParamFloatValue(TAG_CTRLPARAM9, 0.0f);
    }

    public final void setCTRLPARAM9(float fValue) {
        this.setParamValue(TAG_CTRLPARAM9, Float.valueOf(fValue));
    }

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isCTRLPARAMSNull() {
        return this.isParamNull(TAG_CTRLPARAMS);
    }

    public final String getCTRLPARAMS() {
        return this.getParamStringValue(TAG_CTRLPARAMS, "");
    }

    public final void setCTRLPARAMS(String strValue) {
        this.setParamValue(TAG_CTRLPARAMS, strValue);
    }

    public final boolean isAJAXHANDLERNull() {
        return this.isParamNull(TAG_AJAXHANDLER);
    }

    public final String getAJAXHANDLER() {
        return this.getParamStringValue(TAG_AJAXHANDLER, "");
    }

    public final void setAJAXHANDLER(String strValue) {
        this.setParamValue(TAG_AJAXHANDLER, strValue);
    }

    public final boolean isPSACHANDLERIDNull() {
        return this.isParamNull(TAG_PSACHANDLERID);
    }

    public final String getPSACHANDLERID() {
        return this.getParamStringValue(TAG_PSACHANDLERID, "");
    }

    public final void setPSACHANDLERID(String strValue) {
        this.setParamValue(TAG_PSACHANDLERID, strValue);
    }

    public final boolean isPSACHANDLERNAMENull() {
        return this.isParamNull(TAG_PSACHANDLERNAME);
    }

    public final String getPSACHANDLERNAME() {
        return this.getParamStringValue(TAG_PSACHANDLERNAME, "");
    }

    public final void setPSACHANDLERNAME(String strValue) {
        this.setParamValue(TAG_PSACHANDLERNAME, strValue);
    }

    public final boolean isREFVIEWSHOWMODENull() {
        return this.isParamNull(TAG_REFVIEWSHOWMODE);
    }

    public final String getREFVIEWSHOWMODE() {
        return this.getParamStringValue(TAG_REFVIEWSHOWMODE, "");
    }

    public final void setREFVIEWSHOWMODE(String strValue) {
        this.setParamValue(TAG_REFVIEWSHOWMODE, strValue);
    }

    public final boolean isLINKVIEWSHOWMODENull() {
        return this.isParamNull(TAG_LINKVIEWSHOWMODE);
    }

    public final String getLINKVIEWSHOWMODE() {
        return this.getParamStringValue(TAG_LINKVIEWSHOWMODE, "");
    }

    public final void setLINKVIEWSHOWMODE(String strValue) {
        this.setParamValue(TAG_LINKVIEWSHOWMODE, strValue);
    }
}

