/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.demodel.userdict.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.psrt.srv.common.entity.UserDict;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class UserDictReloadCurUserUIActionModelBase
extends DEUIActionModelBase<UserDict> {
    private static final Log log = LogFactory.getLog(UserDictReloadCurUserUIActionModelBase.class);

    public UserDictReloadCurUserUIActionModelBase() {
        this.setId("6BBDD2EC-9323-4984-8A0D-0AA19BAEEF14");
        this.setName("ReloadCurUser");
        this.setActionTarget("NONE");
        this.setDEActionName("ReloadCurUser");
        this.setSuccessMsg("\u91cd\u65b0\u52a0\u8f7d\u5f53\u524d\u7528\u6237\u6210\u529f\uff01");
    }
}

