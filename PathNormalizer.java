import java.util.regex.*;
import java.io.*;
class PathNormalizer{
	private static String pattern1 = "\\./";						//first pattern: single dot components
	private static String pattern2 = "[a-z$$[0-9]]+/\\.\\./";		//second pattern: double dot components along with parent directory
	private static String replace = "";								//deletes matching patterns
	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));	
		String inputLine = stdin.readLine();
		Pattern p = Pattern.compile(pattern1);
		Pattern q = Pattern.compile(pattern2);
		Matcher n = q.matcher(inputLine);
		StringBuffer outputLine = new StringBuffer();
		while(n.find()){											//tries to match pattern 2 first
			n.appendReplacement(outputLine, replace);
		}
		n.appendTail(outputLine);						
		Matcher m = p.matcher(outputLine.toString());
		outputLine = new StringBuffer();							//sends the output of first pattern match to search for next pattern match
		while(m.find()){
			m.appendReplacement(outputLine, replace);
		}
		m.appendTail(outputLine);
		System.out.println(outputLine.toString());					//prints resulting line as a string
	}
}