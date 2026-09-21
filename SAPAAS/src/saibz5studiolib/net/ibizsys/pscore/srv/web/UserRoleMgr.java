/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.security.UserRoleMgr
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.psrt.srv.common.entity.UserRoleData
 */
package net.ibizsys.pscore.srv.web;

import java.util.ArrayList;
import net.ibizsys.paas.service.IService;
import net.ibizsys.psrt.srv.common.entity.UserRoleData;

public class UserRoleMgr
extends net.ibizsys.paas.security.UserRoleMgr {
    private static final long serialVersionUID = 1L;

    public ArrayList<UserRoleData> getUserRoleDatas(String string, String string2) throws Exception {
        return super.getUserRoleDatas(string, string2);
    }

    public String getUserRoleDataCond(IService iService, UserRoleData userRoleData) throws Exception {
        return super.getUserRoleDataCond(iService, userRoleData);
    }
}

