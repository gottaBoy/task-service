/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Ctrl.Data.TreeNodeRS;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;
import java.util.Vector;

public class TreeNode
extends BaseDataEntity {
    public static final String NODEACTION_PAGELINK = "PAGELINK";
    public static final String NODEACTION_JAVASCRIPT = "JAVASCRIPT";
    public static final String TREENODETYPE_STATIC = "STATIC";
    public static final String TREENODETYPE_DE = "DE";
    public static final String TREENODETYPE_CODELIST = "CODELIST";
    public static final String TAG_TREENODEID = "TREENODEID";
    public static final String TAG_TREENODENAME = "TREENODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TREENODETYPE = "TREENODETYPE";
    public static final String TAG_TREEVIEWID = "TREEVIEWID";
    public static final String TAG_TREEVIEWNAME = "TREEVIEWNAME";
    public static final String TAG_ICONCLS = "ICONCLS";
    public static final String TAG_ROOTNODE = "ROOTNODE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_QUERYMODELID = "QUERYMODELID";
    public static final String TAG_QUERYMODELNAME = "QUERYMODELNAME";
    public static final String TAG_ENABLEUP = "ENABLEUP";
    public static final String TAG_EXPAND = "EXPAND";
    public static final String TAG_SORTDEFID = "SORTDEFID";
    public static final String TAG_SORTDEFNAME = "SORTDEFNAME";
    public static final String TAG_SORTDIR = "SORTDIR";
    public static final String TAG_PAGEID = "PAGEID";
    public static final String TAG_PAGENAME = "PAGENAME";
    public static final String TAG_NODEACTION = "NODEACTION";
    public static final String TAG_ACTIONPARAM = "ACTIONPARAM";
    public static final String TAG_CODELISTID = "CODELISTID";
    public static final String TAG_CODELISTNAME = "CODELISTNAME";
    public static final String TAG_NODEVALUE = "NODEVALUE";
    public static final String TAG_APPENDPNODEID = "APPENDPNODEID";
    public static final String TAG_KEYDEFID = "KEYDEFID";
    public static final String TAG_KEYDEFNAME = "KEYDEFNAME";
    public static final String TAG_TEXTDEFID = "TEXTDEFID";
    public static final String TAG_TEXTDEFNAME = "TEXTDEFNAME";
    public static final String TAG_ENABLECHECK = "ENABLECHECK";
    public static final String TAG_CHECKED = "CHECKED";
    public static final String TAG_DISTINCTMODE = "DISTINCTMODE";
    public static final String TAG_FILTERQMID = "FILTERQMID";
    public static final String TAG_FILTERQMNAME = "FILTERQMNAME";
    public static final String TAG_CMREMOVE = "CMREMOVE";
    public static final String TAG_CMREFRESH = "CMREFRESH";
    public static final String TAG_REMOVEDEACTIONID = "REMOVEDEACTIONID";
    public static final String TAG_REMOVEDEACTIONNAME = "REMOVEDEACTIONNAME";
    public static final String TAG_NODETYPE = "NODETYPE";
    public static final String TAG_ICONDEFID = "ICONDEFID";
    public static final String TAG_ICONDEFNAME = "ICONDEFNAME";
    protected Vector<TreeNodeRS> treeNodeRSs = new Vector();

    public Vector<TreeNodeRS> getTreeNodeRSList() {
        return this.treeNodeRSs;
    }

    public void InitTreeNodeRSProcessParams() {
        for (TreeNodeRS treeNodeRS : this.treeNodeRSs) {
            treeNodeRS.BuildProcessParams();
        }
    }

    public String getTREENODEID() {
        return this.GetParamStringValue(TAG_TREENODEID, "");
    }

    public void setTREENODEID(String strValue) {
        this.SetParamValue(TAG_TREENODEID, strValue);
    }

    public String getTREENODENAME() {
        return this.GetParamStringValue(TAG_TREENODENAME, "");
    }

    public void setTREENODENAME(String strValue) {
        this.SetParamValue(TAG_TREENODENAME, strValue);
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

    public String getTREENODETYPE() {
        return this.GetParamStringValue(TAG_TREENODETYPE, "");
    }

    public void setTREENODETYPE(String strValue) {
        this.SetParamValue(TAG_TREENODETYPE, strValue);
    }

    public String getTREEVIEWID() {
        return this.GetParamStringValue(TAG_TREEVIEWID, "");
    }

    public void setTREEVIEWID(String strValue) {
        this.SetParamValue(TAG_TREEVIEWID, strValue);
    }

    public String getTREEVIEWNAME() {
        return this.GetParamStringValue(TAG_TREEVIEWNAME, "");
    }

    public void setTREEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_TREEVIEWNAME, strValue);
    }

    public String getICONCLS() {
        return this.GetParamStringValue(TAG_ICONCLS, "");
    }

    public void setICONCLS(String strValue) {
        this.SetParamValue(TAG_ICONCLS, strValue);
    }

    public boolean getROOTNODE() {
        return this.GetParamIntValue(TAG_ROOTNODE, 0) == 1;
    }

    public void setROOTNODE(boolean bValue) {
        this.SetParamValue(TAG_ROOTNODE, bValue ? 1 : 0);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
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

    public boolean getENABLEUP() {
        return this.GetParamIntValue(TAG_ENABLEUP, 0) == 1;
    }

    public void setENABLEUP(boolean bValue) {
        this.SetParamValue(TAG_ENABLEUP, bValue ? 1 : 0);
    }

    public boolean getEXPAND() {
        return this.GetParamIntValue(TAG_EXPAND, 0) == 1;
    }

    public void setEXPAND(boolean bValue) {
        this.SetParamValue(TAG_EXPAND, bValue ? 1 : 0);
    }

    public String getSORTDEFID() {
        return this.GetParamStringValue(TAG_SORTDEFID, "");
    }

    public void setSORTDEFID(String strValue) {
        this.SetParamValue(TAG_SORTDEFID, strValue);
    }

    public String getSORTDEFNAME() {
        return this.GetParamStringValue(TAG_SORTDEFNAME, "");
    }

    public void setSORTDEFNAME(String strValue) {
        this.SetParamValue(TAG_SORTDEFNAME, strValue);
    }

    public String getSORTDIR() {
        return this.GetParamStringValue(TAG_SORTDIR, "");
    }

    public void setSORTDIR(String strValue) {
        this.SetParamValue(TAG_SORTDIR, strValue);
    }

    public String getPAGEID() {
        return this.GetParamStringValue(TAG_PAGEID, "");
    }

    public void setPAGEID(String strValue) {
        this.SetParamValue(TAG_PAGEID, strValue);
    }

    public String getPAGENAME() {
        return this.GetParamStringValue(TAG_PAGENAME, "");
    }

    public void setPAGENAME(String strValue) {
        this.SetParamValue(TAG_PAGENAME, strValue);
    }

    public String getNODEACTION() {
        return this.GetParamStringValue(TAG_NODEACTION, "");
    }

    public void setNODEACTION(String strValue) {
        this.SetParamValue(TAG_NODEACTION, strValue);
    }

    public String getACTIONPARAM() {
        return this.GetParamStringValue(TAG_ACTIONPARAM, "");
    }

    public void setACTIONPARAM(String strValue) {
        this.SetParamValue(TAG_ACTIONPARAM, strValue);
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

    public String getNODEVALUE() {
        return this.GetParamStringValue(TAG_NODEVALUE, "");
    }

    public void setNODEVALUE(String strValue) {
        this.SetParamValue(TAG_NODEVALUE, strValue);
    }

    public boolean getAPPENDPNODEID() {
        return this.GetParamIntValue(TAG_APPENDPNODEID, 0) == 1;
    }

    public void setAPPENDPNODEID(boolean bValue) {
        this.SetParamValue(TAG_APPENDPNODEID, bValue ? 1 : 0);
    }

    public String getKEYDEFID() {
        return this.GetParamStringValue(TAG_KEYDEFID, "");
    }

    public void setKEYDEFID(String strValue) {
        this.SetParamValue(TAG_KEYDEFID, strValue);
    }

    public String getKEYDEFNAME() {
        return this.GetParamStringValue(TAG_KEYDEFNAME, "");
    }

    public void setKEYDEFNAME(String strValue) {
        this.SetParamValue(TAG_KEYDEFNAME, strValue);
    }

    public String getTEXTDEFID() {
        return this.GetParamStringValue(TAG_TEXTDEFID, "");
    }

    public void setTEXTDEFID(String strValue) {
        this.SetParamValue(TAG_TEXTDEFID, strValue);
    }

    public String getTEXTDEFNAME() {
        return this.GetParamStringValue(TAG_TEXTDEFNAME, "");
    }

    public void setTEXTDEFNAME(String strValue) {
        this.SetParamValue(TAG_TEXTDEFNAME, strValue);
    }

    public boolean getENABLECHECK() {
        return this.GetParamIntValue(TAG_ENABLECHECK, 0) == 1;
    }

    public void setENABLECHECK(boolean bValue) {
        this.SetParamValue(TAG_ENABLECHECK, bValue ? 1 : 0);
    }

    public boolean getCHECKED() {
        return this.GetParamIntValue(TAG_CHECKED, 0) == 1;
    }

    public void setCHECKED(boolean bValue) {
        this.SetParamValue(TAG_CHECKED, bValue ? 1 : 0);
    }

    public boolean getDISTINCTMODE() {
        return this.GetParamIntValue(TAG_DISTINCTMODE, 0) == 1;
    }

    public void setDISTINCTMODE(boolean bValue) {
        this.SetParamValue(TAG_DISTINCTMODE, bValue ? 1 : 0);
    }

    public String getFILTERQMID() {
        return this.GetParamStringValue(TAG_FILTERQMID, "");
    }

    public void setFILTERQMID(String strValue) {
        this.SetParamValue(TAG_FILTERQMID, strValue);
    }

    public String getFILTERQMNAME() {
        return this.GetParamStringValue(TAG_FILTERQMNAME, "");
    }

    public void setFILTERQMNAME(String strValue) {
        this.SetParamValue(TAG_FILTERQMNAME, strValue);
    }

    public boolean isCMREMOVENull() {
        return this.IsParamNull(TAG_CMREMOVE);
    }

    public boolean getCMREMOVE() {
        return this.GetParamIntValue(TAG_CMREMOVE, 0) == 1;
    }

    public void setCMREMOVE(boolean bValue) {
        this.SetParamValue(TAG_CMREMOVE, bValue ? 1 : 0);
    }

    public boolean isCMREFRESHNull() {
        return this.IsParamNull(TAG_CMREFRESH);
    }

    public boolean getCMREFRESH() {
        return this.GetParamIntValue(TAG_CMREFRESH, 0) == 1;
    }

    public void setCMREFRESH(boolean bValue) {
        this.SetParamValue(TAG_CMREFRESH, bValue ? 1 : 0);
    }

    public boolean isREMOVEDEACTIONIDNull() {
        return this.IsParamNull(TAG_REMOVEDEACTIONID);
    }

    public String getREMOVEDEACTIONID() {
        return this.GetParamStringValue(TAG_REMOVEDEACTIONID, "");
    }

    public void setREMOVEDEACTIONID(String strValue) {
        this.SetParamValue(TAG_REMOVEDEACTIONID, strValue);
    }

    public boolean isREMOVEDEACTIONNAMENull() {
        return this.IsParamNull(TAG_REMOVEDEACTIONNAME);
    }

    public String getREMOVEDEACTIONNAME() {
        return this.GetParamStringValue(TAG_REMOVEDEACTIONNAME, "");
    }

    public void setREMOVEDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_REMOVEDEACTIONNAME, strValue);
    }

    public boolean isNODETYPENull() {
        return this.IsParamNull(TAG_NODETYPE);
    }

    public String getNODETYPE() {
        return this.GetParamStringValue(TAG_NODETYPE, "");
    }

    public void setNODETYPE(String strValue) {
        this.SetParamValue(TAG_NODETYPE, strValue);
    }

    public boolean isICONDEFIDNull() {
        return this.IsParamNull(TAG_ICONDEFID);
    }

    public String getICONDEFID() {
        return this.GetParamStringValue(TAG_ICONDEFID, "");
    }

    public void setICONDEFID(String strValue) {
        this.SetParamValue(TAG_ICONDEFID, strValue);
    }

    public boolean isICONDEFNAMENull() {
        return this.IsParamNull(TAG_ICONDEFNAME);
    }

    public String getICONDEFNAME() {
        return this.GetParamStringValue(TAG_ICONDEFNAME, "");
    }

    public void setICONDEFNAME(String strValue) {
        this.SetParamValue(TAG_ICONDEFNAME, strValue);
    }
}

