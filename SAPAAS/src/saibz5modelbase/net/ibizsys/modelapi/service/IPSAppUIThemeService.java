/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppUITheme;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppUIThemeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppUIThemeService
extends IPSModelService<PSAppUITheme, PSAppUIThemeDTO> {
    public List<PSAppUITheme> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSAppUITheme get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSAppUIThemeDTO> listDTOByPSSysApp(String var1) throws Exception;
}

