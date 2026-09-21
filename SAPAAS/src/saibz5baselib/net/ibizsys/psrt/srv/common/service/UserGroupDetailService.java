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
import net.ibizsys.psrt.srv.common.entity.UserGroupDetail;
import net.ibizsys.psrt.srv.common.service.UserGroupDetailServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class UserGroupDetailService
extends UserGroupDetailServiceBase {
    private static final Log log = LogFactory.getLog(UserGroupDetailService.class);

    @Override
    protected void onBeforeCreate(UserGroupDetail et) throws Exception {
        if (!StringHelper.isNullOrEmpty(et.getUserObjectName())) {
            et.setUserGroupDetailName(et.getUserObjectName());
        }
        super.onBeforeCreate(et);
    }
}

