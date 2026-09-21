/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppUIStyle;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppUIStyleDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppUIStyleService
extends IPSModelService<PSAppUIStyle, PSAppUIStyleDTO> {
    public List<PSAppUIStyle> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSAppUIStyle get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSAppUIStyleDTO> listDTOByPSSysApp(String var1) throws Exception;
}

