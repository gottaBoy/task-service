/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSPFEditorTempl;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFEditorTempl;
import net.ibizsys.model.pf.IPSPFStyle;

public interface IPSPFEditorTemplRuntime
extends IPSPFEditorTempl {
    public void init(IPSModelStorageContext var1, IPSPF var2, IPSPFStyle var3, PSPFEditorTempl var4) throws Exception;
}

