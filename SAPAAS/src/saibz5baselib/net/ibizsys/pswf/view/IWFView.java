/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.view;

import net.ibizsys.paas.view.IView;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;

public interface IWFView
extends IView {
    public boolean isWFIAMode();

    public String getWFStepValue();

    public IWFModel getWFModel();

    public IWFVersionModel getWFVersionModel();

    public int getWFVersion();
}

