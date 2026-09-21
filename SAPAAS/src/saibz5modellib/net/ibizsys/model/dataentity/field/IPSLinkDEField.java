/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.der.IPSDERBase;

public interface IPSLinkDEField
extends IPSDEField {
    public IPSDEField getRelatedPSDEField() throws Exception;

    public IPSDEField getRealPSDEField() throws Exception;

    public IPSDEField getRealPSDEField(boolean var1) throws Exception;

    public IPSDERBase getPSDER() throws Exception;

    public String getDERId();
}

