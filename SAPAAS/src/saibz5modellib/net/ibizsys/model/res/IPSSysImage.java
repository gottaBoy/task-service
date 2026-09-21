/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.res;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSSysImage
extends IPSSystemObject,
IPSModelObject {
    public String getPSImageTemplId();

    public String getImagePath();

    public String getCssClass();

    public String getImagePathX();

    public String getCssClassX();

    public String getGlyph();

    public String getImagePath(int var1);

    public String getCssClass(int var1);

    public int getWidth();

    public int getHeight();
}

