import java.util.ArrayList;
import java.util.Random;

public class RandomArrayTest {

	public static void main(String[] args) {
		int n = 100000;
		Random random = new Random();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			list.add(random.nextInt(n*10));
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%,8d", list.get(i));

			if (i % 100 == 0 && i > 0) {
				System.out.println();
			}
		}

	}

}
