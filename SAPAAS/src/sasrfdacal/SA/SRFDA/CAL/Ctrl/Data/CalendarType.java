/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.CAL.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class CalendarType
extends BaseDataEntity {
    public static final String TAG_CALENDARTYPEID = "CALENDARTYPEID";
    public static final String TAG_CALENDARTYPENAME = "CALENDARTYPENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_EDITPATH = "EDITPATH";
    public static final String TAG_COLOR = "COLOR";
    public static final String TAG_ISUSERCREATE = "ISUSERCREATE";
    public static final String TAG_SHOWORDER = "SHOWORDER";
    public static final String TAG_BEGINTIMEDEFNAME = "BEGINTIMEDEFNAME";
    public static final String TAG_ENDTIMEDEFNAME = "ENDTIMEDEFNAME";
    public static final String TAG_CALENDARGROUP = "CALENDARGROUP";
    public static final String TAG_BKCOLOR = "BKCOLOR";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_EDITPAGENAME = "EDITPAGENAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_EDITPAGEID = "EDITPAGEID";

    public String getCALENDARTYPEID() {
        return this.GetParamStringValue(TAG_CALENDARTYPEID, "");
    }

    public void setCALENDARTYPEID(String strValue) {
        this.SetParamValue(TAG_CALENDARTYPEID, strValue);
    }

    public String getCALENDARTYPENAME() {
        return this.GetParamStringValue(TAG_CALENDARTYPENAME, "");
    }

    public void setCALENDARTYPENAME(String strValue) {
        this.SetParamValue(TAG_CALENDARTYPENAME, strValue);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public String getCOLOR() {
        return this.GetParamStringValue(TAG_COLOR, "");
    }

    public void setCOLOR(String strValue) {
        this.SetParamValue(TAG_COLOR, strValue);
    }

    public boolean getISUSERCREATE() {
        return this.GetParamIntValue(TAG_ISUSERCREATE, 0) == 1;
    }

    public void setISUSERCREATE(boolean bValue) {
        this.SetParamValue(TAG_ISUSERCREATE, bValue ? 1 : 0);
    }

    public String getSHOWORDER() {
        return this.GetParamStringValue(TAG_SHOWORDER, "");
    }

    public void setSHOWORDER(String strValue) {
        this.SetParamValue(TAG_SHOWORDER, strValue);
    }

    public String getBEGINTIMEDEFNAME() {
        return this.GetParamStringValue(TAG_BEGINTIMEDEFNAME, "");
    }

    public void setBEGINTIMEDEFNAME(String strValue) {
        this.SetParamValue(TAG_BEGINTIMEDEFNAME, strValue);
    }

    public String getENDTIMEDEFNAME() {
        return this.GetParamStringValue(TAG_ENDTIMEDEFNAME, "");
    }

    public void setENDTIMEDEFNAME(String strValue) {
        this.SetParamValue(TAG_ENDTIMEDEFNAME, strValue);
    }

    public String getCALENDARGROUP() {
        return this.GetParamStringValue(TAG_CALENDARGROUP, "");
    }

    public void setCALENDARGROUP(String strValue) {
        this.SetParamValue(TAG_CALENDARGROUP, strValue);
    }

    public String getBKCOLOR() {
        return this.GetParamStringValue(TAG_BKCOLOR, "");
    }

    public void setBKCOLOR(String strValue) {
        this.SetParamValue(TAG_BKCOLOR, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getEDITPAGENAME() {
        return this.GetParamStringValue(TAG_EDITPAGENAME, "");
    }

    public void setEDITPAGENAME(String strValue) {
        this.SetParamValue(TAG_EDITPAGENAME, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getEDITPAGEID() {
        return this.GetParamStringValue(TAG_EDITPAGEID, "");
    }

    public void setEDITPAGEID(String strValue) {
        this.SetParamValue(TAG_EDITPAGEID, strValue);
    }
}

