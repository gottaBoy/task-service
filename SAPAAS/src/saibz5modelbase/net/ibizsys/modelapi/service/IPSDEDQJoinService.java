/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDQJoin;
import net.ibizsys.modelapi.domain.PSDEDataQuery;
import net.ibizsys.modelapi.dto.PSDEDQJoinDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDQJoinService
extends IPSModelService<PSDEDQJoin, PSDEDQJoinDTO> {
    public List<PSDEDQJoin> listByPSDEDQJoin(PSDEDQJoin var1) throws Exception;

    public PSDEDQJoin get(PSDEDQJoin var1, String var2, boolean var3) throws Exception;

    public List<PSDEDQJoinDTO> listDTOByPSDEDQJoin(String var1) throws Exception;

    public List<PSDEDQJoin> listByPSDEDataQuery(PSDEDataQuery var1) throws Exception;

    public PSDEDQJoin get(PSDEDataQuery var1, String var2, boolean var3) throws Exception;

    public List<PSDEDQJoinDTO> listDTOByPSDEDataQuery(String var1) throws Exception;

    public List<PSDEDQJoin> listAllChild(PSDEDQJoin var1) throws Exception;

    public List<PSDEDQJoin> listAllByPSDEDataQuery(PSDEDataQuery var1) throws Exception;

    public List<PSDEDQJoinDTO> listAllDTOByPSDEDataQuery(String var1) throws Exception;
}

