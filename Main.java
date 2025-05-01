import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);

		NetflixOriginal[] userShows = new NetflixOriginal[2];

		for(int i = 0; i< userShows.length; i++)
		{
			userShows[i] = Main.instantiateFromInput(keyboard);
			System.out.println(userShows[i]);

		}

		keyboard.close();

	}

	public static NetflixOriginal instantiateFromInput(Scanner keyboard)
	{
		String name, genre;
		double starRating;
		boolean isValid;

		NetflixOriginal result = new NetflixOriginal();

		System.out.print("Please enter the name of the show: ");
		name = keyboard.nextLine();
		result.setName(name);

		do{
			System.out.print("Please enter the star rating: ");
			starRating = Double.parseDouble(keyboard.nextLine());
			isValid = result.setStarRating(starRating);

			if(!isValid)
			{
				System.out.println("ERROR: rating must be between 0.0 and 5.0");
			}
		} while(!isValid);
	
		do{
			System.out.print("Please enter the genre " + NetflixOriginal.VALID_GENRES_STRING + " = ");
			genre = keyboard.nextLine();
			isValid = result.setGenre(genre);

			if(!isValid)
			{
				System.out.printf("ERROR: genre must match available options:\n");
			}
		} while(!isValid);

	

		return result;
	}
}