/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPFPITempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPFPITemplServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysPFPITemplService
extends PSSysPFPITemplServiceBase {
    private static final Log log = LogFactory.getLog(PSSysPFPITemplService.class);

    @Override
    protected boolean onFillEntityKeyValue(PSSysPFPITempl pSSysPFPITempl, boolean bl) throws Exception {
        if (!bl && !StringHelper.isNullOrEmpty((String)pSSysPFPITempl.getPSPFPubCodeId())) {
            StringBuilderEx stringBuilderEx = new StringBuilderEx();
            Object object = pSSysPFPITempl.get("PSSYSPFPLUGINID");
            if (object == null) {
                object = "__EMTPY__";
            }
            stringBuilderEx.append("%1$s", object);
            stringBuilderEx.append("||");
            Object object2 = pSSysPFPITempl.get("PSPFID");
            if (object2 == null) {
                object2 = "__EMTPY__";
            }
            stringBuilderEx.append("%1$s", object2);
            stringBuilderEx.append("||");
            String string = pSSysPFPITempl.getPSPFPubCodeId();
            if (string == null) {
                string = "__EMTPY__";
            }
            stringBuilderEx.append("%1$s", (Object)string);
            String string2 = stringBuilderEx.toString();
            pSSysPFPITempl.set(this.getPSSysPFPITemplDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string2));
            return true;
        }
        if (!bl && !StringHelper.isNullOrEmpty((String)pSSysPFPITempl.getPSPFPubCodeName())) {
            StringBuilderEx stringBuilderEx = new StringBuilderEx();
            Object object = pSSysPFPITempl.get("PSSYSPFPLUGINID");
            if (object == null) {
                object = "__EMTPY__";
            }
            stringBuilderEx.append("%1$s", object);
            stringBuilderEx.append("||");
            Object object3 = pSSysPFPITempl.get("PSPFID");
            if (object3 == null) {
                object3 = "__EMTPY__";
            }
            stringBuilderEx.append("%1$s", object3);
            stringBuilderEx.append("||");
            String string = pSSysPFPITempl.getPSPFPubCodeName();
            if (string == null) {
                string = "__EMTPY__";
            }
            stringBuilderEx.append("%1$s", (Object)string.toUpperCase());
            String string3 = stringBuilderEx.toString();
            pSSysPFPITempl.set(this.getPSSysPFPITemplDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string3));
            return true;
        }
        return super.onFillEntityKeyValue(pSSysPFPITempl, bl);
    }

    @Override
    protected void onBeforeCreate(PSSysPFPITempl pSSysPFPITempl) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSSysPFPITempl.getPSPFPubCodeId())) {
            pSSysPFPITempl.setPSSysPFPITemplName(StringHelper.format((String)"%1$s/%2$s", (Object)pSSysPFPITempl.getPSSysPFPluginName(), (Object)pSSysPFPITempl.getPSPFName()));
        } else {
            pSSysPFPITempl.setPSSysPFPITemplName(StringHelper.format((String)"%1$s/%2$s/%3$s", (Object)pSSysPFPITempl.getPSSysPFPluginName(), (Object)pSSysPFPITempl.getPSPFName(), (Object)pSSysPFPITempl.getPSPFPubCodeName()));
        }
        if (StringHelper.length((String)pSSysPFPITempl.getTemplCode2()) > 2000) {
            pSSysPFPITempl.setTemplCode2Ex(pSSysPFPITempl.getTemplCode2());
            pSSysPFPITempl.setTemplCode2(null);
        } else if (!StringHelper.isNullOrEmpty((String)pSSysPFPITempl.getTemplCode2())) {
            pSSysPFPITempl.setTemplCode2Ex(null);
        }
        super.onBeforeCreate(pSSysPFPITempl);
    }

    @Override
    protected void onBeforeUpdate(PSSysPFPITempl pSSysPFPITempl) throws Exception {
        if (StringHelper.length((String)pSSysPFPITempl.getTemplCode2()) > 2000) {
            pSSysPFPITempl.setTemplCode2Ex(pSSysPFPITempl.getTemplCode2());
            pSSysPFPITempl.setTemplCode2(null);
        } else if (pSSysPFPITempl.isTemplCode2Dirty()) {
            pSSysPFPITempl.setTemplCode2Ex(null);
        }
        super.onBeforeUpdate(pSSysPFPITempl);
    }

    protected CallResult internalGet(PSSysPFPITempl pSSysPFPITempl, boolean bl) throws Exception {
        CallResult callResult = super.internalGet(pSSysPFPITempl, bl);
        if (callResult.isOk()) {
            if (!StringHelper.isNullOrEmpty((String)pSSysPFPITempl.getTemplCode2Ex())) {
                pSSysPFPITempl.setTemplCode2(pSSysPFPITempl.getTemplCode2Ex());
            }
            this.onCalcTemplLabel(pSSysPFPITempl);
        }
        return callResult;
    }

    @Override
    protected CallResult internalGetTemp(PSSysPFPITempl pSSysPFPITempl, boolean bl) throws Exception {
        CallResult callResult = super.internalGetTemp(pSSysPFPITempl, bl);
        if (callResult.isOk()) {
            if (!StringHelper.isNullOrEmpty((String)pSSysPFPITempl.getTemplCode2Ex())) {
                pSSysPFPITempl.setTemplCode2(pSSysPFPITempl.getTemplCode2Ex());
            }
            this.onCalcTemplLabel(pSSysPFPITempl);
        }
        return callResult;
    }

    @Override
    protected void onCalcTemplLabel(PSSysPFPITempl pSSysPFPITempl) throws Exception {
        pSSysPFPITempl.set("LABEL_TEMPLCODE", "\u4ee3\u7801\u6a21\u677f");
        pSSysPFPITempl.set("LABEL_TEMPLCODE2", "\u4ee3\u7801\u6a21\u677f2");
        pSSysPFPITempl.set("LABEL_TEMPLCODE3", "\u4ee3\u7801\u6a21\u677f3");
        pSSysPFPITempl.set("LABEL_TEMPLCODE4", "\u4ee3\u7801\u6a21\u677f4");
        if (StringHelper.isNullOrEmpty((String)pSSysPFPITempl.getPSPFPubCodeId()) && StringHelper.compare((String)pSSysPFPITempl.getPSPFId(), (String)"EXTJS5", (boolean)true) == 0) {
            pSSysPFPITempl.set("LABEL_TEMPLCODE", "\u89c6\u56fe\u4ee3\u7801(View)");
            pSSysPFPITempl.set("LABEL_TEMPLCODE2", "\u63a7\u5236\u5668\u4ee3\u7801(Controller)");
        }
    }

    @Override
    public String getModelV2Tag(PSSysPFPITempl pSSysPFPITempl) {
        if (!StringHelper.isNullOrEmpty((String)pSSysPFPITempl.getPSPFId())) {
            if (!StringHelper.isNullOrEmpty((String)pSSysPFPITempl.getPSPFPubCodeId())) {
                return StringHelper.format((String)"%1$s[%2$s]", (Object)pSSysPFPITempl.getPSPFId(), (Object)pSSysPFPITempl.getPSPFPubCodeId());
            }
            return pSSysPFPITempl.getPSPFId();
        }
        return super.getModelV2Tag(pSSysPFPITempl);
    }
}

