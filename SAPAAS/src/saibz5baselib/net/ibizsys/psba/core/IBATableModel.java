/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import net.ibizsys.psba.core.IBAColSet;
import net.ibizsys.psba.core.IBAColumn;
import net.ibizsys.psba.core.IBAModelBase;
import net.ibizsys.psba.core.IBATable;
import net.ibizsys.psba.core.IBATableDE;
import net.ibizsys.psba.core.IBATableDER;
import net.ibizsys.psba.core.IBATableRuntime;

public interface IBATableModel
extends IBAModelBase,
IBATable,
IBATableRuntime {
    public void registerBAColSet(IBAColSet var1) throws Exception;

    public void registerBAColumn(IBAColumn var1) throws Exception;

    public void registerBATableDE(IBATableDE var1) throws Exception;

    public void registerBATableDER(IBATableDER var1) throws Exception;

    public int getBATableDERCount();

    public IBATableDER getBATableDERAt(int var1) throws Exception;
}

