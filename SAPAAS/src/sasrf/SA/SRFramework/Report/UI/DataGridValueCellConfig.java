/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Report.UI;

import SA.SRFramework.Report.UI.BaseTextConfig;

public class DataGridValueCellConfig
extends BaseTextConfig {
    private String strDefaultValue = "";
    private int nHeight = 25;

    public void setDefaultValue(String value) {
        this.strDefaultValue = value;
    }

    public String getDefaultValue() {
        return this.strDefaultValue;
    }

    public int getHeight() {
        return this.nHeight;
    }

    public void setHeight(int value) {
        this.nHeight = value;
    }
}

