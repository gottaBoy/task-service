/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import java.util.Iterator;
import net.ibizsys.psba.core.IBAColumn;
import net.ibizsys.psba.core.IBATableObject;

public interface IBAColSet
extends IBATableObject {
    public Iterator<IBAColumn> getBAColumns();

    public IBAColumn getBAColumn(String var1) throws Exception;
}

