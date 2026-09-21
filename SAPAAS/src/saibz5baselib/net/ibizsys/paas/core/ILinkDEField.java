/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDEField;

public interface ILinkDEField
extends IDEField {
    public String getDERId();

    public IDEField getRelatedDEField();
}

