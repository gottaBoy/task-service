/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.IPSCoreSysService
 *  net.ibizsys.pscore.srv.IPSRawSelectWork
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemService
 *  net.ibizsys.pscore.srv.util.PSModelV2Helper
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  net.ibizsys.pscore.srv.util.modelinst.PSDBServerSessionFactoryImpl
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.Util;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.IPSCoreSysService;
import net.ibizsys.pscore.srv.IPSRawSelectWork;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.ibizsys.pscore.srv.util.modelinst.PSDBServerSessionFactoryImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDBServerBackupHelper {
    private static final Log log = LogFactory.getLog(PSDBServerBackupHelper.class);

    protected Map<String, String> getBackupDataMap() throws Exception {
        HashMap<String, String> dataMap = new HashMap<String, String>();
        dataMap.put("FILE", "");
        dataMap.put("PSACHANDLER", "");
        dataMap.put("PSACHANDLERACTION", "");
        dataMap.put("PSAMITEMTYPE", "");
        dataMap.put("PSAPPCTRLSTYLE", "");
        dataMap.put("PSAPPDERS", "");
        dataMap.put("PSAPPDERSVIEW", "");
        dataMap.put("PSAPPDEVIEW", "");
        dataMap.put("PSAPPDEVIEWREF", "");
        dataMap.put("PSAPPDYNADEVIEW", "");
        dataMap.put("PSAPPEDITORTEMPL", "");
        dataMap.put("PSAPPFUNC", "");
        dataMap.put("PSAPPFUNCTYPE", "");
        dataMap.put("PSAPPINDEXVIEW", "");
        dataMap.put("PSAPPLAN", "");
        dataMap.put("PSAPPLOCALDE", "");
        dataMap.put("PSAPPMENU", "");
        dataMap.put("PSAPPMENUITEM", "");
        dataMap.put("PSAPPMODULE", "");
        dataMap.put("PSAPPPANELVIEW", "");
        dataMap.put("PSAPPPDTVIEW", "");
        dataMap.put("PSAPPPKG", "");
        dataMap.put("PSAPPPORTALVIEW", "");
        dataMap.put("PSAPPPVPART", "");
        dataMap.put("PSAPPSERVER", "");
        dataMap.put("PSAPPSUBAPP", "");
        dataMap.put("PSAPPTITLEBAR", "");
        dataMap.put("PSAPPTYPE", "");
        dataMap.put("PSAPPUISTYLE", "");
        dataMap.put("PSAPPUITHEME", "");
        dataMap.put("PSAPPUSERMODE", "");
        dataMap.put("PSAPPUTIL", "");
        dataMap.put("PSAPPUTILPAGE", "");
        dataMap.put("PSAPPUTILVIEW", "");
        dataMap.put("PSAPPVIEWCODE", "");
        dataMap.put("PSAPPVIEWLOGIC", "");
        dataMap.put("PSAPPVIEWREF", "");
        dataMap.put("PSAPPVIEWSTYLE", "");
        dataMap.put("PSAPPVIEWTEMPL", "");
        dataMap.put("PSAPPWF", "");
        dataMap.put("PSAPPWFVER", "");
        dataMap.put("PSASBOOKING", "");
        dataMap.put("PSASBOOKINGLOG", "");
        dataMap.put("PSASGROUP", "");
        dataMap.put("PSASTYPE", "");
        dataMap.put("PSBACKSERVICE", "");
        dataMap.put("PSBDDEVINST", "");
        dataMap.put("PSBDSERVER", "");
        dataMap.put("PSBDTYPE", "");
        dataMap.put("PSBKTASKLOG", "");
        dataMap.put("PSBOOKINGRESTYPE", "");
        dataMap.put("PSCHARTTYPE", "");
        dataMap.put("PSCODEITEM", "");
        dataMap.put("PSCODELIST", "");
        dataMap.put("PSCODELISTTEMPL", "");
        dataMap.put("PSCODENAME", "");
        dataMap.put("PSCODEPREVIEWACTION", "");
        dataMap.put("PSCODESERVERACTION", "");
        dataMap.put("PSCODESNIPPETTYPE", "");
        dataMap.put("PSCONSOLESERVER", "");
        dataMap.put("PSCOREPRD", "");
        dataMap.put("PSCOREPRDCAT", "");
        dataMap.put("PSCOREPRDFUNC", "");
        dataMap.put("PSCOREPRDINSTLOG", "");
        dataMap.put("PSCOREPRDISSUE", "");
        dataMap.put("PSCOREPRDVER", "");
        dataMap.put("PSCOUNTER", "");
        dataMap.put("PSCOUNTERTYPE", "");
        dataMap.put("PSCOUNTERTYPESF", "");
        dataMap.put("PSCPVFUNC", "");
        dataMap.put("PSCPVISSUE", "");
        dataMap.put("PSCSSCATTEMPL", "");
        dataMap.put("PSCSSTEMPL", "");
        dataMap.put("PSCTRLACTION", "");
        dataMap.put("PSCTRLEVENT", "");
        dataMap.put("PSCTRLMODEL", "");
        dataMap.put("PSCTRLMSG", "");
        dataMap.put("PSCTRLMSGITEM", "");
        dataMap.put("PSCTRLMSGTAG", "");
        dataMap.put("PSCTRLTYPE", "");
        dataMap.put("PSCTRLTYPEACTION", "");
        dataMap.put("PSCTRLTYPEEVENT", "");
        dataMap.put("PSCTRLTYPEMODEL", "");
        dataMap.put("PSCTRLTYPEMSGTAG", "");
        dataMap.put("PSDATAENTITY", "");
        dataMap.put("PSDATASYNCAGENTTYPE", "");
        dataMap.put("PSDBDEVINST", "");
        dataMap.put("PSDBDEVINSTBK", "");
        dataMap.put("PSDBOBJTYPE", "");
        dataMap.put("PSDBPROCPARAM", "");
        dataMap.put("PSDBSERVER", "");
        dataMap.put("PSDBSPPARTTEMPL", "");
        dataMap.put("PSDBSYSPROCTEMPL", "");
        dataMap.put("PSDBSYSPROCTYPE", "");
        dataMap.put("PSDBTYPE", "");
        dataMap.put("PSDBVALUEFUNC", "");
        dataMap.put("PSDBVALUEMODE", "");
        dataMap.put("PSDBVALUEOP", "");
        dataMap.put("PSDBVFCODE", "");
        dataMap.put("PSDCABILITY", "");
        dataMap.put("PSDCASGROUP", "");
        dataMap.put("PSDCBDINST", "");
        dataMap.put("PSDCBKTASK", "");
        dataMap.put("PSDCBKTYPE", "");
        dataMap.put("PSDCBULLETIN", "");
        dataMap.put("PSDCCODESNIPPET", "");
        dataMap.put("PSDCCODESNIPPETREF", "");
        dataMap.put("PSDCCOREPRDISSUE", "");
        dataMap.put("PSDCDBFUNC", "");
        dataMap.put("PSDCDBINDEX", "");
        dataMap.put("PSDCDBINSTBK", "");
        dataMap.put("PSDCDBINSTREF", "");
        dataMap.put("PSDCDBOBJ", "");
        dataMap.put("PSDCDBPROC", "");
        dataMap.put("PSDCDBSEQU", "");
        dataMap.put("PSDCDBTABLE", "");
        dataMap.put("PSDCDBVIEW", "");
        dataMap.put("PSDCDEPLOYCENTER", "");
        dataMap.put("PSDCDEPLOYSERVER", "");
        dataMap.put("PSDCDETEMPL", "");
        dataMap.put("PSDCDETEMPLFIELD", "");
        dataMap.put("PSDCINST", "");
        dataMap.put("PSDCMAVENREPO", "");
        dataMap.put("PSDCMOBAPPTDREF", "");
        dataMap.put("PSDCMOBAPPTESTDEVICE", "");
        dataMap.put("PSDCMOBPACKCERT", "");
        dataMap.put("PSDCMODELTEMPL", "");
        dataMap.put("PSDCMSGACCOUNT", "");
        dataMap.put("PSDCMSPLATFORM", "");
        dataMap.put("PSDCMSPLATFORMFUNC", "");
        dataMap.put("PSDCMSPLATFORMNODE", "");
        dataMap.put("PSDCMTDECAT", "");
        dataMap.put("PSDCMTDEF", "");
        dataMap.put("PSDCNWFLOW", "");
        dataMap.put("PSDCORG", "");
        dataMap.put("PSDCORGSECTOR", "");
        dataMap.put("PSDCORGUSER", "");
        dataMap.put("PSDCPFPITEMPL", "");
        dataMap.put("PSDCPFPLUGIN", "");
        dataMap.put("PSDCPRODUCT", "");
        dataMap.put("PSDCRESHOURS", "");
        dataMap.put("PSDCRESHOURSLOG", "");
        dataMap.put("PSDCRESREP", "");
        dataMap.put("PSDCROBOT", "");
        dataMap.put("PSDCROBOTABILITY", "");
        dataMap.put("PSDCROBOTLOG", "");
        dataMap.put("PSDCRTMSG", "");
        dataMap.put("PSDCSERVER", "");
        dataMap.put("PSDCSERVERSTATE", "");
        dataMap.put("PSDCSFPKG", "");
        dataMap.put("PSDCSFPKGVER", "");
        dataMap.put("PSDCSVNBK", "");
        dataMap.put("PSDCSYNCAGENT", "");
        dataMap.put("PSDCSYNCDATA", "");
        dataMap.put("PSDCSYNCDATA2", "");
        dataMap.put("PSDCSYNCDATATYPE", "");
        dataMap.put("PSDCSYSINSTACTION", "");
        dataMap.put("PSDCSYSLIC", "");
        dataMap.put("PSDCSYSMODELINST", "");
        dataMap.put("PSDCSYSPRDVER", "");
        dataMap.put("PSDCSYSPRODUCT", "");
        dataMap.put("PSDCSYSRES", "");
        dataMap.put("PSDCTASKLOG", "");
        dataMap.put("PSDCWORKSHOPSERVER", "");
        dataMap.put("PSDCWORKSPACE", "");
        dataMap.put("PSDCWORKSPACEACTION", "");
        dataMap.put("PSDCWORKSPACELOG", "");
        dataMap.put("PSDCWORKSPACEUSER", "");
        dataMap.put("PSDEACMODE", "");
        dataMap.put("PSDEACMODEITEM", "");
        dataMap.put("PSDEACTION", "");
        dataMap.put("PSDEACTIONLOGIC", "");
        dataMap.put("PSDEACTIONPARAM", "");
        dataMap.put("PSDEACTIONTEMPL", "");
        dataMap.put("PSDEACTIONTYPE", "");
        dataMap.put("PSDEACTIONWIZARD", "");
        dataMap.put("PSDEAWGROUP", "");
        dataMap.put("PSDEAWGRPDETAIL", "");
        dataMap.put("PSDEAWITEM", "");
        dataMap.put("PSDECHART", "");
        dataMap.put("PSDECHARTAXES", "");
        dataMap.put("PSDECHARTPARAM", "");
        dataMap.put("PSDECTRL", "");
        dataMap.put("PSDEDATAEXP", "");
        dataMap.put("PSDEDATAIMP", "");
        dataMap.put("PSDEDATAIMPITEM", "");
        dataMap.put("PSDEDATAQUERY", "");
        dataMap.put("PSDEDATARELATION", "");
        dataMap.put("PSDEDATASET", "");
        dataMap.put("PSDEDATASYNC", "");
        dataMap.put("PSDEDATAVIEW", "");
        dataMap.put("PSDEDBCFG", "");
        dataMap.put("PSDEDBIDXFIELD", "");
        dataMap.put("PSDEDBINDEX", "");
        dataMap.put("PSDEDBOBJSQL", "");
        dataMap.put("PSDEDQCODE", "");
        dataMap.put("PSDEDQCODECOND", "");
        dataMap.put("PSDEDQCODEEXP", "");
        dataMap.put("PSDEDQCOND", "");
        dataMap.put("PSDEDQJOIN", "");
        dataMap.put("PSDEDQPDCOND", "");
        dataMap.put("PSDEDRDETAIL", "");
        dataMap.put("PSDEDRGROUP", "");
        dataMap.put("PSDEDRITEM", "");
        dataMap.put("PSDEDSCODE", "");
        dataMap.put("PSDEDSDQ", "");
        dataMap.put("PSDEDSGRPPARAM", "");
        dataMap.put("PSDEDSPARAM", "");
        dataMap.put("PSDEDTSQUEUE", "");
        dataMap.put("PSDEDUPRULE", "");
        dataMap.put("PSDEDUPRULEITEM", "");
        dataMap.put("PSDEFDATATYPE", "");
        dataMap.put("PSDEFDLOGIC", "");
        dataMap.put("PSDEFDTCOL", "");
        dataMap.put("PSDEFFORMITEM", "");
        dataMap.put("PSDEFGRIDCOL", "");
        dataMap.put("PSDEFGROUP", "");
        dataMap.put("PSDEFGROUPDETAIL", "");
        dataMap.put("PSDEFIELD", "");
        dataMap.put("PSDEFINPUTTIP", "");
        dataMap.put("PSDEFINPUTTIPSET", "");
        dataMap.put("PSDEFIUDETAIL", "");
        dataMap.put("PSDEFIUPDATE", "");
        dataMap.put("PSDEFIVR", "");
        dataMap.put("PSDEFORM", "");
        dataMap.put("PSDEFORMDETAIL", "");
        dataMap.put("PSDEFORMRF", "");
        dataMap.put("PSDEFSFITEM", "");
        dataMap.put("PSDEFTYPE", "");
        dataMap.put("PSDEFVALUERULE", "");
        dataMap.put("PSDEFVRCODETYPE", "");
        dataMap.put("PSDEFVRCOND", "");
        dataMap.put("PSDEFVRDSPARAM", "");
        dataMap.put("PSDEFVRTYPE", "");
        dataMap.put("PSDEFVRTYPEDETAIL", "");
        dataMap.put("PSDEGCTYPE", "");
        dataMap.put("PSDEGEIUDETAIL", "");
        dataMap.put("PSDEGEIUPDATE", "");
        dataMap.put("PSDEGRID", "");
        dataMap.put("PSDEGRIDCOL", "");
        dataMap.put("PSDEGROUP", "");
        dataMap.put("PSDEGROUPDETAIL", "");
        dataMap.put("PSDEINITCFG", "");
        dataMap.put("PSDEJOINTYPE", "");
        dataMap.put("PSDELIST", "");
        dataMap.put("PSDELISTITEM", "");
        dataMap.put("PSDELLCOND", "");
        dataMap.put("PSDELLCONDTYPE", "");
        dataMap.put("PSDELLTYPE", "");
        dataMap.put("PSDELNPARAM", "");
        dataMap.put("PSDELNTYPE", "");
        dataMap.put("PSDELOGIC", "");
        dataMap.put("PSDELOGICLINK", "");
        dataMap.put("PSDELOGICNODE", "");
        dataMap.put("PSDELOGICPARAM", "");
        dataMap.put("PSDEMAINSTATE", "");
        dataMap.put("PSDEMAINSTATERS", "");
        dataMap.put("PSDEMAP", "");
        dataMap.put("PSDEMAPACTION", "");
        dataMap.put("PSDEMAPDETAIL", "");
        dataMap.put("PSDEMAPDQ", "");
        dataMap.put("PSDEMAPDS", "");
        dataMap.put("PSDEMODEL", "");
        dataMap.put("PSDEMODELCNT", "");
        dataMap.put("PSDEMSACTION", "");
        dataMap.put("PSDEMSOPPRIV", "");
        dataMap.put("PSDEOPPRIV", "");
        dataMap.put("PSDEOPPRIVROLE", "");
        dataMap.put("PSDEPLOYCENTER", "");
        dataMap.put("PSDEPLOYSERVER", "");
        dataMap.put("PSDEPRINT", "");
        dataMap.put("PSDEPSAASSYS", "");
        dataMap.put("PSDEPSAASSYSAPP", "");
        dataMap.put("PSDEPSAASSYSVER", "");
        dataMap.put("PSDEPSLN", "");
        dataMap.put("PSDEPSLNAS", "");
        dataMap.put("PSDEPSLNASGRP", "");
        dataMap.put("PSDEPSLNASITEM", "");
        dataMap.put("PSDEPSLNDBINST", "");
        dataMap.put("PSDEPSLNDEPSESSION", "");
        dataMap.put("PSDEPSLNHOST", "");
        dataMap.put("PSDEPSLNLOG", "");
        dataMap.put("PSDEPSLNMODE", "");
        dataMap.put("PSDEPSLNMODEPRD", "");
        dataMap.put("PSDEPSLNMQINST", "");
        dataMap.put("PSDEPSLNPACK", "");
        dataMap.put("PSDEPSLNPRD", "");
        dataMap.put("PSDEPSLNRUNLOG", "");
        dataMap.put("PSDEPSLNSYS", "");
        dataMap.put("PSDEPSLNSYSAS", "");
        dataMap.put("PSDEPSLNSYSDB", "");
        dataMap.put("PSDEPSLNSYSDYNAINST", "");
        dataMap.put("PSDEPSLNSYSKEY", "");
        dataMap.put("PSDEPSLNSYSMQ", "");
        dataMap.put("PSDEPSLNTYPE", "");
        dataMap.put("PSDEPSLNUSER", "");
        dataMap.put("PSDEPSYS", "");
        dataMap.put("PSDEPSYSAPI", "");
        dataMap.put("PSDEPSYSAPP", "");
        dataMap.put("PSDEPSYSTYPE", "");
        dataMap.put("PSDEPSYSVER", "");
        dataMap.put("PSDEPTOOLTYPE", "");
        dataMap.put("PSDER", "");
        dataMap.put("PSDERDEFMAP", "");
        dataMap.put("PSDEREPITEM", "");
        dataMap.put("PSDEREPORT", "");
        dataMap.put("PSDERGROUP", "");
        dataMap.put("PSDERGROUPDETAIL", "");
        dataMap.put("PSDERTAW", "");
        dataMap.put("PSDERTAWI", "");
        dataMap.put("PSDERTYPE", "");
        dataMap.put("PSDESADETAIL", "");
        dataMap.put("PSDESAMPLEDATA", "");
        dataMap.put("PSDESAMPLEDATAREF", "");
        dataMap.put("PSDESARS", "");
        dataMap.put("PSDESERVICEAPI", "");
        dataMap.put("PSDESPCODE", "");
        dataMap.put("PSDESPCODEPART", "");
        dataMap.put("PSDESPFIELD", "");
        dataMap.put("PSDESYSPROC", "");
        dataMap.put("PSDETABLE", "");
        dataMap.put("PSDETBITEM", "");
        dataMap.put("PSDETOOLBAR", "");
        dataMap.put("PSDETREECOL", "");
        dataMap.put("PSDETREENODE", "");
        dataMap.put("PSDETREENODECOL", "");
        dataMap.put("PSDETREENODERS", "");
        dataMap.put("PSDETREENODERV", "");
        dataMap.put("PSDETREEVIEW", "");
        dataMap.put("PSDEUAGROUP", "");
        dataMap.put("PSDEUAGRPDETAIL", "");
        dataMap.put("PSDEUIACTION", "");
        dataMap.put("PSDEUIACTIONTYPE", "");
        dataMap.put("PSDEUSERROLE", "");
        dataMap.put("PSDEUTILDE", "");
        dataMap.put("PSDEUTILTYPE", "");
        dataMap.put("PSDEVCENTER", "");
        dataMap.put("PSDEVCENTERAS", "");
        dataMap.put("PSDEVCENTERDBINST", "");
        dataMap.put("PSDEVCENTERFILE", "");
        dataMap.put("PSDEVCENTERLOG", "");
        dataMap.put("PSDEVCENTERMQ", "");
        dataMap.put("PSDEVCENTERPF", "");
        dataMap.put("PSDEVCENTERRES", "");
        dataMap.put("PSDEVCENTERSERVER", "");
        dataMap.put("PSDEVCENTERSF", "");
        dataMap.put("PSDEVCENTERSRV", "");
        dataMap.put("PSDEVCENTERSVN", "");
        dataMap.put("PSDEVCENTERTS", "");
        dataMap.put("PSDEVENV", "");
        dataMap.put("PSDEVIEWBASE", "");
        dataMap.put("PSDEVIEWCTRL", "");
        dataMap.put("PSDEVIEWCTRLDS", "");
        dataMap.put("PSDEVIEWENGINE", "");
        dataMap.put("PSDEVIEWGROUP", "");
        dataMap.put("PSDEVIEWGRPDETAIL", "");
        dataMap.put("PSDEVIEWLOGIC", "");
        dataMap.put("PSDEVIEWRV", "");
        dataMap.put("PSDEVIEWSERVICE", "");
        dataMap.put("PSDEVPRD", "");
        dataMap.put("PSDEVPRDISSUE", "");
        dataMap.put("PSDEVPRDISSUEPLAN", "");
        dataMap.put("PSDEVPRDSEPCPLAN", "");
        dataMap.put("PSDEVPRDSPEC", "");
        dataMap.put("PSDEVPRDSPECPLAN", "");
        dataMap.put("PSDEVPRDSUBVER", "");
        dataMap.put("PSDEVPRDSYS", "");
        dataMap.put("PSDEVPRDSYSSYNC", "");
        dataMap.put("PSDEVPRDSYSSYNCITEM", "");
        dataMap.put("PSDEVPRDVER", "");
        dataMap.put("PSDEVRGROUP", "");
        dataMap.put("PSDEVRGRPDETAIL", "");
        dataMap.put("PSDEVSERVER", "");
        dataMap.put("PSDEVSERVERLEASE", "");
        dataMap.put("PSDEVSERVERTYPE", "");
        dataMap.put("PSDEVSLN", "");
        dataMap.put("PSDEVSLNCODESERVER", "");
        dataMap.put("PSDEVSLNCSSESSION", "");
        dataMap.put("PSDEVSLNLINK", "");
        dataMap.put("PSDEVSLNMSDEPAPI", "");
        dataMap.put("PSDEVSLNMSDEPAPP", "");
        dataMap.put("PSDEVSLNMSDEPFUNC", "");
        dataMap.put("PSDEVSLNMSDEPFUNCITEM", "");
        dataMap.put("PSDEVSLNMSDEPLOY", "");
        dataMap.put("PSDEVSLNRECENT", "");
        dataMap.put("PSDEVSLNSYS", "");
        dataMap.put("PSDEVSLNSYSAPI", "");
        dataMap.put("PSDEVSLNSYSAPP", "");
        dataMap.put("PSDEVSLNSYSBAK", "");
        dataMap.put("PSDEVSLNSYSBAKLINK", "");
        dataMap.put("PSDEVSLNSYSDEPINST", "");
        dataMap.put("PSDEVSLNSYSDYNAINST", "");
        dataMap.put("PSDEVSLNSYSGD", "");
        dataMap.put("PSDEVSLNSYSGROUP", "");
        dataMap.put("PSDEVSLNSYSKEY", "");
        dataMap.put("PSDEVSLNSYSLOCKLOG", "");
        dataMap.put("PSDEVSLNSYSMODEL", "");
        dataMap.put("PSDEVSLNSYSPATCH", "");
        dataMap.put("PSDEVSLNSYSPUBLOCK", "");
        dataMap.put("PSDEVSLNSYSREF", "");
        dataMap.put("PSDEVSLNSYSREFLINK", "");
        dataMap.put("PSDEVSLNSYSRES", "");
        dataMap.put("PSDEVSLNSYSSRC", "");
        dataMap.put("PSDEVSLNSYSSRV", "");
        dataMap.put("PSDEVSLNSYSTS", "");
        dataMap.put("PSDEVSLNSYSVER", "");
        dataMap.put("PSDEVSLNSYSWSGIT", "");
        dataMap.put("PSDEVSLNTEMPL", "");
        dataMap.put("PSDEVSLNUSER", "");
        dataMap.put("PSDEVSLNUSERCS", "");
        dataMap.put("PSDEVSYSDIFFITEM", "");
        dataMap.put("PSDEVSYSDIFFREP", "");
        dataMap.put("PSDEVUSER", "");
        dataMap.put("PSDEVUSERGROUP", "");
        dataMap.put("PSDEVUSERMODEL", "");
        dataMap.put("PSDEVUSEROBJ", "");
        dataMap.put("PSDEVUSERRECENT", "");
        dataMap.put("PSDEVUSERSQL", "");
        dataMap.put("PSDEWIZARD", "");
        dataMap.put("PSDEWIZARDFORM", "");
        dataMap.put("PSDEWIZARDSTEP", "");
        dataMap.put("PSDRITEMTYPE", "");
        dataMap.put("PSDSBOOKING", "");
        dataMap.put("PSDSBOOKINGLOG", "");
        dataMap.put("PSDSCONSOLE", "");
        dataMap.put("PSDSPANELTOOLBOX", "");
        dataMap.put("PSDSSYSAPPBAR", "");
        dataMap.put("PSDSSYSAPPBARFILTER", "");
        dataMap.put("PSDYNAAPP", "");
        dataMap.put("PSDYNAAPPVCINST", "");
        dataMap.put("PSDYNAAPPVIEW", "");
        dataMap.put("PSDYNAAPPVIEWCTRL", "");
        dataMap.put("PSDYNAAPPVIEWINST", "");
        dataMap.put("PSDYNACODELIST", "");
        dataMap.put("PSDYNACODELISTINST", "");
        dataMap.put("PSDYNADE", "");
        dataMap.put("PSDYNADEFORM", "");
        dataMap.put("PSDYNADEFORMINST", "");
        dataMap.put("PSDYNADEFORMTEMPL", "");
        dataMap.put("PSDYNADETEMPL", "");
        dataMap.put("PSDYNADEVIEWTEMPL", "");
        dataMap.put("PSDYNAINST", "");
        dataMap.put("PSDYNASYS", "");
        dataMap.put("PSDYNAWF", "");
        dataMap.put("PSDYNAWFVER", "");
        dataMap.put("PSDYNAWFVERINST", "");
        dataMap.put("PSDYNAWORKFLOW", "");
        dataMap.put("PSEDITORSTYLE", "");
        dataMap.put("PSEDITORTYPE", "");
        dataMap.put("PSFDLOGICTYPE", "");
        dataMap.put("PSFORMDETAILTYPE", "");
        dataMap.put("PSFORMTYPE", "");
        dataMap.put("PSGITUSER", "");
        dataMap.put("PSHELPARTICLE", "");
        dataMap.put("PSHELPARTICLECAT", "");
        dataMap.put("PSHELPARTICLETEMPL", "");
        dataMap.put("PSHELPARTICLETYPE", "");
        dataMap.put("PSHELPARTSEC", "");
        dataMap.put("PSHELPMODART", "");
        dataMap.put("PSHELPMODULE", "");
        dataMap.put("PSHELPPRJ", "");
        dataMap.put("PSHELPPRJTEMPL", "");
        dataMap.put("PSHELPPRJTYPE", "");
        dataMap.put("PSHELPRESOURCE", "");
        dataMap.put("PSHELPSECTION", "");
        dataMap.put("PSHELPSECTIONTEMPL", "");
        dataMap.put("PSHELPSECTIONTYPE", "");
        dataMap.put("PSIMAGETEMPL", "");
        dataMap.put("PSLANGUAGE", "");
        dataMap.put("PSLANGUAGEITEM", "");
        dataMap.put("PSLANGUAGERES", "");
        dataMap.put("PSLISTITEMTYPE", "");
        dataMap.put("PSMAVENREPO", "");
        dataMap.put("PSMAVENSERVER", "");
        dataMap.put("PSMAVENSERVERTYPE", "");
        dataMap.put("PSMIDETAIL", "");
        dataMap.put("PSMOBAPPPACK", "");
        dataMap.put("PSMOBAPPPACKSERVER", "");
        dataMap.put("PSMOBAPPPACKSESSION", "");
        dataMap.put("PSMOBAPPPACKTD", "");
        dataMap.put("PSMOBAPPSTARTPAGE", "");
        dataMap.put("PSMODEL", "");
        dataMap.put("PSMODELAPI", "");
        dataMap.put("PSMODELAPIINT", "");
        dataMap.put("PSMODELAPIMETHOD", "");
        dataMap.put("PSMODELAPIRS", "");
        dataMap.put("PSMODELBOOKMARK", "");
        dataMap.put("PSMODELERROR", "");
        dataMap.put("PSMODELEXAMPLE", "");
        dataMap.put("PSMODELEXAMPLECAT", "");
        dataMap.put("PSMODELEXAMPLESTEP", "");
        dataMap.put("PSMODELFIELD", "");
        dataMap.put("PSMODELFIELDVALUE", "");
        dataMap.put("PSMODELHOTCODE", "");
        dataMap.put("PSMODELIMPORT", "");
        dataMap.put("PSMODELINIT", "");
        dataMap.put("PSMODELMEMO", "");
        dataMap.put("PSMODELMODULE", "");
        dataMap.put("PSMODELOBJ", "");
        dataMap.put("PSMODELOBJREF", "");
        dataMap.put("PSMODELPFCODE", "");
        dataMap.put("PSMODELPLUGIN", "");
        dataMap.put("PSMODELREF", "");
        dataMap.put("PSMODELRESOURCE", "");
        dataMap.put("PSMODELRS", "");
        dataMap.put("PSMODELRT", "");
        dataMap.put("PSMODELRTMSG", "");
        dataMap.put("PSMODELSECTION", "");
        dataMap.put("PSMODELSEQ", "");
        dataMap.put("PSMODELSFCODE", "");
        dataMap.put("PSMODELSTATE", "");
        dataMap.put("PSMODELSTORAGE", "");
        dataMap.put("PSMODELSUBVIEW", "");
        dataMap.put("PSMODELSUMMARYTEMPL", "");
        dataMap.put("PSMODELUIACTION", "");
        dataMap.put("PSMODELVALUEGROUP", "");
        dataMap.put("PSMODELVIEW", "");
        dataMap.put("PSMODELVIEWUIACTION", "");
        dataMap.put("PSMODULE", "");
        dataMap.put("PSMQINST", "");
        dataMap.put("PSMQTYPE", "");
        dataMap.put("PSMSPLATFORM", "");
        dataMap.put("PSMSPLATFORMFUNC", "");
        dataMap.put("PSMSPLATFORMNODE", "");
        dataMap.put("PSNDFILE", "");
        dataMap.put("PSNDFILELINK", "");
        dataMap.put("PSPANELDETAILTYPE", "");
        dataMap.put("PSPANELENGINE", "");
        dataMap.put("PSPANELITEMLOGIC", "");
        dataMap.put("PSPANELLLCOND", "");
        dataMap.put("PSPANELLLCONDTYPE", "");
        dataMap.put("PSPANELLLTYPE", "");
        dataMap.put("PSPANELLNPARAM", "");
        dataMap.put("PSPANELLNTYPE", "");
        dataMap.put("PSPANELLOGICLINK", "");
        dataMap.put("PSPANELLOGICNODE", "");
        dataMap.put("PSPANELLOGICPARAM", "");
        dataMap.put("PSPDTAPPFUNC", "");
        dataMap.put("PSPDTVIEW", "");
        dataMap.put("PSPF", "");
        dataMap.put("PSPFAPPTEMPL", "");
        dataMap.put("PSPFCDN", "");
        dataMap.put("PSPFCODEFOLDER", "");
        dataMap.put("PSPFCTDETAIL", "");
        dataMap.put("PSPFCTRLTEMPL", "");
        dataMap.put("PSPFCTRLTYPE", "");
        dataMap.put("PSPFEDITORTEMPL", "");
        dataMap.put("PSPFEDITORTYPE", "");
        dataMap.put("PSPFPKG", "");
        dataMap.put("PSPFPKGCAT", "");
        dataMap.put("PSPFPKGVER", "");
        dataMap.put("PSPFPKGVERCDN", "");
        dataMap.put("PSPFPLUGIN", "");
        dataMap.put("PSPFPLUGINTEMPL", "");
        dataMap.put("PSPFPLUGINTYPE", "");
        dataMap.put("PSPFPREVIEWACTION", "");
        dataMap.put("PSPFPREVIEWNODE", "");
        dataMap.put("PSPFPUBCODE", "");
        dataMap.put("PSPFPUBOBJ", "");
        dataMap.put("PSPFPUBOBJPARAM", "");
        dataMap.put("PSPFQUICKTEMPL", "");
        dataMap.put("PSPFRESOURCE", "");
        dataMap.put("PSPFSTYLE", "");
        dataMap.put("PSPFSTYLECODE", "");
        dataMap.put("PSPFSTYLELOG", "");
        dataMap.put("PSPFSTYLEPKG", "");
        dataMap.put("PSPFSTYLEPRJ", "");
        dataMap.put("PSPFUATEMPL", "");
        dataMap.put("PSPFVIEWTEMPL", "");
        dataMap.put("PSPFVIEWTYPE", "");
        dataMap.put("PSPFVLTEMPL", "");
        dataMap.put("PSPILOGICTYPE", "");
        dataMap.put("PSPORTLET", "");
        dataMap.put("PSPORTLETTYPE", "");
        dataMap.put("PSPRODUCT", "");
        dataMap.put("PSPRODUCTTYPE", "");
        dataMap.put("PSROBOT", "");
        dataMap.put("PSROBOTABILITY", "");
        dataMap.put("PSROBOTTYPE", "");
        dataMap.put("PSROBOTTYPEABILITY", "");
        dataMap.put("PSROBOTWORK", "");
        dataMap.put("PSROBOTWORKTYPE", "");
        dataMap.put("PSROSSERVER", "");
        dataMap.put("PSRTWXACCOUNT", "");
        dataMap.put("PSSAASSYS", "");
        dataMap.put("PSSAASSYSAPI", "");
        dataMap.put("PSSAASSYSAPP", "");
        dataMap.put("PSSAASSYSDB", "");
        dataMap.put("PSSAASSYSVER", "");
        dataMap.put("PSSAHANDLER", "");
        dataMap.put("PSSAMPLEVALUE", "");
        dataMap.put("PSSF", "");
        dataMap.put("PSSFACHANDLER", "");
        dataMap.put("PSSFCODEFOLDER", "");
        dataMap.put("PSSFCODETEMPL", "");
        dataMap.put("PSSFCODETYPE", "");
        dataMap.put("PSSFCONFIG", "");
        dataMap.put("PSSFCTRLTYPE", "");
        dataMap.put("PSSFEXCEPTION", "");
        dataMap.put("PSSFPF", "");
        dataMap.put("PSSFPKG", "");
        dataMap.put("PSSFPKGCAT", "");
        dataMap.put("PSSFPKGVER", "");
        dataMap.put("PSSFPLUGIN", "");
        dataMap.put("PSSFPLUGINTEMPL", "");
        dataMap.put("PSSFPREVIEWACTION", "");
        dataMap.put("PSSFPUBOBJ", "");
        dataMap.put("PSSFPUBOBJPARAM", "");
        dataMap.put("PSSFSAHANDLER", "");
        dataMap.put("PSSFSTYLE", "");
        dataMap.put("PSSFSTYLECODE", "");
        dataMap.put("PSSFSTYLELOG", "");
        dataMap.put("PSSFSTYLEPARAM", "");
        dataMap.put("PSSFSTYLEPKG", "");
        dataMap.put("PSSFSTYLEPRJ", "");
        dataMap.put("PSSFSTYLEREF", "");
        dataMap.put("PSSFSTYLEVER", "");
        dataMap.put("PSSFVERCODE", "");
        dataMap.put("PSSFVERCODEITEM", "");
        dataMap.put("PSSFVIEWTYPE", "");
        dataMap.put("PSSTUDIOSERVER", "");
        dataMap.put("PSSTUDIOSERVERGRP", "");
        dataMap.put("PSSTUDIOSERVERLOG", "");
        dataMap.put("PSSTUDIOTHEME", "");
        dataMap.put("PSSUBAPP", "");
        dataMap.put("PSSUBAPPVIEW", "");
        dataMap.put("PSSUBDE", "");
        dataMap.put("PSSUBDEACTION", "");
        dataMap.put("PSSUBDEVIEW", "");
        dataMap.put("PSSUBSYS", "");
        dataMap.put("PSSUBSYSDM", "");
        dataMap.put("PSSUBSYSSADETAIL", "");
        dataMap.put("PSSUBSYSSERVICEAPI", "");
        dataMap.put("PSSUBSYSSF", "");
        dataMap.put("PSSUBSYSVER", "");
        dataMap.put("PSSUBSYSVERINST", "");
        dataMap.put("PSSUBVIEWTYPE", "");
        dataMap.put("PSSVNINSTREPO", "");
        dataMap.put("PSSVNSERVER", "");
        dataMap.put("PSSVRDOMAIN", "");
        dataMap.put("PSSVRPROVIDER", "");
        dataMap.put("PSSVRSERVER", "");
        dataMap.put("PSSYSACHANDLER", "");
        dataMap.put("PSSYSACTOR", "");
        dataMap.put("PSSYSAPP", "");
        dataMap.put("PSSYSBACKSERVICE", "");
        dataMap.put("PSSYSBDCOLSET", "");
        dataMap.put("PSSYSBDCOLUMN", "");
        dataMap.put("PSSYSBDINSTCFG", "");
        dataMap.put("PSSYSBDMODULE", "");
        dataMap.put("PSSYSBDPART", "");
        dataMap.put("PSSYSBDSCHEME", "");
        dataMap.put("PSSYSBDTABLE", "");
        dataMap.put("PSSYSBDTABLEDE", "");
        dataMap.put("PSSYSBDTABLEDER", "");
        dataMap.put("PSSYSBDTABLERS", "");
        dataMap.put("PSSYSCALENDAR", "");
        dataMap.put("PSSYSCALENDARITEM", "");
        dataMap.put("PSSYSCALENDARITEMRV", "");
        dataMap.put("PSSYSCODESNIPPET", "");
        dataMap.put("PSSYSCONSOLE", "");
        dataMap.put("PSSYSCOUNTER", "");
        dataMap.put("PSSYSCOUNTERITEM", "");
        dataMap.put("PSSYSCSS", "");
        dataMap.put("PSSYSCSSCAT", "");
        dataMap.put("PSSYSCTRLSTYLE", "");
        dataMap.put("PSSYSDASHBOARD", "");
        dataMap.put("PSSYSDATASYNCAGENT", "");
        dataMap.put("PSSYSDBCHGLOG", "");
        dataMap.put("PSSYSDBCOLUMN", "");
        dataMap.put("PSSYSDBDETAIL", "");
        dataMap.put("PSSYSDBPART", "");
        dataMap.put("PSSYSDBSCHEME", "");
        dataMap.put("PSSYSDBTABLE", "");
        dataMap.put("PSSYSDBVALUEOP", "");
        dataMap.put("PSSYSDBVF", "");
        dataMap.put("PSSYSDBVFCODE", "");
        dataMap.put("PSSYSDEFTYPE", "");
        dataMap.put("PSSYSDELOGICNODE", "");
        dataMap.put("PSSYSDEPLOY", "");
        dataMap.put("PSSYSDEPLOYAPP", "");
        dataMap.put("PSSYSDEPLOYAS", "");
        dataMap.put("PSSYSDEPLOYDB", "");
        dataMap.put("PSSYSDEVBKTASK", "");
        dataMap.put("PSSYSDEVBTTYPE", "");
        dataMap.put("PSSYSDEVINFO", "");
        dataMap.put("PSSYSDEVINFOTYPE", "");
        dataMap.put("PSSYSDEVSTUDIO", "");
        dataMap.put("PSSYSDICTCAT", "");
        dataMap.put("PSSYSDMITEM", "");
        dataMap.put("PSSYSDMITEMLOG", "");
        dataMap.put("PSSYSDMVER", "");
        dataMap.put("PSSYSDMVERITEM", "");
        dataMap.put("PSSYSDSACTION", "");
        dataMap.put("PSSYSDSACTIONTYPE", "");
        dataMap.put("PSSYSDYNAMODEL", "");
        dataMap.put("PSSYSDYNAMODELATTR", "");
        dataMap.put("PSSYSDYNAMODELCAT", "");
        dataMap.put("PSSYSEDITORSTYLE", "");
        dataMap.put("PSSYSENGINECFG", "");
        dataMap.put("PSSYSERMAP", "");
        dataMap.put("PSSYSERMAPNODE", "");
        dataMap.put("PSSYSFILE", "");
        dataMap.put("PSSYSIMAGE", "");
        dataMap.put("PSSYSISSUE", "");
        dataMap.put("PSSYSISSUEENGINE", "");
        dataMap.put("PSSYSISSUETYPE", "");
        dataMap.put("PSSYSLANITEM", "");
        dataMap.put("PSSYSLANRES", "");
        dataMap.put("PSSYSMODELACTION", "");
        dataMap.put("PSSYSMODELFOLDER", "");
        dataMap.put("PSSYSMODELFOLDERITEM", "");
        dataMap.put("PSSYSMODELFUNC", "");
        dataMap.put("PSSYSMODELFUNCCAT", "");
        dataMap.put("PSSYSMODELFUNCTEMPL", "");
        dataMap.put("PSSYSMODELGROUP", "");
        dataMap.put("PSSYSMODELINST", "");
        dataMap.put("PSSYSMODELINSTBK", "");
        dataMap.put("PSSYSMODELINSTSUM", "");
        dataMap.put("PSSYSMODELLOADLOG", "");
        dataMap.put("PSSYSMODELLOG", "");
        dataMap.put("PSSYSMODELMSG", "");
        dataMap.put("PSSYSMODELSYNC", "");
        dataMap.put("PSSYSMODELVER", "");
        dataMap.put("PSSYSMSGTEMPL", "");
        dataMap.put("PSSYSOPPRIV", "");
        dataMap.put("PSSYSORGTYPE", "");
        dataMap.put("PSSYSOUTYPE", "");
        dataMap.put("PSSYSOUTYPERS", "");
        dataMap.put("PSSYSPDTVIEW", "");
        dataMap.put("PSSYSPFPITEMPL", "");
        dataMap.put("PSSYSPFPLUGIN", "");
        dataMap.put("PSSYSPOLICY", "");
        dataMap.put("PSSYSPOLICYMODEL", "");
        dataMap.put("PSSYSPORTLET", "");
        dataMap.put("PSSYSPRDVER", "");
        dataMap.put("PSSYSPRODUCT", "");
        dataMap.put("PSSYSPROJECT", "");
        dataMap.put("PSSYSREF", "");
        dataMap.put("PSSYSREFDE", "");
        dataMap.put("PSSYSREPORT", "");
        dataMap.put("PSSYSREQITEM", "");
        dataMap.put("PSSYSREQITEMDATA", "");
        dataMap.put("PSSYSREQITEMHIS", "");
        dataMap.put("PSSYSREQMODULE", "");
        dataMap.put("PSSYSRTDEFINPUTTIP", "");
        dataMap.put("PSSYSRTMSG", "");
        dataMap.put("PSSYSRUNLOG", "");
        dataMap.put("PSSYSRUNSESSION", "");
        dataMap.put("PSSYSSAHANDLER", "");
        dataMap.put("PSSYSSAMPLEVALUE", "");
        dataMap.put("PSSYSSEARCHBAR", "");
        dataMap.put("PSSYSSEARCHBARITEM", "");
        dataMap.put("PSSYSSERVICEAPI", "");
        dataMap.put("PSSYSSFCODE", "");
        dataMap.put("PSSYSSFPITEMPL", "");
        dataMap.put("PSSYSSFPLUGIN", "");
        dataMap.put("PSSYSSFPUB", "");
        dataMap.put("PSSYSSFPUBPKG", "");
        dataMap.put("PSSYSSFPUBREF", "");
        dataMap.put("PSSYSSQLCMD", "");
        dataMap.put("PSSYSSQLCMDSQL", "");
        dataMap.put("PSSYSTASK", "");
        dataMap.put("PSSYSTASKDATA", "");
        dataMap.put("PSSYSTBITEM", "");
        dataMap.put("PSSYSTCASSERT", "");
        dataMap.put("PSSYSTCINPUT", "");
        dataMap.put("PSSYSTDITEM", "");
        dataMap.put("PSSYSTEM", "");
        dataMap.put("PSSYSTEMAS", "");
        dataMap.put("PSSYSTEMDBCFG", "");
        dataMap.put("PSSYSTEMMQ", "");
        dataMap.put("PSSYSTEMRUN", "");
        dataMap.put("PSSYSTEMSRC", "");
        dataMap.put("PSSYSTESTCASE", "");
        dataMap.put("PSSYSTESTDATA", "");
        dataMap.put("PSSYSTITLEBAR", "");
        dataMap.put("PSSYSTOOLBAR", "");
        dataMap.put("PSSYSUIACTION", "");
        dataMap.put("PSSYSUNIRES", "");
        dataMap.put("PSSYSUNISTATE", "");
        dataMap.put("PSSYSUNIT", "");
        dataMap.put("PSSYSUSERCASE", "");
        dataMap.put("PSSYSUSERCASERS", "");
        dataMap.put("PSSYSUSERDR", "");
        dataMap.put("PSSYSUSERMODE", "");
        dataMap.put("PSSYSUSERROLERES", "");
        dataMap.put("PSSYSUSERROLEDATA", "");
        dataMap.put("PSSYSUTILDE", "");
        dataMap.put("PSSYSUTILTYPE", "");
        dataMap.put("PSSYSVALUERULE", "");
        dataMap.put("PSSYSVIEWLOGIC", "");
        dataMap.put("PSSYSVIEWLOGICPARAM", "");
        dataMap.put("PSSYSVIEWPANEL", "");
        dataMap.put("PSSYSVIEWPANELITEM", "");
        dataMap.put("PSSYSVIEWPANELLOGIC", "");
        dataMap.put("PSSYSVIEWPANELMODEL", "");
        dataMap.put("PSSYSWFMODE", "");
        dataMap.put("PSSYSWFSETTING", "");
        dataMap.put("PSTASKSERVER", "");
        dataMap.put("PSTASKSERVERLOG", "");
        dataMap.put("PSTBITEMTYPE", "");
        dataMap.put("PSTREENODETYPE", "");
        dataMap.put("PSTSCMD", "");
        dataMap.put("PSUACAPPTYPE", "");
        dataMap.put("PSUAWIZARD", "");
        dataMap.put("PSUAWIZARD2", "");
        dataMap.put("PSUAWIZARD3", "");
        dataMap.put("PSUIENGINETYPE", "");
        dataMap.put("PSUIENGINETYPEPARAM", "");
        dataMap.put("PSUNIT", "");
        dataMap.put("PSUSDCAPPPOLICY", "");
        dataMap.put("PSUSDCMODULE", "");
        dataMap.put("PSUSDCMODULEINST", "");
        dataMap.put("PSUSDCMODULEINSTFUNC", "");
        dataMap.put("PSUSDCMODULEINSTREF", "");
        dataMap.put("PSUSMODULE", "");
        dataMap.put("PSUSMODULEINST", "");
        dataMap.put("PSUSMODULEINSTFUNC", "");
        dataMap.put("PSUSMODULEINSTREF", "");
        dataMap.put("PSUWAPPFUNC", "");
        dataMap.put("PSUWAPPVIEW", "");
        dataMap.put("PSUWCREATEDE", "");
        dataMap.put("PSUWCREATEDEDEF", "");
        dataMap.put("PSUWCREATEDEDER", "");
        dataMap.put("PSUWCREATEDEITEM", "");
        dataMap.put("PSUWCREATEMODEL", "");
        dataMap.put("PSUWDEDRITEM", "");
        dataMap.put("PSUWDEUNIONKEY", "");
        dataMap.put("PSUWPICKUPMODEL", "");
        dataMap.put("PSVALUERULE", "");
        dataMap.put("PSVARSAMPLEVALUE", "");
        dataMap.put("PSVARTYPE", "");
        dataMap.put("PSVIEWENGINE", "");
        dataMap.put("PSVIEWLOGICTYPE", "");
        dataMap.put("PSVIEWLOGICTYPEPARAM", "");
        dataMap.put("PSVIEWMSG", "");
        dataMap.put("PSVIEWMSGGROUP", "");
        dataMap.put("PSVIEWMSGGRPDETAIL", "");
        dataMap.put("PSVIEWRTMSG", "");
        dataMap.put("PSVIEWSTYLE", "");
        dataMap.put("PSVIEWTYPE", "");
        dataMap.put("PSVIEWTYPECAT", "");
        dataMap.put("PSVIEWTYPELOGIC", "");
        dataMap.put("PSVIEWWIZARDGROUP", "");
        dataMap.put("PSVTCATDETAIL", "");
        dataMap.put("PSVTCTRL", "");
        dataMap.put("PSVTRV", "");
        dataMap.put("PSVTSAMPLE", "");
        dataMap.put("PSVTSTYLE", "");
        dataMap.put("PSWFDE", "");
        dataMap.put("PSWFENGINETYPE", "");
        dataMap.put("PSWFLINK", "");
        dataMap.put("PSWFLINKCOND", "");
        dataMap.put("PSWFLINKCONDTYPE", "");
        dataMap.put("PSWFLINKROLE", "");
        dataMap.put("PSWFLINKTYPE", "");
        dataMap.put("PSWFPROCESS", "");
        dataMap.put("PSWFPROCESSTYPE", "");
        dataMap.put("PSWFPROCPARAM", "");
        dataMap.put("PSWFPROCROLE", "");
        dataMap.put("PSWFPROCSUBWF", "");
        dataMap.put("PSWFROLE", "");
        dataMap.put("PSWFSUBWF", "");
        dataMap.put("PSWFUTILUIACTION", "");
        dataMap.put("PSWFVERLOG", "");
        dataMap.put("PSWFVERSION", "");
        dataMap.put("PSWFWORKTIME", "");
        dataMap.put("PSWORKFLOW", "");
        dataMap.put("PSWORKSHOPSERVER", "");
        dataMap.put("PSWORKSPACE", "");
        dataMap.put("PSWORKSPACELOG", "");
        dataMap.put("PSWORKSPACETYPE", "");
        dataMap.put("PSWPAPP", "");
        dataMap.put("PSWPAPPENTITY", "");
        dataMap.put("PSWPAPPINST", "");
        dataMap.put("PSWPDCAPPENTITY", "");
        dataMap.put("PSWPDCAPPINST", "");
        dataMap.put("PSWPDCENGINEINST", "");
        dataMap.put("PSWPDCWFCAT", "");
        dataMap.put("PSWPDCWFINST", "");
        dataMap.put("PSWPDCWORKFLOW", "");
        dataMap.put("PSWPENGINE", "");
        dataMap.put("PSWPENGINEINST", "");
        dataMap.put("PSWXACCOUNT", "");
        dataMap.put("PSWXENTAPP", "");
        dataMap.put("PSWXLOGIC", "");
        dataMap.put("PSWXMENU", "");
        dataMap.put("PSWXMENUFUNC", "");
        dataMap.put("PSWXMENUITEM", "");
        dataMap.put("PSSUBSYSSADE", "");
        dataMap.put("PSSUBSYSSADEFIELD", "");
        dataMap.put("PSSUBSYSSADERS", "");
        dataMap.put("PSSYSDBPROC", "");
        dataMap.put("PSSYSDBPROCPARAM", "");
        dataMap.put("PSDESAVR", "");
        dataMap.put("PSSYSCONTENT", "");
        dataMap.put("PSSYSRESOURCE", "");
        dataMap.put("PSAPPSTORYBOARD", "");
        dataMap.put("PSAPPSBITEMRS", "");
        dataMap.put("PSAPPSBITEM", "");
        dataMap.put("PSAPPRESOURCE", "");
        dataMap.put("PSSYSCONTENTCAT", "");
        dataMap.put("PSSYSTESTMODULE", "");
        dataMap.put("PSSYSTESTPRJ", "");
        dataMap.put("PSSYSUCMAP", "");
        dataMap.put("PSSYSUCMAPNODE", "");
        dataMap.put("PSDEACTIONGROUP", "");
        dataMap.put("PSDEAGDETAIL", "");
        dataMap.put("PSCTRLLOGICGROUP", "");
        dataMap.put("PSCTRLLOGICGRPDETAIL", "");
        dataMap.put("PSSYSSEARCHSCHEME", "");
        dataMap.put("PSSYSSEARCHDOC", "");
        dataMap.put("PSSYSSEARCHFIELD", "");
        dataMap.put("PSSYSSEARCHDE", "");
        dataMap.put("PSSYSSEARCHDEFIELD", "");
        dataMap.put("PSSYSMAPVIEW", "");
        dataMap.put("PSSYSMAPITEM", "");
        dataMap.put("PSSYSPORTLETCAT", "");
        dataMap.put("PSAPPPORTLET", "");
        dataMap.put("PSSYSWFCAT", "");
        dataMap.put("PSAPPSTORYBOARD", "");
        dataMap.put("PSAPPSBITEM", "");
        dataMap.put("PSAPPSBITEMRS", "");
        dataMap.put("PSDEGEIVR", "");
        dataMap.put("PSDEACTIONVR", "");
        dataMap.put("PSDEMSFIELD", "");
        return dataMap;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void backup(String strDBServerId, String strFolder) throws Exception {
        String strDate = String.format("%1$tY%1$tm%1$td%1$tH%1$tM", new Date());
        String strBackupPath = String.format("%1$s%2$s%3$s%2$s%4$s", strFolder, File.separator, strDBServerId, strDate);
        final File folder = new File(strBackupPath);
        folder.mkdirs();
        final SessionFactory sessionFactory = PSSysModelInstGlobal.getDBServerSessionFactory((String)strDBServerId);
        PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)sessionFactory);
        final ArrayList list = psSystemService.selectRaw("select schema_name from information_schema.schemata;", null);
        log.info((Object)String.format("\u5f00\u59cb\u5907\u4efd\u6570\u636e\u5e93[%1$s]\uff0c\u6570\u91cf[%2$s]", strDBServerId, list.size()));
        final ArrayList finishlist = new ArrayList();
        int nCount = list.size();
        ExecutorService pool = Executors.newCachedThreadPool();
        int i = 0;
        while (i < 8) {
            pool.execute(new Runnable(){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                @Override
                public void run() {
                    while (true) {
                        IEntity iEntity = null;
                        ArrayList arrayList = list;
                        synchronized (arrayList) {
                            if (list.size() > 0) {
                                iEntity = (IEntity)list.remove(0);
                            }
                        }
                        if (iEntity == null) break;
                        PSDBServerBackupHelper.this.backupDBInst(iEntity, folder, (PSDBServerSessionFactoryImpl)sessionFactory);
                        arrayList = finishlist;
                        synchronized (arrayList) {
                            finishlist.add(iEntity);
                        }
                    }
                }
            });
            ++i;
        }
        while (true) {
            ArrayList arrayList = finishlist;
            synchronized (arrayList) {
                if (finishlist.size() == nCount) {
                    break;
                }
            }
            Thread.sleep(50L);
        }
        pool.shutdown();
    }

    protected void backupDBInst(IEntity iEntity, File folder, PSDBServerSessionFactoryImpl sessionFactory) {
        try {
            String strName = DataObject.getStringValue((Object)iEntity.get("schema_name"), (String)"");
            if ("performance_schema".equals(strName) || "mysql".equals(strName)) {
                return;
            }
            String strNewFolder = String.format("%1$s%2$s%3$s", folder.getAbsolutePath(), File.separator, strName);
            File instFolder = new File(strNewFolder);
            instFolder.mkdirs();
            PSSysModelInst psSysModelInst = new PSSysModelInst();
            psSysModelInst.setDBName(strName);
            sessionFactory.setPSSysModelInst(psSysModelInst);
            log.info((Object)String.format("\u5f00\u59cb\u5907\u4efd\u5b9e\u4f8b[%1$s]", strName));
            this.backup(strNewFolder, sessionFactory);
        }
        catch (Exception ex) {
            log.error((Object)String.format("\u5907\u4efd\u5b9e\u4f8b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void backup(String strFolder, PSDBServerSessionFactoryImpl sessionFactory) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strFolder)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5bfc\u51fa\u76ee\u5f55");
        }
        Map<String, String> exportDataMap = this.getBackupDataMap();
        ArrayList<String> importModelList = new ArrayList<String>();
        ArrayList<String> importModelList2 = new ArrayList<String>();
        ArrayList<String> errorList = new ArrayList<String>();
        ArrayList totalList = new ArrayList();
        importModelList.addAll(exportDataMap.keySet());
        importModelList.remove("PSDEDQCODEEXP");
        importModelList.remove("PSSYSDMITEM");
        importModelList.remove("PSDEFDTCOL");
        importModelList.remove("PSDEFFORMITEM");
        importModelList.remove("PSDEFORMDETAIL");
        importModelList.remove("PSDEFIELD");
        importModelList.remove("PSDEVIEWCTRL");
        importModelList.remove("PSLANGUAGERES");
        importModelList.remove("PSDEFSFITEM");
        importModelList.remove("PSDEACTION");
        importModelList.remove("PSDEVIEWBASE");
        importModelList.remove("PSDEFINPUTTIP");
        importModelList.remove("PSCODEITEM");
        importModelList.remove("PSDEGRIDCOL");
        importModelList.add(0, "PSDEVIEWCTRL");
        importModelList.add(0, "PSLANGUAGERES");
        importModelList.add(0, "PSDEFSFITEM");
        importModelList.add(0, "PSDEACTION");
        importModelList.add(0, "PSDEVIEWBASE");
        importModelList.add(0, "PSDEFINPUTTIP");
        importModelList.add(0, "PSCODEITEM");
        importModelList.add(0, "PSDEGRIDCOL");
        importModelList.add(0, "PSDEDQCODEEXP");
        importModelList.add(0, "PSDEFFORMITEM");
        importModelList.add(0, "PSDEFORMDETAIL");
        importModelList.add(0, "PSDEFIELD");
        importModelList.add(0, "PSSYSDMITEM");
        importModelList.add(0, "PSDEFDTCOL");
        PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)sessionFactory);
        long nBeginTime = System.currentTimeMillis();
        int nTotalModelCnt = importModelList.size();
        try {
            while (true) {
                String strPSModelName = null;
                ArrayList<String> arrayList = importModelList;
                synchronized (arrayList) {
                    if (importModelList.size() > 0) {
                        strPSModelName = (String)importModelList.remove(0);
                    }
                }
                if (StringHelper.isNullOrEmpty((String)strPSModelName)) break;
                IDataEntityModel iDEModel = DEModelGlobal.getDEModel((String)strPSModelName, (boolean)true);
                if (iDEModel == null) continue;
                IService iService = iDEModel.getService((SessionFactory)sessionFactory);
                if (iService.getSessionFactory() != sessionFactory) {
                    ArrayList<String> arrayList2 = importModelList2;
                    synchronized (arrayList2) {
                        importModelList2.add(strPSModelName);
                        log.debug((Object)StringHelper.format((String)"\u5ffd\u7565\u5bfc\u51fa[%1$s]\uff0c\u6570\u636e\u6e90\u4e0d\u4e00\u81f4\uff0c\u5f53\u524d\u5df2\u5b8c\u6210 %2$s/%3$s", (Object)strPSModelName, (Object)importModelList2.size(), (Object)nTotalModelCnt));
                    }
                }
                String strSQL = StringHelper.format((String)"select * from %1$s ", (Object)iDEModel.getTableName());
                if (iDEModel.getInheritDEModel() != null && !StringHelper.isNullOrEmpty((String)iDEModel.getViewName())) {
                    strSQL = StringHelper.format((String)"select * from %1$s ", (Object)iDEModel.getViewName());
                }
                try {
                    if (iService instanceof IPSCoreSysService) {
                        ((IPSCoreSysService)iService).selectRaw(strSQL, null, (IPSRawSelectWork)new BackupHelper(strFolder, iService, iDEModel));
                    } else {
                        psSystemService.selectRaw(strSQL, null, (IPSRawSelectWork)new BackupHelper(strFolder, (IService)psSystemService, iDEModel));
                    }
                    ArrayList<String> arrayList3 = importModelList2;
                    synchronized (arrayList3) {
                        importModelList2.add(strPSModelName);
                        log.debug((Object)StringHelper.format((String)"\u5bfc\u51fa[%1$s]\uff0c\u5f53\u524d\u5df2\u5b8c\u6210 %2$s/%3$s", (Object)strPSModelName, (Object)importModelList2.size(), (Object)nTotalModelCnt));
                        continue;
                    }
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                    importModelList2.add(strPSModelName);
                    log.error((Object)StringHelper.format((String)"\u5bfc\u51fa[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c\u5f53\u524d\u5df2\u5b8c\u6210 %2$s/%3$s", (Object)strPSModelName, (Object)importModelList2.size(), (Object)nTotalModelCnt));
                    continue;
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
            errorList.add(ex.getMessage());
        }
        if (errorList.size() > 0) {
            throw new Exception("\u5bfc\u51fa\u53d1\u751f\u9519\u8bef");
        }
        int nTotal = 0;
        Iterator iterator = totalList.iterator();
        while (iterator.hasNext()) {
            int nValue = (Integer)iterator.next();
            nTotal += nValue;
        }
        log.debug((Object)StringHelper.format((String)"\u5bfc\u51fa\u8bb0\u5f55\u6570[%1$s]\uff0c\u8017\u65f6[%2$s]", (Object)nTotal, (Object)(System.currentTimeMillis() - nBeginTime)));
    }

    protected class BackupHelper
    implements IPSRawSelectWork {
        private IDataEntityModel iDataEntityModel = null;
        private String strModelFolder = null;
        private IService iService = null;

        public BackupHelper(String strResFolder, IService iService, IDataEntityModel iDataEntityModel) throws Exception {
            this.iService = iService;
            this.iDataEntityModel = iDataEntityModel != null ? iDataEntityModel : this.iService.getDEModel();
            this.strModelFolder = String.valueOf(strResFolder) + File.separator + this.iDataEntityModel.getName();
            File folder = new File(this.strModelFolder);
            if (!folder.exists()) {
                folder.mkdirs();
            }
        }

        public void process(IDataTable iDataTable) throws Exception {
            int nRead;
            int nCount = 2000;
            do {
                nRead = iDataTable.cacheRows(nCount);
                int i = 0;
                while (i < nRead) {
                    IDataRow iDataRow = iDataTable.getCachedRow(i);
                    IEntity simpleEntity = this.iDataEntityModel.createEntity();
                    DataObject.fromDataRow((IDataObject)simpleEntity, (IDataRow)iDataRow);
                    String strModelResPath = String.valueOf(this.strModelFolder) + File.separator + "ALL.txt";
                    PSModelV2Helper.appendFile((String)strModelResPath, (String)(String.valueOf(PSModelV2Helper.toJSONString((IEntity)simpleEntity, (boolean)false)) + "\n\n"));
                    ++i;
                }
            } while (nRead >= nCount);
        }
    }
}

