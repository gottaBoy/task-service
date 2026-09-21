/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.WT.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WTServiceStep
extends BaseDataEntity {
    public static final String MSGFORMAT_text = "text";
    public static final String MSGFORMAT_image = "image";
    public static final String MSGFORMAT_voice = "voice";
    public static final String MSGFORMAT_video = "video";
    public static final String MSGFORMAT_location = "location";
    public static final String MSGFORMAT_link = "link";
    public static final String MSGFORMAT_event = "event";
    public static final String TAG_WTSERVICESTEPID = "WTSERVICESTEPID";
    public static final String TAG_WTSERVICESTEPNAME = "WTSERVICESTEPNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WTSERVICEBASEID = "WTSERVICEBASEID";
    public static final String TAG_WTSERVICEBASENAME = "WTSERVICEBASENAME";
    public static final String TAG_STEPID = "STEPID";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_MSGFORMAT = "MSGFORMAT";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_TITLE = "TITLE";
    public static final String TAG_PICURL = "PICURL";
    public static final String TAG_DETAILURL = "DETAILURL";

    public final boolean isWTSERVICESTEPIDNull() {
        return this.IsParamNull(TAG_WTSERVICESTEPID);
    }

    public final String getWTSERVICESTEPID() {
        return this.GetParamStringValue(TAG_WTSERVICESTEPID, "");
    }

    public final void setWTSERVICESTEPID(String strValue) {
        this.SetParamValue(TAG_WTSERVICESTEPID, strValue);
    }

    public final boolean isWTSERVICESTEPNAMENull() {
        return this.IsParamNull(TAG_WTSERVICESTEPNAME);
    }

    public final String getWTSERVICESTEPNAME() {
        return this.GetParamStringValue(TAG_WTSERVICESTEPNAME, "");
    }

    public final void setWTSERVICESTEPNAME(String strValue) {
        this.SetParamValue(TAG_WTSERVICESTEPNAME, strValue);
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

    public final boolean isWTSERVICEBASEIDNull() {
        return this.IsParamNull(TAG_WTSERVICEBASEID);
    }

    public final String getWTSERVICEBASEID() {
        return this.GetParamStringValue(TAG_WTSERVICEBASEID, "");
    }

    public final void setWTSERVICEBASEID(String strValue) {
        this.SetParamValue(TAG_WTSERVICEBASEID, strValue);
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

    public final boolean isSTEPIDNull() {
        return this.IsParamNull(TAG_STEPID);
    }

    public final String getSTEPID() {
        return this.GetParamStringValue(TAG_STEPID, "");
    }

    public final void setSTEPID(String strValue) {
        this.SetParamValue(TAG_STEPID, strValue);
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

    public final boolean isMSGFORMATNull() {
        return this.IsParamNull(TAG_MSGFORMAT);
    }

    public final String getMSGFORMAT() {
        return this.GetParamStringValue(TAG_MSGFORMAT, "");
    }

    public final void setMSGFORMAT(String strValue) {
        this.SetParamValue(TAG_MSGFORMAT, strValue);
    }

    public final boolean isCONTENTNull() {
        return this.IsParamNull(TAG_CONTENT);
    }

    public final String getCONTENT() {
        return this.GetParamStringValue(TAG_CONTENT, "");
    }

    public final void setCONTENT(String strValue) {
        this.SetParamValue(TAG_CONTENT, strValue);
    }

    public final boolean isTITLENull() {
        return this.IsParamNull(TAG_TITLE);
    }

    public final String getTITLE() {
        return this.GetParamStringValue(TAG_TITLE, "");
    }

    public final void setTITLE(String strValue) {
        this.SetParamValue(TAG_TITLE, strValue);
    }

    public final boolean isPICURLNull() {
        return this.IsParamNull(TAG_PICURL);
    }

    public final String getPICURL() {
        return this.GetParamStringValue(TAG_PICURL, "");
    }

    public final void setPICURL(String strValue) {
        this.SetParamValue(TAG_PICURL, strValue);
    }

    public final boolean isDETAILURLNull() {
        return this.IsParamNull(TAG_DETAILURL);
    }

    public final String getDETAILURL() {
        return this.GetParamStringValue(TAG_DETAILURL, "");
    }

    public final void setDETAILURL(String strValue) {
        this.SetParamValue(TAG_DETAILURL, strValue);
    }
}

