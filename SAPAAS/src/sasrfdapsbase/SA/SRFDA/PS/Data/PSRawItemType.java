/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSRawItemType
extends BaseDataEntity {
    public static final String TAG_PSRAWITEMTYPEID = "PSRAWITEMTYPEID";
    public static final String TAG_PSRAWITEMTYPENAME = "PSRAWITEMTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_CTRLOBJ = "CTRLOBJ";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_RAWITEMPARAMS = "RAWITEMPARAMS";

    public final boolean isPSRAWITEMTYPEIDNull() {
        return this.IsParamNull(TAG_PSRAWITEMTYPEID);
    }

    public final String getPSRAWITEMTYPEID() {
        return this.GetParamStringValue(TAG_PSRAWITEMTYPEID, "");
    }

    public final void setPSRAWITEMTYPEID(String strValue) {
        this.SetParamValue(TAG_PSRAWITEMTYPEID, strValue);
    }

    public final boolean isPSRAWITEMTYPENAMENull() {
        return this.IsParamNull(TAG_PSRAWITEMTYPENAME);
    }

    public final String getPSRAWITEMTYPENAME() {
        return this.GetParamStringValue(TAG_PSRAWITEMTYPENAME, "");
    }

    public final void setPSRAWITEMTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSRAWITEMTYPENAME, strValue);
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

    public final boolean isCTRLOBJNull() {
        return this.IsParamNull(TAG_CTRLOBJ);
    }

    public final String getCTRLOBJ() {
        return this.GetParamStringValue(TAG_CTRLOBJ, "");
    }

    public final void setCTRLOBJ(String strValue) {
        this.SetParamValue(TAG_CTRLOBJ, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isRAWITEMPARAMSNull() {
        return this.IsParamNull(TAG_RAWITEMPARAMS);
    }

    public final String getRAWITEMPARAMS() {
        return this.GetParamStringValue(TAG_RAWITEMPARAMS, "");
    }

    public final void setRAWITEMPARAMS(String strValue) {
        this.SetParamValue(TAG_RAWITEMPARAMS, strValue);
    }
}

