package yusuke.numata.sort.marge;

public class MargeSort {

	public static String execute(String string) {

		String[] csvData = string.split(",");
		int datalength = csvData.length;
		
		String rtn = sort(csvData, datalength);
		
		return rtn;
		
	}

	private static String sort(String[] csvData, int datalength) {
		
		int halflength = datalength / 2;
		if (halflength == 2) {
			
		}

		return null;
	}

	
}
