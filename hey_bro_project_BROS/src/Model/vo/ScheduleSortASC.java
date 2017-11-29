package Model.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class ScheduleSortASC implements Comparator<Schedule>{

	@Override
	public int compare(Schedule o1, Schedule o2) {
		SimpleDateFormat dateParse = new SimpleDateFormat("yy/MM/dd");
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = dateParse.parse(o1.getDate());
			date2 = dateParse.parse(o2.getDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date1.compareTo(date2);
	}

}
