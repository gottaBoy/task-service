/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.dr;

import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysImage;

public interface IPSDEDRGroup
extends IPSDataEntityObject {
    public String getCaption();

    public String getCaption(String var1);

    public IPSSysImage getPSSysImage();

    public IPSLanguageRes getCapPSLanguageRes();

    public boolean isHidden();
}

