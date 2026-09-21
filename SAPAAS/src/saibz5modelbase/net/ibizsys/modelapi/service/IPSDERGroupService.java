/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDERGroup;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSDERGroupDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDERGroupService
extends IPSModelService<PSDERGroup, PSDERGroupDTO> {
    public List<PSDERGroup> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDERGroup get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDERGroupDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSDERGroup> listByPSModule(PSModule var1) throws Exception;

    public PSDERGroup get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSDERGroupDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSDERGroup> listByPSSystem(PSSystem var1) throws Exception;

    public PSDERGroup get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSDERGroupDTO> listDTOByPSSystem(String var1) throws Exception;
}

