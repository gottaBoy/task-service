/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlType
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.control.IPSControlType;
import net.ibizsys.model.entity.PSPFCtrlTempl;
import net.ibizsys.model.pf.IPSPFCtrlTemplDetail;
import net.ibizsys.model.pf.IPSPFPubCode;
import net.ibizsys.model.pf.IPSPFStyleObject;
import net.ibizsys.model.pub.IPSPFCtrlCodePublisher;

public interface IPSPFCtrlTempl
extends IPSPFStyleObject {
    public IPSPFPubCode getPSPFPubCode() throws Exception;

    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail(String var1) throws Exception;

    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail(String var1, boolean var2) throws Exception;

    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail2(String var1) throws Exception;

    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail2(String var1, boolean var2) throws Exception;

    public IPSControlType getPSControlType();

    public IPSPFCtrlCodePublisher getPSPFCtrlCodePublisher() throws Exception;

    public PSPFCtrlTempl getPSPFCtrlTemplData();
}

