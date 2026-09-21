/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.SqlParamList
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewRefServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppDEViewRefService
extends PSAppDEViewRefServiceBase {
    private static final Log log = LogFactory.getLog(PSAppDEViewRefService.class);

    @Override
    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        String string = "DELETE FROM T_SRFPSAPPDEVIEWREF WHERE PSSYSAPPID=? ";
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSSysApp.getPSSysAppId());
        this.getDAO().executeRawSql(null, string, sqlParamList);
    }
}

