/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysDEFType;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysDEFTypeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysDEFTypeService
extends IPSModelService<PSSysDEFType, PSSysDEFTypeDTO> {
    public List<PSSysDEFType> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysDEFType get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysDEFTypeDTO> listDTOByPSSystem(String var1) throws Exception;
}

