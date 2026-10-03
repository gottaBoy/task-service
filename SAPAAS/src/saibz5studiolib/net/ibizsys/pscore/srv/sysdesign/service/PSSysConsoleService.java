/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.SqlParam
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysConsole;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysConsoleServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysConsoleService
extends PSSysConsoleServiceBase {
    private static final Log log = LogFactory.getLog(PSSysConsoleService.class);

    @Override
    protected void onResetLog(PSSysConsole pSSysConsole) throws Exception {
        String string = "";
        if (WebContext.getCurrent() != null) {
            string = WebContext.getCurrent().getAppDataValue("pssystemid");
        }
        if (!StringHelper.isNullOrEmpty((String)string)) {
            String string2 = "DELETE FROM T_SRFPSSYSCONSOLE WHERE PSSYSTEMID=? ";
            SqlParamList sqlParamList = new SqlParamList();
            sqlParamList.add(new SqlParam((Object)string, 25));
            this.getDAO().executeRawSql(null, string2, sqlParamList);
        }
    }

    @Override
    protected void onFixIssue(PSSysConsole pSSysConsole) throws Exception {
        if (!pSSysConsole.isFullEntity()) {
            this.get(pSSysConsole);
        }
        if (DataObject.getIntegerValue((Object)pSSysConsole.getFixState(), (Integer)0) == 1) {
            String string = pSSysConsole.getFixDEName();
            String string2 = pSSysConsole.getFixDEAction();
            String string3 = pSSysConsole.getFixDataKey();
            if (StringHelper.isNullOrEmpty((String)string)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u4fee\u590d\u5b9e\u4f53\u540d\u79f0");
            }
            if (StringHelper.isNullOrEmpty((String)string2)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u4fee\u590d\u5b9e\u4f53\u884c\u4e3a");
            }
            if (StringHelper.isNullOrEmpty((String)string3)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u4fee\u590d\u6570\u636e\u6807\u8bc6");
            }
            IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)string);
            IEntity iEntity = iDataEntityModel.createEntity();
            iEntity.set(iDataEntityModel.getKeyDEField().getName(), (Object)string3);
            iDataEntityModel.getService(this.getSessionFactory()).executeAction(string2, iEntity);
            String string4 = pSSysConsole.getPSSysConsoleId();
            pSSysConsole.reset();
            pSSysConsole.setPSSysConsoleId(string4);
            pSSysConsole.setFixState(2);
            this.update(pSSysConsole);
        }
    }
}

