/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 */
package net.ibizsys.model.pub;

import java.util.Map;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.pf.IPSPFCtrlTemplDetail;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCodePublisher;
import net.ibizsys.model.pub.IPSPFCtrlCodePublisher;

public interface IPSPFCtrlPartCodePublisher
extends IPSPFCodePublisher {
    public void init(IPSModelStorageContext var1, IPSPFCtrlTemplDetail var2) throws Exception;

    public IPSGenerateCodeResult generateCode(IPSControl var1, Object var2) throws Exception;

    public IPSGenerateCodeResult generateCode(IPSControl var1, Object var2, Map<String, Object> var3) throws Exception;

    public IPSGenerateCodeResult generateCode(IPSPFCtrlCodePublisher var1, IPSControl var2, Object var3, Map<String, Object> var4) throws Exception;

    public String getCodePart(String var1, Object var2) throws Exception;

    public boolean hasCodePart(String var1) throws Exception;
}

