/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysActor;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysActorDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysActorService
extends IPSModelService<PSSysActor, PSSysActorDTO> {
    public List<PSSysActor> listByPSModule(PSModule var1) throws Exception;

    public PSSysActor get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysActorDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysActor> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysActor get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysActorDTO> listDTOByPSSystem(String var1) throws Exception;
}

