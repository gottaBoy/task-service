/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEACMode;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEACModeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEACModeService
extends IPSModelService<PSDEACMode, PSDEACModeDTO> {
    public List<PSDEACMode> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEACMode get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEACModeDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

