/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.MainViewModel;
import net.sf.json.JSONObject;

public class BaseEditViewModel
extends MainViewModel {
    protected boolean bCopyMode = false;
    protected boolean bContainKey = false;
    protected JSONObject keyData = null;
    protected Boolean bPreviewFormDirty = null;
    protected Boolean bShowDataInfoBar = null;

    @Override
    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (this.getContainKey()) {
            jo.put("containkey", this.getContainKey());
            jo.put("keydata", (Object)this.getKeyData());
            jo.put("copymode", this.getCopyMode());
        }
        if (this.getPreviewFormDirty() != null) {
            jo.put("previewformdirty", (Object)this.getPreviewFormDirty());
        }
        if (this.getShowDataInfoBar() != null) {
            jo.put("showdatainfobar", (Object)this.getShowDataInfoBar());
        }
    }

    public boolean getContainKey() {
        return this.bContainKey;
    }

    public void setContainKey(boolean bContainKey) {
        this.bContainKey = bContainKey;
    }

    public boolean getCopyMode() {
        return this.bCopyMode;
    }

    public void setCopyMode(boolean bCopyMode) {
        this.bCopyMode = bCopyMode;
    }

    public JSONObject getKeyData() {
        return this.keyData;
    }

    public void setKeyData(JSONObject keyData) {
        this.keyData = keyData;
    }

    public Boolean getPreviewFormDirty() {
        return this.bPreviewFormDirty;
    }

    public void setPreviewFormDirty(Boolean bPreviewFormDirty) {
        this.bPreviewFormDirty = bPreviewFormDirty;
    }

    public Boolean getShowDataInfoBar() {
        return this.bShowDataInfoBar;
    }

    public void setShowDataInfoBar(Boolean bShowDataInfoBar) {
        this.bShowDataInfoBar = bShowDataInfoBar;
    }
}

