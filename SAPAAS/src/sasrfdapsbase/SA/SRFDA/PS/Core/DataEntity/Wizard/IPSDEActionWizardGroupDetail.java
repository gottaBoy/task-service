/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizard;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizardGroup;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEAWGrpDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelIgnoreMeta
public interface IPSDEActionWizardGroupDetail
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSDEActionWizardGroup var2, PSDEAWGrpDetail var3) throws Exception;

    public IPSDEActionWizardGroup getPSDEActionWizardGroup();

    public IPSDEActionWizard getPSDEActionWizard() throws Exception;
}

