/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEField;
import net.ibizsys.modelapi.domain.PSDER;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEFieldService
extends IPSModelService<PSDEField, PSDEFieldDTO> {
    public List<PSDEField> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEField get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEFieldDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSDEField> listByPSDER(PSDER var1) throws Exception;

    public PSDEField get(PSDER var1, String var2, boolean var3) throws Exception;

    public List<PSDEFieldDTO> listDTOByPSDER(String var1) throws Exception;
}

