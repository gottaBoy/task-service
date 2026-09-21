/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSAjaxControl
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.IPSControlRuntime;
import net.ibizsys.model.control.IPSControlTypeRuntime;
import net.ibizsys.model.control.PSAjaxControlImpl;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSAjaxControlContainerImpl
extends PSAjaxControlImpl
implements IPSControlContainer {
    private HashMap<String, IPSControl> psControlMap = new HashMap();
    private HashMap<String, IPSAjaxControl> psControlMap2 = new HashMap();

    public IPSControl registerPSControl(String strKey, String strPSCtrlType, IPSControlParam iPSControlParam) throws Exception {
        IPSControlTypeRuntime iPSControlType = (IPSControlTypeRuntime)this.getPSModelStorageContext().getPSControlType(strPSCtrlType);
        IPSControlRuntime iPSControl = (IPSControlRuntime)iPSControlType.createPSControl(iPSControlParam);
        iPSControl.init(this.getPSModelStorageContext(), this, strKey, iPSControlParam);
        this.registerPSControl(strKey, iPSControl);
        return iPSControl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void registerPSControl(String strKey, IPSControl iPSControl) {
        HashMap<String, IPSControl> hashMap = this.psControlMap;
        synchronized (hashMap) {
            this.psControlMap.put(strKey, iPSControl);
            if (iPSControl instanceof IPSAjaxControl) {
                this.psControlMap2.put(strKey, (IPSAjaxControl)iPSControl);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public IPSControl getPSControl(String strControlName) throws Exception {
        IPSControl iPSControl = null;
        HashMap<String, IPSControl> hashMap = this.psControlMap;
        synchronized (hashMap) {
            iPSControl = this.psControlMap.get(strControlName);
        }
        if (iPSControl == null) {
            throw new Exception(StringHelper.format((String)"\u89c6\u56fe[%1$s]\u65e0\u6cd5\u83b7\u53d6\u90e8\u4ef6[%2$s]", (Object)this.getPSAppViewRuntime().getFullCodeName(), (Object)strControlName));
        }
        return iPSControl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean hasPSControl(String strControlName) {
        HashMap<String, IPSControl> hashMap = this.psControlMap;
        synchronized (hashMap) {
            return this.psControlMap.containsKey(strControlName);
        }
    }

    @PSModelRTMeta(description="\u90e8\u4ef6\u96c6\u5408", hideempty2=true)
    public Iterator<IPSControl> getPSControls() {
        return this.psControlMap.values().iterator();
    }

    public Iterator<IPSAjaxControl> getPSAjaxControls() {
        return this.psControlMap2.values().iterator();
    }
}

