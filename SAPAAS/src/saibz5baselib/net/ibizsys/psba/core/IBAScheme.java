/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import java.util.Iterator;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.psba.core.IBATable;

public interface IBAScheme
extends IModelBase {
    public Iterator<IBATable> getBATables();

    public IBATable getBATable(String var1, boolean var2) throws Exception;

    public ISystem getSystem();
}

