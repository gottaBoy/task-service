/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.common.entity;

import java.util.ArrayList;
import java.util.TreeMap;
import net.ibizsys.psrt.srv.common.entity.UserRoleDataBase;
import net.ibizsys.psrt.srv.common.entity.UserRoleDataDetail;

public class UserRoleData
extends UserRoleDataBase {
    private TreeMap<String, Boolean> actionsMap = new TreeMap();
    protected ArrayList<UserRoleDataDetail> dataDetails = new ArrayList();

    public void addAction(String strAction, Boolean bAllow) {
        this.actionsMap.put(strAction.toUpperCase(), bAllow);
    }

    public boolean containsAction(String strAction) {
        return this.actionsMap.containsKey(strAction.toUpperCase());
    }

    public boolean getAction(String strAction) {
        if (this.containsAction(strAction)) {
            return this.actionsMap.get(strAction.toUpperCase());
        }
        return false;
    }

    public ArrayList<UserRoleDataDetail> getDetailList() {
        return this.dataDetails;
    }
}

