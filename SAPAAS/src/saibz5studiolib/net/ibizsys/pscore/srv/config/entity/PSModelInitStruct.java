/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.config.entity;

import java.util.ArrayList;
import net.ibizsys.pscore.srv.config.entity.PSMIDetail;
import net.ibizsys.pscore.srv.config.entity.PSModelInit;

public class PSModelInitStruct
extends PSModelInit {
    private ArrayList<PSMIDetail> psMIDetailList = new ArrayList();

    public ArrayList<PSMIDetail> getPSModelInitDetails() {
        return this.psMIDetailList;
    }
}

