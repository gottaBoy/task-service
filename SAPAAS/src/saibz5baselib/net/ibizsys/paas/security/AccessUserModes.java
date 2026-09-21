/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.security;

public class AccessUserModes {
    public static final Integer UNKNOWN = 0;
    public static final Integer ANONYMOUS = 1;
    public static final Integer LOGINUSER = 2;
    public static final Integer ALLUSER = ANONYMOUS | LOGINUSER;
    public static final Integer LOGINUSERWITHKEY = 4;
}

