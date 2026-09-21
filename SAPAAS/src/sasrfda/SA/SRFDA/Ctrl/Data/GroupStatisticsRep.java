/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Ctrl.Data.GSRGroupColumn;
import SA.SRFDA.Ctrl.Data.GSRMeasure;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;
import java.util.Vector;

public class GroupStatisticsRep
extends BaseDataEntity {
    public static final String TAG_GROUPSTATISTICSREPID = "GROUPSTATISTICSREPID";
    public static final String TAG_GROUPSTATISTICSREPNAME = "GROUPSTATISTICSREPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_QUERYMODELID = "QUERYMODELID";
    public static final String TAG_QUERYMODELNAME = "QUERYMODELNAME";
    public static final String TAG_ENABLETIMEGROUP = "ENABLETIMEGROUP";
    public static final String TAG_TIMECODELISTID = "TIMECODELISTID";
    public static final String TAG_TIMECODELISTNAME = "TIMECODELISTNAME";
    public static final String TAG_SEARCHFORMID = "SEARCHFORMID";
    public static final String TAG_SEARCHFORMNAME = "SEARCHFORMNAME";
    public static final String TAG_TIMEDEFIELDID = "TIMEDEFIELDID";
    public static final String TAG_TIMEDEFIELDTIME = "TIMEDEFIELDTIME";
    public static final String TAG_ENABLETOPN = "ENABLETOPN";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_DETAILDGID = "DETAILDGID";
    public static final String TAG_DETAILDGNAME = "DETAILDGNAME";
    public static final String TAG_DETAILDGPAGEID = "DETAILDGPAGEID";
    public static final String TAG_DETAILDGPAGENAME = "DETAILDGPAGENAME";
    public static final String TAG_ICONPATH = "ICONPATH";
    public static final String TAG_GROUPCOND = "GROUPCOND";
    public static final String TAG_BEGINTIMEARG = "BEGINTIMEARG";
    public static final String TAG_ENDTIMEARG = "ENDTIMEARG";
    public static final String TAG_TOPNCOUNT = "TOPNCOUNT";
    public static final String TAG_TABLVIEWDEFAULT = "TABLVIEWDEFAULT";
    public static final String TAG_ENABLECONDSL = "ENABLECONDSL";
    protected Vector<GSRMeasure> measures = null;
    protected Vector<GSRGroupColumn> groupColumns = null;

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

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getQUERYMODELID() {
        return this.GetParamStringValue(TAG_QUERYMODELID, "");
    }

    public void setQUERYMODELID(String strValue) {
        this.SetParamValue(TAG_QUERYMODELID, strValue);
    }

    public String getQUERYMODELNAME() {
        return this.GetParamStringValue(TAG_QUERYMODELNAME, "");
    }

    public void setQUERYMODELNAME(String strValue) {
        this.SetParamValue(TAG_QUERYMODELNAME, strValue);
    }

    public boolean getENABLETIMEGROUP() {
        return this.GetParamIntValue(TAG_ENABLETIMEGROUP, 0) == 1;
    }

    public void setENABLETIMEGROUP(boolean bValue) {
        this.SetParamValue(TAG_ENABLETIMEGROUP, bValue ? 1 : 0);
    }

    public String getTIMECODELISTID() {
        return this.GetParamStringValue(TAG_TIMECODELISTID, "");
    }

    public void setTIMECODELISTID(String strValue) {
        this.SetParamValue(TAG_TIMECODELISTID, strValue);
    }

    public String getTIMECODELISTNAME() {
        return this.GetParamStringValue(TAG_TIMECODELISTNAME, "");
    }

    public void setTIMECODELISTNAME(String strValue) {
        this.SetParamValue(TAG_TIMECODELISTNAME, strValue);
    }

    public String getSEARCHFORMID() {
        return this.GetParamStringValue(TAG_SEARCHFORMID, "");
    }

    public void setSEARCHFORMID(String strValue) {
        this.SetParamValue(TAG_SEARCHFORMID, strValue);
    }

    public String getSEARCHFORMNAME() {
        return this.GetParamStringValue(TAG_SEARCHFORMNAME, "");
    }

    public void setSEARCHFORMNAME(String strValue) {
        this.SetParamValue(TAG_SEARCHFORMNAME, strValue);
    }

    public String getTIMEDEFIELDID() {
        return this.GetParamStringValue(TAG_TIMEDEFIELDID, "");
    }

    public void setTIMEDEFIELDID(String strValue) {
        this.SetParamValue(TAG_TIMEDEFIELDID, strValue);
    }

    public String getTIMEDEFIELDTIME() {
        return this.GetParamStringValue(TAG_TIMEDEFIELDTIME, "");
    }

    public void setTIMEDEFIELDTIME(String strValue) {
        this.SetParamValue(TAG_TIMEDEFIELDTIME, strValue);
    }

    public boolean getENABLETOPN() {
        return this.GetParamIntValue(TAG_ENABLETOPN, 0) == 1;
    }

    public void setENABLETOPN(boolean bValue) {
        this.SetParamValue(TAG_ENABLETOPN, bValue ? 1 : 0);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public String getDETAILDGNAME() {
        return this.GetParamStringValue(TAG_DETAILDGNAME, "");
    }

    public void setDETAILDGNAME(String strValue) {
        this.SetParamValue(TAG_DETAILDGNAME, strValue);
    }

    public String getDETAILDGID() {
        return this.GetParamStringValue(TAG_DETAILDGID, "");
    }

    public void setDETAILDGID(String strValue) {
        this.SetParamValue(TAG_DETAILDGID, strValue);
    }

    public String getDETAILDGPAGEID() {
        return this.GetParamStringValue(TAG_DETAILDGPAGEID, "");
    }

    public void setDETAILDGPAGEID(String strValue) {
        this.SetParamValue(TAG_DETAILDGPAGEID, strValue);
    }

    public String getDETAILDGPAGENAME() {
        return this.GetParamStringValue(TAG_DETAILDGPAGENAME, "");
    }

    public void setDETAILDGPAGENAME(String strValue) {
        this.SetParamValue(TAG_DETAILDGPAGENAME, strValue);
    }

    public String getICONPATH() {
        return this.GetParamStringValue(TAG_ICONPATH, "");
    }

    public void setICONPATH(String strValue) {
        this.SetParamValue(TAG_ICONPATH, strValue);
    }

    public String getGROUPCOND() {
        return this.GetParamStringValue(TAG_GROUPCOND, "");
    }

    public void setGROUPCOND(String strValue) {
        this.SetParamValue(TAG_GROUPCOND, strValue);
    }

    public String getBEGINTIMEARG() {
        return this.GetParamStringValue(TAG_BEGINTIMEARG, "");
    }

    public void setBEGINTIMEARG(String strValue) {
        this.SetParamValue(TAG_BEGINTIMEARG, strValue);
    }

    public String getENDTIMEARG() {
        return this.GetParamStringValue(TAG_ENDTIMEARG, "");
    }

    public void setENDTIMEARG(String strValue) {
        this.SetParamValue(TAG_ENDTIMEARG, strValue);
    }

    public int getTOPNCOUNT() {
        return this.GetParamIntValue(TAG_TOPNCOUNT, 0);
    }

    public void setTOPNCOUNT(int strValue) {
        this.SetParamValue(TAG_TOPNCOUNT, strValue);
    }

    public Vector<GSRMeasure> getMeasures() {
        return this.measures;
    }

    public Vector<GSRGroupColumn> getGroupColumns() {
        return this.groupColumns;
    }

    public void setMeasures(Vector<GSRMeasure> measures) {
        this.measures = measures;
    }

    public void setGroupColumns(Vector<GSRGroupColumn> groupColumns) {
        this.groupColumns = groupColumns;
    }

    public String getIconPath(String strDefault) {
        return this.GetParamStringValue(TAG_ICONPATH, strDefault);
    }

    public int getTopNCount(int nDefault) {
        return this.GetParamIntValue(TAG_TOPNCOUNT, nDefault);
    }

    public boolean getTABLVIEWDEFAULT() {
        return this.GetParamIntValue(TAG_TABLVIEWDEFAULT, 0) == 1;
    }

    public void setTABLVIEWDEFAULT(boolean bValue) {
        this.SetParamValue(TAG_TABLVIEWDEFAULT, bValue ? 1 : 0);
    }

    public boolean getENABLECONDSL() {
        return this.GetParamIntValue(TAG_ENABLECONDSL, 0) == 1;
    }

    public void setENABLECONDSL(boolean bValue) {
        this.SetParamValue(TAG_ENABLECONDSL, bValue ? 1 : 0);
    }
}

