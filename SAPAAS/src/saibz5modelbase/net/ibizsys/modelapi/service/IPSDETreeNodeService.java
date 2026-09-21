/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDETreeNode;
import net.ibizsys.modelapi.domain.PSDETreeView;
import net.ibizsys.modelapi.dto.PSDETreeNodeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDETreeNodeService
extends IPSModelService<PSDETreeNode, PSDETreeNodeDTO> {
    public List<PSDETreeNode> listByPSDETreeView(PSDETreeView var1) throws Exception;

    public PSDETreeNode get(PSDETreeView var1, String var2, boolean var3) throws Exception;

    public List<PSDETreeNodeDTO> listDTOByPSDETreeView(String var1) throws Exception;
}

