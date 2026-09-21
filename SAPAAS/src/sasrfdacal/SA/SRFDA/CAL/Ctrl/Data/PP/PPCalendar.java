/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.CAL.Ctrl.Data.PP;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PPCalendar
extends BaseDataEntity {
    public static final String PARAMTYPE = "PP_CALENDAR";
    public static final String TAG_PPCALENDARID = "PPCALENDARID";
    public static final String TAG_PPCALENDARNAME = "PPCALENDARNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_PAGETYPE = "PAGETYPE";
    public static final String TAG_PAGEID = "PAGEID";
    public static final String TAG_PAGENAME = "PAGENAME";
    public static final String TAG_PAGEPARAMTYPEID = "PAGEPARAMTYPEID";
    public static final String TAG_PAGEPARAMTYPENAME = "PAGEPARAMTYPENAME";
    public static final String TAG_CTRLID = "CTRLID";
    public static final String TAG_PPTYPEDESC = "PPTYPEDESC";
    public static final String TAG_STARTHOUR = "STARTHOUR";
    public static final String TAG_ENDHOUR = "ENDHOUR";
    public static final String TAG_DATAPATH = "DATAPATH";
    public static final String TAG_INITVIEW = "INITVIEW";
    public static final String TAG_CALENDARGROUP = "CALENDARGROUP";

    public boolean isPPCALENDARIDNull() {
        return this.IsParamNull(TAG_PPCALENDARID);
    }

    public String getPPCALENDARID() {
        return this.GetParamStringValue(TAG_PPCALENDARID, "");
    }

    public void setPPCALENDARID(String strValue) {
        this.SetParamValue(TAG_PPCALENDARID, strValue);
    }

    public boolean isPPCALENDARNAMENull() {
        return this.IsParamNull(TAG_PPCALENDARNAME);
    }

    public String getPPCALENDARNAME() {
        return this.GetParamStringValue(TAG_PPCALENDARNAME, "");
    }

    public void setPPCALENDARNAME(String strValue) {
        this.SetParamValue(TAG_PPCALENDARNAME, strValue);
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

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isPAGETYPENull() {
        return this.IsParamNull(TAG_PAGETYPE);
    }

    public String getPAGETYPE() {
        return this.GetParamStringValue(TAG_PAGETYPE, "");
    }

    public void setPAGETYPE(String strValue) {
        this.SetParamValue(TAG_PAGETYPE, strValue);
    }

    public boolean isPAGEIDNull() {
        return this.IsParamNull(TAG_PAGEID);
    }

    public String getPAGEID() {
        return this.GetParamStringValue(TAG_PAGEID, "");
    }

    public void setPAGEID(String strValue) {
        this.SetParamValue(TAG_PAGEID, strValue);
    }

    public boolean isPAGENAMENull() {
        return this.IsParamNull(TAG_PAGENAME);
    }

    public String getPAGENAME() {
        return this.GetParamStringValue(TAG_PAGENAME, "");
    }

    public void setPAGENAME(String strValue) {
        this.SetParamValue(TAG_PAGENAME, strValue);
    }

    public boolean isPAGEPARAMTYPEIDNull() {
        return this.IsParamNull(TAG_PAGEPARAMTYPEID);
    }

    public String getPAGEPARAMTYPEID() {
        return this.GetParamStringValue(TAG_PAGEPARAMTYPEID, "");
    }

    public void setPAGEPARAMTYPEID(String strValue) {
        this.SetParamValue(TAG_PAGEPARAMTYPEID, strValue);
    }

    public boolean isPAGEPARAMTYPENAMENull() {
        return this.IsParamNull(TAG_PAGEPARAMTYPENAME);
    }

    public String getPAGEPARAMTYPENAME() {
        return this.GetParamStringValue(TAG_PAGEPARAMTYPENAME, "");
    }

    public void setPAGEPARAMTYPENAME(String strValue) {
        this.SetParamValue(TAG_PAGEPARAMTYPENAME, strValue);
    }

    public boolean isCTRLIDNull() {
        return this.IsParamNull(TAG_CTRLID);
    }

    public String getCTRLID() {
        return this.GetParamStringValue(TAG_CTRLID, "");
    }

    public void setCTRLID(String strValue) {
        this.SetParamValue(TAG_CTRLID, strValue);
    }

    public boolean isPPTYPEDESCNull() {
        return this.IsParamNull(TAG_PPTYPEDESC);
    }

    public String getPPTYPEDESC() {
        return this.GetParamStringValue(TAG_PPTYPEDESC, "");
    }

    public void setPPTYPEDESC(String strValue) {
        this.SetParamValue(TAG_PPTYPEDESC, strValue);
    }

    public boolean isSTARTHOURNull() {
        return this.IsParamNull(TAG_STARTHOUR);
    }

    public int getSTARTHOUR() {
        return this.GetParamIntValue(TAG_STARTHOUR, 0);
    }

    public void setSTARTHOUR(int strValue) {
        this.SetParamValue(TAG_STARTHOUR, strValue);
    }

    public boolean isENDHOURNull() {
        return this.IsParamNull(TAG_ENDHOUR);
    }

    public int getENDHOUR() {
        return this.GetParamIntValue(TAG_ENDHOUR, 0);
    }

    public void setENDHOUR(int strValue) {
        this.SetParamValue(TAG_ENDHOUR, strValue);
    }

    public boolean isDATAPATHNull() {
        return this.IsParamNull(TAG_DATAPATH);
    }

    public String getDATAPATH() {
        return this.GetParamStringValue(TAG_DATAPATH, "");
    }

    public void setDATAPATH(String strValue) {
        this.SetParamValue(TAG_DATAPATH, strValue);
    }

    public boolean isINITVIEWNull() {
        return this.IsParamNull(TAG_INITVIEW);
    }

    public String getINITVIEW() {
        return this.GetParamStringValue(TAG_INITVIEW, "");
    }

    public void setINITVIEW(String strValue) {
        this.SetParamValue(TAG_INITVIEW, strValue);
    }

    public boolean isCALENDARGROUPNull() {
        return this.IsParamNull(TAG_CALENDARGROUP);
    }

    public String getCALENDARGROUP() {
        return this.GetParamStringValue(TAG_CALENDARGROUP, "");
    }

    public void setCALENDARGROUP(String strValue) {
        this.SetParamValue(TAG_CALENDARGROUP, strValue);
    }
}

