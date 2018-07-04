package com.example.demo.action;



import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.api.ApiManager;
import com.example.demo.api.CI_ReqPartnertype;
import com.example.demo.api.CI_ReqUpdateOrderAll;
import com.example.demo.entity.Partner;
import com.example.demo.entity.Partnerfile;
import com.example.demo.entity.Partnertype;
import com.example.demo.entity.Stuser;
import com.example.demo.fdfs.FastDFSClientWrapper;
import com.example.demo.service.PartnerService;
import com.example.demo.service.PartnerfileService;
import com.example.demo.service.PartnertypeService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/partner")
public class PartnerController extends BaseController{
	
	@Resource
	ApiManager apiManager;
	@Resource
	PartnertypeService partnertypeService;
	
	@RequestMapping("/partnerType")
	public String partnerType(HttpServletRequest request) {
		return "partner/partnerType";
	}
	@RequestMapping("/partnerFile")
	public String partnerFile(HttpServletRequest request) {
		return "partner/partnerFile";
	}
	
	
	@RequestMapping("/partner")
	public String partner(HttpServletRequest request) {
		Partnertype record =new Partnertype ();
		List<Partnertype> types =partnertypeService.selectByCondition(record);
		request.getSession().setAttribute("types",types);
		
		return "partner/partner";
	}

	
}

@RestController
@RequestMapping("/Partner")
class PartnerPostController extends BaseController{
	
	@Resource
	ApiManager apiManager;
	
	@Resource
	UserService stuserService;
	
	@Resource
	private CI_ReqPartnertype cI_ReqPartnertype;
	
	@Resource
	PartnertypeService partnertypeService;
	
	@Resource
	PartnerService partnerService;
	
	@Resource
	PartnerfileService partnerfileService;
	
	@Autowired
    private FastDFSClientWrapper dfsClient;
	
	@RequestMapping("/partnerTypeData")
	@ResponseBody
	public String partnerTypeData(Integer limit, Integer offset, String search,String typeid, String typename) {
		Partnertype partnertype =new Partnertype();
		//条件
		if(null !=typeid && !typeid.equals(""))
			partnertype.setTypeid(Integer.parseInt(typeid));
		if(null !=typename && !typename.equals(""))
			partnertype.setTypename(typename);
		
		return partnertypeService.selectByConditionJson(partnertype,search,offset,limit);
		//return cI_ReqPartnertype.doAction(1,"1", "CI_ReqPartnertype", 1, "{}");
	}
	
	@RequestMapping("/partnerTypeAdd")
	@ResponseBody
	public String partnerTypeAdd(String typename) {
		// change row count
		int rtn =partnertypeService.insertByTypeName(typename);
		if(0 ==rtn)
			return "add partnerType fail";
		return "add partnerType success";
	}
	@RequestMapping("/partnerTypeUpdate")
	@ResponseBody
	public String partnerTypeUpdate(int typeid,String typename) {
		// change row count
		int rtn =partnertypeService.update(typeid, typename);
		if(0 ==rtn)
			return "update partnerType fail";
		return "update partnerType success";
	}
	@RequestMapping("/partnerTypeDelete")
	@ResponseBody
	public String partnerTypeDelete(int id) {
		// change row count [{"0":true,"typeid":2,"typename":"银行"},{"0":true,"typeid":3,"typename":"银行2"}]
		int rtn =partnertypeService.delete(id);
		if(0 ==rtn)
			return "delete partnerType fail";
		return "delete partnerType success";
	}
	//partner manager
	@RequestMapping("/partnerData")
	@ResponseBody
	public String data(Integer limit, Integer offset, String search,
			String typeid,
			String partnerid,
			String name,
			String abbreviation,
			String partnercode) {
		Partner partner =new Partner();
		//条件
		if(null !=typeid && !typeid.equals("")&&!typeid.equals("-1"))
			partner.setTypeid(Integer.parseInt(typeid));
		if(null !=partnerid && !partnerid.equals(""))
			partner.setPartnerid(Integer.parseInt(partnerid));
		if(null !=name && !name.equals(""))
			partner.setName(name);
		if(null !=abbreviation && !abbreviation.equals(""))
			partner.setAbbreviation(abbreviation);
		if(null !=partnercode && !partnercode.equals(""))
			partner.setPartnercode(partnercode);
		
		return partnerService.selectByConditionJson(partner,search,offset,limit);
		//return cI_ReqPartner.doAction(1,"1", "CI_ReqPartner", 1, "{}");
	}
	
