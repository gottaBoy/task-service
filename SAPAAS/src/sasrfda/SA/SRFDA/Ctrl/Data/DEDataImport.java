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
import java.util.Vector;

public class DEDataImport
extends BaseDataEntity {
    public static final String TAG_DEDATAIMPORTID = "DEDATAIMPORTID";
    public static final String TAG_DEDATAIMPORTNAME = "DEDATAIMPORTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_TEMPLPATH = "TEMPLPATH";
    public static final String TAG_IMPORTVIEW = "IMPORTVIEW";
    public static final String TAG_IMPORTACTION = "IMPORTACTION";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_STOPWHENERROR = "STOPWHENERROR";
    public static final String TAG_MULTIKEY = "MULTIKEY";
    public static final String TAG_INSERTMODE = "INSERTMODE";
    public static final String TAG_UPDATEMODE = "UPDATEMODE";
    public static final String TAG_INSERTDATAACTION = "INSERTDATAACTION";
    public static final String TAG_UPDATEDATAACTION = "UPDATEDATAACTION";
    protected Vector<String> multiKeys = null;

    public String getDEDATAIMPORTID() {
        return this.GetParamStringValue(TAG_DEDATAIMPORTID, "");
    }

    public void setDEDATAIMPORTID(String strValue) {
        this.SetParamValue(TAG_DEDATAIMPORTID, strValue);
    }

    public String getDEDATAIMPORTNAME() {
        return this.GetParamStringValue(TAG_DEDATAIMPORTNAME, "");
    }

    public void setDEDATAIMPORTNAME(String strValue) {
        this.SetParamValue(TAG_DEDATAIMPORTNAME, strValue);
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

    public String getTEMPLPATH() {
        return this.GetParamStringValue(TAG_TEMPLPATH, "");
    }

    public void setTEMPLPATH(String strValue) {
        this.SetParamValue(TAG_TEMPLPATH, strValue);
    }

    public String getIMPORTVIEW() {
        return this.GetParamStringValue(TAG_IMPORTVIEW, "");
    }

    public void setIMPORTVIEW(String strValue) {
        this.SetParamValue(TAG_IMPORTVIEW, strValue);
    }

    public String getIMPORTACTION() {
        return this.GetParamStringValue(TAG_IMPORTACTION, "");
    }

    public void setIMPORTACTION(String strValue) {
        this.SetParamValue(TAG_IMPORTACTION, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isSTOPWHENERRORNull() {
        return this.IsParamNull(TAG_STOPWHENERROR);
    }

    public boolean getSTOPWHENERROR() {
        return this.GetParamIntValue(TAG_STOPWHENERROR, 0) == 1;
    }

    public void setSTOPWHENERROR(boolean bValue) {
        this.SetParamValue(TAG_STOPWHENERROR, bValue ? 1 : 0);
    }

    public boolean isMULTIKEYNull() {
        return this.IsParamNull(TAG_MULTIKEY);
    }

    public String getMULTIKEY() {
        return this.GetParamStringValue(TAG_MULTIKEY, "");
    }

    public void setMULTIKEY(String strValue) {
        this.SetParamValue(TAG_MULTIKEY, strValue);
    }

    public boolean isINSERTMODENull() {
        return this.IsParamNull(TAG_INSERTMODE);
    }

    public String getINSERTMODE() {
        return this.GetParamStringValue(TAG_INSERTMODE, "");
    }

    public void setINSERTMODE(String strValue) {
        this.SetParamValue(TAG_INSERTMODE, strValue);
    }

    public boolean isUPDATEMODENull() {
        return this.IsParamNull(TAG_UPDATEMODE);
    }

    public String getUPDATEMODE() {
        return this.GetParamStringValue(TAG_UPDATEMODE, "");
    }

    public void setUPDATEMODE(String strValue) {
        this.SetParamValue(TAG_UPDATEMODE, strValue);
    }

    public boolean isINSERTDATAACTIONNull() {
        return this.IsParamNull(TAG_INSERTDATAACTION);
    }

    public String getINSERTDATAACTION() {
        return this.GetParamStringValue(TAG_INSERTDATAACTION, "");
    }

    public void setINSERTDATAACTION(String strValue) {
        this.SetParamValue(TAG_INSERTDATAACTION, strValue);
    }

    public boolean isUPDATEDATAACTIONNull() {
        return this.IsParamNull(TAG_UPDATEDATAACTION);
    }

    public String getUPDATEDATAACTION() {
        return this.GetParamStringValue(TAG_UPDATEDATAACTION, "");
    }

    public void setUPDATEDATAACTION(String strValue) {
        this.SetParamValue(TAG_UPDATEDATAACTION, strValue);
    }

    public Vector<String> getMultiKeys() {
        return this.multiKeys;
    }

    public void BuildModel() {
        if (this.multiKeys != null) {
            return;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getMULTIKEY())) {
            TreeMap<String, Integer> multiKeyMap = new TreeMap<String, Integer>();
            CodeListConfig codeListConfig = new CodeListConfig();
            if (XMLConfig.LoadFromXML((String)this.getMULTIKEY(), (XMLConfig)codeListConfig)) {
                int nCount = codeListConfig.getCodeItems().size();
                int i = 0;
                while (i < nCount) {
                    CodeItemConfig codeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(i);
                    if (!multiKeyMap.containsKey(codeItemConfig.getText().toUpperCase())) {
                        multiKeyMap.put(codeItemConfig.getText().toUpperCase(), 1);
                        this.multiKeys.add(codeItemConfig.getText().toUpperCase());
                    }
                    ++i;
                }
            }
        }
    }
}

