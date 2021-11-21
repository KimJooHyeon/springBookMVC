package spring.mvc.kjh.service;

import java.util.List;
import java.util.Map;

import spring.mvc.kjh.vo.BookVO;

public interface BookService {
	boolean insert(Map<String, Object> map) throws Exception;
	
	BookVO detail(int bookId) throws Exception;
	
	List<Map<String, Object>> list() throws Exception;
	
	boolean update(BookVO bookVo) throws Exception;
	
	boolean delete(Map<String, Object> map) throws Exception;
	
	List<Map<String, Object>> search(Map<String, Object> map) throws Exception;
}