	@RequestMapping("/partnerAdd")
	@ResponseBody
	public String partnerAdd(
			String typeid,
			String partnerid,
			String name,
			String abbreviation,
			String partnercode,
			String partnerkey) {
		// change row count
		Partner partner =new Partner();
		if(null !=typeid && !typeid.equals(""))
			partner.setTypeid(Integer.parseInt(typeid));
		if(null !=partnerid && !partnerid.equals(""))
			partner.setPartnerid(Integer.parseInt(partnerid));
		if(null !=name && !name.equals(""))
			partner.setName(name);
		if(null !=abbreviation && !abbreviation.equals(""))
			partner.setAbbreviation(abbreviation);
		if(null !=partnercode && !partnercode.equals(""))
			partner.setPartnercode(partnercode);
		if(null !=partnerkey && !partnerkey.equals(""))
			partner.setPartnerkey(partnerkey);
		
		int rtn =partnerService.insertSelective(partner);
		if(0 ==rtn)
			return "add partner fail";
		return "add partner success";
	}
	@RequestMapping("/partnerUpdate")
	@ResponseBody
	public String partnerUpdate(String typeid,
			String partnerid,
			String name,
			String abbreviation,
			String partnercode,
			String partnerkey) {
		Partner partner =new Partner();
		if(null !=typeid && !typeid.equals(""))
			partner.setTypeid(Integer.parseInt(typeid));
		if(null !=partnerid && !partnerid.equals(""))
			partner.setPartnerid(Integer.parseInt(partnerid));
		if(null !=name && !name.equals(""))
			partner.setName(name);
		if(null !=abbreviation && !abbreviation.equals(""))
			partner.setAbbreviation(abbreviation);
		if(null !=partnercode && !partnercode.equals(""))
			partner.setPartnercode(partnercode);
		if(null !=partnerkey && !partnerkey.equals(""))
			partner.setPartnerkey(partnerkey);
		int rtn =partnerService.updateByPrimaryKey(partner);
		if(0 ==rtn)
			return "update partner fail";
		return "update partner success";
	}
	@RequestMapping("/partnerDelete")
	@ResponseBody
	public String partnerDelete(int id) {
		// change row count [{"0":true,"typeid":2,"typename":"银行"},{"0":true,"typeid":3,"typename":"银行2"}]
		int rtn =partnerService.delete(id);
		if(0 ==rtn)
			return "delete partner fail";
		return "delete partner success";
	}
	//partner file
	//文件列表
	@RequestMapping("/partnerFileData")
	@ResponseBody
	public String partnerFileData(Integer limit, Integer offset, String search,
			String filename,
			String abbreviation,
			String dir) {
		Partnerfile partnerfile =new Partnerfile();
		//条件
		if(null !=filename && !filename.equals(""))
			partnerfile.setFilename(filename);
		if(null !=abbreviation && !abbreviation.equals(""))
			partnerfile.setAbbreviation(abbreviation);
		if(null !=dir && !dir.equals(""))
			partnerfile.setFatherid(Integer.parseInt(dir));
		
		return partnerfileService.selectByConditionJson(partnerfile,search,offset,limit);
		//return cI_ReqPartner.doAction(1,"1", "CI_ReqPartner", 1, "{}");
	}
	
