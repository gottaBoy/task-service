/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.wf.demodel;

import net.ibizsys.paas.controller.IRedirectViewController;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEWFModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.wf.demodel.WFWorkListDEModelBase;
import net.ibizsys.psrt.srv.wf.entity.WFWorkList;

public class WFWorkListDEModel
extends WFWorkListDEModelBase {
    private static final long serialVersionUID = -1L;

    @Override
    public String getSDDEViewPDTParam(WFWorkList et, boolean bEnableWF, boolean bWFWorkMode, int nAppType) throws Exception {
        IDEWFModel iDEWF;
        boolean bEnableWorkflow = true;
        if (ViewController.getCurrent() != null && ViewController.getCurrent() instanceof IRedirectViewController) {
            bEnableWorkflow = ((IRedirectViewController)ViewController.getCurrent()).isEnableWorkflow();
        }
        String strDEId = et.getUserData4();
        IDataEntityModel iRealDEModel = DEModelGlobal.getDEModel(strDEId);
        Object iEntity = iRealDEModel.createEntity();
        iEntity.set(iRealDEModel.getKeyDEField().getName(), et.getUserData());
        iRealDEModel.getService(et.getSessionFactory()).get(iEntity);
        boolean bDataInWF = false;
        boolean bWFMode = false;
        if (bEnableWorkflow && (iDEWF = iRealDEModel.testDataInWF((IEntity)iEntity)) != null) {
            bDataInWF = true;
            bWFMode = iDEWF.testUserWFSubmit((IEntity)iEntity, WebContext.getCurrent().getCurUserId(), null);
        }
        String strPDTViewParam = iRealDEModel.getSDDEViewPDTParam(iEntity, bDataInWF, bWFMode, nAppType);
        String strRDMode = "WLRD:" + iRealDEModel.getName() + ":" + strPDTViewParam;
        et.set("srfkey", et.getUserData());
        return strRDMode;
    }

    @Override
    public String getDEViewIdByPDT(String strPreDefinedType, boolean bTryMode) throws Exception {
        if (strPreDefinedType.indexOf("WLRD:") == 0) {
            int nPos = (strPreDefinedType = strPreDefinedType.substring(5)).indexOf(":");
            if (nPos == -1) {
                return null;
            }
            String strDEId = strPreDefinedType.substring(0, nPos);
            strPreDefinedType = strPreDefinedType.substring(nPos + 1);
            IDataEntityModel iRealDEModel = DEModelGlobal.getDEModel(strDEId);
            return iRealDEModel.getDEViewIdByPDT(strPreDefinedType, bTryMode);
        }
        return super.getDEViewIdByPDT(strPreDefinedType, bTryMode);
    }
}

