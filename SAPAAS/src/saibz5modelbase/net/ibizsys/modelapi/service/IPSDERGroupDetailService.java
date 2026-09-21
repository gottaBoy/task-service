/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDERGroup;
import net.ibizsys.modelapi.domain.PSDERGroupDetail;
import net.ibizsys.modelapi.dto.PSDERGroupDetailDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDERGroupDetailService
extends IPSModelService<PSDERGroupDetail, PSDERGroupDetailDTO> {
    public List<PSDERGroupDetail> listByPSDERGroup(PSDERGroup var1) throws Exception;

    public PSDERGroupDetail get(PSDERGroup var1, String var2, boolean var3) throws Exception;

    public List<PSDERGroupDetailDTO> listDTOByPSDERGroup(String var1) throws Exception;
}

