/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.PSCoreSysServiceBaseBase;
import net.ibizsys.pscore.srv.codelist.DEDataQueryColLevel2CodeListModel;
import net.ibizsys.pscore.srv.codelist.DEStorageTypeCodeListModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQJoin;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIModeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetailBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridColBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivRole;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETable;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUserRole;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQJoinService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivRoleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETableService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUserRoleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMTDEF;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMTDEFBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTempl;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTemplBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysLic;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysLicService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysSADEField;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBScheme;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTable;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBSchemeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSDEFDataTypeHelper;
import net.ibizsys.pscore.srv.util.PSModelFolderKeyHelper;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import net.ibizsys.pscore.srv.util.PSRTHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDataEntityService
extends PSDataEntityServiceBase {
    private static final Log log = LogFactory.getLog(PSDataEntityService.class);
    public static final String TAG_WFINSTANCEID = "WFINSTANCEID";
    public static final String TAG_WFSTATE = "WFSTATE";
    public static final String TAG_WFSTEP = "WFSTEP";
    public static final String TAG_WFVERSION = "WFVERSION";
    public static final String TAG_WFUSERSTATE = "WFUSERSTATE";
    private static HashMap<String, String> rtDEMap = new HashMap();
    private static HashMap<String, String> wfActionMap = new HashMap();
    private static HashMap<String, String> predefinedFieldMap = new HashMap();

    @Override
    protected boolean onFillEntityKeyValue(PSDataEntity pSDataEntity, boolean bl) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSDataEntity.getPSSysModelGroupId())) {
            StringBuilderEx stringBuilderEx = new StringBuilderEx();
            Object object = pSDataEntity.get("PSSYSTEMID");
            if (object == null) {
                object = "__EMTPY__";
            }
            stringBuilderEx.append("%1$s", object);
            stringBuilderEx.append("||");
            Object object2 = pSDataEntity.get("PSDATAENTITYNAME");
            if (object2 == null) {
                object2 = "__EMTPY__";
            }
            stringBuilderEx.append("%1$s", object2);
            Object object3 = pSDataEntity.get("PSSYSMODELGROUPID");
            if (object3 == null) {
                object3 = "__EMTPY__";
            }
            stringBuilderEx.append("%1$s", object3);
            String string = stringBuilderEx.toString();
            pSDataEntity.set(this.getPSDataEntityDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
            return true;
        }
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDataEntity.get("PSSYSTEMID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object4 = pSDataEntity.get("PSDATAENTITYNAME");
        if (object4 == null) {
            object4 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object4);
        String string = stringBuilderEx.toString();
        pSDataEntity.set(this.getPSDataEntityDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    @Override
    public boolean fillEntityKeyValue(PSDataEntity pSDataEntity, boolean bl) throws Exception {
        if (!PSCoreSysServiceBase.isImpSysModelNow() && !bl && StringHelper.isNullOrEmpty((String)pSDataEntity.getPSSysModelGroupId()) && pSDataEntity.getPSModule() != null) {
            pSDataEntity.setPSSysModelGroupId(pSDataEntity.getPSModule().getPSSysModelGroupId());
        }
        return super.fillEntityKeyValue(pSDataEntity, bl);
    }

    @Override
    protected void onBeforeCreate(PSDataEntity pSDataEntity) throws Exception {
        int n;
        PSSystem pSSystem;
        Object object;
        super.onBeforeCreate(pSDataEntity);
        if (!PSRTHelper.isRTDE(pSDataEntity.getPSDataEntityName())) {
            object = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem2 = new PSSystem();
            pSSystem2.setPSSystemId(pSDataEntity.getPSSystemId());
            ((PSSystemServiceBase)object).increaseDECnt(pSSystem2);
        }
        object = null;
        boolean bl = false;
        if (DataObject.getBoolValue((Integer)pSDataEntity.getExistingModel(), (boolean)false)) {
            bl = true;
        }
        if (!bl && pSDataEntity.getPSModule() != null && DataObject.getBoolValue((Integer)pSDataEntity.getPSModule().getSubSysModule(), (boolean)false)) {
            bl = true;
        }
        if (!bl && !StringHelper.isNullOrEmpty((String)(pSSystem = pSDataEntity.getPSSystem()).getPSDevSlnSysId())) {
            object = PSModelGlobal.getPSDCModelTempl(pSSystem.getPSDevSlnSysId());
        }
        String string = pSDataEntity.getPSDataEntityName().toUpperCase();
        if (object != null && ((PSDCModelTemplBase)object).getDENameMaxLength() != null && ((PSDCModelTemplBase)object).getDENameMaxLength() > 0 && string.length() > ((PSDCModelTemplBase)object).getDENameMaxLength()) {
            throw new Exception(StringHelper.format((String)"\u6a21\u578b\u6a21\u677f[%1$s]\u5b9a\u4e49\u5b9e\u4f53\u540d\u79f0\u957f\u5ea6\u4e0d\u80fd\u8d85\u8fc7[%2$s]", (Object)((PSDCModelTemplBase)object).getPSDCModelTemplName(), (Object)((PSDCModelTemplBase)object).getDENameMaxLength()));
        }
        pSDataEntity.setPSDataEntityName(string);
        boolean bl2 = true;
        if (!StringHelper.isNullOrEmpty((String)pSDataEntity.getPSDataEntityId())) {
            boolean bl3 = bl2 = pSDataEntity.getPSDataEntityId().indexOf("S") != 0;
        }
        if (bl2) {
            pSDataEntity.resetPSDataEntityId();
            this.fillEntityKeyValue((IEntity)pSDataEntity);
        }
        if (StringHelper.isNullOrEmpty((String)pSDataEntity.getCodeName())) {
            if (PSDataEntityService.isEnableCodeNameUpperCamel()) {
                pSDataEntity.setCodeName(PSDataEntityService.toUpperCamel(string));
            } else {
                pSDataEntity.setCodeName(string);
            }
        }
        if (object == null) {
            if (DataObject.getBoolValue((Integer)pSDataEntity.getSystemFlag(), (boolean)false)) {
                if (StringHelper.isNullOrEmpty((String)pSDataEntity.getTableName())) {
                    pSDataEntity.setTableName(StringHelper.format((String)"ST_%1$s", (Object)string));
                }
                if (StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName())) {
                    pSDataEntity.setViewName(StringHelper.format((String)"SV_%1$s", (Object)string));
                }
            } else {
                if (StringHelper.isNullOrEmpty((String)pSDataEntity.getTableName())) {
                    pSDataEntity.setTableName(StringHelper.format((String)"T_%1$s", (Object)string));
                }
                if (StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName())) {
                    pSDataEntity.setViewName(StringHelper.format((String)"V_%1$s", (Object)string));
                }
                if (StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName2())) {
                    pSDataEntity.setViewName2(StringHelper.format((String)"V2_%1$s", (Object)string));
                }
                if (StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName3())) {
                    pSDataEntity.setViewName3(StringHelper.format((String)"V3_%1$s", (Object)string));
                }
                if (StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName4())) {
                    pSDataEntity.setViewName4(StringHelper.format((String)"V4_%1$s", (Object)string));
                }
            }
        } else {
            String string2 = "";
            String string3 = "";
            String string4 = "";
            String string5 = "";
            String string6 = "";
            if (DataObject.getBoolValue((Integer)((PSDCModelTemplBase)object).getTablePrefixFlag(), (boolean)true) && StringHelper.isNullOrEmpty((String)(string2 = ((PSDCModelTemplBase)object).getTablePrefix()))) {
                string2 = DataObject.getBoolValue((Integer)pSDataEntity.getSystemFlag(), (boolean)false) ? "ST_" : "T_";
            }
            if (DataObject.getBoolValue((Integer)((PSDCModelTemplBase)object).getViewPrefixFlag(), (boolean)true)) {
                string3 = ((PSDCModelTemplBase)object).getViewPrefix();
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    string3 = DataObject.getBoolValue((Integer)pSDataEntity.getSystemFlag(), (boolean)false) ? "SV_" : "V_";
                }
                if (StringHelper.isNullOrEmpty((String)(string4 = ((PSDCModelTemplBase)object).getView2Prefix()))) {
                    string4 = DataObject.getBoolValue((Integer)pSDataEntity.getSystemFlag(), (boolean)false) ? "SV2_" : "V2_";
                }
                if (StringHelper.isNullOrEmpty((String)(string5 = ((PSDCModelTemplBase)object).getView3Prefix()))) {
                    string5 = DataObject.getBoolValue((Integer)pSDataEntity.getSystemFlag(), (boolean)false) ? "SV3_" : "V3_";
                }
                if (StringHelper.isNullOrEmpty((String)(string6 = ((PSDCModelTemplBase)object).getView4Prefix()))) {
                    string6 = DataObject.getBoolValue((Integer)pSDataEntity.getSystemFlag(), (boolean)false) ? "SV4_" : "V4_";
                }
            }
            if (StringHelper.isNullOrEmpty((String)pSDataEntity.getTableName())) {
                pSDataEntity.setTableName(StringHelper.format((String)"%1$s%2$s", (Object)string2, (Object)string));
            }
            if (StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName())) {
                pSDataEntity.setViewName(StringHelper.format((String)"%1$s%2$s", (Object)string3, (Object)string));
            }
            if (StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName2())) {
                pSDataEntity.setViewName2(StringHelper.format((String)"%1$s%2$s", (Object)string4, (Object)string));
            }
            if (StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName3())) {
                pSDataEntity.setViewName3(StringHelper.format((String)"%1$s%2$s", (Object)string5, (Object)string));
            }
            if (StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName4())) {
                pSDataEntity.setViewName4(StringHelper.format((String)"%1$s%2$s", (Object)string6, (Object)string));
            }
        }
        if ((n = DataObject.getIntegerValue((Object)pSDataEntity.getVirtualFlag(), (Integer)0).intValue()) > 0) {
            if (n != 4 && n != 5) {
                pSDataEntity.resetTableName();
            }
            if (n == 3 && StringHelper.compare((String)pSDataEntity.getIndexDEType(), (String)"INDEX", (boolean)false) != 0) {
                this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u8bbe\u7f6e\u5b9e\u4f53[%1$s]\u7d22\u5f15\u7c7b\u578b[\u7d22\u5f15\u4e3b\u5b9e\u4f53]", (Object)pSDataEntity.getPSDataEntityName()), false);
                pSDataEntity.setIndexDEType("INDEX");
            }
        }
        if (DataObject.getBoolValue((Integer)pSDataEntity.getNoViewMode(), (boolean)false)) {
            pSDataEntity.resetViewName();
            pSDataEntity.resetViewName2();
            pSDataEntity.resetViewName3();
            pSDataEntity.resetViewName4();
        }
    }

    @Override
    protected void onBeforeUpdate(PSDataEntity pSDataEntity) throws Exception {
        if (pSDataEntity.isExistingModelDirty() && pSDataEntity.isNoViewModeDirty() && pSDataEntity.isViewName2Dirty() && pSDataEntity.isViewName3Dirty() && pSDataEntity.isViewName4Dirty() && pSDataEntity.isViewNameDirty() && pSDataEntity.isTableNameDirty() && !DataObject.getBoolValue((Integer)pSDataEntity.getNoViewMode(), (boolean)false) && !DataObject.getBoolValue((Integer)pSDataEntity.getExistingModel(), (boolean)false) && (StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName2()) || StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName3()) || StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName4()))) {
            int n;
            Object object;
            PSDCModelTemplBase pSDCModelTemplBase = null;
            boolean bl = false;
            if (DataObject.getBoolValue((Integer)pSDataEntity.getExistingModel(), (boolean)false)) {
                bl = true;
            }
            if (!bl && pSDataEntity.getPSModule() != null && DataObject.getBoolValue((Integer)pSDataEntity.getPSModule().getSubSysModule(), (boolean)false)) {
                bl = true;
            }
            if (!bl && !StringHelper.isNullOrEmpty((String)((PSSystemBase)(object = pSDataEntity.getPSSystem())).getPSDevSlnSysId())) {
                pSDCModelTemplBase = PSModelGlobal.getPSDCModelTempl(((PSSystemBase)object).getPSDevSlnSysId());
            }
            String string = pSDataEntity.getPSDataEntityName().toUpperCase();
            if (pSDCModelTemplBase != null && pSDCModelTemplBase.getDENameMaxLength() != null && pSDCModelTemplBase.getDENameMaxLength() > 0 && string.length() > pSDCModelTemplBase.getDENameMaxLength()) {
                throw new Exception(StringHelper.format((String)"\u6a21\u578b\u6a21\u677f[%1$s]\u5b9a\u4e49\u5b9e\u4f53\u540d\u79f0\u957f\u5ea6\u4e0d\u80fd\u8d85\u8fc7[%2$s]", (Object)pSDCModelTemplBase.getPSDCModelTemplName(), (Object)pSDCModelTemplBase.getDENameMaxLength()));
            }
            pSDataEntity.setPSDataEntityName(string);
            if (StringHelper.isNullOrEmpty((String)pSDataEntity.getCodeName())) {
                if (PSDataEntityService.isEnableCodeNameUpperCamel()) {
                    pSDataEntity.setCodeName(PSDataEntityService.toUpperCamel(string));
                } else {
                    pSDataEntity.setCodeName(string);
                }
            }
            if (pSDCModelTemplBase == null) {
                if (DataObject.getBoolValue((Integer)pSDataEntity.getSystemFlag(), (boolean)false)) {
                    if (StringHelper.isNullOrEmpty((String)pSDataEntity.getTableName())) {
                        pSDataEntity.setTableName(StringHelper.format((String)"ST_%1$s", (Object)string));
                    }
                    if (StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName())) {
                        pSDataEntity.setViewName(StringHelper.format((String)"SV_%1$s", (Object)string));
                    }
                } else {
                    if (StringHelper.isNullOrEmpty((String)pSDataEntity.getTableName())) {
                        pSDataEntity.setTableName(StringHelper.format((String)"T_%1$s", (Object)string));
                    }
                    if (StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName())) {
                        pSDataEntity.setViewName(StringHelper.format((String)"V_%1$s", (Object)string));
                    }
                    if (StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName2())) {
                        pSDataEntity.setViewName2(StringHelper.format((String)"V2_%1$s", (Object)string));
                    }
                    if (StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName3())) {
                        pSDataEntity.setViewName3(StringHelper.format((String)"V3_%1$s", (Object)string));
                    }
                    if (StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName4())) {
                        pSDataEntity.setViewName4(StringHelper.format((String)"V4_%1$s", (Object)string));
                    }
                }
            } else {
                object = "";
                String string2 = "";
                String string3 = "";
                String string4 = "";
                String string5 = "";
                if (DataObject.getBoolValue((Integer)pSDCModelTemplBase.getTablePrefixFlag(), (boolean)true) && StringHelper.isNullOrEmpty((String)(object = pSDCModelTemplBase.getTablePrefix()))) {
                    object = DataObject.getBoolValue((Integer)pSDataEntity.getSystemFlag(), (boolean)false) ? "ST_" : "T_";
                }
                if (DataObject.getBoolValue((Integer)pSDCModelTemplBase.getViewPrefixFlag(), (boolean)true)) {
                    string2 = pSDCModelTemplBase.getViewPrefix();
                    if (StringHelper.isNullOrEmpty((String)string2)) {
                        string2 = DataObject.getBoolValue((Integer)pSDataEntity.getSystemFlag(), (boolean)false) ? "SV_" : "V_";
                    }
                    if (StringHelper.isNullOrEmpty((String)(string3 = pSDCModelTemplBase.getView2Prefix()))) {
                        string3 = DataObject.getBoolValue((Integer)pSDataEntity.getSystemFlag(), (boolean)false) ? "SV2_" : "V2_";
                    }
                    if (StringHelper.isNullOrEmpty((String)(string4 = pSDCModelTemplBase.getView3Prefix()))) {
                        string4 = DataObject.getBoolValue((Integer)pSDataEntity.getSystemFlag(), (boolean)false) ? "SV3_" : "V3_";
                    }
                    if (StringHelper.isNullOrEmpty((String)(string5 = pSDCModelTemplBase.getView4Prefix()))) {
                        string5 = DataObject.getBoolValue((Integer)pSDataEntity.getSystemFlag(), (boolean)false) ? "SV4_" : "V4_";
                    }
                }
                if (StringHelper.isNullOrEmpty((String)pSDataEntity.getTableName())) {
                    pSDataEntity.setTableName(StringHelper.format((String)"%1$s%2$s", (Object)object, (Object)string));
                }
                if (StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName())) {
                    pSDataEntity.setViewName(StringHelper.format((String)"%1$s%2$s", (Object)string2, (Object)string));
                }
                if (StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName2())) {
                    pSDataEntity.setViewName2(StringHelper.format((String)"%1$s%2$s", (Object)string3, (Object)string));
                }
                if (StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName3())) {
                    pSDataEntity.setViewName3(StringHelper.format((String)"%1$s%2$s", (Object)string4, (Object)string));
                }
                if (StringHelper.isNullOrEmpty((String)pSDataEntity.getViewName4())) {
                    pSDataEntity.setViewName4(StringHelper.format((String)"%1$s%2$s", (Object)string5, (Object)string));
                }
            }
            if ((n = DataObject.getIntegerValue((Object)pSDataEntity.getVirtualFlag(), (Integer)0).intValue()) > 0 && n != 4 && n != 5) {
                pSDataEntity.resetTableName();
            }
            if (DataObject.getBoolValue((Integer)pSDataEntity.getNoViewMode(), (boolean)false)) {
                pSDataEntity.resetViewName();
                pSDataEntity.resetViewName2();
                pSDataEntity.resetViewName3();
                pSDataEntity.resetViewName4();
            }
        }
        super.onBeforeUpdate(pSDataEntity);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    protected void onSyncInheritDEField(PSDataEntity pSDataEntity) throws Exception {
        block30: {
            int n;
            PSDERService pSDERService;
            block29: {
                if (!pSDataEntity.isFullEntity()) {
                    this.get((IEntity)pSDataEntity);
                }
                pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                n = DataObject.getIntegerValue((Object)pSDataEntity.getVirtualFlag(), (Integer)0);
                if (n != 1 && n != 4 && n != 5) break block29;
                HashMap<String, String> hashMap = new HashMap<String, String>();
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                ArrayList<PSDEField> arrayList = pSDEFieldService.selectByPSDE(pSDataEntity);
                for (PSDEField serializable2 : arrayList) {
                    hashMap.put(serializable2.getPSDEFieldName().toUpperCase(), "");
                }
                SelectCond selectCond = new SelectCond();
                selectCond.set("DERTYPE", (Object)"DERMULINH");
                selectCond.set("MINORPSDEID", (Object)pSDataEntity.getPSDataEntityId());
                selectCond.setOrderInfo("ORDER BY ORDERVALUE");
                ArrayList hashMap4 = pSDERService.select((ISelectCond)selectCond);
                if (hashMap4.size() == 0) {
                    throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u6ca1\u6709\u5b9a\u4e49\u7ee7\u627f\u5173\u7cfb", (Object)pSDataEntity.getPSDataEntityName()));
                }
                for (PSDER properties : hashMap4) {
                    Object object;
                    Object object2;
                    void var14_38;
                    PSDataEntity pSDataEntity2 = new PSDataEntity();
                    pSDataEntity2.setPSDataEntityId(properties.getMajorPSDEId());
                    arrayList = pSDEFieldService.selectByPSDE(pSDataEntity2);
                    HashMap<String, PSDEField> hashMap2 = new HashMap<String, PSDEField>();
                    for (PSDEField pSDEField : arrayList) {
                        hashMap2.put(pSDEField.getPSDEFieldName(), pSDEField);
                    }
                    boolean bl = DataObject.getIntegerValue((Object)properties.getDEFInheritMode(), (Integer)1) == 1;
                    String string = properties.getIgnoreDEFields();
                    if (!StringHelper.isNullOrEmpty((String)string)) {
                        String string2 = string.toUpperCase();
                    } else {
                        String string3 = "";
                    }
                    Properties properties2 = PropertiesHelper.load((String)var14_38);
                    if (bl) {
                        HashMap hashMap3 = new HashMap();
                        for (Object object3 : properties2.keySet()) {
                            object2 = (String)object3;
                            object = PropertiesHelper.getProperty((Properties)properties2, (String)object2);
                            if (StringHelper.isNullOrEmpty((String)object)) {
                                object = object2;
                            }
                            hashMap3.put(object, object2);
                        }
                        for (PSDEField pSDEField : arrayList) {
                            if (hashMap3.containsKey(pSDEField.getPSDEFieldName()) || hashMap.containsKey(pSDEField.getPSDEFieldName())) continue;
                            object2 = new PSDEField();
                            pSDEField.copyTo((IDataObject)object2, false);
                            if (!StringHelper.isNullOrEmpty((String)pSDEField.getCodeName())) {
                                object = new PSDEField();
                                ((PSDEFieldBase)object).setPSDEId(pSDataEntity.getPSDataEntityId());
                                ((PSDEFieldBase)object).setCodeName(pSDEField.getCodeName());
                                if (pSDEFieldService.select(object, true)) {
                                    ((PSDEFieldBase)object2).remove("CODENAME");
                                }
                            }
                            ((PSDEFieldBase)object2).remove("FORMULAFORMAT");
                            ((PSDEFieldBase)object2).remove("FORMULAFIELDS");
                            ((PSDEFieldBase)object2).remove("PSDEFIELDID");
                            ((PSDEFieldBase)object2).remove("PSDATATYPEID");
                            ((PSDEFieldBase)object2).remove("PSDATATYPENAME");
                            ((PSDEFieldBase)object2).remove("INDEXTYPE");
                            ((PSDEFieldBase)object2).remove("MULTIFORMFIELD");
                            ((PSDEFieldBase)object2).remove("MAJORFIELD");
                            ((PSDEFieldBase)object2).remove("PKEY");
                            ((PSDEFieldBase)object2).remove("FKEY");
                            ((PSDEFieldBase)object2).setDEFType(3);
                            ((PSDEFieldBase)object2).setPhysicalField(0);
                            ((PSDEFieldBase)object2).setPSDataTypeId("INHERIT");
                            ((PSDEFieldBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
                            ((PSDEFieldBase)object2).setPSDEName(pSDataEntity.getPSDataEntityName());
                            ((PSDEFieldBase)object2).setMajorField(0);
                            ((PSDEFieldBase)object2).setPSDERId(properties.getPSDERId());
                            ((PSDEFieldBase)object2).setPSDERName(properties.getPSDERName());
                            ((PSDEFieldBase)object2).setDERPSDEFId(pSDEField.getPSDEFieldId());
                            ((PSDEFieldBase)object2).setDERPSDEFName(pSDEField.getPSDEFieldName());
                            pSDEFieldService.create(object2, false);
                            hashMap.put(((PSDEFieldBase)object2).getPSDEFieldName(), "");
                        }
                        continue;
                    }
                    for (Object e : properties2.keySet()) {
                        String string4 = (String)e;
                        if (hashMap.containsKey(string4)) continue;
                        object2 = PropertiesHelper.getProperty((Properties)properties2, (String)string4);
                        if (StringHelper.isNullOrEmpty((String)object2)) {
                            object2 = string4;
                        }
                        if ((object = (PSDEField)hashMap2.get(object2)) == null) {
                            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u5c5e\u6027[%2$s]", (Object)properties.getMajorPSDEName(), (Object)object2));
                        }
                        PSDEField pSDEField = new PSDEField();
                        object.copyTo((IDataObject)pSDEField, false);
                        if (!StringHelper.isNullOrEmpty((String)((PSDEFieldBase)object).getCodeName())) {
                            PSDEField pSDEField2 = new PSDEField();
                            pSDEField2.setPSDEId(pSDataEntity.getPSDataEntityId());
                            pSDEField2.setCodeName(((PSDEFieldBase)object).getCodeName());
                            if (pSDEFieldService.select(pSDEField2, true)) {
                                pSDEField.remove("CODENAME");
                            }
                        }
                        pSDEField.remove("FORMULAFORMAT");
                        pSDEField.remove("FORMULAFIELDS");
                        pSDEField.remove("PSDEFIELDID");
                        pSDEField.remove("PSDATATYPEID");
                        pSDEField.remove("PSDATATYPENAME");
                        pSDEField.remove("INDEXTYPE");
                        pSDEField.remove("MULTIFORMFIELD");
                        pSDEField.remove("MAJORFIELD");
                        pSDEField.remove("PKEY");
                        pSDEField.remove("FKEY");
                        pSDEField.setDEFType(3);
                        pSDEField.setPhysicalField(0);
                        pSDEField.setPSDataTypeId("INHERIT");
                        pSDEField.setPSDEId(pSDataEntity.getPSDataEntityId());
                        pSDEField.setPSDEName(pSDataEntity.getPSDataEntityName());
                        pSDEField.setPSDEFieldName(string4);
                        pSDEField.setMajorField(0);
                        pSDEField.setPSDERId(properties.getPSDERId());
                        pSDEField.setPSDERName(properties.getPSDERName());
                        pSDEField.setDERPSDEFId(((PSDEFieldBase)object).getPSDEFieldId());
                        pSDEField.setDERPSDEFName(((PSDEFieldBase)object).getPSDEFieldName());
                        pSDEFieldService.create(pSDEField, false);
                        hashMap.put(string4, "");
                    }
                }
                break block30;
            }
            if (n != 0) break block30;
            PSDER pSDER = new PSDER();
            pSDER.setMinorPSDEId(pSDataEntity.getPSDataEntityId());
            pSDER.setDERType("DERINHERIT");
            if (!pSDERService.select(pSDER, true)) {
                throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u6ca1\u6709\u5b9a\u4e49\u7ee7\u627f\u5173\u7cfb", (Object)pSDataEntity.getPSDataEntityName()));
            }
            boolean bl = DataObject.getIntegerValue((Object)pSDER.getDEFInheritMode(), (Integer)1) == 1;
            String string = pSDER.getIgnoreDEFields();
            HashMap<String, String> hashMap = new HashMap<String, String>();
            HashMap<String, String> hashMap4 = new HashMap<String, String>();
            if (!StringHelper.isNullOrEmpty((String)string)) {
                String[] bl2 = StringHelper.splitEx((String)(string = string.toUpperCase()));
                if (bl2.length > 1) {
                    for (String string5 : bl2) {
                        String string6 = string5.trim();
                        if (StringHelper.isNullOrEmpty((String)string6)) continue;
                        if (bl) {
                            hashMap.put(string6, "");
                            continue;
                        }
                        hashMap4.put(string6, "");
                    }
                } else {
                    Properties bl3 = PropertiesHelper.load((String)string);
                    for (Object arrayList : bl3.keySet()) {
                        String string8 = (String)arrayList;
                        string8 = string8.trim();
                        if (StringHelper.isNullOrEmpty((String)string8)) continue;
                        if (bl) {
                            hashMap.put(string8, "");
                            continue;
                        }
                        hashMap4.put(string8, "");
                    }
                }
            }
            boolean bl2 = false;
            boolean bl3 = false;
            PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDEField> arrayList = pSDEFieldService.selectByPSDE(pSDataEntity);
            for (PSDEField pSDEField : arrayList) {
                hashMap.put(pSDEField.getPSDEFieldName().toUpperCase(), "");
                if (DataObject.getBoolValue((Integer)pSDEField.getPKey(), (boolean)false)) {
                    bl2 = true;
                }
                if (!DataObject.getBoolValue((Integer)pSDEField.getMajorField(), (boolean)false)) continue;
                bl3 = true;
            }
            PSDataEntity pSDataEntity3 = new PSDataEntity();
            pSDataEntity3.setPSDataEntityId(pSDER.getMajorPSDEId());
            arrayList = pSDEFieldService.selectByPSDE(pSDataEntity3);
            for (PSDEField pSDEField : arrayList) {
                if (DataObject.getBoolValue((Integer)pSDEField.getPKey(), (boolean)false) && bl2 || DataObject.getBoolValue((Integer)pSDEField.getMajorField(), (boolean)false) && bl3 || hashMap.containsKey(pSDEField.getPSDEFieldName().toUpperCase()) || !bl && !hashMap4.containsKey(pSDEField.getPSDEFieldName().toUpperCase())) continue;
                PSDEField pSDEField3 = new PSDEField();
                pSDEField.copyTo((IDataObject)pSDEField3, false);
                pSDEField3.remove("FORMULAFORMAT");
                pSDEField3.remove("FORMULAFIELDS");
                pSDEField3.remove("PSDEFIELDID");
                pSDEField3.remove("PSDATATYPEID");
                pSDEField3.remove("PSDATATYPENAME");
                pSDEField3.remove("INDEXTYPE");
                pSDEField3.remove("MULTIFORMFIELD");
                pSDEField3.setPSDataTypeId("INHERIT");
                pSDEField3.setPSDEId(pSDataEntity.getPSDataEntityId());
                pSDEField3.setPSDEName(pSDataEntity.getPSDataEntityName());
                pSDEField3.setPSDERId(pSDER.getPSDERId());
                pSDEField3.setPSDERName(pSDER.getPSDERName());
                pSDEField3.setDERPSDEFId(pSDEField.getPSDEFieldId());
                pSDEField3.setDERPSDEFName(pSDEField.getPSDEFieldName());
                pSDEFieldService.create(pSDEField3, false);
            }
        }
    }

    public String checkObjCodeName(PSDataEntity pSDataEntity, Object object, String string) throws Exception {
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEField> arrayList = pSDEFieldService.selectByPSDE(pSDataEntity);
        for (PSDEField serializable2 : arrayList) {
            EntityBase pSDER;
            Object object2 = serializable2.getCodeName();
            if (StringHelper.isNullOrEmpty((String)object2)) {
                object2 = serializable2.getPSDEFieldName();
            }
            if (StringHelper.compare((String)object2, (String)string, (boolean)true) != 0) continue;
            if (object != null && object instanceof PSDEField) {
                pSDER = (PSDEField)object;
                if (StringHelper.compare((String)serializable2.getPSDEFieldId(), (String)pSDER.getPSDEFieldId(), (boolean)false) == 0) {
                    return null;
                }
            }
            if (object != null && object instanceof PSDER) {
                pSDER = (PSDER)object;
                if (StringHelper.compare((String)serializable2.getPSDataTypeId(), (String)"ONE2MANYDATA", (boolean)false) == 0 && StringHelper.compare((String)serializable2.getO2MPSDERId(), (String)pSDER.getPSDERId(), (boolean)false) == 0) {
                    return null;
                }
            }
            return StringHelper.format((String)"\u5b9e\u4f53\u5c5e\u6027[%1$s]", (Object)serializable2.getPSDEFieldName());
        }
        PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDER> arrayList2 = pSDERService.selectByMinorPSDE(pSDataEntity);
        for (PSDER pSDER : arrayList2) {
            EntityBase entityBase;
            String string2 = pSDER.getCodeName();
            if (!StringHelper.isNullOrEmpty((String)string2) && StringHelper.compare((String)string2, (String)string, (boolean)true) == 0) {
                EntityBase entityBase2;
                if (object != null && object instanceof PSDER) {
                    entityBase2 = (PSDER)object;
                    if (StringHelper.compare((String)pSDER.getPSDERId(), (String)entityBase2.getPSDERId(), (boolean)false) == 0) {
                        return null;
                    }
                }
                if (object != null && object instanceof PSDEField && StringHelper.compare((String)(entityBase2 = (PSDEField)object).getPSDataTypeId(), (String)"PICKUPOBJECT", (boolean)false) == 0 && StringHelper.compare((String)entityBase2.getPSDERId(), (String)pSDER.getPSDERId(), (boolean)false) == 0) {
                    return null;
                }
                return StringHelper.format((String)"\u5b9e\u4f53\u5173\u7cfb[%1$s]", (Object)pSDER.getPSDERName());
            }
            string2 = pSDER.getMinorCodeName();
            if (StringHelper.isNullOrEmpty((String)string2) || StringHelper.compare((String)string2, (String)string, (boolean)true) != 0) continue;
            if (object != null && object instanceof PSDER) {
                entityBase = (PSDER)object;
                if (StringHelper.compare((String)pSDER.getPSDERId(), (String)entityBase.getPSDERId(), (boolean)false) == 0) {
                    return null;
                }
                if (StringHelper.compare((String)pSDER.getMajorPSDEId(), (String)entityBase.getMajorPSDEId(), (boolean)false) != 0) {
                    return null;
                }
            }
            if (object != null && object instanceof PSDEField && StringHelper.compare((String)(entityBase = (PSDEField)object).getPSDataTypeId(), (String)"ONE2MANYDATA", (boolean)false) == 0 && StringHelper.compare((String)entityBase.getO2MPSDERId(), (String)pSDER.getPSDERId(), (boolean)false) == 0) {
                return null;
            }
            return StringHelper.format((String)"\u5b9e\u4f53\u5173\u7cfb[%1$s]", (Object)pSDER.getPSDERName());
        }
        return null;
    }

    public String checkDEFieldName(PSDataEntity pSDataEntity, Object object, String string) throws Exception {
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEField> arrayList = pSDEFieldService.selectByPSDE(pSDataEntity);
        for (PSDEField pSDEField : arrayList) {
            if (StringHelper.compare((String)string, (String)pSDEField.getPSDEFieldName(), (boolean)false) != 0) continue;
            if (object != null && object instanceof PSDEField) {
                PSDEField pSDEField2 = (PSDEField)object;
                if (StringHelper.compare((String)pSDEField.getPSDEFieldId(), (String)pSDEField2.getPSDEFieldId(), (boolean)false) == 0) {
                    return null;
                }
            }
            return StringHelper.format((String)"\u5b9e\u4f53\u5c5e\u6027[%1$s]", (Object)pSDEField.getPSDEFieldName());
        }
        return null;
    }

    @Override
    protected void onInitModel(PSDataEntity pSDataEntity) throws Exception {
        PSSysSFPub pSSysSFPub;
        super.onInitModel(pSDataEntity);
        PSSystem pSSystem = PSDataEntityService.getCurrentPSSystem((IEntity)pSDataEntity, this.getSessionFactory());
        if (DataObject.getBoolValue((Integer)pSSystem.getEnableMultiLan(), (boolean)PSDataEntityService.isEnableI18NDefault())) {
            this.initPSDataEntityLanRes(pSDataEntity, false);
        }
        if ((pSSysSFPub = PSDataEntityService.getCurrentDefaultPSSysSFPub((IEntity)pSDataEntity, this.getSessionFactory())) != null && "RUNTIME".equals(pSSysSFPub.getDynaModelMode())) {
            this.initModelRTModes(pSDataEntity);
        }
    }

    protected void initPSDataEntityLanRes(PSDataEntity pSDataEntity, boolean bl) throws Exception {
        Object object;
        Object object2;
        Object object3;
        Object bl32;
        Object object4;
        Object object5;
        Object object8;
        Object object9;
        boolean bl2 = false;
        PSSysSFPub pSSysSFPub = PSDataEntityService.getCurrentDefaultPSSysSFPub((IEntity)pSDataEntity, this.getSessionFactory());
        if (pSSysSFPub != null && "RUNTIME".equals(pSSysSFPub.getDynaModelMode())) {
            bl2 = true;
        }
        PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
        if (pSDataEntity.getLNPSLanResId() == null) {
            object9 = new PSLanguageRes();
            ((PSLanguageResBase)object9).setPSSystemId(pSDataEntity.getPSSystemId());
            ((PSLanguageResBase)object9).setLanResType("DE.LNAME");
            ((PSLanguageResBase)object9).setUserData(pSDataEntity.getPSDataEntityName());
            ((PSLanguageResBase)object9).setPSDEId(pSDataEntity.getPSDataEntityId());
            ((PSLanguageResBase)object9).setPSDEName(pSDataEntity.getPSDataEntityName());
            if (pSLanguageResService.checkKey(object9) == 0) {
                ((PSLanguageResBase)object9).setContent(pSDataEntity.getLogicName());
                if (bl2) {
                    ((PSLanguageResBase)object9).setPSModuleId(pSDataEntity.getPSModuleId());
                    ((PSLanguageResBase)object9).setPSModuleName(pSDataEntity.getPSModuleName());
                    pSLanguageResService.save((IEntity)object9);
                } else {
                    pSLanguageResService.create(object9);
                }
                object8 = pSDataEntity.getPSDataEntityId();
                pSDataEntity.reset();
                pSDataEntity.setPSDataEntityId((String)object8);
                pSDataEntity.setLNPSLanResId(((PSLanguageResBase)object9).getPSLanguageResId());
                pSDataEntity.setLNPSLanResName(((PSLanguageResBase)object9).getPSLanguageResName());
                this.update(pSDataEntity);
            }
        } else if (bl && StringHelper.compare((String)((PSLanguageResBase)(object9 = pSDataEntity.getLNPSLanRes())).getContent(), (String)pSDataEntity.getLogicName(), (boolean)false) != 0) {
            object9.reset();
            ((PSLanguageResBase)object9).setPSSystemId(pSDataEntity.getPSSystemId());
            if (bl2) {
                ((PSLanguageResBase)object9).setPSModuleId(pSDataEntity.getPSModuleId());
                ((PSLanguageResBase)object9).setPSModuleName(pSDataEntity.getPSModuleName());
            }
            ((PSLanguageResBase)object9).setLanResType("DE.LNAME");
            ((PSLanguageResBase)object9).setUserData(pSDataEntity.getPSDataEntityName());
            ((PSLanguageResBase)object9).setPSDEId(pSDataEntity.getPSDataEntityId());
            ((PSLanguageResBase)object9).setPSDEName(pSDataEntity.getPSDataEntityName());
            ((PSLanguageResBase)object9).setContent(pSDataEntity.getLogicName());
            pSLanguageResService.save((IEntity)object9);
            object8 = pSDataEntity.getPSDataEntityId();
            pSDataEntity.reset();
            pSDataEntity.setPSDataEntityId((String)object8);
            pSDataEntity.setLNPSLanResId(((PSLanguageResBase)object9).getPSLanguageResId());
            pSDataEntity.setLNPSLanResName(((PSLanguageResBase)object9).getPSLanguageResName());
            this.update(pSDataEntity);
        }
        object9 = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        object8 = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
        PSDEFSFItemService pSDEFSFItemService = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEField> arrayList = pSDataEntity.getPSDEFields();
        for (PSDEField serializable2 : arrayList) {
            if (serializable2.getLNPSLanResId() == null) {
                object5 = new PSLanguageRes();
                ((PSLanguageResBase)object5).setPSSystemId(pSDataEntity.getPSSystemId());
                ((PSLanguageResBase)object5).setLanResType("DEF.LNAME");
                ((PSLanguageResBase)object5).setUserData(serializable2.getPSDEFieldName());
                boolean bl4 = false;
                if (bl2) {
                    if (!StringHelper.isNullOrEmpty((String)serializable2.getPreDefineType())) {
                        if (!"NONE".equals(serializable2.getPreDefineType())) {
                            bl4 = true;
                        }
                    } else {
                        bl4 = predefinedFieldMap.containsKey(serializable2.getPSDEFieldName());
                    }
                } else {
                    bl4 = true;
                }
                if (bl4 && pSLanguageResService.select(object5, true)) {
                    if (StringHelper.compare((String)((PSLanguageResBase)object5).getContent(), (String)serializable2.getLogicName(), (boolean)false) != 0) {
                        ((PSLanguageResBase)object5).resetPSLanguageResId();
                        ((PSLanguageResBase)object5).resetPSLanguageResName();
                        ((PSLanguageResBase)object5).resetCodeName();
                        if (bl2) {
                            ((PSLanguageResBase)object5).setPSModuleId(pSDataEntity.getPSModuleId());
                            ((PSLanguageResBase)object5).setPSModuleName(pSDataEntity.getPSModuleName());
                        }
                        ((PSLanguageResBase)object5).setPSDEId(serializable2.getPSDEId());
                        ((PSLanguageResBase)object5).setPSDEName(serializable2.getPSDEName());
                        ((PSLanguageResBase)object5).setPSDEFId(serializable2.getPSDEFieldId());
                        ((PSLanguageResBase)object5).setPSDEFName(serializable2.getPSDEFieldName());
                        ((PSLanguageResBase)object5).setUserData(StringHelper.format((String)"%1$s.%2$s", (Object)serializable2.getPSDEName(), (Object)serializable2.getPSDEFieldName()));
                        ((PSLanguageResBase)object5).setContent(serializable2.getLogicName());
                        if (pSLanguageResService.fillEntityKeyValue((IEntity)object5)) {
                            if (pSLanguageResService.checkKey(object5) == 0) {
                                pSLanguageResService.create(object5);
                            } else {
                                pSLanguageResService.get((IEntity)object5);
                            }
                        } else {
                            pSLanguageResService.create(object5);
                        }
                    }
                } else if (!bl4) {
                    ((PSLanguageResBase)object5).setPSDEId(serializable2.getPSDEId());
                    ((PSLanguageResBase)object5).setPSDEName(serializable2.getPSDEName());
                    ((PSLanguageResBase)object5).setPSDEFId(serializable2.getPSDEFieldId());
                    ((PSLanguageResBase)object5).setPSDEFName(serializable2.getPSDEFieldName());
                    ((PSLanguageResBase)object5).setUserData(StringHelper.format((String)"%1$s.%2$s", (Object)serializable2.getPSDEName(), (Object)serializable2.getPSDEFieldName()));
                    if (pSLanguageResService.checkKey(object5) == 0) {
                        ((PSLanguageResBase)object5).setContent(serializable2.getLogicName());
                        if (bl2) {
                            ((PSLanguageResBase)object5).setPSModuleId(pSDataEntity.getPSModuleId());
                            ((PSLanguageResBase)object5).setPSModuleName(pSDataEntity.getPSModuleName());
                            pSLanguageResService.save((IEntity)object5);
                        } else {
                            pSLanguageResService.create(object5);
                        }
                    } else {
                        pSLanguageResService.get((IEntity)object5);
                    }
                } else {
                    ((PSLanguageResBase)object5).setContent(serializable2.getLogicName());
                    pSLanguageResService.create(object5);
                }
                object4 = serializable2.getPSDEFieldId();
                serializable2.reset();
                serializable2.setPSDEFieldId((String)object4);
                serializable2.setLNPSLanResId(((PSLanguageResBase)object5).getPSLanguageResId());
                serializable2.setLNPSLanResName(((PSLanguageResBase)object5).getPSLanguageResName());
                ((PSCoreSysServiceBaseBase)((Object)object9)).update(serializable2);
            } else if (bl && StringHelper.compare((String)((PSLanguageResBase)(object5 = serializable2.getLNPSLanRes())).getContent(), (String)serializable2.getLogicName(), (boolean)false) != 0) {
                object5.reset();
                ((PSLanguageResBase)object5).setPSSystemId(pSDataEntity.getPSSystemId());
                ((PSLanguageResBase)object5).setLanResType("DEF.LNAME");
                if (bl2) {
                    ((PSLanguageResBase)object5).setPSModuleId(pSDataEntity.getPSModuleId());
                    ((PSLanguageResBase)object5).setPSModuleName(pSDataEntity.getPSModuleName());
                }
                ((PSLanguageResBase)object5).setPSDEId(serializable2.getPSDEId());
                ((PSLanguageResBase)object5).setPSDEName(serializable2.getPSDEName());
                ((PSLanguageResBase)object5).setPSDEFId(serializable2.getPSDEFieldId());
                ((PSLanguageResBase)object5).setPSDEFName(serializable2.getPSDEFieldName());
                ((PSLanguageResBase)object5).setUserData(StringHelper.format((String)"%1$s.%2$s", (Object)serializable2.getPSDEName(), (Object)serializable2.getPSDEFieldName()));
                ((PSLanguageResBase)object5).setContent(serializable2.getLogicName());
                pSLanguageResService.save((IEntity)object5);
                bl32 = serializable2.getPSDEFieldId();
                serializable2.reset();
                serializable2.setPSDEFieldId((String)bl32);
                serializable2.setLNPSLanResId(((PSLanguageResBase)object5).getPSLanguageResId());
                serializable2.setLNPSLanResName(((PSLanguageResBase)object5).getPSLanguageResName());
                ((PSCoreSysServiceBaseBase)((Object)object9)).update(serializable2);
            }
            object5 = serializable2.getPSDEFUIModes();
            bl32 = ((ArrayList)object5).iterator();
            block1: while (bl32.hasNext()) {
                PSLanguageRes pSDEFSFItem;
                object4 = (PSDEFUIMode)bl32.next();
                if (StringHelper.isNullOrEmpty((String)((PSDEFUIModeBase)object4).getCaption())) continue;
                if (((PSDEFUIModeBase)object4).getCapPSLanResId() == null) {
                    for (int pSLanguageRes = 0; pSLanguageRes < 1000; ++pSLanguageRes) {
                        object3 = new PSLanguageRes();
                        ((PSLanguageResBase)object3).setPSSystemId(pSDataEntity.getPSSystemId());
                        if (bl2) {
                            ((PSLanguageResBase)object3).setPSModuleId(pSDataEntity.getPSModuleId());
                        }
                        ((PSLanguageResBase)object3).setLanResType("CONTROL");
                        ((PSLanguageResBase)object3).setUserData(StringHelper.format((String)"DEFUIMODE.%1$s.%2$s.%3$s", (Object)serializable2.getPSDEName(), (Object)serializable2.getPSDEFieldName(), (Object)pSLanguageRes));
                        if (pSLanguageResService.select(object3, true)) continue;
                        if (bl2) {
                            ((PSLanguageResBase)object3).setPSModuleId(pSDataEntity.getPSModuleId());
                            ((PSLanguageResBase)object3).setPSModuleName(pSDataEntity.getPSModuleName());
                        }
                        ((PSLanguageResBase)object3).setPSDEId(serializable2.getPSDEId());
                        ((PSLanguageResBase)object3).setPSDEName(serializable2.getPSDEName());
                        ((PSLanguageResBase)object3).setPSDEFId(serializable2.getPSDEFieldId());
                        ((PSLanguageResBase)object3).setPSDEFName(serializable2.getPSDEFieldName());
                        ((PSLanguageResBase)object3).setContent(((PSDEFUIModeBase)object4).getCaption());
                        pSLanguageResService.create(object3);
                        String string = ((PSDEFUIModeBase)object4).getPSDEFUIModeId();
                        object4.reset();
                        ((PSDEFUIModeBase)object4).setPSDEFUIModeId(string);
                        ((PSDEFUIModeBase)object4).setCapPSLanResId(((PSLanguageResBase)object3).getPSLanguageResId());
                        ((PSDEFUIModeBase)object4).setCapPSLanResName(((PSLanguageResBase)object3).getPSLanguageResName());
                        ((PSCoreSysServiceBaseBase)((Object)object8)).update(object4);
                        continue block1;
                    }
                    continue;
                }
                if (!bl || StringHelper.compare((String)(pSDEFSFItem = ((PSDEFUIModeBase)object4).getCapPSLanRes()).getContent(), (String)((PSDEFUIModeBase)object4).getCaption(), (boolean)false) == 0) continue;
                pSDEFSFItem.setContent(((PSDEFUIModeBase)object4).getCaption());
                ((PSCoreSysServiceBaseBase)((Object)object8)).update(object4);
            }
            bl32 = serializable2.getPSDEFSFItems();
            object4 = ((ArrayList)bl32).iterator();
            while (object4.hasNext()) {
                PSDEFSFItem iterator = (PSDEFSFItem)object4.next();
                if (iterator.getCapPSLanResId() != null) continue;
                object3 = new PSLanguageRes();
                ((PSLanguageResBase)object3).setPSSystemId(pSDataEntity.getPSSystemId());
                if (bl2) {
                    ((PSLanguageResBase)object3).setPSModuleId(pSDataEntity.getPSModuleId());
                }
                ((PSLanguageResBase)object3).setLanResType("CONTROL");
                ((PSLanguageResBase)object3).setUserData(StringHelper.format((String)"DEFSFITEM.%1$s.%2$s", (Object)serializable2.getPSDEName(), (Object)iterator.getPSDEFSFItemName()));
                if (pSLanguageResService.select(object3, true)) continue;
                if (bl2) {
                    ((PSLanguageResBase)object3).setPSModuleId(pSDataEntity.getPSModuleId());
                    ((PSLanguageResBase)object3).setPSModuleName(pSDataEntity.getPSModuleName());
                }
                ((PSLanguageResBase)object3).setPSDEId(serializable2.getPSDEId());
                ((PSLanguageResBase)object3).setPSDEName(serializable2.getPSDEName());
                ((PSLanguageResBase)object3).setPSDEFId(serializable2.getPSDEFieldId());
                ((PSLanguageResBase)object3).setPSDEFName(serializable2.getPSDEFieldName());
                String string = iterator.getCaption();
                ((PSLanguageResBase)object3).setContent(string);
                pSLanguageResService.create(object3);
                String string2 = iterator.getPSDEFSFItemId();
                iterator.reset();
                iterator.setPSDEFSFItemId(string2);
                iterator.setCapPSLanResId(((PSLanguageResBase)object3).getPSLanguageResId());
                iterator.setCapPSLanResName(((PSLanguageResBase)object3).getPSLanguageResName());
                pSDEFSFItemService.update(iterator);
            }
        }
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEForm> arrayList2 = pSDataEntity.getPSDEForms();
        for (Object bl32 : arrayList2) {
            object4 = ((PSDEFormBase)bl32).getPSDEFormDetails();
            Iterator pSDEGrid = ((ArrayList)object4).iterator();
            while (pSDEGrid.hasNext()) {
                object3 = (PSDEFormDetail)pSDEGrid.next();
                if (StringHelper.isNullOrEmpty((String)((PSDEFormDetailBase)object3).getCaption()) || ((PSDEFormDetailBase)object3).getCapPSLanResId() != null) continue;
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSSystemId(pSDataEntity.getPSSystemId());
                if (bl2) {
                    pSLanguageRes.setPSModuleId(pSDataEntity.getPSModuleId());
                    pSLanguageRes.setPSModuleName(pSDataEntity.getPSModuleName());
                }
                pSLanguageRes.setPSDEId(((PSDEFormBase)bl32).getPSDEId());
                pSLanguageRes.setPSDEName(((PSDEFormBase)bl32).getPSDEName());
                pSLanguageRes.setLanResType("CONTROL");
                pSLanguageRes.setUserData(StringHelper.format((String)"DEFORM.%1$s.%2$s.%3$s.%4$s", (Object)((PSDEFormBase)bl32).getPSDEName(), (Object)((PSDEFormBase)bl32).getCodeName(), (Object)((PSDEFormDetailBase)object3).getDetailType(), (Object)((PSDEFormDetailBase)object3).getPSDEFormDetailName()).toUpperCase());
                if (pSLanguageResService.select(pSLanguageRes, true)) continue;
                pSLanguageRes.setContent(((PSDEFormDetailBase)object3).getCaption());
                pSLanguageResService.create(pSLanguageRes);
                object2 = ((PSDEFormDetailBase)object3).getPSDEFormDetailId();
                object3.reset();
                ((PSDEFormDetailBase)object3).setPSDEFormDetailId((String)object2);
                ((PSDEFormDetailBase)object3).setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
                ((PSDEFormDetailBase)object3).setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                pSDEFormDetailService.update(object3);
            }
        }
        object5 = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        bl32 = pSDataEntity.getPSDEGrids();
        object4 = ((ArrayList)bl32).iterator();
        while (object4.hasNext()) {
            PSDEGrid arrayList22 = (PSDEGrid)object4.next();
            object3 = arrayList22.getPSDEGridCols();
            Iterator iterator = ((ArrayList)object3).iterator();
            while (iterator.hasNext()) {
                object2 = (PSDEGridCol)iterator.next();
                if (StringHelper.isNullOrEmpty((String)((PSDEGridColBase)object2).getCaption()) || ((PSDEGridColBase)object2).getCapPSLanResId() != null) continue;
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSSystemId(pSDataEntity.getPSSystemId());
                if (bl2) {
                    pSLanguageRes.setPSModuleId(pSDataEntity.getPSModuleId());
                    pSLanguageRes.setPSModuleName(pSDataEntity.getPSModuleName());
                }
                pSLanguageRes.setPSDEId(arrayList22.getPSDEId());
                pSLanguageRes.setPSDEName(arrayList22.getPSDEName());
                pSLanguageRes.setLanResType("CONTROL");
                pSLanguageRes.setUserData(StringHelper.format((String)"DEGRID.%1$s.%2$s.%3$s.%4$s", (Object)arrayList22.getPSDEName(), (Object)arrayList22.getCodeName(), (Object)((PSDEGridColBase)object2).getGridColType(), (Object)((PSDEGridColBase)object2).getPSDEGridColName()).toUpperCase());
                if (pSLanguageResService.select(pSLanguageRes, true)) continue;
                pSLanguageRes.setContent(((PSDEGridColBase)object2).getCaption());
                pSLanguageResService.create(pSLanguageRes);
                object = ((PSDEGridColBase)object2).getPSDEGridColId();
                object2.reset();
                ((PSDEGridColBase)object2).setPSDEGridColId((String)object);
                ((PSDEGridColBase)object2).setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
                ((PSDEGridColBase)object2).setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                ((PSCoreSysServiceBaseBase)((Object)object5)).update(object2);
            }
        }
        object4 = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEViewBase> arrayList3 = pSDataEntity.getPSDEViewBases();
        for (PSDEViewBase pSDEViewBase : arrayList3) {
            object2 = new PSDEViewBase();
            ((PSDEViewBaseBase)object2).setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
            boolean bl5 = false;
            if (!StringHelper.isNullOrEmpty((String)pSDEViewBase.getTitle()) && StringHelper.isNullOrEmpty((String)pSDEViewBase.getTitlePSLanResId())) {
                object = new PSLanguageRes();
                ((PSLanguageResBase)object).setPSSystemId(pSDataEntity.getPSSystemId());
                if (bl2) {
                    ((PSLanguageResBase)object).setPSModuleId(pSDataEntity.getPSModuleId());
                }
                ((PSLanguageResBase)object).setLanResType("PAGE");
                ((PSLanguageResBase)object).setUserData(StringHelper.format((String)"TITLE.%1$s.%2$s", (Object)pSDEViewBase.getPSDEName(), (Object)pSDEViewBase.getCodeName()).toUpperCase());
                if (!pSLanguageResService.select(object, true)) {
                    if (bl2) {
                        ((PSLanguageResBase)object).setPSModuleId(pSDataEntity.getPSModuleId());
                        ((PSLanguageResBase)object).setPSModuleName(pSDataEntity.getPSModuleName());
                    }
                    ((PSLanguageResBase)object).setPSDEId(pSDEViewBase.getPSDEId());
                    ((PSLanguageResBase)object).setPSDEName(pSDEViewBase.getPSDEName());
                    ((PSLanguageResBase)object).setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
                    ((PSLanguageResBase)object).setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
                    ((PSLanguageResBase)object).setContent(pSDEViewBase.getTitle());
                    pSLanguageResService.create(object);
                    ((PSDEViewBaseBase)object2).setTitlePSLanResId(((PSLanguageResBase)object).getPSLanguageResId());
                    ((PSDEViewBaseBase)object2).setTitlePSLanResName(((PSLanguageResBase)object).getPSLanguageResName());
                    bl5 = true;
                }
            } else if (bl && pSDEViewBase.getTitlePSLanRes() != null && StringHelper.compare((String)((PSLanguageResBase)(object = pSDEViewBase.getTitlePSLanRes())).getContent(), (String)pSDEViewBase.getTitle(), (boolean)false) != 0) {
                object.reset();
                ((PSLanguageResBase)object).setPSSystemId(pSDataEntity.getPSSystemId());
                if (bl2) {
                    ((PSLanguageResBase)object).setPSModuleId(pSDataEntity.getPSModuleId());
                    ((PSLanguageResBase)object).setPSModuleName(pSDataEntity.getPSModuleName());
                }
                ((PSLanguageResBase)object).setLanResType("PAGE");
                ((PSLanguageResBase)object).setUserData(StringHelper.format((String)"TITLE.%1$s.%2$s", (Object)pSDEViewBase.getPSDEName(), (Object)pSDEViewBase.getCodeName()).toUpperCase());
                ((PSLanguageResBase)object).setPSDEId(pSDEViewBase.getPSDEId());
                ((PSLanguageResBase)object).setPSDEName(pSDEViewBase.getPSDEName());
                ((PSLanguageResBase)object).setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
                ((PSLanguageResBase)object).setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
                ((PSLanguageResBase)object).setContent(pSDEViewBase.getTitle());
                pSLanguageResService.save((IEntity)object);
                ((PSDEViewBaseBase)object2).setTitlePSLanResId(((PSLanguageResBase)object).getPSLanguageResId());
                ((PSDEViewBaseBase)object2).setTitlePSLanResName(((PSLanguageResBase)object).getPSLanguageResName());
                bl5 = true;
            }
            if (!StringHelper.isNullOrEmpty((String)pSDEViewBase.getCaption()) && StringHelper.isNullOrEmpty((String)pSDEViewBase.getCapPSLanResId())) {
                object = new PSLanguageRes();
                ((PSLanguageResBase)object).setPSSystemId(pSDataEntity.getPSSystemId());
                if (bl2) {
                    ((PSLanguageResBase)object).setPSModuleId(pSDataEntity.getPSModuleId());
                }
                ((PSLanguageResBase)object).setLanResType("PAGE");
                ((PSLanguageResBase)object).setUserData(StringHelper.format((String)"CAPTION.%1$s.%2$s", (Object)pSDEViewBase.getPSDEName(), (Object)pSDEViewBase.getCodeName()).toUpperCase());
                if (!pSLanguageResService.select(object, true)) {
                    if (bl2) {
                        ((PSLanguageResBase)object).setPSModuleId(pSDataEntity.getPSModuleId());
                        ((PSLanguageResBase)object).setPSModuleName(pSDataEntity.getPSModuleName());
                    }
                    ((PSLanguageResBase)object).setPSDEId(pSDEViewBase.getPSDEId());
                    ((PSLanguageResBase)object).setPSDEName(pSDEViewBase.getPSDEName());
                    ((PSLanguageResBase)object).setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
                    ((PSLanguageResBase)object).setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
                    ((PSLanguageResBase)object).setContent(pSDEViewBase.getCaption());
                    pSLanguageResService.create(object);
                    ((PSDEViewBaseBase)object2).setCapPSLanResId(((PSLanguageResBase)object).getPSLanguageResId());
                    ((PSDEViewBaseBase)object2).setCapPSLanResName(((PSLanguageResBase)object).getPSLanguageResName());
                    bl5 = true;
                }
            } else if (bl && pSDEViewBase.getCapPSLanRes() != null && StringHelper.compare((String)((PSLanguageResBase)(object = pSDEViewBase.getCapPSLanRes())).getContent(), (String)pSDEViewBase.getCaption(), (boolean)false) != 0) {
                object.reset();
                ((PSLanguageResBase)object).setPSSystemId(pSDataEntity.getPSSystemId());
                if (bl2) {
                    ((PSLanguageResBase)object).setPSModuleId(pSDataEntity.getPSModuleId());
                    ((PSLanguageResBase)object).setPSModuleName(pSDataEntity.getPSModuleName());
                }
                ((PSLanguageResBase)object).setLanResType("PAGE");
                ((PSLanguageResBase)object).setUserData(StringHelper.format((String)"CAPTION.%1$s.%2$s", (Object)pSDEViewBase.getPSDEName(), (Object)pSDEViewBase.getCodeName()).toUpperCase());
                ((PSLanguageResBase)object).setPSDEId(pSDEViewBase.getPSDEId());
                ((PSLanguageResBase)object).setPSDEName(pSDEViewBase.getPSDEName());
                ((PSLanguageResBase)object).setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
                ((PSLanguageResBase)object).setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
                ((PSLanguageResBase)object).setContent(pSDEViewBase.getCaption());
                pSLanguageResService.save((IEntity)object);
                ((PSDEViewBaseBase)object2).setCapPSLanResId(((PSLanguageResBase)object).getPSLanguageResId());
                ((PSDEViewBaseBase)object2).setCapPSLanResName(((PSLanguageResBase)object).getPSLanguageResName());
                bl5 = true;
            }
            if (!StringHelper.isNullOrEmpty((String)pSDEViewBase.getSubCaption()) && StringHelper.isNullOrEmpty((String)pSDEViewBase.getSubCapPSLanResId())) {
                object = new PSLanguageRes();
                ((PSLanguageResBase)object).setPSSystemId(pSDataEntity.getPSSystemId());
                if (bl2) {
                    ((PSLanguageResBase)object).setPSModuleId(pSDataEntity.getPSModuleId());
                }
                ((PSLanguageResBase)object).setLanResType("PAGE");
                ((PSLanguageResBase)object).setUserData(StringHelper.format((String)"SUBCAP.%1$s.%2$s", (Object)pSDEViewBase.getPSDEName(), (Object)pSDEViewBase.getCodeName()).toUpperCase());
                if (!pSLanguageResService.select(object, true)) {
                    if (bl2) {
                        ((PSLanguageResBase)object).setPSModuleId(pSDataEntity.getPSModuleId());
                        ((PSLanguageResBase)object).setPSModuleName(pSDataEntity.getPSModuleName());
                    }
                    ((PSLanguageResBase)object).setPSDEId(pSDEViewBase.getPSDEId());
                    ((PSLanguageResBase)object).setPSDEName(pSDEViewBase.getPSDEName());
                    ((PSLanguageResBase)object).setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
                    ((PSLanguageResBase)object).setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
                    ((PSLanguageResBase)object).setContent(pSDEViewBase.getSubCaption());
                    pSLanguageResService.create(object);
                    ((PSDEViewBaseBase)object2).setSubCapPSLanResId(((PSLanguageResBase)object).getPSLanguageResId());
                    ((PSDEViewBaseBase)object2).setSubCapPSLanResName(((PSLanguageResBase)object).getPSLanguageResName());
                    bl5 = true;
                }
            } else if (bl && pSDEViewBase.getSubCapPSLanRes() != null && StringHelper.compare((String)((PSLanguageResBase)(object = pSDEViewBase.getSubCapPSLanRes())).getContent(), (String)pSDEViewBase.getSubCaption(), (boolean)false) != 0) {
                object.reset();
                ((PSLanguageResBase)object).setPSSystemId(pSDataEntity.getPSSystemId());
                if (bl2) {
                    ((PSLanguageResBase)object).setPSModuleId(pSDataEntity.getPSModuleId());
                    ((PSLanguageResBase)object).setPSModuleName(pSDataEntity.getPSModuleName());
                }
                ((PSLanguageResBase)object).setLanResType("PAGE");
                ((PSLanguageResBase)object).setUserData(StringHelper.format((String)"SUBCAP.%1$s.%2$s", (Object)pSDEViewBase.getPSDEName(), (Object)pSDEViewBase.getCodeName()).toUpperCase());
                ((PSLanguageResBase)object).setPSDEId(pSDEViewBase.getPSDEId());
                ((PSLanguageResBase)object).setPSDEName(pSDEViewBase.getPSDEName());
                ((PSLanguageResBase)object).setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
                ((PSLanguageResBase)object).setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
                ((PSLanguageResBase)object).setContent(pSDEViewBase.getSubCaption());
                pSLanguageResService.save((IEntity)object);
                ((PSDEViewBaseBase)object2).setSubCapPSLanResId(((PSLanguageResBase)object).getPSLanguageResId());
                ((PSDEViewBaseBase)object2).setSubCapPSLanResName(((PSLanguageResBase)object).getPSLanguageResName());
                bl5 = true;
            }
            if (!bl5) continue;
            ((PSCoreSysServiceBase)object4).update(object2, false);
        }
    }

    @Override
    protected void onAfterCreate(PSDataEntity pSDataEntity) throws Exception {
        if (!PSDataEntityService.isImpSysModelNowEx()) {
            this.initPSDETables(pSDataEntity);
        }
        super.onAfterCreate(pSDataEntity);
    }

    @Override
    protected void onAfterUpdate(PSDataEntity pSDataEntity) throws Exception {
        if (!PSDataEntityService.isImpSysModelNowEx()) {
            this.initPSDETables(pSDataEntity);
        }
        super.onAfterUpdate(pSDataEntity);
    }

    @Override
    protected void onBeforeRemove(PSDataEntity pSDataEntity) throws Exception {
        PSDataEntity pSDataEntity2 = (PSDataEntity)this.getLast((IEntity)pSDataEntity);
        if (DataObject.getIntegerValue((Object)pSDataEntity2.getRemoveFlag(), (Integer)0) != 1) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5fc5\u987b\u8bbe\u7f6e\u4e3a[\u5141\u8bb8\u5220\u9664]\u624d\u80fd\u5220\u9664", (Object)pSDataEntity2.getPSDataEntityName()));
        }
        if (!PSRTHelper.isRTDE(pSDataEntity2.getPSDataEntityName())) {
            PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = new PSSystem();
            pSSystem.setPSSystemId(pSDataEntity2.getPSSystemId());
            pSSystemService.decreaseDECnt(pSSystem);
        }
        super.onBeforeRemove(pSDataEntity);
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        return true;
    }

    @Override
    protected void onAfterRemove(PSDataEntity pSDataEntity) throws Exception {
        PSDataEntity pSDataEntity2 = (PSDataEntity)this.getLast((IEntity)pSDataEntity);
        if (pSDataEntity2 != null && !StringHelper.isNullOrEmpty((String)pSDataEntity2.getPSSystemId())) {
            this.resetPSSysModelLogs(pSDataEntity2.getPSSystemId());
        }
        super.onAfterRemove(pSDataEntity);
    }

    @Override
    protected boolean onMergeChild_PSDEFields(PSDataEntity pSDataEntity) throws Exception {
        if (super.onMergeChild_PSDEFields(pSDataEntity)) {
            PSDataEntity pSDataEntity2 = new PSDataEntity();
            pSDataEntity2.setPSDataEntityId(pSDataEntity.getPSDataEntityId());
            this.get((IEntity)pSDataEntity2);
            if (!PSRTHelper.isRTDE(pSDataEntity2.getPSDataEntityName())) {
                PSDCSysLic pSDCSysLic = this.getPSSystemLic(pSDataEntity2);
                if (pSDCSysLic != null) {
                    PSDCSysLicService pSDCSysLicService = (PSDCSysLicService)ServiceGlobal.getService(PSDCSysLicService.class);
                    pSDCSysLicService.testLic(pSDCSysLic, "MAXDEFCNTPERDE", pSDataEntity.getPSDEFieldsCnt());
                }
                return true;
            }
        }
        return false;
    }

    public PSDCSysLic getPSSystemLic(PSDataEntity pSDataEntity) throws Exception {
        PSSystem pSSystem = pSDataEntity.getPSSystem();
        if (pSSystem != null && !StringHelper.isNullOrEmpty((String)pSSystem.getPSDevSlnSysId())) {
            PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
            pSDevSlnSys.setPSDevSlnSysId(pSSystem.getPSDevSlnSysId());
            pSDevSlnSysService.get((IEntity)pSDevSlnSys);
            return pSDevSlnSys.getPSDCSysLic();
        }
        return null;
    }

    @Override
    protected void onFixLanRes(PSDataEntity pSDataEntity) throws Exception {
        this.get((IEntity)pSDataEntity);
        this.initPSDataEntityLanRes(pSDataEntity, true);
    }

    @Override
    protected void onInitWFFields(PSDataEntity pSDataEntity) throws Exception {
        String string = pSDataEntity.getPSDataEntityId();
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        PSDEField pSDEField = new PSDEField();
        pSDEField.setPSDEId(string);
        pSDEField.setBizTag(TAG_WFINSTANCEID);
        if (!pSDEFieldService.select(pSDEField, true)) {
            pSDEField.setPSDEFieldName(TAG_WFINSTANCEID);
            pSDEField.setCodeName("WFInstanceId");
            pSDEField.setLogicName("\u5de5\u4f5c\u6d41\u5b9e\u4f8b");
            pSDEField.setDEFType(1);
            pSDEField.setPSDataTypeId("TEXT");
            pSDEField.setPSDataTypeName("\u6587\u672c\uff0c\u53ef\u6307\u5b9a\u957f\u5ea6");
            pSDEField.setAllowEmpty(1);
            pSDEFieldService.save((IEntity)pSDEField);
        }
        pSDEField.reset();
        pSDEField.setPSDEId(string);
        pSDEField.setBizTag(TAG_WFSTATE);
        if (!pSDEFieldService.select(pSDEField, true)) {
            pSDEField.setPSDEFieldName(TAG_WFSTATE);
            pSDEField.setCodeName("WFState");
            pSDEField.setLogicName("\u5de5\u4f5c\u6d41\u72b6\u6001");
            pSDEField.setDEFType(1);
            pSDEField.setPSDataTypeId(TAG_WFSTATE);
            pSDEField.setPSDataTypeName("\u5de5\u4f5c\u6d41\u5904\u7406\u72b6\u6001");
            pSDEField.setAllowEmpty(1);
            pSDEFieldService.save((IEntity)pSDEField);
        }
        pSDEField.reset();
        pSDEField.setPSDEId(string);
        pSDEField.setBizTag(TAG_WFSTEP);
        if (!pSDEFieldService.select(pSDEField, true)) {
            pSDEField.setPSDEFieldName(TAG_WFSTEP);
            pSDEField.setCodeName("WFStep");
            pSDEField.setLogicName("\u5de5\u4f5c\u6d41\u6b65\u9aa4");
            pSDEField.setDEFType(1);
            pSDEField.setPSDataTypeId("SSCODELIST");
            pSDEField.setPSDataTypeName("\u5355\u9879\u9009\u62e9(\u6587\u672c\u503c)");
            pSDEField.setAllowEmpty(1);
            pSDEFieldService.save((IEntity)pSDEField);
        }
        pSDEField.reset();
        pSDEField.setPSDEId(string);
        pSDEField.setBizTag(TAG_WFVERSION);
        if (!pSDEFieldService.select(pSDEField, true)) {
            pSDEField.setPSDEFieldName(TAG_WFVERSION);
            pSDEField.setCodeName("WFVersion");
            pSDEField.setLogicName("\u6d41\u7a0b\u7248\u672c");
            pSDEField.setDEFType(1);
            pSDEField.setPSDataTypeId("TEXT");
            pSDEField.setPSDataTypeName("\u6587\u672c\uff0c\u53ef\u6307\u5b9a\u957f\u5ea6");
            pSDEField.setAllowEmpty(1);
            pSDEFieldService.save((IEntity)pSDEField);
        }
        pSDEField.reset();
        pSDEField.setPSDEId(string);
        pSDEField.setBizTag(TAG_WFUSERSTATE);
        if (!pSDEFieldService.select(pSDEField, true)) {
            pSDEField.setPSDEFieldName(pSDataEntity.getPSDataEntityName() + TAG_WFSTATE);
            String string2 = pSDataEntity.getCodeName();
            if (StringHelper.isNullOrEmpty((String)string2)) {
                string2 = pSDataEntity.getPSDataEntityName();
            }
            pSDEField.setCodeName(StringHelper.format((String)"%1$sWFState", (Object)string2));
            pSDEField.setLogicName("\u4e1a\u52a1\u72b6\u6001");
            pSDEField.setDEFType(1);
            pSDEField.setPSDataTypeId("SSCODELIST");
            pSDEField.setPSDataTypeName("\u5355\u9879\u9009\u62e9(\u6587\u672c\u503c)");
            pSDEField.setAllowEmpty(1);
            pSDEFieldService.save((IEntity)pSDEField);
        }
    }

    @Override
    protected void onInitViewMsgFields(PSDataEntity pSDataEntity) throws Exception {
        String string = pSDataEntity.getPSDataEntityId();
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        PSDEField pSDEField = new PSDEField();
        pSDEField.setPSDEId(string);
        pSDEField.setPSDEFieldName("SRFVIEWID");
        if (!pSDEFieldService.select(pSDEField, true)) {
            pSDEField.setPSDEFieldName("SRFVIEWID");
            pSDEField.setCodeName("SRFViewId");
            pSDEField.setLogicName("\u89c6\u56fe\u6807\u8bc6");
            pSDEField.setDEFType(1);
            pSDEField.setPSDataTypeId("TEXT");
            pSDEField.setPSDataTypeName("\u6587\u672c\uff0c\u53ef\u6307\u5b9a\u957f\u5ea6");
            pSDEField.setLength(200);
            pSDEField.setAllowEmpty(1);
            pSDEFieldService.save((IEntity)pSDEField);
        }
        pSDEField.reset();
        pSDEField.setPSDEId(string);
        pSDEField.setPSDEFieldName("SRFVIEWCLS");
        if (!pSDEFieldService.select(pSDEField, true)) {
            pSDEField.setPSDEFieldName("SRFVIEWCLS");
            pSDEField.setCodeName("SRFViewCls");
            pSDEField.setLogicName("\u89c6\u56fe\u7c7b\u540d");
            pSDEField.setDEFType(1);
            pSDEField.setPSDataTypeId("TEXT");
            pSDEField.setPSDataTypeName("\u6587\u672c\uff0c\u53ef\u6307\u5b9a\u957f\u5ea6");
            pSDEField.setLength(200);
            pSDEField.setAllowEmpty(1);
            pSDEFieldService.save((IEntity)pSDEField);
        }
    }

    @Override
    protected void onInitDEImage(PSDataEntity pSDataEntity) throws Exception {
        this.get((IEntity)pSDataEntity);
        if (!StringHelper.isNullOrEmpty((String)pSDataEntity.getPSSysImageId())) {
            return;
        }
        PSSysImage pSSysImage = new PSSysImage();
        pSSysImage.setSessionFactory(this.getSessionFactory());
        pSSysImage.setPSSystemId(pSDataEntity.getPSSystemId());
        pSSysImage.setPSSystemName(pSDataEntity.getPSSystemName());
        pSSysImage.setPSSysImageName(StringHelper.format((String)"\u5b9e\u4f53[%1$s][%2$s]", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDataEntity.getLogicName()));
        pSSysImage.setImagePath(StringHelper.format((String)"default/de/icon_%1$s.png", (Object)pSDataEntity.getPSDataEntityName().toLowerCase()));
        pSSysImage.setImagePathX(StringHelper.format((String)"default/de/icon_%1$s@{0}x.png", (Object)pSDataEntity.getPSDataEntityName().toLowerCase()));
        pSSysImage.create();
        String string = pSDataEntity.getPSDataEntityId();
        pSDataEntity.reset();
        pSDataEntity.setPSDataEntityId(string);
        pSDataEntity.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSDataEntity.setPSSysImageName(pSSysImage.getPSSysImageName());
        this.update(pSDataEntity);
    }

    @Override
    protected void onEnableMob(PSDataEntity pSDataEntity) throws Exception {
        this.get((IEntity)pSDataEntity);
        if (DataObject.getBoolValue((Integer)pSDataEntity.getEnableMob(), (boolean)false)) {
            return;
        }
        String string = pSDataEntity.getPSDataEntityId();
        pSDataEntity.reset();
        pSDataEntity.setPSDataEntityId(string);
        pSDataEntity.setEnableMob(1);
        this.update(pSDataEntity);
        this.initModel(pSDataEntity);
    }

    @Override
    protected String getEntityFolderKeyValue(PSDataEntity pSDataEntity, PSSystem pSSystem) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSSYSTEMID", (Object)pSDataEntity.getPSSystemId());
        selectCond.set("PSDATAENTITYNAME", (Object)pSDataEntity.getPSDataEntityName());
        selectCond.set("PSSYSMODELGROUPID", SelectCond.ISNULL);
        selectCond.setFetchFirst(true);
        ArrayList arrayList = this.select((ISelectCond)selectCond);
        if (arrayList.size() > 0) {
            return ((PSDataEntity)arrayList.get(0)).getPSDataEntityId();
        }
        return PSModelFolderKeyHelper.getModelKey((IEntity)pSDataEntity, pSSystem, this.getDEModel().getName(), "", this.getSessionFactory());
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void getDraft(PSDataEntity var1_1) throws Exception {
        block2: {
            super.getDraft(var1_1);
            if (var1_1.getDEType() == null) {
                var1_1.setDEType(1);
            }
            if (!StringHelper.isNullOrEmpty((String)var1_1.getPSDataEntityName()) || StringHelper.isNullOrEmpty((String)var1_1.getPSSystemId())) break block2;
            var2_2 = 0;
            do lbl-1000:
            // 3 sources

            {
                var3_3 = new PSDataEntity();
                var3_3.setPSSystemId(var1_1.getPSSystemId());
                var3_3.setPSDataEntityName(StringHelper.format((String)"ENTITY%1$s", (Object)(++var2_2 == 1 ? "" : Integer.valueOf(var2_2))));
                if (this.select(var3_3, true)) ** GOTO lbl-1000
                var1_1.setPSDataEntityName(var3_3.getPSDataEntityName());
                var3_3.reset();
                var3_3.setPSSystemId(var1_1.getPSSystemId());
                var3_3.setLogicName(StringHelper.format((String)"\u5b9e\u4f53%1$s", (Object)(var2_2 == 1 ? "" : Integer.valueOf(var2_2))));
            } while (this.select(var3_3, true));
            var1_1.setLogicName(var3_3.getLogicName());
        }
    }

    protected void initPSDETables(PSDataEntity pSDataEntity) throws Exception {
        PSDataEntity pSDataEntity2 = null;
        if (pSDataEntity.isFullEntity()) {
            pSDataEntity2 = pSDataEntity;
        } else {
            pSDataEntity2 = new PSDataEntity();
            pSDataEntity2.setPSDataEntityId(pSDataEntity.getPSDataEntityId());
            this.get((IEntity)pSDataEntity2);
        }
        this.onInitPSDETables(pSDataEntity2);
    }

    protected void onInitPSDETables(PSDataEntity pSDataEntity) throws Exception {
        PSDETableService pSDETableService = (PSDETableService)ServiceGlobal.getService(PSDETableService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETable> arrayList = pSDETableService.selectByPSDE(pSDataEntity);
        HashMap<String, PSDETable> hashMap = new HashMap<String, PSDETable>();
        for (PSDETable object : arrayList) {
            hashMap.put(object.getPSSysDBTableId(), object);
        }
        if ((DataObject.getIntegerValue((Object)pSDataEntity.getStorageMode(), (Integer)DEStorageTypeCodeListModel.SQL) & DEStorageTypeCodeListModel.SQL) == DEStorageTypeCodeListModel.SQL) {
            Object object2 = "DEFAULT";
            if (!StringHelper.isNullOrEmpty((String)pSDataEntity.getDSLink())) {
                object2 = pSDataEntity.getDSLink();
            }
            PSSysDBSchemeService pSSysDBSchemeService = (PSSysDBSchemeService)ServiceGlobal.getService(PSSysDBSchemeService.class, (SessionFactory)this.getSessionFactory());
            PSSysDBScheme pSSysDBScheme = null;
            SelectContext selectContext = new SelectContext();
            selectContext.set("PSSYSTEMID", (Object)pSDataEntity.getPSSystemId());
            selectContext.set("DSLINK", object2);
            ArrayList arrayList2 = pSSysDBSchemeService.select((ISelectCond)selectContext);
            if (arrayList2 != null) {
                for (PSSysDBScheme pSSysDBScheme2 : arrayList2) {
                    if (!StringHelper.isNullOrEmpty((String)pSDataEntity.getPSSysModelGroupId()) ? !pSDataEntity.getPSSysModelGroupId().equals(pSSysDBScheme2.getPSSysModelGroupId()) : !StringHelper.isNullOrEmpty((String)pSSysDBScheme2.getPSSysModelGroupId())) continue;
                    pSSysDBScheme = pSSysDBScheme2;
                    break;
                }
            }
            if (pSSysDBScheme == null && PSDataEntityService.isCloudMode()) {
                pSSysDBScheme = new PSSysDBScheme();
                pSSysDBScheme.setPSSysDBSchemeName(String.format("\u6570\u636e\u5e93\u4f53\u7cfb[%1$s]", object2));
                pSSysDBScheme.setPSSystemId(pSDataEntity.getPSSystemId());
                pSSysDBScheme.setDSLink((String)object2);
                if (!StringHelper.isNullOrEmpty((String)pSDataEntity.getPSSysModelGroupId())) {
                    pSSysDBScheme.setPSSysModelGroupId(pSDataEntity.getPSSysModelGroupId());
                }
                pSSysDBSchemeService.create(pSSysDBScheme);
            }
            if (pSSysDBScheme != null) {
                PSSysDBTableService pSSysDBTableService = (PSSysDBTableService)ServiceGlobal.getService(PSSysDBTableService.class, (SessionFactory)this.getSessionFactory());
                for (int i = 0; i < 1; ++i) {
                    PSDETable pSDETable;
                    String string = "";
                    String string2 = "";
                    String string3 = "";
                    if (i != 0) break;
                    string = pSDataEntity.getTableName();
                    string2 = "MAIN";
                    string3 = pSDataEntity.getLogicName();
                    if (StringHelper.isNullOrEmpty((String)string)) continue;
                    PSSysDBTable pSSysDBTable = new PSSysDBTable();
                    pSSysDBTable.setPSSysDBSchemeId(pSSysDBScheme.getPSSysDBSchemeId());
                    pSSysDBTable.setPSSysDBTableName(string.toUpperCase());
                    if (!pSSysDBTableService.select(pSSysDBTable, true)) {
                        pSSysDBTable.setCodeName(string);
                        pSSysDBTable.setLogicName(string3);
                        pSSysDBTable.setPSSysDBSchemeName(pSSysDBScheme.getPSSysDBSchemeName());
                        pSSysDBTable.setTableType("TABLE");
                        pSSysDBTableService.create(pSSysDBTable, true);
                    }
                    if ((pSDETable = (PSDETable)hashMap.remove(pSSysDBTable.getPSSysDBTableId())) == null) {
                        pSDETable = new PSDETable();
                        pSDETable.setPSDEId(pSDataEntity.getPSDataEntityId());
                        pSDETable.setPSSysDBTableId(pSSysDBTable.getPSSysDBTableId());
                        pSDETable.setPSDEName(pSDataEntity.getPSDataEntityName());
                        pSDETable.setPSSysDBTableName(pSSysDBTable.getPSSysDBTableName());
                        pSDETable.setPSDETableName(pSSysDBTable.getPSSysDBTableName());
                        pSDETable.setTableType(string2);
                        EntityBase.setIgnoreCheck((IEntity)pSDETable, (boolean)true);
                        pSDETableService.create(pSDETable, true);
                        continue;
                    }
                    if (StringHelper.compare((String)pSDETable.getTableType(), (String)string2, (boolean)false) == 0) continue;
                    pSDETable.setTableType(string2);
                    EntityBase.setIgnoreCheck((IEntity)pSDETable, (boolean)true);
                    pSDETableService.update(pSDETable, false);
                }
            }
        }
        for (PSDETable pSDETable : hashMap.values()) {
            pSDETableService.remove((IEntity)pSDETable);
        }
    }

    @Override
    protected void compileCurModelV2(PSDataEntity pSDataEntity, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSCoreSysServiceBase.ModelV2 modelV2 = this.getLastCompileModelV2("PSSYSMODELGROUP");
        if (modelV2 != null) {
            String string3 = modelV2.key;
            pSDataEntity.setPSSysModelGroupId(string3);
        }
        super.compileCurModelV2(pSDataEntity, objectNode, string, string2, n);
    }

    public PSDEDataSet getDefaultPSDEDataSet(PSDataEntity pSDataEntity, String string) throws Exception {
        PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDataSet> arrayList = pSDEDataSetService.selectByPSDE(pSDataEntity);
        if (StringHelper.isNullOrEmpty((String)string)) {
            for (PSDEDataSet pSDEDataSet : arrayList) {
                if (!DataObject.getBoolValue((Integer)pSDEDataSet.getDefaultMode(), (boolean)false)) continue;
                return pSDEDataSet;
            }
        }
        for (PSDEDataSet pSDEDataSet : arrayList) {
            if (!(StringHelper.isNullOrEmpty((String)string) ? StringHelper.isNullOrEmpty((String)pSDEDataSet.getPredefineType()) : StringHelper.compare((String)pSDEDataSet.getPredefineType(), (String)string, (boolean)false) == 0)) continue;
            return pSDEDataSet;
        }
        return null;
    }

    @Override
    protected void onInitDEMSViews(PSDataEntity pSDataEntity) throws Exception {
    }

    @Override
    protected SelectContext getListDRDataFolderCond(PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter, IService iService, String string, String string2, String string3, String string4, String string5) throws Exception {
        if (StringHelper.compare((String)string2, (String)"PSDEFID", (boolean)true) == 0) {
            string2 = "PSDEID";
        }
        return super.getListDRDataFolderCond(pSMOSFile, iPSMOSFileFilter, iService, string, string2, string3, string4, string5);
    }

    @Override
    protected void onSyncDETableDEFields(PSDataEntity pSDataEntity) throws Exception {
        if (!pSDataEntity.isFullEntity()) {
            this.get((IEntity)pSDataEntity);
        }
        this.initPSDETables(pSDataEntity);
        PSDETableService pSDETableService = (PSDETableService)ServiceGlobal.getService(PSDETableService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETable> arrayList = pSDETableService.selectByPSDE(pSDataEntity);
        for (PSDETable pSDETable : arrayList) {
            try {
                pSDETableService.syncDEFields(pSDETable);
            }
            catch (Exception exception) {
                throw new Exception(StringHelper.format((String)"\u540c\u6b65\u5b9e\u4f53\u6570\u636e\u8868[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)pSDETable.getPSDETableName(), (Object)exception.getMessage()), exception);
            }
        }
    }

    @Override
    protected void onSyncSubSysSADEFields(PSDataEntity pSDataEntity) throws Exception {
        if (!pSDataEntity.isFullEntity()) {
            this.get((IEntity)pSDataEntity);
        }
        if (pSDataEntity.getPSSubSysSADE() == null) {
            throw new Exception(StringHelper.format((String)"\u672a\u7ed1\u5b9a\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53"));
        }
        ArrayList<PSSubSysSADEField> arrayList = pSDataEntity.getPSSubSysSADE().getPSSubSysSADEFields();
        HashMap<String, PSSubSysSADEField> hashMap = new HashMap<String, PSSubSysSADEField>();
        for (PSSubSysSADEField serializable2 : arrayList) {
            hashMap.put(serializable2.getPSSubSysSADEFieldName().toUpperCase(), serializable2);
        }
        boolean bl = false;
        ArrayList<PSDEField> arrayList2 = pSDataEntity.getPSDEFields();
        for (Object object : arrayList2) {
            if (StringHelper.isNullOrEmpty((String)((PSDEFieldBase)object).getPSDEFieldName())) continue;
            hashMap.remove(((PSDEFieldBase)object).getPSDEFieldName().toUpperCase());
            if (DataObject.getIntegerValue((Object)((PSDEFieldBase)object).getPKey(), (Integer)0) != 1) continue;
            bl = true;
        }
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        for (PSSubSysSADEField pSSubSysSADEField : hashMap.values()) {
            PSDEField pSDEField = new PSDEField();
            pSDEField.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEField.setPSDEName(pSDataEntity.getPSDataEntityName());
            pSDEField.setPSSubSysSADEFieldId(pSSubSysSADEField.getPSSubSysSADEFieldId());
            pSDEField.setPSSubSysSADEFieldName(pSSubSysSADEField.getPSSubSysSADEFieldName());
            pSDEField.setDEFType(1);
            pSDEField.setPSDEFieldName(pSSubSysSADEField.getPSSubSysSADEFieldName().toUpperCase());
            if (!StringHelper.isNullOrEmpty((String)pSSubSysSADEField.getLogicName())) {
                pSDEField.setLogicName(pSSubSysSADEField.getLogicName());
            } else {
                pSDEField.setLogicName(pSSubSysSADEField.getPSSubSysSADEFieldName());
            }
            if (!StringHelper.isNullOrEmpty((String)pSSubSysSADEField.getCodeName())) {
                pSDEField.setCodeName(pSSubSysSADEField.getCodeName());
            } else {
                pSDEField.setCodeName(pSSubSysSADEField.getPSSubSysSADEFieldName());
            }
            pSDEField.setAllowEmpty(DataObject.getIntegerValue((Object)pSSubSysSADEField.getAllowEmpty(), (Integer)1));
            Integer n = pSSubSysSADEField.getStdDataType();
            if (n == null || n == 0) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u636e\u5217[%1$s]\u6570\u636e\u7c7b\u578b", (Object)pSSubSysSADEField.getPSSubSysSADEFieldName()));
            }
            int n2 = DataObject.getIntegerValue((Object)pSSubSysSADEField.getLength(), (Integer)-1);
            int n3 = DataObject.getIntegerValue((Object)pSSubSysSADEField.getPrecision2(), (Integer)-1);
            PSDEFDataTypeHelper.fillPSDEField(pSDEField, n, n2, n3);
            if (!bl && DataObject.getIntegerValue((Object)pSSubSysSADEField.getPKey(), (Integer)0) == 1) {
                pSDEField.setPKey(1);
                bl = true;
            }
            try {
                pSDEFieldService.create(pSDEField);
            }
            catch (Exception exception) {
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5c5e\u6027[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)pSDEField.getPSDEFieldName(), (Object)exception.getMessage()), exception);
            }
        }
    }

    @Override
    protected void onAutoSyncDEFields(PSDataEntity pSDataEntity) throws Exception {
        if (!pSDataEntity.isFullEntity()) {
            this.get((IEntity)pSDataEntity);
        }
        boolean bl = false;
        if (pSDataEntity.getPSSubSysSADE() != null) {
            this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5f00\u59cb\u4ece\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53\u540c\u6b65\u5c5e\u6027", (Object)pSDataEntity.getPSDataEntityName()), false);
            this.syncSubSysSADEFields(pSDataEntity);
            bl = true;
        }
        if (DataObject.getIntegerValue((Object)pSDataEntity.getExistingModel(), (Integer)0) == 1) {
            this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5f00\u59cb\u4ece\u73b0\u6709\u6570\u636e\u7ed3\u6784\u540c\u6b65\u5c5e\u6027", (Object)pSDataEntity.getPSDataEntityName()), false);
            this.syncDETableDEFields(pSDataEntity);
            bl = true;
        }
        PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        int n = DataObject.getIntegerValue((Object)pSDataEntity.getVirtualFlag(), (Integer)0);
        if (n == 1 || n == 4 || n == 5) {
            SelectCond selectCond = new SelectCond();
            selectCond.set("DERTYPE", (Object)"DERMULINH");
            selectCond.set("MINORPSDEID", (Object)pSDataEntity.getPSDataEntityId());
            selectCond.setOrderInfo("ORDER BY ORDERVALUE");
            ArrayList arrayList = pSDERService.select((ISelectCond)selectCond);
            if (arrayList.size() > 0) {
                this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5f00\u59cb\u4ece\u7ee7\u627f\u5b9e\u4f53\u540c\u6b65\u5c5e\u6027", (Object)pSDataEntity.getPSDataEntityName()), false);
                this.syncInheritDEField(pSDataEntity);
                bl = true;
            }
        } else if (n == 0) {
            PSDER pSDER = new PSDER();
            pSDER.setMinorPSDEId(pSDataEntity.getPSDataEntityId());
            pSDER.setDERType("DERINHERIT");
            if (pSDERService.select(pSDER, true)) {
                this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5f00\u59cb\u4ece\u7ee7\u627f\u5b9e\u4f53\u540c\u6b65\u5c5e\u6027", (Object)pSDataEntity.getPSDataEntityName()), false);
                this.syncInheritDEField(pSDataEntity);
                bl = true;
            }
        }
        if (!bl) {
            this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u65e0\u6cd5\u81ea\u52a8\u540c\u6b65\u5c5e\u6027\uff0c\u5f53\u524d\u4ec5\u652f\u6301\u4ee5\u4e0b\u573a\u666f\uff081\uff09\u5b9a\u4e49\u6709\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53\uff082\uff09\u5b9a\u4e49\u4e3a\u4f7f\u7528\u5916\u90e8\u6570\u636e\u7ed3\u6784\uff083\uff09\u5b9a\u4e49\u6709\u7ee7\u627f\u5173\u7cfb", (Object)pSDataEntity.getPSDataEntityName()), false);
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u65e0\u6cd5\u81ea\u52a8\u540c\u6b65\u5c5e\u6027\uff0c\u5f53\u524d\u4ec5\u652f\u6301\u4ee5\u4e0b\u573a\u666f\uff081\uff09\u5b9a\u4e49\u6709\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53\uff082\uff09\u5b9a\u4e49\u4e3a\u4f7f\u7528\u5916\u90e8\u6570\u636e\u7ed3\u6784\uff083\uff09\u5b9a\u4e49\u6709\u7ee7\u627f\u5173\u7cfb", (Object)pSDataEntity.getPSDataEntityName()));
        }
    }

    protected void initModelRTModes(PSDataEntity pSDataEntity) throws Exception {
        int n;
        boolean bl;
        if (!pSDataEntity.isFullEntity()) {
            this.get((IEntity)pSDataEntity);
        }
        boolean bl2 = bl = DataObject.getIntegerValue((Object)pSDataEntity.getDEType(), (Integer)1) == 1;
        if (bl) {
            this.initSimplePSDataQuery(pSDataEntity);
            if (DataObject.getBoolValue((Integer)pSDataEntity.getEnableOrgModel(), (boolean)true)) {
                this.initDEOrgModels(pSDataEntity);
            }
        }
        if (DataObject.getIntegerValue((Object)pSDataEntity.getEnableAudit(), (Integer)0) == 1) {
            this.initAuditPSDataQuery(pSDataEntity);
        }
        int n2 = n = bl ? 0 : 2;
        if ((DataObject.getIntegerValue((Object)pSDataEntity.getDataAccMode(), (Integer)n) & 2) == 2) {
            this.initMapPSDEOPPrivs(pSDataEntity);
        }
        if (pSDataEntity.getPSWFDEs().size() > 0) {
            this.initWFPSDEActions(pSDataEntity);
        }
    }

    protected void initSimplePSDataQuery(PSDataEntity pSDataEntity) throws Exception {
        PSDEFGroup pSDEFGroup = new PSDEFGroup();
        pSDEFGroup.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEFGroup.setGroupType("BASEFIELDS");
        boolean bl = false;
        PSDEFGroupService pSDEFGroupService = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
        if (!pSDEFGroupService.selectOne((IEntity)pSDEFGroup, true)) {
            pSDEFGroup.setCodeName("Simple{0}");
            pSDEFGroup.setPSDEFGroupName("\u57fa\u7840\u5c5e\u6027\u7ec4{0}");
            pSDEFGroupService.create(pSDEFGroup, false);
            this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u5c5e\u6027\u7ec4[%2$s]", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEFGroup.getPSDEFGroupName()), false);
            bl = true;
        }
        PSDEDataQuery pSDEDataQuery = new PSDEDataQuery();
        pSDEDataQuery.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEDataQuery.setViewColLevel(DEDataQueryColLevel2CodeListModel.DEFGROUP);
        pSDEDataQuery.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
        PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
        if (bl || !pSDEDataQueryService.selectOne((IEntity)pSDEDataQuery, true)) {
            pSDEDataQuery.setCodeName("Simple{0}");
            pSDEDataQuery.setPSDEDataQueryName("SIMPLE{0}");
            pSDEDataQuery.setLogicName("\u57fa\u7840\u5c5e\u6027\u67e5\u8be2{0}");
            pSDEDataQuery.setPubMode(0);
            pSDEDataQueryService.create(pSDEDataQuery, false);
            PSDEDQJoin pSDEDQJoin = new PSDEDQJoin();
            pSDEDQJoin.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
            pSDEDQJoin.setPSDEDQName(pSDEDataQuery.getPSDEDataQueryName());
            pSDEDQJoin.setJoinPSDEId(pSDEDataQuery.getPSDEId());
            pSDEDQJoin.setJoinPSDEName(pSDEDataQuery.getPSDEName());
            pSDEDQJoin.setMainFlag(1);
            pSDEDQJoin.setPSDEJoinTypeId("MAIN");
            pSDEDQJoin.setPSDEDQJoinName(pSDEDataQuery.getPSDEName());
            PSDEDQJoinService pSDEDQJoinService = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
            pSDEDQJoinService.create(pSDEDQJoin);
            this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u6570\u636e\u67e5\u8be2[%2$s]", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEDataQuery.getPSDEDataQueryName()), false);
        }
    }

    protected void initAuditPSDataQuery(PSDataEntity pSDataEntity) throws Exception {
        PSDEFGroup pSDEFGroup = new PSDEFGroup();
        pSDEFGroup.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEFGroup.setGroupType("AUDITFIELDS");
        boolean bl = false;
        PSDEFGroupService pSDEFGroupService = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
        if (!pSDEFGroupService.selectOne((IEntity)pSDEFGroup, true)) {
            pSDEFGroup.setCodeName("Audit{0}");
            pSDEFGroup.setPSDEFGroupName("\u5ba1\u8ba1\u5c5e\u6027\u7ec4{0}");
            pSDEFGroupService.create(pSDEFGroup, false);
            this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u5c5e\u6027\u7ec4[%2$s]", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEFGroup.getPSDEFGroupName()), false);
            bl = true;
        }
        PSDEDataQuery pSDEDataQuery = new PSDEDataQuery();
        pSDEDataQuery.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEDataQuery.setViewColLevel(DEDataQueryColLevel2CodeListModel.DEFGROUP);
        pSDEDataQuery.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
        PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
        if (bl || !pSDEDataQueryService.selectOne((IEntity)pSDEDataQuery, true)) {
            pSDEDataQuery.setCodeName("Audit{0}");
            pSDEDataQuery.setPSDEDataQueryName("AUDIT{0}");
            pSDEDataQuery.setLogicName("\u5ba1\u8ba1\u5c5e\u6027\u67e5\u8be2{0}");
            pSDEDataQuery.setPubMode(0);
            pSDEDataQueryService.create(pSDEDataQuery, false);
            PSDEDQJoin pSDEDQJoin = new PSDEDQJoin();
            pSDEDQJoin.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
            pSDEDQJoin.setPSDEDQName(pSDEDataQuery.getPSDEDataQueryName());
            pSDEDQJoin.setJoinPSDEId(pSDEDataQuery.getPSDEId());
            pSDEDQJoin.setJoinPSDEName(pSDEDataQuery.getPSDEName());
            pSDEDQJoin.setMainFlag(1);
            pSDEDQJoin.setPSDEJoinTypeId("MAIN");
            pSDEDQJoin.setPSDEDQJoinName(pSDEDataQuery.getPSDEName());
            PSDEDQJoinService pSDEDQJoinService = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
            pSDEDQJoinService.create(pSDEDQJoin);
            this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u6570\u636e\u67e5\u8be2[%2$s]", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEDataQuery.getPSDEDataQueryName()), false);
        }
    }

    protected void initDEOrgModels(PSDataEntity pSDataEntity) throws Exception {
        Object object;
        Object object2;
        Object object3;
        boolean bl = false;
        if (DataObject.getBoolValue((Integer)pSDataEntity.getExistingModel(), (boolean)false)) {
            bl = true;
        }
        if (!bl && DataObject.getIntegerValue((Object)pSDataEntity.getVirtualFlag(), (Integer)0) > 0) {
            bl = true;
        }
        if (!(bl || StringHelper.isNullOrEmpty((String)pSDataEntity.getPSSubSysServiceAPIId()) && StringHelper.isNullOrEmpty((String)pSDataEntity.getPSSubSysSADEId()))) {
            bl = true;
        }
        PSSystem pSSystem = PSDataEntityService.getCurrentPSSystem((IEntity)pSDataEntity, this.getSessionFactory());
        PSDCModelTempl pSDCModelTempl = null;
        if (!StringHelper.isNullOrEmpty((String)pSSystem.getPSDevSlnSysId())) {
            pSDCModelTempl = PSModelGlobal.getPSDCModelTempl(pSSystem.getPSDevSlnSysId());
        }
        HashMap<String, PSDCMTDEF> hashMap = new HashMap<String, PSDCMTDEF>();
        if (pSDCModelTempl != null) {
            object3 = pSDCModelTempl.getPSDCMTDEFs();
            object2 = ((ArrayList)object3).iterator();
            while (object2.hasNext()) {
                object = object2.next();
                if (StringHelper.isNullOrEmpty((String)((PSDCMTDEFBase)object).getPreDefinedType())) continue;
                hashMap.put(((PSDCMTDEFBase)object).getPreDefinedType(), (PSDCMTDEF)object);
            }
        }
        object3 = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        if (!bl) {
            object2 = new PSDEField();
            ((PSDEFieldBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
            ((PSDEFieldBase)object2).setPreDefineType("ORGID");
            if (!object3.selectOne((IEntity)object2, true)) {
                ((PSDEFieldBase)object2).resetPreDefineType();
                ((PSDEFieldBase)object2).setPSDEFieldName("ORGID");
                if (!object3.selectOne((IEntity)object2, true)) {
                    object = (PSDCMTDEF)hashMap.remove("ORGID");
                    if (object != null) {
                        ((PSDEFieldBase)object2).setPSDEFieldName(((PSDCMTDEFBase)object).getPSDCMTDEFName());
                        ((PSDEFieldBase)object2).setCodeName(((PSDCMTDEFBase)object).getCodeName());
                        ((PSDEFieldBase)object2).setLogicName(((PSDCMTDEFBase)object).getLogicName());
                        ((PSDEFieldBase)object2).setPSDataTypeId(((PSDCMTDEFBase)object).getDEFDataType());
                        ((PSDEFieldBase)object2).setLength(((PSDCMTDEFBase)object).getLength());
                        ((PSDEFieldBase)object2).setPreDefineType("ORGID");
                    } else {
                        if (PSDataEntityService.isEnableCodeNameUpperCamel()) {
                            ((PSDEFieldBase)object2).setPSDEFieldName(StringHelper.format((String)"ORG_ID"));
                        } else {
                            ((PSDEFieldBase)object2).setPSDEFieldName(StringHelper.format((String)"ORGID"));
                        }
                        ((PSDEFieldBase)object2).setLogicName("\u7ec4\u7ec7\u673a\u6784\u6807\u8bc6");
                        ((PSDEFieldBase)object2).setCodeName("OrgId");
                        ((PSDEFieldBase)object2).setPSDataTypeId("TEXT");
                        ((PSDEFieldBase)object2).setLength(60);
                        ((PSDEFieldBase)object2).setPreDefineType("ORGID");
                    }
                    ((PSDEFieldBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
                    ((PSDEFieldBase)object2).setTableName(pSDataEntity.getTableName());
                    ((PSDEFieldBase)object2).setDEFType(1);
                    ((PSDEFieldBase)object2).setPhysicalField(1);
                    ((PSDEFieldBase)object2).setAllowEmpty(1);
                    ((PSDEFieldBase)object2).setMajorField(0);
                    ((PSDEFieldBase)object2).setPKey(0);
                    ((PSDEFieldBase)object2).setFKey(0);
                    try {
                        ((PSCoreSysServiceBase)object3).create(object2, false);
                        this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u5c5e\u6027[%2$s]", (Object)pSDataEntity.getPSDataEntityName(), (Object)((PSDEFieldBase)object2).getPSDEFieldName()), false);
                    }
                    catch (Exception exception) {
                        log.error((Object)String.format("\u5efa\u7acb\u5b9e\u4f53\u5c5e\u6027[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", ((PSDEFieldBase)object2).getPSDEFieldName(), exception.getMessage()), (Throwable)exception);
                        this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u5c5e\u6027[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDataEntity.getPSDataEntityName(), (Object)((PSDEFieldBase)object2).getPSDEFieldName(), (Object)exception.getMessage()), false);
                        throw new Exception(String.format("\u5efa\u7acb\u5b9e\u4f53\u5c5e\u6027[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", ((PSDEFieldBase)object2).getPSDEFieldName(), exception.getMessage()), exception);
                    }
                }
            }
        }
        if (!bl) {
            object2 = new PSDEField();
            ((PSDEFieldBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
            ((PSDEFieldBase)object2).setPreDefineType("ORGSECTORID");
            if (!object3.selectOne((IEntity)object2, true)) {
                ((PSDEFieldBase)object2).resetPreDefineType();
                ((PSDEFieldBase)object2).setPSDEFieldName("ORGSECTORID");
                if (!object3.selectOne((IEntity)object2, true)) {
                    ((PSDEFieldBase)object2).setPSDEFieldName("DEPTID");
                    if (!object3.selectOne((IEntity)object2, true)) {
                        object = (PSDCMTDEF)hashMap.remove("ORGSECTORID");
                        if (object != null) {
                            ((PSDEFieldBase)object2).setPSDEFieldName(((PSDCMTDEFBase)object).getPSDCMTDEFName());
                            ((PSDEFieldBase)object2).setCodeName(((PSDCMTDEFBase)object).getCodeName());
                            ((PSDEFieldBase)object2).setLogicName(((PSDCMTDEFBase)object).getLogicName());
                            ((PSDEFieldBase)object2).setPSDataTypeId(((PSDCMTDEFBase)object).getDEFDataType());
                            ((PSDEFieldBase)object2).setLength(((PSDCMTDEFBase)object).getLength());
                            ((PSDEFieldBase)object2).setPreDefineType("ORGSECTORID");
                        } else {
                            if (PSDataEntityService.isEnableCodeNameUpperCamel()) {
                                ((PSDEFieldBase)object2).setPSDEFieldName(StringHelper.format((String)"DEPT_ID"));
                            } else {
                                ((PSDEFieldBase)object2).setPSDEFieldName(StringHelper.format((String)"DEPTID"));
                            }
                            ((PSDEFieldBase)object2).setLogicName("\u7ec4\u7ec7\u90e8\u95e8\u6807\u8bc6");
                            ((PSDEFieldBase)object2).setCodeName("DeptId");
                            ((PSDEFieldBase)object2).setPSDataTypeId("TEXT");
                            ((PSDEFieldBase)object2).setLength(60);
                            ((PSDEFieldBase)object2).setPreDefineType("ORGSECTORID");
                        }
                        ((PSDEFieldBase)object2).setPSDEId(pSDataEntity.getPSDataEntityId());
                        ((PSDEFieldBase)object2).setTableName(pSDataEntity.getTableName());
                        ((PSDEFieldBase)object2).setDEFType(1);
                        ((PSDEFieldBase)object2).setPhysicalField(1);
                        ((PSDEFieldBase)object2).setAllowEmpty(1);
                        ((PSDEFieldBase)object2).setMajorField(0);
                        ((PSDEFieldBase)object2).setPKey(0);
                        ((PSDEFieldBase)object2).setFKey(0);
                        try {
                            ((PSCoreSysServiceBase)object3).create(object2, false);
                            this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u5c5e\u6027[%2$s]", (Object)pSDataEntity.getPSDataEntityName(), (Object)((PSDEFieldBase)object2).getPSDEFieldName()), false);
                        }
                        catch (Exception exception) {
                            log.error((Object)String.format("\u5efa\u7acb\u5b9e\u4f53\u5c5e\u6027[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", ((PSDEFieldBase)object2).getPSDEFieldName(), exception.getMessage()), (Throwable)exception);
                            this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u5c5e\u6027[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDataEntity.getPSDataEntityName(), (Object)((PSDEFieldBase)object2).getPSDEFieldName(), (Object)exception.getMessage()), false);
                            throw new Exception(String.format("\u5efa\u7acb\u5b9e\u4f53\u5c5e\u6027[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", ((PSDEFieldBase)object2).getPSDEFieldName(), exception.getMessage()), exception);
                        }
                    }
                }
            }
        }
        object2 = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
        object = (PSDEUserRoleService)ServiceGlobal.getService(PSDEUserRoleService.class, (SessionFactory)this.getSessionFactory());
        PSDEOPPrivRoleService pSDEOPPrivRoleService = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDEID", (Object)pSDataEntity.getPSDataEntityId());
        ArrayList arrayList = object2.select((ISelectCond)selectCond);
        if (arrayList.size() > 0) {
            PSDEOPPrivRole pSDEOPPrivRole;
            PSDEUserRole pSDEUserRole;
            PSDEOPPriv pSDEOPPriv2;
            HashMap<String, PSDEOPPriv> hashMap2 = new HashMap<String, PSDEOPPriv>();
            for (PSDEOPPriv pSDEOPPriv2 : arrayList) {
                if (hashMap2.containsKey(pSDEOPPriv2.getPSDEOPPrivName()) && !StringHelper.isNullOrEmpty((String)pSDEOPPriv2.getPSDERId())) continue;
                hashMap2.put(pSDEOPPriv2.getPSDEOPPrivName(), pSDEOPPriv2);
            }
            PSDEOPPriv pSDEOPPriv3 = (PSDEOPPriv)hashMap2.get("READ");
            pSDEOPPriv2 = (PSDEOPPriv)hashMap2.get("UPDATE");
            PSDEOPPriv pSDEOPPriv4 = (PSDEOPPriv)hashMap2.get("DELETE");
            PSDEOPPriv pSDEOPPriv5 = (PSDEOPPriv)hashMap2.get("CREATE");
            if (pSDEOPPriv3 != null) {
                pSDEUserRole = new PSDEUserRole();
                pSDEUserRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                pSDEUserRole.setUserRoleTag("ALL_R");
                if (!object.selectOne((IEntity)pSDEUserRole, true)) {
                    pSDEUserRole.setPSDEUserRoleName("\u5168\u90e8\u6570\u636e\uff08\u8bfb\uff09");
                    pSDEUserRole.setDefaultFlag(0);
                    pSDEUserRole.setAllDataFlag(1);
                    try {
                        ((PSCoreSysServiceBaseBase)((Object)object)).create(pSDEUserRole);
                        this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u64cd\u4f5c\u89d2\u8272[%2$s]", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEUserRole.getPSDEUserRoleName()), false);
                    }
                    catch (Exception exception) {
                        log.error((Object)String.format("\u5efa\u7acb\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", pSDEUserRole.getPSDEUserRoleName(), exception.getMessage()), (Throwable)exception);
                        this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u64cd\u4f5c\u89d2\u8272[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEUserRole.getPSDEUserRoleName(), (Object)exception.getMessage()), false);
                        throw new Exception(String.format("\u5efa\u7acb\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", pSDEUserRole.getPSDEUserRoleName(), exception.getMessage()), exception);
                    }
                    pSDEOPPrivRole = new PSDEOPPrivRole();
                    pSDEOPPrivRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                    pSDEOPPrivRole.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEOPPrivRole.setRoleType("DEROLE");
                    pSDEOPPrivRole.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
                    pSDEOPPrivRole.setPSDEOPPrivId(pSDEOPPriv3.getPSDEOPPrivId());
                    pSDEOPPrivRole.setPSDEOPPrivName(pSDEOPPriv3.getPSDEOPPrivName());
                    pSDEOPPrivRole.setPSDEOPPrivRoleName(pSDEOPPriv3.getPSDEOPPrivName());
                    pSDEOPPrivRoleService.create(pSDEOPPrivRole, false);
                }
                pSDEUserRole = new PSDEUserRole();
                pSDEUserRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                pSDEUserRole.setUserRoleTag("CURORG_R");
                if (!object.selectOne((IEntity)pSDEUserRole, true)) {
                    pSDEUserRole.setPSDEUserRoleName("\u5f53\u524d\u7ec4\u7ec7\uff08\u8bfb\uff09");
                    pSDEUserRole.setDefaultFlag(0);
                    pSDEUserRole.setEnableOrgDR(1);
                    pSDEUserRole.setOrgDR(1);
                    try {
                        ((PSCoreSysServiceBaseBase)((Object)object)).create(pSDEUserRole);
                        this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u64cd\u4f5c\u89d2\u8272[%2$s]", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEUserRole.getPSDEUserRoleName()), false);
                    }
                    catch (Exception exception) {
                        log.error((Object)String.format("\u5efa\u7acb\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", pSDEUserRole.getPSDEUserRoleName(), exception.getMessage()), (Throwable)exception);
                        this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u64cd\u4f5c\u89d2\u8272[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEUserRole.getPSDEUserRoleName(), (Object)exception.getMessage()), false);
                        throw new Exception(String.format("\u5efa\u7acb\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", pSDEUserRole.getPSDEUserRoleName(), exception.getMessage()), exception);
                    }
                    pSDEOPPrivRole = new PSDEOPPrivRole();
                    pSDEOPPrivRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                    pSDEOPPrivRole.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEOPPrivRole.setRoleType("DEROLE");
                    pSDEOPPrivRole.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
                    pSDEOPPrivRole.setPSDEOPPrivId(pSDEOPPriv3.getPSDEOPPrivId());
                    pSDEOPPrivRole.setPSDEOPPrivName(pSDEOPPriv3.getPSDEOPPrivName());
                    pSDEOPPrivRole.setPSDEOPPrivRoleName(pSDEOPPriv3.getPSDEOPPrivName());
                    pSDEOPPrivRoleService.create(pSDEOPPrivRole, false);
                }
                pSDEUserRole = new PSDEUserRole();
                pSDEUserRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                pSDEUserRole.setUserRoleTag("CURDEPT_R");
                if (!object.selectOne((IEntity)pSDEUserRole, true)) {
                    pSDEUserRole.setPSDEUserRoleName("\u5f53\u524d\u90e8\u95e8\uff08\u8bfb\uff09");
                    pSDEUserRole.setDefaultFlag(0);
                    pSDEUserRole.setEnableSecDR(1);
                    pSDEUserRole.setSecDR(1);
                    try {
                        ((PSCoreSysServiceBaseBase)((Object)object)).create(pSDEUserRole);
                        this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u64cd\u4f5c\u89d2\u8272[%2$s]", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEUserRole.getPSDEUserRoleName()), false);
                    }
                    catch (Exception exception) {
                        log.error((Object)String.format("\u5efa\u7acb\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", pSDEUserRole.getPSDEUserRoleName(), exception.getMessage()), (Throwable)exception);
                        this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u64cd\u4f5c\u89d2\u8272[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEUserRole.getPSDEUserRoleName(), (Object)exception.getMessage()), false);
                        throw new Exception(String.format("\u5efa\u7acb\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", pSDEUserRole.getPSDEUserRoleName(), exception.getMessage()), exception);
                    }
                    pSDEOPPrivRole = new PSDEOPPrivRole();
                    pSDEOPPrivRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                    pSDEOPPrivRole.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEOPPrivRole.setRoleType("DEROLE");
                    pSDEOPPrivRole.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
                    pSDEOPPrivRole.setPSDEOPPrivId(pSDEOPPriv3.getPSDEOPPrivId());
                    pSDEOPPrivRole.setPSDEOPPrivName(pSDEOPPriv3.getPSDEOPPrivName());
                    pSDEOPPrivRole.setPSDEOPPrivRoleName(pSDEOPPriv3.getPSDEOPPrivName());
                    pSDEOPPrivRoleService.create(pSDEOPPrivRole, false);
                }
            }
            if (pSDEOPPriv3 != null && pSDEOPPriv2 != null && pSDEOPPriv4 != null && pSDEOPPriv5 != null) {
                pSDEUserRole = new PSDEUserRole();
                pSDEUserRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                pSDEUserRole.setUserRoleTag("ALL_RW");
                if (!object.selectOne((IEntity)pSDEUserRole, true)) {
                    pSDEUserRole.setPSDEUserRoleName("\u5168\u90e8\u6570\u636e\uff08\u8bfb\u5199\uff09");
                    pSDEUserRole.setDefaultFlag(0);
                    pSDEUserRole.setAllDataFlag(1);
                    try {
                        ((PSCoreSysServiceBaseBase)((Object)object)).create(pSDEUserRole);
                        this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u64cd\u4f5c\u89d2\u8272[%2$s]", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEUserRole.getPSDEUserRoleName()), false);
                    }
                    catch (Exception exception) {
                        log.error((Object)String.format("\u5efa\u7acb\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", pSDEUserRole.getPSDEUserRoleName(), exception.getMessage()), (Throwable)exception);
                        this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u64cd\u4f5c\u89d2\u8272[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEUserRole.getPSDEUserRoleName(), (Object)exception.getMessage()), false);
                        throw new Exception(String.format("\u5efa\u7acb\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", pSDEUserRole.getPSDEUserRoleName(), exception.getMessage()), exception);
                    }
                    pSDEOPPrivRole = new PSDEOPPrivRole();
                    pSDEOPPrivRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                    pSDEOPPrivRole.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEOPPrivRole.setRoleType("DEROLE");
                    pSDEOPPrivRole.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
                    pSDEOPPrivRole.setPSDEOPPrivId(pSDEOPPriv3.getPSDEOPPrivId());
                    pSDEOPPrivRole.setPSDEOPPrivName(pSDEOPPriv3.getPSDEOPPrivName());
                    pSDEOPPrivRole.setPSDEOPPrivRoleName(pSDEOPPriv3.getPSDEOPPrivName());
                    pSDEOPPrivRoleService.create(pSDEOPPrivRole, false);
                    pSDEOPPrivRole = new PSDEOPPrivRole();
                    pSDEOPPrivRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                    pSDEOPPrivRole.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEOPPrivRole.setRoleType("DEROLE");
                    pSDEOPPrivRole.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
                    pSDEOPPrivRole.setPSDEOPPrivId(pSDEOPPriv2.getPSDEOPPrivId());
                    pSDEOPPrivRole.setPSDEOPPrivName(pSDEOPPriv2.getPSDEOPPrivName());
                    pSDEOPPrivRole.setPSDEOPPrivRoleName(pSDEOPPriv2.getPSDEOPPrivName());
                    pSDEOPPrivRoleService.create(pSDEOPPrivRole, false);
                    pSDEOPPrivRole = new PSDEOPPrivRole();
                    pSDEOPPrivRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                    pSDEOPPrivRole.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEOPPrivRole.setRoleType("DEROLE");
                    pSDEOPPrivRole.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
                    pSDEOPPrivRole.setPSDEOPPrivId(pSDEOPPriv4.getPSDEOPPrivId());
                    pSDEOPPrivRole.setPSDEOPPrivName(pSDEOPPriv4.getPSDEOPPrivName());
                    pSDEOPPrivRole.setPSDEOPPrivRoleName(pSDEOPPriv4.getPSDEOPPrivName());
                    pSDEOPPrivRoleService.create(pSDEOPPrivRole, false);
                    pSDEOPPrivRole = new PSDEOPPrivRole();
                    pSDEOPPrivRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                    pSDEOPPrivRole.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEOPPrivRole.setRoleType("DEROLE");
                    pSDEOPPrivRole.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
                    pSDEOPPrivRole.setPSDEOPPrivId(pSDEOPPriv5.getPSDEOPPrivId());
                    pSDEOPPrivRole.setPSDEOPPrivName(pSDEOPPriv5.getPSDEOPPrivName());
                    pSDEOPPrivRole.setPSDEOPPrivRoleName(pSDEOPPriv5.getPSDEOPPrivName());
                    pSDEOPPrivRoleService.create(pSDEOPPrivRole, false);
                }
                pSDEUserRole = new PSDEUserRole();
                pSDEUserRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                pSDEUserRole.setUserRoleTag("CURORG_RW");
                if (!object.selectOne((IEntity)pSDEUserRole, true)) {
                    pSDEUserRole.setPSDEUserRoleName("\u5f53\u524d\u7ec4\u7ec7\uff08\u8bfb\u5199\uff09");
                    pSDEUserRole.setDefaultFlag(0);
                    pSDEUserRole.setEnableOrgDR(1);
                    pSDEUserRole.setOrgDR(1);
                    try {
                        ((PSCoreSysServiceBaseBase)((Object)object)).create(pSDEUserRole);
                        this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u64cd\u4f5c\u89d2\u8272[%2$s]", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEUserRole.getPSDEUserRoleName()), false);
                    }
                    catch (Exception exception) {
                        log.error((Object)String.format("\u5efa\u7acb\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", pSDEUserRole.getPSDEUserRoleName(), exception.getMessage()), (Throwable)exception);
                        this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u64cd\u4f5c\u89d2\u8272[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEUserRole.getPSDEUserRoleName(), (Object)exception.getMessage()), false);
                        throw new Exception(String.format("\u5efa\u7acb\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", pSDEUserRole.getPSDEUserRoleName(), exception.getMessage()), exception);
                    }
                    pSDEOPPrivRole = new PSDEOPPrivRole();
                    pSDEOPPrivRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                    pSDEOPPrivRole.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEOPPrivRole.setRoleType("DEROLE");
                    pSDEOPPrivRole.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
                    pSDEOPPrivRole.setPSDEOPPrivId(pSDEOPPriv3.getPSDEOPPrivId());
                    pSDEOPPrivRole.setPSDEOPPrivName(pSDEOPPriv3.getPSDEOPPrivName());
                    pSDEOPPrivRole.setPSDEOPPrivRoleName(pSDEOPPriv3.getPSDEOPPrivName());
                    pSDEOPPrivRoleService.create(pSDEOPPrivRole, false);
                    pSDEOPPrivRole = new PSDEOPPrivRole();
                    pSDEOPPrivRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                    pSDEOPPrivRole.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEOPPrivRole.setRoleType("DEROLE");
                    pSDEOPPrivRole.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
                    pSDEOPPrivRole.setPSDEOPPrivId(pSDEOPPriv2.getPSDEOPPrivId());
                    pSDEOPPrivRole.setPSDEOPPrivName(pSDEOPPriv2.getPSDEOPPrivName());
                    pSDEOPPrivRole.setPSDEOPPrivRoleName(pSDEOPPriv2.getPSDEOPPrivName());
                    pSDEOPPrivRoleService.create(pSDEOPPrivRole, false);
                    pSDEOPPrivRole = new PSDEOPPrivRole();
                    pSDEOPPrivRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                    pSDEOPPrivRole.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEOPPrivRole.setRoleType("DEROLE");
                    pSDEOPPrivRole.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
                    pSDEOPPrivRole.setPSDEOPPrivId(pSDEOPPriv4.getPSDEOPPrivId());
                    pSDEOPPrivRole.setPSDEOPPrivName(pSDEOPPriv4.getPSDEOPPrivName());
                    pSDEOPPrivRole.setPSDEOPPrivRoleName(pSDEOPPriv4.getPSDEOPPrivName());
                    pSDEOPPrivRoleService.create(pSDEOPPrivRole, false);
                    pSDEOPPrivRole = new PSDEOPPrivRole();
                    pSDEOPPrivRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                    pSDEOPPrivRole.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEOPPrivRole.setRoleType("DEROLE");
                    pSDEOPPrivRole.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
                    pSDEOPPrivRole.setPSDEOPPrivId(pSDEOPPriv5.getPSDEOPPrivId());
                    pSDEOPPrivRole.setPSDEOPPrivName(pSDEOPPriv5.getPSDEOPPrivName());
                    pSDEOPPrivRole.setPSDEOPPrivRoleName(pSDEOPPriv5.getPSDEOPPrivName());
                    pSDEOPPrivRoleService.create(pSDEOPPrivRole, false);
                }
                pSDEUserRole = new PSDEUserRole();
                pSDEUserRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                pSDEUserRole.setUserRoleTag("CURDEPT_RW");
                if (!object.selectOne((IEntity)pSDEUserRole, true)) {
                    pSDEUserRole.setPSDEUserRoleName("\u5f53\u524d\u90e8\u95e8\uff08\u8bfb\u5199\uff09");
                    pSDEUserRole.setDefaultFlag(0);
                    pSDEUserRole.setEnableSecDR(1);
                    pSDEUserRole.setSecDR(1);
                    try {
                        ((PSCoreSysServiceBaseBase)((Object)object)).create(pSDEUserRole);
                        this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u64cd\u4f5c\u89d2\u8272[%2$s]", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEUserRole.getPSDEUserRoleName()), false);
                    }
                    catch (Exception exception) {
                        log.error((Object)String.format("\u5efa\u7acb\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", pSDEUserRole.getPSDEUserRoleName(), exception.getMessage()), (Throwable)exception);
                        this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u64cd\u4f5c\u89d2\u8272[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEUserRole.getPSDEUserRoleName(), (Object)exception.getMessage()), false);
                        throw new Exception(String.format("\u5efa\u7acb\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", pSDEUserRole.getPSDEUserRoleName(), exception.getMessage()), exception);
                    }
                    pSDEOPPrivRole = new PSDEOPPrivRole();
                    pSDEOPPrivRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                    pSDEOPPrivRole.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEOPPrivRole.setRoleType("DEROLE");
                    pSDEOPPrivRole.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
                    pSDEOPPrivRole.setPSDEOPPrivId(pSDEOPPriv3.getPSDEOPPrivId());
                    pSDEOPPrivRole.setPSDEOPPrivName(pSDEOPPriv3.getPSDEOPPrivName());
                    pSDEOPPrivRole.setPSDEOPPrivRoleName(pSDEOPPriv3.getPSDEOPPrivName());
                    pSDEOPPrivRoleService.create(pSDEOPPrivRole, false);
                    pSDEOPPrivRole = new PSDEOPPrivRole();
                    pSDEOPPrivRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                    pSDEOPPrivRole.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEOPPrivRole.setRoleType("DEROLE");
                    pSDEOPPrivRole.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
                    pSDEOPPrivRole.setPSDEOPPrivId(pSDEOPPriv2.getPSDEOPPrivId());
                    pSDEOPPrivRole.setPSDEOPPrivName(pSDEOPPriv2.getPSDEOPPrivName());
                    pSDEOPPrivRole.setPSDEOPPrivRoleName(pSDEOPPriv2.getPSDEOPPrivName());
                    pSDEOPPrivRoleService.create(pSDEOPPrivRole, false);
                    pSDEOPPrivRole = new PSDEOPPrivRole();
                    pSDEOPPrivRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                    pSDEOPPrivRole.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEOPPrivRole.setRoleType("DEROLE");
                    pSDEOPPrivRole.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
                    pSDEOPPrivRole.setPSDEOPPrivId(pSDEOPPriv4.getPSDEOPPrivId());
                    pSDEOPPrivRole.setPSDEOPPrivName(pSDEOPPriv4.getPSDEOPPrivName());
                    pSDEOPPrivRole.setPSDEOPPrivRoleName(pSDEOPPriv4.getPSDEOPPrivName());
                    pSDEOPPrivRoleService.create(pSDEOPPrivRole, false);
                    pSDEOPPrivRole = new PSDEOPPrivRole();
                    pSDEOPPrivRole.setPSDEId(pSDataEntity.getPSDataEntityId());
                    pSDEOPPrivRole.setPSDEName(pSDataEntity.getPSDataEntityName());
                    pSDEOPPrivRole.setRoleType("DEROLE");
                    pSDEOPPrivRole.setPSDEUserRoleId(pSDEUserRole.getPSDEUserRoleId());
                    pSDEOPPrivRole.setPSDEOPPrivId(pSDEOPPriv5.getPSDEOPPrivId());
                    pSDEOPPrivRole.setPSDEOPPrivName(pSDEOPPriv5.getPSDEOPPrivName());
                    pSDEOPPrivRole.setPSDEOPPrivRoleName(pSDEOPPriv5.getPSDEOPPrivName());
                    pSDEOPPrivRoleService.create(pSDEOPPrivRole, false);
                }
            }
        }
    }

    protected void initMapPSDEOPPrivs(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDER> arrayList = pSDataEntity.getMinorPSDERs();
        if (arrayList == null) {
            return;
        }
        PSSystem pSSystem = PSDataEntityService.getCurrentPSSystem((IEntity)pSDataEntity, this.getSessionFactory());
        PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
        for (PSDER pSDER : arrayList) {
            Serializable serializable;
            int n;
            if (!"DER1N".equals(pSDER.getDERType()) && (!"DERCUSTOM".equals(pSDER.getDERType()) || !"DER1N".equals(pSDER.getDERSubType())) || ((n = DataObject.getIntegerValue((Object)pSDER.getMasterRS(), (Integer)0).intValue()) & 4) == 0) continue;
            PSDEOPPriv pSDEOPPriv = null;
            PSDEOPPriv pSDEOPPriv2 = null;
            SelectCond selectCond = new SelectCond();
            selectCond.set("PSDEID", (Object)pSDER.getMajorPSDEId());
            ArrayList arrayList2 = pSDEOPPrivService.select((ISelectCond)selectCond);
            if (arrayList2.size() > 0) {
                serializable = new HashMap();
                for (PSDEOPPriv pSDEOPPriv3 : arrayList2) {
                    if (serializable.containsKey(pSDEOPPriv3.getPSDEOPPrivName()) || !StringHelper.isNullOrEmpty((String)pSDEOPPriv3.getPSDERId())) continue;
                    serializable.put(pSDEOPPriv3.getPSDEOPPrivName(), pSDEOPPriv3);
                }
                pSDEOPPriv = (PSDEOPPriv)serializable.get("READ");
                pSDEOPPriv2 = (PSDEOPPriv)serializable.get("UPDATE");
            }
            if (pSDEOPPriv != null) {
                serializable = new PSDEOPPriv();
                ((PSDEOPPrivBase)serializable).setPSDEId(pSDataEntity.getPSDataEntityId());
                ((PSDEOPPrivBase)serializable).setPSDEOPPrivName("READ");
                ((PSDEOPPrivBase)serializable).setPSDERId(pSDER.getPSDERId());
                if (!pSDEOPPrivService.selectOne((IEntity)serializable, true)) {
                    ((PSDEOPPrivBase)serializable).setMapPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
                    ((PSDEOPPrivBase)serializable).setMapPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
                    ((PSDEOPPrivBase)serializable).setPSSystemId(pSSystem.getPSSystemId());
                    ((PSDEOPPrivBase)serializable).setPSSystemName(pSSystem.getPSSystemName());
                    try {
                        pSDEOPPrivService.create(serializable);
                        this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u64cd\u4f5c\u6807\u8bc6[%2$s]", (Object)pSDataEntity.getPSDataEntityName(), (Object)((PSDEOPPrivBase)serializable).getPSDEOPPrivName()), false);
                    }
                    catch (Exception exception) {
                        log.error((Object)String.format("\u5efa\u7acb\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", ((PSDEOPPrivBase)serializable).getPSDEOPPrivName(), exception.getMessage()), (Throwable)exception);
                        this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u64cd\u4f5c\u6807\u8bc6[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDataEntity.getPSDataEntityName(), (Object)((PSDEOPPrivBase)serializable).getPSDEOPPrivName(), (Object)exception.getMessage()), false);
                        throw new Exception(String.format("\u5efa\u7acb\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", ((PSDEOPPrivBase)serializable).getPSDEOPPrivName(), exception.getMessage()), exception);
                    }
                }
            }
            if (pSDEOPPriv2 == null) continue;
            serializable = new String[]{"UPDATE", "CREATE", "DELETE"};
            for (Object object : serializable) {
                PSDEOPPriv pSDEOPPriv4 = new PSDEOPPriv();
                pSDEOPPriv4.setPSDEId(pSDataEntity.getPSDataEntityId());
                pSDEOPPriv4.setPSDEOPPrivName((String)object);
                pSDEOPPriv4.setPSDERId(pSDER.getPSDERId());
                if (pSDEOPPrivService.selectOne((IEntity)pSDEOPPriv4, true)) continue;
                pSDEOPPriv4.setMapPSDEOPPrivId(pSDEOPPriv2.getPSDEOPPrivId());
                pSDEOPPriv4.setMapPSDEOPPrivName(pSDEOPPriv2.getPSDEOPPrivName());
                pSDEOPPriv4.setPSSystemId(pSSystem.getPSSystemId());
                pSDEOPPriv4.setPSSystemName(pSSystem.getPSSystemName());
                try {
                    pSDEOPPrivService.create(pSDEOPPriv4);
                    this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u64cd\u4f5c\u6807\u8bc6[%2$s]", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEOPPriv4.getPSDEOPPrivName()), false);
                }
                catch (Exception exception) {
                    log.error((Object)String.format("\u5efa\u7acb\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", pSDEOPPriv4.getPSDEOPPrivName(), exception.getMessage()), (Throwable)exception);
                    this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u64cd\u4f5c\u6807\u8bc6[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEOPPriv4.getPSDEOPPrivName(), (Object)exception.getMessage()), false);
                    throw new Exception(String.format("\u5efa\u7acb\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", pSDEOPPriv4.getPSDEOPPrivName(), exception.getMessage()), exception);
                }
            }
        }
    }

    protected void initWFPSDEActions(PSDataEntity pSDataEntity) throws Exception {
        PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        for (Map.Entry<String, String> entry : wfActionMap.entrySet()) {
            PSDEAction pSDEAction = new PSDEAction();
            pSDEAction.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEAction.setPSDEActionName(entry.getKey());
            if (pSDEActionService.selectOne((IEntity)pSDEAction, true)) continue;
            pSDEAction.setPSDEName(pSDataEntity.getPSDataEntityName());
            pSDEAction.setCodeName(entry.getKey());
            pSDEAction.setLogicName(entry.getValue());
            pSDEAction.setActionType("BUILTIN");
            if (StringHelper.compare((String)entry.getKey(), (String)"wfStart", (boolean)false) != 0) {
                pSDEAction.setPubMode(0);
            }
            try {
                pSDEActionService.create(pSDEAction, false);
                this.sendStudioConsole(true, "INFO", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u884c\u4e3a[%2$s]", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEAction.getPSDEActionName()), false);
            }
            catch (Exception exception) {
                log.error((Object)String.format("\u5efa\u7acb\u5b9e\u4f53\u884c\u4e3a[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", pSDEAction.getPSDEActionName(), exception.getMessage()), (Throwable)exception);
                this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5efa\u7acb\u884c\u4e3a[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)pSDataEntity.getPSDataEntityName(), (Object)pSDEAction.getPSDEActionName(), (Object)exception.getMessage()), false);
                throw new Exception(String.format("\u5efa\u7acb\u5b9e\u4f53\u884c\u4e3a[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", pSDEAction.getPSDEActionName(), exception.getMessage()), exception);
            }
        }
    }

    @Override
    public Object getDataContextValue(PSDataEntity pSDataEntity, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = super.getDataContextValue(pSDataEntity, string, iDataContextParam);
        if (object == null && StringHelper.compare((String)string, (String)"psdeid", (boolean)true) == 0) {
            return pSDataEntity.getPSDataEntityId();
        }
        return object;
    }

    static {
        rtDEMap.put("WFWORKFLOW", "");
        rtDEMap.put("WFINSTANCE", "");
        rtDEMap.put("SERVICE", "");
        rtDEMap.put("SYSADMIN", "");
        rtDEMap.put("WFSTEPDATA", "");
        rtDEMap.put("WFUSERGROUPDETAIL", "");
        rtDEMap.put("DATAENTITY", "");
        rtDEMap.put("USERROLEDATAACTION", "");
        rtDEMap.put("WFTMPSTEPACTOR", "");
        rtDEMap.put("USERROLEDEFIELD", "");
        rtDEMap.put("PPMODEL", "");
        rtDEMap.put("FILE", "");
        rtDEMap.put("USERROLE", "");
        rtDEMap.put("ORGUSER", "");
        rtDEMap.put("SYSADMINFUNC", "");
        rtDEMap.put("USEROBJECT", "");
        rtDEMap.put("MSGSENDQUEUE", "");
        rtDEMap.put("DATAAUDIT", "");
        rtDEMap.put("WFREMINDER", "");
        rtDEMap.put("ORGUNITCAT", "");
        rtDEMap.put("WFSTEPACTOR", "");
        rtDEMap.put("ORGTYPE", "");
        rtDEMap.put("WFSYSTEMUSER", "");
        rtDEMap.put("USERGROUPDETAIL", "");
        rtDEMap.put("WFCUSTOMPROCESS", "");
        rtDEMap.put("USERDICTITEM", "");
        rtDEMap.put("DALOG", "");
        rtDEMap.put("WFACTION", "");
        rtDEMap.put("ORGSECUSERTYPE", "");
        rtDEMap.put("WFAPPSETTING", "");
        rtDEMap.put("LOGINACCOUNT", "");
        rtDEMap.put("USERGROUP", "");
        rtDEMap.put("CODEITEM", "");
        rtDEMap.put("ORGSECTOR", "");
        rtDEMap.put("WFUIWIZARD", "");
        rtDEMap.put("REGISTRY", "");
        rtDEMap.put("MSGSENDQUEUEHIS", "");
        rtDEMap.put("WFSTEPINST", "");
        rtDEMap.put("WFDYNAMICUSER", "");
        rtDEMap.put("LOGINLOG", "");
        rtDEMap.put("MSGACCOUNT", "");
        rtDEMap.put("DATAAUDITDETAIL", "");
        rtDEMap.put("WFASSISTWORK", "");
        rtDEMap.put("CODELIST", "");
        rtDEMap.put("UNIRES", "");
        rtDEMap.put("WFUSERCANDIDATE", "");
        rtDEMap.put("ORGSECUSER", "");
        rtDEMap.put("WFACTOR", "");
        rtDEMap.put("USERROLEDATADETAIL", "");
        rtDEMap.put("USERROLEDETAIL", "");
        rtDEMap.put(TAG_WFSTEP, "");
        rtDEMap.put("MSGACCOUNTDETAIL", "");
        rtDEMap.put("USERROLEDATAS", "");
        rtDEMap.put("WFUSERASSIST", "");
        rtDEMap.put("USERROLEDATA", "");
        rtDEMap.put("USERDICTCAT", "");
        rtDEMap.put("WFWORKLIST", "");
        rtDEMap.put("USERROLEDEFIELDS", "");
        rtDEMap.put("PVPART", "");
        rtDEMap.put("USERDICT", "");
        rtDEMap.put("SYSTEM", "");
        rtDEMap.put("USERDGTHEME", "");
        rtDEMap.put("WFIAACTION", "");
        rtDEMap.put("MSGTEMPLATE", "");
        rtDEMap.put("ORG", "");
        rtDEMap.put("WFUSERGROUP", "");
        rtDEMap.put("ORGUSERLEVEL", "");
        rtDEMap.put("QUERYMODEL", "");
        rtDEMap.put("USERROLERES", "");
        rtDEMap.put("WFUSER", "");
        rtDEMap.put("WFWFVERSION", "");
        rtDEMap.put("USER", "");
        rtDEMap.put("USERROLETYPE", "");
        rtDEMap.put("PORTALPAGE", "");
        rtDEMap.put("WFUCPOLICY", "");
        wfActionMap.put("WFStart", "\u5de5\u4f5c\u6d41\u542f\u52a8");
        wfActionMap.put("WFInit", "\u5de5\u4f5c\u6d41\u521d\u59cb\u5316\u56de\u8c03");
        wfActionMap.put("WFUpdate", "\u5de5\u4f5c\u6d41\u66f4\u65b0\u56de\u8c03");
        wfActionMap.put("WFFinish", "\u5de5\u4f5c\u6d41\u5b8c\u6210\u56de\u8c03");
        wfActionMap.put("WFError", "\u5de5\u4f5c\u6d41\u9519\u8bef\u56de\u8c03");
        predefinedFieldMap.put("CREATEMAN", "");
        predefinedFieldMap.put("CREATEMANNAME", "");
        predefinedFieldMap.put("CREATEDATE", "");
        predefinedFieldMap.put("UPDATEMAN", "");
        predefinedFieldMap.put("UPDATEMANNAME", "");
        predefinedFieldMap.put("UPDATEDATE", "");
        predefinedFieldMap.put("ENABLE", "");
        predefinedFieldMap.put("ORGID", "");
        predefinedFieldMap.put("ORGSECTORID", "");
        predefinedFieldMap.put("ORGNAME", "");
        predefinedFieldMap.put("ORGSECTORNAME", "");
        predefinedFieldMap.put("ORDERVALUE", "");
    }
}

