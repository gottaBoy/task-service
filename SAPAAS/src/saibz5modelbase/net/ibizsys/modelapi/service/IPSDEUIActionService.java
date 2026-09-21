/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEUIAction;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.domain.PSWFVersion;
import net.ibizsys.modelapi.domain.PSWorkflow;
import net.ibizsys.modelapi.dto.PSDEUIActionDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEUIActionService
extends IPSModelService<PSDEUIAction, PSDEUIActionDTO> {
    public List<PSDEUIAction> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEUIAction get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEUIActionDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSDEUIAction> listByPSWFVersion(PSWFVersion var1) throws Exception;

    public PSDEUIAction get(PSWFVersion var1, String var2, boolean var3) throws Exception;

    public List<PSDEUIActionDTO> listDTOByPSWFVersion(String var1) throws Exception;

    public List<PSDEUIAction> listByPSWorkflow(PSWorkflow var1) throws Exception;

    public PSDEUIAction get(PSWorkflow var1, String var2, boolean var3) throws Exception;

    public List<PSDEUIActionDTO> listDTOByPSWorkflow(String var1) throws Exception;

    public List<PSDEUIAction> listByPSModule(PSModule var1) throws Exception;

    public PSDEUIAction get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSDEUIActionDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSDEUIAction> listByPSSystem(PSSystem var1) throws Exception;

    public PSDEUIAction get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSDEUIActionDTO> listDTOByPSSystem(String var1) throws Exception;
}

