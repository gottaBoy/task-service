/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Menu;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityRuntime;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationRuntime;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;
import SA.SRFDA.PS.Core.Control.Menu.PSAppMenuItemImplBase;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Data.PSAppFunc;
import SA.SRFDA.PS.Data.PSDEUIAction;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSAppMenuItem", typevalues={"MENUITEM"})
public class PSAppMenuItemImpl
extends PSAppMenuItemImplBase
implements IPSAppMenuItem {
    @Override
    protected void onInit() throws Exception {
        String strActionType;
        if (this.getPSAppFunc() == null && !StringHelper.isNullOrEmpty((String)(strActionType = this.psAppMenuItem.getBTNACTIONTYPE()))) {
            IPSApplication iPSApplication = this.getPSApplication();
            if (iPSApplication == null) {
                throw new Exception("\u524d\u7aef\u5e94\u7528\u5bf9\u8c61\u65e0\u6548");
            }
            PSAppFunc psAppFunc = new PSAppFunc();
            if (this.getPSAppMenu() != null) {
                psAppFunc.setPSAPPFUNCID(String.format("menu_%1$s_%2$s_click", this.getPSAppMenu().getCodeName(), this.getName()).toUpperCase());
                psAppFunc.setCODENAME(String.format("menu_%1$s_%2$s_click", this.getPSAppMenu().getCodeName(), this.getName()));
            } else if (this.getPSAppMenuModel() != null) {
                psAppFunc.setPSAPPFUNCID(String.format("menu_%1$s_%2$s_click", this.getPSAppMenuModel().getCodeName(), this.getName()).toUpperCase());
                psAppFunc.setCODENAME(String.format("menu_%1$s_%2$s_click", this.getPSAppMenuModel().getCodeName(), this.getName()));
            } else {
                throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6240\u5c5e\u83dc\u5355\u5bf9\u8c61");
            }
            psAppFunc.set("AUTOMODEL", 1);
            psAppFunc.setPSAPPFUNCNAME(this.getCaption());
            if (StringHelper.compare((String)strActionType, (String)"OPENVIEW", (boolean)false) == 0) {
                if (StringHelper.isNullOrEmpty((String)this.psAppMenuItem.getOPENPSAPPVIEWID())) {
                    throw new Exception("\u672a\u6307\u5b9a\u5e94\u7528\u89c6\u56fe");
                }
                psAppFunc.setAPPFUNCTYPE("APPVIEW");
                psAppFunc.setPSAPPVIEWID(this.psAppMenuItem.getOPENPSAPPVIEWID());
                psAppFunc.setPSAPPVIEWNAME(this.psAppMenuItem.getOPENPSAPPVIEWNAME());
            } else if (StringHelper.compare((String)strActionType, (String)"UIACTION", (boolean)false) == 0) {
                if (StringHelper.isNullOrEmpty((String)this.psAppMenuItem.getPSDEUIACTIONID())) {
                    throw new Exception("\u672a\u6307\u5b9a\u754c\u9762\u884c\u4e3a");
                }
                psAppFunc.setAPPFUNCTYPE("UIACTION");
                psAppFunc.setPSAPPLOCALDEID(this.psAppMenuItem.getPSAPPLOCALDEID());
                psAppFunc.setPSAPPLOCALDENAME(this.psAppMenuItem.getPSAPPLOCALDENAME());
                psAppFunc.setPSDEID(this.psAppMenuItem.getPSDEID());
                psAppFunc.setPSDEUIACTIONID(this.psAppMenuItem.getPSDEUIACTIONID());
                psAppFunc.setPSDEUIACTIONNAME(this.psAppMenuItem.getPSDEUIACTIONNAME());
            } else {
                IPSAppDEUIAction iPSAppUIAction = null;
                Object iPSDataEntity = null;
                IPSAppDataEntity iPSAppDataEntity = null;
                if (StringHelper.compare((String)strActionType, (String)"UILOGIC", (boolean)false) == 0) {
                    if (StringHelper.isNullOrEmpty((String)this.psAppMenuItem.getPSAPPLOCALDEID())) {
                        throw new Exception("\u672a\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61");
                    }
                    iPSAppDataEntity = iPSApplication.getPSAppDataEntity(this.psAppMenuItem.getPSAPPLOCALDEID(), false);
                }
                if (StringHelper.compare((String)strActionType, (String)"UILOGIC", (boolean)false) == 0) {
                    if (StringHelper.isNullOrEmpty((String)this.psAppMenuItem.getPSDELOGICID())) {
                        throw new Exception("\u672a\u6307\u5b9a\u754c\u9762\u903b\u8f91\u5bf9\u8c61");
                    }
                    IPSAppDEUILogic iPSAppDEUILogic = iPSAppDataEntity.getPSAppDEUILogic(this.psAppMenuItem.getPSDELOGICID());
                    PSDEUIAction psDEUIAction = new PSDEUIAction();
                    psDEUIAction.setPSDEUIACTIONID(psAppFunc.getPSAPPFUNCID());
                    psDEUIAction.setCODENAME(psAppFunc.getCODENAME());
                    psDEUIAction.setPSDEUIACTIONNAME(this.getCaption());
                    psDEUIAction.setCAPTION(this.getCaption());
                    psDEUIAction.setUIACTIONTYPE("FRONT");
                    psDEUIAction.setFRONTPROTYPE("OTHER");
                    psDEUIAction.setVLEXECMODE("REPLACE");
                    psDEUIAction.setVIEWLOGICTYPE("DELOGIC");
                    psDEUIAction.setPSDEVIEWLOGICID(this.psAppMenuItem.getPSDELOGICID());
                    psDEUIAction.setACTIONTARGET("NONE");
                    psDEUIAction.setPSDEID(iPSAppDataEntity.getPSDataEntity().getId());
                    psDEUIAction.setPSDENAME(iPSAppDataEntity.getPSDataEntity().getName());
                    psDEUIAction.set("AUTOMODEL", 1);
                    iPSAppUIAction = ((IPSAppDataEntityRuntime)((Object)iPSAppDataEntity)).registerPSAppDEUIAction(psDEUIAction);
                } else if (StringHelper.compare((String)strActionType, (String)"OPENHTMLPAGE", (boolean)false) == 0) {
                    if (StringHelper.isNullOrEmpty((String)this.psAppMenuItem.getHTMLPAGEURL())) {
                        throw new Exception("\u672a\u6307\u5b9a\u6253\u5f00\u7684\u9875\u9762\u8def\u5f84");
                    }
                    PSDEUIAction psDEUIAction = new PSDEUIAction();
                    psDEUIAction.setPSDEUIACTIONID(psAppFunc.getPSAPPFUNCID());
                    psDEUIAction.setCODENAME(psAppFunc.getCODENAME());
                    psDEUIAction.setPSDEUIACTIONNAME(this.getCaption());
                    psDEUIAction.setCAPTION(this.getCaption());
                    psDEUIAction.setUIACTIONTYPE("FRONT");
                    psDEUIAction.setFRONTPROTYPE("OPENHTMLPAGE");
                    psDEUIAction.setHTMLPAGEURL(this.psAppMenuItem.getHTMLPAGEURL());
                    psDEUIAction.setACTIONTARGET("NONE");
                    psDEUIAction.set("AUTOMODEL", 1);
                    if (iPSAppDataEntity != null) {
                        psDEUIAction.setPSDEID(iPSAppDataEntity.getPSDataEntity().getId());
                        psDEUIAction.setPSDENAME(iPSAppDataEntity.getPSDataEntity().getName());
                        iPSAppUIAction = ((IPSAppDataEntityRuntime)((Object)iPSAppDataEntity)).registerPSAppDEUIAction(psDEUIAction);
                    } else {
                        iPSAppUIAction = ((IPSApplicationRuntime)((Object)iPSApplication)).registerPSAppDEUIAction(psDEUIAction);
                    }
                } else if (StringHelper.compare((String)strActionType, (String)"CUSTOM", (boolean)false) == 0) {
                    PSDEUIAction psDEUIAction = new PSDEUIAction();
                    psDEUIAction.setPSDEUIACTIONID(psAppFunc.getPSAPPFUNCID());
                    psDEUIAction.setCODENAME(psAppFunc.getCODENAME());
                    psDEUIAction.setPSDEUIACTIONNAME(this.getCaption());
                    psDEUIAction.setCAPTION(this.getCaption());
                    psDEUIAction.setUIACTIONTYPE("CUSTOM");
                    psDEUIAction.setCUSTOMCODE(this.psAppMenuItem.getCUSTOMCODE());
                    psDEUIAction.setACTIONTARGET("NONE");
                    psDEUIAction.set("AUTOMODEL", 1);
                    if (iPSAppDataEntity != null) {
                        psDEUIAction.setPSDEID(iPSAppDataEntity.getPSDataEntity().getId());
                        psDEUIAction.setPSDENAME(iPSAppDataEntity.getPSDataEntity().getName());
                        iPSAppUIAction = ((IPSAppDataEntityRuntime)((Object)iPSAppDataEntity)).registerPSAppDEUIAction(psDEUIAction);
                    } else {
                        iPSAppUIAction = ((IPSApplicationRuntime)((Object)iPSApplication)).registerPSAppDEUIAction(psDEUIAction);
                    }
                } else if (StringHelper.compare((String)strActionType, (String)"NONE", (boolean)false) != 0 && (iPSAppUIAction = iPSApplication.getPSAppDEUIActionByPredefinedType(strActionType, true)) == null) {
                    PSDEUIAction psDEUIAction = new PSDEUIAction();
                    psDEUIAction.setPSDEUIACTIONID(psAppFunc.getPSAPPFUNCID());
                    psDEUIAction.setCODENAME(psAppFunc.getCODENAME());
                    psDEUIAction.setPSDEUIACTIONNAME(this.getCaption());
                    psDEUIAction.setCAPTION(this.getCaption());
                    psDEUIAction.setUIACTIONTYPE("SYS");
                    psDEUIAction.setPSSYSUIACTIONID(strActionType);
                    psDEUIAction.set("AUTOMODEL", 1);
                    if (iPSAppDataEntity != null) {
                        psDEUIAction.setPSDEID(iPSAppDataEntity.getPSDataEntity().getId());
                        psDEUIAction.setPSDENAME(iPSAppDataEntity.getPSDataEntity().getName());
                        iPSAppUIAction = ((IPSAppDataEntityRuntime)((Object)iPSAppDataEntity)).registerPSAppDEUIAction(psDEUIAction);
                    } else {
                        iPSAppUIAction = ((IPSApplicationRuntime)((Object)iPSApplication)).registerPSAppDEUIAction(psDEUIAction);
                    }
                }
                if (iPSAppUIAction != null) {
                    psAppFunc.setAPPFUNCTYPE("UIACTION");
                    if (iPSAppDataEntity != null) {
                        psAppFunc.setPSAPPLOCALDEID(iPSAppDataEntity.getId());
                        psAppFunc.setPSAPPLOCALDENAME(iPSAppDataEntity.getName());
                        psAppFunc.setPSDEID(iPSAppDataEntity.getPSDataEntity().getId());
                    }
                    psAppFunc.setPSDEUIACTIONID(iPSAppUIAction.getId());
                    psAppFunc.setPSDEUIACTIONNAME(iPSAppUIAction.getName());
                } else {
                    psAppFunc = null;
                }
            }
            if (psAppFunc != null) {
                this.setPSAppFunc(((IPSApplicationRuntime)((Object)iPSApplication)).registerPSAppFunc(psAppFunc));
            }
        }
        super.onInit();
    }
}

