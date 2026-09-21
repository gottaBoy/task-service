/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDRGroup;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEDRGroupDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDRGroupService
extends IPSModelService<PSDEDRGroup, PSDEDRGroupDTO> {
    public List<PSDEDRGroup> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEDRGroup get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEDRGroupDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

