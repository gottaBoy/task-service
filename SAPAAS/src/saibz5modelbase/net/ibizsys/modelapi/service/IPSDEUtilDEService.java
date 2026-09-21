/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEUtilDE;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEUtilDEDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEUtilDEService
extends IPSModelService<PSDEUtilDE, PSDEUtilDEDTO> {
    public List<PSDEUtilDE> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEUtilDE get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEUtilDEDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

