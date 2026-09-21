/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 */
package net.ibizsys.model.pub;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.pf.IPSPFEditorTempl;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCodePublisher;

public interface IPSPFEditorCodePublisher
extends IPSPFCodePublisher {
    public void init(IPSModelStorageContext var1, IPSPFEditorTempl var2) throws Exception;

    public IPSGenerateCodeResult generateCode(IPSControl var1, Object var2) throws Exception;
}

