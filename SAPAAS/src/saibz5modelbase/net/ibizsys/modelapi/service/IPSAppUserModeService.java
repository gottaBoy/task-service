/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppUserMode;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppUserModeDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppUserModeService
extends IPSModelService<PSAppUserMode, PSAppUserModeDTO> {
    public List<PSAppUserMode> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSAppUserMode get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSAppUserModeDTO> listDTOByPSSysApp(String var1) throws Exception;
}

