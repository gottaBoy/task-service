/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSModule;
import net.ibizsys.modelapi.domain.PSSysReqItem;
import net.ibizsys.modelapi.domain.PSSysReqModule;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysReqItemService
extends IPSModelService<PSSysReqItem, PSSysReqItemDTO> {
    public List<PSSysReqItem> listByPSSysReqModule(PSSysReqModule var1) throws Exception;

    public PSSysReqItem get(PSSysReqModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysReqItemDTO> listDTOByPSSysReqModule(String var1) throws Exception;

    public List<PSSysReqItem> listByPSModule(PSModule var1) throws Exception;

    public PSSysReqItem get(PSModule var1, String var2, boolean var3) throws Exception;

    public List<PSSysReqItemDTO> listDTOByPSModule(String var1) throws Exception;

    public List<PSSysReqItem> listByPSSystem(PSSystem var1) throws Exception;

    public PSSysReqItem get(PSSystem var1, String var2, boolean var3) throws Exception;

    public List<PSSysReqItemDTO> listDTOByPSSystem(String var1) throws Exception;

    public List<PSSysReqItem> listByPSSysReqItem(PSSysReqItem var1) throws Exception;

    public PSSysReqItem get(PSSysReqItem var1, String var2, boolean var3) throws Exception;

    public List<PSSysReqItemDTO> listDTOByPSSysReqItem(String var1) throws Exception;

    public List<PSSysReqItem> listAllChild(PSSysReqItem var1) throws Exception;

    public List<PSSysReqItem> listAllByPSSysReqModule(PSSysReqModule var1) throws Exception;

    public List<PSSysReqItemDTO> listAllDTOByPSSysReqModule(String var1) throws Exception;

    public List<PSSysReqItem> listAllByPSModule(PSModule var1) throws Exception;

    public List<PSSysReqItemDTO> listAllDTOByPSModule(String var1) throws Exception;

    public List<PSSysReqItem> listAllByPSSystem(PSSystem var1) throws Exception;

    public List<PSSysReqItemDTO> listAllDTOByPSSystem(String var1) throws Exception;
}

