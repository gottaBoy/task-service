/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysPortlet;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysPortletDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysPortletService
extends IPSModelService<PSSysPortlet, PSSysPortletDTO> {
    public List<PSSysPortlet> listByPSDataEntity(PSDataEntity var1) throws Exception;

    public PSSysPortlet get(PSDataEntity var1, String var2, boolean var3) throws Exception;

    public List<PSSysPortletDTO> listDTOByPSDataEntity(String var1) throws Exception;

    public List<PSSysPortlet> listByPSModule(PSModule var1) throws Exception;

    public PSSysPortlet get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysPortletDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysPortlet> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysPortlet get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysPortletDTO> listDTOByPSSystem(String var1) throws Exception;
}

