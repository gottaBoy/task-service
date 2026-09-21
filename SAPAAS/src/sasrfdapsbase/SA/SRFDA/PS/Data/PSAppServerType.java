/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppServerType
extends BaseDataEntity {
    public static final String TAG_PSASTYPEID = "PSASTYPEID";
    public static final String TAG_PSASTYPENAME = "PSASTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ICONPATH = "ICONPATH";
    public static final String TAG_INSTALLPATH = "INSTALLPATH";
    public static final String TAG_STARTCMD = "STARTCMD";
    public static final String TAG_STOPCMD = "STOPCMD";
    public static final String TAG_TYPEHELPER = "TYPEHELPER";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";

    public final boolean isPSASTYPEIDNull() {
        return this.IsParamNull(TAG_PSASTYPEID);
    }

    public final String getPSASTYPEID() {
        return this.GetParamStringValue(TAG_PSASTYPEID, "");
    }

    public final void setPSASTYPEID(String strValue) {
        this.SetParamValue(TAG_PSASTYPEID, strValue);
    }

    public final boolean isPSASTYPENAMENull() {
        return this.IsParamNull(TAG_PSASTYPENAME);
    }

    public final String getPSASTYPENAME() {
        return this.GetParamStringValue(TAG_PSASTYPENAME, "");
    }

    public final void setPSASTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSASTYPENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isICONPATHNull() {
        return this.IsParamNull(TAG_ICONPATH);
    }

    public final String getICONPATH() {
        return this.GetParamStringValue(TAG_ICONPATH, "");
    }

    public final void setICONPATH(String strValue) {
        this.SetParamValue(TAG_ICONPATH, strValue);
    }

    public final boolean isINSTALLPATHNull() {
        return this.IsParamNull(TAG_INSTALLPATH);
    }

    public final String getINSTALLPATH() {
        return this.GetParamStringValue(TAG_INSTALLPATH, "");
    }

    public final void setINSTALLPATH(String strValue) {
        this.SetParamValue(TAG_INSTALLPATH, strValue);
    }

    public final boolean isSTARTCMDNull() {
        return this.IsParamNull(TAG_STARTCMD);
    }

    public final String getSTARTCMD() {
        return this.GetParamStringValue(TAG_STARTCMD, "");
    }

    public final void setSTARTCMD(String strValue) {
        this.SetParamValue(TAG_STARTCMD, strValue);
    }

    public final boolean isSTOPCMDNull() {
        return this.IsParamNull(TAG_STOPCMD);
    }

    public final String getSTOPCMD() {
        return this.GetParamStringValue(TAG_STOPCMD, "");
    }

    public final void setSTOPCMD(String strValue) {
        this.SetParamValue(TAG_STOPCMD, strValue);
    }

    public final boolean isTYPEHELPERNull() {
        return this.IsParamNull(TAG_TYPEHELPER);
    }

    public final String getTYPEHELPER() {
        return this.GetParamStringValue(TAG_TYPEHELPER, "");
    }

    public final void setTYPEHELPER(String strValue) {
        this.SetParamValue(TAG_TYPEHELPER, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
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

