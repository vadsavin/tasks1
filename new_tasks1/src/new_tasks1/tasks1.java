package new_tasks1;

import java.util.Arrays;

public class tasks1 {
	public static void main(String[] args) {
		System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
		System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
		System.out.println(nicoCipherEncoder("mubashirhassan", "crazy"));
		System.out.println(Arrays.toString(twoFactors(new int[]{1, 2, -1, 4, 5, 6, 10, 7}, 20)));
		System.out.println(Arrays.toString(isExact(721)));
	}
	
	//1
	public static String hiddenAnagram(String a, String b) {
		a = a.toLowerCase().replaceAll("[^a-zA-Z]+", "");	
		b = b.toLowerCase().replaceAll("[^a-zA-Z]+", "");
		
		
		for(int i = 0; i < a.length(); i++) {
			for(int j = i+b.length(); j<a.length(); j++) {
				String substr = a.substring(i, j);
				if(checkStringsAnagram(b, substr))
					return substr;
			}
		}
		return "notfound";
		
	}
	private static boolean checkStringsAnagram(String a, String b) {
		char[] achrs = a.toCharArray();
		for(int i = 0; i < a.length(); i++) {
			if(!b.contains(String.valueOf(achrs[i]))) {
				return false;
			}else {
				int index = b.indexOf(achrs[i]);
				b = b.substring(0, index) + b.substring(index+1);
			}
			
		}
		return true;
	}
	
	//2
	public static String[] collect(String s, int n) {
		if(s.length() < n) return new String[0];	
		
		String[] result = new String[s.length()/n];
		for(int i = 0; i < result.length; i++) {
			
			try {
				result[i] = s.substring(0,n);
				s = s.substring(n);
			}catch(Exception e){
				
			}
		}
		Arrays.sort(result);
		return result;
	}
	
	//3
	public static String nicoCipherEncoder(String mes, String key) {
		char[] keyCopy = key.toCharArray();
		char[] keychrs = key.toCharArray();
		char[] meschrs = mes.toCharArray();
		Arrays.sort(keyCopy);

		int[] keyNumbers = new int[key.length()];
		for(int i = 0; i < key.length(); i++) {
			char c = keyCopy[i];
			for(int j = 0; j < key.length(); j++) {
				if(c == keychrs[j]) {
					keyNumbers[j] = i;
				}
			}
		}

		int[] picker = new int[key.length()];
		for(int i = 0; i < key.length(); i++) {
			for(int j = 0; j < key.length(); j++) {
				if(i == keyNumbers[j]) {
					picker[i] = j;
				}
			}
		}

		int n = (int)Math.ceil((float)mes.length() / key.length());
		
		char[][] table = new char[n][key.length()];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < key.length(); j++) {
				try {
					int index = i*key.length() + j;
					table[i][j] = meschrs[index];
				}catch(Exception e) {
					table[i][j] = ' ';
				}
			}
		}
		
		String result = "";
		for(int i = 0; i < n*key.length(); i++) {
			int y = i/key.length(),
				x = picker[i%key.length()];
			result+=table[y][x];
		}
		return result;
	}
	
	//4
	public static int[] twoFactors(int[] ar, int n) {
		int[] res = new int[2];
		for(int i = 0; i < ar.length-1; i++) {
			for(int j = i+1; j<ar.length; j++) {
				if(ar[i]*ar[j] == n) {
					res[0] = ar[i];
					res[1] = ar[j];
					return res;
				}
			}
		}
		return new int[0];
		
	}
	
	//5
	public static int[] isExact(int n) {
		return recursiveFactorialSolver(n,n,2);
	}
	private static int[] recursiveFactorialSolver(int starter, int value, int factor) {
		System.out.println(value);
		if(value == 1) {
			return new int[] {starter,factor-1};
		}else if(value == 0 || value%(factor)!=0) {
			return new int[] {};
		} else {
			return recursiveFactorialSolver(starter, value/(factor), factor+1);
		}
	}

}
