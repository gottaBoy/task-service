/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class AppUISetting
extends BaseDataEntity {
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_UPLOADPAGEPATH = "UPLOADPAGEPATH";
    public static final String TAG_DOWNLOADPAGEPATH = "DOWNLOADPAGEPATH";
    public static final String TAG_UPLOADPICPAGEPATH = "UPLOADPICPAGEPATH";
    public static final String TAG_DOWNLOADPICPAGEPATH = "DOWNLOADPICPAGEPATH";
    public static final String TAG_DEFEDITVIEW = "DEFEDITVIEW";
    public static final String TAG_DEFERRORVIEW = "DEFERRORVIEW";
    public static final String TAG_EDITVIEWENABLEREMOVE = "EDITVIEWENABLEREMOVE";
    public static final String TAG_APPLICATIONID = "APPLICATIONID";
    public static final String TAG_APPLICATIONNAME = "APPLICATIONNAME";
    public static final String TAG_DEFSEARCHFORM = "DEFSEARCHFORM";
    public static final String TAG_DGACTIONHELPER = "DGACTIONHELPER";
    public static final String TAG_DGEXACTIONHELPER = "DGEXACTIONHELPER";
    public static final String TAG_FORMACTIONHELPER = "FORMACTIONHELPER";
    public static final String TAG_GVEDITABLEDEFAULT = "GVEDITABLEDEFAULT";
    public static final String TAG_SPCUSTOMSEARCH = "SPCUSTOMSEARCH";
    public static final String TAG_SFDEFVALUEFROMURL = "SFDEFVALUEFROMURL";
    public static final String TAG_FORMDISABLESTATE = "FORMDISABLESTATE";
    public static final String TAG_TREEACTIONHELPER = "TREEACTIONHELPER";
    public static final String TAG_EDITVIEWENABLENEW = "EDITVIEWENABLENEW";
    public static final String TAG_GVEDITVIEWMODAL = "GVEDITVIEWMODAL";

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

    public boolean isUPLOADPAGEPATHNull() {
        return this.IsParamNull(TAG_UPLOADPAGEPATH);
    }

    public String getUPLOADPAGEPATH() {
        return this.GetParamStringValue(TAG_UPLOADPAGEPATH, "");
    }

    public void setUPLOADPAGEPATH(String strValue) {
        this.SetParamValue(TAG_UPLOADPAGEPATH, strValue);
    }

    public boolean isDOWNLOADPAGEPATHNull() {
        return this.IsParamNull(TAG_DOWNLOADPAGEPATH);
    }

    public String getDOWNLOADPAGEPATH() {
        return this.GetParamStringValue(TAG_DOWNLOADPAGEPATH, "");
    }

    public void setDOWNLOADPAGEPATH(String strValue) {
        this.SetParamValue(TAG_DOWNLOADPAGEPATH, strValue);
    }

    public boolean isUPLOADPICPAGEPATHNull() {
        return this.IsParamNull(TAG_UPLOADPICPAGEPATH);
    }

    public String getUPLOADPICPAGEPATH() {
        return this.GetParamStringValue(TAG_UPLOADPICPAGEPATH, "");
    }

    public void setUPLOADPICPAGEPATH(String strValue) {
        this.SetParamValue(TAG_UPLOADPICPAGEPATH, strValue);
    }

    public boolean isDOWNLOADPICPAGEPATHNull() {
        return this.IsParamNull(TAG_DOWNLOADPICPAGEPATH);
    }

    public String getDOWNLOADPICPAGEPATH() {
        return this.GetParamStringValue(TAG_DOWNLOADPICPAGEPATH, "");
    }

    public void setDOWNLOADPICPAGEPATH(String strValue) {
        this.SetParamValue(TAG_DOWNLOADPICPAGEPATH, strValue);
    }

    public boolean isDEFEDITVIEWNull() {
        return this.IsParamNull(TAG_DEFEDITVIEW);
    }

    public String getDEFEDITVIEW() {
        return this.GetParamStringValue(TAG_DEFEDITVIEW, "");
    }

    public void setDEFEDITVIEW(String strValue) {
        this.SetParamValue(TAG_DEFEDITVIEW, strValue);
    }

    public boolean isDEFERRORVIEWNull() {
        return this.IsParamNull(TAG_DEFERRORVIEW);
    }

    public String getDEFERRORVIEW() {
        return this.GetParamStringValue(TAG_DEFERRORVIEW, "");
    }

    public void setDEFERRORVIEW(String strValue) {
        this.SetParamValue(TAG_DEFERRORVIEW, strValue);
    }

    public boolean isEDITVIEWENABLEREMOVENull() {
        return this.IsParamNull(TAG_EDITVIEWENABLEREMOVE);
    }

    public boolean getEDITVIEWENABLEREMOVE() {
        return this.GetParamIntValue(TAG_EDITVIEWENABLEREMOVE, 0) == 1;
    }

    public void setEDITVIEWENABLEREMOVE(boolean bValue) {
        this.SetParamValue(TAG_EDITVIEWENABLEREMOVE, bValue ? 1 : 0);
    }

    public boolean isAPPLICATIONIDNull() {
        return this.IsParamNull(TAG_APPLICATIONID);
    }

    public String getAPPLICATIONID() {
        return this.GetParamStringValue(TAG_APPLICATIONID, "");
    }

    public void setAPPLICATIONID(String strValue) {
        this.SetParamValue(TAG_APPLICATIONID, strValue);
    }

    public boolean isAPPLICATIONNAMENull() {
        return this.IsParamNull(TAG_APPLICATIONNAME);
    }

    public String getAPPLICATIONNAME() {
        return this.GetParamStringValue(TAG_APPLICATIONNAME, "");
    }

    public void setAPPLICATIONNAME(String strValue) {
        this.SetParamValue(TAG_APPLICATIONNAME, strValue);
    }

    public boolean isDEFSEARCHFORMNull() {
        return this.IsParamNull(TAG_DEFSEARCHFORM);
    }

    public boolean getDEFSEARCHFORM() {
        return this.GetParamIntValue(TAG_DEFSEARCHFORM, 0) == 1;
    }

    public void setDEFSEARCHFORM(boolean bValue) {
        this.SetParamValue(TAG_DEFSEARCHFORM, bValue ? 1 : 0);
    }

    public boolean isDGACTIONHELPERNull() {
        return this.IsParamNull(TAG_DGACTIONHELPER);
    }

    public String getDGACTIONHELPER() {
        return this.GetParamStringValue(TAG_DGACTIONHELPER, "");
    }

    public void setDGACTIONHELPER(String strValue) {
        this.SetParamValue(TAG_DGACTIONHELPER, strValue);
    }

    public boolean isDGEXACTIONHELPERNull() {
        return this.IsParamNull(TAG_DGEXACTIONHELPER);
    }

    public String getDGEXACTIONHELPER() {
        return this.GetParamStringValue(TAG_DGEXACTIONHELPER, "");
    }

    public void setDGEXACTIONHELPER(String strValue) {
        this.SetParamValue(TAG_DGEXACTIONHELPER, strValue);
    }

    public boolean isFORMACTIONHELPERNull() {
        return this.IsParamNull(TAG_FORMACTIONHELPER);
    }

    public String getFORMACTIONHELPER() {
        return this.GetParamStringValue(TAG_FORMACTIONHELPER, "");
    }

    public void setFORMACTIONHELPER(String strValue) {
        this.SetParamValue(TAG_FORMACTIONHELPER, strValue);
    }

    public boolean isGVEDITABLEDEFAULTNull() {
        return this.IsParamNull(TAG_GVEDITABLEDEFAULT);
    }

    public boolean getGVEDITABLEDEFAULT() {
        return this.GetParamIntValue(TAG_GVEDITABLEDEFAULT, 0) == 1;
    }

    public void setGVEDITABLEDEFAULT(boolean bValue) {
        this.SetParamValue(TAG_GVEDITABLEDEFAULT, bValue ? 1 : 0);
    }

    public boolean isSPCUSTOMSEARCHNull() {
        return this.IsParamNull(TAG_SPCUSTOMSEARCH);
    }

    public boolean getSPCUSTOMSEARCH() {
        return this.GetParamIntValue(TAG_SPCUSTOMSEARCH, 0) == 1;
    }

    public void setSPCUSTOMSEARCH(boolean bValue) {
        this.SetParamValue(TAG_SPCUSTOMSEARCH, bValue ? 1 : 0);
    }

    public boolean isSFDEFVALUEFROMURLNull() {
        return this.IsParamNull(TAG_SFDEFVALUEFROMURL);
    }

    public boolean getSFDEFVALUEFROMURL() {
        return this.GetParamIntValue(TAG_SFDEFVALUEFROMURL, 0) == 1;
    }

    public void setSFDEFVALUEFROMURL(boolean bValue) {
        this.SetParamValue(TAG_SFDEFVALUEFROMURL, bValue ? 1 : 0);
    }

    public boolean isFORMDISABLESTATENull() {
        return this.IsParamNull(TAG_FORMDISABLESTATE);
    }

    public String getFORMDISABLESTATE() {
        return this.GetParamStringValue(TAG_FORMDISABLESTATE, "");
    }

    public void setFORMDISABLESTATE(String strValue) {
        this.SetParamValue(TAG_FORMDISABLESTATE, strValue);
    }

    public boolean isTREEACTIONHELPERNull() {
        return this.IsParamNull(TAG_TREEACTIONHELPER);
    }

    public String getTREEACTIONHELPER() {
        return this.GetParamStringValue(TAG_TREEACTIONHELPER, "");
    }

    public void setTREEACTIONHELPER(String strValue) {
        this.SetParamValue(TAG_TREEACTIONHELPER, strValue);
    }

    public boolean isEDITVIEWENABLENEWNull() {
        return this.IsParamNull(TAG_EDITVIEWENABLENEW);
    }

    public boolean getEDITVIEWENABLENEW() {
        return this.GetParamIntValue(TAG_EDITVIEWENABLENEW, 0) == 1;
    }

    public void setEDITVIEWENABLENEW(boolean bValue) {
        this.SetParamValue(TAG_EDITVIEWENABLENEW, bValue ? 1 : 0);
    }

    public boolean isGVEDITVIEWMODALNull() {
        return this.IsParamNull(TAG_GVEDITVIEWMODAL);
    }

    public boolean getGVEDITVIEWMODAL() {
        return this.GetParamIntValue(TAG_GVEDITVIEWMODAL, 0) == 1;
    }

    public void setGVEDITVIEWMODAL(boolean bValue) {
        this.SetParamValue(TAG_GVEDITVIEWMODAL, bValue ? 1 : 0);
    }
}

