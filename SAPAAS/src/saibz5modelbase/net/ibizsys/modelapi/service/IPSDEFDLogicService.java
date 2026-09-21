/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSDEFDLogic;
import net.ibizsys.modelapi.domain.PSDEForm;
import net.ibizsys.modelapi.domain.PSDEFormDetail;
import net.ibizsys.modelapi.dto.PSDEFDLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSDEFDLogicService
extends IPSModelService<PSDEFDLogic, PSDEFDLogicDTO> {
    public List<PSDEFDLogic> listByPSDEFDLogic(PSDEFDLogic var1) throws Exception;

    public PSDEFDLogic get(PSDEFDLogic var1, String var2, boolean var3) throws Exception;

    public List<PSDEFDLogicDTO> listDTOByPSDEFDLogic(String var1) throws Exception;

    public List<PSDEFDLogic> listByPSDEFormDetail(PSDEFormDetail var1) throws Exception;

    public PSDEFDLogic get(PSDEFormDetail var1, String var2, boolean var3) throws Exception;

    public List<PSDEFDLogicDTO> listDTOByPSDEFormDetail(String var1) throws Exception;

    public List<PSDEFDLogic> listByPSDEForm(PSDEForm var1) throws Exception;

    public PSDEFDLogic get(PSDEForm var1, String var2, boolean var3) throws Exception;

    public List<PSDEFDLogicDTO> listDTOByPSDEForm(String var1) throws Exception;

    public List<PSDEFDLogic> listAllChild(PSDEFDLogic var1) throws Exception;

    public List<PSDEFDLogic> listAllByPSDEFormDetail(PSDEFormDetail var1) throws Exception;

    public List<PSDEFDLogicDTO> listAllDTOByPSDEFormDetail(String var1) throws Exception;

    public List<PSDEFDLogic> listAllByPSDEForm(PSDEForm var1) throws Exception;

    public List<PSDEFDLogicDTO> listAllDTOByPSDEForm(String var1) throws Exception;
}

