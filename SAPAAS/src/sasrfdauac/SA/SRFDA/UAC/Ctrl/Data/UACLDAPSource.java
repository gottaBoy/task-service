/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.UAC.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class UACLDAPSource
extends BaseDataEntity {
    public static final String TAG_UACLDAPSOURCEID = "UACLDAPSOURCEID";
    public static final String TAG_UACLDAPSOURCENAME = "UACLDAPSOURCENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_LDAPSERVER = "LDAPSERVER";
    public static final String TAG_LDAPSERVER2 = "LDAPSERVER2";
    public static final String TAG_ISAD = "ISAD";
    public static final String TAG_BINDUSER = "BINDUSER";
    public static final String TAG_BINDPWD = "BINDPWD";

    public String getUACLDAPSOURCEID() {
        return this.GetParamStringValue(TAG_UACLDAPSOURCEID, "");
    }

    public void setUACLDAPSOURCEID(String strValue) {
        this.SetParamValue(TAG_UACLDAPSOURCEID, strValue);
    }

    public String getUACLDAPSOURCENAME() {
        return this.GetParamStringValue(TAG_UACLDAPSOURCENAME, "");
    }

    public void setUACLDAPSOURCENAME(String strValue) {
        this.SetParamValue(TAG_UACLDAPSOURCENAME, strValue);
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

    public String getLDAPSERVER() {
        return this.GetParamStringValue(TAG_LDAPSERVER, "");
    }

    public void setLDAPSERVER(String strValue) {
        this.SetParamValue(TAG_LDAPSERVER, strValue);
    }

    public String getLDAPSERVER2() {
        return this.GetParamStringValue(TAG_LDAPSERVER2, "");
    }

    public void setLDAPSERVER2(String strValue) {
        this.SetParamValue(TAG_LDAPSERVER2, strValue);
    }

    public boolean getISAD() {
        return this.GetParamIntValue(TAG_ISAD, 0) == 1;
    }

    public void setISAD(boolean bValue) {
        this.SetParamValue(TAG_ISAD, bValue ? 1 : 0);
    }

    public String getBINDUSER() {
        return this.GetParamStringValue(TAG_BINDUSER, "");
    }

    public void setBINDUSER(String strValue) {
        this.SetParamValue(TAG_BINDUSER, strValue);
    }

    public String getBINDPWD() {
        return this.GetParamStringValue(TAG_BINDPWD, "");
    }

    public void setBINDPWD(String strValue) {
        this.SetParamValue(TAG_BINDPWD, strValue);
    }
}

