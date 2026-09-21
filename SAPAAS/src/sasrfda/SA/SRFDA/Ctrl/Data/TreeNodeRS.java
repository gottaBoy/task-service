/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Web.ISRFDATreeNodeRSSelector;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Date;
import java.util.Properties;

public class TreeNodeRS
extends BaseDataEntity {
    public static final String TAG_TREENODERSID = "TREENODERSID";
    public static final String TAG_TREENODERSNAME = "TREENODERSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PTREENODEID = "PTREENODEID";
    public static final String TAG_PTREENODENAME = "PTREENODENAME";
    public static final String TAG_CTREENODEID = "CTREENODEID";
    public static final String TAG_CTREENODENAME = "CTREENODENAME";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_PROCESSPARAM = "PROCESSPARAM";
    public static final String TAG_CMCREATE = "CMCREATE";
    public static final String TAG_NEWCHILDTYPE = "NEWCHILDTYPE";
    public static final String TAG_NEWCHILDPATH = "NEWCHILDPATH";
    public static final String TAG_NEWDEBHGROUPID = "NEWDEBHGROUPID";
    public static final String TAG_NEWDEBHGROUPNAME = "NEWDEBHGROUPNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_SELECTORHELPER = "SELECTORHELPER";
    private Properties processParams = null;
    private ISRFDATreeNodeRSSelector iSRFDATreeNodeRSSelector = null;

    public void BuildProcessParams() {
        try {
            if (!StringHelper.IsNullOrEmpty((String)this.getPROCESSPARAM())) {
                this.processParams = new Properties();
                this.processParams = PropertiesHelper.Load((Properties)this.processParams, (String)this.getPROCESSPARAM());
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Properties getProcessParams() {
        return this.processParams;
    }

    public ISRFDATreeNodeRSSelector getTreeNodeRSSelector() {
        if (StringHelper.IsNullOrEmpty((String)this.getSELECTORHELPER())) {
            return null;
        }
        if (this.iSRFDATreeNodeRSSelector != null) {
            return this.iSRFDATreeNodeRSSelector;
        }
        ISRFDATreeNodeRSSelector iSRFDATreeNodeRSSelector = (ISRFDATreeNodeRSSelector)ObjectHelper.Create((String)this.getSELECTORHELPER());
        iSRFDATreeNodeRSSelector.Init(this);
        this.iSRFDATreeNodeRSSelector = iSRFDATreeNodeRSSelector;
        return this.iSRFDATreeNodeRSSelector;
    }

    public String getTREENODERSID() {
        return this.GetParamStringValue(TAG_TREENODERSID, "");
    }

    public void setTREENODERSID(String strValue) {
        this.SetParamValue(TAG_TREENODERSID, strValue);
    }

    public String getTREENODERSNAME() {
        return this.GetParamStringValue(TAG_TREENODERSNAME, "");
    }

    public void setTREENODERSNAME(String strValue) {
        this.SetParamValue(TAG_TREENODERSNAME, strValue);
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

    public String getPTREENODEID() {
        return this.GetParamStringValue(TAG_PTREENODEID, "");
    }

    public void setPTREENODEID(String strValue) {
        this.SetParamValue(TAG_PTREENODEID, strValue);
    }

    public String getPTREENODENAME() {
        return this.GetParamStringValue(TAG_PTREENODENAME, "");
    }

    public void setPTREENODENAME(String strValue) {
        this.SetParamValue(TAG_PTREENODENAME, strValue);
    }

    public String getCTREENODEID() {
        return this.GetParamStringValue(TAG_CTREENODEID, "");
    }

    public void setCTREENODEID(String strValue) {
        this.SetParamValue(TAG_CTREENODEID, strValue);
    }

    public String getCTREENODENAME() {
        return this.GetParamStringValue(TAG_CTREENODENAME, "");
    }

    public void setCTREENODENAME(String strValue) {
        this.SetParamValue(TAG_CTREENODENAME, strValue);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int strValue) {
        this.SetParamValue(TAG_ORDERFLAG, strValue);
    }

    public String getPROCESSPARAM() {
        return this.GetParamStringValue(TAG_PROCESSPARAM, "");
    }

    public void setPROCESSPARAM(String strValue) {
        this.SetParamValue(TAG_PROCESSPARAM, strValue);
    }

    public boolean isCMCREATENull() {
        return this.IsParamNull(TAG_CMCREATE);
    }

    public boolean getCMCREATE() {
        return this.GetParamIntValue(TAG_CMCREATE, 0) == 1;
    }

    public void setCMCREATE(boolean bValue) {
        this.SetParamValue(TAG_CMCREATE, bValue ? 1 : 0);
    }

    public boolean isNEWDEBHGROUPIDNull() {
        return this.IsParamNull(TAG_NEWDEBHGROUPID);
    }

    public String getNEWDEBHGROUPID() {
        return this.GetParamStringValue(TAG_NEWDEBHGROUPID, "");
    }

    public void setNEWDEBHGROUPID(String strValue) {
        this.SetParamValue(TAG_NEWDEBHGROUPID, strValue);
    }

    public boolean isNEWDEBHGROUPNAMENull() {
        return this.IsParamNull(TAG_NEWDEBHGROUPNAME);
    }

    public String getNEWDEBHGROUPNAME() {
        return this.GetParamStringValue(TAG_NEWDEBHGROUPNAME, "");
    }

    public void setNEWDEBHGROUPNAME(String strValue) {
        this.SetParamValue(TAG_NEWDEBHGROUPNAME, strValue);
    }

    public boolean isNEWCHILDPATHNull() {
        return this.IsParamNull(TAG_NEWCHILDPATH);
    }

    public String getNEWCHILDPATH() {
        return this.GetParamStringValue(TAG_NEWCHILDPATH, "");
    }

    public void setNEWCHILDPATH(String strValue) {
        this.SetParamValue(TAG_NEWCHILDPATH, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isSELECTORHELPERNull() {
        return this.IsParamNull(TAG_SELECTORHELPER);
    }

    public final String getSELECTORHELPER() {
        return this.GetParamStringValue(TAG_SELECTORHELPER, "");
    }

    public final void setSELECTORHELPER(String strValue) {
        this.SetParamValue(TAG_SELECTORHELPER, strValue);
    }
}

