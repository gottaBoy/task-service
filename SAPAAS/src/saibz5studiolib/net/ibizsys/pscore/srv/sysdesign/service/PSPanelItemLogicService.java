/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.codelist.DLValueOPCodeListModel;
import net.ibizsys.pscore.srv.codelist.GroupCondCodeListModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelItemLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItem;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelItemLogicServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSPanelItemLogicService
extends PSPanelItemLogicServiceBase {
    private static final Log log = LogFactory.getLog(PSPanelItemLogicService.class);

    @Override
    protected void onFillParentInfo_PSSysViewPanelItem(PSPanelItemLogic pSPanelItemLogic, PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        super.onFillParentInfo_PSSysViewPanelItem(pSPanelItemLogic, pSSysViewPanelItem);
        pSPanelItemLogic.setPSSysViewPanelId(pSSysViewPanelItem.getPSSysViewPanelId());
        pSPanelItemLogic.setPSSysViewPanelName(pSSysViewPanelItem.getPSSysViewPanelName());
    }

    @Override
    protected void onBeforeCreateTemp(PSPanelItemLogic pSPanelItemLogic) throws Exception {
        pSPanelItemLogic.setPSPanelItemLogicName(this.calcPSPanelItemLogicName(pSPanelItemLogic));
        super.onBeforeCreateTemp(pSPanelItemLogic);
    }

    @Override
    protected void onBeforeUpdateTemp(PSPanelItemLogic pSPanelItemLogic) throws Exception {
        pSPanelItemLogic.setPSPanelItemLogicName(this.calcPSPanelItemLogicName(pSPanelItemLogic));
        super.onBeforeUpdateTemp(pSPanelItemLogic);
    }

    protected String calcPSPanelItemLogicName(PSPanelItemLogic pSPanelItemLogic) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        if (StringHelper.compare((String)pSPanelItemLogic.getLogicType(), (String)"SINGLE", (boolean)true) == 0) {
            if (StringHelper.isNullOrEmpty((String)pSPanelItemLogic.getDstFieldName())) {
                return "?";
            }
            stringBuilderEx.append("%1$s", (Object)pSPanelItemLogic.getDstFieldName());
            if (StringHelper.isNullOrEmpty((String)pSPanelItemLogic.getCondOp())) {
                return "?";
            }
            stringBuilderEx.append(" %1$s ", (Object)DLValueOPCodeListModel.getInstance().getCodeListText(pSPanelItemLogic.getCondOp(), true));
            if (!StringHelper.isNullOrEmpty((String)pSPanelItemLogic.getCondValue())) {
                stringBuilderEx.append("(%1$s)", (Object)pSPanelItemLogic.getCondValue());
            }
            return stringBuilderEx.toString();
        }
        if (StringHelper.compare((String)pSPanelItemLogic.getLogicType(), (String)"GROUP", (boolean)true) == 0) {
            if (StringHelper.isNullOrEmpty((String)pSPanelItemLogic.getGroupOP())) {
                return "?";
            }
            stringBuilderEx.append("%1$s", (Object)GroupCondCodeListModel.getInstance().getCodeListText(pSPanelItemLogic.getGroupOP(), true));
            if (pSPanelItemLogic.getGroupNotFlag() != null && pSPanelItemLogic.getGroupNotFlag() == 1) {
                stringBuilderEx.append("[\u53d6\u53cd]");
            }
            return stringBuilderEx.toString();
        }
        return "?";
    }

    @Override
    public XmlNode exportXmlModel(PSPanelItemLogic pSPanelItemLogic, XmlNode xmlNode) throws Exception {
        boolean bl;
        boolean bl2 = bl = xmlNode == null;
        if (!bl && !pSPanelItemLogic.isFullEntity()) {
            if (pSPanelItemLogic.getPSPanelItemLogicId().indexOf("SRFTEMPKEY:") == 0) {
                this.getTemp((IEntity)pSPanelItemLogic);
            } else {
                this.get((IEntity)pSPanelItemLogic);
            }
        }
        if (StringHelper.isNullOrEmpty((String)pSPanelItemLogic.getLogicCat())) {
            return null;
        }
        if (!StringHelper.isNullOrEmpty((String)pSPanelItemLogic.getPPSPanelItemLogicId())) {
            pSPanelItemLogic.setLogicCat(null);
        }
        return super.exportXmlModel(pSPanelItemLogic, xmlNode);
    }

    @Override
    protected void importCurXmlModel(PSPanelItemLogic pSPanelItemLogic, XmlNode xmlNode) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSPanelItemLogic.getPPSPanelItemLogicId())) {
            String string = xmlNode.getAttribute("LOGICCAT", "");
            if (StringHelper.isNullOrEmpty((String)string)) {
                throw new Exception("\u903b\u8f91\u5206\u7c7b\u65e0\u6548");
            }
        } else {
            xmlNode.setAttribute("LOGICCAT", pSPanelItemLogic.getPPSPanelItemLogic().getLogicCat());
        }
        super.importCurXmlModel(pSPanelItemLogic, xmlNode);
    }
}

