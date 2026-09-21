/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEFGroup;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEFGroupDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEFGroupService
extends IPSModelService<PSDEFGroup, PSDEFGroupDTO> {
    public List<PSDEFGroup> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEFGroup get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEFGroupDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

