/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDETreeView;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSDETreeViewDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDETreeViewService
extends IPSModelService<PSDETreeView, PSDETreeViewDTO> {
    public List<PSDETreeView> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSDETreeView get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSDETreeViewDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSDETreeView> listByPSSystem(PSSystem var1) throws Exception;

    public PSDETreeView get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSDETreeViewDTO> listDTOByPSSystem(String var1) throws Exception;
}

