/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util;

import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstRef;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;

public interface IPSDCDBInstOwnerListener {
    public void onPSDCDBInstChanged(PSDCDBInstRef var1, PSDevCenterDBInst var2, PSDevCenterDBInst var3) throws Exception;
}

