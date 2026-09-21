/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class MBList
extends BaseDataEntity {
    public static final int MBLISTTYPE_MAIN = 1;
    public static final int MBLISTTYPE_PICKUP = 2;
    public static final String TAG_MBLISTID = "MBLISTID";
    public static final String TAG_MBLISTNAME = "MBLISTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MBUIPARTTYPE = "MBUIPARTTYPE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_ITEMTPL = "ITEMTPL";
    public static final String TAG_ITEMTPLFUNC = "ITEMTPLFUNC";
    public static final String TAG_MAINFLAG = "MAINFLAG";
    public static final String TAG_PICKUPFLAG = "PICKUPFLAG";
    public static final String TAG_MAINPRIORITY = "MAINPRIORITY";
    public static final String TAG_PICKUPPRIORITY = "PICKUPPRIORITY";
    public static final String TAG_DSITEMS = "DSITEMS";

    public boolean isMBLISTIDNull() {
        return this.IsParamNull(TAG_MBLISTID);
    }

    public String getMBLISTID() {
        return this.GetParamStringValue(TAG_MBLISTID, "");
    }

    public void setMBLISTID(String strValue) {
        this.SetParamValue(TAG_MBLISTID, strValue);
    }

    public boolean isMBLISTNAMENull() {
        return this.IsParamNull(TAG_MBLISTNAME);
    }

    public String getMBLISTNAME() {
        return this.GetParamStringValue(TAG_MBLISTNAME, "");
    }

    public void setMBLISTNAME(String strValue) {
        this.SetParamValue(TAG_MBLISTNAME, strValue);
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

    public boolean isMBUIPARTTYPENull() {
        return this.IsParamNull(TAG_MBUIPARTTYPE);
    }

    public String getMBUIPARTTYPE() {
        return this.GetParamStringValue(TAG_MBUIPARTTYPE, "");
    }

    public void setMBUIPARTTYPE(String strValue) {
        this.SetParamValue(TAG_MBUIPARTTYPE, strValue);
    }

    public boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public boolean isDENAMENull() {
        return this.IsParamNull(TAG_DENAME);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public boolean isITEMTPLNull() {
        return this.IsParamNull(TAG_ITEMTPL);
    }

    public String getITEMTPL() {
        return this.GetParamStringValue(TAG_ITEMTPL, "");
    }

    public void setITEMTPL(String strValue) {
        this.SetParamValue(TAG_ITEMTPL, strValue);
    }

    public boolean isITEMTPLFUNCNull() {
        return this.IsParamNull(TAG_ITEMTPLFUNC);
    }

    public String getITEMTPLFUNC() {
        return this.GetParamStringValue(TAG_ITEMTPLFUNC, "");
    }

    public void setITEMTPLFUNC(String strValue) {
        this.SetParamValue(TAG_ITEMTPLFUNC, strValue);
    }

    public boolean isMAINFLAGNull() {
        return this.IsParamNull(TAG_MAINFLAG);
    }

    public boolean getMAINFLAG() {
        return this.GetParamIntValue(TAG_MAINFLAG, 0) == 1;
    }

    public void setMAINFLAG(boolean bValue) {
        this.SetParamValue(TAG_MAINFLAG, bValue ? 1 : 0);
    }

    public boolean isPICKUPFLAGNull() {
        return this.IsParamNull(TAG_PICKUPFLAG);
    }

    public boolean getPICKUPFLAG() {
        return this.GetParamIntValue(TAG_PICKUPFLAG, 0) == 1;
    }

    public void setPICKUPFLAG(boolean bValue) {
        this.SetParamValue(TAG_PICKUPFLAG, bValue ? 1 : 0);
    }

    public boolean isMAINPRIORITYNull() {
        return this.IsParamNull(TAG_MAINPRIORITY);
    }

    public int getMAINPRIORITY() {
        return this.GetParamIntValue(TAG_MAINPRIORITY, 0);
    }

    public void setMAINPRIORITY(int strValue) {
        this.SetParamValue(TAG_MAINPRIORITY, strValue);
    }

    public boolean isPICKUPPRIORITYNull() {
        return this.IsParamNull(TAG_PICKUPPRIORITY);
    }

    public int getPICKUPPRIORITY() {
        return this.GetParamIntValue(TAG_PICKUPPRIORITY, 0);
    }

    public void setPICKUPPRIORITY(int strValue) {
        this.SetParamValue(TAG_PICKUPPRIORITY, strValue);
    }

    public boolean isDSITEMSNull() {
        return this.IsParamNull(TAG_DSITEMS);
    }

    public String getDSITEMS() {
        return this.GetParamStringValue(TAG_DSITEMS, "");
    }

    public void setDSITEMS(String strValue) {
        this.SetParamValue(TAG_DSITEMS, strValue);
    }
}

