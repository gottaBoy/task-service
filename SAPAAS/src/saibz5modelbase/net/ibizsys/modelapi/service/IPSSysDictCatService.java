/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysDictCat;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysDictCatDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysDictCatService
extends IPSModelService<PSSysDictCat, PSSysDictCatDTO> {
    public List<PSSysDictCat> listByPSModule(PSModule var1) throws Exception;

    public PSSysDictCat get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysDictCatDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysDictCat> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysDictCat get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysDictCatDTO> listDTOByPSSystem(String var1) throws Exception;
}

