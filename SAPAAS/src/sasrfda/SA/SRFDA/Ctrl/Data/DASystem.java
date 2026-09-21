/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DASystem
extends BaseDataEntity {
    public static final String TAG_SYSTEMID = "SYSTEMID";
    public static final String TAG_SYSTEMNAME = "SYSTEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_SYSTEMTYPE = "SYSTEMTYPE";
    public static final String TAG_SERVICE = "SERVICE";
    public static final String TAG_SYSTEMFUN = "SYSTEMFUN";
    public static final String TAG_FUNLIC = "FUNLIC";
    public static final String TAG_SYSTEMADDR = "SYSTEMADDR";
    public static final String TAG_AURLOGINADDR = "AURLOGINADDR";
    public static final String TAG_AURLOGOUTADDR = "AURLOGOUTADDR";
    public static final String TAG_BIGICON = "BIGICON";
    public static final String TAG_SYSTEMPARAM = "SYSTEMPARAM";

    public String getSYSTEMID() {
        return this.GetParamStringValue(TAG_SYSTEMID, "");
    }

    public void setSYSTEMID(String strValue) {
        this.SetParamValue(TAG_SYSTEMID, strValue);
    }

    public String getSYSTEMNAME() {
        return this.GetParamStringValue(TAG_SYSTEMNAME, "");
    }

    public void setSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_SYSTEMNAME, strValue);
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

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public String getSYSTEMTYPE() {
        return this.GetParamStringValue(TAG_SYSTEMTYPE, "");
    }

    public void setSYSTEMTYPE(String strValue) {
        this.SetParamValue(TAG_SYSTEMTYPE, strValue);
    }

    public String getSERVICE() {
        return this.GetParamStringValue(TAG_SERVICE, "");
    }

    public void setSERVICE(String strValue) {
        this.SetParamValue(TAG_SERVICE, strValue);
    }

    public String getSYSTEMFUN() {
        return this.GetParamStringValue(TAG_SYSTEMFUN, "");
    }

    public void setSYSTEMFUN(String strValue) {
        this.SetParamValue(TAG_SYSTEMFUN, strValue);
    }

    public String getFUNLIC() {
        return this.GetParamStringValue(TAG_FUNLIC, "");
    }

    public void setFUNLIC(String strValue) {
        this.SetParamValue(TAG_FUNLIC, strValue);
    }

    public String getSYSTEMADDR() {
        return this.GetParamStringValue(TAG_SYSTEMADDR, "");
    }

    public void setSYSTEMADDR(String strValue) {
        this.SetParamValue(TAG_SYSTEMADDR, strValue);
    }

    public String getAURLOGINADDR() {
        return this.GetParamStringValue(TAG_AURLOGINADDR, "");
    }

    public void setAURLOGINADDR(String strValue) {
        this.SetParamValue(TAG_AURLOGINADDR, strValue);
    }

    public String getAURLOGOUTADDR() {
        return this.GetParamStringValue(TAG_AURLOGOUTADDR, "");
    }

    public void setAURLOGOUTADDR(String strValue) {
        this.SetParamValue(TAG_AURLOGOUTADDR, strValue);
    }

    public String getBIGICON() {
        return this.GetParamStringValue(TAG_BIGICON, "");
    }

    public void setBIGICON(String strValue) {
        this.SetParamValue(TAG_BIGICON, strValue);
    }

    public String getSYSTEMPARAM() {
        return this.GetParamStringValue(TAG_SYSTEMPARAM, "");
    }

    public void setSYSTEMPARAM(String strValue) {
        this.SetParamValue(TAG_SYSTEMPARAM, strValue);
    }
}

