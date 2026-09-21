/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.WT.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WTMenu
extends BaseDataEntity {
    public static final String MENUTYPE_click = "click";
    public static final String MENUTYPE_view = "view";
    public static final String TAG_WTMENUID = "WTMENUID";
    public static final String TAG_WTMENUNAME = "WTMENUNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WTACCOUNTID = "WTACCOUNTID";
    public static final String TAG_WTACCOUNTNAME = "WTACCOUNTNAME";
    public static final String TAG_PWTMENUID = "PWTMENUID";
    public static final String TAG_PWTMENUNAME = "PWTMENUNAME";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_MENUTYPE = "MENUTYPE";
    public static final String TAG_VIEWURL = "VIEWURL";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_WTSERVICEBASEID = "WTSERVICEBASEID";
    public static final String TAG_WTSERVICEBASENAME = "WTSERVICEBASENAME";

    public final boolean isWTMENUIDNull() {
        return this.IsParamNull(TAG_WTMENUID);
    }

    public final String getWTMENUID() {
        return this.GetParamStringValue(TAG_WTMENUID, "");
    }

    public final void setWTMENUID(String strValue) {
        this.SetParamValue(TAG_WTMENUID, strValue);
    }

    public final boolean isWTMENUNAMENull() {
        return this.IsParamNull(TAG_WTMENUNAME);
    }

    public final String getWTMENUNAME() {
        return this.GetParamStringValue(TAG_WTMENUNAME, "");
    }

    public final void setWTMENUNAME(String strValue) {
        this.SetParamValue(TAG_WTMENUNAME, strValue);
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

    public final boolean isWTACCOUNTIDNull() {
        return this.IsParamNull(TAG_WTACCOUNTID);
    }

    public final String getWTACCOUNTID() {
        return this.GetParamStringValue(TAG_WTACCOUNTID, "");
    }

    public final void setWTACCOUNTID(String strValue) {
        this.SetParamValue(TAG_WTACCOUNTID, strValue);
    }

    public final boolean isWTACCOUNTNAMENull() {
        return this.IsParamNull(TAG_WTACCOUNTNAME);
    }

    public final String getWTACCOUNTNAME() {
        return this.GetParamStringValue(TAG_WTACCOUNTNAME, "");
    }

    public final void setWTACCOUNTNAME(String strValue) {
        this.SetParamValue(TAG_WTACCOUNTNAME, strValue);
    }

    public final boolean isPWTMENUIDNull() {
        return this.IsParamNull(TAG_PWTMENUID);
    }

    public final String getPWTMENUID() {
        return this.GetParamStringValue(TAG_PWTMENUID, "");
    }

    public final void setPWTMENUID(String strValue) {
        this.SetParamValue(TAG_PWTMENUID, strValue);
    }

    public final boolean isPWTMENUNAMENull() {
        return this.IsParamNull(TAG_PWTMENUNAME);
    }

    public final String getPWTMENUNAME() {
        return this.GetParamStringValue(TAG_PWTMENUNAME, "");
    }

    public final void setPWTMENUNAME(String strValue) {
        this.SetParamValue(TAG_PWTMENUNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isMENUTYPENull() {
        return this.IsParamNull(TAG_MENUTYPE);
    }

    public final String getMENUTYPE() {
        return this.GetParamStringValue(TAG_MENUTYPE, "");
    }

    public final void setMENUTYPE(String strValue) {
        this.SetParamValue(TAG_MENUTYPE, strValue);
    }

    public final boolean isVIEWURLNull() {
        return this.IsParamNull(TAG_VIEWURL);
    }

    public final String getVIEWURL() {
        return this.GetParamStringValue(TAG_VIEWURL, "");
    }

    public final void setVIEWURL(String strValue) {
        this.SetParamValue(TAG_VIEWURL, strValue);
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

    public final boolean isWTSERVICEBASENAMENull() {
        return this.IsParamNull(TAG_WTSERVICEBASENAME);
    }

    public final String getWTSERVICEBASENAME() {
        return this.GetParamStringValue(TAG_WTSERVICEBASENAME, "");
    }

    public final void setWTSERVICEBASENAME(String strValue) {
        this.SetParamValue(TAG_WTSERVICEBASENAME, strValue);
    }

    public final boolean isWTSERVICEBASEIDNull() {
        return this.IsParamNull(TAG_WTSERVICEBASEID);
    }

    public final String getWTSERVICEBASEID() {
        return this.GetParamStringValue(TAG_WTSERVICEBASEID, "");
    }

    public final void setWTSERVICEBASEID(String strValue) {
        this.SetParamValue(TAG_WTSERVICEBASEID, strValue);
    }
}

