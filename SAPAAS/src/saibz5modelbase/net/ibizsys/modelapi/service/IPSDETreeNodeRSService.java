/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDETreeNodeRS;
import net.ibizsys.modelapi.domain.PSDETreeView;
import net.ibizsys.modelapi.dto.PSDETreeNodeRSDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDETreeNodeRSService
extends IPSModelService<PSDETreeNodeRS, PSDETreeNodeRSDTO> {
    public List<PSDETreeNodeRS> listByPSDETreeView(PSDETreeView var1) throws Exception;

    public PSDETreeNodeRS get(PSDETreeView var1, String var2, boolean var3) throws Exception;

    public List<PSDETreeNodeRSDTO> listDTOByPSDETreeView(String var1) throws Exception;
}

