/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSPanelLogicNodeType
extends BaseDataEntity {
    public static final String TAG_PSPANELLNTYPEID = "PSPANELLNTYPEID";
    public static final String TAG_PSPANELLNTYPENAME = "PSPANELLNTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ICONPATH = "ICONPATH";
    public static final String TAG_ITEMOBJ = "ITEMOBJ";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSPANELLNTYPEIDNull() {
        return this.IsParamNull(TAG_PSPANELLNTYPEID);
    }

    public final String getPSPANELLNTYPEID() {
        return this.GetParamStringValue(TAG_PSPANELLNTYPEID, "");
    }

    public final void setPSPANELLNTYPEID(String strValue) {
        this.SetParamValue(TAG_PSPANELLNTYPEID, strValue);
    }

    public final boolean isPSPANELLNTYPENAMENull() {
        return this.IsParamNull(TAG_PSPANELLNTYPENAME);
    }

    public final String getPSPANELLNTYPENAME() {
        return this.GetParamStringValue(TAG_PSPANELLNTYPENAME, "");
    }

    public final void setPSPANELLNTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSPANELLNTYPENAME, strValue);
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

    public final boolean isICONPATHNull() {
        return this.IsParamNull(TAG_ICONPATH);
    }

    public final String getICONPATH() {
        return this.GetParamStringValue(TAG_ICONPATH, "");
    }

    public final void setICONPATH(String strValue) {
        this.SetParamValue(TAG_ICONPATH, strValue);
    }

    public final boolean isITEMOBJNull() {
        return this.IsParamNull(TAG_ITEMOBJ);
    }

    public final String getITEMOBJ() {
        return this.GetParamStringValue(TAG_ITEMOBJ, "");
    }

    public final void setITEMOBJ(String strValue) {
        this.SetParamValue(TAG_ITEMOBJ, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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
}

