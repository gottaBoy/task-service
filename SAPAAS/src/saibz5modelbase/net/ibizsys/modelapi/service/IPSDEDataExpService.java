/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDataExp;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEDataExpDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDataExpService
extends IPSModelService<PSDEDataExp, PSDEDataExpDTO> {
    public List<PSDEDataExp> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEDataExp get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEDataExpDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

