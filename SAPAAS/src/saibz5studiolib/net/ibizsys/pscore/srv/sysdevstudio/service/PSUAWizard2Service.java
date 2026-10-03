/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vladsch.flexmark.ast.Document
 *  com.vladsch.flexmark.ast.Node
 *  com.vladsch.flexmark.ext.tables.TablesExtension
 *  com.vladsch.flexmark.html.HtmlRenderer
 *  com.vladsch.flexmark.parser.Parser
 *  com.vladsch.flexmark.parser.ParserEmulationProfile
 *  com.vladsch.flexmark.util.options.DataHolder
 *  com.vladsch.flexmark.util.options.MutableDataSet
 *  com.vladsch.flexmark.util.options.MutableDataSetter
 *  net.ibizsys.paas.core.RemoteCallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityException
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceUpdateParam
 *  net.ibizsys.paas.util.Base64Helper
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 *  org.yaml.snakeyaml.DumperOptions
 *  org.yaml.snakeyaml.DumperOptions$FlowStyle
 *  org.yaml.snakeyaml.Yaml
 */
package net.ibizsys.pscore.srv.sysdevstudio.service;

import com.vladsch.flexmark.ast.Document;
import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.options.DataHolder;
import com.vladsch.flexmark.util.options.MutableDataSet;
import com.vladsch.flexmark.util.options.MutableDataSetter;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import net.ibizsys.paas.core.RemoteCallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityException;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceUpdateParam;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippet;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCCodeSnippetService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.service.PSSVNServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUAWizard2;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSUAWizard2ServiceBase;
import net.ibizsys.pscore.srv.util.PSSysDevUserUserGlobal;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

