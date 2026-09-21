/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Map;

import SA.SRFDA.PS.Core.Control.Map.IPSMap;
import SA.SRFDA.PS.Core.Control.PSMDAjaxControlContainerImpl2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSMapImpl
extends PSMDAjaxControlContainerImpl2
implements IPSMap {
    private static final Log log = LogFactory.getLog(PSMapImpl.class);

    @Override
    protected String onGetControlType() {
        return "MAP";
    }
}

