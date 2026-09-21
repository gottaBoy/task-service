/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public class DBCallerAction
extends XMLConfig {
    public static final String TAG_ACTIONTYPE = "ACTIONTYPE";
    public static final String TAG_ACTION = "ACTION";
    public static final String TAG_DATABASE = "DATABASE";
    public static final String ACTIONTYPE_GROUPBY = "GROUPBY";
    public static final String ACTIONTYPE_CONDITION = "CONDITION";
    public static final String ACTIONTYPE_DEFAULTORDER = "DEFAULTORDER";
    public static final String ACTIONTYPE_FAILED = "FAILED";
    public static final String ACTIONTYPE_PREPARE = "PREPARE";
    public static final String ACTIONTYPE_BEFORE = "BEFORE";
    public static final String ACTIONTYPE_AFTER = "AFTER";
    public static final String ACTIONTYPE_END = "END";
    public static final String ACTIONTYPE_DECLAREPARAM = "DECLAREPARAM";
    protected String strActionType = "";
    protected String strAction = "";
    protected String strDatabase = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare(strName, TAG_ACTIONTYPE, true) == 0) {
            this.strActionType = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(TAG_ACTION) == 0) {
            this.strAction = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(TAG_DATABASE) == 0) {
            this.strDatabase = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getActionType() {
        return this.strActionType;
    }

    public void setActionType(String strActionType) {
        this.strActionType = strActionType;
    }

    public String getAction() {
        return this.strAction;
    }

    public void setAction(String strAction) {
        this.strAction = strAction;
    }

    public String getDatabase() {
        return this.strDatabase;
    }

    public void setDatabase(String strDatabase) {
        this.strDatabase = strDatabase;
    }
}

