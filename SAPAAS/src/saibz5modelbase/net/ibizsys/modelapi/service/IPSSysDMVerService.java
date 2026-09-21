/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysDMVer;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysDMVerDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysDMVerService
extends IPSModelService<PSSysDMVer, PSSysDMVerDTO> {
    public List<PSSysDMVer> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysDMVer get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysDMVerDTO> listDTOByPSSystem(String var1) throws Exception;
}

