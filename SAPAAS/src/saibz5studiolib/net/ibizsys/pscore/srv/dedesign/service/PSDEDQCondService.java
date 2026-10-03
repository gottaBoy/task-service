/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.PSVarType2CodeListModel;
import net.ibizsys.pscore.srv.config.entity.PSVarSampleValue;
import net.ibizsys.pscore.srv.config.service.PSVarSampleValueService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQJoin;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCondServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEDQCondService
extends PSDEDQCondServiceBase {
    private static final Log log = LogFactory.getLog(PSDEDQCondService.class);

    @Override
    protected void onBeforeCreateTemp(PSDEDQCond pSDEDQCond) throws Exception {
        pSDEDQCond.setPSDEDQCondName(this.calcPSDEDQCondName(pSDEDQCond));
        super.onBeforeCreateTemp(pSDEDQCond);
    }

    @Override
    protected void onBeforeUpdateTemp(PSDEDQCond pSDEDQCond) throws Exception {
        pSDEDQCond.setPSDEDQCondName(this.calcPSDEDQCondName(pSDEDQCond));
        super.onBeforeUpdateTemp(pSDEDQCond);
    }

    @Override
    protected void onFillEntityFullInfo_PSDEDQ(PSDEDQCond pSDEDQCond, boolean bl) throws Exception {
        super.onFillEntityFullInfo_PSDEDQ(pSDEDQCond, bl);
        if (StringHelper.isNullOrEmpty((String)pSDEDQCond.getPSDEDQId()) && !StringHelper.isNullOrEmpty((String)pSDEDQCond.getPSDEDQJoinId())) {
            PSDEDQJoin pSDEDQJoin = pSDEDQCond.getPSDEDQJoin();
            pSDEDQCond.setPSDEDQId(pSDEDQJoin.getPSDEDQId());
            pSDEDQCond.setPSDEDQName(pSDEDQJoin.getPSDEDQName());
        }
    }

    @Override
    protected void onFillEntityFullInfo_PSDEDQJoin(PSDEDQCond pSDEDQCond, boolean bl) throws Exception {
        super.onFillEntityFullInfo_PSDEDQJoin(pSDEDQCond, bl);
    }

    @Override
    protected void onFillParentInfo_PSDEDQJoin(PSDEDQCond pSDEDQCond, PSDEDQJoin pSDEDQJoin) throws Exception {
        super.onFillParentInfo_PSDEDQJoin(pSDEDQCond, pSDEDQJoin);
        pSDEDQCond.setPSDEDQId(pSDEDQJoin.getPSDEDQId());
        pSDEDQCond.setPSDEDQName(pSDEDQJoin.getPSDEDQName());
    }

    protected String calcPSDEDQCondName(PSDEDQCond pSDEDQCond) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        if (StringHelper.compare((String)pSDEDQCond.getCondType(), (String)"SINGLE", (boolean)true) == 0) {
            if (StringHelper.isNullOrEmpty((String)pSDEDQCond.getPSDEFName())) {
                return "?";
            }
            if (StringHelper.isNullOrEmpty((String)pSDEDQCond.getPSSysDBVFName())) {
                stringBuilderEx.append("%1$s", (Object)pSDEDQCond.getPSDEFName());
            } else {
                stringBuilderEx.append("%1$s(%2$s)", (Object)pSDEDQCond.getPSSysDBVFName(), (Object)pSDEDQCond.getPSDEFName());
            }
            if (StringHelper.isNullOrEmpty((String)pSDEDQCond.getPSDBValueOPName())) {
                return "?";
            }
            stringBuilderEx.append(" %1$s ", (Object)pSDEDQCond.getPSDBValueOPName());
            if (!StringHelper.isNullOrEmpty((String)pSDEDQCond.getPSVARTypeName())) {
                stringBuilderEx.append("%1$s", (Object)pSDEDQCond.getPSVARTypeName());
            }
            if (!StringHelper.isNullOrEmpty((String)pSDEDQCond.getCondValue())) {
                stringBuilderEx.append("(%1$s)", (Object)pSDEDQCond.getCondValue());
            }
            return stringBuilderEx.toString();
        }
        if (StringHelper.compare((String)pSDEDQCond.getCondType(), (String)"GROUP", (boolean)true) == 0) {
            if (StringHelper.isNullOrEmpty((String)pSDEDQCond.getGroupOP())) {
                return "?";
            }
            stringBuilderEx.append("%1$s", (Object)pSDEDQCond.getGroupOP());
            if (pSDEDQCond.getGroupNotFlag() != null && pSDEDQCond.getGroupNotFlag() == 1) {
                stringBuilderEx.append("[\u53d6\u53cd]");
            }
            return stringBuilderEx.toString();
        }
        if (StringHelper.compare((String)pSDEDQCond.getCondType(), (String)"PREDEFINED", (boolean)true) == 0) {
            return pSDEDQCond.getPSDEDQPDCondName();
        }
        if (StringHelper.compare((String)pSDEDQCond.getCondType(), (String)"CUSTOM", (boolean)true) == 0) {
            return pSDEDQCond.getPSDEDQCondName();
        }
        return "?";
    }

    @Override
    protected void onAjaxFillCondValue(PSDEDQCond pSDEDQCond) throws Exception {
        if (this.getWebContext() == null || this.getWebContext().getCurAjaxActionResult() == null) {
            throw new Exception("\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u4e0d\u6b63\u786e");
        }
        String string = this.getWebContext().getPostValue("srfactionparam");
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        JSONObject jSONObject = JSONObject.fromString((String)string);
        String string2 = jSONObject.optString("srfkey");
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return;
        }
        PSVarSampleValueService pSVarSampleValueService = (PSVarSampleValueService)ServiceGlobal.getService(PSVarSampleValueService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSVarSampleValue pSVarSampleValue = new PSVarSampleValue();
        pSVarSampleValue.setPSVarSampleValueId(string2);
        if (pSVarSampleValueService.get(pSVarSampleValue, true)) {
            PSVarType2CodeListModel pSVarType2CodeListModel = (PSVarType2CodeListModel)CodeListGlobal.getCodeList(PSVarType2CodeListModel.class);
            pSDEDQCond.setPSVARTypeId(pSVarSampleValue.getVarType());
            pSDEDQCond.setPSVARTypeName(pSVarType2CodeListModel.getCodeListText(pSVarSampleValue.getVarType(), false));
            pSDEDQCond.setCondValue(pSVarSampleValue.getValue());
            pSDEDQCond.setCondValueText(pSVarSampleValue.getPSVarSampleValueName());
        }
    }
}

