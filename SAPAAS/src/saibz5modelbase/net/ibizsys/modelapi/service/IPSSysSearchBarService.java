/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysSearchBar;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysSearchBarDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysSearchBarService
extends IPSModelService<PSSysSearchBar, PSSysSearchBarDTO> {
    public List<PSSysSearchBar> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSSysSearchBar get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSSysSearchBarDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSSysSearchBar> listByPSModule(PSModule var1) throws Exception;

    public PSSysSearchBar get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysSearchBarDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysSearchBar> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysSearchBar get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysSearchBarDTO> listDTOByPSSystem(String var1) throws Exception;
}

