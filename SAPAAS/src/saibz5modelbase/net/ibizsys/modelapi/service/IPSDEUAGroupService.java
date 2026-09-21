/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEUAGroup;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.domain.PSWFVersion;
import net.ibizsys.modelapi.domain.PSWorkflow;
import net.ibizsys.modelapi.dto.PSDEUAGroupDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEUAGroupService
extends IPSModelService<PSDEUAGroup, PSDEUAGroupDTO> {
    public List<PSDEUAGroup> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEUAGroup get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEUAGroupDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSDEUAGroup> listByPSWFVersion(PSWFVersion var1) throws Exception;

    public PSDEUAGroup get(PSWFVersion var1, String var2, boolean var3) throws Exception;

    public List<PSDEUAGroupDTO> listDTOByPSWFVersion(String var1) throws Exception;

    public List<PSDEUAGroup> listByPSWorkflow(PSWorkflow var1) throws Exception;

    public PSDEUAGroup get(PSWorkflow var1, String var2, boolean var3) throws Exception;

    public List<PSDEUAGroupDTO> listDTOByPSWorkflow(String var1) throws Exception;

    public List<PSDEUAGroup> listByPSModule(PSModule var1) throws Exception;

    public PSDEUAGroup get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSDEUAGroupDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSDEUAGroup> listByPSSystem(PSSystem var1) throws Exception;

    public PSDEUAGroup get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSDEUAGroupDTO> listDTOByPSSystem(String var1) throws Exception;
}

