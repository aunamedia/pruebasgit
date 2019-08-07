import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h,m,s;
		h = sc.nextInt();
		m = sc.nextInt();
		s = sc.nextInt();
		sc.close();
		
		if(h >= 24) {
			h = 0;
		}
		if(m >= 60) {
			m = 0;
		}
		if(s >= 60) {
			s = 0;
		}
		System.out.println("Hora " + h+":"+m+":"+s);
		int r = 1;
		int c = 2;
		String[][] col = new String[2][];
		for(int i = 0; i<col.length;i++) {
			col[i] = new String[3];
			for(int j = 0; j < col[0].length; j++) {
				System.out.println(i + " - " + j);
				col[i][j] = i + " - " + j;
			}
		}
	}
}
