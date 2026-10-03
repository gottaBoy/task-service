/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardStep;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardFormServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardStepService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEWizardFormService
extends PSDEWizardFormServiceBase {
    private static final Log log = LogFactory.getLog(PSDEWizardFormService.class);

    @Override
    protected void onInitWizardStep(PSDEWizardForm pSDEWizardForm) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSDEWizardForm.getPSDEWizardStepId())) {
            throw new Exception("\u5f53\u524d\u5df2\u6307\u5b9a\u5411\u5bfc\u6b65\u9aa4");
        }
        if (StringHelper.isNullOrEmpty((String)pSDEWizardForm.getPSDEWizardId())) {
            throw new Exception("\u5b9e\u4f53\u5411\u5bfc\u8868\u5355\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5411\u5bfc");
        }
        if (StringHelper.isNullOrEmpty((String)pSDEWizardForm.getFormTag())) {
            throw new Exception("\u5b9e\u4f53\u5411\u5bfc\u8868\u5355\u6ca1\u6709\u6307\u5b9a\u8868\u5355\u6807\u8bc6");
        }
        PSDEWizardStepService pSDEWizardStepService = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
        boolean bl = KeyValueHelper.isTempKey((String)pSDEWizardForm.getPSDEWizardId());
        PSDEWizardStep pSDEWizardStep = new PSDEWizardStep();
        pSDEWizardStep.setPSDEWizardId(pSDEWizardForm.getPSDEWizardId());
        pSDEWizardStep.setStepTag(pSDEWizardForm.getFormTag());
        pSDEWizardStep.setSessionFactory(this.getSessionFactory());
        boolean bl2 = false;
        bl2 = bl ? pSDEWizardStepService.selectTempOne(pSDEWizardStep, true) : pSDEWizardStepService.selectOne(pSDEWizardStep, true);
        if (!bl2) {
            block10: {
                PSDEWizardStep pSDEWizardStep2;
                SelectCond selectCond = new SelectCond();
                selectCond.setOrderInfo("ORDER BY ORDERVALUE DESC");
                selectCond.setMaxRowCount(1);
                selectCond.set("PSDEWIZARDID", (Object)pSDEWizardForm.getPSDEWizardId());
                ArrayList arrayList = null;
                arrayList = bl ? pSDEWizardStepService.selectTemp((ISelectCond)selectCond) : pSDEWizardStepService.select((ISelectCond)selectCond);
                int n = 100;
                if (arrayList.size() > 0) {
                    n = DataObject.getIntegerValue((Object)((PSDEWizardStep)arrayList.get(0)).getOrderValue(), (Integer)n) + 100;
                }
                pSDEWizardStep.setOrderValue(n);
                String string = pSDEWizardForm.getPSDEWizardFormName();
                if (StringHelper.isNullOrEmpty((String)string)) {
                    string = "\u6b65\u9aa4";
                }
                int n2 = 0;
                while (true) {
                    pSDEWizardStep2 = new PSDEWizardStep();
                    pSDEWizardStep2.setPSDEWizardId(pSDEWizardForm.getPSDEWizardId());
                    pSDEWizardStep2.setPSDEWizardStepName(StringHelper.format((String)"%1$s%2$s", (Object)string, (Object)(++n2 == 1 ? "" : Integer.valueOf(n2))));
                    pSDEWizardStep2.setSessionFactory(this.getSessionFactory());
                    if (bl) {
                        if (pSDEWizardStepService.selectTempOne(pSDEWizardStep2, true)) continue;
                        pSDEWizardStep.setPSDEWizardStepName(pSDEWizardStep2.getPSDEWizardStepName());
                        break block10;
                    }
                    if (!pSDEWizardStepService.selectOne(pSDEWizardStep2, true)) break;
                }
                pSDEWizardStep.setPSDEWizardStepName(pSDEWizardStep2.getPSDEWizardStepName());
            }
            if (bl) {
                pSDEWizardStepService.createTemp(pSDEWizardStep);
            } else {
                pSDEWizardStepService.create(pSDEWizardStep);
            }
        }
        pSDEWizardForm.setPSDEWizardStepId(pSDEWizardStep.getPSDEWizardStepId());
        pSDEWizardForm.setPSDEWizardStepName(pSDEWizardStep.getPSDEWizardStepName());
    }

    @Override
    protected void onInitNextAction(PSDEWizardForm pSDEWizardForm) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSDEWizardForm.getSavePSDEActionId())) {
            throw new Exception("\u5f53\u524d\u5df2\u6307\u5b9a\u4e0b\u4e00\u6b65\u64cd\u4f5c\u884c\u4e3a");
        }
        if (StringHelper.isNullOrEmpty((String)pSDEWizardForm.getPSDEWizardId())) {
            throw new Exception("\u5b9e\u4f53\u5411\u5bfc\u8868\u5355\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5411\u5bfc");
        }
        if (StringHelper.isNullOrEmpty((String)pSDEWizardForm.getFormTag())) {
            throw new Exception("\u5b9e\u4f53\u5411\u5bfc\u8868\u5355\u6ca1\u6709\u6307\u5b9a\u8868\u5355\u6807\u8bc6");
        }
        pSDEWizardForm.setSessionFactory(this.getSessionFactory());
        PSDEAction pSDEAction = new PSDEAction();
        pSDEAction.setSessionFactory(this.getSessionFactory());
        pSDEAction.setPSDEId(pSDEWizardForm.getPSDEWizard().getPSDEId());
        String string = pSDEWizardForm.getFormTag().substring(0, 1).toUpperCase();
        if (pSDEWizardForm.getFormTag().length() > 1) {
            string = string + pSDEWizardForm.getFormTag().substring(1).toLowerCase();
        }
        String string2 = StringHelper.format((String)"FinishStep%1$s", (Object)string);
        pSDEAction.setCodeName(string2);
        if (!pSDEAction.select(true)) {
            pSDEAction.resetCodeName();
            pSDEAction.setPSDEActionName(string2);
            if (!pSDEAction.select(true)) {
                pSDEAction.setCodeName(string2);
                pSDEAction.setActionType("USERCUSTOM");
                pSDEAction.setMemo(StringHelper.format((String)"\u5411\u5bfc\u8868\u5355[%1$s]\u4e0b\u4e00\u6b65\u8c03\u7528\u884c\u4e3a", (Object)(StringHelper.isNullOrEmpty((String)pSDEWizardForm.getPSDEWizardFormName()) ? pSDEWizardForm.getFormTag() : pSDEWizardForm.getPSDEWizardFormName())));
                pSDEAction.create();
            }
        }
        pSDEWizardForm.setSavePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEWizardForm.setSavePSDEActionName(pSDEAction.getPSDEActionName());
    }
}

