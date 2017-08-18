package com.myjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myjsp.entity.User;

@Controller
public class TagsController {
	
	@RequestMapping(value = "mysql.do")
	public String jstl() {
		return "/WEB-INF/mysql";
	}
	
	@RequestMapping(value="form.do")
    public String form(User myuser, Model model){

        if(!model.containsAttribute("user")){        
            
            User user=new User();
            user.setUsername("chenjianxian");
            user.setPassword("123456");
            user.setNickname("xiaoxian");
            
            model.addAttribute("user", user);
        }
        return "WEB-INF/pages/tagstest";
    }
	/*
	@RequestMapping(value="tags.do", method = {RequestMethod.POST})
    public String tags(Model model){

        if(!model.containsAttribute("contentModel")){        
            
            TagsModel tagsModel=new TagsModel();
            
            tagsModel.setUsername("aaa");
            tagsModel.setPassword("bbb");
            tagsModel.setTestBoolean(true);
            tagsModel.setSelectArray(new String[] {"arrayItem 路人甲"});
            tagsModel.setTestArray(new String[] {"arrayItem 路人甲","arrayItem 路人乙","arrayItem 路人丙"});
            tagsModel.setRadiobuttonId(1);
            tagsModel.setSelectId(2);
            tagsModel.setSelectIds(Arrays.asList(1,2));
            Map<Integer,String> map=new HashMap<Integer,String>();
            map.put(1, "mapItem 路人甲");
            map.put(2, "mapItem 路人乙");
            map.put(3, "mapItem 路人丙");
            tagsModel.setTestMap(map);
            tagsModel.setRemark("备注...");
            
            model.addAttribute("contentModel", tagsModel);
        }
        return "tagstest";
    }
    */
	
}
