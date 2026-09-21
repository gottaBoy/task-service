/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppModule;
import net.ibizsys.modelapi.domain.PSAppWF;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppWFDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppWFService
extends IPSModelService<PSAppWF, PSAppWFDTO> {
    public List<PSAppWF> listByPSAppModule(PSAppModule var1) throws Exception;

    public PSAppWF get(PSAppModule var1, String var2, boolean var3) throws Exception;

    public List<PSAppWFDTO> listDTOByPSAppModule(String var1) throws Exception;

    public List<PSAppWF> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSAppWF get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSAppWFDTO> listDTOByPSSysApp(String var1) throws Exception;
}

