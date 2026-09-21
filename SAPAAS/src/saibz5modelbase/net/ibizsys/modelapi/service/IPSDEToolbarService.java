/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEToolbar;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSDEToolbarDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEToolbarService
extends IPSModelService<PSDEToolbar, PSDEToolbarDTO> {
    public List<PSDEToolbar> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDEToolbar get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDEToolbarDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSDEToolbar> listByPSModule(PSModule var1) throws Exception;

    public PSDEToolbar get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSDEToolbarDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSDEToolbar> listByPSSystem(PSSystem var1) throws Exception;

    public PSDEToolbar get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSDEToolbarDTO> listDTOByPSSystem(String var1) throws Exception;
}

