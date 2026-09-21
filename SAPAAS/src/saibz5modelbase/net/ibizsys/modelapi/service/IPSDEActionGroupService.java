/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEActionGroup;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEActionGroupDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEActionGroupService
extends IPSModelService<PSDEActionGroup, PSDEActionGroupDTO> {
    public List<PSDEActionGroup> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEActionGroup get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEActionGroupDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

