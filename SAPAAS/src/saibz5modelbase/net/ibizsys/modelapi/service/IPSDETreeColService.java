/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDETreeCol;
import net.ibizsys.modelapi.domain.PSDETreeView;
import net.ibizsys.modelapi.dto.PSDETreeColDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDETreeColService
extends IPSModelService<PSDETreeCol, PSDETreeColDTO> {
    public List<PSDETreeCol> listByPSDETreeView(PSDETreeView var1) throws Exception;

    public PSDETreeCol get(PSDETreeView var1, String var2, boolean var3) throws Exception;

    public List<PSDETreeColDTO> listDTOByPSDETreeView(String var1) throws Exception;
}

