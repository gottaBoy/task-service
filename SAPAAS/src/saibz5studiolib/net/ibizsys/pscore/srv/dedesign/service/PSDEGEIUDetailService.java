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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIUDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridCol;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEGEIUDetailService
extends PSDEGEIUDetailServiceBase {
    private static final Log log = LogFactory.getLog(PSDEGEIUDetailService.class);

    @Override
    protected void importCurXmlModel(PSDEGEIUDetail pSDEGEIUDetail, XmlNode xmlNode) throws Exception {
        String string = xmlNode.getAttribute("PSDEGRIDCOLNAME", "");
        if (!StringHelper.isNullOrEmpty((String)string)) {
            PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
            PSDEGEIUpdate pSDEGEIUpdate = pSDEGEIUDetail.getPSDEGEIUpdate();
            PSDEGridCol pSDEGridCol = new PSDEGridCol();
            pSDEGridCol.setPSDEGridColName(string);
            pSDEGridCol.setPSDEGridId(pSDEGEIUpdate.getPSDEGridId());
            pSDEGridColService.selectTemp(pSDEGridCol, false);
            pSDEGEIUDetail.setPSDEGridColId(pSDEGridCol.getPSDEGridColId());
            xmlNode.setAttribute("PSDEGRIDCOLID", pSDEGridCol.getPSDEGridColId());
        }
        super.importCurXmlModel(pSDEGEIUDetail, xmlNode);
    }
}

