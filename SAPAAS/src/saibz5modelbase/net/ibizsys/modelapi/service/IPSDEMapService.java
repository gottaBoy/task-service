/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEMap;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEMapDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEMapService
extends IPSModelService<PSDEMap, PSDEMapDTO> {
    public List<PSDEMap> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEMap get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEMapDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