@Component
public class PSUAWizard2Service
extends PSUAWizard2ServiceBase {
    private final String _S1 = "MFwwDQYJKoZIhvcNAQ";
    private final String _S2 = "EBBQADSwAwSAJBAK6ioJMxbkWnZU8NG";
    private final String _S6 = "TcvCbNOd3NrrFKDbSocWQQr+R4/MRznOksA";
    private final String _S3 = "DA4XtrmKer6Ro/8cYcHf17";
    private final String _S4 = "QUlyb3tJvh3cUCAwEAAQ==";
    private final String _ERR = "\u751f\u4ea7\u7ebf\u6388\u6743\u7801\u65e0\u6548";
    private final String _ERR2 = "\u751f\u4ea7\u7ebf\u6388\u6743\u7801\u5df2\u4f7f\u7528";
    public static final String WIZARD_DMCODE = "DMCODE";
    public static final String WIZARD_SYSINIT = "SYSINIT";
    public static final String WIZARD_DCINIT = "DCINIT";
    public static final String WIZARD_CHANGEPWD = "CHANGEPWD";
    public static final String WIZARD_APPINIT = "APPINIT";
    public static final String WIZARD_CODESNIPPET = "CODESNIPPET";
    public static final String WIZARD_SYSDEVENVINFO = "SYSDEVENVINFO";
    public static final String WIZARD_ASSIGNWORKSPACE = "ASSIGNWORKSPACE";
    public static final String WIZARD_INSTALLSYS = "INSTALLSYS";
    public static final String WIZARD_INSTALLSYS2 = "INSTALLSYS2";
    public static final String WIZARD_SUBSYSAPIIMPORT = "SUBSYSAPIIMPORT";
    public static final String WIZARD_INITDCWORKSPACE = "INITDCWORKSPACE";
    public static final String WIZARD_INITWORKSPACE = "INITWORKSPACE";
    public static final Random random = new Random();
    private static final Log log = LogFactory.getLog(PSUAWizard2Service.class);

    @Override
    public void getDraft(PSUAWizard2 pSUAWizard2) throws Exception {
        super.getDraft(pSUAWizard2);
        if (StringHelper.compare((String)pSUAWizard2.getWizardMode(), (String)WIZARD_DMCODE, (boolean)true) == 0) {
            this.getDMCodeDraft(pSUAWizard2);
            return;
        }
        if (StringHelper.compare((String)pSUAWizard2.getWizardMode(), (String)WIZARD_SYSDEVENVINFO, (boolean)true) == 0) {
            this.getSysDevInfoDraft(pSUAWizard2);
            return;
        }
        if (StringHelper.compare((String)pSUAWizard2.getWizardMode(), (String)WIZARD_CODESNIPPET, (boolean)true) == 0) {
            this.getCodeSnippetDraft(pSUAWizard2);
            return;
        }
        if (StringHelper.compare((String)pSUAWizard2.getWizardMode(), (String)WIZARD_INSTALLSYS, (boolean)true) == 0) {
            this.getInstallSysDraft(pSUAWizard2);
            return;
        }
        if (StringHelper.compare((String)pSUAWizard2.getWizardMode(), (String)WIZARD_INSTALLSYS2, (boolean)true) == 0) {
            this.getInstallSys2Draft(pSUAWizard2);
            return;
        }
    }

    protected void getDMCodeDraft(PSUAWizard2 pSUAWizard2) throws Exception {
        String string = pSUAWizard2.getActionData();
        PSSystemDBCfg pSSystemDBCfg = new PSSystemDBCfg();
        pSSystemDBCfg.setPSSystemDBCfgId(string);
        PSSysDMItemService pSSysDMItemService = (PSSysDMItemService)ServiceGlobal.getService(PSSysDMItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysDMItem> arrayList = pSSysDMItemService.selectByPSSystemDBCfg(pSSystemDBCfg);
        Collections.sort(arrayList, new Comparator<PSSysDMItem>(){

            @Override
            public int compare(PSSysDMItem pSSysDMItem, PSSysDMItem pSSysDMItem2) {
                int n = StringHelper.compare((String)pSSysDMItem.getPSDEName(), (String)pSSysDMItem2.getPSDEName(), (boolean)false);
                if (n != 0) {
                    return n;
                }
                return StringHelper.compare((String)pSSysDMItem.getPSSysDMItemName(), (String)pSSysDMItem2.getPSSysDMItemName(), (boolean)false);
            }
        });
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        this.appendDMCode(stringBuilderEx, arrayList, "TABLE");
        pSUAWizard2.setWizardParam(stringBuilderEx.toString());
        stringBuilderEx.reset();
        this.appendDMCode(stringBuilderEx, arrayList, "COLUMN");
        pSUAWizard2.setWizardParam2(stringBuilderEx.toString());
        stringBuilderEx.reset();
        this.appendDMCode(stringBuilderEx, arrayList, "VIEW");
        pSUAWizard2.setWizardParam3(stringBuilderEx.toString());
        stringBuilderEx.reset();
        this.appendDMCode(stringBuilderEx, arrayList, "FKEY");
        this.appendDMCode(stringBuilderEx, arrayList, "INDEX");
        pSUAWizard2.setWizardParam4(stringBuilderEx.toString());
    }

    protected void appendDMCode(StringBuilderEx stringBuilderEx, ArrayList<PSSysDMItem> arrayList, String string) {
        for (PSSysDMItem pSSysDMItem : arrayList) {
            if (StringHelper.compare((String)pSSysDMItem.getDBObjType(), (String)string, (boolean)true) != 0) continue;
            if (!StringHelper.isNullOrEmpty((String)pSSysDMItem.getDropSql())) {
                stringBuilderEx.append(pSSysDMItem.getDropSql());
                stringBuilderEx.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
            }
            if (!StringHelper.isNullOrEmpty((String)pSSysDMItem.getCreateSql3())) {
                stringBuilderEx.append(pSSysDMItem.getCreateSql3());
                stringBuilderEx.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
            }
            if (!StringHelper.isNullOrEmpty((String)pSSysDMItem.getCreateSql())) {
                stringBuilderEx.append(pSSysDMItem.getCreateSql());
                stringBuilderEx.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
            } else if (!StringHelper.isNullOrEmpty((String)pSSysDMItem.getCreateSql4())) {
                stringBuilderEx.append(pSSysDMItem.getCreateSql4());
                stringBuilderEx.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
            }
            if (!StringHelper.isNullOrEmpty((String)pSSysDMItem.getCreateSql2())) {
                stringBuilderEx.append(pSSysDMItem.getCreateSql2());
                stringBuilderEx.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
            }
            if (!StringHelper.isNullOrEmpty((String)pSSysDMItem.getCreateSql5())) {
                stringBuilderEx.append(pSSysDMItem.getCreateSql5());
                stringBuilderEx.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
            }
            if (!StringHelper.isNullOrEmpty((String)pSSysDMItem.getCreateSql6())) {
                stringBuilderEx.append(pSSysDMItem.getCreateSql6());
                stringBuilderEx.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
            }
            if (StringHelper.isNullOrEmpty((String)pSSysDMItem.getCreateSql7())) continue;
            stringBuilderEx.append(pSSysDMItem.getCreateSql7());
            stringBuilderEx.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
        }
    }

    protected void getSysDevInfoDraft(PSUAWizard2 pSUAWizard2) throws Exception {
        RemoteCallResult object;
        String string;
        String string2;
        StringBuilderEx stringBuilderEx;
        boolean bl = true;
        if (!StringHelper.isNullOrEmpty((String)this.getWebContext().getCurUserId())) {
            if (DataObject.getBoolValue((Object)pSUAWizard2.get("V6MODE"), (boolean)false)) {
                bl = false;
            } else {
                JSONObject appData = WebContext.getAppData();
                if (appData != null) {
                    string2 = appData.optString("pssystemid");
                    string = appData.optString("psdevslnsysid");
                    if (!(StringHelper.isNullOrEmpty((String)string2) && StringHelper.isNullOrEmpty((String)string)
                            || PSSysDevUserUserGlobal.getPSSysDevUser(this.getWebContext(), string, string2).getAccMode() == 5)) {
                        bl = false;
                    }
                }
            }
        }
        stringBuilderEx = new StringBuilderEx();
        if (!bl) {
            string2 = pSUAWizard2.getActionData();
            string = "";
            if (WebContext.getCurrent() != null) {
                string = WebContext.getCurrent().getAppDataValue("psdevslnsysid");
                pSUAWizard2.set("psdevslnsysid", string);
            }
            if (!StringHelper.isNullOrEmpty((String)string) && (object = this.executeRemoteCall3("GETSYSDEVENVINFO", pSUAWizard2)).getContent() != null) {
                stringBuilderEx.append((String)object.getContent());
            }
        } else {
            stringBuilderEx.append("\u6743\u9650\u4e0d\u8db3");
        }
        pSUAWizard2.setWizardParam(stringBuilderEx.toString());
    }

    @Override
    protected void onBeforeCreate(PSUAWizard2 pSUAWizard2) throws Exception {
        if (StringHelper.compare((String)pSUAWizard2.getWizardMode(), (String)WIZARD_CHANGEPWD, (boolean)true) == 0) {
            this.doChangeCurUserPwd(pSUAWizard2);
            return;
        }
        super.onBeforeCreate(pSUAWizard2);
    }

    @Override
    protected void onAfterCreate(PSUAWizard2 pSUAWizard2) throws Exception {
        super.onAfterCreate(pSUAWizard2);
        if (StringHelper.compare((String)pSUAWizard2.getWizardMode(), (String)WIZARD_SYSINIT, (boolean)true) == 0) {
            this.doSysInit(pSUAWizard2);
            return;
        }
        if (StringHelper.compare((String)pSUAWizard2.getWizardMode(), (String)WIZARD_DCINIT, (boolean)true) == 0) {
            this.doDCInit(pSUAWizard2);
            return;
        }
        if (StringHelper.compare((String)pSUAWizard2.getWizardMode(), (String)WIZARD_APPINIT, (boolean)true) == 0) {
            this.doAppInit(pSUAWizard2);
            return;
        }
        if (StringHelper.compare((String)pSUAWizard2.getWizardMode(), (String)WIZARD_ASSIGNWORKSPACE, (boolean)true) == 0) {
            this.doAssignWorkspace(pSUAWizard2);
            return;
        }
        if (StringHelper.compare((String)pSUAWizard2.getWizardMode(), (String)WIZARD_INSTALLSYS, (boolean)true) == 0) {
            this.doInstallSys(pSUAWizard2);
            return;
        }
        if (StringHelper.compare((String)pSUAWizard2.getWizardMode(), (String)WIZARD_INSTALLSYS2, (boolean)true) == 0) {
            this.doInstallSys2(pSUAWizard2);
            return;
        }
        if (StringHelper.compare((String)pSUAWizard2.getWizardMode(), (String)WIZARD_SUBSYSAPIIMPORT, (boolean)true) == 0) {
            this.doSubSysAPIImport(pSUAWizard2);
            return;
        }
        if (StringHelper.compare((String)pSUAWizard2.getWizardMode(), (String)WIZARD_INITDCWORKSPACE, (boolean)true) == 0) {
            this.doInitDCWorkspace(pSUAWizard2);
            return;
        }
        if (StringHelper.compare((String)pSUAWizard2.getWizardMode(), (String)WIZARD_INITWORKSPACE, (boolean)true) == 0) {
            this.doInitWorkspace(pSUAWizard2);
            return;
        }
    }

    protected void doSysInit(PSUAWizard2 pSUAWizard2) throws Exception {
        if (DataObject.getBoolValue((Integer)pSUAWizard2.getWizardParam10(), (boolean)false)) {
            this.executeAction("X_ADDINITSYSMODELTASK", pSUAWizard2);
        }
        if (DataObject.getBoolValue((Integer)pSUAWizard2.getWizardParam11(), (boolean)false)) {
            this.executeAction("X_ADDINITSYSDEDBMODELTASK", pSUAWizard2);
        }
        if (DataObject.getBoolValue((Integer)pSUAWizard2.getWizardParam12(), (boolean)false)) {
            this.executeAction("X_ADDIMPSUBSYSMODELTASK", pSUAWizard2);
        }
        if (DataObject.getBoolValue((Integer)pSUAWizard2.getWizardParam13(), (boolean)false)) {
            this.executeAction("X_ADDSYNCSUBSYSDBMODELTASK", pSUAWizard2);
        }
    }

    protected void doDCInit(PSUAWizard2 pSUAWizard2) throws Exception {
        PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
        PSDevCenter pSDevCenter = new PSDevCenter();
        pSDevCenter.setPSDevCenterId(pSUAWizard2.getActionData());
        pSDevCenterService.initModel(pSDevCenter);
    }

    public void doChangeCurUserPwd(PSUAWizard2 pSUAWizard2) throws Exception {
        String string;
        String string2 = DataObject.getStringValue((IDataObject)pSUAWizard2, (String)"oripassword", (String)"");
        String string3 = DataObject.getStringValue((IDataObject)pSUAWizard2, (String)"newpassword", (String)"");
        if (StringHelper.compare((String)string3, (String)(string = DataObject.getStringValue((IDataObject)pSUAWizard2, (String)"newpassword2", (String)"")), (boolean)false) != 0) {
            EntityError entityError = new EntityError();
            entityError.register("newpassowrd", "\u65b0\u5bc6\u7801", null, 3, "\u65b0\u5bc6\u7801\u8f93\u5165\u5fc5\u987b\u4e00\u81f4");
            entityError.register("newpassowrd2", "\u91cd\u590d\u65b0\u5bc6\u7801", null, 3, "\u65b0\u5bc6\u7801\u8f93\u5165\u5fc5\u987b\u4e00\u81f4");
            throw new EntityException(entityError);
        }
        pSUAWizard2.set("loginname", WebContext.getCurrent().getCurLoginName());
        this.executeRemoteCall2(WIZARD_CHANGEPWD, pSUAWizard2);
    }

    public void doChangePwd(PSUAWizard2 pSUAWizard2) throws Exception {
        this.executeRemoteCall2(WIZARD_CHANGEPWD, pSUAWizard2);
    }

    protected void doAppInit(PSUAWizard2 pSUAWizard2) throws Exception {
        this.executeAction("X_ADDINITAPPMODELTASK", pSUAWizard2);
    }

    public void doCreateUser(PSUAWizard2 pSUAWizard2) throws Exception {
        this.executeRemoteCall2("CREATEUSER", pSUAWizard2);
    }

    public void doUpdateSVNAuthZ(PSUAWizard2 pSUAWizard2) throws Exception {
        String string = DataObject.getStringValue((Object)pSUAWizard2.get("pssvnserverid"), null);
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        PSSVNServerService pSSVNServerService = (PSSVNServerService)ServiceGlobal.getService(PSSVNServerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSSVNServer pSSVNServer = new PSSVNServer();
        pSSVNServer.setPSSVNServerId(string);
        pSSVNServerService.get(pSSVNServer);
        if ("GIT".equals(pSSVNServer.getSVNType())) {
            return;
        }
        this.executeRemoteCall2("UPDATESVNAUTHZ", pSUAWizard2);
    }

    public void listPSDevSln(PSUAWizard2 pSUAWizard2) throws Exception {
        RemoteCallResult remoteCallResult = this.executeRemoteCall2("LISTDEVSLNSYS", pSUAWizard2);
        if (remoteCallResult.getJAContent() != null) {
            pSUAWizard2.setParam5(remoteCallResult.getJAContent().toString());
        }
    }

    protected void getCodeSnippetDraft(PSUAWizard2 pSUAWizard2) throws Exception {
        String string = pSUAWizard2.getParam5();
        String string2 = pSUAWizard2.getParam6();
        String string3 = pSUAWizard2.getActionData();
        PSDCCodeSnippet pSDCCodeSnippet = new PSDCCodeSnippet();
        pSDCCodeSnippet.setPSDCCodeSnippetId(string3);
        PSDCCodeSnippetService pSDCCodeSnippetService = (PSDCCodeSnippetService)ServiceGlobal.getService(PSDCCodeSnippetService.class, (SessionFactory)this.getSessionFactory());
        pSDCCodeSnippetService.getModelCode(pSDCCodeSnippet);
        pSUAWizard2.setWizardParam(pSDCCodeSnippet.getTemplCode());
        if (!StringHelper.isNullOrEmpty((String)pSDCCodeSnippet.getTemplCode())) {
            try {
                String string4 = pSDCCodeSnippet.getTemplCode();
                MutableDataSet mutableDataSet = new MutableDataSet();
                mutableDataSet.setFrom((MutableDataSetter)ParserEmulationProfile.MARKDOWN);
                mutableDataSet.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));
                Parser parser = Parser.builder((DataHolder)mutableDataSet).build();
                HtmlRenderer htmlRenderer = HtmlRenderer.builder((DataHolder)mutableDataSet).build();
                Document document = parser.parse(string4);
                String string5 = htmlRenderer.render((Node)document);
                string5 = "<div style='width:100%;height:500px;overflow:auto;' class='markdown-body' id='markdowndiv'>" + string5 + "</div>";
                pSUAWizard2.setWizardParam2(string5);
            }
            catch (Exception exception) {
                log.error((Object)exception);
            }
        }
    }

    public void updateFinish(final PSUAWizard2 pSUAWizard2) throws Exception {
        this.update(new ServiceUpdateParam<PSUAWizard2>(){

            public PSUAWizard2 getEntity() {
                return pSUAWizard2;
            }

            public void doBeforeAction(PSUAWizard2 pSUAWizard22) throws Exception {
                PSUAWizard2Service.this.onBeforeUpdateFinish(pSUAWizard22);
            }

            public void doAfterAction(PSUAWizard2 pSUAWizard22) throws Exception {
                PSUAWizard2Service.this.onAfterUpdateFinish(pSUAWizard22);
            }

            public boolean isPrepareLast() {
                return PSUAWizard2Service.this.isPrepareLastForUpdate();
            }

            public boolean isSysUpdate() {
                return true;
            }
        });
    }

    protected void onBeforeUpdateFinish(PSUAWizard2 pSUAWizard2) throws Exception {
    }

    protected void onAfterUpdateFinish(PSUAWizard2 pSUAWizard2) throws Exception {
    }

    protected void doAssignWorkspace(PSUAWizard2 pSUAWizard2) throws Exception {
        PSDCWorkspaceService pSDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCWorkspace pSDCWorkspace = new PSDCWorkspace();
        pSDCWorkspace.setPSDCWorkspaceId(pSUAWizard2.getActionData());
        pSDCWorkspace.setPSDevSlnId(pSUAWizard2.getParam5());
        pSDCWorkspace.setPSDevSlnName(pSUAWizard2.getParam6());
        pSDCWorkspaceService.assign(pSDCWorkspace);
    }

    private void doInitDCWorkspace(PSUAWizard2 pSUAWizard2) throws Exception {
        PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevCenter pSDevCenter = new PSDevCenter();
        pSDevCenter.setPSDevCenterId(pSUAWizard2.getActionData());
        pSDevCenterService.get(pSDevCenter);
        int n = DataObject.getIntegerValue((Object)pSUAWizard2.getWizardParam10(), (Integer)1);
        int n2 = DataObject.getIntegerValue((Object)pSUAWizard2.getWizardParam11(), (Integer)365);
        PSWorkspaceService pSWorkspaceService = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        ArrayList<PSWorkspace> arrayList = new ArrayList<PSWorkspace>();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis() + (long)(n2 * 24 * 60 * 60 * 1000));
        if (n2 >= 9999) {
            timestamp = null;
        }
        for (int i = 0; i < n; ++i) {
            PSWorkspace pSWorkspace = new PSWorkspace();
            pSWorkspace.setPSWorkspaceName(String.format("\u751f\u4ea7\u7ebf[%1$s]_%2$s", pSDevCenter.getPSDevCenterName(), random.nextInt(9999999)));
            pSWorkspace.setExpiredTime(timestamp);
            pSWorkspace.setWorkspaceState(20);
            pSWorkspace.setWorkspaceType("CLOUD");
            pSWorkspace.setWorkspaceUsage("CLOUD");
            pSWorkspace.setPSSvrDomainId(pSDevCenter.getPSSvrDomainId());
            pSWorkspace.setPSSvrDomainName(pSDevCenter.getPSSvrDomainName());
            pSWorkspaceService.create(pSWorkspace);
            arrayList.add(pSWorkspace);
        }
        for (PSWorkspace pSWorkspace : arrayList) {
            pSWorkspace.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
            pSWorkspace.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
            pSWorkspaceService.bindDC(pSWorkspace);
        }
    }

    private void doInitWorkspace(PSUAWizard2 pSUAWizard2) throws Exception {
        String string;
        PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevCenter pSDevCenter = new PSDevCenter();
        pSDevCenter.setPSDevCenterId(PSUAWizard2Service.getCurrentPSDCId());
        pSDevCenterService.get(pSDevCenter);
        String string2 = pSUAWizard2.getWizardParam();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            log.error((Object)"1");
            throw new Exception("\u751f\u4ea7\u7ebf\u6388\u6743\u7801\u65e0\u6548");
        }
        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        Yaml yaml = new Yaml(dumperOptions);
        Map map = null;
        try {
            string = new String(Base64Helper.decode((String)string2), "UTF-8");
            log.debug((Object)string);
            map = (Map)yaml.loadAs(string, Map.class);
        }
        catch (Throwable throwable) {
            log.error((Object)throwable);
            throw new Exception("\u751f\u4ea7\u7ebf\u6388\u6743\u7801\u65e0\u6548");
        }
        string = (String)map.remove("PARAM".toLowerCase());
        if (StringHelper.isNullOrEmpty((String)string)) {
            log.error((Object)"2");
            throw new Exception("\u751f\u4ea7\u7ebf\u6388\u6743\u7801\u65e0\u6548");
        }
        log.debug((Object)string);
        String string3 = yaml.dump((Object)map);
        log.debug((Object)string3);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64Helper.decode((String)"MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAK6ioJMxbkWnZU8NGTcvCbNOd3NrrFKDbSocWQQr+R4/MRznOksADA4XtrmKer6Ro/8cYcHf17QUlyb3tJvh3cUCAwEAAQ=="));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(publicKey);
        signature.update(string3.getBytes("UTF-8"));
        boolean bl = signature.verify(Base64Helper.decode((String)string));
        if (!bl) {
            log.error((Object)"3");
            throw new Exception("\u751f\u4ea7\u7ebf\u6388\u6743\u7801\u65e0\u6548");
        }
        PSWorkspaceService pSWorkspaceService = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSWorkspace pSWorkspace = new PSWorkspace();
        pSWorkspace.setPSWorkspaceId(KeyValueHelper.genUniqueId((String)"CLOUD", (String)string, (String)"CLOUD"));
        if (pSWorkspaceService.get(pSWorkspace, true)) {
            throw new Exception("\u751f\u4ea7\u7ebf\u6388\u6743\u7801\u5df2\u4f7f\u7528");
        }
        try {
            pSWorkspace.setPSWorkspaceName(DataTypeHelper.getStringValue(map.get("PSWORKSPACENAME".toLowerCase())));
            pSWorkspace.setParam(string);
            pSWorkspace.setParam2(DataTypeHelper.getStringValue(map.get("PARAM2".toLowerCase())));
            pSWorkspace.setParam3(DataTypeHelper.getStringValue(map.get("PARAM3".toLowerCase())));
            pSWorkspace.setParam4(DataTypeHelper.getStringValue(map.get("PARAM4".toLowerCase())));
            pSWorkspace.setParam5(DataTypeHelper.getIntegerValue(map.get("PARAM5".toLowerCase())));
            pSWorkspace.setParam6(DataTypeHelper.getIntegerValue(map.get("PARAM6".toLowerCase())));
            pSWorkspace.setParam7(DataTypeHelper.getIntegerValue(map.get("PARAM7".toLowerCase())));
            pSWorkspace.setParam8(DataTypeHelper.getIntegerValue(map.get("PARAM8".toLowerCase())));
            pSWorkspace.setExpiredTime(DataTypeHelper.getTimestampValue(map.get("EXPIREDTIME".toLowerCase())));
            pSWorkspace.setWorkspaceType(DataTypeHelper.getStringValue(map.get("WORKSPACETYPE".toLowerCase())));
            pSWorkspace.setWorkspaceUsage(DataTypeHelper.getStringValue(map.get("WORKSPACEUSAGE".toLowerCase())));
            pSWorkspace.setWorkspaceState(20);
            pSWorkspace.setPSSvrDomainId(pSDevCenter.getPSSvrDomainId());
            pSWorkspace.setPSSvrDomainName(pSDevCenter.getPSSvrDomainName());
            pSWorkspaceService.create(pSWorkspace);
            pSWorkspace.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
            pSWorkspace.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
            pSWorkspaceService.bindDC(pSWorkspace);
        }
        catch (Throwable throwable) {
            log.error((Object)throwable);
            throw new Exception("\u751f\u4ea7\u7ebf\u6388\u6743\u7801\u65e0\u6548");
        }
        pSUAWizard2.setPSUAWizard2Name(pSWorkspace.getPSWorkspaceName());
    }

    protected void getInstallSysDraft(PSUAWizard2 pSUAWizard2) throws Exception {
        PSDCWorkspaceService pSDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCWorkspace pSDCWorkspace = new PSDCWorkspace();
        pSDCWorkspace.setPSDCWorkspaceId(pSUAWizard2.getActionData());
        pSDCWorkspaceService.get(pSDCWorkspace);
        pSUAWizard2.setParam7(pSDCWorkspace.getPSDevSlnId());
    }

    protected void doInstallSys(PSUAWizard2 pSUAWizard2) throws Exception {
        PSDCWorkspaceService pSDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCWorkspace pSDCWorkspace = new PSDCWorkspace();
        pSDCWorkspace.setPSDCWorkspaceId(pSUAWizard2.getActionData());
        pSDCWorkspace.setPSDevSlnSysId(pSUAWizard2.getParam5());
        pSDCWorkspace.setPSDevSlnSysName(pSUAWizard2.getParam6());
        pSDCWorkspaceService.installSys(pSDCWorkspace);
    }

    protected void getInstallSys2Draft(PSUAWizard2 pSUAWizard2) throws Exception {
        PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
        pSDevSlnSys.setPSDevSlnSysId(pSUAWizard2.getActionData());
        pSDevSlnSysService.get(pSDevSlnSys);
        if (DataObject.getIntegerValue((Object)pSDevSlnSys.getDevSysState(), (Integer)DevSysStateCodeListModel.ONLINE) != DevSysStateCodeListModel.OFFLINE) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf\u672a\u5904\u4e8e\u79bb\u7ebf\u72b6\u6001"));
        }
        pSUAWizard2.setParam7(pSDevSlnSys.getPSDevSlnId());
    }

    protected void doInstallSys2(PSUAWizard2 pSUAWizard2) throws Exception {
        PSDCWorkspace pSDCWorkspace;
        PSDCWorkspaceService pSDCWorkspaceService;
        PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
        pSDevSlnSys.setPSDevSlnSysId(pSUAWizard2.getActionData());
        pSDevSlnSysService.get(pSDevSlnSys);
        if (DataObject.getIntegerValue((Object)pSDevSlnSys.getDevSysState(), (Integer)DevSysStateCodeListModel.ONLINE) != DevSysStateCodeListModel.OFFLINE) {
            throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf\u672a\u5904\u4e8e\u79bb\u7ebf\u72b6\u6001"));
        }
        String string = pSUAWizard2.getParam5();
        if (StringHelper.isNullOrEmpty((String)string)) {
            if (PSUAWizard2Service.isCloudMode()) {
                pSDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                SelectContext selectContext = new SelectContext();
                selectContext.set("PSDEVCENTERID", pSDevSlnSys.getPSDevCenterId());
                selectContext.set("RESSTATE", 20);
                selectContext.set("WORKSPACESTATE", 30);
                selectContext.setIsNull("PSDEVSLNSYSID");
                ArrayList<PSDCWorkspace> arrayList = pSDCWorkspaceService.select((ISelectCond)selectContext);
                if (arrayList != null && arrayList.size() != 0) {
                    for (PSDCWorkspace pSDCWorkspace2 : arrayList) {
                        if (StringHelper.compare((String)pSDevSlnSys.getPSDevSlnId(), (String)pSDCWorkspace2.getPSDevSlnId(), (boolean)false) != 0 || pSDCWorkspace2.getExpiredTime() != null && pSDCWorkspace2.getExpiredTime().getTime() <= System.currentTimeMillis()) continue;
                        string = pSDCWorkspace2.getPSDCWorkspaceId();
                        break;
                    }
                    if (StringHelper.isNullOrEmpty((String)string)) {
                        for (PSDCWorkspace pSDCWorkspace2 : arrayList) {
                            if (!StringHelper.isNullOrEmpty((String)pSDCWorkspace2.getPSDevSlnId()) || pSDCWorkspace2.getExpiredTime() != null && pSDCWorkspace2.getExpiredTime().getTime() <= System.currentTimeMillis()) continue;
                            string = pSDCWorkspace2.getPSDCWorkspaceId();
                            break;
                        }
                    }
                }
            }
            if (StringHelper.isNullOrEmpty((String)string)) {
                throw new Exception("\u672a\u6307\u5b9a\u751f\u4ea7\u7ebf");
            }
        }
        pSDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        pSDCWorkspace = new PSDCWorkspace();
        pSDCWorkspace.setPSDCWorkspaceId(string);
        pSDCWorkspace.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
        pSDCWorkspace.setPSDevSlnSysName(pSDevSlnSys.getPSDevSlnSysName());
        pSDCWorkspaceService.installSys(pSDCWorkspace);
    }

    protected void doSubSysAPIImport(PSUAWizard2 pSUAWizard2) throws Exception {
        PSSubSysServiceAPIService pSSubSysServiceAPIService = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        PSSubSysServiceAPI pSSubSysServiceAPI = new PSSubSysServiceAPI();
        pSSubSysServiceAPI.setPSSubSysServiceAPIId(pSUAWizard2.getParam5());
        pSSubSysServiceAPI.set("IMPORTSCHEMA", pSUAWizard2.getWizardParam());
        pSSubSysServiceAPIService.importSchema(pSSubSysServiceAPI);
    }
}
