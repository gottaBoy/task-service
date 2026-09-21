/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFLinkCondModel;

public interface IWFLinkSingleCondModel
extends IWFLinkCondModel {
    public String getFieldName() throws Exception;

    public String getCondOP();

    public String getParamType();

    public String getParamValue();
}

