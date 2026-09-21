/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEGroup;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSDEGroupDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEGroupService
extends IPSModelService<PSDEGroup, PSDEGroupDTO> {
    public List<PSDEGroup> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEGroup get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEGroupDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSDEGroup> listByPSModule(PSModule var1) throws Exception;

    public PSDEGroup get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSDEGroupDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSDEGroup> listByPSSystem(PSSystem var1) throws Exception;

    public PSDEGroup get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSDEGroupDTO> listDTOByPSSystem(String var1) throws Exception;
}

