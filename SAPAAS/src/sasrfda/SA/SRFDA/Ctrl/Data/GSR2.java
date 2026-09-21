/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Ctrl.Data.GSR2Dimension;
import SA.SRFDA.Ctrl.Data.GSR2Dimension2;
import SA.SRFDA.Ctrl.Data.GSR2Measure;
import SA.SRFDA.Ctrl.Data.GSR2SumTable;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;
import java.util.Vector;

public class GSR2
extends BaseDataEntity {
    public static final String TAG_GSR2ID = "GSR2ID";
    public static final String TAG_GSR2NAME = "GSR2NAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_QUERYMODELNAME = "QUERYMODELNAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_QUERYMODELID = "QUERYMODELID";
    public static final String TAG_SEARCHFORMID = "SEARCHFORMID";
    public static final String TAG_SEARCHFORMNAME = "SEARCHFORMNAME";
    public static final String TAG_ENABLECONDSL = "ENABLECONDSL";
    public static final String TAG_TOPNCOUNT = "TOPNCOUNT";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_TABLEVIEWDEFAULT = "TABLEVIEWDEFAULT";
    public static final String TAG_TIMEDEFID = "TIMEDEFID";
    public static final String TAG_TIMEDEFNAME = "TIMEDEFNAME";
    public static final String TAG_GROUPDEFID = "GROUPDEFID";
    public static final String TAG_GROUPDEFNAME = "GROUPDEFNAME";
    public static final String TAG_ENABLETOPN = "ENABLETOPN";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_DETAILDENAME = "DETAILDENAME";
    public static final String TAG_DETAILDGPAGEID = "DETAILDGPAGEID";
    public static final String TAG_DETAILDGPAGENAME = "DETAILDGPAGENAME";
    public static final String TAG_TIMECOLUMNWIDTH = "TIMECOLUMNWIDTH";
    public static final String TAG_GROUPCOLUMNWIDTH = "GROUPCOLUMNWIDTH";
    public static final String TAG_ICONPATH = "ICONPATH";
    public static final String TAG_BACKENDCTRL = "BACKENDCTRL";
    public static final String TAG_SPEXPAND = "SPEXPAND";
    public static final String TAG_AUTOLOAD = "AUTOLOAD";
    public static final String TAG_GSR2PARAMS = "GSR2PARAMS";
    public static final String TAG_ENABLESL = "ENABLESL";
    protected Vector<GSR2Dimension> dimensions = new Vector();
    protected Vector<GSR2Dimension2> dimensions2 = new Vector();
    protected Vector<GSR2Measure> measures = new Vector();
    protected Vector<GSR2SumTable> sumTables = new Vector();

    public Vector<GSR2Dimension2> getDimensions2() {
        return this.dimensions2;
    }

    public Vector<GSR2Dimension> getDimensions() {
        return this.dimensions;
    }

    public Vector<GSR2Measure> getMeasures() {
        return this.measures;
    }

    public Vector<GSR2SumTable> getSumTables() {
        return this.sumTables;
    }

    public GSR2SumTable FindSumTable(String strSumTableId) {
        for (GSR2SumTable sumTable : this.sumTables) {
            if (StringHelper.Compare((String)sumTable.getGSR2SUMTABLEID(), (String)strSumTableId, (boolean)true) != 0) continue;
            return sumTable;
        }
        return null;
    }

    public GSR2Dimension FindDimension(String strDimensionId) {
        for (GSR2Dimension dimension : this.dimensions) {
            if (StringHelper.Compare((String)dimension.getGSR2DIMENSIONID(), (String)strDimensionId, (boolean)true) != 0) continue;
            return dimension;
        }
        return null;
    }

    public GSR2Dimension2 FindDimension2(String strDimension2Id) {
        for (GSR2Dimension2 dimension2 : this.dimensions2) {
            if (StringHelper.Compare((String)dimension2.getGSR2DIMENSION2ID(), (String)strDimension2Id, (boolean)true) != 0) continue;
            return dimension2;
        }
        return null;
    }

    public void setDimensions2(Vector<GSR2Dimension2> dimensions2) {
        this.dimensions2 = dimensions2;
    }

    public void setDimensions(Vector<GSR2Dimension> dimensions) {
        this.dimensions = dimensions;
    }

    public void setMeasures(Vector<GSR2Measure> measures) {
        this.measures = measures;
    }

    public void setSumTables(Vector<GSR2SumTable> sumTables) {
        this.sumTables = sumTables;
    }

    public int getTopNCount(int nDefault) {
        return this.GetParamIntValue(TAG_TOPNCOUNT, nDefault);
    }

    public String getIconPath(String strDefault) {
        return this.GetParamStringValue(TAG_ICONPATH, strDefault);
    }

    public String getGSR2ID() {
        return this.GetParamStringValue(TAG_GSR2ID, "");
    }

    public void setGSR2ID(String strValue) {
        this.SetParamValue(TAG_GSR2ID, strValue);
    }

    public String getGSR2NAME() {
        return this.GetParamStringValue(TAG_GSR2NAME, "");
    }

    public void setGSR2NAME(String strValue) {
        this.SetParamValue(TAG_GSR2NAME, strValue);
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

    public String getQUERYMODELNAME() {
        return this.GetParamStringValue(TAG_QUERYMODELNAME, "");
    }

    public void setQUERYMODELNAME(String strValue) {
        this.SetParamValue(TAG_QUERYMODELNAME, strValue);
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

    public boolean getENABLECONDSL() {
        return this.GetParamIntValue(TAG_ENABLECONDSL, 0) == 1;
    }

    public void setENABLECONDSL(boolean bValue) {
        this.SetParamValue(TAG_ENABLECONDSL, bValue ? 1 : 0);
    }

    public int getTOPNCOUNT() {
        return this.GetParamIntValue(TAG_TOPNCOUNT, 0);
    }

    public void setTOPNCOUNT(int strValue) {
        this.SetParamValue(TAG_TOPNCOUNT, strValue);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public boolean getTABLEVIEWDEFAULT() {
        return this.GetParamIntValue(TAG_TABLEVIEWDEFAULT, 0) == 1;
    }

    public void setTABLEVIEWDEFAULT(boolean bValue) {
        this.SetParamValue(TAG_TABLEVIEWDEFAULT, bValue ? 1 : 0);
    }

    public String getTIMEDEFID() {
        return this.GetParamStringValue(TAG_TIMEDEFID, "");
    }

    public void setTIMEDEFID(String strValue) {
        this.SetParamValue(TAG_TIMEDEFID, strValue);
    }

    public String getTIMEDEFNAME() {
        return this.GetParamStringValue(TAG_TIMEDEFNAME, "");
    }

    public void setTIMEDEFNAME(String strValue) {
        this.SetParamValue(TAG_TIMEDEFNAME, strValue);
    }

    public String getGROUPDEFID() {
        return this.GetParamStringValue(TAG_GROUPDEFID, "");
    }

    public void setGROUPDEFID(String strValue) {
        this.SetParamValue(TAG_GROUPDEFID, strValue);
    }

    public String getGROUPDEFNAME() {
        return this.GetParamStringValue(TAG_GROUPDEFNAME, "");
    }

    public void setGROUPDEFNAME(String strValue) {
        this.SetParamValue(TAG_GROUPDEFNAME, strValue);
    }

    public boolean getENABLETOPN() {
        return this.GetParamIntValue(TAG_ENABLETOPN, 0) == 1;
    }

    public void setENABLETOPN(boolean bValue) {
        this.SetParamValue(TAG_ENABLETOPN, bValue ? 1 : 0);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public String getDETAILDENAME() {
        return this.GetParamStringValue(TAG_DETAILDENAME, "");
    }

    public void setDETAILDENAME(String strValue) {
        this.SetParamValue(TAG_DETAILDENAME, strValue);
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

    public int getTIMECOLUMNWIDTH() {
        return this.GetParamIntValue(TAG_TIMECOLUMNWIDTH, 0);
    }

    public void setTIMECOLUMNWIDTH(int strValue) {
        this.SetParamValue(TAG_TIMECOLUMNWIDTH, strValue);
    }

    public int getGROUPCOLUMNWIDTH() {
        return this.GetParamIntValue(TAG_GROUPCOLUMNWIDTH, 0);
    }

    public void setGROUPCOLUMNWIDTH(int strValue) {
        this.SetParamValue(TAG_GROUPCOLUMNWIDTH, strValue);
    }

    public String getICONPATH() {
        return this.GetParamStringValue(TAG_ICONPATH, "");
    }

    public void setICONPATH(String strValue) {
        this.SetParamValue(TAG_ICONPATH, strValue);
    }

    public String getBACKENDCTRL() {
        return this.GetParamStringValue(TAG_BACKENDCTRL, "");
    }

    public void setBACKENDCTRL(String strValue) {
        this.SetParamValue(TAG_BACKENDCTRL, strValue);
    }

    public boolean getSPEXPAND() {
        return this.GetParamIntValue(TAG_SPEXPAND, 1) == 1;
    }

    public void setSPEXPAND(boolean bValue) {
        this.SetParamValue(TAG_SPEXPAND, bValue ? 1 : 0);
    }

    public boolean getAUTOLOAD() {
        return this.GetParamIntValue(TAG_AUTOLOAD, 0) == 1;
    }

    public void setAUTOLOAD(boolean bValue) {
        this.SetParamValue(TAG_AUTOLOAD, bValue ? 1 : 0);
    }

    public void setGSR2PARAMS(String strValue) {
        this.SetParamValue(TAG_GSR2PARAMS, strValue);
    }

    public boolean getENABLESL() {
        return this.GetParamIntValue(TAG_ENABLESL, 1) == 1;
    }

    public void setENABLESL(boolean bValue) {
        this.SetParamValue(TAG_ENABLESL, bValue ? 1 : 0);
    }
}

