package spring.mvc.kjh.mapper;

import java.util.List;
import java.util.Map;

import spring.mvc.kjh.vo.BookVO;

public interface BookMapper {
	boolean insert(Map<String, Object> map);
	
	BookVO detail(int bookId);
	
	List<Map<String, Object>> list();
	
	boolean update(BookVO bookVo);
	
	boolean delete(Map<String, Object> map);
	
	List<Map<String, Object>> search(Map<String, Object> map);
}


