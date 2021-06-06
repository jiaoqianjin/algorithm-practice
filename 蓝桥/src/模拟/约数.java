package 模拟��;

public class Լ�� {
	public static void main(String[] args) {
		int n = 1200000;
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if((n/i)*i == n) {
				count ++;
			}

		}
		System.out.println(count);
	}
}
