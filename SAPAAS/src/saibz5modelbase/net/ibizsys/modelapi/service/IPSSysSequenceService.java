/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysSequence;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysSequenceDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysSequenceService
extends IPSModelService<PSSysSequence, PSSysSequenceDTO> {
    public List<PSSysSequence> listByPSModule(PSModule var1) throws Exception;

    public PSSysSequence get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysSequenceDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysSequence> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysSequence get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysSequenceDTO> listDTOByPSSystem(String var1) throws Exception;
}

