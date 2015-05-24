package kr.co.opodg.login.action;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
    private SqlSession query;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/test.web", method = RequestMethod.GET)
	public ModelAndView test(Locale locale, Model model) {
		logger.info("Welcome test! The client locale is {}.", locale);
		
		ModelAndView mv = new ModelAndView();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		String return1 = query.selectOne("test.getTest");
		ArrayList<String> arr = new ArrayList();
		arr.add("1");
		arr.add("2");
		arr.add("3");
		
		mv.setViewName("test");
		mv.addObject("serverTime", formattedDate );
		mv.addObject("test", "test" );
		mv.addObject("arr", arr );
		mv.addObject("count",return1);
		
		
		return mv;
	}
	
}
