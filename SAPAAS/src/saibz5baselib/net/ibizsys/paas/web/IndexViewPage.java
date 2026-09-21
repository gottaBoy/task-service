/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.web;

import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.web.Page;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IndexViewPage
extends Page {
    private static final Log log = LogFactory.getLog(IndexViewPage.class);
    private JSONObject appDataJO = new JSONObject();
    private JSONObject appDataJO2 = new JSONObject();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    protected JSONObject getAppDataObject() {
        return this.appDataJO;
    }

    protected JSONObject getLocalAppDataObject() {
        return this.appDataJO2;
    }

    public String getAppDataString() {
        return Base64Helper.encodeBytes(this.appDataJO.toString().getBytes()).replace("\r", "").replace("\n", "");
    }

    public String getLocalAppDataString() {
        return this.appDataJO2.toString();
    }
}

