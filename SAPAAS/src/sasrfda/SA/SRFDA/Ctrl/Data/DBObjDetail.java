/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DBObjDetail
extends BaseDataEntity {
    public static final String TAG_DBOBJDETAILID = "DBOBJDETAILID";
    public static final String TAG_DBOBJDETAILNAME = "DBOBJDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DBOBJECTID = "DBOBJECTID";
    public static final String TAG_DBOBJECTNAME = "DBOBJECTNAME";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_OBJCODE = "OBJCODE";
    public static final String TAG_AFTERCREATECODE = "AFTERCREATECODE";
    public static final String TAG_AFTERCREATECODE2 = "AFTERCREATECODE2";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_VERSION = "VERSION";

    public boolean isDBOBJDETAILIDNull() {
        return this.IsParamNull(TAG_DBOBJDETAILID);
    }

    public String getDBOBJDETAILID() {
        return this.GetParamStringValue(TAG_DBOBJDETAILID, "");
    }

    public void setDBOBJDETAILID(String strValue) {
        this.SetParamValue(TAG_DBOBJDETAILID, strValue);
    }

    public boolean isDBOBJDETAILNAMENull() {
        return this.IsParamNull(TAG_DBOBJDETAILNAME);
    }

    public String getDBOBJDETAILNAME() {
        return this.GetParamStringValue(TAG_DBOBJDETAILNAME, "");
    }

    public void setDBOBJDETAILNAME(String strValue) {
        this.SetParamValue(TAG_DBOBJDETAILNAME, strValue);
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

    public boolean isDBOBJECTIDNull() {
        return this.IsParamNull(TAG_DBOBJECTID);
    }

    public String getDBOBJECTID() {
        return this.GetParamStringValue(TAG_DBOBJECTID, "");
    }

    public void setDBOBJECTID(String strValue) {
        this.SetParamValue(TAG_DBOBJECTID, strValue);
    }

    public boolean isDBOBJECTNAMENull() {
        return this.IsParamNull(TAG_DBOBJECTNAME);
    }

    public String getDBOBJECTNAME() {
        return this.GetParamStringValue(TAG_DBOBJECTNAME, "");
    }

    public void setDBOBJECTNAME(String strValue) {
        this.SetParamValue(TAG_DBOBJECTNAME, strValue);
    }

    public boolean isDBTYPENull() {
        return this.IsParamNull(TAG_DBTYPE);
    }

    public String getDBTYPE() {
        return this.GetParamStringValue(TAG_DBTYPE, "");
    }

    public void setDBTYPE(String strValue) {
        this.SetParamValue(TAG_DBTYPE, strValue);
    }

    public boolean isOBJCODENull() {
        return this.IsParamNull(TAG_OBJCODE);
    }

    public String getOBJCODE() {
        return this.GetParamStringValue(TAG_OBJCODE, "");
    }

    public void setOBJCODE(String strValue) {
        this.SetParamValue(TAG_OBJCODE, strValue);
    }

    public boolean isAFTERCREATECODENull() {
        return this.IsParamNull(TAG_AFTERCREATECODE);
    }

    public String getAFTERCREATECODE() {
        return this.GetParamStringValue(TAG_AFTERCREATECODE, "");
    }

    public void setAFTERCREATECODE(String strValue) {
        this.SetParamValue(TAG_AFTERCREATECODE, strValue);
    }

    public boolean isAFTERCREATECODE2Null() {
        return this.IsParamNull(TAG_AFTERCREATECODE2);
    }

    public String getAFTERCREATECODE2() {
        return this.GetParamStringValue(TAG_AFTERCREATECODE2, "");
    }

    public void setAFTERCREATECODE2(String strValue) {
        this.SetParamValue(TAG_AFTERCREATECODE2, strValue);
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

    public boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }
}

