/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import net.ibizsys.paas.core.IDEField;
import net.ibizsys.psba.core.IBAColSet;
import net.ibizsys.psba.core.IBATableDE;
import net.ibizsys.psba.core.IBATableObject;

public interface IBAColumn
extends IBATableObject {
    public static final String UNIONKEYVALUE_KEY1 = "KEY1";
    public static final String UNIONKEYVALUE_KEY2 = "KEY2";
    public static final String UNIONKEYVALUE_KEY3 = "KEY3";
    public static final String UNIONKEYVALUE_KEY4 = "KEY4";

    public IDEField getDEField();

    public IBAColSet getBAColSet();

    public IBATableDE getBATableDE();

    public String getDBValueFunc();

    public String getDEFieldName();

    public String getDEName();

    public String getBAColSetName();

    public String getPreDefinedType();

    public boolean isEnableTempData();

    public int getStdDataType();

    public String getUnionKeyValue();

    public String getBATableDEId();
}

