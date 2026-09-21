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

public class Form
extends BaseDataEntity {
    public static final String FORMPARAM_DISABLEITEMS = "DISABLEITEMS";
    public static final String FORMPARAM_MODIFYPDATA = "MODIFYPDATA";
    public static final String TAG_FORMID = "FORMID";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_FORMNAME = "FORMNAME";
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
    public static final String TAG_FMVERSION = "FMVERSION";
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
    public static final String TAG_FORMPLUGIN = "FORMPLUGIN";
    public static final String TAG_FORMSCRIPT = "FORMSCRIPT";
    public static final String TAG_FIVCSCRIPT = "FIVCSCRIPT";
    public static final String TAG_FORMSCRIPTEX = "FORMSCRIPTEX";
    public static final String TAG_FORMSCRIPTEX2 = "FORMSCRIPTEX2";
    public static final String TAG_FORMBSSCRIPT = "FORMBSSCRIPT";
    public static final String TAG_ENABLENEW = "ENABLENEW";
    public static final String TAG_SENSITIVEMODE = "SENSITIVEMODE";
    public static final String TAG_SENSITIVEFIELDS = "SENSITIVEFIELDS";
    public static final String TAG_SAVECHECK = "SAVECHECK";
    public static final String TAG_WFBACKENDCTRL = "WFBACKENDCTRL";
    public static final String TAG_PAGECAPTION = "PAGECAPTION";
    public static final String TAG_CHILDDATATAG = "CHILDDATATAG";
    public static final String TAG_SRFSYSPUB = "SRFSYSPUB";
    public static final String TAG_SRFUSERPUB = "SRFUSERPUB";
    public static final String TAG_GETMODE = "GETMODE";
    private Properties formProperties = null;

    public String getFORMID() {
        return this.GetParamStringValue(TAG_FORMID, "").trim();
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "").trim();
    }

    public String getFORMNAME() {
        return this.GetParamStringValue(TAG_FORMNAME, "");
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
        return this.GetParamStringValue(TAG_RESERVER, "DEFAULT");
    }

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "DEFAULT");
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

    public String getFORMPLUGIN() {
        return this.GetParamStringValue(TAG_FORMPLUGIN, "");
    }

    public void setFORMID(String strValue) {
        this.SetParamValue(TAG_FORMID, strValue);
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public void setFORMNAME(String strValue) {
        this.SetParamValue(TAG_FORMNAME, strValue);
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

    public void setFORMPLUGIN(String strValue) {
        this.SetParamValue(TAG_FORMPLUGIN, strValue);
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

    public void setISMAJOR(boolean bValue) {
        this.SetParamValue(TAG_ISMAJOR, bValue ? 1 : 0);
    }

    public void setISPRINT(boolean bValue) {
        this.SetParamValue(TAG_ISPRINT, bValue ? 1 : 0);
    }

    public int getFMVERSION() {
        return this.GetParamIntValue(TAG_FMVERSION, 0);
    }

    public int getDETYPE() {
        return this.GetParamIntValue(TAG_DETYPE, 0);
    }

    public int getDEVERSION() {
        return this.GetParamIntValue(TAG_DEVERSION, 0);
    }

    public String getINSERTMODE() {
        return this.getRESERVER();
    }

    public boolean isINSERTMODENull() {
        return this.IsParamNull(TAG_RESERVER);
    }

    public String getUPDATEMODE() {
        return this.getRESERVER2();
    }

    public boolean isUPDATEMODENull() {
        return this.IsParamNull(TAG_RESERVER2);
    }

    public String getFORMBSSCRIPT() {
        return this.GetParamStringValue(TAG_FORMBSSCRIPT, "");
    }

    public void setFORMBSSCRIPT(String strValue) {
        this.SetParamValue(TAG_FORMBSSCRIPT, strValue);
    }

    public String getFORMSCRIPT() {
        return this.GetParamStringValue(TAG_FORMSCRIPT, "");
    }

    public void setFORMSCRIPT(String strValue) {
        this.SetParamValue(TAG_FORMSCRIPT, strValue);
    }

    private void BuildFormProperties() {
        try {
            if (this.formProperties != null) {
                return;
            }
            String strFormParam = this.getFORMGEARS();
            if (!StringHelper.IsNullOrEmpty((String)strFormParam)) {
                this.formProperties = PropertiesHelper.Load((Properties)this.formProperties, (String)strFormParam);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public Properties getFormProperties() {
        this.BuildFormProperties();
        return this.formProperties;
    }

    public String GetFormProperty(String strName, String strDefault) {
        this.BuildFormProperties();
        return PropertiesHelper.GetProperty((Properties)this.formProperties, (String)strName, (String)strDefault);
    }

    public boolean GetFormProperty(String strName, boolean bDefault) {
        String strValue = this.GetFormProperty(strName, "");
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            return bDefault;
        }
        return StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0;
    }

    public int GetFormProperty(String strName, int nDefault) {
        String strValue = this.GetFormProperty(strName, "");
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            return nDefault;
        }
        return Integer.parseInt(strValue);
    }

    public String getFIVCSCRIPT() {
        return this.GetParamStringValue(TAG_FIVCSCRIPT, "");
    }

    public void setFIVCSCRIPT(String strValue) {
        this.SetParamValue(TAG_FIVCSCRIPT, strValue);
    }

    public String getFORMSCRIPTEX() {
        return this.GetParamStringValue(TAG_FORMSCRIPTEX, "");
    }

    public void setFORMSCRIPTEX(String strValue) {
        this.SetParamValue(TAG_FORMSCRIPTEX, strValue);
    }

    public String getFORMSCRIPTEX2() {
        return this.GetParamStringValue(TAG_FORMSCRIPTEX2, "");
    }

    public void setFORMSCRIPTEX2(String strValue) {
        this.SetParamValue(TAG_FORMSCRIPTEX2, strValue);
    }

    public boolean isENABLENEWNull() {
        return this.IsParamNull(TAG_ENABLENEW);
    }

    public boolean getENABLENEW() {
        return this.GetParamIntValue(TAG_ENABLENEW, 0) == 1;
    }

    public void setENABLENEW(boolean bValue) {
        this.SetParamValue(TAG_ENABLENEW, bValue ? 1 : 0);
    }

    public boolean isSENSITIVEMODENull() {
        return this.IsParamNull(TAG_SENSITIVEMODE);
    }

    public boolean getSENSITIVEMODE() {
        return this.GetParamIntValue(TAG_SENSITIVEMODE, 0) == 1;
    }

    public void setSENSITIVEMODE(boolean bValue) {
        this.SetParamValue(TAG_SENSITIVEMODE, bValue ? 1 : 0);
    }

    public boolean isSENSITIVEFIELDSNull() {
        return this.IsParamNull(TAG_SENSITIVEFIELDS);
    }

    public String getSENSITIVEFIELDS() {
        return this.GetParamStringValue(TAG_SENSITIVEFIELDS, "");
    }

    public void setSENSITIVEFIELDS(String strValue) {
        this.SetParamValue(TAG_SENSITIVEFIELDS, strValue);
    }

    public final boolean isWFBACKENDCTRLNull() {
        return this.IsParamNull(TAG_WFBACKENDCTRL);
    }

    public final String getWFBACKENDCTRL() {
        return this.GetParamStringValue(TAG_WFBACKENDCTRL, "");
    }

    public final void setWFBACKENDCTRL(String strValue) {
        this.SetParamValue(TAG_WFBACKENDCTRL, strValue);
    }

    public final boolean isSAVECHECKNull() {
        return this.IsParamNull(TAG_SAVECHECK);
    }

    public final boolean getSAVECHECK() {
        return this.GetParamIntValue(TAG_SAVECHECK, 0) == 1;
    }

    public final void setSAVECHECK(boolean bValue) {
        this.SetParamValue(TAG_SAVECHECK, bValue ? 1 : 0);
    }

    public final boolean isPAGECAPTIONNull() {
        return this.IsParamNull(TAG_PAGECAPTION);
    }

    public final String getPAGECAPTION() {
        return this.GetParamStringValue(TAG_PAGECAPTION, "");
    }

    public final void setPAGECAPTION(String strValue) {
        this.SetParamValue(TAG_PAGECAPTION, strValue);
    }

    public final boolean isCHILDDATATAGNull() {
        return this.IsParamNull(TAG_CHILDDATATAG);
    }

    public final String getCHILDDATATAG() {
        return this.GetParamStringValue(TAG_CHILDDATATAG, "");
    }

    public final void setCHILDDATATAG(String strValue) {
        this.SetParamValue(TAG_CHILDDATATAG, strValue);
    }

    public final boolean isSRFSYSPUBNull() {
        return this.IsParamNull(TAG_SRFSYSPUB);
    }

    public final boolean getSRFSYSPUB() {
        return this.GetParamIntValue(TAG_SRFSYSPUB, 0) == 1;
    }

    public final void setSRFSYSPUB(boolean bValue) {
        this.SetParamValue(TAG_SRFSYSPUB, bValue ? 1 : 0);
    }

    public final boolean isSRFUSERPUBNull() {
        return this.IsParamNull(TAG_SRFUSERPUB);
    }

    public final boolean getSRFUSERPUB() {
        return this.GetParamIntValue(TAG_SRFUSERPUB, 0) == 1;
    }

    public final void setSRFUSERPUB(boolean bValue) {
        this.SetParamValue(TAG_SRFUSERPUB, bValue ? 1 : 0);
    }

    public final boolean isGETMODENull() {
        return this.IsParamNull(TAG_GETMODE);
    }

    public final String getGETMODE() {
        return this.GetParamStringValue(TAG_GETMODE, "");
    }

    public final void setGETMODE(String strValue) {
        this.SetParamValue(TAG_GETMODE, strValue);
    }
}

