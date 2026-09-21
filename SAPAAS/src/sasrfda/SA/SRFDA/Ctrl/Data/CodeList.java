/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;

public class CodeList
extends BaseDataEntity {
    public static final String TAG_CLMODEL = "CLMODEL";
    public static final String TAG_CLPATH = "CLPATH";
    public static final String TAG_CLVERSION = "CLVERSION";
    public static final String TAG_CODELISTID = "CODELISTID";
    public static final String TAG_CODELISTNAME = "CODELISTNAME";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_FILLER = "FILLER";
    public static final String TAG_EMPTYTEXT = "EMPTYTEXT";
    public static final String TAG_ORMODE = "ORMODE";
    public static final String TAG_NOVALUEEMPTY = "NOVALUEEMPTY";
    public static final String TAG_NUMBERORMODE = "NUMBERORMODE";
    public static final String TAG_STRINGORMODE = "STRINGORMODE";
    public static final String TAG_SEPERATOR = "SEPERATOR";
    public static final String TAG_VALUESEPERATOR = "VALUESEPERATOR";
    public static final String TAG_ISUSERSCOPE = "ISUSERSCOPE";
    public static final String TAG_CLPARAM = "CLPARAM";
    private Properties codeListProperties = null;

    public String getCLMODEL() {
        return this.GetParamStringValue(TAG_CLMODEL, "");
    }

    public String getCLPATH() {
        return this.GetParamStringValue(TAG_CLPATH, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public String getCODELISTNAME() {
        return this.GetParamStringValue(TAG_CODELISTNAME, "");
    }

    public void setCLMODEL(String strValue) {
        this.SetParamValue(TAG_CLMODEL, strValue);
    }

    public void setCLPATH(String strValue) {
        this.SetParamValue(TAG_CLPATH, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public void setCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_CODELISTNAME, strValue);
    }

    public String getCODELISTID() {
        return this.GetParamStringValue(TAG_CODELISTID, "");
    }

    public void setCODELISTID(String strValue) {
        this.SetParamValue(TAG_CODELISTID, strValue);
    }

    public String getFILLER() {
        return this.GetParamStringValue(TAG_FILLER, "");
    }

    public void setFILLER(String strValue) {
        this.SetParamValue(TAG_FILLER, strValue);
    }

    public String getEMPTYTEXT() {
        return this.GetParamStringValue(TAG_EMPTYTEXT, "");
    }

    public void setEMPTYTEXT(String strValue) {
        this.SetParamValue(TAG_EMPTYTEXT, strValue);
    }

    public String getORMODE() {
        return this.GetParamStringValue(TAG_ORMODE, "");
    }

    public void setORMODE(String strValue) {
        this.SetParamValue(TAG_ORMODE, strValue);
    }

    public String getSEPERATOR() {
        return this.GetParamStringValue(TAG_SEPERATOR, "");
    }

    public void setSEPERATOR(String strValue) {
        this.SetParamValue(TAG_SEPERATOR, strValue);
    }

    public String getVALUESEPERATOR() {
        return this.GetParamStringValue(TAG_VALUESEPERATOR, "");
    }

    public void setVALUESEPERATOR(String strValue) {
        this.SetParamValue(TAG_VALUESEPERATOR, strValue);
    }

    public int getCLVERSION() {
        return this.GetParamIntValue(TAG_CLVERSION, -1);
    }

    public void setCLVERSION(int nValue) {
        this.SetParamValue(TAG_CLVERSION, nValue);
    }

    public boolean isUSERSCOPE() {
        return this.GetParamIntValue(TAG_ISUSERSCOPE, 0) == 1;
    }

    public boolean isNOVALUEEMPTY() {
        return this.GetParamIntValue(TAG_NOVALUEEMPTY, 0) == 1;
    }

    public String getCLPARAM() {
        return this.GetParamStringValue(TAG_CLPARAM, "");
    }

    public void setCLPARAM(String strValue) {
        this.SetParamValue(TAG_CLPARAM, strValue);
    }

    public final Properties GetCodeListParams() {
        try {
            if (this.codeListProperties != null) {
                return this.codeListProperties;
            }
            String strChartParam = this.getCLPARAM();
            if (!StringHelper.IsNullOrEmpty((String)strChartParam)) {
                this.codeListProperties = PropertiesHelper.Load((Properties)this.codeListProperties, (String)strChartParam);
            }
        }
        catch (Exception ex) {
            return null;
        }
        return this.codeListProperties;
    }
}

