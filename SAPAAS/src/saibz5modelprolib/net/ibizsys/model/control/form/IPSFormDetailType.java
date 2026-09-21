/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.model.core.IPSModelObject
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSDEFormDetail;
import net.ibizsys.model.entity.PSFormDetailType;

public interface IPSFormDetailType
extends IPSModelObject {
    public void init(IPSModelStorageContext var1, PSFormDetailType var2) throws Exception;

    public IPSDEFormDetail createPSDEFormDetail(PSDEFormDetail var1) throws Exception;

    public boolean isRootFDType();

    public boolean isSupportPFDType(String var1);
}

