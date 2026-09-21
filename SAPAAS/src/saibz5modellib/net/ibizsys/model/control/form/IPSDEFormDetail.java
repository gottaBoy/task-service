/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.control.form.IPSDEFDGroupLogic;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;

public interface IPSDEFormDetail
extends IPSModelObject {
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
    public static final String DETAILSTYLE_DEFAULT = "DEFAULT";
    public static final String DETAILSTYLE_STYLE2 = "STYLE2";
    public static final String DETAILSTYLE_STYLE3 = "STYLE3";
    public static final String DETAILSTYLE_STYLE4 = "STYLE4";
    public static final String BORERLAYOUTPOS_NORTH = "NORTH";
    public static final String BORERLAYOUTPOS_WEST = "WEST";
    public static final String BORERLAYOUTPOS_EAST = "EAST";
    public static final String BORERLAYOUTPOS_SOUTH = "SOUTH";
    public static final String BORERLAYOUTPOS_CENTER = "CENTER";

    public String getCodeName();

    public String getUniqueId();

    public IPSDEFormDetail getParentPSDEFormDetail();

    public String getCaption();

    public boolean isShowCaption();

    public IPSDEForm getPSDEForm();

    public String getDetailType();

    public double getContentWidth();

    public double getContentHeight();

    public double getWidth();

    public double getHeight();

    public String getParentLayoutMode();

    public IPSDEFDGroupLogic getPSDEFDGroupLogic(String var1) throws Exception;

    public String getCssStyle();

    public int getColSpan() throws Exception;

    public int getRowSpan() throws Exception;

    public int getColXS();

    public int getColSM();

    public int getColMD();

    public int getColLG();

    public int getColXSOffset();

    public int getColSMOffset();

    public int getColMDOffset();

    public int getColLGOffset();

    public String getColCssClass();

    public IPSSysCss getPSSysCss();

    public IPSSysImage getPSSysImage();

    public IPSSysCss getLabelPSSysCss();

    public IPSLanguageRes getCapPSLanguageRes();

    public String getCapLanResTag();

    public int getColWidth();

    public IPSDEFormDetail getRootPSDEFormDetail();

    public String getUserTag();

    public String getUserTag2();

    public String getDetailStyle();

    public String getBorderLayoutPos();
}

