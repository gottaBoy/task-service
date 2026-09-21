/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class CounterType
extends BaseDataEntity {
    public static final String TAG_COUNTERTYPEID = "COUNTERTYPEID";
    public static final String TAG_COUNTERTYPENAME = "COUNTERTYPENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TYPEHELPER = "TYPEHELPER";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_TYPEPARAM = "TYPEPARAM";

    public final boolean isCOUNTERTYPEIDNull() {
        return this.IsParamNull(TAG_COUNTERTYPEID);
    }

    public final String getCOUNTERTYPEID() {
        return this.GetParamStringValue(TAG_COUNTERTYPEID, "");
    }

    public final void setCOUNTERTYPEID(String strValue) {
        this.SetParamValue(TAG_COUNTERTYPEID, strValue);
    }

    public final boolean isCOUNTERTYPENAMENull() {
        return this.IsParamNull(TAG_COUNTERTYPENAME);
    }

    public final String getCOUNTERTYPENAME() {
        return this.GetParamStringValue(TAG_COUNTERTYPENAME, "");
    }

    public final void setCOUNTERTYPENAME(String strValue) {
        this.SetParamValue(TAG_COUNTERTYPENAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public final boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public final int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public final void setVERSION(int nValue) {
        this.SetParamValue(TAG_VERSION, nValue);
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

    public final boolean isTYPEHELPERNull() {
        return this.IsParamNull(TAG_TYPEHELPER);
    }

    public final String getTYPEHELPER() {
        return this.GetParamStringValue(TAG_TYPEHELPER, "");
    }

    public final void setTYPEHELPER(String strValue) {
        this.SetParamValue(TAG_TYPEHELPER, strValue);
    }

    public final boolean isORDERFLAGNull() {
        return this.IsParamNull(TAG_ORDERFLAG);
    }

    public final int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public final void setORDERFLAG(int nValue) {
        this.SetParamValue(TAG_ORDERFLAG, nValue);
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

    public final boolean isTYPEPARAMNull() {
        return this.IsParamNull(TAG_TYPEPARAM);
    }

    public final String getTYPEPARAM() {
        return this.GetParamStringValue(TAG_TYPEPARAM, "");
    }

    public final void setTYPEPARAM(String strValue) {
        this.SetParamValue(TAG_TYPEPARAM, strValue);
    }
}

