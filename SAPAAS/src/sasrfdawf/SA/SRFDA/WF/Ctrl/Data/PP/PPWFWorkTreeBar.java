/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.WF.Ctrl.Data.PP;

import SA.SRFDA.WF.Ctrl.Data.PP.PPWFWorkTreeNode;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

public class PPWFWorkTreeBar
extends BaseDataEntity {
    public static final String PARAMTYPE = "PP_WFWORKTREEBAR";
    public static final String TAG_PPWFWORKTREEBARID = "PPWFWORKTREEBARID";
    public static final String TAG_PPWFWORKTREEBARNAME = "PPWFWORKTREEBARNAME";
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
    public static final String TAG_MYWFWORKFIRST = "MYWFWORKFIRST";
    public static final String TAG_HISTORYWFWORKNAME = "HISTORYWFWORKNAME";
    public static final String TAG_WFPARALLELFOLDER = "WFPARALLELFOLDER";
    public static final String TAG_WFHISTORYWORK = "WFHISTORYWORK";
    protected Hashtable<String, PPWFWorkTreeNode> ppWFWorkTreeNodeMap = new Hashtable();

    public boolean isPPWFWORKTREEBARIDNull() {
        return this.IsParamNull(TAG_PPWFWORKTREEBARID);
    }

    public String getPPWFWORKTREEBARID() {
        return this.GetParamStringValue(TAG_PPWFWORKTREEBARID, "");
    }

    public void setPPWFWORKTREEBARID(String strValue) {
        this.SetParamValue(TAG_PPWFWORKTREEBARID, strValue);
    }

    public boolean isPPWFWORKTREEBARNAMENull() {
        return this.IsParamNull(TAG_PPWFWORKTREEBARNAME);
    }

    public String getPPWFWORKTREEBARNAME() {
        return this.GetParamStringValue(TAG_PPWFWORKTREEBARNAME, "");
    }

    public void setPPWFWORKTREEBARNAME(String strValue) {
        this.SetParamValue(TAG_PPWFWORKTREEBARNAME, strValue);
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

    public boolean isMYWFWORKFIRSTNull() {
        return this.IsParamNull(TAG_MYWFWORKFIRST);
    }

    public boolean getMYWFWORKFIRST() {
        return this.GetParamIntValue(TAG_MYWFWORKFIRST, 0) == 1;
    }

    public void setMYWFWORKFIRST(boolean bValue) {
        this.SetParamValue(TAG_MYWFWORKFIRST, bValue ? 1 : 0);
    }

    public boolean isHISTORYWFWORKNAMENull() {
        return this.IsParamNull(TAG_HISTORYWFWORKNAME);
    }

    public String getHISTORYWFWORKNAME() {
        return this.GetParamStringValue(TAG_HISTORYWFWORKNAME, "");
    }

    public void setHISTORYWFWORKNAME(String strValue) {
        this.SetParamValue(TAG_HISTORYWFWORKNAME, strValue);
    }

    public boolean isWFPARALLELFOLDERNull() {
        return this.IsParamNull(TAG_WFPARALLELFOLDER);
    }

    public boolean getWFPARALLELFOLDER() {
        return this.GetParamIntValue(TAG_WFPARALLELFOLDER, 0) == 1;
    }

    public void setWFPARALLELFOLDER(boolean bValue) {
        this.SetParamValue(TAG_WFPARALLELFOLDER, bValue ? 1 : 0);
    }

    public boolean isWFHISTORYWORKNull() {
        return this.IsParamNull(TAG_WFHISTORYWORK);
    }

    public boolean getWFHISTORYWORK() {
        return this.GetParamIntValue(TAG_WFHISTORYWORK, 0) == 1;
    }

    public void setWFHISTORYWORK(boolean bValue) {
        this.SetParamValue(TAG_WFHISTORYWORK, bValue ? 1 : 0);
    }

    public void setPPWFWorkTreeNodes(Vector<PPWFWorkTreeNode> ppWFWorkTreeNodes) {
        this.ppWFWorkTreeNodeMap.clear();
        if (ppWFWorkTreeNodes == null) {
            return;
        }
        for (PPWFWorkTreeNode ppWFWorkTreeNode : ppWFWorkTreeNodes) {
            String strKey = StringHelper.Format((String)"%1$s_%2$s", (Object)ppWFWorkTreeNode.getWFDATAGROUP(), (Object)ppWFWorkTreeNode.getNODEVALUE());
            this.ppWFWorkTreeNodeMap.put(strKey, ppWFWorkTreeNode);
        }
    }

    public PPWFWorkTreeNode FindPPWFWorkTreeNode(String strWFDataGroup, String strNodeValue) {
        String strKey = StringHelper.Format((String)"%1$s_%2$s", (Object)strWFDataGroup, (Object)strNodeValue);
        return this.ppWFWorkTreeNodeMap.get(strKey);
    }
}

