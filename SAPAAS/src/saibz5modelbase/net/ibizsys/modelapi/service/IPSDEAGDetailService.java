/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEAGDetail;
import net.ibizsys.modelapi.domain.PSDEActionGroup;
import net.ibizsys.modelapi.dto.PSDEAGDetailDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEAGDetailService
extends IPSModelService<PSDEAGDetail, PSDEAGDetailDTO> {
    public List<PSDEAGDetail> listByPSDEActionGroup(PSDEActionGroup var1) throws Exception;

    public PSDEAGDetail get(PSDEActionGroup var1, String var2, boolean var3) throws Exception;

    public List<PSDEAGDetailDTO> listDTOByPSDEActionGroup(String var1) throws Exception;
}

