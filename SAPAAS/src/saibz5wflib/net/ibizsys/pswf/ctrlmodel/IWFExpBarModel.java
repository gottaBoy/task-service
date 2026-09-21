/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.IExpBarModel
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 */
package net.ibizsys.pswf.ctrlmodel;

import net.ibizsys.paas.ctrlmodel.IExpBarModel;
import net.ibizsys.pswf.control.expbar.IWFExpBar;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;

public interface IWFExpBarModel
extends IExpBarModel,
IWFExpBar {
    public static final String ITEM_MYWFWORK = "MYWFWORK";
    public static final String ITEM_MY = "MY";
    public static final String ITEM_ALL = "ALL";

    public IWFModel getWFModel();

    public IWFVersionModel getWFVersionModel();
}

