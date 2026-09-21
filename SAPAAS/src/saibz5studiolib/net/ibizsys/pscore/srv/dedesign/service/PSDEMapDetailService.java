/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapDetail;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapDetailServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEMapDetailService
extends PSDEMapDetailServiceBase {
    private static final Log log = LogFactory.getLog(PSDEMapDetailService.class);

    @Override
    protected void onBeforeCreateTemp(PSDEMapDetail pSDEMapDetail) throws Exception {
        pSDEMapDetail.setPSDEMapDetailName(this.calcPSDEMapDetailName(pSDEMapDetail));
        super.onBeforeCreateTemp(pSDEMapDetail);
    }

    @Override
    protected void onBeforeUpdateTemp(PSDEMapDetail pSDEMapDetail) throws Exception {
        pSDEMapDetail.setPSDEMapDetailName(this.calcPSDEMapDetailName(pSDEMapDetail));
        super.onBeforeUpdateTemp(pSDEMapDetail);
    }

    protected String calcPSDEMapDetailName(PSDEMapDetail pSDEMapDetail) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        if (!StringHelper.isNullOrEmpty((String)pSDEMapDetail.getSrcPSDEFName())) {
            stringBuilderEx.append("\u6e90\u5c5e\u6027[%1$s]", (Object)pSDEMapDetail.getSrcPSDEFName());
        } else {
            stringBuilderEx.append("\u6e90\u503c[%1$s]", (Object)pSDEMapDetail.getSrcValue());
        }
        stringBuilderEx.append(" ==> \u76ee\u6807\u5c5e\u6027[%1$s]", (Object)pSDEMapDetail.getDstFieldName());
        return stringBuilderEx.toString();
    }

    @Override
    public Object getDataContextValue(PSDEMapDetail pSDEMapDetail, String string, IDataContextParam iDataContextParam) throws Exception {
        if (iDataContextParam != null && pSDEMapDetail.getPSDEMap() != null && StringHelper.compare((String)string, (String)"psdeid", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"psdefield", (boolean)true) == 0) {
            if (StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"SRCPSDEFNAME", (boolean)true) == 0) {
                return pSDEMapDetail.getPSDEMap().getPSDEId();
            }
            if (StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"DSTFIELDNAME", (boolean)true) == 0) {
                return pSDEMapDetail.getPSDEMap().getDSTPSDEId();
            }
        }
        return super.getDataContextValue(pSDEMapDetail, string, iDataContextParam);
    }
}

