/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.core.PSDCSysLicException;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysLic;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysLicServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDCSysLicService
extends PSDCSysLicServiceBase {
    private static final Log log = LogFactory.getLog(PSDCSysLicService.class);

    public void testLic(PSDCSysLic pSDCSysLic, String string, int n) throws Exception {
        IDEField iDEField = this.getDEModel().getDEField(string, true);
        if (iDEField == null) {
            throw new PSDCSysLicException(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6388\u6743\u9879[%1$s]", (Object)string));
        }
        int n2 = DataObject.getIntegerValue((Object)pSDCSysLic.get(string), (Integer)-1);
        if (n2 == -1) {
            return;
        }
        if (n2 < n) {
            throw new PSDCSysLicException(StringHelper.format((String)"\u6388\u6743\u9879[%1$s]\u8d85\u8fc7\u9650\u5236\uff0c\u5141\u8bb8[%2$s]\uff0c\u5f53\u524d[%3$s]", (Object)iDEField.getLogicName(), (Object)n2, (Object)n), iDEField.getLogicName(), n2, n);
        }
    }

    public void testLic2(PSDCSysLic pSDCSysLic, String string, int n) throws Exception {
        IDEField iDEField = this.getDEModel().getDEField(string, true);
        if (iDEField == null) {
            throw new PSDCSysLicException(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6388\u6743\u9879[%1$s]", (Object)string));
        }
        int n2 = DataObject.getIntegerValue((Object)pSDCSysLic.get(string), (Integer)-1);
        if (n2 == -1) {
            return;
        }
        if (n2 < n) {
            throw new PSDCSysLicException(StringHelper.format((String)"\u6388\u6743\u9879[%1$s]\u8d85\u8fc7\u9650\u5236\uff0c\u5141\u8bb8[%2$s]\uff0c\u5f53\u524d[%3$s]", (Object)iDEField.getLogicName(), (Object)n2, (Object)(n - 1)), iDEField.getLogicName(), n2, n);
        }
    }

    @Override
    protected boolean onMergeChild_PSDevSlnSyses(PSDCSysLic pSDCSysLic) throws Exception {
        boolean bl = super.onMergeChild_PSDevSlnSyses(pSDCSysLic);
        if (bl) {
            PSDCSysLic pSDCSysLic2 = new PSDCSysLic();
            pSDCSysLic2.setPSDCSysLicId(pSDCSysLic.getPSDCSysLicId());
            this.get((IEntity)pSDCSysLic2);
            this.testLic(pSDCSysLic2, "MAXSYSCNT", pSDCSysLic.getCurSysCnt());
            this.testLic(pSDCSysLic2, "MAXACTIVESYSCNT", pSDCSysLic.getCurActiveSysCnt());
            this.testLic(pSDCSysLic2, "MAXTOTALENTITYCNT", pSDCSysLic.getCurTotalEntityCnt());
        }
        return bl;
    }
}

