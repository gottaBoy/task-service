/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.cache;

import net.ibizsys.paas.core.IModelBase2;

public interface IUniState
extends IModelBase2 {
    public static final String UNISTATETYPE_DE = "DE";
    public static final String STATE = "STATE";
    public static final String STATE2 = "STATE2";
    public static final String STATE3 = "STATE3";
    public static final String STATE4 = "STATE4";
    public static final String STATE5 = "STATE5";
    public static final String STATE6 = "STATE6";
    public static final String STATE7 = "STATE7";
    public static final String STATE8 = "STATE8";

    public String getUniqueTag();

    public String getDEName();

    public String getKeyField();

    public String getFolderField();

    public String getFolder2Field();

    public String getFolder3Field();

    public String getStateField();

    public String getState2Field();

    public String getState3Field();

    public String getState4Field();

    public String getState5Field();

    public String getState6Field();

    public String getState7Field();

    public String getState8Field();

    public String getUniStateType();
}

