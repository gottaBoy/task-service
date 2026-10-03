/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdevstudio.service;

import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWDEDRItem;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSUWDEDRItemServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSUWDEDRItemService
extends PSUWDEDRItemServiceBase {
    private static final Log log = LogFactory.getLog(PSUWDEDRItemService.class);

    @Override
    protected void onBeforeCreate(PSUWDEDRItem pSUWDEDRItem) throws Exception {
        if (WebContext.getCurrent() != null && WebContext.getReferData() != null) {
            String string = WebContext.getReferData().optString("srfdeid");
            String string2 = WebContext.getReferData().optString("srfkey");
            if (!StringHelper.isNullOrEmpty((String)string) && !StringHelper.isNullOrEmpty((String)string2)) {
                IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)string);
                if (StringHelper.compare((String)iDataEntityModel.getName(), (String)"PSDEFORMDETAIL", (boolean)true) == 0) {
                    PSDEFormDetail pSDEFormDetail = new PSDEFormDetail();
                    pSDEFormDetail.setPSDEFormDetailId(string2);
                    PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
                    if (pSDEFormDetailService.autoGet(pSDEFormDetail, true) && pSDEFormDetail.getPSDEForm() != null) {
                        pSUWDEDRItem.setPSDEId(pSDEFormDetail.getPSDEForm().getPSDEId());
                    }
                } else if (StringHelper.compare((String)iDataEntityModel.getName(), (String)"PSDEDRDETAIL", (boolean)true) == 0) {
                    PSDEDRDetail pSDEDRDetail = new PSDEDRDetail();
                    pSDEDRDetail.setPSDEDRDetailId(string2);
                    PSDEDRDetailService pSDEDRDetailService = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
                    if (pSDEDRDetailService.autoGet(pSDEDRDetail, true) && pSDEDRDetail.getPSDEDR() != null) {
                        pSUWDEDRItem.setPSDEId(pSDEDRDetail.getPSDEDR().getPSDEId());
                    }
                }
            }
        }
        super.onBeforeCreate(pSUWDEDRItem);
    }

    @Override
    public Object getDataContextValue(PSUWDEDRItem pSUWDEDRItem, String string, IDataContextParam iDataContextParam) throws Exception {
        if (iDataContextParam != null) {
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEVIEWBASE", (boolean)true) == 0 && StringHelper.compare((String)string, (String)"psdeid", (boolean)true) == 0) {
                return pSUWDEDRItem.getViewPSDEId();
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDER", (boolean)true) == 0 && StringHelper.compare((String)string, (String)"MAJORPSDEID", (boolean)true) == 0) {
                return pSUWDEDRItem.getPSDEId();
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDER", (boolean)true) == 0 && StringHelper.compare((String)string, (String)"MINORPSDEID", (boolean)true) == 0) {
                return pSUWDEDRItem.getViewPSDEId();
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDER", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"SYSPSDERNAME", (boolean)true) == 0) {
                return pSUWDEDRItem.getViewPSDEId();
            }
        }
        return super.getDataContextValue(pSUWDEDRItem, string, iDataContextParam);
    }

    @Override
    protected void onFinishStepSelectView(PSUWDEDRItem pSUWDEDRItem) throws Exception {
        PSUWDEDRItem pSUWDEDRItem2 = new PSUWDEDRItem();
        pSUWDEDRItem2.setPSUWDEDRItemId(pSUWDEDRItem.getPSUWDEDRItemId());
        this.get(pSUWDEDRItem2);
        PSDER pSDER = null;
        if (!StringHelper.isNullOrEmpty((String)pSUWDEDRItem2.getPSDEId()) && !StringHelper.isNullOrEmpty((String)pSUWDEDRItem.getViewPSDEId())) {
            pSDER = new PSDER();
            pSDER.setSessionFactory(this.getSessionFactory());
            pSDER.setDERType("DER1N");
            pSDER.setMajorPSDEId(pSUWDEDRItem2.getPSDEId());
            pSDER.setMinorPSDEId(pSUWDEDRItem.getViewPSDEId());
            if (!pSDER.select(true)) {
                pSDER = null;
            }
        }
        if (pSDER != null) {
            pSUWDEDRItem.setDRItemType("DER1N");
            pSUWDEDRItem.setPSDERId(pSDER.getPSDERId());
            pSUWDEDRItem.setPSDERName(pSDER.getPSDERName());
        }
        pSUWDEDRItem.setPSDEDRItemName(pSUWDEDRItem.getPSDEViewBaseName());
        if (!StringHelper.isNullOrEmpty((String)pSUWDEDRItem2.getPSDEId())) {
            PSDEDRItem pSDEDRItem;
            int n = 0;
            do {
                pSDEDRItem = new PSDEDRItem();
                pSDEDRItem.setPSDEId(pSUWDEDRItem2.getPSDEId());
                if (++n == 1) {
                    pSDEDRItem.setPSDEDRItemName(pSUWDEDRItem.getPSDEViewBaseName());
                } else {
                    pSDEDRItem.setPSDEDRItemName(StringHelper.format((String)"%1$s\uff08%2$s\uff09", (Object)pSUWDEDRItem.getPSDEViewBaseName(), (Object)(n == 1 ? "" : Integer.valueOf(n))));
                }
                pSDEDRItem.setSessionFactory(this.getSessionFactory());
            } while (pSDEDRItem.select(true));
            pSUWDEDRItem.setPSDEDRItemName(pSDEDRItem.getPSDEDRItemName());
        }
        this.update(pSUWDEDRItem);
    }

    @Override
    protected void onFinishStepSelectType(PSUWDEDRItem pSUWDEDRItem) throws Exception {
        this.update(pSUWDEDRItem);
    }

    @Override
    protected void onFinishWizard(PSUWDEDRItem pSUWDEDRItem) throws Exception {
        this.get(pSUWDEDRItem);
        PSDEDRItem pSDEDRItem = new PSDEDRItem();
        pSUWDEDRItem.copyTo((IDataObject)pSDEDRItem, false);
        pSDEDRItem.setSessionFactory(this.getSessionFactory());
        if (StringHelper.compare((String)pSDEDRItem.getDRItemType(), (String)"DER1N", (boolean)true) != 0) {
            if (StringHelper.compare((String)pSDEDRItem.getDRItemType(), (String)"SYSDER1N", (boolean)true) == 0) {
                pSDEDRItem.setPSDERId(pSUWDEDRItem.getSysPSDERId());
                pSDEDRItem.setPSDERName(pSUWDEDRItem.getSysPSDERName());
            } else {
                pSDEDRItem.setPSDERId(null);
                pSDEDRItem.setPSDERName(null);
            }
        }
        pSDEDRItem.create();
        pSUWDEDRItem.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
        pSUWDEDRItem.setPSDEDRItemName(pSDEDRItem.getPSDEDRItemName());
        this.update(pSUWDEDRItem);
    }
}

