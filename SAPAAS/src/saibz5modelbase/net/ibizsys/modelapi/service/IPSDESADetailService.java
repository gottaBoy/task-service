/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDESADetail;
import net.ibizsys.modelapi.domain.PSDESARS;
import net.ibizsys.modelapi.domain.PSDEServiceAPI;
import net.ibizsys.modelapi.dto.PSDESADetailDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDESADetailService
extends IPSModelService<PSDESADetail, PSDESADetailDTO> {
    public List<PSDESADetail> listByPSDESARS(PSDESARS var1) throws Exception;

    public PSDESADetail get(PSDESARS var1, String var2, boolean var3) throws Exception;

    public List<PSDESADetailDTO> listDTOByPSDESARS(String var1) throws Exception;

    public List<PSDESADetail> listByPSDEServiceAPI(PSDEServiceAPI var1) throws Exception;

    public PSDESADetail get(PSDEServiceAPI var1, String var2, boolean var3) throws Exception;

    public List<PSDESADetailDTO> listDTOByPSDEServiceAPI(String var1) throws Exception;
}

