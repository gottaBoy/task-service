/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.PSDEEditFormItemImpl;
import net.ibizsys.model.control.form.PSDESearchFormItemImpl;
import net.ibizsys.model.control.form.PSFormDetailTypeImpl;
import net.ibizsys.model.entity.PSDEFormDetail;
import net.ibizsys.paas.util.StringHelper;

public class PSFormItemTypeImpl
extends PSFormDetailTypeImpl {
    @Override
    public IPSDEFormDetail createPSDEFormDetail(PSDEFormDetail psDEFormDetail) throws Exception {
        if (StringHelper.compare((String)psDEFormDetail.getFORMTYPE(), (String)"EDITFORM", (boolean)true) == 0 || StringHelper.compare((String)psDEFormDetail.getFORMTYPE(), (String)"FORM", (boolean)true) == 0) {
            return new PSDEEditFormItemImpl();
        }
        if (StringHelper.compare((String)psDEFormDetail.getFORMTYPE(), (String)"SEARCHFORM", (boolean)true) == 0) {
            return new PSDESearchFormItemImpl();
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8868\u5355\u9879"));
    }
}

