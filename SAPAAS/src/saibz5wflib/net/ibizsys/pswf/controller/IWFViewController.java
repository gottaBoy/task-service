/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 */
package net.ibizsys.pswf.controller;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;

public interface IWFViewController
extends IViewController {
    public boolean isWFIAMode();

    public IWFModel getWFModel();

    public IWFVersionModel getWFVersionModel();

    public String getWFStepValue();

    public int getWFVersion();
}

