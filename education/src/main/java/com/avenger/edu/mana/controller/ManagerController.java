package com.avenger.edu.mana.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.avenger.edu.mana.mapper.ManagerMapper;
import com.avenger.edu.mana.model.Clazz;
import com.avenger.edu.mana.model.College;
import com.avenger.edu.mana.model.Major;
import com.avenger.edu.mana.model.Manager;
import com.avenger.edu.mana.model.Student;
import com.avenger.edu.mana.model.Teacher;



@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	ManagerMapper mmaper;
	
	private Logger logger = LoggerFactory.getLogger(ManagerController.class);
	
	@PostMapping("/login")
	@ResponseBody
	public int login(@RequestBody Manager manager) {
		int i=0;
		Manager m= mmaper.login(manager);
		if(m.getMana_id().equals(manager.getMana_id())) {
			i++;
		}if(m.getMana_password().equals(manager.getMana_password())) {
			i++;
		}
		
		return i;
	}
	
	@PostMapping("/registers")
	@ResponseBody
	public void registerS(@RequestBody Student student) {
		String i=student.getStu_majo();
		String a[]=i.split("[(]");
		int majo_id=Integer.parseInt(a[0]);
        i=student.getStu_clas();
        a=i.split("[(]");
		int clas_id=Integer.parseInt(a[0]);
		String stu_pic=student.getStu_pic();
		stu_pic="../images/student/"+stu_pic;
		student.setStu_pic(stu_pic);
		student.setMajo_id(majo_id);
		student.setClas_id(clas_id);
		mmaper.registerStudent(student);
	}
	
	@PostMapping("/alters")
	@ResponseBody
	public void updateS(@RequestBody Student student) {
		mmaper.alterStudent(student);
	}
	
	@PostMapping("/selects")
	@ResponseBody
	public Student selectS(@RequestBody Student student) {
		return mmaper.selectStudent(student);
	}
	
	@PostMapping("/registert")
	@ResponseBody
	public void registerT(@RequestBody Teacher teacher) {
		String i=teacher.getCol_name();
		String a[]=i.split("[(]");
		int col_id=Integer.parseInt(a[0]);
		teacher.setCol_id(col_id);
		mmaper.registerTeacher(teacher);
	}
	
	@PostMapping("/altert")
	@ResponseBody
	public void updateS(@RequestBody Teacher teacher) {
		mmaper.alterTeacher(teacher);
	}
	
	@PostMapping("/selectt")
	@ResponseBody
	public Teacher selectT(@RequestBody Teacher teacher) {
		return mmaper.selectTeacher(teacher);
	}
	
	 @PostMapping("/load")
	 @ResponseBody
	    public void singleFileUpload( MultipartFile file,HttpServletRequest request) {
		 System.out.println("开始下载");
		 logger.debug("传入的文件参数：{}", JSON.toJSONString(file, true));

		 if (Objects.isNull(file) || file.isEmpty()) {
	            logger.error("文件为空");
	        }
	        try {
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get("C:/Users/liulei/Desktop/quiz/education/education/src/main/resources/static/images/student/" + file.getOriginalFilename());
	            //文件写入指定路径
	            Files.write(path, bytes);
	            logger.debug("文件写入成功...");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 @PostMapping("/clazz")
		@ResponseBody
		public List<Clazz> selectClazz() {
			return mmaper.selectClazz();
		}

	 @PostMapping("/college")
		@ResponseBody
		public List<College> selectCollege() {
			return mmaper.selectCollege();
		}
	 
	 @PostMapping("/major")
		@ResponseBody
		public List<Major> selectMajor() {
			return mmaper.selectMajor();
		}
}
