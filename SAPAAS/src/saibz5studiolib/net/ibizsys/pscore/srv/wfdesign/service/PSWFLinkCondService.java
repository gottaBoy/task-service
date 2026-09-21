/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.wfdesign.service;

import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkCond;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkCondServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSWFLinkCondService
extends PSWFLinkCondServiceBase {
    private static final Log log = LogFactory.getLog(PSWFLinkCondService.class);

    @Override
    protected void onBeforeCreateTemp(PSWFLinkCond pSWFLinkCond) throws Exception {
        pSWFLinkCond.setPSWFLinkCondName(this.calcPSWFLinkCondName(pSWFLinkCond));
        if (StringHelper.isNullOrEmpty((String)pSWFLinkCond.getPSWFVersionId()) && pSWFLinkCond.getPSWFLink() != null) {
            pSWFLinkCond.setPSWFVersionId(pSWFLinkCond.getPSWFLink().getPSWFVersionId());
        }
        super.onBeforeCreateTemp(pSWFLinkCond);
    }

    @Override
    protected void onBeforeUpdateTemp(PSWFLinkCond pSWFLinkCond) throws Exception {
        pSWFLinkCond.setPSWFLinkCondName(this.calcPSWFLinkCondName(pSWFLinkCond));
        if (StringHelper.isNullOrEmpty((String)pSWFLinkCond.getPSWFVersionId()) && pSWFLinkCond.getPSWFLink() != null) {
            pSWFLinkCond.setPSWFVersionId(pSWFLinkCond.getPSWFLink().getPSWFVersionId());
        }
        super.onBeforeUpdateTemp(pSWFLinkCond);
    }

    protected String calcPSWFLinkCondName(PSWFLinkCond pSWFLinkCond) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        if (StringHelper.compare((String)pSWFLinkCond.getLogicType(), (String)"SINGLE", (boolean)true) == 0) {
            if (!StringHelper.isNullOrEmpty((String)pSWFLinkCond.getCustomDSTParam())) {
                stringBuilderEx.append("[%1$s]", (Object)pSWFLinkCond.getCustomDSTParam());
            } else if (!StringHelper.isNullOrEmpty((String)pSWFLinkCond.getDstPSDEFName())) {
                stringBuilderEx.append("[%1$s]", (Object)pSWFLinkCond.getDstPSDEFName());
            } else {
                return "?";
            }
            if (StringHelper.isNullOrEmpty((String)pSWFLinkCond.getPSDBValueOPName())) {
                return "?";
            }
            stringBuilderEx.append(" %1$s ", (Object)pSWFLinkCond.getPSDBValueOPName());
            if (!StringHelper.isNullOrEmpty((String)pSWFLinkCond.getCondValue())) {
                stringBuilderEx.append("(%1$s)", (Object)pSWFLinkCond.getCondValue());
            }
            return stringBuilderEx.toString();
        }
        if (StringHelper.compare((String)pSWFLinkCond.getLogicType(), (String)"GROUP", (boolean)true) == 0) {
            if (StringHelper.isNullOrEmpty((String)pSWFLinkCond.getGroupOP())) {
                return "?";
            }
            stringBuilderEx.append("%1$s", (Object)pSWFLinkCond.getGroupOP());
            if (pSWFLinkCond.getGroupNotFlag() != null && pSWFLinkCond.getGroupNotFlag() == 1) {
                stringBuilderEx.append("[\u53d6\u53cd]");
            }
            return stringBuilderEx.toString();
        }
        return "?";
    }
}

