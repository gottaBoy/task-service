/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.sql.Date;

public class BaseDataEntityEx
extends BaseDataEntity {
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";

    public String getCreateMan() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCreateMan(String strCreatMan) {
        this.SetParamValue(TAG_CREATEMAN, strCreatMan);
    }

    public String getUpdateMan() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUpdateMan(String strCreatMan) {
        this.SetParamValue(TAG_UPDATEMAN, strCreatMan);
    }

    public Date getCreateDate() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public Date getUpdateDate() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public boolean getEnable() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setEnable(boolean bEnable) {
        this.SetParamValue(TAG_ENABLE, bEnable ? 1 : 0);
    }

    public void setReserver(String strReserver) {
        this.SetParamValue(TAG_RESERVER, strReserver);
    }

    public String getReserver() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public void setReserver2(String strReserver2) {
        this.SetParamValue(TAG_RESERVER2, strReserver2);
    }

    public String getReserver2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }
}

