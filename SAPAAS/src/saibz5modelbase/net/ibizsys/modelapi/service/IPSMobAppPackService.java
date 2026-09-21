/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSMobAppPack;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSMobAppPackDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSMobAppPackService
extends IPSModelService<PSMobAppPack, PSMobAppPackDTO> {
    public List<PSMobAppPack> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSMobAppPack get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSMobAppPackDTO> listDTOByPSSysApp(String var1) throws Exception;
}

