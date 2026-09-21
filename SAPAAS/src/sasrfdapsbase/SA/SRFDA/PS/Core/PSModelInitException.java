/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModels;
import net.ibizsys.paas.util.StringHelper;

public class PSModelInitException
extends Exception {
    private IPSModelObject iPSModelObject = null;
    private String strMessage = null;
    private boolean bCritical = false;

    public PSModelInitException(IPSModelObject iPSModelObject, Exception ex) {
        super(ex);
        this.iPSModelObject = iPSModelObject;
        String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)iPSModelObject.getModelType()), (Object)iPSModelObject.getFullModelName());
        this.strMessage = StringHelper.format((String)"%1$s\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strLogName, (Object)ex.getMessage());
    }

    public PSModelInitException(IPSModelObject iPSModelObject, Exception ex, boolean bCritical) {
        super(ex);
        this.iPSModelObject = iPSModelObject;
        this.bCritical = bCritical;
        String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)iPSModelObject.getModelType()), (Object)iPSModelObject.getFullModelName());
        this.strMessage = StringHelper.format((String)"%1$s\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strLogName, (Object)ex.getMessage());
    }

    public IPSModelObject getPSModelObject() {
        return this.iPSModelObject;
    }

    @Override
    public String getMessage() {
        if (!StringHelper.isNullOrEmpty((String)this.strMessage)) {
            return this.strMessage;
        }
        return super.getMessage();
    }

    public boolean isCritical() {
        return this.bCritical;
    }
}

