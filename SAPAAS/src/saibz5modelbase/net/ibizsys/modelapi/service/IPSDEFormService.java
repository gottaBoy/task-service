/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEForm;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEFormDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEFormService
extends IPSModelService<PSDEForm, PSDEFormDTO> {
    public List<PSDEForm> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEForm get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEFormDTO> listDTOByPSDataEntity(String var1) throws Exception;
}

