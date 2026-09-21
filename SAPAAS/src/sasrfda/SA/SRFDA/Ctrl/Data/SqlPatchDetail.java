/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class SqlPatchDetail
extends BaseDataEntity {
    public static final String TAG_SQLPATCHDETAILID = "SQLPATCHDETAILID";
    public static final String TAG_SQLPATCHDETAILNAME = "SQLPATCHDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_SQLCODE = "SQLCODE";
    public static final String TAG_SQLPATCHITEMID = "SQLPATCHITEMID";
    public static final String TAG_SQLPATCHITEMNAME = "SQLPATCHITEMNAME";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_CHECKCODE = "CHECKCODE";
    public static final String TAG_SQLCODE2 = "SQLCODE2";

    public boolean isSQLPATCHDETAILIDNull() {
        return this.IsParamNull(TAG_SQLPATCHDETAILID);
    }

    public String getSQLPATCHDETAILID() {
        return this.GetParamStringValue(TAG_SQLPATCHDETAILID, "");
    }

    public void setSQLPATCHDETAILID(String strValue) {
        this.SetParamValue(TAG_SQLPATCHDETAILID, strValue);
    }

    public boolean isSQLPATCHDETAILNAMENull() {
        return this.IsParamNull(TAG_SQLPATCHDETAILNAME);
    }

    public String getSQLPATCHDETAILNAME() {
        return this.GetParamStringValue(TAG_SQLPATCHDETAILNAME, "");
    }

    public void setSQLPATCHDETAILNAME(String strValue) {
        this.SetParamValue(TAG_SQLPATCHDETAILNAME, strValue);
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

    public boolean isDBTYPENull() {
        return this.IsParamNull(TAG_DBTYPE);
    }

    public String getDBTYPE() {
        return this.GetParamStringValue(TAG_DBTYPE, "");
    }

    public void setDBTYPE(String strValue) {
        this.SetParamValue(TAG_DBTYPE, strValue);
    }

    public boolean isSQLCODENull() {
        return this.IsParamNull(TAG_SQLCODE);
    }

    public String getSQLCODE() {
        return this.GetParamStringValue(TAG_SQLCODE, "");
    }

    public void setSQLCODE(String strValue) {
        this.SetParamValue(TAG_SQLCODE, strValue);
    }

    public boolean isSQLPATCHITEMIDNull() {
        return this.IsParamNull(TAG_SQLPATCHITEMID);
    }

    public String getSQLPATCHITEMID() {
        return this.GetParamStringValue(TAG_SQLPATCHITEMID, "");
    }

    public void setSQLPATCHITEMID(String strValue) {
        this.SetParamValue(TAG_SQLPATCHITEMID, strValue);
    }

    public boolean isSQLPATCHITEMNAMENull() {
        return this.IsParamNull(TAG_SQLPATCHITEMNAME);
    }

    public String getSQLPATCHITEMNAME() {
        return this.GetParamStringValue(TAG_SQLPATCHITEMNAME, "");
    }

    public void setSQLPATCHITEMNAME(String strValue) {
        this.SetParamValue(TAG_SQLPATCHITEMNAME, strValue);
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

    public boolean isCHECKCODENull() {
        return this.IsParamNull(TAG_CHECKCODE);
    }

    public String getCHECKCODE() {
        return this.GetParamStringValue(TAG_CHECKCODE, "");
    }

    public void setCHECKCODE(String strValue) {
        this.SetParamValue(TAG_CHECKCODE, strValue);
    }

    public boolean isSQLCODE2Null() {
        return this.IsParamNull(TAG_SQLCODE2);
    }

    public String getSQLCODE2() {
        return this.GetParamStringValue(TAG_SQLCODE2, "");
    }

    public void setSQLCODE2(String strValue) {
        this.SetParamValue(TAG_SQLCODE2, strValue);
    }
}

