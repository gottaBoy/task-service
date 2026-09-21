/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEDBIdxField;
import net.ibizsys.modelapi.domain.PSDEDBIndex;
import net.ibizsys.modelapi.dto.PSDEDBIdxFieldDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEDBIdxFieldService
extends IPSModelService<PSDEDBIdxField, PSDEDBIdxFieldDTO> {
    public List<PSDEDBIdxField> listByPSDEDBIndex(PSDEDBIndex var1) throws Exception;

    public PSDEDBIdxField get(PSDEDBIndex var1, String var2, boolean var3) throws Exception;

    public List<PSDEDBIdxFieldDTO> listDTOByPSDEDBIndex(String var1) throws Exception;
}

