/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.codelist.AggModeCodeListModel;
import net.ibizsys.pscore.srv.codelist.DELogicParamAllValueTypeCodeListModel;
import net.ibizsys.pscore.srv.codelist.DELogicParamTypeCodeListModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELNParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParam;
import net.ibizsys.pscore.srv.dedesign.service.PSDELNParamServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDELNParamService
extends PSDELNParamServiceBase {
    private static final Log log = LogFactory.getLog(PSDELNParamService.class);

    @Override
    protected void onBeforeCreateTemp(PSDELNParam pSDELNParam) throws Exception {
        super.onBeforeCreateTemp(pSDELNParam);
        if (StringHelper.compare((String)pSDELNParam.getParamType(), (String)"COPYPARAM", (boolean)true) == 0 || StringHelper.compare((String)pSDELNParam.getParamType(), (String)"BINDPARAM", (boolean)true) == 0 || StringHelper.compare((String)pSDELNParam.getParamType(), (String)"APPENDPARAM", (boolean)true) == 0) {
            String string;
            if (pSDELNParam.contains("SRCPSDLPARAMID2")) {
                string = DataObject.getStringValue((Object)pSDELNParam.get("SRCPSDLPARAMID2"));
                String string2 = DataObject.getStringValue((Object)pSDELNParam.get("SRCPSDLPARAMNAME2"));
                pSDELNParam.setSrcPSDLParamId(string);
                pSDELNParam.setSrcPSDLParamName(string2);
            }
            if (pSDELNParam.contains("CUSTOMSRCPARAM2")) {
                string = DataObject.getStringValue((Object)pSDELNParam.get("CUSTOMSRCPARAM2"));
                pSDELNParam.setCustomSrcParam(string);
            }
            if (StringHelper.compare((String)pSDELNParam.getDstPSDLParamId(), (String)pSDELNParam.getSrcPSDLParamId(), (boolean)false) == 0) {
                throw new Exception("\u3010\u62f7\u8d1d\u53d8\u91cf\u3011\u6e90\u53c2\u6570\u4e0e\u76ee\u6807\u53c2\u6570\u4e0d\u80fd\u76f8\u540c");
            }
        }
        pSDELNParam.setPSDELNParamName(this.calcPSDELNParamName(pSDELNParam));
    }

    @Override
    protected void onBeforeUpdateTemp(PSDELNParam pSDELNParam) throws Exception {
        super.onBeforeUpdateTemp(pSDELNParam);
        if (StringHelper.compare((String)pSDELNParam.getParamType(), (String)"COPYPARAM", (boolean)true) == 0 || StringHelper.compare((String)pSDELNParam.getParamType(), (String)"BINDPARAM", (boolean)true) == 0 || StringHelper.compare((String)pSDELNParam.getParamType(), (String)"APPENDPARAM", (boolean)true) == 0) {
            String string;
            if (pSDELNParam.contains("SRCPSDLPARAMID2")) {
                string = DataObject.getStringValue((Object)pSDELNParam.get("SRCPSDLPARAMID2"));
                String string2 = DataObject.getStringValue((Object)pSDELNParam.get("SRCPSDLPARAMNAME2"));
                pSDELNParam.setSrcPSDLParamId(string);
                pSDELNParam.setSrcPSDLParamName(string2);
            }
            if (pSDELNParam.contains("CUSTOMSRCPARAM2")) {
                string = DataObject.getStringValue((Object)pSDELNParam.get("CUSTOMSRCPARAM2"));
                pSDELNParam.setCustomSrcParam(string);
            }
            if (StringHelper.compare((String)pSDELNParam.getDstPSDLParamId(), (String)pSDELNParam.getSrcPSDLParamId(), (boolean)false) == 0) {
                throw new Exception("\u3010\u62f7\u8d1d\u53d8\u91cf\u3011\u6e90\u53c2\u6570\u4e0e\u76ee\u6807\u53c2\u6570\u4e0d\u80fd\u76f8\u540c");
            }
        }
        pSDELNParam.setPSDELNParamName(this.calcPSDELNParamName(pSDELNParam));
    }

    protected String calcPSDELNParamName(PSDELNParam pSDELNParam) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        String string = pSDELNParam.getParamType();
        DELogicParamTypeCodeListModel dELogicParamTypeCodeListModel = (DELogicParamTypeCodeListModel)CodeListGlobal.getCodeList((String)DELogicParamTypeCodeListModel.class.getCanonicalName());
        if (StringHelper.compare((String)string, (String)"RESETPARAM", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"RENEWPARAM", (boolean)true) == 0) {
            stringBuilderEx.append("%1$s", (Object)pSDELNParam.getDstPSDLParamName());
        } else if (StringHelper.compare((String)string, (String)"COPYPARAM", (boolean)true) == 0) {
            stringBuilderEx.append("%1$s ==> %2$s", (Object)pSDELNParam.getSrcPSDLParamName(), (Object)pSDELNParam.getDstPSDLParamName());
        } else if (StringHelper.compare((String)string, (String)"SORTPARAM", (boolean)true) == 0) {
            if (StringHelper.isNullOrEmpty((String)pSDELNParam.getCustomDstParam())) {
                stringBuilderEx.append("%1$s[%2$s]", (Object)pSDELNParam.getDstPSDLParamName(), (Object)pSDELNParam.getDstPSDEFName());
            } else {
                stringBuilderEx.append("%1$s[%2$s]", (Object)pSDELNParam.getDstPSDLParamName(), (Object)pSDELNParam.getCustomDstParam());
            }
        } else if (StringHelper.compare((String)string, (String)"BINDPARAM", (boolean)true) == 0) {
            stringBuilderEx.append("%1$s ==> %2$s", (Object)pSDELNParam.getSrcPSDLParamName(), (Object)pSDELNParam.getDstPSDLParamName());
        } else if (StringHelper.compare((String)string, (String)"APPENDPARAM", (boolean)true) == 0) {
            stringBuilderEx.append("%1$s ==> %2$s", (Object)pSDELNParam.getSrcPSDLParamName(), (Object)pSDELNParam.getDstPSDLParamName());
        } else if (StringHelper.compare((String)string, (String)"AGGREGATEMAPPARAM", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"MERGEMAPPARAM", (boolean)true) == 0) {
            String string2 = pSDELNParam.getCustomSrcParam();
            String string3 = pSDELNParam.getCustomDstParam();
            if (StringHelper.isNullOrEmpty((String)string3)) {
                string3 = string2;
            }
            stringBuilderEx.append("%1$s ==> %2$s", (Object)string2, (Object)string3);
            String string4 = pSDELNParam.getAggMode();
            if (!StringHelper.isNullOrEmpty((String)string4)) {
                AggModeCodeListModel aggModeCodeListModel = (AggModeCodeListModel)CodeListGlobal.getCodeList((String)AggModeCodeListModel.class.getCanonicalName());
                stringBuilderEx.append(" [%1$s]", (Object)aggModeCodeListModel.getCodeListText(string4, false));
            }
        } else {
            DELogicParamAllValueTypeCodeListModel dELogicParamAllValueTypeCodeListModel = (DELogicParamAllValueTypeCodeListModel)CodeListGlobal.getCodeList((String)DELogicParamAllValueTypeCodeListModel.class.getCanonicalName());
            String string5 = dELogicParamAllValueTypeCodeListModel.getCodeListText(pSDELNParam.getSrcValueType(), true);
            if (StringHelper.compare((String)pSDELNParam.getSrcValueType(), (String)"SRCDLPARAM", (boolean)true) == 0 || StringHelper.compare((String)pSDELNParam.getSrcValueType(), (String)"LOGICPARAMFIELD", (boolean)true) == 0) {
                if (StringHelper.isNullOrEmpty((String)pSDELNParam.getCustomSrcParam())) {
                    if (StringHelper.isNullOrEmpty((String)pSDELNParam.getSrcPSDEFName())) {
                        if (StringHelper.compare((String)pSDELNParam.getSrcValueType(), (String)"LOGICPARAMFIELD", (boolean)true) == 0) {
                            return "?";
                        }
                        stringBuilderEx.append("%1$s", (Object)pSDELNParam.getSrcPSDLParamName());
                    } else {
                        stringBuilderEx.append("%1$s[%2$s]", (Object)pSDELNParam.getSrcPSDLParamName(), (Object)pSDELNParam.getSrcPSDEFName());
                    }
                } else {
                    stringBuilderEx.append("%1$s[%2$s]", (Object)pSDELNParam.getSrcPSDLParamName(), (Object)pSDELNParam.getCustomSrcParam());
                }
            } else if (StringHelper.compare((String)pSDELNParam.getSrcValueType(), (String)"LOGICPARAM", (boolean)true) == 0) {
                stringBuilderEx.append("%1$s", (Object)pSDELNParam.getSrcPSDLParamName());
            } else if (StringHelper.compare((String)pSDELNParam.getSrcValueType(), (String)"SEQUENCE", (boolean)true) == 0) {
                stringBuilderEx.append("%1$s[%2$s]", (Object)string5, (Object)pSDELNParam.getPSSysSequenceName());
            } else if (StringHelper.compare((String)pSDELNParam.getSrcValueType(), (String)"TRANSLATOR", (boolean)true) == 0) {
                stringBuilderEx.append("%1$s[%2$s]", (Object)string5, (Object)pSDELNParam.getPSSysTranslatorName());
            } else if (StringHelper.compare((String)pSDELNParam.getSrcValueType(), (String)"COUNT", (boolean)true) == 0) {
                stringBuilderEx.append("%1$s", (Object)pSDELNParam.getSrcPSDLParamName());
            } else if (StringHelper.compare((String)pSDELNParam.getSrcValueType(), (String)"NONEVALUE", (boolean)true) == 0 || StringHelper.compare((String)pSDELNParam.getSrcValueType(), (String)"NULLVALUE", (boolean)true) == 0) {
                stringBuilderEx.append("%1$s", (Object)string5);
            } else if (StringHelper.compare((String)pSDELNParam.getSrcValueType(), (String)"SRCVALUE", (boolean)true) == 0) {
                if (StringHelper.length((String)pSDELNParam.getSrcValue()) > 20) {
                    stringBuilderEx.append("%1$s[%2$s...]", (Object)string5, (Object)pSDELNParam.getSrcValue().substring(0, 20));
                } else {
                    stringBuilderEx.append("%1$s[%2$s]", (Object)string5, (Object)pSDELNParam.getSrcValue());
                }
            } else if (StringHelper.compare((String)pSDELNParam.getSrcValueType(), (String)"EXPRESSION", (boolean)true) == 0) {
                if (StringHelper.length((String)pSDELNParam.getDirectCode()) > 20) {
                    stringBuilderEx.append("%1$s[%2$s...]", (Object)string5, (Object)pSDELNParam.getDirectCode().substring(0, 20));
                } else {
                    stringBuilderEx.append("%1$s[%2$s]", (Object)string5, (Object)pSDELNParam.getDirectCode());
                }
            } else if (StringHelper.isNullOrEmpty((String)pSDELNParam.getCustomSrcParam())) {
                stringBuilderEx.append("%1$s[%2$s]", (Object)string5, (Object)pSDELNParam.getSrcPSDEFName());
            } else {
                stringBuilderEx.append("%1$s[%2$s]", (Object)string5, (Object)pSDELNParam.getCustomSrcParam());
            }
            if (StringHelper.compare((String)pSDELNParam.getParamType(), (String)"SQLPARAM", (boolean)true) == 0 || StringHelper.compare((String)pSDELNParam.getParamType(), (String)"SFPLUGINPARAM", (boolean)true) == 0) {
                return stringBuilderEx.toString();
            }
            stringBuilderEx.append(" ==> ");
            if (StringHelper.compare((String)string, (String)"WEBHEADERPARAM", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"WEBURIPARAM", (boolean)true) == 0) {
                stringBuilderEx.append("%1$s[%2$s]", (Object)dELogicParamTypeCodeListModel.getCodeListText(string, true), (Object)pSDELNParam.getCustomDstParam());
            } else if (StringHelper.isNullOrEmpty((String)pSDELNParam.getCustomDstParam())) {
                stringBuilderEx.append("%1$s[%2$s]", (Object)pSDELNParam.getDstPSDLParamName(), (Object)pSDELNParam.getDstPSDEFName());
            } else {
                stringBuilderEx.append("%1$s[%2$s]", (Object)pSDELNParam.getDstPSDLParamName(), (Object)pSDELNParam.getCustomDstParam());
            }
        }
        return stringBuilderEx.toString();
    }

    @Override
    protected void importCurXmlModel(PSDELNParam pSDELNParam, XmlNode xmlNode) throws Exception {
        PSDELogicParamService pSDELogicParamService = (PSDELogicParamService)ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)this.getSessionFactory());
        String string = xmlNode.getAttribute("SRCPSDLPARAMNAME", "");
        if (!StringHelper.isNullOrEmpty((String)string)) {
            PSDELogicParam srcParam = new PSDELogicParam();
            srcParam.setPSDELogicParamName(string);
            srcParam.setPSDELogicId(pSDELNParam.getPSDELogicId());
            pSDELogicParamService.selectTemp(srcParam, false);
            pSDELNParam.setSrcPSDLParamId(srcParam.getPSDELogicParamId());
            xmlNode.setAttribute("SRCPSDLPARAMID", srcParam.getPSDELogicParamId());
        }
        String dstParamName = xmlNode.getAttribute("DSTPSDLPARAMNAME", "");
        if (!StringHelper.isNullOrEmpty(dstParamName)) {
            PSDELogicParam pSDELogicParam = new PSDELogicParam();
            pSDELogicParam.setPSDELogicParamName(dstParamName);
            pSDELogicParam.setPSDELogicId(pSDELNParam.getPSDELogicId());
            pSDELogicParamService.selectTemp(pSDELogicParam, false);
            pSDELNParam.setDstPSDLParamId(pSDELogicParam.getPSDELogicParamId());
            xmlNode.setAttribute("DSTPSDLPARAMID", pSDELogicParam.getPSDELogicParamId());
        }
        super.importCurXmlModel(pSDELNParam, xmlNode);
    }

    protected CallResult internalGet(PSDELNParam pSDELNParam, boolean bl) throws Exception {
        CallResult callResult = super.internalGet(pSDELNParam, bl);
        if (callResult.isOk()) {
            if (StringHelper.isNullOrEmpty((String)pSDELNParam.getCustomDstParam()) && !StringHelper.isNullOrEmpty((String)pSDELNParam.getDstPSDEFName())) {
                pSDELNParam.setCustomDstParam(pSDELNParam.getDstPSDEFName());
                pSDELNParam.setDstPSDEFId("");
                pSDELNParam.setDstPSDEFName("");
            }
            if (StringHelper.compare((String)pSDELNParam.getSrcValueType(), (String)"SRCDLPARAM", (boolean)true) == 0 && StringHelper.isNullOrEmpty((String)pSDELNParam.getCustomSrcParam()) && !StringHelper.isNullOrEmpty((String)pSDELNParam.getSrcPSDEFName())) {
                pSDELNParam.setCustomSrcParam(pSDELNParam.getSrcPSDEFName());
                pSDELNParam.setSrcPSDEFId("");
                pSDELNParam.setSrcPSDEFName("");
            }
        }
        return callResult;
    }

    @Override
    protected CallResult internalGetTemp(PSDELNParam pSDELNParam, boolean bl) throws Exception {
        CallResult callResult = super.internalGetTemp(pSDELNParam, bl);
        if (callResult.isOk()) {
            if (StringHelper.isNullOrEmpty((String)pSDELNParam.getCustomDstParam()) && !StringHelper.isNullOrEmpty((String)pSDELNParam.getDstPSDEFName())) {
                pSDELNParam.setCustomDstParam(pSDELNParam.getDstPSDEFName());
                pSDELNParam.setDstPSDEFId("");
                pSDELNParam.setDstPSDEFName("");
            }
            if (StringHelper.compare((String)pSDELNParam.getSrcValueType(), (String)"SRCDLPARAM", (boolean)true) == 0 && StringHelper.isNullOrEmpty((String)pSDELNParam.getCustomSrcParam()) && !StringHelper.isNullOrEmpty((String)pSDELNParam.getSrcPSDEFName())) {
                pSDELNParam.setCustomSrcParam(pSDELNParam.getSrcPSDEFName());
                pSDELNParam.setSrcPSDEFId("");
                pSDELNParam.setSrcPSDEFName("");
            }
        }
        return callResult;
    }
}
