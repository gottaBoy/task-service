/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.drctrl;

import java.util.Iterator;
import net.ibizsys.model.control.drctrl.IPSDEDRBar;
import net.ibizsys.model.control.drctrl.IPSDEDRBarItem;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.dr.IPSDEDRGroup;
import net.ibizsys.model.res.IPSLanguageRes;

public interface IPSDEDRBarGroup
extends IPSModelObject {
    public IPSDEDRBar getPSDEDRBar();

    public String getCaption();

    public Iterator<IPSDEDRBarItem> getPSDEDRBarItems();

    public IPSDEDRGroup getPSDEDRGroup();

    public boolean isHidden();

    public IPSLanguageRes getCapPSLanguageRes();
}

