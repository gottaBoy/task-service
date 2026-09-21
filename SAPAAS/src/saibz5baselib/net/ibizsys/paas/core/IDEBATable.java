/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDataEntityObject;

public interface IDEBATable
extends IDataEntityObject {
    public int getBATableDEType();

    public String getBAThemeId();

    public String getBATableName();

    public String getBAColSetName();
}

