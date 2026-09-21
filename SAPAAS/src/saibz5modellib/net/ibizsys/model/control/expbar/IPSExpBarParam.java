/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.expbar;

import net.ibizsys.model.control.IPSAjaxControlParam;

public interface IPSExpBarParam
extends IPSAjaxControlParam {
    public static final String CTRLPARAM_SECTIONNAME = "SECTION.NAME";
    public static final String CTRLPARAM_SECTIONNAMELANRESTAG = "SECTION.NAMELANRESTAG";

    public String getPSSysCounterId();

    public String getTitle();

    public String getTitlePSLanguageResId();

    public Boolean getEnableCounter();
}

