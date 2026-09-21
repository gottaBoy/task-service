/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.ViewModel;

import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class LinkModel {
    protected String strUrl = "";
    protected int nWidth = 0;
    protected int nHeight = 0;
    protected boolean bShowModal = false;

    public String getUrl() {
        return this.strUrl;
    }

    public void setUrl(String strUrl) {
        this.strUrl = strUrl;
    }

    public int getWidth() {
        return this.nWidth;
    }

    public void setWidth(int nWidth) {
        this.nWidth = nWidth;
    }

    public int getHeight() {
        return this.nHeight;
    }

    public void setHeight(int nHeight) {
        this.nHeight = nHeight;
    }

    public boolean getShowModal() {
        return this.bShowModal;
    }

    public void setShowModal(boolean bShowModal) {
        this.bShowModal = bShowModal;
    }

    public void FillJSONObject(JSONObject jo) {
        this.OnFillJSONObject(jo);
    }

    protected void OnFillJSONObject(JSONObject jo) {
        if (!StringHelper.IsNullOrEmpty((String)this.getUrl())) {
            jo.put("url", (Object)this.getUrl());
        }
        if (this.getWidth() != 0) {
            jo.put("width", this.getWidth());
        }
        if (this.getHeight() != 0) {
            jo.put("height", this.getHeight());
        }
        if (this.getShowModal()) {
            jo.put("showmodal", this.getShowModal());
        }
    }

    public JSONObject GetJSONObject() {
        JSONObject jo = new JSONObject();
        this.FillJSONObject(jo);
        return jo;
    }
}

