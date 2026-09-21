/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysDynaModel;
import net.ibizsys.modelapi.domain.PSSysDynaModelAttr;
import net.ibizsys.modelapi.dto.PSSysDynaModelAttrDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysDynaModelAttrService
extends IPSModelService<PSSysDynaModelAttr, PSSysDynaModelAttrDTO> {
    public List<PSSysDynaModelAttr> listByPSSysDynaModel(PSSysDynaModel var1) throws Exception;

    public PSSysDynaModelAttr get(PSSysDynaModel var1, String var2, boolean var3) throws Exception;

    public List<PSSysDynaModelAttrDTO> listDTOByPSSysDynaModel(String var1) throws Exception;
}

