/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invou;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author leoas
 */
public class ip 
{
    private static final Pattern PATTERN = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    
    public ip(){}

 public ArrayList<String> generateRange(String begin_, String end_)
 {
    ArrayList<String> array = new ArrayList<String>();
    Long begin = ipToLong(begin_);
    Long end = ipToLong(end_);
    Long length = end - begin;
    array.add(longToIp(begin));
    
    for(int i=0;i<length;i++)
    {
        begin++;
        array.add(longToIp(begin));
    }
    return array;
 }
 
    public long ipToLong(String ipAddress) {

	String[] ipAddressInArray = ipAddress.split("\\.");

	long result = 0;
	for (int i = 0; i < ipAddressInArray.length; i++) {

		int power = 3 - i;
		int ip = Integer.parseInt(ipAddressInArray[i]);
		result += ip * Math.pow(256, power);

	}

	return result;
  }

  
    public String longToIp(long ip) {
	StringBuilder result = new StringBuilder(15);
	for (int i = 0; i < 4; i++) 
        {	
            result.insert(0,Long.toString(ip & 0xff));
            if (i < 3)
            {
		result.insert(0,'.');
            }
            ip = ip >> 8;
	}
	return result.toString();
  }
    
    public static boolean validateIP(final String ip) 
    {
    return PATTERN.matcher(ip).matches();
    }
    
  
}
