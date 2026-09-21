/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysSFCode
extends BaseDataEntity {
    public static final String TAG_PSSYSSFCODEID = "PSSYSSFCODEID";
    public static final String TAG_PSSYSSFCODENAME = "PSSYSSFCODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String TAG_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String TAG_PSSFCODEFOLDERID = "PSSFCODEFOLDERID";
    public static final String TAG_PSSFCODEFOLDERNAME = "PSSFCODEFOLDERNAME";
    public static final String TAG_PSSFCODETYPEID = "PSSFCODETYPEID";
    public static final String TAG_PSSFCODETYPENAME = "PSSFCODETYPENAME";
    public static final String TAG_CODEPATH = "CODEPATH";
    public static final String TAG_FULLCODENAME = "FULLCODENAME";
    public static final String TAG_PUBCODE = "PUBCODE";
    public static final String TAG_USERCODE = "USERCODE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_SYSOBJID = "SYSOBJID";
    public static final String TAG_SYSOBJNAME = "SYSOBJNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";

    public final boolean isPSSYSSFCODEIDNull() {
        return this.IsParamNull(TAG_PSSYSSFCODEID);
    }

    public final String getPSSYSSFCODEID() {
        return this.GetParamStringValue(TAG_PSSYSSFCODEID, "");
    }

    public final void setPSSYSSFCODEID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFCODEID, strValue);
    }

    public final boolean isPSSYSSFCODENAMENull() {
        return this.IsParamNull(TAG_PSSYSSFCODENAME);
    }

    public final String getPSSYSSFCODENAME() {
        return this.GetParamStringValue(TAG_PSSYSSFCODENAME, "");
    }

    public final void setPSSYSSFCODENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFCODENAME, strValue);
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

    public final boolean isPSSFCODEFOLDERIDNull() {
        return this.IsParamNull(TAG_PSSFCODEFOLDERID);
    }

    public final String getPSSFCODEFOLDERID() {
        return this.GetParamStringValue(TAG_PSSFCODEFOLDERID, "");
    }

    public final void setPSSFCODEFOLDERID(String strValue) {
        this.SetParamValue(TAG_PSSFCODEFOLDERID, strValue);
    }

    public final boolean isPSSFCODEFOLDERNAMENull() {
        return this.IsParamNull(TAG_PSSFCODEFOLDERNAME);
    }

    public final String getPSSFCODEFOLDERNAME() {
        return this.GetParamStringValue(TAG_PSSFCODEFOLDERNAME, "");
    }

    public final void setPSSFCODEFOLDERNAME(String strValue) {
        this.SetParamValue(TAG_PSSFCODEFOLDERNAME, strValue);
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

    public final boolean isCODEPATHNull() {
        return this.IsParamNull(TAG_CODEPATH);
    }

    public final String getCODEPATH() {
        return this.GetParamStringValue(TAG_CODEPATH, "");
    }

    public final void setCODEPATH(String strValue) {
        this.SetParamValue(TAG_CODEPATH, strValue);
    }

    public final boolean isFULLCODENAMENull() {
        return this.IsParamNull(TAG_FULLCODENAME);
    }

    public final String getFULLCODENAME() {
        return this.GetParamStringValue(TAG_FULLCODENAME, "");
    }

    public final void setFULLCODENAME(String strValue) {
        this.SetParamValue(TAG_FULLCODENAME, strValue);
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

    public final boolean isSYSOBJIDNull() {
        return this.IsParamNull(TAG_SYSOBJID);
    }

    public final String getSYSOBJID() {
        return this.GetParamStringValue(TAG_SYSOBJID, "");
    }

    public final void setSYSOBJID(String strValue) {
        this.SetParamValue(TAG_SYSOBJID, strValue);
    }

    public final boolean isSYSOBJNAMENull() {
        return this.IsParamNull(TAG_SYSOBJNAME);
    }

    public final String getSYSOBJNAME() {
        return this.GetParamStringValue(TAG_SYSOBJNAME, "");
    }

    public final void setSYSOBJNAME(String strValue) {
        this.SetParamValue(TAG_SYSOBJNAME, strValue);
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
}

