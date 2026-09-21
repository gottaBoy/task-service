/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.psrt.srv.common.service;

import java.util.ArrayList;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psrt.srv.common.entity.CodeList;
import net.ibizsys.psrt.srv.common.entity.UserDict;
import net.ibizsys.psrt.srv.common.entity.UserDictCat;
import net.ibizsys.psrt.srv.common.service.CodeListService;
import net.ibizsys.psrt.srv.common.service.UserDictCatService;
import net.ibizsys.psrt.srv.common.service.UserDictServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class UserDictService
extends UserDictServiceBase {
    private static final Log log = LogFactory.getLog(UserDictService.class);

    @Override
    protected void onReloadCurUser(UserDict userDict) throws Exception {
        IWebContext iWebContext = this.getWebContext();
        if (iWebContext == null) {
            throw new Exception(StringHelper.format("\u5f53\u524d\u7528\u6237\u8eab\u4efd\u65e0\u6548"));
        }
        UserDictCatService userDictCatService = (UserDictCatService)ServiceGlobal.getService(UserDictCatService.class, this.getSessionFactory());
        CodeListService codeListService = (CodeListService)ServiceGlobal.getService(CodeListService.class, this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList userDictCatList = userDictCatService.select(selectCond);
        for (UserDictCat userDictCat : userDictCatList) {
            try {
                String strUserDictCatCodeListId = UserDictCatService.calcUserDictCatCodeListId(userDictCat.getUserDictCatId());
                CodeList codeList = new CodeList();
                codeList.setCodeListId(strUserDictCatCodeListId);
                codeListService.refreshModel(codeList);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format("\u5237\u65b0\u7528\u6237\u8bcd\u6761[%1$s]\u4ee3\u7801\u8868\u53d1\u751f\u5f02\u5e38\uff0c%2$s", userDictCat.getUserDictCatName(), ex.getMessage()), (Throwable)ex);
            }
        }
    }
}

