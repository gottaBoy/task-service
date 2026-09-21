/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.codelist.DLValueOPCodeListModel;
import net.ibizsys.pscore.srv.codelist.GroupCondCodeListModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLLCond;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParam;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLLCondServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSPanelLLCondService
extends PSPanelLLCondServiceBase {
    private static final Log log = LogFactory.getLog(PSPanelLLCondService.class);

    @Override
    protected void onBeforeCreateTemp(PSPanelLLCond pSPanelLLCond) throws Exception {
        pSPanelLLCond.setPSPanelLLCondName(this.calcPSPanelLLCondName(pSPanelLLCond));
        super.onBeforeCreateTemp(pSPanelLLCond);
    }

    @Override
    protected void onBeforeUpdateTemp(PSPanelLLCond pSPanelLLCond) throws Exception {
        pSPanelLLCond.setPSPanelLLCondName(this.calcPSPanelLLCondName(pSPanelLLCond));
        super.onBeforeUpdateTemp(pSPanelLLCond);
    }

    protected String calcPSPanelLLCondName(PSPanelLLCond pSPanelLLCond) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        if (StringHelper.compare((String)pSPanelLLCond.getLogicType(), (String)"SINGLE", (boolean)true) == 0) {
            if (StringHelper.isNullOrEmpty((String)pSPanelLLCond.getDstPSPanelLPName())) {
                return "?";
            }
            stringBuilderEx.append("%1$s", (Object)pSPanelLLCond.getDstPSPanelLPName());
            if (StringHelper.isNullOrEmpty((String)pSPanelLLCond.getDstFieldName())) {
                return "?";
            }
            stringBuilderEx.append("[%1$s]", (Object)pSPanelLLCond.getDstFieldName());
            if (StringHelper.isNullOrEmpty((String)pSPanelLLCond.getCondOp())) {
                return "?";
            }
            stringBuilderEx.append(" %1$s ", (Object)DLValueOPCodeListModel.getInstance().getCodeListText(pSPanelLLCond.getCondOp(), true));
            if (!StringHelper.isNullOrEmpty((String)pSPanelLLCond.getCondValue())) {
                stringBuilderEx.append("(%1$s)", (Object)pSPanelLLCond.getCondValue());
            }
            return stringBuilderEx.toString();
        }
        if (StringHelper.compare((String)pSPanelLLCond.getLogicType(), (String)"GROUP", (boolean)true) == 0) {
            if (StringHelper.isNullOrEmpty((String)pSPanelLLCond.getGroupOP())) {
                return "?";
            }
            stringBuilderEx.append("%1$s", (Object)GroupCondCodeListModel.getInstance().getCodeItemByText(pSPanelLLCond.getGroupOP(), true));
            if (pSPanelLLCond.getGroupNotFlag() != null && pSPanelLLCond.getGroupNotFlag() == 1) {
                stringBuilderEx.append("[\u53d6\u53cd]");
            }
            return stringBuilderEx.toString();
        }
        return "?";
    }

    @Override
    protected void importCurXmlModel(PSPanelLLCond pSPanelLLCond, XmlNode xmlNode) throws Exception {
        PSPanelLogicParamService pSPanelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        String string = xmlNode.getAttribute("DSTPSPANELLPNAME", "");
        if (!StringHelper.isNullOrEmpty((String)string)) {
            PSPanelLogicParam pSPanelLogicParam = new PSPanelLogicParam();
            pSPanelLogicParam.setPSPanelLogicParamName(string);
            pSPanelLogicParam.setPSSysViewPanelLogicId(pSPanelLLCond.getPSPanelLogicLink().getPSSysViewPanelLogicId());
            pSPanelLogicParamService.selectTemp(pSPanelLogicParam, false);
            pSPanelLLCond.setDstPSPanelLPId(pSPanelLogicParam.getPSPanelLogicParamId());
            xmlNode.setAttribute("DSTPSPANELLPID", pSPanelLogicParam.getPSPanelLogicParamId());
        }
        super.importCurXmlModel(pSPanelLLCond, xmlNode);
    }
}

