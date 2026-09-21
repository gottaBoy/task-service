/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSWXMenu
extends BaseDataEntity {
    public static final String TAG_PSWXMENUID = "PSWXMENUID";
    public static final String TAG_PSWXMENUNAME = "PSWXMENUNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSWXACCOUNTID = "PSWXACCOUNTID";
    public static final String TAG_PSWXACCOUNTNAME = "PSWXACCOUNTNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_MENUMODEL = "MENUMODEL";
    public static final String TAG_PSWXENTAPPID = "PSWXENTAPPID";
    public static final String TAG_PSWXENTAPPNAME = "PSWXENTAPPNAME";

    public final boolean isPSWXMENUIDNull() {
        return this.IsParamNull(TAG_PSWXMENUID);
    }

    public final String getPSWXMENUID() {
        return this.GetParamStringValue(TAG_PSWXMENUID, "");
    }

    public final void setPSWXMENUID(String strValue) {
        this.SetParamValue(TAG_PSWXMENUID, strValue);
    }

    public final boolean isPSWXMENUNAMENull() {
        return this.IsParamNull(TAG_PSWXMENUNAME);
    }

    public final String getPSWXMENUNAME() {
        return this.GetParamStringValue(TAG_PSWXMENUNAME, "");
    }

    public final void setPSWXMENUNAME(String strValue) {
        this.SetParamValue(TAG_PSWXMENUNAME, strValue);
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

    public final boolean isPSWXACCOUNTIDNull() {
        return this.IsParamNull(TAG_PSWXACCOUNTID);
    }

    public final String getPSWXACCOUNTID() {
        return this.GetParamStringValue(TAG_PSWXACCOUNTID, "");
    }

    public final void setPSWXACCOUNTID(String strValue) {
        this.SetParamValue(TAG_PSWXACCOUNTID, strValue);
    }

    public final boolean isPSWXACCOUNTNAMENull() {
        return this.IsParamNull(TAG_PSWXACCOUNTNAME);
    }

    public final String getPSWXACCOUNTNAME() {
        return this.GetParamStringValue(TAG_PSWXACCOUNTNAME, "");
    }

    public final void setPSWXACCOUNTNAME(String strValue) {
        this.SetParamValue(TAG_PSWXACCOUNTNAME, strValue);
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

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
    }

    public final boolean isMENUMODELNull() {
        return this.IsParamNull(TAG_MENUMODEL);
    }

    public final String getMENUMODEL() {
        return this.GetParamStringValue(TAG_MENUMODEL, "");
    }

    public final void setMENUMODEL(String strValue) {
        this.SetParamValue(TAG_MENUMODEL, strValue);
    }

    public final boolean isPSWXENTAPPIDNull() {
        return this.IsParamNull(TAG_PSWXENTAPPID);
    }

    public final String getPSWXENTAPPID() {
        return this.GetParamStringValue(TAG_PSWXENTAPPID, "");
    }

    public final void setPSWXENTAPPID(String strValue) {
        this.SetParamValue(TAG_PSWXENTAPPID, strValue);
    }

    public final boolean isPSWXENTAPPNAMENull() {
        return this.IsParamNull(TAG_PSWXENTAPPNAME);
    }

    public final String getPSWXENTAPPNAME() {
        return this.GetParamStringValue(TAG_PSWXENTAPPNAME, "");
    }

    public final void setPSWXENTAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSWXENTAPPNAME, strValue);
    }
}

