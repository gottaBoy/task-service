/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.data;

import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.IDEFieldDiffItem;

public class DEFieldDiffItem
implements IDEFieldDiffItem {
    private IDEField iDEField = null;
    private Object newValue = null;
    private Object oldValue = null;
    private String strDiffInfo = "";
    private String strNewText = null;
    private String strOldText = null;

    @Override
    public IDEField getDEField() {
        return this.iDEField;
    }

    @Override
    public Object getNewValue() {
        return this.newValue;
    }

    @Override
    public Object getOldValue() {
        return this.oldValue;
    }

    @Override
    public String getDiffInfo() {
        return this.strDiffInfo;
    }

    public void setDEField(IDEField iDEField) {
        this.iDEField = iDEField;
    }

    public void setNewValue(Object newValue) {
        this.newValue = newValue;
    }

    public void setOldValue(Object oldValue) {
        this.oldValue = oldValue;
    }

    public void setDiffInfo(String strDiffInfo) {
        this.strDiffInfo = strDiffInfo;
    }

    @Override
    public String getNewText() {
        if (this.strNewText == null && this.getNewValue() != null) {
            return this.getNewValue().toString();
        }
        return this.strNewText;
    }

    public void setNewText(String strNewText) {
        this.strNewText = strNewText;
    }

    @Override
    public String getOldText() {
        if (this.strOldText == null && this.getOldValue() != null) {
            return this.getOldValue().toString();
        }
        return this.strOldText;
    }

    public void setOldText(String strOldText) {
        this.strOldText = strOldText;
    }
}

