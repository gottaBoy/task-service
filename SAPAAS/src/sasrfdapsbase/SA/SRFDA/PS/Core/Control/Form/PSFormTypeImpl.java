/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEForm;
import SA.SRFDA.PS.Core.Control.Form.IPSFormType;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEForm;
import SA.SRFDA.PS.Data.PSFormType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSFormTypeImpl
extends PSObjectImpl
implements IPSFormType {
    protected PSFormType psFormType = null;
    private static final Log log = LogFactory.getLog(PSFormTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSFormType psFormType) throws Exception {
        this.psFormType = psFormType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psFormType.getPSFORMTYPEID());
        this.setName(psFormType.getPSFORMTYPENAME());
        this.onInit();
    }

    @Override
    public IPSDEForm createPSDEForm(PSDEForm psDEForm) throws Exception {
        return (IPSDEForm)ObjectHelper.Create((String)this.psFormType.getFORMOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

