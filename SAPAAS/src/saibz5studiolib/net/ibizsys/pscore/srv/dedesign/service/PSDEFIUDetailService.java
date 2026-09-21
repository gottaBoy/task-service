/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFIUDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEFIUDetailService
extends PSDEFIUDetailServiceBase {
    private static final Log log = LogFactory.getLog(PSDEFIUDetailService.class);

    @Override
    protected void onFillParentInfo_PSDEFIUpdate(PSDEFIUDetail pSDEFIUDetail, PSDEFIUpdate pSDEFIUpdate) throws Exception {
        super.onFillParentInfo_PSDEFIUpdate(pSDEFIUDetail, pSDEFIUpdate);
        pSDEFIUDetail.setPSDEFormId(pSDEFIUpdate.getPSDEFormId());
        pSDEFIUDetail.setPSDEFormName(pSDEFIUpdate.getPSDEFormName());
    }

    @Override
    protected void onFillParentInfo_PSDEFormDetail(PSDEFIUDetail pSDEFIUDetail, PSDEFormDetail pSDEFormDetail) throws Exception {
        super.onFillParentInfo_PSDEFormDetail(pSDEFIUDetail, pSDEFormDetail);
        pSDEFIUDetail.setPSDEFormId(pSDEFormDetail.getPSDEFormId());
        pSDEFIUDetail.setPSDEFormName(pSDEFormDetail.getPSDEFormName());
    }

    @Override
    protected void importCurXmlModel(PSDEFIUDetail pSDEFIUDetail, XmlNode xmlNode) throws Exception {
        String string = xmlNode.getAttribute("PSDEFORMDETAILNAME", "");
        if (!StringHelper.isNullOrEmpty((String)string)) {
            PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
            PSDEFIUpdate pSDEFIUpdate = pSDEFIUDetail.getPSDEFIUpdate();
            PSDEFormDetail pSDEFormDetail = new PSDEFormDetail();
            pSDEFormDetail.setPSDEFormDetailName(string);
            pSDEFormDetail.setPSDEFormId(pSDEFIUpdate.getPSDEFormId());
            pSDEFormDetailService.selectTemp(pSDEFormDetail, false);
            pSDEFIUDetail.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
            xmlNode.setAttribute("PSDEFORMDETAILID", pSDEFormDetail.getPSDEFormDetailId());
        }
        super.importCurXmlModel(pSDEFIUDetail, xmlNode);
    }
}

