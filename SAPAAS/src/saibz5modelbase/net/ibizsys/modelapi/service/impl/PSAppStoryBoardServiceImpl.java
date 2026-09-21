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
import net.ibizsys.modelapi.domain.PSAppSBItem;
import net.ibizsys.modelapi.domain.PSAppSBItemRS;
import net.ibizsys.modelapi.domain.PSAppStoryBoard;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppSBItemDTO;
import net.ibizsys.modelapi.dto.PSAppSBItemRSDTO;
import net.ibizsys.modelapi.dto.PSAppStoryBoardDTO;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.service.IPSAppStoryBoardService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelBase;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppStoryBoardServiceImpl
extends PSModelServiceImplBase<PSAppStoryBoard, PSAppStoryBoardDTO>
implements IPSAppStoryBoardService {
    private static final Log log = LogFactory.getLog(PSAppStoryBoardServiceImpl.class);

    @Override
    public List<PSAppStoryBoard> listByPSSysApp(PSSysApp parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppStoryBoard get(PSSysApp parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppStoryBoard> list = this.listByPSSysApp(parent);
        if (list != null) {
            for (PSAppStoryBoard item : list) {
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
    public List<PSAppStoryBoardDTO> listDTOByPSSysApp(String strParentKey) throws Exception {
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey);
        List<PSAppStoryBoard> list = this.listByPSSysApp(pssysapp);
        if (list != null) {
            ArrayList<PSAppStoryBoardDTO> dtoList = new ArrayList<PSAppStoryBoardDTO>();
            for (PSAppStoryBoard item : list) {
                PSAppStoryBoardDTO dto = (PSAppStoryBoardDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSAppStoryBoard> onListAll() throws Exception {
        ArrayList<PSAppStoryBoard> list = new ArrayList<PSAppStoryBoard>();
        List pssysapps = PSModelServiceUtil.getInstance().getPSSysAppService().listAll();
        if (pssysapps != null) {
            for (PSSysApp parent : pssysapps) {
                List<PSAppStoryBoard> items = this.listByPSSysApp(parent);
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
    protected PSAppStoryBoard onGet(String strParentKey, String strCurKey) throws Exception {
        PSAppStoryBoard item;
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey, true);
        if (pssysapp != null && (item = this.get(pssysapp, strCurKey, true)) != null) {
            return item;
        }
        return (PSAppStoryBoard)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSAppStoryBoardDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysAppId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysAppService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSAppStoryBoard et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppStoryBoardDTO dto, PSAppStoryBoard t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase dstItem;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppStoryBoardId(t.getId().replace("/", "."));
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDefaultFlag() != null || !bIgnoreNull) {
            dto.setDefaultFlag(t.getDefaultFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSAppStoryBoardName() != null || !bIgnoreNull) {
            dto.setPSAppStoryBoardName(t.getPSAppStoryBoardName());
        }
        if (t.getPSDynaInstId() != null || !bIgnoreNull) {
            dto.setPSDynaInstId(t.getPSDynaInstId());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
        }
        if (t.getSBTag() != null || !bIgnoreNull) {
            dto.setSBTag(t.getSBTag());
        }
        if (t.getSBTag2() != null || !bIgnoreNull) {
            dto.setSBTag2(t.getSBTag2());
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
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            dto.setPSSysAppId(this.getRealPSModelId(t, dto.getPSSysAppId()).replace("/", "."));
        }
        if ("PSSYSAPP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysAppId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            PSSysAppDTO linkDTO = (PSSysAppDTO)PSModelServiceUtil.getInstance().getPSSysAppService().getDTO(dto.getPSSysAppId());
            dto.setPSSysAppName(linkDTO.getPSSysAppName());
        } else {
            dto.setPSSysAppName(null);
        }
        List<PSModelBase> list = PSModelServiceUtil.getInstance().getPSAppSBItemService().listByPSAppStoryBoard(t);
        if (list != null && list.size() > 0) {
            ArrayList<PSAppSBItemDTO> psappsbitems = new ArrayList<PSAppSBItemDTO>();
            for (PSAppSBItem pSAppSBItem : list) {
                dstItem = (PSAppSBItemDTO)PSModelServiceUtil.getInstance().getPSAppSBItemService().toDTO(pSAppSBItem);
                psappsbitems.add((PSAppSBItemDTO)dstItem);
            }
            dto.setPsappsbitems(psappsbitems);
        }
        if ((list = PSModelServiceUtil.getInstance().getPSAppSBItemRSService().listByPSAppStoryBoard(t)) != null && list.size() > 0) {
            ArrayList<PSAppSBItemRSDTO> psappsbitemrs = new ArrayList<PSAppSBItemRSDTO>();
            for (PSAppSBItemRS pSAppSBItemRS : list) {
                dstItem = (PSAppSBItemRSDTO)PSModelServiceUtil.getInstance().getPSAppSBItemRSService().toDTO(pSAppSBItemRS);
                psappsbitemrs.add((PSAppSBItemRSDTO)dstItem);
            }
            dto.setPsappsbitemrs(psappsbitemrs);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSAPPSTORYBOARD";
    }

    @Override
    public PSAppStoryBoard createDomain() {
        return new PSAppStoryBoard();
    }

    @Override
    public PSAppStoryBoardDTO createDTO() {
        return new PSAppStoryBoardDTO();
    }
}

