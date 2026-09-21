/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMComplexRes
extends BaseDataEntity {
    public static final String TAG_TMCOMPLEXRESID = "TMCOMPLEXRESID";
    public static final String TAG_TMCOMPLEXRESNAME = "TMCOMPLEXRESNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TMRESBASETYPE = "TMRESBASETYPE";
    public static final String TAG_TMRESCENTERID = "TMRESCENTERID";
    public static final String TAG_TMRESCENTERNAME = "TMRESCENTERNAME";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_TMTIMERULEID = "TMTIMERULEID";
    public static final String TAG_TMTIMERULENAME = "TMTIMERULENAME";
    public static final String TAG_CAPACITY = "CAPACITY";
    public static final String TAG_CAPACITY2 = "CAPACITY2";
    public static final String TAG_CAPACITY3 = "CAPACITY3";
    public static final String TAG_CAPACITY4 = "CAPACITY4";
    public static final String TAG_TMRESTYPEID = "TMRESTYPEID";
    public static final String TAG_TMRESTYPENAME = "TMRESTYPENAME";
    public static final String TAG_ICONPATH = "ICONPATH";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_LOGICRESTYPE = "LOGICRESTYPE";

    public boolean isTMCOMPLEXRESIDNull() {
        return this.IsParamNull(TAG_TMCOMPLEXRESID);
    }

    public String getTMCOMPLEXRESID() {
        return this.GetParamStringValue(TAG_TMCOMPLEXRESID, "");
    }

    public void setTMCOMPLEXRESID(String strValue) {
        this.SetParamValue(TAG_TMCOMPLEXRESID, strValue);
    }

    public boolean isTMCOMPLEXRESNAMENull() {
        return this.IsParamNull(TAG_TMCOMPLEXRESNAME);
    }

    public String getTMCOMPLEXRESNAME() {
        return this.GetParamStringValue(TAG_TMCOMPLEXRESNAME, "");
    }

    public void setTMCOMPLEXRESNAME(String strValue) {
        this.SetParamValue(TAG_TMCOMPLEXRESNAME, strValue);
    }

    public boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public boolean isTMRESBASETYPENull() {
        return this.IsParamNull(TAG_TMRESBASETYPE);
    }

    public String getTMRESBASETYPE() {
        return this.GetParamStringValue(TAG_TMRESBASETYPE, "");
    }

    public void setTMRESBASETYPE(String strValue) {
        this.SetParamValue(TAG_TMRESBASETYPE, strValue);
    }

    public boolean isTMRESCENTERIDNull() {
        return this.IsParamNull(TAG_TMRESCENTERID);
    }

    public String getTMRESCENTERID() {
        return this.GetParamStringValue(TAG_TMRESCENTERID, "");
    }

    public void setTMRESCENTERID(String strValue) {
        this.SetParamValue(TAG_TMRESCENTERID, strValue);
    }

    public boolean isTMRESCENTERNAMENull() {
        return this.IsParamNull(TAG_TMRESCENTERNAME);
    }

    public String getTMRESCENTERNAME() {
        return this.GetParamStringValue(TAG_TMRESCENTERNAME, "");
    }

    public void setTMRESCENTERNAME(String strValue) {
        this.SetParamValue(TAG_TMRESCENTERNAME, strValue);
    }

    public boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public boolean isTMTIMERULEIDNull() {
        return this.IsParamNull(TAG_TMTIMERULEID);
    }

    public String getTMTIMERULEID() {
        return this.GetParamStringValue(TAG_TMTIMERULEID, "");
    }

    public void setTMTIMERULEID(String strValue) {
        this.SetParamValue(TAG_TMTIMERULEID, strValue);
    }

    public boolean isTMTIMERULENAMENull() {
        return this.IsParamNull(TAG_TMTIMERULENAME);
    }

    public String getTMTIMERULENAME() {
        return this.GetParamStringValue(TAG_TMTIMERULENAME, "");
    }

    public void setTMTIMERULENAME(String strValue) {
        this.SetParamValue(TAG_TMTIMERULENAME, strValue);
    }

    public boolean isCAPACITYNull() {
        return this.IsParamNull(TAG_CAPACITY);
    }

    public float getCAPACITY() {
        return this.GetParamFloatValue(TAG_CAPACITY, 0.0f);
    }

    public void setCAPACITY(float strValue) {
        this.SetParamValue(TAG_CAPACITY, Float.valueOf(strValue));
    }

    public boolean isCAPACITY2Null() {
        return this.IsParamNull(TAG_CAPACITY2);
    }

    public float getCAPACITY2() {
        return this.GetParamFloatValue(TAG_CAPACITY2, 0.0f);
    }

    public void setCAPACITY2(float strValue) {
        this.SetParamValue(TAG_CAPACITY2, Float.valueOf(strValue));
    }

    public boolean isCAPACITY3Null() {
        return this.IsParamNull(TAG_CAPACITY3);
    }

    public int getCAPACITY3() {
        return this.GetParamIntValue(TAG_CAPACITY3, 0);
    }

    public void setCAPACITY3(int strValue) {
        this.SetParamValue(TAG_CAPACITY3, strValue);
    }

    public boolean isCAPACITY4Null() {
        return this.IsParamNull(TAG_CAPACITY4);
    }

    public int getCAPACITY4() {
        return this.GetParamIntValue(TAG_CAPACITY4, 0);
    }

    public void setCAPACITY4(int strValue) {
        this.SetParamValue(TAG_CAPACITY4, strValue);
    }

    public boolean isTMRESTYPEIDNull() {
        return this.IsParamNull(TAG_TMRESTYPEID);
    }

    public String getTMRESTYPEID() {
        return this.GetParamStringValue(TAG_TMRESTYPEID, "");
    }

    public void setTMRESTYPEID(String strValue) {
        this.SetParamValue(TAG_TMRESTYPEID, strValue);
    }

    public boolean isTMRESTYPENAMENull() {
        return this.IsParamNull(TAG_TMRESTYPENAME);
    }

    public String getTMRESTYPENAME() {
        return this.GetParamStringValue(TAG_TMRESTYPENAME, "");
    }

    public void setTMRESTYPENAME(String strValue) {
        this.SetParamValue(TAG_TMRESTYPENAME, strValue);
    }

    public boolean isICONPATHNull() {
        return this.IsParamNull(TAG_ICONPATH);
    }

    public String getICONPATH() {
        return this.GetParamStringValue(TAG_ICONPATH, "");
    }

    public void setICONPATH(String strValue) {
        this.SetParamValue(TAG_ICONPATH, strValue);
    }

    public boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public boolean isLOGICRESTYPENull() {
        return this.IsParamNull(TAG_LOGICRESTYPE);
    }

    public String getLOGICRESTYPE() {
        return this.GetParamStringValue(TAG_LOGICRESTYPE, "");
    }

    public void setLOGICRESTYPE(String strValue) {
        this.SetParamValue(TAG_LOGICRESTYPE, strValue);
    }
}

