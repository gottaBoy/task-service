/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppViewCode
extends BaseDataEntity {
    public static final String PRJTYPE_APP_PUB = "APP_PUB";
    public static final String PRJTYPE_APP_USR = "APP_USR";
    public static final String TAG_PSAPPVIEWCODEID = "PSAPPVIEWCODEID";
    public static final String TAG_PSAPPVIEWCODENAME = "PSAPPVIEWCODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String TAG_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String TAG_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String TAG_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PUBCODE = "PUBCODE";
    public static final String TAG_MERGECODE = "MERGECODE";
    public static final String TAG_USERCODE = "USERCODE";
    public static final String TAG_CODEPATH = "CODEPATH";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PRJTYPE = "PRJTYPE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_UISTYLE = "UISTYLE";
    public static final String TAG_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String TAG_PRJPATH = "PRJPATH";

    public final boolean isPSAPPVIEWCODEIDNull() {
        return this.IsParamNull(TAG_PSAPPVIEWCODEID);
    }

    public final String getPSAPPVIEWCODEID() {
        return this.GetParamStringValue(TAG_PSAPPVIEWCODEID, "");
    }

    public final void setPSAPPVIEWCODEID(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWCODEID, strValue);
    }

    public final boolean isPSAPPVIEWCODENAMENull() {
        return this.IsParamNull(TAG_PSAPPVIEWCODENAME);
    }

    public final String getPSAPPVIEWCODENAME() {
        return this.GetParamStringValue(TAG_PSAPPVIEWCODENAME, "");
    }

    public final void setPSAPPVIEWCODENAME(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWCODENAME, strValue);
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

    public final boolean isPSAPPVIEWIDNull() {
        return this.IsParamNull(TAG_PSAPPVIEWID);
    }

    public final String getPSAPPVIEWID() {
        return this.GetParamStringValue(TAG_PSAPPVIEWID, "");
    }

    public final void setPSAPPVIEWID(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWID, strValue);
    }

    public final boolean isPSAPPVIEWNAMENull() {
        return this.IsParamNull(TAG_PSAPPVIEWNAME);
    }

    public final String getPSAPPVIEWNAME() {
        return this.GetParamStringValue(TAG_PSAPPVIEWNAME, "");
    }

    public final void setPSAPPVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWNAME, strValue);
    }

    public final boolean isPSPFPUBCODEIDNull() {
        return this.IsParamNull(TAG_PSPFPUBCODEID);
    }

    public final String getPSPFPUBCODEID() {
        return this.GetParamStringValue(TAG_PSPFPUBCODEID, "");
    }

    public final void setPSPFPUBCODEID(String strValue) {
        this.SetParamValue(TAG_PSPFPUBCODEID, strValue);
    }

    public final boolean isPSPFPUBCODENAMENull() {
        return this.IsParamNull(TAG_PSPFPUBCODENAME);
    }

    public final String getPSPFPUBCODENAME() {
        return this.GetParamStringValue(TAG_PSPFPUBCODENAME, "");
    }

    public final void setPSPFPUBCODENAME(String strValue) {
        this.SetParamValue(TAG_PSPFPUBCODENAME, strValue);
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

    public final boolean isPUBCODENull() {
        return this.IsParamNull(TAG_PUBCODE);
    }

    public final String getPUBCODE() {
        return this.GetParamStringValue(TAG_PUBCODE, "");
    }

    public final void setPUBCODE(String strValue) {
        this.SetParamValue(TAG_PUBCODE, strValue);
    }

    public final boolean isMERGECODENull() {
        return this.IsParamNull(TAG_MERGECODE);
    }

    public final String getMERGECODE() {
        return this.GetParamStringValue(TAG_MERGECODE, "");
    }

    public final void setMERGECODE(String strValue) {
        this.SetParamValue(TAG_MERGECODE, strValue);
    }

    public final boolean isUSERCODENull() {
        return this.IsParamNull(TAG_USERCODE);
    }

    public final String getUSERCODE() {
        return this.GetParamStringValue(TAG_USERCODE, "");
    }

    public final void setUSERCODE(String strValue) {
        this.SetParamValue(TAG_USERCODE, strValue);
    }

    public final boolean isCODEPATHNull() {
        return this.IsParamNull(TAG_CODEPATH);
    }

    public final String getCODEPATH() {
        return this.GetParamStringValue(TAG_CODEPATH, "");
    }

    public final void setCODEPATH(String strValue) {
        this.SetParamValue(TAG_CODEPATH, strValue);
    }

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isPRJTYPENull() {
        return this.IsParamNull(TAG_PRJTYPE);
    }

    public final String getPRJTYPE() {
        return this.GetParamStringValue(TAG_PRJTYPE, "");
    }

    public final void setPRJTYPE(String strValue) {
        this.SetParamValue(TAG_PRJTYPE, strValue);
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

    public final boolean isUISTYLENull() {
        return this.IsParamNull(TAG_UISTYLE);
    }

    public final String getUISTYLE() {
        return this.GetParamStringValue(TAG_UISTYLE, "");
    }

    public final void setUISTYLE(String strValue) {
        this.SetParamValue(TAG_UISTYLE, strValue);
    }

    public final boolean isPSPFSTYLEIDNull() {
        return this.IsParamNull(TAG_PSPFSTYLEID);
    }

    public final String getPSPFSTYLEID() {
        return this.GetParamStringValue(TAG_PSPFSTYLEID, "");
    }

    public final void setPSPFSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLEID, strValue);
    }

    public final boolean isPRJPATHNull() {
        return this.IsParamNull(TAG_PRJPATH);
    }

    public final String getPRJPATH() {
        return this.GetParamStringValue(TAG_PRJPATH, "");
    }

    public final void setPRJPATH(String strValue) {
        this.SetParamValue(TAG_PRJPATH, strValue);
    }
}

