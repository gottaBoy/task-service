/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEGrid;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEGridDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEGridService
extends IPSModelService<PSDEGrid, PSDEGridDTO> {
    public List<PSDEGrid> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEGrid get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEGridDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

