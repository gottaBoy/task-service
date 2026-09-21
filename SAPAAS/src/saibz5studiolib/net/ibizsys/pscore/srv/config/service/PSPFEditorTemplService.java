/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.config.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.EditorContainersCodeListModel;
import net.ibizsys.pscore.srv.config.entity.PSPFEditorTempl;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.service.PSPFEditorTemplServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSPFEditorTemplService
extends PSPFEditorTemplServiceBase {
    private static final Log log = LogFactory.getLog(PSPFEditorTemplService.class);

    protected boolean onFillEntityKeyValue(PSPFEditorTempl pSPFEditorTempl, boolean bl) throws Exception {
        if (!bl) {
            PSPFStyle pSPFStyle = pSPFEditorTempl.getPSPFStyle();
            String string = pSPFEditorTempl.getContainerType();
            pSPFEditorTempl.setPSPFId(pSPFStyle.getPSPFId());
            pSPFEditorTempl.setPSPFName(pSPFStyle.getPSPFName());
            if (StringHelper.isNullOrEmpty((String)pSPFEditorTempl.getPSPFStyleId())) {
                pSPFEditorTempl.setPSPFEditorTemplId(KeyValueHelper.genUniqueId((String)pSPFEditorTempl.getPSPFId(), (String)pSPFEditorTempl.getPSEditorTypeId(), (String)string, (String)pSPFEditorTempl.getPSPFPubCodeId()));
            } else {
                pSPFEditorTempl.setPSPFEditorTemplId(KeyValueHelper.genUniqueId((String)pSPFEditorTempl.getPSPFId(), (String)pSPFEditorTempl.getPSPFStyleId(), (String)pSPFEditorTempl.getPSEditorTypeId(), (String)string, (String)pSPFEditorTempl.getPSPFPubCodeId()));
            }
            return true;
        }
        return super.onFillEntityKeyValue((IEntity)pSPFEditorTempl, bl);
    }

    @Override
    protected void onBeforeCreate(PSPFEditorTempl pSPFEditorTempl) throws Exception {
        String string = pSPFEditorTempl.getContainerType();
        EditorContainersCodeListModel editorContainersCodeListModel = (EditorContainersCodeListModel)CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.EditorContainersCodeListModel");
        String string2 = editorContainersCodeListModel.getCodeListText(string, false);
        if (StringHelper.isNullOrEmpty((String)pSPFEditorTempl.getPSPFStyleId())) {
            String string3 = StringHelper.format((String)"%1$s/%2$s/%3$s/%4$s", (Object)pSPFEditorTempl.getPSPFName(), (Object)pSPFEditorTempl.getPSEditorTypeName(), (Object)string2, (Object)pSPFEditorTempl.getPSPFPubCodeName());
            pSPFEditorTempl.setPSPFEditorTemplName(string3);
        } else {
            String string4 = StringHelper.format((String)"%1$s/%2$s/%3$s/%4$s/%5$s", (Object)pSPFEditorTempl.getPSPFName(), (Object)pSPFEditorTempl.getPSPFStyleName(), (Object)pSPFEditorTempl.getPSEditorTypeName(), (Object)string2, (Object)pSPFEditorTempl.getPSPFPubCodeName());
            pSPFEditorTempl.setPSPFEditorTemplName(string4);
        }
        super.onBeforeCreate(pSPFEditorTempl);
    }
}

