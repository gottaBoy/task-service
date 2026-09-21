/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDataEntityService
extends IPSModelService<PSDataEntity, PSDataEntityDTO> {
    public List<PSDataEntity> listByPSModule(PSModule var1) throws Exception;

    public PSDataEntity get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSDataEntityDTO> listDTOByPSModule(String var1) throws Exception;
}

