/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFProcessModel
 */
package net.ibizsys.pswf.core;

import java.util.Iterator;
import net.ibizsys.pswf.core.IWFDEActionProcessParamModel;
import net.ibizsys.pswf.core.IWFProcessModel;

public interface IWFDEActionProcessModel
extends IWFProcessModel {
    public Iterator<IWFDEActionProcessParamModel> getWFDEActionProcessParamModels();

    public String getDEActionName();
}

