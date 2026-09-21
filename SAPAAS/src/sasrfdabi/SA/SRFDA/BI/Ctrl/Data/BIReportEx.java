/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIReportEx
extends BaseDataEntity {
    public static final String TAG_BIREPORTEXID = "BIREPORTEXID";
    public static final String TAG_BIREPORTEXNAME = "BIREPORTEXNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BICUBEID = "BICUBEID";
    public static final String TAG_BICUBENAME = "BICUBENAME";
    public static final String TAG_ENABLEMSGROUP = "ENABLEMSGROUP";
    public static final String TAG_COLHEADERMSFIRST = "COLHEADERMSFIRST";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_PAGESIZE = "PAGESIZE";

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

    public boolean isBICUBEIDNull() {
        return this.IsParamNull(TAG_BICUBEID);
    }

    public String getBICUBEID() {
        return this.GetParamStringValue(TAG_BICUBEID, "");
    }

    public void setBICUBEID(String strValue) {
        this.SetParamValue(TAG_BICUBEID, strValue);
    }

    public boolean isBICUBENAMENull() {
        return this.IsParamNull(TAG_BICUBENAME);
    }

    public String getBICUBENAME() {
        return this.GetParamStringValue(TAG_BICUBENAME, "");
    }

    public void setBICUBENAME(String strValue) {
        this.SetParamValue(TAG_BICUBENAME, strValue);
    }

    public boolean isENABLEMSGROUPNull() {
        return this.IsParamNull(TAG_ENABLEMSGROUP);
    }

    public boolean getENABLEMSGROUP() {
        return this.GetParamIntValue(TAG_ENABLEMSGROUP, 0) == 1;
    }

    public void setENABLEMSGROUP(boolean bValue) {
        this.SetParamValue(TAG_ENABLEMSGROUP, bValue ? 1 : 0);
    }

    public boolean isCOLHEADERMSFIRSTNull() {
        return this.IsParamNull(TAG_COLHEADERMSFIRST);
    }

    public boolean getCOLHEADERMSFIRST() {
        return this.GetParamIntValue(TAG_COLHEADERMSFIRST, 0) == 1;
    }

    public void setCOLHEADERMSFIRST(boolean bValue) {
        this.SetParamValue(TAG_COLHEADERMSFIRST, bValue ? 1 : 0);
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

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isPAGESIZENull() {
        return this.IsParamNull(TAG_PAGESIZE);
    }

    public int getPAGESIZE() {
        return this.GetParamIntValue(TAG_PAGESIZE, 0);
    }

    public void setPAGESIZE(int strValue) {
        this.SetParamValue(TAG_PAGESIZE, strValue);
    }
}

