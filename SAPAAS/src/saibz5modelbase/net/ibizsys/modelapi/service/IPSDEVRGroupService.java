/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEVRGroup;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEVRGroupDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEVRGroupService
extends IPSModelService<PSDEVRGroup, PSDEVRGroupDTO> {
    public List<PSDEVRGroup> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEVRGroup get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEVRGroupDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

