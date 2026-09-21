/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.exception.ErrorException
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.util.SimpleWebContext
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;

public class PSCommonModelDataCtrl
extends PSDEDataCtrl {
    public CallResult Remove(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            SimpleWebContext simpleWebContext = new SimpleWebContext();
            simpleWebContext.setSessionValue("SRFPERSONID", (Object)this.getWebContext().getCurUserId());
            simpleWebContext.setSessionValue("SRFUSERID", (Object)this.getWebContext().getCurUserId());
            simpleWebContext.setSessionValue("SRFUSERNAME", (Object)this.getWebContext().getCurUserName());
            final IDataEntityModel iDEModel = DEModelGlobal.getDEModel((String)this.GetDEHelper().getName());
            final IEntity iEntity = iDEModel.createEntity();
            PSDEDataCtrl.convertEntity2(dataEntity, iEntity);
            ServiceWorkHelper.getInstance((IWebContext)simpleWebContext).execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    IService iService = iDEModel.getService();
                    iService.remove(iEntity);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            if (ex instanceof ErrorException) {
                ErrorException errorException = (ErrorException)ex;
                callResult.setRetCode(errorException.getErrorCode());
            }
            return callResult;
        }
    }

    public CallResult Save(boolean bInsert, String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            SimpleWebContext simpleWebContext = new SimpleWebContext();
            simpleWebContext.setSessionValue("SRFPERSONID", (Object)this.getWebContext().getCurUserId());
            simpleWebContext.setSessionValue("SRFUSERID", (Object)this.getWebContext().getCurUserId());
            simpleWebContext.setSessionValue("SRFUSERNAME", (Object)this.getWebContext().getCurUserName());
            final IDataEntityModel iDEModel = DEModelGlobal.getDEModel((String)this.GetDEHelper().getName());
            final IEntity iEntity = iDEModel.createEntity();
            PSDEDataCtrl.convertEntity2(dataEntity, iEntity);
            final boolean bInsert2 = bInsert;
            ServiceWorkHelper.getInstance((IWebContext)simpleWebContext).execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    IService iService = iDEModel.getService();
                    if (bInsert2) {
                        iService.create(iEntity);
                    } else {
                        iService.update(iEntity);
                    }
                }
            });
            PSDEDataCtrl.convertEntity(iEntity, dataEntity);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            if (ex instanceof ErrorException) {
                ErrorException errorException = (ErrorException)ex;
                callResult.setRetCode(errorException.getErrorCode());
            }
            return callResult;
        }
    }

    public CallResult Save(boolean bInsert, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            IDataEntityModel iDEModel = DEModelGlobal.getDEModel((String)this.GetDEHelper().getName());
            IService iService = iDEModel.getService();
            IEntity iEntity = iDEModel.createEntity();
            PSDEDataCtrl.convertEntity2(dataEntity, iEntity);
            if (bInsert) {
                iService.create(iEntity);
            } else {
                iService.update(iEntity);
            }
            PSDEDataCtrl.convertEntity(iEntity, dataEntity);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            if (ex instanceof ErrorException) {
                ErrorException errorException = (ErrorException)ex;
                callResult.setRetCode(errorException.getErrorCode());
            }
            return callResult;
        }
    }
}

