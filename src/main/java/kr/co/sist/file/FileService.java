package kr.co.sist.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileService {
	
	public List<FileDTO> fileList(){
		List<FileDTO> list=new ArrayList<FileDTO>();
		
		File uploadDir=new File("C:/dev/workspace/jsp_prj/src/main/webapp/upload");
		File[] listFiles=uploadDir.listFiles();
		
		if(listFiles != null) {
			FileDTO fDTO=null;
			for(File tmpFile: listFiles) {
				fDTO=new FileDTO();
				fDTO.setFileName(tmpFile.getName());
				fDTO.setLength(tmpFile.length());
				fDTO.setLastModified(new Date( tmpFile.lastModified()));
				
				list.add(fDTO);
			}//end for
		}//end if
		
		return list;
	}
}
