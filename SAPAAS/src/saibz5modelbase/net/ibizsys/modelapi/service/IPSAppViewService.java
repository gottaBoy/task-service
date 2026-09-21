/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppModule;
import net.ibizsys.modelapi.domain.PSAppView;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppViewDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppViewService<T extends PSAppView, DTO extends PSAppViewDTO>
extends IPSModelService<T, DTO> {
    public List<T> listByPSAppModule(PSAppModule var1) throws Exception;

    public T get(PSAppModule var1, String var2, boolean var3) throws Exception;

    public List<DTO> listDTOByPSAppModule(String var1) throws Exception;

    public List<T> listByPSSysApp(PSSysApp var1) throws Exception;

    public T get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<DTO> listDTOByPSSysApp(String var1) throws Exception;
}

