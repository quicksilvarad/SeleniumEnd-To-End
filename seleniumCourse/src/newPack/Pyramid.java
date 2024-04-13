package newPack;

public class Pyramid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x="*";
		for (int i=0; i<=5; i++)
		{
			for (int j=1; j<=5-i; j++)
			{
				System.out.print(x);
				System.out.print(" ");


			}
			System.out.print("\n");
		}

	}

}
