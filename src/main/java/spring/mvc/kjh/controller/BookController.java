package spring.mvc.kjh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.mvc.kjh.service.BookService;
import spring.mvc.kjh.vo.BookVO;

@Controller
@RequestMapping("/book")
public class BookController {
	@Inject
	BookService bookService;
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	// 책 등록 폼
	@GetMapping("/create")
	public String createForm() {
		logger.info("createForm");
		return "book/create";
	}
	
	// 책 등록 처리
	@PostMapping("/detail")
	public String create(@RequestParam Map<String, Object> map) throws Exception {
		logger.info("create");
		logger.info("map : " + map.toString());
		boolean isSuccess = this.bookService.insert(map);
		int bookId = Integer.parseInt(map.get("bookId").toString());
		if (isSuccess) {
			return "redirect:/book/detail?bookId=" + bookId; // 등록 성공 시 책 상세 페이지로 이동
		}
		return "book/list"; // 등록 실패 시 목록으로 이동
	}
	
	// 책 상세
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam int bookId) throws Exception {
		logger.info("detail");
		logger.info("bookId : " + bookId);
		BookVO bookVo = this.bookService.detail(bookId);
		model.addAttribute("bookVo", bookVo);
		return "book/detail";
	}
	
	// 책 목록
	@GetMapping("/list")
	public String list(Model model) throws Exception {
		logger.info("list");
		
		List<Map<String, Object>> mapList = this.bookService.list();
		logger.info("mapList : " + mapList);
		
		model.addAttribute("mapList", mapList);
		model.addAttribute("searchOption", "");
		model.addAttribute("keyword", "");
		return "book/list";
	}
	
	// 책 수정 폼
	@GetMapping("/update")
	public String updateForm(Model model, @RequestParam int bookId) throws Exception {
		logger.info("updateForm");
		BookVO bookVo = this.bookService.detail(bookId);
		model.addAttribute("bookVo", bookVo);
		return "book/updateForm";
	}
	
	// 책 수정 처리
	@PostMapping("/update")
	public String update(Model model, @RequestParam Map<String, Object> map) throws Exception {
		logger.info("update");
		BookVO bookVo = new BookVO();
		int bookId = Integer.parseInt(map.get("bookId").toString());
		bookVo.setBookId(bookId);
		bookVo.setTitle(map.get("title").toString());
		bookVo.setCategory(map.get("category").toString());
		bookVo.setPrice(Integer.parseInt(map.get("price").toString()));
		boolean isSuccess = this.bookService.update(bookVo);
		if (isSuccess) {
			return "redirect:/book/detail?bookId=" + bookId; // 수정 성공 시 상세 페이지로 이동
		}
		model.addAttribute("bookVo", bookVo);
		return "book/list"; // 수정 실패 시 목록으로 이동
	}
	
	// 책 삭제 처리 (상세 페이지에서 해당 항목만 삭제하기)
	@GetMapping("/delete")
	public String delete(@RequestParam Map<String, Object> map) throws Exception {
		logger.info("delete");
		int bookId = Integer.parseInt(map.get("bookId").toString());
		boolean isSuccess = this.bookService.delete(map);
		if (isSuccess) {
			return "redirect:/book/list";
		}
		return "book/detail?bookId=" + bookId;
	}
	
	// 책 삭제 처리 (목록에서 체크박스를 이용하여 삭제하기)
	@PostMapping("/deleteCheckBox")
	public String deleteCheckBox(@RequestParam List<Integer> bookIds) throws Exception {
		logger.info("deleteCheckBox");
		logger.info("bookIds : " + bookIds);
		Map<String, Object> map = new HashMap<>();
		for (Integer bookId : bookIds) {
			map.put("bookId", bookId);
			this.bookService.delete(map);
		}
		return "redirect:/book/list"; // 선택한 항목 삭제 완료 시 목록으로 이동
	}
	
	// 책 검색
	@PostMapping("/search")
	public String search(Model model, @RequestParam(defaultValue = "") String searchOption, 
			@RequestParam(defaultValue = "") String keyword) throws Exception {
		logger.info("search");
		logger.info("searchOption : " + searchOption);
		logger.info("keyword : " + keyword);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		List<Map<String, Object>> mapList = this.bookService.search(map);
		logger.info("mapList : " + mapList);
		
		model.addAttribute("mapList", mapList);
		model.addAttribute("searchOption", searchOption);
		model.addAttribute("keyword", keyword);
		return "book/list";
	}
}
