	// 下载文件
    @RequestMapping(value = "/partnerFileDownload", method = RequestMethod.POST)
    public String partnerFileDownload(String fileid, HttpServletResponse response)
    {
    	String fail ="download partnerfile fail";
    	String success ="download partnerfile success";
    	Partnerfile partnerfile =partnerfileService.selectByPrimaryKey(Integer.parseInt(fileid));
    	if(null ==partnerfile)
    		return fail;
    	if(1 ==partnerfile.getTypeid())
    		return fail;
    	String fileUrl =partnerfile.getSaveposition();
    	
    	ServletOutputStream outputStream = null;
    	try {
    		byte[] bytes =  dfsClient.downloadFile(fileUrl);
    		response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(partnerfile.getFilename(), "UTF-8"));
    		response.setCharacterEncoding("UTF-8");
    		outputStream  = response.getOutputStream();
    		outputStream.write(bytes);
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		return fail;
    	}finally {
    		try {
    			outputStream.flush();
    			outputStream.close();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	return success;
    }
	// 上传文件
    @RequestMapping(value = "/partnerFileAdd", method = RequestMethod.POST)
    public String partnerFileAdd(
    		String fileid,
    		String typeid,
    		String filename,
    		String abbreviation,
    		String permission,
    		Integer fatherid,
    		MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	String fail ="add partnerfile fail";
    	String success ="add partnerfile success";
    	//now time
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    	String updatetime =df.format(new Date());// new Date()为获取当前系统时间
    	//current user
    	String username=(String)SecurityUtils.getSubject().getPrincipal();
    	Stuser user =stuserService.getByUsername(username);
    	if(null ==user)
    		return fail;
    	int uploaduser =user.getId();
    	Partnerfile partnerfile =new Partnerfile();
    	if(typeid != null &&  !typeid.equals(""))
    		partnerfile.setTypeid(Integer.parseInt(typeid));
		partnerfile.setAbbreviation(abbreviation);
    	partnerfile.setPermission(permission);
    	partnerfile.setFatherid(fatherid);
    	partnerfile.setUpdatetime(updatetime);
    	partnerfile.setUploaduser(uploaduser);
    	//目录 无上传动作
    	if(1 ==partnerfile.getTypeid()){
        	//目录名为空时 默认为描述   		
    		if(filename ==null || filename=="" ||filename.compareTo("undefined") ==0)
    			partnerfile.setFilename(abbreviation);
    		else
    			partnerfile.setFilename(filename);
	    	partnerfile.setSize(0);
	    	partnerfile.setSaveposition("");
    	}
    	else {//文件 有上传动作
    		String imgUrl ="";
        	try{
        		imgUrl = dfsClient.uploadFile(file);
        	}catch(Exception e){
        		return fail;
        	}
        	//文件名为空时 默认为原文件名
        	if(filename ==null || filename==""|| filename.compareTo("undefined") ==0)
    			partnerfile.setFilename(file.getOriginalFilename());
    		else
    			partnerfile.setFilename(filename);
	    	partnerfile.setSize((int)file.getSize()/1024);
	    	partnerfile.setSaveposition(imgUrl);
    	}
    	int rtn =partnerfileService.addFile(partnerfile);
		if(0 ==rtn)
			return fail;
		return success;
    }
    @RequestMapping("/partnerFileDelete")
	@ResponseBody
	public String partnerFileDelete(Integer id) {
		// change row count [{"0":true,"typeid":2,"typename":"银行"},{"0":true,"typeid":3,"typename":"银行2"}]
    	//删除数据库中的信息
    	List<String> paths = new ArrayList<String>();
		partnerfileService.deleteFile(id, paths);
		//删除实际的数据
		for(String path:paths)
		{
			dfsClient.deleteFile(path);
		}
		return "delete partner success";
	}
    @RequestMapping("/partnerFileUpdate")
	@ResponseBody
	public String partnerFileUpdate(
			String fileid,
    		String typeid,
    		String filename,
    		String abbreviation,
    		String permission,
    		Integer fatherid) {
    	Partnerfile partnerfile =new Partnerfile();
    	partnerfile.setFileid(Integer.parseInt(fileid));
    	//只能修改文件名、概述、权限
    	partnerfile.setFilename(filename);
    	partnerfile.setAbbreviation(abbreviation);
    	partnerfile.setPermission(permission);
    	
    	int rtn =partnerfileService.updateByPrimaryKey(partnerfile);
		if(0 ==rtn)
			return "update partner fail";
		return "update partner success";
	}
}
class PartnerTypeReq
{}


