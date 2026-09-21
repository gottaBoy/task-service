/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEUAGroup;
import net.ibizsys.modelapi.domain.PSDEUAGroupDetail;
import net.ibizsys.modelapi.dto.PSDEUAGroupDetailDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEUAGroupDetailService
extends IPSModelService<PSDEUAGroupDetail, PSDEUAGroupDetailDTO> {
    public List<PSDEUAGroupDetail> listByPSDEUAGroup(PSDEUAGroup var1) throws Exception;

    public PSDEUAGroupDetail get(PSDEUAGroup var1, String var2, boolean var3) throws Exception;

    public List<PSDEUAGroupDetailDTO> listDTOByPSDEUAGroup(String var1) throws Exception;
}

