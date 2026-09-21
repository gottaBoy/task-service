/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.control.form.IPSDEForm;

public interface IPSDEEditForm
extends IPSDEForm {
    public static final String KEYITEM = "srfkey";
    public static final String MAJORITEM = "srfmajortext";
    public static final String ORIKEYITEM = "srforikey";
    public static final String UFITEM = "srfuf";
    public static final String DEITEM = "srfdeid";
    public static final String SOURCEKEYITEM = "srfsourcekey";
    public static final String UPDATEDATE = "srfupdatedate";
    public static final String TEMPMODEITEM = "srftempmode";

    public boolean isShowFormNavBar();

    public boolean isInfoFormMode();
}

