/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemUserRoleModel;
import net.ibizsys.paas.sysmodel.SystemModelObjectBase;
import net.ibizsys.paas.web.IWebContext;

public abstract class SystemUserRoleModelBase
extends SystemModelObjectBase
implements ISystemUserRoleModel {
    private String strRoleTag = null;
    private HashMap<String, String> sysUniResMap = new HashMap();

    @Override
    public void init(ISystemModel iSystemModel) throws Exception {
        this.setSystemModel(iSystemModel);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public String getRoleTag() {
        return this.strRoleTag;
    }

    public void setRoleTag(String strRoleTag) {
        this.strRoleTag = strRoleTag;
    }

    @Override
    public Iterator<String> getUniResTags() {
        if (this.sysUniResMap.size() == 0) {
            return null;
        }
        return this.sysUniResMap.keySet().iterator();
    }

    @Override
    public void registerUniResTag(String strUniResTag) {
        this.sysUniResMap.put(strUniResTag, "");
    }

    @Override
    public boolean testCurUser(IWebContext iWebContext) throws Exception {
        return false;
    }

    @Override
    public boolean testUniResTag(String strUniResTag) throws Exception {
        return this.sysUniResMap.containsKey(strUniResTag);
    }
}

