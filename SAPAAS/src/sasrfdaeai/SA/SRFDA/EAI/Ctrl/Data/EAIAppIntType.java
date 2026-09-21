/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class EAIAppIntType
extends BaseDataEntity {
    public static final String EAIAPPINT_TCP = "EAIAPPINT_TCP";
    public static final String EAIAPPINT_UDP = "EAIAPPINT_UDP";
    public static final String EAIAPPINT_HTTP = "EAIAPPINT_HTTP";
    public static final String EAIAPPINT_WEBSERVICE = "EAIAPPINT_WEBSERVICE";
    public static final String EAIAPPINT_EJB = "EAIAPPINT_EJB";
    public static final String EAIAPPINT_SMTP = "EAIAPPINT_SMTP";
    public static final String EAIAPPINT_POP3 = "EAIAPPINT_POP3";
    public static final String EAIAPPINT_IMAP = "EAIAPPINT_IMAP";
    public static final String EAIAPPINT_FILE = "EAIAPPINT_FILE";
    public static final String EAIAPPINT_FTP = "EAIAPPINT_FTP";
    public static final String EAIAPPINT_HTTPS = "EAIAPPINT_HTTPS";
    public static final String EAIAPPINT_JMS = "EAIAPPINT_JMS";
    public static final String EAIAPPINT_RMI = "EAIAPPINT_RMI";
    public static final String EAIAPPINT_FTP_MAIN = "EAIAPPINT_FTP_MAIN";
    public static final String EAIAPPINT_HTTP_MAIN = "EAIAPPINT_HTTP_MAIN";
    public static final String EAIAPPINT_HTTPS_MAIN = "EAIAPPINT_HTTPS_MAIN";
    public static final String EAIAPPINT_JMS_MAIN = "EAIAPPINT_JMS_MAIN";
    public static final String EAIAPPINT_POP3_MAIN = "EAIAPPINT_POP3_MAIN";
    public static final String EAIAPPINT_TCP_MAIN = "EAIAPPINT_TCP_MAIN";
    public static final String EAIAPPINT_UDP_MAIN = "EAIAPPINT_UDP_MAIN";
    public static final String EAIAPPINT_WEBSERVICE_MAIN = "EAIAPPINT_WEBSERVICE_MAIN";
    public static final String EAIAPPINT_SIMPLEWS_MAIN = "EAIAPPINT_SIMPLEWS_MAIN";
    public static final String EAIAPPINT_FTP_POLLING = "EAIAPPINT_FTP_POLLING";
    public static final String EAIAPPINT_FILE_POLLING = "EAIAPPINT_FILE_POLLING";
    public static final String TAG_EAIAPPINTTYPEID = "EAIAPPINTTYPEID";
    public static final String TAG_EAIAPPINTTYPENAME = "EAIAPPINTTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_EDITPATH = "EDITPATH";
    public static final String TAG_ICONPATH = "ICONPATH";
    public static final String TAG_SHOWORDER = "SHOWORDER";

    public String getEAIAPPINTTYPEID() {
        return this.GetParamStringValue(TAG_EAIAPPINTTYPEID, "");
    }

    public void setEAIAPPINTTYPEID(String strValue) {
        this.SetParamValue(TAG_EAIAPPINTTYPEID, strValue);
    }

    public String getEAIAPPINTTYPENAME() {
        return this.GetParamStringValue(TAG_EAIAPPINTTYPENAME, "");
    }

    public void setEAIAPPINTTYPENAME(String strValue) {
        this.SetParamValue(TAG_EAIAPPINTTYPENAME, strValue);
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

    public String getEDITPATH() {
        return this.GetParamStringValue(TAG_EDITPATH, "");
    }

    public void setEDITPATH(String strValue) {
        this.SetParamValue(TAG_EDITPATH, strValue);
    }

    public String getICONPATH() {
        return this.GetParamStringValue(TAG_ICONPATH, "");
    }

    public void setICONPATH(String strValue) {
        this.SetParamValue(TAG_ICONPATH, strValue);
    }

    public String getSHOWORDER() {
        return this.GetParamStringValue(TAG_SHOWORDER, "");
    }

    public void setSHOWORDER(String strValue) {
        this.SetParamValue(TAG_SHOWORDER, strValue);
    }
}

