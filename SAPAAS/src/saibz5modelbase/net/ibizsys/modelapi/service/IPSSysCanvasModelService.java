/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysCanvas;
import net.ibizsys.modelapi.domain.PSSysCanvasModel;
import net.ibizsys.modelapi.dto.PSSysCanvasModelDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysCanvasModelService
extends IPSModelService<PSSysCanvasModel, PSSysCanvasModelDTO> {
    public List<PSSysCanvasModel> listByPSSysCanvas(PSSysCanvas var1) throws Exception;

    public PSSysCanvasModel get(PSSysCanvas var1, String var2, boolean var3) throws Exception;

    public List<PSSysCanvasModelDTO> listDTOByPSSysCanvas(String var1) throws Exception;
}

