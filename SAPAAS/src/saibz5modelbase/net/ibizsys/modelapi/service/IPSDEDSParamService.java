/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDSParam;
import net.ibizsys.modelapi.domain.PSDEDataSet;
import net.ibizsys.modelapi.dto.PSDEDSParamDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDSParamService
extends IPSModelService<PSDEDSParam, PSDEDSParamDTO> {
    public List<PSDEDSParam> listByPSDEDataSet(PSDEDataSet var1) throws Exception;

    public PSDEDSParam get(PSDEDataSet var1, String var2, boolean var3) throws Exception;

    public List<PSDEDSParamDTO> listDTOByPSDEDataSet(String var1) throws Exception;
}

