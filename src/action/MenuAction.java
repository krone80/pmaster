package action;

import com.opensymphony.xwork2.ActionSupport;

public class MenuAction extends ActionSupport  {
    public String execute() throws Exception {
        return "success";
    }
    public String toSearch()  throws Exception{
		System.out.println("toSearch");
		return "success";
	}
	public String toRegister()  throws Exception{
		System.out.println("toRegister");
		return "success";
	}
	public String toLogin()  throws Exception{
		System.out.println("toLogin");
		return "success";
	}
	public String toMenu()  throws Exception{
		System.out.println("toMenu");
		return "success";
	}
}
