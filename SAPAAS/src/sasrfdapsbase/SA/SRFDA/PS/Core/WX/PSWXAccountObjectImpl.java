/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswx.core.IWXAccount
 */
package SA.SRFDA.PS.Core.WX;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Core.WX.IPSWXAccountObject;
import net.ibizsys.pswx.core.IWXAccount;

public abstract class PSWXAccountObjectImpl
extends PSObjectImpl
implements IPSWXAccountObject {
    private IPSWXAccount iPSWXAccount = null;

    @Override
    public IPSWXAccount getPSWXAccount() {
        return this.iPSWXAccount;
    }

    protected void setPSWXAccount(IPSWXAccount iPSWXAccount) {
        this.iPSWXAccount = iPSWXAccount;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSWXAccount().getPSSysModelInstId();
    }

    @Override
    public IWXAccount getWXAccount() {
        return this.getPSWXAccount();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSWXAccount();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSWXAccount();
    }

    @Override
    protected String onGetDynaModelFolder() {
        return null;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }
}

