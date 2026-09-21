/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.form;

import java.util.Iterator;
import net.ibizsys.model.control.form.IPSDEFIUpdateDetail;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;

public interface IPSDEFormItemUpdate
extends IPSModelObject {
    public IPSDEForm getPSDEForm();

    public String getCodeName();

    public Iterator<IPSDEFIUpdateDetail> getPSDEFIUpdateDetails();

    public IPSDEAction getPSDEAction() throws Exception;
}

