/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.control.form.IPSDEFormDetail;

public interface IPSDEFormIFrame
extends IPSDEFormDetail {
    public String getEmbedViewId();

    public String getRefreshItems();

    public String getIFrameUrl();
}

