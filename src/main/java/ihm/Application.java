package ihm;


import bll.TableManager;
import bo.*;


public class Application {

	public static void main(String[] args){
		try {
			TableManager.initList("client");
			
			for (Table client : TableManager.getList()) {
				System.out.println("Test  "+client);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}




	}
}
