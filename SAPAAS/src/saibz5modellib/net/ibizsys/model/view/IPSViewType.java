/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.view;

import net.ibizsys.model.core.IPSModelObject;

public interface IPSViewType
extends IPSModelObject {
    public boolean isDEViewType();

    public String getCodeName();

    public boolean isEmbeddedView();
}

