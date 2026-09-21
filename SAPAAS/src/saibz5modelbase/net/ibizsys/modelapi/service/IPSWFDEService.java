/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSWFDE;
import net.ibizsys.modelapi.domain.PSWorkflow;
import net.ibizsys.modelapi.dto.PSWFDEDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSWFDEService
extends IPSModelService<PSWFDE, PSWFDEDTO> {
    public List<PSWFDE> listByPSWorkflow(PSWorkflow var1) throws Exception;

    public PSWFDE get(PSWorkflow var1, String var2, boolean var3) throws Exception;

    public List<PSWFDEDTO> listDTOByPSWorkflow(String var1) throws Exception;
}

