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
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCodePublisher;

public interface IPSPFCtrlCodePublisher
extends IPSPFCodePublisher {
    public void init(IPSModelStorageContext var1, IPSPFCtrlTempl var2) throws Exception;

    public IPSGenerateCodeResult generateCode(IPSControl var1) throws Exception;

    public IPSGenerateCodeResult generateCode(IPSControl var1, Map<String, Object> var2) throws Exception;

    public String generateCode2(IPSControl var1, Map<String, Object> var2) throws Exception;

    public String getCodePart(String var1, Object var2) throws Exception;

    public boolean hasCodePart(String var1) throws Exception;
}

