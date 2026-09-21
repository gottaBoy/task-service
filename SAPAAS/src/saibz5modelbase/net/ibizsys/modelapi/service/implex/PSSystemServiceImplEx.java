/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.implex;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.service.impl.PSSystemServiceImpl;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceSession;
import org.springframework.util.StringUtils;

public class PSSystemServiceImplEx
extends PSSystemServiceImpl {
    @Override
    public List<PSSystem> listAll() throws Exception {
        PSModelServiceSession psModelServiceSession = PSModelServiceSession.getCurrent();
        String strModelTag = String.format("%1$s%2$s%3$s.json", psModelServiceSession.getPSModelFolderPath(), File.separator, this.getModelName());
        IPSModel iPSModel = psModelServiceSession.getPSModel(this.getModelName(), strModelTag);
        if (iPSModel != null && !(iPSModel instanceof PSSystem)) {
            iPSModel = null;
        }
        if (iPSModel == null) {
            PSSystem psSystem = new PSSystem();
            psSystem.setSrfFilePath(strModelTag);
            psModelServiceSession.setPSModel(this.getModelName(), strModelTag, psSystem);
            iPSModel = psSystem;
        }
        ArrayList<PSSystem> list = new ArrayList<PSSystem>();
        list.add((PSSystem)iPSModel);
        return list;
    }

    @Override
    public PSSystem get(String strKey, boolean bTryMode) throws Exception {
        if (StringUtils.hasLength((String)strKey)) {
            if (bTryMode) {
                return null;
            }
            throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u8def\u5f84\u4e3a[%1$s]", strKey));
        }
        PSModelServiceSession psModelServiceSession = PSModelServiceSession.getCurrent();
        String strModelTag = String.format("%1$s%2$s%3$s.json", psModelServiceSession.getPSModelFolderPath(), File.separator, this.getModelName());
        IPSModel iPSModel = psModelServiceSession.getPSModel(this.getModelName(), strModelTag);
        if (iPSModel != null && !(iPSModel instanceof PSSystem)) {
            iPSModel = null;
        }
        if (iPSModel == null) {
            PSSystem psSystem = new PSSystem();
            psSystem.setSrfFilePath(strModelTag);
            psModelServiceSession.setPSModel(this.getModelName(), strModelTag, psSystem);
            iPSModel = psSystem;
        }
        return (PSSystem)iPSModel;
    }
}

