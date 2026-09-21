/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSSysDBPart;
import net.ibizsys.modelapi.domain.PSSysDashboard;
import net.ibizsys.modelapi.dto.PSSysDBPartDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSSysDBPartService
extends IPSModelService<PSSysDBPart, PSSysDBPartDTO> {
    public List<PSSysDBPart> listByPSSysDBPart(PSSysDBPart var1) throws Exception;

    public PSSysDBPart get(PSSysDBPart var1, String var2, boolean var3) throws Exception;

    public List<PSSysDBPartDTO> listDTOByPSSysDBPart(String var1) throws Exception;

    public List<PSSysDBPart> listByPSSysDashboard(PSSysDashboard var1) throws Exception;

    public PSSysDBPart get(PSSysDashboard var1, String var2, boolean var3) throws Exception;

    public List<PSSysDBPartDTO> listDTOByPSSysDashboard(String var1) throws Exception;

    public List<PSSysDBPart> listAllChild(PSSysDBPart var1) throws Exception;

    public List<PSSysDBPart> listAllByPSSysDashboard(PSSysDashboard var1) throws Exception;

    public List<PSSysDBPartDTO> listAllDTOByPSSysDashboard(String var1) throws Exception;
}

