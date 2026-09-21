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
import net.ibizsys.modelapi.domain.PSAppSBItemRS;
import net.ibizsys.modelapi.domain.PSAppStoryBoard;
import net.ibizsys.modelapi.dto.PSAppSBItemDTO;
import net.ibizsys.modelapi.dto.PSAppSBItemRSDTO;
import net.ibizsys.modelapi.dto.PSAppStoryBoardDTO;
import net.ibizsys.modelapi.dto.PSSysReqItemDTO;
import net.ibizsys.modelapi.dto.PSSysUserCaseDTO;
import net.ibizsys.modelapi.service.IPSAppSBItemRSService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppSBItemRSServiceImpl
extends PSModelServiceImplBase<PSAppSBItemRS, PSAppSBItemRSDTO>
implements IPSAppSBItemRSService {
    private static final Log log = LogFactory.getLog(PSAppSBItemRSServiceImpl.class);

    @Override
    public List<PSAppSBItemRS> listByPSAppStoryBoard(PSAppStoryBoard parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppSBItemRS get(PSAppStoryBoard parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppSBItemRS> list = this.listByPSAppStoryBoard(parent);
        if (list != null) {
            for (PSAppSBItemRS item : list) {
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
    public List<PSAppSBItemRSDTO> listDTOByPSAppStoryBoard(String strParentKey) throws Exception {
        PSAppStoryBoard psappstoryboard = (PSAppStoryBoard)PSModelServiceUtil.getInstance().getPSAppStoryBoardService().get(strParentKey);
        List<PSAppSBItemRS> list = this.listByPSAppStoryBoard(psappstoryboard);
        if (list != null) {
            ArrayList<PSAppSBItemRSDTO> dtoList = new ArrayList<PSAppSBItemRSDTO>();
            for (PSAppSBItemRS item : list) {
                PSAppSBItemRSDTO dto = (PSAppSBItemRSDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSAppSBItemRS> onListAll() throws Exception {
        ArrayList<PSAppSBItemRS> list = new ArrayList<PSAppSBItemRS>();
        List psappstoryboards = PSModelServiceUtil.getInstance().getPSAppStoryBoardService().listAll();
        if (psappstoryboards != null) {
            for (PSAppStoryBoard parent : psappstoryboards) {
                List<PSAppSBItemRS> items = this.listByPSAppStoryBoard(parent);
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
    protected PSAppSBItemRS onGet(String strParentKey, String strCurKey) throws Exception {
        PSAppSBItemRS item;
        PSAppStoryBoard psappstoryboard = (PSAppStoryBoard)PSModelServiceUtil.getInstance().getPSAppStoryBoardService().get(strParentKey, true);
        if (psappstoryboard != null && (item = this.get(psappstoryboard, strCurKey, true)) != null) {
            return item;
        }
        return (PSAppSBItemRS)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSAppSBItemRSDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSAppStoryBoardId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSAppStoryBoardService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSAppSBItemRS et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppSBItemRSDTO dto, PSAppSBItemRS t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppSBItemRSId(t.getId().replace("/", "."));
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCPSAppSBItemId() != null || !bIgnoreNull) {
            dto.setCPSAppSBItemId(t.getCPSAppSBItemId());
        }
        if (t.getCPSAppSBItemName() != null || !bIgnoreNull) {
            dto.setCPSAppSBItemName(t.getCPSAppSBItemName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDstEndPoint() != null || !bIgnoreNull) {
            dto.setDstEndPoint(t.getDstEndPoint());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPPSAppSBItemId() != null || !bIgnoreNull) {
            dto.setPPSAppSBItemId(t.getPPSAppSBItemId());
        }
        if (t.getPPSAppSBItemName() != null || !bIgnoreNull) {
            dto.setPPSAppSBItemName(t.getPPSAppSBItemName());
        }
        if (t.getPSAppSBItemRSName() != null || !bIgnoreNull) {
            dto.setPSAppSBItemRSName(t.getPSAppSBItemRSName());
        }
        if (t.getPSAppStoryBoardId() != null || !bIgnoreNull) {
            dto.setPSAppStoryBoardId(t.getPSAppStoryBoardId());
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
        if (t.getPSSysReqItemId() != null || !bIgnoreNull) {
            dto.setPSSysReqItemId(t.getPSSysReqItemId());
        }
        if (t.getPSSysReqItemName() != null || !bIgnoreNull) {
            dto.setPSSysReqItemName(t.getPSSysReqItemName());
        }
        if (t.getPSSysUserCaseId() != null || !bIgnoreNull) {
            dto.setPSSysUserCaseId(t.getPSSysUserCaseId());
        }
        if (t.getPSSysUserCaseName() != null || !bIgnoreNull) {
            dto.setPSSysUserCaseName(t.getPSSysUserCaseName());
        }
        if (t.getRSTag() != null || !bIgnoreNull) {
            dto.setRSTag(t.getRSTag());
        }
        if (t.getRSTag2() != null || !bIgnoreNull) {
            dto.setRSTag2(t.getRSTag2());
        }
        if (t.getRSTag3() != null || !bIgnoreNull) {
            dto.setRSTag3(t.getRSTag3());
        }
        if (t.getRSTag4() != null || !bIgnoreNull) {
            dto.setRSTag4(t.getRSTag4());
        }
        if (t.getRSType() != null || !bIgnoreNull) {
            dto.setRSType(t.getRSType());
        }
        if (t.getSrcEndPoint() != null || !bIgnoreNull) {
            dto.setSrcEndPoint(t.getSrcEndPoint());
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
        if (t.getUserFlag() != null || !bIgnoreNull) {
            dto.setUserFlag(t.getUserFlag());
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
        if (StringUtils.hasLength((String)dto.getCPSAppSBItemId())) {
            dto.setCPSAppSBItemId(this.getRealPSModelId(t, dto.getCPSAppSBItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPPSAppSBItemId())) {
            dto.setPPSAppSBItemId(this.getRealPSModelId(t, dto.getPPSAppSBItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSAppStoryBoardId())) {
            dto.setPSAppStoryBoardId(this.getRealPSModelId(t, dto.getPSAppStoryBoardId()).replace("/", "."));
        }
        if ("PSAPPSTORYBOARD".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSAppStoryBoardId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            dto.setPSSysReqItemId(this.getRealPSModelId(t, dto.getPSSysReqItemId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysUserCaseId())) {
            dto.setPSSysUserCaseId(this.getRealPSModelId(t, dto.getPSSysUserCaseId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getCPSAppSBItemId())) {
            linkDTO = (PSAppSBItemDTO)PSModelServiceUtil.getInstance().getPSAppSBItemService().getDTO(dto.getCPSAppSBItemId());
            dto.setCPSAppSBItemName(((PSAppSBItemDTO)linkDTO).getPSAppSBItemName());
        } else {
            dto.setCPSAppSBItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPPSAppSBItemId())) {
            linkDTO = (PSAppSBItemDTO)PSModelServiceUtil.getInstance().getPSAppSBItemService().getDTO(dto.getPPSAppSBItemId());
            dto.setPPSAppSBItemName(((PSAppSBItemDTO)linkDTO).getPSAppSBItemName());
        } else {
            dto.setPPSAppSBItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSAppStoryBoardId())) {
            linkDTO = (PSAppStoryBoardDTO)PSModelServiceUtil.getInstance().getPSAppStoryBoardService().getDTO(dto.getPSAppStoryBoardId());
            dto.setPSAppStoryBoardName(((PSAppStoryBoardDTO)linkDTO).getPSAppStoryBoardName());
            dto.setPSSysAppId(((PSAppStoryBoardDTO)linkDTO).getPSSysAppId());
        } else {
            dto.setPSAppStoryBoardName(null);
            dto.setPSSysAppId(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysReqItemId())) {
            linkDTO = (PSSysReqItemDTO)PSModelServiceUtil.getInstance().getPSSysReqItemService().getDTO(dto.getPSSysReqItemId(), true);
            if (linkDTO != null) {
                dto.setPSSysReqItemName(((PSSysReqItemDTO)linkDTO).getPSSysReqItemName());
            }
        } else {
            dto.setPSSysReqItemName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysUserCaseId())) {
            linkDTO = (PSSysUserCaseDTO)PSModelServiceUtil.getInstance().getPSSysUserCaseService().getDTO(dto.getPSSysUserCaseId(), true);
            if (linkDTO != null) {
                dto.setPSSysUserCaseName(((PSSysUserCaseDTO)linkDTO).getPSSysUserCaseName());
            }
        } else {
            dto.setPSSysUserCaseName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSAPPSBITEMRS";
    }

    @Override
    public PSAppSBItemRS createDomain() {
        return new PSAppSBItemRS();
    }

    @Override
    public PSAppSBItemRSDTO createDTO() {
        return new PSAppSBItemRSDTO();
    }
}

