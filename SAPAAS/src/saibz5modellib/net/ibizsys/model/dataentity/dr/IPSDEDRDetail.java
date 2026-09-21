/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.dataentity.dr;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.dr.IPSDEDRItem;
import net.ibizsys.model.dataentity.dr.IPSDEDataRelation;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.res.IPSSysPDTView;

public interface IPSDEDRDetail
extends IPSModelObject {
    public static final String DETAILTYPE_DRITEM = "DRITEM";
    public static final String DETAILTYPE_PDTVIEW = "PDTVIEW";

    public IPSDEDataRelation getPSDEDR();

    public String getCaption();

    public String getCaption(String var1);

    public String getDetailType();

    public String getPSDEDRGroupId();

    public String getPSDEViewId();

    public String getPSDEDRItemId();

    public IPSDEDRItem getPSDEDRItem();

    public IPSSysPDTView getPSSysPDTView();

    public IPSSysImage getPSSysImage();

    public String getEnableMode();

    public String getCounterId();

    public IPSDEAction getTestPSDEAction();

    public IPSDEOPPriv getTestPSDEOPPriv();

    public IPSLanguageRes getCapPSLanguageRes();
}

