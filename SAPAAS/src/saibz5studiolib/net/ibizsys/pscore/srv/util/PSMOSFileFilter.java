/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.pscore.srv.util;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;

public class PSMOSFileFilter
implements IPSMOSFileFilter {
    private String strQuery = null;
    private boolean bStarQuery = false;

    @Override
    public String getQuery() {
        return this.strQuery;
    }

    public void setQuery(String string) {
        if (StringHelper.compare((String)string, (String)"*", (boolean)false) == 0) {
            this.bStarQuery = true;
            this.strQuery = null;
        } else {
            this.strQuery = string;
            this.bStarQuery = false;
        }
    }

    @Override
    public boolean isStarQuery() {
        return this.bStarQuery;
    }
}

