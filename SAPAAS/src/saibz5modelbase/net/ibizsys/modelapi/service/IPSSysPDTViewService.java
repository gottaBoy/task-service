/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysPDTView;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysPDTViewDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysPDTViewService
extends IPSModelService<PSSysPDTView, PSSysPDTViewDTO> {
    public List<PSSysPDTView> listByPSModule(PSModule var1) throws Exception;

    public PSSysPDTView get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysPDTViewDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysPDTView> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysPDTView get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysPDTViewDTO> listDTOByPSSystem(String var1) throws Exception;
}

