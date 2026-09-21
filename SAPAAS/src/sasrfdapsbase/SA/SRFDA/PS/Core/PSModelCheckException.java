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

public class PSModelCheckException
extends Exception {
    private IPSModelObject iPSModelObject = null;
    private String strMessage = null;
    private boolean bCritical = false;

    public PSModelCheckException(IPSModelObject iPSModelObject, Exception ex) {
        super(ex);
        this.iPSModelObject = iPSModelObject;
        String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)iPSModelObject.getModelType()), (Object)iPSModelObject.getFullModelName());
        this.strMessage = StringHelper.format((String)"%1$s\u6a21\u578b\u68c0\u67e5\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strLogName, (Object)ex.getMessage());
    }

    public PSModelCheckException(IPSModelObject iPSModelObject, Exception ex, boolean bCritical) {
        super(ex);
        this.iPSModelObject = iPSModelObject;
        this.bCritical = bCritical;
        String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)iPSModelObject.getModelType()), (Object)iPSModelObject.getFullModelName());
        this.strMessage = StringHelper.format((String)"%1$s\u6a21\u578b\u68c0\u67e5\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strLogName, (Object)ex.getMessage());
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

