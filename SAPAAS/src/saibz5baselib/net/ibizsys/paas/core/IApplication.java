/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.core.ISystemObject;

public interface IApplication
extends ISystemObject {
    public static final int APPTYPE_UNKNOWN = 0;
    public static final int APPTYPE_DESKTOP = 1;
    public static final int APPTYPE_MOBILE = 2;
    public static final String PF_EXTJS5 = "EXTJS5";
    public static final String PF_JQUERY = "JQUERY";
    public static final String PF_JQUERY_R2 = "JQUERY_R2";
    public static final String PF_ANGULARJS = "ANGULARJS";
    public static final String PF_ANGULAR = "ANGULAR";
    public static final String PF_IONIC = "IONIC";
    public static final String PF_VUE = "VUE";
    public static final String PF_VUEMOB = "VUEMOB";
    public static final String PF_VUE_R2 = "VUE_R2";
    public static final String PF_VUEMOB_R2 = "VUEMOB_R2";
    public static final String PF_REACT = "REACT";
    public static final String PF_REACTMOB = "REACTMOB";
    public static final String PF_VUE_R3 = "VUE_R3";
    public static final String PF_IONIC4_R6 = "IONIC4_R6";

    @Override
    public ISystem getSystem();

    public String getPFType();
}

