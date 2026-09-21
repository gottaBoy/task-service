/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;
import java.util.TreeMap;

public class FIUpdate
extends BaseDataEntity {
    public static final String INFOFIELD_DEFAULT = "%SRFFIINFO%";
    public static final String TAG_FIUPDATEID = "FIUPDATEID";
    public static final String TAG_FIUPDATENAME = "FIUPDATENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_RELATEDFIELDS = "RELATEDFIELDS";
    public static final String TAG_DEDATACTRLID = "DEDATACTRLID";
    public static final String TAG_DEDATACTRLNAME = "DEDATACTRLNAME";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_EXTFIELDS = "EXTFIELDS";
    public static final String TAG_INFOFIELD = "INFOFIELD";
    protected TreeMap<String, Integer> relatedFields = null;

    public String getInfoField() {
        if (StringHelper.IsNullOrEmpty((String)this.getINFOFIELD())) {
            return INFOFIELD_DEFAULT;
        }
        return this.getINFOFIELD();
    }

    public String getEXTFIELDS() {
        return this.GetParamStringValue(TAG_EXTFIELDS, "");
    }

    public void setEXTFIELDS(String strValue) {
        this.SetParamValue(TAG_EXTFIELDS, strValue);
    }

    public boolean isINFOFIELDNull() {
        return this.IsParamNull(TAG_INFOFIELD);
    }

    public String getINFOFIELD() {
        return this.GetParamStringValue(TAG_INFOFIELD, "");
    }

    public void setINFOFIELD(String strValue) {
        this.SetParamValue(TAG_INFOFIELD, strValue);
    }

    public String getFIUPDATEID() {
        return this.GetParamStringValue(TAG_FIUPDATEID, "");
    }

    public void setFIUPDATEID(String strValue) {
        this.SetParamValue(TAG_FIUPDATEID, strValue);
    }

    public String getFIUPDATENAME() {
        return this.GetParamStringValue(TAG_FIUPDATENAME, "");
    }

    public void setFIUPDATENAME(String strValue) {
        this.SetParamValue(TAG_FIUPDATENAME, strValue);
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

    public String getRELATEDFIELDS() {
        return this.GetParamStringValue(TAG_RELATEDFIELDS, "");
    }

    public void setRELATEDFIELDS(String strValue) {
        this.SetParamValue(TAG_RELATEDFIELDS, strValue);
    }

    public String getDEDATACTRLID() {
        return this.GetParamStringValue(TAG_DEDATACTRLID, "");
    }

    public void setDEDATACTRLID(String strValue) {
        this.SetParamValue(TAG_DEDATACTRLID, strValue);
    }

    public String getDEDATACTRLNAME() {
        return this.GetParamStringValue(TAG_DEDATACTRLNAME, "");
    }

    public void setDEDATACTRLNAME(String strValue) {
        this.SetParamValue(TAG_DEDATACTRLNAME, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public TreeMap<String, Integer> getRelatedFields() {
        return this.relatedFields;
    }

    public void BuildModel() {
        this.relatedFields = new TreeMap();
        CodeListConfig codeListConfig = new CodeListConfig();
        XMLConfig.LoadFromXML((String)this.getRELATEDFIELDS(), (XMLConfig)codeListConfig);
        int nCount = codeListConfig.getCodeItems().size();
        int i = 0;
        while (i < nCount) {
            CodeItemConfig codeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(i);
            this.relatedFields.put(codeItemConfig.getText().toUpperCase(), 1);
            ++i;
        }
        String strExtFields = this.getEXTFIELDS();
        if (!StringHelper.IsNullOrEmpty((String)strExtFields)) {
            String[] extFields = strExtFields.split("[;]");
            int i2 = 0;
            while (i2 < extFields.length) {
                String strField = extFields[i2];
                if (!StringHelper.IsNullOrEmpty((String)(strField = strField.trim()))) {
                    this.relatedFields.put(strField.toUpperCase(), 1);
                }
                ++i2;
            }
        }
    }
}

