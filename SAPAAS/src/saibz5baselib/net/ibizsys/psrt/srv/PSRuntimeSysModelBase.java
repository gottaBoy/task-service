/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv;

import javax.annotation.PostConstruct;

import net.ibizsys.paas.core.DER;
import net.ibizsys.paas.core.DERs;
import net.ibizsys.paas.ctrlhandler.ICounterHandler;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.paas.sysmodel.SystemUserRoleModelBase;
import net.ibizsys.paas.sysmodel.DEDataSetSystemUserRoleModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.ViewMsgGroupModel;
import net.ibizsys.paas.view.StaticViewMsgModel;
import net.ibizsys.paas.view.DEDataSetViewMsgModel;
import net.ibizsys.paas.demodel.DEFInputTipSetModel;
import net.ibizsys.paas.cache.DEUniStateModel;
import net.ibizsys.paas.dts.DTSQueueModel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
@DERs({
    @DER(id="1656e926f11b26fc5332306b52592366",name="DER1N_CODEITEM_CODEITEM_PCODEITEMID",type="DER1N",majordeid="60a039b41c39edc7ff965f1c0958232d",minordeid="60a039b41c39edc7ff965f1c0958232d" ,majordename="CODEITEM",minordename="CODEITEM",masterrs=0,pickupdefname="PCODEITEMID")
    ,@DER(id="fc0a850d89848ac4bd8af35ad839c288",name="DER1N_CODEITEM_CODELIST_CODELISTID",type="DER1N",majordeid="85317205b415aa6af990684ca7704515",minordeid="60a039b41c39edc7ff965f1c0958232d" ,majordename="CODELIST",minordename="CODEITEM",masterrs=0,pickupdefname="CODELISTID")
    ,@DER(id="b78b4cc48da463c059424a26efec842c",name="DER1N_CODELIST_DATAENTITY_DEID",type="DER1N",majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2",minordeid="85317205b415aa6af990684ca7704515" ,majordename="DATAENTITY",minordename="CODELIST",masterrs=0,pickupdefname="DEID")
    ,@DER(id="2c440711be83754e5250c0394b03dbb9",name="DER1N_DATAAUDITDETAIL_DATAAUDIT_DATAAUDITID",type="DER1N",majordeid="326125ce130f4bec558c9778daef045c",minordeid="7d9fefe4909e0cfffcb467129475b02d" ,majordename="DATAAUDIT",minordename="DATAAUDITDETAIL",masterrs=0,pickupdefname="DATAAUDITID")
    ,@DER(id="c11fec2d7398bbfae41f4b5d1639079d",name="DER1N_DATAENTITY_DATAENTITY_DER11DEID",type="DER1N",majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2",minordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2" ,majordename="DATAENTITY",minordename="DATAENTITY",masterrs=0,pickupdefname="DER11DEID")
    ,@DER(id="a55673f3c26f1de111eeb547dbb40a6e",name="DER1N_DATAENTITY_QUERYMODEL_ACQUERYMODELID",type="DER1N",majordeid="ee650aec5d0df3c9880100dc57441146",minordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2" ,majordename="QUERYMODEL",minordename="DATAENTITY",masterrs=0,pickupdefname="ACQUERYMODELID")
    ,@DER(id="a1149c0cf281cf46f0ae70d7d1921522",name="DER1N_DATASYNCIN2_DATAENTITY_DEID",type="DER1N",majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2",minordeid="04c87ff6cdac6dd390613dbc44f3c51d" ,majordename="DATAENTITY",minordename="DATASYNCIN2",masterrs=0,pickupdefname="DEID")
    ,@DER(id="1e2d9fdba388047e02ad8b2e4cb8ea39",name="DER1N_DATASYNCIN_DATAENTITY_DEID",type="DER1N",majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2",minordeid="3621f160a6392fc07fea086d691daa0d" ,majordename="DATAENTITY",minordename="DATASYNCIN",masterrs=0,pickupdefname="DEID")
    ,@DER(id="a7ca173df623eafe0993ef8c1cb7ce56",name="DER1N_DATASYNCOUT2_DATAENTITY_DEID",type="DER1N",majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2",minordeid="1cecb3d95febd748a2daf8e9c86a8ec5" ,majordename="DATAENTITY",minordename="DATASYNCOUT2",masterrs=0,pickupdefname="DEID")
    ,@DER(id="1bee3d42cc35ae68e2c216fd3450ace8",name="DER1N_DATASYNCOUT_DATAENTITY_DEID",type="DER1N",majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2",minordeid="c8381accf6c7621d57757a4955ddb504" ,majordename="DATAENTITY",minordename="DATASYNCOUT",masterrs=0,pickupdefname="DEID")
    ,@DER(id="3cae02ebc5bd30e35ddae8d16a3cd0c2",name="DER1N_DEDATACHG2_DATAENTITY_DEID",type="DER1N",majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2",minordeid="2be4c985b8c11e06783904ce4e9d8b90" ,majordename="DATAENTITY",minordename="DEDATACHG2",masterrs=0,pickupdefname="DEID")
    ,@DER(id="dd5f14db2aeccd0eed9324a65fac48de",name="DER1N_DEDATACHG_DATAENTITY_DEID",type="DER1N",majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2",minordeid="b46bdd8836d4e93bad690042e23ff374" ,majordename="DATAENTITY",minordename="DEDATACHG",masterrs=0,pickupdefname="DEID")
    ,@DER(id="c7f4b6bab443a687f9d6a4a0652775e4",name="DER1N_DSDYNAVIEWINST_DSDYNAVIEW_DSDYNAVIEWID",type="DER1N",majordeid="87d8599997ce9323cd2bba43278b4135",minordeid="455ba35d2ea0b7be6e2035f54ff60f5b" ,majordename="DSDYNAVIEW",minordename="DSDYNAVIEWINST",masterrs=0,pickupdefname="DSDYNAVIEWID")
    ,@DER(id="2c3f7e899a996bc416cec3c73769220b",name="DER1N_DSDYNAWFVER_DSDYNAWF_DSDYNAWFID",type="DER1N",majordeid="94ed000542e335afa0722bc1cbfdf279",minordeid="da1ebfa0f1777e651b33c7e1df73c4ec" ,majordename="DSDYNAWF",minordename="DSDYNAWFVER",masterrs=1,pickupdefname="DSDYNAWFID")
    ,@DER(id="df7f1d11355a8a1723875d8d43aa137a",name="DER1N_LOGINACCOUNT_USER_USERID",type="DER1N",majordeid="f4552a6291c79e3934263b31b83aec33",minordeid="5ae7d9610693e638cd1064cf7c9126f8" ,majordename="USER",minordename="LOGINACCOUNT",masterrs=0,pickupdefname="USERID")
    ,@DER(id="112ac206b9d83aa2e07750365aad59cb",name="DER1N_LOGINLOG_LOGINACCOUNT_LOGINACCOUNTID",type="DER1N",majordeid="5ae7d9610693e638cd1064cf7c9126f8",minordeid="7628b30c66aaeab68c9aec1aed3f7e21" ,majordename="LOGINACCOUNT",minordename="LOGINLOG",masterrs=0,pickupdefname="LOGINACCOUNTID")
    ,@DER(id="6baea83229dbeddb3df2b5fc71adcb5b",name="DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MAJORMSGACCOUNTID",type="DER1N",majordeid="7ce656616f83e08ed4aeba648bb0a30b",minordeid="b0a62e77dcb2ca3226353cea1c370b79" ,majordename="MSGACCOUNT",minordename="MSGACCOUNTDETAIL",masterrs=7,pickupdefname="MAJORMSGACCOUNTID")
    ,@DER(id="2768f18f1b00ae87fd75c3a5f275cb02",name="DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MINORMSGACCOUNTID",type="DER1N",majordeid="7ce656616f83e08ed4aeba648bb0a30b",minordeid="b0a62e77dcb2ca3226353cea1c370b79" ,majordename="MSGACCOUNT",minordename="MSGACCOUNTDETAIL",masterrs=0,pickupdefname="MINORMSGACCOUNTID")
    ,@DER(id="de59ed9eb9b555bc06e35224c3ae6c2b",name="DER1N_MSGTEMPLATE_DATAENTITY_DEID",type="DER1N",majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2",minordeid="e2c5b96d6cb0389900da130bc4545add" ,majordename="DATAENTITY",minordename="MSGTEMPLATE",masterrs=0,pickupdefname="DEID")
    ,@DER(id="4985d3434f612c5d23ae9fa4b434e3eb",name="DER1N_ORGSECTOR_ORGSECTOR_PORGSECTORID",type="DER1N",majordeid="63061bfdafbbd213fc0ce66d3f26419e",minordeid="63061bfdafbbd213fc0ce66d3f26419e" ,majordename="ORGSECTOR",minordename="ORGSECTOR",masterrs=0,pickupdefname="PORGSECTORID")
    ,@DER(id="4ac954e7df5461621e1996c284eeae39",name="DER1N_ORGSECTOR_ORGSECTOR_REPORGSECTORID",type="DER1N",majordeid="63061bfdafbbd213fc0ce66d3f26419e",minordeid="63061bfdafbbd213fc0ce66d3f26419e" ,majordename="ORGSECTOR",minordename="ORGSECTOR",masterrs=0,pickupdefname="REPORGSECTORID")
    ,@DER(id="9b73d0648c9cd83f5c4413a7503de665",name="DER1N_ORGSECTOR_ORG_ORGID",type="DER1N",majordeid="e3e158d75b7bc6f589686b6e1beb966c",minordeid="63061bfdafbbd213fc0ce66d3f26419e" ,majordename="ORG",minordename="ORGSECTOR",masterrs=0,pickupdefname="ORGID")
    ,@DER(id="039739dbaf58acdf0e2282f988acc319",name="DER1N_ORGSECUSER_ORGSECTOR_ORGSECTORID",type="DER1N",majordeid="63061bfdafbbd213fc0ce66d3f26419e",minordeid="a29184750c477cf3910fc2179179dccc" ,majordename="ORGSECTOR",minordename="ORGSECUSER",masterrs=0,pickupdefname="ORGSECTORID")
    ,@DER(id="3fb9f4803139d36c71baa9b5d1fc673f",name="DER1N_ORGSECUSER_ORGSECUSERTYPE_ORGSECUSERTYPEID",type="DER1N",majordeid="576dd33b28a3ee34ba68561c68aa93b3",minordeid="a29184750c477cf3910fc2179179dccc" ,majordename="ORGSECUSERTYPE",minordename="ORGSECUSER",masterrs=0,pickupdefname="ORGSECUSERTYPEID")
    ,@DER(id="698edb9b7d3933dffd677d0af5da9d6c",name="DER1N_ORGSECUSER_ORGUSER_ORGUSERID",type="DER1N",majordeid="1f9576cdcc6a949230c7669182c73648",minordeid="a29184750c477cf3910fc2179179dccc" ,majordename="ORGUSER",minordename="ORGSECUSER",masterrs=0,pickupdefname="ORGUSERID")
    ,@DER(id="b1568c2ef7918c4690bffc8cc39a8327",name="DER1N_ORGSECUSER_ORG_ORGID",type="DER1N",majordeid="e3e158d75b7bc6f589686b6e1beb966c",minordeid="a29184750c477cf3910fc2179179dccc" ,majordename="ORG",minordename="ORGSECUSER",masterrs=0,pickupdefname="ORGID")
    ,@DER(id="c64c576f22b1072cdecf2c043cf9106b",name="DER1N_ORGUSER_ORGSECTOR_ORGSECTORID",type="DER1N",majordeid="63061bfdafbbd213fc0ce66d3f26419e",minordeid="1f9576cdcc6a949230c7669182c73648" ,majordename="ORGSECTOR",minordename="ORGUSER",masterrs=0,pickupdefname="ORGSECTORID")
    ,@DER(id="eda174cf10516278ae0cf592e6ed9943",name="DER1N_ORGUSER_ORGSECUSERTYPE_ORGSECUSERTYPEID",type="DER1N",majordeid="576dd33b28a3ee34ba68561c68aa93b3",minordeid="1f9576cdcc6a949230c7669182c73648" ,majordename="ORGSECUSERTYPE",minordename="ORGUSER",masterrs=0,pickupdefname="ORGSECUSERTYPEID")
    ,@DER(id="d4fa384409c56f68322a2f0cab46cd75",name="DER1N_ORGUSER_ORGUSERLEVEL_ORGUSERLEVELID",type="DER1N",majordeid="e6c870c62a861cfd5593212fa41d6f88",minordeid="1f9576cdcc6a949230c7669182c73648" ,majordename="ORGUSERLEVEL",minordename="ORGUSER",masterrs=0,pickupdefname="ORGUSERLEVELID")
    ,@DER(id="7ef88aac275d3d363f5981c8f53b9988",name="DER1N_ORGUSER_ORG_ORGID",type="DER1N",majordeid="e3e158d75b7bc6f589686b6e1beb966c",minordeid="1f9576cdcc6a949230c7669182c73648" ,majordename="ORG",minordename="ORGUSER",masterrs=0,pickupdefname="ORGID")
    ,@DER(id="4572de06ad701dd628e9960bc055113e",name="DER1N_ORG_ORG_PORGID",type="DER1N",majordeid="e3e158d75b7bc6f589686b6e1beb966c",minordeid="e3e158d75b7bc6f589686b6e1beb966c" ,majordename="ORG",minordename="ORG",masterrs=0,pickupdefname="PORGID")
    ,@DER(id="9147ed7184373dfae772ea5db9afa2ec",name="DER1N_PPMODEL_PORTALPAGE_PORTALPAGEID",type="DER1N",majordeid="f63040021720d1401ec2014d30b02bb6",minordeid="14ad5675b58882f0e61ba3caabcf6f5e" ,majordename="PORTALPAGE",minordename="PPMODEL",masterrs=0,pickupdefname="PORTALPAGEID")
    ,@DER(id="1FA00E9F-A266-433E-8C95-9AA615F10D35",name="DER1N_PPMODEL_PVPART_C1PVPARTID",type="DER1N",majordeid="d1ce1f760d77192f620b4f6b9d7769f8",minordeid="14ad5675b58882f0e61ba3caabcf6f5e" ,majordename="PVPART",minordename="PPMODEL",masterrs=0,pickupdefname="C1PVPARTID")
    ,@DER(id="D848A57B-A529-482F-AC73-977043C3FDAC",name="DER1N_PPMODEL_PVPART_C2PVPARTID",type="DER1N",majordeid="d1ce1f760d77192f620b4f6b9d7769f8",minordeid="14ad5675b58882f0e61ba3caabcf6f5e" ,majordename="PVPART",minordename="PPMODEL",masterrs=0,pickupdefname="C2PVPARTID")
    ,@DER(id="F3FE8428-161F-4FFE-B2C9-78418B5ED714",name="DER1N_PPMODEL_PVPART_C3PVPARTID",type="DER1N",majordeid="d1ce1f760d77192f620b4f6b9d7769f8",minordeid="14ad5675b58882f0e61ba3caabcf6f5e" ,majordename="PVPART",minordename="PPMODEL",masterrs=0,pickupdefname="C3PVPARTID")
    ,@DER(id="BA8ECEB3-7D9A-496D-B667-4FA9377EAE61",name="DER1N_PPMODEL_PVPART_C4PVPARTID",type="DER1N",majordeid="d1ce1f760d77192f620b4f6b9d7769f8",minordeid="14ad5675b58882f0e61ba3caabcf6f5e" ,majordename="PVPART",minordename="PPMODEL",masterrs=0,pickupdefname="C4PVPARTID")
    ,@DER(id="77D64820-2DC9-4828-87F7-2B3D20F78C2D",name="DER1N_PPMODEL_PVPART_L1PVPARTID",type="DER1N",majordeid="d1ce1f760d77192f620b4f6b9d7769f8",minordeid="14ad5675b58882f0e61ba3caabcf6f5e" ,majordename="PVPART",minordename="PPMODEL",masterrs=0,pickupdefname="L1PVPARTID")
    ,@DER(id="CD16E202-1010-4C47-BBED-77DED600D88F",name="DER1N_PPMODEL_PVPART_L2PVPARTID",type="DER1N",majordeid="d1ce1f760d77192f620b4f6b9d7769f8",minordeid="14ad5675b58882f0e61ba3caabcf6f5e" ,majordename="PVPART",minordename="PPMODEL",masterrs=0,pickupdefname="L2PVPARTID")
    ,@DER(id="0546BC6D-55EF-4035-A387-9ADDC5BAE305",name="DER1N_PPMODEL_PVPART_L3PVPARTID",type="DER1N",majordeid="d1ce1f760d77192f620b4f6b9d7769f8",minordeid="14ad5675b58882f0e61ba3caabcf6f5e" ,majordename="PVPART",minordename="PPMODEL",masterrs=0,pickupdefname="L3PVPARTID")
    ,@DER(id="44B29146-69C1-4ADF-841D-287AD281BB1B",name="DER1N_PPMODEL_PVPART_L4PVPARTID",type="DER1N",majordeid="d1ce1f760d77192f620b4f6b9d7769f8",minordeid="14ad5675b58882f0e61ba3caabcf6f5e" ,majordename="PVPART",minordename="PPMODEL",masterrs=0,pickupdefname="L4PVPARTID")
    ,@DER(id="168133AE-E7F2-4ECA-AEE7-6024461A186F",name="DER1N_PPMODEL_PVPART_R1PVPARTID",type="DER1N",majordeid="d1ce1f760d77192f620b4f6b9d7769f8",minordeid="14ad5675b58882f0e61ba3caabcf6f5e" ,majordename="PVPART",minordename="PPMODEL",masterrs=0,pickupdefname="R1PVPARTID")
    ,@DER(id="90A67CD5-A745-49F6-B5A0-5761278A8C49",name="DER1N_PPMODEL_PVPART_R2PVPARTID",type="DER1N",majordeid="d1ce1f760d77192f620b4f6b9d7769f8",minordeid="14ad5675b58882f0e61ba3caabcf6f5e" ,majordename="PVPART",minordename="PPMODEL",masterrs=0,pickupdefname="R2PVPARTID")
    ,@DER(id="F28672F2-1292-47FA-8AE4-172B90EE2DC3",name="DER1N_PPMODEL_PVPART_R3PVPARTID",type="DER1N",majordeid="d1ce1f760d77192f620b4f6b9d7769f8",minordeid="14ad5675b58882f0e61ba3caabcf6f5e" ,majordename="PVPART",minordename="PPMODEL",masterrs=0,pickupdefname="R3PVPARTID")
    ,@DER(id="6245CA0A-5D44-4C18-99EF-2831C221858C",name="DER1N_PPMODEL_PVPART_R4PVPARTID",type="DER1N",majordeid="d1ce1f760d77192f620b4f6b9d7769f8",minordeid="14ad5675b58882f0e61ba3caabcf6f5e" ,majordename="PVPART",minordename="PPMODEL",masterrs=0,pickupdefname="R4PVPARTID")
    ,@DER(id="33f0a71e7c35aa4cd878d0c74f49c934",name="DER1N_PVPART_PORTALPAGE_PORTALPAGEID",type="DER1N",majordeid="f63040021720d1401ec2014d30b02bb6",minordeid="d1ce1f760d77192f620b4f6b9d7769f8" ,majordename="PORTALPAGE",minordename="PVPART",masterrs=1,pickupdefname="PORTALPAGEID")
    ,@DER(id="11a7fc0706213efb7c5b035a8f044d14",name="DER1N_QUERYMODEL_DATAENTITY_DEID",type="DER1N",majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2",minordeid="ee650aec5d0df3c9880100dc57441146" ,majordename="DATAENTITY",minordename="QUERYMODEL",masterrs=0,pickupdefname="DEID")
    ,@DER(id="e615bf186441877722a351ba6ece7d3f",name="DER1N_SYSADMINFUNC_SYSADMIN_SYSADMINID",type="DER1N",majordeid="089885ec20e095e248e78d49d3153815",minordeid="2e71859d8147cd788d815a3371f9ebd6" ,majordename="SYSADMIN",minordename="SYSADMINFUNC",masterrs=0,pickupdefname="SYSADMINID")
    ,@DER(id="9e1bd95d49cd30bbe25f4afea9267142",name="DER1N_TSSDGROUPDETAIL_TSSDGROUP_TSSDGROUPID",type="DER1N",majordeid="f37da71b9c7217fb86634c135e6fb7e0",minordeid="e8b6c72b7a73a98f68bf91b812d46c31" ,majordename="TSSDGROUP",minordename="TSSDGROUPDETAIL",masterrs=0,pickupdefname="TSSDGROUPID")
    ,@DER(id="8124434e843cf1f08d5fb07d2d54e9e7",name="DER1N_TSSDGROUPDETAIL_TSSDITEM_TSSDITEMID",type="DER1N",majordeid="7923f282cb5da8b2419d53cb6fc6e9a7",minordeid="e8b6c72b7a73a98f68bf91b812d46c31" ,majordename="TSSDITEM",minordename="TSSDGROUPDETAIL",masterrs=0,pickupdefname="TSSDITEMID")
    ,@DER(id="7e6e292c4bc8b87e33c746ce352b90f0",name="DER1N_TSSDTASKLOG_TSSDTASK_TSSDTASKID",type="DER1N",majordeid="f8d12641ce30b874fa6c58f749b0bb73",minordeid="5d9604bc9220d47f935650303d154680" ,majordename="TSSDTASK",minordename="TSSDTASKLOG",masterrs=0,pickupdefname="TSSDTASKID")
    ,@DER(id="319ae648b35fee410962855bf6d8332b",name="DER1N_TSSDTASKPOLICY_TSSDPOLICY_TSSDPOLICYID",type="DER1N",majordeid="0af0cc46519139106341b4cbfe9b89e7",minordeid="7fbddaf527849efd537411955e65800d" ,majordename="TSSDPOLICY",minordename="TSSDTASKPOLICY",masterrs=0,pickupdefname="TSSDPOLICYID")
    ,@DER(id="102d9f722bdf57754c150d249c253fe2",name="DER1N_TSSDTASKPOLICY_TSSDTASK_TSSDTASKID",type="DER1N",majordeid="f8d12641ce30b874fa6c58f749b0bb73",minordeid="7fbddaf527849efd537411955e65800d" ,majordename="TSSDTASK",minordename="TSSDTASKPOLICY",masterrs=5,pickupdefname="TSSDTASKID")
    ,@DER(id="2490b25836227a105fd744484250651d",name="DER1N_TSSDTASK_TSSDENGINE_TSSDENGINEID",type="DER1N",majordeid="e4da63c72c04866163e5a74ca984d13f",minordeid="f8d12641ce30b874fa6c58f749b0bb73" ,majordename="TSSDENGINE",minordename="TSSDTASK",masterrs=0,pickupdefname="TSSDENGINEID")
    ,@DER(id="816a3c9fc6c7c768566a343f30a9e5ad",name="DER1N_USERDICTITEM_USERDICTCAT_USERDICTCATID",type="DER1N",majordeid="c41d9a5508a558b5ccc8a091c5e249b1",minordeid="4d49318ec5a12e0a9e36d79e45c641f2" ,majordename="USERDICTCAT",minordename="USERDICTITEM",masterrs=0,pickupdefname="USERDICTCATID")
    ,@DER(id="45ea033c1c140b803db8112b9b345def",name="DER1N_USERDICTITEM_USERDICT_USERDICTID",type="DER1N",majordeid="de0f12cf67b20fb12eb5454093998c74",minordeid="4d49318ec5a12e0a9e36d79e45c641f2" ,majordename="USERDICT",minordename="USERDICTITEM",masterrs=5,pickupdefname="USERDICTID")
    ,@DER(id="a33d43efdb58f6910c5cbca43cc22930",name="DER1N_USERGROUPDETAIL_USERGROUP_USERGROUPID",type="DER1N",majordeid="5eba267a2d34c0c5dc686961a48f62d1",minordeid="404bf990bacdba520e82d9603063c3dd" ,majordename="USERGROUP",minordename="USERGROUPDETAIL",masterrs=3,pickupdefname="USERGROUPID")
    ,@DER(id="d2216828da19ff602cfdbb816d921f48",name="DER1N_USERGROUPDETAIL_USEROBJECT_USEROBJECTID",type="DER1N",majordeid="318a3649ecafa3b934925a0231207d09",minordeid="404bf990bacdba520e82d9603063c3dd" ,majordename="USEROBJECT",minordename="USERGROUPDETAIL",masterrs=3,pickupdefname="USEROBJECTID")
    ,@DER(id="14815ab047b405f1703f66aa10b011f0",name="DER1N_USERROLEDATAACTION_USERROLEDATA_USERROLEDATAID",type="DER1N",majordeid="c4125399a698dc5f8acca6dc8b38b353",minordeid="0cc63f54de2a15b9a7db47ff805af49a" ,majordename="USERROLEDATA",minordename="USERROLEDATAACTION",masterrs=1,pickupdefname="USERROLEDATAID")
    ,@DER(id="c13286609770010aadf50b74b6039785",name="DER1N_USERROLEDATADETAIL_QUERYMODEL_QUERYMODELID",type="DER1N",majordeid="ee650aec5d0df3c9880100dc57441146",minordeid="a54fc7fa42e8260cab1cb33393e222b1" ,majordename="QUERYMODEL",minordename="USERROLEDATADETAIL",masterrs=3,pickupdefname="QUERYMODELID")
    ,@DER(id="f4161eb5fbed839ac5979824062f5ec0",name="DER1N_USERROLEDATADETAIL_USERROLEDATA_USERROLEDATAID",type="DER1N",majordeid="c4125399a698dc5f8acca6dc8b38b353",minordeid="a54fc7fa42e8260cab1cb33393e222b1" ,majordename="USERROLEDATA",minordename="USERROLEDATADETAIL",masterrs=7,pickupdefname="USERROLEDATAID")
    ,@DER(id="bce5036d19290a1d1f71e80e076e1ad6",name="DER1N_USERROLEDATAS_USERROLEDATA_USERROLEDATAID",type="DER1N",majordeid="c4125399a698dc5f8acca6dc8b38b353",minordeid="b2af03b3659b89cfbfc6f8932ff1b61f" ,majordename="USERROLEDATA",minordename="USERROLEDATAS",masterrs=7,pickupdefname="USERROLEDATAID")
    ,@DER(id="009216e13b6229bf1af5bb2063006b3f",name="DER1N_USERROLEDATAS_USERROLE_USERROLEID",type="DER1N",majordeid="1e40618663977c439800bf56d8ac4390",minordeid="b2af03b3659b89cfbfc6f8932ff1b61f" ,majordename="USERROLE",minordename="USERROLEDATAS",masterrs=7,pickupdefname="USERROLEID")
    ,@DER(id="632e7bf4b3451ef4f33e536cb11e58bc",name="DER1N_USERROLEDATA_DATAENTITY_DEID",type="DER1N",majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2",minordeid="c4125399a698dc5f8acca6dc8b38b353" ,majordename="DATAENTITY",minordename="USERROLEDATA",masterrs=1,pickupdefname="DEID")
    ,@DER(id="8073CCE8-085F-438D-A69F-7B519E115ABF",name="DER1N_USERROLEDATA_ORGSECTOR_DSTORGSECTORID",type="DER1N",majordeid="63061bfdafbbd213fc0ce66d3f26419e",minordeid="c4125399a698dc5f8acca6dc8b38b353" ,majordename="ORGSECTOR",minordename="USERROLEDATA",masterrs=0,pickupdefname="DSTORGSECTORID")
    ,@DER(id="418AF732-99EB-4853-87E7-2F1D98022A03",name="DER1N_USERROLEDATA_ORG_DSTORGID",type="DER1N",majordeid="e3e158d75b7bc6f589686b6e1beb966c",minordeid="c4125399a698dc5f8acca6dc8b38b353" ,majordename="ORG",minordename="USERROLEDATA",masterrs=0,pickupdefname="DSTORGID")
    ,@DER(id="1a468bb598fd7359388e092714af54a1",name="DER1N_USERROLEDEFIELDS_USERROLEDEFIELD_USERROLEDEFIELDID",type="DER1N",majordeid="10d6c2ea8dda8754dcde1bceab9704c5",minordeid="c95a8972b0f72a140d65e057a002144a" ,majordename="USERROLEDEFIELD",minordename="USERROLEDEFIELDS",masterrs=3,pickupdefname="USERROLEDEFIELDID")
    ,@DER(id="ea0eaa76b1fe9fef40baea2da6ec5716",name="DER1N_USERROLEDEFIELDS_USERROLE_USERROLEID",type="DER1N",majordeid="1e40618663977c439800bf56d8ac4390",minordeid="c95a8972b0f72a140d65e057a002144a" ,majordename="USERROLE",minordename="USERROLEDEFIELDS",masterrs=3,pickupdefname="USERROLEID")
    ,@DER(id="eb751ef3ced5b2f39136c706a1cf8ac5",name="DER1N_USERROLEDEFIELD_DATAENTITY_DEID",type="DER1N",majordeid="0cbbb4ccda4e86a9e6f16ed5f3a171c2",minordeid="10d6c2ea8dda8754dcde1bceab9704c5" ,majordename="DATAENTITY",minordename="USERROLEDEFIELD",masterrs=0,pickupdefname="DEID")
    ,@DER(id="c5889a1d7a44fb5e162dba1377ba8dc1",name="DER1N_USERROLEDETAIL_USEROBJECT_USEROBJECTID",type="DER1N",majordeid="318a3649ecafa3b934925a0231207d09",minordeid="a6ba8b8895f3f2438f9e9ef761ccb29c" ,majordename="USEROBJECT",minordename="USERROLEDETAIL",masterrs=7,pickupdefname="USEROBJECTID")
    ,@DER(id="94ab233ca60b50ab4e8bed7281b09fc7",name="DER1N_USERROLEDETAIL_USERROLE_USERROLEID",type="DER1N",majordeid="1e40618663977c439800bf56d8ac4390",minordeid="a6ba8b8895f3f2438f9e9ef761ccb29c" ,majordename="USERROLE",minordename="USERROLEDETAIL",masterrs=7,pickupdefname="USERROLEID")
    ,@DER(id="7855e1ce00f0ec5b85f9912bd786a59d",name="DER1N_USERROLERES_UNIRES_UNIRESID",type="DER1N",majordeid="88d390ffbdb76f146f608c669729d81d",minordeid="ee84bfb6e336a62bdcd671895549aebe" ,majordename="UNIRES",minordename="USERROLERES",masterrs=3,pickupdefname="UNIRESID")
    ,@DER(id="3fabb41f1c288768eb38179ce4375b1c",name="DER1N_USERROLERES_USERROLE_USERROLEID",type="DER1N",majordeid="1e40618663977c439800bf56d8ac4390",minordeid="ee84bfb6e336a62bdcd671895549aebe" ,majordename="USERROLE",minordename="USERROLERES",masterrs=7,pickupdefname="USERROLEID")
    ,@DER(id="5f482026eec8d0778d155d7945fe9e3e",name="DER1N_WFACTION_WFWORKFLOW_WFWORKFLOWID",type="DER1N",majordeid="0166e9c016bf57201ba996cba3a67a45",minordeid="50811730d38a8bd964a31a05331bc214" ,majordename="WFWORKFLOW",minordename="WFACTION",masterrs=0,pickupdefname="WFWORKFLOWID")
    ,@DER(id="CF68E169-CAF0-4B3E-A0BD-5D625C248B91",name="DER1N_WFAPPSETTING_MSGTEMPLATE_REMINDMSGTEMPID",type="DER1N",majordeid="e2c5b96d6cb0389900da130bc4545add",minordeid="598b85c09bc9375e762590d2ab97552c" ,majordename="MSGTEMPLATE",minordename="WFAPPSETTING",masterrs=0,pickupdefname="REMINDMSGTEMPID")
    ,@DER(id="5f68ca9cf3fef51ccc62327d94d904d6",name="DER1N_WFASSISTWORK_WFINSTANCE_WFINSTANCEID",type="DER1N",majordeid="0211d06b901d7948d2394149b7d0d96e",minordeid="80bc47afe28e23ebfb7aea12fdbc1acd" ,majordename="WFINSTANCE",minordename="WFASSISTWORK",masterrs=0,pickupdefname="WFINSTANCEID")
    ,@DER(id="4e27fa512548502bb53180923b46257e",name="DER1N_WFASSISTWORK_WFSTEPACTOR_WFSTEPACTORID",type="DER1N",majordeid="3860c42c755f4097c4dfe7d806b185bc",minordeid="80bc47afe28e23ebfb7aea12fdbc1acd" ,majordename="WFSTEPACTOR",minordename="WFASSISTWORK",masterrs=0,pickupdefname="WFSTEPACTORID")
    ,@DER(id="756f259ec2f765f2556894f2575d8284",name="DER1N_WFASSISTWORK_WFWORKFLOW_WFWORKFLOWID",type="DER1N",majordeid="0166e9c016bf57201ba996cba3a67a45",minordeid="80bc47afe28e23ebfb7aea12fdbc1acd" ,majordename="WFWORKFLOW",minordename="WFASSISTWORK",masterrs=0,pickupdefname="WFWORKFLOWID")
    ,@DER(id="8de4cf4868586b92e9e7da5466952329",name="DER1N_WFIAACTION_WFSTEP_WFSTEPID",type="DER1N",majordeid="aa16d05a90245cec51dc8a2fb7f63fdb",minordeid="e1ba3122fd9af91ae76dd18bf015669a" ,majordename="WFSTEP",minordename="WFIAACTION",masterrs=0,pickupdefname="WFSTEPID")
    ,@DER(id="320BB681-03BC-4218-87F8-E425B288AE97",name="DER1N_WFINSTANCE_ORG_ORGID",type="DER1N",majordeid="e3e158d75b7bc6f589686b6e1beb966c",minordeid="0211d06b901d7948d2394149b7d0d96e" ,majordename="ORG",minordename="WFINSTANCE",masterrs=0,pickupdefname="ORGID")
    ,@DER(id="0e24814e3d1572e3f06d4f36c7c5de9f",name="DER1N_WFINSTANCE_WFINSTANCE_PWFINSTANCEID",type="DER1N",majordeid="0211d06b901d7948d2394149b7d0d96e",minordeid="0211d06b901d7948d2394149b7d0d96e" ,majordename="WFINSTANCE",minordename="WFINSTANCE",masterrs=0,pickupdefname="PWFINSTANCEID")
    ,@DER(id="8097c1878cf34b7d5a2618d26684dcb5",name="DER1N_WFINSTANCE_WFWORKFLOW_WFWORKFLOWID",type="DER1N",majordeid="0166e9c016bf57201ba996cba3a67a45",minordeid="0211d06b901d7948d2394149b7d0d96e" ,majordename="WFWORKFLOW",minordename="WFINSTANCE",masterrs=0,pickupdefname="WFWORKFLOWID")
    ,@DER(id="2112baeba2c7f01d9862c28344770bb3",name="DER1N_WFREMINDER_WFSTEPACTOR_WFSTEPACTORID",type="DER1N",majordeid="3860c42c755f4097c4dfe7d806b185bc",minordeid="352ff0280b4d127a400f4262d6ebfded" ,majordename="WFSTEPACTOR",minordename="WFREMINDER",masterrs=0,pickupdefname="WFSTEPACTORID")
    ,@DER(id="a0a110c3f3c7328f10e027bc9cbad882",name="DER1N_WFREMINDER_WFUSER_WFUSERID",type="DER1N",majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48",minordeid="352ff0280b4d127a400f4262d6ebfded" ,majordename="WFUSER",minordename="WFREMINDER",masterrs=0,pickupdefname="WFUSERID")
    ,@DER(id="df958687a02982a4cd68af51ad5732ef",name="DER1N_WFSTEPACTOR_WFSTEP_WFSTEPID",type="DER1N",majordeid="aa16d05a90245cec51dc8a2fb7f63fdb",minordeid="3860c42c755f4097c4dfe7d806b185bc" ,majordename="WFSTEP",minordename="WFSTEPACTOR",masterrs=0,pickupdefname="WFSTEPID")
    ,@DER(id="005C8C79-8C7E-4A68-A7C3-1E8E0D09FCC4",name="DER1N_WFSTEPACTOR_WFUSER_ORIGINALWFUSERID",type="DER1N",majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48",minordeid="3860c42c755f4097c4dfe7d806b185bc" ,majordename="WFUSER",minordename="WFSTEPACTOR",masterrs=0,pickupdefname="ORIGINALWFUSERID")
    ,@DER(id="616cb82677f494e69eebd92deec244f9",name="DER1N_WFSTEPDATA_WFINSTANCE_WFINSTANCEID",type="DER1N",majordeid="0211d06b901d7948d2394149b7d0d96e",minordeid="095ff4eab83529a1b8f093180a7ef3fa" ,majordename="WFINSTANCE",minordename="WFSTEPDATA",masterrs=0,pickupdefname="WFINSTANCEID")
    ,@DER(id="5f80942fa364725bebae0ba7029344f7",name="DER1N_WFSTEPDATA_WFSTEP_WFSTEPID",type="DER1N",majordeid="aa16d05a90245cec51dc8a2fb7f63fdb",minordeid="095ff4eab83529a1b8f093180a7ef3fa" ,majordename="WFSTEP",minordename="WFSTEPDATA",masterrs=0,pickupdefname="WFSTEPID")
    ,@DER(id="62982D23-52D6-46B4-86A3-A35358D31E3D",name="DER1N_WFSTEPDATA_WFUSER_ORIGINALWFUSERID",type="DER1N",majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48",minordeid="095ff4eab83529a1b8f093180a7ef3fa" ,majordename="WFUSER",minordename="WFSTEPDATA",masterrs=0,pickupdefname="ORIGINALWFUSERID")
    ,@DER(id="3072ea9cfb909379f3b4fb234d646e45",name="DER1N_WFSTEPINST_WFINSTANCE_WFINSTANCEID",type="DER1N",majordeid="0211d06b901d7948d2394149b7d0d96e",minordeid="707f76a538be385bf4bf65a2b1125003" ,majordename="WFINSTANCE",minordename="WFSTEPINST",masterrs=0,pickupdefname="WFINSTANCEID")
    ,@DER(id="ad2f6511189748f7d19fb8e45781e988",name="DER1N_WFSTEPINST_WFSTEP_WFSTEPID",type="DER1N",majordeid="aa16d05a90245cec51dc8a2fb7f63fdb",minordeid="707f76a538be385bf4bf65a2b1125003" ,majordename="WFSTEP",minordename="WFSTEPINST",masterrs=0,pickupdefname="WFSTEPID")
    ,@DER(id="ed32886f9f70deccef8b87f2f5dafab5",name="DER1N_WFSTEP_WFINSTANCE_WFINSTANCEID",type="DER1N",majordeid="0211d06b901d7948d2394149b7d0d96e",minordeid="aa16d05a90245cec51dc8a2fb7f63fdb" ,majordename="WFINSTANCE",minordename="WFSTEP",masterrs=0,pickupdefname="WFINSTANCEID")
    ,@DER(id="ab31530b21b9769706f6a2fbeeb9f9a7",name="DER1N_WFTMPSTEPACTOR_WFACTOR_WFACTORID",type="DER1N",majordeid="a532b2dae4eeecca638c9a8e1b7e3fa7",minordeid="0e976da1c2895bf2e955f90554c10b15" ,majordename="WFACTOR",minordename="WFTMPSTEPACTOR",masterrs=0,pickupdefname="WFACTORID")
    ,@DER(id="c63d3e12576fa39727d412500b8987f4",name="DER1N_WFTMPSTEPACTOR_WFSTEP_PREVWFSTEPID",type="DER1N",majordeid="aa16d05a90245cec51dc8a2fb7f63fdb",minordeid="0e976da1c2895bf2e955f90554c10b15" ,majordename="WFSTEP",minordename="WFTMPSTEPACTOR",masterrs=0,pickupdefname="PREVWFSTEPID")
    ,@DER(id="75e6cc0f9a99dfa020b0520a0f76f28d",name="DER1N_WFUCPOLICY_WFUSER_MAJORWFUSERID",type="DER1N",majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48",minordeid="fa6ff2a161c8371f494e170dde6ddb53" ,majordename="WFUSER",minordename="WFUCPOLICY",masterrs=5,pickupdefname="MAJORWFUSERID")
    ,@DER(id="cdeb6924e468218750aa54ffd43fbe91",name="DER1N_WFUCPOLICY_WFUSER_MINORWFUSERID",type="DER1N",majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48",minordeid="fa6ff2a161c8371f494e170dde6ddb53" ,majordename="WFUSER",minordename="WFUCPOLICY",masterrs=0,pickupdefname="MINORWFUSERID")
    ,@DER(id="69c0793b95a21868e494577c5fc3cd5c",name="DER1N_WFUSERASSIST_WFUSER_WFMAJORUSERID",type="DER1N",majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48",minordeid="c0a02fe821e07837af3333a49fb08b30" ,majordename="WFUSER",minordename="WFUSERASSIST",masterrs=0,pickupdefname="WFMAJORUSERID")
    ,@DER(id="748c7e4b9050643eca7dafc43e9ed0fd",name="DER1N_WFUSERASSIST_WFUSER_WFMINORUSERID",type="DER1N",majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48",minordeid="c0a02fe821e07837af3333a49fb08b30" ,majordename="WFUSER",minordename="WFUSERASSIST",masterrs=0,pickupdefname="WFMINORUSERID")
    ,@DER(id="ddc14d8f88d17c3a4c3caddf78a99357",name="DER1N_WFUSERASSIST_WFWORKFLOW_WFWORKFLOWID",type="DER1N",majordeid="0166e9c016bf57201ba996cba3a67a45",minordeid="c0a02fe821e07837af3333a49fb08b30" ,majordename="WFWORKFLOW",minordename="WFUSERASSIST",masterrs=0,pickupdefname="WFWORKFLOWID")
    ,@DER(id="48824f5e6e0527d348c27233c8541df7",name="DER1N_WFUSERCANDIDATE_WFUSER_WFMAJORUSERID",type="DER1N",majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48",minordeid="9f2a5bbda357d70344cb5debd7d05c71" ,majordename="WFUSER",minordename="WFUSERCANDIDATE",masterrs=0,pickupdefname="WFMAJORUSERID")
    ,@DER(id="8d9808ac3dd5b5d89db44f2a2a3da1c4",name="DER1N_WFUSERCANDIDATE_WFUSER_WFMINORUSERID",type="DER1N",majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48",minordeid="9f2a5bbda357d70344cb5debd7d05c71" ,majordename="WFUSER",minordename="WFUSERCANDIDATE",masterrs=0,pickupdefname="WFMINORUSERID")
    ,@DER(id="3394c2a890c8f95f5864a8656ec0423a",name="DER1N_WFUSERGROUPDETAIL_WFUSERGROUP_WFUSERGROUPID",type="DER1N",majordeid="e64a576e41250c73ac1f51c15d6631e2",minordeid="0b60b3e6ed35cc656ceecb6fac698e6e" ,majordename="WFUSERGROUP",minordename="WFUSERGROUPDETAIL",masterrs=3,pickupdefname="WFUSERGROUPID")
    ,@DER(id="376e40d56e10ff46457f47a8dd066db0",name="DER1N_WFUSERGROUPDETAIL_WFUSER_WFUSERID",type="DER1N",majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48",minordeid="0b60b3e6ed35cc656ceecb6fac698e6e" ,majordename="WFUSER",minordename="WFUSERGROUPDETAIL",masterrs=3,pickupdefname="WFUSERID")
    ,@DER(id="062f9bbb6348d5a732fc7152835525d8",name="DER1N_WFWFVERSION_WFWORKFLOW_WFWFID",type="DER1N",majordeid="0166e9c016bf57201ba996cba3a67a45",minordeid="f0abca40127ddf436270635ba0e3c135" ,majordename="WFWORKFLOW",minordename="WFWFVERSION",masterrs=0,pickupdefname="WFWFID")
    ,@DER(id="0780B21E-BFC7-44A1-934D-21FF0F7834A5",name="DER1N_WFWORKFLOW_MSGTEMPLATE_REMINDMSGTEMPLID",type="DER1N",majordeid="e2c5b96d6cb0389900da130bc4545add",minordeid="0166e9c016bf57201ba996cba3a67a45" ,majordename="MSGTEMPLATE",minordename="WFWORKFLOW",masterrs=0,pickupdefname="REMINDMSGTEMPLID")
    ,@DER(id="8F946D79-D3FA-41EC-B8D4-3F4C84606912",name="DER1N_WFWORKLIST2_WFINSTANCE_WFINSTANCEID",type="DER1N",majordeid="0211d06b901d7948d2394149b7d0d96e",minordeid="e888ed9d1cfcb38ac15cceaa4130b162" ,majordename="WFINSTANCE",minordename="WFWORKLIST2",masterrs=0,pickupdefname="WFINSTANCEID")
    ,@DER(id="667736E8-E0DE-4FEA-96CF-2EF9E04DB7A8",name="DER1N_WFWORKLIST2_WFUSER_ORIGINALWFUSERID",type="DER1N",majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48",minordeid="e888ed9d1cfcb38ac15cceaa4130b162" ,majordename="WFUSER",minordename="WFWORKLIST2",masterrs=0,pickupdefname="ORIGINALWFUSERID")
    ,@DER(id="802abef14e1abf4be1f76c09383c19de",name="DER1N_WFWORKLIST_WFINSTANCE_WFINSTANCEID",type="DER1N",majordeid="0211d06b901d7948d2394149b7d0d96e",minordeid="c93ef4408352303441d2f73e0e4990a2" ,majordename="WFINSTANCE",minordename="WFWORKLIST",masterrs=0,pickupdefname="WFINSTANCEID")
    ,@DER(id="A764D6F8-DCD8-4670-AE22-6984474CDD1C",name="DER1N_WFWORKLIST_WFUSER_ORIGINALWFUSERID",type="DER1N",majordeid="ef2c7b349c855e594aa4fe0cb7ad8b48",minordeid="c93ef4408352303441d2f73e0e4990a2" ,majordename="WFUSER",minordename="WFWORKLIST",masterrs=0,pickupdefname="ORIGINALWFUSERID")
    ,@DER(id="4a1aa49749e2057269bba6a500bd0ab7",name="DER1N_WXACCESSTOKEN_WXACCOUNT_WXACCOUNTID",type="DER1N",majordeid="a807f4b43d86fbcad55c58e4621a8c80",minordeid="7c0817a9156329b7eed4a878988f31cc" ,majordename="WXACCOUNT",minordename="WXACCESSTOKEN",masterrs=0,pickupdefname="WXACCOUNTID")
    ,@DER(id="c66aa6aa9829065286380810811d4993",name="DER1N_WXACCOUNT_ORG_ORGID",type="DER1N",majordeid="e3e158d75b7bc6f589686b6e1beb966c",minordeid="a807f4b43d86fbcad55c58e4621a8c80" ,majordename="ORG",minordename="WXACCOUNT",masterrs=0,pickupdefname="ORGID")
    ,@DER(id="0c3183f54dde288ca2faaa5a2a72d5e9",name="DER1N_WXENTAPP_WXACCOUNT_WXACCOUNTID",type="DER1N",majordeid="a807f4b43d86fbcad55c58e4621a8c80",minordeid="aeb4861b6d65eff3ef2098ddd7a0d4f5" ,majordename="WXACCOUNT",minordename="WXENTAPP",masterrs=0,pickupdefname="WXACCOUNTID")
    ,@DER(id="4aa536c534ffdc4cb313289b449291da",name="DER1N_WXMEDIA_WXACCOUNT_WXACCOUNTID",type="DER1N",majordeid="a807f4b43d86fbcad55c58e4621a8c80",minordeid="6e265a32be682141a452a8832bc78530" ,majordename="WXACCOUNT",minordename="WXMEDIA",masterrs=0,pickupdefname="WXACCOUNTID")
    ,@DER(id="2e9be8bfb53a6e12b1fe91a6d96081b1",name="DER1N_WXMEDIA_WXENTAPP_WXENTAPPID",type="DER1N",majordeid="aeb4861b6d65eff3ef2098ddd7a0d4f5",minordeid="6e265a32be682141a452a8832bc78530" ,majordename="WXENTAPP",minordename="WXMEDIA",masterrs=0,pickupdefname="WXENTAPPID")
    ,@DER(id="e489a0c18fefe28b35f154f7c63eaa3a",name="DER1N_WXMESSAGE_WXACCOUNT_WXACCOUNTID",type="DER1N",majordeid="a807f4b43d86fbcad55c58e4621a8c80",minordeid="657d40a805a0f204934829160a198bb7" ,majordename="WXACCOUNT",minordename="WXMESSAGE",masterrs=0,pickupdefname="WXACCOUNTID")
    ,@DER(id="033908d98baf605c5f0136b12140a381",name="DER1N_WXMESSAGE_WXENTAPP_WXENTAPPID",type="DER1N",majordeid="aeb4861b6d65eff3ef2098ddd7a0d4f5",minordeid="657d40a805a0f204934829160a198bb7" ,majordename="WXENTAPP",minordename="WXMESSAGE",masterrs=0,pickupdefname="WXENTAPPID")
    ,@DER(id="a318a4042da740195b6afdebe4047f25",name="DER1N_WXORGSECTOR_ORGSECTOR_ORGSECTORID",type="DER1N",majordeid="63061bfdafbbd213fc0ce66d3f26419e",minordeid="2b5ee3ad72f76d2cb7d12f8c5f31b817" ,majordename="ORGSECTOR",minordename="WXORGSECTOR",masterrs=0,pickupdefname="ORGSECTORID")
    ,@DER(id="3d51e9b7863df17d47d50c73a21a1413",name="DER1N_WXORGSECTOR_WXACCOUNT_WXACCOUNTID",type="DER1N",majordeid="a807f4b43d86fbcad55c58e4621a8c80",minordeid="2b5ee3ad72f76d2cb7d12f8c5f31b817" ,majordename="WXACCOUNT",minordename="WXORGSECTOR",masterrs=0,pickupdefname="WXACCOUNTID")
    ,@DER(id="a7f689243bc823d7aea798e6c7f3b7a6",name="DERINDEX_WFDYNAMICUSER_WFACTOR",type="DERINDEX",majordeid="a532b2dae4eeecca638c9a8e1b7e3fa7",minordeid="733170434261be84089d353a6a231373" ,majordename="WFACTOR",minordename="WFDYNAMICUSER",indexvalue="DYNAMICUSER")
    ,@DER(id="239b3eb687da5f9fc4c32559bb8b12c9",name="DERINDEX_WFSYSTEMUSER_WFACTOR",type="DERINDEX",majordeid="a532b2dae4eeecca638c9a8e1b7e3fa7",minordeid="3d6fd9746bb1acf4b6af87da05f6a646" ,majordename="WFACTOR",minordename="WFSYSTEMUSER",indexvalue="SYSTEMUSER")
    ,@DER(id="da7e61a04a493ac3a5de582c1cf7ff21",name="DERINDEX_WFUSERGROUP_WFACTOR",type="DERINDEX",majordeid="a532b2dae4eeecca638c9a8e1b7e3fa7",minordeid="e64a576e41250c73ac1f51c15d6631e2" ,majordename="WFACTOR",minordename="WFUSERGROUP",indexvalue="USERGROUP")
    ,@DER(id="b66d862165d2dc4ced13946380ee8910",name="DERINDEX_WFUSER_WFACTOR",type="DERINDEX",majordeid="a532b2dae4eeecca638c9a8e1b7e3fa7",minordeid="ef2c7b349c855e594aa4fe0cb7ad8b48" ,majordename="WFACTOR",minordename="WFUSER",indexvalue="USER")
    ,@DER(id="c0558f7368a6a1a9ec5fbb5c8de6a8b9",name="DERINHERIT_USERGROUP_USEROBJECT",type="DERINHERIT",majordeid="318a3649ecafa3b934925a0231207d09",minordeid="5eba267a2d34c0c5dc686961a48f62d1" ,majordename="USEROBJECT",minordename="USERGROUP",indexvalue="USERGROUP")
    ,@DER(id="403d507e89bbf1c6ec3c33e4bed9df17",name="DERINHERIT_USER_USEROBJECT",type="DERINHERIT",majordeid="318a3649ecafa3b934925a0231207d09",minordeid="f4552a6291c79e3934263b31b83aec33" ,majordename="USEROBJECT",minordename="USER",indexvalue="USER")
})
/**
 * 系统[PSRuntime]模型对象基类
 */
public abstract class PSRuntimeSysModelBase extends net.ibizsys.paas.sysmodel.SystemModelBase  {

    private static final Log log = LogFactory.getLog(PSRuntimeSysModelBase.class);
    /**
     * 实体关系[DER1N_CODEITEM_CODEITEM_PCODEITEMID]
     */
    public static final String DER1N_CODEITEM_CODEITEM_PCODEITEMID = "DER1N_CODEITEM_CODEITEM_PCODEITEMID";
    /**
     * 实体关系[DER1N_CODEITEM_CODELIST_CODELISTID]
     */
    public static final String DER1N_CODEITEM_CODELIST_CODELISTID = "DER1N_CODEITEM_CODELIST_CODELISTID";
    /**
     * 实体关系[DER1N_CODELIST_DATAENTITY_DEID]
     */
    public static final String DER1N_CODELIST_DATAENTITY_DEID = "DER1N_CODELIST_DATAENTITY_DEID";
    /**
     * 实体关系[DER1N_DATAAUDITDETAIL_DATAAUDIT_DATAAUDITID]
     */
    public static final String DER1N_DATAAUDITDETAIL_DATAAUDIT_DATAAUDITID = "DER1N_DATAAUDITDETAIL_DATAAUDIT_DATAAUDITID";
    /**
     * 实体关系[DER1N_DATAENTITY_DATAENTITY_DER11DEID]
     */
    public static final String DER1N_DATAENTITY_DATAENTITY_DER11DEID = "DER1N_DATAENTITY_DATAENTITY_DER11DEID";
    /**
     * 实体关系[DER1N_DATAENTITY_QUERYMODEL_ACQUERYMODELID]
     */
    public static final String DER1N_DATAENTITY_QUERYMODEL_ACQUERYMODELID = "DER1N_DATAENTITY_QUERYMODEL_ACQUERYMODELID";
    /**
     * 实体关系[DER1N_DATASYNCIN2_DATAENTITY_DEID]
     */
    public static final String DER1N_DATASYNCIN2_DATAENTITY_DEID = "DER1N_DATASYNCIN2_DATAENTITY_DEID";
    /**
     * 实体关系[DER1N_DATASYNCIN_DATAENTITY_DEID]
     */
    public static final String DER1N_DATASYNCIN_DATAENTITY_DEID = "DER1N_DATASYNCIN_DATAENTITY_DEID";
    /**
     * 实体关系[DER1N_DATASYNCOUT2_DATAENTITY_DEID]
     */
    public static final String DER1N_DATASYNCOUT2_DATAENTITY_DEID = "DER1N_DATASYNCOUT2_DATAENTITY_DEID";
    /**
     * 实体关系[DER1N_DATASYNCOUT_DATAENTITY_DEID]
     */
    public static final String DER1N_DATASYNCOUT_DATAENTITY_DEID = "DER1N_DATASYNCOUT_DATAENTITY_DEID";
    /**
     * 实体关系[DER1N_DEDATACHG2_DATAENTITY_DEID]
     */
    public static final String DER1N_DEDATACHG2_DATAENTITY_DEID = "DER1N_DEDATACHG2_DATAENTITY_DEID";
    /**
     * 实体关系[DER1N_DEDATACHG_DATAENTITY_DEID]
     */
    public static final String DER1N_DEDATACHG_DATAENTITY_DEID = "DER1N_DEDATACHG_DATAENTITY_DEID";
    /**
     * 实体关系[DER1N_DSDYNAVIEWINST_DSDYNAVIEW_DSDYNAVIEWID]
     */
    public static final String DER1N_DSDYNAVIEWINST_DSDYNAVIEW_DSDYNAVIEWID = "DER1N_DSDYNAVIEWINST_DSDYNAVIEW_DSDYNAVIEWID";
    /**
     * 实体关系[DER1N_DSDYNAWFVER_DSDYNAWF_DSDYNAWFID]
     */
    public static final String DER1N_DSDYNAWFVER_DSDYNAWF_DSDYNAWFID = "DER1N_DSDYNAWFVER_DSDYNAWF_DSDYNAWFID";
    /**
     * 实体关系[DER1N_LOGINACCOUNT_USER_USERID]
     */
    public static final String DER1N_LOGINACCOUNT_USER_USERID = "DER1N_LOGINACCOUNT_USER_USERID";
    /**
     * 实体关系[DER1N_LOGINLOG_LOGINACCOUNT_LOGINACCOUNTID]
     */
    public static final String DER1N_LOGINLOG_LOGINACCOUNT_LOGINACCOUNTID = "DER1N_LOGINLOG_LOGINACCOUNT_LOGINACCOUNTID";
    /**
     * 实体关系[DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MAJORMSGACCOUNTID]
     */
    public static final String DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MAJORMSGACCOUNTID = "DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MAJORMSGACCOUNTID";
    /**
     * 实体关系[DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MINORMSGACCOUNTID]
     */
    public static final String DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MINORMSGACCOUNTID = "DER1N_MSGACCOUNTDETAIL_MSGACCOUNT_MINORMSGACCOUNTID";
    /**
     * 实体关系[DER1N_MSGTEMPLATE_DATAENTITY_DEID]
     */
    public static final String DER1N_MSGTEMPLATE_DATAENTITY_DEID = "DER1N_MSGTEMPLATE_DATAENTITY_DEID";
    /**
     * 实体关系[DER1N_ORGSECTOR_ORGSECTOR_PORGSECTORID]
     */
    public static final String DER1N_ORGSECTOR_ORGSECTOR_PORGSECTORID = "DER1N_ORGSECTOR_ORGSECTOR_PORGSECTORID";
    /**
     * 实体关系[DER1N_ORGSECTOR_ORGSECTOR_REPORGSECTORID]
     */
    public static final String DER1N_ORGSECTOR_ORGSECTOR_REPORGSECTORID = "DER1N_ORGSECTOR_ORGSECTOR_REPORGSECTORID";
    /**
     * 实体关系[DER1N_ORGSECTOR_ORG_ORGID]
     */
    public static final String DER1N_ORGSECTOR_ORG_ORGID = "DER1N_ORGSECTOR_ORG_ORGID";
    /**
     * 实体关系[DER1N_ORGSECUSER_ORGSECTOR_ORGSECTORID]
     */
    public static final String DER1N_ORGSECUSER_ORGSECTOR_ORGSECTORID = "DER1N_ORGSECUSER_ORGSECTOR_ORGSECTORID";
    /**
     * 实体关系[DER1N_ORGSECUSER_ORGSECUSERTYPE_ORGSECUSERTYPEID]
     */
    public static final String DER1N_ORGSECUSER_ORGSECUSERTYPE_ORGSECUSERTYPEID = "DER1N_ORGSECUSER_ORGSECUSERTYPE_ORGSECUSERTYPEID";
    /**
     * 实体关系[DER1N_ORGSECUSER_ORGUSER_ORGUSERID]
     */
    public static final String DER1N_ORGSECUSER_ORGUSER_ORGUSERID = "DER1N_ORGSECUSER_ORGUSER_ORGUSERID";
    /**
     * 实体关系[DER1N_ORGSECUSER_ORG_ORGID]
     */
    public static final String DER1N_ORGSECUSER_ORG_ORGID = "DER1N_ORGSECUSER_ORG_ORGID";
    /**
     * 实体关系[DER1N_ORGUSER_ORGSECTOR_ORGSECTORID]
     */
    public static final String DER1N_ORGUSER_ORGSECTOR_ORGSECTORID = "DER1N_ORGUSER_ORGSECTOR_ORGSECTORID";
    /**
     * 实体关系[DER1N_ORGUSER_ORGSECUSERTYPE_ORGSECUSERTYPEID]
     */
    public static final String DER1N_ORGUSER_ORGSECUSERTYPE_ORGSECUSERTYPEID = "DER1N_ORGUSER_ORGSECUSERTYPE_ORGSECUSERTYPEID";
    /**
     * 实体关系[DER1N_ORGUSER_ORGUSERLEVEL_ORGUSERLEVELID]
     */
    public static final String DER1N_ORGUSER_ORGUSERLEVEL_ORGUSERLEVELID = "DER1N_ORGUSER_ORGUSERLEVEL_ORGUSERLEVELID";
    /**
     * 实体关系[DER1N_ORGUSER_ORG_ORGID]
     */
    public static final String DER1N_ORGUSER_ORG_ORGID = "DER1N_ORGUSER_ORG_ORGID";
    /**
     * 实体关系[DER1N_ORG_ORG_PORGID]
     */
    public static final String DER1N_ORG_ORG_PORGID = "DER1N_ORG_ORG_PORGID";
    /**
     * 实体关系[DER1N_PPMODEL_PORTALPAGE_PORTALPAGEID]
     */
    public static final String DER1N_PPMODEL_PORTALPAGE_PORTALPAGEID = "DER1N_PPMODEL_PORTALPAGE_PORTALPAGEID";
    /**
     * 实体关系[DER1N_PPMODEL_PVPART_C1PVPARTID]
     */
    public static final String DER1N_PPMODEL_PVPART_C1PVPARTID = "DER1N_PPMODEL_PVPART_C1PVPARTID";
    /**
     * 实体关系[DER1N_PPMODEL_PVPART_C2PVPARTID]
     */
    public static final String DER1N_PPMODEL_PVPART_C2PVPARTID = "DER1N_PPMODEL_PVPART_C2PVPARTID";
    /**
     * 实体关系[DER1N_PPMODEL_PVPART_C3PVPARTID]
     */
    public static final String DER1N_PPMODEL_PVPART_C3PVPARTID = "DER1N_PPMODEL_PVPART_C3PVPARTID";
    /**
     * 实体关系[DER1N_PPMODEL_PVPART_C4PVPARTID]
     */
    public static final String DER1N_PPMODEL_PVPART_C4PVPARTID = "DER1N_PPMODEL_PVPART_C4PVPARTID";
    /**
     * 实体关系[DER1N_PPMODEL_PVPART_L1PVPARTID]
     */
    public static final String DER1N_PPMODEL_PVPART_L1PVPARTID = "DER1N_PPMODEL_PVPART_L1PVPARTID";
    /**
     * 实体关系[DER1N_PPMODEL_PVPART_L2PVPARTID]
     */
    public static final String DER1N_PPMODEL_PVPART_L2PVPARTID = "DER1N_PPMODEL_PVPART_L2PVPARTID";
    /**
     * 实体关系[DER1N_PPMODEL_PVPART_L3PVPARTID]
     */
    public static final String DER1N_PPMODEL_PVPART_L3PVPARTID = "DER1N_PPMODEL_PVPART_L3PVPARTID";
    /**
     * 实体关系[DER1N_PPMODEL_PVPART_L4PVPARTID]
     */
    public static final String DER1N_PPMODEL_PVPART_L4PVPARTID = "DER1N_PPMODEL_PVPART_L4PVPARTID";
    /**
     * 实体关系[DER1N_PPMODEL_PVPART_R1PVPARTID]
     */
    public static final String DER1N_PPMODEL_PVPART_R1PVPARTID = "DER1N_PPMODEL_PVPART_R1PVPARTID";
    /**
     * 实体关系[DER1N_PPMODEL_PVPART_R2PVPARTID]
     */
    public static final String DER1N_PPMODEL_PVPART_R2PVPARTID = "DER1N_PPMODEL_PVPART_R2PVPARTID";
    /**
     * 实体关系[DER1N_PPMODEL_PVPART_R3PVPARTID]
     */
    public static final String DER1N_PPMODEL_PVPART_R3PVPARTID = "DER1N_PPMODEL_PVPART_R3PVPARTID";
    /**
     * 实体关系[DER1N_PPMODEL_PVPART_R4PVPARTID]
     */
    public static final String DER1N_PPMODEL_PVPART_R4PVPARTID = "DER1N_PPMODEL_PVPART_R4PVPARTID";
    /**
     * 实体关系[DER1N_PVPART_PORTALPAGE_PORTALPAGEID]
     */
    public static final String DER1N_PVPART_PORTALPAGE_PORTALPAGEID = "DER1N_PVPART_PORTALPAGE_PORTALPAGEID";
    /**
     * 实体关系[DER1N_QUERYMODEL_DATAENTITY_DEID]
     */
    public static final String DER1N_QUERYMODEL_DATAENTITY_DEID = "DER1N_QUERYMODEL_DATAENTITY_DEID";
    /**
     * 实体关系[DER1N_SYSADMINFUNC_SYSADMIN_SYSADMINID]
     */
    public static final String DER1N_SYSADMINFUNC_SYSADMIN_SYSADMINID = "DER1N_SYSADMINFUNC_SYSADMIN_SYSADMINID";
    /**
     * 实体关系[DER1N_TSSDGROUPDETAIL_TSSDGROUP_TSSDGROUPID]
     */
    public static final String DER1N_TSSDGROUPDETAIL_TSSDGROUP_TSSDGROUPID = "DER1N_TSSDGROUPDETAIL_TSSDGROUP_TSSDGROUPID";
    /**
     * 实体关系[DER1N_TSSDGROUPDETAIL_TSSDITEM_TSSDITEMID]
     */
    public static final String DER1N_TSSDGROUPDETAIL_TSSDITEM_TSSDITEMID = "DER1N_TSSDGROUPDETAIL_TSSDITEM_TSSDITEMID";
    /**
     * 实体关系[DER1N_TSSDTASKLOG_TSSDTASK_TSSDTASKID]
     */
    public static final String DER1N_TSSDTASKLOG_TSSDTASK_TSSDTASKID = "DER1N_TSSDTASKLOG_TSSDTASK_TSSDTASKID";
    /**
     * 实体关系[DER1N_TSSDTASKPOLICY_TSSDPOLICY_TSSDPOLICYID]
     */
    public static final String DER1N_TSSDTASKPOLICY_TSSDPOLICY_TSSDPOLICYID = "DER1N_TSSDTASKPOLICY_TSSDPOLICY_TSSDPOLICYID";
    /**
     * 实体关系[DER1N_TSSDTASKPOLICY_TSSDTASK_TSSDTASKID]
     */
    public static final String DER1N_TSSDTASKPOLICY_TSSDTASK_TSSDTASKID = "DER1N_TSSDTASKPOLICY_TSSDTASK_TSSDTASKID";
    /**
     * 实体关系[DER1N_TSSDTASK_TSSDENGINE_TSSDENGINEID]
     */
    public static final String DER1N_TSSDTASK_TSSDENGINE_TSSDENGINEID = "DER1N_TSSDTASK_TSSDENGINE_TSSDENGINEID";
    /**
     * 实体关系[DER1N_USERDICTITEM_USERDICTCAT_USERDICTCATID]
     */
    public static final String DER1N_USERDICTITEM_USERDICTCAT_USERDICTCATID = "DER1N_USERDICTITEM_USERDICTCAT_USERDICTCATID";
    /**
     * 实体关系[DER1N_USERDICTITEM_USERDICT_USERDICTID]
     */
    public static final String DER1N_USERDICTITEM_USERDICT_USERDICTID = "DER1N_USERDICTITEM_USERDICT_USERDICTID";
    /**
     * 实体关系[DER1N_USERGROUPDETAIL_USERGROUP_USERGROUPID]
     */
    public static final String DER1N_USERGROUPDETAIL_USERGROUP_USERGROUPID = "DER1N_USERGROUPDETAIL_USERGROUP_USERGROUPID";
    /**
     * 实体关系[DER1N_USERGROUPDETAIL_USEROBJECT_USEROBJECTID]
     */
    public static final String DER1N_USERGROUPDETAIL_USEROBJECT_USEROBJECTID = "DER1N_USERGROUPDETAIL_USEROBJECT_USEROBJECTID";
    /**
     * 实体关系[DER1N_USERROLEDATAACTION_USERROLEDATA_USERROLEDATAID]
     */
    public static final String DER1N_USERROLEDATAACTION_USERROLEDATA_USERROLEDATAID = "DER1N_USERROLEDATAACTION_USERROLEDATA_USERROLEDATAID";
    /**
     * 实体关系[DER1N_USERROLEDATADETAIL_QUERYMODEL_QUERYMODELID]
     */
    public static final String DER1N_USERROLEDATADETAIL_QUERYMODEL_QUERYMODELID = "DER1N_USERROLEDATADETAIL_QUERYMODEL_QUERYMODELID";
    /**
     * 实体关系[DER1N_USERROLEDATADETAIL_USERROLEDATA_USERROLEDATAID]
     */
    public static final String DER1N_USERROLEDATADETAIL_USERROLEDATA_USERROLEDATAID = "DER1N_USERROLEDATADETAIL_USERROLEDATA_USERROLEDATAID";
    /**
     * 实体关系[DER1N_USERROLEDATAS_USERROLEDATA_USERROLEDATAID]
     */
    public static final String DER1N_USERROLEDATAS_USERROLEDATA_USERROLEDATAID = "DER1N_USERROLEDATAS_USERROLEDATA_USERROLEDATAID";
    /**
     * 实体关系[DER1N_USERROLEDATAS_USERROLE_USERROLEID]
     */
    public static final String DER1N_USERROLEDATAS_USERROLE_USERROLEID = "DER1N_USERROLEDATAS_USERROLE_USERROLEID";
    /**
     * 实体关系[DER1N_USERROLEDATA_DATAENTITY_DEID]
     */
    public static final String DER1N_USERROLEDATA_DATAENTITY_DEID = "DER1N_USERROLEDATA_DATAENTITY_DEID";
    /**
     * 实体关系[DER1N_USERROLEDATA_ORGSECTOR_DSTORGSECTORID]
     */
    public static final String DER1N_USERROLEDATA_ORGSECTOR_DSTORGSECTORID = "DER1N_USERROLEDATA_ORGSECTOR_DSTORGSECTORID";
    /**
     * 实体关系[DER1N_USERROLEDATA_ORG_DSTORGID]
     */
    public static final String DER1N_USERROLEDATA_ORG_DSTORGID = "DER1N_USERROLEDATA_ORG_DSTORGID";
    /**
     * 实体关系[DER1N_USERROLEDEFIELDS_USERROLEDEFIELD_USERROLEDEFIELDID]
     */
    public static final String DER1N_USERROLEDEFIELDS_USERROLEDEFIELD_USERROLEDEFIELDID = "DER1N_USERROLEDEFIELDS_USERROLEDEFIELD_USERROLEDEFIELDID";
    /**
     * 实体关系[DER1N_USERROLEDEFIELDS_USERROLE_USERROLEID]
     */
    public static final String DER1N_USERROLEDEFIELDS_USERROLE_USERROLEID = "DER1N_USERROLEDEFIELDS_USERROLE_USERROLEID";
    /**
     * 实体关系[DER1N_USERROLEDEFIELD_DATAENTITY_DEID]
     */
    public static final String DER1N_USERROLEDEFIELD_DATAENTITY_DEID = "DER1N_USERROLEDEFIELD_DATAENTITY_DEID";
    /**
     * 实体关系[DER1N_USERROLEDETAIL_USEROBJECT_USEROBJECTID]
     */
    public static final String DER1N_USERROLEDETAIL_USEROBJECT_USEROBJECTID = "DER1N_USERROLEDETAIL_USEROBJECT_USEROBJECTID";
    /**
     * 实体关系[DER1N_USERROLEDETAIL_USERROLE_USERROLEID]
     */
    public static final String DER1N_USERROLEDETAIL_USERROLE_USERROLEID = "DER1N_USERROLEDETAIL_USERROLE_USERROLEID";
    /**
     * 实体关系[DER1N_USERROLERES_UNIRES_UNIRESID]
     */
    public static final String DER1N_USERROLERES_UNIRES_UNIRESID = "DER1N_USERROLERES_UNIRES_UNIRESID";
    /**
     * 实体关系[DER1N_USERROLERES_USERROLE_USERROLEID]
     */
    public static final String DER1N_USERROLERES_USERROLE_USERROLEID = "DER1N_USERROLERES_USERROLE_USERROLEID";
    /**
     * 实体关系[DER1N_WFACTION_WFWORKFLOW_WFWORKFLOWID]
     */
    public static final String DER1N_WFACTION_WFWORKFLOW_WFWORKFLOWID = "DER1N_WFACTION_WFWORKFLOW_WFWORKFLOWID";
    /**
     * 实体关系[DER1N_WFAPPSETTING_MSGTEMPLATE_REMINDMSGTEMPID]
     */
    public static final String DER1N_WFAPPSETTING_MSGTEMPLATE_REMINDMSGTEMPID = "DER1N_WFAPPSETTING_MSGTEMPLATE_REMINDMSGTEMPID";
    /**
     * 实体关系[DER1N_WFASSISTWORK_WFINSTANCE_WFINSTANCEID]
     */
    public static final String DER1N_WFASSISTWORK_WFINSTANCE_WFINSTANCEID = "DER1N_WFASSISTWORK_WFINSTANCE_WFINSTANCEID";
    /**
     * 实体关系[DER1N_WFASSISTWORK_WFSTEPACTOR_WFSTEPACTORID]
     */
    public static final String DER1N_WFASSISTWORK_WFSTEPACTOR_WFSTEPACTORID = "DER1N_WFASSISTWORK_WFSTEPACTOR_WFSTEPACTORID";
    /**
     * 实体关系[DER1N_WFASSISTWORK_WFWORKFLOW_WFWORKFLOWID]
     */
    public static final String DER1N_WFASSISTWORK_WFWORKFLOW_WFWORKFLOWID = "DER1N_WFASSISTWORK_WFWORKFLOW_WFWORKFLOWID";
    /**
     * 实体关系[DER1N_WFIAACTION_WFSTEP_WFSTEPID]
     */
    public static final String DER1N_WFIAACTION_WFSTEP_WFSTEPID = "DER1N_WFIAACTION_WFSTEP_WFSTEPID";
    /**
     * 实体关系[DER1N_WFINSTANCE_ORG_ORGID]
     */
    public static final String DER1N_WFINSTANCE_ORG_ORGID = "DER1N_WFINSTANCE_ORG_ORGID";
    /**
     * 实体关系[DER1N_WFINSTANCE_WFINSTANCE_PWFINSTANCEID]
     */
    public static final String DER1N_WFINSTANCE_WFINSTANCE_PWFINSTANCEID = "DER1N_WFINSTANCE_WFINSTANCE_PWFINSTANCEID";
    /**
     * 实体关系[DER1N_WFINSTANCE_WFWORKFLOW_WFWORKFLOWID]
     */
    public static final String DER1N_WFINSTANCE_WFWORKFLOW_WFWORKFLOWID = "DER1N_WFINSTANCE_WFWORKFLOW_WFWORKFLOWID";
    /**
     * 实体关系[DER1N_WFREMINDER_WFSTEPACTOR_WFSTEPACTORID]
     */
    public static final String DER1N_WFREMINDER_WFSTEPACTOR_WFSTEPACTORID = "DER1N_WFREMINDER_WFSTEPACTOR_WFSTEPACTORID";
    /**
     * 实体关系[DER1N_WFREMINDER_WFUSER_WFUSERID]
     */
    public static final String DER1N_WFREMINDER_WFUSER_WFUSERID = "DER1N_WFREMINDER_WFUSER_WFUSERID";
    /**
     * 实体关系[DER1N_WFSTEPACTOR_WFSTEP_WFSTEPID]
     */
    public static final String DER1N_WFSTEPACTOR_WFSTEP_WFSTEPID = "DER1N_WFSTEPACTOR_WFSTEP_WFSTEPID";
    /**
     * 实体关系[DER1N_WFSTEPACTOR_WFUSER_ORIGINALWFUSERID]
     */
    public static final String DER1N_WFSTEPACTOR_WFUSER_ORIGINALWFUSERID = "DER1N_WFSTEPACTOR_WFUSER_ORIGINALWFUSERID";
    /**
     * 实体关系[DER1N_WFSTEPDATA_WFINSTANCE_WFINSTANCEID]
     */
    public static final String DER1N_WFSTEPDATA_WFINSTANCE_WFINSTANCEID = "DER1N_WFSTEPDATA_WFINSTANCE_WFINSTANCEID";
    /**
     * 实体关系[DER1N_WFSTEPDATA_WFSTEP_WFSTEPID]
     */
    public static final String DER1N_WFSTEPDATA_WFSTEP_WFSTEPID = "DER1N_WFSTEPDATA_WFSTEP_WFSTEPID";
    /**
     * 实体关系[DER1N_WFSTEPDATA_WFUSER_ORIGINALWFUSERID]
     */
    public static final String DER1N_WFSTEPDATA_WFUSER_ORIGINALWFUSERID = "DER1N_WFSTEPDATA_WFUSER_ORIGINALWFUSERID";
    /**
     * 实体关系[DER1N_WFSTEPINST_WFINSTANCE_WFINSTANCEID]
     */
    public static final String DER1N_WFSTEPINST_WFINSTANCE_WFINSTANCEID = "DER1N_WFSTEPINST_WFINSTANCE_WFINSTANCEID";
    /**
     * 实体关系[DER1N_WFSTEPINST_WFSTEP_WFSTEPID]
     */
    public static final String DER1N_WFSTEPINST_WFSTEP_WFSTEPID = "DER1N_WFSTEPINST_WFSTEP_WFSTEPID";
    /**
     * 实体关系[DER1N_WFSTEP_WFINSTANCE_WFINSTANCEID]
     */
    public static final String DER1N_WFSTEP_WFINSTANCE_WFINSTANCEID = "DER1N_WFSTEP_WFINSTANCE_WFINSTANCEID";
    /**
     * 实体关系[DER1N_WFTMPSTEPACTOR_WFACTOR_WFACTORID]
     */
    public static final String DER1N_WFTMPSTEPACTOR_WFACTOR_WFACTORID = "DER1N_WFTMPSTEPACTOR_WFACTOR_WFACTORID";
    /**
     * 实体关系[DER1N_WFTMPSTEPACTOR_WFSTEP_PREVWFSTEPID]
     */
    public static final String DER1N_WFTMPSTEPACTOR_WFSTEP_PREVWFSTEPID = "DER1N_WFTMPSTEPACTOR_WFSTEP_PREVWFSTEPID";
    /**
     * 实体关系[DER1N_WFUCPOLICY_WFUSER_MAJORWFUSERID]
     */
    public static final String DER1N_WFUCPOLICY_WFUSER_MAJORWFUSERID = "DER1N_WFUCPOLICY_WFUSER_MAJORWFUSERID";
    /**
     * 实体关系[DER1N_WFUCPOLICY_WFUSER_MINORWFUSERID]
     */
    public static final String DER1N_WFUCPOLICY_WFUSER_MINORWFUSERID = "DER1N_WFUCPOLICY_WFUSER_MINORWFUSERID";
    /**
     * 实体关系[DER1N_WFUSERASSIST_WFUSER_WFMAJORUSERID]
     */
    public static final String DER1N_WFUSERASSIST_WFUSER_WFMAJORUSERID = "DER1N_WFUSERASSIST_WFUSER_WFMAJORUSERID";
    /**
     * 实体关系[DER1N_WFUSERASSIST_WFUSER_WFMINORUSERID]
     */
    public static final String DER1N_WFUSERASSIST_WFUSER_WFMINORUSERID = "DER1N_WFUSERASSIST_WFUSER_WFMINORUSERID";
    /**
     * 实体关系[DER1N_WFUSERASSIST_WFWORKFLOW_WFWORKFLOWID]
     */
    public static final String DER1N_WFUSERASSIST_WFWORKFLOW_WFWORKFLOWID = "DER1N_WFUSERASSIST_WFWORKFLOW_WFWORKFLOWID";
    /**
     * 实体关系[DER1N_WFUSERCANDIDATE_WFUSER_WFMAJORUSERID]
     */
    public static final String DER1N_WFUSERCANDIDATE_WFUSER_WFMAJORUSERID = "DER1N_WFUSERCANDIDATE_WFUSER_WFMAJORUSERID";
    /**
     * 实体关系[DER1N_WFUSERCANDIDATE_WFUSER_WFMINORUSERID]
     */
    public static final String DER1N_WFUSERCANDIDATE_WFUSER_WFMINORUSERID = "DER1N_WFUSERCANDIDATE_WFUSER_WFMINORUSERID";
    /**
     * 实体关系[DER1N_WFUSERGROUPDETAIL_WFUSERGROUP_WFUSERGROUPID]
     */
    public static final String DER1N_WFUSERGROUPDETAIL_WFUSERGROUP_WFUSERGROUPID = "DER1N_WFUSERGROUPDETAIL_WFUSERGROUP_WFUSERGROUPID";
    /**
     * 实体关系[DER1N_WFUSERGROUPDETAIL_WFUSER_WFUSERID]
     */
    public static final String DER1N_WFUSERGROUPDETAIL_WFUSER_WFUSERID = "DER1N_WFUSERGROUPDETAIL_WFUSER_WFUSERID";
    /**
     * 实体关系[DER1N_WFWFVERSION_WFWORKFLOW_WFWFID]
     */
    public static final String DER1N_WFWFVERSION_WFWORKFLOW_WFWFID = "DER1N_WFWFVERSION_WFWORKFLOW_WFWFID";
    /**
     * 实体关系[DER1N_WFWORKFLOW_MSGTEMPLATE_REMINDMSGTEMPLID]
     */
    public static final String DER1N_WFWORKFLOW_MSGTEMPLATE_REMINDMSGTEMPLID = "DER1N_WFWORKFLOW_MSGTEMPLATE_REMINDMSGTEMPLID";
    /**
     * 实体关系[DER1N_WFWORKLIST2_WFINSTANCE_WFINSTANCEID]
     */
    public static final String DER1N_WFWORKLIST2_WFINSTANCE_WFINSTANCEID = "DER1N_WFWORKLIST2_WFINSTANCE_WFINSTANCEID";
    /**
     * 实体关系[DER1N_WFWORKLIST2_WFUSER_ORIGINALWFUSERID]
     */
    public static final String DER1N_WFWORKLIST2_WFUSER_ORIGINALWFUSERID = "DER1N_WFWORKLIST2_WFUSER_ORIGINALWFUSERID";
    /**
     * 实体关系[DER1N_WFWORKLIST_WFINSTANCE_WFINSTANCEID]
     */
    public static final String DER1N_WFWORKLIST_WFINSTANCE_WFINSTANCEID = "DER1N_WFWORKLIST_WFINSTANCE_WFINSTANCEID";
    /**
     * 实体关系[DER1N_WFWORKLIST_WFUSER_ORIGINALWFUSERID]
     */
    public static final String DER1N_WFWORKLIST_WFUSER_ORIGINALWFUSERID = "DER1N_WFWORKLIST_WFUSER_ORIGINALWFUSERID";
    /**
     * 实体关系[DER1N_WXACCESSTOKEN_WXACCOUNT_WXACCOUNTID]
     */
    public static final String DER1N_WXACCESSTOKEN_WXACCOUNT_WXACCOUNTID = "DER1N_WXACCESSTOKEN_WXACCOUNT_WXACCOUNTID";
    /**
     * 实体关系[DER1N_WXACCOUNT_ORG_ORGID]
     */
    public static final String DER1N_WXACCOUNT_ORG_ORGID = "DER1N_WXACCOUNT_ORG_ORGID";
    /**
     * 实体关系[DER1N_WXENTAPP_WXACCOUNT_WXACCOUNTID]
     */
    public static final String DER1N_WXENTAPP_WXACCOUNT_WXACCOUNTID = "DER1N_WXENTAPP_WXACCOUNT_WXACCOUNTID";
    /**
     * 实体关系[DER1N_WXMEDIA_WXACCOUNT_WXACCOUNTID]
     */
    public static final String DER1N_WXMEDIA_WXACCOUNT_WXACCOUNTID = "DER1N_WXMEDIA_WXACCOUNT_WXACCOUNTID";
    /**
     * 实体关系[DER1N_WXMEDIA_WXENTAPP_WXENTAPPID]
     */
    public static final String DER1N_WXMEDIA_WXENTAPP_WXENTAPPID = "DER1N_WXMEDIA_WXENTAPP_WXENTAPPID";
    /**
     * 实体关系[DER1N_WXMESSAGE_WXACCOUNT_WXACCOUNTID]
     */
    public static final String DER1N_WXMESSAGE_WXACCOUNT_WXACCOUNTID = "DER1N_WXMESSAGE_WXACCOUNT_WXACCOUNTID";
    /**
     * 实体关系[DER1N_WXMESSAGE_WXENTAPP_WXENTAPPID]
     */
    public static final String DER1N_WXMESSAGE_WXENTAPP_WXENTAPPID = "DER1N_WXMESSAGE_WXENTAPP_WXENTAPPID";
    /**
     * 实体关系[DER1N_WXORGSECTOR_ORGSECTOR_ORGSECTORID]
     */
    public static final String DER1N_WXORGSECTOR_ORGSECTOR_ORGSECTORID = "DER1N_WXORGSECTOR_ORGSECTOR_ORGSECTORID";
    /**
     * 实体关系[DER1N_WXORGSECTOR_WXACCOUNT_WXACCOUNTID]
     */
    public static final String DER1N_WXORGSECTOR_WXACCOUNT_WXACCOUNTID = "DER1N_WXORGSECTOR_WXACCOUNT_WXACCOUNTID";
    /**
     * 实体关系[DERINDEX_WFDYNAMICUSER_WFACTOR]
     */
    public static final String DERINDEX_WFDYNAMICUSER_WFACTOR = "DERINDEX_WFDYNAMICUSER_WFACTOR";
    /**
     * 实体关系[DERINDEX_WFSYSTEMUSER_WFACTOR]
     */
    public static final String DERINDEX_WFSYSTEMUSER_WFACTOR = "DERINDEX_WFSYSTEMUSER_WFACTOR";
    /**
     * 实体关系[DERINDEX_WFUSERGROUP_WFACTOR]
     */
    public static final String DERINDEX_WFUSERGROUP_WFACTOR = "DERINDEX_WFUSERGROUP_WFACTOR";
    /**
     * 实体关系[DERINDEX_WFUSER_WFACTOR]
     */
    public static final String DERINDEX_WFUSER_WFACTOR = "DERINDEX_WFUSER_WFACTOR";
    /**
     * 实体关系[DERINHERIT_USERGROUP_USEROBJECT]
     */
    public static final String DERINHERIT_USERGROUP_USEROBJECT = "DERINHERIT_USERGROUP_USEROBJECT";
    /**
     * 实体关系[DERINHERIT_USER_USEROBJECT]
     */
    public static final String DERINHERIT_USER_USEROBJECT = "DERINHERIT_USER_USEROBJECT";

    /**
     * 实体[系统]
     */
    public static final String SYSTEM = "SYSTEM";
    /**
     * 实体[工作流用户候选者]
     */
    public static final String WFUSERCANDIDATE = "WFUSERCANDIDATE";
    /**
     * 实体[统一资源]
     */
    public static final String UNIRES = "UNIRES";
    /**
     * 实体[动态视图实例]
     */
    public static final String DSDYNAVIEWINST = "DSDYNAVIEWINST";
    /**
     * 实体[动态代码表]
     */
    public static final String DSDYNACODELIST = "DSDYNACODELIST";
    /**
     * 实体[实体数据变更（已处理）]
     */
    public static final String DEDATACHG2 = "DEDATACHG2";
    /**
     * 实体[工作流步骤数据]
     */
    public static final String WFSTEPDATA = "WFSTEPDATA";
    /**
     * 实体[系统管理模块]
     */
    public static final String SYSADMIN = "SYSADMIN";
    /**
     * 实体[微信企业应用]
     */
    public static final String WXENTAPP = "WXENTAPP";
    /**
     * 实体[数据对象能力明细]
     */
    public static final String USERROLEDATADETAIL = "USERROLEDATADETAIL";
    /**
     * 实体[实体数据变更派发引擎]
     */
    public static final String DEDATACHGDISP = "DEDATACHGDISP";
    /**
     * 实体[任务调度任务类型]
     */
    public static final String TSSDTASKTYPE = "TSSDTASKTYPE";
    /**
     * 实体[门户视图部件]
     */
    public static final String PVPART = "PVPART";
    /**
     * 实体[数据审计]
     */
    public static final String DATAAUDIT = "DATAAUDIT";
    /**
     * 实体[工作流工作列表]
     */
    public static final String WFWORKLIST = "WFWORKLIST";
    /**
     * 实体[用户角色资源能力]
     */
    public static final String USERROLERES = "USERROLERES";
    /**
     * 实体[注册表]
     */
    public static final String REGISTRY = "REGISTRY";
    /**
     * 实体[用户角色]
     */
    public static final String USERROLE = "USERROLE";
    /**
     * 实体[调度任务项策略]
     */
    public static final String TSSDTASKPOLICY = "TSSDTASKPOLICY";
    /**
     * 实体[任务时刻策略所有者]
     */
    public static final String TSSDPOLICYOWNER = "TSSDPOLICYOWNER";
    /**
     * 实体[用户角色实体属性访问]
     */
    public static final String USERROLEDEFIELD = "USERROLEDEFIELD";
    /**
     * 实体[任务时刻策略组]
     */
    public static final String TSSDGROUP = "TSSDGROUP";
    /**
     * 实体[动态视图]
     */
    public static final String DSDYNAVIEW = "DSDYNAVIEW";
    /**
     * 实体[工作流用户组成员]
     */
    public static final String WFUSERGROUPDETAIL = "WFUSERGROUPDETAIL";
    /**
     * 实体[工作流预定义处理]
     */
    public static final String WFCUSTOMPROCESS = "WFCUSTOMPROCESS";
    /**
     * 实体[用户词条类别]
     */
    public static final String USERDICTCAT = "USERDICTCAT";
    /**
     * 实体[任务时刻策略项]
     */
    public static final String TSSDITEM = "TSSDITEM";
    /**
     * 实体[帐户使用记录]
     */
    public static final String LOGINLOG = "LOGINLOG";
    /**
     * 实体[系统管理功能]
     */
    public static final String SYSADMINFUNC = "SYSADMINFUNC";
    /**
     * 实体[任务调度任务项]
     */
    public static final String TSSDTASK = "TSSDTASK";
    /**
     * 实体[工作流用户代办]
     */
    public static final String WFUSERASSIST = "WFUSERASSIST";
    /**
     * 实体[工作流交互操作]
     */
    public static final String WFIAACTION = "WFIAACTION";
    /**
     * 实体[微信访问票据]
     */
    public static final String WXACCESSTOKEN = "WXACCESSTOKEN";
    /**
     * 实体[用户角色数据操作]
     */
    public static final String USERROLEDATAACTION = "USERROLEDATAACTION";
    /**
     * 实体[组织类型]
     */
    public static final String ORGTYPE = "ORGTYPE";
    /**
     * 实体[DA日志]
     */
    public static final String DALOG = "DALOG";
    /**
     * 实体[用户表格自定义]
     */
    public static final String USERDGTHEME = "USERDGTHEME";
    /**
     * 实体[用户角色数据能力]
     */
    public static final String USERROLEDATAS = "USERROLEDATAS";
    /**
     * 实体[组织部门]
     */
    public static final String ORGSECTOR = "ORGSECTOR";
    /**
     * 实体[消息发送队列]
     */
    public static final String MSGSENDQUEUE = "MSGSENDQUEUE";
    /**
     * 实体[工作流代办工作]
     */
    public static final String WFASSISTWORK = "WFASSISTWORK";
    /**
     * 实体[实体查询模型]
     */
    public static final String QUERYMODEL = "QUERYMODEL";
    /**
     * 实体[用户角色成员]
     */
    public static final String USERROLEDETAIL = "USERROLEDETAIL";
    /**
     * 实体[数据对象能力]
     */
    public static final String USERROLEDATA = "USERROLEDATA";
    /**
     * 实体[工作流配置]
     */
    public static final String WFWORKFLOW = "WFWORKFLOW";
    /**
     * 实体[用户角色相关实体属性访问控制]
     */
    public static final String USERROLEDEFIELDS = "USERROLEDEFIELDS";
    /**
     * 实体[消息发送队列（历史）]
     */
    public static final String MSGSENDQUEUEHIS = "MSGSENDQUEUEHIS";
    /**
     * 实体[数据同步接收队列2]
     */
    public static final String DATASYNCIN2 = "DATASYNCIN2";
    /**
     * 实体[数据审计明细]
     */
    public static final String DATAAUDITDETAIL = "DATAAUDITDETAIL";
    /**
     * 实体[任务时刻策略]
     */
    public static final String TSSDPOLICY = "TSSDPOLICY";
    /**
     * 实体[工作流操作者]
     */
    public static final String WFACTOR = "WFACTOR";
    /**
     * 实体[代码表]
     */
    public static final String CODELIST = "CODELIST";
    /**
     * 实体[消息模板]
     */
    public static final String MSGTEMPLATE = "MSGTEMPLATE";
    /**
     * 实体[用户角色类型]
     */
    public static final String USERROLETYPE = "USERROLETYPE";
    /**
     * 实体[用户词条]
     */
    public static final String USERDICTITEM = "USERDICTITEM";
    /**
     * 实体[微信公众号]
     */
    public static final String WXACCOUNT = "WXACCOUNT";
    /**
     * 实体[数据同步接收队列]
     */
    public static final String DATASYNCIN = "DATASYNCIN";
    /**
     * 实体[代码项]
     */
    public static final String CODEITEM = "CODEITEM";
    /**
     * 实体[任务调度引擎]
     */
    public static final String TSSDENGINE = "TSSDENGINE";
    /**
     * 实体[工作流候选用户策略]
     */
    public static final String WFUCPOLICY = "WFUCPOLICY";
    /**
     * 实体[工作流步骤操作者]
     */
    public static final String WFSTEPACTOR = "WFSTEPACTOR";
    /**
     * 实体[工作流用户操作]
     */
    public static final String WFACTION = "WFACTION";
    /**
     * 实体[工作流操作界面]
     */
    public static final String WFUIWIZARD = "WFUIWIZARD";
    /**
     * 实体[工作流步骤]
     */
    public static final String WFSTEP = "WFSTEP";
    /**
     * 实体[用户组成员]
     */
    public static final String USERGROUPDETAIL = "USERGROUPDETAIL";
    /**
     * 实体[动态工作流]
     */
    public static final String DSDYNAWF = "DSDYNAWF";
    /**
     * 实体[工作流系统设定]
     */
    public static final String WFAPPSETTING = "WFAPPSETTING";
    /**
     * 实体[微信部门]
     */
    public static final String WXORGSECTOR = "WXORGSECTOR";
    /**
     * 实体[数据同步发送队列2]
     */
    public static final String DATASYNCOUT2 = "DATASYNCOUT2";
    /**
     * 实体[微信多媒体内容]
     */
    public static final String WXMEDIA = "WXMEDIA";
    /**
     * 实体[工作流系统用户]
     */
    public static final String WFSYSTEMUSER = "WFSYSTEMUSER";
    /**
     * 实体[服务]
     */
    public static final String SERVICE = "SERVICE";
    /**
     * 实体[组消息账户明细]
     */
    public static final String MSGACCOUNTDETAIL = "MSGACCOUNTDETAIL";
    /**
     * 实体[工作流配置版本]
     */
    public static final String WFWFVERSION = "WFWFVERSION";
    /**
     * 实体[用户词典]
     */
    public static final String USERDICT = "USERDICT";
    /**
     * 实体[实体数据变更]
     */
    public static final String DEDATACHG = "DEDATACHG";
    /**
     * 实体[门户页面]
     */
    public static final String PORTALPAGE = "PORTALPAGE";
    /**
     * 实体[登录帐户]
     */
    public static final String LOGINACCOUNT = "LOGINACCOUNT";
    /**
     * 实体[用户]
     */
    public static final String USER = "USER";
    /**
     * 实体[组织单元类别]
     */
    public static final String ORGUNITCAT = "ORGUNITCAT";
    /**
     * 实体[动态工作流版本]
     */
    public static final String DSDYNAWFVER = "DSDYNAWFVER";
    /**
     * 实体[组织部门人员]
     */
    public static final String ORGSECUSER = "ORGSECUSER";
    /**
     * 实体[任务时刻策略组明细]
     */
    public static final String TSSDGROUPDETAIL = "TSSDGROUPDETAIL";
    /**
     * 实体[组织人员级别]
     */
    public static final String ORGUSERLEVEL = "ORGUSERLEVEL";
    /**
     * 实体[文件]
     */
    public static final String FILE = "FILE";
    /**
     * 实体[工作流动态用户]
     */
    public static final String WFDYNAMICUSER = "WFDYNAMICUSER";
    /**
     * 实体[门户页面模型]
     */
    public static final String PPMODEL = "PPMODEL";
    /**
     * 实体[任务调度日志]
     */
    public static final String TSSDTASKLOG = "TSSDTASKLOG";
    /**
     * 实体[工作流用户]
     */
    public static final String WFUSER = "WFUSER";
    /**
     * 实体[数据同步发送队列]
     */
    public static final String DATASYNCOUT = "DATASYNCOUT";
    /**
     * 实体[用户组]
     */
    public static final String USERGROUP = "USERGROUP";
    /**
     * 实体[用户对象]
     */
    public static final String USEROBJECT = "USEROBJECT";
    /**
     * 实体[工作流步骤操作者（临时）]
     */
    public static final String WFTMPSTEPACTOR = "WFTMPSTEPACTOR";
    /**
     * 实体[工作流工作列表2]
     */
    public static final String WFWORKLIST2 = "WFWORKLIST2";
    /**
     * 实体[实体]
     */
    public static final String DATAENTITY = "DATAENTITY";
    /**
     * 实体[消息账户]
     */
    public static final String MSGACCOUNT = "MSGACCOUNT";
    /**
     * 实体[数据同步代理]
     */
    public static final String DATASYNCAGENT = "DATASYNCAGENT";
    /**
     * 实体[工作流实例]
     */
    public static final String WFINSTANCE = "WFINSTANCE";
    /**
     * 实体[微信消息]
     */
    public static final String WXMESSAGE = "WXMESSAGE";
    /**
     * 实体[工作流用户组]
     */
    public static final String WFUSERGROUP = "WFUSERGROUP";
    /**
     * 实体[组织人员]
     */
    public static final String ORGUSER = "ORGUSER";
    /**
     * 实体[部门人员关系类型]
     */
    public static final String ORGSECUSERTYPE = "ORGSECUSERTYPE";
    /**
     * 实体[工作流工作催办]
     */
    public static final String WFREMINDER = "WFREMINDER";
    /**
     * 实体[工作流步骤子实例]
     */
    public static final String WFSTEPINST = "WFSTEPINST";
    /**
     * 实体[组织机构]
     */
    public static final String ORG = "ORG";

    public PSRuntimeSysModelBase() throws Exception {
        super();
        this.setId("2C40DFCD-0DF5-47BF-91A5-C45F810B0001");
        this.setName("PSRuntime");
        SysModelGlobal.registerSystem("net.ibizsys.psrt.srv.PSRuntimeSysModel",this);
        this.initAnnotation(PSRuntimeSysModelBase .class);
    }

    @PostConstruct
    public void postConstruct() throws Exception {
        super.postConstruct();
        this.prepareCodeLists();
        this.prepareSysCounters();
        this.prepareSysValueRules();
        this.prepareDataEntities();
        this.prepareSystemUserRoles();
        this.prepareDTSQueues();
        this.prepareUniStates();
        this.prepareServiceAPIClients();
        this.prepareDEFInputTipSets();
        this.prepareViewMsgs();
        this.prepareViewMsgGroups();
        this.prepareWXAccounts();
        this.prepareWorkflows();
        this.prepareBASchemes();
        this.prepareSysUtils();
        this.installPlugins(this.getPSRuntimePlugins());
    }

    /**
     * 手动安装系统
     * @throws Exception
     */
    public void install() throws Exception {
        super.postConstruct();
        this.prepareCodeLists();
        this.prepareSysCounters();
        this.prepareSysValueRules();
        this.prepareDataEntities();
        this.prepareDAOs();
        this.prepareServices();
        this.prepareSystemUserRoles();
        this.prepareDTSQueues();
        this.prepareUniStates();
        this.prepareServiceAPIClients();
        this.prepareDEFInputTipSets();
        this.prepareViewMsgs();
        this.prepareViewMsgGroups();
        this.prepareWXAccounts();
        this.prepareWorkflows();
        this.prepareBASchemes();
        this.prepareSysUtils();
        this.installPlugins(this.getPSRuntimePlugins());
    }


    @Autowired(required=false)
    @Qualifier("dbDialectPSRuntime")
    private IDBDialect dbDialectPSRuntime;

    /**
     * 设置当前系统数据设配器
     * @param dbDialectPSRuntime
     */
    public void setDBDialectPSRuntime(IDBDialect dbDialectPSRuntime) {
        this.dbDialectPSRuntime = dbDialectPSRuntime;
    }

    /**
     * 获取当前系统数据设配器
     * @return
     */
    public IDBDialect getDBDialectPSRuntime() {
        return dbDialectPSRuntime;
    }


    @Autowired(required=false)
    @Qualifier("sessionFactoryPSRuntime")
    private SessionFactory sessionFactoryPSRuntime;

    /**
     * 设置当前系统会话工厂
     * @param sessionFactoryPSRuntime
     */
    public void setSessionFactoryPSRuntime(SessionFactory sessionFactoryPSRuntime) {
        this.sessionFactoryPSRuntime = sessionFactoryPSRuntime;
    }

    /**
     * 获取当前系统会话工厂
     * @return
     */
    public SessionFactory getSessionFactoryPSRuntime() {
        return sessionFactoryPSRuntime;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.sysmodel.SystemModelBase#getSessionFactory()
     */
    @Override
    public SessionFactory getSessionFactory() {
        if(getSessionFactoryPSRuntime()==null)
            return super.getSessionFactory();
        return getSessionFactoryPSRuntime();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.sysmodel.SystemModelBase#getDBDialect()
     */
    @Override
    public IDBDialect getDBDialect() {
        if(getDBDialectPSRuntime()==null)
            return super.getDBDialect();
        return getDBDialectPSRuntime();
    }

    /**
     * 准备系统代码表
     */
    protected void prepareCodeLists() {
        new net.ibizsys.psrt.srv.codelist.UserRoleTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.WFConfigStateCodeListModel();
        new net.ibizsys.psrt.srv.codelist.UniResTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.TSSecondCodeListModel();
        new net.ibizsys.psrt.srv.codelist.CodeList105CodeListModel();
        new net.ibizsys.psrt.srv.codelist.SystemFuncCodeListModel();
        new net.ibizsys.psrt.srv.codelist.ServiceStartModeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.CodeList24CodeListModel();
        new net.ibizsys.psrt.srv.codelist.DEFieldAccModeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.TSHourCodeListModel();
        new net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel();
        new net.ibizsys.psrt.srv.codelist.WXMsgTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.WXEntAppTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.DataSyncAgentTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.TSMonthWeekTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.MsgContentTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.TSDayCodeListModel();
        new net.ibizsys.psrt.srv.codelist.ServiceRunStateCodeListModel();
        new net.ibizsys.psrt.srv.codelist.MsgTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.URDUserDRCodeListModel();
        new net.ibizsys.psrt.srv.codelist.TSDayTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.CodeList5CodeListModel();
        new net.ibizsys.psrt.srv.codelist.URDSecDRCodeListModel();
        new net.ibizsys.psrt.srv.codelist.PVLayoutModeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.CodeList25CodeListModel();
        new net.ibizsys.psrt.srv.codelist.CodeList58CodeListModel();
        new net.ibizsys.psrt.srv.codelist.CodeList20CodeListModel();
        new net.ibizsys.psrt.srv.codelist.WFGotoStepCodeListModel();
        new net.ibizsys.psrt.srv.codelist.TSMonthCodeListModel();
        new net.ibizsys.psrt.srv.codelist.CodeList19CodeListModel();
        new net.ibizsys.psrt.srv.codelist.DETableSpaceCodeListModel();
        new net.ibizsys.psrt.srv.codelist.TSMinuteCodeListModel();
        new net.ibizsys.psrt.srv.codelist.ServiceContainerCodeListModel();
        new net.ibizsys.psrt.srv.codelist.TSWeekCodeListModel();
        new net.ibizsys.psrt.srv.codelist.TSMonthDayTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.DataSyncOutAgentCodeListModel();
        new net.ibizsys.psrt.srv.codelist.CodeList80CodeListModel();
        new net.ibizsys.psrt.srv.codelist.TSMinuteTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.CodeList71CodeListModel();
        new net.ibizsys.psrt.srv.codelist.WFGotoStepActorCodeListModel();
        new net.ibizsys.psrt.srv.codelist.PVPartTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.DEDataChgLogTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.DEIndexModeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.URDBCDRCodeListModel();
        new net.ibizsys.psrt.srv.codelist.MsgImportanceLevelCodeListModel();
        new net.ibizsys.psrt.srv.codelist.URDOrgDRCodeListModel();
        new net.ibizsys.psrt.srv.codelist.CodeList50CodeListModel();
        new net.ibizsys.psrt.srv.codelist.DataChangeEventCodeListModel();
        new net.ibizsys.psrt.srv.codelist.YesNoCodeListModel();
        new net.ibizsys.psrt.srv.codelist.CodeList59CodeListModel();
        new net.ibizsys.psrt.srv.codelist.WFActorTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.TSMonthTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.DynaViewTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.AuditDEActionCodeListModel();
        new net.ibizsys.psrt.srv.codelist.DEPrintFuncCodeListModel();
        new net.ibizsys.psrt.srv.codelist.TSSecondTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.WFConfigTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.AllOrgCodeListModel();
        new net.ibizsys.psrt.srv.codelist.DataSyncInAgentCodeListModel();
        new net.ibizsys.psrt.srv.codelist.TSPolicyTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.SystemTypeCodeListModel();
        new net.ibizsys.psrt.srv.codelist.CodeList56CodeListModel();
        new net.ibizsys.psrt.srv.codelist.CodeList97CodeListModel();
        new net.ibizsys.psrt.srv.codelist.WFUCPolicyStateCodeListModel();

        //初始化用户词条类别代码表
    }

    /**
     * 准备系统属性输入提示集合
     */
    protected void prepareDEFInputTipSets() {
        try {
        } catch(Exception ex) {
            log.error(StringHelper.format("初始化属性输入提示集合发生异常，%1$s",ex.getMessage()),ex);
        }
    }




    /**
     * 准备系统视图消息
     */
    protected void prepareViewMsgs() {
        try {
        } catch(Exception ex) {
            log.error(StringHelper.format("初始化视图消息发生异常，%1$s",ex.getMessage()),ex);
        }
    }

    /**
     * 准备系统视图消息组
     */
    protected void prepareViewMsgGroups() {
        try {
        } catch(Exception ex) {
            log.error(StringHelper.format("初始化视图消息组发生异常，%1$s",ex.getMessage()),ex);
        }
    }


    /**
     * 准备系统统一状态对象
     */
    protected void prepareUniStates() {
        try {
        } catch(Exception ex) {
            log.error(StringHelper.format("初始化统一状态对象发生异常，%1$s",ex.getMessage()),ex);
        }
    }

    /**
     * 准备系统用户角色对象
     */
    protected void prepareSystemUserRoles() {
        try {
        } catch(Exception ex) {
            log.error(StringHelper.format("初始化用户角色对象发生异常，%1$s",ex.getMessage()),ex);
        }
    }


    /**
     * 准备系统分布事务处理队列
     */
    protected void prepareDTSQueues() {
        try {
        } catch(Exception ex) {
            log.error(StringHelper.format("初始化分布事务处理队列发生异常，%1$s",ex.getMessage()),ex);
        }
    }

    /**
     * 准备系统服务接口客户端对象
     */
    protected void prepareServiceAPIClients() {
        try {
        } catch(Exception ex) {
            log.error(StringHelper.format("初始化系统服务接口客户端发生异常，%1$s",ex.getMessage()),ex);
        }
    }

    /**
     * 准备系统计数器
     */
    protected void prepareSysCounters() {
        try {
        } catch(Exception ex) {
            log.error(StringHelper.format("初始化系统计数器发生异常，%1$s",ex.getMessage()),ex);
        }
    }

    /**
     * 准备系统值规则
     */
    protected void prepareSysValueRules() {
        try {
            net.ibizsys.paas.sysmodel.util.RegExValueRuleModel valueRuleModel0 = new net.ibizsys.paas.sysmodel.util.RegExValueRuleModel();
            valueRuleModel0.setExpression("(-?\\d+)(\\.\\d+)?");
            valueRuleModel0.setId("01bc1646c58b34db649ab16c4b8d5e60");
            valueRuleModel0.setName("浮点数");
            valueRuleModel0.init(this);
            this.registerSystemValueRuleModel(valueRuleModel0);
            net.ibizsys.paas.sysmodel.util.RegExValueRuleModel valueRuleModel1 = new net.ibizsys.paas.sysmodel.util.RegExValueRuleModel();
            valueRuleModel1.setExpression("[0-9]*[1-9][0-9]*");
            valueRuleModel1.setId("0d13b22cb1bf499a6ceea57a92bedef8");
            valueRuleModel1.setName("正整数");
            valueRuleModel1.init(this);
            this.registerSystemValueRuleModel(valueRuleModel1);
            net.ibizsys.paas.sysmodel.util.RegExValueRuleModel valueRuleModel2 = new net.ibizsys.paas.sysmodel.util.RegExValueRuleModel();
            valueRuleModel2.setExpression("[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+");
            valueRuleModel2.setId("0ea99d804f06a71115c5a62bc28b3527");
            valueRuleModel2.setName("email地址");
            valueRuleModel2.init(this);
            this.registerSystemValueRuleModel(valueRuleModel2);
            net.ibizsys.paas.sysmodel.util.RegExValueRuleModel valueRuleModel3 = new net.ibizsys.paas.sysmodel.util.RegExValueRuleModel();
            valueRuleModel3.setExpression("\\d+");
            valueRuleModel3.setId("3268e77dd7a4a4b05530bebec4f46c50");
            valueRuleModel3.setName("非负整数（正整数 + 0）");
            valueRuleModel3.init(this);
            this.registerSystemValueRuleModel(valueRuleModel3);
            net.ibizsys.paas.sysmodel.util.RegExValueRuleModel valueRuleModel4 = new net.ibizsys.paas.sysmodel.util.RegExValueRuleModel();
            valueRuleModel4.setExpression("[A-Za-z0-9]+");
            valueRuleModel4.setId("6e404aa8db594e2f28a5852a7cdad0e8");
            valueRuleModel4.setName("由数字和26个英文字母组成的字符串");
            valueRuleModel4.init(this);
            this.registerSystemValueRuleModel(valueRuleModel4);
            net.ibizsys.paas.sysmodel.util.RegExValueRuleModel valueRuleModel5 = new net.ibizsys.paas.sysmodel.util.RegExValueRuleModel();
            valueRuleModel5.setExpression("[A-Z]+");
            valueRuleModel5.setId("8016fd5dea62b7ca19148a61e566b9d3");
            valueRuleModel5.setName("由26个英文字母的大写组成的字符串");
            valueRuleModel5.init(this);
            this.registerSystemValueRuleModel(valueRuleModel5);
            net.ibizsys.paas.sysmodel.util.RegExValueRuleModel valueRuleModel6 = new net.ibizsys.paas.sysmodel.util.RegExValueRuleModel();
            valueRuleModel6.setExpression("\\w+");
            valueRuleModel6.setId("84edfd10899f07328ee6438ffacf8143");
            valueRuleModel6.setName("由数字、26个英文字母或者下划线组成的字符串");
            valueRuleModel6.init(this);
            this.registerSystemValueRuleModel(valueRuleModel6);
            net.ibizsys.paas.sysmodel.util.RegExValueRuleModel valueRuleModel7 = new net.ibizsys.paas.sysmodel.util.RegExValueRuleModel();
            valueRuleModel7.setExpression("((-\\d+(\\.\\d+)?)|(0+(\\.0+)?))+");
            valueRuleModel7.setId("8a59008054e727cb36eb10e6b864d900");
            valueRuleModel7.setName("非正浮点数（负浮点数 + 0）");
            valueRuleModel7.init(this);
            this.registerSystemValueRuleModel(valueRuleModel7);
            net.ibizsys.paas.sysmodel.util.RegExValueRuleModel valueRuleModel8 = new net.ibizsys.paas.sysmodel.util.RegExValueRuleModel();
            valueRuleModel8.setExpression("[a-zA-Z_$][a-zA-Z0-9_$]*");
            valueRuleModel8.setId("97841f956bba437825ae258442aeb496");
            valueRuleModel8.setName("代码名称");
            valueRuleModel8.init(this);
            this.registerSystemValueRuleModel(valueRuleModel8);
            net.ibizsys.paas.sysmodel.util.RegExValueRuleModel valueRuleModel9 = new net.ibizsys.paas.sysmodel.util.RegExValueRuleModel();
            valueRuleModel9.setExpression("((-\\d+)|(0+))+");
            valueRuleModel9.setId("97e9883ae7e261976a128b79c60d6871");
            valueRuleModel9.setName("非正整数（负整数 + 0）");
            valueRuleModel9.init(this);
            this.registerSystemValueRuleModel(valueRuleModel9);
            net.ibizsys.paas.sysmodel.util.RegExValueRuleModel valueRuleModel10 = new net.ibizsys.paas.sysmodel.util.RegExValueRuleModel();
            valueRuleModel10.setExpression("(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))+");
            valueRuleModel10.setId("9c5f80f095330c696cec98766e567bce");
            valueRuleModel10.setName("正浮点数");
            valueRuleModel10.init(this);
            this.registerSystemValueRuleModel(valueRuleModel10);
            net.ibizsys.paas.sysmodel.util.RegExValueRuleModel valueRuleModel11 = new net.ibizsys.paas.sysmodel.util.RegExValueRuleModel();
            valueRuleModel11.setExpression("-?\\d+");
            valueRuleModel11.setId("a8804f3a519c547bfb7a2d76bc4b0c1d");
            valueRuleModel11.setName("整数");
            valueRuleModel11.init(this);
            this.registerSystemValueRuleModel(valueRuleModel11);
            net.ibizsys.paas.sysmodel.util.RegExValueRuleModel valueRuleModel12 = new net.ibizsys.paas.sysmodel.util.RegExValueRuleModel();
            valueRuleModel12.setExpression("[A-Za-z]+");
            valueRuleModel12.setId("b436b7b8f20944fe85a0450feb9b6144");
            valueRuleModel12.setName("由26个英文字母组成的字符串");
            valueRuleModel12.init(this);
            this.registerSystemValueRuleModel(valueRuleModel12);
            net.ibizsys.paas.sysmodel.util.RegExValueRuleModel valueRuleModel13 = new net.ibizsys.paas.sysmodel.util.RegExValueRuleModel();
            valueRuleModel13.setExpression("[a-z]+");
            valueRuleModel13.setId("b7228b9943dc4d881c722406dda53537");
            valueRuleModel13.setName("由26个英文字母的小写组成的字符串");
            valueRuleModel13.init(this);
            this.registerSystemValueRuleModel(valueRuleModel13);
            net.ibizsys.paas.sysmodel.util.RegExValueRuleModel valueRuleModel14 = new net.ibizsys.paas.sysmodel.util.RegExValueRuleModel();
            valueRuleModel14.setExpression("-[0-9]*[1-9][0-9]*");
            valueRuleModel14.setId("c146a1ccac246c50ef999f17e8bf4c38");
            valueRuleModel14.setName("负整数");
            valueRuleModel14.init(this);
            this.registerSystemValueRuleModel(valueRuleModel14);
            net.ibizsys.paas.sysmodel.util.RegExValueRuleModel valueRuleModel15 = new net.ibizsys.paas.sysmodel.util.RegExValueRuleModel();
            valueRuleModel15.setExpression("(-(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*)))+");
            valueRuleModel15.setId("c6aaa542c20b9ecf01c6f1087922b9c4");
            valueRuleModel15.setName("负浮点数");
            valueRuleModel15.init(this);
            this.registerSystemValueRuleModel(valueRuleModel15);
            net.ibizsys.paas.sysmodel.util.RegExValueRuleModel valueRuleModel16 = new net.ibizsys.paas.sysmodel.util.RegExValueRuleModel();
            valueRuleModel16.setExpression("[^\\\\\\/\\:\\*\\?\\\"\\<\\>\\|]+(\\[^\\\\\\/\\:\\*\\?\\\"\\<\\>\\|]+)*");
            valueRuleModel16.setId("dc01ec15e5c043ac869c18a5d93dfbd8");
            valueRuleModel16.setName("文件名称");
            valueRuleModel16.init(this);
            this.registerSystemValueRuleModel(valueRuleModel16);
            net.ibizsys.paas.sysmodel.util.RegExValueRuleModel valueRuleModel17 = new net.ibizsys.paas.sysmodel.util.RegExValueRuleModel();
            valueRuleModel17.setExpression("\\d+(\\.\\d+)?");
            valueRuleModel17.setId("f8290b8fc83f51573a4c02112463363c");
            valueRuleModel17.setName("非负浮点数（正浮点数 + 0）");
            valueRuleModel17.init(this);
            this.registerSystemValueRuleModel(valueRuleModel17);
            net.ibizsys.paas.sysmodel.util.RegExValueRuleModel valueRuleModel18 = new net.ibizsys.paas.sysmodel.util.RegExValueRuleModel();
            valueRuleModel18.setExpression("[a-zA-z]+://(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*(\\?\\S*)?");
            valueRuleModel18.setId("fb7e8feea11f2c49e548e3a43f9a64d8");
            valueRuleModel18.setName("URL");
            valueRuleModel18.init(this);
            this.registerSystemValueRuleModel(valueRuleModel18);
        } catch(Exception ex) {
            log.error(StringHelper.format("初始化系统值规则发生异常，%1$s",ex.getMessage()),ex);
        }
    }


    /**
     * 准备系统实体
     */
    protected void prepareDataEntities() throws Exception {


        new net.ibizsys.psrt.srv.common.demodel.SystemDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFUserCandidateDEModel();
        new net.ibizsys.psrt.srv.common.demodel.UniResDEModel();
        new net.ibizsys.psrt.srv.dynasys.demodel.DSDynaViewInstDEModel();
        new net.ibizsys.psrt.srv.dynasys.demodel.DSDynaCodeListDEModel();
        new net.ibizsys.psrt.srv.common.demodel.DEDataChg2DEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFStepDataDEModel();
        new net.ibizsys.psrt.srv.common.demodel.SysAdminDEModel();
        new net.ibizsys.psrt.srv.wx.demodel.WXEntAppDEModel();
        new net.ibizsys.psrt.srv.common.demodel.UserRoleDataDetailDEModel();
        new net.ibizsys.psrt.srv.common.demodel.DEDataChgDispDEModel();
        new net.ibizsys.psrt.srv.common.demodel.TSSDTaskTypeDEModel();
        new net.ibizsys.psrt.srv.common.demodel.PVPartDEModel();
        new net.ibizsys.psrt.srv.common.demodel.DataAuditDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFWorkListDEModel();
        new net.ibizsys.psrt.srv.common.demodel.UserRoleResDEModel();
        new net.ibizsys.psrt.srv.common.demodel.RegistryDEModel();
        new net.ibizsys.psrt.srv.common.demodel.UserRoleDEModel();
        new net.ibizsys.psrt.srv.common.demodel.TSSDTaskPolicyDEModel();
        new net.ibizsys.psrt.srv.common.demodel.TSSDPolicyOwnerDEModel();
        new net.ibizsys.psrt.srv.common.demodel.UserRoleDEFieldDEModel();
        new net.ibizsys.psrt.srv.common.demodel.TSSDGroupDEModel();
        new net.ibizsys.psrt.srv.dynasys.demodel.DSDynaViewDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFUserGroupDetailDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFCustomProcessDEModel();
        new net.ibizsys.psrt.srv.common.demodel.UserDictCatDEModel();
        new net.ibizsys.psrt.srv.common.demodel.TSSDItemDEModel();
        new net.ibizsys.psrt.srv.common.demodel.LoginLogDEModel();
        new net.ibizsys.psrt.srv.common.demodel.SysAdminFuncDEModel();
        new net.ibizsys.psrt.srv.common.demodel.TSSDTaskDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFUserAssistDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFIAActionDEModel();
        new net.ibizsys.psrt.srv.wx.demodel.WXAccessTokenDEModel();
        new net.ibizsys.psrt.srv.common.demodel.UserRoleDataActionDEModel();
        new net.ibizsys.psrt.srv.common.demodel.OrgTypeDEModel();
        new net.ibizsys.psrt.srv.common.demodel.DALogDEModel();
        new net.ibizsys.psrt.srv.common.demodel.UserDGThemeDEModel();
        new net.ibizsys.psrt.srv.common.demodel.UserRoleDatasDEModel();
        new net.ibizsys.psrt.srv.common.demodel.OrgSectorDEModel();
        new net.ibizsys.psrt.srv.common.demodel.MsgSendQueueDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFAssistWorkDEModel();
        new net.ibizsys.psrt.srv.demodel.demodel.QueryModelDEModel();
        new net.ibizsys.psrt.srv.common.demodel.UserRoleDetailDEModel();
        new net.ibizsys.psrt.srv.common.demodel.UserRoleDataDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFWorkflowDEModel();
        new net.ibizsys.psrt.srv.common.demodel.UserRoleDEFieldsDEModel();
        new net.ibizsys.psrt.srv.common.demodel.MsgSendQueueHisDEModel();
        new net.ibizsys.psrt.srv.common.demodel.DataSyncIn2DEModel();
        new net.ibizsys.psrt.srv.common.demodel.DataAuditDetailDEModel();
        new net.ibizsys.psrt.srv.common.demodel.TSSDPolicyDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFActorDEModel();
        new net.ibizsys.psrt.srv.common.demodel.CodeListDEModel();
        new net.ibizsys.psrt.srv.common.demodel.MsgTemplateDEModel();
        new net.ibizsys.psrt.srv.common.demodel.UserRoleTypeDEModel();
        new net.ibizsys.psrt.srv.common.demodel.UserDictItemDEModel();
        new net.ibizsys.psrt.srv.wx.demodel.WXAccountDEModel();
        new net.ibizsys.psrt.srv.common.demodel.DataSyncInDEModel();
        new net.ibizsys.psrt.srv.common.demodel.CodeItemDEModel();
        new net.ibizsys.psrt.srv.common.demodel.TSSDEngineDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFUCPolicyDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFStepActorDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFActionDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFUIWizardDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFStepDEModel();
        new net.ibizsys.psrt.srv.common.demodel.UserGroupDetailDEModel();
        new net.ibizsys.psrt.srv.dynasys.demodel.DSDynaWFDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFAppSettingDEModel();
        new net.ibizsys.psrt.srv.wx.demodel.WXOrgSectorDEModel();
        new net.ibizsys.psrt.srv.common.demodel.DataSyncOut2DEModel();
        new net.ibizsys.psrt.srv.wx.demodel.WXMediaDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFSystemUserDEModel();
        new net.ibizsys.psrt.srv.common.demodel.ServiceDEModel();
        new net.ibizsys.psrt.srv.common.demodel.MsgAccountDetailDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFVersionDEModel();
        new net.ibizsys.psrt.srv.common.demodel.UserDictDEModel();
        new net.ibizsys.psrt.srv.common.demodel.DEDataChgDEModel();
        new net.ibizsys.psrt.srv.common.demodel.PortalPageDEModel();
        new net.ibizsys.psrt.srv.common.demodel.LoginAccountDEModel();
        new net.ibizsys.psrt.srv.common.demodel.UserDEModel();
        new net.ibizsys.psrt.srv.common.demodel.OrgUnitCatDEModel();
        new net.ibizsys.psrt.srv.dynasys.demodel.DSDynaWFVerDEModel();
        new net.ibizsys.psrt.srv.common.demodel.OrgSecUserDEModel();
        new net.ibizsys.psrt.srv.common.demodel.TSSDGroupDetailDEModel();
        new net.ibizsys.psrt.srv.common.demodel.OrgUserLevelDEModel();
        new net.ibizsys.psrt.srv.common.demodel.FileDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFDynamicUserDEModel();
        new net.ibizsys.psrt.srv.common.demodel.PPModelDEModel();
        new net.ibizsys.psrt.srv.common.demodel.TSSDTaskLogDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFUserDEModel();
        new net.ibizsys.psrt.srv.common.demodel.DataSyncOutDEModel();
        new net.ibizsys.psrt.srv.common.demodel.UserGroupDEModel();
        new net.ibizsys.psrt.srv.common.demodel.UserObjectDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFTmpStepActorDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFWorkList2DEModel();
        new net.ibizsys.psrt.srv.demodel.demodel.DataEntityDEModel();
        new net.ibizsys.psrt.srv.common.demodel.MsgAccountDEModel();
        new net.ibizsys.psrt.srv.common.demodel.DataSyncAgentDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFInstanceDEModel();
        new net.ibizsys.psrt.srv.wx.demodel.WXMessageDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFUserGroupDEModel();
        new net.ibizsys.psrt.srv.common.demodel.OrgUserDEModel();
        new net.ibizsys.psrt.srv.common.demodel.OrgSecUserTypeDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFReminderDEModel();
        new net.ibizsys.psrt.srv.wf.demodel.WFStepInstDEModel();
        new net.ibizsys.psrt.srv.common.demodel.OrgDEModel();


    }

    /**
     * 准备系统实体服务对象
     */
    protected void prepareServices() throws Exception {


        net.ibizsys.psrt.srv.common.service.SystemService service0= 	 new net.ibizsys.psrt.srv.common.service.SystemService();
        service0.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFUserCandidateService service1= 	 new net.ibizsys.psrt.srv.wf.service.WFUserCandidateService();
        service1.postConstruct();
        net.ibizsys.psrt.srv.common.service.UniResService service2= 	 new net.ibizsys.psrt.srv.common.service.UniResService();
        service2.postConstruct();
        net.ibizsys.psrt.srv.dynasys.service.DSDynaViewInstService service3= 	 new net.ibizsys.psrt.srv.dynasys.service.DSDynaViewInstService();
        service3.postConstruct();
        net.ibizsys.psrt.srv.dynasys.service.DSDynaCodeListService service4= 	 new net.ibizsys.psrt.srv.dynasys.service.DSDynaCodeListService();
        service4.postConstruct();
        net.ibizsys.psrt.srv.common.service.DEDataChg2Service service5= 	 new net.ibizsys.psrt.srv.common.service.DEDataChg2Service();
        service5.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFStepDataService service6= 	 new net.ibizsys.psrt.srv.wf.service.WFStepDataService();
        service6.postConstruct();
        net.ibizsys.psrt.srv.common.service.SysAdminService service7= 	 new net.ibizsys.psrt.srv.common.service.SysAdminService();
        service7.postConstruct();
        net.ibizsys.psrt.srv.wx.service.WXEntAppService service8= 	 new net.ibizsys.psrt.srv.wx.service.WXEntAppService();
        service8.postConstruct();
        net.ibizsys.psrt.srv.common.service.UserRoleDataDetailService service9= 	 new net.ibizsys.psrt.srv.common.service.UserRoleDataDetailService();
        service9.postConstruct();
        net.ibizsys.psrt.srv.common.service.DEDataChgDispService service10= 	 new net.ibizsys.psrt.srv.common.service.DEDataChgDispService();
        service10.postConstruct();
        net.ibizsys.psrt.srv.common.service.TSSDTaskTypeService service11= 	 new net.ibizsys.psrt.srv.common.service.TSSDTaskTypeService();
        service11.postConstruct();
        net.ibizsys.psrt.srv.common.service.PVPartService service12= 	 new net.ibizsys.psrt.srv.common.service.PVPartService();
        service12.postConstruct();
        net.ibizsys.psrt.srv.common.service.DataAuditService service13= 	 new net.ibizsys.psrt.srv.common.service.DataAuditService();
        service13.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFWorkListService service14= 	 new net.ibizsys.psrt.srv.wf.service.WFWorkListService();
        service14.postConstruct();
        net.ibizsys.psrt.srv.common.service.UserRoleResService service15= 	 new net.ibizsys.psrt.srv.common.service.UserRoleResService();
        service15.postConstruct();
        net.ibizsys.psrt.srv.common.service.RegistryService service16= 	 new net.ibizsys.psrt.srv.common.service.RegistryService();
        service16.postConstruct();
        net.ibizsys.psrt.srv.common.service.UserRoleService service17= 	 new net.ibizsys.psrt.srv.common.service.UserRoleService();
        service17.postConstruct();
        net.ibizsys.psrt.srv.common.service.TSSDTaskPolicyService service18= 	 new net.ibizsys.psrt.srv.common.service.TSSDTaskPolicyService();
        service18.postConstruct();
        net.ibizsys.psrt.srv.common.service.TSSDPolicyOwnerService service19= 	 new net.ibizsys.psrt.srv.common.service.TSSDPolicyOwnerService();
        service19.postConstruct();
        net.ibizsys.psrt.srv.common.service.UserRoleDEFieldService service20= 	 new net.ibizsys.psrt.srv.common.service.UserRoleDEFieldService();
        service20.postConstruct();
        net.ibizsys.psrt.srv.common.service.TSSDGroupService service21= 	 new net.ibizsys.psrt.srv.common.service.TSSDGroupService();
        service21.postConstruct();
        net.ibizsys.psrt.srv.dynasys.service.DSDynaViewService service22= 	 new net.ibizsys.psrt.srv.dynasys.service.DSDynaViewService();
        service22.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFUserGroupDetailService service23= 	 new net.ibizsys.psrt.srv.wf.service.WFUserGroupDetailService();
        service23.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFCustomProcessService service24= 	 new net.ibizsys.psrt.srv.wf.service.WFCustomProcessService();
        service24.postConstruct();
        net.ibizsys.psrt.srv.common.service.UserDictCatService service25= 	 new net.ibizsys.psrt.srv.common.service.UserDictCatService();
        service25.postConstruct();
        net.ibizsys.psrt.srv.common.service.TSSDItemService service26= 	 new net.ibizsys.psrt.srv.common.service.TSSDItemService();
        service26.postConstruct();
        net.ibizsys.psrt.srv.common.service.LoginLogService service27= 	 new net.ibizsys.psrt.srv.common.service.LoginLogService();
        service27.postConstruct();
        net.ibizsys.psrt.srv.common.service.SysAdminFuncService service28= 	 new net.ibizsys.psrt.srv.common.service.SysAdminFuncService();
        service28.postConstruct();
        net.ibizsys.psrt.srv.common.service.TSSDTaskService service29= 	 new net.ibizsys.psrt.srv.common.service.TSSDTaskService();
        service29.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFUserAssistService service30= 	 new net.ibizsys.psrt.srv.wf.service.WFUserAssistService();
        service30.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFIAActionService service31= 	 new net.ibizsys.psrt.srv.wf.service.WFIAActionService();
        service31.postConstruct();
        net.ibizsys.psrt.srv.wx.service.WXAccessTokenService service32= 	 new net.ibizsys.psrt.srv.wx.service.WXAccessTokenService();
        service32.postConstruct();
        net.ibizsys.psrt.srv.common.service.UserRoleDataActionService service33= 	 new net.ibizsys.psrt.srv.common.service.UserRoleDataActionService();
        service33.postConstruct();
        net.ibizsys.psrt.srv.common.service.OrgTypeService service34= 	 new net.ibizsys.psrt.srv.common.service.OrgTypeService();
        service34.postConstruct();
        net.ibizsys.psrt.srv.common.service.DALogService service35= 	 new net.ibizsys.psrt.srv.common.service.DALogService();
        service35.postConstruct();
        net.ibizsys.psrt.srv.common.service.UserDGThemeService service36= 	 new net.ibizsys.psrt.srv.common.service.UserDGThemeService();
        service36.postConstruct();
        net.ibizsys.psrt.srv.common.service.UserRoleDatasService service37= 	 new net.ibizsys.psrt.srv.common.service.UserRoleDatasService();
        service37.postConstruct();
        net.ibizsys.psrt.srv.common.service.OrgSectorService service38= 	 new net.ibizsys.psrt.srv.common.service.OrgSectorService();
        service38.postConstruct();
        net.ibizsys.psrt.srv.common.service.MsgSendQueueService service39= 	 new net.ibizsys.psrt.srv.common.service.MsgSendQueueService();
        service39.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFAssistWorkService service40= 	 new net.ibizsys.psrt.srv.wf.service.WFAssistWorkService();
        service40.postConstruct();
        net.ibizsys.psrt.srv.demodel.service.QueryModelService service41= 	 new net.ibizsys.psrt.srv.demodel.service.QueryModelService();
        service41.postConstruct();
        net.ibizsys.psrt.srv.common.service.UserRoleDetailService service42= 	 new net.ibizsys.psrt.srv.common.service.UserRoleDetailService();
        service42.postConstruct();
        net.ibizsys.psrt.srv.common.service.UserRoleDataService service43= 	 new net.ibizsys.psrt.srv.common.service.UserRoleDataService();
        service43.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFWorkflowService service44= 	 new net.ibizsys.psrt.srv.wf.service.WFWorkflowService();
        service44.postConstruct();
        net.ibizsys.psrt.srv.common.service.UserRoleDEFieldsService service45= 	 new net.ibizsys.psrt.srv.common.service.UserRoleDEFieldsService();
        service45.postConstruct();
        net.ibizsys.psrt.srv.common.service.MsgSendQueueHisService service46= 	 new net.ibizsys.psrt.srv.common.service.MsgSendQueueHisService();
        service46.postConstruct();
        net.ibizsys.psrt.srv.common.service.DataSyncIn2Service service47= 	 new net.ibizsys.psrt.srv.common.service.DataSyncIn2Service();
        service47.postConstruct();
        net.ibizsys.psrt.srv.common.service.DataAuditDetailService service48= 	 new net.ibizsys.psrt.srv.common.service.DataAuditDetailService();
        service48.postConstruct();
        net.ibizsys.psrt.srv.common.service.TSSDPolicyService service49= 	 new net.ibizsys.psrt.srv.common.service.TSSDPolicyService();
        service49.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFActorService service50= 	 new net.ibizsys.psrt.srv.wf.service.WFActorService();
        service50.postConstruct();
        net.ibizsys.psrt.srv.common.service.CodeListService service51= 	 new net.ibizsys.psrt.srv.common.service.CodeListService();
        service51.postConstruct();
        net.ibizsys.psrt.srv.common.service.MsgTemplateService service52= 	 new net.ibizsys.psrt.srv.common.service.MsgTemplateService();
        service52.postConstruct();
        net.ibizsys.psrt.srv.common.service.UserRoleTypeService service53= 	 new net.ibizsys.psrt.srv.common.service.UserRoleTypeService();
        service53.postConstruct();
        net.ibizsys.psrt.srv.common.service.UserDictItemService service54= 	 new net.ibizsys.psrt.srv.common.service.UserDictItemService();
        service54.postConstruct();
        net.ibizsys.psrt.srv.wx.service.WXAccountService service55= 	 new net.ibizsys.psrt.srv.wx.service.WXAccountService();
        service55.postConstruct();
        net.ibizsys.psrt.srv.common.service.DataSyncInService service56= 	 new net.ibizsys.psrt.srv.common.service.DataSyncInService();
        service56.postConstruct();
        net.ibizsys.psrt.srv.common.service.CodeItemService service57= 	 new net.ibizsys.psrt.srv.common.service.CodeItemService();
        service57.postConstruct();
        net.ibizsys.psrt.srv.common.service.TSSDEngineService service58= 	 new net.ibizsys.psrt.srv.common.service.TSSDEngineService();
        service58.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFUCPolicyService service59= 	 new net.ibizsys.psrt.srv.wf.service.WFUCPolicyService();
        service59.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFStepActorService service60= 	 new net.ibizsys.psrt.srv.wf.service.WFStepActorService();
        service60.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFActionService service61= 	 new net.ibizsys.psrt.srv.wf.service.WFActionService();
        service61.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFUIWizardService service62= 	 new net.ibizsys.psrt.srv.wf.service.WFUIWizardService();
        service62.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFStepService service63= 	 new net.ibizsys.psrt.srv.wf.service.WFStepService();
        service63.postConstruct();
        net.ibizsys.psrt.srv.common.service.UserGroupDetailService service64= 	 new net.ibizsys.psrt.srv.common.service.UserGroupDetailService();
        service64.postConstruct();
        net.ibizsys.psrt.srv.dynasys.service.DSDynaWFService service65= 	 new net.ibizsys.psrt.srv.dynasys.service.DSDynaWFService();
        service65.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFAppSettingService service66= 	 new net.ibizsys.psrt.srv.wf.service.WFAppSettingService();
        service66.postConstruct();
        net.ibizsys.psrt.srv.wx.service.WXOrgSectorService service67= 	 new net.ibizsys.psrt.srv.wx.service.WXOrgSectorService();
        service67.postConstruct();
        net.ibizsys.psrt.srv.common.service.DataSyncOut2Service service68= 	 new net.ibizsys.psrt.srv.common.service.DataSyncOut2Service();
        service68.postConstruct();
        net.ibizsys.psrt.srv.wx.service.WXMediaService service69= 	 new net.ibizsys.psrt.srv.wx.service.WXMediaService();
        service69.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFSystemUserService service70= 	 new net.ibizsys.psrt.srv.wf.service.WFSystemUserService();
        service70.postConstruct();
        net.ibizsys.psrt.srv.common.service.ServiceService service71= 	 new net.ibizsys.psrt.srv.common.service.ServiceService();
        service71.postConstruct();
        net.ibizsys.psrt.srv.common.service.MsgAccountDetailService service72= 	 new net.ibizsys.psrt.srv.common.service.MsgAccountDetailService();
        service72.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFVersionService service73= 	 new net.ibizsys.psrt.srv.wf.service.WFVersionService();
        service73.postConstruct();
        net.ibizsys.psrt.srv.common.service.UserDictService service74= 	 new net.ibizsys.psrt.srv.common.service.UserDictService();
        service74.postConstruct();
        net.ibizsys.psrt.srv.common.service.DEDataChgService service75= 	 new net.ibizsys.psrt.srv.common.service.DEDataChgService();
        service75.postConstruct();
        net.ibizsys.psrt.srv.common.service.PortalPageService service76= 	 new net.ibizsys.psrt.srv.common.service.PortalPageService();
        service76.postConstruct();
        net.ibizsys.psrt.srv.common.service.LoginAccountService service77= 	 new net.ibizsys.psrt.srv.common.service.LoginAccountService();
        service77.postConstruct();
        net.ibizsys.psrt.srv.common.service.UserService service78= 	 new net.ibizsys.psrt.srv.common.service.UserService();
        service78.postConstruct();
        net.ibizsys.psrt.srv.common.service.OrgUnitCatService service79= 	 new net.ibizsys.psrt.srv.common.service.OrgUnitCatService();
        service79.postConstruct();
        net.ibizsys.psrt.srv.dynasys.service.DSDynaWFVerService service80= 	 new net.ibizsys.psrt.srv.dynasys.service.DSDynaWFVerService();
        service80.postConstruct();
        net.ibizsys.psrt.srv.common.service.OrgSecUserService service81= 	 new net.ibizsys.psrt.srv.common.service.OrgSecUserService();
        service81.postConstruct();
        net.ibizsys.psrt.srv.common.service.TSSDGroupDetailService service82= 	 new net.ibizsys.psrt.srv.common.service.TSSDGroupDetailService();
        service82.postConstruct();
        net.ibizsys.psrt.srv.common.service.OrgUserLevelService service83= 	 new net.ibizsys.psrt.srv.common.service.OrgUserLevelService();
        service83.postConstruct();
        net.ibizsys.psrt.srv.common.service.FileService service84= 	 new net.ibizsys.psrt.srv.common.service.FileService();
        service84.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFDynamicUserService service85= 	 new net.ibizsys.psrt.srv.wf.service.WFDynamicUserService();
        service85.postConstruct();
        net.ibizsys.psrt.srv.common.service.PPModelService service86= 	 new net.ibizsys.psrt.srv.common.service.PPModelService();
        service86.postConstruct();
        net.ibizsys.psrt.srv.common.service.TSSDTaskLogService service87= 	 new net.ibizsys.psrt.srv.common.service.TSSDTaskLogService();
        service87.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFUserService service88= 	 new net.ibizsys.psrt.srv.wf.service.WFUserService();
        service88.postConstruct();
        net.ibizsys.psrt.srv.common.service.DataSyncOutService service89= 	 new net.ibizsys.psrt.srv.common.service.DataSyncOutService();
        service89.postConstruct();
        net.ibizsys.psrt.srv.common.service.UserGroupService service90= 	 new net.ibizsys.psrt.srv.common.service.UserGroupService();
        service90.postConstruct();
        net.ibizsys.psrt.srv.common.service.UserObjectServiceProxy service91= 	 new net.ibizsys.psrt.srv.common.service.UserObjectServiceProxy();
        service91.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFTmpStepActorService service92= 	 new net.ibizsys.psrt.srv.wf.service.WFTmpStepActorService();
        service92.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFWorkList2Service service93= 	 new net.ibizsys.psrt.srv.wf.service.WFWorkList2Service();
        service93.postConstruct();
        net.ibizsys.psrt.srv.demodel.service.DataEntityService service94= 	 new net.ibizsys.psrt.srv.demodel.service.DataEntityService();
        service94.postConstruct();
        net.ibizsys.psrt.srv.common.service.MsgAccountService service95= 	 new net.ibizsys.psrt.srv.common.service.MsgAccountService();
        service95.postConstruct();
        net.ibizsys.psrt.srv.common.service.DataSyncAgentService service96= 	 new net.ibizsys.psrt.srv.common.service.DataSyncAgentService();
        service96.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFInstanceService service97= 	 new net.ibizsys.psrt.srv.wf.service.WFInstanceService();
        service97.postConstruct();
        net.ibizsys.psrt.srv.wx.service.WXMessageService service98= 	 new net.ibizsys.psrt.srv.wx.service.WXMessageService();
        service98.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFUserGroupService service99= 	 new net.ibizsys.psrt.srv.wf.service.WFUserGroupService();
        service99.postConstruct();
        net.ibizsys.psrt.srv.common.service.OrgUserService service100= 	 new net.ibizsys.psrt.srv.common.service.OrgUserService();
        service100.postConstruct();
        net.ibizsys.psrt.srv.common.service.OrgSecUserTypeService service101= 	 new net.ibizsys.psrt.srv.common.service.OrgSecUserTypeService();
        service101.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFReminderService service102= 	 new net.ibizsys.psrt.srv.wf.service.WFReminderService();
        service102.postConstruct();
        net.ibizsys.psrt.srv.wf.service.WFStepInstService service103= 	 new net.ibizsys.psrt.srv.wf.service.WFStepInstService();
        service103.postConstruct();
        net.ibizsys.psrt.srv.common.service.OrgService service104= 	 new net.ibizsys.psrt.srv.common.service.OrgService();
        service104.postConstruct();
    }

    /**
     * 准备系统实体数据访问对象
     */
    protected void prepareDAOs() throws Exception {
        net.ibizsys.psrt.srv.common.dao.SystemDAO dao0= 	 new net.ibizsys.psrt.srv.common.dao.SystemDAO();
        dao0.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFUserCandidateDAO dao1= 	 new net.ibizsys.psrt.srv.wf.dao.WFUserCandidateDAO();
        dao1.postConstruct();
        net.ibizsys.psrt.srv.common.dao.UniResDAO dao2= 	 new net.ibizsys.psrt.srv.common.dao.UniResDAO();
        dao2.postConstruct();
        net.ibizsys.psrt.srv.dynasys.dao.DSDynaViewInstDAO dao3= 	 new net.ibizsys.psrt.srv.dynasys.dao.DSDynaViewInstDAO();
        dao3.postConstruct();
        net.ibizsys.psrt.srv.dynasys.dao.DSDynaCodeListDAO dao4= 	 new net.ibizsys.psrt.srv.dynasys.dao.DSDynaCodeListDAO();
        dao4.postConstruct();
        net.ibizsys.psrt.srv.common.dao.DEDataChg2DAO dao5= 	 new net.ibizsys.psrt.srv.common.dao.DEDataChg2DAO();
        dao5.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFStepDataDAO dao6= 	 new net.ibizsys.psrt.srv.wf.dao.WFStepDataDAO();
        dao6.postConstruct();
        net.ibizsys.psrt.srv.common.dao.SysAdminDAO dao7= 	 new net.ibizsys.psrt.srv.common.dao.SysAdminDAO();
        dao7.postConstruct();
        net.ibizsys.psrt.srv.wx.dao.WXEntAppDAO dao8= 	 new net.ibizsys.psrt.srv.wx.dao.WXEntAppDAO();
        dao8.postConstruct();
        net.ibizsys.psrt.srv.common.dao.UserRoleDataDetailDAO dao9= 	 new net.ibizsys.psrt.srv.common.dao.UserRoleDataDetailDAO();
        dao9.postConstruct();
        net.ibizsys.psrt.srv.common.dao.DEDataChgDispDAO dao10= 	 new net.ibizsys.psrt.srv.common.dao.DEDataChgDispDAO();
        dao10.postConstruct();
        net.ibizsys.psrt.srv.common.dao.TSSDTaskTypeDAO dao11= 	 new net.ibizsys.psrt.srv.common.dao.TSSDTaskTypeDAO();
        dao11.postConstruct();
        net.ibizsys.psrt.srv.common.dao.PVPartDAO dao12= 	 new net.ibizsys.psrt.srv.common.dao.PVPartDAO();
        dao12.postConstruct();
        net.ibizsys.psrt.srv.common.dao.DataAuditDAO dao13= 	 new net.ibizsys.psrt.srv.common.dao.DataAuditDAO();
        dao13.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFWorkListDAO dao14= 	 new net.ibizsys.psrt.srv.wf.dao.WFWorkListDAO();
        dao14.postConstruct();
        net.ibizsys.psrt.srv.common.dao.UserRoleResDAO dao15= 	 new net.ibizsys.psrt.srv.common.dao.UserRoleResDAO();
        dao15.postConstruct();
        net.ibizsys.psrt.srv.common.dao.RegistryDAO dao16= 	 new net.ibizsys.psrt.srv.common.dao.RegistryDAO();
        dao16.postConstruct();
        net.ibizsys.psrt.srv.common.dao.UserRoleDAO dao17= 	 new net.ibizsys.psrt.srv.common.dao.UserRoleDAO();
        dao17.postConstruct();
        net.ibizsys.psrt.srv.common.dao.TSSDTaskPolicyDAO dao18= 	 new net.ibizsys.psrt.srv.common.dao.TSSDTaskPolicyDAO();
        dao18.postConstruct();
        net.ibizsys.psrt.srv.common.dao.TSSDPolicyOwnerDAO dao19= 	 new net.ibizsys.psrt.srv.common.dao.TSSDPolicyOwnerDAO();
        dao19.postConstruct();
        net.ibizsys.psrt.srv.common.dao.UserRoleDEFieldDAO dao20= 	 new net.ibizsys.psrt.srv.common.dao.UserRoleDEFieldDAO();
        dao20.postConstruct();
        net.ibizsys.psrt.srv.common.dao.TSSDGroupDAO dao21= 	 new net.ibizsys.psrt.srv.common.dao.TSSDGroupDAO();
        dao21.postConstruct();
        net.ibizsys.psrt.srv.dynasys.dao.DSDynaViewDAO dao22= 	 new net.ibizsys.psrt.srv.dynasys.dao.DSDynaViewDAO();
        dao22.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFUserGroupDetailDAO dao23= 	 new net.ibizsys.psrt.srv.wf.dao.WFUserGroupDetailDAO();
        dao23.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFCustomProcessDAO dao24= 	 new net.ibizsys.psrt.srv.wf.dao.WFCustomProcessDAO();
        dao24.postConstruct();
        net.ibizsys.psrt.srv.common.dao.UserDictCatDAO dao25= 	 new net.ibizsys.psrt.srv.common.dao.UserDictCatDAO();
        dao25.postConstruct();
        net.ibizsys.psrt.srv.common.dao.TSSDItemDAO dao26= 	 new net.ibizsys.psrt.srv.common.dao.TSSDItemDAO();
        dao26.postConstruct();
        net.ibizsys.psrt.srv.common.dao.LoginLogDAO dao27= 	 new net.ibizsys.psrt.srv.common.dao.LoginLogDAO();
        dao27.postConstruct();
        net.ibizsys.psrt.srv.common.dao.SysAdminFuncDAO dao28= 	 new net.ibizsys.psrt.srv.common.dao.SysAdminFuncDAO();
        dao28.postConstruct();
        net.ibizsys.psrt.srv.common.dao.TSSDTaskDAO dao29= 	 new net.ibizsys.psrt.srv.common.dao.TSSDTaskDAO();
        dao29.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFUserAssistDAO dao30= 	 new net.ibizsys.psrt.srv.wf.dao.WFUserAssistDAO();
        dao30.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFIAActionDAO dao31= 	 new net.ibizsys.psrt.srv.wf.dao.WFIAActionDAO();
        dao31.postConstruct();
        net.ibizsys.psrt.srv.wx.dao.WXAccessTokenDAO dao32= 	 new net.ibizsys.psrt.srv.wx.dao.WXAccessTokenDAO();
        dao32.postConstruct();
        net.ibizsys.psrt.srv.common.dao.UserRoleDataActionDAO dao33= 	 new net.ibizsys.psrt.srv.common.dao.UserRoleDataActionDAO();
        dao33.postConstruct();
        net.ibizsys.psrt.srv.common.dao.OrgTypeDAO dao34= 	 new net.ibizsys.psrt.srv.common.dao.OrgTypeDAO();
        dao34.postConstruct();
        net.ibizsys.psrt.srv.common.dao.DALogDAO dao35= 	 new net.ibizsys.psrt.srv.common.dao.DALogDAO();
        dao35.postConstruct();
        net.ibizsys.psrt.srv.common.dao.UserDGThemeDAO dao36= 	 new net.ibizsys.psrt.srv.common.dao.UserDGThemeDAO();
        dao36.postConstruct();
        net.ibizsys.psrt.srv.common.dao.UserRoleDatasDAO dao37= 	 new net.ibizsys.psrt.srv.common.dao.UserRoleDatasDAO();
        dao37.postConstruct();
        net.ibizsys.psrt.srv.common.dao.OrgSectorDAO dao38= 	 new net.ibizsys.psrt.srv.common.dao.OrgSectorDAO();
        dao38.postConstruct();
        net.ibizsys.psrt.srv.common.dao.MsgSendQueueDAO dao39= 	 new net.ibizsys.psrt.srv.common.dao.MsgSendQueueDAO();
        dao39.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFAssistWorkDAO dao40= 	 new net.ibizsys.psrt.srv.wf.dao.WFAssistWorkDAO();
        dao40.postConstruct();
        net.ibizsys.psrt.srv.demodel.dao.QueryModelDAO dao41= 	 new net.ibizsys.psrt.srv.demodel.dao.QueryModelDAO();
        dao41.postConstruct();
        net.ibizsys.psrt.srv.common.dao.UserRoleDetailDAO dao42= 	 new net.ibizsys.psrt.srv.common.dao.UserRoleDetailDAO();
        dao42.postConstruct();
        net.ibizsys.psrt.srv.common.dao.UserRoleDataDAO dao43= 	 new net.ibizsys.psrt.srv.common.dao.UserRoleDataDAO();
        dao43.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFWorkflowDAO dao44= 	 new net.ibizsys.psrt.srv.wf.dao.WFWorkflowDAO();
        dao44.postConstruct();
        net.ibizsys.psrt.srv.common.dao.UserRoleDEFieldsDAO dao45= 	 new net.ibizsys.psrt.srv.common.dao.UserRoleDEFieldsDAO();
        dao45.postConstruct();
        net.ibizsys.psrt.srv.common.dao.MsgSendQueueHisDAO dao46= 	 new net.ibizsys.psrt.srv.common.dao.MsgSendQueueHisDAO();
        dao46.postConstruct();
        net.ibizsys.psrt.srv.common.dao.DataSyncIn2DAO dao47= 	 new net.ibizsys.psrt.srv.common.dao.DataSyncIn2DAO();
        dao47.postConstruct();
        net.ibizsys.psrt.srv.common.dao.DataAuditDetailDAO dao48= 	 new net.ibizsys.psrt.srv.common.dao.DataAuditDetailDAO();
        dao48.postConstruct();
        net.ibizsys.psrt.srv.common.dao.TSSDPolicyDAO dao49= 	 new net.ibizsys.psrt.srv.common.dao.TSSDPolicyDAO();
        dao49.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFActorDAO dao50= 	 new net.ibizsys.psrt.srv.wf.dao.WFActorDAO();
        dao50.postConstruct();
        net.ibizsys.psrt.srv.common.dao.CodeListDAO dao51= 	 new net.ibizsys.psrt.srv.common.dao.CodeListDAO();
        dao51.postConstruct();
        net.ibizsys.psrt.srv.common.dao.MsgTemplateDAO dao52= 	 new net.ibizsys.psrt.srv.common.dao.MsgTemplateDAO();
        dao52.postConstruct();
        net.ibizsys.psrt.srv.common.dao.UserRoleTypeDAO dao53= 	 new net.ibizsys.psrt.srv.common.dao.UserRoleTypeDAO();
        dao53.postConstruct();
        net.ibizsys.psrt.srv.common.dao.UserDictItemDAO dao54= 	 new net.ibizsys.psrt.srv.common.dao.UserDictItemDAO();
        dao54.postConstruct();
        net.ibizsys.psrt.srv.wx.dao.WXAccountDAO dao55= 	 new net.ibizsys.psrt.srv.wx.dao.WXAccountDAO();
        dao55.postConstruct();
        net.ibizsys.psrt.srv.common.dao.DataSyncInDAO dao56= 	 new net.ibizsys.psrt.srv.common.dao.DataSyncInDAO();
        dao56.postConstruct();
        net.ibizsys.psrt.srv.common.dao.CodeItemDAO dao57= 	 new net.ibizsys.psrt.srv.common.dao.CodeItemDAO();
        dao57.postConstruct();
        net.ibizsys.psrt.srv.common.dao.TSSDEngineDAO dao58= 	 new net.ibizsys.psrt.srv.common.dao.TSSDEngineDAO();
        dao58.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFUCPolicyDAO dao59= 	 new net.ibizsys.psrt.srv.wf.dao.WFUCPolicyDAO();
        dao59.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFStepActorDAO dao60= 	 new net.ibizsys.psrt.srv.wf.dao.WFStepActorDAO();
        dao60.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFActionDAO dao61= 	 new net.ibizsys.psrt.srv.wf.dao.WFActionDAO();
        dao61.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFUIWizardDAO dao62= 	 new net.ibizsys.psrt.srv.wf.dao.WFUIWizardDAO();
        dao62.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFStepDAO dao63= 	 new net.ibizsys.psrt.srv.wf.dao.WFStepDAO();
        dao63.postConstruct();
        net.ibizsys.psrt.srv.common.dao.UserGroupDetailDAO dao64= 	 new net.ibizsys.psrt.srv.common.dao.UserGroupDetailDAO();
        dao64.postConstruct();
        net.ibizsys.psrt.srv.dynasys.dao.DSDynaWFDAO dao65= 	 new net.ibizsys.psrt.srv.dynasys.dao.DSDynaWFDAO();
        dao65.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFAppSettingDAO dao66= 	 new net.ibizsys.psrt.srv.wf.dao.WFAppSettingDAO();
        dao66.postConstruct();
        net.ibizsys.psrt.srv.wx.dao.WXOrgSectorDAO dao67= 	 new net.ibizsys.psrt.srv.wx.dao.WXOrgSectorDAO();
        dao67.postConstruct();
        net.ibizsys.psrt.srv.common.dao.DataSyncOut2DAO dao68= 	 new net.ibizsys.psrt.srv.common.dao.DataSyncOut2DAO();
        dao68.postConstruct();
        net.ibizsys.psrt.srv.wx.dao.WXMediaDAO dao69= 	 new net.ibizsys.psrt.srv.wx.dao.WXMediaDAO();
        dao69.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFSystemUserDAO dao70= 	 new net.ibizsys.psrt.srv.wf.dao.WFSystemUserDAO();
        dao70.postConstruct();
        net.ibizsys.psrt.srv.common.dao.ServiceDAO dao71= 	 new net.ibizsys.psrt.srv.common.dao.ServiceDAO();
        dao71.postConstruct();
        net.ibizsys.psrt.srv.common.dao.MsgAccountDetailDAO dao72= 	 new net.ibizsys.psrt.srv.common.dao.MsgAccountDetailDAO();
        dao72.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFVersionDAO dao73= 	 new net.ibizsys.psrt.srv.wf.dao.WFVersionDAO();
        dao73.postConstruct();
        net.ibizsys.psrt.srv.common.dao.UserDictDAO dao74= 	 new net.ibizsys.psrt.srv.common.dao.UserDictDAO();
        dao74.postConstruct();
        net.ibizsys.psrt.srv.common.dao.DEDataChgDAO dao75= 	 new net.ibizsys.psrt.srv.common.dao.DEDataChgDAO();
        dao75.postConstruct();
        net.ibizsys.psrt.srv.common.dao.PortalPageDAO dao76= 	 new net.ibizsys.psrt.srv.common.dao.PortalPageDAO();
        dao76.postConstruct();
        net.ibizsys.psrt.srv.common.dao.LoginAccountDAO dao77= 	 new net.ibizsys.psrt.srv.common.dao.LoginAccountDAO();
        dao77.postConstruct();
        net.ibizsys.psrt.srv.common.dao.UserDAO dao78= 	 new net.ibizsys.psrt.srv.common.dao.UserDAO();
        dao78.postConstruct();
        net.ibizsys.psrt.srv.common.dao.OrgUnitCatDAO dao79= 	 new net.ibizsys.psrt.srv.common.dao.OrgUnitCatDAO();
        dao79.postConstruct();
        net.ibizsys.psrt.srv.dynasys.dao.DSDynaWFVerDAO dao80= 	 new net.ibizsys.psrt.srv.dynasys.dao.DSDynaWFVerDAO();
        dao80.postConstruct();
        net.ibizsys.psrt.srv.common.dao.OrgSecUserDAO dao81= 	 new net.ibizsys.psrt.srv.common.dao.OrgSecUserDAO();
        dao81.postConstruct();
        net.ibizsys.psrt.srv.common.dao.TSSDGroupDetailDAO dao82= 	 new net.ibizsys.psrt.srv.common.dao.TSSDGroupDetailDAO();
        dao82.postConstruct();
        net.ibizsys.psrt.srv.common.dao.OrgUserLevelDAO dao83= 	 new net.ibizsys.psrt.srv.common.dao.OrgUserLevelDAO();
        dao83.postConstruct();
        net.ibizsys.psrt.srv.common.dao.FileDAO dao84= 	 new net.ibizsys.psrt.srv.common.dao.FileDAO();
        dao84.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFDynamicUserDAO dao85= 	 new net.ibizsys.psrt.srv.wf.dao.WFDynamicUserDAO();
        dao85.postConstruct();
        net.ibizsys.psrt.srv.common.dao.PPModelDAO dao86= 	 new net.ibizsys.psrt.srv.common.dao.PPModelDAO();
        dao86.postConstruct();
        net.ibizsys.psrt.srv.common.dao.TSSDTaskLogDAO dao87= 	 new net.ibizsys.psrt.srv.common.dao.TSSDTaskLogDAO();
        dao87.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFUserDAO dao88= 	 new net.ibizsys.psrt.srv.wf.dao.WFUserDAO();
        dao88.postConstruct();
        net.ibizsys.psrt.srv.common.dao.DataSyncOutDAO dao89= 	 new net.ibizsys.psrt.srv.common.dao.DataSyncOutDAO();
        dao89.postConstruct();
        net.ibizsys.psrt.srv.common.dao.UserGroupDAO dao90= 	 new net.ibizsys.psrt.srv.common.dao.UserGroupDAO();
        dao90.postConstruct();
        net.ibizsys.psrt.srv.common.dao.UserObjectDAO dao91= 	 new net.ibizsys.psrt.srv.common.dao.UserObjectDAO();
        dao91.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFTmpStepActorDAO dao92= 	 new net.ibizsys.psrt.srv.wf.dao.WFTmpStepActorDAO();
        dao92.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFWorkList2DAO dao93= 	 new net.ibizsys.psrt.srv.wf.dao.WFWorkList2DAO();
        dao93.postConstruct();
        net.ibizsys.psrt.srv.demodel.dao.DataEntityDAO dao94= 	 new net.ibizsys.psrt.srv.demodel.dao.DataEntityDAO();
        dao94.postConstruct();
        net.ibizsys.psrt.srv.common.dao.MsgAccountDAO dao95= 	 new net.ibizsys.psrt.srv.common.dao.MsgAccountDAO();
        dao95.postConstruct();
        net.ibizsys.psrt.srv.common.dao.DataSyncAgentDAO dao96= 	 new net.ibizsys.psrt.srv.common.dao.DataSyncAgentDAO();
        dao96.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFInstanceDAO dao97= 	 new net.ibizsys.psrt.srv.wf.dao.WFInstanceDAO();
        dao97.postConstruct();
        net.ibizsys.psrt.srv.wx.dao.WXMessageDAO dao98= 	 new net.ibizsys.psrt.srv.wx.dao.WXMessageDAO();
        dao98.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFUserGroupDAO dao99= 	 new net.ibizsys.psrt.srv.wf.dao.WFUserGroupDAO();
        dao99.postConstruct();
        net.ibizsys.psrt.srv.common.dao.OrgUserDAO dao100= 	 new net.ibizsys.psrt.srv.common.dao.OrgUserDAO();
        dao100.postConstruct();
        net.ibizsys.psrt.srv.common.dao.OrgSecUserTypeDAO dao101= 	 new net.ibizsys.psrt.srv.common.dao.OrgSecUserTypeDAO();
        dao101.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFReminderDAO dao102= 	 new net.ibizsys.psrt.srv.wf.dao.WFReminderDAO();
        dao102.postConstruct();
        net.ibizsys.psrt.srv.wf.dao.WFStepInstDAO dao103= 	 new net.ibizsys.psrt.srv.wf.dao.WFStepInstDAO();
        dao103.postConstruct();
        net.ibizsys.psrt.srv.common.dao.OrgDAO dao104= 	 new net.ibizsys.psrt.srv.common.dao.OrgDAO();
        dao104.postConstruct();
    }

    /**
     * 准备系统工作流模型
     */
    protected void prepareWorkflows() throws Exception {


    }

    /**
     * 准备大数据架构模型
     */
    protected void prepareBASchemes() throws Exception {
    }

    /**
     * 准备微信公众号
     */
    protected void prepareWXAccounts() throws Exception {
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.sysmodel.SystemModelBase#onInstallRTDatas()
     */
    @Override
    protected void onInstallRTDatas() throws Exception {
        super.onInstallRTDatas();

        net.ibizsys.psrt.srv.common.service.UserDictCatService userDictCatService  = (net.ibizsys.psrt.srv.common.service.UserDictCatService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.UserDictCatService.class);
        net.ibizsys.psrt.srv.common.service.UserDictService userDictService  = (net.ibizsys.psrt.srv.common.service.UserDictService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.UserDictService.class);
        net.ibizsys.psrt.srv.common.service.UniResService uniResService  = (net.ibizsys.psrt.srv.common.service.UniResService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.UniResService.class);
        net.ibizsys.psrt.srv.common.service.MsgTemplateService msgTemplateService  = (net.ibizsys.psrt.srv.common.service.MsgTemplateService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.MsgTemplateService.class);
        net.ibizsys.psrt.srv.common.service.ServiceService serviceService  = (net.ibizsys.psrt.srv.common.service.ServiceService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.ServiceService.class);
        net.ibizsys.psrt.srv.wf.service.WFAppSettingService wfAppSettingService  = (net.ibizsys.psrt.srv.wf.service.WFAppSettingService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFAppSettingService.class);
        net.ibizsys.psrt.srv.common.service.DataSyncAgentService dataSyncAgentService  = (net.ibizsys.psrt.srv.common.service.DataSyncAgentService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.DataSyncAgentService.class);
        net.ibizsys.psrt.srv.wx.service.WXAccountService wxAccountService  = (net.ibizsys.psrt.srv.wx.service.WXAccountService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wx.service.WXAccountService.class);
        net.ibizsys.psrt.srv.wx.service.WXEntAppService wxEntAppService  = (net.ibizsys.psrt.srv.wx.service.WXEntAppService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wx.service.WXEntAppService.class);

        onInstallRTDatas_DataEntity();

        //初始化用户词条类别

        //初始化系统统一资源

        //初始化系统消息模板
        //初始化数据同步代理
        //初始化系统后台作业
    }

    protected void onInstallRTDatas_DataEntity() throws Exception {
        onInstallRTDatas_DataEntity_DEModel();
        onInstallRTDatas_DataEntity_DynaSys();
        onInstallRTDatas_DataEntity_WX();
        onInstallRTDatas_DataEntity_WF();
        onInstallRTDatas_DataEntity_Common();
    }

    protected void onInstallRTDatas_DataEntity_DEModel() throws Exception {
        net.ibizsys.psrt.srv.demodel.service.DataEntityService dataEntityService  = (net.ibizsys.psrt.srv.demodel.service.DataEntityService)ServiceGlobal.getService(net.ibizsys.psrt.srv.demodel.service.DataEntityService.class);
        net.ibizsys.psrt.srv.demodel.service.QueryModelService queryModelService  = (net.ibizsys.psrt.srv.demodel.service.QueryModelService)ServiceGlobal.getService(net.ibizsys.psrt.srv.demodel.service.QueryModelService.class);


        // 安装实体 "实体查询模型"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("ee650aec5d0df3c9880100dc57441146");
            dataEntity.setDEName("QUERYMODEL");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("实体查询模型");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "实体"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("0cbbb4ccda4e86a9e6f16ed5f3a171c2");
            dataEntity.setDEName("DATAENTITY");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("实体");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }

    }
    protected void onInstallRTDatas_DataEntity_DynaSys() throws Exception {
        net.ibizsys.psrt.srv.demodel.service.DataEntityService dataEntityService  = (net.ibizsys.psrt.srv.demodel.service.DataEntityService)ServiceGlobal.getService(net.ibizsys.psrt.srv.demodel.service.DataEntityService.class);
        net.ibizsys.psrt.srv.demodel.service.QueryModelService queryModelService  = (net.ibizsys.psrt.srv.demodel.service.QueryModelService)ServiceGlobal.getService(net.ibizsys.psrt.srv.demodel.service.QueryModelService.class);


        // 安装实体 "动态视图实例"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("455ba35d2ea0b7be6e2035f54ff60f5b");
            dataEntity.setDEName("DSDYNAVIEWINST");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("动态视图实例");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "动态代码表"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("7a90be048da1f8e71d2f8f74e8703c05");
            dataEntity.setDEName("DSDYNACODELIST");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("动态代码表");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "动态视图"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("87d8599997ce9323cd2bba43278b4135");
            dataEntity.setDEName("DSDYNAVIEW");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("动态视图");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "动态工作流"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("94ed000542e335afa0722bc1cbfdf279");
            dataEntity.setDEName("DSDYNAWF");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("动态工作流");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "动态工作流版本"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("da1ebfa0f1777e651b33c7e1df73c4ec");
            dataEntity.setDEName("DSDYNAWFVER");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("动态工作流版本");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }

    }
    protected void onInstallRTDatas_DataEntity_WX() throws Exception {
        net.ibizsys.psrt.srv.demodel.service.DataEntityService dataEntityService  = (net.ibizsys.psrt.srv.demodel.service.DataEntityService)ServiceGlobal.getService(net.ibizsys.psrt.srv.demodel.service.DataEntityService.class);
        net.ibizsys.psrt.srv.demodel.service.QueryModelService queryModelService  = (net.ibizsys.psrt.srv.demodel.service.QueryModelService)ServiceGlobal.getService(net.ibizsys.psrt.srv.demodel.service.QueryModelService.class);


        // 安装实体 "微信企业应用"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("aeb4861b6d65eff3ef2098ddd7a0d4f5");
            dataEntity.setDEName("WXENTAPP");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("微信企业应用");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "微信访问票据"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("7c0817a9156329b7eed4a878988f31cc");
            dataEntity.setDEName("WXACCESSTOKEN");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("微信访问票据");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "微信公众号"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("a807f4b43d86fbcad55c58e4621a8c80");
            dataEntity.setDEName("WXACCOUNT");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("微信公众号");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "微信部门"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("2b5ee3ad72f76d2cb7d12f8c5f31b817");
            dataEntity.setDEName("WXORGSECTOR");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("微信部门");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "微信多媒体内容"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("6e265a32be682141a452a8832bc78530");
            dataEntity.setDEName("WXMEDIA");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("微信多媒体内容");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "微信消息"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("657d40a805a0f204934829160a198bb7");
            dataEntity.setDEName("WXMESSAGE");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("微信消息");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }

    }
    protected void onInstallRTDatas_DataEntity_WF() throws Exception {
        net.ibizsys.psrt.srv.demodel.service.DataEntityService dataEntityService  = (net.ibizsys.psrt.srv.demodel.service.DataEntityService)ServiceGlobal.getService(net.ibizsys.psrt.srv.demodel.service.DataEntityService.class);
        net.ibizsys.psrt.srv.demodel.service.QueryModelService queryModelService  = (net.ibizsys.psrt.srv.demodel.service.QueryModelService)ServiceGlobal.getService(net.ibizsys.psrt.srv.demodel.service.QueryModelService.class);


        // 安装实体 "工作流用户候选者"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("9f2a5bbda357d70344cb5debd7d05c71");
            dataEntity.setDEName("WFUSERCANDIDATE");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流用户候选者");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流步骤数据"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("095ff4eab83529a1b8f093180a7ef3fa");
            dataEntity.setDEName("WFSTEPDATA");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流步骤数据");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流工作列表"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("c93ef4408352303441d2f73e0e4990a2");
            dataEntity.setDEName("WFWORKLIST");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流工作列表");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流用户组成员"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("0b60b3e6ed35cc656ceecb6fac698e6e");
            dataEntity.setDEName("WFUSERGROUPDETAIL");
            dataEntity.setDEType(3);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流用户组成员");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流预定义处理"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("4b334725c65c703dfa12a6ed7103a9da");
            dataEntity.setDEName("WFCUSTOMPROCESS");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流预定义处理");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流用户代办"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("c0a02fe821e07837af3333a49fb08b30");
            dataEntity.setDEName("WFUSERASSIST");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流用户代办");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流交互操作"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("e1ba3122fd9af91ae76dd18bf015669a");
            dataEntity.setDEName("WFIAACTION");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流交互操作");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流代办工作"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("80bc47afe28e23ebfb7aea12fdbc1acd");
            dataEntity.setDEName("WFASSISTWORK");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流代办工作");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流配置"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("0166e9c016bf57201ba996cba3a67a45");
            dataEntity.setDEName("WFWORKFLOW");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(1);
            dataEntity.setDELogicName("工作流配置");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流操作者"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("a532b2dae4eeecca638c9a8e1b7e3fa7");
            dataEntity.setDEName("WFACTOR");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流操作者");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流候选用户策略"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("fa6ff2a161c8371f494e170dde6ddb53");
            dataEntity.setDEName("WFUCPOLICY");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流候选用户策略");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流步骤操作者"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("3860c42c755f4097c4dfe7d806b185bc");
            dataEntity.setDEName("WFSTEPACTOR");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流步骤操作者");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流用户操作"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("50811730d38a8bd964a31a05331bc214");
            dataEntity.setDEName("WFACTION");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流用户操作");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流操作界面"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("6ad51695d5686e6ed1738d36b5a6b1a2");
            dataEntity.setDEName("WFUIWIZARD");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流操作界面");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流步骤"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("aa16d05a90245cec51dc8a2fb7f63fdb");
            dataEntity.setDEName("WFSTEP");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流步骤");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流系统设定"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("598b85c09bc9375e762590d2ab97552c");
            dataEntity.setDEName("WFAPPSETTING");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流系统设定");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流系统用户"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("3d6fd9746bb1acf4b6af87da05f6a646");
            dataEntity.setDEName("WFSYSTEMUSER");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流系统用户");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流配置版本"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("f0abca40127ddf436270635ba0e3c135");
            dataEntity.setDEName("WFWFVERSION");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流配置版本");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流动态用户"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("733170434261be84089d353a6a231373");
            dataEntity.setDEName("WFDYNAMICUSER");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流动态用户");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流用户"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("ef2c7b349c855e594aa4fe0cb7ad8b48");
            dataEntity.setDEName("WFUSER");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流用户");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流步骤操作者（临时）"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("0e976da1c2895bf2e955f90554c10b15");
            dataEntity.setDEName("WFTMPSTEPACTOR");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流步骤操作者（临时）");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流工作列表2"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("e888ed9d1cfcb38ac15cceaa4130b162");
            dataEntity.setDEName("WFWORKLIST2");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流工作列表2");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流实例"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("0211d06b901d7948d2394149b7d0d96e");
            dataEntity.setDEName("WFINSTANCE");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(1);
            dataEntity.setDELogicName("工作流实例");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流用户组"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("e64a576e41250c73ac1f51c15d6631e2");
            dataEntity.setDEName("WFUSERGROUP");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流用户组");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流工作催办"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("352ff0280b4d127a400f4262d6ebfded");
            dataEntity.setDEName("WFREMINDER");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流工作催办");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "工作流步骤子实例"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("707f76a538be385bf4bf65a2b1125003");
            dataEntity.setDEName("WFSTEPINST");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("工作流步骤子实例");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }

    }
    protected void onInstallRTDatas_DataEntity_Common() throws Exception {
        net.ibizsys.psrt.srv.demodel.service.DataEntityService dataEntityService  = (net.ibizsys.psrt.srv.demodel.service.DataEntityService)ServiceGlobal.getService(net.ibizsys.psrt.srv.demodel.service.DataEntityService.class);
        net.ibizsys.psrt.srv.demodel.service.QueryModelService queryModelService  = (net.ibizsys.psrt.srv.demodel.service.QueryModelService)ServiceGlobal.getService(net.ibizsys.psrt.srv.demodel.service.QueryModelService.class);


        // 安装实体 "系统"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("df93b04c07324dc3f4ae6aa109e612d1");
            dataEntity.setDEName("SYSTEM");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("系统");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "统一资源"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("88d390ffbdb76f146f608c669729d81d");
            dataEntity.setDEName("UNIRES");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("统一资源");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "实体数据变更（已处理）"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("2be4c985b8c11e06783904ce4e9d8b90");
            dataEntity.setDEName("DEDATACHG2");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("实体数据变更（已处理）");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "系统管理模块"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("089885ec20e095e248e78d49d3153815");
            dataEntity.setDEName("SYSADMIN");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("系统管理模块");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "数据对象能力明细"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("a54fc7fa42e8260cab1cb33393e222b1");
            dataEntity.setDEName("USERROLEDATADETAIL");
            dataEntity.setDEType(3);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("数据对象能力明细");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "实体数据变更派发引擎"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("54b64fbcfb4f415664d56327f7a2c210");
            dataEntity.setDEName("DEDATACHGDISP");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("实体数据变更派发引擎");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "任务调度任务类型"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("43332c6488824ab95b327d64b4f23a1b");
            dataEntity.setDEName("TSSDTASKTYPE");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("任务调度任务类型");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "门户视图部件"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("d1ce1f760d77192f620b4f6b9d7769f8");
            dataEntity.setDEName("PVPART");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("门户视图部件");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "数据审计"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("326125ce130f4bec558c9778daef045c");
            dataEntity.setDEName("DATAAUDIT");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("数据审计");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "用户角色资源能力"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("ee84bfb6e336a62bdcd671895549aebe");
            dataEntity.setDEName("USERROLERES");
            dataEntity.setDEType(3);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("用户角色资源能力");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "注册表"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("6f29424570cf5cb552950326c000e031");
            dataEntity.setDEName("REGISTRY");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("注册表");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "用户角色"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("1e40618663977c439800bf56d8ac4390");
            dataEntity.setDEName("USERROLE");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("用户角色");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "调度任务项策略"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("7fbddaf527849efd537411955e65800d");
            dataEntity.setDEName("TSSDTASKPOLICY");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("调度任务项策略");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "任务时刻策略所有者"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("f19ecba385e1fe480789956e5f638b78");
            dataEntity.setDEName("TSSDPOLICYOWNER");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("任务时刻策略所有者");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "用户角色实体属性访问"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("10d6c2ea8dda8754dcde1bceab9704c5");
            dataEntity.setDEName("USERROLEDEFIELD");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("用户角色实体属性访问");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "任务时刻策略组"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("f37da71b9c7217fb86634c135e6fb7e0");
            dataEntity.setDEName("TSSDGROUP");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("任务时刻策略组");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "用户词条类别"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("c41d9a5508a558b5ccc8a091c5e249b1");
            dataEntity.setDEName("USERDICTCAT");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("用户词条类别");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "任务时刻策略项"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("7923f282cb5da8b2419d53cb6fc6e9a7");
            dataEntity.setDEName("TSSDITEM");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("任务时刻策略项");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "帐户使用记录"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("7628b30c66aaeab68c9aec1aed3f7e21");
            dataEntity.setDEName("LOGINLOG");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("帐户使用记录");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "系统管理功能"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("2e71859d8147cd788d815a3371f9ebd6");
            dataEntity.setDEName("SYSADMINFUNC");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("系统管理功能");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "任务调度任务项"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("f8d12641ce30b874fa6c58f749b0bb73");
            dataEntity.setDEName("TSSDTASK");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("任务调度任务项");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "用户角色数据操作"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("0cc63f54de2a15b9a7db47ff805af49a");
            dataEntity.setDEName("USERROLEDATAACTION");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("用户角色数据操作");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "组织类型"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("3bb1f0b62e66ff93dc5929eb8794751a");
            dataEntity.setDEName("ORGTYPE");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("组织类型");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "DA日志"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("4f42003f518ff9e8ba0c1d582a3b70d5");
            dataEntity.setDEName("DALOG");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("DA日志");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "用户表格自定义"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("dfe988181f007801f103fd18e8a5661b");
            dataEntity.setDEName("USERDGTHEME");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("用户表格自定义");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "用户角色数据能力"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("b2af03b3659b89cfbfc6f8932ff1b61f");
            dataEntity.setDEName("USERROLEDATAS");
            dataEntity.setDEType(3);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("用户角色数据能力");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "组织部门"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("63061bfdafbbd213fc0ce66d3f26419e");
            dataEntity.setDEName("ORGSECTOR");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("组织部门");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "消息发送队列"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("323db6416464fc80757753d4f3666854");
            dataEntity.setDEName("MSGSENDQUEUE");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("消息发送队列");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "用户角色成员"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("a6ba8b8895f3f2438f9e9ef761ccb29c");
            dataEntity.setDEName("USERROLEDETAIL");
            dataEntity.setDEType(3);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("用户角色成员");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "数据对象能力"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("c4125399a698dc5f8acca6dc8b38b353");
            dataEntity.setDEName("USERROLEDATA");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("数据对象能力");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "用户角色相关实体属性访问控制"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("c95a8972b0f72a140d65e057a002144a");
            dataEntity.setDEName("USERROLEDEFIELDS");
            dataEntity.setDEType(3);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("用户角色相关实体属性访问控制");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "消息发送队列（历史）"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("6f417c7c7a003110acbb270429717f0f");
            dataEntity.setDEName("MSGSENDQUEUEHIS");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("消息发送队列（历史）");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "数据同步接收队列2"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("04c87ff6cdac6dd390613dbc44f3c51d");
            dataEntity.setDEName("DATASYNCIN2");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("数据同步接收队列2");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "数据审计明细"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("7d9fefe4909e0cfffcb467129475b02d");
            dataEntity.setDEName("DATAAUDITDETAIL");
            dataEntity.setDEType(2);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("数据审计明细");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "任务时刻策略"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("0af0cc46519139106341b4cbfe9b89e7");
            dataEntity.setDEName("TSSDPOLICY");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("任务时刻策略");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "代码表"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("85317205b415aa6af990684ca7704515");
            dataEntity.setDEName("CODELIST");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("代码表");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "消息模板"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("e2c5b96d6cb0389900da130bc4545add");
            dataEntity.setDEName("MSGTEMPLATE");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(1);
            dataEntity.setDELogicName("消息模板");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "用户角色类型"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("f5d60d6bd8ba7928bbe13fed42ae606a");
            dataEntity.setDEName("USERROLETYPE");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("用户角色类型");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "用户词条"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("4d49318ec5a12e0a9e36d79e45c641f2");
            dataEntity.setDEName("USERDICTITEM");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("用户词条");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "数据同步接收队列"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("3621f160a6392fc07fea086d691daa0d");
            dataEntity.setDEName("DATASYNCIN");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("数据同步接收队列");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "代码项"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("60a039b41c39edc7ff965f1c0958232d");
            dataEntity.setDEName("CODEITEM");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("代码项");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "任务调度引擎"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("e4da63c72c04866163e5a74ca984d13f");
            dataEntity.setDEName("TSSDENGINE");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("任务调度引擎");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "用户组成员"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("404bf990bacdba520e82d9603063c3dd");
            dataEntity.setDEName("USERGROUPDETAIL");
            dataEntity.setDEType(3);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("用户组成员");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "数据同步发送队列2"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("1cecb3d95febd748a2daf8e9c86a8ec5");
            dataEntity.setDEName("DATASYNCOUT2");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("数据同步发送队列2");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "服务"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("08903b770bfabc9dbb8e95f19a74ed65");
            dataEntity.setDEName("SERVICE");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("服务");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "组消息账户明细"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("b0a62e77dcb2ca3226353cea1c370b79");
            dataEntity.setDEName("MSGACCOUNTDETAIL");
            dataEntity.setDEType(2);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("组消息账户明细");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "用户词典"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("de0f12cf67b20fb12eb5454093998c74");
            dataEntity.setDEName("USERDICT");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("用户词典");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "实体数据变更"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("b46bdd8836d4e93bad690042e23ff374");
            dataEntity.setDEName("DEDATACHG");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("实体数据变更");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "门户页面"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("f63040021720d1401ec2014d30b02bb6");
            dataEntity.setDEName("PORTALPAGE");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("门户页面");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "登录帐户"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("5ae7d9610693e638cd1064cf7c9126f8");
            dataEntity.setDEName("LOGINACCOUNT");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("登录帐户");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "用户"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("f4552a6291c79e3934263b31b83aec33");
            dataEntity.setDEName("USER");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(1);
            dataEntity.setDELogicName("用户");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "组织单元类别"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("37c7b65732fb7013db7c970d1262e849");
            dataEntity.setDEName("ORGUNITCAT");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("组织单元类别");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "组织部门人员"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("a29184750c477cf3910fc2179179dccc");
            dataEntity.setDEName("ORGSECUSER");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("组织部门人员");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "任务时刻策略组明细"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("e8b6c72b7a73a98f68bf91b812d46c31");
            dataEntity.setDEName("TSSDGROUPDETAIL");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("任务时刻策略组明细");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "组织人员级别"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("e6c870c62a861cfd5593212fa41d6f88");
            dataEntity.setDEName("ORGUSERLEVEL");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("组织人员级别");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "文件"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("1c1b5758a629c73a4e148d5328a921fd");
            dataEntity.setDEName("FILE");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(1);
            dataEntity.setDELogicName("文件");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "门户页面模型"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("14ad5675b58882f0e61ba3caabcf6f5e");
            dataEntity.setDEName("PPMODEL");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("门户页面模型");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "任务调度日志"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("5d9604bc9220d47f935650303d154680");
            dataEntity.setDEName("TSSDTASKLOG");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("任务调度日志");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "数据同步发送队列"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("c8381accf6c7621d57757a4955ddb504");
            dataEntity.setDEName("DATASYNCOUT");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("数据同步发送队列");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "用户组"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("5eba267a2d34c0c5dc686961a48f62d1");
            dataEntity.setDEName("USERGROUP");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(1);
            dataEntity.setDELogicName("用户组");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "用户对象"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("318a3649ecafa3b934925a0231207d09");
            dataEntity.setDEName("USEROBJECT");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(1);
            dataEntity.setDELogicName("用户对象");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "消息账户"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("7ce656616f83e08ed4aeba648bb0a30b");
            dataEntity.setDEName("MSGACCOUNT");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(1);
            dataEntity.setDELogicName("消息账户");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "数据同步代理"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("eca73ee23612ec7a94bc4d8f40f3c5dc");
            dataEntity.setDEName("DATASYNCAGENT");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(1);
            dataEntity.setDELogicName("数据同步代理");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "组织人员"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("1f9576cdcc6a949230c7669182c73648");
            dataEntity.setDEName("ORGUSER");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("组织人员");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "部门人员关系类型"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("576dd33b28a3ee34ba68561c68aa93b3");
            dataEntity.setDEName("ORGSECUSERTYPE");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("部门人员关系类型");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }
        // 安装实体 "组织机构"
        if(true) {
            net.ibizsys.psrt.srv.demodel.entity.DataEntity dataEntity = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
            dataEntity.setDEId("e3e158d75b7bc6f589686b6e1beb966c");
            dataEntity.setDEName("ORG");
            dataEntity.setDEType(1);
            dataEntity.setIsLogicValid(0);
            dataEntity.setDELogicName("组织机构");
            dataEntity.setDEVersion(1);
            if(dataEntityService.checkKey(dataEntity)==IService.CHECKKEYSTATE_OK) {
                dataEntityService.create(dataEntity,false);
                ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n",this.getName(),dataEntityService.getDEModel().getLogicName(),dataEntityService.getDEModel().getDataInfo(dataEntity)));
            }
            //初始化权限查询模型
        }

    }



    @Autowired(required=false)
    @Qualifier("pSRuntimePlugins")
    private net.ibizsys.paas.core.PluginList pSRuntimePlugins;

    /***
     * 获取系统插件配置
     */
    public net.ibizsys.paas.core.PluginList getPSRuntimePlugins() {
        return this.pSRuntimePlugins;
    }

    @Autowired(required=false)
    @Qualifier("pSRuntimeServiceAPIClientId")
    private String pSRuntimeServiceAPIClientId;

    @Override
    public String getServiceAPIClientId() {
        return this.pSRuntimeServiceAPIClientId;
    }



    /**
     * 准备系统功能
     */
    protected void prepareSysUtils() {
        try {
        } catch(Exception ex) {
            log.error(StringHelper.format("初始化系统功能发生异常，%1$s",ex.getMessage()),ex);
        }
    }


}