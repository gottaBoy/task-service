/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDRDetail;
import net.ibizsys.modelapi.domain.PSDEDataRelation;
import net.ibizsys.modelapi.dto.PSDEDRDetailDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDRDetailService
extends IPSModelService<PSDEDRDetail, PSDEDRDetailDTO> {
    public List<PSDEDRDetail> listByPSDEDataRelation(PSDEDataRelation var1) throws Exception;

    public PSDEDRDetail get(PSDEDataRelation var1, String var2, boolean var3) throws Exception;

    public List<PSDEDRDetailDTO> listDTOByPSDEDataRelation(String var1) throws Exception;
}

