/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEGrid;
import net.ibizsys.modelapi.domain.PSDEGridCol;
import net.ibizsys.modelapi.dto.PSDEGridColDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEGridColService
extends IPSModelService<PSDEGridCol, PSDEGridColDTO> {
    public List<PSDEGridCol> listByPSDEGridCol(PSDEGridCol var1) throws Exception;

    public PSDEGridCol get(PSDEGridCol var1, String var2, boolean var3) throws Exception;

    public List<PSDEGridColDTO> listDTOByPSDEGridCol(String var1) throws Exception;

    public List<PSDEGridCol> listByPSDEGrid(PSDEGrid var1) throws Exception;

    public PSDEGridCol get(PSDEGrid var1, String var2, boolean var3) throws Exception;

    public List<PSDEGridColDTO> listDTOByPSDEGrid(String var1) throws Exception;

    public List<PSDEGridCol> listAllChild(PSDEGridCol var1) throws Exception;

    public List<PSDEGridCol> listAllByPSDEGrid(PSDEGrid var1) throws Exception;

    public List<PSDEGridColDTO> listAllDTOByPSDEGrid(String var1) throws Exception;
}

