/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.entity.PSPFEditorTempl;
import net.ibizsys.model.pf.IPSPFObject;
import net.ibizsys.model.pf.IPSPFPubCode;
import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.model.pub.IPSPFEditorCodePublisher;

public interface IPSPFEditorTempl
extends IPSPFObject {
    public IPSPFPubCode getPSPFPubCode() throws Exception;

    public IPSPFStyle getPSPFStyle();

    public PSPFEditorTempl getPSPFEditorTemplData();

    public IPSPFEditorCodePublisher getPSPFEditorCodePublisher() throws Exception;
}

