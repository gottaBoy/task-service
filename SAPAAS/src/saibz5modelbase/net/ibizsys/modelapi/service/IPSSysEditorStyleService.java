/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysEditorStyle;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysEditorStyleDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysEditorStyleService
extends IPSModelService<PSSysEditorStyle, PSSysEditorStyleDTO> {
    public List<PSSysEditorStyle> listByPSModule(PSModule var1) throws Exception;

    public PSSysEditorStyle get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysEditorStyleDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysEditorStyle> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysEditorStyle get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysEditorStyleDTO> listDTOByPSSystem(String var1) throws Exception;
}

