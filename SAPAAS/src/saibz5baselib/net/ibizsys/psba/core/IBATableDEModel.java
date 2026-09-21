/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.psba.core.IBAModelBase;
import net.ibizsys.psba.core.IBATableDE;

public interface IBATableDEModel
extends IBAModelBase,
IBATableDE {
    public String getRowKey(ISimpleDataObject var1) throws Exception;
}

