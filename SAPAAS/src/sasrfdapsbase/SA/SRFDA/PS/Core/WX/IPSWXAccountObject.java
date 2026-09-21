/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswx.core.IWXAccount
 */
package SA.SRFDA.PS.Core.WX;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import net.ibizsys.pswx.core.IWXAccount;

public interface IPSWXAccountObject
extends IPSModelObject {
    public IPSWXAccount getPSWXAccount();

    public IWXAccount getWXAccount();
}

