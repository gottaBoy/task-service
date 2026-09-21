/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.codelist.DELLCondParamTypeCodeListModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELLCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParam;
import net.ibizsys.pscore.srv.dedesign.service.PSDELLCondServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDELLCondService
extends PSDELLCondServiceBase {
    private static final Log log = LogFactory.getLog(PSDELLCondService.class);

    @Override
    protected void onBeforeCreateTemp(PSDELLCond pSDELLCond) throws Exception {
        pSDELLCond.setPSDELLCondName(this.calcPSDELLCondName(pSDELLCond));
        super.onBeforeCreateTemp(pSDELLCond);
    }

    @Override
    protected void onBeforeUpdateTemp(PSDELLCond pSDELLCond) throws Exception {
        pSDELLCond.setPSDELLCondName(this.calcPSDELLCondName(pSDELLCond));
        super.onBeforeUpdateTemp(pSDELLCond);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected String calcPSDELLCondName(PSDELLCond pSDELLCond) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        if (StringHelper.compare((String)pSDELLCond.getLogicType(), (String)"SINGLE", (boolean)true) == 0) {
            if (StringHelper.isNullOrEmpty((String)pSDELLCond.getDstPSDLParamName())) {
                return "?";
            }
            stringBuilderEx.append("%1$s", (Object)pSDELLCond.getDstPSDLParamName());
            if (!StringHelper.isNullOrEmpty((String)pSDELLCond.getCustomDSTParam())) {
                stringBuilderEx.append("[%1$s]", (Object)pSDELLCond.getCustomDSTParam());
            } else if (!StringHelper.isNullOrEmpty((String)pSDELLCond.getDstPSDEFName())) {
                stringBuilderEx.append("[%1$s]", (Object)pSDELLCond.getDstPSDEFName());
            }
            if (StringHelper.isNullOrEmpty((String)pSDELLCond.getPSDBValueOPName())) {
                return "?";
            }
            stringBuilderEx.append(" %1$s ", (Object)pSDELLCond.getPSDBValueOPName());
            if (!StringHelper.isNullOrEmpty((String)pSDELLCond.getParamType())) {
                DELLCondParamTypeCodeListModel dELLCondParamTypeCodeListModel = (DELLCondParamTypeCodeListModel)CodeListGlobal.getCodeList((String)DELLCondParamTypeCodeListModel.class.getCanonicalName());
                String string = dELLCondParamTypeCodeListModel.getCodeListText(pSDELLCond.getParamType(), true);
                if (StringHelper.compare((String)pSDELLCond.getParamType(), (String)"CURTIME", (boolean)false) == 0) {
                    stringBuilderEx.append("[%1$s]", (Object)string);
                    return stringBuilderEx.toString();
                } else if (StringHelper.compare((String)pSDELLCond.getParamType(), (String)"ENTITYFIELD", (boolean)false) == 0) {
                    if (StringHelper.isNullOrEmpty((String)pSDELLCond.getCondValue())) {
                        return "?";
                    }
                    stringBuilderEx.append("[%1$s]", (Object)pSDELLCond.getCondValue());
                    return stringBuilderEx.toString();
                } else if (StringHelper.compare((String)pSDELLCond.getParamType(), (String)"SRCENTITYFIELD", (boolean)false) == 0) {
                    if (StringHelper.isNullOrEmpty((String)pSDELLCond.getSrcPSDLParamName())) {
                        return "?";
                    }
                    if (StringHelper.isNullOrEmpty((String)pSDELLCond.getCondValue())) {
                        return "?";
                    }
                    stringBuilderEx.append("%1$s[%2$s]", (Object)pSDELLCond.getSrcPSDLParamName(), (Object)pSDELLCond.getCondValue());
                    return stringBuilderEx.toString();
                } else {
                    if (StringHelper.compare((String)pSDELLCond.getParamType(), (String)"SRCDLPARAM", (boolean)false) != 0) return "?";
                    if (StringHelper.isNullOrEmpty((String)pSDELLCond.getSrcPSDLParamName())) {
                        return "?";
                    }
                    stringBuilderEx.append("%1$s", (Object)pSDELLCond.getSrcPSDLParamName());
                }
                return stringBuilderEx.toString();
            } else {
                if (StringHelper.isNullOrEmpty((String)pSDELLCond.getCondValue())) return stringBuilderEx.toString();
                stringBuilderEx.append("(%1$s)", (Object)pSDELLCond.getCondValue());
            }
            return stringBuilderEx.toString();
        }
        if (StringHelper.compare((String)pSDELLCond.getLogicType(), (String)"GROUP", (boolean)true) != 0) return "?";
        if (StringHelper.isNullOrEmpty((String)pSDELLCond.getGroupOP())) {
            return "?";
        }
        stringBuilderEx.append("%1$s", (Object)pSDELLCond.getGroupOP());
        if (pSDELLCond.getGroupNotFlag() == null || pSDELLCond.getGroupNotFlag() != 1) return stringBuilderEx.toString();
        stringBuilderEx.append("[\u53d6\u53cd]");
        return stringBuilderEx.toString();
    }

    @Override
    protected void importCurXmlModel(PSDELLCond pSDELLCond, XmlNode xmlNode) throws Exception {
        PSDELogicParamService pSDELogicParamService = (PSDELogicParamService)ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)this.getSessionFactory());
        String string = xmlNode.getAttribute("DSTPSDLPARAMNAME", "");
        if (!StringHelper.isNullOrEmpty((String)string)) {
            PSDELogicParam pSDELogicParam = new PSDELogicParam();
            pSDELogicParam.setPSDELogicParamName(string);
            pSDELogicParam.setPSDELogicId(pSDELLCond.getPSDELogicLink().getPSDELogicId());
            pSDELogicParamService.selectTemp(pSDELogicParam, false);
            pSDELLCond.setDstPSDLParamId(pSDELogicParam.getPSDELogicParamId());
            xmlNode.setAttribute("DSTPSDLPARAMID", pSDELogicParam.getPSDELogicParamId());
        }
        super.importCurXmlModel(pSDELLCond, xmlNode);
    }
}

