/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.data;

import net.ibizsys.paas.core.IDEField;

public interface IDEFieldDiffItem {
    public IDEField getDEField();

    public Object getNewValue();

    public Object getOldValue();

    public String getDiffInfo();

    public String getNewText();

    public String getOldText();
}

