/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.service;

import java.util.List;
import net.ibizsys.modelapi.domain.PSAppStoryBoard;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppStoryBoardDTO;
import net.ibizsys.modelapi.util.IPSModelService;

public interface IPSAppStoryBoardService
extends IPSModelService<PSAppStoryBoard, PSAppStoryBoardDTO> {
    public List<PSAppStoryBoard> listByPSSysApp(PSSysApp var1) throws Exception;

    public PSAppStoryBoard get(PSSysApp var1, String var2, boolean var3) throws Exception;

    public List<PSAppStoryBoardDTO> listDTOByPSSysApp(String var1) throws Exception;
}

