/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.XML.XMLNode
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.config.entity.PSSF
 *  net.ibizsys.pscore.srv.config.entity.PSWorkspaceType
 *  net.ibizsys.pscore.srv.config.service.PSDBTypeService
 *  net.ibizsys.pscore.srv.config.service.PSSFService
 *  net.ibizsys.pscore.srv.config.service.PSWorkspaceTypeService
 *  net.ibizsys.pscore.srv.core.IPSDEFieldModel
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSGitUser
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer
 *  net.ibizsys.pscore.srv.paasmgr.service.PSDBServerService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSGitUserService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSSVNServerService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.Util.PSSysModelInstHelper;
import SA.SRFDA.PS.Data.PSSysModelInst;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.XML.XMLNode;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSWorkspaceType;
import net.ibizsys.pscore.srv.config.service.PSDBTypeService;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSWorkspaceTypeService;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSGitUser;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSGitUserService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSVNServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSModelSchemeHelper {
    private static final Log log = LogFactory.getLog(PSModelSchemeHelper.class);
    private static Map<String, String> deNameMap = new HashMap<String, String>();
    private String strDBName = null;
    private ISystemModel iSystemModel = null;
    private PSSysModelInst psSysModelInst = null;

    static {
        deNameMap.put("DE1545", "PSDEUTILTYPE");
        deNameMap.put("DE1547", "PSAPPUTILTYPE");
        deNameMap.put("DE1696", "PSRAWITEMTYPE");
        deNameMap.put("DE1697", "PSBUTTONTYPE");
        deNameMap.put("DE1506", "PSDEACTIONTYPE");
        deNameMap.put("DE1645", "PSSAHANDLER");
        deNameMap.put("DE1510", "PSDERTYPE");
        deNameMap.put("DE1646", "PSSFSAHANDLER");
        deNameMap.put("DE1492", "PSSYSUTILTYPE");
        deNameMap.put("DE1222", "PSWFENGINETYPE");
        deNameMap.put("DE1224", "PSSEARCHENGINETYPE");
        deNameMap.put("DE1600", "PSVIEWTYPE");
        deNameMap.put("DE1501", "PSDBTYPE");
        deNameMap.put("DE1920", "PSSYSDEVBTTYPE");
        deNameMap.put("DE1523", "PSDEFVRTYPE");
        deNameMap.put("DE1623", "PSPORTLETTYPE");
        deNameMap.put("DE1607", "PSFORMDETAILTYPE");
        deNameMap.put("DE1605", "PSEDITORTYPE");
        deNameMap.put("DE1882", "PSWFLINKCONDTYPE");
        deNameMap.put("DE1815", "PSPFPLUGINTYPE");
        deNameMap.put("DE1503", "PSPF");
        deNameMap.put("DE1515", "PSSFCODETYPE");
        deNameMap.put("DE1896", "PSSYSMODELVER");
        deNameMap.put("DE1950", "PSSUBSYS");
        deNameMap.put("DE1601", "PSCTRLTYPE");
        deNameMap.put("DE1521", "PSDELNTYPE");
        deNameMap.put("DE1522", "PSDELLTYPE");
        deNameMap.put("DE1818", "PSCOUNTERTYPE");
        deNameMap.put("DE1819", "PSCOUNTER");
        deNameMap.put("DE1617", "PSTREENODETYPE");
        deNameMap.put("DE1649", "PSSYSACHANDLER");
        deNameMap.put("DE1537", "PSPDTVIEW");
        deNameMap.put("DE1502", "PSSF");
        deNameMap.put("DE1513", "PSSFSTYLE");
        deNameMap.put("DE1520", "PSDEFDATATYPE");
        deNameMap.put("DE1650", "PSSFACHANDLER");
        deNameMap.put("DE1822", "PSBACKSERVICE");
        deNameMap.put("DE1537", "PSPDTVIEW");
        deNameMap.put("DE1881", "PSWFLINKTYPE");
        deNameMap.put("DE1880", "PSWFPROCESSTYPE");
        deNameMap.put("DE1652", "PSSFPKG");
        deNameMap.put("DE1651", "PSSFPKGCAT");
        deNameMap.put("DE1653", "PSSFPKGVER");
        deNameMap.put("DE1629", "PSDATASYNCAGENTTYPE");
        deNameMap.put("DE1509", "PSVARTYPE");
        deNameMap.put("DE1511", "PSDEJOINTYPE");
        deNameMap.put("DE1970", "PSSYSISSUETYPE");
        deNameMap.put("DE1971", "PSSYSISSUEENGINE");
        deNameMap.put("DE1490", "PSAPPTYPE");
        deNameMap.put("DE1956", "PSSUBSYSVER");
        deNameMap.put("DE1505", "PSDEFTYPE");
        deNameMap.put("DE1602", "PSVTCATDETAIL");
        deNameMap.put("DE1599", "PSVIEWTYPECAT");
        deNameMap.put("DE1590", "PSMODELINIT");
        deNameMap.put("DE1618", "PSEDITORSTYLE");
        deNameMap.put("DE1540", "PSDBVALUEOP");
        deNameMap.put("DE1614", "PSVIEWLOGICTYPE");
        deNameMap.put("DE1539", "PSPDTAPPFUNC");
        deNameMap.put("DE1514", "PSSFCODEFOLDER");
        deNameMap.put("DE1604", "PSDEGCTYPE");
        deNameMap.put("DE1609", "PSDRITEMTYPE");
        deNameMap.put("DE1598", "PSVIEWENGINE");
        deNameMap.put("DE1425", "PSROBOTWORK");
        deNameMap.put("DE1434", "PSROBOTABILITY");
        deNameMap.put("DE1925", "PSDCBKTYPE");
        deNameMap.put("DE1680", "PSHELPSECTIONTYPE");
        deNameMap.put("DE1681", "PSHELPARTICLETYPE");
        deNameMap.put("DE1685", "PSHELPPRJTYPE");
        deNameMap.put("DE1684", "PSHELPARTSEC");
        deNameMap.put("DE1682", "PSHELPARTICLETEMPL");
        deNameMap.put("DE1686", "PSHELPPRJTEMPL");
        deNameMap.put("DE1683", "PSHELPSECTIONTEMPL");
        deNameMap.put("DE1532", "PSLANGUAGE");
        deNameMap.put("DE1533", "PSSYSLANRES");
        deNameMap.put("DE1508", "PSSYSUIACTION");
        deNameMap.put("DE1534", "PSSYSLANITEM");
        deNameMap.put("DE1430", "PSROBOTTYPE");
        deNameMap.put("DE1431", "PSROBOTWORKTYPE");
        deNameMap.put("DE1648", "PSCTRLMSGTAG");
        deNameMap.put("DE1450", "PSBOOKINGRESTYPE");
        deNameMap.put("DE1512", "PSASTYPE");
        deNameMap.put("DE1541", "PSDBVALUEFUNC");
        deNameMap.put("DE1544", "PSDEVSERVERTYPE");
        deNameMap.put("DE1701", "PSPILOGICTYPE");
        deNameMap.put("DE1608", "PSFDLOGICTYPE");
        deNameMap.put("DE1560", "PSPANELLLCONDTYPE");
        deNameMap.put("DE1525", "PSDELLCONDTYPE");
        deNameMap.put("DE1561", "PSPANELLNTYPE");
        deNameMap.put("DE1562", "PSPANELLLTYPE");
        deNameMap.put("DE1619", "PSPANELDETAILTYPE");
        deNameMap.put("DE1620", "PSSYSTOOLBAR");
        deNameMap.put("DE1531", "PSIMAGETEMPL");
        deNameMap.put("DE1660", "PSSFPLUGIN");
        deNameMap.put("DE1661", "PSSFPLUGINTEMPL");
        deNameMap.put("DE1816", "PSPFPLUGIN");
        deNameMap.put("DE1817", "PSPFPLUGINTEMPL");
        deNameMap.put("DE1606", "PSTBITEMTYPE");
        deNameMap.put("DE1809", "PSCODESNIPPETTYPE");
        deNameMap.put("DE1871", "PSMAVENSERVERTYPE");
        deNameMap.put("DE1610", "PSAMITEMTYPE");
        deNameMap.put("DE1591", "PSMIDETAIL");
        deNameMap.put("DE1502", "PSSF");
        deNameMap.put("DE1503", "PSPF");
        deNameMap.put("DE1513", "PSSFSTYLE");
        deNameMap.put("DE1514", "PSSFCODEFOLDER");
        deNameMap.put("DE1515", "PSSFCODETYPE");
        deNameMap.put("DE1516", "PSSFCODETEMPL");
        deNameMap.put("DE1546", "PSSFPF");
        deNameMap.put("DE1550", "PSSFSTYLEVER");
        deNameMap.put("DE1551", "PSSFVERCODE");
        deNameMap.put("DE1552", "PSSFVERCODEITEM");
        deNameMap.put("DE1553", "PSSFSTYLECODE");
        deNameMap.put("DE1580", "PSPFRESOURCE");
        deNameMap.put("DE1592", "PSPFCODEFOLDER");
        deNameMap.put("DE1595", "PSPFSTYLE");
        deNameMap.put("DE1596", "PSPFPUBCODE");
        deNameMap.put("DE1597", "PSPFSTYLEPRJ");
        deNameMap.put("DE1631", "PSPFCTRLTYPE");
        deNameMap.put("DE1632", "PSPFVIEWTYPE");
        deNameMap.put("DE1633", "PSPFEDITORTYPE");
        deNameMap.put("DE1634", "PSPFPUBOBJ");
        deNameMap.put("DE1635", "PSPFPUBOBJPARAM");
        deNameMap.put("DE1636", "PSSFPUBOBJ");
        deNameMap.put("DE1637", "PSSFPUBOBJPARAM");
        deNameMap.put("DE1638", "PSPFPREVIEWNODE");
        deNameMap.put("DE1640", "PSSFCTRLTYPE");
        deNameMap.put("DE1641", "PSSFVIEWTYPE");
        deNameMap.put("DE1646", "PSSFSAHANDLER");
        deNameMap.put("DE1650", "PSSFACHANDLER");
        deNameMap.put("DE1651", "PSSFPKGCAT");
        deNameMap.put("DE1652", "PSSFPKG");
        deNameMap.put("DE1653", "PSSFPKGVER");
        deNameMap.put("DE1654", "PSSFSTYLEPKG");
        deNameMap.put("DE1655", "PSSFSTYLEPRJ");
        deNameMap.put("DE1656", "PSSFSTYLELOG");
        deNameMap.put("DE1657", "PSPFSTYLELOG");
        deNameMap.put("DE1658", "PSSFEXCEPTION");
        deNameMap.put("DE1659", "PSSFCONFIG");
        deNameMap.put("DE1660", "PSSFPLUGIN");
        deNameMap.put("DE1661", "PSSFPLUGINTEMPL");
        deNameMap.put("DE1662", "PSSFSTYLEPARAM");
        deNameMap.put("DE1663", "PSSFSTYLEREF");
        deNameMap.put("DE1671", "PSPFPKGCAT");
        deNameMap.put("DE1672", "PSPFPKG");
        deNameMap.put("DE1673", "PSPFPKGVER");
        deNameMap.put("DE1674", "PSPFSTYLEPKG");
        deNameMap.put("DE1675", "PSPFCDN");
        deNameMap.put("DE1676", "PSPFPKGVERCDN");
        deNameMap.put("DE1677", "PSPFSTYLEREF");
        deNameMap.put("DE1800", "PSPFSTYLECODE");
        deNameMap.put("DE1801", "PSPFVIEWTEMPL");
        deNameMap.put("DE1802", "PSPFCTRLTEMPL");
        deNameMap.put("DE1803", "PSPFCTDETAIL");
        deNameMap.put("DE1804", "PSPFEDITORTEMPL");
        deNameMap.put("DE1805", "PSPFUATEMPL");
        deNameMap.put("DE1806", "PSPFVLTEMPL");
        deNameMap.put("DE1808", "PSPFAPPTEMPL");
        deNameMap.put("DE1810", "PSPFQUICKTEMPL");
        deNameMap.put("DE1815", "PSPFPLUGINTYPE");
        deNameMap.put("DE1816", "PSPFPLUGIN");
        deNameMap.put("DE1817", "PSPFPLUGINTEMPL");
        deNameMap.put("DE4200", "PSPFPREVIEWACTION");
        deNameMap.put("DE4201", "PSSFPREVIEWACTION");
        deNameMap.put("DE1530", "PSCODELISTTEMPL");
        deNameMap.put("DE1621", "PSSYSTBITEM");
        deNameMap.put("DE1611", "PSVTRV");
        deNameMap.put("DE1612", "PSVTCTRL");
        deNameMap.put("DE1691", "PSUIENGINETYPE");
        deNameMap.put("DE1692", "PSUIENGINETYPEPARAM");
        deNameMap.put("DE1985", "PSSTUDIOPLUGIN");
        deNameMap.put("DE4073", "PSSYSRTDEFINPUTTIP");
    }

    public void init(ISystemModel iSystemModel, PSSysModelInst psSysModelInst) {
        this.psSysModelInst = psSysModelInst;
        this.strDBName = this.psSysModelInst.getDBNAME();
        this.iSystemModel = iSystemModel;
    }

    protected String getDBName() {
        return this.strDBName;
    }

    protected ISystemModel getSystemModel() {
        return this.iSystemModel;
    }

    protected PSSysModelInst getPSSysModelInst() {
        return this.psSysModelInst;
    }

    public void initCloudMode(final String strMode, final String strDataFolder) throws Exception {
        ServiceWorkHelper.getInstance().execute(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSModelSchemeHelper.this.onInitCloudMode(strMode, strDataFolder);
            }
        });
    }

    protected void onInitCloudMode(String strMode, String strDataFolder) throws Exception {
        String strLastTag;
        String strDefaultId = "LITE_DEFAULT_DOMAIN";
        boolean bInitDC = false;
        PSWorkspaceTypeService psWorkspaceTypeService = (PSWorkspaceTypeService)ServiceGlobal.getService(PSWorkspaceTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSWorkspaceType psWorkspaceType = new PSWorkspaceType();
        psWorkspaceType.setPSWorkspaceTypeId("CLOUD");
        if (!psWorkspaceTypeService.get((IEntity)psWorkspaceType, true)) {
            psWorkspaceType.setPSWorkspaceTypeName("Cloud\u751f\u4ea7\u7ebf");
            psWorkspaceType.setWorkspaceUsage("CLOUD");
            psWorkspaceType.setWorkspaceMode("B");
            psWorkspaceTypeService.create((IEntity)psWorkspaceType);
        }
        PSSvrDomainService psSvrDomainService = (PSSvrDomainService)ServiceGlobal.getService(PSSvrDomainService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSSvrDomain psSvrDomain = new PSSvrDomain();
        psSvrDomain.setPSSvrDomainId(strDefaultId);
        if (!psSvrDomainService.get((IEntity)psSvrDomain, true)) {
            psSvrDomain.setPSSvrDomainName("\u9ed8\u8ba4\u670d\u52a1\u57df");
            psSvrDomain.setDomainCode("LITE");
            psSvrDomainService.create((IEntity)psSvrDomain);
        }
        PSSFService psSFService = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSSF psSF = new PSSF();
        psSF.setPSSFId("J2EE6");
        if (!psSFService.get((IEntity)psSF, true)) {
            psSF.setPSSFName("J2EE\u6846\u67b6");
            psSF.setPkgLowerCase(Integer.valueOf(1));
            psSF.setCodeFlag(Integer.valueOf(1));
            psSF.setDocFlag(Integer.valueOf(0));
            psSF.setModelFlag(Integer.valueOf(0));
            psSF.setValidFlag(Integer.valueOf(1));
            psSFService.create((IEntity)psSF);
        }
        PSTaskServerService psTaskServerService = (PSTaskServerService)ServiceGlobal.getService(PSTaskServerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSTaskServer psTaskServer = new PSTaskServer();
        String strDefaultTaskServerId = String.valueOf(strDefaultId) + "_TASK01";
        psTaskServer.setPSTaskServerId(strDefaultTaskServerId);
        if (!psTaskServerService.get((IEntity)psTaskServer, true)) {
            psTaskServer.setPSTaskServerName("\u9ed8\u8ba4\u670d\u52a1\u5668");
            psTaskServer.setPSSvrDomainId(psSvrDomain.getPSSvrDomainId());
            psTaskServer.setServerUrl("http://modelserver.ibizcloud.cn:38080");
            psTaskServerService.create((IEntity)psTaskServer);
        }
        if (bInitDC) {
            PSDBServerService psDBServerService = (PSDBServerService)ServiceGlobal.getService(PSDBServerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDBServer psDBServer = new PSDBServer();
            psDBServer.setPSDBServerId(strDefaultId);
            if (!psDBServerService.get((IEntity)psDBServer, true)) {
                psDBServer.setPSDBServerName("\u6570\u636e\u5e93\u670d\u52a1\u5668");
                psDBServer.setPSSvrDomainId(psSvrDomain.getPSSvrDomainId());
                psDBServer.setDBType("MYSQL5");
                psDBServer.setDBRoot("/");
                psDBServer.setDBUserName(this.getPSSysModelInst().getUSERNAME());
                psDBServer.setDBPasswd(this.getPSSysModelInst().getPASSWD());
                psDBServer.setDBUrl("jdbc:mysql://mysql.ibizcloud.cn:3306/%1$s?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&useOldAliasMetadataBehavior=true");
                psDBServer.setIPAddr("mysql.ibizcloud.cn");
                psDBServer.setUserName("root");
                psDBServer.setPasswd("12345678");
                psDBServerService.create((IEntity)psDBServer);
            }
            PSSVNServerService psSVNServerService = (PSSVNServerService)ServiceGlobal.getService(PSSVNServerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSSVNServer psSVNServer = new PSSVNServer();
            psSVNServer.setPSSVNServerId(strDefaultId);
            if (!psSVNServerService.get((IEntity)psSVNServer, true)) {
                psSVNServer.setPSSVNServerName("\u7248\u672c\u670d\u52a1\u5668");
                psSVNServer.setPSSvrDomainId(psSvrDomain.getPSSvrDomainId());
                psSVNServer.setSVNType("GIT");
                psSVNServer.setIpAddr("gitlab.ibizcloud.cn");
                psSVNServer.setSVNUrl("#");
                psSVNServer.setUserName("root");
                psSVNServer.setPasswd("12345678");
                psSVNServer.setSVNRoot("/");
                psSVNServer.setGitPath("http://gitlab.ibizcloud.cn");
                psSVNServerService.create((IEntity)psSVNServer);
            }
            PSGitUserService psGitUserService = (PSGitUserService)ServiceGlobal.getService(PSGitUserService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSGitUser psGitUser = new PSGitUser();
            psGitUser.setPSGitUserId(strDefaultId);
            if (!psGitUserService.get((IEntity)psGitUser, true)) {
                psGitUser.setPSGitUserName("\u7248\u672c\u670d\u52a1\u5668\u8bbf\u95ee\u7528\u6237");
                psGitUser.setPSSvrDomainId(psSvrDomain.getPSSvrDomainId());
                psGitUser.setPSSVNServerId(psSVNServer.getPSSVNServerId());
                psGitUser.setDefaultFlag(Integer.valueOf(1));
                psGitUser.setUserName("root");
                psGitUser.setPasswd("12345678");
                psGitUser.setGitPath("IBIZ");
                psGitUserService.create((IEntity)psGitUser);
            }
            PSDevCenterService psDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevCenter psDevCenter = new PSDevCenter();
            psDevCenter.setPSDevCenterId(strDefaultId);
            if (!psDevCenterService.get((IEntity)psDevCenter, true)) {
                psDevCenter.setPSDevCenterName("\u9ed8\u8ba4\u5f00\u653e\u4e2d\u5fc3");
                psDevCenter.setPSSvrDomainId(psSvrDomain.getPSSvrDomainId());
                psDevCenter.setDCType("DEVCENTER");
                psDevCenter.setDCLevel(Integer.valueOf(10));
                psDevCenter.setDomainName("lite");
                psDevCenter.setFullDomainName("lite.ibizcloud.cn");
                psDevCenter.setEnableWorkspace(Integer.valueOf(1));
                psDevCenterService.create((IEntity)psDevCenter);
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strDataFolder) && !StringHelper.IsNullOrEmpty((String)(strLastTag = this.onInitData(strDataFolder, psSvrDomain.getDomainParam3())))) {
            psSvrDomain.reset();
            psSvrDomain.setPSSvrDomainId(strDefaultId);
            psSvrDomain.setDomainParam3(strLastTag);
            psSvrDomainService.update((IEntity)psSvrDomain, false);
        }
    }

    protected String onInitData(String strDataFolder, String strLastTag) throws Exception {
        TreeMap<String, File> folderMap = new TreeMap<String, File>();
        File folder = new File(strDataFolder);
        File[] files = folder.listFiles();
        if (files != null) {
            File[] fileArray = files;
            int n = files.length;
            int n2 = 0;
            while (n2 < n) {
                File file = fileArray[n2];
                if (file.isDirectory()) {
                    if (!StringHelper.IsNullOrEmpty((String)strLastTag)) {
                        if (StringHelper.Compare((String)strLastTag, (String)file.getName(), (boolean)true) < 0) {
                            folderMap.put(file.getName(), file);
                        }
                    } else {
                        folderMap.put(file.getName(), file);
                    }
                }
                ++n2;
            }
        }
        String strLast = "";
        for (Map.Entry entry : folderMap.entrySet()) {
            strLast = (String)entry.getKey();
            this.onInitDataFolder((File)entry.getValue());
        }
        return strLast;
    }

    protected void onInitDataFolder(File folder) throws Exception {
        log.debug((Object)String.format("\u521d\u59cb\u5316\u5b89\u88c5\u6570\u636e\u76ee\u5f55[%1$s]", folder.getName()));
        File[] files = folder.listFiles();
        if (files != null) {
            File[] fileArray = files;
            int n = files.length;
            int n2 = 0;
            while (n2 < n) {
                File file = fileArray[n2];
                if (file.isFile() && file.getName().indexOf(".srfbak") != -1) {
                    this.onInitDataFile(file);
                }
                ++n2;
            }
        }
    }

    protected void onInitDataFile(File file) throws Exception {
        log.debug((Object)String.format("\u521d\u59cb\u5316\u5b89\u88c5\u6570\u636e\u6587\u4ef6[%1$s]", file.getName()));
        XMLNode rootNode = XMLNode.Load((String)file.getCanonicalPath());
        if (rootNode == null) {
            throw new Exception(String.format("\u6570\u636e\u6587\u4ef6[%1$s]\u65e0\u6548", file.getAbsolutePath()));
        }
        if (rootNode.getChildNodes() != null) {
            for (XMLNode xmlNode : rootNode.getChildNodes()) {
                String strValue;
                String strDEId = xmlNode.GetExtValue("SRFDEID", "");
                if (StringHelper.IsNullOrEmpty((String)strDEId) || StringHelper.IsNullOrEmpty((String)(strValue = xmlNode.GetExtValue("SRFVALUE", "")))) continue;
                String strDEName = deNameMap.get(strDEId);
                if (StringHelper.IsNullOrEmpty((String)strDEName)) {
                    log.warn((Object)String.format("\u5b9e\u4f53\u7f16\u53f7[%1$s]\u672a\u6307\u5b9a\u5bf9\u5e94\u7684\u5b9e\u4f53\u5bf9\u8c61\uff0c\u5ffd\u7565\u5bfc\u5165", strDEId));
                    continue;
                }
                IDataEntityModel iDEModel = DEModelGlobal.getDEModel((String)strDEName);
                BaseDataEntity importDataEntity = BaseDataEntity.FromString((String)strValue);
                HashMap data = new HashMap();
                importDataEntity.FillMap(data);
                IEntity iEntity = iDEModel.createEntity();
                for (Map.Entry entry : data.entrySet()) {
                    Object objValue = entry.getValue();
                    if (objValue != null) {
                        if (objValue instanceof String && StringHelper.IsNullOrEmpty((String)((String)objValue))) {
                            iEntity.set((String)entry.getKey(), null);
                            continue;
                        }
                        iEntity.set((String)entry.getKey(), objValue);
                        continue;
                    }
                    iEntity.set((String)entry.getKey(), null);
                }
                iEntity.remove("PSDEVCENTERID");
                iEntity.remove("PSDCID");
                iEntity.remove("PSDEVCENTERNAME");
                iEntity.remove("PSDCNAME");
                IService iService = iDEModel.getService(PSCoreSysServiceBase.getCurMajorSessionFactory());
                iService.save(iEntity, false);
            }
        }
    }

    public void syncDEModels(String strSqlFolder) throws Exception {
        Iterator deModels;
        List<IEntity> columnList;
        boolean bSyncView = false;
        long nTime = System.currentTimeMillis();
        HashMap<String, String> tableMap = new HashMap<String, String>();
        HashMap<String, String> columnMap = new HashMap<String, String>();
        List<IEntity> tableList = this.getTables();
        if (tableList != null) {
            for (IEntity iEntity : tableList) {
                tableMap.put(DataObject.getStringValue((Object)iEntity.get("TABLE_NAME")).toUpperCase(), "");
            }
        }
        if ((columnList = this.getTableColumns()) != null) {
            for (IEntity iEntity : columnList) {
                String strTag = String.format("%1$s|%2$s", iEntity.get("TABLE_NAME"), iEntity.get("COLUMN_NAME")).toUpperCase();
                columnMap.put(strTag, "");
            }
        }
        if ((deModels = this.getSystemModel().getDataEntityModels()) != null) {
            while (deModels.hasNext()) {
                IDataEntityModel iDataEntityModel = (IDataEntityModel)deModels.next();
                if (StringHelper.IsNullOrEmpty((String)iDataEntityModel.getTableName())) continue;
                if (tableMap.containsKey(iDataEntityModel.getTableName().toUpperCase())) {
                    if (!this.syncDEModel(iDataEntityModel, columnMap)) continue;
                    bSyncView = true;
                    continue;
                }
                if (this.syncDEModel(iDataEntityModel, null)) {
                    bSyncView = true;
                }
                tableMap.put(iDataEntityModel.getTableName().toUpperCase(), "");
            }
        }
        if (bSyncView && !StringHelper.IsNullOrEmpty((String)strSqlFolder)) {
            this.syncSqlFolder(new File(strSqlFolder));
        }
        nTime = System.currentTimeMillis() - nTime;
        log.debug((Object)String.format("\u540c\u6b65\u6570\u636e\u6a21\u578b\u8017\u65f6[%1$s]ms", nTime));
    }

    protected boolean syncDEModel(IDataEntityModel iDataEntityModel, Map<String, String> columnMap) throws Exception {
        boolean bChanged = false;
        String strTableName = iDataEntityModel.getTableName();
        if (columnMap == null) {
            log.warn((Object)String.format("\u5b9e\u4f53[%1$s]\u6570\u636e\u8868[%2$s]\u4e0d\u5b58\u5728\uff0c\u6267\u884c\u5efa\u7acb\u64cd\u4f5c", iDataEntityModel.getName(), strTableName));
            ArrayList<String> sqlList = new ArrayList<String>();
            this.fillCreateTableSqls(iDataEntityModel, false, sqlList);
            for (String strSql : sqlList) {
                try {
                    this.executeRaw(strSql);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
            }
            bChanged = true;
        } else {
            Iterator psDEFields = iDataEntityModel.getDEFields();
            while (psDEFields.hasNext()) {
                IPSDEFieldModel iPSDEField = (IPSDEFieldModel)psDEFields.next();
                if (!iPSDEField.isPhisicalDEField()) continue;
                String strTag = String.format("%1$s|%2$s", strTableName, iPSDEField.getName()).toUpperCase();
                if (columnMap.containsKey(strTag)) continue;
                log.warn((Object)String.format("\u5b9e\u4f53[%1$s]\u6570\u636e\u8868[%2$s]\u5217[%3$s]\u4e0d\u5b58\u5728\uff0c\u6267\u884c\u5efa\u7acb\u64cd\u4f5c", iDataEntityModel.getName(), strTableName, iPSDEField.getName()));
                ArrayList<String> sqlList = new ArrayList<String>();
                this.fillCreateTableColumnSqls(iDataEntityModel, strTableName, iPSDEField, false, sqlList);
                for (String strSql : sqlList) {
                    try {
                        this.executeRaw(strSql);
                    }
                    catch (Exception ex) {
                        log.error((Object)ex);
                    }
                }
                columnMap.put(strTag, "");
                bChanged = true;
            }
        }
        return bChanged;
    }

    protected void syncSqlFolder(File folder) throws Exception {
        File[] files = folder.listFiles();
        if (files != null) {
            File[] fileArray = files;
            int n = files.length;
            int n2 = 0;
            while (n2 < n) {
                File file = fileArray[n2];
                if (file.isFile() && file.getName().indexOf(".sql") != -1) {
                    this.syncSqlFile(file);
                }
                ++n2;
            }
        }
    }

    protected void syncSqlFile(File file) throws Exception {
        String[] sqls;
        String strSQL = PSSysModelInstHelper.readFile(file.getCanonicalPath());
        if (StringHelper.IsNullOrEmpty((String)strSQL)) {
            return;
        }
        String[] stringArray = sqls = strSQL.split("[;]");
        int n = sqls.length;
        int n2 = 0;
        while (n2 < n) {
            String sql = stringArray[n2];
            if (!StringHelper.IsNullOrEmpty((String)sql) && !StringHelper.IsNullOrEmpty((String)(sql = sql.trim())) && sql.toUpperCase().indexOf("_TMP") == -1) {
                try {
                    this.executeRaw(sql);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
            }
            ++n2;
        }
    }

    protected boolean isTableExists(String strTableName, boolean bTempMode) throws Exception {
        String strSQL;
        IEntity iEntity;
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        return (iEntity = this.selectSingle(strSQL = StringHelper.Format((String)"select TABLE_NAME from INFORMATION_SCHEMA.TABLES where UPPER(TABLE_SCHEMA)='%1$s' and UPPER(TABLE_NAME)='%2$s'", (Object)this.getDBName().toUpperCase(), (Object)strTableName.toUpperCase()), true)) != null;
    }

    protected void fillCreateTableSqls(IDataEntityModel iDataEntityModel, boolean bTempMode, List<String> sqlList) throws Exception {
        boolean bFirst = true;
        StringBuilderEx sb = new StringBuilderEx();
        String strTableName = iDataEntityModel.getTableName();
        String strKeyColumnName = "";
        String strRealTableName = strTableName;
        String strTempTag = "_TMP";
        if (bTempMode) {
            strRealTableName = String.valueOf(strRealTableName) + strTempTag;
        }
        boolean bPubComment = false;
        sb.Append("CREATE TABLE %1$s(", (Object)this.getDBObjStandardName(strRealTableName));
        Iterator psDEFields = iDataEntityModel.getDEFields();
        while (psDEFields.hasNext()) {
            IPSDEFieldModel iPSDEField = (IPSDEFieldModel)psDEFields.next();
            if (!iPSDEField.isPhisicalDEField() || bTempMode && !iPSDEField.isEnableTempData()) continue;
            if (bFirst) {
                bFirst = false;
                sb.Append("\n");
            } else {
                sb.Append("\n,");
            }
            if (iPSDEField.isKeyDEField()) {
                strKeyColumnName = iPSDEField.getName();
                sb.Append("`%1$s` %2$s", (Object)iPSDEField.getName(), (Object)this.getDBDataType(iPSDEField, true, false, false, null));
                sb.Append("PRIMARY KEY ");
                if (bPubComment) {
                    sb.Append("COMMENT '%1$s' ", (Object)iPSDEField.getLogicName());
                }
                if (!bTempMode) continue;
                sb.Append("\n,");
                sb.Append("`SRFORIKEY` %1$s", (Object)this.getDBDataType(iPSDEField, false, true, false, null));
                sb.Append("\n,");
                sb.Append("`SRFDRAFTFLAG` INT ");
                continue;
            }
            sb.Append("`%1$s` %2$s", (Object)iPSDEField.getName(), (Object)this.getDBDataType(iPSDEField, false, true, false, null));
            if (!bPubComment) continue;
            sb.Append("COMMENT '%1$s' ", (Object)iPSDEField.getLogicName());
        }
        sb.Append("\n)");
        sb.Append(";");
        sqlList.add(sb.toString());
    }

    protected void fillCreateTableColumnSqls(IDataEntityModel iDataEntityModel, String strTableName, IPSDEFieldModel iDEFieldModel, boolean bTempMode, List<String> sqlList) throws Exception {
        String strDataType = this.getDBDataType(iDEFieldModel, false, true, false, "");
        if (StringHelper.IsNullOrEmpty((String)strDataType)) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u6570\u636e\u5e93\u7c7b\u578b\u5931\u8d25", (Object)iDEFieldModel.getName()));
        }
        StringBuilderEx sb = new StringBuilderEx();
        if (bTempMode) {
            String strTempTag = "_TMP";
            sb.Append("ALTER TABLE %1$s\n", (Object)this.getDBObjStandardName(String.valueOf(strTableName) + strTempTag));
        } else {
            sb.Append("ALTER TABLE %1$s\n", (Object)this.getDBObjStandardName(strTableName));
        }
        sb.Append("ADD COLUMN %1$s %2$s", (Object)this.getDBObjStandardName(iDEFieldModel.getName()), (Object)strDataType);
        sb.Append("\n");
        sqlList.add(sb.toString());
    }

    protected boolean isTableColumnExists(IPSDEFieldModel iDEFieldModel, boolean bTempMode) throws Exception {
        String strSQL;
        String strTableName = iDEFieldModel.getDataEntity().getTableName().toUpperCase();
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        return this.selectSingle(strSQL = StringHelper.Format((String)"select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where UPPER(TABLE_SCHEMA)='%1$s' and UPPER(TABLE_NAME)='%2$s'  and UPPER(COLUMN_NAME)='%3$s'", (Object)this.getDBName().toUpperCase(), (Object)strTableName, (Object)iDEFieldModel.getName().toUpperCase()), true) != null;
    }

    protected List<IEntity> getTableColumns() throws Exception {
        String strSQL = StringHelper.Format((String)"select TABLE_NAME, COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where UPPER(TABLE_SCHEMA)='%1$s'", (Object)this.getDBName().toUpperCase());
        return this.selectMulti(strSQL);
    }

    protected List<IEntity> getTables() throws Exception {
        String strSQL = StringHelper.Format((String)"select TABLE_NAME from INFORMATION_SCHEMA.TABLES where UPPER(TABLE_SCHEMA)='%1$s' ", (Object)this.getDBName().toUpperCase());
        return this.selectMulti(strSQL);
    }

    protected String getDBDataType(IPSDEFieldModel iDEFieldModel, boolean bAppendNullFlag, boolean bAllowNull, boolean bAppendDefault, String strDefault) throws Exception {
        int nStdDataType = iDEFieldModel.getStdDataType();
        iDEFieldModel.getDEFDTColumn("MYSQL5");
        switch (nStdDataType) {
            case 25: {
                int nLength = iDEFieldModel.getLength();
                if (nLength <= 0) {
                    nLength = 200;
                }
                if (nLength >= 4000) {
                    nLength = 4000;
                }
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" VARCHAR(%1$s) ", (Object)nLength);
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 21: {
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" MEDIUMTEXT ");
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 9: {
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" INTEGER ");
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 1: {
                int nLength = 20;
                if (nLength <= 0) {
                    nLength = 20;
                }
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" BIGINT(%1$s) ", (Object)nLength);
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 7: {
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DOUBLE ");
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 5: {
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DATETIME ");
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 27: {
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DATE ");
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 28: {
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DATETIME ");
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 6: 
            case 29: {
                int nPRECISION;
                int nLength = 20;
                if (nLength <= 0) {
                    nLength = 12;
                }
                if ((nPRECISION = 2) <= 0) {
                    nPRECISION = 0;
                }
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" DECIMAL(%1$s,%2$s) ", (Object)nLength, (Object)nPRECISION);
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
            case 24: {
                String strDBType = "";
                strDBType = String.valueOf(strDBType) + StringHelper.Format((String)" MEDIUMBLOB ");
                if (bAppendNullFlag) {
                    strDBType = bAllowNull ? String.valueOf(strDBType) + StringHelper.Format((String)" NULL ") : String.valueOf(strDBType) + StringHelper.Format((String)" NOT NULL ");
                }
                return strDBType;
            }
        }
        throw new Exception(String.format("\u5c5e\u6027[%1$s]\u7c7b\u578b[%2$s]\u4e0d\u652f\u6301", iDEFieldModel.getName(), iDEFieldModel.getStdDataType()));
    }

    public String getDBObjStandardName(String strOriginName) {
        String[] items = strOriginName.split("[.]");
        if (items.length == 1) {
            return StringHelper.Format((String)"`%1$s`", (Object)strOriginName);
        }
        net.ibizsys.paas.util.StringBuilderEx sb = new net.ibizsys.paas.util.StringBuilderEx();
        int i = 0;
        while (i < items.length) {
            if (i != 0) {
                sb.append(".");
            }
            sb.append("`%1$s`", (Object)items[i]);
            ++i;
        }
        return sb.toString();
    }

    protected IEntity selectSingle(String strSQL, boolean bTryMode) throws Exception {
        PSDBTypeService psDBTypeService = (PSDBTypeService)ServiceGlobal.getService(PSDBTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        ArrayList list = psDBTypeService.selectRaw(strSQL, null);
        if (list != null && list.size() == 1) {
            return (IEntity)list.get(0);
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e", new Object[0]));
    }

    protected List<IEntity> selectMulti(String strSQL) throws Exception {
        PSDBTypeService psDBTypeService = (PSDBTypeService)ServiceGlobal.getService(PSDBTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        ArrayList list = psDBTypeService.selectRaw(strSQL, null);
        return list;
    }

    protected void executeRaw(String strSql) throws Exception {
        PSDBTypeService psDBTypeService = (PSDBTypeService)ServiceGlobal.getService(PSDBTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psDBTypeService.executeRaw(strSql, null);
    }
}

