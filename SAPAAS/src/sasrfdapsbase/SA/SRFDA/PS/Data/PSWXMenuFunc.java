/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSWXMenuFunc
extends BaseDataEntity {
    public static final String FUNCTYPE_click = "click";
    public static final String FUNCTYPE_view = "view";
    public static final String FUNCTYPE_scancode_push = "scancode_push";
    public static final String FUNCTYPE_scancode_waitmsg = "scancode_waitmsg";
    public static final String FUNCTYPE_pic_sysphoto = "pic_sysphoto";
    public static final String FUNCTYPE_pic_photo_or_album = "pic_photo_or_album";
    public static final String FUNCTYPE_pic_weixin = "pic_weixin";
    public static final String FUNCTYPE_location_select = "location_select";
    public static final String TAG_PSWXMENUFUNCID = "PSWXMENUFUNCID";
    public static final String TAG_PSWXMENUFUNCNAME = "PSWXMENUFUNCNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSWXACCOUNTID = "PSWXACCOUNTID";
    public static final String TAG_PSWXACCOUNTNAME = "PSWXACCOUNTNAME";
    public static final String TAG_FUNCTYPE = "FUNCTYPE";
    public static final String TAG_VIEWURL = "VIEWURL";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CLICKTAG = "CLICKTAG";
    public static final String TAG_PSWXENTAPPID = "PSWXENTAPPID";
    public static final String TAG_PSWXENTAPPNAME = "PSWXENTAPPNAME";

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

    public final boolean isFUNCTYPENull() {
        return this.IsParamNull(TAG_FUNCTYPE);
    }

    public final String getFUNCTYPE() {
        return this.GetParamStringValue(TAG_FUNCTYPE, "");
    }

    public final void setFUNCTYPE(String strValue) {
        this.SetParamValue(TAG_FUNCTYPE, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isCLICKTAGNull() {
        return this.IsParamNull(TAG_CLICKTAG);
    }

    public final String getCLICKTAG() {
        return this.GetParamStringValue(TAG_CLICKTAG, "");
    }

    public final void setCLICKTAG(String strValue) {
        this.SetParamValue(TAG_CLICKTAG, strValue);
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

