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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysERMapNode;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysERMapNodeServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysERMapNodeService
extends PSSysERMapNodeServiceBase {
    private static final Log log = LogFactory.getLog(PSSysERMapNodeService.class);

    @Override
    protected void onBeforeCreateTemp(PSSysERMapNode pSSysERMapNode) throws Exception {
        PSSysERMapNode pSSysERMapNode2 = new PSSysERMapNode();
        pSSysERMapNode2.setPSSysERMapId(pSSysERMapNode.getPSSysERMapId());
        pSSysERMapNode2.setPSDEId(pSSysERMapNode.getPSDEId());
        if (this.selectTemp(pSSysERMapNode2, true)) {
            throw new ErrorException(7);
        }
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setFunc("COUNT");
        selectField.setAlias("CNT");
        selectContext.addSelectField((ISelectField)selectField);
        selectContext.set("PSSYSERMAPID", (Object)pSSysERMapNode.getPSSysERMapId());
        ArrayList arrayList = this.selectTemp((ISelectCond)selectContext);
        if (DataObject.getIntegerValue((IDataObject)((IDataObject)arrayList.get(0)), (String)"CNT", (int)0) > 50) {
            throw new Exception(StringHelper.format((String)"\u5355\u4e2aER\u56fe\u5b9e\u4f53\u6570\u4e0d\u80fd\u8d85\u8fc750"));
        }
        super.onBeforeCreateTemp(pSSysERMapNode);
    }
}

