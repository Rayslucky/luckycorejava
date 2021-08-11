package IOstream;

import java.io.File;

public class FileFromfolder {

	public static void main(String[] args) {
		File D  = new File("C:\\Users\\akhand\\Desktop\\luckycorejava");
        File[] list =D.listFiles();
        for (int i = 0; i < list.length; i++) {
        	//File f  = new File("C:\\Users\\akhand\\Desktop\\luckycorejava",list[i]);
        	if (list[i].isDirectory()) {
        		System.out.println((i+1)+":"+list[i].getName());
				
			}
		}
	}

}
