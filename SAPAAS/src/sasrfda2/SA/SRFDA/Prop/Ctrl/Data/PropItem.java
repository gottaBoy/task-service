/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Prop.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PropItem
extends BaseDataEntity {
    public static final String TAG_PROPITEMID = "PROPITEMID";
    public static final String TAG_PROPITEMNAME = "PROPITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ENABLEFLAG = "ENABLEFLAG";
    public static final String TAG_PROPSTRUCTNAME = "PROPSTRUCTNAME";
    public static final String TAG_PROPGROUPNAME = "PROPGROUPNAME";
    public static final String TAG_PROPSTRUCTID = "PROPSTRUCTID";
    public static final String TAG_PROPGROUPID = "PROPGROUPID";
    public static final String TAG_DATATYPE = "DATATYPE";
    public static final String TAG_CODELISTID = "CODELISTID";
    public static final String TAG_CODELISTNAME = "CODELISTNAME";
    public static final String TAG_PICKUPDEID = "PICKUPDEID";
    public static final String TAG_PICKUPDENAME = "PICKUPDENAME";
    public static final String TAG_PICKUPPAGEID = "PICKUPPAGEID";
    public static final String TAG_PICKUPPAGENAME = "PICKUPPAGENAME";
    public static final String TAG_PICKUPPARAM = "PICKUPPARAM";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PROPOBJSTRUCTID = "PROPOBJSTRUCTID";
    public static final String TAG_PROPOBJSTRUCTNAME = "PROPOBJSTRUCTNAME";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_LOGICXML = "LOGICXML";

    public boolean isPROPITEMIDNull() {
        return this.IsParamNull(TAG_PROPITEMID);
    }

    public String getPROPITEMID() {
        return this.GetParamStringValue(TAG_PROPITEMID, "");
    }

    public void setPROPITEMID(String strValue) {
        this.SetParamValue(TAG_PROPITEMID, strValue);
    }

    public boolean isPROPITEMNAMENull() {
        return this.IsParamNull(TAG_PROPITEMNAME);
    }

    public String getPROPITEMNAME() {
        return this.GetParamStringValue(TAG_PROPITEMNAME, "");
    }

    public void setPROPITEMNAME(String strValue) {
        this.SetParamValue(TAG_PROPITEMNAME, strValue);
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

    public boolean isENABLEFLAGNull() {
        return this.IsParamNull(TAG_ENABLEFLAG);
    }

    public boolean getENABLEFLAG() {
        return this.GetParamIntValue(TAG_ENABLEFLAG, 0) == 1;
    }

    public void setENABLEFLAG(boolean bValue) {
        this.SetParamValue(TAG_ENABLEFLAG, bValue ? 1 : 0);
    }

    public boolean isPROPSTRUCTNAMENull() {
        return this.IsParamNull(TAG_PROPSTRUCTNAME);
    }

    public String getPROPSTRUCTNAME() {
        return this.GetParamStringValue(TAG_PROPSTRUCTNAME, "");
    }

    public void setPROPSTRUCTNAME(String strValue) {
        this.SetParamValue(TAG_PROPSTRUCTNAME, strValue);
    }

    public boolean isPROPGROUPNAMENull() {
        return this.IsParamNull(TAG_PROPGROUPNAME);
    }

    public String getPROPGROUPNAME() {
        return this.GetParamStringValue(TAG_PROPGROUPNAME, "");
    }

    public void setPROPGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PROPGROUPNAME, strValue);
    }

    public boolean isPROPSTRUCTIDNull() {
        return this.IsParamNull(TAG_PROPSTRUCTID);
    }

    public String getPROPSTRUCTID() {
        return this.GetParamStringValue(TAG_PROPSTRUCTID, "");
    }

    public void setPROPSTRUCTID(String strValue) {
        this.SetParamValue(TAG_PROPSTRUCTID, strValue);
    }

    public boolean isPROPGROUPIDNull() {
        return this.IsParamNull(TAG_PROPGROUPID);
    }

    public String getPROPGROUPID() {
        return this.GetParamStringValue(TAG_PROPGROUPID, "");
    }

    public void setPROPGROUPID(String strValue) {
        this.SetParamValue(TAG_PROPGROUPID, strValue);
    }

    public boolean isDATATYPENull() {
        return this.IsParamNull(TAG_DATATYPE);
    }

    public String getDATATYPE() {
        return this.GetParamStringValue(TAG_DATATYPE, "");
    }

    public void setDATATYPE(String strValue) {
        this.SetParamValue(TAG_DATATYPE, strValue);
    }

    public boolean isCODELISTIDNull() {
        return this.IsParamNull(TAG_CODELISTID);
    }

    public String getCODELISTID() {
        return this.GetParamStringValue(TAG_CODELISTID, "");
    }

    public void setCODELISTID(String strValue) {
        this.SetParamValue(TAG_CODELISTID, strValue);
    }

    public boolean isCODELISTNAMENull() {
        return this.IsParamNull(TAG_CODELISTNAME);
    }

    public String getCODELISTNAME() {
        return this.GetParamStringValue(TAG_CODELISTNAME, "");
    }

    public void setCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_CODELISTNAME, strValue);
    }

    public boolean isPICKUPDEIDNull() {
        return this.IsParamNull(TAG_PICKUPDEID);
    }

    public String getPICKUPDEID() {
        return this.GetParamStringValue(TAG_PICKUPDEID, "");
    }

    public void setPICKUPDEID(String strValue) {
        this.SetParamValue(TAG_PICKUPDEID, strValue);
    }

    public boolean isPICKUPDENAMENull() {
        return this.IsParamNull(TAG_PICKUPDENAME);
    }

    public String getPICKUPDENAME() {
        return this.GetParamStringValue(TAG_PICKUPDENAME, "");
    }

    public void setPICKUPDENAME(String strValue) {
        this.SetParamValue(TAG_PICKUPDENAME, strValue);
    }

    public boolean isPICKUPPAGEIDNull() {
        return this.IsParamNull(TAG_PICKUPPAGEID);
    }

    public String getPICKUPPAGEID() {
        return this.GetParamStringValue(TAG_PICKUPPAGEID, "");
    }

    public void setPICKUPPAGEID(String strValue) {
        this.SetParamValue(TAG_PICKUPPAGEID, strValue);
    }

    public boolean isPICKUPPAGENAMENull() {
        return this.IsParamNull(TAG_PICKUPPAGENAME);
    }

    public String getPICKUPPAGENAME() {
        return this.GetParamStringValue(TAG_PICKUPPAGENAME, "");
    }

    public void setPICKUPPAGENAME(String strValue) {
        this.SetParamValue(TAG_PICKUPPAGENAME, strValue);
    }

    public boolean isPICKUPPARAMNull() {
        return this.IsParamNull(TAG_PICKUPPARAM);
    }

    public String getPICKUPPARAM() {
        return this.GetParamStringValue(TAG_PICKUPPARAM, "");
    }

    public void setPICKUPPARAM(String strValue) {
        this.SetParamValue(TAG_PICKUPPARAM, strValue);
    }

    public boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public boolean isPROPOBJSTRUCTIDNull() {
        return this.IsParamNull(TAG_PROPOBJSTRUCTID);
    }

    public String getPROPOBJSTRUCTID() {
        return this.GetParamStringValue(TAG_PROPOBJSTRUCTID, "");
    }

    public void setPROPOBJSTRUCTID(String strValue) {
        this.SetParamValue(TAG_PROPOBJSTRUCTID, strValue);
    }

    public boolean isPROPOBJSTRUCTNAMENull() {
        return this.IsParamNull(TAG_PROPOBJSTRUCTNAME);
    }

    public String getPROPOBJSTRUCTNAME() {
        return this.GetParamStringValue(TAG_PROPOBJSTRUCTNAME, "");
    }

    public void setPROPOBJSTRUCTNAME(String strValue) {
        this.SetParamValue(TAG_PROPOBJSTRUCTNAME, strValue);
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

    public boolean isLOGICXMLNull() {
        return this.IsParamNull(TAG_LOGICXML);
    }

    public String getLOGICXML() {
        return this.GetParamStringValue(TAG_LOGICXML, "");
    }

    public void setLOGICXML(String strValue) {
        this.SetParamValue(TAG_LOGICXML, strValue);
    }
}

