/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDERIndex;
import net.ibizsys.paas.demodel.DERBaseModel;

public class DERIndexModel
extends DERBaseModel
implements IDERIndex {
    @Override
    public String getTypeValue() {
        return this.der.indexvalue();
    }
}

