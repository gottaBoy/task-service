/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 */
package net.ibizsys.model;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSModelObjectRuntime
extends IPSModelObject {
    public static final int DYNAMODELTYPE_NONE = 0;
    public static final int DYNAMODELTYPE_DYNASYS = 1;
    public static final int DYNAMODELTYPE_DYNAINST = 2;

    public IPSModelStorageContext getPSModelStorageContext();

    public String getPSSysModelInstId();

    public int check() throws Exception;

    public void refreshModelVer();

    public String getPSDynaInstId();

    public int getDynaModelType();
}

