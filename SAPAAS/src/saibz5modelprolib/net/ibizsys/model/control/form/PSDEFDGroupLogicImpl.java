/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFDGroupLogic
 *  net.ibizsys.model.control.form.IPSDEFDLogic
 */
package net.ibizsys.model.control.form;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.control.form.IPSDEFDGroupLogic;
import net.ibizsys.model.control.form.IPSDEFDLogic;
import net.ibizsys.model.control.form.PSDEFDLogicImpl;
import net.ibizsys.model.entity.PSDEFDLogic;

public class PSDEFDGroupLogicImpl
extends PSDEFDLogicImpl
implements IPSDEFDGroupLogic {
    protected ArrayList<IPSDEFDLogic> psDEFDLogicList = new ArrayList();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDEFDLogics();
    }

    protected void onPreparePSDEFDLogics() throws Exception {
        ArrayList<PSDEFDLogic> psDEFDLogicList = this.psDEFDLogic.getChildPSDEFDLogics(false);
        if (psDEFDLogicList == null) {
            return;
        }
        for (PSDEFDLogic psDEFDLogic : psDEFDLogicList) {
            IPSDEFDLogic iPSDEFDLogic = this.getPSModelStorageContext().createPSDEFDLogic(this.iPSDEFormDetail, this, psDEFDLogic);
            this.psDEFDLogicList.add(iPSDEFDLogic);
        }
    }

    public String getGroupOP() {
        return this.psDEFDLogic.getGROUPOP();
    }

    public boolean isNotMode() {
        return this.psDEFDLogic.getGROUPNOTFLAG();
    }

    public Iterator<IPSDEFDLogic> getPSDEFDLogics() {
        if (this.psDEFDLogicList == null || this.psDEFDLogicList.size() == 0) {
            return null;
        }
        return this.psDEFDLogicList.iterator();
    }
}

