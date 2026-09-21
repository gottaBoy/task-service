/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSModelPFCode
extends BaseDataEntity {
    public static final String TAG_PSMODELPFCODEID = "PSMODELPFCODEID";
    public static final String TAG_PSMODELPFCODENAME = "PSMODELPFCODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String TAG_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODEPKGNAME = "CODEPKGNAME";
    public static final String TAG_CODEPATH = "CODEPATH";
    public static final String TAG_PUBCODE = "PUBCODE";
    public static final String TAG_USERCODE = "USERCODE";
    public static final String TAG_CUSTOMFLAG = "CUSTOMFLAG";
    public static final String TAG_PSMODELID = "PSMODELID";
    public static final String TAG_PSMODELNAME = "PSMODELNAME";
    public static final String TAG_PSMODELTYPE = "PSMODELTYPE";
    public static final String TAG_CODEMODE = "CODEMODE";
    public static final String TAG_PRJNAME = "PRJNAME";
    public static final String TAG_PRJFOLDER = "PRJFOLDER";

    public final boolean isPSMODELPFCODEIDNull() {
        return this.IsParamNull(TAG_PSMODELPFCODEID);
    }

    public final String getPSMODELPFCODEID() {
        return this.GetParamStringValue(TAG_PSMODELPFCODEID, "");
    }

    public final void setPSMODELPFCODEID(String strValue) {
        this.SetParamValue(TAG_PSMODELPFCODEID, strValue);
    }

    public final boolean isPSMODELPFCODENAMENull() {
        return this.IsParamNull(TAG_PSMODELPFCODENAME);
    }

    public final String getPSMODELPFCODENAME() {
        return this.GetParamStringValue(TAG_PSMODELPFCODENAME, "");
    }

    public final void setPSMODELPFCODENAME(String strValue) {
        this.SetParamValue(TAG_PSMODELPFCODENAME, strValue);
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

    public final boolean isCODEPKGNAMENull() {
        return this.IsParamNull(TAG_CODEPKGNAME);
    }

    public final String getCODEPKGNAME() {
        return this.GetParamStringValue(TAG_CODEPKGNAME, "");
    }

    public final void setCODEPKGNAME(String strValue) {
        this.SetParamValue(TAG_CODEPKGNAME, strValue);
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

    public final boolean isPUBCODENull() {
        return this.IsParamNull(TAG_PUBCODE);
    }

    public final String getPUBCODE() {
        return this.GetParamStringValue(TAG_PUBCODE, "");
    }

    public final void setPUBCODE(String strValue) {
        this.SetParamValue(TAG_PUBCODE, strValue);
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

    public final boolean isCUSTOMFLAGNull() {
        return this.IsParamNull(TAG_CUSTOMFLAG);
    }

    public final boolean getCUSTOMFLAG() {
        return this.GetParamIntValue(TAG_CUSTOMFLAG, 0) == 1;
    }

    public final void setCUSTOMFLAG(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSMODELIDNull() {
        return this.IsParamNull(TAG_PSMODELID);
    }

    public final String getPSMODELID() {
        return this.GetParamStringValue(TAG_PSMODELID, "");
    }

    public final void setPSMODELID(String strValue) {
        this.SetParamValue(TAG_PSMODELID, strValue);
    }

    public final boolean isPSMODELNAMENull() {
        return this.IsParamNull(TAG_PSMODELNAME);
    }

    public final String getPSMODELNAME() {
        return this.GetParamStringValue(TAG_PSMODELNAME, "");
    }

    public final void setPSMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSMODELNAME, strValue);
    }

    public final boolean isPSMODELTYPENull() {
        return this.IsParamNull(TAG_PSMODELTYPE);
    }

    public final String getPSMODELTYPE() {
        return this.GetParamStringValue(TAG_PSMODELTYPE, "");
    }

    public final void setPSMODELTYPE(String strValue) {
        this.SetParamValue(TAG_PSMODELTYPE, strValue);
    }

    public final boolean isCODEMODENull() {
        return this.IsParamNull(TAG_CODEMODE);
    }

    public final String getCODEMODE() {
        return this.GetParamStringValue(TAG_CODEMODE, "");
    }

    public final void setCODEMODE(String strValue) {
        this.SetParamValue(TAG_CODEMODE, strValue);
    }

    public final boolean isPRJNAMENull() {
        return this.IsParamNull(TAG_PRJNAME);
    }

    public final String getPRJNAME() {
        return this.GetParamStringValue(TAG_PRJNAME, "");
    }

    public final void setPRJNAME(String strValue) {
        this.SetParamValue(TAG_PRJNAME, strValue);
    }

    public final boolean isPRJFOLDERNull() {
        return this.IsParamNull(TAG_PRJFOLDER);
    }

    public final String getPRJFOLDER() {
        return this.GetParamStringValue(TAG_PRJFOLDER, "");
    }

    public final void setPRJFOLDER(String strValue) {
        this.SetParamValue(TAG_PRJFOLDER, strValue);
    }
}

