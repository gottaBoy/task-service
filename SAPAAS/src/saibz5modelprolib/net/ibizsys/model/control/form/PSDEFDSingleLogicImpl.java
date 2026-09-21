/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFDSingleLogic
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.control.form.IPSDEFDSingleLogic;
import net.ibizsys.model.control.form.PSDEFDLogicImpl;

public class PSDEFDSingleLogicImpl
extends PSDEFDLogicImpl
implements IPSDEFDSingleLogic {
    public String getDEFDName() {
        return this.psDEFDLogic.getFDNAME();
    }

    public String getPSDBValueOPId() {
        return this.psDEFDLogic.getPSDBVALUEOPID();
    }

    public String getValue() {
        return this.psDEFDLogic.getCONDVALUE();
    }
}

