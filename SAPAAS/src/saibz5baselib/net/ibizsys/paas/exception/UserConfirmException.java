/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.exception;

import java.util.ArrayList;
import net.sf.json.JSONObject;

public class UserConfirmException
extends Exception {
    private String strConfirmKey = null;
    private String strConfirmTitle = null;
    private ArrayList confirmOptions = null;
    private JSONObject confirmActionParam = null;

    public UserConfirmException(String strConfirmMsg, String strConfirmKey, String strConfirmTitle, ArrayList confirmOptions, JSONObject confirmActionParam) {
        super(strConfirmMsg);
        this.strConfirmKey = strConfirmKey;
        this.strConfirmTitle = strConfirmTitle;
        this.confirmOptions = confirmOptions;
        this.confirmActionParam = confirmActionParam;
    }

    public String getConfirmKey() {
        return this.strConfirmKey;
    }

    public ArrayList getConfirmOptions() {
        return this.confirmOptions;
    }

    public JSONObject getConfirmActionParam() {
        return this.confirmActionParam;
    }

    public String getConfirmTitle() {
        return this.strConfirmTitle;
    }
}

