package aa.mine.web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class commonUtil {

	public String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString().replace("-", "");
		System.out.println(str.length());
		return str;
	}
	
	public long getDate(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date date = new Date();
		String dateStr = sdf.format(date);
		System.out.println(dateStr);
		return Long.parseLong(dateStr);
	}
}
