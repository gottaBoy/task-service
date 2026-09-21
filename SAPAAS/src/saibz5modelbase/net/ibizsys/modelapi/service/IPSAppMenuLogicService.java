/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppMenu;
import net.ibizsys.modelapi.domain.PSAppMenuLogic;
import net.ibizsys.modelapi.dto.PSAppMenuLogicDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppMenuLogicService
extends IPSModelService<PSAppMenuLogic, PSAppMenuLogicDTO> {
    public List<PSAppMenuLogic> listByPSAppMenu(PSAppMenu var1) throws Exception;

    public PSAppMenuLogic get(PSAppMenu var1, String var2, boolean var3) throws Exception;

    public List<PSAppMenuLogicDTO> listDTOByPSAppMenu(String var1) throws Exception;
}

