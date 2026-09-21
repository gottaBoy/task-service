/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEForm
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.control.form.IPSFormType;
import net.ibizsys.model.entity.PSDEForm;
import net.ibizsys.model.entity.PSFormType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSFormTypeImpl
extends PSObjectImpl
implements IPSFormType {
    protected PSFormType psFormType = null;
    private static final Log log = LogFactory.getLog(PSFormTypeImpl.class);

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSFormType psFormType) throws Exception {
        this.psFormType = psFormType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psFormType.getPSFORMTYPEID());
        this.setName(psFormType.getPSFORMTYPENAME());
        this.onInit();
    }

    @Override
    public IPSDEForm createPSDEForm(PSDEForm psDEForm) throws Exception {
        return (IPSDEForm)this.getPSModelStorageContext().createObject(this.psFormType.getFORMOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

