/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.dr;

import java.util.Iterator;
import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.dr.IPSDEDRDetail;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysImage;

public interface IPSDEDataRelation
extends IPSDataEntityObject {
    public Iterator<IPSDEDRDetail> getPSDEDRDetails();

    public String getCodeName();

    public String getPSSysCounterId();

    public String getFormPSDEViewBaseId();

    public String getFormCaption();

    public IPSLanguageRes getFormCapPSLanguageRes();

    public IPSSysImage getFormPSSysImage();

    public boolean isHideEditItem();
}

