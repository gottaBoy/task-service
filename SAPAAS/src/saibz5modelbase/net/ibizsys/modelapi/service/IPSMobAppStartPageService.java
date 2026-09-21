/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSMobAppStartPage;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSMobAppStartPageDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSMobAppStartPageService
extends IPSModelService<PSMobAppStartPage, PSMobAppStartPageDTO> {
    public List<PSMobAppStartPage> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSMobAppStartPage get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSMobAppStartPageDTO> listDTOByPSSysApp(String var1) throws Exception;
}

