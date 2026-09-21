/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDataRelation;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEDataRelationDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDataRelationService
extends IPSModelService<PSDEDataRelation, PSDEDataRelationDTO> {
    public List<PSDEDataRelation> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEDataRelation get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEDataRelationDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

