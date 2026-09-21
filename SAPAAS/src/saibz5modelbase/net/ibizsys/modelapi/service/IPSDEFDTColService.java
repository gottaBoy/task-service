/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEFDTCol;
import net.ibizsys.modelapi.domain.PSDEField;
import net.ibizsys.modelapi.dto.PSDEFDTColDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEFDTColService
extends IPSModelService<PSDEFDTCol, PSDEFDTColDTO> {
    public List<PSDEFDTCol> listByPSDEField(PSDEField var1) throws Exception;

    public PSDEFDTCol get(PSDEField var1, String var2, boolean var3) throws Exception;

    public List<PSDEFDTColDTO> listDTOByPSDEField(String var1) throws Exception;
}

