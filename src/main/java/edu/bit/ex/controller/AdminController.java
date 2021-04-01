package edu.bit.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.bit.ex.page.MemberCriteria;
import edu.bit.ex.page.MemberPageVO;
import edu.bit.ex.page.PrdctListCriteria;
import edu.bit.ex.service.AdminService;
import edu.bit.ex.vo.MbrAddressVO;
import edu.bit.ex.vo.MbrVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/admin/*")
public class AdminController {
	@Autowired
	private AdminService adminService;

	// 관리자 마이페이지...(admin)
	@GetMapping("/mypage")
	public ModelAndView adminpage(ModelAndView mav) throws Exception {
		log.debug("adminpage");
		log.info("adminpage");
		mav.setViewName("admin/adminpage");
		return mav;
	}

	// 관리자 유저 Q&A 페이징리스트

	/*
	 * @GetMapping("/mypage/userqna") public ModelAndView adminQnA(UserQnACriteria cri, ModelAndView mav) throws Exception { log.debug("adminQnA");
	 * log.info("adminQnA"); mav.setViewName("admin/adminQnA");
	 * 
	 * mav.addObject("board", adminService.getUserQnAListWithCri(cri)); int total = adminService.getUserQnATotalCount(cri); mav.addObject("pageMaker",
	 * new UserQnAPageVO(cri, total));
	 * 
	 * return mav; }
	 */

	// 관리자 매출조회 페이지 (보류)
	@GetMapping("/mypage/sales")
	public ModelAndView admintotal(ModelAndView mav) throws Exception {
		log.debug("admintotal");
		log.info("admintotal");

		mav.setViewName("admin/admintotal");

		return mav;
	}

	// 관리자 회원정보 조회 페이지...(admin)
	/*
	 * @GetMapping("/adminSearchMember") public String adminSearchMember(Model model, SearchCriteria cri) throws Exception {
	 * log.info("adminSearchMember........."); model.addAttribute("mem", adminService.getMemberList(cri));
	 * 
	 * int total = adminService.getTotal(cri); log.info("total.........."); model.addAttribute("pageMaker", new SearchPageVO(cri, total));
	 * 
	 * return "/adminSearchMember"; }
	 */

	// 관리자 매출 조회 검색페이지 (보류)
	@GetMapping("/mypage/search")
	public ModelAndView adminSearchtotal(ModelAndView mav) throws Exception {
		log.debug("adminSearchtotal");
		log.info("adminSearchtotal");
		mav.setViewName("admin/adminSearchtotal");

		return mav;
	}

	// 관리자 판매자 리스트 admin
	@RequestMapping(value = "/mypage/seller", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView admin_seller_list(ModelAndView mav, MemberCriteria cri) {
		mav.setViewName("admin/admin_seller_list");
		mav.addObject("mbr", adminService.getSellerListWithCri(cri));
		int total = adminService.getSellerTotalCount(cri);
		mav.addObject("pageMaker", new MemberPageVO(cri, total));

		return mav;
	}

	// 관리자 판매자 상세정보 admin
	@RequestMapping(value = "/mypage/seller/{seller_id}", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView admin_seller_detail(@PathVariable("seller_id") String m_id, ModelAndView mav) {
		mav.setViewName("admin/admin_seller");
		mav.addObject("mbr", adminService.getMemberInfo(m_id));
		mav.addObject("adr", adminService.getSellerAddress(m_id));
		return mav;
	}

	// 관리자 판매자 상품리스트 admin
	@RequestMapping(value = "/mypage/seller/{seller_id}/prdct", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView admin_seller_prdctlist(@PathVariable("seller_id") String m_id, PrdctListCriteria cri, ModelAndView mav) {
		mav.setViewName("admin/brand_prdct_list");
		// mav.addObject("mbr", adminService.getMemberInfo(m_id));
		// mav.addObject("prdct", adminService.getSellerPrdctListWithCri(cri, m_id));
		// int total = adminService.getSellerPrdctTotalCount(cri, m_id);
		// mav.addObject("pageMaker", new PrdctListPageVO(cri, total));
		// log.info("total : " + total);
		return mav;
	}

	// 관리자 판매자 정보수정 admin
	@PutMapping(value = "/mypage/seller/{seller_id}")
	public ResponseEntity<String> admin_seller_update(@RequestBody MbrAddressVO mavo) {
		ResponseEntity<String> entity = null;

		log.info("rest_update..");
		try {

			// adminService.sellerInfoUpdate(mavo);
			log.info("update seller info");
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	// 관리자 판매자 삭제 admin

	// 관리자 회원 리스트 admin
	@RequestMapping(value = "/mypage/member", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView admin_member_list(MemberCriteria cri, ModelAndView mav) {
		mav.setViewName("admin/admin_member_list");

		mav.addObject("mbr", adminService.getMemberListWithCri(cri));
		int total = adminService.getMemberTotalCount(cri);
		mav.addObject("pageMaker", new MemberPageVO(cri, total));
		return mav;
	}

	// 관리자 회원 상세정보 admin
	@RequestMapping(value = "/mypage/member/{member_id}", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView admin_member_detail(@PathVariable("member_id") String m_id, ModelAndView mav) {
		mav.setViewName("admin/admin_member");
		mav.addObject("mbr", adminService.getMemberInfo(m_id));
		return mav;
	}

	// 관리자 회원정보수정 admin
	@PutMapping(value = "/mypage/member/{member_id}")
	public ResponseEntity<String> admin_member_update(@RequestBody MbrVO mbrvo) {
		ResponseEntity<String> entity = null;

		log.info("rest_update..");
		try {

			// adminService.memberInfoUpdate(mbrvo);
			log.info("update member info");
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	// 관리자 회원 삭제 admin

	// 관리자 회원 상세정보 admin
	@RequestMapping(value = "/mypage/member/{member_id}/order", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView admin_member_order_list(@PathVariable("member_id") String m_id, ModelAndView mav) {
		mav.setViewName("admin/admin_member_order_list");
		mav.addObject("mbr", adminService.getMemberInfo(m_id));
		return mav;
	}

}