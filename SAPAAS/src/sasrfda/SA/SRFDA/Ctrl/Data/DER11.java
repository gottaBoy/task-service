/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Ctrl.Data.BaseDER;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;

public class DER11
extends BaseDER {
    public static final String TAG_DER11_ID = "DER11_ID";
    public static final String TAG_DER11_NAME = "DER11_NAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_REMOVEACTIONTYPE = "REMOVEACTIONTYPE";
    public static final String TAG_MAJORDENAME = "MAJORDENAME";
    public static final String TAG_MAJORDEID = "MAJORDEID";
    public static final String TAG_MINORDEID = "MINORDEID";
    public static final String TAG_MINORDENAME = "MINORDENAME";
    public static final String TAG_MAJORDELOGICNAME = "MAJORDELOGICNAME";
    public static final String TAG_MINORDELOGICNAME = "MINORDELOGICNAME";
    public static final String TAG_DERLOGICNAME = "DERLOGICNAME";
    public static final String TAG_SHOWORDER = "SHOWORDER";
    public static final String TAG_EDITPAGEID = "EDITPAGEID";
    public static final String TAG_EDITPAGNAME = "EDITPAGNAME";
    public static final String TAG_DERTYPEID = "DERTYPEID";
    public static final String TAG_DERTYPENAME = "DERTYPENAME";
    public static final String TAG_SMALLICON = "SMALLICON";
    public static final String TAG_SHOWNAME = "SHOWNAME";

    public String getDERShowName() {
        if (!StringHelper.IsNullOrEmpty((String)this.getSHOWNAME())) {
            return this.getSHOWNAME();
        }
        return this.getMINORDELOGICNAME();
    }

    @Override
    public String getDERID() {
        return this.GetParamStringValue(TAG_DER11_ID, "").trim();
    }

    @Override
    public String getDERNAME() {
        return this.GetParamStringValue(TAG_DER11_NAME, "");
    }

    @Override
    public void setDERID(String strDER11ID) {
        this.SetParamValue(TAG_DER11_ID, strDER11ID);
    }

    @Override
    public void setDERNAME(String strDER11NAME) {
        this.SetParamValue(TAG_DER11_NAME, strDER11NAME);
    }

    public String getEDITPAGEID() {
        return this.GetParamStringValue(TAG_EDITPAGEID, "");
    }

    @Override
    public String getDERTYPEID() {
        return this.GetParamStringValue(TAG_DERTYPEID, "");
    }

    @Override
    public void setDERTYPEID(String strValue) {
        this.SetParamValue(TAG_DERTYPEID, strValue);
    }

    @Override
    public String getDERTYPENAME() {
        return this.GetParamStringValue(TAG_DERTYPENAME, "");
    }

    @Override
    public void setDERTYPENAME(String strValue) {
        this.SetParamValue(TAG_DERTYPENAME, strValue);
    }

    public boolean isSHOWNAMENull() {
        return this.IsParamNull(TAG_SHOWNAME);
    }

    public String getSHOWNAME() {
        return this.GetParamStringValue(TAG_SHOWNAME, "");
    }

    public void setSHOWNAME(String strValue) {
        this.SetParamValue(TAG_SHOWNAME, strValue);
    }

    public boolean isDER11_IDNull() {
        return this.IsParamNull(TAG_DER11_ID);
    }

    public String getDER11_ID() {
        return this.GetParamStringValue(TAG_DER11_ID, "");
    }

    public void setDER11_ID(String strValue) {
        this.SetParamValue(TAG_DER11_ID, strValue);
    }

    public boolean isDER11_NAMENull() {
        return this.IsParamNull(TAG_DER11_NAME);
    }

    public String getDER11_NAME() {
        return this.GetParamStringValue(TAG_DER11_NAME, "");
    }

    public void setDER11_NAME(String strValue) {
        this.SetParamValue(TAG_DER11_NAME, strValue);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    @Override
    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    @Override
    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    @Override
    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    @Override
    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public boolean isISSYSTEMNull() {
        return this.IsParamNull(TAG_ISSYSTEM);
    }

    public boolean getISSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }

    public void setISSYSTEM(boolean bValue) {
        this.SetParamValue(TAG_ISSYSTEM, bValue ? 1 : 0);
    }

    public boolean isMAJORDENAMENull() {
        return this.IsParamNull(TAG_MAJORDENAME);
    }

    @Override
    public String getMAJORDENAME() {
        return this.GetParamStringValue(TAG_MAJORDENAME, "");
    }

    @Override
    public void setMAJORDENAME(String strValue) {
        this.SetParamValue(TAG_MAJORDENAME, strValue);
    }

    public boolean isMAJORDEIDNull() {
        return this.IsParamNull(TAG_MAJORDEID);
    }

    @Override
    public String getMAJORDEID() {
        return this.GetParamStringValue(TAG_MAJORDEID, "");
    }

    @Override
    public void setMAJORDEID(String strValue) {
        this.SetParamValue(TAG_MAJORDEID, strValue);
    }

    public boolean isMINORDEIDNull() {
        return this.IsParamNull(TAG_MINORDEID);
    }

    @Override
    public String getMINORDEID() {
        return this.GetParamStringValue(TAG_MINORDEID, "");
    }

    @Override
    public void setMINORDEID(String strValue) {
        this.SetParamValue(TAG_MINORDEID, strValue);
    }

    public boolean isMINORDENAMENull() {
        return this.IsParamNull(TAG_MINORDENAME);
    }

    @Override
    public String getMINORDENAME() {
        return this.GetParamStringValue(TAG_MINORDENAME, "");
    }

    @Override
    public void setMINORDENAME(String strValue) {
        this.SetParamValue(TAG_MINORDENAME, strValue);
    }

    public boolean isMAJORDELOGICNAMENull() {
        return this.IsParamNull(TAG_MAJORDELOGICNAME);
    }

    @Override
    public String getMAJORDELOGICNAME() {
        return this.GetParamStringValue(TAG_MAJORDELOGICNAME, "");
    }

    @Override
    public void setMAJORDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_MAJORDELOGICNAME, strValue);
    }

    public boolean isMINORDELOGICNAMENull() {
        return this.IsParamNull(TAG_MINORDELOGICNAME);
    }

    @Override
    public String getMINORDELOGICNAME() {
        return this.GetParamStringValue(TAG_MINORDELOGICNAME, "");
    }

    @Override
    public void setMINORDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_MINORDELOGICNAME, strValue);
    }

    public boolean isDERLOGICNAMENull() {
        return this.IsParamNull(TAG_DERLOGICNAME);
    }

    @Override
    public String getDERLOGICNAME() {
        return this.GetParamStringValue(TAG_DERLOGICNAME, "");
    }

    @Override
    public void setDERLOGICNAME(String strValue) {
        this.SetParamValue(TAG_DERLOGICNAME, strValue);
    }

    public boolean isSHOWORDERNull() {
        return this.IsParamNull(TAG_SHOWORDER);
    }

    @Override
    public int getSHOWORDER() {
        return this.GetParamIntValue(TAG_SHOWORDER, 0);
    }

    public void setSHOWORDER(int nValue) {
        this.SetParamValue(TAG_SHOWORDER, nValue);
    }

    public boolean isEDITPAGEIDNull() {
        return this.IsParamNull(TAG_EDITPAGEID);
    }

    public void setEDITPAGEID(String strValue) {
        this.SetParamValue(TAG_EDITPAGEID, strValue);
    }

    public boolean isEDITPAGNAMENull() {
        return this.IsParamNull(TAG_EDITPAGNAME);
    }

    public String getEDITPAGNAME() {
        return this.GetParamStringValue(TAG_EDITPAGNAME, "");
    }

    public void setEDITPAGNAME(String strValue) {
        this.SetParamValue(TAG_EDITPAGNAME, strValue);
    }

    public boolean isDERTYPEIDNull() {
        return this.IsParamNull(TAG_DERTYPEID);
    }

    public boolean isDERTYPENAMENull() {
        return this.IsParamNull(TAG_DERTYPENAME);
    }

    public boolean isSMALLICONNull() {
        return this.IsParamNull(TAG_SMALLICON);
    }

    @Override
    public String getSMALLICON() {
        return this.GetParamStringValue(TAG_SMALLICON, "");
    }

    @Override
    public void setSMALLICON(String strValue) {
        this.SetParamValue(TAG_SMALLICON, strValue);
    }
}

