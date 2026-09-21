/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityException
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.exception.ErrorException
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityException;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysIssue;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysIssueServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysIssueService
extends PSSysIssueServiceBase {
    private static final Log log = LogFactory.getLog(PSSysIssueService.class);

    @Override
    protected void onFillParentInfo_PSDE(PSSysIssue pSSysIssue, PSDataEntity pSDataEntity) throws Exception {
        super.onFillParentInfo_PSDE(pSSysIssue, pSDataEntity);
        pSSysIssue.setPSSystemId(pSDataEntity.getPSSystemId());
        pSSysIssue.setPSSystemName(pSDataEntity.getPSSystemName());
    }

    @Override
    protected void onFillParentInfo_PSSysApp(PSSysIssue pSSysIssue, PSSysApp pSSysApp) throws Exception {
        super.onFillParentInfo_PSSysApp(pSSysIssue, pSSysApp);
        pSSysIssue.setPSSystemId(pSSysApp.getPSSystemId());
        pSSysIssue.setPSSystemName(pSSysApp.getPSSystemName());
    }

    @Override
    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        String string = "DELETE FROM T_SRFPSSYSISSUE WHERE PSSYSTEMID=? ";
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSSystem.getPSSystemId());
        this.getDAO().executeRawSql(null, string, sqlParamList);
    }

    public int getPSSysIssueCountByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        final CallResult callResult = new CallResult();
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                String string = "SELECT COUNT(*) AS CNT FROM T_SRFPSSYSISSUE WHERE PSSYSTEMID=? ";
                SqlParamList sqlParamList = new SqlParamList();
                sqlParamList.addString(pSSystem2.getPSSystemId());
                ArrayList arrayList = PSSysIssueService.this.getDAO().executeRawSelectSql(null, string, sqlParamList);
                callResult.setUserObject((Object)DataObject.getIntegerValue((Object)((IEntity)arrayList.get(0)).get("CNT"), (Integer)0));
            }
        });
        return (Integer)callResult.getUserObject();
    }

    public void logPSSysIssue(PSSysIssue pSSysIssue) throws Exception {
        pSSysIssue.setSessionFactory(this.getSessionFactory());
        this.onTestCreate((IEntity)pSSysIssue);
        if (this.fillEntityKeyValue(pSSysIssue, false)) {
            int n = this.checkKey(pSSysIssue);
            switch (n) {
                case 2: {
                    throw new ErrorException(6, this.getLocalization("CTRL.SERVICE.CHECKKEYSTATE_DELETE", StringHelper.format((String)"\u6570\u636e\u5df2\u7ecf\u88ab\u5220\u9664\uff0c\u65e0\u6cd5\u518d\u6b21\u5efa\u7acb")), (IDataEntity)this.getDEModel());
                }
                case 1: {
                    Iterator iterator = this.getDEModel().getUnionKeyValueDEFields();
                    if (iterator != null) {
                        EntityError entityError = new EntityError();
                        while (iterator.hasNext()) {
                            IDEField iDEField = (IDEField)iterator.next();
                            EntityFieldError entityFieldError = new EntityFieldError();
                            entityFieldError.setFieldName(iDEField.getName());
                            if (this.getWebContext() != null) {
                                entityFieldError.setFieldLogicName(iDEField.getLogicName(this.getWebContext().getLocalization()));
                            } else {
                                entityFieldError.setFieldLogicName(iDEField.getLogicName());
                            }
                            entityFieldError.setErrorType(3);
                            entityFieldError.setErrorInfo(this.getLocalization("CTRL.SERVICE.CHECKFIELDDUPRULE_INFO", "\u503c\u91cd\u590d"));
                            entityError.register(entityFieldError);
                        }
                        throw new EntityException(entityError, this.getLocalization("CTRL.SERVICE.CHECKKEYSTATE_EXIST", StringHelper.format((String)"\u6570\u636e\u5df2\u7ecf\u5b58\u5728\uff0c\u65e0\u6cd5\u518d\u6b21\u5efa\u7acb")), (IDataEntity)this.getDEModel());
                    }
                    throw new ErrorException(6, this.getLocalization("CTRL.SERVICE.CHECKKEYSTATE_EXIST", StringHelper.format((String)"\u6570\u636e\u5df2\u7ecf\u5b58\u5728\uff0c\u65e0\u6cd5\u518d\u6b21\u5efa\u7acb")), (IDataEntity)this.getDEModel());
                }
            }
        }
        final PSSysIssue pSSysIssue2 = pSSysIssue;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysIssueService.this.setLast((IEntity)pSSysIssue2, (IEntity)EMPTYLAST, true);
                PSSysIssueService.this.fillEntityFullInfo((IEntity)pSSysIssue2, true);
                PSSysIssueService.this.onBeforeCreate((IEntity)pSSysIssue2);
                PSSysIssueService.this.internalCreate((IEntity)pSSysIssue2);
                PSSysIssueService.this.onAfterCreate((IEntity)pSSysIssue2);
                PSSysIssueService.this.resetLast((IEntity)pSSysIssue2);
            }
        });
    }
}

