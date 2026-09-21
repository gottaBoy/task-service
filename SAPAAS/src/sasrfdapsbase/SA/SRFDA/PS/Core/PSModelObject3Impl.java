/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelObject3;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSModelObject3Impl
extends PSObjectImpl
implements IPSModelObject3 {
    private Map<String, IPSModelObject> refPSModelObjectMap = null;

    @Override
    public void registerRefPSModelObject(IPSModelObject iPSModelObject) {
        String strTag;
        if (iPSModelObject == null) {
            return;
        }
        if (this.refPSModelObjectMap == null) {
            ConcurrentHashMap<String, IPSModelObject> refPSModelObjectMap = new ConcurrentHashMap<String, IPSModelObject>();
            if (this.refPSModelObjectMap == null) {
                this.refPSModelObjectMap = refPSModelObjectMap;
            }
        }
        if (this.refPSModelObjectMap.containsKey(strTag = StringHelper.format((String)"%1$s|%2$s", (Object)iPSModelObject.getModelType(), (Object)iPSModelObject.getModelId()))) {
            return;
        }
        this.refPSModelObjectMap.put(strTag, iPSModelObject);
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6a21\u578b\u96c6\u5408", outputdoc="(%1$s.getRefPSModelObjects()?? && (srflist(%1$s.getRefPSModelObjects())?size gt 0))")
    public Iterator<IPSModelObject> getRefPSModelObjects() {
        if (this.refPSModelObjectMap == null || this.refPSModelObjectMap.size() == 0) {
            return null;
        }
        return this.refPSModelObjectMap.values().iterator();
    }
}

