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

public class DBStorage
extends BaseDataEntity {
    public static final String PROPERTY_DBSCHEMA = "DBSCHEMA";
    public static final String PROPERTY_DBMODELHELPER = "DBMODELHELPER";
    public static final String PROPERTY_DEDATACTRLHELPER = "DEDATACTRLHELPER";
    public static final String PROPERTY_DEDATACTRL = "DEDATACTRL";
    public static final String PROPERTY_DAQUERYMODELHELPER = "DAQUERYMODELHELPER";
    public static final String PROPERTY_DEFDTCOLUMN = "DEFDTCOLUMN";
    public static final String PROPERTY_DEHELPER = "DEHELPER";
    public static final String PROPERTY_WFDGACTIONHELPER = "WFDGACTIONHELPER";
    public static final String PROPERTY_DGACTIONHELPER = "DGACTIONHELPER";
    public static final String PROPERTY_DGEXACTIONHELPER = "DGEXACTIONHELPER";
    public static final String TAG_DBSTORAGEID = "DBSTORAGEID";
    public static final String TAG_DBSTORAGENAME = "DBSTORAGENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PARAMS = "PARAMS";
    public static final String TAG_DSN = "DSN";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_DBCALLER = "DBCALLER";
    public static final String TAG_DBSTORAGEOBJECT = "DBSTORAGEOBJECT";
    private Properties params = null;

    public String getDBSTORAGEID() {
        return this.GetParamStringValue(TAG_DBSTORAGEID, "");
    }

    public void setDBSTORAGEID(String strValue) {
        this.SetParamValue(TAG_DBSTORAGEID, strValue);
    }

    public String getDBSTORAGENAME() {
        return this.GetParamStringValue(TAG_DBSTORAGENAME, "");
    }

    public void setDBSTORAGENAME(String strValue) {
        this.SetParamValue(TAG_DBSTORAGENAME, strValue);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public String getPARAMS() {
        return this.GetParamStringValue(TAG_PARAMS, "");
    }

    public void setPARAMS(String strValue) {
        this.SetParamValue(TAG_PARAMS, strValue);
    }

    public String getDSN() {
        return this.GetParamStringValue(TAG_DSN, "");
    }

    public void setDSN(String strValue) {
        this.SetParamValue(TAG_DSN, strValue);
    }

    public String getDBTYPE() {
        return this.GetParamStringValue(TAG_DBTYPE, "");
    }

    public void setDBTYPE(String strValue) {
        this.SetParamValue(TAG_DBTYPE, strValue);
    }

    public String getDBCALLER() {
        return this.GetParamStringValue(TAG_DBCALLER, "");
    }

    public void setDBCALLER(String strValue) {
        this.SetParamValue(TAG_DBCALLER, strValue);
    }

    public String getDBSTORAGEOBJECT() {
        return this.GetParamStringValue(TAG_DBSTORAGEOBJECT, "");
    }

    public void setDBSTORAGEOBJECT(String strValue) {
        this.SetParamValue(TAG_DBSTORAGEOBJECT, strValue);
    }

    public void PrepareParams() {
        if (this.params != null) {
            return;
        }
        try {
            this.params = PropertiesHelper.Load((String)this.getPARAMS());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Properties getParams() {
        this.PrepareParams();
        return this.params;
    }

    public String GetParam(String strName, String strDefault) {
        this.PrepareParams();
        String strValue = PropertiesHelper.GetProperty((Properties)this.params, (String)strName);
        if (strValue == null) {
            return strDefault;
        }
        return strValue;
    }
}

