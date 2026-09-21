/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDETreeNode;
import net.ibizsys.modelapi.domain.PSDETreeNodeRV;
import net.ibizsys.modelapi.dto.PSDETreeNodeRVDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDETreeNodeRVService
extends IPSModelService<PSDETreeNodeRV, PSDETreeNodeRVDTO> {
    public List<PSDETreeNodeRV> listByPSDETreeNode(PSDETreeNode var1) throws Exception;

    public PSDETreeNodeRV get(PSDETreeNode var1, String var2, boolean var3) throws Exception;

    public List<PSDETreeNodeRVDTO> listDTOByPSDETreeNode(String var1) throws Exception;
}

