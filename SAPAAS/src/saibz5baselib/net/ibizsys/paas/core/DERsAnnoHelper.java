/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.HashMap;
import net.ibizsys.paas.core.DER;
import net.ibizsys.paas.core.DERs;

public class DERsAnnoHelper {
    private HashMap<String, DER> derMap = new HashMap();
    private DERs ders = null;

    public DERsAnnoHelper(DERs ders) {
        this.ders = ders;
        DER[] dERArray = this.ders.value();
        int n = dERArray.length;
        int n2 = 0;
        while (n2 < n) {
            DER der = dERArray[n2];
            this.derMap.put(der.id(), der);
            this.derMap.put(der.name(), der);
            ++n2;
        }
    }

    public DER getDER1N(String strName) throws Exception {
        DER der = this.derMap.get(strName);
        return der;
    }
}

