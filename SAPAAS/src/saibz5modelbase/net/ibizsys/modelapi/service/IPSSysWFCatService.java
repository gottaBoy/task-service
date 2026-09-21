/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysWFCat;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysWFCatDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysWFCatService
extends IPSModelService<PSSysWFCat, PSSysWFCatDTO> {
    public List<PSSysWFCat> listByPSModule(PSModule var1) throws Exception;

    public PSSysWFCat get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysWFCatDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysWFCat> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysWFCat get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysWFCatDTO> listDTOByPSSystem(String var1) throws Exception;
}

