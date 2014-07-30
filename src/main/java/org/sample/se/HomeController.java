package org.sample.se;

import java.io.File;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.sample.se.Util.FileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private BoardDAO boardService;
	
	@RequestMapping(value = "/")
	public String home(Model model, Board board) {
		board.setTotalItemCount(boardService.countBoardList(board));
		board.setItemPerPage(10);
		model.addAttribute("list", boardService.getBoardList(board));
		return "list";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(Model model) {
		return "write";
	}
	
	@RequestMapping(value = "/writeSubmit", method = RequestMethod.POST)
	public String writeSubmit(Model model, Board board) {
		board.setBoardNum(1);
		board.setAuthor(4);
		board.setContents(board.getContents().replaceAll("\n", "").replaceAll("\t", "").replaceAll("\r", ""));
		boardService.insertBoardItem(board);
		return "redirect:view?seq="+board.getSeq();
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(Model model, Board board) {
		model.addAttribute("item", boardService.getBoardItem(board));
		return "view";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(Model model, Board board) {
		model.addAttribute("item", boardService.getBoardItem(board));
		model.addAttribute("modify", "true");
		return "write";
	}
	
	@RequestMapping(value = "/modifySubmit", method = RequestMethod.POST)
	public String modifySubmit(Model model, Board board) {
		board.setContents(board.getContents().replaceAll("\n", "").replaceAll("\t", "").replaceAll("\r", ""));
		boardService.updateBoardItem(board);
		return "redirect:view?seq="+board.getSeq();
	}
	
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public String fileUpload(Model model, MultipartRequest multipartRequest, HttpServletRequest request){
		MultipartFile imgfile = multipartRequest.getFile("Filedata");
		Calendar cal = Calendar.getInstance();
		String fileName = imgfile.getOriginalFilename();
		String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		String replaceName = cal.getTimeInMillis() + fileType;  
		
		//String path = "C:/Users/Snow/Documents/Develop/WorkSpace/SESample/src/main/webapp/resources";
		String path = request.getSession().getServletContext().getRealPath("/")+File.separator+"resources";
		FileUpload.fileUpload(imgfile, path, replaceName);
		model.addAttribute("path", path);
		model.addAttribute("filename", replaceName);
		return "file_upload";
	}

}
