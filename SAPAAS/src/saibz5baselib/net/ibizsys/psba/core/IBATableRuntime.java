/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import net.ibizsys.psba.entity.IBAEntity;

public interface IBATableRuntime {
    public IBAEntity createBAEntity() throws Exception;

    public IBAEntity getBAEntity(String var1) throws Exception;

    public IBAEntity getBAEntity(String var1, String[] var2) throws Exception;

    public IBAEntity getBAEntity(String var1, String[] var2, boolean var3) throws Exception;
}

