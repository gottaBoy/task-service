/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysSAHandler;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysSAHandlerDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysSAHandlerService
extends IPSModelService<PSSysSAHandler, PSSysSAHandlerDTO> {
    public List<PSSysSAHandler> listByPSModule(PSModule var1) throws Exception;

    public PSSysSAHandler get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysSAHandlerDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysSAHandler> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysSAHandler get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysSAHandlerDTO> listDTOByPSSystem(String var1) throws Exception;
}

