/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class Message
extends BaseDataEntity {
    public static final String TAG_MESSAGEID = "MESSAGEID";
    public static final String TAG_MESSAGENAME = "MESSAGENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MSGFOLDER = "MSGFOLDER";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_ISREADFLAG = "ISREADFLAG";
    public static final String TAG_MSGTO = "MSGTO";
    public static final String TAG_MSGCC = "MSGCC";
    public static final String TAG_ATTACHMENTS = "ATTACHMENTS";
    public static final String TAG_MSGSIZE = "MSGSIZE";
    public static final String TAG_SENDTIME = "SENDTIME";
    public static final String TAG_RECVTIME = "RECVTIME";
    public static final String TAG_SENDDAY = "SENDDAY";
    public static final String TAG_RECVDAY = "RECVDAY";
    public static final String TAG_MESSAGETYPE = "MESSAGETYPE";
    public static final String TAG_MSGTAG = "MSGTAG";
    public static final String TAG_JOINID = "JOINID";
    public static final String TAG_MSGTAG2 = "MSGTAG2";
    public static final String TAG_MSGTAGNAME = "MSGTAGNAME";
    public static final String TAG_MSGACCOUNTNAME = "MSGACCOUNTNAME";
    public static final String TAG_MSGFROMACCOUNTNAME = "MSGFROMACCOUNTNAME";
    public static final String TAG_FROMMSGADDRESS = "FROMMSGADDRESS";
    public static final String TAG_MSGACCOUNTID = "MSGACCOUNTID";
    public static final String TAG_MSGFROMACCOUNTID = "MSGFROMACCOUNTID";

    public String getMESSAGEID() {
        return this.GetParamStringValue(TAG_MESSAGEID, "");
    }

    public void setMESSAGEID(String strValue) {
        this.SetParamValue(TAG_MESSAGEID, strValue);
    }

    public String getMESSAGENAME() {
        return this.GetParamStringValue(TAG_MESSAGENAME, "");
    }

    public void setMESSAGENAME(String strValue) {
        this.SetParamValue(TAG_MESSAGENAME, strValue);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public String getMSGFOLDER() {
        return this.GetParamStringValue(TAG_MSGFOLDER, "");
    }

    public void setMSGFOLDER(String strValue) {
        this.SetParamValue(TAG_MSGFOLDER, strValue);
    }

    public String getCONTENT() {
        return this.GetParamStringValue(TAG_CONTENT, "");
    }

    public void setCONTENT(String strValue) {
        this.SetParamValue(TAG_CONTENT, strValue);
    }

    public boolean getISREADFLAG() {
        return this.GetParamIntValue(TAG_ISREADFLAG, 0) == 1;
    }

    public void setISREADFLAG(boolean bValue) {
        this.SetParamValue(TAG_ISREADFLAG, bValue ? 1 : 0);
    }

    public String getMSGTO() {
        return this.GetParamStringValue(TAG_MSGTO, "");
    }

    public void setMSGTO(String strValue) {
        this.SetParamValue(TAG_MSGTO, strValue);
    }

    public String getMSGCC() {
        return this.GetParamStringValue(TAG_MSGCC, "");
    }

    public void setMSGCC(String strValue) {
        this.SetParamValue(TAG_MSGCC, strValue);
    }

    public String getATTACHMENTS() {
        return this.GetParamStringValue(TAG_ATTACHMENTS, "");
    }

    public void setATTACHMENTS(String strValue) {
        this.SetParamValue(TAG_ATTACHMENTS, strValue);
    }

    public float getMSGSIZE() {
        return this.GetParamFloatValue(TAG_MSGSIZE, 0.0f);
    }

    public void setMSGSIZE(float strValue) {
        this.SetParamValue(TAG_MSGSIZE, Float.valueOf(strValue));
    }

    public Date getSENDTIME() {
        return this.GetParamDateValue(TAG_SENDTIME, null);
    }

    public void setSENDTIME(Date strValue) {
        this.SetParamValue(TAG_SENDTIME, strValue);
    }

    public Date getRECVTIME() {
        return this.GetParamDateValue(TAG_RECVTIME, null);
    }

    public void setRECVTIME(Date strValue) {
        this.SetParamValue(TAG_RECVTIME, strValue);
    }

    public Date getSENDDAY() {
        return this.GetParamDateValue(TAG_SENDDAY, null);
    }

    public void setSENDDAY(Date strValue) {
        this.SetParamValue(TAG_SENDDAY, strValue);
    }

    public Date getRECVDAY() {
        return this.GetParamDateValue(TAG_RECVDAY, null);
    }

    public void setRECVDAY(Date strValue) {
        this.SetParamValue(TAG_RECVDAY, strValue);
    }

    public String getMESSAGETYPE() {
        return this.GetParamStringValue(TAG_MESSAGETYPE, "");
    }

    public void setMESSAGETYPE(String strValue) {
        this.SetParamValue(TAG_MESSAGETYPE, strValue);
    }

    public String getMSGTAG() {
        return this.GetParamStringValue(TAG_MSGTAG, "");
    }

    public void setMSGTAG(String strValue) {
        this.SetParamValue(TAG_MSGTAG, strValue);
    }

    public String getJOINID() {
        return this.GetParamStringValue(TAG_JOINID, "");
    }

    public void setJOINID(String strValue) {
        this.SetParamValue(TAG_JOINID, strValue);
    }

    public String getMSGTAG2() {
        return this.GetParamStringValue(TAG_MSGTAG2, "");
    }

    public void setMSGTAG2(String strValue) {
        this.SetParamValue(TAG_MSGTAG2, strValue);
    }

    public String getMSGTAGNAME() {
        return this.GetParamStringValue(TAG_MSGTAGNAME, "");
    }

    public void setMSGTAGNAME(String strValue) {
        this.SetParamValue(TAG_MSGTAGNAME, strValue);
    }

    public String getMSGACCOUNTNAME() {
        return this.GetParamStringValue(TAG_MSGACCOUNTNAME, "");
    }

    public void setMSGACCOUNTNAME(String strValue) {
        this.SetParamValue(TAG_MSGACCOUNTNAME, strValue);
    }

    public String getMSGFROMACCOUNTNAME() {
        return this.GetParamStringValue(TAG_MSGFROMACCOUNTNAME, "");
    }

    public void setMSGFROMACCOUNTNAME(String strValue) {
        this.SetParamValue(TAG_MSGFROMACCOUNTNAME, strValue);
    }

    public String getFROMMSGADDRESS() {
        return this.GetParamStringValue(TAG_FROMMSGADDRESS, "");
    }

    public void setFROMMSGADDRESS(String strValue) {
        this.SetParamValue(TAG_FROMMSGADDRESS, strValue);
    }

    public String getMSGACCOUNTID() {
        return this.GetParamStringValue(TAG_MSGACCOUNTID, "");
    }

    public void setMSGACCOUNTID(String strValue) {
        this.SetParamValue(TAG_MSGACCOUNTID, strValue);
    }

    public String getMSGFROMACCOUNTID() {
        return this.GetParamStringValue(TAG_MSGFROMACCOUNTID, "");
    }

    public void setMSGFROMACCOUNTID(String strValue) {
        this.SetParamValue(TAG_MSGFROMACCOUNTID, strValue);
    }
}

