/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.search.service;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDEField;
import net.ibizsys.pscore.srv.search.service.PSSysSearchDEFieldServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysSearchDEFieldService
extends PSSysSearchDEFieldServiceBase {
    private static final Log log = LogFactory.getLog(PSSysSearchDEFieldService.class);

    @Override
    public void getDraft(PSSysSearchDEField pSSysSearchDEField) throws Exception {
        super.getDraft(pSSysSearchDEField);
        if (StringHelper.isNullOrEmpty((String)pSSysSearchDEField.getPSDEId())) {
            this.calcSearchDE(pSSysSearchDEField);
        }
        if (StringHelper.isNullOrEmpty((String)pSSysSearchDEField.getPSSysSearchDocId())) {
            this.calcSearchDoc(pSSysSearchDEField);
        }
    }

    @Override
    protected void onBeforeCreate(PSSysSearchDEField pSSysSearchDEField) throws Exception {
        pSSysSearchDEField.setPSSysSearchDEFieldName(pSSysSearchDEField.getPSSysSearchFieldName());
        super.onBeforeCreate(pSSysSearchDEField);
    }

    @Override
    protected void onCalcSearchDE(PSSysSearchDEField pSSysSearchDEField) throws Exception {
        if (pSSysSearchDEField.getPSDEF() != null) {
            pSSysSearchDEField.setPSDEId(pSSysSearchDEField.getPSDEF().getPSDEId());
        } else if (pSSysSearchDEField.getPSSysSearchDE() != null) {
            pSSysSearchDEField.setPSDEId(pSSysSearchDEField.getPSSysSearchDE().getPSDEId());
        } else {
            pSSysSearchDEField.setPSDEId(null);
        }
    }

    @Override
    protected void onCalcSearchDoc(PSSysSearchDEField pSSysSearchDEField) throws Exception {
        if (pSSysSearchDEField.getPSSysSearchDE() != null) {
            pSSysSearchDEField.setPSSysSearchDocId(pSSysSearchDEField.getPSSysSearchDE().getPSSysSearchDocId());
        } else {
            pSSysSearchDEField.setPSSysSearchDocId(null);
        }
    }
}

