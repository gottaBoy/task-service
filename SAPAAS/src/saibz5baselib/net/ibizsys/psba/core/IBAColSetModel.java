/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import net.ibizsys.psba.core.IBAColSet;
import net.ibizsys.psba.core.IBAColumn;

public interface IBAColSetModel
extends IBAColSet {
    public void registerBAColumn(IBAColumn var1) throws Exception;
}

