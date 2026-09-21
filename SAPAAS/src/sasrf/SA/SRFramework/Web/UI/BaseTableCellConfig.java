/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;

public abstract class BaseTableCellConfig
extends XMLConfig {
    private int nHeight = 25;
    private int nWidth = 100;
    private String strCSS = "";
    private String strValue = "";
    private String strAlign = "";

    public void setHeight(int value) {
        this.nHeight = value;
    }

    public int getHeight() {
        return this.nHeight;
    }

    public void setWidth(int value) {
        this.nWidth = value;
    }

    public int getWidth() {
        return this.nWidth;
    }

    public String getCSS() {
        return this.strCSS;
    }

    public void setCSS(String value) {
        this.strCSS = value;
    }

    public void setValue(String value) {
        this.strValue = value;
    }

    public String getValue() {
        return this.strValue;
    }

    public void setAlign(String value) {
        this.strAlign = value;
    }

    public String getAlign() {
        return this.strAlign;
    }
}

