/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
 *  net.ibizsys.paas.exception.ErrorException
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUCMapNode;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUCMapNodeServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysUCMapNodeService
extends PSSysUCMapNodeServiceBase {
    private static final Log log = LogFactory.getLog(PSSysUCMapNodeService.class);

    @Override
    protected void onBeforeCreateTemp(PSSysUCMapNode pSSysUCMapNode) throws Exception {
        PSSysUCMapNode pSSysUCMapNode2 = new PSSysUCMapNode();
        pSSysUCMapNode2.setPSSysUCMapId(pSSysUCMapNode.getPSSysUCMapId());
        if (!StringHelper.isNullOrEmpty((String)pSSysUCMapNode.getPSSysActorId())) {
            pSSysUCMapNode2.setPSSysActorId(pSSysUCMapNode.getPSSysActorId());
            if (this.selectTemp(pSSysUCMapNode2, true)) {
                throw new ErrorException(7);
            }
            if (StringHelper.isNullOrEmpty((String)pSSysUCMapNode.getPSSysActorName())) {
                pSSysUCMapNode.setPSSysUCMapNodeName(pSSysUCMapNode.getPSSysActor().getPSSysActorName());
            } else {
                pSSysUCMapNode.setPSSysUCMapNodeName(pSSysUCMapNode.getPSSysActorName());
            }
        } else if (!StringHelper.isNullOrEmpty((String)pSSysUCMapNode.getPSSysUserCaseId())) {
            pSSysUCMapNode2.setPSSysActorId(pSSysUCMapNode.getPSSysUserCaseId());
            if (this.selectTemp(pSSysUCMapNode2, true)) {
                throw new ErrorException(7);
            }
            if (StringHelper.isNullOrEmpty((String)pSSysUCMapNode.getPSSysUserCaseName())) {
                pSSysUCMapNode.setPSSysUCMapNodeName(pSSysUCMapNode.getPSSysUserCase().getPSSysUserCaseName());
            } else {
                pSSysUCMapNode.setPSSysUCMapNodeName(pSSysUCMapNode.getPSSysUserCaseName());
            }
        } else {
            throw new ErrorException(5);
        }
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setFunc("COUNT");
        selectField.setAlias("CNT");
        selectContext.addSelectField((ISelectField)selectField);
        selectContext.set("PSSYSUCMAPID", (Object)pSSysUCMapNode.getPSSysUCMapId());
        ArrayList arrayList = this.selectTemp((ISelectCond)selectContext);
        if (DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0) > 50) {
            throw new Exception(StringHelper.format((String)"\u5355\u4e2a\u7528\u4f8b\u56fe\u56fe\u4f8b\u6570\u4e0d\u80fd\u8d85\u8fc750"));
        }
        super.onBeforeCreateTemp(pSSysUCMapNode);
    }
}

