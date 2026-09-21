/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import net.ibizsys.psba.core.IBATableObject;

public interface IBATableDER
extends IBATableObject {
    public String getMajorDEName();

    public String getMinorDEName();

    public String getDERFieldName();
}

