/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util;

import net.ibizsys.pscore.srv.codelist.DCLevelCodeListModel;
import net.ibizsys.pscore.srv.util.IPSDevUser;
import net.ibizsys.pscore.srv.util.PSDevUserBase;

public class PSDevUser
extends PSDevUserBase
implements IPSDevUser {
    public static final PSDevUser ACCESSDENY = new PSDevUser();
    private int nAccMode = 0;
    private String strPSDCInstId = null;
    private boolean bDefaultMode = false;
    private boolean bAdminMode = false;
    private String strPSDCType = "DEVCENTER";
    private int nPSDCLevel = DCLevelCodeListModel.PROFESSIONAL;

    @Override
    public int getAccMode() {
        return this.nAccMode;
    }

    public void setAccMode(int n) {
        this.nAccMode = n;
    }

    @Override
    public String getPSDCInstId() {
        return this.strPSDCInstId;
    }

    public void setPSDCInstId(String string) {
        this.strPSDCInstId = string;
    }

    @Override
    public boolean isShareAccMode() {
        return (this.getAccMode() & 5) == 5;
    }

    @Override
    public boolean isMaintainAccMode() {
        return (this.getAccMode() & 0xB) == 11;
    }

    @Override
    public boolean isDefaultMode() {
        return this.bDefaultMode;
    }

    public void setDefaultMode(boolean bl) {
        this.bDefaultMode = bl;
    }

    @Override
    public boolean isAdminMode() {
        return this.bAdminMode;
    }

    public void setAdminMode(boolean bl) {
        this.bAdminMode = bl;
    }

    @Override
    public String getPSDCType() {
        return this.strPSDCType;
    }

    public void setPSDCType(String string) {
        this.strPSDCType = string;
    }

    @Override
    public int getPSDCLevel() {
        return this.nPSDCLevel;
    }

    public void setPSDCLevel(int n) {
        this.nPSDCLevel = n;
    }
}

