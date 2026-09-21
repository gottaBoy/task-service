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
import net.ibizsys.modelapi.domain.PSSysSFPub;
import net.ibizsys.modelapi.domain.PSSystem;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysSFPubDTO;
import net.ibizsys.modelapi.dto.PSSystemDTO;
import net.ibizsys.modelapi.service.IPSSysSFPubService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysSFPubServiceImpl
extends PSModelServiceImplBase<PSSysSFPub, PSSysSFPubDTO>
implements IPSSysSFPubService {
    private static final Log log = LogFactory.getLog(PSSysSFPubServiceImpl.class);

    @Override
    public List<PSSysSFPub> listByPSSystem(PSSystem parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysSFPub get(PSSystem parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysSFPub> list = this.listByPSSystem(parent);
        if (list != null) {
            for (PSSysSFPub item : list) {
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
    public List<PSSysSFPubDTO> listDTOByPSSystem(String strParentKey) throws Exception {
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey);
        List<PSSysSFPub> list = this.listByPSSystem(pssystem);
        if (list != null) {
            ArrayList<PSSysSFPubDTO> dtoList = new ArrayList<PSSysSFPubDTO>();
            for (PSSysSFPub item : list) {
                PSSysSFPubDTO dto = (PSSysSFPubDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysSFPub> onListAll() throws Exception {
        ArrayList<PSSysSFPub> list = new ArrayList<PSSysSFPub>();
        List pssystems = PSModelServiceUtil.getInstance().getPSSystemService().listAll();
        if (pssystems != null) {
            for (PSSystem parent : pssystems) {
                List<PSSysSFPub> items = this.listByPSSystem(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

    @Override
    protected PSSysSFPub onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysSFPub item;
        PSSystem pssystem = (PSSystem)PSModelServiceUtil.getInstance().getPSSystemService().get(strParentKey, true);
        if (pssystem != null && (item = this.get(pssystem, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysSFPub)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysSFPubDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSystemId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSystemService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysSFPub et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysSFPubDTO dto, PSSysSFPub t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysSFPubId(t.getId().replace("/", "."));
        }
        if (t.getBaseClsParams() != null || !bIgnoreNull) {
            dto.setBaseClsParams(t.getBaseClsParams());
        }
        if (t.getBaseCLSPKGCodeName() != null || !bIgnoreNull) {
            dto.setBaseCLSPKGCodeName(t.getBaseCLSPKGCodeName());
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getContentType() != null || !bIgnoreNull) {
            dto.setContentType(t.getContentType());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDefaultPub() != null || !bIgnoreNull) {
            dto.setDefaultPub(t.getDefaultPub());
        }
        if (t.getDocPSSFStyleId() != null || !bIgnoreNull) {
            dto.setDocPSSFStyleId(t.getDocPSSFStyleId());
        }
        if (t.getDocPSSFStyleName() != null || !bIgnoreNull) {
            dto.setDocPSSFStyleName(t.getDocPSSFStyleName());
        }
        if (t.getDynaModelMode() != null || !bIgnoreNull) {
            dto.setDynaModelMode(t.getDynaModelMode());
        }
        if (t.getGlobalTSFlag() != null || !bIgnoreNull) {
            dto.setGlobalTSFlag(t.getGlobalTSFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPKGCodeName() != null || !bIgnoreNull) {
            dto.setPKGCodeName(t.getPKGCodeName());
        }
        if (t.getPPSSysSFPubId() != null || !bIgnoreNull) {
            dto.setPPSSysSFPubId(t.getPPSSysSFPubId());
        }
        if (t.getPPSSysSFPubName() != null || !bIgnoreNull) {
            dto.setPPSSysSFPubName(t.getPPSSysSFPubName());
        }
        if (t.getPSSFStyleId() != null || !bIgnoreNull) {
            dto.setPSSFStyleId(t.getPSSFStyleId());
        }
        if (t.getPSSFStyleName() != null || !bIgnoreNull) {
            dto.setPSSFStyleName(t.getPSSFStyleName());
        }
        if (t.getPSSFStyleParamId() != null || !bIgnoreNull) {
            dto.setPSSFStyleParamId(t.getPSSFStyleParamId());
        }
        if (t.getPSSFStyleParamName() != null || !bIgnoreNull) {
            dto.setPSSFStyleParamName(t.getPSSFStyleParamName());
        }
        if (t.getPSSFStyleVerId() != null || !bIgnoreNull) {
            dto.setPSSFStyleVerId(t.getPSSFStyleVerId());
        }
        if (t.getPSSFStyleVerName() != null || !bIgnoreNull) {
            dto.setPSSFStyleVerName(t.getPSSFStyleVerName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysSFPubName() != null || !bIgnoreNull) {
            dto.setPSSysSFPubName(t.getPSSysSFPubName());
        }
        if (t.getPSSystemId() != null || !bIgnoreNull) {
            dto.setPSSystemId(t.getPSSystemId());
        }
        if (t.getPSSystemName() != null || !bIgnoreNull) {
            dto.setPSSystemName(t.getPSSystemName());
        }
        if (t.getPubFolder() != null || !bIgnoreNull) {
            dto.setPubFolder(t.getPubFolder());
        }
        if (t.getPubTag() != null || !bIgnoreNull) {
            dto.setPubTag(t.getPubTag());
        }
        if (t.getPubTag2() != null || !bIgnoreNull) {
            dto.setPubTag2(t.getPubTag2());
        }
        if (t.getPubTag3() != null || !bIgnoreNull) {
            dto.setPubTag3(t.getPubTag3());
        }
        if (t.getPubTag4() != null || !bIgnoreNull) {
            dto.setPubTag4(t.getPubTag4());
        }
        if (t.getRemoveFlag() != null || !bIgnoreNull) {
            dto.setRemoveFlag(t.getRemoveFlag());
        }
        if (t.getStyleParams() != null || !bIgnoreNull) {
            dto.setStyleParams(t.getStyleParams());
        }
        if (t.getSubSysPkgFlag() != null || !bIgnoreNull) {
            dto.setSubSysPkgFlag(t.getSubSysPkgFlag());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserCat() != null || !bIgnoreNull) {
            dto.setUserCat(t.getUserCat());
        }
        if (t.getUserTag() != null || !bIgnoreNull) {
            dto.setUserTag(t.getUserTag());
        }
        if (t.getUserTag2() != null || !bIgnoreNull) {
            dto.setUserTag2(t.getUserTag2());
        }
        if (t.getUserTag3() != null || !bIgnoreNull) {
            dto.setUserTag3(t.getUserTag3());
        }
        if (t.getUserTag4() != null || !bIgnoreNull) {
            dto.setUserTag4(t.getUserTag4());
        }
        if (t.getVerStr() != null || !bIgnoreNull) {
            dto.setVerStr(t.getVerStr());
        }
        if (StringUtils.hasLength((String)dto.getPPSSysSFPubId())) {
            dto.setPPSSysSFPubId(this.getRealPSModelId(t, dto.getPPSSysSFPubId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            dto.setPSSystemId(this.getRealPSModelId(t, dto.getPSSystemId()).replace("/", "."));
        }
        if ("PSSYSTEM".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSystemId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSSysSFPubId())) {
            linkDTO = (PSSysSFPubDTO)PSModelServiceUtil.getInstance().getPSSysSFPubService().getDTO(dto.getPPSSysSFPubId());
            dto.setPPSSysSFPubName(((PSSysSFPubDTO)linkDTO).getPSSysSFPubName());
        } else {
            dto.setPPSSysSFPubName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSystemId())) {
            linkDTO = (PSSystemDTO)PSModelServiceUtil.getInstance().getPSSystemService().getDTO(dto.getPSSystemId());
            dto.setPSSystemName(((PSSystemDTO)linkDTO).getPSSystemName());
        } else {
            dto.setPSSystemName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSSFPUB";
    }

    @Override
    public PSSysSFPub createDomain() {
        return new PSSysSFPub();
    }

    @Override
    public PSSysSFPubDTO createDTO() {
        return new PSSysSFPubDTO();
    }
}

