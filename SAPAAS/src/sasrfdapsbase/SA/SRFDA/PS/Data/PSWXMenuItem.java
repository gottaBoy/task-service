/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

public class PSWXMenuItem
extends BaseDataEntity {
    public static final String TAG_PSWXMENUITEMID = "PSWXMENUITEMID";
    public static final String TAG_PSWXMENUITEMNAME = "PSWXMENUITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSWXMENUID = "PSWXMENUID";
    public static final String TAG_PSWXMENUNAME = "PSWXMENUNAME";
    public static final String TAG_PPSWXMENUITEMID = "PPSWXMENUITEMID";
    public static final String TAG_PPSWXMENUITEMNAME = "PPSWXMENUITEMNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSWXMENUFUNCID = "PSWXMENUFUNCID";
    public static final String TAG_PSWXMENUFUNCNAME = "PSWXMENUFUNCNAME";
    public static final String TAG_CAPTION = "CAPTION";
    private ArrayList<PSWXMenuItem> childPSWXMenuItemList = null;

    public final boolean isPSWXMENUITEMIDNull() {
        return this.IsParamNull(TAG_PSWXMENUITEMID);
    }

    public final String getPSWXMENUITEMID() {
        return this.GetParamStringValue(TAG_PSWXMENUITEMID, "");
    }

    public final void setPSWXMENUITEMID(String strValue) {
        this.SetParamValue(TAG_PSWXMENUITEMID, strValue);
    }

    public final boolean isPSWXMENUITEMNAMENull() {
        return this.IsParamNull(TAG_PSWXMENUITEMNAME);
    }

    public final String getPSWXMENUITEMNAME() {
        return this.GetParamStringValue(TAG_PSWXMENUITEMNAME, "");
    }

    public final void setPSWXMENUITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSWXMENUITEMNAME, strValue);
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

    public final boolean isPPSWXMENUITEMIDNull() {
        return this.IsParamNull(TAG_PPSWXMENUITEMID);
    }

    public final String getPPSWXMENUITEMID() {
        return this.GetParamStringValue(TAG_PPSWXMENUITEMID, "");
    }

    public final void setPPSWXMENUITEMID(String strValue) {
        this.SetParamValue(TAG_PPSWXMENUITEMID, strValue);
    }

    public final boolean isPPSWXMENUITEMNAMENull() {
        return this.IsParamNull(TAG_PPSWXMENUITEMNAME);
    }

    public final String getPPSWXMENUITEMNAME() {
        return this.GetParamStringValue(TAG_PPSWXMENUITEMNAME, "");
    }

    public final void setPPSWXMENUITEMNAME(String strValue) {
        this.SetParamValue(TAG_PPSWXMENUITEMNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPSWXMENUFUNCIDNull() {
        return this.IsParamNull(TAG_PSWXMENUFUNCID);
    }

    public final String getPSWXMENUFUNCID() {
        return this.GetParamStringValue(TAG_PSWXMENUFUNCID, "");
    }

    public final void setPSWXMENUFUNCID(String strValue) {
        this.SetParamValue(TAG_PSWXMENUFUNCID, strValue);
    }

    public final boolean isPSWXMENUFUNCNAMENull() {
        return this.IsParamNull(TAG_PSWXMENUFUNCNAME);
    }

    public final String getPSWXMENUFUNCNAME() {
        return this.GetParamStringValue(TAG_PSWXMENUFUNCNAME, "");
    }

    public final void setPSWXMENUFUNCNAME(String strValue) {
        this.SetParamValue(TAG_PSWXMENUFUNCNAME, strValue);
    }

    public final boolean isCAPTIONNull() {
        return this.IsParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
    }

    public ArrayList<PSWXMenuItem> getChildPSWXMenuItems(boolean bCreated) {
        if (this.childPSWXMenuItemList != null) {
            return this.childPSWXMenuItemList;
        }
        if (bCreated) {
            this.childPSWXMenuItemList = new ArrayList();
        }
        return this.childPSWXMenuItemList;
    }

    public void resetChildDatas() {
        if (this.childPSWXMenuItemList != null) {
            this.childPSWXMenuItemList.clear();
            this.childPSWXMenuItemList = null;
        }
    }
}

