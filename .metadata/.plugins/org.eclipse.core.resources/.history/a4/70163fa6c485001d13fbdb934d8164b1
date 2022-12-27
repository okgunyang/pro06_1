package com.shop2.myapp.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.shop2.myapp.dto.UserDTO;
import com.shop2.myapp.service.AjaxService;
import com.shop2.myapp.util.AES256;

@Controller
@RequestMapping("/ajax/")
public class AjaxController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private AjaxService ajaxService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("test1")
	public String testLoad(Model model) throws Exception {
		return "ajax/test1";
	}
	
	//아이디 중복 체크
	@GetMapping("idCheck.do")
	@ResponseBody
	public boolean idCheck(@RequestParam("id") String id) throws Exception {
		UserDTO user = ajaxService.getUser(id);
		if(user==null) {
			return true;
		} else {
			return false;	
		}
	}
	
	@GetMapping("test2")
	public String testLoad2(Model model) throws Exception {
		return "ajax/test2";
	}
	
	@GetMapping("userList.do")
	@ResponseBody
	public List<UserDTO> userList(Model model) throws Exception {
		List<UserDTO> userList = ajaxService.userList();
		return userList;
	}
	
	@GetMapping("test3")
	public String testLoad3(Model model) throws Exception {
		return "ajax/test3";
	}
	
	@GetMapping("getUser.do")
	@ResponseBody
	public UserDTO getUser(@RequestParam("id") String id, Model model) throws Exception {
		UserDTO user = ajaxService.getUser(id);
		return user;
	}
	
	@GetMapping("test4")
	public String testLoad4(Model model) throws Exception {
		return "ajax/test4";
	}
	
	//@PostMapping("getLogin.do")
	//@ResponseBody
	//public UserDTO getLogin(@ModelAttribute("user") UserDTO user, Model model) throws Exception {
	//	UserDTO usr = ajaxService.getLogin(user.getId(), user.getPw());
	
	@GetMapping("getLogin.do")
	@ResponseBody
	public UserDTO getLogin(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) throws Exception {
		AES256 aes256 = new AES256();
		pw = aes256.encrypt(pw);
		UserDTO usr = ajaxService.getLogin(id, pw);
		if(usr==null) {
			session.invalidate();
		} else {
			session.setAttribute("sid", usr.getId());
			session.setAttribute("sname", usr.getName());
		}
		return usr;
	}
	
	@GetMapping("test5")
	public String testLoad5(Model model) throws Exception {
		return "ajax/test5";
	}
	
	@Value("${part4.upload.path}")
    private String uploadPath;

	@Value("${part5.upload.path}")
    private String uploadPath2;
	
	@RequestMapping(value="url.do", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
    public List<String> getData(Model model, MultipartHttpServletRequest req){
		
        List<MultipartFile> multipartFileList = new ArrayList<>(); 
        List<String> fileQt = new ArrayList<String>(); 
        try {
            MultiValueMap<String, MultipartFile> files = req.getMultiFileMap();
            for (Map.Entry<String, List<MultipartFile>> entry : files.entrySet()) {
                List<MultipartFile> fileList = entry.getValue();
                for (MultipartFile file : fileList) {
                    if (file.isEmpty()) continue;
                    multipartFileList.add(file);
                    String originalName = file.getOriginalFilename();
                    String fileName = originalName.substring(originalName.lastIndexOf("//")+1);
                    String folderPath = makeFolder(); //날짜 폴더 생성
                    String uuid = UUID.randomUUID().toString(); //UUID
                    String saveName = uploadPath + File.separator + folderPath +File.separator + uuid + "_" + fileName; //저장할 파일 이름 중간에 "_"를 이용하여 구분                    
                    Path savePath = Paths.get(saveName);
                    //images안의 디렉토리 경로와 파일 이름 별도로 저장하여 서비스로 전달하기 위한 이름 
                    String singleFileName = File.separator + folderPath +File.separator + uuid + "_" + fileName;
                    fileQt.add(singleFileName);
                    //Paths.get() 메서드는 특정 경로의 파일 정보를 가져옵니다.(경로 정의하기)
                    file.transferTo(savePath);
                }
            }
        } catch (Exception e){
	        e.printStackTrace();
        }
        return fileQt;
    }
	
    private String makeFolder(){
      String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
      //LocalDate를 문자열로 포멧
      String folderPath = str.replace("/",File.separator);
      File uploadPathFoler = new File(uploadPath, folderPath);
        
      if(uploadPathFoler.exists() == false){
	        uploadPathFoler.mkdirs();
      }
       return folderPath;
    }
    
    //회원 가입 폼
	@GetMapping("test6")
	public String testLoad6(@ModelAttribute("user") UserDTO user, Model model) throws Exception {
		return "ajax/test6";
	}
	
	@PostMapping("addUser.do")
	public String addUser(@ModelAttribute("user") UserDTO user, Model model) throws Exception {
		AES256 aes256 = new AES256();
		user.setPw(aes256.encrypt(user.getPw()));
		ajaxService.addUser(user);
		return "ajax/test1";
	}
}
