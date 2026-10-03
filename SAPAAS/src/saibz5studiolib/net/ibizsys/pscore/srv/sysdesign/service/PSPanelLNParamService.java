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
import net.ibizsys.pscore.srv.codelist.PanelLogicNodeSrcTypeCodeListModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLNParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParamBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLNParamServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSPanelLNParamService
extends PSPanelLNParamServiceBase {
    private static final Log log = LogFactory.getLog(PSPanelLNParamService.class);

    @Override
    protected void onBeforeCreateTemp(PSPanelLNParam pSPanelLNParam) throws Exception {
        super.onBeforeCreateTemp(pSPanelLNParam);
        if (StringHelper.compare((String)pSPanelLNParam.getParamType(), (String)"COPYMODEL", (boolean)true) == 0 && StringHelper.compare((String)pSPanelLNParam.getDstPSPanelLPId(), (String)pSPanelLNParam.getSrcPSPanelLPId(), (boolean)false) == 0) {
            throw new Exception("\u3010\u62f7\u8d1d\u6a21\u578b\u3011\u6e90\u53c2\u6570\u4e0e\u76ee\u6807\u53c2\u6570\u4e0d\u80fd\u76f8\u540c");
        }
        pSPanelLNParam.setPSPanelLNParamName(this.calcPSPanelLNParamName(pSPanelLNParam));
    }

    @Override
    protected void onBeforeUpdateTemp(PSPanelLNParam pSPanelLNParam) throws Exception {
        super.onBeforeUpdateTemp(pSPanelLNParam);
        if (StringHelper.compare((String)pSPanelLNParam.getParamType(), (String)"COPYMODEL", (boolean)true) == 0 && StringHelper.compare((String)pSPanelLNParam.getDstPSPanelLPId(), (String)pSPanelLNParam.getSrcPSPanelLPId(), (boolean)false) == 0) {
            throw new Exception("\u3010\u62f7\u8d1d\u6a21\u578b\u3011\u6e90\u53c2\u6570\u4e0e\u76ee\u6807\u53c2\u6570\u4e0d\u80fd\u76f8\u540c");
        }
        pSPanelLNParam.setPSPanelLNParamName(this.calcPSPanelLNParamName(pSPanelLNParam));
    }

    protected String calcPSPanelLNParamName(PSPanelLNParam pSPanelLNParam) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        String string = pSPanelLNParam.getParamType();
        if (StringHelper.compare((String)string, (String)"RESETMODEL", (boolean)true) == 0) {
            stringBuilderEx.append("%1$s", (Object)pSPanelLNParam.getDstPSPanelLPName());
        } else if (StringHelper.compare((String)string, (String)"COPYMODEL", (boolean)true) == 0) {
            stringBuilderEx.append("%1$s ==> %2$s", (Object)pSPanelLNParam.getSrcPSPanelLPName(), (Object)pSPanelLNParam.getDstPSPanelLPName());
        } else {
            String string2 = PanelLogicNodeSrcTypeCodeListModel.getInstance().getCodeListText(pSPanelLNParam.getSrcValueType(), true);
            if (StringHelper.compare((String)pSPanelLNParam.getSrcValueType(), (String)"SRCMODEL", (boolean)true) == 0) {
                if (!StringHelper.isNullOrEmpty((String)pSPanelLNParam.getSrcFieldName())) {
                    stringBuilderEx.append("%1$s[%2$s]", (Object)pSPanelLNParam.getSrcPSPanelLPName(), (Object)pSPanelLNParam.getSrcFieldName());
                } else {
                    stringBuilderEx.append("%1$s", (Object)pSPanelLNParam.getSrcPSPanelLPName());
                }
            } else if (StringHelper.compare((String)pSPanelLNParam.getSrcValueType(), (String)"NONEVALUE", (boolean)true) == 0 || StringHelper.compare((String)pSPanelLNParam.getSrcValueType(), (String)"NULLVALUE", (boolean)true) == 0) {
                stringBuilderEx.append("%1$s", (Object)string2);
            } else if (StringHelper.compare((String)pSPanelLNParam.getSrcValueType(), (String)"SRCVALUE", (boolean)true) == 0) {
                if (StringHelper.length((String)pSPanelLNParam.getSrcValue()) > 20) {
                    stringBuilderEx.append("%1$s[%2$s...]", (Object)string2, (Object)pSPanelLNParam.getSrcValue().substring(0, 20));
                } else {
                    stringBuilderEx.append("%1$s[%2$s]", (Object)string2, (Object)pSPanelLNParam.getSrcValue());
                }
            } else if (!StringHelper.isNullOrEmpty((String)pSPanelLNParam.getSrcFieldName())) {
                stringBuilderEx.append("%1$s[%2$s]", (Object)string2, (Object)pSPanelLNParam.getSrcFieldName());
            }
            stringBuilderEx.append(" ==> ");
            if (StringHelper.isNullOrEmpty((String)pSPanelLNParam.getDstFieldName())) {
                stringBuilderEx.append("%1$s", (Object)pSPanelLNParam.getDstPSPanelLPName());
            } else {
                stringBuilderEx.append("%1$s[%2$s]", (Object)pSPanelLNParam.getDstPSPanelLPName(), (Object)pSPanelLNParam.getDstFieldName());
            }
        }
        return stringBuilderEx.toString();
    }

    @Override
    protected void importCurXmlModel(PSPanelLNParam pSPanelLNParam, XmlNode xmlNode) throws Exception {
        Object object;
        PSPanelLogicParamService pSPanelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        String string = xmlNode.getAttribute("SRCPSPANELLPNAME", "");
        if (!StringHelper.isNullOrEmpty((String)string)) {
            object = new PSPanelLogicParam();
            ((PSPanelLogicParamBase)object).setPSPanelLogicParamName(string);
            ((PSPanelLogicParamBase)object).setPSSysViewPanelLogicId(pSPanelLNParam.getPSPanelLogicNode().getPSSysViewPanelLogicId());
            pSPanelLogicParamService.selectTemp((PSPanelLogicParam)object, false);
            pSPanelLNParam.setSrcPSPanelLPId(((PSPanelLogicParamBase)object).getPSPanelLogicParamId());
            xmlNode.setAttribute("SRCPSPANELLPID", ((PSPanelLogicParamBase)object).getPSPanelLogicParamId());
        }
        if (!StringHelper.isNullOrEmpty((String)(object = xmlNode.getAttribute("DSTPSPANELLPNAME", "")))) {
            PSPanelLogicParam pSPanelLogicParam = new PSPanelLogicParam();
            pSPanelLogicParam.setPSPanelLogicParamName((String)object);
            pSPanelLogicParam.setPSSysViewPanelLogicId(pSPanelLNParam.getPSPanelLogicNode().getPSSysViewPanelLogicId());
            pSPanelLogicParamService.selectTemp(pSPanelLogicParam, false);
            pSPanelLNParam.setDstPSPanelLPId(pSPanelLogicParam.getPSPanelLogicParamId());
            xmlNode.setAttribute("DSTPSPANELLPID", pSPanelLogicParam.getPSPanelLogicParamId());
        }
        super.importCurXmlModel(pSPanelLNParam, xmlNode);
    }
}

