/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl2;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherMacro;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSCodePublisherMacroImplBase
extends PSObjectImpl2
implements IPSCodePublisherMacro {
    private IPSModelObject iPSModelObject = null;
    private Object objValue = null;

    public PSCodePublisherMacroImplBase(IPSModelObject iPSModelObject, String strKey, Object objValue) {
        this.iPSModelObject = iPSModelObject;
        this.setId(strKey);
        this.setName(strKey);
        this.objValue = objValue;
    }

    @Override
    @PSModelRTMeta(description="\u952e\u540d", order=100)
    public String getKey() {
        return this.getName();
    }

    @Override
    @PSModelRTMeta(description="\u503c", order=110)
    public Object getValue() {
        return this.objValue;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSModelObject.getPSSysModelInstId();
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.iPSModelObject.getModelId(), (Object)this.getName());
    }

    public IPSModelObject getPSModelObject() {
        return this.iPSModelObject;
    }
}

