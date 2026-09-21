/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Date;
import java.util.Properties;

public class PageParamType
extends BaseDataEntity {
    public static final String TAG_PAGEPARAMTYPEID = "PAGEPARAMTYPEID";
    public static final String TAG_PAGEPARAMTYPENAME = "PAGEPARAMTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ICONCLS = "ICONCLS";
    public static final String TAG_PAGETEMPLID = "PAGETEMPLID";
    public static final String TAG_PAGETEMPLNAME = "PAGETEMPLNAME";
    public static final String TAG_CTRLID = "CTRLID";
    public static final String TAG_PARAMTYPE = "PARAMTYPE";
    public static final String TAG_INITPARAM = "INITPARAM";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_PARAMGROUP = "PARAMGROUP";
    private Properties initProperties = null;

    public void BuildInitParam() {
        try {
            this.initProperties = new Properties();
            this.initProperties = PropertiesHelper.Load((Properties)this.initProperties, (String)this.getINITPARAM());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Properties getInitParam() {
        return this.initProperties;
    }

    public String getPAGEPARAMTYPEID() {
        return this.GetParamStringValue(TAG_PAGEPARAMTYPEID, "");
    }

    public void setPAGEPARAMTYPEID(String strValue) {
        this.SetParamValue(TAG_PAGEPARAMTYPEID, strValue);
    }

    public String getPAGEPARAMTYPENAME() {
        return this.GetParamStringValue(TAG_PAGEPARAMTYPENAME, "");
    }

    public void setPAGEPARAMTYPENAME(String strValue) {
        this.SetParamValue(TAG_PAGEPARAMTYPENAME, strValue);
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

    public String getICONCLS() {
        return this.GetParamStringValue(TAG_ICONCLS, "");
    }

    public void setICONCLS(String strValue) {
        this.SetParamValue(TAG_ICONCLS, strValue);
    }

    public String getPAGETEMPLID() {
        return this.GetParamStringValue(TAG_PAGETEMPLID, "");
    }

    public void setPAGETEMPLID(String strValue) {
        this.SetParamValue(TAG_PAGETEMPLID, strValue);
    }

    public String getPAGETEMPLNAME() {
        return this.GetParamStringValue(TAG_PAGETEMPLNAME, "");
    }

    public void setPAGETEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PAGETEMPLNAME, strValue);
    }

    public String getCTRLID() {
        return this.GetParamStringValue(TAG_CTRLID, "");
    }

    public void setCTRLID(String strValue) {
        this.SetParamValue(TAG_CTRLID, strValue);
    }

    public String getPARAMTYPE() {
        return this.GetParamStringValue(TAG_PARAMTYPE, "");
    }

    public void setPARAMTYPE(String strValue) {
        this.SetParamValue(TAG_PARAMTYPE, strValue);
    }

    public String getINITPARAM() {
        return this.GetParamStringValue(TAG_INITPARAM, "");
    }

    public void setINITPARAM(String strValue) {
        this.SetParamValue(TAG_INITPARAM, strValue);
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

    public boolean isPARAMGROUPNull() {
        return this.IsParamNull(TAG_PARAMGROUP);
    }

    public String getPARAMGROUP() {
        return this.GetParamStringValue(TAG_PARAMGROUP, "");
    }

    public void setPARAMGROUP(String strValue) {
        this.SetParamValue(TAG_PARAMGROUP, strValue);
    }
}

