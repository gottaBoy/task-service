/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.domain.PSWorkflow;
import net.ibizsys.modelapi.dto.PSWorkflowDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSWorkflowService
extends IPSModelService<PSWorkflow, PSWorkflowDTO> {
    public List<PSWorkflow> listByPSModule(PSModule var1) throws Exception;

    public PSWorkflow get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSWorkflowDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSWorkflow> listByPSSystem(PSSystem var1) throws Exception;

    public PSWorkflow get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSWorkflowDTO> listDTOByPSSystem(String var1) throws Exception;
}

