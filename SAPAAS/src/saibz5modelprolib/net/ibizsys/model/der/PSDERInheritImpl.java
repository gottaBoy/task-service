/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.der.IPSDERInherit
 */
package net.ibizsys.model.der;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.der.IPSDERInherit;
import net.ibizsys.model.der.PSDERIndexImpl;

public class PSDERInheritImpl
extends PSDERIndexImpl
implements IPSDERInherit {
    @PSModelRTMeta(description="\u5355\u7ee7\u627f\u5173\u7cfb")
    public boolean isSingleInherit() {
        return true;
    }
}

