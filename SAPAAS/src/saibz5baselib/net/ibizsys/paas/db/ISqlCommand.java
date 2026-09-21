/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

import java.util.Iterator;
import net.ibizsys.paas.db.IProcParam;

public interface ISqlCommand {
    public String getSql();

    public Iterator<IProcParam> getProcParams();
}

