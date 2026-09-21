/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysCss;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysCssService
extends IPSModelService<PSSysCss, PSSysCssDTO> {
    public List<PSSysCss> listByPSModule(PSModule var1) throws Exception;

    public PSSysCss get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysCssDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysCss> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysCss get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysCssDTO> listDTOByPSSystem(String var1) throws Exception;
}

