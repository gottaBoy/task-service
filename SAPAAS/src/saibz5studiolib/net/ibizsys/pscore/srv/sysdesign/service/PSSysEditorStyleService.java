/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysEditorStyleService
extends PSSysEditorStyleServiceBase {
    private static final Log log = LogFactory.getLog(PSSysEditorStyleService.class);

    @Override
    public String getModelV2Tag(PSSysEditorStyle pSSysEditorStyle) {
        if (!StringHelper.isNullOrEmpty((String)pSSysEditorStyle.getPSEditorTypeId())) {
            if (StringHelper.isNullOrEmpty((String)pSSysEditorStyle.getCodeName())) {
                return pSSysEditorStyle.getPSEditorTypeId();
            }
            return StringHelper.format((String)"%1$s(%2$s)", (Object)pSSysEditorStyle.getPSEditorTypeId(), (Object)pSSysEditorStyle.getCodeName());
        }
        return super.getModelV2Tag(pSSysEditorStyle);
    }
}

