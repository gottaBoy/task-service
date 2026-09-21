/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDETreeLogic;
import net.ibizsys.modelapi.domain.PSDETreeView;
import net.ibizsys.modelapi.dto.PSDETreeLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDETreeLogicService
extends IPSModelService<PSDETreeLogic, PSDETreeLogicDTO> {
    public List<PSDETreeLogic> listByPSDETreeView(PSDETreeView var1) throws Exception;

    public PSDETreeLogic get(PSDETreeView var1, String var2, boolean var3) throws Exception;

    public List<PSDETreeLogicDTO> listDTOByPSDETreeView(String var1) throws Exception;
}

