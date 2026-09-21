/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.psba.core.IBATableObject;

public interface IBATableDE
extends IBATableObject {
    public static final int BATABLEDETYPE_DEFAULT = 1;
    public static final int BATABLEDETYPE_MAJOR = 2;
    public static final int BATABLEDETYPE_MINOR = 3;
    public static final int BATABLEDETYPE_RELATED = 0;

    public int getBATableDEType();

    public IDataEntity getDataEntity();

    public String getBAColSetName();

    public String getRowKeyFormat();

    public String getRowKeyParams();
}

