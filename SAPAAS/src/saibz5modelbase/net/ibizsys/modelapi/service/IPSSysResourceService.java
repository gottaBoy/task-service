/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysResource;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysResourceDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysResourceService
extends IPSModelService<PSSysResource, PSSysResourceDTO> {
    public List<PSSysResource> listByPSModule(PSModule var1) throws Exception;

    public PSSysResource get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysResourceDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysResource> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysResource get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysResourceDTO> listDTOByPSSystem(String var1) throws Exception;
}

