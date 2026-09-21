/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlType
 *  net.ibizsys.model.control.IPSEditorType
 *  net.ibizsys.model.control.counter.IPSCounter
 *  net.ibizsys.model.control.counter.IPSCounterType
 *  net.ibizsys.model.control.form.IPSDEFDLogic
 *  net.ibizsys.model.control.form.IPSDEForm
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.model.control.grid.IPSDEGrid
 *  net.ibizsys.model.control.grid.IPSDEGridColumn
 *  net.ibizsys.model.control.toolbar.IPSDEToolbar
 *  net.ibizsys.model.control.toolbar.IPSDEToolbarItem
 *  net.ibizsys.model.data.IPSDBValueOP
 *  net.ibizsys.model.res.IPSPortletType
 *  net.ibizsys.model.view.IPSViewType
 */
package net.ibizsys.model;

import net.ibizsys.model.control.IPSControlType;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.control.counter.IPSCounter;
import net.ibizsys.model.control.counter.IPSCounterType;
import net.ibizsys.model.control.form.IPSDEFDLogic;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSFDLogicType;
import net.ibizsys.model.control.form.IPSFormDetailType;
import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.control.grid.IPSDEGridColumnType;
import net.ibizsys.model.control.menu.IPSAppMenuItemType;
import net.ibizsys.model.control.toolbar.IPSDEToolbar;
import net.ibizsys.model.control.toolbar.IPSDEToolbarItem;
import net.ibizsys.model.control.toolbar.IPSToolbarItemType;
import net.ibizsys.model.data.IPSDBValueOP;
import net.ibizsys.model.dataentity.action.IPSDEActionType;
import net.ibizsys.model.dataentity.dr.IPSDRItemType;
import net.ibizsys.model.dataentity.field.IPSDEFieldType;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRuleType;
import net.ibizsys.model.dataentity.logic.IPSDELogicLinkCondType;
import net.ibizsys.model.dataentity.logic.IPSDELogicNodeType;
import net.ibizsys.model.der.IPSDERType;
import net.ibizsys.model.entity.PSDEFDLogic;
import net.ibizsys.model.entity.PSDEFormDetail;
import net.ibizsys.model.entity.PSDEGridColumn;
import net.ibizsys.model.entity.PSDEToolbarItem;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFPluginTempl;
import net.ibizsys.model.res.IPSPortletType;
import net.ibizsys.model.view.IPSViewType;
import net.ibizsys.model.wf.IPSWFLinkCondType;
import net.ibizsys.model.wf.IPSWFLinkType;
import net.ibizsys.model.wf.IPSWFProcessType;

public interface IPSModelStorageContext {
    public IPSEditorType getPSEditorType(String var1) throws Exception;

    public IPSDEFDLogic createPSDEFDLogic(IPSDEFormDetail var1, IPSDEFDLogic var2, PSDEFDLogic var3) throws Exception;

    public IPSDEFormDetail createPSDEFormDetail(IPSDEForm var1, IPSDEFormDetail var2, PSDEFormDetail var3) throws Exception;

    public IPSDEGridColumn createPSDEGridColumn(IPSDEGrid var1, IPSDEGridColumn var2, PSDEGridColumn var3) throws Exception;

    public IPSDEToolbarItem createPSDEToolbarItem(IPSDEToolbar var1, IPSDEToolbarItem var2, PSDEToolbarItem var3) throws Exception;

    public IPSDBValueOP getPSDBValueOP(String var1) throws Exception;

    public IPSPortletType getPSPortletType(String var1) throws Exception;

    public IPSDEActionType getPSDEActionType(String var1) throws Exception;

    public IPSDELogicNodeType getPSDELogicNodeType(String var1) throws Exception;

    public IPSDELogicLinkCondType getPSDELogicLinkCondType(String var1) throws Exception;

    public IPSDRItemType getPSDRItemType(String var1) throws Exception;

    public IPSDEFieldType getPSDEFieldType(String var1) throws Exception;

    public IPSDEFieldType getPSDEFieldTypeByTag(String var1) throws Exception;

    public IPSDEFValueRuleType getPSDEFValueRuleType(String var1) throws Exception;

    public IPSDERType getPSDERType(String var1) throws Exception;

    public IPSViewType getPSViewType(String var1) throws Exception;

    public IPSWFLinkType getPSWFLinkType(String var1) throws Exception;

    public IPSWFLinkCondType getPSWFLinkCondType(String var1) throws Exception;

    public IPSWFProcessType getPSWFProcessType(String var1) throws Exception;

    public IPSCounterType getPSCounterType(String var1) throws Exception;

    public IPSCounter getPSCounter(String var1) throws Exception;

    public IPSControlType getPSControlType(String var1) throws Exception;

    public IPSAppMenuItemType getPSAppMenuItemType(String var1) throws Exception;

    public IPSToolbarItemType getPSToolbarItemType(String var1) throws Exception;

    public IPSFormDetailType getPSFormDetailType(String var1) throws Exception;

    public IPSFDLogicType getPSFDLogicType(String var1) throws Exception;

    public IPSDEGridColumnType getPSDEGridColumnType(String var1) throws Exception;

    public IPSPF getPSPF(String var1) throws Exception;

    public IPSPFPluginTempl getPSPFPluginTempl(String var1) throws Exception;

    public IPSPFPluginTempl getPSPFPluginTempl(String var1, boolean var2) throws Exception;

    public Object createObject(String var1) throws Exception;
}

