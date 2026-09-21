/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import java.util.Iterator;
import net.ibizsys.pswf.core.IWFLinkCondModel;

public interface IWFLinkGroupCondModel
extends IWFLinkCondModel {
    public String getGroupOP();

    public boolean isNotMode();

    public Iterator<IWFLinkCondModel> getWFLinkCondModels();
}

