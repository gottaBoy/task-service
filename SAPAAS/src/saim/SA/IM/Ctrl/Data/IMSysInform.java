/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.sql.Timestamp;
import java.util.Date;

public class IMSysInform
extends BaseDataEntity {
    public static final String RECEIVERTYPE_ALL = "ALL";
    public static final String RECEIVERTYPE_USER = "USER";
    public static final String TAG_IMSYSINFORMID = "IMSYSINFORMID";
    public static final String TAG_IMSYSINFORMNAME = "IMSYSINFORMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RECEIVERTYPE = "RECEIVERTYPE";
    public static final String TAG_RECEIVER = "RECEIVER";
    public static final String TAG_INFORMTIME = "INFORMTIME";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_RICHCONTENT = "RICHCONTENT";

    public final boolean isIMSYSINFORMIDNull() {
        return this.IsParamNull(TAG_IMSYSINFORMID);
    }

    public final String getIMSYSINFORMID() {
        return this.GetParamStringValue(TAG_IMSYSINFORMID, "");
    }

    public final void setIMSYSINFORMID(String strValue) {
        this.SetParamValue(TAG_IMSYSINFORMID, strValue);
    }

    public final boolean isIMSYSINFORMNAMENull() {
        return this.IsParamNull(TAG_IMSYSINFORMNAME);
    }

    public final String getIMSYSINFORMNAME() {
        return this.GetParamStringValue(TAG_IMSYSINFORMNAME, "");
    }

    public final void setIMSYSINFORMNAME(String strValue) {
        this.SetParamValue(TAG_IMSYSINFORMNAME, strValue);
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

    public final boolean isRECEIVERTYPENull() {
        return this.IsParamNull(TAG_RECEIVERTYPE);
    }

    public final String getRECEIVERTYPE() {
        return this.GetParamStringValue(TAG_RECEIVERTYPE, "");
    }

    public final void setRECEIVERTYPE(String strValue) {
        this.SetParamValue(TAG_RECEIVERTYPE, strValue);
    }

    public final boolean isRECEIVERNull() {
        return this.IsParamNull(TAG_RECEIVER);
    }

    public final String getRECEIVER() {
        return this.GetParamStringValue(TAG_RECEIVER, "");
    }

    public final void setRECEIVER(String strValue) {
        this.SetParamValue(TAG_RECEIVER, strValue);
    }

    public final boolean isINFORMTIMENull() {
        return this.IsParamNull(TAG_INFORMTIME);
    }

    public final Timestamp getINFORMTIME() {
        return this.GetParamTimestampValue(TAG_INFORMTIME, null);
    }

    public final void setINFORMTIME(Timestamp dtValue) {
        this.SetParamValue(TAG_INFORMTIME, dtValue);
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

    public final boolean isRICHCONTENTNull() {
        return this.IsParamNull(TAG_RICHCONTENT);
    }

    public final String getRICHCONTENT() {
        return this.GetParamStringValue(TAG_RICHCONTENT, "");
    }

    public final void setRICHCONTENT(String strValue) {
        this.SetParamValue(TAG_RICHCONTENT, strValue);
    }
}

