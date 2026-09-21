/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEMap;
import net.ibizsys.modelapi.domain.PSDEMapAction;
import net.ibizsys.modelapi.dto.PSDEMapActionDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEMapActionService
extends IPSModelService<PSDEMapAction, PSDEMapActionDTO> {
    public List<PSDEMapAction> listByPSDEMap(PSDEMap var1) throws Exception;

    public PSDEMapAction get(PSDEMap var1, String var2, boolean var3) throws Exception;

    public List<PSDEMapActionDTO> listDTOByPSDEMap(String var1) throws Exception;
}

