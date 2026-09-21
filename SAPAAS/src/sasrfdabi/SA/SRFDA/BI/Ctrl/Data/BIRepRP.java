/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIRepRP
extends BaseDataEntity {
    public static final String TAG_BIREPRPID = "BIREPRPID";
    public static final String TAG_BIREPRPNAME = "BIREPRPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BIREPORTEXID = "BIREPORTEXID";
    public static final String TAG_BIREPORTEXNAME = "BIREPORTEXNAME";
    public static final String TAG_BIREPPANELID = "BIREPPANELID";
    public static final String TAG_BIREPPANELNAME = "BIREPPANELNAME";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";

    public boolean isBIREPRPIDNull() {
        return this.IsParamNull(TAG_BIREPRPID);
    }

    public String getBIREPRPID() {
        return this.GetParamStringValue(TAG_BIREPRPID, "");
    }

    public void setBIREPRPID(String strValue) {
        this.SetParamValue(TAG_BIREPRPID, strValue);
    }

    public boolean isBIREPRPNAMENull() {
        return this.IsParamNull(TAG_BIREPRPNAME);
    }

    public String getBIREPRPNAME() {
        return this.GetParamStringValue(TAG_BIREPRPNAME, "");
    }

    public void setBIREPRPNAME(String strValue) {
        this.SetParamValue(TAG_BIREPRPNAME, strValue);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public boolean isBIREPORTEXIDNull() {
        return this.IsParamNull(TAG_BIREPORTEXID);
    }

    public String getBIREPORTEXID() {
        return this.GetParamStringValue(TAG_BIREPORTEXID, "");
    }

    public void setBIREPORTEXID(String strValue) {
        this.SetParamValue(TAG_BIREPORTEXID, strValue);
    }

    public boolean isBIREPORTEXNAMENull() {
        return this.IsParamNull(TAG_BIREPORTEXNAME);
    }

    public String getBIREPORTEXNAME() {
        return this.GetParamStringValue(TAG_BIREPORTEXNAME, "");
    }

    public void setBIREPORTEXNAME(String strValue) {
        this.SetParamValue(TAG_BIREPORTEXNAME, strValue);
    }

    public boolean isBIREPPANELIDNull() {
        return this.IsParamNull(TAG_BIREPPANELID);
    }

    public String getBIREPPANELID() {
        return this.GetParamStringValue(TAG_BIREPPANELID, "");
    }

    public void setBIREPPANELID(String strValue) {
        this.SetParamValue(TAG_BIREPPANELID, strValue);
    }

    public boolean isBIREPPANELNAMENull() {
        return this.IsParamNull(TAG_BIREPPANELNAME);
    }

    public String getBIREPPANELNAME() {
        return this.GetParamStringValue(TAG_BIREPPANELNAME, "");
    }

    public void setBIREPPANELNAME(String strValue) {
        this.SetParamValue(TAG_BIREPPANELNAME, strValue);
    }

    public boolean isORDERFLAGNull() {
        return this.IsParamNull(TAG_ORDERFLAG);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int strValue) {
        this.SetParamValue(TAG_ORDERFLAG, strValue);
    }
}

