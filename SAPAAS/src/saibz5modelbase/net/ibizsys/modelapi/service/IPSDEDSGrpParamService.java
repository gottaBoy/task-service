/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDSGrpParam;
import net.ibizsys.modelapi.domain.PSDEDataSet;
import net.ibizsys.modelapi.dto.PSDEDSGrpParamDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDSGrpParamService
extends IPSModelService<PSDEDSGrpParam, PSDEDSGrpParamDTO> {
    public List<PSDEDSGrpParam> listByPSDEDataSet(PSDEDataSet var1) throws Exception;

    public PSDEDSGrpParam get(PSDEDataSet var1, String var2, boolean var3) throws Exception;

    public List<PSDEDSGrpParamDTO> listDTOByPSDEDataSet(String var1) throws Exception;
}

