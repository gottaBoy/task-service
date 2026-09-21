/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSModelSFCode
extends BaseDataEntity {
    public static final String TAG_PSMODELSFCODEID = "PSMODELSFCODEID";
    public static final String TAG_PSMODELSFCODENAME = "PSMODELSFCODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String TAG_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String TAG_PSSFCODETYPEID = "PSSFCODETYPEID";
    public static final String TAG_PSSFCODETYPENAME = "PSSFCODETYPENAME";
    public static final String TAG_PUBCODE = "PUBCODE";
    public static final String TAG_USERCODE = "USERCODE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODEPATH = "CODEPATH";
    public static final String TAG_CODEPKGNAME = "CODEPKGNAME";
    public static final String TAG_CODEMODE = "CODEMODE";
    public static final String TAG_PRJNAME = "PRJNAME";
    public static final String TAG_PRJFOLDER = "PRJFOLDER";
    public static final String TAG_CUSTOMFLAG = "CUSTOMFLAG";

    public final boolean isPSMODELSFCODEIDNull() {
        return this.IsParamNull(TAG_PSMODELSFCODEID);
    }

    public final String getPSMODELSFCODEID() {
        return this.GetParamStringValue(TAG_PSMODELSFCODEID, "");
    }

    public final void setPSMODELSFCODEID(String strValue) {
        this.SetParamValue(TAG_PSMODELSFCODEID, strValue);
    }

    public final boolean isPSMODELSFCODENAMENull() {
        return this.IsParamNull(TAG_PSMODELSFCODENAME);
    }

    public final String getPSMODELSFCODENAME() {
        return this.GetParamStringValue(TAG_PSMODELSFCODENAME, "");
    }

    public final void setPSMODELSFCODENAME(String strValue) {
        this.SetParamValue(TAG_PSMODELSFCODENAME, strValue);
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

    public final boolean isPSSYSSFPUBIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPUBID);
    }

    public final String getPSSYSSFPUBID() {
        return this.GetParamStringValue(TAG_PSSYSSFPUBID, "");
    }

    public final void setPSSYSSFPUBID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPUBID, strValue);
    }

    public final boolean isPSSYSSFPUBNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPUBNAME);
    }

    public final String getPSSYSSFPUBNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPUBNAME, "");
    }

    public final void setPSSYSSFPUBNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPUBNAME, strValue);
    }

    public final boolean isPSSFCODETYPEIDNull() {
        return this.IsParamNull(TAG_PSSFCODETYPEID);
    }

    public final String getPSSFCODETYPEID() {
        return this.GetParamStringValue(TAG_PSSFCODETYPEID, "");
    }

    public final void setPSSFCODETYPEID(String strValue) {
        this.SetParamValue(TAG_PSSFCODETYPEID, strValue);
    }

    public final boolean isPSSFCODETYPENAMENull() {
        return this.IsParamNull(TAG_PSSFCODETYPENAME);
    }

    public final String getPSSFCODETYPENAME() {
        return this.GetParamStringValue(TAG_PSSFCODETYPENAME, "");
    }

    public final void setPSSFCODETYPENAME(String strValue) {
        this.SetParamValue(TAG_PSSFCODETYPENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isCODEPKGNAMENull() {
        return this.IsParamNull(TAG_CODEPKGNAME);
    }

    public final String getCODEPKGNAME() {
        return this.GetParamStringValue(TAG_CODEPKGNAME, "");
    }

    public final void setCODEPKGNAME(String strValue) {
        this.SetParamValue(TAG_CODEPKGNAME, strValue);
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

    public final boolean isCUSTOMFLAGNull() {
        return this.IsParamNull(TAG_CUSTOMFLAG);
    }

    public final boolean getCUSTOMFLAG() {
        return this.GetParamIntValue(TAG_CUSTOMFLAG, 0) == 1;
    }

    public final void setCUSTOMFLAG(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMFLAG, bValue ? 1 : 0);
    }
}

