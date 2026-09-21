/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEForm;
import net.ibizsys.modelapi.domain.PSDEFormDetail;
import net.ibizsys.modelapi.dto.PSDEFormDetailDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEFormDetailService
extends IPSModelService<PSDEFormDetail, PSDEFormDetailDTO> {
    public List<PSDEFormDetail> listByPSDEFormDetail(PSDEFormDetail var1) throws Exception;

    public PSDEFormDetail get(PSDEFormDetail var1, String var2, boolean var3) throws Exception;

    public List<PSDEFormDetailDTO> listDTOByPSDEFormDetail(String var1) throws Exception;

    public List<PSDEFormDetail> listByPSDEForm(PSDEForm var1) throws Exception;

    public PSDEFormDetail get(PSDEForm var1, String var2, boolean var3) throws Exception;

    public List<PSDEFormDetailDTO> listDTOByPSDEForm(String var1) throws Exception;

    public List<PSDEFormDetail> listAllChild(PSDEFormDetail var1) throws Exception;

    public List<PSDEFormDetail> listAllByPSDEForm(PSDEForm var1) throws Exception;

    public List<PSDEFormDetailDTO> listAllDTOByPSDEForm(String var1) throws Exception;
}

