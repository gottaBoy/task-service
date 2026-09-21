/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDETreeNode;
import net.ibizsys.modelapi.domain.PSDETreeNodeCol;
import net.ibizsys.modelapi.domain.PSDETreeView;
import net.ibizsys.modelapi.dto.PSDETreeNodeColDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDETreeNodeColService
extends IPSModelService<PSDETreeNodeCol, PSDETreeNodeColDTO> {
    public List<PSDETreeNodeCol> listByPSDETreeNode(PSDETreeNode var1) throws Exception;

    public PSDETreeNodeCol get(PSDETreeNode var1, String var2, boolean var3) throws Exception;

    public List<PSDETreeNodeColDTO> listDTOByPSDETreeNode(String var1) throws Exception;

    public List<PSDETreeNodeCol> listByPSDETreeView(PSDETreeView var1) throws Exception;

    public PSDETreeNodeCol get(PSDETreeView var1, String var2, boolean var3) throws Exception;

    public List<PSDETreeNodeColDTO> listDTOByPSDETreeView(String var1) throws Exception;
}

