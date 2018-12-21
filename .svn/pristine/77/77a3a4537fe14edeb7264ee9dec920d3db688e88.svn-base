package com.fun.api.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fun.framework.web.controller.BaseController;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
@Api(value = "mer-payinfo", consumes = "application/json", produces = "application/json", protocols = "http")
public class MerPayInfoController extends BaseController {
//	private @Autowired MerPayInfoService merPayInfoService;
//
//	@Secure()
//	@RequestMapping(path = { "/mer-pay-download" }, method = { RequestMethod.GET, RequestMethod.POST })
//	@ApiOperation(value = "下载支付信息", notes = "下载支付信息", response = AdminPayInfo.class, httpMethod = "POST")
//	public ResponseEntity<byte[]> downPayInfos(@ModelAttribute MerPayInfoQueryDto queryDto) throws Exception {
//		log.debug(">>listPayInfos");
//		long userId = getAuthentication();
//		queryDto.setPage(1);
//		queryDto.setRows(Integer.MAX_VALUE);
//		Pagination<MerPayInfo> pagination = merPayInfoService.listPayInfos(userId, queryDto);
//		HttpHeaders headers = new HttpHeaders();
//		String[] payTypes = new String[] { "微信", "支付宝", "快捷支付", "网银支付", "QQ钱包", "银联", "京东钱包", "银联一码付", "银联扫码", "微信h5", "支付宝h5" };
//		String[] payStatus = new String[] { "未支付", "已支付", "已取消" };
//		List<DataRow> list = pagination.getRows().stream().map(a -> {
//			DataRow dataRow = new DataRow();
//			// 交易时间 平台订单号 商户订单号 充值方式 订单状态 订单金额 手续费 到帐金额
//			dataRow.setCell01(DateFormatUtils.format(a.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
//			dataRow.setCell02(a.getOrderNo2());
//			dataRow.setCell03(a.getOrderNo1());
//			dataRow.setCell04(payTypes[a.getPayType() - 1]);
//			dataRow.setCell05(payStatus[a.getPayStatus() - 1]);
//			dataRow.setCell06(String.format("%.2f", a.getOrderAmt()));
//			dataRow.setCell07(String.format("%.2f", a.getFee1()));
//			dataRow.setCell08(String.format("%.2f", a.getOrderAmt() - a.getFee1()));
//			return dataRow;
//		}).collect(Collectors.toList());
//		byte[] b = ExcelUtils.toExcel("data/template-11.xlsx", "支付信息", list);
//		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//		headers.setContentDispositionFormData("payinfo", "支付信息.xlsx", Charset.defaultCharset());
//		return new ResponseEntity<byte[]>(b, headers, HttpStatus.OK);
//	}



}
