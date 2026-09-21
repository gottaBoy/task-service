/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.der.IPSDERMultiInherit
 */
package net.ibizsys.model.der;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.der.IPSDERMultiInherit;
import net.ibizsys.model.der.PSDERInheritImpl;

public class PSDERMultiInheritImpl
extends PSDERInheritImpl
implements IPSDERMultiInherit {
    @Override
    @PSModelRTMeta(description="\u5355\u7ee7\u627f\u5173\u7cfb")
    public boolean isSingleInherit() {
        return false;
    }
}

