/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

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
    public static final String TAG_DATA = "DATA";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String TAG_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String TAG_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String TAG_BKCOLOR = "BKCOLOR";
    public static final String TAG_BEGINVALUE = "BEGINVALUE";
    public static final String TAG_ENDVALUE = "ENDVALUE";
    public static final String TAG_INCBEGINVALUE = "INCBEGINVALUE";
    public static final String TAG_INCENDVALUE = "INCENDVALUE";
    public static final String TAG_THRESHOLDGROUPFLAG = "THRESHOLDGROUPFLAG";
    public static final String TAG_CSSCLASS = "CSSCLASS";
    private ArrayList<PSCodeItem> childPSCodeItemList = null;

    public final boolean isPSCODEITEMIDNull() {
        return this.IsParamNull(TAG_PSCODEITEMID);
    }

    public final String getPSCODEITEMID() {
        return this.GetParamStringValue(TAG_PSCODEITEMID, "");
    }

    public final void setPSCODEITEMID(String strValue) {
        this.SetParamValue(TAG_PSCODEITEMID, strValue);
    }

    public final boolean isPSCODEITEMNAMENull() {
        return this.IsParamNull(TAG_PSCODEITEMNAME);
    }

    public final String getPSCODEITEMNAME() {
        return this.GetParamStringValue(TAG_PSCODEITEMNAME, "");
    }

    public final void setPSCODEITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSCODEITEMNAME, strValue);
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

    public final boolean isPSCODELISTIDNull() {
        return this.IsParamNull(TAG_PSCODELISTID);
    }

    public final String getPSCODELISTID() {
        return this.GetParamStringValue(TAG_PSCODELISTID, "");
    }

    public final void setPSCODELISTID(String strValue) {
        this.SetParamValue(TAG_PSCODELISTID, strValue);
    }

    public final boolean isPSCODELISTNAMENull() {
        return this.IsParamNull(TAG_PSCODELISTNAME);
    }

    public final String getPSCODELISTNAME() {
        return this.GetParamStringValue(TAG_PSCODELISTNAME, "");
    }

    public final void setPSCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_PSCODELISTNAME, strValue);
    }

    public final boolean isPPSCODEITEMIDNull() {
        return this.IsParamNull(TAG_PPSCODEITEMID);
    }

    public final String getPPSCODEITEMID() {
        return this.GetParamStringValue(TAG_PPSCODEITEMID, "");
    }

    public final void setPPSCODEITEMID(String strValue) {
        this.SetParamValue(TAG_PPSCODEITEMID, strValue);
    }

    public final boolean isPPSCODEITEMNAMENull() {
        return this.IsParamNull(TAG_PPSCODEITEMNAME);
    }

    public final String getPPSCODEITEMNAME() {
        return this.GetParamStringValue(TAG_PPSCODEITEMNAME, "");
    }

    public final void setPPSCODEITEMNAME(String strValue) {
        this.SetParamValue(TAG_PPSCODEITEMNAME, strValue);
    }

    public final boolean isCODEITEMVALUENull() {
        return this.IsParamNull(TAG_CODEITEMVALUE);
    }

    public final String getCODEITEMVALUE() {
        return this.GetParamStringValue(TAG_CODEITEMVALUE, "");
    }

    public final void setCODEITEMVALUE(String strValue) {
        this.SetParamValue(TAG_CODEITEMVALUE, strValue);
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

    public final boolean isLEVELTAGNull() {
        return this.IsParamNull(TAG_LEVELTAG);
    }

    public final String getLEVELTAG() {
        return this.GetParamStringValue(TAG_LEVELTAG, "");
    }

    public final void setLEVELTAG(String strValue) {
        this.SetParamValue(TAG_LEVELTAG, strValue);
    }

    public final boolean isLEVELVALUENull() {
        return this.IsParamNull(TAG_LEVELVALUE);
    }

    public final int getLEVELVALUE() {
        return this.GetParamIntValue(TAG_LEVELVALUE, 0);
    }

    public final void setLEVELVALUE(int nValue) {
        this.SetParamValue(TAG_LEVELVALUE, nValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isCOLORNull() {
        return this.IsParamNull(TAG_COLOR);
    }

    public final String getCOLOR() {
        return this.GetParamStringValue(TAG_COLOR, "");
    }

    public final void setCOLOR(String strValue) {
        this.SetParamValue(TAG_COLOR, strValue);
    }

    public final boolean isICONCLSNull() {
        return this.IsParamNull(TAG_ICONCLS);
    }

    public final String getICONCLS() {
        return this.GetParamStringValue(TAG_ICONCLS, "");
    }

    public final void setICONCLS(String strValue) {
        this.SetParamValue(TAG_ICONCLS, strValue);
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

    public final boolean isSHORTKEYNull() {
        return this.IsParamNull(TAG_SHORTKEY);
    }

    public final String getSHORTKEY() {
        return this.GetParamStringValue(TAG_SHORTKEY, "");
    }

    public final void setSHORTKEY(String strValue) {
        this.SetParamValue(TAG_SHORTKEY, strValue);
    }

    public final boolean isPSSYSIMAGEIDNull() {
        return this.IsParamNull(TAG_PSSYSIMAGEID);
    }

    public final String getPSSYSIMAGEID() {
        return this.GetParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.IsParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.GetParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGENAME, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.IsParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.GetParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.SetParamValue(TAG_USERDATA2, strValue);
    }

    public final boolean isUSERDATANull() {
        return this.IsParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.GetParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.SetParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isDISABLESELECTNull() {
        return this.IsParamNull(TAG_DISABLESELECT);
    }

    public final boolean getDISABLESELECT() {
        return this.GetParamIntValue(TAG_DISABLESELECT, 0) == 1;
    }

    public final void setDISABLESELECT(boolean bValue) {
        this.SetParamValue(TAG_DISABLESELECT, bValue ? 1 : 0);
    }

    public final boolean isTEXTPSLANRESIDNull() {
        return this.IsParamNull(TAG_TEXTPSLANRESID);
    }

    public final String getTEXTPSLANRESID() {
        return this.GetParamStringValue(TAG_TEXTPSLANRESID, "");
    }

    public final void setTEXTPSLANRESID(String strValue) {
        this.SetParamValue(TAG_TEXTPSLANRESID, strValue);
    }

    public final boolean isTEXTPSLANRESNAMENull() {
        return this.IsParamNull(TAG_TEXTPSLANRESNAME);
    }

    public final String getTEXTPSLANRESNAME() {
        return this.GetParamStringValue(TAG_TEXTPSLANRESNAME, "");
    }

    public final void setTEXTPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_TEXTPSLANRESNAME, strValue);
    }

    public final boolean isSHOWASEMPTYNull() {
        return this.IsParamNull(TAG_SHOWASEMPTY);
    }

    public final boolean getSHOWASEMPTY() {
        return this.GetParamIntValue(TAG_SHOWASEMPTY, 0) == 1;
    }

    public final void setSHOWASEMPTY(boolean bValue) {
        this.SetParamValue(TAG_SHOWASEMPTY, bValue ? 1 : 0);
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

    public final boolean isDATANull() {
        return this.IsParamNull(TAG_DATA);
    }

    public final String getDATA() {
        return this.GetParamStringValue(TAG_DATA, "");
    }

    public final void setDATA(String strValue) {
        this.SetParamValue(TAG_DATA, strValue);
    }

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
    }

    public final boolean isTOOLTIPINFONull() {
        return this.IsParamNull(TAG_TOOLTIPINFO);
    }

    public final String getTOOLTIPINFO() {
        return this.GetParamStringValue(TAG_TOOLTIPINFO, "");
    }

    public final void setTOOLTIPINFO(String strValue) {
        this.SetParamValue(TAG_TOOLTIPINFO, strValue);
    }

    public final boolean isTIPPSLANRESIDNull() {
        return this.IsParamNull(TAG_TIPPSLANRESID);
    }

    public final String getTIPPSLANRESID() {
        return this.GetParamStringValue(TAG_TIPPSLANRESID, "");
    }

    public final void setTIPPSLANRESID(String strValue) {
        this.SetParamValue(TAG_TIPPSLANRESID, strValue);
    }

    public final boolean isTIPPSLANRESNAMENull() {
        return this.IsParamNull(TAG_TIPPSLANRESNAME);
    }

    public final String getTIPPSLANRESNAME() {
        return this.GetParamStringValue(TAG_TIPPSLANRESNAME, "");
    }

    public final void setTIPPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_TIPPSLANRESNAME, strValue);
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

    public final boolean isENDVALUENull() {
        return this.IsParamNull(TAG_ENDVALUE);
    }

    public final double getENDVALUE() {
        return this.GetParamDoubleValue(TAG_ENDVALUE, 0.0);
    }

    public final void setENDVALUE(double strValue) {
        this.SetParamValue(TAG_ENDVALUE, strValue);
    }

    public final boolean isBEGINVALUENull() {
        return this.IsParamNull(TAG_BEGINVALUE);
    }

    public final double getBEGINVALUE() {
        return this.GetParamDoubleValue(TAG_BEGINVALUE, 0.0);
    }

    public final void setBEGINVALUE(double strValue) {
        this.SetParamValue(TAG_BEGINVALUE, strValue);
    }

    public final boolean isINCBEGINVALUENull() {
        return this.IsParamNull(TAG_INCBEGINVALUE);
    }

    public final boolean getINCBEGINVALUE() {
        return this.GetParamIntValue(TAG_INCBEGINVALUE, 0) == 1;
    }

    public final void setINCBEGINVALUE(boolean bValue) {
        this.SetParamValue(TAG_INCBEGINVALUE, bValue ? 1 : 0);
    }

    public final boolean isINCENDVALUENull() {
        return this.IsParamNull(TAG_INCENDVALUE);
    }

    public final boolean getINCENDVALUE() {
        return this.GetParamIntValue(TAG_INCENDVALUE, 0) == 1;
    }

    public final void setINCENDVALUE(boolean bValue) {
        this.SetParamValue(TAG_INCENDVALUE, bValue ? 1 : 0);
    }

    public final boolean isTHRESHOLDGROUPFLAGNull() {
        return this.IsParamNull(TAG_THRESHOLDGROUPFLAG);
    }

    public final boolean getTHRESHOLDGROUPFLAG() {
        return this.GetParamIntValue(TAG_THRESHOLDGROUPFLAG, 0) == 1;
    }

    public final void setTHRESHOLDGROUPFLAG(boolean bValue) {
        this.SetParamValue(TAG_THRESHOLDGROUPFLAG, bValue ? 1 : 0);
    }

    public final boolean isCSSCLASSNull() {
        return this.IsParamNull(TAG_CSSCLASS);
    }

    public final String getCSSCLASS() {
        return this.GetParamStringValue(TAG_CSSCLASS, "");
    }

    public final void setCSSCLASS(String strValue) {
        this.SetParamValue(TAG_CSSCLASS, strValue);
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

