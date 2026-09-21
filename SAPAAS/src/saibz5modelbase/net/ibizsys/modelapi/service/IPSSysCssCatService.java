/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysCssCat;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysCssCatDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysCssCatService
extends IPSModelService<PSSysCssCat, PSSysCssCatDTO> {
    public List<PSSysCssCat> listByPSModule(PSModule var1) throws Exception;

    public PSSysCssCat get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysCssCatDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysCssCat> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysCssCat get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysCssCatDTO> listDTOByPSSystem(String var1) throws Exception;
}

