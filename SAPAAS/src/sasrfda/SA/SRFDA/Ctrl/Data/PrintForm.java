/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Model.QueryGroupModelConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;

public class PrintForm
extends BaseDataEntity {
    public static final String TAG_PRINTFORMID = "PRINTFORMID";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_PRINTFORMNAME = "PRINTFORMNAME";
    public static final String TAG_OWNERID = "OWNERID";
    public static final String TAG_CONFIGID = "CONFIGID";
    public static final String TAG_ISMAJOR = "ISMAJOR";
    public static final String TAG_ISWFFORM = "ISWFFORM";
    public static final String TAG_WFSTATE = "WFSTATE";
    public static final String TAG_WFSTEP = "WFSTEP";
    public static final String TAG_ISPRINT = "ISPRINT";
    public static final String TAG_CONFIGPATH = "CONFIGPATH";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_BACKENDCTRL = "BACKENDCTRL";
    public static final String TAG_BACKENDCONFIG = "BACKENDCONFIG";
    public static final String TAG_CTRLOBJECT = "CTRLOBJECT";
    public static final String TAG_CTRLID = "CTRLID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DELOGICNAME = "DELOGICNAME";
    public static final String TAG_DETYPE = "DETYPE";
    public static final String TAG_TABLENAME = "TABLENAME";
    public static final String TAG_MINORFIELDNAME = "MINORFIELDNAME";
    public static final String TAG_MINORFIELDVALUE = "MINORFIELDVALUE";
    public static final String TAG_MINORTABLENAME = "MINORTABLENAME";
    public static final String TAG_EXTABLENAME = "EXTABLENAME";
    public static final String TAG_ISLOGICVALID = "ISLOGICVALID";
    public static final String TAG_DEVERSION = "DEVERSION";
    public static final String TAG_SMALLICON = "SMALLICON";
    public static final String TAG_BIGICON = "BIGICON";
    public static final String TAG_VIEWNAME = "VIEWNAME";
    public static final String TAG_FORMMODELPATH = "FORMMODELPATH";
    public static final String TAG_FORMMODEL = "FORMMODEL";
    public static final String TAG_FORMGEARS = "FORMGEARS";
    public static final String TAG_FORMTOOLBAR = "FORMTOOLBAR";
    public static final String TAG_FORMOBJECT = "FORMOBJECT";
    public static final String TAG_REPORTPATH = "REPORTPATH";
    public static final String TAG_ISENABLEGROUP = "ISENABLEGROUP";
    public static final String TAG_GROUPMODEL = "GROUPMODEL";
    public static final String TAG_QUERYMODELID = "QUERYMODELID";
    public static final String TAG_GETACTION = "GETACTION";
    public static final String TAG_WFFORMNAME = "WFFORMNAME";
    public static final String TAG_ENABLECOLPRIV = "ENABLECOLPRIV";
    public static final String TAG_ENABLEMP = "ENABLEMP";
    public static final String TAG_ENABLELOG = "ENABLELOG";
    protected QueryGroupModelConfig queryGroupModelConfig = null;

    public String getPRINTFORMID() {
        return this.GetParamStringValue(TAG_PRINTFORMID, "").trim();
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "").trim();
    }

    public String getPRINTFORMNAME() {
        return this.GetParamStringValue(TAG_PRINTFORMNAME, "");
    }

    public String getOWNERID() {
        return this.GetParamStringValue(TAG_OWNERID, "");
    }

    public String getCONFIGID() {
        return this.GetParamStringValue(TAG_CONFIGID, "");
    }

    public String getCONFIGPATH() {
        return this.GetParamStringValue(TAG_CONFIGPATH, "");
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getRESERVER() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }

    public String getBACKENDCTRL() {
        return this.GetParamStringValue(TAG_BACKENDCTRL, "");
    }

    public String getBACKENDCONFIG() {
        return this.GetParamStringValue(TAG_BACKENDCONFIG, "");
    }

    public String getCTRLOBJECT() {
        return this.GetParamStringValue(TAG_CTRLOBJECT, "");
    }

    public String getCTRLID() {
        return this.GetParamStringValue(TAG_CTRLID, "");
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public String getDELOGICNAME() {
        return this.GetParamStringValue(TAG_DELOGICNAME, "");
    }

    public String getTABLENAME() {
        return this.GetParamStringValue(TAG_TABLENAME, "");
    }

    public String getMINORFIELDNAME() {
        return this.GetParamStringValue(TAG_MINORFIELDNAME, "");
    }

    public String getMINORFIELDVALUE() {
        return this.GetParamStringValue(TAG_MINORFIELDVALUE, "");
    }

    public String getMINORTABLENAME() {
        return this.GetParamStringValue(TAG_MINORTABLENAME, "");
    }

    public String getEXTABLENAME() {
        return this.GetParamStringValue(TAG_EXTABLENAME, "");
    }

    public String getSMALLICON() {
        return this.GetParamStringValue(TAG_SMALLICON, "");
    }

    public String getBIGICON() {
        return this.GetParamStringValue(TAG_BIGICON, "");
    }

    public String getVIEWNAME() {
        return this.GetParamStringValue(TAG_VIEWNAME, "");
    }

    public String getFORMMODELPATH() {
        return this.GetParamStringValue(TAG_FORMMODELPATH, "");
    }

    public String getFORMMODEL() {
        return this.GetParamStringValue(TAG_FORMMODEL, "");
    }

    public String getFORMGEARS() {
        return this.GetParamStringValue(TAG_FORMGEARS, "");
    }

    public String getFORMTOOLBAR() {
        return this.GetParamStringValue(TAG_FORMTOOLBAR, "");
    }

    public String getWFSTATE() {
        return this.GetParamStringValue(TAG_WFSTATE, "");
    }

    public String getWFSTEP() {
        return this.GetParamStringValue(TAG_WFSTEP, "");
    }

    public String getFORMOBJECT() {
        return this.GetParamStringValue(TAG_FORMOBJECT, "");
    }

    public String getREPORTPATH() {
        return this.GetParamStringValue(TAG_REPORTPATH, "");
    }

    public String getGROUPMODEL() {
        return this.GetParamStringValue(TAG_GROUPMODEL, "");
    }

    public String getQUERYMODELID() {
        return this.GetParamStringValue(TAG_QUERYMODELID, "");
    }

    public String getGETACTION() {
        return this.GetParamStringValue(TAG_GETACTION, "");
    }

    public String getWFFORMNAME() {
        return this.GetParamStringValue(TAG_WFFORMNAME, "");
    }

    public void setPRINTFORMID(String strValue) {
        this.SetParamValue(TAG_PRINTFORMID, strValue);
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public void setPRINTFORMNAME(String strValue) {
        this.SetParamValue(TAG_PRINTFORMNAME, strValue);
    }

    public void setOWNERID(String strValue) {
        this.SetParamValue(TAG_OWNERID, strValue);
    }

    public void setCONFIGID(String strValue) {
        this.SetParamValue(TAG_CONFIGID, strValue);
    }

    public void setCONFIGPATH(String strValue) {
        this.SetParamValue(TAG_CONFIGPATH, strValue);
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setRESERVER(String strValue) {
        this.SetParamValue(TAG_RESERVER, strValue);
    }

    public void setRESERVER2(String strValue) {
        this.SetParamValue(TAG_RESERVER2, strValue);
    }

    public void setBACKENDCTRL(String strValue) {
        this.SetParamValue(TAG_BACKENDCTRL, strValue);
    }

    public void setBACKENDCONFIG(String strValue) {
        this.SetParamValue(TAG_BACKENDCONFIG, strValue);
    }

    public void setCTRLOBJECT(String strValue) {
        this.SetParamValue(TAG_CTRLOBJECT, strValue);
    }

    public void setCTRLID(String strValue) {
        this.SetParamValue(TAG_CTRLID, strValue);
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public void setDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_DELOGICNAME, strValue);
    }

    public void setTABLENAME(String strValue) {
        this.SetParamValue(TAG_TABLENAME, strValue);
    }

    public void setMINORFIELDNAME(String strValue) {
        this.SetParamValue(TAG_MINORFIELDNAME, strValue);
    }

    public void setMINORFIELDVALUE(String strValue) {
        this.SetParamValue(TAG_MINORFIELDVALUE, strValue);
    }

    public void setMINORTABLENAME(String strValue) {
        this.SetParamValue(TAG_MINORTABLENAME, strValue);
    }

    public void setEXTABLENAME(String strValue) {
        this.SetParamValue(TAG_EXTABLENAME, strValue);
    }

    public void setSMALLICON(String strValue) {
        this.SetParamValue(TAG_SMALLICON, strValue);
    }

    public void setBIGICON(String strValue) {
        this.SetParamValue(TAG_BIGICON, strValue);
    }

    public void setVIEWNAME(String strValue) {
        this.SetParamValue(TAG_VIEWNAME, strValue);
    }

    public void setFORMMODELPATH(String strValue) {
        this.SetParamValue(TAG_FORMMODELPATH, strValue);
    }

    public void setFORMMODEL(String strValue) {
        this.SetParamValue(TAG_FORMMODEL, strValue);
    }

    public void setFORMGEARS(String strValue) {
        this.SetParamValue(TAG_FORMGEARS, strValue);
    }

    public void setFORMTOOLBAR(String strValue) {
        this.SetParamValue(TAG_FORMTOOLBAR, strValue);
    }

    public void setGETACTION(String strValue) {
        this.SetParamValue(TAG_GETACTION, strValue);
    }

    public boolean isISMAJOR() {
        return this.GetParamIntValue(TAG_ISMAJOR, 0) == 1;
    }

    public boolean isISPRINT() {
        return this.GetParamIntValue(TAG_ISPRINT, 0) == 1;
    }

    public boolean isISLOGICVALID() {
        return this.GetParamIntValue(TAG_ISLOGICVALID, 0) == 1;
    }

    public boolean isWFFORM() {
        return this.GetParamIntValue(TAG_ISWFFORM, 0) == 1;
    }

    public boolean isENABLEGROUP() {
        return this.GetParamIntValue(TAG_ISENABLEGROUP, 0) == 1;
    }

    public void setISMAJOR(boolean bValue) {
        this.SetParamValue(TAG_ISMAJOR, bValue ? 1 : 0);
    }

    public void setISPRINT(boolean bValue) {
        this.SetParamValue(TAG_ISPRINT, bValue ? 1 : 0);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public int getDETYPE() {
        return this.GetParamIntValue(TAG_DETYPE, 0);
    }

    public int getDEVERSION() {
        return this.GetParamIntValue(TAG_DEVERSION, 0);
    }

    public boolean getENABLECOLPRIV() {
        return this.GetParamIntValue(TAG_ENABLECOLPRIV, 0) == 1;
    }

    public void setENABLECOLPRIV(boolean bValue) {
        this.SetParamValue(TAG_ENABLECOLPRIV, bValue ? 1 : 0);
    }

    public boolean isENABLEMPNull() {
        return this.IsParamNull(TAG_ENABLEMP);
    }

    public boolean getENABLEMP() {
        return this.GetParamIntValue(TAG_ENABLEMP, 0) == 1;
    }

    public void setENABLEMP(boolean bValue) {
        this.SetParamValue(TAG_ENABLEMP, bValue ? 1 : 0);
    }

    public boolean isENABLELOGNull() {
        return this.IsParamNull(TAG_ENABLELOG);
    }

    public boolean getENABLELOG() {
        return this.GetParamIntValue(TAG_ENABLELOG, 0) == 1;
    }

    public void setENABLELOG(boolean bValue) {
        this.SetParamValue(TAG_ENABLELOG, bValue ? 1 : 0);
    }

    public QueryGroupModelConfig getQueryGroupModelConfig() {
        if (this.queryGroupModelConfig != null) {
            return this.queryGroupModelConfig;
        }
        String strGroupModelXML = this.getGROUPMODEL();
        if (StringHelper.Length((String)strGroupModelXML) > 0) {
            this.queryGroupModelConfig = new QueryGroupModelConfig();
            if (!XMLConfig.LoadFromXML((String)strGroupModelXML, (XMLConfig)this.queryGroupModelConfig)) {
                return null;
            }
        }
        return this.queryGroupModelConfig;
    }
}

