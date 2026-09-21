/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.security;

import java.util.ArrayList;
import net.ibizsys.paas.core.IDEDataRange;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psrt.srv.common.entity.Org;
import net.ibizsys.psrt.srv.common.entity.OrgSector;
import net.ibizsys.psrt.srv.common.entity.UserRoleData;

public interface IUserRoleMgr {
    public void init(IWebContext var1) throws Exception;

    public String getUserId();

    public Org getOrg() throws Exception;

    public OrgSector getOrgSector() throws Exception;

    public ArrayList<UserRoleData> getUserRoleDatas(String var1, String var2) throws Exception;

    public boolean testUserRoleUniRes(String var1, String var2) throws Exception;

    public boolean testUserRoleDataAction(IDataEntityModel var1, IEntity var2, String var3) throws Exception;

    public boolean testUserRoleDataAction(String var1, IEntity var2, String var3) throws Exception;

    public int testUserRoleDEField(String var1, String var2) throws Exception;

    public String getUserRoleDataCond(IService var1, UserRoleData var2) throws Exception;

    public String getUserRoleDataCond(IService var1, UserRoleData var2, IDEDataSetFetchContext var3) throws Exception;

    public String getDEDataRangeCond(IService var1, IDEDataRange var2) throws Exception;

    public String getDEDataRangeCond(IService var1, IDEDataRange var2, IDEDataSetFetchContext var3) throws Exception;
}

