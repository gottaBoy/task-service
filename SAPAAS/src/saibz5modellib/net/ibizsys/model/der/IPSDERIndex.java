/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.der;

import java.util.Iterator;
import net.ibizsys.model.der.IPSDERBase;

public interface IPSDERIndex
extends IPSDERBase {
    public String getTypeValue();

    public Iterator getPropertyMapNames();

    public String getPropertyMap(String var1);
}

