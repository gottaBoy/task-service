/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.entity.PSPFCtrlTemplDetail;
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pf.IPSPFObject;
import net.ibizsys.model.pf.IPSPFPubCode;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;

public interface IPSPFCtrlTemplDetail
extends IPSPFObject {
    public IPSPFCtrlTempl getPSPFCtrlTempl();

    public IPSPFPubCode getPSPFPubCode() throws Exception;

    public String getLogicName();

    public IPSPFCtrlPartCodePublisher getPSPFCtrlPartCodePublisher() throws Exception;

    public PSPFCtrlTemplDetail getPSPFCtrlTemplDetailData();
}

