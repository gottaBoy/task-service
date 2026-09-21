/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.SerializationFeature
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.core.DEDataSetCond
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDataQueryCodeCond
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.IDataColumn
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.paas.web.util.SimpleWebContext
 *  net.ibizsys.pscore.srv.IPSCoreSysService
 *  net.ibizsys.pscore.srv.IPSModelV2Service
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.Version
 *  net.ibizsys.pscore.srv.core.IPSDEFieldModel
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.util.IPSSysDevUser
 *  net.ibizsys.pscore.srv.util.PSSysDevUserUserGlobal
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Web;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Web.RemoteCallResult;
import SA.SRFDA.PS.Web.SRFDAPSPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataColumn;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;
import net.ibizsys.pscore.srv.IPSCoreSysService;
import net.ibizsys.pscore.srv.IPSModelV2Service;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.Version;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.util.IPSSysDevUser;
import net.ibizsys.pscore.srv.util.PSSysDevUserUserGlobal;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class RemoteCallPage
extends SRFDAPSPage {
    private static final Log log = LogFactory.getLog(RemoteCallPage.class);
    public static final RemoteCallResult IGNORERESULT = new RemoteCallResult();
    public static final String ACTION_EXPORTMODELV2 = "EXPORTMODELV2";
    public static final String ACTION_IMPORTMODELV2 = "IMPORTMODELV2";
    public static ObjectMapper MAPPER = new ObjectMapper();
    static final String CONDTYPE_DEFIELD = "DEFIELD";
    static final String CONDTYPE_CUSTOM = "CUSTOM";
    static final String CONDTYPE_GROUP = "GROUP";
    static final String CONDTYPE_PREDEFINED = "PREDEFINED";
    static final String DEID_PSSYSDEVUSERUSERGLOBAL = "PSSYSDEVUSERUSERGLOBAL";
    static final String CALL_PSSYSDEVUSERUSERGLOBAL_GETPSSYSDEVUSERBYSLN = "GETPSSYSDEVUSERBYSLN";
    static final String CALL_PSSYSDEVUSERUSERGLOBAL_GETPSSYSDEVUSERBYSYS = "GETPSSYSDEVUSERBYSYS";
    static final String CALL_PSSYSDEVUSERUSERGLOBAL_GETPSSYSDEVUSERBYTEMPL = "GETPSSYSDEVUSERBYTEMPL";
    private static HashMap<String, String> deNameMap;
    private static HashMap<String, Integer> v5CallAccessCtrlMap;
    private static HashMap<String, String> dcIdMap;

    static {
        MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        MAPPER.setDateFormat((DateFormat)new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        deNameMap = new HashMap();
        v5CallAccessCtrlMap = new HashMap();
        dcIdMap = new HashMap();
        deNameMap.put("PSCODENAME", "DE1100");
        deNameMap.put("PSMODEL", "DE1115");
        deNameMap.put("PSMODELRS", "DE1116");
        deNameMap.put("PSMODELFIELD", "DE1117");
        deNameMap.put("PSMODELEXAMPLECAT", "DE1118");
        deNameMap.put("PSMODELAPI", "DE1120");
        deNameMap.put("PSMODELAPIINT", "DE1121");
        deNameMap.put("PSMODELAPIMETHOD", "DE1122");
        deNameMap.put("PSMODELPLUGIN", "DE1123");
        deNameMap.put("PSMODELMODULE", "DE1124");
        deNameMap.put("PSMODELSECTION", "DE1125");
        deNameMap.put("PSMODELEXAMPLE", "DE1126");
        deNameMap.put("PSMODELRESOURCE", "DE1127");
        deNameMap.put("PSMODELHOTCODE", "DE1128");
        deNameMap.put("PSMODELEXAMPLESTEP", "DE1129");
        deNameMap.put("PSSAMPLEVALUE", "DE1130");
        deNameMap.put("PSMODELVALUEGROUP", "DE1131");
        deNameMap.put("PSMODELFIELDVALUE", "DE1132");
        deNameMap.put("PSMODELUIACTION", "DE1133");
        deNameMap.put("PSMODELVIEW", "DE1134");
        deNameMap.put("PSMODELSUBVIEW", "DE1135");
        deNameMap.put("PSMODELSTATE", "DE1136");
        deNameMap.put("PSMODELERROR", "DE1137");
        deNameMap.put("PSMODELVIEWUIACTION", "DE1138");
        deNameMap.put("PSCOREPRDCAT", "DE1139");
        deNameMap.put("PSCOREPRD", "DE1140");
        deNameMap.put("PSCOREPRDVER", "DE1141");
        deNameMap.put("PSCOREPRDISSUE", "DE1146");
        deNameMap.put("PSCOREPRDFUNC", "DE1147");
        deNameMap.put("PSCPVISSUE", "DE1148");
        deNameMap.put("PSCPVFUNC", "DE1149");
        deNameMap.put("PSPRODUCTTYPE", "DE1200");
        deNameMap.put("PSUNIT", "DE1300");
        deNameMap.put("PSSYSPOLICY", "DE1400");
        deNameMap.put("PSSYSPOLICYMODEL", "DE1401");
        deNameMap.put("PSROBOTWORK", "DE1425");
        deNameMap.put("PSROBOTTYPE", "DE1430");
        deNameMap.put("PSROBOTWORKTYPE", "DE1431");
        deNameMap.put("PSROBOTABILITY", "DE1434");
        deNameMap.put("PSROBOTTYPEABILITY", "DE1440");
        deNameMap.put("PSBOOKINGRESTYPE", "DE1450");
        deNameMap.put("PSAPPTYPE", "DE1490");
        deNameMap.put("PSMQTYPE", "DE1491");
        deNameMap.put("PSDBTYPE", "DE1501");
        deNameMap.put("PSSF", "DE1502");
        deNameMap.put("PSPF", "DE1503");
        deNameMap.put("PSDBSYSPROCTYPE", "DE1504");
        deNameMap.put("PSDEFTYPE", "DE1505");
        deNameMap.put("PSDEACTIONTYPE", "DE1506");
        deNameMap.put("PSDEUIACTIONTYPE", "DE1507");
        deNameMap.put("PSSYSUIACTION", "DE1508");
        deNameMap.put("PSVARTYPE", "DE1509");
        deNameMap.put("PSDERTYPE", "DE1510");
        deNameMap.put("PSDEJOINTYPE", "DE1511");
        deNameMap.put("PSASTYPE", "DE1512");
        deNameMap.put("PSSFSTYLE", "DE1513");
        deNameMap.put("PSSFCODEFOLDER", "DE1514");
        deNameMap.put("PSSFCODETYPE", "DE1515");
        deNameMap.put("PSSFCODETEMPL", "DE1516");
        deNameMap.put("PSDBSYSPROCTEMPL", "DE1517");
        deNameMap.put("PSDBSPPARTTEMPL", "DE1518");
        deNameMap.put("PSDBVALUEMODE", "DE1519");
        deNameMap.put("PSDEFDATATYPE", "DE1520");
        deNameMap.put("PSDELNTYPE", "DE1521");
        deNameMap.put("PSDELLTYPE", "DE1522");
        deNameMap.put("PSDEFVRTYPE", "DE1523");
        deNameMap.put("PSDEFVRTYPEDETAIL", "DE1524");
        deNameMap.put("PSDELLCONDTYPE", "DE1525");
        deNameMap.put("PSBDTYPE", "DE1526");
        deNameMap.put("PSCSSCATTEMPL", "DE1529");
        deNameMap.put("PSCODELISTTEMPL", "DE1530");
        deNameMap.put("PSIMAGETEMPL", "DE1531");
        deNameMap.put("PSLANGUAGE", "DE1532");
        deNameMap.put("PSSYSLANRES", "DE1533");
        deNameMap.put("PSSYSLANITEM", "DE1534");
        deNameMap.put("PSDBOBJTYPE", "DE1535");
        deNameMap.put("PSCSSTEMPL", "DE1536");
        deNameMap.put("PSPDTVIEW", "DE1537");
        deNameMap.put("PSDEDQPDCOND", "DE1538");
        deNameMap.put("PSPDTAPPFUNC", "DE1539");
        deNameMap.put("PSDBVALUEOP", "DE1540");
        deNameMap.put("PSDBVALUEFUNC", "DE1541");
        deNameMap.put("PSDBVFCODE", "DE1542");
        deNameMap.put("PSVALUERULE", "DE1543");
        deNameMap.put("PSDEVSERVERTYPE", "DE1544");
        deNameMap.put("PSDEUTILTYPE", "DE1545");
        deNameMap.put("PSSFPF", "DE1546");
        deNameMap.put("PSSFSTYLEVER", "DE1550");
        deNameMap.put("PSSFVERCODE", "DE1551");
        deNameMap.put("PSSFVERCODEITEM", "DE1552");
        deNameMap.put("PSSFSTYLECODE", "DE1553");
        deNameMap.put("PSMODELINIT", "DE1590");
        deNameMap.put("PSMIDETAIL", "DE1591");
        deNameMap.put("PSPFCODEFOLDER", "DE1592");
        deNameMap.put("PSPFSTYLE", "DE1595");
        deNameMap.put("PSPFPUBCODE", "DE1596");
        deNameMap.put("PSPFSTYLEPRJ", "DE1597");
        deNameMap.put("PSVIEWENGINE", "DE1598");
        deNameMap.put("PSVIEWTYPECAT", "DE1599");
        deNameMap.put("PSVIEWTYPE", "DE1600");
        deNameMap.put("PSCTRLTYPE", "DE1601");
        deNameMap.put("PSVTCATDETAIL", "DE1602");
        deNameMap.put("PSFORMTYPE", "DE1603");
        deNameMap.put("PSDEGCTYPE", "DE1604");
        deNameMap.put("PSEDITORTYPE", "DE1605");
        deNameMap.put("PSTBITEMTYPE", "DE1606");
        deNameMap.put("PSFORMDETAILTYPE", "DE1607");
        deNameMap.put("PSFDLOGICTYPE", "DE1608");
        deNameMap.put("PSDRITEMTYPE", "DE1609");
        deNameMap.put("PSAMITEMTYPE", "DE1610");
        deNameMap.put("PSVTRV", "DE1611");
        deNameMap.put("PSVTCTRL", "DE1612");
        deNameMap.put("PSVTSTYLE", "DE1613");
        deNameMap.put("PSVIEWLOGICTYPE", "DE1614");
        deNameMap.put("PSVTSAMPLE", "DE1615");
        deNameMap.put("PSVIEWTYPELOGIC", "DE1616");
        deNameMap.put("PSTREENODETYPE", "DE1617");
        deNameMap.put("PSEDITORSTYLE", "DE1618");
        deNameMap.put("PSPANELDETAILTYPE", "DE1619");
        deNameMap.put("PSSYSTOOLBAR", "DE1620");
        deNameMap.put("PSSYSTBITEM", "DE1621");
        deNameMap.put("PSCHARTTYPE", "DE1622");
        deNameMap.put("PSPORTLETTYPE", "DE1623");
        deNameMap.put("PSLISTITEMTYPE", "DE1624");
        deNameMap.put("PSCTRLEVENT", "DE1625");
        deNameMap.put("PSCTRLACTION", "DE1626");
        deNameMap.put("PSCTRLTYPEEVENT", "DE1627");
        deNameMap.put("PSCTRLTYPEACTION", "DE1628");
        deNameMap.put("PSDATASYNCAGENTTYPE", "DE1629");
        deNameMap.put("PSVIEWSTYLE", "DE1630");
        deNameMap.put("PSPFCTRLTYPE", "DE1631");
        deNameMap.put("PSPFVIEWTYPE", "DE1632");
        deNameMap.put("PSPFEDITORTYPE", "DE1633");
        deNameMap.put("PSPFPUBOBJ", "DE1634");
        deNameMap.put("PSPFPUBOBJPARAM", "DE1635");
        deNameMap.put("PSSFPUBOBJ", "DE1636");
        deNameMap.put("PSSFPUBOBJPARAM", "DE1637");
        deNameMap.put("PSSFCTRLTYPE", "DE1640");
        deNameMap.put("PSSFVIEWTYPE", "DE1641");
        deNameMap.put("PSCTRLMSGTAG", "DE1648");
        deNameMap.put("PSSYSACHANDLER", "DE1649");
        deNameMap.put("PSSFACHANDLER", "DE1650");
        deNameMap.put("PSSFPKGCAT", "DE1651");
        deNameMap.put("PSSFPKG", "DE1652");
        deNameMap.put("PSSFPKGVER", "DE1653");
        deNameMap.put("PSSFSTYLEPKG", "DE1654");
        deNameMap.put("PSSFSTYLEPRJ", "DE1655");
        deNameMap.put("PSSFSTYLELOG", "DE1656");
        deNameMap.put("PSPFSTYLELOG", "DE1657");
        deNameMap.put("PSSFEXCEPTION", "DE1658");
        deNameMap.put("PSSFCONFIG", "DE1659");
        deNameMap.put("PSSFPLUGIN", "DE1660");
        deNameMap.put("PSSFPLUGINTEMPL", "DE1661");
        deNameMap.put("PSSFSTYLEPARAM", "DE1662");
        deNameMap.put("PSSFSTYLEREF", "DE1663");
        deNameMap.put("PSCTRLTYPEMSGTAG", "DE1665");
        deNameMap.put("PSPFPKGCAT", "DE1671");
        deNameMap.put("PSPFPKG", "DE1672");
        deNameMap.put("PSPFPKGVER", "DE1673");
        deNameMap.put("PSPFSTYLEPKG", "DE1674");
        deNameMap.put("PSPFCDN", "DE1675");
        deNameMap.put("PSPFPKGVERCDN", "DE1676");
        deNameMap.put("PSHELPSECTIONTYPE", "DE1680");
        deNameMap.put("PSHELPARTICLETYPE", "DE1681");
        deNameMap.put("PSHELPARTICLETEMPL", "DE1682");
        deNameMap.put("PSHELPSECTIONTEMPL", "DE1683");
        deNameMap.put("PSHELPARTSEC", "DE1684");
        deNameMap.put("PSHELPPRJTYPE", "DE1685");
        deNameMap.put("PSHELPPRJTEMPL", "DE1686");
        deNameMap.put("PSAPPFUNCTYPE", "DE1700");
        deNameMap.put("PSSVRPROVIDER", "DE1709");
        deNameMap.put("PSPRODUCT", "DE1710");
        deNameMap.put("PSSYSPRODUCT", "DE1711");
        deNameMap.put("PSSYSPRDVER", "DE1712");
        deNameMap.put("PSRTWXACCOUNT", "DE1750");
        deNameMap.put("PSPFSTYLECODE", "DE1800");
        deNameMap.put("PSPFVIEWTEMPL", "DE1801");
        deNameMap.put("PSPFCTRLTEMPL", "DE1802");
        deNameMap.put("PSPFCTDETAIL", "DE1803");
        deNameMap.put("PSPFEDITORTEMPL", "DE1804");
        deNameMap.put("PSPFUATEMPL", "DE1805");
        deNameMap.put("PSPFVLTEMPL", "DE1806");
        deNameMap.put("PSDEFVRCODETYPE", "DE1807");
        deNameMap.put("PSPFAPPTEMPL", "DE1808");
        deNameMap.put("PSCODESNIPPETTYPE", "DE1809");
        deNameMap.put("PSPFPLUGINTYPE", "DE1815");
        deNameMap.put("PSPFPLUGIN", "DE1816");
        deNameMap.put("PSPFPLUGINTEMPL", "DE1817");
        deNameMap.put("PSCOUNTERTYPE", "DE1818");
        deNameMap.put("PSCOUNTER", "DE1819");
        deNameMap.put("PSCOUNTERTYPESF", "DE1820");
        deNameMap.put("PSPORTLET", "DE1821");
        deNameMap.put("PSBACKSERVICE", "DE1822");
        deNameMap.put("PSDEPTOOLTYPE", "DE1870");
        deNameMap.put("PSMAVENSERVERTYPE", "DE1871");
        deNameMap.put("PSWFPROCESSTYPE", "DE1880");
        deNameMap.put("PSWFLINKTYPE", "DE1881");
        deNameMap.put("PSWFLINKCONDTYPE", "DE1882");
        deNameMap.put("PSDEPSLNTYPE", "DE1883");
        deNameMap.put("PSDEPSYSTYPE", "DE1884");
        deNameMap.put("PSSVRDOMAIN", "DE1885");
        deNameMap.put("PSWORKSHOPSERVER", "DE1886");
        deNameMap.put("PSSVRSERVER", "DE1890");
        deNameMap.put("PSDBSERVER", "DE1891");
        deNameMap.put("PSDEVSERVER", "DE1892");
        deNameMap.put("PSDEVSERVERLEASE", "DE1893");
        deNameMap.put("PSDEVENV", "DE1894");
        deNameMap.put("PSSYSMODELINST", "DE1895");
        deNameMap.put("PSSYSMODELVER", "DE1896");
        deNameMap.put("PSSYSMODELACTION", "DE1897");
        deNameMap.put("PSDCINST", "DE1898");
        deNameMap.put("PSDEPLOYCENTER", "DE1899");
        deNameMap.put("PSDBDEVINST", "DE1900");
        deNameMap.put("PSAPPSERVER", "DE1901");
        deNameMap.put("PSTASKSERVER", "DE1902");
        deNameMap.put("PSSVNSERVER", "DE1903");
        deNameMap.put("PSSVNINSTREPO", "DE1904");
        deNameMap.put("PSROSSERVER", "DE1905");
        deNameMap.put("PSMQINST", "DE1906");
        deNameMap.put("PSTSCMD", "DE1907");
        deNameMap.put("PSDCSERVER", "DE1908");
        deNameMap.put("PSBDSERVER", "DE1909");
        deNameMap.put("PSBDDEVINST", "DE1910");
        deNameMap.put("PSASGROUP", "DE1911");
        deNameMap.put("PSMOBAPPPACKSERVER", "DE1912");
        deNameMap.put("PSDEPLOYSERVER", "DE1913");
        deNameMap.put("PSMSPLATFORM", "DE1914");
        deNameMap.put("PSMSPLATFORMFUNC", "DE1915");
        deNameMap.put("PSMSPLATFORMNODE", "DE1916");
        deNameMap.put("PSMAVENSERVER", "DE1917");
        deNameMap.put("PSMAVENREPO", "DE1918");
        deNameMap.put("PSGITUSER", "DE1919");
        deNameMap.put("PSSYSDEVBTTYPE", "DE1920");
        deNameMap.put("PSSYSDEVINFOTYPE", "DE1921");
        deNameMap.put("PSSYSDSACTIONTYPE", "DE1922");
        deNameMap.put("PSSTUDIOSERVERGRP", "DE1923");
        deNameMap.put("PSSTUDIOSERVER", "DE1924");
        deNameMap.put("PSDCBKTYPE", "DE1925");
        deNameMap.put("PSSTUDIOSERVERLOG", "DE1926");
        deNameMap.put("PSTASKSERVERLOG", "DE1927");
        deNameMap.put("PSDBWIZARDINST", "DE1928");
        deNameMap.put("PSNDFILE", "DE1930");
        deNameMap.put("PSNDFILELINK", "DE1931");
        deNameMap.put("PSSYSMODELPATCH", "DE1932");
        deNameMap.put("PSROBOT", "DE1935");
        deNameMap.put("PSDCSYNCAGENT", "DE1940");
        deNameMap.put("PSDCSYNCDATATYPE", "DE1941");
        deNameMap.put("PSSUBSYS", "DE1950");
        deNameMap.put("PSSUBDE", "DE1951");
        deNameMap.put("PSSUBDEACTION", "DE1952");
        deNameMap.put("PSSUBSYSSF", "DE1953");
        deNameMap.put("PSSUBSYSDM", "DE1954");
        deNameMap.put("PSSUBDEVIEW", "DE1955");
        deNameMap.put("PSSUBSYSVER", "DE1956");
        deNameMap.put("PSSUBSYSVERINST", "DE1957");
        deNameMap.put("PSSUBAPP", "DE1960");
        deNameMap.put("PSSUBAPPVIEW", "DE1963");
        deNameMap.put("PSSYSMODELINSTBK", "DE1965");
        deNameMap.put("PSDBDEVINSTBK", "DE1966");
        deNameMap.put("PSSYSISSUETYPE", "DE1970");
        deNameMap.put("PSSYSISSUEENGINE", "DE1971");
        deNameMap.put("PSSYSENGINECFG", "DE1972");
        deNameMap.put("PSSYSMODELFUNCCAT", "DE1979");
        deNameMap.put("PSSYSMODELFUNC", "DE1980");
        deNameMap.put("PSSYSMODELFUNCTEMPL", "DE1981");
        deNameMap.put("PSCOREPRDINSTLOG", "DE1982");
        deNameMap.put("PSMODELOBJ", "DE2000");
        deNameMap.put("PSSYSDYNAMODEL", "DE2001");
        deNameMap.put("PSSYSDYNAMODELATTR", "DE2002");
        deNameMap.put("PSDEVCENTER", "DE2010");
        deNameMap.put("PSDEVUSEROBJ", "DE2011");
        deNameMap.put("PSDEVUSER", "DE2012");
        deNameMap.put("PSDEVUSERGROUP", "DE2013");
        deNameMap.put("PSDEVCENTERSRV", "DE2014");
        deNameMap.put("PSDEVCENTERDBINST", "DE2015");
        deNameMap.put("PSDEVCENTERSERVER", "DE2016");
        deNameMap.put("PSDCSERVERSTATE", "DE2017");
        deNameMap.put("PSDEVCENTERAS", "DE2018");
        deNameMap.put("PSDEVCENTERTS", "DE2019");
        deNameMap.put("PSDEVSLN", "DE2020");
        deNameMap.put("PSDEVSLNSYS", "DE2021");
        deNameMap.put("PSDEVCENTERSVN", "DE2022");
        deNameMap.put("PSDEVCENTERMQ", "DE2023");
        deNameMap.put("PSDEVSLNSYSVER", "DE2024");
        deNameMap.put("PSDCBDINST", "DE2025");
        deNameMap.put("PSDEVSLNSYSPATCH", "DE2026");
        deNameMap.put("PSDEVSLNUSER", "DE2029");
        deNameMap.put("PSSYSTEM", "DE2030");
        deNameMap.put("PSMODULE", "DE2031");
        deNameMap.put("PSSYSTEMDBCFG", "DE2032");
        deNameMap.put("PSSYSEDITORSTYLE", "DE2033");
        deNameMap.put("PSSYSVALUERULE", "DE2034");
        deNameMap.put("PSSYSUSERMODE", "DE2035");
        deNameMap.put("PSSYSDBDETAIL", "DE2036");
        deNameMap.put("PSSYSOPPRIV", "DE2037");
        deNameMap.put("PSSYSPFPLUGIN", "DE2038");
        deNameMap.put("PSSYSTEMAS", "DE2039");
        deNameMap.put("PSCODELIST", "DE2040");
        deNameMap.put("PSCODEITEM", "DE2041");
        deNameMap.put("PSSUBVIEWTYPE", "DE2042");
        deNameMap.put("PSSYSUNIRES", "DE2043");
        deNameMap.put("PSSYSDBVF", "DE2044");
        deNameMap.put("PSSYSDBVFCODE", "DE2045");
        deNameMap.put("PSSYSCTRLSTYLE", "DE2046");
        deNameMap.put("PSSYSACTOR", "DE2047");
        deNameMap.put("PSSYSUSERCASE", "DE2048");
        deNameMap.put("PSSYSTEMMQ", "DE2049");
        deNameMap.put("PSDATAENTITY", "DE2050");
        deNameMap.put("PSDEFIELD", "DE2051");
        deNameMap.put("PSDER", "DE2052");
        deNameMap.put("PSSYSSAMPLEVALUE", "DE2053");
        deNameMap.put("PSLANGUAGERES", "DE2054");
        deNameMap.put("PSDEDBCFG", "DE2055");
        deNameMap.put("PSDEDATASET", "DE2056");
        deNameMap.put("PSDEDATAQUERY", "DE2057");
        deNameMap.put("PSDEDQJOIN", "DE2058");
        deNameMap.put("PSDEDQCOND", "DE2059");
        deNameMap.put("PSDEFDTCOL", "DE2060");
        deNameMap.put("PSDEDSDQ", "DE2061");
        deNameMap.put("PSDEDSCODE", "DE2062");
        deNameMap.put("PSDEDQCODE", "DE2063");
        deNameMap.put("PSDEOPPRIV", "DE2064");
        deNameMap.put("PSDEDUPRULE", "DE2065");
        deNameMap.put("PSDEDUPRULEITEM", "DE2066");
        deNameMap.put("PSDEFVALUERULE", "DE2067");
        deNameMap.put("PSDEDSPARAM", "DE2068");
        deNameMap.put("PSDEFVRDSPARAM", "DE2069");
        deNameMap.put("PSDESYSPROC", "DE2070");
        deNameMap.put("PSDEFVRCOND", "DE2071");
        deNameMap.put("PSDESPCODE", "DE2072");
        deNameMap.put("PSDESPCODEPART", "DE2073");
        deNameMap.put("PSDESPFIELD", "DE2074");
        deNameMap.put("PSDEDQCODEEXP", "DE2075");
        deNameMap.put("PSDEACTION", "DE2076");
        deNameMap.put("PSDEDQCODECOND", "DE2077");
        deNameMap.put("PSDEDSGRPPARAM", "DE2078");
        deNameMap.put("PSDEDBINDEX", "DE2079");
        deNameMap.put("PSDEUIACTION", "DE2080");
        deNameMap.put("PSDEDATARELATION", "DE2081");
        deNameMap.put("PSDEDRITEM", "DE2082");
        deNameMap.put("PSDELOGIC", "DE2083");
        deNameMap.put("PSDELOGICNODE", "DE2084");
        deNameMap.put("PSDELOGICLINK", "DE2085");
        deNameMap.put("PSDELOGICPARAM", "DE2086");
        deNameMap.put("PSDELLCOND", "DE2087");
        deNameMap.put("PSDEACTIONLOGIC", "DE2088");
        deNameMap.put("PSDBPROCPARAM", "DE2089");
        deNameMap.put("PSSYSDBCHGLOG", "DE2090");
        deNameMap.put("PSDEDRGROUP", "DE2091");
        deNameMap.put("PSDEDRDETAIL", "DE2092");
        deNameMap.put("PSDEVRGROUP", "DE2093");
        deNameMap.put("PSDEVRGRPDETAIL", "DE2094");
        deNameMap.put("PSDEUAGROUP", "DE2095");
        deNameMap.put("PSDEUAGRPDETAIL", "DE2096");
        deNameMap.put("PSDELNPARAM", "DE2097");
        deNameMap.put("PSDEDATAEXP", "DE2098");
        deNameMap.put("PSDEDATAIMP", "DE2099");
        deNameMap.put("PSSYSDEPLOY", "DE2100");
        deNameMap.put("PSSYSDEPLOYDB", "DE2101");
        deNameMap.put("PSSYSDEPLOYAS", "DE2102");
        deNameMap.put("PSSYSDEPLOYAPP", "DE2103");
        deNameMap.put("PSSYSORGTYPE", "DE2104");
        deNameMap.put("PSSYSOUTYPE", "DE2105");
        deNameMap.put("PSSYSOUTYPERS", "DE2106");
        deNameMap.put("PSDEDBIDXFIELD", "DE2107");
        deNameMap.put("PSDERDEFMAP", "DE2108");
        deNameMap.put("PSSYSUSERDR", "DE2109");
        deNameMap.put("PSVIEWMSGGROUP", "DE2110");
        deNameMap.put("PSVIEWMSG", "DE2111");
        deNameMap.put("PSVIEWMSGGRPDETAIL", "DE2112");
        deNameMap.put("PSCTRLMSG", "DE2113");
        deNameMap.put("PSCTRLMSGITEM", "DE2114");
        deNameMap.put("PSVIEWWIZARDGROUP", "DE2115");
        deNameMap.put("PSSYSSFPLUGIN", "DE2116");
        deNameMap.put("PSSYSCSSCAT", "DE2119");
        deNameMap.put("PSSYSIMAGE", "DE2120");
        deNameMap.put("PSSYSCSS", "DE2121");
        deNameMap.put("PSSYSDELOGICNODE", "DE2122");
        deNameMap.put("PSSYSREF", "DE2130");
        deNameMap.put("PSSYSREFDE", "DE2131");
        deNameMap.put("PSDETEMPMODE", "DE2140");
        deNameMap.put("PSDETMDETAIL", "DE2141");
        deNameMap.put("PSDETMDRS", "DE2142");
        deNameMap.put("PSDEMAP", "DE2143");
        deNameMap.put("PSDEMAPDETAIL", "DE2144");
        deNameMap.put("PSDEMAINSTATE", "DE2145");
        deNameMap.put("PSDEMSACTION", "DE2146");
        deNameMap.put("PSDEMSOPPRIV", "DE2147");
        deNameMap.put("PSDEFGROUP", "DE2148");
        deNameMap.put("PSDEFGROUPDETAIL", "DE2149");
        deNameMap.put("PSDERGROUP", "DE2150");
        deNameMap.put("PSDERGROUPDETAIL", "DE2152");
        deNameMap.put("PSDEUSERROLE", "DE2153");
        deNameMap.put("PSDEOPPRIVROLE", "DE2160");
        deNameMap.put("PSDEACTIONTEMPL", "DE2180");
        deNameMap.put("PSDEACTIONPARAM", "DE2188");
        deNameMap.put("PSDEMAINSTATERS", "DE2189");
        deNameMap.put("PSDEDBOBJSQL", "DE2190");
        deNameMap.put("PSSYSUNISTATE", "DE2191");
        deNameMap.put("PSSYSSQLCMD", "DE2194");
        deNameMap.put("PSSYSSQLCMDSQL", "DE2195");
        deNameMap.put("PSSYSCOUNTER", "DE2197");
        deNameMap.put("PSSYSDICTCAT", "DE2198");
        deNameMap.put("PSSYSCOUNTERITEM", "DE2199");
        deNameMap.put("PSDECTRL", "DE2200");
        deNameMap.put("PSDEFORM", "DE2201");
        deNameMap.put("PSDEFORMDETAIL", "DE2202");
        deNameMap.put("PSDEFFORMITEM", "DE2203");
        deNameMap.put("PSDEFSFITEM", "DE2204");
        deNameMap.put("PSDEFIVR", "DE2205");
        deNameMap.put("PSDETOOLBAR", "DE2206");
        deNameMap.put("PSDETBITEM", "DE2207");
        deNameMap.put("PSDEFDLOGIC", "DE2208");
        deNameMap.put("PSDEVIEWGROUP", "DE2209");
        deNameMap.put("PSDEGRID", "DE2210");
        deNameMap.put("PSDEGRIDCOL", "DE2211");
        deNameMap.put("PSDEFGRIDCOL", "DE2212");
        deNameMap.put("PSDEGEIUPDATE", "DE2213");
        deNameMap.put("PSDEGEIUDETAIL", "DE2214");
        deNameMap.put("PSDEACMODE", "DE2215");
        deNameMap.put("PSDEFIUPDATE", "DE2216");
        deNameMap.put("PSDEDATAVIEW", "DE2217");
        deNameMap.put("PSDEFIUDETAIL", "DE2218");
        deNameMap.put("PSDEFORMRF", "DE2219");
        deNameMap.put("PSDETREEVIEW", "DE2220");
        deNameMap.put("PSDETREENODE", "DE2221");
        deNameMap.put("PSDETREENODERS", "DE2222");
        deNameMap.put("PSDECHART", "DE2223");
        deNameMap.put("PSDECHARTPARAM", "DE2224");
        deNameMap.put("PSDEPRINT", "DE2225");
        deNameMap.put("PSDECHARTAXES", "DE2226");
        deNameMap.put("PSDELIST", "DE2227");
        deNameMap.put("PSDELISTITEM", "DE2228");
        deNameMap.put("PSDEACMODEITEM", "DE2229");
        deNameMap.put("PSDEREPORT", "DE2230");
        deNameMap.put("PSDEREPITEM", "DE2231");
        deNameMap.put("PSDETREENODERV", "DE2232");
        deNameMap.put("PSDETREECOL", "DE2233");
        deNameMap.put("PSDETREENODECOL", "DE2234");
        deNameMap.put("PSSYSPORTLET", "DE2240");
        deNameMap.put("PSSYSREPORT", "DE2241");
        deNameMap.put("PSSYSDBSCHEME", "DE2245");
        deNameMap.put("PSSYSDBTABLE", "DE2250");
        deNameMap.put("PSSYSDBCOLUMN", "DE2251");
        deNameMap.put("PSDETABLE", "DE2252");
        deNameMap.put("PSSYSSEARCHBAR", "DE2280");
        deNameMap.put("PSSYSDASHBOARD", "DE2281");
        deNameMap.put("PSSYSTITLEBAR", "DE2282");
        deNameMap.put("PSSYSCALENDAR", "DE2283");
        deNameMap.put("PSSYSCALENDARITEM", "DE2284");
        deNameMap.put("PSSYSCALENDARITEMRV", "DE2285");
        deNameMap.put("PSACHANDLER", "DE2290");
        deNameMap.put("PSSYSVIEWLOGIC", "DE2291");
        deNameMap.put("PSACHANDLERACTION", "DE2292");
        deNameMap.put("PSSYSVIEWPANEL", "DE2299");
        deNameMap.put("PSDEVIEWBASE", "DE2300");
        deNameMap.put("PSDEVIEWRV", "DE2301");
        deNameMap.put("PSDEVIEWCTRL", "DE2302");
        deNameMap.put("PSDEVIEWLOGIC", "DE2303");
        deNameMap.put("PSSYSPFPITEMPL", "DE2304");
        deNameMap.put("PSDEFINPUTTIPSET", "DE2305");
        deNameMap.put("PSDEVIEWCTRLDS", "DE2306");
        deNameMap.put("PSSYSVIEWPANELITEM", "DE2307");
        deNameMap.put("PSSYSSEARCHBARITEM", "DE2308");
        deNameMap.put("PSSYSDBPART", "DE2309");
        deNameMap.put("PSSYSMSGTEMPL", "DE2310");
        deNameMap.put("PSSYSBACKSERVICE", "DE2311");
        deNameMap.put("PSDEFINPUTTIP", "DE2312");
        deNameMap.put("PSDEACTIONWIZARD", "DE2313");
        deNameMap.put("PSDEAWITEM", "DE2314");
        deNameMap.put("PSDEAWGROUP", "DE2315");
        deNameMap.put("PSDEAWGRPDETAIL", "DE2316");
        deNameMap.put("PSDEVIEWSERVICE", "DE2317");
        deNameMap.put("PSSYSBDINSTCFG", "DE2320");
        deNameMap.put("PSSYSBDSCHEME", "DE2321");
        deNameMap.put("PSSYSBDPART", "DE2322");
        deNameMap.put("PSSYSBDMODULE", "DE2323");
        deNameMap.put("PSSYSBDTABLE", "DE2330");
        deNameMap.put("PSSYSBDCOLSET", "DE2331");
        deNameMap.put("PSSYSBDTABLEDE", "DE2332");
        deNameMap.put("PSSYSBDTABLEDER", "DE2334");
        deNameMap.put("PSSYSBDCOLUMN", "DE2335");
        deNameMap.put("PSSYSBDTABLERS", "DE2336");
        deNameMap.put("PSSYSSFPITEMPL", "DE2350");
        deNameMap.put("PSDEVPRD", "DE2355");
        deNameMap.put("PSDEVPRDVER", "DE2356");
        deNameMap.put("PSDEVPRDSUBVER", "DE2360");
        deNameMap.put("PSDEVPRDSYS", "DE2365");
        deNameMap.put("PSDEVPRDSYSSYNC", "DE2375");
        deNameMap.put("PSDEVPRDSYSSYNCITEM", "DE2376");
        deNameMap.put("PSSYSISSUE", "DE2380");
        deNameMap.put("PSSYSPDTVIEW", "DE2381");
        deNameMap.put("PSSYSUTILDE", "DE2382");
        deNameMap.put("PSSYSUSERROLERES", "DE2383");
        deNameMap.put("PSDEVIEWGRPDETAIL", "DE2384");
        deNameMap.put("PSDEVPRDISSUE", "DE2385");
        deNameMap.put("PSDEVPRDISSUEPLAN", "DE2386");
        deNameMap.put("PSDEVPRDSPEC", "DE2390");
        deNameMap.put("PSDEVPRDSEPCPLAN", "DE2391");
        deNameMap.put("PSDEVPRDSPECPLAN", "DE2392");
        deNameMap.put("PSDEMODELCNT", "DE2399");
        deNameMap.put("PSSYSWFMODE", "DE2400");
        deNameMap.put("PSWORKFLOW", "DE2401");
        deNameMap.put("PSWFVERSION", "DE2402");
        deNameMap.put("PSWFROLE", "DE2403");
        deNameMap.put("PSWFDE", "DE2404");
        deNameMap.put("PSWFPROCESS", "DE2410");
        deNameMap.put("PSWFLINK", "DE2411");
        deNameMap.put("PSWFWORKTIME", "DE2412");
        deNameMap.put("PSWFSUBWF", "DE2413");
        deNameMap.put("PSWFPROCROLE", "DE2414");
        deNameMap.put("PSWFLINKCOND", "DE2415");
        deNameMap.put("PSWFPROCSUBWF", "DE2416");
        deNameMap.put("PSWFLINKROLE", "DE2417");
        deNameMap.put("PSWFPROCPARAM", "DE2418");
        deNameMap.put("PSSYSWFSETTING", "DE2419");
        deNameMap.put("PSWFVERLOG", "DE2420");
        deNameMap.put("PSSYSDATASYNCAGENT", "DE2440");
        deNameMap.put("PSDEDATASYNC", "DE2441");
        deNameMap.put("PSSYSREQMODULE", "DE2446");
        deNameMap.put("PSDEWIZARD", "DE2447");
        deNameMap.put("PSDEWIZARDSTEP", "DE2448");
        deNameMap.put("PSDEWIZARDFORM", "DE2449");
        deNameMap.put("PSSYSREQITEM", "DE2450");
        deNameMap.put("PSSYSREQITEMDATA", "DE2451");
        deNameMap.put("PSSYSREQITEMHIS", "DE2452");
        deNameMap.put("PSDEVCENTERPF", "DE2470");
        deNameMap.put("PSDEVCENTERSF", "DE2480");
        deNameMap.put("PSDCSFPKG", "DE2481");
        deNameMap.put("PSSYSAPP", "DE2500");
        deNameMap.put("PSAPPMODULE", "DE2501");
        deNameMap.put("PSAPPUSERMODE", "DE2502");
        deNameMap.put("PSAPPCTRLSTYLE", "DE2503");
        deNameMap.put("PSAPPVIEWSTYLE", "DE2504");
        deNameMap.put("PSAPPVIEW", "DE2506");
        deNameMap.put("PSAPPDEVIEW", "DE2507");
        deNameMap.put("PSAPPINDEXVIEW", "DE2508");
        deNameMap.put("PSAPPPORTALVIEW", "DE2509");
        deNameMap.put("PSAPPFUNC", "DE2510");
        deNameMap.put("PSAPPVIEWREF", "DE2511");
        deNameMap.put("PSAPPSUBAPP", "DE2512");
        deNameMap.put("PSAPPPKG", "DE2517");
        deNameMap.put("PSAPPLAN", "DE2518");
        deNameMap.put("PSAPPUTILPAGE", "DE2519");
        deNameMap.put("PSAPPMENU", "DE2520");
        deNameMap.put("PSAPPMENUITEM", "DE2521");
        deNameMap.put("PSAPPPVPART", "DE2522");
        deNameMap.put("PSAPPUISTYLE", "DE2523");
        deNameMap.put("PSAPPUITHEME", "DE2524");
        deNameMap.put("PSMOBAPPPACK", "DE2530");
        deNameMap.put("PSMOBAPPSTARTPAGE", "DE2531");
        deNameMap.put("PSMOBAPPPACKSESSION", "DE2532");
        deNameMap.put("PSMOBAPPPACKTD", "DE2533");
        deNameMap.put("PSAPPLOCALDE", "DE2540");
        deNameMap.put("PSAPPUTIL", "DE2541");
        deNameMap.put("PSAPPTITLEBAR", "DE2550");
        deNameMap.put("PSAPPVIEWTEMPL", "DE2580");
        deNameMap.put("PSAPPEDITORTEMPL", "DE2581");
        deNameMap.put("PSAPPVIEWLOGIC", "DE2585");
        deNameMap.put("PSAPPVIEWCODE", "DE2590");
        deNameMap.put("PSDEVSLNSYSAPP", "DE2591");
        deNameMap.put("PSAPPDEVIEWREF", "DE2599");
        deNameMap.put("PSDCMSPLATFORM", "DE2650");
        deNameMap.put("PSDCMSPLATFORMFUNC", "DE2651");
        deNameMap.put("PSDCMSPLATFORMNODE", "DE2652");
        deNameMap.put("PSDEVSLNMSDEPLOY", "DE2660");
        deNameMap.put("PSDEVSLNMSDEPAPP", "DE2661");
        deNameMap.put("PSDEVSLNMSDEPFUNC", "DE2823");
        deNameMap.put("PSDCASGROUP", "DE2670");
        deNameMap.put("PSDESAMPLEDATA", "DE2680");
        deNameMap.put("PSDESAMPLEDATAREF", "DE2685");
        deNameMap.put("PSDEVSYSDIFFREP", "DE2700");
        deNameMap.put("PSDEVSYSDIFFITEM", "DE2701");
        deNameMap.put("PSDEPSYS", "DE2702");
        deNameMap.put("PSDEPSYSVER", "DE2703");
        deNameMap.put("PSDEPSYSAPP", "DE2704");
        deNameMap.put("PSDEPSLN", "DE2720");
        deNameMap.put("PSDEPSLNPRD", "DE2721");
        deNameMap.put("PSDEPSLNDBINST", "DE2722");
        deNameMap.put("PSDEPSLNAS", "DE2723");
        deNameMap.put("PSDEPSLNASGRP", "DE2724");
        deNameMap.put("PSDEPSLNASITEM", "DE2725");
        deNameMap.put("PSDEPSLNMQINST", "DE2726");
        deNameMap.put("PSDEPSLNSYS", "DE2730");
        deNameMap.put("PSDEPSLNSYSDB", "DE2731");
        deNameMap.put("PSDEPSLNSYSMQ", "DE2732");
        deNameMap.put("PSDEPSLNSYSAS", "DE2737");
        deNameMap.put("PSDEPSLNMODE", "DE2740");
        deNameMap.put("PSDEPSLNMODEPRD", "DE2741");
        deNameMap.put("PSDEPSLNHOST", "DE2750");
        deNameMap.put("PSDEPSLNLOG", "DE2760");
        deNameMap.put("PSDEPSLNRUNLOG", "DE2761");
        deNameMap.put("PSDEPSLNPACK", "DE2765");
        deNameMap.put("PSDEPSLNDEPSESSION", "DE2766");
        deNameMap.put("PSSYSDMVER", "DE2790");
        deNameMap.put("PSSYSSFPUB", "DE2800");
        deNameMap.put("PSSYSSFCODE", "DE2801");
        deNameMap.put("PSSYSSFPUBPKG", "DE2802");
        deNameMap.put("PSSYSDMITEM", "DE2803");
        deNameMap.put("PSSYSDMITEMLOG", "DE2804");
        deNameMap.put("PSSYSMODELMSG", "DE2805");
        deNameMap.put("PSSYSDEFTYPE", "DE2806");
        deNameMap.put("PSSYSDMVERITEM", "DE2807");
        deNameMap.put("PSSYSSFPUBREF", "DE2808");
        deNameMap.put("PSSYSSERVICEAPI", "DE2810");
        deNameMap.put("PSDESERVICEAPI", "DE2811");
        deNameMap.put("PSDESADETAIL", "DE2812");
        deNameMap.put("PSDEVSLNSYSAPI", "DE2813");
        deNameMap.put("PSDEVSLNSYSSRV", "DE2814");
        deNameMap.put("PSSUBSYSSERVICEAPI", "DE2815");
        deNameMap.put("PSSUBSYSSADETAIL", "DE2816");
        deNameMap.put("PSDEDTSQUEUE", "DE2817");
        deNameMap.put("PSDEUTILDE", "DE2818");
        deNameMap.put("PSDEMODEL", "DE2819");
        deNameMap.put("PSSYSTESTDATA", "DE2820");
        deNameMap.put("PSSYSTDITEM", "DE2821");
        deNameMap.put("PSDEVSLNMSDEPAPI", "DE2822");
        deNameMap.put("PSDEDATAIMPITEM", "DE2825");
        deNameMap.put("PSSYSTEMRUN", "DE2830");
        deNameMap.put("PSSYSRUNSESSION", "DE2831");
        deNameMap.put("PSSYSRUNLOG", "DE2832");
        deNameMap.put("PSSYSCONSOLE", "DE2833");
        deNameMap.put("PSSYSUSERCASERS", "DE2834");
        deNameMap.put("PSSYSTESTCASE", "DE2835");
        deNameMap.put("PSSYSTCINPUT", "DE2836");
        deNameMap.put("PSSYSTCASSERT", "DE2837");
        deNameMap.put("PSSYSCODESNIPPET", "DE2838");
        deNameMap.put("PSSYSERMAP", "DE2840");
        deNameMap.put("PSSYSERMAPNODE", "DE2841");
        deNameMap.put("PSDCSFPKGVER", "DE2842");
        deNameMap.put("PSHELPARTICLECAT", "DE2843");
        deNameMap.put("PSLANGUAGEITEM", "DE2848");
        deNameMap.put("PSMODELREF", "DE2849");
        deNameMap.put("PSUAWIZARD", "DE2850");
        deNameMap.put("PSUAWIZARD2", "DE2851");
        deNameMap.put("PSUAWIZARD3", "DE2853");
        deNameMap.put("PSHELPARTICLE", "DE2854");
        deNameMap.put("PSHELPPRJ", "DE2855");
        deNameMap.put("PSHELPMODULE", "DE2856");
        deNameMap.put("PSHELPRESOURCE", "DE2857");
        deNameMap.put("PSHELPSECTION", "DE2858");
        deNameMap.put("PSHELPMODART", "DE2859");
        deNameMap.put("PSDEVSLNSYSGROUP", "DE2860");
        deNameMap.put("PSDEVSLNSYSGD", "DE2861");
        deNameMap.put("PSDEVSLNSYSSRC", "DE2862");
        deNameMap.put("PSSYSTEMSRC", "DE2863");
        deNameMap.put("PSSYSMODELSYNC", "DE2864");
        deNameMap.put("PSDCSYSRES", "DE2870");
        deNameMap.put("PSWXACCOUNT", "DE2875");
        deNameMap.put("PSWXENTAPP", "DE2880");
        deNameMap.put("PSWXMENU", "DE2881");
        deNameMap.put("PSWXMENUFUNC", "DE2885");
        deNameMap.put("PSWXLOGIC", "DE2888");
        deNameMap.put("PSWXMENUITEM", "DE2889");
        deNameMap.put("PSSYSMODELLOADLOG", "DE2899");
        deNameMap.put("PSV3MIGRATE", "DE2900");
        deNameMap.put("PSV3MIGRATEDE", "DE2901");
        deNameMap.put("PSV3MGFORM", "DE2902");
        deNameMap.put("PSV3MGGRID", "DE2903");
        deNameMap.put("PSV3MGVIEW", "DE2904");
        deNameMap.put("PSSAASSYS", "DE2905");
        deNameMap.put("PSSAASSYSVER", "DE2906");
        deNameMap.put("PSSAASSYSAPP", "DE2907");
        deNameMap.put("PSDEPSAASSYS", "DE2908");
        deNameMap.put("PSDEPSAASSYSVER", "DE2909");
        deNameMap.put("PSMODELAPIRS", "DE2910");
        deNameMap.put("PSSYSUNIT", "DE2911");
        deNameMap.put("PSSYSMODELLOG", "DE2912");
        deNameMap.put("PSDEPSAASSYSAPP", "DE2913");
        deNameMap.put("PSSAASSYSDB", "DE2914");
        deNameMap.put("PSSYSTASK", "DE2915");
        deNameMap.put("PSSYSTASKDATA", "DE2916");
        deNameMap.put("PSDCWORKSHOPSERVER", "DE2919");
        deNameMap.put("PSSYSDEVSTUDIO", "DE2920");
        deNameMap.put("PSSYSDEVINFO", "DE2921");
        deNameMap.put("PSSYSDEVBKTASK", "DE2922");
        deNameMap.put("PSSYSDSACTION", "DE2923");
        deNameMap.put("PSSYSPROJECT", "DE2924");
        deNameMap.put("PSDCDEPLOYCENTER", "DE2925");
        deNameMap.put("PSDEVCENTERFILE", "DE2928");
        deNameMap.put("PSDCRESHOURS", "DE2930");
        deNameMap.put("PSDCRESHOURSLOG", "DE2931");
        deNameMap.put("PSDCMOBPACKCERT", "DE2932");
        deNameMap.put("PSDCMOBAPPTESTDEVICE", "DE2933");
        deNameMap.put("PSDCMOBAPPTDREF", "DE2934");
        deNameMap.put("PSDCDEPLOYSERVER", "DE2935");
        deNameMap.put("PSDEVSLNSYSDYNAINST", "DE2939");
        deNameMap.put("PSDEVSLNSYSKEY", "DE2940");
        deNameMap.put("PSDCSYSLIC", "DE2941");
        deNameMap.put("PSDEVSLNSYSMODEL", "DE2942");
        deNameMap.put("PSDCDBINSTBK", "DE2943");
        deNameMap.put("PSDCSVNBK", "DE2944");
        deNameMap.put("PSDEVSLNSYSRES", "DE2945");
        deNameMap.put("PSDEVSLNSYSWSGIT", "DE2946");
        deNameMap.put("PSDEVSLNSYSREF", "DE2947");
        deNameMap.put("PSDCMODELTEMPL", "DE2950");
        deNameMap.put("PSDCMTDECAT", "DE2951");
        deNameMap.put("PSDCMTDEF", "DE2952");
        deNameMap.put("PSDCCOREPRDISSUE", "DE2956");
        deNameMap.put("PSDCPRODUCT", "DE2960");
        deNameMap.put("PSDCSYSPRODUCT", "DE2961");
        deNameMap.put("PSDCSYSPRDVER", "DE2962");
        deNameMap.put("PSDCDBOBJ", "DE2963");
        deNameMap.put("PSDEVUSERSQL", "DE2964");
        deNameMap.put("PSDEVUSERMODEL", "DE2965");
        deNameMap.put("PSDCABILITY", "DE2966");
        deNameMap.put("PSDCROBOT", "DE2970");
        deNameMap.put("PSDCROBOTABILITY", "DE2972");
        deNameMap.put("PSDCROBOTLOG", "DE2976");
        deNameMap.put("PSDEVCENTERRES", "DE2979");
        deNameMap.put("PSDEVCENTERLOG", "DE2980");
        deNameMap.put("PSDEVUSERRECENT", "DE2981");
        deNameMap.put("PSDCBULLETIN", "DE2982");
        deNameMap.put("PSDCTASKLOG", "DE2983");
        deNameMap.put("PSDCBKTASK", "DE2984");
        deNameMap.put("PSDCFILE", "DE2985");
        deNameMap.put("PSDCNWFLOW", "DE2986");
        deNameMap.put("PSDCRESREP", "DE2990");
        deNameMap.put("PSMODELSTORAGE", "DE2999");
        deNameMap.put("PSASBOOKING", "DE3010");
        deNameMap.put("PSASBOOKINGLOG", "DE3011");
        deNameMap.put("PSDSBOOKING", "DE3012");
        deNameMap.put("PSDSBOOKINGLOG", "DE3013");
        deNameMap.put("PSDCDBINSTREF", "DE3100");
        deNameMap.put("PSDEVSLNSYSBAK", "DE3150");
        deNameMap.put("PSDEVSLNSYSTS", "DE3200");
        deNameMap.put("PSDEVSLNSYSPUBLOCK", "DE3201");
        deNameMap.put("PSDEVSLNSYSLOCKLOG", "DE3210");
        deNameMap.put("PSDCPFPLUGIN", "DE3250");
        deNameMap.put("PSDCPFPITEMPL", "DE3251");
        deNameMap.put("PSDCCODESNIPPET", "DE3252");
        deNameMap.put("PSDCCODESNIPPETREF", "DE3253");
        deNameMap.put("PSDCSYNCDATA", "DE3501");
        deNameMap.put("PSDCSYNCDATA2", "DE3502");
        deNameMap.put("PSSYSMODELINSTSUM", "DE4010");
        deNameMap.put("PSVARSAMPLEVALUE", "DE4030");
        deNameMap.put("PSDCRTMSG", "DE4061");
        deNameMap.put("PSSYSRTMSG", "DE4062");
        deNameMap.put("PSVIEWRTMSG", "DE4063");
        deNameMap.put("PSMODELRTMSG", "DE4064");
        deNameMap.put("PSDERTAW", "DE4071");
        deNameMap.put("PSDERTAWI", "DE4072");
        deNameMap.put("PSSYSRTDEFINPUTTIP", "DE4073");
        deNameMap.put("PSBKTASKLOG", "DE4100");
        deNameMap.put("PSDCDBTABLE", "DE4501");
        deNameMap.put("PSDCDBVIEW", "DE4502");
        deNameMap.put("PSDCDBINDEX", "DE4503");
        deNameMap.put("PSDCDBFUNC", "DE4504");
        deNameMap.put("PSDCDBPROC", "DE4505");
        deNameMap.put("PSDCDBSEQU", "DE4506");
        deNameMap.put("PSMODELSFCODE", "DE4531");
        deNameMap.put("PSMODELPFCODE", "DE4532");
        deNameMap.put("PSMODELRT", "DE4533");
        deNameMap.put("PSMODELMEMO", "DE4534");
        deNameMap.put("PSDYNASYS", "DE4560");
        deNameMap.put("PSDYNADE", "DE4570");
        deNameMap.put("PSDYNACODELIST", "DE4571");
        deNameMap.put("PSDYNADEFORM", "DE4580");
        deNameMap.put("PSDYNAINST", "DE4600");
        deNameMap.put("PSDYNACODELISTINST", "DE4605");
        deNameMap.put("PSDYNAWF", "DE4610");
        deNameMap.put("PSDYNAWFVER", "DE4611");
        deNameMap.put("PSDYNAWFVERINST", "DE4612");
        deNameMap.put("PSDYNAAPP", "DE4620");
        deNameMap.put("PSDYNAAPPVIEW", "DE4625");
        deNameMap.put("PSDYNAAPPVIEWCTRL", "DE4626");
        deNameMap.put("PSDYNADEFORMINST", "DE4640");
        deNameMap.put("PSDYNAAPPVIEWINST", "DE4660");
        deNameMap.put("PSDYNAAPPVCINST", "DE4661");
        deNameMap.put("PSUWCREATEDE", "DE4700");
        deNameMap.put("PSUWDEUNIONKEY", "DE4701");
        deNameMap.put("PSUWAPPVIEW", "DE4702");
        deNameMap.put("PSUWCREATEDEITEM", "DE4703");
        deNameMap.put("PSUWDEDRITEM", "DE4704");
        deNameMap.put("PSUWAPPFUNC", "DE4705");
        deNameMap.put("PSUWCREATEDEDEF", "DE4706");
        deNameMap.put("PSUWCREATEDEDER", "DE4707");
        deNameMap.put("PSSYSSERVICEAPI", "DE2810");
        deNameMap.put("PSDEVSLNSYSDEPINST", "DE3153");
        deNameMap.put("PSPFPREVIEWACTION", "DE4200");
        deNameMap.put("PSSFPREVIEWACTION", "DE4201");
        deNameMap.put("PSCODEPREVIEWACTION", "DE4202");
        deNameMap.put("PSCODESERVERACTION", "DE4203");
        deNameMap.put("PSDCWORKSPACEACTION", "DE2975");
        deNameMap.put("PSAPPSTORYBOARD", "DE2560");
        deNameMap.put("PSUWPROJECT", "DE4711");
        deNameMap.put("PSSTUDIOPLUGIN", "DE1985");
        deNameMap.put("PSSTUDIOPLUGINDATA", "DE1986");
        deNameMap.put("PSDEVSLNMSDEPRES", "DE2663");
        deNameMap.put("PSDEVSLNRES", "DE2662");
        deNameMap.put("PSDEVSLNPIPELINE", "DE2988");
        deNameMap.put("PSDEVSLNPIPELINEREF", "DE2989");
        deNameMap.put("PSDEVSLNPIPELINELOG", "DE2993");
        deNameMap.put("PSDEVSLNPIPELINESTAGE", "DE2994");
        deNameMap.put("PSDEVSLNPIPELINESTEP", "DE2995");
        deNameMap.put("PSCREDENTIAL", "DE1936");
        dcIdMap.put("PSDEVCENTERPF", "PSDEVCENTERID");
        dcIdMap.put("PSDEVSERVERLEASE", "PSDEVCENTERID");
        dcIdMap.put("PSDEVSLNSYSDEPINST", "PSDEVCENTERID");
        dcIdMap.put("PSDCCONTAINERSPEC", "PSDEVCENTERID");
        dcIdMap.put("PSWPDCWFCAT", "PSDEVCENTERID");
        dcIdMap.put("PSDCDBINSTREF", "PSDEVCENTERID");
        dcIdMap.put("PSDCWORKSPACE", "PSDEVCENTERID");
        dcIdMap.put("PSUSDCMODULE", "PSDEVCENTERID");
        dcIdMap.put("PSUSDCAPPPOLICY", "PSDEVCENTERID");
        dcIdMap.put("PSDCORGUSER", "PSDEVCENTERID");
        dcIdMap.put("PSPFPKGVER", "PSDCID");
        dcIdMap.put("PSDCMSPLATFORM", "PSDEVCENTERID");
        dcIdMap.put("PSDCDBINSTBK", "PSDEVCENTERID");
        dcIdMap.put("PSPFSTYLE", "PSDEVCENTERID");
        dcIdMap.put("PSSFSTYLEPARAM", "PSDEVCENTERID");
        dcIdMap.put("PSDEVSLNSYSBAK", "PSDEVCENTERID");
        dcIdMap.put("PSDEVCENTERFILE", "PSDEVCENTERID");
        dcIdMap.put("PSSTUDIOPLUGIN", "PSDEVCENTERID");
        dcIdMap.put("PSWPDCWORKFLOW", "PSDEVCENTERID");
        dcIdMap.put("PSDCSVNBK", "PSDEVCENTERID");
        dcIdMap.put("PSDCSYNCDATA", "PSDEVCENTERID");
        dcIdMap.put("PSSFPKGVER", "PSDCID");
        dcIdMap.put("PSWSBOOKINGLOG", "PSDEVCENTERID");
        dcIdMap.put("PSASBOOKING", "PSDEVCENTERID");
        dcIdMap.put("PSDSBOOKINGLOG", "PSDEVCENTERID");
        dcIdMap.put("PSDEVCENTERAS", "PSDEVCENTERID");
        dcIdMap.put("PSDCRESHOURS", "PSDEVCENTERID");
        dcIdMap.put("PSDCROBOTABILITY", "PSDEVCENTERID");
        dcIdMap.put("PSDCSYSRES", "PSDEVCENTERID");
        dcIdMap.put("PSDCDEPLOYCENTER", "PSDEVCENTERID");
        dcIdMap.put("PSDCDEPLOYSERVER", "PSDEVCENTERID");
        dcIdMap.put("PSHELPSECTIONTEMPL", "PSDEVCENTERID");
        dcIdMap.put("PSDCREGISTRYREPO", "PSDEVCENTERID");
        dcIdMap.put("PSSFSTYLE", "PSDEVCENTERID");
        dcIdMap.put("PSDCMOBAPPTESTDEVICE", "PSDEVCENTERID");
        dcIdMap.put("PSPFPKG", "PSDCID");
        dcIdMap.put("PSPFCDN", "PSDEVCENTERID");
        dcIdMap.put("PSDBVALUEFUNC", "PSDEVCENTERID");
        dcIdMap.put("PSSYSENGINECFG", "PSDEVCENTERID");
        dcIdMap.put("PSMODELIMPORT", "PSDEVCENTERID");
        dcIdMap.put("PSSAASSYS", "PSDEVCENTERID");
        dcIdMap.put("PSDCSFPKG", "PSDEVCENTERID");
        dcIdMap.put("PSDSBOOKING", "PSDEVCENTERID");
        dcIdMap.put("PSDCSYSMODELREPO", "PSDEVCENTERID");
        dcIdMap.put("PSDCPFPLUGIN", "PSDEVCENTERID");
        dcIdMap.put("PSWSBOOKING", "PSDEVCENTERID");
        dcIdMap.put("PSDCMAVENREPO", "PSDEVCENTERID");
        dcIdMap.put("PSDCSEARCHENGINEINST", "PSDEVCENTERID");
        dcIdMap.put("PSWPDCENGINEINST", "PSDEVCENTERID");
        dcIdMap.put("PSDCBKTASK", "PSDEVCENTERID");
        dcIdMap.put("PSSTUDIOPLUGINDATA", "PSDEVCENTERID");
        dcIdMap.put("PSDCSERVERSTATE", "PSDEVCENTERID");
        dcIdMap.put("PSDEVCENTERRES", "PSDEVCENTERID");
        dcIdMap.put("PSDCSYSINSTACTION", "PSDEVCENTERID");
        dcIdMap.put("PSSTUDIOTHEME", "PSDEVCENTERID");
        dcIdMap.put("PSASBOOKINGLOG", "PSDEVCENTERID");
        dcIdMap.put("PSDEVCENTERDBINST", "PSDEVCENTERID");
        dcIdMap.put("PSSFSTYLEVER", "PSDEVCENTERID");
        dcIdMap.put("PSPFPLUGIN", "PSDCID");
        dcIdMap.put("PSWPDCAPPENTITY", "PSDEVCENTERID");
        dcIdMap.put("PSSFPKG", "PSDCID");
        dcIdMap.put("PSHELPPRJTEMPL", "PSDEVCENTERID");
        dcIdMap.put("PSDEVCENTERTS", "PSDEVCENTERID");
        dcIdMap.put("PSDEVCENTERSF", "PSDEVCENTERID");
        dcIdMap.put("PSWPDCAPPINST", "PSDEVCENTERID");
        dcIdMap.put("PSDEPSLN", "PSDEVCENTERID");
        dcIdMap.put("PSVARSAMPLEVALUE", "PSDEVCENTERID");
        dcIdMap.put("PSDCWORKSHOPSERVER", "PSDEVCENTERID");
        dcIdMap.put("PSSYSMODELINST", "PSDEVCENTERID");
        dcIdMap.put("PSDEVUSEROBJ", "PSDEVCENTERID");
        dcIdMap.put("PSDEVSLNSYSLOCKLOG", "PSDEVCENTERID");
        dcIdMap.put("PSSFPLUGIN", "PSDCID");
        dcIdMap.put("PSDEVCENTERLOG", "PSDEVCENTERID");
        dcIdMap.put("PSDCSYNCDATA2", "PSDEVCENTERID");
        dcIdMap.put("PSDCABILITY", "PSDEVCENTERID");
        dcIdMap.put("PSVIEWENGINE", "PSDEVCENTERID");
        dcIdMap.put("PSDCRESREP", "PSDEVCENTERID");
        dcIdMap.put("PSDCMOBPACKCERT", "PSDEVCENTERID");
        dcIdMap.put("PSDCDETEMPL", "PSDEVCENTERID");
        dcIdMap.put("PSDCRESHOURSLOG", "PSDEVCENTERID");
        dcIdMap.put("PSDCNWFLOW", "PSDEVCENTERID");
        dcIdMap.put("PSDEVCENTERSRV", "PSDEVCENTERID");
        dcIdMap.put("PSDCTASKLOG", "PSDEVCENTERID");
        dcIdMap.put("PSDEVSLNSYSKEY", "PSDEVCENTERID");
        dcIdMap.put("PSDEVSLN", "PSDEVCENTERID");
        dcIdMap.put("PSDEVCENTERSERVER", "PSDEVCENTERID");
        dcIdMap.put("PSDEPSLNSYSKEY", "PSDEVCENTERID");
        dcIdMap.put("PSDCCLUSTER", "PSDEVCENTERID");
        dcIdMap.put("PSDCBDINST", "PSDEVCENTERID");
        dcIdMap.put("PSDEVUSERRECENT", "PSDEVCENTERID");
        dcIdMap.put("PSDEVCENTERSVN", "PSDEVCENTERID");
        dcIdMap.put("PSDCFILE", "PSDEVCENTERID");
        dcIdMap.put("PSBKTASKLOG", "PSDEVCENTERID");
        dcIdMap.put("PSUSDCMODULEINST", "PSDEVCENTERID");
        dcIdMap.put("PSDCORGSECTOR", "PSDEVCENTERID");
        dcIdMap.put("PSREGISTRYREPO", "PSDEVCENTERID");
        dcIdMap.put("PSVIEWSTYLE", "PSDCID");
        dcIdMap.put("PSDCBULLETIN", "PSDEVCENTERID");
        dcIdMap.put("PSDCASGROUP", "PSDEVCENTERID");
        dcIdMap.put("PSPFRESOURCE", "PSDEVCENTERID");
        dcIdMap.put("PSDEVCENTERMQ", "PSDEVCENTERID");
        dcIdMap.put("PSHELPARTICLETEMPL", "PSDEVCENTERID");
        dcIdMap.put("PSDCPRODUCT", "PSDEVCENTERID");
        dcIdMap.put("PSDCWORKSPACEACTION", "PSDEVCENTERID");
        dcIdMap.put("PSDCROBOT", "PSDEVCENTERID");
        dcIdMap.put("PSDEVSLNSYSDYNAINST", "PSDEVCENTERID");
        dcIdMap.put("PSDERTAW", "PSDEVCENTERID");
        dcIdMap.put("PSDCMODELTEMPL", "PSDEVCENTERID");
        dcIdMap.put("PSTSCMD", "PSDEVCENTERID");
        dcIdMap.put("PSDCCOREPRDISSUE", "PSDEVCENTERID");
        dcIdMap.put("PSDEVSLNSYSVER", "PSDEVCENTERID");
        dcIdMap.put("PSDCORG", "PSDEVCENTERID");
        dcIdMap.put("PSMAVENREPO", "PSDEVCENTERID");
        dcIdMap.put("PSDCSYSMODELINST", "PSDEVCENTERID");
        dcIdMap.put("PSDCWFENGINEINST", "PSDEVCENTERID");
        dcIdMap.put("PSDCSYSLIC", "PSDEVCENTERID");
        dcIdMap.put("PSDCWORKSPACELOG", "PSDEVCENTERID");
        dcIdMap.put("PSDEPSYS", "PSDEVCENTERID");
        dcIdMap.put("PSDCCODESNIPPET", "PSDEVCENTERID");
        dcIdMap.put("PSDEVSLNSYSPUBLOCK", "PSDEVCENTERID");
        dcIdMap.put("PSPFPKGVERCDN", "PSDEVCENTERID");
        dcIdMap.put("PSGITUSER", "PSDEVCENTERID");
        dcIdMap.put("PSCREDENTIAL", "PSDEVCENTERID");
        v5CallAccessCtrlMap.put("PSWORKSPACE:*", 0);
        v5CallAccessCtrlMap.put("PSDCWORKSPACE:CREATE", 0);
        v5CallAccessCtrlMap.put("PSDCWORKSPACE:REMOVE", 0);
    }

    public RemoteCallPage() {
        this.setMainPage(false);
        this.setOutputDebug(false);
    }

    protected void OnLoad() {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        RemoteCallResult ajaxActionResult = null;
        IWebContext lastWebContext = WebContext.getCurrent();
        try {
            SimpleWebContext simpleWebContext = new SimpleWebContext();
            simpleWebContext.setSessionValue("SRFPERSONID", (Object)"SYSTEM");
            simpleWebContext.setSessionValue("SRFLOGINNAME", (Object)"SYSTEM");
            simpleWebContext.setSessionValue("SRFUSERNAME", (Object)"\u7cfb\u7edf\u5185\u7f6e\u7528\u6237");
            WebContext.setCurrent((IWebContext)simpleWebContext);
            PSCoreSysServiceBase.setCurrentPSDCId(null);
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            ajaxActionResult = this.RemoteCall();
            WebContext.setCurrent((IWebContext)lastWebContext);
        }
        catch (Exception ex) {
            WebContext.setCurrent((IWebContext)lastWebContext);
            ajaxActionResult = new RemoteCallResult();
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(ex.getMessage());
        }
        PSCoreSysServiceBase.setCurrentPSDCId(null);
        PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
        PSCoreSysServiceBase.setCurrentPSSystemId(null);
        if (ajaxActionResult == IGNORERESULT) {
            return;
        }
        this.Output(ajaxActionResult.ToJSONString());
    }

    protected RemoteCallResult RemoteCall() throws Exception {
        RemoteCallResult ajaxActionResult = new RemoteCallResult();
        try {
            if (!this.getPSModelStorage().isLoaded()) {
                ajaxActionResult.setRetCode(1);
                ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u4efb\u52a1\u7cfb\u7edf\u6b63\u5728\u542f\u52a8\uff0c\u8bf7\u7a0d\u5019\u91cd\u8bd5\uff01"));
                return ajaxActionResult;
            }
        }
        catch (Exception ex) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(ex.getMessage());
            return ajaxActionResult;
        }
        String strV5Mode = this.getWebContext().GetParamValue("SRFV5MODE");
        if (StringHelper.Compare((String)strV5Mode, (String)"TRUE", (boolean)true) == 0) {
            return this.doV5Mode();
        }
        this.getWebContext().SetSessionValue("PERSONID", (Object)"SYSTEM");
        this.getWebContext().SetSessionValue("SRFLOGINNAME", (Object)"SYSTEM");
        String strDEId = this.getWebContext().GetParamValue("SRFDEID");
        if (deNameMap.containsKey(strDEId)) {
            strDEId = deNameMap.get(strDEId);
        }
        String strCall = this.getWebContext().GetParamValue("SRFCALL");
        String strRemoteAddr = this.getWebContext().getRemoteAddr();
        if (StringHelper.IsNullOrEmpty((String)strDEId)) {
            if (StringHelper.Compare((String)strCall, (String)"GETSV", (boolean)false) == 0) {
                String strArg = this.getWebContext().GetPostValue("srfarg");
                BaseDataEntity dataEntity = BaseDataEntity.FromJSONString((String)strArg);
                Hashtable totalParamList = dataEntity.getTotalParamList();
                for (Object objKey : totalParamList.keySet()) {
                    Object objValue = this.getWebContext().GetSessionValue(objKey.toString());
                    dataEntity.SetParamValue(objKey.toString(), objValue);
                }
                ajaxActionResult.getItems().add(BaseDataEntity.ToJSONObject((BaseDataEntity)dataEntity, (boolean)true));
                return ajaxActionResult;
            }
            if (StringHelper.Compare((String)strCall, (String)"GETGV", (boolean)false) == 0) {
                String strArg = this.getWebContext().GetPostValue("srfarg");
                BaseDataEntity dataEntity = BaseDataEntity.FromJSONString((String)strArg);
                Hashtable totalParamList = dataEntity.getTotalParamList();
                for (Object objKey : totalParamList.keySet()) {
                    Object objValue = this.getWebContext().GetGlobalValue(objKey.toString());
                    dataEntity.SetParamValue(objKey.toString(), objValue);
                }
                ajaxActionResult.getItems().add(BaseDataEntity.ToJSONObject((BaseDataEntity)dataEntity, (boolean)true));
                return ajaxActionResult;
            }
        } else {
            IDEDataCtrl iDEDataCtrl = this.GetDEDataCtrl(strDEId);
            if (iDEDataCtrl == null) {
                ajaxActionResult.setRetCode(1);
                ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)strDEId));
                return ajaxActionResult;
            }
            if (StringHelper.Compare((String)strCall, (String)"SAVE", (boolean)false) == 0) {
                boolean bInsert = StringHelper.Compare((String)this.getWebContext().GetPostValue("srfarg"), (String)"TRUE", (boolean)true) == 0;
                String strActionMode = this.getWebContext().GetPostValue("srfarg2");
                String strArg3 = this.getWebContext().GetPostValue("srfarg3");
                BaseDataEntity dataEntity = BaseDataEntity.FromJSONString((String)strArg3);
                CallResult callResult = iDEDataCtrl.Save(bInsert, strActionMode, dataEntity);
                ajaxActionResult.From(callResult);
                if (callResult.IsError()) {
                    return ajaxActionResult;
                }
                ajaxActionResult.getItems().add(BaseDataEntity.ToJSONObject((BaseDataEntity)dataEntity, (boolean)true));
                return ajaxActionResult;
            }
            if (StringHelper.Compare((String)strCall, (String)"REMOVE", (boolean)false) == 0) {
                String strActionMode = this.getWebContext().GetPostValue("srfarg");
                String strArg2 = this.getWebContext().GetPostValue("srfarg2");
                BaseDataEntity dataEntity = BaseDataEntity.FromJSONString((String)strArg2);
                CallResult callResult = iDEDataCtrl.Remove(strActionMode, dataEntity);
                ajaxActionResult.From(callResult);
                if (callResult.IsError()) {
                    return ajaxActionResult;
                }
                return ajaxActionResult;
            }
            if (StringHelper.Compare((String)strCall, (String)"CUSTOMCALL", (boolean)false) == 0) {
                String strActionMode = this.getWebContext().GetPostValue("srfarg");
                String strArg2 = this.getWebContext().GetPostValue("srfarg2");
                if (StringHelper.IsNullOrEmpty((String)strActionMode)) {
                    strActionMode = this.getWebContext().GetParamValue("SRFARG");
                }
                if (StringHelper.IsNullOrEmpty((String)strArg2) && !StringHelper.IsNullOrEmpty((String)(strArg2 = this.getWebContext().GetParamValue("SRFARG2"))) && strArg2.indexOf("{") != 0) {
                    JSONObject jo = new JSONObject();
                    jo.put(iDEDataCtrl.GetDEHelper().getKeyDEFHelper().getName(), (Object)strArg2);
                    strArg2 = jo.toString();
                }
                BaseDataEntity dataEntity = BaseDataEntity.FromJSONString((String)strArg2);
                String strUserId = dataEntity.getParamStringValue("SRF_PERSONID", "");
                String strLoginName = dataEntity.getParamStringValue("SRF_LOGINNAME", "");
                String strPersonName = dataEntity.getParamStringValue("SRF_PERSONNAME", "");
                strRemoteAddr = dataEntity.getParamStringValue("SRF_IPADDR", "");
                StringHelper.IsNullOrEmpty((String)strUserId);
                if (!StringHelper.IsNullOrEmpty((String)strLoginName)) {
                    WebContext.getCurrent().setSessionValue("SRFLOGINNAME", (Object)strLoginName);
                }
                if (!StringHelper.IsNullOrEmpty((String)strPersonName)) {
                    WebContext.getCurrent().setSessionValue("SRFUSERNAME", (Object)strPersonName);
                }
                if (!StringHelper.IsNullOrEmpty((String)strRemoteAddr)) {
                    WebContext.getCurrent().setSessionValue("SRFREALREMOTEADDR", (Object)strRemoteAddr);
                }
                CallResult callResult = iDEDataCtrl.CustomCall(strActionMode, dataEntity);
                ajaxActionResult.From(callResult);
                if (callResult.IsError()) {
                    return ajaxActionResult;
                }
                ajaxActionResult.getItems().add(BaseDataEntity.ToJSONObject((BaseDataEntity)dataEntity, (boolean)true));
                return ajaxActionResult;
            }
            if (StringHelper.Compare((String)strCall, (String)"GET", (boolean)false) == 0) {
                String strArg = this.getWebContext().GetPostValue("srfarg");
                BaseDataEntity dataEntity = BaseDataEntity.FromString((String)strArg);
                CallResult callResult = iDEDataCtrl.Get(dataEntity);
                ajaxActionResult.From(callResult);
                if (callResult.IsError()) {
                    return ajaxActionResult;
                }
                ajaxActionResult.getItems().add(BaseDataEntity.ToJSONObject((BaseDataEntity)dataEntity, (boolean)true));
                return ajaxActionResult;
            }
            if (StringHelper.Compare((String)strCall, (String)"SELECT", (boolean)false) == 0) {
                Vector list = new Vector();
                String strArg = this.getWebContext().GetPostValue("srfarg");
                if (StringHelper.IsNullOrEmpty((String)strArg)) {
                    strArg = this.getWebContext().GetParamValue("SRFARG");
                }
                BaseDataEntity dataEntity = null;
                if (StringHelper.IsNullOrEmpty((String)strArg)) {
                    strArg = "{}";
                }
                dataEntity = strArg.indexOf("{") == 0 ? BaseDataEntity.FromJSONString((String)strArg) : BaseDataEntity.FromString((String)strArg);
                CallResult callResult = iDEDataCtrl.Select(dataEntity, list);
                ajaxActionResult.From(callResult);
                if (callResult.IsError()) {
                    return ajaxActionResult;
                }
                for (BaseDataEntity item : list) {
                    ajaxActionResult.getItems().add(BaseDataEntity.ToJSONObject((BaseDataEntity)item, (boolean)true));
                }
                return ajaxActionResult;
            }
            if (StringHelper.Compare((String)strCall, (String)"SELECT1", (boolean)false) == 0) {
                String strArg = this.getWebContext().GetPostValue("srfarg");
                BaseDataEntity dataEntity = BaseDataEntity.FromString((String)strArg);
                if (dataEntity == null) {
                    dataEntity = new BaseDataEntity();
                }
                CallResult callResult = iDEDataCtrl.Select(dataEntity);
                ajaxActionResult.From(callResult);
                if (callResult.IsError()) {
                    return ajaxActionResult;
                }
                ajaxActionResult.getItems().add(BaseDataEntity.ToJSONObject((BaseDataEntity)dataEntity, (boolean)true));
                return ajaxActionResult;
            }
            if (StringHelper.Compare((String)strCall, (String)"SELECTEX", (boolean)false) == 0) {
                Vector list = new Vector();
                String strActionMode = this.getWebContext().GetPostValue("srfarg");
                String strArg2 = this.getWebContext().GetPostValue("srfarg2");
                BaseDataEntity dataEntity = BaseDataEntity.FromString((String)strArg2);
                if (dataEntity == null) {
                    dataEntity = new BaseDataEntity();
                }
                CallResult callResult = iDEDataCtrl.Select(strActionMode, dataEntity, list);
                ajaxActionResult.From(callResult);
                if (callResult.IsError()) {
                    return ajaxActionResult;
                }
                for (BaseDataEntity item : list) {
                    ajaxActionResult.getItems().add(BaseDataEntity.ToJSONObject((BaseDataEntity)item, (boolean)true));
                }
                return ajaxActionResult;
            }
            if (StringHelper.Compare((String)strCall, (String)"GETDEFAULT", (boolean)false) == 0) {
                String strArg = this.getWebContext().GetPostValue("srfarg");
                BaseDataEntity dataEntity = BaseDataEntity.FromString((String)strArg);
                CallResult callResult = iDEDataCtrl.GetDefault((ISRFDAWebContext)this.getWebContext(), dataEntity);
                ajaxActionResult.From(callResult);
                if (callResult.IsError()) {
                    return ajaxActionResult;
                }
                ajaxActionResult.getItems().add(BaseDataEntity.ToJSONObject((BaseDataEntity)dataEntity, (boolean)true));
                return ajaxActionResult;
            }
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8fdc\u7a0b\u8c03\u7528[%1$s]", (Object)strCall));
    }

    protected RemoteCallResult doV5Mode() throws Exception {
        RemoteCallResult ajaxActionResult = new RemoteCallResult();
        String strUserId = this.getWebContext().GetParamValue("SRFUSERID");
        String strUserName = this.getWebContext().GetParamValue("SRFUSERNAME");
        if (!StringHelper.IsNullOrEmpty((String)strUserName)) {
            strUserName = URLDecoder.decode(strUserName, "UTF-8");
        }
        String strLoginName = this.getWebContext().GetParamValue("SRFLOGINNAME");
        String strDCId = this.getWebContext().GetParamValue("SRFDCID");
        String strDCName = this.getWebContext().GetParamValue("SRFDCNAME");
        if (!StringHelper.IsNullOrEmpty((String)strDCName)) {
            strDCName = URLDecoder.decode(strDCName, "UTF-8");
        }
        if (StringHelper.IsNullOrEmpty((String)strUserId)) {
            strUserId = "SYSTEM";
        }
        if (StringHelper.IsNullOrEmpty((String)strUserName)) {
            strUserName = strUserId;
        }
        SimpleWebContext simpleWebContext = new SimpleWebContext();
        simpleWebContext.setSessionValue("SRFPERSONID", (Object)strUserId);
        simpleWebContext.setSessionValue("SRFUSERID", (Object)strUserId);
        simpleWebContext.setSessionValue("SRFLOGINNAME", (Object)strLoginName);
        simpleWebContext.setSessionValue("SRFUSERNAME", (Object)strUserName);
        simpleWebContext.setSessionValue("SRFORGID", (Object)strDCId);
        simpleWebContext.setSessionValue("SRFORGNAME", (Object)strDCName);
        WebContext.setCurrent((IWebContext)simpleWebContext);
        JSONObject appdataJO = new JSONObject();
        appdataJO.put("psdevcenterid", (Object)strDCId);
        appdataJO.put("psdevcentername", (Object)strDCName);
        WebContext.setAppData((JSONObject)appdataJO);
        PSCoreSysServiceBase.setCurrentPSDCId((String)strDCId);
        PSCoreSysServiceBase.setThreadCurDCLimit((boolean)true);
        boolean bSimpleImportExportMode = PSCoreSysServiceBase.isSimpleImportExportMode();
        try {
            String strDCIdFieldName;
            IPSCoreSysService iService;
            IDataEntityModel iDataEntityModel;
            PSCoreSysServiceBase.setSimpleImportExportMode((Boolean)true);
            String strBody = this.getBody();
            String strDEId = this.getWebContext().GetParamValue("SRFDEID");
            String strCall = this.getWebContext().GetParamValue("SRFCALL");
            if (StringHelper.IsNullOrEmpty((String)strCall)) {
                throw new Exception("\u672a\u6307\u5b9a\u8c03\u7528\u64cd\u4f5c");
            }
            String strAccessTag = String.format("%1$s:%2$s", strDEId, strCall = strCall.toUpperCase()).toUpperCase();
            Integer nCtrl = v5CallAccessCtrlMap.get(strAccessTag);
            if (nCtrl == null ? (nCtrl = v5CallAccessCtrlMap.get(strAccessTag = String.format("%1$s:*", strDEId).toUpperCase())) != null && nCtrl == 0 : nCtrl == 0) {
                throw new Exception("\u8bbf\u95ee\u62d2\u7edd");
            }
            if (StringHelper.IsNullOrEmpty((String)strBody)) {
                strBody = "{}";
            }
            Map map = (Map)MAPPER.readValue(strBody, Map.class);
            if (DEID_PSSYSDEVUSERUSERGLOBAL.equalsIgnoreCase(strDEId)) {
                ObjectNode retNode = MAPPER.createObjectNode();
                retNode.put("ret", 0);
                if (CALL_PSSYSDEVUSERUSERGLOBAL_GETPSSYSDEVUSERBYSLN.equalsIgnoreCase(strCall)) {
                    String strPSDevSlnId = (String)map.get("psdevslnid");
                    IPSSysDevUser iPSSysDevUser = PSSysDevUserUserGlobal.getPSSysDevUserBySln((IWebContext)simpleWebContext, (String)strPSDevSlnId);
                    retNode.put("item", (JsonNode)MAPPER.convertValue((Object)iPSSysDevUser, ObjectNode.class));
                } else if (CALL_PSSYSDEVUSERUSERGLOBAL_GETPSSYSDEVUSERBYSYS.equalsIgnoreCase(strCall)) {
                    String strPSDevSlnSysId = (String)map.get("psdevslnsysid");
                    IPSSysDevUser iPSSysDevUser = PSSysDevUserUserGlobal.getPSSysDevUserBySys((IWebContext)simpleWebContext, (String)strPSDevSlnSysId);
                    retNode.put("item", (JsonNode)MAPPER.convertValue((Object)iPSSysDevUser, ObjectNode.class));
                } else if (CALL_PSSYSDEVUSERUSERGLOBAL_GETPSSYSDEVUSERBYTEMPL.equalsIgnoreCase(strCall)) {
                    String strPSDevSlnTemplId = (String)map.get("psdevslntemplid");
                    IPSSysDevUser iPSSysDevUser = PSSysDevUserUserGlobal.getPSSysDevUserByTempl((IWebContext)simpleWebContext, (String)strPSDevSlnTemplId);
                    retNode.put("item", (JsonNode)MAPPER.convertValue((Object)iPSSysDevUser, ObjectNode.class));
                } else {
                    throw new Exception(String.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u64cd\u4f5c[%1$s]", strCall));
                }
                this.Output(MAPPER.writeValueAsString((Object)retNode));
                RemoteCallResult remoteCallResult = IGNORERESULT;
                return remoteCallResult;
            }
            SessionFactory sessionFactory = null;
            String strPSDevSlnSysId = this.getWebContext().GetParamValue("SRFPSDEVSLNSYSID");
            if (!StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId)) {
                iDataEntityModel = DEModelGlobal.getDEModel((String)"PSDEVSLNSYS");
                iService = (IPSCoreSysService)iDataEntityModel.getService(PSCoreSysServiceBase.getCurMajorSessionFactory());
                PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
                psDevSlnSys.setPSDevSlnSysId(strPSDevSlnSysId);
                iService.get((IEntity)psDevSlnSys);
                sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)psDevSlnSys.getPSSysModelInstId());
                PSCoreSysServiceBase.setCurrentPSDevSlnSysId((String)strPSDevSlnSysId);
                PSCoreSysServiceBase.setCurrentPSSystemId((String)psDevSlnSys.getPSSystemId());
            }
            iDataEntityModel = DEModelGlobal.getDEModel((String)strDEId);
            iService = (IPSCoreSysService)iDataEntityModel.getService(sessionFactory != null ? sessionFactory : PSCoreSysServiceBase.getCurMajorSessionFactory());
            if (strCall.indexOf("FETCH") == 0) {
                DEDataSetCond cond;
                Object srfparentdename = map.get("srfparentdename");
                Object srfparentkey = map.get("srfparentkey");
                if (srfparentdename instanceof String && srfparentkey instanceof String) {
                    String strParentKeyName;
                    IDataEntityModel parentDataEntityModel;
                    String strParentDEName = (String)srfparentdename;
                    String strParentKey = (String)srfparentkey;
                    if (!(StringHelper.IsNullOrEmpty((String)strParentDEName) || StringHelper.IsNullOrEmpty((String)strParentKey) || strParentDEName.equalsIgnoreCase("PSDEVCENTER") || (parentDataEntityModel = DEModelGlobal.getDEModel((String)strParentDEName.toUpperCase(), (boolean)true)) == null || appdataJO.has(strParentKeyName = parentDataEntityModel.getKeyDEField().getName().toLowerCase()))) {
                        appdataJO.put(strParentKeyName, (Object)strParentKey);
                    }
                }
                DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(WebContext.getCurrent());
                deDataSetFetchContextImpl.setSessionFactory(PSCoreSysServiceBase.getCurMajorSessionFactory());
                deDataSetFetchContextImpl.setPageSize(DataTypeHelper.getIntegerValue(map.get("size"), (Integer)20).intValue());
                int nPage = DataTypeHelper.getIntegerValue(map.get("page"), (Integer)0);
                deDataSetFetchContextImpl.setStartRow(nPage * deDataSetFetchContextImpl.getPageSize());
                String strSort = (String)map.get("sort");
                if (!StringHelper.IsNullOrEmpty((String)strSort)) {
                    String[] items = strSort.split("[,]");
                    deDataSetFetchContextImpl.setSort(items[0]);
                    if (items.length > 1) {
                        deDataSetFetchContextImpl.setSortDir(items[1]);
                    }
                }
                if ((cond = RemoteCallPage.getDEDataSetCond(map, true, map)) != null) {
                    deDataSetFetchContextImpl.getConditionList().add(cond);
                }
                DBFetchResult fetchResult = iService.fetchDataSet(strCall.substring(5), (IDEDataSetFetchContext)deDataSetFetchContextImpl);
                ObjectNode retNode = MAPPER.createObjectNode();
                retNode.put("ret", 0);
                retNode.put("total", fetchResult.getTotalRow());
                retNode.put("start", deDataSetFetchContextImpl.getStartRow());
                retNode.put("size", deDataSetFetchContextImpl.getPageSize());
                ArrayNode itemsNode = retNode.putArray("items");
                IDataTable dt = fetchResult.getDataSet().getDataTable(0);
                if (dt.getCachedRowCount() == -1) {
                    IDataRow iDataRow;
                    while ((iDataRow = dt.next()) != null) {
                        LinkedHashMap<String, Object> iDataObject = new LinkedHashMap<String, Object>();
                        RemoteCallPage.fromDataRow(iDataObject, iDataRow);
                        iService.translate(iDataObject);
                        itemsNode.add((JsonNode)MAPPER.convertValue(iDataObject, ObjectNode.class));
                    }
                } else {
                    int nRows = dt.getCachedRowCount();
                    int i = 0;
                    while (i < nRows) {
                        IDataRow iDataRow = dt.getCachedRow(i);
                        LinkedHashMap<String, Object> iDataObject = new LinkedHashMap<String, Object>();
                        RemoteCallPage.fromDataRow(iDataObject, iDataRow);
                        iService.translate(iDataObject);
                        itemsNode.add((JsonNode)MAPPER.convertValue(iDataObject, ObjectNode.class));
                        ++i;
                    }
                }
                this.Output(MAPPER.writeValueAsString((Object)retNode));
                RemoteCallResult remoteCallResult = IGNORERESULT;
                return remoteCallResult;
            }
            IEntity iEntity = iDataEntityModel.createEntity();
            for (Map.Entry entry : map.entrySet()) {
                iEntity.set((String)entry.getKey(), entry.getValue());
            }
            if (ACTION_EXPORTMODELV2.equalsIgnoreCase(strCall)) {
                iService.get(iEntity);
                ObjectNode retNode = MAPPER.createObjectNode();
                retNode.put("ret", 0);
                retNode.set("item", (JsonNode)((IPSModelV2Service)iService).exportModelV2(iEntity));
                this.Output(MAPPER.writeValueAsString((Object)retNode));
                RemoteCallResult remoteCallResult = IGNORERESULT;
                return remoteCallResult;
            }
            if (ACTION_IMPORTMODELV2.equalsIgnoreCase(strCall)) {
                Object model = iEntity.get("model");
                if (model == null) {
                    throw new Exception("\u672a\u4f20\u5165\u5bfc\u5165\u6a21\u578b");
                }
                iEntity.remove("model");
                ObjectNode modelNode = (ObjectNode)MAPPER.convertValue(model, ObjectNode.class);
                String strModelV2Scope = DataObject.getStringValue((Object)iEntity.get("SRFMODELV2SCOPE"));
                if (!StringHelper.IsNullOrEmpty((String)strModelV2Scope)) {
                    String[] items = strModelV2Scope.split("[#]");
                    IEntity iEntity2 = iDataEntityModel.createEntity();
                    String strValue = String.format("<%1$s>", items[0]);
                    ((IPSModelV2Service)iService).setModelV2ResScope(iEntity2, items[0], strValue);
                    HashMap params = new HashMap();
                    iEntity2.fillMap(params);
                    for (Map.Entry entry : params.entrySet()) {
                        if (!strValue.equals(entry.getValue())) continue;
                        modelNode.put(((String)entry.getKey()).toLowerCase(), strValue);
                        break;
                    }
                }
                ((IPSModelV2Service)iService).importModelV2(iEntity, modelNode);
                ObjectNode retNode = MAPPER.createObjectNode();
                retNode.put("ret", 0);
                DataObject dataObject = new DataObject();
                iEntity.copyTo((IDataObject)dataObject, false, false);
                LinkedHashMap map2 = new LinkedHashMap();
                dataObject.fillMap(map2);
                iService.translate(map2);
                retNode.put("item", (JsonNode)MAPPER.convertValue(map2, ObjectNode.class));
                this.Output(MAPPER.writeValueAsString((Object)retNode));
                RemoteCallResult remoteCallResult = IGNORERESULT;
                return remoteCallResult;
            }
            if ("CREATE".equalsIgnoreCase(strCall) && !StringHelper.IsNullOrEmpty((String)strDCId) && !StringHelper.IsNullOrEmpty((String)(strDCIdFieldName = dcIdMap.get(iDataEntityModel.getName())))) {
                iEntity.set(strDCIdFieldName, (Object)strDCId);
            }
            if ("CREATE".equalsIgnoreCase(strCall) || "UPDATE".equalsIgnoreCase(strCall)) {
                boolean bUpdate = "UPDATE".equalsIgnoreCase(strCall);
                Iterator deFields = iService.getDEModel().getDEFields();
                if (deFields != null) {
                    while (deFields.hasNext()) {
                        IPSDEFieldModel iPSDEFieldModel = (IPSDEFieldModel)deFields.next();
                        if (iPSDEFieldModel.isKeyDEField()) continue;
                        int nUserInputMode = iPSDEFieldModel.getUserInputMode();
                        if (bUpdate && (nUserInputMode & 2) == 0) {
                            iEntity.remove(iPSDEFieldModel.getName());
                            continue;
                        }
                        if (bUpdate || (nUserInputMode & 1) != 0) continue;
                        iEntity.remove(iPSDEFieldModel.getName());
                    }
                }
            }
            iService.executeAction(strCall, iEntity);
            ObjectNode retNode = MAPPER.createObjectNode();
            retNode.put("ret", 0);
            DataObject dataObject = new DataObject();
            iEntity.copyTo((IDataObject)dataObject, false, false);
            LinkedHashMap<String, Integer> map2 = new LinkedHashMap<String, Integer>();
            dataObject.fillMap(map2);
            iService.translate(map2);
            if (iDataEntityModel.getName().equals("PSDEVSLNSYS") && "GET".equalsIgnoreCase(strCall)) {
                map2.put("activemodelinstver", Version.MODEL);
            }
            retNode.put("item", (JsonNode)MAPPER.convertValue(map2, ObjectNode.class));
            this.Output(MAPPER.writeValueAsString((Object)retNode));
            RemoteCallResult remoteCallResult = IGNORERESULT;
            return remoteCallResult;
        }
        catch (Throwable ex) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(ex.getMessage());
            RemoteCallResult remoteCallResult = ajaxActionResult;
            return remoteCallResult;
        }
        finally {
            PSCoreSysServiceBase.setThreadCurDCLimit((boolean)false);
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            PSCoreSysServiceBase.setSimpleImportExportMode((Boolean)bSimpleImportExportMode);
        }
    }

    protected String getBody() throws Exception {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader((InputStream)this.getWebContext().getPage().getRequest().getInputStream(), "UTF-8"));
        }
        catch (IOException e) {
            log.error((Object)e);
            throw e;
        }
        String line = null;
        StringBuilder sb = new StringBuilder();
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
        catch (IOException e) {
            log.error((Object)e);
            throw e;
        }
        return sb.toString();
    }

    public static DEDataSetCond getDEDataSetCond(Map<String, Object> map, boolean bIgnoreEmtpyGroup, Map<String, Object> params) {
        Object objSearchConds = map.remove("searchconds");
        map.remove("condtype");
        DEDataSetCond searchGroupCond = new DEDataSetCond();
        searchGroupCond.setCondType(CONDTYPE_GROUP);
        String strCondOp = (String)map.remove("condop");
        if (StringHelper.IsNullOrEmpty((String)strCondOp)) {
            searchGroupCond.setCondOp("AND");
        } else {
            searchGroupCond.setCondOp(strCondOp);
        }
        Boolean bNotMode = (Boolean)map.remove("notmode");
        if (bNotMode != null) {
            searchGroupCond.setNotMode(bNotMode.booleanValue());
        }
        if (objSearchConds instanceof List) {
            List list = (List)objSearchConds;
            for (Object objItem : list) {
                DEDataSetCond childGroup;
                if (!(objItem instanceof Map)) continue;
                Map child = (Map)objItem;
                String strType = (String)child.remove("condtype");
                if (CONDTYPE_DEFIELD.equalsIgnoreCase(strType)) {
                    DEDataSetCond searchFieldCond = new DEDataSetCond();
                    searchFieldCond.setCondType(CONDTYPE_DEFIELD);
                    String strFieldName = (String)child.remove("fieldname");
                    String strChildOp = (String)child.remove("condop");
                    Object objParamMode = child.remove("parammode");
                    Object objValue = child.remove("value");
                    if (objParamMode != null && objParamMode.toString().equalsIgnoreCase("true") && objValue != null) {
                        objValue = params.get(objValue.toString());
                    }
                    searchFieldCond.setDEFName(strFieldName);
                    searchFieldCond.setCondOp(strChildOp);
                    if (objValue != null) {
                        searchFieldCond.setCondValue(objValue.toString());
                    }
                    searchGroupCond.addChildDEDataQueryCond((IDEDataQueryCodeCond)searchFieldCond);
                    continue;
                }
                if (!CONDTYPE_GROUP.equalsIgnoreCase(strType) || (childGroup = RemoteCallPage.getDEDataSetCond(child, bIgnoreEmtpyGroup, params)) == null) continue;
                searchGroupCond.addChildDEDataQueryCond((IDEDataQueryCodeCond)childGroup);
            }
        }
        if (bIgnoreEmtpyGroup && (searchGroupCond.getChildDEDataQueryConds() == null || !searchGroupCond.getChildDEDataQueryConds().hasNext())) {
            return null;
        }
        return searchGroupCond;
    }

    public static void fromDataRow(Map<String, Object> iDataObject, IDataRow dr) throws Exception {
        IDataTable dataTable = dr.getDataTable();
        if (dataTable != null) {
            int nColumnCount = dataTable.getColumnCount();
            int i = 0;
            while (i < nColumnCount) {
                IDataColumn dataColumn = dataTable.getDataColumn(i);
                if (dr.isDBNull(i)) {
                    iDataObject.put(dataColumn.getName().toLowerCase(), null);
                } else {
                    iDataObject.put(dataColumn.getName().toLowerCase(), dr.get(i));
                }
                ++i;
            }
        } else {
            throw new Exception("\u65e0\u6548\u7684\u884c\u6570\u636e\u5bf9\u8c61");
        }
    }

    public static void translate(Map<String, Object> map, String strDEName) throws Exception {
    }
}

