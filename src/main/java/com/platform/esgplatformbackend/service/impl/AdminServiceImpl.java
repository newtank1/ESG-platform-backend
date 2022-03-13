package com.platform.esgplatformbackend.service.impl;

import com.platform.esgplatformbackend.dao.*;
import com.platform.esgplatformbackend.model.po.*;
import com.platform.esgplatformbackend.model.vo.*;
import com.platform.esgplatformbackend.service.AdminService;
import com.platform.esgplatformbackend.util.Constant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private CorporationBasicMapper corporationBasicMapper;
    @Resource
    private CorporationESGMapper corporationESGMapper;
    @Resource
    private CorporationOpinionMapper corporationOpinionMapper;
    @Resource
    private CorporationStockMapper corporationStockMapper;
    @Resource
    private CorporationEventMapper corporationEventMapper;
    @Resource
    private CorporationESGScoreMapper corporationESGScoreMapper;
    @Resource
    private CorporationInfoMapper corporationInfoMapper;
    @Override
    public ResultVO<CorporationBasicVo> addCorporation(CorporationBasicVo corp) {
        CorporationBasicPo po = corporationBasicMapper.getCorporationByName(corp.getName());
        if(po!=null) return new ResultVO<>(Constant.REQUEST_FAIL, "公司已创建");

        int insert = corporationBasicMapper.insert(new CorporationBasicPo(corp));
        if(insert==1) return new ResultVO<>(Constant.REQUEST_SUCCESS,"创建公司成功", corp);
        else return new ResultVO<>(Constant.REQUEST_FAIL, "创建公司失败");
    }

    @Override
    public ResultVO<CorporationBasicVo> updateCorporationBasic(CorporationBasicVo corp) {
        int corporation_id = corp.getCorporation_id();
        String name = corp.getName();
        int stoke = corp.getStoke();
        String industry = corp.getIndustry();
        String location = corp.getLocation();
        String introduction=corp.getIntroduction();
        int update = corporationBasicMapper.update(name,stoke,industry,location,corporation_id,introduction);

        if(update==1) return new ResultVO<>(Constant.REQUEST_SUCCESS, "更新公司基本信息成功", corp);
        else return new ResultVO<>(Constant.REQUEST_FAIL, "更新公司基本信息失败");
    }

    // TODO
    public ResultVO<CorporationESGVo> submitESG(CorporationESGScoreVo vo) {
        /*CorporationESGPo po = new CorporationESGPo(vo);
        int line = corporationESGMapper.insert(new CorporationESGPo(vo));
        if(line==1){
            return new ResultVO<>(Constant.REQUEST_SUCCESS, "提交ESG信息成功", vo);
        }else{
            return new ResultVO<>(Constant.REQUEST_FAIL, "提交ESG信息失败");
        }*/
        /*CorporationESGScorePo po=new CorporationESGScorePo(vo);
        int line= corporationESGScoreMapper.insert(po);
        if(line==0) return new ResultVO<>(Constant.REQUEST_FAIL, "提交ESG信息失败");
        int corporation_id=(int)vo.getCorporation_id();
        Date time=corporationInfoMapper.getCorporationById(corporation_id).getTime();
        if(time.before(vo.getTime())) {
            corporationESGMapper.update(0,0,po.getRecord_id(),corporation_id);
            String industry = corporationBasicMapper.getCorporationById(corporation_id).getIndustry();
            List<CorporationInfoPo> corporationTotalInfoPos=corporationInfoMapper.getScoreByTotal();
            List<CorporationInfoPo> corporationIndustryInfoPos=corporationInfoMapper.getScoreByIndustry(industry);
            for (CorporationInfoPo corporationTotalInfoPo : corporationTotalInfoPos) {
                int total_rank=corporationTotalInfoPos.indexOf(corporationTotalInfoPo)+1;
                int industry_rank=corporationTotalInfoPo.getESG_industry_ranking();
                if(corporationIndustryInfoPos.contains(corporationTotalInfoPo))
                    industry_rank=corporationIndustryInfoPos.indexOf(corporationTotalInfoPo)+1;
                int po_corporation_id=corporationTotalInfoPo.getCorporation_id();
                int record_id=corporationTotalInfoPo.getRecord_id();
                corporationESGMapper.update(total_rank,industry_rank,record_id,po_corporation_id);
            }
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS, "提交ESG信息成功", new CorporationESGVo(corporationESGMapper.getESGByCorporationId(corporation_id)));*/
        return null;
    }

    @Override
    public ResultVO<CorporationOpinionVo> submitOpinion(CorporationOpinionVo vo) {
        int line = corporationOpinionMapper.insert(new CorporationOpinionPo(vo));
        if(line==1){
            return new ResultVO<>(Constant.REQUEST_SUCCESS, "成功", vo);
        }else{
            return new ResultVO<>(Constant.REQUEST_FAIL, "失败");
        }
    }

    @Override
    public ResultVO<CorporationEventVo> submitEvent(CorporationEventVo vo) {
        int line = corporationEventMapper.insert(new CorporationEventPo(vo));
        if(line==1){
            return new ResultVO<>(Constant.REQUEST_SUCCESS, "成功", vo);
        }else{
            return new ResultVO<>(Constant.REQUEST_FAIL, "失败");
        }
    }

    @Override
    public ResultVO<CorporationStockVo> submitStock(CorporationStockVo vo) {
        int line = corporationStockMapper.insert(new CorporationStockPo(vo));
        if(line==1){
            return new ResultVO<>(Constant.REQUEST_SUCCESS, "成功", vo);
        }else{
            return new ResultVO<>(Constant.REQUEST_FAIL, "失败");
        }
    }

    @Override
    public List<CorporationESGScoreVo> getESGHistory(Integer corporation_id) {
        List<CorporationESGScorePo> pos = corporationESGScoreMapper.getByCorporationId(corporation_id);
        List<CorporationESGScoreVo> res=new ArrayList<>();
        for (CorporationESGScorePo po : pos) {
            res.add(new CorporationESGScoreVo(po));
        }
        return res;
    }
}
