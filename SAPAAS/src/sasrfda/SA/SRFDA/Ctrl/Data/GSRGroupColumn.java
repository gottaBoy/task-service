/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;

public class GSRGroupColumn
extends BaseDataEntity {
    public static final String TAG_GSRGROUPCOLUMNID = "GSRGROUPCOLUMNID";
    public static final String TAG_GSRGROUPCOLUMNNAME = "GSRGROUPCOLUMNNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_GROUPSTATISTICSREPID = "GROUPSTATISTICSREPID";
    public static final String TAG_GROUPSTATISTICSREPNAME = "GROUPSTATISTICSREPNAME";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_DEFIELDID = "DEFIELDID";
    public static final String TAG_DEFIELDNAME = "DEFIELDNAME";
    public static final String TAG_NAMEDEFID = "NAMEDEFID";
    public static final String TAG_NAMEDEFNAME = "NAMEDEFNAME";
    public static final String TAG_CODELISTID = "CODELISTID";
    public static final String TAG_CODELISTNAME = "CODELISTNAME";
    public static final String TAG_DEFAULTGROUP = "DEFAULTGROUP";
    public static final String TAG_COND = "COND";
    public static final String TAG_COLUMNNAME = "COLUMNNAME";
    public static final String TAG_ENABLETIMEGROUP = "ENABLETIMEGROUP";
    public static final String TAG_TIMEGROUPTYPE = "TIMEGROUPTYPE";
    public static final String TIMEGROUPTYPE_YEAR = "Y";
    public static final String TIMEGROUPTYPE_SEASON = "Q";
    public static final String TIMEGROUPTYPE_MONTH = "M";
    public static final String TIMEGROUPTYPE_DAY = "D";
    public static final String TIMEGROUPTYPE_HOUR = "H";
    public static final String TIMEGROUPTYPE_YEARWEEK = "YEARWEEK";

    public String getGSRGROUPCOLUMNID() {
        return this.GetParamStringValue(TAG_GSRGROUPCOLUMNID, "");
    }

    public void setGSRGROUPCOLUMNID(String strValue) {
        this.SetParamValue(TAG_GSRGROUPCOLUMNID, strValue);
    }

    public String getGSRGROUPCOLUMNNAME() {
        return this.GetParamStringValue(TAG_GSRGROUPCOLUMNNAME, "");
    }

    public void setGSRGROUPCOLUMNNAME(String strValue) {
        this.SetParamValue(TAG_GSRGROUPCOLUMNNAME, strValue);
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

    public String getGROUPSTATISTICSREPID() {
        return this.GetParamStringValue(TAG_GROUPSTATISTICSREPID, "");
    }

    public void setGROUPSTATISTICSREPID(String strValue) {
        this.SetParamValue(TAG_GROUPSTATISTICSREPID, strValue);
    }

    public String getGROUPSTATISTICSREPNAME() {
        return this.GetParamStringValue(TAG_GROUPSTATISTICSREPNAME, "");
    }

    public void setGROUPSTATISTICSREPNAME(String strValue) {
        this.SetParamValue(TAG_GROUPSTATISTICSREPNAME, strValue);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int strValue) {
        this.SetParamValue(TAG_ORDERFLAG, strValue);
    }

    public int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public void setWIDTH(int strValue) {
        this.SetParamValue(TAG_WIDTH, strValue);
    }

    public String getDEFIELDID() {
        return this.GetParamStringValue(TAG_DEFIELDID, "");
    }

    public void setDEFIELDID(String strValue) {
        this.SetParamValue(TAG_DEFIELDID, strValue);
    }

    public String getDEFIELDNAME() {
        return this.GetParamStringValue(TAG_DEFIELDNAME, "");
    }

    public void setDEFIELDNAME(String strValue) {
        this.SetParamValue(TAG_DEFIELDNAME, strValue);
    }

    public String getNAMEDEFID() {
        return this.GetParamStringValue(TAG_NAMEDEFID, "");
    }

    public void setNAMEDEFID(String strValue) {
        this.SetParamValue(TAG_NAMEDEFID, strValue);
    }

    public String getNAMEDEFNAME() {
        return this.GetParamStringValue(TAG_NAMEDEFNAME, "");
    }

    public void setNAMEDEFNAME(String strValue) {
        this.SetParamValue(TAG_NAMEDEFNAME, strValue);
    }

    public String getCODELISTID() {
        return this.GetParamStringValue(TAG_CODELISTID, "");
    }

    public void setCODELISTID(String strValue) {
        this.SetParamValue(TAG_CODELISTID, strValue);
    }

    public String getCODELISTNAME() {
        return this.GetParamStringValue(TAG_CODELISTNAME, "");
    }

    public void setCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_CODELISTNAME, strValue);
    }

    public boolean getDEFAULTGROUP() {
        return this.GetParamIntValue(TAG_DEFAULTGROUP, 0) == 1;
    }

    public void setDEFAULTGROUP(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTGROUP, bValue ? 1 : 0);
    }

    public String getCOND() {
        return this.GetParamStringValue(TAG_COND, "");
    }

    public void setCOND(String strValue) {
        this.SetParamValue(TAG_COND, strValue);
    }

    public String getCOLUMNNAME() {
        return this.GetParamStringValue(TAG_COLUMNNAME, "");
    }

    public void setCOLUMNNAME(String strValue) {
        this.SetParamValue(TAG_COLUMNNAME, strValue);
    }

    public String getColumnName() {
        if (StringHelper.IsNullOrEmpty((String)this.getCOLUMNNAME())) {
            return this.getGSRGROUPCOLUMNNAME();
        }
        return this.getCOLUMNNAME();
    }

    public boolean getENABLETIMEGROUP() {
        return this.GetParamIntValue(TAG_ENABLETIMEGROUP, 0) == 1;
    }

    public void setENABLETIMEGROUP(boolean bValue) {
        this.SetParamValue(TAG_ENABLETIMEGROUP, bValue ? 1 : 0);
    }

    public String getTIMEGROUPTYPE() {
        return this.GetParamStringValue(TAG_TIMEGROUPTYPE, "");
    }

    public void setTIMEGROUPTYPE(String strValue) {
        this.SetParamValue(TAG_TIMEGROUPTYPE, strValue);
    }
}

