/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DEWizardDetail
extends BaseDataEntity {
    public static final String STEPACTION_PREV = "PREV";
    public static final String STEPACTION_NEXT = "NEXT";
    public static final String STEPACTION_FINISH = "FINISH";
    public static final String STEPDATATYPE_NEWL1DATA = "NEWL1DATA";
    public static final String STEPDATATYPE_NEWL2DATA = "NEWL2DATA";
    public static final String STEPDATATYPE_NEWL3DATA = "NEWL3DATA";
    public static final String STEPDATATYPE_ACTIVEL1DATA = "ACTIVEL1DATA";
    public static final String STEPDATATYPE_ACTIVEL2DATA = "ACTIVEL2DATA";
    public static final String STEPDATATYPE_ACTIVEL3DATA = "ACTIVEL3DATA";
    public static final String TAG_DEWIZARDDETAILID = "DEWIZARDDETAILID";
    public static final String TAG_DEWIZARDDETAILNAME = "DEWIZARDDETAILNAME";
    public static final String REFSTEPDATATYPE_LASTDATA = "LASTDATA";
    public static final String REFSTEPDATATYPE_ACTIVEL1DATA = "ACTIVEL1DATA";
    public static final String REFSTEPDATATYPE_ACTIVEL2DATA = "ACTIVEL2DATA";
    public static final String REFSTEPDATATYPE_ACTIVEL3DATA = "ACTIVEL3DATA";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEWIZARDID = "DEWIZARDID";
    public static final String TAG_DEWIZARDNAME = "DEWIZARDNAME";
    public static final String TAG_FORMID = "FORMID";
    public static final String TAG_FORMNAME = "FORMNAME";
    public static final String TAG_WZPAGEID = "WZPAGEID";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_STEPACTION = "STEPACTION";
    public static final String TAG_STEPDATATYPE = "STEPDATATYPE";
    public static final String TAG_DEACTIONID = "DEACTIONID";
    public static final String TAG_DEACTIONNAME = "DEACTIONNAME";
    public static final String TAG_DEFAULTWZPAGEID = "DEFAULTWZPAGEID";
    public static final String TAG_SAVEDEACTIONID = "SAVEDEACTIONID";
    public static final String TAG_SAVEDEACTIONNAME = "SAVEDEACTIONNAME";
    public static final String TAG_FOREIGNKEY = "FOREIGNKEY";
    public static final String TAG_PDATAMAP = "PDATAMAP";
    public static final String TAG_REALDATAMODE = "REALDATAMODE";
    public static final String TAG_REALDATAKEY = "REALDATAKEY";
    public static final String TAG_REFSTEPDATATYPE = "REFSTEPDATATYPE";
    public static final String TAG_IGNORESTEPDATA = "IGNORESTEPDATA";
    public static final String TAG_REALSAVEDEACTIONID = "REALSAVEDEACTIONID";
    public static final String TAG_REALSAVEDEACTIONNAME = "REALSAVEDEACTIONNAME";

    public boolean isDEWIZARDDETAILIDNull() {
        return this.IsParamNull(TAG_DEWIZARDDETAILID);
    }

    public String getDEWIZARDDETAILID() {
        return this.GetParamStringValue(TAG_DEWIZARDDETAILID, "");
    }

    public void setDEWIZARDDETAILID(String strValue) {
        this.SetParamValue(TAG_DEWIZARDDETAILID, strValue);
    }

    public boolean isDEWIZARDDETAILNAMENull() {
        return this.IsParamNull(TAG_DEWIZARDDETAILNAME);
    }

    public String getDEWIZARDDETAILNAME() {
        return this.GetParamStringValue(TAG_DEWIZARDDETAILNAME, "");
    }

    public void setDEWIZARDDETAILNAME(String strValue) {
        this.SetParamValue(TAG_DEWIZARDDETAILNAME, strValue);
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

    public boolean isDEWIZARDIDNull() {
        return this.IsParamNull(TAG_DEWIZARDID);
    }

    public String getDEWIZARDID() {
        return this.GetParamStringValue(TAG_DEWIZARDID, "");
    }

    public void setDEWIZARDID(String strValue) {
        this.SetParamValue(TAG_DEWIZARDID, strValue);
    }

    public boolean isDEWIZARDNAMENull() {
        return this.IsParamNull(TAG_DEWIZARDNAME);
    }

    public String getDEWIZARDNAME() {
        return this.GetParamStringValue(TAG_DEWIZARDNAME, "");
    }

    public void setDEWIZARDNAME(String strValue) {
        this.SetParamValue(TAG_DEWIZARDNAME, strValue);
    }

    public boolean isFORMIDNull() {
        return this.IsParamNull(TAG_FORMID);
    }

    public String getFORMID() {
        return this.GetParamStringValue(TAG_FORMID, "");
    }

    public void setFORMID(String strValue) {
        this.SetParamValue(TAG_FORMID, strValue);
    }

    public boolean isFORMNAMENull() {
        return this.IsParamNull(TAG_FORMNAME);
    }

    public String getFORMNAME() {
        return this.GetParamStringValue(TAG_FORMNAME, "");
    }

    public void setFORMNAME(String strValue) {
        this.SetParamValue(TAG_FORMNAME, strValue);
    }

    public boolean isWZPAGEIDNull() {
        return this.IsParamNull(TAG_WZPAGEID);
    }

    public String getWZPAGEID() {
        return this.GetParamStringValue(TAG_WZPAGEID, "");
    }

    public void setWZPAGEID(String strValue) {
        this.SetParamValue(TAG_WZPAGEID, strValue);
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

    public boolean isSTEPACTIONNull() {
        return this.IsParamNull(TAG_STEPACTION);
    }

    public String getSTEPACTION() {
        return this.GetParamStringValue(TAG_STEPACTION, "");
    }

    public void setSTEPACTION(String strValue) {
        this.SetParamValue(TAG_STEPACTION, strValue);
    }

    public final boolean isSTEPDATATYPENull() {
        return this.IsParamNull(TAG_STEPDATATYPE);
    }

    public final String getSTEPDATATYPE() {
        return this.GetParamStringValue(TAG_STEPDATATYPE, "");
    }

    public final void setSTEPDATATYPE(String strValue) {
        this.SetParamValue(TAG_STEPDATATYPE, strValue);
    }

    public final boolean isDEACTIONIDNull() {
        return this.IsParamNull(TAG_DEACTIONID);
    }

    public final String getDEACTIONID() {
        return this.GetParamStringValue(TAG_DEACTIONID, "");
    }

    public final void setDEACTIONID(String strValue) {
        this.SetParamValue(TAG_DEACTIONID, strValue);
    }

    public final boolean isDEACTIONNAMENull() {
        return this.IsParamNull(TAG_DEACTIONNAME);
    }

    public final String getDEACTIONNAME() {
        return this.GetParamStringValue(TAG_DEACTIONNAME, "");
    }

    public final void setDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_DEACTIONNAME, strValue);
    }

    public final boolean isDEFAULTWZPAGEIDNull() {
        return this.IsParamNull(TAG_DEFAULTWZPAGEID);
    }

    public final String getDEFAULTWZPAGEID() {
        return this.GetParamStringValue(TAG_DEFAULTWZPAGEID, "");
    }

    public final void setDEFAULTWZPAGEID(String strValue) {
        this.SetParamValue(TAG_DEFAULTWZPAGEID, strValue);
    }

    public final boolean isSAVEDEACTIONIDNull() {
        return this.IsParamNull(TAG_SAVEDEACTIONID);
    }

    public final String getSAVEDEACTIONID() {
        return this.GetParamStringValue(TAG_SAVEDEACTIONID, "");
    }

    public final void setSAVEDEACTIONID(String strValue) {
        this.SetParamValue(TAG_SAVEDEACTIONID, strValue);
    }

    public final boolean isSAVEDEACTIONNAMENull() {
        return this.IsParamNull(TAG_SAVEDEACTIONNAME);
    }

    public final String getSAVEDEACTIONNAME() {
        return this.GetParamStringValue(TAG_SAVEDEACTIONNAME, "");
    }

    public final void setSAVEDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_SAVEDEACTIONNAME, strValue);
    }

    public final boolean isFOREIGNKEYNull() {
        return this.IsParamNull(TAG_FOREIGNKEY);
    }

    public final String getFOREIGNKEY() {
        return this.GetParamStringValue(TAG_FOREIGNKEY, "");
    }

    public final void setFOREIGNKEY(String strValue) {
        this.SetParamValue(TAG_FOREIGNKEY, strValue);
    }

    public final boolean isPDATAMAPNull() {
        return this.IsParamNull(TAG_PDATAMAP);
    }

    public final String getPDATAMAP() {
        return this.GetParamStringValue(TAG_PDATAMAP, "");
    }

    public final void setPDATAMAP(String strValue) {
        this.SetParamValue(TAG_PDATAMAP, strValue);
    }

    public final boolean isREALDATAMODENull() {
        return this.IsParamNull(TAG_REALDATAMODE);
    }

    public final boolean getREALDATAMODE() {
        return this.GetParamIntValue(TAG_REALDATAMODE, 0) == 1;
    }

    public final void setREALDATAMODE(boolean bValue) {
        this.SetParamValue(TAG_REALDATAMODE, bValue ? 1 : 0);
    }

    public final boolean isREALDATAKEYNull() {
        return this.IsParamNull(TAG_REALDATAKEY);
    }

    public final String getREALDATAKEY() {
        return this.GetParamStringValue(TAG_REALDATAKEY, "");
    }

    public final void setREALDATAKEY(String strValue) {
        this.SetParamValue(TAG_REALDATAKEY, strValue);
    }

    public final boolean isREFSTEPDATATYPENull() {
        return this.IsParamNull(TAG_REFSTEPDATATYPE);
    }

    public final String getREFSTEPDATATYPE() {
        return this.GetParamStringValue(TAG_REFSTEPDATATYPE, "");
    }

    public final void setREFSTEPDATATYPE(String strValue) {
        this.SetParamValue(TAG_REFSTEPDATATYPE, strValue);
    }

    public final boolean isIGNORESTEPDATANull() {
        return this.IsParamNull(TAG_IGNORESTEPDATA);
    }

    public final boolean getIGNORESTEPDATA() {
        return this.GetParamIntValue(TAG_IGNORESTEPDATA, 0) == 1;
    }

    public final void setIGNORESTEPDATA(boolean bValue) {
        this.SetParamValue(TAG_IGNORESTEPDATA, bValue ? 1 : 0);
    }

    public final boolean isREALSAVEDEACTIONIDNull() {
        return this.IsParamNull(TAG_REALSAVEDEACTIONID);
    }

    public final String getREALSAVEDEACTIONID() {
        return this.GetParamStringValue(TAG_REALSAVEDEACTIONID, "");
    }

    public final void setREALSAVEDEACTIONID(String strValue) {
        this.SetParamValue(TAG_REALSAVEDEACTIONID, strValue);
    }

    public final boolean isREALSAVEDEACTIONNAMENull() {
        return this.IsParamNull(TAG_REALSAVEDEACTIONNAME);
    }

    public final String getREALSAVEDEACTIONNAME() {
        return this.GetParamStringValue(TAG_REALSAVEDEACTIONNAME, "");
    }

    public final void setREALSAVEDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_REALSAVEDEACTIONNAME, strValue);
    }
}

