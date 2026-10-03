/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.CloneSessionManager
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.CloneSessionManager;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLNParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelLogic;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSPanelLogicNodeService
extends PSPanelLogicNodeServiceBase {
    private static final Log log = LogFactory.getLog(PSPanelLogicNodeService.class);

    @Override
    protected void onAfterGetDraftTemp(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        String string = pSPanelLogicNode.getCodeName();
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.fillPSPanelLogicNodeDefaultCodeName(pSPanelLogicNode);
        }
        super.onAfterGetDraftTemp(pSPanelLogicNode);
    }

    protected void fillPSPanelLogicNodeDefaultCodeName(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        int n = 1;
        String string = pSPanelLogicNode.getLogicNodeType();
        String string2 = string;
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return;
        }
        string2 = string2.toLowerCase();
        PSSysViewPanelLogic pSSysViewPanelLogic = new PSSysViewPanelLogic();
        pSSysViewPanelLogic.setPSSysViewPanelLogicId(pSPanelLogicNode.getPSSysViewPanelLogicId());
        ArrayList<PSPanelLogicNode> arrayList = null;
        arrayList = pSSysViewPanelLogic.getPSSysViewPanelLogicId().indexOf("SRFTEMPKEY:") == 0 ? this.selectTempByPSSysViewPanelLogic(pSSysViewPanelLogic) : this.selectByPSSysViewPanelLogic(pSSysViewPanelLogic);
        HashMap<String, PSPanelLogicNode> hashMap = new HashMap<String, PSPanelLogicNode>();
        String object;
        Iterator<PSPanelLogicNode> objectIterator = arrayList.iterator();
        while (objectIterator.hasNext()) {
            PSPanelLogicNode pSPanelLogicNode2 = objectIterator.next();
            hashMap.put(pSPanelLogicNode2.getCodeName().toLowerCase(), pSPanelLogicNode2);
        }
        while (true) {
            if (!hashMap.containsKey(object = StringHelper.format((String)"%1$s%2$s", (Object)string2, (Object)(n == 0 ? "" : Integer.valueOf(n))))) break;
            ++n;
        }
        object = ((String)object).substring(0, 1).toUpperCase() + ((String)object).substring(1);
        pSPanelLogicNode.setCodeName((String)object);
    }

    protected boolean onFillEntityKeyValue(PSPanelLogicNode pSPanelLogicNode, boolean bl) throws Exception {
        if (StringHelper.compare((String)pSPanelLogicNode.getLogicNodeType(), (String)"BEGIN", (boolean)true) == 0) {
            pSPanelLogicNode.setPSPanelLogicNodeId(pSPanelLogicNode.getPSSysViewPanelLogicId());
            return true;
        }
        return super.onFillEntityKeyValue(pSPanelLogicNode, bl);
    }

    @Override
    protected void importCurXmlModel(PSPanelLogicNode pSPanelLogicNode, XmlNode xmlNode) throws Exception {
        PSPanelLogicParamService pSPanelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        String string = xmlNode.getAttribute("PSPANELLOGICPARAMNAME", "");
        if (!StringHelper.isNullOrEmpty((String)string)) {
            PSPanelLogicParam pSPanelLogicParam = new PSPanelLogicParam();
            pSPanelLogicParam.setPSPanelLogicParamName(string);
            pSPanelLogicParam.setPSSysViewPanelLogicId(pSPanelLogicNode.getPSSysViewPanelLogicId());
            pSPanelLogicParamService.selectTemp(pSPanelLogicParam, false);
            pSPanelLogicNode.setPSPanelLogicParamId(pSPanelLogicParam.getPSPanelLogicParamId());
            xmlNode.setAttribute("PSPANELLOGICPARAMID", pSPanelLogicParam.getPSPanelLogicParamId());
        }
        super.importCurXmlModel(pSPanelLogicNode, xmlNode);
    }

    @Override
    protected ArrayList<PSPanelLNParam> updateRelatedDataTempMajor_removePSPanelLNParam(PSPanelLogicNode pSPanelLogicNode, PSPanelLogicNode pSPanelLogicNode2) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            return null;
        }
        return super.updateRelatedDataTempMajor_removePSPanelLNParam(pSPanelLogicNode, pSPanelLogicNode2);
    }

    @Override
    protected void updateRelatedDataTempMajor_updatePSPanelLNParam(PSPanelLogicNode pSPanelLogicNode, PSPanelLogicNode pSPanelLogicNode2, ArrayList<PSPanelLNParam> arrayList) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            return;
        }
        super.updateRelatedDataTempMajor_updatePSPanelLNParam(pSPanelLogicNode, pSPanelLogicNode2, arrayList);
    }

    @Override
    protected void getRelatedDataTempMajor_PSPanelLNParam(PSPanelLogicNode pSPanelLogicNode) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            return;
        }
        super.getRelatedDataTempMajor_PSPanelLNParam(pSPanelLogicNode);
    }
}

