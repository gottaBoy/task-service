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
import java.util.Date;
import java.util.Properties;
import java.util.TreeMap;

public class DEDCProcess
extends BaseDataEntity {
    public static final String TAG_DEDCPROCESSID = "DEDCPROCESSID";
    public static final String TAG_DEDCPROCESSNAME = "DEDCPROCESSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SRCDATAENTITY = "SRCDATAENTITY";
    public static final String TAG_DSTDATAENTITY = "DSTDATAENTITY";
    public static final String TAG_DSTDATAENTITYTYPE = "DSTDATAENTITYTYPE";
    public static final String TAG_SRCDATAENTITYTYPE = "SRCDATAENTITYTYPE";
    public static final String TAG_DEACTION = "DEACTION";
    public static final String TAG_DEPARAM = "DEPARAM";
    public static final String TAG_SCRIPT = "SCRIPT";
    public static final String TAG_ERRORCODE = "ERRORCODE";
    public static final String TAG_USERERRORCODE = "USERERRORCODE";
    public static final String TAG_ERRORINFO = "ERRORINFO";
    public static final String TAG_PROCESSOBJECT = "PROCESSOBJECT";
    public static final String TAG_PARAMID = "PARAMID";
    public static final String TAG_IGNOREERROR = "IGNOREERROR";
    public static final String TAG_PARAM1 = "PARAM1";
    public static final String TAG_PARAM2 = "PARAM2";
    public static final String TAG_PARAM3 = "PARAM3";
    public static final String TAG_PARAM4 = "PARAM4";
    public static final String TAG_PARAM5 = "PARAM5";
    public static final String TAG_PARAM6 = "PARAM6";
    public static final String TAG_PARAM7 = "PARAM7";
    public static final String TAG_PARAM8 = "PARAM8";
    public static final String TAG_PARAM9 = "PARAM9";
    public static final String TAG_PARAM10 = "PARAM10";
    public static final String TAG_PARAM11 = "PARAM11";
    public static final String TAG_PARAM12 = "PARAM12";
    public static final String TAG_PARAM13 = "PARAM13";
    public static final String TAG_PARAM14 = "PARAM14";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DEID = "DEID";
    private TreeMap<String, Properties> paramsMap = new TreeMap();

    public String getDEDCPROCESSID() {
        return this.GetParamStringValue(TAG_DEDCPROCESSID, "");
    }

    public void setDEDCPROCESSID(String strValue) {
        this.SetParamValue(TAG_DEDCPROCESSID, strValue);
    }

    public String getDEDCPROCESSNAME() {
        return this.GetParamStringValue(TAG_DEDCPROCESSNAME, "");
    }

    public void setDEDCPROCESSNAME(String strValue) {
        this.SetParamValue(TAG_DEDCPROCESSNAME, strValue);
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

    public String getSRCDATAENTITY() {
        String strValue = this.GetParamStringValue(TAG_SRCDATAENTITY, "");
        if (!StringHelper.IsNullOrEmpty((String)strValue)) {
            return strValue;
        }
        return this.getSRCDATAENTITYTYPE();
    }

    public void setSRCDATAENTITY(String strValue) {
        this.SetParamValue(TAG_SRCDATAENTITY, strValue);
    }

    public String getDSTDATAENTITY() {
        String strValue = this.GetParamStringValue(TAG_DSTDATAENTITY, "");
        if (!StringHelper.IsNullOrEmpty((String)strValue)) {
            return strValue;
        }
        return this.getDSTDATAENTITYTYPE();
    }

    public void setDSTDATAENTITY(String strValue) {
        this.SetParamValue(TAG_DSTDATAENTITY, strValue);
    }

    public String getDEACTION() {
        return this.GetParamStringValue(TAG_DEACTION, "");
    }

    public void setDEACTION(String strValue) {
        this.SetParamValue(TAG_DEACTION, strValue);
    }

    public String getDEPARAM() {
        return this.GetParamStringValue(TAG_DEPARAM, "");
    }

    public void setDEPARAM(String strValue) {
        this.SetParamValue(TAG_DEPARAM, strValue);
    }

    public String getSCRIPT() {
        return this.GetParamStringValue(TAG_SCRIPT, "");
    }

    public void setSCRIPT(String strValue) {
        this.SetParamValue(TAG_SCRIPT, strValue);
    }

    public String getERRORCODE() {
        return this.GetParamStringValue(TAG_ERRORCODE, "");
    }

    public void setERRORCODE(String strValue) {
        this.SetParamValue(TAG_ERRORCODE, strValue);
    }

    public int getUSERERRORCODE() {
        return this.GetParamIntValue(TAG_USERERRORCODE, 0);
    }

    public void setUSERERRORCODE(int strValue) {
        this.SetParamValue(TAG_USERERRORCODE, strValue);
    }

    public String getERRORINFO() {
        return this.GetParamStringValue(TAG_ERRORINFO, "");
    }

    public void setERRORINFO(String strValue) {
        this.SetParamValue(TAG_ERRORINFO, strValue);
    }

    public String getPROCESSOBJECT() {
        return this.GetParamStringValue(TAG_PROCESSOBJECT, "");
    }

    public void setPROCESSOBJECT(String strValue) {
        this.SetParamValue(TAG_PROCESSOBJECT, strValue);
    }

    public String getPARAMID() {
        return this.GetParamStringValue(TAG_PARAMID, "");
    }

    public void setPARAMID(String strValue) {
        this.SetParamValue(TAG_PARAMID, strValue);
    }

    public String getIGNOREERROR() {
        return this.GetParamStringValue(TAG_IGNOREERROR, "");
    }

    public void setIGNOREERROR(String strValue) {
        this.SetParamValue(TAG_IGNOREERROR, strValue);
    }

    public String getPARAM1() {
        return this.GetParamStringValue(TAG_PARAM1, "");
    }

    public void setPARAM1(String strValue) {
        this.SetParamValue(TAG_PARAM1, strValue);
    }

    public String getPARAM2() {
        return this.GetParamStringValue(TAG_PARAM2, "");
    }

    public void setPARAM2(String strValue) {
        this.SetParamValue(TAG_PARAM2, strValue);
    }

    public String getPARAM3() {
        return this.GetParamStringValue(TAG_PARAM3, "");
    }

    public void setPARAM3(String strValue) {
        this.SetParamValue(TAG_PARAM3, strValue);
    }

    public String getPARAM4() {
        return this.GetParamStringValue(TAG_PARAM4, "");
    }

    public void setPARAM4(String strValue) {
        this.SetParamValue(TAG_PARAM4, strValue);
    }

    public String getPARAM5() {
        return this.GetParamStringValue(TAG_PARAM5, "");
    }

    public void setPARAM5(String strValue) {
        this.SetParamValue(TAG_PARAM5, strValue);
    }

    public String getPARAM6() {
        return this.GetParamStringValue(TAG_PARAM6, "");
    }

    public void setPARAM6(String strValue) {
        this.SetParamValue(TAG_PARAM6, strValue);
    }

    public int getPARAM7() {
        return this.GetParamIntValue(TAG_PARAM7, 0);
    }

    public void setPARAM7(int strValue) {
        this.SetParamValue(TAG_PARAM7, strValue);
    }

    public int getPARAM8() {
        return this.GetParamIntValue(TAG_PARAM8, 0);
    }

    public void setPARAM8(int strValue) {
        this.SetParamValue(TAG_PARAM8, strValue);
    }

    public boolean getPARAM9() {
        return this.GetParamIntValue(TAG_PARAM9, 0) == 1;
    }

    public boolean getPARAM9(boolean bDefault) {
        if (this.IsParamNull(TAG_PARAM9)) {
            return bDefault;
        }
        return this.GetParamIntValue(TAG_PARAM9, 0) == 1;
    }

    public void setPARAM9(boolean bValue) {
        this.SetParamValue(TAG_PARAM9, bValue ? 1 : 0);
    }

    public boolean getPARAM10() {
        return this.GetParamIntValue(TAG_PARAM10, 0) == 1;
    }

    public boolean getPARAM10(boolean bDefault) {
        if (this.IsParamNull(TAG_PARAM10)) {
            return bDefault;
        }
        return this.GetParamIntValue(TAG_PARAM10, 0) == 1;
    }

    public void setPARAM10(boolean bValue) {
        this.SetParamValue(TAG_PARAM10, bValue ? 1 : 0);
    }

    public String getPARAM11() {
        return this.GetParamStringValue(TAG_PARAM11, "");
    }

    public void setPARAM11(String strValue) {
        this.SetParamValue(TAG_PARAM11, strValue);
    }

    public String getPARAM12() {
        return this.GetParamStringValue(TAG_PARAM12, "");
    }

    public void setPARAM12(String strValue) {
        this.SetParamValue(TAG_PARAM12, strValue);
    }

    public String getPARAM13() {
        return this.GetParamStringValue(TAG_PARAM13, "");
    }

    public void setPARAM13(String strValue) {
        this.SetParamValue(TAG_PARAM13, strValue);
    }

    public String getPARAM14() {
        return this.GetParamStringValue(TAG_PARAM14, "");
    }

    public void setPARAM14(String strValue) {
        this.SetParamValue(TAG_PARAM14, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getDSTDATAENTITYTYPE() {
        return this.GetParamStringValue(TAG_DSTDATAENTITYTYPE, "");
    }

    public void setDSTDATAENTITYTYPE(String strValue) {
        this.SetParamValue(TAG_DSTDATAENTITYTYPE, strValue);
    }

    public String getSRCDATAENTITYTYPE() {
        return this.GetParamStringValue(TAG_SRCDATAENTITYTYPE, "");
    }

    public void setSRCDATAENTITYTYPE(String strValue) {
        this.SetParamValue(TAG_SRCDATAENTITYTYPE, strValue);
    }

    public Properties getParams() {
        return this.getParams(TAG_DEPARAM);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Properties getParams(String strParamId) {
        TreeMap<String, Properties> treeMap = this.paramsMap;
        synchronized (treeMap) {
            if (this.paramsMap.containsKey(strParamId)) {
                return this.paramsMap.get(strParamId);
            }
        }
        try {
            Properties properties = PropertiesHelper.Load((String)this.GetParamStringValue(strParamId, ""));
            TreeMap<String, Properties> treeMap2 = this.paramsMap;
            synchronized (treeMap2) {
                this.paramsMap.put(strParamId, properties);
            }
            return properties;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

