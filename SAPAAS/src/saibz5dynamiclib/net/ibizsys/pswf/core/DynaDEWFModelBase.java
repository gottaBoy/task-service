/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst
 *  net.ibizsys.psrt.srv.dynasys.service.DSDynaViewInstService
 *  net.ibizsys.pswf.core.DEWFModelBase
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaViewInstService;
import net.ibizsys.pswf.core.DEWFModelBase;

public abstract class DynaDEWFModelBase
extends DEWFModelBase {
    public String getWFEditViewPDTParam(IEntity iEntity, boolean bWorkMode, int nAppType) throws Exception {
        boolean bWorkFlow = this.testDataInWF(iEntity);
        if (bWorkFlow) {
            String strDEViewId;
            boolean bMultiForm = this.getDEModel().isEnableMultiForm();
            Object multiFormValue = null;
            if (bMultiForm && (multiFormValue = iEntity.get(this.getDEModel().getMultiFormDEField().getName())) == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u591a\u8868\u5355\u8bc6\u522b\u6570\u636e"));
            }
            Object wfStepValue = iEntity.get(this.getWFStepField());
            int nVer = 1;
            if (!StringHelper.isNullOrEmpty((String)this.getWFVerField())) {
                nVer = DataObject.getIntegerValue((IDataObject)iEntity, (String)this.getWFVerField(), (int)nVer);
            }
            String strPredefinedType = null;
            strPredefinedType = nAppType == 2 ? (multiFormValue == null ? (bWorkMode ? "MOBWFEDITVIEW:" + StringHelper.format((String)"%1$s:%3$sW:%2$s", (Object)this.getName(), (Object)wfStepValue, (Object)(nVer == 1 ? "" : Integer.valueOf(nVer))) : "MOBWFEDITVIEW:" + StringHelper.format((String)"%1$s:D", (Object)this.getName())) : (bWorkMode ? "MOBWFEDITVIEW:" + StringHelper.format((String)"%3$s:%1$s:%4$sW:%2$s", (Object)this.getName(), (Object)wfStepValue, (Object)multiFormValue, (Object)(nVer == 1 ? "" : Integer.valueOf(nVer))) : "MOBWFEDITVIEW:" + StringHelper.format((String)"%2$s:%1$s:D", (Object)this.getName(), (Object)multiFormValue))) : (multiFormValue == null ? (bWorkMode ? "WFEDITVIEW:" + StringHelper.format((String)"%1$s:%3$sW:%2$s", (Object)this.getName(), (Object)wfStepValue, (Object)(nVer == 1 ? "" : Integer.valueOf(nVer))) : "WFEDITVIEW:" + StringHelper.format((String)"%1$s:D", (Object)this.getName())) : (bWorkMode ? "WFEDITVIEW:" + StringHelper.format((String)"%3$s:%1$s:%4$sW:%2$s", (Object)this.getName(), (Object)wfStepValue, (Object)multiFormValue, (Object)(nVer == 1 ? "" : Integer.valueOf(nVer))) : "WFEDITVIEW:" + StringHelper.format((String)"%2$s:%1$s:D", (Object)this.getName(), (Object)multiFormValue)));
            if (bWorkMode && !StringHelper.isNullOrEmpty((String)strPredefinedType) && this.getDEModel() != null && WebContext.getCurrent() != null && !StringHelper.isNullOrEmpty((String)WebContext.getDynaSysInstId()) && StringHelper.isNullOrEmpty((String)(strDEViewId = this.getDEModel().getDEViewIdByPDT(strPredefinedType, true))) && this.getDEModel().getSystemModel().getDynaSystemSetting() != null) {
                DSDynaViewInstService psDynaViewInstService = (DSDynaViewInstService)ServiceGlobal.getService(DSDynaViewInstService.class);
                DSDynaViewInst dsDynaViewInst = new DSDynaViewInst();
                dsDynaViewInst.setDynaSysInstId(WebContext.getDynaSysInstId());
                dsDynaViewInst.setDEWFId(this.getId());
                if (nVer == 1) {
                    dsDynaViewInst.setPDVTParam(StringHelper.format((String)"%1$s", (Object)wfStepValue));
                } else {
                    dsDynaViewInst.setPDVTParam(StringHelper.format((String)"%1$s@%2$s", (Object)wfStepValue, (Object)nVer));
                }
                if (nAppType == 2) {
                    dsDynaViewInst.setPredefinedViewType("MOBWFEDITVIEW");
                } else {
                    dsDynaViewInst.setPredefinedViewType("WFEDITVIEW");
                }
                if (psDynaViewInstService.select((IEntity)dsDynaViewInst, true) && dsDynaViewInst.getDSDynaView() != null && !StringHelper.isNullOrEmpty((String)dsDynaViewInst.getDSDynaView().getPredefinedViewType())) {
                    if (!StringHelper.isNullOrEmpty((String)dsDynaViewInst.getDSDynaView().getPDVTParam())) {
                        return StringHelper.format((String)"%1$s:%2$s", (Object)dsDynaViewInst.getDSDynaView().getPredefinedViewType(), (Object)dsDynaViewInst.getDSDynaView().getPDVTParam());
                    }
                    return dsDynaViewInst.getDSDynaView().getPredefinedViewType();
                }
            }
            return strPredefinedType;
        }
        return null;
    }
}

