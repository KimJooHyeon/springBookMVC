package spring.mvc.kjh.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.kjh.mapper.BookMapper;
import spring.mvc.kjh.service.BookService;
import spring.mvc.kjh.vo.BookVO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookMapper bookMapper;
	
	@Override
	public boolean insert(Map<String, Object> map) throws Exception {
		boolean flag = false;
		if (this.bookMapper.insert(map)) {
			flag = true;
		}
		return flag;
	}

	@Override
	public BookVO detail(int bookId) throws Exception {
		BookVO bookVo = bookMapper.detail(bookId);
		return bookVo;
	}

	@Override
	public List<Map<String, Object>> list() throws Exception {
		return this.bookMapper.list();
	}

	@Override
	public boolean update(BookVO bookVo) throws Exception {
		boolean flag = false;
		if (this.bookMapper.update(bookVo)) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean delete(Map<String, Object> map) throws Exception {
		boolean flag = false;
		if (this.bookMapper.delete(map)) {
			flag = true;
		}
		return flag;
	}

	@Override
	public List<Map<String, Object>> search(Map<String, Object> map) throws Exception {
		return this.bookMapper.search(map);
	}

}
