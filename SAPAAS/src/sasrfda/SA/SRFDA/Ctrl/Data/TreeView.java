/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Ctrl.Data.TreeNode;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

public class TreeView
extends BaseDataEntity {
    public static final String TAG_TREEVIEWID = "TREEVIEWID";
    public static final String TAG_TREEVIEWNAME = "TREEVIEWNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_SHOWROOT = "SHOWROOT";
    public static final String TAG_BACKENDCTRL = "BACKENDCTRL";
    public static final String TAG_DEFAULTVIEW = "DEFAULTVIEW";
    public static final String TAG_ROOTSELECT = "ROOTSELECT";
    public static final String TAG_ENABLESEARCH = "ENABLESEARCH";
    protected Vector<TreeNode> treeNodes = new Vector();
    protected Hashtable<String, TreeNode> treeNodeMap = new Hashtable();

    public Vector<TreeNode> getTreeNodeList() {
        return this.treeNodes;
    }

    public TreeNode getRootTreeNode() {
        for (TreeNode treeNode : this.treeNodes) {
            if (!treeNode.getROOTNODE()) continue;
            return treeNode;
        }
        return null;
    }

    public synchronized void InitTreeNodeMap() {
        this.treeNodeMap.clear();
        for (TreeNode treeNode : this.treeNodes) {
            this.treeNodeMap.put(treeNode.getTREENODEID(), treeNode);
        }
    }

    public TreeNode FindTreeNode(String strTreeNodeId) {
        return this.treeNodeMap.get(strTreeNodeId);
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

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
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

    public boolean getSHOWROOT() {
        return this.GetParamIntValue(TAG_SHOWROOT, 0) == 1;
    }

    public void setSHOWROOT(boolean bValue) {
        this.SetParamValue(TAG_SHOWROOT, bValue ? 1 : 0);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public String getBACKENDCTRL() {
        return this.GetParamStringValue(TAG_BACKENDCTRL, "");
    }

    public void setBACKENDCTRL(String strValue) {
        this.SetParamValue(TAG_BACKENDCTRL, strValue);
    }

    public String getDEFAULTVIEW() {
        return this.GetParamStringValue(TAG_DEFAULTVIEW, "");
    }

    public void setDEFAULTVIEW(String strValue) {
        this.SetParamValue(TAG_DEFAULTVIEW, strValue);
    }

    public boolean getROOTSELECT() {
        return this.GetParamIntValue(TAG_ROOTSELECT, 0) == 1;
    }

    public void setROOTSELECT(boolean bValue) {
        this.SetParamValue(TAG_ROOTSELECT, bValue ? 1 : 0);
    }

    public boolean getENABLESEARCH() {
        return this.GetParamIntValue(TAG_ENABLESEARCH, 0) == 1;
    }

    public void setENABLESEARCH(boolean bValue) {
        this.SetParamValue(TAG_ENABLESEARCH, bValue ? 1 : 0);
    }
}

