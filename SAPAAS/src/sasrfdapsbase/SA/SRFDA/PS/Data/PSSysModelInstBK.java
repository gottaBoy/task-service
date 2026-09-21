/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysModelInstBK
extends BaseDataEntity {
    public static final String TAG_PSSYSMODELINSTBKID = "PSSYSMODELINSTBKID";
    public static final String TAG_PSSYSMODELINSTBKNAME = "PSSYSMODELINSTBKNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String TAG_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String TAG_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String TAG_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String TAG_BKTIME = "BKTIME";
    public static final String TAG_BKFILEPATH = "BKFILEPATH";
    public static final String TAG_BKFILESIZE = "BKFILESIZE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PASSWD = "PASSWD";

    public final boolean isPSSYSMODELINSTBKIDNull() {
        return this.IsParamNull(TAG_PSSYSMODELINSTBKID);
    }

    public final String getPSSYSMODELINSTBKID() {
        return this.GetParamStringValue(TAG_PSSYSMODELINSTBKID, "");
    }

    public final void setPSSYSMODELINSTBKID(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELINSTBKID, strValue);
    }

    public final boolean isPSSYSMODELINSTBKNAMENull() {
        return this.IsParamNull(TAG_PSSYSMODELINSTBKNAME);
    }

    public final String getPSSYSMODELINSTBKNAME() {
        return this.GetParamStringValue(TAG_PSSYSMODELINSTBKNAME, "");
    }

    public final void setPSSYSMODELINSTBKNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELINSTBKNAME, strValue);
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

    public final boolean isPSSYSMODELINSTIDNull() {
        return this.IsParamNull(TAG_PSSYSMODELINSTID);
    }

    public final String getPSSYSMODELINSTID() {
        return this.GetParamStringValue(TAG_PSSYSMODELINSTID, "");
    }

    public final void setPSSYSMODELINSTID(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELINSTID, strValue);
    }

    public final boolean isPSSYSMODELINSTNAMENull() {
        return this.IsParamNull(TAG_PSSYSMODELINSTNAME);
    }

    public final String getPSSYSMODELINSTNAME() {
        return this.GetParamStringValue(TAG_PSSYSMODELINSTNAME, "");
    }

    public final void setPSSYSMODELINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELINSTNAME, strValue);
    }

    public final boolean isPSTASKSERVERIDNull() {
        return this.IsParamNull(TAG_PSTASKSERVERID);
    }

    public final String getPSTASKSERVERID() {
        return this.GetParamStringValue(TAG_PSTASKSERVERID, "");
    }

    public final void setPSTASKSERVERID(String strValue) {
        this.SetParamValue(TAG_PSTASKSERVERID, strValue);
    }

    public final boolean isPSTASKSERVERNAMENull() {
        return this.IsParamNull(TAG_PSTASKSERVERNAME);
    }

    public final String getPSTASKSERVERNAME() {
        return this.GetParamStringValue(TAG_PSTASKSERVERNAME, "");
    }

    public final void setPSTASKSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSTASKSERVERNAME, strValue);
    }

    public final boolean isBKTIMENull() {
        return this.IsParamNull(TAG_BKTIME);
    }

    public final Date getBKTIME() {
        return this.GetParamDateValue(TAG_BKTIME, null);
    }

    public final void setBKTIME(Date dtValue) {
        this.SetParamValue(TAG_BKTIME, dtValue);
    }

    public final boolean isBKFILEPATHNull() {
        return this.IsParamNull(TAG_BKFILEPATH);
    }

    public final String getBKFILEPATH() {
        return this.GetParamStringValue(TAG_BKFILEPATH, "");
    }

    public final void setBKFILEPATH(String strValue) {
        this.SetParamValue(TAG_BKFILEPATH, strValue);
    }

    public final boolean isBKFILESIZENull() {
        return this.IsParamNull(TAG_BKFILESIZE);
    }

    public final int getBKFILESIZE() {
        return this.GetParamIntValue(TAG_BKFILESIZE, 0);
    }

    public final void setBKFILESIZE(int nValue) {
        this.SetParamValue(TAG_BKFILESIZE, nValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isPASSWDNull() {
        return this.IsParamNull(TAG_PASSWD);
    }

    public final String getPASSWD() {
        return this.GetParamStringValue(TAG_PASSWD, "");
    }

    public final void setPASSWD(String strValue) {
        this.SetParamValue(TAG_PASSWD, strValue);
    }
}

