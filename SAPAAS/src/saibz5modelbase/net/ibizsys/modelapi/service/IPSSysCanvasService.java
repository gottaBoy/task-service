/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysCanvas;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysCanvasDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysCanvasService
extends IPSModelService<PSSysCanvas, PSSysCanvasDTO> {
    public List<PSSysCanvas> listByPSModule(PSModule var1) throws Exception;

    public PSSysCanvas get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysCanvasDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysCanvas> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysCanvas get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysCanvasDTO> listDTOByPSSystem(String var1) throws Exception;
}

