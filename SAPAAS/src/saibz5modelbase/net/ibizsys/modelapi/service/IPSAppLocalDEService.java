/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppLocalDE;
import net.ibizsys.modelapi.domain.PSAppModule;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppLocalDEDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppLocalDEService
extends IPSModelService<PSAppLocalDE, PSAppLocalDEDTO> {
    public List<PSAppLocalDE> listByPSAppModule(PSAppModule var1) throws Exception;

    public PSAppLocalDE get(PSAppModule var1, String var2, boolean var3) throws Exception;

    public List<PSAppLocalDEDTO> listDTOByPSAppModule(String var1) throws Exception;

    public List<PSAppLocalDE> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSAppLocalDE get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSAppLocalDEDTO> listDTOByPSSysApp(String var1) throws Exception;
}

