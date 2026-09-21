/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Web.Builder.UIBuilder;
import SA.SRFramework.Web.UI.MainViewConfig;

public class MainViewBuilder
extends UIBuilder {
    protected String strMainViewId = "mainview_frame";
    protected MainViewConfig mainViewConfig = null;
    protected int nWidth = 820;
    protected int nHeight = 350;
    protected String strCustomPath = "";

    @Override
    public void setWidth(int value) {
        this.nWidth = value;
    }

    @Override
    public void setHeight(int value) {
        this.nHeight = value;
    }

    public String getMainViewId() {
        return this.strMainViewId;
    }

    public void setMainViewId(String value) {
        this.strMainViewId = value;
    }

    public void setMVConfig(MainViewConfig value) {
        this.mainViewConfig = value;
    }

    public void setCustomPath(String value) {
        this.strCustomPath = value;
    }
}

