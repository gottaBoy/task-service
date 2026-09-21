/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEActionWizardItem
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizard;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEAWItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEActionWizardItem;

@PSModelPFIgnoreMeta
@PSModelIgnoreMeta
public interface IPSDEActionWizardItem
extends IPSModelObject,
IDEActionWizardItem {
    public void init(ISRFDAGlobalHelper var1, IPSDEActionWizard var2, PSDEAWItem var3) throws Exception;

    public IPSDEActionWizard getPSDEActionWizard();

    public String getPSDEFieldId();

    public IPSDEField getPSDEField() throws Exception;
}

