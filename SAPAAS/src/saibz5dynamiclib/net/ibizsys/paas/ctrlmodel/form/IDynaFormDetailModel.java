/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDynaModel
 */
package net.ibizsys.paas.ctrlmodel.form;

import net.ibizsys.paas.core.IDynaModel;
import net.ibizsys.paas.core.IDynaModelJsonExporter;
import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.paas.ctrlmodel.IDynaFormModel;

public interface IDynaFormDetailModel
extends IDynaModel,
IDynaModelJsonExporter,
IDynaModelJsonLoader {
    public static final String ATTR_SHOWCAPTION = "showcaption";
    public static final String ATTR_COLXS = "colxs";
    public static final String ATTR_COLSM = "colsm";
    public static final String ATTR_COLMD = "colmd";
    public static final String ATTR_COLLG = "collg";
    public static final String ATTR_COLXSOFFSET = "colxsoffset";
    public static final String ATTR_COLSMOFFSET = "colsmoffset";
    public static final String ATTR_COLMDOFFSET = "colmdoffset";
    public static final String ATTR_COLLGOFFSET = "collgoffset";
    public static final String DETAILTYPE_FORMPAGE = "FORMPAGE";
    public static final String DETAILTYPE_TABPANEL = "TABPANEL";
    public static final String DETAILTYPE_TABPAGE = "TABPAGE";
    public static final String DETAILTYPE_FORMITEM = "FORMITEM";
    public static final String DETAILTYPE_USERCONTROL = "USERCONTROL";
    public static final String DETAILTYPE_FORMPART = "FORMPART";
    public static final String DETAILTYPE_GROUPPANEL = "GROUPPANEL";
    public static final String DETAILTYPE_DRUIPART = "DRUIPART";
    public static final String DETAILTYPE_BUTTON = "BUTTON";
    public static final String DETAILTYPE_RAWITEM = "RAWITEM";

    public void init(IDynaFormModel var1, IDynaFormDetailModel var2, Object var3) throws Exception;

    public String getDetailType();

    public IDynaFormModel getDynaFormModel();

    public IDynaFormDetailModel getParentModel();

    public int getColXS();

    public int getColSM();

    public int getColMD();

    public int getColLG();

    public int getColXSOffset();

    public int getColSMOffset();

    public int getColMDOffset();

    public int getColLGOffset();

    public double getWidth();

    public double getHeight();

    public String getCaption();

    public boolean isShowCaption();
}

