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

public class IMUserInform
extends BaseDataEntity {
    public static final String RECEIVERTYPE_ALL = "ALL";
    public static final String RECEIVERTYPE_USER = "USER";
    public static final int IMPORTANCEFLAG_LOW = 10;
    public static final int IMPORTANCEFLAG_NORMAL = 20;
    public static final int IMPORTANCEFLAG_HIGH = 30;
    public static final String TAG_IMUSERINFORMID = "IMUSERINFORMID";
    public static final String TAG_IMUSERINFORMNAME = "IMUSERINFORMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SENDER = "SENDER";
    public static final String TAG_INFORMTIME = "INFORMTIME";
    public static final String TAG_EXPIREDTIME = "EXPIREDTIME";
    public static final String TAG_RECEIVERTYPE = "RECEIVERTYPE";
    public static final String TAG_RECEIVER = "RECEIVER";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_RICHCONTENT = "RICHCONTENT";
    public static final String TAG_CANCELFLAG = "CANCELFLAG";
    public static final String TAG_IMPORTANCEFLAG = "IMPORTANCEFLAG";
    public static final String TAG_URL = "URL";
    public static final String TAG_INFORMTYPE = "INFORMTYPE";

    public final boolean isIMUSERINFORMIDNull() {
        return this.IsParamNull(TAG_IMUSERINFORMID);
    }

    public final String getIMUSERINFORMID() {
        return this.GetParamStringValue(TAG_IMUSERINFORMID, "");
    }

    public final void setIMUSERINFORMID(String strValue) {
        this.SetParamValue(TAG_IMUSERINFORMID, strValue);
    }

    public final boolean isIMUSERINFORMNAMENull() {
        return this.IsParamNull(TAG_IMUSERINFORMNAME);
    }

    public final String getIMUSERINFORMNAME() {
        return this.GetParamStringValue(TAG_IMUSERINFORMNAME, "");
    }

    public final void setIMUSERINFORMNAME(String strValue) {
        this.SetParamValue(TAG_IMUSERINFORMNAME, strValue);
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

    public final boolean isSENDERNull() {
        return this.IsParamNull(TAG_SENDER);
    }

    public final String getSENDER() {
        return this.GetParamStringValue(TAG_SENDER, "");
    }

    public final void setSENDER(String strValue) {
        this.SetParamValue(TAG_SENDER, strValue);
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

    public final boolean isEXPIREDTIMENull() {
        return this.IsParamNull(TAG_EXPIREDTIME);
    }

    public final Timestamp getEXPIREDTIME() {
        return this.GetParamTimestampValue(TAG_EXPIREDTIME, null);
    }

    public final void setEXPIREDTIME(Timestamp dtValue) {
        this.SetParamValue(TAG_EXPIREDTIME, dtValue);
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

    public final boolean isCANCELFLAGNull() {
        return this.IsParamNull(TAG_CANCELFLAG);
    }

    public final boolean getCANCELFLAG() {
        return this.GetParamIntValue(TAG_CANCELFLAG, 0) == 1;
    }

    public final void setCANCELFLAG(boolean bValue) {
        this.SetParamValue(TAG_CANCELFLAG, bValue ? 1 : 0);
    }

    public final boolean isIMPORTANCEFLAGNull() {
        return this.IsParamNull(TAG_IMPORTANCEFLAG);
    }

    public final int getIMPORTANCEFLAG() {
        return this.GetParamIntValue(TAG_IMPORTANCEFLAG, 0);
    }

    public final void setIMPORTANCEFLAG(int nValue) {
        this.SetParamValue(TAG_IMPORTANCEFLAG, nValue);
    }

    public final boolean isURLNull() {
        return this.IsParamNull(TAG_URL);
    }

    public final String getURL() {
        return this.GetParamStringValue(TAG_URL, "");
    }

    public final void setURL(String strValue) {
        this.SetParamValue(TAG_URL, strValue);
    }

    public final boolean isINFORMTYPENull() {
        return this.IsParamNull(TAG_INFORMTYPE);
    }

    public final int getINFORMTYPE() {
        return this.GetParamIntValue(TAG_INFORMTYPE, 0);
    }

    public final void setINFORMTYPE(int nValue) {
        this.SetParamValue(TAG_INFORMTYPE, nValue);
    }
}

