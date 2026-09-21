/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.ArrayList;
import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSCodeItem
extends BaseDataEntity {
    public static final String TAG_PSCODEITEMID = "PSCODEITEMID";
    public static final String TAG_PSCODEITEMNAME = "PSCODEITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_PPSCODEITEMID = "PPSCODEITEMID";
    public static final String TAG_PPSCODEITEMNAME = "PPSCODEITEMNAME";
    public static final String TAG_CODEITEMVALUE = "CODEITEMVALUE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_LEVELTAG = "LEVELTAG";
    public static final String TAG_LEVELVALUE = "LEVELVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_COLOR = "COLOR";
    public static final String TAG_ICONCLS = "ICONCLS";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_SHORTKEY = "SHORTKEY";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_USERDATA2 = "USERDATA2";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_DISABLESELECT = "DISABLESELECT";
    public static final String TAG_TEXTPSLANRESID = "TEXTPSLANRESID";
    public static final String TAG_TEXTPSLANRESNAME = "TEXTPSLANRESNAME";
    public static final String TAG_SHOWASEMPTY = "SHOWASEMPTY";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    private ArrayList<PSCodeItem> childPSCodeItemList = null;

    public final boolean isPSCODEITEMIDNull() {
        return this.isParamNull(TAG_PSCODEITEMID);
    }

    public final String getPSCODEITEMID() {
        return this.getParamStringValue(TAG_PSCODEITEMID, "");
    }

    public final void setPSCODEITEMID(String strValue) {
        this.setParamValue(TAG_PSCODEITEMID, strValue);
    }

    public final boolean isPSCODEITEMNAMENull() {
        return this.isParamNull(TAG_PSCODEITEMNAME);
    }

    public final String getPSCODEITEMNAME() {
        return this.getParamStringValue(TAG_PSCODEITEMNAME, "");
    }

    public final void setPSCODEITEMNAME(String strValue) {
        this.setParamValue(TAG_PSCODEITEMNAME, strValue);
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

    public final boolean isPPSCODEITEMIDNull() {
        return this.isParamNull(TAG_PPSCODEITEMID);
    }

    public final String getPPSCODEITEMID() {
        return this.getParamStringValue(TAG_PPSCODEITEMID, "");
    }

    public final void setPPSCODEITEMID(String strValue) {
        this.setParamValue(TAG_PPSCODEITEMID, strValue);
    }

    public final boolean isPPSCODEITEMNAMENull() {
        return this.isParamNull(TAG_PPSCODEITEMNAME);
    }

    public final String getPPSCODEITEMNAME() {
        return this.getParamStringValue(TAG_PPSCODEITEMNAME, "");
    }

    public final void setPPSCODEITEMNAME(String strValue) {
        this.setParamValue(TAG_PPSCODEITEMNAME, strValue);
    }

    public final boolean isCODEITEMVALUENull() {
        return this.isParamNull(TAG_CODEITEMVALUE);
    }

    public final String getCODEITEMVALUE() {
        return this.getParamStringValue(TAG_CODEITEMVALUE, "");
    }

    public final void setCODEITEMVALUE(String strValue) {
        this.setParamValue(TAG_CODEITEMVALUE, strValue);
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

    public final boolean isLEVELTAGNull() {
        return this.isParamNull(TAG_LEVELTAG);
    }

    public final String getLEVELTAG() {
        return this.getParamStringValue(TAG_LEVELTAG, "");
    }

    public final void setLEVELTAG(String strValue) {
        this.setParamValue(TAG_LEVELTAG, strValue);
    }

    public final boolean isLEVELVALUENull() {
        return this.isParamNull(TAG_LEVELVALUE);
    }

    public final int getLEVELVALUE() {
        return this.getParamIntValue(TAG_LEVELVALUE, 0);
    }

    public final void setLEVELVALUE(int nValue) {
        this.setParamValue(TAG_LEVELVALUE, nValue);
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

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isCOLORNull() {
        return this.isParamNull(TAG_COLOR);
    }

    public final String getCOLOR() {
        return this.getParamStringValue(TAG_COLOR, "");
    }

    public final void setCOLOR(String strValue) {
        this.setParamValue(TAG_COLOR, strValue);
    }

    public final boolean isICONCLSNull() {
        return this.isParamNull(TAG_ICONCLS);
    }

    public final String getICONCLS() {
        return this.getParamStringValue(TAG_ICONCLS, "");
    }

    public final void setICONCLS(String strValue) {
        this.setParamValue(TAG_ICONCLS, strValue);
    }

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

    public final boolean isSHORTKEYNull() {
        return this.isParamNull(TAG_SHORTKEY);
    }

    public final String getSHORTKEY() {
        return this.getParamStringValue(TAG_SHORTKEY, "");
    }

    public final void setSHORTKEY(String strValue) {
        this.setParamValue(TAG_SHORTKEY, strValue);
    }

    public final boolean isPSSYSIMAGEIDNull() {
        return this.isParamNull(TAG_PSSYSIMAGEID);
    }

    public final String getPSSYSIMAGEID() {
        return this.getParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.setParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.isParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.getParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.setParamValue(TAG_PSSYSIMAGENAME, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.isParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.getParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.setParamValue(TAG_USERDATA2, strValue);
    }

    public final boolean isUSERDATANull() {
        return this.isParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.getParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.setParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isDISABLESELECTNull() {
        return this.isParamNull(TAG_DISABLESELECT);
    }

    public final boolean getDISABLESELECT() {
        return this.getParamIntValue(TAG_DISABLESELECT, 0) == 1;
    }

    public final void setDISABLESELECT(boolean bValue) {
        this.setParamValue(TAG_DISABLESELECT, bValue ? 1 : 0);
    }

    public final boolean isTEXTPSLANRESIDNull() {
        return this.isParamNull(TAG_TEXTPSLANRESID);
    }

    public final String getTEXTPSLANRESID() {
        return this.getParamStringValue(TAG_TEXTPSLANRESID, "");
    }

    public final void setTEXTPSLANRESID(String strValue) {
        this.setParamValue(TAG_TEXTPSLANRESID, strValue);
    }

    public final boolean isTEXTPSLANRESNAMENull() {
        return this.isParamNull(TAG_TEXTPSLANRESNAME);
    }

    public final String getTEXTPSLANRESNAME() {
        return this.getParamStringValue(TAG_TEXTPSLANRESNAME, "");
    }

    public final void setTEXTPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_TEXTPSLANRESNAME, strValue);
    }

    public final boolean isSHOWASEMPTYNull() {
        return this.isParamNull(TAG_SHOWASEMPTY);
    }

    public final boolean getSHOWASEMPTY() {
        return this.getParamIntValue(TAG_SHOWASEMPTY, 0) == 1;
    }

    public final void setSHOWASEMPTY(boolean bValue) {
        this.setParamValue(TAG_SHOWASEMPTY, bValue ? 1 : 0);
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

    public ArrayList<PSCodeItem> getChildPSCodeItems(boolean bCreated) {
        if (this.childPSCodeItemList != null) {
            return this.childPSCodeItemList;
        }
        if (bCreated) {
            this.childPSCodeItemList = new ArrayList();
        }
        return this.childPSCodeItemList;
    }

    public void resetChildDatas() {
        if (this.childPSCodeItemList != null) {
            this.childPSCodeItemList.clear();
            this.childPSCodeItemList = null;
        }
    }
}

