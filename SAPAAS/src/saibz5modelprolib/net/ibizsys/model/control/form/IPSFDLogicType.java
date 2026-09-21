/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFDLogic
 *  net.ibizsys.model.core.IPSModelObject
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.form.IPSDEFDLogic;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSDEFDLogic;
import net.ibizsys.model.entity.PSFDLogicType;

public interface IPSFDLogicType
extends IPSModelObject {
    public void init(IPSModelStorageContext var1, PSFDLogicType var2) throws Exception;

    public IPSDEFDLogic createPSDEFDLogic(PSDEFDLogic var1) throws Exception;
}

