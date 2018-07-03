package com.example.demo.action;



import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.example.demo.fdfs.FastDFSClientWrapper;
import com.example.demo.service.PartnerService;
import com.example.demo.service.PartnerfileService;
import com.example.demo.service.PartnertypeService;
import com.fasterxml.jackson.databind.ObjectMapper;


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
	
	// 上传文件
    @RequestMapping(value = "/partnerFileAdd", method = RequestMethod.POST)
    public String partnerFileAdd(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 省略业务逻辑代码。。。
    	String imgUrl ="fail";
    	try{
    		imgUrl = dfsClient.uploadFile(file);
    	}catch(Exception e){
    		return imgUrl;
    	}
        return imgUrl;
    }
}
class PartnerTypeReq
{}


