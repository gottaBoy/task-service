/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.psrt.srv.common.service;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.UserRoleDEFields;
import net.ibizsys.psrt.srv.common.service.UserRoleDEFieldsServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class UserRoleDEFieldsService
extends UserRoleDEFieldsServiceBase {
    private static final Log log = LogFactory.getLog(UserRoleDEFieldsService.class);

    @Override
    protected void onBeforeCreate(UserRoleDEFields et) throws Exception {
        if (StringHelper.isNullOrEmpty(et.getUserRoleDEFieldsName()) && et.getUserRoleDEField() != null) {
            et.setUserRoleDEFieldsName(et.getUserRoleDEField().getUserRoleDEFieldName());
        }
        super.onBeforeCreate(et);
    }
}

