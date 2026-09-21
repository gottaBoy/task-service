/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFDLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFDLogicServiceBase;
import org.springframework.stereotype.Component;

@Component
public class PSDEFDLogicService
extends PSDEFDLogicServiceBase {
    @Override
    protected void onFillParentInfo_PSDEFormDetail(PSDEFDLogic pSDEFDLogic, PSDEFormDetail pSDEFormDetail) throws Exception {
        super.onFillParentInfo_PSDEFormDetail(pSDEFDLogic, pSDEFormDetail);
        pSDEFDLogic.setPSDEFormId(pSDEFormDetail.getPSDEFormId());
        pSDEFDLogic.setPSDEFormName(pSDEFormDetail.getPSDEFormName());
    }

    @Override
    protected void onBeforeCreateTemp(PSDEFDLogic pSDEFDLogic) throws Exception {
        pSDEFDLogic.setPSDEFDLogicName(this.calcPSDEFDLogicName(pSDEFDLogic));
        super.onBeforeCreateTemp(pSDEFDLogic);
    }

    @Override
    protected void onBeforeUpdateTemp(PSDEFDLogic pSDEFDLogic) throws Exception {
        pSDEFDLogic.setPSDEFDLogicName(this.calcPSDEFDLogicName(pSDEFDLogic));
        super.onBeforeUpdateTemp(pSDEFDLogic);
    }

    protected String calcPSDEFDLogicName(PSDEFDLogic pSDEFDLogic) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        if (StringHelper.compare((String)pSDEFDLogic.getLogicType(), (String)"SINGLE", (boolean)true) == 0) {
            if (StringHelper.isNullOrEmpty((String)pSDEFDLogic.getFDName())) {
                return "?";
            }
            stringBuilderEx.append("%1$s", (Object)pSDEFDLogic.getFDName());
            if (StringHelper.isNullOrEmpty((String)pSDEFDLogic.getPSDBValueOPName())) {
                return "?";
            }
            stringBuilderEx.append(" %1$s ", (Object)pSDEFDLogic.getPSDBValueOPName());
            if (!StringHelper.isNullOrEmpty((String)pSDEFDLogic.getCondValue())) {
                stringBuilderEx.append("(%1$s)", (Object)pSDEFDLogic.getCondValue());
            }
            return stringBuilderEx.toString();
        }
        if (StringHelper.compare((String)pSDEFDLogic.getLogicType(), (String)"GROUP", (boolean)true) == 0) {
            if (StringHelper.isNullOrEmpty((String)pSDEFDLogic.getGroupOP())) {
                return "?";
            }
            stringBuilderEx.append("%1$s", (Object)pSDEFDLogic.getGroupOP());
            if (pSDEFDLogic.getGroupNotFlag() != null && pSDEFDLogic.getGroupNotFlag() == 1) {
                stringBuilderEx.append("[\u53d6\u53cd]");
            }
            return stringBuilderEx.toString();
        }
        return "?";
    }

    @Override
    public XmlNode exportXmlModel(PSDEFDLogic pSDEFDLogic, XmlNode xmlNode) throws Exception {
        boolean bl;
        boolean bl2 = bl = xmlNode == null;
        if (!bl && !pSDEFDLogic.isFullEntity()) {
            if (pSDEFDLogic.getPSDEFDLogicId().indexOf("SRFTEMPKEY:") == 0) {
                this.getTemp((IEntity)pSDEFDLogic);
            } else {
                this.get((IEntity)pSDEFDLogic);
            }
        }
        if (StringHelper.isNullOrEmpty((String)pSDEFDLogic.getLogicCat())) {
            return null;
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEFDLogic.getPPSDEFDLogicId())) {
            pSDEFDLogic.setLogicCat(null);
        }
        return super.exportXmlModel(pSDEFDLogic, xmlNode);
    }

    @Override
    protected void importCurXmlModel(PSDEFDLogic pSDEFDLogic, XmlNode xmlNode) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEFDLogic.getPPSDEFDLogicId())) {
            String string = xmlNode.getAttribute("LOGICCAT", "");
            if (StringHelper.isNullOrEmpty((String)string)) {
                throw new Exception("\u903b\u8f91\u5206\u7c7b\u65e0\u6548");
            }
        } else {
            xmlNode.setAttribute("LOGICCAT", pSDEFDLogic.getPPSDEFDLogic().getLogicCat());
        }
        super.importCurXmlModel(pSDEFDLogic, xmlNode);
    }
}

