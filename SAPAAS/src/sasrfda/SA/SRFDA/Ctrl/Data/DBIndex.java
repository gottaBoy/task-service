/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DBIndex
extends BaseDataEntity {
    public static final String TAG_DBINDEXID = "DBINDEXID";
    public static final String TAG_DBINDEXNAME = "DBINDEXNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_INDEXFIELDS = "INDEXFIELDS";
    public static final String TAG_INCFIELDS = "INCFIELDS";
    public static final String TAG_ALLOWREVERSE = "ALLOWREVERSE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public boolean isDBINDEXIDNull() {
        return this.IsParamNull(TAG_DBINDEXID);
    }

    public String getDBINDEXID() {
        return this.GetParamStringValue(TAG_DBINDEXID, "");
    }

    public void setDBINDEXID(String strValue) {
        this.SetParamValue(TAG_DBINDEXID, strValue);
    }

    public boolean isDBINDEXNAMENull() {
        return this.IsParamNull(TAG_DBINDEXNAME);
    }

    public String getDBINDEXNAME() {
        return this.GetParamStringValue(TAG_DBINDEXNAME, "");
    }

    public void setDBINDEXNAME(String strValue) {
        this.SetParamValue(TAG_DBINDEXNAME, strValue);
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

    public boolean isINDEXFIELDSNull() {
        return this.IsParamNull(TAG_INDEXFIELDS);
    }

    public String getINDEXFIELDS() {
        return this.GetParamStringValue(TAG_INDEXFIELDS, "");
    }

    public void setINDEXFIELDS(String strValue) {
        this.SetParamValue(TAG_INDEXFIELDS, strValue);
    }

    public boolean isINCFIELDSNull() {
        return this.IsParamNull(TAG_INCFIELDS);
    }

    public String getINCFIELDS() {
        return this.GetParamStringValue(TAG_INCFIELDS, "");
    }

    public void setINCFIELDS(String strValue) {
        this.SetParamValue(TAG_INCFIELDS, strValue);
    }

    public boolean isALLOWREVERSENull() {
        return this.IsParamNull(TAG_ALLOWREVERSE);
    }

    public boolean getALLOWREVERSE() {
        return this.GetParamIntValue(TAG_ALLOWREVERSE, 0) == 1;
    }

    public void setALLOWREVERSE(boolean bValue) {
        this.SetParamValue(TAG_ALLOWREVERSE, bValue ? 1 : 0);
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
}

