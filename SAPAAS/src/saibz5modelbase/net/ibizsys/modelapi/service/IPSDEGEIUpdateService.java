/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEGEIUpdate;
import net.ibizsys.modelapi.domain.PSDEGrid;
import net.ibizsys.modelapi.dto.PSDEGEIUpdateDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEGEIUpdateService
extends IPSModelService<PSDEGEIUpdate, PSDEGEIUpdateDTO> {
    public List<PSDEGEIUpdate> listByPSDEGrid(PSDEGrid var1) throws Exception;

    public PSDEGEIUpdate get(PSDEGrid var1, String var2, boolean var3) throws Exception;

    public List<PSDEGEIUpdateDTO> listDTOByPSDEGrid(String var1) throws Exception;
}

