/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.psrt.srv.common.service;

import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.psrt.srv.common.entity.CodeList;
import net.ibizsys.psrt.srv.common.service.CodeListServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class CodeListService
extends CodeListServiceBase {
    private static final Log log = LogFactory.getLog(CodeListService.class);

    @Override
    protected void onRefreshModel(CodeList codeList) throws Exception {
        ICodeListModel iCodeListModel = (ICodeListModel)CodeListGlobal.getCodeList(codeList.getCodeListId(), this.getSessionFactory());
        iCodeListModel.refresh();
    }
}

