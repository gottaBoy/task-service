/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Web.Builder.UIBuilder;
import SA.SRFramework.Web.UI.SubViewConfig;

public class SubViewBuilder
extends UIBuilder {
    protected String strSubViewId = "subview_frame";
    protected SubViewConfig subViewConfig = null;
    protected int nWidth = 820;
    protected String strCustomPath = "";

    @Override
    public void setWidth(int value) {
        this.nWidth = value;
    }

    public String getSubViewId() {
        return this.strSubViewId;
    }

    public void setSubViewId(String value) {
        this.strSubViewId = value;
    }

    public void setSVConfig(SubViewConfig value) {
        this.subViewConfig = value;
    }

    public void setCustomPath(String value) {
        this.strCustomPath = value;
    }
}

