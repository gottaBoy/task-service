/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import net.ibizsys.modelapi.domain.PSWFLink;
import net.ibizsys.modelapi.domain.PSWFLinkCond;
import net.ibizsys.modelapi.domain.PSWFVersion;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSWFLinkCondDTO;
import net.ibizsys.modelapi.dto.PSWFLinkDTO;
import net.ibizsys.modelapi.dto.PSWFVersionDTO;
import net.ibizsys.modelapi.service.IPSWFLinkCondService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSWFLinkCondServiceImpl
extends PSModelServiceImplBase<PSWFLinkCond, PSWFLinkCondDTO>
implements IPSWFLinkCondService {
    private static final Log log = LogFactory.getLog(PSWFLinkCondServiceImpl.class);

    @Override
    public List<PSWFLinkCond> listByPSWFLinkCond(PSWFLinkCond parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWFLinkCond get(PSWFLinkCond parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWFLinkCond> list = this.listByPSWFLinkCond(parent);
        if (list != null) {
            for (PSWFLinkCond item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSWFLinkCondDTO> listDTOByPSWFLinkCond(String strParentKey) throws Exception {
        PSWFLinkCond pswflinkcond = (PSWFLinkCond)PSModelServiceUtil.getInstance().getPSWFLinkCondService().get(strParentKey);
        List<PSWFLinkCond> list = this.listByPSWFLinkCond(pswflinkcond);
        if (list != null) {
            ArrayList<PSWFLinkCondDTO> dtoList = new ArrayList<PSWFLinkCondDTO>();
            for (PSWFLinkCond item : list) {
                PSWFLinkCondDTO dto = (PSWFLinkCondDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSWFLinkCond> listByPSWFLink(PSWFLink parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWFLinkCond get(PSWFLink parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWFLinkCond> list = this.listByPSWFLink(parent);
        if (list != null) {
            for (PSWFLinkCond item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSWFLinkCondDTO> listDTOByPSWFLink(String strParentKey) throws Exception {
        PSWFLink pswflink = (PSWFLink)PSModelServiceUtil.getInstance().getPSWFLinkService().get(strParentKey);
        List<PSWFLinkCond> list = this.listByPSWFLink(pswflink);
        if (list != null) {
            ArrayList<PSWFLinkCondDTO> dtoList = new ArrayList<PSWFLinkCondDTO>();
            for (PSWFLinkCond item : list) {
                PSWFLinkCondDTO dto = (PSWFLinkCondDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSWFLinkCond> listByPSWFVersion(PSWFVersion parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSWFLinkCond get(PSWFVersion parent, String strKey, boolean bTryMode) throws Exception {
        List<PSWFLinkCond> list = this.listByPSWFVersion(parent);
        if (list != null) {
            for (PSWFLinkCond item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSWFLinkCondDTO> listDTOByPSWFVersion(String strParentKey) throws Exception {
        PSWFVersion pswfversion = (PSWFVersion)PSModelServiceUtil.getInstance().getPSWFVersionService().get(strParentKey);
        List<PSWFLinkCond> list = this.listByPSWFVersion(pswfversion);
        if (list != null) {
            ArrayList<PSWFLinkCondDTO> dtoList = new ArrayList<PSWFLinkCondDTO>();
            for (PSWFLinkCond item : list) {
                PSWFLinkCondDTO dto = (PSWFLinkCondDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSWFLinkCond> onListAll() throws Exception {
        List pswfversions;
        ArrayList<PSWFLinkCond> list = new ArrayList<PSWFLinkCond>();
        List pswflinks = PSModelServiceUtil.getInstance().getPSWFLinkService().listAll();
        if (pswflinks != null) {
            for (PSWFLink parent : pswflinks) {
                List<PSWFLinkCond> items = this.listByPSWFLink(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if ((pswfversions = PSModelServiceUtil.getInstance().getPSWFVersionService().listAll()) != null) {
            for (PSWFVersion parent : pswfversions) {
                List<PSWFLinkCond> items = this.listByPSWFVersion(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ArrayList<PSWFLinkCond> alllist = new ArrayList<PSWFLinkCond>();
        alllist.addAll(list);
        for (PSWFLinkCond item : list) {
            List<PSWFLinkCond> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSWFLinkCond> listAllChild(PSWFLinkCond parent) throws Exception {
        List<PSWFLinkCond> list = this.listByPSWFLinkCond(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSWFLinkCond> alllist = new ArrayList<PSWFLinkCond>();
        alllist.addAll(list);
        for (PSWFLinkCond item : list) {
            List<PSWFLinkCond> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSWFLinkCond> listAllByPSWFLink(PSWFLink parent) throws Exception {
        List<PSWFLinkCond> list = this.listByPSWFLink(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSWFLinkCond> alllist = new ArrayList<PSWFLinkCond>();
        alllist.addAll(list);
        for (PSWFLinkCond item : list) {
            List<PSWFLinkCond> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSWFLinkCondDTO> listAllDTOByPSWFLink(String strParentKey) throws Exception {
        PSWFLink pswflink = (PSWFLink)PSModelServiceUtil.getInstance().getPSWFLinkService().get(strParentKey);
        List<PSWFLinkCond> list = this.listAllByPSWFLink(pswflink);
        if (list != null) {
            ArrayList<PSWFLinkCondDTO> dtoList = new ArrayList<PSWFLinkCondDTO>();
            for (PSWFLinkCond item : list) {
                PSWFLinkCondDTO dto = (PSWFLinkCondDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    public List<PSWFLinkCond> listAllByPSWFVersion(PSWFVersion parent) throws Exception {
        List<PSWFLinkCond> list = this.listByPSWFVersion(parent);
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList<PSWFLinkCond> alllist = new ArrayList<PSWFLinkCond>();
        alllist.addAll(list);
        for (PSWFLinkCond item : list) {
            List<PSWFLinkCond> list2 = this.listAllChild(item);
            if (list2 == null || list2.size() <= 0) continue;
            alllist.addAll(list2);
        }
        return alllist;
    }

    @Override
    public List<PSWFLinkCondDTO> listAllDTOByPSWFVersion(String strParentKey) throws Exception {
        PSWFVersion pswfversion = (PSWFVersion)PSModelServiceUtil.getInstance().getPSWFVersionService().get(strParentKey);
        List<PSWFLinkCond> list = this.listAllByPSWFVersion(pswfversion);
        if (list != null) {
            ArrayList<PSWFLinkCondDTO> dtoList = new ArrayList<PSWFLinkCondDTO>();
            for (PSWFLinkCond item : list) {
                PSWFLinkCondDTO dto = (PSWFLinkCondDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected PSWFLinkCond onGet(String strParentKey, String strCurKey) throws Exception {
        PSWFLinkCond item;
        PSWFLinkCond item2;
        PSWFLinkCond item3;
        PSWFLinkCond pswflinkcond = (PSWFLinkCond)PSModelServiceUtil.getInstance().getPSWFLinkCondService().get(strParentKey, true);
        if (pswflinkcond != null && (item3 = this.get(pswflinkcond, strCurKey, true)) != null) {
            return item3;
        }
        PSWFLink pswflink = (PSWFLink)PSModelServiceUtil.getInstance().getPSWFLinkService().get(strParentKey, true);
        if (pswflink != null && (item2 = this.get(pswflink, strCurKey, true)) != null) {
            return item2;
        }
        PSWFVersion pswfversion = (PSWFVersion)PSModelServiceUtil.getInstance().getPSWFVersionService().get(strParentKey, true);
        if (pswfversion != null && (item = this.get(pswfversion, strCurKey, true)) != null) {
            return item;
        }
        return (PSWFLinkCond)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSWFLinkCondDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPPSWFLinkCondId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWFLinkCondService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSWFLinkId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWFLinkService().get(strPickupValue, false);
        }
        strPickupValue = dto.getPSWFVersionId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSWFVersionService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSWFLinkCond et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSWFLinkCondDTO dto, PSWFLinkCond t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSWFLinkCondId(t.getId().replace("/", "."));
        }
        if (t.getCondValue() != null || !bIgnoreNull) {
            dto.setCondValue(t.getCondValue());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getCustomDSTParam() != null || !bIgnoreNull) {
            dto.setCustomDSTParam(t.getCustomDSTParam());
        }
        if (t.getDstPSDEFId() != null || !bIgnoreNull) {
            dto.setDstPSDEFId(t.getDstPSDEFId());
        }
        if (t.getDstPSDEFName() != null || !bIgnoreNull) {
            dto.setDstPSDEFName(t.getDstPSDEFName());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getGroupNotFlag() != null || !bIgnoreNull) {
            dto.setGroupNotFlag(t.getGroupNotFlag());
        }
        if (t.getGroupOP() != null || !bIgnoreNull) {
            dto.setGroupOP(t.getGroupOP());
        }
        if (t.getLogicType() != null || !bIgnoreNull) {
            dto.setLogicType(t.getLogicType());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getParamType() != null || !bIgnoreNull) {
            dto.setParamType(t.getParamType());
        }
        if (t.getPPSWFLinkCondId() != null || !bIgnoreNull) {
            dto.setPPSWFLinkCondId(t.getPPSWFLinkCondId());
        }
        if (t.getPPSWFLinkCondName() != null || !bIgnoreNull) {
            dto.setPPSWFLinkCondName(t.getPPSWFLinkCondName());
        }
        if (t.getPSDBValueOPId() != null || !bIgnoreNull) {
            dto.setPSDBValueOPId(t.getPSDBValueOPId());
        }
        if (t.getPSDBValueOPName() != null || !bIgnoreNull) {
            dto.setPSDBValueOPName(t.getPSDBValueOPName());
        }
        if (t.getPSWFLinkCondName() != null || !bIgnoreNull) {
            dto.setPSWFLinkCondName(t.getPSWFLinkCondName());
        }
        if (t.getPSWFLinkId() != null || !bIgnoreNull) {
            dto.setPSWFLinkId(t.getPSWFLinkId());
        }
        if (t.getPSWFLinkName() != null || !bIgnoreNull) {
            dto.setPSWFLinkName(t.getPSWFLinkName());
        }
        if (t.getPSWFVersionId() != null || !bIgnoreNull) {
            dto.setPSWFVersionId(t.getPSWFVersionId());
        }
        if (t.getPSWFVersionName() != null || !bIgnoreNull) {
            dto.setPSWFVersionName(t.getPSWFVersionName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEFId())) {
            dto.setDstPSDEFId(this.getRealPSModelId(t, dto.getDstPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSWFLinkCondId())) {
            dto.setPPSWFLinkCondId(this.getRealPSModelId(t, dto.getPPSWFLinkCondId()).replace("/", "."));
        }
        if ("PSWFLINKCOND".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPPSWFLinkCondId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFLinkId())) {
            dto.setPSWFLinkId(this.getRealPSModelId(t, dto.getPSWFLinkId()).replace("/", "."));
        }
        if ("PSWFLINK".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWFLinkId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSWFVersionId())) {
            dto.setPSWFVersionId(this.getRealPSModelId(t, dto.getPSWFVersionId()).replace("/", "."));
        }
        if ("PSWFVERSION".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSWFVersionId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getDstPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getDstPSDEFId());
            dto.setDstPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setDstPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getPPSWFLinkCondId())) {
            linkDTO = (PSWFLinkCondDTO)PSModelServiceUtil.getInstance().getPSWFLinkCondService().getDTO(dto.getPPSWFLinkCondId());
            dto.setPPSWFLinkCondName(((PSWFLinkCondDTO)linkDTO).getPSWFLinkCondName());
        } else {
            dto.setPPSWFLinkCondName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFLinkId())) {
            linkDTO = (PSWFLinkDTO)PSModelServiceUtil.getInstance().getPSWFLinkService().getDTO(dto.getPSWFLinkId());
            dto.setPSWFLinkName(((PSWFLinkDTO)linkDTO).getPSWFLinkName());
        } else {
            dto.setPSWFLinkName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSWFVersionId())) {
            linkDTO = (PSWFVersionDTO)PSModelServiceUtil.getInstance().getPSWFVersionService().getDTO(dto.getPSWFVersionId());
            dto.setPSWFVersionName(((PSWFVersionDTO)linkDTO).getPSWFVersionName());
        } else {
            dto.setPSWFVersionName(null);
        }
        List<PSWFLinkCond> list = PSModelServiceUtil.getInstance().getPSWFLinkCondService().listByPSWFLinkCond(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSWFLinkCondDTO> pswflinkconds = new ArrayList<PSWFLinkCondDTO>();
            for (PSWFLinkCond item : list) {
                PSWFLinkCondDTO dstItem = (PSWFLinkCondDTO)PSModelServiceUtil.getInstance().getPSWFLinkCondService().toDTO(item);
                pswflinkconds.add(dstItem);
            }
            dto.setPswflinkconds(pswflinkconds);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSWFLINKCOND";
    }

    @Override
    public PSWFLinkCond createDomain() {
        return new PSWFLinkCond();
    }

    @Override
    public PSWFLinkCondDTO createDTO() {
        return new PSWFLinkCondDTO();
    }
}

