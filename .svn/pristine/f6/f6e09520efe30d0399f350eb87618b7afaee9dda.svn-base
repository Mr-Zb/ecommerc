package com.fun.admin.service;

import java.math.BigDecimal;
import java.util.*;

import com.fun.client.domain.MemUserInfo;
import com.fun.client.service.MemUserInfoService;
import com.fun.client.service.UserPlaceOrderService;
import com.fun.framework.domain.AjaxReturn;
import com.fun.framework.service.BaseService;
import com.fun.le.service.SchSchemeDetailService;
import com.fun.le.service.SchSchemeInfoService;
import com.fun.le.service.SchSchemeIssueService;
import com.fun.le.service.SchSchemeOfferService;
import com.fun.utils.OrderStateEnum;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fun.admin.repository.LotMapper;
import com.fun.admin.repository.SchMapper;
import com.fun.framework.support.BusinessException;
import com.fun.framework.utils.CollectionUtils;
import com.fun.le.entities.LotLotteryIssue;
import com.fun.le.entities.LotProductInfo;
import com.fun.le.entities.SchSchemeDetail;
import com.fun.le.entities.SchSchemeInfo;
import com.fun.le.entities.SchSchemeIssue;
import com.fun.le.entities.SchSchemeOffer;

@Service
@Lazy(false)
public class SchService extends BaseService {
	@Autowired
	private SchSchemeInfoService schemeInfoService;
	@Autowired
	private SchSchemeDetailService schemeDetailService;
	@Autowired
	private SchSchemeIssueService schemeIssueService;
	@Autowired
	private SchSchemeOfferService schemeOfferService;
	@Autowired
	private MemUserInfoService memUserInfoService;
	@Autowired
	private LotMapper lotMapper;
	@Autowired
	private SequenceService sequenceService;
	@Autowired
	private UserPlaceOrderService userPlaceOrderService;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = { Exception.class })
	public void createScheme(Integer userId, SchSchemeInfo schemeInfo, SchSchemeDetail detail,
								   SchSchemeIssue issue, SchSchemeOffer offer, Integer goodsId) throws BusinessException {
		MemUserInfo userInfo = this.memUserInfoService.selectById(userId);
		schemeInfo.setTotalIssue(1);
		schemeInfo.setExpressIssue(0);
		schemeInfo.setSchemeState(0);
		if (schemeInfo.getGather() > 1) {
			schemeInfo.setScheneNo(this.sequenceService.generate("H"));
		} else {
			schemeInfo.setScheneNo(this.sequenceService.generate("Z"));
		}
		schemeInfo.setMemberId(userId);
		schemeInfo.setMemberName(userInfo.getLoginName());
		schemeInfo.setAgentId(userInfo.getAgentId().intValue());
		schemeInfo.setAgentName(userInfo.getAgentName());
		schemeInfo.setAgentFullId(userInfo.getAgentFullId());
		schemeInfo.setAgentFullName(userInfo.getAgentFullName());
		schemeInfo.setMemberScore(userInfo.getUserScore());
		schemeInfo.setAmount5(0.0);
		schemeInfo.setAmount6(0.0);
		schemeInfo.setMemberLevel(1);
		double amount1 = 0.0;
		double amount2 = 0.0;
		int multiple = 0;

		detail.setProductId(schemeInfo.getProductId());
		amount1 += detail.getAmount2();

		List<LotLotteryIssue> _issues = (List<LotLotteryIssue>) this.lotMapper.listCheckIssue(schemeInfo.getProductId(), issue, DateTime.now().toDate());

		LotLotteryIssue lotLotteryIssue = null;
		Map<String, LotLotteryIssue> issueMap = Collections.synchronizedMap(new HashMap<String, LotLotteryIssue>());
		if (CollectionUtils.isNotEmpty(_issues)) {
			_issues.parallelStream().forEach(issue1 -> issueMap.put(issue1.getLotteryIssue(), issue1));
			lotLotteryIssue = _issues.get(0);
		}
		if (!issueMap.containsKey(issue.getSchemeIssue())) {
			//截止时间到开奖时间内投注，只能投下一期
			LotLotteryIssue issue1 = lotMapper.currentEndTime(schemeInfo.getProductId(),new Date());
			lotLotteryIssue = lotMapper.getLotIssue(schemeInfo.getProductId(),issue1.getLotteryIssue());
		}

		schemeInfo.setEndIssue(lotLotteryIssue.getLotteryIssue());
		schemeInfo.setEndTime(lotLotteryIssue.getEndTime());
		schemeInfo.setNextEndIssue(lotLotteryIssue.getLotteryIssue());
		schemeInfo.setNextEndTime(lotLotteryIssue.getEndTime());
		schemeInfo.setNextOpenIssue(lotLotteryIssue.getLotteryIssue());
		schemeInfo.setNextOpenTime(lotLotteryIssue.getOpenTime());


		issue.setProductId(schemeInfo.getProductId());
		issue.setEndTime(lotLotteryIssue.getEndTime());
		issue.setOpenTime(lotLotteryIssue.getOpenTime());
		issue.setOpenState(0);
		issue.setIssueState(0);
		issue.setSchemeAmount1(amount1 * issue.getSchemeMultiple());
		issue.setSchemeAmount2(0.0);
		issue.setOpenCode("");
		multiple += issue.getSchemeMultiple();

		if (multiple <= 0) {
			throw new BusinessException(501, "倍投数不正确");
		}
		amount2 = amount1 * multiple;
		amount1 = BigDecimal.valueOf(schemeInfo.getAmount1()).setScale(2, 4).doubleValue();
		amount2 = BigDecimal.valueOf(amount2).setScale(2, 4).doubleValue();
		if (amount1 != amount2) {
			throw new BusinessException(501, "金额验证不正确");
		}
		schemeInfo.setTotalMultiple(multiple);
		schemeInfo.setAmount1(amount2);
		schemeInfo.setAmount2(amount2 / schemeInfo.getGather());
		schemeInfo.setAmount3(amount2 * schemeInfo.getGatherd() / schemeInfo.getGather());
		schemeInfo.setAmount4(amount2 * schemeInfo.getMinimum() / schemeInfo.getGather());
		schemeInfo.setSchemeSchedule(schemeInfo.getGatherd() * 100 / schemeInfo.getGather());
		schemeInfo.setMemberScore(0);
		if (detail.getGameContext().equals("1")){
			schemeInfo.setTitle("大吉");
		}else {
			schemeInfo.setTitle("大利");
		}
		schemeInfo.setSchemeLocked(0);
		if (schemeInfo.getGather() > schemeInfo.getGatherd()) {
			schemeInfo.setSchemeState(1);
		} else {
			schemeInfo.setSchemeState(2);
		}
		offer.setOfferAmount1(schemeInfo.getAmount2() * schemeInfo.getGatherd());
		offer.setOfferAmount2(0.0);
		offer.setOfferAmount3(0.0);
		offer.setOfferNum(schemeInfo.getGatherd());
		offer.setProductId(schemeInfo.getProductId());
		offer.setMemberId(userId);
		offer.setMemberName(userInfo.getLoginName());
		offer.setAgentId(userInfo.getAgentId().intValue());
		offer.setAgentName(userInfo.getAgentName());
		offer.setAgentFullId(userInfo.getAgentFullId());
		offer.setAgentFullName(userInfo.getAgentFullName());

		String orderNo = userPlaceOrderService.cqsscPlaceOrder(userId,goodsId,1,detail.getGameContext(),lotLotteryIssue);
		schemeInfo.setOrderNo(orderNo);
		this.schemeInfoService.insert(userId, schemeInfo);
		issue.setSchemeId(schemeInfo.getPkId());
		detail.setSchemeId(schemeInfo.getPkId());
		offer.setSchemeId(schemeInfo.getPkId());
		this.schemeDetailService.insert(userId, detail);
		this.schemeIssueService.insert(userId, issue);
		this.schemeOfferService.insert(userId, offer);

	}



}
