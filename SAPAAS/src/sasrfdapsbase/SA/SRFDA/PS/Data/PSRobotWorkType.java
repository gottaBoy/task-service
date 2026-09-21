/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSRobotWorkType
extends BaseDataEntity {
    public static final String TAG_PSROBOTWORKTYPEID = "PSROBOTWORKTYPEID";
    public static final String TAG_PSROBOTWORKTYPENAME = "PSROBOTWORKTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_WORKDESC = "WORKDESC";
    public static final String TAG_TYPEOBJ = "TYPEOBJ";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_TYPEPARAMS = "TYPEPARAMS";
    public static final String TAG_ENERGY = "ENERGY";

    public final boolean isPSROBOTWORKTYPEIDNull() {
        return this.IsParamNull(TAG_PSROBOTWORKTYPEID);
    }

    public final String getPSROBOTWORKTYPEID() {
        return this.GetParamStringValue(TAG_PSROBOTWORKTYPEID, "");
    }

    public final void setPSROBOTWORKTYPEID(String strValue) {
        this.SetParamValue(TAG_PSROBOTWORKTYPEID, strValue);
    }

    public final boolean isPSROBOTWORKTYPENAMENull() {
        return this.IsParamNull(TAG_PSROBOTWORKTYPENAME);
    }

    public final String getPSROBOTWORKTYPENAME() {
        return this.GetParamStringValue(TAG_PSROBOTWORKTYPENAME, "");
    }

    public final void setPSROBOTWORKTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSROBOTWORKTYPENAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isWORKDESCNull() {
        return this.IsParamNull(TAG_WORKDESC);
    }

    public final String getWORKDESC() {
        return this.GetParamStringValue(TAG_WORKDESC, "");
    }

    public final void setWORKDESC(String strValue) {
        this.SetParamValue(TAG_WORKDESC, strValue);
    }

    public final boolean isTYPEOBJNull() {
        return this.IsParamNull(TAG_TYPEOBJ);
    }

    public final String getTYPEOBJ() {
        return this.GetParamStringValue(TAG_TYPEOBJ, "");
    }

    public final void setTYPEOBJ(String strValue) {
        this.SetParamValue(TAG_TYPEOBJ, strValue);
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

    public final boolean isTYPEPARAMSNull() {
        return this.IsParamNull(TAG_TYPEPARAMS);
    }

    public final String getTYPEPARAMS() {
        return this.GetParamStringValue(TAG_TYPEPARAMS, "");
    }

    public final void setTYPEPARAMS(String strValue) {
        this.SetParamValue(TAG_TYPEPARAMS, strValue);
    }

    public final boolean isENERGYNull() {
        return this.IsParamNull(TAG_ENERGY);
    }

    public final int getENERGY() {
        return this.GetParamIntValue(TAG_ENERGY, 0);
    }

    public final void setENERGY(int nValue) {
        this.SetParamValue(TAG_ENERGY, nValue);
    }
}

