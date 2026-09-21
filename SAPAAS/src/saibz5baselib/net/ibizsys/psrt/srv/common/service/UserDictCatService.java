/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.psrt.srv.common.service;

import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.psrt.srv.common.service.UserDictCatServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class UserDictCatService
extends UserDictCatServiceBase {
    private static String USERDICTCAT = "USERDICTCAT";
    private static String USERDICTCAT_USER = "USER";
    private static final Log log = LogFactory.getLog(UserDictCatService.class);

    public static String calcUserDictCatCodeListId(String strUserDictCatId) {
        String strId = KeyValueHelper.genUniqueId(USERDICTCAT, USERDICTCAT_USER, strUserDictCatId);
        return strId;
    }
}

