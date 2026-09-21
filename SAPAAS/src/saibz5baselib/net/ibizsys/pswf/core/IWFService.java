/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.WFActionParam;
import net.ibizsys.pswf.core.WFActionResult;

public interface IWFService {
    public static final String CONNECTION_IAGOTO = "SRFWFIAGOTO";
    public static final String CONNECTION_TIMEOUT = "SRFWFTIMEOUT";
    public static final String CONNECTION_WFRESUBMIT = "SRFWFRESUBMIT";

    public void init(IWFModel var1) throws Exception;

    public WFActionResult start(WFActionParam var1) throws Exception;

    public WFActionResult submit(WFActionParam var1) throws Exception;

    public WFActionResult close(WFActionParam var1) throws Exception;

    public WFActionResult restart(WFActionParam var1) throws Exception;

    public WFActionResult submitEmbedWorkflow(WFActionParam var1, WFInstance var2, IEntity var3, boolean var4) throws Exception;

    public WFActionResult rollbackIAAction(WFActionParam var1) throws Exception;

    public WFActionResult timeoutIAAction(WFActionParam var1) throws Exception;

    public WFActionResult markReadFlag(WFActionParam var1) throws Exception;
}

