package edu.bit.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Controller
@RequestMapping("/ej/*")
public class EjController {
	/* @Autowired */

	@GetMapping("/prd")
	public String ProductDetail(Model model) throws Exception {
		log.debug("product");
		log.info("product..");

		return "ej/productDetail";
	}

	@GetMapping("/main")
	public String Main(Model model) throws Exception {
		log.debug("main");
		log.info("main..");

		return "ej/main";
	}

	@GetMapping("/cart")
	public String MemberCart(Model model) throws Exception {
		log.debug("cart");
		log.info("cart..");

		return "ej/memberCart";
	}

	@GetMapping("/order")
	public String OderInput(Model model) throws Exception {
		log.debug("order");
		log.info("order..");

		return "ej/orderInput";
	}

	@GetMapping("/like")
	public String LikeProduct(Model model) throws Exception {
		log.debug("like");
		log.info("like..");

		return "ej/likeProduct";
	}

	@GetMapping("/recently")
	public String RecentlyProduct(Model model) throws Exception {
		log.debug("recently");
		log.info("recently..");

		return "ej/recentlyProduct";
	}

	@GetMapping("/nmcheck")
	public String NonMemberOrderCheck(Model model) throws Exception {
		log.debug("nmcheck");
		log.info("nmcheck..");

		return "ej/nonMemberOrderCheck";
	}

}