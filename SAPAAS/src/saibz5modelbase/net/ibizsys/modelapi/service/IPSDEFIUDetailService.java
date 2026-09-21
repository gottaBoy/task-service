/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEFIUDetail;
import net.ibizsys.modelapi.domain.PSDEFIUpdate;
import net.ibizsys.modelapi.domain.PSDEForm;
import net.ibizsys.modelapi.dto.PSDEFIUDetailDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEFIUDetailService
extends IPSModelService<PSDEFIUDetail, PSDEFIUDetailDTO> {
    public List<PSDEFIUDetail> listByPSDEFIUpdate(PSDEFIUpdate var1) throws Exception;

    public PSDEFIUDetail get(PSDEFIUpdate var1, String var2, boolean var3) throws Exception;

    public List<PSDEFIUDetailDTO> listDTOByPSDEFIUpdate(String var1) throws Exception;

    public List<PSDEFIUDetail> listByPSDEForm(PSDEForm var1) throws Exception;

    public PSDEFIUDetail get(PSDEForm var1, String var2, boolean var3) throws Exception;

    public List<PSDEFIUDetailDTO> listDTOByPSDEForm(String var1) throws Exception;
}

