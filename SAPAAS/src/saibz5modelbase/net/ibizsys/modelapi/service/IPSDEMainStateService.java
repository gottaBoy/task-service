/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEMainState;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEMainStateDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEMainStateService
extends IPSModelService<PSDEMainState, PSDEMainStateDTO> {
    public List<PSDEMainState> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEMainState get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEMainStateDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

